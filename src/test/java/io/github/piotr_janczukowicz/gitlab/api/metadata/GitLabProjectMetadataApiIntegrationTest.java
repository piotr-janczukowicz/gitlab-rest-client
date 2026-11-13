package io.github.piotr_janczukowicz.gitlab.api.metadata;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectMetadataApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/metadata",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMetadata.class, "metadata.json")));

        final GitLabMetadata result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMetadataApi(GitLabCaller.of(client)).get();
        }

        assertThat(result).isEqualTo(MetadataCatalogFixtures.metadata());
        HTTP.verifyRequested(GET, "/api/v4/metadata");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/metadata", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMetadataApi api = new GitLabProjectMetadataApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.get());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/metadata");
    }

    @Test
    void getVersion_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/version",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMetadata.class, "metadata.json")));

        final GitLabMetadata result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMetadataApi(GitLabCaller.of(client)).getVersion();
        }

        assertThat(result).isEqualTo(MetadataCatalogFixtures.metadata());
        HTTP.verifyRequested(GET, "/api/v4/version");
    }

    @Test
    void getVersion_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/version", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMetadataApi api = new GitLabProjectMetadataApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getVersion());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/version");
    }
}

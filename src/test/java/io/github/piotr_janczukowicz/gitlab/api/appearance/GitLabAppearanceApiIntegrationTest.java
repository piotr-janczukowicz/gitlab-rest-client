package io.github.piotr_janczukowicz.gitlab.api.appearance;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabAppearanceApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/application/appearance",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabAppearance.class, "appearance.json")));

        final GitLabAppearance result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabAppearanceApi(GitLabCaller.of(client)).get();
        }

        assertThat(result).isEqualTo(AppearanceCatalogFixtures.appearance());
        HTTP.verifyRequested(GET, "/api/v4/application/appearance");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/application/appearance", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabAppearanceApi api = new GitLabAppearanceApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.get());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/application/appearance");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/application/appearance",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabAppearance.class, "appearance.json")));

        final GitLabAppearance result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabAppearanceApi(GitLabCaller.of(client))
                    .update(MultipartFormData.builder().text("field", "value").build());
        }

        assertThat(result).isEqualTo(AppearanceCatalogFixtures.appearance());
        HTTP.verifyRequested(PUT, "/api/v4/application/appearance");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/application/appearance", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabAppearanceApi api = new GitLabAppearanceApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/application/appearance");
    }
}

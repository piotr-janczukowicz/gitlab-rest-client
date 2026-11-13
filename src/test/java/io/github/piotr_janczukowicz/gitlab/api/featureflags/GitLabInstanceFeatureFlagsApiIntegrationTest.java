package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabFeatureDefinition;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabInstanceFeatureFlagsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/features",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabFeature.class, "feature.json") + "]"));

        final List<GitLabFeature> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabInstanceFeatureFlagsApi(GitLabCaller.of(client)).list();
        }

        assertThat(result).containsExactly(FeatureflagsCatalogFixtures.feature());
        HTTP.verifyRequested(GET, "/api/v4/features");
    }

    @Test
    void listDefinitions_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/features/definitions",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabFeatureDefinition.class, "feature-definition.json") + "]"));

        final List<GitLabFeatureDefinition> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabInstanceFeatureFlagsApi(GitLabCaller.of(client)).listDefinitions();
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.featureDefinition());
        HTTP.verifyRequested(GET, "/api/v4/features/definitions");
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/features/name",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabFeature.class, "feature.json")));

        final GitLabFeature result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabInstanceFeatureFlagsApi(GitLabCaller.of(client))
                    .create("name", FeatureflagsCatalogFixtures.instanceFeatureFlagsCreatePayload());
        }

        assertThat(result).isEqualTo(FeatureflagsCatalogFixtures.feature());
        HTTP.verifyRequested(POST, "/api/v4/features/name");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/features/name", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabInstanceFeatureFlagsApi api = new GitLabInstanceFeatureFlagsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.create("name", FeatureflagsCatalogFixtures.instanceFeatureFlagsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/features/name");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/features/name", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabInstanceFeatureFlagsApi(GitLabCaller.of(client)).delete("name");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/features/name");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/features/name", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabInstanceFeatureFlagsApi api = new GitLabInstanceFeatureFlagsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/features/name");
    }
}

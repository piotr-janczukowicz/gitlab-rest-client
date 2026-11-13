package io.github.piotr_janczukowicz.gitlab.api.unleash;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabUnleashApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void call_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/feature_flags/unleash/project_id", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabUnleashApi(GitLabCaller.of(client)).call("project_id");
        }

        HTTP.verifyRequested(GET, "/api/v4/feature_flags/unleash/project_id");
    }

    @Test
    void call_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/feature_flags/unleash/project_id", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUnleashApi api = new GitLabUnleashApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.call("project_id"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/feature_flags/unleash/project_id");
    }

    @Test
    void callFeatures_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/feature_flags/unleash/project_id/features", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabUnleashApi(GitLabCaller.of(client)).callFeatures("project_id");
        }

        HTTP.verifyRequested(GET, "/api/v4/feature_flags/unleash/project_id/features");
    }

    @Test
    void callFeatures_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/feature_flags/unleash/project_id/features", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUnleashApi api = new GitLabUnleashApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callFeatures("project_id"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/feature_flags/unleash/project_id/features");
    }

    @Test
    void callClientFeatures_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/feature_flags/unleash/project_id/client/features", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabUnleashApi(GitLabCaller.of(client)).callClientFeatures("project_id");
        }

        HTTP.verifyRequested(GET, "/api/v4/feature_flags/unleash/project_id/client/features");
    }

    @Test
    void callClientFeatures_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/feature_flags/unleash/project_id/client/features", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUnleashApi api = new GitLabUnleashApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callClientFeatures("project_id"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/feature_flags/unleash/project_id/client/features");
    }

    @Test
    void registerClient_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/feature_flags/unleash/project_id/client/register", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabUnleashApi(GitLabCaller.of(client))
                    .registerClient("project_id", UnleashCatalogFixtures.unleashRegisterClientPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/feature_flags/unleash/project_id/client/register");
    }

    @Test
    void registerClient_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/feature_flags/unleash/project_id/client/register", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUnleashApi api = new GitLabUnleashApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.registerClient("project_id", UnleashCatalogFixtures.unleashRegisterClientPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/feature_flags/unleash/project_id/client/register");
    }

    @Test
    void createClientMetric_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/feature_flags/unleash/project_id/client/metrics", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabUnleashApi(GitLabCaller.of(client))
                    .createClientMetric("project_id", UnleashCatalogFixtures.unleashCreateClientMetricPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/feature_flags/unleash/project_id/client/metrics");
    }

    @Test
    void createClientMetric_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/feature_flags/unleash/project_id/client/metrics", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUnleashApi api = new GitLabUnleashApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.createClientMetric("project_id", UnleashCatalogFixtures.unleashCreateClientMetricPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/feature_flags/unleash/project_id/client/metrics");
    }
}

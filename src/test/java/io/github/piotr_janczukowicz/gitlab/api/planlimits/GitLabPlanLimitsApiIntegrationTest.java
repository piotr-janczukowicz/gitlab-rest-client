package io.github.piotr_janczukowicz.gitlab.api.planlimits;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
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
class GitLabPlanLimitsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/application/plan_limits",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabPlanLimit.class, "plan-limit.json")));

        final GitLabPlanLimit result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabPlanLimitsApi(GitLabCaller.of(client)).get();
        }

        assertThat(result).isEqualTo(PlanlimitsCatalogFixtures.planLimit());
        HTTP.verifyRequested(GET, "/api/v4/application/plan_limits");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/application/plan_limits", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabPlanLimitsApi api = new GitLabPlanLimitsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.get());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/application/plan_limits");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/application/plan_limits",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabPlanLimit.class, "plan-limit.json")));

        final GitLabPlanLimit result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabPlanLimitsApi(GitLabCaller.of(client))
                    .update(PlanlimitsCatalogFixtures.planLimitsUpdatePayload());
        }

        assertThat(result).isEqualTo(PlanlimitsCatalogFixtures.planLimit());
        HTTP.verifyRequested(PUT, "/api/v4/application/plan_limits");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/application/plan_limits", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabPlanLimitsApi api = new GitLabPlanLimitsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(PlanlimitsCatalogFixtures.planLimitsUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/application/plan_limits");
    }
}

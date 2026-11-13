package io.github.piotr_janczukowicz.gitlab.api.runnercontrollers;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiRunnerController;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabRunnerControllersApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void callScopes_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/runner_controllers/1/scopes", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabRunnerControllersApi(GitLabCaller.of(client)).callScopes(1L);
        }

        HTTP.verifyRequested(GET, "/api/v4/runner_controllers/1/scopes");
    }

    @Test
    void callScopes_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/runner_controllers/1/scopes", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabRunnerControllersApi api = new GitLabRunnerControllersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callScopes(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/runner_controllers/1/scopes");
    }

    @Test
    void createScopesInstance_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/runner_controllers/1/scopes/instance",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabCiRunnerControllerInstanceLevelScoping.class,
                        "ci-runner-controller-instance-level-scoping.json")));

        final GitLabCiRunnerControllerInstanceLevelScoping result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabRunnerControllersApi(GitLabCaller.of(client)).createScopesInstance(1L);
        }

        assertThat(result).isEqualTo(RunnercontrollersCatalogFixtures.ciRunnerControllerInstanceLevelScoping());
        HTTP.verifyRequested(POST, "/api/v4/runner_controllers/1/scopes/instance");
    }

    @Test
    void createScopesInstance_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/runner_controllers/1/scopes/instance", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabRunnerControllersApi api = new GitLabRunnerControllersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createScopesInstance(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/runner_controllers/1/scopes/instance");
    }

    @Test
    void deleteScopesInstance_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/runner_controllers/1/scopes/instance", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabRunnerControllersApi(GitLabCaller.of(client)).deleteScopesInstance(1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/runner_controllers/1/scopes/instance");
    }

    @Test
    void deleteScopesInstance_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/runner_controllers/1/scopes/instance", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabRunnerControllersApi api = new GitLabRunnerControllersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteScopesInstance(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/runner_controllers/1/scopes/instance");
    }

    @Test
    void createScopesRunner_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/runner_controllers/1/scopes/runners/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabCiRunnerControllerRunnerLevelScoping.class,
                        "ci-runner-controller-runner-level-scoping.json")));

        final GitLabCiRunnerControllerRunnerLevelScoping result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabRunnerControllersApi(GitLabCaller.of(client)).createScopesRunner(1L, 1L);
        }

        assertThat(result).isEqualTo(RunnercontrollersCatalogFixtures.ciRunnerControllerRunnerLevelScoping());
        HTTP.verifyRequested(POST, "/api/v4/runner_controllers/1/scopes/runners/1");
    }

    @Test
    void createScopesRunner_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/runner_controllers/1/scopes/runners/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabRunnerControllersApi api = new GitLabRunnerControllersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createScopesRunner(1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/runner_controllers/1/scopes/runners/1");
    }

    @Test
    void deleteScopesRunner_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/runner_controllers/1/scopes/runners/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabRunnerControllersApi(GitLabCaller.of(client)).deleteScopesRunner(1L, 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/runner_controllers/1/scopes/runners/1");
    }

    @Test
    void deleteScopesRunner_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/runner_controllers/1/scopes/runners/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabRunnerControllersApi api = new GitLabRunnerControllersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteScopesRunner(1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/runner_controllers/1/scopes/runners/1");
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/runner_controllers",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabCiRunnerController.class, "ci-runner-controller.json")));

        final GitLabCiRunnerController result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabRunnerControllersApi(GitLabCaller.of(client))
                    .create(RunnercontrollersCatalogFixtures.runnerControllersCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciRunnerController());
        HTTP.verifyRequested(POST, "/api/v4/runner_controllers");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/runner_controllers", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabRunnerControllersApi api = new GitLabRunnerControllersApi(GitLabCaller.of(client));
            thrown =
                    catchThrowable(() -> api.create(RunnercontrollersCatalogFixtures.runnerControllersCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/runner_controllers");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/runner_controllers/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabCiRunnerControllerDetail.class, "ci-runner-controller-detail.json")));

        final Optional<GitLabCiRunnerControllerDetail> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabRunnerControllersApi(GitLabCaller.of(client)).get(1L);
        }

        assertThat(result).contains(RunnercontrollersCatalogFixtures.ciRunnerControllerDetail());
        HTTP.verifyRequested(GET, "/api/v4/runner_controllers/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/runner_controllers/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabRunnerControllersApi(GitLabCaller.of(client))
                    .get(1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/runner_controllers/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/runner_controllers/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabCiRunnerController.class, "ci-runner-controller.json")));

        final GitLabCiRunnerController result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabRunnerControllersApi(GitLabCaller.of(client))
                    .update(1L, RunnercontrollersCatalogFixtures.runnerControllersUpdatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciRunnerController());
        HTTP.verifyRequested(PUT, "/api/v4/runner_controllers/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/runner_controllers/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabRunnerControllersApi api = new GitLabRunnerControllersApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.update(1L, RunnercontrollersCatalogFixtures.runnerControllersUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/runner_controllers/1");
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/runner_controllers/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabCiRunnerController.class, "ci-runner-controller.json")));

        final Optional<GitLabCiRunnerController> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabRunnerControllersApi(GitLabCaller.of(client)).delete(1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.ciRunnerController());
        HTTP.verifyRequested(DELETE, "/api/v4/runner_controllers/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/runner_controllers/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabRunnerControllersApi api = new GitLabRunnerControllersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/runner_controllers/1");
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/runner_controllers/1", GitLabApiStubSupport.noContent());

        final Optional<GitLabCiRunnerController> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabRunnerControllersApi(GitLabCaller.of(client)).delete(1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/runner_controllers/1");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.runners;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBasicProjectDetails;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiResetTokenResult;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiRunner;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiRunnerController;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiRunnerManager;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiRunnerRegistrationDetails;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiRunnerWithUuid;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabInstanceRunnersApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void listRunnerControllers_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/runner_controllers",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabCiRunnerController.class, "ci-runner-controller.json")
                                        + "]")
                        .header("Link", "<" + base + "/api/v4/runner_controllers?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabCiRunnerController.class, "ci-runner-controller.json") + "]"));

        final List<GitLabCiRunnerController> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabInstanceRunnersApi(GitLabCaller.of(client))
                    .listRunnerControllers()
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        CommonCatalogFixtures.ciRunnerController(), CommonCatalogFixtures.ciRunnerController());
        HTTP.verifyRequested(GET, "/api/v4/runner_controllers", 2);
    }

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/runners",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabCiRunnerWithUuid.class, "ci-runner-with-uuid.json") + "]")
                        .header("Link", "<" + base + "/api/v4/runners?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabCiRunnerWithUuid.class, "ci-runner-with-uuid.json") + "]"));

        final List<GitLabCiRunnerWithUuid> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabInstanceRunnersApi(GitLabCaller.of(client)).list().all();
        }

        assertThat(items)
                .containsExactly(CommonCatalogFixtures.ciRunnerWithUuid(), CommonCatalogFixtures.ciRunnerWithUuid());
        HTTP.verifyRequested(GET, "/api/v4/runners", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/runners",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabCiRunnerRegistrationDetails.class, "ci-runner-registration-details.json")));

        final GitLabCiRunnerRegistrationDetails result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabInstanceRunnersApi(GitLabCaller.of(client))
                    .create(RunnersCatalogFixtures.instanceRunnersCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciRunnerRegistrationDetails());
        HTTP.verifyRequested(POST, "/api/v4/runners");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/runners", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabInstanceRunnersApi api = new GitLabInstanceRunnersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(RunnersCatalogFixtures.instanceRunnersCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/runners");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/runners", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabInstanceRunnersApi(GitLabCaller.of(client)).delete("token");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/runners");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/runners", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabInstanceRunnersApi api = new GitLabInstanceRunnersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("token"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/runners");
    }

    @Test
    void listAll_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/runners/all",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabCiRunnerWithUuid.class, "ci-runner-with-uuid.json") + "]")
                        .header("Link", "<" + base + "/api/v4/runners/all?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabCiRunnerWithUuid.class, "ci-runner-with-uuid.json") + "]"));

        final List<GitLabCiRunnerWithUuid> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabInstanceRunnersApi(GitLabCaller.of(client))
                    .listAll()
                    .all();
        }

        assertThat(items)
                .containsExactly(CommonCatalogFixtures.ciRunnerWithUuid(), CommonCatalogFixtures.ciRunnerWithUuid());
        HTTP.verifyRequested(GET, "/api/v4/runners/all", 2);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/runners/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabCiRunnerDetails.class, "ci-runner-details.json")));

        final Optional<GitLabCiRunnerDetails> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabInstanceRunnersApi(GitLabCaller.of(client)).get(1L);
        }

        assertThat(result).contains(RunnersCatalogFixtures.ciRunnerDetails());
        HTTP.verifyRequested(GET, "/api/v4/runners/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/runners/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabInstanceRunnersApi(GitLabCaller.of(client))
                    .get(1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/runners/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/runners/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabCiRunnerDetails.class, "ci-runner-details.json")));

        final GitLabCiRunnerDetails result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabInstanceRunnersApi(GitLabCaller.of(client))
                    .update(1L, RunnersCatalogFixtures.instanceRunnersUpdatePayload());
        }

        assertThat(result).isEqualTo(RunnersCatalogFixtures.ciRunnerDetails());
        HTTP.verifyRequested(PUT, "/api/v4/runners/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/runners/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabInstanceRunnersApi api = new GitLabInstanceRunnersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(1L, RunnersCatalogFixtures.instanceRunnersUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/runners/1");
    }

    @Test
    void deleteById_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/runners/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiRunner.class, "ci-runner.json")));

        final Optional<GitLabCiRunner> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabInstanceRunnersApi(GitLabCaller.of(client)).deleteById(1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.ciRunner());
        HTTP.verifyRequested(DELETE, "/api/v4/runners/1");
    }

    @Test
    void deleteById_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/runners/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabInstanceRunnersApi api = new GitLabInstanceRunnersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteById(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/runners/1");
    }

    @Test
    void deleteById_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/runners/1", GitLabApiStubSupport.noContent());

        final Optional<GitLabCiRunner> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabInstanceRunnersApi(GitLabCaller.of(client)).deleteById(1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/runners/1");
    }

    @Test
    void listManagers_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/runners/1/managers",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabCiRunnerManager.class, "ci-runner-manager.json") + "]"));

        final List<GitLabCiRunnerManager> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabInstanceRunnersApi(GitLabCaller.of(client)).listManagers(1L);
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.ciRunnerManager());
        HTTP.verifyRequested(GET, "/api/v4/runners/1/managers");
    }

    @Test
    void listProjects_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/runners/1/projects",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabBasicProjectDetails.class, "basic-project-details.json")
                                + "]")
                        .header("Link", "<" + base + "/api/v4/runners/1/projects?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(GitLabBasicProjectDetails.class, "basic-project-details.json") + "]"));

        final List<GitLabBasicProjectDetails> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabInstanceRunnersApi(GitLabCaller.of(client))
                    .listProjects(1L)
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        CommonCatalogFixtures.basicProjectDetails(), CommonCatalogFixtures.basicProjectDetails());
        HTTP.verifyRequested(GET, "/api/v4/runners/1/projects", 2);
    }

    @Test
    void listJobs_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/runners/1/jobs",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(
                                        GitLabCiJobBasicWithProject.class, "ci-job-basic-with-project.json")
                                + "]")
                        .header("Link", "<" + base + "/api/v4/runners/1/jobs?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabCiJobBasicWithProject.class, "ci-job-basic-with-project.json")
                                + "]"));

        final List<GitLabCiJobBasicWithProject> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabInstanceRunnersApi(GitLabCaller.of(client))
                    .listJobs(1L)
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        RunnersCatalogFixtures.ciJobBasicWithProject(), RunnersCatalogFixtures.ciJobBasicWithProject());
        HTTP.verifyRequested(GET, "/api/v4/runners/1/jobs", 2);
    }

    @Test
    void resetAuthenticationTokenById_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/runners/1/reset_authentication_token",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabCiResetTokenResult.class, "ci-reset-token-result.json")));

        final GitLabCiResetTokenResult result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabInstanceRunnersApi(GitLabCaller.of(client)).resetAuthenticationTokenById(1L);
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciResetTokenResult());
        HTTP.verifyRequested(POST, "/api/v4/runners/1/reset_authentication_token");
    }

    @Test
    void resetAuthenticationTokenById_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/runners/1/reset_authentication_token", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabInstanceRunnersApi api = new GitLabInstanceRunnersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.resetAuthenticationTokenById(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/runners/1/reset_authentication_token");
    }

    @Test
    void resetRegistrationToken_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/runners/reset_registration_token",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabCiResetTokenResult.class, "ci-reset-token-result.json")));

        final GitLabCiResetTokenResult result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabInstanceRunnersApi(GitLabCaller.of(client)).resetRegistrationToken();
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciResetTokenResult());
        HTTP.verifyRequested(POST, "/api/v4/runners/reset_registration_token");
    }

    @Test
    void resetRegistrationToken_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/runners/reset_registration_token", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabInstanceRunnersApi api = new GitLabInstanceRunnersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.resetRegistrationToken());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/runners/reset_registration_token");
    }

    @Test
    void deleteManager_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/runners/managers", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabInstanceRunnersApi(GitLabCaller.of(client)).deleteManager("token", "system_id");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/runners/managers");
    }

    @Test
    void deleteManager_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/runners/managers", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabInstanceRunnersApi api = new GitLabInstanceRunnersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteManager("token", "system_id"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/runners/managers");
    }

    @Test
    void verify_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/runners/verify",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabCiRunnerRegistrationDetails.class, "ci-runner-registration-details.json")));

        final GitLabCiRunnerRegistrationDetails result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabInstanceRunnersApi(GitLabCaller.of(client))
                    .verify(RunnersCatalogFixtures.instanceRunnersVerifyPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciRunnerRegistrationDetails());
        HTTP.verifyRequested(POST, "/api/v4/runners/verify");
    }

    @Test
    void verify_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/runners/verify", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabInstanceRunnersApi api = new GitLabInstanceRunnersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.verify(RunnersCatalogFixtures.instanceRunnersVerifyPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/runners/verify");
    }

    @Test
    void resetAuthenticationToken_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/runners/reset_authentication_token",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabCiResetTokenResult.class, "ci-reset-token-result.json")));

        final GitLabCiResetTokenResult result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabInstanceRunnersApi(GitLabCaller.of(client))
                    .resetAuthenticationToken(RunnersCatalogFixtures.instanceRunnersResetAuthenticationTokenPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciResetTokenResult());
        HTTP.verifyRequested(POST, "/api/v4/runners/reset_authentication_token");
    }

    @Test
    void resetAuthenticationToken_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/runners/reset_authentication_token", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabInstanceRunnersApi api = new GitLabInstanceRunnersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.resetAuthenticationToken(
                    RunnersCatalogFixtures.instanceRunnersResetAuthenticationTokenPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/runners/reset_authentication_token");
    }

    @Test
    void getRouterDiscovery_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/runners/router/discovery",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabCiJobRouterDiscoveryInformation.class, "ci-job-router-discovery-information.json")));

        final GitLabCiJobRouterDiscoveryInformation result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabInstanceRunnersApi(GitLabCaller.of(client)).getRouterDiscovery();
        }

        assertThat(result).isEqualTo(RunnersCatalogFixtures.ciJobRouterDiscoveryInformation());
        HTTP.verifyRequested(GET, "/api/v4/runners/router/discovery");
    }

    @Test
    void getRouterDiscovery_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/runners/router/discovery", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabInstanceRunnersApi api = new GitLabInstanceRunnersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getRouterDiscovery());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/runners/router/discovery");
    }
}

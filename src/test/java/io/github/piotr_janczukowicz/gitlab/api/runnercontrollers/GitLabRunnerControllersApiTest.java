package io.github.piotr_janczukowicz.gitlab.api.runnercontrollers;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiRunnerController;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabRunnerControllersApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabRunnerControllersApi api() {
        return new GitLabRunnerControllersApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabRunnerControllersApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void callScopes_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllersApi lowTier =
                new GitLabRunnerControllersApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.callScopes(1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void callScopes_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllersApi lowTier =
                new GitLabRunnerControllersApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.callScopes(1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void callScopes_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callScopes(1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/runner_controllers/1/scopes");
    }

    @Test
    void callScopes_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callScopes(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createScopesInstance_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllersApi lowTier =
                new GitLabRunnerControllersApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createScopesInstance(1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createScopesInstance_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllersApi lowTier =
                new GitLabRunnerControllersApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createScopesInstance(1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createScopesInstance_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabCiRunnerControllerInstanceLevelScoping.class,
                                "ci-runner-controller-instance-level-scoping.json")));

        final GitLabCiRunnerControllerInstanceLevelScoping result = api().createScopesInstance(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .isEqualTo(RunnercontrollersCatalogFixtures.ciRunnerControllerInstanceLevelScoping());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/runner_controllers/1/scopes/instance");
        });
    }

    @Test
    void createScopesInstance_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createScopesInstance(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteScopesInstance_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllersApi lowTier =
                new GitLabRunnerControllersApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteScopesInstance(1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void deleteScopesInstance_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllersApi lowTier =
                new GitLabRunnerControllersApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteScopesInstance(1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void deleteScopesInstance_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteScopesInstance(1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/runner_controllers/1/scopes/instance");
    }

    @Test
    void deleteScopesInstance_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteScopesInstance(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createScopesRunner_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllersApi lowTier =
                new GitLabRunnerControllersApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createScopesRunner(1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createScopesRunner_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllersApi lowTier =
                new GitLabRunnerControllersApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createScopesRunner(1L, 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createScopesRunner_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabCiRunnerControllerRunnerLevelScoping.class,
                                "ci-runner-controller-runner-level-scoping.json")));

        final GitLabCiRunnerControllerRunnerLevelScoping result = api().createScopesRunner(1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .isEqualTo(RunnercontrollersCatalogFixtures.ciRunnerControllerRunnerLevelScoping());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/runner_controllers/1/scopes/runners/1");
        });
    }

    @Test
    void createScopesRunner_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createScopesRunner(1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteScopesRunner_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllersApi lowTier =
                new GitLabRunnerControllersApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteScopesRunner(1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void deleteScopesRunner_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllersApi lowTier =
                new GitLabRunnerControllersApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteScopesRunner(1L, 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void deleteScopesRunner_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteScopesRunner(1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/runner_controllers/1/scopes/runners/1");
    }

    @Test
    void deleteScopesRunner_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteScopesRunner(1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void create_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllersApi lowTier =
                new GitLabRunnerControllersApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown =
                catchThrowable(() -> lowTier.create(RunnercontrollersCatalogFixtures.runnerControllersCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void create_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllersApi lowTier =
                new GitLabRunnerControllersApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown =
                catchThrowable(() -> lowTier.create(RunnercontrollersCatalogFixtures.runnerControllersCreatePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabCiRunnerController.class, "ci-runner-controller.json")));

        final GitLabCiRunnerController result =
                api().create(RunnercontrollersCatalogFixtures.runnerControllersCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.ciRunnerController());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/runner_controllers");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"description\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().create(RunnercontrollersCatalogFixtures.runnerControllersCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void get_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllersApi lowTier =
                new GitLabRunnerControllersApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.get(1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void get_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllersApi lowTier =
                new GitLabRunnerControllersApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.get(1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabCiRunnerControllerDetail.class, "ci-runner-controller-detail.json")));

        final Optional<GitLabCiRunnerControllerDetail> result = api().get(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(RunnercontrollersCatalogFixtures.ciRunnerControllerDetail());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/runner_controllers/1");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabCiRunnerControllerDetail> result = api().get(1L);

        assertThat(result).isEmpty();
    }

    @Test
    void update_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllersApi lowTier =
                new GitLabRunnerControllersApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(
                () -> lowTier.update(1L, RunnercontrollersCatalogFixtures.runnerControllersUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void update_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllersApi lowTier =
                new GitLabRunnerControllersApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(
                () -> lowTier.update(1L, RunnercontrollersCatalogFixtures.runnerControllersUpdatePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabCiRunnerController.class, "ci-runner-controller.json")));

        final GitLabCiRunnerController result =
                api().update(1L, RunnercontrollersCatalogFixtures.runnerControllersUpdatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.ciRunnerController());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("PUT /api/v4/runner_controllers/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"description\":");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().update(1L, RunnercontrollersCatalogFixtures.runnerControllersUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllersApi lowTier =
                new GitLabRunnerControllersApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.delete(1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void delete_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllersApi lowTier =
                new GitLabRunnerControllersApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.delete(1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabCiRunnerController.class, "ci-runner-controller.json")));

        final Optional<GitLabCiRunnerController> result = api().delete(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.ciRunnerController());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/runner_controllers/1");
        });
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        final Optional<GitLabCiRunnerController> result = api().delete(1L);

        assertThat(result).isEmpty();
    }
}

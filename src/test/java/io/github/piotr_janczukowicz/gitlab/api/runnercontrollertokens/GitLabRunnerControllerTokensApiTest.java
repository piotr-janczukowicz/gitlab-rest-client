package io.github.piotr_janczukowicz.gitlab.api.runnercontrollertokens;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
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
class GitLabRunnerControllerTokensApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabRunnerControllerTokensApi api() {
        return new GitLabRunnerControllerTokensApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabRunnerControllerTokensApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllerTokensApi lowTier =
                new GitLabRunnerControllerTokensApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list(1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void list_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllerTokensApi lowTier =
                new GitLabRunnerControllerTokensApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list(1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabCiRunnerControllerToken.class, "ci-runner-controller-token.json")
                                + "]"));

        final GitLabPage<GitLabCiRunnerControllerToken> page = api().list(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items())
                    .containsExactly(RunnercontrollertokensCatalogFixtures.ciRunnerControllerToken());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/runner_controllers/1/tokens");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabCiRunnerControllerToken.class, "ci-runner-controller-token.json")
                                + "]"));

        final GitLabPage<GitLabCiRunnerControllerToken> page = api().list(1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items())
                    .containsExactly(RunnercontrollertokensCatalogFixtures.ciRunnerControllerToken());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/runner_controllers/1/tokens");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void create_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllerTokensApi lowTier =
                new GitLabRunnerControllerTokensApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(
                () -> lowTier.create(1L, RunnercontrollertokensCatalogFixtures.runnerControllerTokensCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void create_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllerTokensApi lowTier =
                new GitLabRunnerControllerTokensApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(
                () -> lowTier.create(1L, RunnercontrollertokensCatalogFixtures.runnerControllerTokensCreatePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabCiRunnerControllerToken.class, "ci-runner-controller-token.json")));

        final GitLabCiRunnerControllerToken result =
                api().create(1L, RunnercontrollertokensCatalogFixtures.runnerControllerTokensCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(RunnercontrollertokensCatalogFixtures.ciRunnerControllerToken());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/runner_controllers/1/tokens");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"description\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().create(1L, RunnercontrollertokensCatalogFixtures.runnerControllerTokensCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void get_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllerTokensApi lowTier =
                new GitLabRunnerControllerTokensApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.get(1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void get_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllerTokensApi lowTier =
                new GitLabRunnerControllerTokensApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.get(1L, 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabCiRunnerControllerToken.class, "ci-runner-controller-token.json")));

        final Optional<GitLabCiRunnerControllerToken> result = api().get(1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(RunnercontrollertokensCatalogFixtures.ciRunnerControllerToken());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/runner_controllers/1/tokens/1");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabCiRunnerControllerToken> result = api().get(1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void delete_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllerTokensApi lowTier =
                new GitLabRunnerControllerTokensApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.delete(1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void delete_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllerTokensApi lowTier =
                new GitLabRunnerControllerTokensApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.delete(1L, 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete(1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/runner_controllers/1/tokens/1");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete(1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void rotate_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllerTokensApi lowTier =
                new GitLabRunnerControllerTokensApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.rotate(1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void rotate_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabRunnerControllerTokensApi lowTier =
                new GitLabRunnerControllerTokensApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.rotate(1L, 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void rotate_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabCiRunnerControllerTokenWithToken.class,
                                "ci-runner-controller-token-with-token.json")));

        final GitLabCiRunnerControllerTokenWithToken result = api().rotate(1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .isEqualTo(RunnercontrollertokensCatalogFixtures.ciRunnerControllerTokenWithToken());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/runner_controllers/1/tokens/1/rotate");
        });
    }

    @Test
    void rotate_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().rotate(1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}

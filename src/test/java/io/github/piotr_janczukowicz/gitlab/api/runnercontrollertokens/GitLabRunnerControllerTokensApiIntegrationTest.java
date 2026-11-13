package io.github.piotr_janczukowicz.gitlab.api.runnercontrollertokens;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
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
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabRunnerControllerTokensApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/runner_controllers/1/tokens",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(
                                        GitLabCiRunnerControllerToken.class, "ci-runner-controller-token.json")
                                + "]")
                        .header("Link", "<" + base + "/api/v4/runner_controllers/1/tokens?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(GitLabCiRunnerControllerToken.class, "ci-runner-controller-token.json")
                        + "]"));

        final List<GitLabCiRunnerControllerToken> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabRunnerControllerTokensApi(GitLabCaller.of(client))
                    .list(1L)
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        RunnercontrollertokensCatalogFixtures.ciRunnerControllerToken(),
                        RunnercontrollertokensCatalogFixtures.ciRunnerControllerToken());
        HTTP.verifyRequested(GET, "/api/v4/runner_controllers/1/tokens", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/runner_controllers/1/tokens",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabCiRunnerControllerToken.class, "ci-runner-controller-token.json")));

        final GitLabCiRunnerControllerToken result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabRunnerControllerTokensApi(GitLabCaller.of(client))
                    .create(1L, RunnercontrollertokensCatalogFixtures.runnerControllerTokensCreatePayload());
        }

        assertThat(result).isEqualTo(RunnercontrollertokensCatalogFixtures.ciRunnerControllerToken());
        HTTP.verifyRequested(POST, "/api/v4/runner_controllers/1/tokens");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/runner_controllers/1/tokens", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabRunnerControllerTokensApi api = new GitLabRunnerControllerTokensApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.create(1L, RunnercontrollertokensCatalogFixtures.runnerControllerTokensCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/runner_controllers/1/tokens");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/runner_controllers/1/tokens/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabCiRunnerControllerToken.class, "ci-runner-controller-token.json")));

        final Optional<GitLabCiRunnerControllerToken> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabRunnerControllerTokensApi(GitLabCaller.of(client)).get(1L, 1L);
        }

        assertThat(result).contains(RunnercontrollertokensCatalogFixtures.ciRunnerControllerToken());
        HTTP.verifyRequested(GET, "/api/v4/runner_controllers/1/tokens/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/runner_controllers/1/tokens/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabRunnerControllerTokensApi(GitLabCaller.of(client))
                    .get(1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/runner_controllers/1/tokens/1");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/runner_controllers/1/tokens/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabRunnerControllerTokensApi(GitLabCaller.of(client)).delete(1L, 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/runner_controllers/1/tokens/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/runner_controllers/1/tokens/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabRunnerControllerTokensApi api = new GitLabRunnerControllerTokensApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete(1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/runner_controllers/1/tokens/1");
    }

    @Test
    void rotate_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/runner_controllers/1/tokens/1/rotate",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabCiRunnerControllerTokenWithToken.class, "ci-runner-controller-token-with-token.json")));

        final GitLabCiRunnerControllerTokenWithToken result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabRunnerControllerTokensApi(GitLabCaller.of(client)).rotate(1L, 1L);
        }

        assertThat(result).isEqualTo(RunnercontrollertokensCatalogFixtures.ciRunnerControllerTokenWithToken());
        HTTP.verifyRequested(POST, "/api/v4/runner_controllers/1/tokens/1/rotate");
    }

    @Test
    void rotate_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/runner_controllers/1/tokens/1/rotate", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabRunnerControllerTokensApi api = new GitLabRunnerControllerTokensApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.rotate(1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/runner_controllers/1/tokens/1/rotate");
    }
}

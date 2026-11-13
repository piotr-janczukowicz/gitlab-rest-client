package io.github.piotr_janczukowicz.gitlab.api.runners;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiResetTokenResult;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiRunner;
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
class GitLabProjectRunnersApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/runners",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabCiRunnerWithUuid.class, "ci-runner-with-uuid.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/projects/group%2Fsub%2Fproject/runners?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabCiRunnerWithUuid.class, "ci-runner-with-uuid.json") + "]"));

        final List<GitLabCiRunnerWithUuid> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectRunnersApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(CommonCatalogFixtures.ciRunnerWithUuid(), CommonCatalogFixtures.ciRunnerWithUuid());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/runners", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/runners",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabCiRunnerWithUuid.class, "ci-runner-with-uuid.json")));

        final GitLabCiRunnerWithUuid result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectRunnersApi(GitLabCaller.of(client))
                    .create("group/sub/project", RunnersCatalogFixtures.projectRunnersCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciRunnerWithUuid());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/runners");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/runners", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectRunnersApi api = new GitLabProjectRunnersApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.create("group/sub/project", RunnersCatalogFixtures.projectRunnersCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/runners");
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/runners/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiRunner.class, "ci-runner.json")));

        final Optional<GitLabCiRunner> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectRunnersApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.ciRunner());
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/runners/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/runners/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectRunnersApi api = new GitLabProjectRunnersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/runners/1");
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/runners/1", GitLabApiStubSupport.noContent());

        final Optional<GitLabCiRunner> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectRunnersApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/runners/1");
    }

    @Test
    void resetRegistrationToken_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/runners/reset_registration_token",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabCiResetTokenResult.class, "ci-reset-token-result.json")));

        final GitLabCiResetTokenResult result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectRunnersApi(GitLabCaller.of(client)).resetRegistrationToken("group/sub/project");
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciResetTokenResult());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/runners/reset_registration_token");
    }

    @Test
    void resetRegistrationToken_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/runners/reset_registration_token",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectRunnersApi api = new GitLabProjectRunnersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.resetRegistrationToken("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/runners/reset_registration_token");
    }
}

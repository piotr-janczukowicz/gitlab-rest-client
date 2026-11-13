package io.github.piotr_janczukowicz.gitlab.api.environments;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabEnvironmentBasic;
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
class GitLabProjectEnvironmentsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/environments",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabEnvironment.class, "environment.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/environments?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabEnvironment.class, "environment.json") + "]"));

        final List<GitLabEnvironment> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectEnvironmentsApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(EnvironmentsCatalogFixtures.environment(), EnvironmentsCatalogFixtures.environment());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/environments", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/environments",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabEnvironment.class, "environment.json")));

        final GitLabEnvironment result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectEnvironmentsApi(GitLabCaller.of(client))
                    .create("group/sub/project", EnvironmentsCatalogFixtures.projectEnvironmentsCreatePayload());
        }

        assertThat(result).isEqualTo(EnvironmentsCatalogFixtures.environment());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/environments");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/environments", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectEnvironmentsApi api = new GitLabProjectEnvironmentsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.create("group/sub/project", EnvironmentsCatalogFixtures.projectEnvironmentsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/environments");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/environments/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabEnvironment.class, "environment.json")));

        final Optional<GitLabEnvironment> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectEnvironmentsApi(GitLabCaller.of(client)).get("group/sub/project", 1L);
        }

        assertThat(result).contains(EnvironmentsCatalogFixtures.environment());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/environments/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/environments/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectEnvironmentsApi(GitLabCaller.of(client))
                    .get("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/environments/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/environments/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabEnvironment.class, "environment.json")));

        final GitLabEnvironment result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectEnvironmentsApi(GitLabCaller.of(client))
                    .update("group/sub/project", 1L, EnvironmentsCatalogFixtures.projectEnvironmentsUpdatePayload());
        }

        assertThat(result).isEqualTo(EnvironmentsCatalogFixtures.environment());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/environments/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/environments/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectEnvironmentsApi api = new GitLabProjectEnvironmentsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project", 1L, EnvironmentsCatalogFixtures.projectEnvironmentsUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/environments/1");
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/environments/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabEnvironment.class, "environment.json")));

        final Optional<GitLabEnvironment> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectEnvironmentsApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        assertThat(result).contains(EnvironmentsCatalogFixtures.environment());
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/environments/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/environments/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectEnvironmentsApi api = new GitLabProjectEnvironmentsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/environments/1");
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/environments/1", GitLabApiStubSupport.noContent());

        final Optional<GitLabEnvironment> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectEnvironmentsApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/environments/1");
    }

    @Test
    void deleteReviewApp_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/environments/review_apps",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabEnvironmentBasic.class, "environment-basic.json")));

        final Optional<GitLabEnvironmentBasic> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectEnvironmentsApi(GitLabCaller.of(client)).deleteReviewApp("group/sub/project");
        }

        assertThat(result).contains(CommonCatalogFixtures.environmentBasic());
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/environments/review_apps");
    }

    @Test
    void deleteReviewApp_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/environments/review_apps",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectEnvironmentsApi api = new GitLabProjectEnvironmentsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteReviewApp("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/environments/review_apps");
    }

    @Test
    void deleteReviewApp_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/environments/review_apps",
                GitLabApiStubSupport.noContent());

        final Optional<GitLabEnvironmentBasic> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectEnvironmentsApi(GitLabCaller.of(client)).deleteReviewApp("group/sub/project");
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/environments/review_apps");
    }

    @Test
    void stop_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/environments/1/stop",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabEnvironment.class, "environment.json")));

        final GitLabEnvironment result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectEnvironmentsApi(GitLabCaller.of(client))
                    .stop("group/sub/project", 1L, EnvironmentsCatalogFixtures.projectEnvironmentsStopPayload());
        }

        assertThat(result).isEqualTo(EnvironmentsCatalogFixtures.environment());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/environments/1/stop");
    }

    @Test
    void stop_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/environments/1/stop", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectEnvironmentsApi api = new GitLabProjectEnvironmentsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.stop("group/sub/project", 1L, EnvironmentsCatalogFixtures.projectEnvironmentsStopPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/environments/1/stop");
    }

    @Test
    void stopStale_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/environments/stop_stale",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectEnvironmentsApi(GitLabCaller.of(client))
                    .stopStale("group/sub/project", EnvironmentsCatalogFixtures.projectEnvironmentsStopStalePayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/environments/stop_stale");
    }

    @Test
    void stopStale_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/environments/stop_stale",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectEnvironmentsApi api = new GitLabProjectEnvironmentsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.stopStale(
                    "group/sub/project", EnvironmentsCatalogFixtures.projectEnvironmentsStopStalePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/environments/stop_stale");
    }
}

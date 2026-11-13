package io.github.piotr_janczukowicz.gitlab.api.errortracking;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.PATCH;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
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
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectErrorTrackingApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/error_tracking/settings",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabErrorTrackingProjectSetting.class, "error-tracking-project-setting.json")));

        final GitLabErrorTrackingProjectSetting result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectErrorTrackingApi(GitLabCaller.of(client)).get("group/sub/project");
        }

        assertThat(result).isEqualTo(ErrortrackingCatalogFixtures.errorTrackingProjectSetting());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/error_tracking/settings");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/error_tracking/settings", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectErrorTrackingApi api = new GitLabProjectErrorTrackingApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.get("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/error_tracking/settings");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/error_tracking/settings",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabErrorTrackingProjectSetting.class, "error-tracking-project-setting.json")));

        final GitLabErrorTrackingProjectSetting result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectErrorTrackingApi(GitLabCaller.of(client))
                    .update("group/sub/project", ErrortrackingCatalogFixtures.projectErrorTrackingUpdatePayload());
        }

        assertThat(result).isEqualTo(ErrortrackingCatalogFixtures.errorTrackingProjectSetting());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/error_tracking/settings");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/error_tracking/settings", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectErrorTrackingApi api = new GitLabProjectErrorTrackingApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.update("group/sub/project", ErrortrackingCatalogFixtures.projectErrorTrackingUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/error_tracking/settings");
    }

    @Test
    void patch_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PATCH,
                "/api/v4/projects/group%2Fsub%2Fproject/error_tracking/settings",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabErrorTrackingProjectSetting.class, "error-tracking-project-setting.json")));

        final GitLabErrorTrackingProjectSetting result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectErrorTrackingApi(GitLabCaller.of(client))
                    .patch("group/sub/project", ErrortrackingCatalogFixtures.projectErrorTrackingPatchPayload());
        }

        assertThat(result).isEqualTo(ErrortrackingCatalogFixtures.errorTrackingProjectSetting());
        HTTP.verifyRequested(PATCH, "/api/v4/projects/group%2Fsub%2Fproject/error_tracking/settings");
    }

    @Test
    void patch_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PATCH,
                "/api/v4/projects/group%2Fsub%2Fproject/error_tracking/settings",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectErrorTrackingApi api = new GitLabProjectErrorTrackingApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.patch("group/sub/project", ErrortrackingCatalogFixtures.projectErrorTrackingPatchPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PATCH, "/api/v4/projects/group%2Fsub%2Fproject/error_tracking/settings");
    }

    @Test
    void listClientKeys_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/error_tracking/client_keys",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabErrorTrackingClientKey.class, "error-tracking-client-key.json")
                                + "]"));

        final List<GitLabErrorTrackingClientKey> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectErrorTrackingApi(GitLabCaller.of(client)).listClientKeys("group/sub/project");
        }

        assertThat(result).containsExactly(ErrortrackingCatalogFixtures.errorTrackingClientKey());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/error_tracking/client_keys");
    }

    @Test
    void createClientKey_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/error_tracking/client_keys",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabErrorTrackingClientKey.class, "error-tracking-client-key.json")));

        final GitLabErrorTrackingClientKey result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectErrorTrackingApi(GitLabCaller.of(client)).createClientKey("group/sub/project");
        }

        assertThat(result).isEqualTo(ErrortrackingCatalogFixtures.errorTrackingClientKey());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/error_tracking/client_keys");
    }

    @Test
    void createClientKey_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/error_tracking/client_keys",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectErrorTrackingApi api = new GitLabProjectErrorTrackingApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createClientKey("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/error_tracking/client_keys");
    }

    @Test
    void deleteClientKey_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/error_tracking/client_keys/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabErrorTrackingClientKey.class, "error-tracking-client-key.json")));

        final Optional<GitLabErrorTrackingClientKey> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result =
                    new GitLabProjectErrorTrackingApi(GitLabCaller.of(client)).deleteClientKey("group/sub/project", 1L);
        }

        assertThat(result).contains(ErrortrackingCatalogFixtures.errorTrackingClientKey());
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/error_tracking/client_keys/1");
    }

    @Test
    void deleteClientKey_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/error_tracking/client_keys/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectErrorTrackingApi api = new GitLabProjectErrorTrackingApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteClientKey("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/error_tracking/client_keys/1");
    }

    @Test
    void deleteClientKey_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/error_tracking/client_keys/1",
                GitLabApiStubSupport.noContent());

        final Optional<GitLabErrorTrackingClientKey> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result =
                    new GitLabProjectErrorTrackingApi(GitLabCaller.of(client)).deleteClientKey("group/sub/project", 1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/error_tracking/client_keys/1");
    }
}

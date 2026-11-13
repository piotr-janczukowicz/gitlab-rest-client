package io.github.piotr_janczukowicz.gitlab.api.remotemirrors;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
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
class GitLabProjectRemoteMirrorsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabRemoteMirror.class, "remote-mirror.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabRemoteMirror.class, "remote-mirror.json") + "]"));

        final List<GitLabRemoteMirror> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectRemoteMirrorsApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        RemotemirrorsCatalogFixtures.remoteMirror(), RemotemirrorsCatalogFixtures.remoteMirror());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabRemoteMirror.class, "remote-mirror.json")));

        final GitLabRemoteMirror result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectRemoteMirrorsApi(GitLabCaller.of(client))
                    .create("group/sub/project", RemotemirrorsCatalogFixtures.projectRemoteMirrorsCreatePayload());
        }

        assertThat(result).isEqualTo(RemotemirrorsCatalogFixtures.remoteMirror());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectRemoteMirrorsApi api = new GitLabProjectRemoteMirrorsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.create("group/sub/project", RemotemirrorsCatalogFixtures.projectRemoteMirrorsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors/mirror_id",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabRemoteMirror.class, "remote-mirror.json")));

        final Optional<GitLabRemoteMirror> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectRemoteMirrorsApi(GitLabCaller.of(client)).get("group/sub/project", "mirror_id");
        }

        assertThat(result).contains(RemotemirrorsCatalogFixtures.remoteMirror());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors/mirror_id");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors/mirror_id",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectRemoteMirrorsApi(GitLabCaller.of(client))
                    .get("group/sub/project", "mirror_id")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors/mirror_id");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors/mirror_id",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabRemoteMirror.class, "remote-mirror.json")));

        final GitLabRemoteMirror result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectRemoteMirrorsApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            "mirror_id",
                            RemotemirrorsCatalogFixtures.projectRemoteMirrorsUpdatePayload());
        }

        assertThat(result).isEqualTo(RemotemirrorsCatalogFixtures.remoteMirror());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors/mirror_id");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors/mirror_id",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectRemoteMirrorsApi api = new GitLabProjectRemoteMirrorsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project",
                    "mirror_id",
                    RemotemirrorsCatalogFixtures.projectRemoteMirrorsUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors/mirror_id");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors/mirror_id",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectRemoteMirrorsApi(GitLabCaller.of(client)).delete("group/sub/project", "mirror_id");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors/mirror_id");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors/mirror_id",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectRemoteMirrorsApi api = new GitLabProjectRemoteMirrorsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", "mirror_id"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors/mirror_id");
    }

    @Test
    void sync_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors/mirror_id/sync",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectRemoteMirrorsApi(GitLabCaller.of(client)).sync("group/sub/project", "mirror_id");
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors/mirror_id/sync");
    }

    @Test
    void sync_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors/mirror_id/sync",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectRemoteMirrorsApi api = new GitLabProjectRemoteMirrorsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.sync("group/sub/project", "mirror_id"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors/mirror_id/sync");
    }

    @Test
    void callPublicKey_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors/mirror_id/public_key",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectRemoteMirrorsApi(GitLabCaller.of(client)).callPublicKey("group/sub/project", "mirror_id");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors/mirror_id/public_key");
    }

    @Test
    void callPublicKey_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors/mirror_id/public_key",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectRemoteMirrorsApi api = new GitLabProjectRemoteMirrorsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callPublicKey("group/sub/project", "mirror_id"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/remote_mirrors/mirror_id/public_key");
    }
}

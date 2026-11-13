package io.github.piotr_janczukowicz.gitlab.api.draftnotes;

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
class GitLabProjectDraftNotesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/draft_notes",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabDraftNote.class, "draft-note.json") + "]"));

        final List<GitLabDraftNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDraftNotesApi(GitLabCaller.of(client)).list("group/sub/project", 1L);
        }

        assertThat(result).containsExactly(DraftnotesCatalogFixtures.draftNote());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/draft_notes");
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/draft_notes",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabDraftNote.class, "draft-note.json")));

        final GitLabDraftNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDraftNotesApi(GitLabCaller.of(client))
                    .create("group/sub/project", 1L, DraftnotesCatalogFixtures.projectDraftNotesCreatePayload());
        }

        assertThat(result).isEqualTo(DraftnotesCatalogFixtures.draftNote());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/draft_notes");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/draft_notes",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDraftNotesApi api = new GitLabProjectDraftNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.create("group/sub/project", 1L, DraftnotesCatalogFixtures.projectDraftNotesCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/draft_notes");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/draft_notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabDraftNote.class, "draft-note.json")));

        final Optional<GitLabDraftNote> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDraftNotesApi(GitLabCaller.of(client)).get("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(DraftnotesCatalogFixtures.draftNote());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/draft_notes/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/draft_notes/1",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectDraftNotesApi(GitLabCaller.of(client))
                    .get("group/sub/project", 1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/draft_notes/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/draft_notes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabDraftNote.class, "draft-note.json")));

        final GitLabDraftNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDraftNotesApi(GitLabCaller.of(client))
                    .update("group/sub/project", 1L, 1L, DraftnotesCatalogFixtures.projectDraftNotesUpdatePayload());
        }

        assertThat(result).isEqualTo(DraftnotesCatalogFixtures.draftNote());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/draft_notes/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/draft_notes/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDraftNotesApi api = new GitLabProjectDraftNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project", 1L, 1L, DraftnotesCatalogFixtures.projectDraftNotesUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/draft_notes/1");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/draft_notes/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectDraftNotesApi(GitLabCaller.of(client)).delete("group/sub/project", 1L, 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/draft_notes/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/draft_notes/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDraftNotesApi api = new GitLabProjectDraftNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/draft_notes/1");
    }

    @Test
    void publish_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/draft_notes/1/publish",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectDraftNotesApi(GitLabCaller.of(client)).publish("group/sub/project", 1L, 1L);
        }

        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/draft_notes/1/publish");
    }

    @Test
    void publish_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/draft_notes/1/publish",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDraftNotesApi api = new GitLabProjectDraftNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.publish("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/draft_notes/1/publish");
    }

    @Test
    void bulkPublish_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/draft_notes/bulk_publish",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectDraftNotesApi(GitLabCaller.of(client))
                    .bulkPublish(
                            "group/sub/project", 1L, DraftnotesCatalogFixtures.projectDraftNotesBulkPublishPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/draft_notes/bulk_publish");
    }

    @Test
    void bulkPublish_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/draft_notes/bulk_publish",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDraftNotesApi api = new GitLabProjectDraftNotesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.bulkPublish(
                    "group/sub/project", 1L, DraftnotesCatalogFixtures.projectDraftNotesBulkPublishPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/draft_notes/bulk_publish");
    }
}

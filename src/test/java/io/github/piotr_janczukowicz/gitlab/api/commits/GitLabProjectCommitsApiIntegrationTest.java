package io.github.piotr_janczukowicz.gitlab.api.commits;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCommit;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCommitDetail;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabDiff;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMergeRequestBasic;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectCommitsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void listStatuses_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/statuses",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabCommitStatus.class, "commit-status.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/statuses?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabCommitStatus.class, "commit-status.json") + "]"));

        final List<GitLabCommitStatus> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectCommitsApi(GitLabCaller.of(client))
                    .listStatuses("group/sub/project", "sha")
                    .all();
        }

        assertThat(items).containsExactly(CommitsCatalogFixtures.commitStatus(), CommitsCatalogFixtures.commitStatus());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/statuses", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/statuses/sha",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCommitStatus.class, "commit-status.json")));

        final GitLabCommitStatus result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectCommitsApi(GitLabCaller.of(client))
                    .create("group/sub/project", "sha", CommitsCatalogFixtures.projectCommitsCreatePayload());
        }

        assertThat(result).isEqualTo(CommitsCatalogFixtures.commitStatus());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/statuses/sha");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/statuses/sha", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectCommitsApi api = new GitLabProjectCommitsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.create("group/sub/project", "sha", CommitsCatalogFixtures.projectCommitsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/statuses/sha");
    }

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabCommit.class, "commit.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/repository/commits?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabCommit.class, "commit.json") + "]"));

        final List<GitLabCommit> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectCommitsApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.commit(), CommonCatalogFixtures.commit());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits", 2);
    }

    @Test
    void createCommits_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCommitDetail.class, "commit-detail.json")));

        final GitLabCommitDetail result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectCommitsApi(GitLabCaller.of(client))
                    .createCommits(
                            "group/sub/project",
                            MultipartFormData.builder().text("field", "value").build());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.commitDetail());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits");
    }

    @Test
    void createCommits_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectCommitsApi api = new GitLabProjectCommitsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createCommits(
                    "group/sub/project",
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCommitDetail.class, "commit-detail.json")));

        final Optional<GitLabCommitDetail> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectCommitsApi(GitLabCaller.of(client)).get("group/sub/project", "sha");
        }

        assertThat(result).contains(CommonCatalogFixtures.commitDetail());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectCommitsApi(GitLabCaller.of(client))
                    .get("group/sub/project", "sha")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha");
    }

    @Test
    void listDiff_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/diff",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabDiff.class, "diff.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/diff?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabDiff.class, "diff.json") + "]"));

        final List<GitLabDiff> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectCommitsApi(GitLabCaller.of(client))
                    .listDiff("group/sub/project", "sha")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.diff(), CommonCatalogFixtures.diff());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/diff", 2);
    }

    @Test
    void listComments_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/comments",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabCommitNote.class, "commit-note.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/comments?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabCommitNote.class, "commit-note.json") + "]"));

        final List<GitLabCommitNote> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectCommitsApi(GitLabCaller.of(client))
                    .listComments("group/sub/project", "sha")
                    .all();
        }

        assertThat(items).containsExactly(CommitsCatalogFixtures.commitNote(), CommitsCatalogFixtures.commitNote());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/comments", 2);
    }

    @Test
    void createComment_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/comments",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCommitNote.class, "commit-note.json")));

        final GitLabCommitNote result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectCommitsApi(GitLabCaller.of(client))
                    .createComment(
                            "group/sub/project", "sha", CommitsCatalogFixtures.projectCommitsCreateCommentPayload());
        }

        assertThat(result).isEqualTo(CommitsCatalogFixtures.commitNote());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/comments");
    }

    @Test
    void createComment_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/comments",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectCommitsApi api = new GitLabProjectCommitsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createComment(
                    "group/sub/project", "sha", CommitsCatalogFixtures.projectCommitsCreateCommentPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/comments");
    }

    @Test
    void getSequence_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/sequence",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCommitSequence.class, "commit-sequence.json")));

        final Optional<GitLabCommitSequence> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectCommitsApi(GitLabCaller.of(client)).getSequence("group/sub/project", "sha");
        }

        assertThat(result).contains(CommitsCatalogFixtures.commitSequence());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/sequence");
    }

    @Test
    void getSequence_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/sequence",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectCommitsApi(GitLabCaller.of(client))
                    .getSequence("group/sub/project", "sha")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/sequence");
    }

    @Test
    void cherryPick_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/cherry_pick",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCommit.class, "commit.json")));

        final GitLabCommit result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectCommitsApi(GitLabCaller.of(client))
                    .cherryPick("group/sub/project", "sha", CommitsCatalogFixtures.projectCommitsCherryPickPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.commit());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/cherry_pick");
    }

    @Test
    void cherryPick_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/cherry_pick",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectCommitsApi api = new GitLabProjectCommitsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.cherryPick(
                    "group/sub/project", "sha", CommitsCatalogFixtures.projectCommitsCherryPickPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/cherry_pick");
    }

    @Test
    void revert_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/revert",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCommit.class, "commit.json")));

        final GitLabCommit result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectCommitsApi(GitLabCaller.of(client))
                    .revert("group/sub/project", "sha", CommitsCatalogFixtures.projectCommitsRevertPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.commit());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/revert");
    }

    @Test
    void revert_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/revert",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectCommitsApi api = new GitLabProjectCommitsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.revert("group/sub/project", "sha", CommitsCatalogFixtures.projectCommitsRevertPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/revert");
    }

    @Test
    void listRefs_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/refs",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabBasicRef.class, "basic-ref.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/refs?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabBasicRef.class, "basic-ref.json") + "]"));

        final List<GitLabBasicRef> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectCommitsApi(GitLabCaller.of(client))
                    .listRefs("group/sub/project", "sha")
                    .all();
        }

        assertThat(items).containsExactly(CommitsCatalogFixtures.basicRef(), CommitsCatalogFixtures.basicRef());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/refs", 2);
    }

    @Test
    void listMergeRequests_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/merge_requests",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabMergeRequestBasic.class, "merge-request-basic.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/merge_requests?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabMergeRequestBasic.class, "merge-request-basic.json") + "]"));

        final List<GitLabMergeRequestBasic> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectCommitsApi(GitLabCaller.of(client))
                    .listMergeRequests("group/sub/project", "sha")
                    .all();
        }

        assertThat(items)
                .containsExactly(CommonCatalogFixtures.mergeRequestBasic(), CommonCatalogFixtures.mergeRequestBasic());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/merge_requests", 2);
    }

    @Test
    void getSignature_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/signature",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabCommitSignature.class, "commit-signature.json")));

        final Optional<GitLabCommitSignature> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectCommitsApi(GitLabCaller.of(client)).getSignature("group/sub/project", "sha");
        }

        assertThat(result).contains(CommitsCatalogFixtures.commitSignature());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/signature");
    }

    @Test
    void getSignature_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/signature",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectCommitsApi(GitLabCaller.of(client))
                    .getSignature("group/sub/project", "sha")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/signature");
    }
}

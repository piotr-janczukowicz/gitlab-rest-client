package io.github.piotr_janczukowicz.gitlab.api.commits;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCommit;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCommitDetail;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabDiff;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMergeRequestBasic;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.time.Instant;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectCommitsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectCommitsApi api() {
        return new GitLabProjectCommitsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectCommitsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void listStatuses_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabCommitStatus.class, "commit-status.json") + "]"));

        final GitLabPage<GitLabCommitStatus> page = api().listStatuses("group/sub/project", "sha");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommitsCatalogFixtures.commitStatus());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/statuses");
        });
    }

    @Test
    void listStatuses_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabCommitStatus.class, "commit-status.json") + "]"));

        final GitLabPage<GitLabCommitStatus> page = api().listStatuses(
                        "group/sub/project",
                        "sha",
                        GitLabProjectCommitsListStatusesFilterBuilder.builder()
                                .ref("ref")
                                .stage("stage")
                                .name("name")
                                .pipelineId(1L)
                                .all(true)
                                .orderBy(GitLabProjectCommitsListStatusesOrderBy.ID)
                                .sort(GitLabProjectCommitsListStatusesSort.ASC)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommitsCatalogFixtures.commitStatus());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/statuses");
            softly.assertThat(request.uri()).hasParameter("ref", "ref");
        });
    }

    @Test
    void listStatuses_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabCommitStatus.class, "commit-status.json") + "]"));

        final GitLabPage<GitLabCommitStatus> page =
                api().listStatuses("group/sub/project", "sha", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommitsCatalogFixtures.commitStatus());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/statuses");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listStatuses_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabCommitStatus.class, "commit-status.json") + "]"));

        final GitLabPage<GitLabCommitStatus> page = api().listStatuses(
                        "group/sub/project",
                        "sha",
                        GitLabProjectCommitsListStatusesFilterBuilder.builder()
                                .ref("ref")
                                .stage("stage")
                                .name("name")
                                .pipelineId(1L)
                                .all(true)
                                .orderBy(GitLabProjectCommitsListStatusesOrderBy.ID)
                                .sort(GitLabProjectCommitsListStatusesSort.ASC)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommitsCatalogFixtures.commitStatus());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/statuses");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("ref", "ref");
        });
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCommitStatus.class, "commit-status.json")));

        final GitLabCommitStatus result =
                api().create("group/sub/project", "sha", CommitsCatalogFixtures.projectCommitsCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommitsCatalogFixtures.commitStatus());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/statuses/sha");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"state\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().create("group/sub/project", "sha", CommitsCatalogFixtures.projectCommitsCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabCommit.class, "commit.json") + "]"));

        final GitLabPage<GitLabCommit> page = api().list("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.commit());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabCommit.class, "commit.json") + "]"));

        final GitLabPage<GitLabCommit> page = api().list(
                        "group/sub/project",
                        GitLabProjectCommitsListFilterBuilder.builder()
                                .refName("ref_name")
                                .since(Instant.parse("2026-01-01T00:00:00Z"))
                                .until(Instant.parse("2026-01-01T00:00:00Z"))
                                .path("path")
                                .follow(true)
                                .author("author")
                                .all(true)
                                .withStats(true)
                                .firstParent(true)
                                .order(GitLabProjectCommitsListOrder.DEFAULT)
                                .trailers(true)
                                .pageToken("page_token")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.commit());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits");
            softly.assertThat(request.uri()).hasParameter("ref_name", "ref_name");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabCommit.class, "commit.json") + "]"));

        final GitLabPage<GitLabCommit> page = api().list("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.commit());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabCommit.class, "commit.json") + "]"));

        final GitLabPage<GitLabCommit> page = api().list(
                        "group/sub/project",
                        GitLabProjectCommitsListFilterBuilder.builder()
                                .refName("ref_name")
                                .since(Instant.parse("2026-01-01T00:00:00Z"))
                                .until(Instant.parse("2026-01-01T00:00:00Z"))
                                .path("path")
                                .follow(true)
                                .author("author")
                                .all(true)
                                .withStats(true)
                                .firstParent(true)
                                .order(GitLabProjectCommitsListOrder.DEFAULT)
                                .trailers(true)
                                .pageToken("page_token")
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.commit());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("ref_name", "ref_name");
        });
    }

    @Test
    void createCommits_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCommitDetail.class, "commit-detail.json")));

        final GitLabCommitDetail result = api().createCommits(
                        "group/sub/project",
                        MultipartFormData.builder().text("field", "value").build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.commitDetail());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/repository/commits");
        });
    }

    @Test
    void createCommits_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createCommits(
                        "group/sub/project",
                        MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCommitDetail.class, "commit-detail.json")));

        final Optional<GitLabCommitDetail> result = api().get("group/sub/project", "sha");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.commitDetail());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabCommitDetail> result = api().get("group/sub/project", "sha");

        assertThat(result).isEmpty();
    }

    @Test
    void get_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCommitDetail.class, "commit-detail.json")));

        api().get(
                        "group/sub/project",
                        "sha",
                        GitLabProjectCommitsGetFilterBuilder.builder()
                                .stats(true)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("stats", "true");
    }

    @Test
    void listDiff_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabDiff.class, "diff.json") + "]"));

        final GitLabPage<GitLabDiff> page = api().listDiff("group/sub/project", "sha");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.diff());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/diff");
        });
    }

    @Test
    void listDiff_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabDiff.class, "diff.json") + "]"));

        final GitLabPage<GitLabDiff> page = api().listDiff(
                        "group/sub/project",
                        "sha",
                        GitLabProjectCommitsListDiffFilterBuilder.builder()
                                .unidiff(true)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.diff());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/diff");
            softly.assertThat(request.uri()).hasParameter("unidiff", "true");
        });
    }

    @Test
    void listDiff_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabDiff.class, "diff.json") + "]"));

        final GitLabPage<GitLabDiff> page = api().listDiff("group/sub/project", "sha", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.diff());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/diff");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listDiff_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabDiff.class, "diff.json") + "]"));

        final GitLabPage<GitLabDiff> page = api().listDiff(
                        "group/sub/project",
                        "sha",
                        GitLabProjectCommitsListDiffFilterBuilder.builder()
                                .unidiff(true)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.diff());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/diff");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("unidiff", "true");
        });
    }

    @Test
    void listComments_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabCommitNote.class, "commit-note.json") + "]"));

        final GitLabPage<GitLabCommitNote> page = api().listComments("group/sub/project", "sha");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommitsCatalogFixtures.commitNote());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/comments");
        });
    }

    @Test
    void listComments_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabCommitNote.class, "commit-note.json") + "]"));

        final GitLabPage<GitLabCommitNote> page =
                api().listComments("group/sub/project", "sha", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommitsCatalogFixtures.commitNote());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/comments");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createComment_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCommitNote.class, "commit-note.json")));

        final GitLabCommitNote result = api().createComment(
                        "group/sub/project", "sha", CommitsCatalogFixtures.projectCommitsCreateCommentPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommitsCatalogFixtures.commitNote());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/comments");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"note\":");
        });
    }

    @Test
    void createComment_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createComment(
                        "group/sub/project", "sha", CommitsCatalogFixtures.projectCommitsCreateCommentPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getSequence_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCommitSequence.class, "commit-sequence.json")));

        final Optional<GitLabCommitSequence> result = api().getSequence("group/sub/project", "sha");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommitsCatalogFixtures.commitSequence());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/sequence");
        });
    }

    @Test
    void getSequence_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabCommitSequence> result = api().getSequence("group/sub/project", "sha");

        assertThat(result).isEmpty();
    }

    @Test
    void getSequence_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCommitSequence.class, "commit-sequence.json")));

        api().getSequence(
                        "group/sub/project",
                        "sha",
                        GitLabProjectCommitsGetSequenceFilterBuilder.builder()
                                .firstParent(true)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("first_parent", "true");
    }

    @Test
    void cherryPick_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCommit.class, "commit.json")));

        final GitLabCommit result =
                api().cherryPick("group/sub/project", "sha", CommitsCatalogFixtures.projectCommitsCherryPickPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.commit());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/cherry_pick");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"branch\":");
        });
    }

    @Test
    void cherryPick_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().cherryPick("group/sub/project", "sha", CommitsCatalogFixtures.projectCommitsCherryPickPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void revert_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCommit.class, "commit.json")));

        final GitLabCommit result =
                api().revert("group/sub/project", "sha", CommitsCatalogFixtures.projectCommitsRevertPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.commit());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/revert");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"branch\":");
        });
    }

    @Test
    void revert_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().revert("group/sub/project", "sha", CommitsCatalogFixtures.projectCommitsRevertPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listRefs_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabBasicRef.class, "basic-ref.json") + "]"));

        final GitLabPage<GitLabBasicRef> page = api().listRefs("group/sub/project", "sha");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommitsCatalogFixtures.basicRef());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/refs");
        });
    }

    @Test
    void listRefs_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabBasicRef.class, "basic-ref.json") + "]"));

        final GitLabPage<GitLabBasicRef> page = api().listRefs(
                        "group/sub/project",
                        "sha",
                        GitLabProjectCommitsListRefsFilterBuilder.builder()
                                .type(GitLabProjectCommitsListRefsType.BRANCH)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommitsCatalogFixtures.basicRef());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/refs");
            softly.assertThat(request.uri()).hasParameter("type", "branch");
        });
    }

    @Test
    void listRefs_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabBasicRef.class, "basic-ref.json") + "]"));

        final GitLabPage<GitLabBasicRef> page = api().listRefs("group/sub/project", "sha", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommitsCatalogFixtures.basicRef());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/refs");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listRefs_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabBasicRef.class, "basic-ref.json") + "]"));

        final GitLabPage<GitLabBasicRef> page = api().listRefs(
                        "group/sub/project",
                        "sha",
                        GitLabProjectCommitsListRefsFilterBuilder.builder()
                                .type(GitLabProjectCommitsListRefsType.BRANCH)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommitsCatalogFixtures.basicRef());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/refs");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("type", "branch");
        });
    }

    @Test
    void listMergeRequests_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabMergeRequestBasic.class, "merge-request-basic.json") + "]"));

        final GitLabPage<GitLabMergeRequestBasic> page = api().listMergeRequests("group/sub/project", "sha");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.mergeRequestBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/merge_requests");
        });
    }

    @Test
    void listMergeRequests_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabMergeRequestBasic.class, "merge-request-basic.json") + "]"));

        final GitLabPage<GitLabMergeRequestBasic> page = api().listMergeRequests(
                        "group/sub/project",
                        "sha",
                        GitLabProjectCommitsListMergeRequestsFilterBuilder.builder()
                                .state("state")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.mergeRequestBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/merge_requests");
            softly.assertThat(request.uri()).hasParameter("state", "state");
        });
    }

    @Test
    void listMergeRequests_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabMergeRequestBasic.class, "merge-request-basic.json") + "]"));

        final GitLabPage<GitLabMergeRequestBasic> page =
                api().listMergeRequests("group/sub/project", "sha", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.mergeRequestBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/merge_requests");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listMergeRequests_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabMergeRequestBasic.class, "merge-request-basic.json") + "]"));

        final GitLabPage<GitLabMergeRequestBasic> page = api().listMergeRequests(
                        "group/sub/project",
                        "sha",
                        GitLabProjectCommitsListMergeRequestsFilterBuilder.builder()
                                .state("state")
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.mergeRequestBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/merge_requests");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("state", "state");
        });
    }

    @Test
    void getSignature_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCommitSignature.class, "commit-signature.json")));

        final Optional<GitLabCommitSignature> result = api().getSignature("group/sub/project", "sha");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommitsCatalogFixtures.commitSignature());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/commits/sha/signature");
        });
    }

    @Test
    void getSignature_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabCommitSignature> result = api().getSignature("group/sub/project", "sha");

        assertThat(result).isEmpty();
    }
}

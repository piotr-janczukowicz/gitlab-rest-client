package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCommit;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.time.Instant;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectRepositoriesApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectRepositoriesApi api() {
        return new GitLabProjectRepositoriesApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectRepositoriesApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void listTree_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabTreeObject.class, "tree-object.json") + "]"));

        final GitLabPage<GitLabTreeObject> page = api().listTree("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(RepositoriesCatalogFixtures.treeObject());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/tree");
        });
    }

    @Test
    void listTree_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabTreeObject.class, "tree-object.json") + "]"));

        final GitLabPage<GitLabTreeObject> page = api().listTree(
                        "group/sub/project",
                        GitLabProjectRepositoriesListTreeFilterBuilder.builder()
                                .ref("ref")
                                .path("path")
                                .recursive(true)
                                .withLastCommit(true)
                                .pageToken("page_token")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(RepositoriesCatalogFixtures.treeObject());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/tree");
            softly.assertThat(request.uri()).hasParameter("ref", "ref");
        });
    }

    @Test
    void listTree_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabTreeObject.class, "tree-object.json") + "]"));

        final GitLabPage<GitLabTreeObject> page = api().listTree("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(RepositoriesCatalogFixtures.treeObject());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/tree");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listTree_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabTreeObject.class, "tree-object.json") + "]"));

        final GitLabPage<GitLabTreeObject> page = api().listTree(
                        "group/sub/project",
                        GitLabProjectRepositoriesListTreeFilterBuilder.builder()
                                .ref("ref")
                                .path("path")
                                .recursive(true)
                                .withLastCommit(true)
                                .pageToken("page_token")
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(RepositoriesCatalogFixtures.treeObject());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/tree");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("ref", "ref");
        });
    }

    @Test
    void callBlobsRaw_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callBlobsRaw("group/sub/project", "sha");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/blobs/sha/raw");
    }

    @Test
    void callBlobsRaw_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callBlobsRaw("group/sub/project", "sha"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callBlob_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callBlob("group/sub/project", "sha");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/blobs/sha");
    }

    @Test
    void callBlob_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callBlob("group/sub/project", "sha"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callArchive_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callArchive("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/archive");
    }

    @Test
    void callArchive_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callArchive("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callArchive_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callArchive(
                        "group/sub/project",
                        GitLabProjectRepositoriesCallArchiveFilterBuilder.builder()
                                .sha("sha")
                                .refType(GitLabProjectRepositoriesCallArchiveRefType.HEADS)
                                .format("format")
                                .path("path")
                                .includeLfsBlobs(true)
                                .excludePaths(List.of("exclude_paths"))
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("sha", "sha");
    }

    @Test
    void getCompare_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCompare.class, "compare.json")));

        final GitLabCompare result = api().getCompare("group/sub/project", "from", "to");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(RepositoriesCatalogFixtures.compare());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/compare");
            softly.assertThat(request.uri()).hasParameter("from", "from");
        });
    }

    @Test
    void getCompare_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getCompare("group/sub/project", "from", "to"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getCompare_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCompare.class, "compare.json")));

        api().getCompare(
                        "group/sub/project",
                        "from",
                        "to",
                        GitLabProjectRepositoriesGetCompareFilterBuilder.builder()
                                .fromProjectId(1L)
                                .straight(true)
                                .unidiff(true)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("from_project_id", "1");
    }

    @Test
    void getHealth_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabRepositoryHealth.class, "repository-health.json")));

        final GitLabRepositoryHealth result = api().getHealth("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(RepositoriesCatalogFixtures.repositoryHealth());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/health");
        });
    }

    @Test
    void getHealth_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getHealth("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getHealth_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabRepositoryHealth.class, "repository-health.json")));

        api().getHealth(
                        "group/sub/project",
                        GitLabProjectRepositoriesGetHealthFilterBuilder.builder()
                                .generate(true)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("generate", "true");
    }

    @Test
    void listContributors_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabContributor.class, "contributor.json") + "]"));

        final GitLabPage<GitLabContributor> page = api().listContributors("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(RepositoriesCatalogFixtures.contributor());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/contributors");
        });
    }

    @Test
    void listContributors_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabContributor.class, "contributor.json") + "]"));

        final GitLabPage<GitLabContributor> page = api().listContributors(
                        "group/sub/project",
                        GitLabProjectRepositoriesListContributorsFilterBuilder.builder()
                                .ref("ref")
                                .orderBy(GitLabProjectRepositoriesListContributorsOrderBy.EMAIL)
                                .sort(GitLabProjectRepositoriesListContributorsSort.ASC)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(RepositoriesCatalogFixtures.contributor());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/contributors");
            softly.assertThat(request.uri()).hasParameter("ref", "ref");
        });
    }

    @Test
    void listContributors_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabContributor.class, "contributor.json") + "]"));

        final GitLabPage<GitLabContributor> page =
                api().listContributors("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(RepositoriesCatalogFixtures.contributor());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/contributors");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listContributors_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabContributor.class, "contributor.json") + "]"));

        final GitLabPage<GitLabContributor> page = api().listContributors(
                        "group/sub/project",
                        GitLabProjectRepositoriesListContributorsFilterBuilder.builder()
                                .ref("ref")
                                .orderBy(GitLabProjectRepositoriesListContributorsOrderBy.EMAIL)
                                .sort(GitLabProjectRepositoriesListContributorsSort.ASC)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(RepositoriesCatalogFixtures.contributor());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/contributors");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("ref", "ref");
        });
    }

    @Test
    void getMergeBase_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCommit.class, "commit.json")));

        final GitLabCommit result = api().getMergeBase("group/sub/project", List.of("refs"));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.commit());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/merge_base");
            softly.assertThat(request.uri()).hasParameter("refs", "refs");
        });
    }

    @Test
    void getMergeBase_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getMergeBase("group/sub/project", List.of("refs")));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void batchBlob_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabBatchBlob.class, "batch-blob.json") + "]"));

        final List<GitLabBatchBlob> result =
                api().batchBlob("group/sub/project", RepositoriesCatalogFixtures.projectRepositoriesBatchBlobPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(RepositoriesCatalogFixtures.batchBlob());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/repository/blobs/batch");
        });
    }

    @Test
    void listChangedPaths_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabChangedPath.class, "changed-path.json") + "]"));

        final GitLabPage<GitLabChangedPath> page = api().listChangedPaths("group/sub/project", "from", "to");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(RepositoriesCatalogFixtures.changedPath());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/changed_paths");
            softly.assertThat(request.uri()).hasParameter("from", "from");
        });
    }

    @Test
    void listChangedPaths_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabChangedPath.class, "changed-path.json") + "]"));

        final GitLabPage<GitLabChangedPath> page = api().listChangedPaths(
                        "group/sub/project",
                        "from",
                        "to",
                        GitLabProjectRepositoriesListChangedPathsFilterBuilder.builder()
                                .findRenames(true)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(RepositoriesCatalogFixtures.changedPath());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/changed_paths");
            softly.assertThat(request.uri()).hasParameter("from", "from");
            softly.assertThat(request.uri()).hasParameter("find_renames", "true");
        });
    }

    @Test
    void listChangedPaths_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabChangedPath.class, "changed-path.json") + "]"));

        final GitLabPage<GitLabChangedPath> page =
                api().listChangedPaths("group/sub/project", "from", "to", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(RepositoriesCatalogFixtures.changedPath());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/changed_paths");
            softly.assertThat(request.uri()).hasParameter("from", "from");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listChangedPaths_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabChangedPath.class, "changed-path.json") + "]"));

        final GitLabPage<GitLabChangedPath> page = api().listChangedPaths(
                        "group/sub/project",
                        "from",
                        "to",
                        GitLabProjectRepositoriesListChangedPathsFilterBuilder.builder()
                                .findRenames(true)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(RepositoriesCatalogFixtures.changedPath());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/changed_paths");
            softly.assertThat(request.uri()).hasParameter("from", "from");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("find_renames", "true");
        });
    }

    @Test
    void getDivergingCommits_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabDivergingCommitCount.class, "diverging-commit-count.json")));

        final GitLabDivergingCommitCount result = api().getDivergingCommits("group/sub/project", "from", "to");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(RepositoriesCatalogFixtures.divergingCommitCount());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/diverging_commits");
            softly.assertThat(request.uri()).hasParameter("from", "from");
        });
    }

    @Test
    void getDivergingCommits_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getDivergingCommits("group/sub/project", "from", "to"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getDivergingCommits_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabDivergingCommitCount.class, "diverging-commit-count.json")));

        api().getDivergingCommits(
                        "group/sub/project",
                        "from",
                        "to",
                        GitLabProjectRepositoriesGetDivergingCommitsFilterBuilder.builder()
                                .maxCount(1)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("max_count", "1");
    }

    @Test
    void listDiffStats_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabDiffStat.class, "diff-stat.json") + "]"));

        final GitLabPage<GitLabDiffStat> page = api().listDiffStats("group/sub/project", "from", "to");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(RepositoriesCatalogFixtures.diffStat());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/diff_stats");
            softly.assertThat(request.uri()).hasParameter("from", "from");
        });
    }

    @Test
    void listDiffStats_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabDiffStat.class, "diff-stat.json") + "]"));

        final GitLabPage<GitLabDiffStat> page =
                api().listDiffStats("group/sub/project", "from", "to", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(RepositoriesCatalogFixtures.diffStat());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/diff_stats");
            softly.assertThat(request.uri()).hasParameter("from", "from");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void getChangelog_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabChangelog.class, "changelog.json")));

        final GitLabChangelog result = api().getChangelog("group/sub/project", "1.2.3");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(RepositoriesCatalogFixtures.changelog());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/changelog");
            softly.assertThat(request.uri()).hasParameter("version", "1.2.3");
        });
    }

    @Test
    void getChangelog_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getChangelog("group/sub/project", "1.2.3"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getChangelog_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabChangelog.class, "changelog.json")));

        api().getChangelog(
                        "group/sub/project",
                        "1.2.3",
                        GitLabProjectRepositoriesGetChangelogFilterBuilder.builder()
                                .fromValue("from")
                                .to("to")
                                .date(Instant.parse("2026-01-01T00:00:00Z"))
                                .trailer("trailer")
                                .configFile("config_file")
                                .configFileRef("config_file_ref")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("from", "from");
    }

    @Test
    void createChangelog_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createChangelog(
                        "group/sub/project", RepositoriesCatalogFixtures.projectRepositoriesCreateChangelogPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/repository/changelog");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"from\":");
        });
    }

    @Test
    void createChangelog_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createChangelog(
                        "group/sub/project", RepositoriesCatalogFixtures.projectRepositoriesCreateChangelogPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}

package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCommit;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectRepositoriesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void listTree_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/tree",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabTreeObject.class, "tree-object.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/repository/tree?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabTreeObject.class, "tree-object.json") + "]"));

        final List<GitLabTreeObject> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectRepositoriesApi(GitLabCaller.of(client))
                    .listTree("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(RepositoriesCatalogFixtures.treeObject(), RepositoriesCatalogFixtures.treeObject());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/tree", 2);
    }

    @Test
    void callBlobsRaw_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/blobs/sha/raw",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectRepositoriesApi(GitLabCaller.of(client)).callBlobsRaw("group/sub/project", "sha");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/blobs/sha/raw");
    }

    @Test
    void callBlobsRaw_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/blobs/sha/raw",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectRepositoriesApi api = new GitLabProjectRepositoriesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callBlobsRaw("group/sub/project", "sha"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/blobs/sha/raw");
    }

    @Test
    void callBlob_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/blobs/sha", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectRepositoriesApi(GitLabCaller.of(client)).callBlob("group/sub/project", "sha");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/blobs/sha");
    }

    @Test
    void callBlob_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/blobs/sha", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectRepositoriesApi api = new GitLabProjectRepositoriesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callBlob("group/sub/project", "sha"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/blobs/sha");
    }

    @Test
    void callArchive_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/archive", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectRepositoriesApi(GitLabCaller.of(client)).callArchive("group/sub/project");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/archive");
    }

    @Test
    void callArchive_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/archive", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectRepositoriesApi api = new GitLabProjectRepositoriesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callArchive("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/archive");
    }

    @Test
    void getCompare_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/compare",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCompare.class, "compare.json")));

        final GitLabCompare result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectRepositoriesApi(GitLabCaller.of(client))
                    .getCompare("group/sub/project", "from", "to");
        }

        assertThat(result).isEqualTo(RepositoriesCatalogFixtures.compare());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/compare");
    }

    @Test
    void getCompare_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/compare", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectRepositoriesApi api = new GitLabProjectRepositoriesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getCompare("group/sub/project", "from", "to"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/compare");
    }

    @Test
    void getHealth_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/health",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabRepositoryHealth.class, "repository-health.json")));

        final GitLabRepositoryHealth result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectRepositoriesApi(GitLabCaller.of(client)).getHealth("group/sub/project");
        }

        assertThat(result).isEqualTo(RepositoriesCatalogFixtures.repositoryHealth());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/health");
    }

    @Test
    void getHealth_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/health", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectRepositoriesApi api = new GitLabProjectRepositoriesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getHealth("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/health");
    }

    @Test
    void listContributors_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/contributors",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabContributor.class, "contributor.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/repository/contributors?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabContributor.class, "contributor.json") + "]"));

        final List<GitLabContributor> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectRepositoriesApi(GitLabCaller.of(client))
                    .listContributors("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(RepositoriesCatalogFixtures.contributor(), RepositoriesCatalogFixtures.contributor());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/contributors", 2);
    }

    @Test
    void getMergeBase_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/merge_base",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCommit.class, "commit.json")));

        final GitLabCommit result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectRepositoriesApi(GitLabCaller.of(client))
                    .getMergeBase("group/sub/project", List.of("refs"));
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.commit());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/merge_base");
    }

    @Test
    void getMergeBase_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/merge_base", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectRepositoriesApi api = new GitLabProjectRepositoriesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getMergeBase("group/sub/project", List.of("refs")));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/merge_base");
    }

    @Test
    void batchBlob_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/blobs/batch",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabBatchBlob.class, "batch-blob.json") + "]"));

        final List<GitLabBatchBlob> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectRepositoriesApi(GitLabCaller.of(client))
                    .batchBlob("group/sub/project", RepositoriesCatalogFixtures.projectRepositoriesBatchBlobPayload());
        }

        assertThat(result).containsExactly(RepositoriesCatalogFixtures.batchBlob());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository/blobs/batch");
    }

    @Test
    void listChangedPaths_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/changed_paths",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabChangedPath.class, "changed-path.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/repository/changed_paths?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabChangedPath.class, "changed-path.json") + "]"));

        final List<GitLabChangedPath> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectRepositoriesApi(GitLabCaller.of(client))
                    .listChangedPaths("group/sub/project", "from", "to")
                    .all();
        }

        assertThat(items)
                .containsExactly(RepositoriesCatalogFixtures.changedPath(), RepositoriesCatalogFixtures.changedPath());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/changed_paths", 2);
    }

    @Test
    void getDivergingCommits_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/diverging_commits",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabDivergingCommitCount.class, "diverging-commit-count.json")));

        final GitLabDivergingCommitCount result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectRepositoriesApi(GitLabCaller.of(client))
                    .getDivergingCommits("group/sub/project", "from", "to");
        }

        assertThat(result).isEqualTo(RepositoriesCatalogFixtures.divergingCommitCount());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/diverging_commits");
    }

    @Test
    void getDivergingCommits_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/diverging_commits",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectRepositoriesApi api = new GitLabProjectRepositoriesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getDivergingCommits("group/sub/project", "from", "to"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/diverging_commits");
    }

    @Test
    void listDiffStats_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/diff_stats",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabDiffStat.class, "diff-stat.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/repository/diff_stats?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabDiffStat.class, "diff-stat.json") + "]"));

        final List<GitLabDiffStat> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectRepositoriesApi(GitLabCaller.of(client))
                    .listDiffStats("group/sub/project", "from", "to")
                    .all();
        }

        assertThat(items)
                .containsExactly(RepositoriesCatalogFixtures.diffStat(), RepositoriesCatalogFixtures.diffStat());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/diff_stats", 2);
    }

    @Test
    void getChangelog_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/changelog",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabChangelog.class, "changelog.json")));

        final GitLabChangelog result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectRepositoriesApi(GitLabCaller.of(client))
                    .getChangelog("group/sub/project", "1.2.3");
        }

        assertThat(result).isEqualTo(RepositoriesCatalogFixtures.changelog());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/changelog");
    }

    @Test
    void getChangelog_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/changelog", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectRepositoriesApi api = new GitLabProjectRepositoriesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getChangelog("group/sub/project", "1.2.3"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/changelog");
    }

    @Test
    void createChangelog_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/repository/changelog", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectRepositoriesApi(GitLabCaller.of(client))
                    .createChangelog(
                            "group/sub/project",
                            RepositoriesCatalogFixtures.projectRepositoriesCreateChangelogPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository/changelog");
    }

    @Test
    void createChangelog_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository/changelog", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectRepositoriesApi api = new GitLabProjectRepositoriesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createChangelog(
                    "group/sub/project", RepositoriesCatalogFixtures.projectRepositoriesCreateChangelogPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository/changelog");
    }
}

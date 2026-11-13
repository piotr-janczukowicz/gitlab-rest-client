package io.github.piotr_janczukowicz.gitlab.api.projectclusters;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCluster;
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
class GitLabProjectProjectClustersApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/clusters",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabCluster.class, "cluster.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/projects/group%2Fsub%2Fproject/clusters?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabCluster.class, "cluster.json") + "]"));

        final List<GitLabCluster> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectProjectClustersApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.cluster(), CommonCatalogFixtures.cluster());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/clusters", 2);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/clusters/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabClusterProject.class, "cluster-project.json")));

        final Optional<GitLabClusterProject> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectClustersApi(GitLabCaller.of(client)).get("group/sub/project", 1L);
        }

        assertThat(result).contains(ProjectclustersCatalogFixtures.clusterProject());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/clusters/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/clusters/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectProjectClustersApi(GitLabCaller.of(client))
                    .get("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/clusters/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/clusters/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabClusterProject.class, "cluster-project.json")));

        final GitLabClusterProject result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectClustersApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            1L,
                            ProjectclustersCatalogFixtures.projectProjectClustersUpdatePayload());
        }

        assertThat(result).isEqualTo(ProjectclustersCatalogFixtures.clusterProject());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/clusters/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/clusters/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectClustersApi api = new GitLabProjectProjectClustersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project", 1L, ProjectclustersCatalogFixtures.projectProjectClustersUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/clusters/1");
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/clusters/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabClusterProject.class, "cluster-project.json")));

        final Optional<GitLabClusterProject> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectClustersApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        assertThat(result).contains(ProjectclustersCatalogFixtures.clusterProject());
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/clusters/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/clusters/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectClustersApi api = new GitLabProjectProjectClustersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/clusters/1");
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/clusters/1", GitLabApiStubSupport.noContent());

        final Optional<GitLabClusterProject> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectClustersApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/clusters/1");
    }

    @Test
    void user_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/clusters/user",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabClusterProject.class, "cluster-project.json")));

        final GitLabClusterProject result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectClustersApi(GitLabCaller.of(client))
                    .user("group/sub/project", ProjectclustersCatalogFixtures.projectClusterUserCreatePayload());
        }

        assertThat(result).isEqualTo(ProjectclustersCatalogFixtures.clusterProject());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/clusters/user");
    }

    @Test
    void user_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/clusters/user", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectClustersApi api = new GitLabProjectProjectClustersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.user("group/sub/project", ProjectclustersCatalogFixtures.projectClusterUserCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/clusters/user");
    }
}

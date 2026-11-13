package io.github.piotr_janczukowicz.gitlab.api.instanceclusters;

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
class GitLabInstanceClustersApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/admin/clusters",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabCluster.class, "cluster.json") + "]"));

        final List<GitLabCluster> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabInstanceClustersApi(GitLabCaller.of(client)).list();
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.cluster());
        HTTP.verifyRequested(GET, "/api/v4/admin/clusters");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/admin/clusters/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCluster.class, "cluster.json")));

        final Optional<GitLabCluster> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabInstanceClustersApi(GitLabCaller.of(client)).get(1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.cluster());
        HTTP.verifyRequested(GET, "/api/v4/admin/clusters/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/admin/clusters/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabInstanceClustersApi(GitLabCaller.of(client))
                    .get(1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/admin/clusters/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/admin/clusters/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCluster.class, "cluster.json")));

        final GitLabCluster result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabInstanceClustersApi(GitLabCaller.of(client))
                    .update(1L, InstanceclustersCatalogFixtures.instanceClustersUpdatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.cluster());
        HTTP.verifyRequested(PUT, "/api/v4/admin/clusters/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/admin/clusters/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabInstanceClustersApi api = new GitLabInstanceClustersApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.update(1L, InstanceclustersCatalogFixtures.instanceClustersUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/admin/clusters/1");
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/admin/clusters/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCluster.class, "cluster.json")));

        final Optional<GitLabCluster> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabInstanceClustersApi(GitLabCaller.of(client)).delete(1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.cluster());
        HTTP.verifyRequested(DELETE, "/api/v4/admin/clusters/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/admin/clusters/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabInstanceClustersApi api = new GitLabInstanceClustersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/admin/clusters/1");
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/admin/clusters/1", GitLabApiStubSupport.noContent());

        final Optional<GitLabCluster> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabInstanceClustersApi(GitLabCaller.of(client)).delete(1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/admin/clusters/1");
    }

    @Test
    void add_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/admin/clusters/add",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCluster.class, "cluster.json")));

        final GitLabCluster result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabInstanceClustersApi(GitLabCaller.of(client))
                    .add(InstanceclustersCatalogFixtures.instanceClustersAddPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.cluster());
        HTTP.verifyRequested(POST, "/api/v4/admin/clusters/add");
    }

    @Test
    void add_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/admin/clusters/add", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabInstanceClustersApi api = new GitLabInstanceClustersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.add(InstanceclustersCatalogFixtures.instanceClustersAddPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/admin/clusters/add");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.geonodes;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabGeoNodeStatus;
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
class GitLabGeoNodesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/geo_nodes",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabGeoNode.class, "geo-node.json") + "]")
                        .header("Link", "<" + base + "/api/v4/geo_nodes?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabGeoNode.class, "geo-node.json") + "]"));

        final List<GitLabGeoNode> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGeoNodesApi(GitLabCaller.of(client)).list().all();
        }

        assertThat(items).containsExactly(GeonodesCatalogFixtures.geoNode(), GeonodesCatalogFixtures.geoNode());
        HTTP.verifyRequested(GET, "/api/v4/geo_nodes", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/geo_nodes",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGeoNode.class, "geo-node.json")));

        final GitLabGeoNode result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGeoNodesApi(GitLabCaller.of(client))
                    .create(GeonodesCatalogFixtures.geoNodesCreatePayload());
        }

        assertThat(result).isEqualTo(GeonodesCatalogFixtures.geoNode());
        HTTP.verifyRequested(POST, "/api/v4/geo_nodes");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/geo_nodes", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGeoNodesApi api = new GitLabGeoNodesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(GeonodesCatalogFixtures.geoNodesCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/geo_nodes");
    }

    @Test
    void listStatus_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/geo_nodes/status",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabGeoNodeStatus.class, "geo-node-status.json") + "]")
                        .header("Link", "<" + base + "/api/v4/geo_nodes/status?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabGeoNodeStatus.class, "geo-node-status.json") + "]"));

        final List<GitLabGeoNodeStatus> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGeoNodesApi(GitLabCaller.of(client)).listStatus().all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.geoNodeStatus(), CommonCatalogFixtures.geoNodeStatus());
        HTTP.verifyRequested(GET, "/api/v4/geo_nodes/status", 2);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/geo_nodes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGeoNode.class, "geo-node.json")));

        final Optional<GitLabGeoNode> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGeoNodesApi(GitLabCaller.of(client)).get(1L);
        }

        assertThat(result).contains(GeonodesCatalogFixtures.geoNode());
        HTTP.verifyRequested(GET, "/api/v4/geo_nodes/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/geo_nodes/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGeoNodesApi(GitLabCaller.of(client)).get(1L).isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/geo_nodes/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/geo_nodes/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGeoNode.class, "geo-node.json")));

        final GitLabGeoNode result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGeoNodesApi(GitLabCaller.of(client))
                    .update(1L, GeonodesCatalogFixtures.geoNodesUpdatePayload());
        }

        assertThat(result).isEqualTo(GeonodesCatalogFixtures.geoNode());
        HTTP.verifyRequested(PUT, "/api/v4/geo_nodes/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/geo_nodes/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGeoNodesApi api = new GitLabGeoNodesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(1L, GeonodesCatalogFixtures.geoNodesUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/geo_nodes/1");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/geo_nodes/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGeoNodesApi(GitLabCaller.of(client)).delete(1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/geo_nodes/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/geo_nodes/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGeoNodesApi api = new GitLabGeoNodesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/geo_nodes/1");
    }

    @Test
    void getStatus_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/geo_nodes/1/status",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGeoNodeStatus.class, "geo-node-status.json")));

        final Optional<GitLabGeoNodeStatus> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGeoNodesApi(GitLabCaller.of(client)).getStatus(1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.geoNodeStatus());
        HTTP.verifyRequested(GET, "/api/v4/geo_nodes/1/status");
    }

    @Test
    void getStatus_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/geo_nodes/1/status", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGeoNodesApi(GitLabCaller.of(client)).getStatus(1L).isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/geo_nodes/1/status");
    }

    @Test
    void repair_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/geo_nodes/1/repair",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGeoNodeStatus.class, "geo-node-status.json")));

        final GitLabGeoNodeStatus result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGeoNodesApi(GitLabCaller.of(client)).repair(1L);
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.geoNodeStatus());
        HTTP.verifyRequested(POST, "/api/v4/geo_nodes/1/repair");
    }

    @Test
    void repair_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/geo_nodes/1/repair", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGeoNodesApi api = new GitLabGeoNodesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.repair(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/geo_nodes/1/repair");
    }
}

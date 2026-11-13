package io.github.piotr_janczukowicz.gitlab.api.geo;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabGeoApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void callProxy_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/geo/proxy", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGeoApi(GitLabCaller.of(client)).callProxy();
        }

        HTTP.verifyRequested(GET, "/api/v4/geo/proxy");
    }

    @Test
    void callProxy_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/geo/proxy", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGeoApi api = new GitLabGeoApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callProxy());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/geo/proxy");
    }

    @Test
    void call_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/geo/retrieve/replicable_name/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGeoApi(GitLabCaller.of(client)).call("replicable_name", 1L);
        }

        HTTP.verifyRequested(GET, "/api/v4/geo/retrieve/replicable_name/1");
    }

    @Test
    void call_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/geo/retrieve/replicable_name/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGeoApi api = new GitLabGeoApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.call("replicable_name", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/geo/retrieve/replicable_name/1");
    }

    @Test
    void listPipelineRefs_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/geo/repositories/gl_repository/pipeline_refs",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabGeoPipelineRefs.class, "geo-pipeline-refs.json") + "]"));

        final List<GitLabGeoPipelineRefs> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGeoApi(GitLabCaller.of(client)).listPipelineRefs("gl_repository");
        }

        assertThat(result).containsExactly(GeoCatalogFixtures.geoPipelineRefs());
        HTTP.verifyRequested(GET, "/api/v4/geo/repositories/gl_repository/pipeline_refs");
    }

    @Test
    void createStatus_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/geo/status",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGeoNodeStatus.class, "geo-node-status.json")));

        final GitLabGeoNodeStatus result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result =
                    new GitLabGeoApi(GitLabCaller.of(client)).createStatus(GeoCatalogFixtures.geoCreateStatusPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.geoNodeStatus());
        HTTP.verifyRequested(POST, "/api/v4/geo/status");
    }

    @Test
    void createStatus_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/geo/status", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGeoApi api = new GitLabGeoApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createStatus(GeoCatalogFixtures.geoCreateStatusPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/geo/status");
    }

    @Test
    void createFailures_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/geo/failures", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGeoApi(GitLabCaller.of(client)).createFailures(GeoCatalogFixtures.geoCreateFailuresPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/geo/failures");
    }

    @Test
    void createFailures_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/geo/failures", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGeoApi api = new GitLabGeoApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createFailures(GeoCatalogFixtures.geoCreateFailuresPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/geo/failures");
    }

    @Test
    void infoRefsUploadPack_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/geo/proxy_git_ssh/info_refs_upload_pack", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGeoApi(GitLabCaller.of(client))
                    .infoRefsUploadPack(GeoCatalogFixtures.geoInfoRefsUploadPackPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/geo/proxy_git_ssh/info_refs_upload_pack");
    }

    @Test
    void infoRefsUploadPack_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/geo/proxy_git_ssh/info_refs_upload_pack", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGeoApi api = new GitLabGeoApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.infoRefsUploadPack(GeoCatalogFixtures.geoInfoRefsUploadPackPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/geo/proxy_git_ssh/info_refs_upload_pack");
    }

    @Test
    void uploadPack_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/geo/proxy_git_ssh/upload_pack", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGeoApi(GitLabCaller.of(client)).uploadPack(GeoCatalogFixtures.geoUploadPackPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/geo/proxy_git_ssh/upload_pack");
    }

    @Test
    void uploadPack_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/geo/proxy_git_ssh/upload_pack", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGeoApi api = new GitLabGeoApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.uploadPack(GeoCatalogFixtures.geoUploadPackPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/geo/proxy_git_ssh/upload_pack");
    }

    @Test
    void infoRefsReceivePack_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/geo/proxy_git_ssh/info_refs_receive_pack", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGeoApi(GitLabCaller.of(client))
                    .infoRefsReceivePack(GeoCatalogFixtures.geoInfoRefsReceivePackPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/geo/proxy_git_ssh/info_refs_receive_pack");
    }

    @Test
    void infoRefsReceivePack_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/geo/proxy_git_ssh/info_refs_receive_pack", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGeoApi api = new GitLabGeoApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.infoRefsReceivePack(GeoCatalogFixtures.geoInfoRefsReceivePackPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/geo/proxy_git_ssh/info_refs_receive_pack");
    }

    @Test
    void receivePack_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/geo/proxy_git_ssh/receive_pack", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGeoApi(GitLabCaller.of(client)).receivePack(GeoCatalogFixtures.geoReceivePackPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/geo/proxy_git_ssh/receive_pack");
    }

    @Test
    void receivePack_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/geo/proxy_git_ssh/receive_pack", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGeoApi api = new GitLabGeoApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.receivePack(GeoCatalogFixtures.geoReceivePackPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/geo/proxy_git_ssh/receive_pack");
    }

    @Test
    void graphql_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/geo/node_proxy/1/graphql", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGeoApi(GitLabCaller.of(client)).graphql(1L);
        }

        HTTP.verifyRequested(POST, "/api/v4/geo/node_proxy/1/graphql");
    }

    @Test
    void graphql_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/geo/node_proxy/1/graphql", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGeoApi api = new GitLabGeoApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.graphql(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/geo/node_proxy/1/graphql");
    }
}

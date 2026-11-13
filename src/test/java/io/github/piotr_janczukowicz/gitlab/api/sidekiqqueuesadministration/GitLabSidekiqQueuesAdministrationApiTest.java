package io.github.piotr_janczukowicz.gitlab.api.sidekiqqueuesadministration;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSidekiqQueuesAdministrationApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabSidekiqQueuesAdministrationApi api() {
        return new GitLabSidekiqQueuesAdministrationApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabSidekiqQueuesAdministrationApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete("queue_name");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/admin/sidekiq/queues/queue_name");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete("queue_name"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete(
                        "queue_name",
                        GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder()
                                .organizationId("organization_id")
                                .user("user")
                                .userId("user_id")
                                .glUserId("gl_user_id")
                                .scopedUser("scoped_user")
                                .scopedUserId("scoped_user_id")
                                .project("project")
                                .rootNamespace("root_namespace")
                                .glRootNamespaceId("gl_root_namespace_id")
                                .clientId("client_id")
                                .callerId("caller_id")
                                .remoteIp("remote_ip")
                                .jobId("job_id")
                                .pipelineId("pipeline_id")
                                .relatedClass("related_class")
                                .featureCategory("feature_category")
                                .artifactSize("artifact_size")
                                .artifactUsedCdn("artifact_used_cdn")
                                .artifactsDependenciesSize("artifacts_dependencies_size")
                                .artifactsDependenciesCount("artifacts_dependencies_count")
                                .rootCallerId("root_caller_id")
                                .mergeActionStatus("merge_action_status")
                                .bulkImportEntityId("bulk_import_entity_id")
                                .sidekiqDestinationShardRedis("sidekiq_destination_shard_redis")
                                .kubernetesAgentId("kubernetes_agent_id")
                                .mvccManifest("mvcc_manifest")
                                .clientType("client_type")
                                .clientName("client_name")
                                .clientVersion("client_version")
                                .subscriptionPlan("subscription_plan")
                                .aiResource("ai_resource")
                                .workerClass("worker_class")
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("organization_id", "organization_id");
    }
}

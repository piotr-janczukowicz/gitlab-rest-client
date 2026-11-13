package io.github.piotr_janczukowicz.gitlab.api.sidekiqqueuesadministration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSidekiqQueuesAdministrationDeleteFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenOrganizationIdIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .organizationId(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.organizationId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .user(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .userId(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlUserIdIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .glUserId(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.glUserId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopedUserIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .scopedUser(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.scopedUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopedUserIdIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .scopedUserId(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.scopedUserId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .project(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.project()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRootNamespaceIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .rootNamespace(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.rootNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlRootNamespaceIdIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .glRootNamespaceId(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.glRootNamespaceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClientIdIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .clientId(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.clientId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCallerIdIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .callerId(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.callerId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRemoteIpIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .remoteIp(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.remoteIp()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobIdIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .jobId(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.jobId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineIdIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .pipelineId(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.pipelineId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRelatedClassIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .relatedClass(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.relatedClass()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFeatureCategoryIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .featureCategory(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.featureCategory()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArtifactSizeIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .artifactSize(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.artifactSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArtifactUsedCdnIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .artifactUsedCdn(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.artifactUsedCdn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArtifactsDependenciesSizeIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .artifactsDependenciesSize(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.artifactsDependenciesSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArtifactsDependenciesCountIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .artifactsDependenciesCount(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.artifactsDependenciesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRootCallerIdIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .rootCallerId(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.rootCallerId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeActionStatusIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .mergeActionStatus(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.mergeActionStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBulkImportEntityIdIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .bulkImportEntityId(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.bulkImportEntityId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSidekiqDestinationShardRedisIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .sidekiqDestinationShardRedis(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.sidekiqDestinationShardRedis()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKubernetesAgentIdIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .kubernetesAgentId(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.kubernetesAgentId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMvccManifestIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .mvccManifest(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.mvccManifest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClientTypeIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .clientType(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.clientType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClientNameIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .clientName(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.clientName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClientVersionIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .clientVersion(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.clientVersion()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubscriptionPlanIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .subscriptionPlan(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.subscriptionPlan()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiResourceIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .aiResource(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.aiResource()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkerClassIsNullable() {
        final GitLabSidekiqQueuesAdministrationDeleteFilterBuilder builder =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(
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
                                        .build())
                        .workerClass(null);

        final GitLabSidekiqQueuesAdministrationDeleteFilter built = builder.build();

        assertThat(built.workerClass()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSidekiqQueuesAdministrationDeleteFilter value =
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
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.organizationId()).isEqualTo("organization_id");
            softly.assertThat(value.user()).isEqualTo("user");
            softly.assertThat(value.userId()).isEqualTo("user_id");
            softly.assertThat(value.glUserId()).isEqualTo("gl_user_id");
            softly.assertThat(value.scopedUser()).isEqualTo("scoped_user");
            softly.assertThat(value.scopedUserId()).isEqualTo("scoped_user_id");
            softly.assertThat(value.project()).isEqualTo("project");
            softly.assertThat(value.rootNamespace()).isEqualTo("root_namespace");
            softly.assertThat(value.glRootNamespaceId()).isEqualTo("gl_root_namespace_id");
            softly.assertThat(value.clientId()).isEqualTo("client_id");
            softly.assertThat(value.callerId()).isEqualTo("caller_id");
            softly.assertThat(value.remoteIp()).isEqualTo("remote_ip");
            softly.assertThat(value.jobId()).isEqualTo("job_id");
            softly.assertThat(value.pipelineId()).isEqualTo("pipeline_id");
            softly.assertThat(value.relatedClass()).isEqualTo("related_class");
            softly.assertThat(value.featureCategory()).isEqualTo("feature_category");
            softly.assertThat(value.artifactSize()).isEqualTo("artifact_size");
            softly.assertThat(value.artifactUsedCdn()).isEqualTo("artifact_used_cdn");
            softly.assertThat(value.artifactsDependenciesSize()).isEqualTo("artifacts_dependencies_size");
            softly.assertThat(value.artifactsDependenciesCount()).isEqualTo("artifacts_dependencies_count");
            softly.assertThat(value.rootCallerId()).isEqualTo("root_caller_id");
            softly.assertThat(value.mergeActionStatus()).isEqualTo("merge_action_status");
            softly.assertThat(value.bulkImportEntityId()).isEqualTo("bulk_import_entity_id");
            softly.assertThat(value.sidekiqDestinationShardRedis()).isEqualTo("sidekiq_destination_shard_redis");
            softly.assertThat(value.kubernetesAgentId()).isEqualTo("kubernetes_agent_id");
            softly.assertThat(value.mvccManifest()).isEqualTo("mvcc_manifest");
            softly.assertThat(value.clientType()).isEqualTo("client_type");
            softly.assertThat(value.clientName()).isEqualTo("client_name");
            softly.assertThat(value.clientVersion()).isEqualTo("client_version");
            softly.assertThat(value.subscriptionPlan()).isEqualTo("subscription_plan");
            softly.assertThat(value.aiResource()).isEqualTo("ai_resource");
            softly.assertThat(value.workerClass()).isEqualTo("worker_class");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSidekiqQueuesAdministrationDeleteFilter original =
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
                        .build();

        final GitLabSidekiqQueuesAdministrationDeleteFilter rebuilt =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSidekiqQueuesAdministrationDeleteFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "organizationId",
                        "user",
                        "userId",
                        "glUserId",
                        "scopedUser",
                        "scopedUserId",
                        "project",
                        "rootNamespace",
                        "glRootNamespaceId",
                        "clientId",
                        "callerId",
                        "remoteIp",
                        "jobId",
                        "pipelineId",
                        "relatedClass",
                        "featureCategory",
                        "artifactSize",
                        "artifactUsedCdn",
                        "artifactsDependenciesSize",
                        "artifactsDependenciesCount",
                        "rootCallerId",
                        "mergeActionStatus",
                        "bulkImportEntityId",
                        "sidekiqDestinationShardRedis",
                        "kubernetesAgentId",
                        "mvccManifest",
                        "clientType",
                        "clientName",
                        "clientVersion",
                        "subscriptionPlan",
                        "aiResource",
                        "workerClass");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabSidekiqQueuesAdministrationDeleteFilter empty =
                GitLabSidekiqQueuesAdministrationDeleteFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabSidekiqQueuesAdministrationDeleteFilter filter =
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
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("organization_id", "organization_id"),
                        Map.entry("user", "user"),
                        Map.entry("user_id", "user_id"),
                        Map.entry("gl_user_id", "gl_user_id"),
                        Map.entry("scoped_user", "scoped_user"),
                        Map.entry("scoped_user_id", "scoped_user_id"),
                        Map.entry("project", "project"),
                        Map.entry("root_namespace", "root_namespace"),
                        Map.entry("gl_root_namespace_id", "gl_root_namespace_id"),
                        Map.entry("client_id", "client_id"),
                        Map.entry("caller_id", "caller_id"),
                        Map.entry("remote_ip", "remote_ip"),
                        Map.entry("job_id", "job_id"),
                        Map.entry("pipeline_id", "pipeline_id"),
                        Map.entry("related_class", "related_class"),
                        Map.entry("feature_category", "feature_category"),
                        Map.entry("artifact_size", "artifact_size"),
                        Map.entry("artifact_used_cdn", "artifact_used_cdn"),
                        Map.entry("artifacts_dependencies_size", "artifacts_dependencies_size"),
                        Map.entry("artifacts_dependencies_count", "artifacts_dependencies_count"),
                        Map.entry("root_caller_id", "root_caller_id"),
                        Map.entry("merge_action_status", "merge_action_status"),
                        Map.entry("bulk_import_entity_id", "bulk_import_entity_id"),
                        Map.entry("sidekiq_destination_shard_redis", "sidekiq_destination_shard_redis"),
                        Map.entry("kubernetes_agent_id", "kubernetes_agent_id"),
                        Map.entry("mvcc_manifest", "mvcc_manifest"),
                        Map.entry("client_type", "client_type"),
                        Map.entry("client_name", "client_name"),
                        Map.entry("client_version", "client_version"),
                        Map.entry("subscription_plan", "subscription_plan"),
                        Map.entry("ai_resource", "ai_resource"),
                        Map.entry("worker_class", "worker_class"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabSidekiqQueuesAdministrationDeleteFilter filter =
                GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder()
                        .organizationId("organization_id")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("organization_id", "organization_id"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabSidekiqQueuesAdministrationDeleteFilter filter =
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
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

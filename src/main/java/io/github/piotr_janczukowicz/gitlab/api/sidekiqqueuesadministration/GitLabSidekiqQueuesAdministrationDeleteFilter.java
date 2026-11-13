package io.github.piotr_janczukowicz.gitlab.api.sidekiqqueuesadministration;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code deleteApiV4AdminSidekiqQueuesQueueName}, without paging.
 *
 * @param organizationId the organization id
 * @param user the user
 * @param userId the user id
 * @param glUserId the gl user id
 * @param scopedUser the scoped user
 * @param scopedUserId the scoped user id
 * @param project the project
 * @param rootNamespace the root namespace
 * @param glRootNamespaceId the gl root namespace id
 * @param clientId the client id
 * @param callerId the caller id
 * @param remoteIp the remote ip
 * @param jobId the job id
 * @param pipelineId the pipeline id
 * @param relatedClass the related class
 * @param featureCategory the feature category
 * @param artifactSize the artifact size
 * @param artifactUsedCdn the artifact used cdn
 * @param artifactsDependenciesSize the artifacts dependencies size
 * @param artifactsDependenciesCount the artifacts dependencies count
 * @param rootCallerId the root caller id
 * @param mergeActionStatus the merge action status
 * @param bulkImportEntityId the bulk import entity id
 * @param sidekiqDestinationShardRedis the sidekiq destination shard redis
 * @param kubernetesAgentId the kubernetes agent id
 * @param mvccManifest the mvcc manifest
 * @param clientType the client type
 * @param clientName the client name
 * @param clientVersion the client version
 * @param subscriptionPlan the subscription plan
 * @param aiResource the ai resource
 * @param workerClass the worker class
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/deleteApiV4AdminSidekiqQueuesQueueName/parameters")
public record GitLabSidekiqQueuesAdministrationDeleteFilter(
        @Nullable String organizationId,
        @Nullable String user,
        @Nullable String userId,
        @Nullable String glUserId,
        @Nullable String scopedUser,
        @Nullable String scopedUserId,
        @Nullable String project,
        @Nullable String rootNamespace,
        @Nullable String glRootNamespaceId,
        @Nullable String clientId,
        @Nullable String callerId,
        @Nullable String remoteIp,
        @Nullable String jobId,
        @Nullable String pipelineId,
        @Nullable String relatedClass,
        @Nullable String featureCategory,
        @Nullable String artifactSize,
        @Nullable String artifactUsedCdn,
        @Nullable String artifactsDependenciesSize,
        @Nullable String artifactsDependenciesCount,
        @Nullable String rootCallerId,
        @Nullable String mergeActionStatus,
        @Nullable String bulkImportEntityId,
        @Nullable String sidekiqDestinationShardRedis,
        @Nullable String kubernetesAgentId,
        @Nullable String mvccManifest,
        @Nullable String clientType,
        @Nullable String clientName,
        @Nullable String clientVersion,
        @Nullable String subscriptionPlan,
        @Nullable String aiResource,
        @Nullable String workerClass) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabSidekiqQueuesAdministrationDeleteFilter empty() {
        return GitLabSidekiqQueuesAdministrationDeleteFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("organization_id", organizationId)
                .text("user", user)
                .text("user_id", userId)
                .text("gl_user_id", glUserId)
                .text("scoped_user", scopedUser)
                .text("scoped_user_id", scopedUserId)
                .text("project", project)
                .text("root_namespace", rootNamespace)
                .text("gl_root_namespace_id", glRootNamespaceId)
                .text("client_id", clientId)
                .text("caller_id", callerId)
                .text("remote_ip", remoteIp)
                .text("job_id", jobId)
                .text("pipeline_id", pipelineId)
                .text("related_class", relatedClass)
                .text("feature_category", featureCategory)
                .text("artifact_size", artifactSize)
                .text("artifact_used_cdn", artifactUsedCdn)
                .text("artifacts_dependencies_size", artifactsDependenciesSize)
                .text("artifacts_dependencies_count", artifactsDependenciesCount)
                .text("root_caller_id", rootCallerId)
                .text("merge_action_status", mergeActionStatus)
                .text("bulk_import_entity_id", bulkImportEntityId)
                .text("sidekiq_destination_shard_redis", sidekiqDestinationShardRedis)
                .text("kubernetes_agent_id", kubernetesAgentId)
                .text("mvcc_manifest", mvccManifest)
                .text("client_type", clientType)
                .text("client_name", clientName)
                .text("client_version", clientVersion)
                .text("subscription_plan", subscriptionPlan)
                .text("ai_resource", aiResource)
                .text("worker_class", workerClass)
                .build();
    }
}

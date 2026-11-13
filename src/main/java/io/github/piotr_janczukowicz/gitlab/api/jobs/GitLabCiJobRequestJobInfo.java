package io.github.piotr_janczukowicz.gitlab.api.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci job request job info.
 *
 * @param id the id
 * @param name the name
 * @param stage the stage
 * @param tagList the tag list
 * @param pipelineId the pipeline id
 * @param projectId the project id
 * @param projectName the project name
 * @param projectFullPath the project full path
 * @param namespaceId the namespace id
 * @param rootNamespaceId the root namespace id
 * @param organizationId the organization id
 * @param instanceId the instance id
 * @param instanceUuid the instance uuid
 * @param userId the user id
 * @param scopedUserId the scoped user id
 * @param timeInQueueSeconds the time in queue seconds
 * @param projectJobsRunningOnInstanceRunnersCount the project jobs running on instance runners count
 * @param queueSize the queue size
 * @param queueDepth the queue depth
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiJobRequestJobInfo")
public record GitLabCiJobRequestJobInfo(
        @Nullable String id,
        @Nullable String name,
        @Nullable String stage,
        @Nullable List<String> tagList,
        @Nullable String pipelineId,
        @Nullable String projectId,
        @Nullable String projectName,
        @Nullable String projectFullPath,
        @Nullable String namespaceId,
        @Nullable String rootNamespaceId,
        @Nullable String organizationId,
        @Nullable String instanceId,
        @Nullable String instanceUuid,
        @Nullable String userId,
        @Nullable String scopedUserId,
        @Nullable String timeInQueueSeconds,
        @Nullable String projectJobsRunningOnInstanceRunnersCount,
        @Nullable String queueSize,
        @Nullable String queueDepth) {}

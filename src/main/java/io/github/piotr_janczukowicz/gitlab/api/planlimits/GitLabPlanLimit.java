package io.github.piotr_janczukowicz.gitlab.api.planlimits;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab plan limit.
 *
 * @param cargoMaxFileSize the cargo max file size
 * @param ciInstanceLevelVariables the ci instance level variables
 * @param ciPipelineSize the ci pipeline size
 * @param ciPipelineVariablesCount the ci pipeline variables count
 * @param ciVariableValueSize the ci variable value size
 * @param ciVariableFileValueSize the ci variable file value size
 * @param ciActiveJobs the ci active jobs
 * @param ciProjectSubscriptions the ci project subscriptions
 * @param ciPipelineSchedules the ci pipeline schedules
 * @param ciNeedsSizeLimit the ci needs size limit
 * @param ciJobVariablesCount the ci job variables count
 * @param ciRegisteredGroupRunners the ci registered group runners
 * @param ciRegisteredProjectRunners the ci registered project runners
 * @param conanMaxFileSize the conan max file size
 * @param dotenvVariables the dotenv variables
 * @param dotenvSize the dotenv size
 * @param draftNotesPerMergeRequest the draft notes per merge request
 * @param enforcementLimit the enforcement limit
 * @param genericPackagesMaxFileSize the generic packages max file size
 * @param helmMaxFileSize the helm max file size
 * @param limitsHistory the limits history
 * @param mavenMaxFileSize the maven max file size
 * @param notificationLimit the notification limit
 * @param npmMaxFileSize the npm max file size
 * @param nugetMaxFileSize the nuget max file size
 * @param organizationHooks the organization hooks
 * @param pipelineHierarchySize the pipeline hierarchy size
 * @param pypiMaxFileSize the pypi max file size
 * @param serviceDeskOutboundEmailsPerHour the service desk outbound emails per hour
 * @param serviceDeskOutboundEmailsPerDay the service desk outbound emails per day
 * @param swiftMaxFileSize the swift max file size
 * @param terraformModuleMaxFileSize the terraform module max file size
 * @param storageSizeLimit the storage size limit
 * @param webHookCalls the web hook calls
 * @param webHookCallsLow the web hook calls low
 * @param webHookCallsMid the web hook calls mid
 * @param integrationExecutions the integration executions
 * @param integrationExecutionsDatadog the integration executions datadog
 * @param maxPipelinesPerMergeTrain the max pipelines per merge train
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesPlanLimit")
public record GitLabPlanLimit(
        @Nullable Long cargoMaxFileSize,
        @Nullable Integer ciInstanceLevelVariables,
        @Nullable Long ciPipelineSize,
        @Nullable Integer ciPipelineVariablesCount,
        @Nullable Long ciVariableValueSize,
        @Nullable Long ciVariableFileValueSize,
        @Nullable Integer ciActiveJobs,
        @Nullable Integer ciProjectSubscriptions,
        @Nullable Integer ciPipelineSchedules,
        @Nullable Integer ciNeedsSizeLimit,
        @Nullable Integer ciJobVariablesCount,
        @Nullable Integer ciRegisteredGroupRunners,
        @Nullable Integer ciRegisteredProjectRunners,
        @Nullable Long conanMaxFileSize,
        @Nullable Integer dotenvVariables,
        @Nullable Long dotenvSize,
        @Nullable Integer draftNotesPerMergeRequest,
        @Nullable Integer enforcementLimit,
        @Nullable Long genericPackagesMaxFileSize,
        @Nullable Long helmMaxFileSize,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> limitsHistory,

        @Nullable Long mavenMaxFileSize,
        @Nullable Integer notificationLimit,
        @Nullable Long npmMaxFileSize,
        @Nullable Long nugetMaxFileSize,
        @Nullable Integer organizationHooks,
        @Nullable Long pipelineHierarchySize,
        @Nullable Long pypiMaxFileSize,
        @Nullable Integer serviceDeskOutboundEmailsPerHour,
        @Nullable Integer serviceDeskOutboundEmailsPerDay,
        @Nullable Long swiftMaxFileSize,
        @Nullable Long terraformModuleMaxFileSize,
        @Nullable Integer storageSizeLimit,
        @Nullable Integer webHookCalls,
        @Nullable Integer webHookCallsLow,
        @Nullable Integer webHookCallsMid,
        @Nullable Integer integrationExecutions,
        @Nullable Integer integrationExecutionsDatadog,
        @Nullable Integer maxPipelinesPerMergeTrain) {}

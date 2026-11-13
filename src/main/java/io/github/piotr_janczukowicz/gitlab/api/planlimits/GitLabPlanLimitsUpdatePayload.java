package io.github.piotr_janczukowicz.gitlab.api.planlimits;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ApplicationPlanLimits}.
 *
 * @param planName the plan name
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
 * @param dotenvSize the dotenv size
 * @param dotenvVariables the dotenv variables
 * @param draftNotesPerMergeRequest the draft notes per merge request
 * @param enforcementLimit the enforcement limit
 * @param genericPackagesMaxFileSize the generic packages max file size
 * @param helmMaxFileSize the helm max file size
 * @param mavenMaxFileSize the maven max file size
 * @param notificationLimit the notification limit
 * @param npmMaxFileSize the npm max file size
 * @param nugetMaxFileSize the nuget max file size
 * @param organizationHooks the organization hooks
 * @param pypiMaxFileSize the pypi max file size
 * @param serviceDeskOutboundEmailsPerHour the service desk outbound emails per hour
 * @param serviceDeskOutboundEmailsPerDay the service desk outbound emails per day
 * @param swiftMaxFileSize the swift max file size
 * @param terraformModuleMaxFileSize the terraform module max file size
 * @param storageSizeLimit the storage size limit
 * @param pipelineHierarchySize the pipeline hierarchy size
 * @param webHookCalls the web hook calls
 * @param webHookCallsLow the web hook calls low
 * @param webHookCallsMid the web hook calls mid
 * @param integrationExecutions the integration executions
 * @param integrationExecutionsDatadog the integration executions datadog
 * @param maxPipelinesPerMergeTrain the max pipelines per merge train
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ApplicationPlanLimits/requestBody")
public record GitLabPlanLimitsUpdatePayload(
        GitLabPlanLimitsUpdatePlanName planName,
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
        @Nullable Long dotenvSize,
        @Nullable Integer dotenvVariables,
        @Nullable Integer draftNotesPerMergeRequest,
        @Nullable Integer enforcementLimit,
        @Nullable Long genericPackagesMaxFileSize,
        @Nullable Long helmMaxFileSize,
        @Nullable Long mavenMaxFileSize,
        @Nullable Integer notificationLimit,
        @Nullable Long npmMaxFileSize,
        @Nullable Long nugetMaxFileSize,
        @Nullable Integer organizationHooks,
        @Nullable Long pypiMaxFileSize,
        @Nullable Integer serviceDeskOutboundEmailsPerHour,
        @Nullable Integer serviceDeskOutboundEmailsPerDay,
        @Nullable Long swiftMaxFileSize,
        @Nullable Long terraformModuleMaxFileSize,
        @Nullable Integer storageSizeLimit,
        @Nullable Long pipelineHierarchySize,
        @Nullable Integer webHookCalls,
        @Nullable Integer webHookCallsLow,
        @Nullable Integer webHookCallsMid,
        @Nullable Integer integrationExecutions,
        @Nullable Integer integrationExecutionsDatadog,
        @Nullable Integer maxPipelinesPerMergeTrain) {
    public GitLabPlanLimitsUpdatePayload {
        requireNonNull(planName, "planName");
    }
}

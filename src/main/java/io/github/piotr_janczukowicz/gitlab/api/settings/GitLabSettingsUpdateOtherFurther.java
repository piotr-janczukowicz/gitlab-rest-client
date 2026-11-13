package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabSettingsUpdatePayload}, flattened into it in JSON.
 *
 * @param relationExportBatchSize the relation export batch size
 * @param rememberMeEnabled the remember me enabled
 * @param searchRateLimit the search rate limit
 * @param searchRateLimitUnauthenticated the search rate limit unauthenticated
 * @param searchRateLimitAllowlistRaw the search rate limit allowlist raw
 * @param sidekiqJobLimiterCompressionThresholdBytes the sidekiq job limiter compression threshold bytes
 * @param sidekiqJobLimiterLimitBytes the sidekiq job limiter limit bytes
 * @param sidekiqJobLimiterMode the sidekiq job limiter mode
 * @param sidekiqTimezoneOverride the sidekiq timezone override
 * @param signInRestrictions the sign in restrictions
 * @param silentAdminExportsEnabled the silent admin exports enabled
 * @param silentModeEnabled the silent mode enabled
 * @param snippetSizeLimit the snippet size limit
 * @param staticObjectsExternalStorageAuthToken the static objects external storage auth token
 * @param staticObjectsExternalStorageUrl the static objects external storage url
 * @param systemHooksCreateLimit the system hooks create limit
 * @param terms the terms
 * @param timeTrackingLimitToHours the time tracking limit to hours
 * @param topLevelGroupCreationEnabled the top level group creation enabled
 * @param uniqueIpsLimitEnabled the unique ips limit enabled
 * @param uniqueIpsLimitPerUser the unique ips limit per user
 * @param uniqueIpsLimitTimeWindow the unique ips limit time window
 * @param updateRunnerVersionsEnabled the update runner versions enabled
 * @param useClickhouseForAnalytics the use clickhouse for analytics
 * @param useNatsForAuditStreaming the use nats for audit streaming
 * @param versionCheckEnabled the version check enabled
 * @param webHookEventResendLimit the web hook event resend limit
 * @param webHookTestLimit the web hook test limit
 * @param activeContextPauseIndexing the active context pause indexing
 * @param secretDetectionTokenRevocationEnabled the secret detection token revocation enabled
 * @param secretDetectionTokenRevocationUrl the secret detection token revocation url
 * @param secretDetectionRevocationTokenTypesUrl the secret detection revocation token types url
 * @param secretPushProtectionAvailable the secret push protection available
 * @param secretDetectionTokenRevocationToken the secret detection token revocation token
 * @param secretDetectionServiceAuthToken the secret detection service auth token
 * @param secretDetectionServiceUrl the secret detection service url
 * @param fileTemplateProjectId the file template project id
 * @param updatingNameDisabledForUsers the updating name disabled for users
 * @param preventMergeRequestsAuthorApproval the prevent merge requests author approval
 * @param preventMergeRequestsCommittersApproval the prevent merge requests committers approval
 * @param mavenPackageRequestsForwarding the maven package requests forwarding
 * @param npmPackageRequestsForwarding the npm package requests forwarding
 * @param pypiPackageRequestsForwarding the pypi package requests forwarding
 * @param rubygemsPackageRequestsForwarding the rubygems package requests forwarding
 * @param virtualRegistriesEndpointsApiLimit the virtual registries endpoints api limit
 * @param auditEventsApiLimit the audit events api limit
 * @param insightsQueryLimit the insights query limit
 * @param orbitQueryLimit the orbit query limit
 * @param orbitIndexingStatusLimit the orbit indexing status limit
 * @param orbitItemCountsLimit the orbit item counts limit
 * @param orbitRateLimitAllowlistRaw the orbit rate limit allowlist raw
 * @param orbitAutoIndexRootNamespace the orbit auto index root namespace
 * @param orbitDapEnabledByDefault the orbit dap enabled by default
 * @param subscriptionUsagePerMinuteLimit the subscription usage per minute limit
 * @param subscriptionUsagePerHourLimit the subscription usage per hour limit
 * @param subscriptionUsagePerDayLimit the subscription usage per day limit
 * @param budgetCapUpdatePerMinuteLimit the budget cap update per minute limit
 * @param budgetCapUpdatePerHourLimit the budget cap update per hour limit
 * @param budgetCapUpdatePerDayLimit the budget cap update per day limit
 * @param maintenanceMode the maintenance mode
 * @param maintenanceModeMessage the maintenance mode message
 * @param makeProfilePrivate the make profile private
 * @param serviceAccessTokensExpirationEnforced the service access tokens expiration enforced
 * @param receptiveClusterAgentsEnabled the receptive cluster agents enabled
 * @param builtInProjectTemplatesEnabled the built in project templates enabled
 * @param allowedIntegrations the allowed integrations
 * @param automaticPurchasedStorageAllocation the automatic purchased storage allocation
 * @param checkNamespacePlan the check namespace plan
 * @param geoNodeAllowedIps the geo node allowed ips
 * @param geoStatusTimeout the geo status timeout
 * @param globallyAllowedIps the globally allowed ips
 * @param scanExecutionPoliciesActionLimit the scan execution policies action limit
 * @param scanExecutionPoliciesScheduleLimit the scan execution policies schedule limit
 * @param scanExecutionPoliciesPerConfigurationLimit the scan execution policies per configuration limit
 * @param unconfirmedUsersDeleteAfterDays the unconfirmed users delete after days
 * @param denyAllRequestsExceptAllowed the deny all requests except allowed
 * @param blockJwtForReclaimedPaths the block jwt for reclaimed paths
 * @param rootMovedPermanentlyRedirection the root moved permanently redirection
 * @param errorTrackingEnabled the error tracking enabled
 * @param errorTrackingApiUrl the error tracking api url
 * @param forcePagesAccessControl the force pages access control
 * @param mathRenderingLimitsEnabled the math rendering limits enabled
 * @param organizationClusterAgentAuthorizationEnabled the organization cluster agent authorization enabled
 * @param instanceTokenPrefix the instance token prefix
 * @param instanceLevelAiBetaFeaturesEnabled the instance level ai beta features enabled
 * @param notesCreateLimit the notes create limit
 * @param notesCreateLimitAllowlistRaw the notes create limit allowlist raw
 * @param membersDeleteLimit the members delete limit
 * @param milestoneDestroyLimit the milestone destroy limit
 * @param sentryEnabled the sentry enabled
 * @param sentryDsn the sentry dsn
 * @param sentryClientsideDsn the sentry clientside dsn
 * @param sentryEnvironment the sentry environment
 * @param sentryClientsideTracesSampleRate the sentry clientside traces sample rate
 * @param invitationFlowEnforcement the invitation flow enforcement
 * @param deactivationEmailAdditionalText the deactivation email additional text
 * @param glqlDbSecondsPerIpLimit the glql db seconds per ip limit
 * @param glqlDbSecondsPerQueryLimit the glql db seconds per query limit
 * @param glqlDbSecondsPerUserLimit the glql db seconds per user limit
 * @param glqlDuoDbSecondsPerUserLimit the glql duo db seconds per user limit
 * @param groupsApiLimit the groups api limit
 * @param issuableCsvImportLimit the issuable csv import limit
 * @param labelDeleteLimit the label delete limit
 * @param createOrganizationApiLimit the create organization api limit
 * @param crossReferenceChecksLimit the cross reference checks limit
 * @param tagsCreateLimit the tags create limit
 * @param todosListApiLimit the todos list api limit
 * @param workItemHierarchyAddChildrenLimit the work item hierarchy add children limit
 * @param workItemMoveLimit the work item move limit
 * @param workItemUpdateLimit the work item update limit
 * @param observabilityBackendSslVerificationEnabled the observability backend ssl verification enabled
 * @param reindexingMinimumIndexSize the reindexing minimum index size
 * @param reindexingMinimumRelativeBloatSize the reindexing minimum relative bloat size
 * @param anonymousSearchesAllowed the anonymous searches allowed
 * @param delayUserAccountSelfDeletion the delay user account self deletion
 * @param backgroundOperationsMaxJobs the background operations max jobs
 * @param pgAshSamplingEnabled the pg ash sampling enabled
 * @param pgAshSampleIntervalSeconds the pg ash sample interval seconds
 * @param granularTokensEnforcedAfter the granular tokens enforced after
 * @param deactivateDormantUsers the deactivate dormant users
 * @param deactivateDormantUsersPeriod the deactivate dormant users period
 * @param nugetSkipMetadataUrlValidation the nuget skip metadata url validation
 * @param helmMaxPackagesCount the helm max packages count
 * @param mcpServerEnabled the mcp server enabled
 * @param dynamicClientRegistrationEnabled the dynamic client registration enabled
 * @param modelPromptCacheEnabled the model prompt cache enabled
 * @param productAnalyticsEnabled the product analytics enabled
 * @param productAnalyticsDataCollectorHost the product analytics data collector host
 * @param productAnalyticsConfiguratorConnectionString the product analytics configurator connection string
 * @param cubeApiBaseUrl the cube api base url
 * @param cubeApiKey the cube api key
 * @param toolApprovalForSessionEnabled the tool approval for session enabled
 * @param toolApprovalForSessionAvailability the tool approval for session availability
 * @param foundationalAgentsDefaultEnabled the foundational agents default enabled
 * @param foundationalAgentsStatuses the foundational agents statuses
 * @param epicMoveListLimit the epic move list limit
 * @param vulnerabilityManagementPoliciesPerConfigurationLimit the vulnerability management policies per configuration
 *     limit
 * @param policyStoreExperimentEnabled the policy store experiment enabled
 * @param fetchObservabilityAlertsFromCloud the fetch observability alerts from cloud
 * @param elasticMigrationWorkerEnabled the elastic migration worker enabled
 * @param displayGitlabCreditsUserData the display gitlab credits user data
 * @param vacProjectIdsRaw the vac project ids raw
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabSettingsUpdateOtherFurther(
        @Nullable String relationExportBatchSize,
        @Nullable String rememberMeEnabled,
        @Nullable String searchRateLimit,
        @Nullable String searchRateLimitUnauthenticated,
        @Nullable String searchRateLimitAllowlistRaw,
        @Nullable String sidekiqJobLimiterCompressionThresholdBytes,
        @Nullable String sidekiqJobLimiterLimitBytes,
        @Nullable GitLabSettingsUpdateSidekiqJobLimiterMode sidekiqJobLimiterMode,
        @Nullable String sidekiqTimezoneOverride,
        @Nullable String signInRestrictions,
        @Nullable String silentAdminExportsEnabled,
        @Nullable String silentModeEnabled,
        @Nullable String snippetSizeLimit,
        @Nullable String staticObjectsExternalStorageAuthToken,
        @Nullable String staticObjectsExternalStorageUrl,
        @Nullable String systemHooksCreateLimit,
        @Nullable String terms,
        @Nullable String timeTrackingLimitToHours,
        @Nullable String topLevelGroupCreationEnabled,
        @Nullable String uniqueIpsLimitEnabled,
        @Nullable String uniqueIpsLimitPerUser,
        @Nullable String uniqueIpsLimitTimeWindow,
        @Nullable String updateRunnerVersionsEnabled,
        @Nullable String useClickhouseForAnalytics,
        @Nullable Boolean useNatsForAuditStreaming,
        @Nullable String versionCheckEnabled,
        @Nullable String webHookEventResendLimit,
        @Nullable String webHookTestLimit,
        @Nullable Boolean activeContextPauseIndexing,
        @Nullable Boolean secretDetectionTokenRevocationEnabled,
        @Nullable String secretDetectionTokenRevocationUrl,
        @Nullable String secretDetectionRevocationTokenTypesUrl,
        @Nullable String secretPushProtectionAvailable,
        @Nullable String secretDetectionTokenRevocationToken,
        @Nullable String secretDetectionServiceAuthToken,
        @Nullable String secretDetectionServiceUrl,
        @Nullable Long fileTemplateProjectId,
        @Nullable Boolean updatingNameDisabledForUsers,
        @Nullable Boolean preventMergeRequestsAuthorApproval,
        @Nullable Boolean preventMergeRequestsCommittersApproval,
        @Nullable Boolean mavenPackageRequestsForwarding,
        @Nullable Boolean npmPackageRequestsForwarding,
        @Nullable Boolean pypiPackageRequestsForwarding,
        @Nullable Boolean rubygemsPackageRequestsForwarding,
        @Nullable Integer virtualRegistriesEndpointsApiLimit,
        @Nullable Integer auditEventsApiLimit,
        @Nullable Integer insightsQueryLimit,
        @Nullable Integer orbitQueryLimit,
        @Nullable Integer orbitIndexingStatusLimit,
        @Nullable Integer orbitItemCountsLimit,
        @Nullable String orbitRateLimitAllowlistRaw,
        @Nullable String orbitAutoIndexRootNamespace,
        @Nullable String orbitDapEnabledByDefault,
        @Nullable Integer subscriptionUsagePerMinuteLimit,
        @Nullable Integer subscriptionUsagePerHourLimit,
        @Nullable Integer subscriptionUsagePerDayLimit,
        @Nullable Integer budgetCapUpdatePerMinuteLimit,
        @Nullable Integer budgetCapUpdatePerHourLimit,
        @Nullable Integer budgetCapUpdatePerDayLimit,
        @Nullable Boolean maintenanceMode,
        @Nullable String maintenanceModeMessage,
        @Nullable Boolean makeProfilePrivate,
        @Nullable Boolean serviceAccessTokensExpirationEnforced,
        @Nullable Boolean receptiveClusterAgentsEnabled,
        @Nullable Boolean builtInProjectTemplatesEnabled,
        @Nullable String allowedIntegrations,
        @Nullable String automaticPurchasedStorageAllocation,
        @Nullable String checkNamespacePlan,
        @Nullable String geoNodeAllowedIps,
        @Nullable String geoStatusTimeout,
        @Nullable String globallyAllowedIps,
        @Nullable String scanExecutionPoliciesActionLimit,
        @Nullable String scanExecutionPoliciesScheduleLimit,
        @Nullable String scanExecutionPoliciesPerConfigurationLimit,
        @Nullable String unconfirmedUsersDeleteAfterDays,
        @Nullable String denyAllRequestsExceptAllowed,
        @Nullable String blockJwtForReclaimedPaths,
        @Nullable String rootMovedPermanentlyRedirection,
        @Nullable String errorTrackingEnabled,
        @Nullable String errorTrackingApiUrl,
        @Nullable String forcePagesAccessControl,
        @Nullable String mathRenderingLimitsEnabled,
        @Nullable String organizationClusterAgentAuthorizationEnabled,
        @Nullable String instanceTokenPrefix,
        @Nullable String instanceLevelAiBetaFeaturesEnabled,
        @Nullable String notesCreateLimit,
        @Nullable String notesCreateLimitAllowlistRaw,
        @Nullable String membersDeleteLimit,
        @Nullable String milestoneDestroyLimit,
        @Nullable String sentryEnabled,
        @Nullable String sentryDsn,
        @Nullable String sentryClientsideDsn,
        @Nullable String sentryEnvironment,
        @Nullable String sentryClientsideTracesSampleRate,
        @Nullable String invitationFlowEnforcement,
        @Nullable String deactivationEmailAdditionalText,
        @Nullable String glqlDbSecondsPerIpLimit,
        @Nullable String glqlDbSecondsPerQueryLimit,
        @Nullable String glqlDbSecondsPerUserLimit,
        @Nullable String glqlDuoDbSecondsPerUserLimit,
        @Nullable String groupsApiLimit,
        @Nullable String issuableCsvImportLimit,
        @Nullable String labelDeleteLimit,
        @Nullable String createOrganizationApiLimit,
        @Nullable String crossReferenceChecksLimit,
        @Nullable String tagsCreateLimit,
        @Nullable String todosListApiLimit,
        @Nullable String workItemHierarchyAddChildrenLimit,
        @Nullable String workItemMoveLimit,
        @Nullable String workItemUpdateLimit,
        @Nullable String observabilityBackendSslVerificationEnabled,
        @Nullable String reindexingMinimumIndexSize,
        @Nullable String reindexingMinimumRelativeBloatSize,
        @Nullable String anonymousSearchesAllowed,
        @Nullable String delayUserAccountSelfDeletion,
        @Nullable String backgroundOperationsMaxJobs,
        @Nullable String pgAshSamplingEnabled,
        @Nullable String pgAshSampleIntervalSeconds,
        @Nullable String granularTokensEnforcedAfter,
        @Nullable String deactivateDormantUsers,
        @Nullable String deactivateDormantUsersPeriod,
        @Nullable String nugetSkipMetadataUrlValidation,
        @Nullable String helmMaxPackagesCount,
        @Nullable String mcpServerEnabled,
        @Nullable String dynamicClientRegistrationEnabled,
        @Nullable String modelPromptCacheEnabled,
        @Nullable String productAnalyticsEnabled,
        @Nullable String productAnalyticsDataCollectorHost,
        @Nullable String productAnalyticsConfiguratorConnectionString,
        @Nullable String cubeApiBaseUrl,
        @Nullable String cubeApiKey,
        @Nullable String toolApprovalForSessionEnabled,
        @Nullable String toolApprovalForSessionAvailability,
        @Nullable String foundationalAgentsDefaultEnabled,
        @Nullable String foundationalAgentsStatuses,
        @Nullable String epicMoveListLimit,
        @Nullable String vulnerabilityManagementPoliciesPerConfigurationLimit,
        @Nullable String policyStoreExperimentEnabled,
        @Nullable String fetchObservabilityAlertsFromCloud,
        @Nullable String elasticMigrationWorkerEnabled,
        @Nullable String displayGitlabCreditsUserData,
        @Nullable String vacProjectIdsRaw) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code staticObjectsExternalStorageAuthToken}, {@code secretPushProtectionAvailable},
     *     {@code secretDetectionTokenRevocationToken}, {@code secretDetectionServiceAuthToken},
     *     {@code instanceTokenPrefix}, {@code granularTokensEnforcedAfter} redacted
     */
    @Override
    public String toString() {
        return "GitLabSettingsUpdateOtherFurther[" + "relationExportBatchSize=" + relationExportBatchSize
                + ", rememberMeEnabled=" + rememberMeEnabled + ", searchRateLimit=" + searchRateLimit
                + ", searchRateLimitUnauthenticated=" + searchRateLimitUnauthenticated
                + ", searchRateLimitAllowlistRaw=" + searchRateLimitAllowlistRaw
                + ", sidekiqJobLimiterCompressionThresholdBytes=" + sidekiqJobLimiterCompressionThresholdBytes
                + ", sidekiqJobLimiterLimitBytes=" + sidekiqJobLimiterLimitBytes + ", sidekiqJobLimiterMode="
                + sidekiqJobLimiterMode + ", sidekiqTimezoneOverride=" + sidekiqTimezoneOverride
                + ", signInRestrictions=" + signInRestrictions + ", silentAdminExportsEnabled="
                + silentAdminExportsEnabled + ", silentModeEnabled=" + silentModeEnabled + ", snippetSizeLimit="
                + snippetSizeLimit + ", staticObjectsExternalStorageAuthToken=<redacted>"
                + ", staticObjectsExternalStorageUrl=" + staticObjectsExternalStorageUrl + ", systemHooksCreateLimit="
                + systemHooksCreateLimit + ", terms=" + terms + ", timeTrackingLimitToHours=" + timeTrackingLimitToHours
                + ", topLevelGroupCreationEnabled=" + topLevelGroupCreationEnabled + ", uniqueIpsLimitEnabled="
                + uniqueIpsLimitEnabled + ", uniqueIpsLimitPerUser=" + uniqueIpsLimitPerUser
                + ", uniqueIpsLimitTimeWindow=" + uniqueIpsLimitTimeWindow + ", updateRunnerVersionsEnabled="
                + updateRunnerVersionsEnabled + ", useClickhouseForAnalytics=" + useClickhouseForAnalytics
                + ", useNatsForAuditStreaming=" + useNatsForAuditStreaming + ", versionCheckEnabled="
                + versionCheckEnabled + ", webHookEventResendLimit=" + webHookEventResendLimit + ", webHookTestLimit="
                + webHookTestLimit + ", activeContextPauseIndexing=" + activeContextPauseIndexing
                + ", secretDetectionTokenRevocationEnabled=" + secretDetectionTokenRevocationEnabled
                + ", secretDetectionTokenRevocationUrl=" + secretDetectionTokenRevocationUrl
                + ", secretDetectionRevocationTokenTypesUrl=" + secretDetectionRevocationTokenTypesUrl
                + ", secretPushProtectionAvailable=<redacted>" + ", secretDetectionTokenRevocationToken=<redacted>"
                + ", secretDetectionServiceAuthToken=<redacted>" + ", secretDetectionServiceUrl="
                + secretDetectionServiceUrl + ", fileTemplateProjectId=" + fileTemplateProjectId
                + ", updatingNameDisabledForUsers=" + updatingNameDisabledForUsers
                + ", preventMergeRequestsAuthorApproval=" + preventMergeRequestsAuthorApproval
                + ", preventMergeRequestsCommittersApproval=" + preventMergeRequestsCommittersApproval
                + ", mavenPackageRequestsForwarding=" + mavenPackageRequestsForwarding
                + ", npmPackageRequestsForwarding=" + npmPackageRequestsForwarding + ", pypiPackageRequestsForwarding="
                + pypiPackageRequestsForwarding + ", rubygemsPackageRequestsForwarding="
                + rubygemsPackageRequestsForwarding + ", virtualRegistriesEndpointsApiLimit="
                + virtualRegistriesEndpointsApiLimit + ", auditEventsApiLimit=" + auditEventsApiLimit
                + ", insightsQueryLimit=" + insightsQueryLimit + ", orbitQueryLimit=" + orbitQueryLimit
                + ", orbitIndexingStatusLimit=" + orbitIndexingStatusLimit + ", orbitItemCountsLimit="
                + orbitItemCountsLimit + ", orbitRateLimitAllowlistRaw=" + orbitRateLimitAllowlistRaw
                + ", orbitAutoIndexRootNamespace=" + orbitAutoIndexRootNamespace + ", orbitDapEnabledByDefault="
                + orbitDapEnabledByDefault + ", subscriptionUsagePerMinuteLimit=" + subscriptionUsagePerMinuteLimit
                + ", subscriptionUsagePerHourLimit=" + subscriptionUsagePerHourLimit + ", subscriptionUsagePerDayLimit="
                + subscriptionUsagePerDayLimit + ", budgetCapUpdatePerMinuteLimit=" + budgetCapUpdatePerMinuteLimit
                + ", budgetCapUpdatePerHourLimit=" + budgetCapUpdatePerHourLimit + ", budgetCapUpdatePerDayLimit="
                + budgetCapUpdatePerDayLimit + ", maintenanceMode=" + maintenanceMode + ", maintenanceModeMessage="
                + maintenanceModeMessage + ", makeProfilePrivate=" + makeProfilePrivate
                + ", serviceAccessTokensExpirationEnforced=" + serviceAccessTokensExpirationEnforced
                + ", receptiveClusterAgentsEnabled=" + receptiveClusterAgentsEnabled
                + ", builtInProjectTemplatesEnabled=" + builtInProjectTemplatesEnabled + ", allowedIntegrations="
                + allowedIntegrations + ", automaticPurchasedStorageAllocation=" + automaticPurchasedStorageAllocation
                + ", checkNamespacePlan=" + checkNamespacePlan + ", geoNodeAllowedIps=" + geoNodeAllowedIps
                + ", geoStatusTimeout=" + geoStatusTimeout + ", globallyAllowedIps=" + globallyAllowedIps
                + ", scanExecutionPoliciesActionLimit=" + scanExecutionPoliciesActionLimit
                + ", scanExecutionPoliciesScheduleLimit=" + scanExecutionPoliciesScheduleLimit
                + ", scanExecutionPoliciesPerConfigurationLimit=" + scanExecutionPoliciesPerConfigurationLimit
                + ", unconfirmedUsersDeleteAfterDays=" + unconfirmedUsersDeleteAfterDays
                + ", denyAllRequestsExceptAllowed=" + denyAllRequestsExceptAllowed + ", blockJwtForReclaimedPaths="
                + blockJwtForReclaimedPaths + ", rootMovedPermanentlyRedirection=" + rootMovedPermanentlyRedirection
                + ", errorTrackingEnabled=" + errorTrackingEnabled + ", errorTrackingApiUrl=" + errorTrackingApiUrl
                + ", forcePagesAccessControl=" + forcePagesAccessControl + ", mathRenderingLimitsEnabled="
                + mathRenderingLimitsEnabled + ", organizationClusterAgentAuthorizationEnabled="
                + organizationClusterAgentAuthorizationEnabled + ", instanceTokenPrefix=<redacted>"
                + ", instanceLevelAiBetaFeaturesEnabled=" + instanceLevelAiBetaFeaturesEnabled + ", notesCreateLimit="
                + notesCreateLimit + ", notesCreateLimitAllowlistRaw=" + notesCreateLimitAllowlistRaw
                + ", membersDeleteLimit=" + membersDeleteLimit + ", milestoneDestroyLimit=" + milestoneDestroyLimit
                + ", sentryEnabled=" + sentryEnabled + ", sentryDsn=" + sentryDsn + ", sentryClientsideDsn="
                + sentryClientsideDsn + ", sentryEnvironment=" + sentryEnvironment
                + ", sentryClientsideTracesSampleRate=" + sentryClientsideTracesSampleRate
                + ", invitationFlowEnforcement=" + invitationFlowEnforcement + ", deactivationEmailAdditionalText="
                + deactivationEmailAdditionalText + ", glqlDbSecondsPerIpLimit=" + glqlDbSecondsPerIpLimit
                + ", glqlDbSecondsPerQueryLimit=" + glqlDbSecondsPerQueryLimit + ", glqlDbSecondsPerUserLimit="
                + glqlDbSecondsPerUserLimit + ", glqlDuoDbSecondsPerUserLimit=" + glqlDuoDbSecondsPerUserLimit
                + ", groupsApiLimit=" + groupsApiLimit + ", issuableCsvImportLimit=" + issuableCsvImportLimit
                + ", labelDeleteLimit=" + labelDeleteLimit + ", createOrganizationApiLimit="
                + createOrganizationApiLimit + ", crossReferenceChecksLimit=" + crossReferenceChecksLimit
                + ", tagsCreateLimit=" + tagsCreateLimit + ", todosListApiLimit=" + todosListApiLimit
                + ", workItemHierarchyAddChildrenLimit=" + workItemHierarchyAddChildrenLimit + ", workItemMoveLimit="
                + workItemMoveLimit + ", workItemUpdateLimit=" + workItemUpdateLimit
                + ", observabilityBackendSslVerificationEnabled=" + observabilityBackendSslVerificationEnabled
                + ", reindexingMinimumIndexSize=" + reindexingMinimumIndexSize + ", reindexingMinimumRelativeBloatSize="
                + reindexingMinimumRelativeBloatSize + ", anonymousSearchesAllowed=" + anonymousSearchesAllowed
                + ", delayUserAccountSelfDeletion=" + delayUserAccountSelfDeletion + ", backgroundOperationsMaxJobs="
                + backgroundOperationsMaxJobs + ", pgAshSamplingEnabled=" + pgAshSamplingEnabled
                + ", pgAshSampleIntervalSeconds=" + pgAshSampleIntervalSeconds
                + ", granularTokensEnforcedAfter=<redacted>" + ", deactivateDormantUsers=" + deactivateDormantUsers
                + ", deactivateDormantUsersPeriod=" + deactivateDormantUsersPeriod + ", nugetSkipMetadataUrlValidation="
                + nugetSkipMetadataUrlValidation + ", helmMaxPackagesCount=" + helmMaxPackagesCount
                + ", mcpServerEnabled=" + mcpServerEnabled + ", dynamicClientRegistrationEnabled="
                + dynamicClientRegistrationEnabled + ", modelPromptCacheEnabled=" + modelPromptCacheEnabled
                + ", productAnalyticsEnabled=" + productAnalyticsEnabled + ", productAnalyticsDataCollectorHost="
                + productAnalyticsDataCollectorHost + ", productAnalyticsConfiguratorConnectionString="
                + productAnalyticsConfiguratorConnectionString + ", cubeApiBaseUrl=" + cubeApiBaseUrl + ", cubeApiKey="
                + cubeApiKey + ", toolApprovalForSessionEnabled=" + toolApprovalForSessionEnabled
                + ", toolApprovalForSessionAvailability=" + toolApprovalForSessionAvailability
                + ", foundationalAgentsDefaultEnabled=" + foundationalAgentsDefaultEnabled
                + ", foundationalAgentsStatuses=" + foundationalAgentsStatuses + ", epicMoveListLimit="
                + epicMoveListLimit + ", vulnerabilityManagementPoliciesPerConfigurationLimit="
                + vulnerabilityManagementPoliciesPerConfigurationLimit + ", policyStoreExperimentEnabled="
                + policyStoreExperimentEnabled + ", fetchObservabilityAlertsFromCloud="
                + fetchObservabilityAlertsFromCloud + ", elasticMigrationWorkerEnabled=" + elasticMigrationWorkerEnabled
                + ", displayGitlabCreditsUserData=" + displayGitlabCreditsUserData + ", vacProjectIdsRaw="
                + vacProjectIdsRaw + "]";
    }
}

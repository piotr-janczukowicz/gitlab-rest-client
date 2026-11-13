package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabApplicationSetting}, flattened into it in JSON.
 *
 * @param relationExportBatchSize the relation export batch size
 * @param offlineTransferExportsEnabled the offline transfer exports enabled
 * @param offlineTransferImportsEnabled the offline transfer imports enabled
 * @param validRunnerRegistrars the valid runner registrars
 * @param deactivationEmailAdditionalText the deactivation email additional text
 * @param projectsApiRateLimitUnauthenticated the projects api rate limit unauthenticated
 * @param projectsApiLimit the projects api limit
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
 * @param systemHooksCreateLimit the system hooks create limit
 * @param webHookEventResendLimit the web hook event resend limit
 * @param webHookTestLimit the web hook test limit
 * @param workItemHierarchyAddChildrenLimit the work item hierarchy add children limit
 * @param workItemMoveLimit the work item move limit
 * @param workItemUpdateLimit the work item update limit
 * @param githubGistsImportLimit the github gists import limit
 * @param namespaceAggregationScheduleLeaseDurationInSeconds the namespace aggregation schedule lease duration in
 *     seconds
 * @param securityTxtContent the security txt content
 * @param securityPolicyGlobalGroupApproversEnabled the security policy global group approvers enabled
 * @param securityApprovalPoliciesLimit the security approval policies limit
 * @param securityMrReportCacheLifetimeMinutes the security mr report cache lifetime minutes
 * @param securityScanStaleAfterDays the security scan stale after days
 * @param downstreamPipelineTriggerLimitPerProjectUserSha the downstream pipeline trigger limit per project user sha
 * @param jobRetryLimitPerUserProject the job retry limit per user project
 * @param jobPlayLimitPerUserProject the job play limit per user project
 * @param jobEraseLimitPerUserProject the job erase limit per user project
 * @param jobCancelLimitPerUserProject the job cancel limit per user project
 * @param asciidocMaxIncludes the asciidoc max includes
 * @param aiActionApiRateLimit the ai action api rate limit
 * @param aiAuditEventsStreamingEnabled the ai audit events streaming enabled
 * @param observabilityBackendSslVerificationEnabled the observability backend ssl verification enabled
 * @param showMigrateFromJenkinsBanner the show migrate from jenkins banner
 * @param vscodeExtensionMarketplace the vscode extension marketplace
 * @param vscodeExtensionMarketplaceEnabled the vscode extension marketplace enabled
 * @param vscodeExtensionMarketplaceExtensionHostDomain the vscode extension marketplace extension host domain
 * @param vscodeExtensionMarketplaceSingleOriginFallbackEnabled the vscode extension marketplace single origin fallback
 *     enabled
 * @param reindexingMinimumIndexSize the reindexing minimum index size
 * @param reindexingMinimumRelativeBloatSize the reindexing minimum relative bloat size
 * @param anonymousSearchesAllowed the anonymous searches allowed
 * @param gitPushPipelineLimit the git push pipeline limit
 * @param gitTwoFactorSessionExpiry the git two factor session expiry
 * @param gitRateLimitUsersAllowlist the git rate limit users allowlist
 * @param gitRateLimitUsersAlertlist the git rate limit users alertlist
 * @param delayUserAccountSelfDeletion the delay user account self deletion
 * @param backgroundOperationsMaxJobs the background operations max jobs
 * @param pgAshSamplingEnabled the pg ash sampling enabled
 * @param pgAshSampleIntervalSeconds the pg ash sample interval seconds
 * @param granularTokensEnforcedAfter the granular tokens enforced after
 * @param loggingFieldSchemaVersion the logging field schema version
 * @param loggingFieldDualEmitTarget the logging field dual emit target
 * @param deactivateDormantUsers the deactivate dormant users
 * @param deactivateDormantUsersPeriod the deactivate dormant users period
 * @param nugetSkipMetadataUrlValidation the nuget skip metadata url validation
 * @param helmMaxPackagesCount the helm max packages count
 * @param mcpServerEnabled the mcp server enabled
 * @param dynamicClientRegistrationEnabled the dynamic client registration enabled
 * @param activeContextPauseIndexing the active context pause indexing
 * @param allowedIntegrations the allowed integrations
 * @param automaticPurchasedStorageAllocation the automatic purchased storage allocation
 * @param checkNamespacePlan the check namespace plan
 * @param geoNodeAllowedIps the geo node allowed ips
 * @param geoStatusTimeout the geo status timeout
 * @param modelPromptCacheEnabled the model prompt cache enabled
 * @param receptiveClusterAgentsEnabled the receptive cluster agents enabled
 * @param secretDetectionTokenRevocationEnabled the secret detection token revocation enabled
 * @param secretDetectionTokenRevocationUrl the secret detection token revocation url
 * @param secretDetectionTokenRevocationToken the secret detection token revocation token
 * @param secretDetectionRevocationTokenTypesUrl the secret detection revocation token types url
 * @param secretDetectionServiceAuthToken the secret detection service auth token
 * @param secretDetectionServiceUrl the secret detection service url
 * @param secretPushProtectionAvailable the secret push protection available
 * @param productAnalyticsEnabled the product analytics enabled
 * @param productAnalyticsDataCollectorHost the product analytics data collector host
 * @param productAnalyticsConfiguratorConnectionString the product analytics configurator connection string
 * @param cubeApiBaseUrl the cube api base url
 * @param cubeApiKey the cube api key
 * @param toolApprovalForSessionEnabled the tool approval for session enabled
 * @param toolApprovalForSessionAvailability the tool approval for session availability
 * @param foundationalAgentsDefaultEnabled the foundational agents default enabled
 * @param foundationalAgentsStatuses the foundational agents statuses
 * @param orbitAutoIndexRootNamespace the orbit auto index root namespace
 * @param orbitDapEnabledByDefault the orbit dap enabled by default
 * @param orbitQueryLimit the orbit query limit
 * @param orbitIndexingStatusLimit the orbit indexing status limit
 * @param orbitItemCountsLimit the orbit item counts limit
 * @param orbitRateLimitAllowlistRaw the orbit rate limit allowlist raw
 * @param epicMoveListLimit the epic move list limit
 * @param insightsQueryLimit the insights query limit
 * @param subscriptionUsagePerMinuteLimit the subscription usage per minute limit
 * @param subscriptionUsagePerHourLimit the subscription usage per hour limit
 * @param subscriptionUsagePerDayLimit the subscription usage per day limit
 * @param budgetCapUpdatePerMinuteLimit the budget cap update per minute limit
 * @param budgetCapUpdatePerHourLimit the budget cap update per hour limit
 * @param budgetCapUpdatePerDayLimit the budget cap update per day limit
 * @param scanExecutionPoliciesActionLimit the scan execution policies action limit
 * @param scanExecutionPoliciesScheduleLimit the scan execution policies schedule limit
 * @param scanExecutionPoliciesPerConfigurationLimit the scan execution policies per configuration limit
 * @param vulnerabilityManagementPoliciesPerConfigurationLimit the vulnerability management policies per configuration
 *     limit
 * @param policyStoreExperimentEnabled the policy store experiment enabled
 * @param fetchObservabilityAlertsFromCloud the fetch observability alerts from cloud
 * @param elasticMigrationWorkerEnabled the elastic migration worker enabled
 * @param displayGitlabCreditsUserData the display gitlab credits user data
 * @param vacProjectIdsRaw the vac project ids raw
 * @param signinEnabled the signin enabled
 * @param preventMergeRequestsAuthorApproval the prevent merge requests author approval
 * @param preventMergeRequestsCommittersApproval the prevent merge requests committers approval
 * @param fileTemplateProjectId the file template project id
 * @param updatingNameDisabledForUsers the updating name disabled for users
 * @param mavenPackageRequestsForwarding the maven package requests forwarding
 * @param npmPackageRequestsForwarding the npm package requests forwarding
 * @param virtualRegistriesEndpointsApiLimit the virtual registries endpoints api limit
 * @param auditEventsApiLimit the audit events api limit
 * @param preReceiveSecretDetectionEnabled the pre receive secret detection enabled
 * @param pypiPackageRequestsForwarding the pypi package requests forwarding
 * @param rubygemsPackageRequestsForwarding the rubygems package requests forwarding
 * @param maintenanceMode the maintenance mode
 * @param maintenanceModeMessage the maintenance mode message
 * @param serviceAccessTokensExpirationEnforced the service access tokens expiration enforced
 * @param unconfirmedUsersDeleteAfterDays the unconfirmed users delete after days
 * @param makeProfilePrivate the make profile private
 * @param builtInProjectTemplatesEnabled the built in project templates enabled
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabApplicationSettingOtherFurther(
        @Nullable String relationExportBatchSize,
        @Nullable String offlineTransferExportsEnabled,
        @Nullable String offlineTransferImportsEnabled,
        @Nullable String validRunnerRegistrars,
        @Nullable String deactivationEmailAdditionalText,
        @Nullable String projectsApiRateLimitUnauthenticated,
        @Nullable String projectsApiLimit,
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
        @Nullable String systemHooksCreateLimit,
        @Nullable String webHookEventResendLimit,
        @Nullable String webHookTestLimit,
        @Nullable String workItemHierarchyAddChildrenLimit,
        @Nullable String workItemMoveLimit,
        @Nullable String workItemUpdateLimit,
        @Nullable String githubGistsImportLimit,
        @Nullable String namespaceAggregationScheduleLeaseDurationInSeconds,
        @Nullable String securityTxtContent,
        @Nullable String securityPolicyGlobalGroupApproversEnabled,
        @Nullable String securityApprovalPoliciesLimit,
        @Nullable String securityMrReportCacheLifetimeMinutes,
        @Nullable String securityScanStaleAfterDays,
        @Nullable String downstreamPipelineTriggerLimitPerProjectUserSha,
        @Nullable String jobRetryLimitPerUserProject,
        @Nullable String jobPlayLimitPerUserProject,
        @Nullable String jobEraseLimitPerUserProject,
        @Nullable String jobCancelLimitPerUserProject,
        @Nullable String asciidocMaxIncludes,
        @Nullable String aiActionApiRateLimit,
        @Nullable Boolean aiAuditEventsStreamingEnabled,
        @Nullable String observabilityBackendSslVerificationEnabled,
        @Nullable String showMigrateFromJenkinsBanner,
        @Nullable String vscodeExtensionMarketplace,
        @Nullable String vscodeExtensionMarketplaceEnabled,
        @Nullable String vscodeExtensionMarketplaceExtensionHostDomain,
        @Nullable String vscodeExtensionMarketplaceSingleOriginFallbackEnabled,
        @Nullable String reindexingMinimumIndexSize,
        @Nullable String reindexingMinimumRelativeBloatSize,
        @Nullable String anonymousSearchesAllowed,
        @Nullable String gitPushPipelineLimit,
        @Nullable String gitTwoFactorSessionExpiry,
        @Nullable String gitRateLimitUsersAllowlist,
        @Nullable String gitRateLimitUsersAlertlist,
        @Nullable String delayUserAccountSelfDeletion,
        @Nullable String backgroundOperationsMaxJobs,
        @Nullable String pgAshSamplingEnabled,
        @Nullable String pgAshSampleIntervalSeconds,
        @Nullable String granularTokensEnforcedAfter,
        @Nullable Integer loggingFieldSchemaVersion,
        @Nullable Integer loggingFieldDualEmitTarget,
        @Nullable String deactivateDormantUsers,
        @Nullable String deactivateDormantUsersPeriod,
        @Nullable String nugetSkipMetadataUrlValidation,
        @Nullable String helmMaxPackagesCount,
        @Nullable String mcpServerEnabled,
        @Nullable String dynamicClientRegistrationEnabled,
        @Nullable String activeContextPauseIndexing,
        @Nullable String allowedIntegrations,
        @Nullable String automaticPurchasedStorageAllocation,
        @Nullable String checkNamespacePlan,
        @Nullable String geoNodeAllowedIps,
        @Nullable String geoStatusTimeout,
        @Nullable String modelPromptCacheEnabled,
        @Nullable String receptiveClusterAgentsEnabled,
        @Nullable String secretDetectionTokenRevocationEnabled,
        @Nullable String secretDetectionTokenRevocationUrl,
        @Nullable String secretDetectionTokenRevocationToken,
        @Nullable String secretDetectionRevocationTokenTypesUrl,
        @Nullable String secretDetectionServiceAuthToken,
        @Nullable String secretDetectionServiceUrl,
        @Nullable String secretPushProtectionAvailable,
        @Nullable String productAnalyticsEnabled,
        @Nullable String productAnalyticsDataCollectorHost,
        @Nullable String productAnalyticsConfiguratorConnectionString,
        @Nullable String cubeApiBaseUrl,
        @Nullable String cubeApiKey,
        @Nullable String toolApprovalForSessionEnabled,
        @Nullable String toolApprovalForSessionAvailability,
        @Nullable String foundationalAgentsDefaultEnabled,
        @Nullable String foundationalAgentsStatuses,
        @Nullable String orbitAutoIndexRootNamespace,
        @Nullable String orbitDapEnabledByDefault,
        @Nullable String orbitQueryLimit,
        @Nullable String orbitIndexingStatusLimit,
        @Nullable String orbitItemCountsLimit,
        @Nullable String orbitRateLimitAllowlistRaw,
        @Nullable String epicMoveListLimit,
        @Nullable String insightsQueryLimit,
        @Nullable String subscriptionUsagePerMinuteLimit,
        @Nullable String subscriptionUsagePerHourLimit,
        @Nullable String subscriptionUsagePerDayLimit,
        @Nullable String budgetCapUpdatePerMinuteLimit,
        @Nullable String budgetCapUpdatePerHourLimit,
        @Nullable String budgetCapUpdatePerDayLimit,
        @Nullable String scanExecutionPoliciesActionLimit,
        @Nullable String scanExecutionPoliciesScheduleLimit,
        @Nullable String scanExecutionPoliciesPerConfigurationLimit,
        @Nullable String vulnerabilityManagementPoliciesPerConfigurationLimit,
        @Nullable String policyStoreExperimentEnabled,
        @Nullable String fetchObservabilityAlertsFromCloud,
        @Nullable String elasticMigrationWorkerEnabled,
        @Nullable String displayGitlabCreditsUserData,
        @Nullable String vacProjectIdsRaw,
        @Nullable String signinEnabled,
        @Nullable String preventMergeRequestsAuthorApproval,
        @Nullable String preventMergeRequestsCommittersApproval,
        @Nullable String fileTemplateProjectId,
        @Nullable String updatingNameDisabledForUsers,
        @Nullable String mavenPackageRequestsForwarding,
        @Nullable String npmPackageRequestsForwarding,
        @Nullable String virtualRegistriesEndpointsApiLimit,
        @Nullable String auditEventsApiLimit,
        @Nullable String preReceiveSecretDetectionEnabled,
        @Nullable String pypiPackageRequestsForwarding,
        @Nullable String rubygemsPackageRequestsForwarding,
        @Nullable String maintenanceMode,
        @Nullable String maintenanceModeMessage,
        @Nullable String serviceAccessTokensExpirationEnforced,
        @Nullable String unconfirmedUsersDeleteAfterDays,
        @Nullable String makeProfilePrivate,
        @Nullable Boolean builtInProjectTemplatesEnabled) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code granularTokensEnforcedAfter}, {@code secretDetectionTokenRevocationToken},
     *     {@code secretDetectionServiceAuthToken}, {@code secretPushProtectionAvailable},
     *     {@code serviceAccessTokensExpirationEnforced} redacted
     */
    @Override
    public String toString() {
        return "GitLabApplicationSettingOtherFurther[" + "relationExportBatchSize=" + relationExportBatchSize
                + ", offlineTransferExportsEnabled=" + offlineTransferExportsEnabled
                + ", offlineTransferImportsEnabled=" + offlineTransferImportsEnabled + ", validRunnerRegistrars="
                + validRunnerRegistrars + ", deactivationEmailAdditionalText=" + deactivationEmailAdditionalText
                + ", projectsApiRateLimitUnauthenticated=" + projectsApiRateLimitUnauthenticated + ", projectsApiLimit="
                + projectsApiLimit + ", glqlDbSecondsPerIpLimit=" + glqlDbSecondsPerIpLimit
                + ", glqlDbSecondsPerQueryLimit=" + glqlDbSecondsPerQueryLimit + ", glqlDbSecondsPerUserLimit="
                + glqlDbSecondsPerUserLimit + ", glqlDuoDbSecondsPerUserLimit=" + glqlDuoDbSecondsPerUserLimit
                + ", groupsApiLimit=" + groupsApiLimit + ", issuableCsvImportLimit=" + issuableCsvImportLimit
                + ", labelDeleteLimit=" + labelDeleteLimit + ", createOrganizationApiLimit="
                + createOrganizationApiLimit + ", crossReferenceChecksLimit=" + crossReferenceChecksLimit
                + ", tagsCreateLimit=" + tagsCreateLimit + ", todosListApiLimit=" + todosListApiLimit
                + ", systemHooksCreateLimit=" + systemHooksCreateLimit + ", webHookEventResendLimit="
                + webHookEventResendLimit + ", webHookTestLimit=" + webHookTestLimit
                + ", workItemHierarchyAddChildrenLimit=" + workItemHierarchyAddChildrenLimit + ", workItemMoveLimit="
                + workItemMoveLimit + ", workItemUpdateLimit=" + workItemUpdateLimit + ", githubGistsImportLimit="
                + githubGistsImportLimit + ", namespaceAggregationScheduleLeaseDurationInSeconds="
                + namespaceAggregationScheduleLeaseDurationInSeconds + ", securityTxtContent=" + securityTxtContent
                + ", securityPolicyGlobalGroupApproversEnabled=" + securityPolicyGlobalGroupApproversEnabled
                + ", securityApprovalPoliciesLimit=" + securityApprovalPoliciesLimit
                + ", securityMrReportCacheLifetimeMinutes=" + securityMrReportCacheLifetimeMinutes
                + ", securityScanStaleAfterDays=" + securityScanStaleAfterDays
                + ", downstreamPipelineTriggerLimitPerProjectUserSha=" + downstreamPipelineTriggerLimitPerProjectUserSha
                + ", jobRetryLimitPerUserProject=" + jobRetryLimitPerUserProject + ", jobPlayLimitPerUserProject="
                + jobPlayLimitPerUserProject + ", jobEraseLimitPerUserProject=" + jobEraseLimitPerUserProject
                + ", jobCancelLimitPerUserProject=" + jobCancelLimitPerUserProject + ", asciidocMaxIncludes="
                + asciidocMaxIncludes + ", aiActionApiRateLimit=" + aiActionApiRateLimit
                + ", aiAuditEventsStreamingEnabled=" + aiAuditEventsStreamingEnabled
                + ", observabilityBackendSslVerificationEnabled=" + observabilityBackendSslVerificationEnabled
                + ", showMigrateFromJenkinsBanner=" + showMigrateFromJenkinsBanner + ", vscodeExtensionMarketplace="
                + vscodeExtensionMarketplace + ", vscodeExtensionMarketplaceEnabled="
                + vscodeExtensionMarketplaceEnabled + ", vscodeExtensionMarketplaceExtensionHostDomain="
                + vscodeExtensionMarketplaceExtensionHostDomain
                + ", vscodeExtensionMarketplaceSingleOriginFallbackEnabled="
                + vscodeExtensionMarketplaceSingleOriginFallbackEnabled + ", reindexingMinimumIndexSize="
                + reindexingMinimumIndexSize + ", reindexingMinimumRelativeBloatSize="
                + reindexingMinimumRelativeBloatSize + ", anonymousSearchesAllowed=" + anonymousSearchesAllowed
                + ", gitPushPipelineLimit=" + gitPushPipelineLimit + ", gitTwoFactorSessionExpiry="
                + gitTwoFactorSessionExpiry + ", gitRateLimitUsersAllowlist=" + gitRateLimitUsersAllowlist
                + ", gitRateLimitUsersAlertlist=" + gitRateLimitUsersAlertlist + ", delayUserAccountSelfDeletion="
                + delayUserAccountSelfDeletion + ", backgroundOperationsMaxJobs=" + backgroundOperationsMaxJobs
                + ", pgAshSamplingEnabled=" + pgAshSamplingEnabled + ", pgAshSampleIntervalSeconds="
                + pgAshSampleIntervalSeconds + ", granularTokensEnforcedAfter=<redacted>"
                + ", loggingFieldSchemaVersion=" + loggingFieldSchemaVersion + ", loggingFieldDualEmitTarget="
                + loggingFieldDualEmitTarget + ", deactivateDormantUsers=" + deactivateDormantUsers
                + ", deactivateDormantUsersPeriod=" + deactivateDormantUsersPeriod + ", nugetSkipMetadataUrlValidation="
                + nugetSkipMetadataUrlValidation + ", helmMaxPackagesCount=" + helmMaxPackagesCount
                + ", mcpServerEnabled=" + mcpServerEnabled + ", dynamicClientRegistrationEnabled="
                + dynamicClientRegistrationEnabled + ", activeContextPauseIndexing=" + activeContextPauseIndexing
                + ", allowedIntegrations=" + allowedIntegrations + ", automaticPurchasedStorageAllocation="
                + automaticPurchasedStorageAllocation + ", checkNamespacePlan=" + checkNamespacePlan
                + ", geoNodeAllowedIps=" + geoNodeAllowedIps + ", geoStatusTimeout=" + geoStatusTimeout
                + ", modelPromptCacheEnabled=" + modelPromptCacheEnabled + ", receptiveClusterAgentsEnabled="
                + receptiveClusterAgentsEnabled + ", secretDetectionTokenRevocationEnabled="
                + secretDetectionTokenRevocationEnabled + ", secretDetectionTokenRevocationUrl="
                + secretDetectionTokenRevocationUrl + ", secretDetectionTokenRevocationToken=<redacted>"
                + ", secretDetectionRevocationTokenTypesUrl=" + secretDetectionRevocationTokenTypesUrl
                + ", secretDetectionServiceAuthToken=<redacted>" + ", secretDetectionServiceUrl="
                + secretDetectionServiceUrl + ", secretPushProtectionAvailable=<redacted>"
                + ", productAnalyticsEnabled=" + productAnalyticsEnabled + ", productAnalyticsDataCollectorHost="
                + productAnalyticsDataCollectorHost + ", productAnalyticsConfiguratorConnectionString="
                + productAnalyticsConfiguratorConnectionString + ", cubeApiBaseUrl=" + cubeApiBaseUrl + ", cubeApiKey="
                + cubeApiKey + ", toolApprovalForSessionEnabled=" + toolApprovalForSessionEnabled
                + ", toolApprovalForSessionAvailability=" + toolApprovalForSessionAvailability
                + ", foundationalAgentsDefaultEnabled=" + foundationalAgentsDefaultEnabled
                + ", foundationalAgentsStatuses=" + foundationalAgentsStatuses + ", orbitAutoIndexRootNamespace="
                + orbitAutoIndexRootNamespace + ", orbitDapEnabledByDefault=" + orbitDapEnabledByDefault
                + ", orbitQueryLimit=" + orbitQueryLimit + ", orbitIndexingStatusLimit=" + orbitIndexingStatusLimit
                + ", orbitItemCountsLimit=" + orbitItemCountsLimit + ", orbitRateLimitAllowlistRaw="
                + orbitRateLimitAllowlistRaw + ", epicMoveListLimit=" + epicMoveListLimit + ", insightsQueryLimit="
                + insightsQueryLimit + ", subscriptionUsagePerMinuteLimit=" + subscriptionUsagePerMinuteLimit
                + ", subscriptionUsagePerHourLimit=" + subscriptionUsagePerHourLimit + ", subscriptionUsagePerDayLimit="
                + subscriptionUsagePerDayLimit + ", budgetCapUpdatePerMinuteLimit=" + budgetCapUpdatePerMinuteLimit
                + ", budgetCapUpdatePerHourLimit=" + budgetCapUpdatePerHourLimit + ", budgetCapUpdatePerDayLimit="
                + budgetCapUpdatePerDayLimit + ", scanExecutionPoliciesActionLimit=" + scanExecutionPoliciesActionLimit
                + ", scanExecutionPoliciesScheduleLimit=" + scanExecutionPoliciesScheduleLimit
                + ", scanExecutionPoliciesPerConfigurationLimit=" + scanExecutionPoliciesPerConfigurationLimit
                + ", vulnerabilityManagementPoliciesPerConfigurationLimit="
                + vulnerabilityManagementPoliciesPerConfigurationLimit + ", policyStoreExperimentEnabled="
                + policyStoreExperimentEnabled + ", fetchObservabilityAlertsFromCloud="
                + fetchObservabilityAlertsFromCloud + ", elasticMigrationWorkerEnabled=" + elasticMigrationWorkerEnabled
                + ", displayGitlabCreditsUserData=" + displayGitlabCreditsUserData + ", vacProjectIdsRaw="
                + vacProjectIdsRaw + ", signinEnabled=" + signinEnabled + ", preventMergeRequestsAuthorApproval="
                + preventMergeRequestsAuthorApproval + ", preventMergeRequestsCommittersApproval="
                + preventMergeRequestsCommittersApproval + ", fileTemplateProjectId=" + fileTemplateProjectId
                + ", updatingNameDisabledForUsers=" + updatingNameDisabledForUsers + ", mavenPackageRequestsForwarding="
                + mavenPackageRequestsForwarding + ", npmPackageRequestsForwarding=" + npmPackageRequestsForwarding
                + ", virtualRegistriesEndpointsApiLimit=" + virtualRegistriesEndpointsApiLimit
                + ", auditEventsApiLimit=" + auditEventsApiLimit + ", preReceiveSecretDetectionEnabled="
                + preReceiveSecretDetectionEnabled + ", pypiPackageRequestsForwarding=" + pypiPackageRequestsForwarding
                + ", rubygemsPackageRequestsForwarding=" + rubygemsPackageRequestsForwarding + ", maintenanceMode="
                + maintenanceMode + ", maintenanceModeMessage=" + maintenanceModeMessage
                + ", serviceAccessTokensExpirationEnforced=<redacted>" + ", unconfirmedUsersDeleteAfterDays="
                + unconfirmedUsersDeleteAfterDays + ", makeProfilePrivate=" + makeProfilePrivate
                + ", builtInProjectTemplatesEnabled=" + builtInProjectTemplatesEnabled + "]";
    }
}

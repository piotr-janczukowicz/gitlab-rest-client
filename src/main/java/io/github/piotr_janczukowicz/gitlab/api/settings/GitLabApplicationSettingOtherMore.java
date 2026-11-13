package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabApplicationSetting}, flattened into it in JSON.
 *
 * @param passwordAuthenticationEnabled the password authentication enabled
 * @param passwordNumberRequired the password number required
 * @param passwordSymbolRequired the password symbol required
 * @param passwordUppercaseRequired the password uppercase required
 * @param passwordLowercaseRequired the password lowercase required
 * @param personalAccessTokenPrefix the personal access token prefix
 * @param instanceTokenPrefix the instance token prefix
 * @param instanceLevelAiBetaFeaturesEnabled the instance level ai beta features enabled
 * @param krokiEnabled the kroki enabled
 * @param krokiUrl the kroki url
 * @param krokiFormats the kroki formats
 * @param krokiDiagramProxyEnabled the kroki diagram proxy enabled
 * @param plantumlEnabled the plantuml enabled
 * @param plantumlUrl the plantuml url
 * @param plantumlDiagramProxyEnabled the plantuml diagram proxy enabled
 * @param diagramsnetEnabled the diagramsnet enabled
 * @param diagramsnetUrl the diagramsnet url
 * @param pollingIntervalMultiplier the polling interval multiplier
 * @param prometheusMetricsEnabled the prometheus metrics enabled
 * @param recaptchaEnabled the recaptcha enabled
 * @param recaptchaPrivateKey the recaptcha private key
 * @param recaptchaSiteKey the recaptcha site key
 * @param loginRecaptchaProtectionEnabled the login recaptcha protection enabled
 * @param receiveMaxInputSize the receive max input size
 * @param repositoryChecksEnabled the repository checks enabled
 * @param repositorySizeLimit the repository size limit
 * @param repositoryStoragesWeighted the repository storages weighted
 * @param rememberMeEnabled the remember me enabled
 * @param restrictedVisibilityLevels the restricted visibility levels
 * @param rsaKeyRestriction the rsa key restriction
 * @param sessionExpireDelay the session expire delay
 * @param sessionExpireFromInit the session expire from init
 * @param sharedRunnersEnabled the shared runners enabled
 * @param sharedRunnersText the shared runners text
 * @param sharedRunnersMinutes the shared runners minutes
 * @param signInRestrictions the sign in restrictions
 * @param signupEnabled the signup enabled
 * @param silentModeEnabled the silent mode enabled
 * @param silentAdminExportsEnabled the silent admin exports enabled
 * @param slackAppEnabled the slack app enabled
 * @param slackAppId the slack app id
 * @param slackAppSecret the slack app secret
 * @param slackAppSigningSecret the slack app signing secret
 * @param slackAppVerificationToken the slack app verification token
 * @param sourcegraphEnabled the sourcegraph enabled
 * @param sourcegraphUrl the sourcegraph url
 * @param sourcegraphPublicOnly the sourcegraph public only
 * @param spamCheckEndpointEnabled the spam check endpoint enabled
 * @param spamCheckEndpointUrl the spam check endpoint url
 * @param spamCheckApiKey the spam check api key
 * @param terminalMaxSessionTime the terminal max session time
 * @param terms the terms
 * @param terraformStateEncryptionEnabled the terraform state encryption enabled
 * @param topLevelGroupCreationEnabled the top level group creation enabled
 * @param protectedPathsRaw the protected paths raw
 * @param protectedPathsForGetRequestRaw the protected paths for get request raw
 * @param protectedCiVariables the protected ci variables
 * @param protectedBranchWriteLimit the protected branch write limit
 * @param timeTrackingLimitToHours the time tracking limit to hours
 * @param twoFactorGracePeriod the two factor grace period
 * @param updateRunnerVersionsEnabled the update runner versions enabled
 * @param uniqueIpsLimitEnabled the unique ips limit enabled
 * @param uniqueIpsLimitPerUser the unique ips limit per user
 * @param uniqueIpsLimitTimeWindow the unique ips limit time window
 * @param usagePingEnabled the usage ping enabled
 * @param usagePingGenerationEnabled the usage ping generation enabled
 * @param usagePingFeaturesEnabled the usage ping features enabled
 * @param useClickhouseForAnalytics the use clickhouse for analytics
 * @param useNatsForAuditStreaming the use nats for audit streaming
 * @param versionCheckEnabled the version check enabled
 * @param diffMaxPatchBytes the diff max patch bytes
 * @param diffMaxFiles the diff max files
 * @param diffMaxLines the diff max lines
 * @param diffMaxVersions the diff max versions
 * @param diffMaxCommits the diff max commits
 * @param commitEmailHostname the commit email hostname
 * @param localMarkdownVersion the local markdown version
 * @param mailgunSigningKey the mailgun signing key
 * @param mailgunEventsEnabled the mailgun events enabled
 * @param snowplowCollectorHostname the snowplow collector hostname
 * @param snowplowCookieDomain the snowplow cookie domain
 * @param snowplowDatabaseCollectorHostname the snowplow database collector hostname
 * @param snowplowEnabled the snowplow enabled
 * @param snowplowAppId the snowplow app id
 * @param gitlabProductUsageDataEnabled the gitlab product usage data enabled
 * @param gitlabDedicatedInstance the gitlab dedicated instance
 * @param gitlabEnvironmentToolkitInstance the gitlab environment toolkit instance
 * @param gitlabShellOperationLimit the gitlab shell operation limit
 * @param gitlabShellOperationPerActorLimit the gitlab shell operation per actor limit
 * @param gitlabProductUsageDataSource the gitlab product usage data source
 * @param pushEventHooksLimit the push event hooks limit
 * @param pushEventActivitiesLimit the push event activities limit
 * @param customHttpCloneUrlRoot the custom http clone url root
 * @param snippetSizeLimit the snippet size limit
 * @param descriptionAndNoteMaxSize the description and note max size
 * @param issuesCreateLimit the issues create limit
 * @param notesCreateLimit the notes create limit
 * @param notesCreateLimitAllowlistRaw the notes create limit allowlist raw
 * @param discussionsResolveLimit the discussions resolve limit
 * @param mergeRequestsCreateLimit the merge requests create limit
 * @param mergeRequestsRebaseLimit the merge requests rebase limit
 * @param environmentDeleteRowsLimitPerUser the environment delete rows limit per user
 * @param featureFlagUserListWriteBytesLimitPerUser the feature flag user list write bytes limit per user
 * @param draftNotesCreateLimit the draft notes create limit
 * @param membersDeleteLimit the members delete limit
 * @param milestoneDestroyLimit the milestone destroy limit
 * @param rawBlobRequestLimit the raw blob request limit
 * @param rawBlobRequestLimitUnauthenticated the raw blob request limit unauthenticated
 * @param releaseEvidenceCollectionsLimitPerUser the release evidence collections limit per user
 * @param releaseWritesLimitPerProject the release writes limit per project
 * @param releaseWritesLimitPerUser the release writes limit per user
 * @param wikiPageMaxContentBytes the wiki page max content bytes
 * @param wikiAsciidocAllowUriIncludes the wiki asciidoc allow uri includes
 * @param wikiReadRequestLimitUnauthenticated the wiki read request limit unauthenticated
 * @param rateLimitingResponseText the rate limiting response text
 * @param packageRegistryAllowAnyoneToPullOption the package registry allow anyone to pull option
 * @param packageRegistryCleanupPoliciesWorkerCapacity the package registry cleanup policies worker capacity
 * @param packageMetadataPurlTypes the package metadata purl types
 * @param keepLatestArtifact the keep latest artifact
 * @param whatsNewVariant the whats new variant
 * @param resourceAccessTokenNotifyInherited the resource access token notify inherited
 * @param resourceUsageLimits the resource usage limits
 * @param sentryEnabled the sentry enabled
 * @param sentryDsn the sentry dsn
 * @param sentryClientsideDsn the sentry clientside dsn
 * @param sentryEnvironment the sentry environment
 * @param sentryClientsideTracesSampleRate the sentry clientside traces sample rate
 * @param sidekiqJobLimiterMode the sidekiq job limiter mode
 * @param sidekiqJobLimiterCompressionThresholdBytes the sidekiq job limiter compression threshold bytes
 * @param sidekiqJobLimiterLimitBytes the sidekiq job limiter limit bytes
 * @param sidekiqTimezoneOverride the sidekiq timezone override
 * @param enableArtifactExternalRedirectWarningPage the enable artifact external redirect warning page
 * @param enableLanguageServerRestrictions the enable language server restrictions
 * @param enableMemberPromotionManagement the enable member promotion management
 * @param searchRateLimit the search rate limit
 * @param searchRateLimitUnauthenticated the search rate limit unauthenticated
 * @param searchRateLimitAllowlistRaw the search rate limit allowlist raw
 * @param pipelineLimitPerProjectUserSha the pipeline limit per project user sha
 * @param pipelineLimitPerUser the pipeline limit per user
 * @param pipelineCancelLimitPerUserProject the pipeline cancel limit per user project
 * @param pipelineRetryLimitPerUserProject the pipeline retry limit per user project
 * @param pipelineScheduleManagementLimitPerUser the pipeline schedule management limit per user
 * @param pipelineDeleteLimitPerUserProject the pipeline delete limit per user project
 * @param pipelineExecutionPoliciesPerConfigurationLimit the pipeline execution policies per configuration limit
 * @param invitationFlowEnforcement the invitation flow enforcement
 * @param canCreateGroup the can create group
 * @param canCreateOrganization the can create organization
 * @param bulkImportConcurrentPipelineBatchLimit the bulk import concurrent pipeline batch limit
 * @param bulkImportEnabled the bulk import enabled
 * @param bulkImportMaxDownloadFileSize the bulk import max download file size
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabApplicationSettingOtherMore(
        @Nullable String passwordAuthenticationEnabled,
        @Nullable String passwordNumberRequired,
        @Nullable String passwordSymbolRequired,
        @Nullable String passwordUppercaseRequired,
        @Nullable String passwordLowercaseRequired,
        @Nullable String personalAccessTokenPrefix,
        @Nullable String instanceTokenPrefix,
        @Nullable String instanceLevelAiBetaFeaturesEnabled,
        @Nullable String krokiEnabled,
        @Nullable String krokiUrl,
        @Nullable String krokiFormats,
        @Nullable String krokiDiagramProxyEnabled,
        @Nullable String plantumlEnabled,
        @Nullable String plantumlUrl,
        @Nullable String plantumlDiagramProxyEnabled,
        @Nullable String diagramsnetEnabled,
        @Nullable String diagramsnetUrl,
        @Nullable String pollingIntervalMultiplier,
        @Nullable String prometheusMetricsEnabled,
        @Nullable String recaptchaEnabled,
        @Nullable String recaptchaPrivateKey,
        @Nullable String recaptchaSiteKey,
        @Nullable String loginRecaptchaProtectionEnabled,
        @Nullable String receiveMaxInputSize,
        @Nullable String repositoryChecksEnabled,
        @Nullable String repositorySizeLimit,
        @Nullable String repositoryStoragesWeighted,
        @Nullable String rememberMeEnabled,
        @Nullable String restrictedVisibilityLevels,
        @Nullable String rsaKeyRestriction,
        @Nullable String sessionExpireDelay,
        @Nullable String sessionExpireFromInit,
        @Nullable String sharedRunnersEnabled,
        @Nullable String sharedRunnersText,
        @Nullable String sharedRunnersMinutes,
        @Nullable String signInRestrictions,
        @Nullable String signupEnabled,
        @Nullable String silentModeEnabled,
        @Nullable String silentAdminExportsEnabled,
        @Nullable String slackAppEnabled,
        @Nullable String slackAppId,
        @Nullable String slackAppSecret,
        @Nullable String slackAppSigningSecret,
        @Nullable String slackAppVerificationToken,
        @Nullable String sourcegraphEnabled,
        @Nullable String sourcegraphUrl,
        @Nullable String sourcegraphPublicOnly,
        @Nullable String spamCheckEndpointEnabled,
        @Nullable String spamCheckEndpointUrl,
        @Nullable String spamCheckApiKey,
        @Nullable String terminalMaxSessionTime,
        @Nullable String terms,
        @Nullable String terraformStateEncryptionEnabled,
        @Nullable String topLevelGroupCreationEnabled,
        @Nullable String protectedPathsRaw,
        @Nullable String protectedPathsForGetRequestRaw,
        @Nullable String protectedCiVariables,
        @Nullable String protectedBranchWriteLimit,
        @Nullable String timeTrackingLimitToHours,
        @Nullable String twoFactorGracePeriod,
        @Nullable String updateRunnerVersionsEnabled,
        @Nullable String uniqueIpsLimitEnabled,
        @Nullable String uniqueIpsLimitPerUser,
        @Nullable String uniqueIpsLimitTimeWindow,
        @Nullable String usagePingEnabled,
        @Nullable String usagePingGenerationEnabled,
        @Nullable String usagePingFeaturesEnabled,
        @Nullable String useClickhouseForAnalytics,
        @Nullable Boolean useNatsForAuditStreaming,
        @Nullable String versionCheckEnabled,
        @Nullable String diffMaxPatchBytes,
        @Nullable String diffMaxFiles,
        @Nullable String diffMaxLines,
        @Nullable String diffMaxVersions,
        @Nullable String diffMaxCommits,
        @Nullable String commitEmailHostname,
        @Nullable String localMarkdownVersion,
        @Nullable String mailgunSigningKey,
        @Nullable String mailgunEventsEnabled,
        @Nullable String snowplowCollectorHostname,
        @Nullable String snowplowCookieDomain,
        @Nullable String snowplowDatabaseCollectorHostname,
        @Nullable String snowplowEnabled,
        @Nullable String snowplowAppId,
        @Nullable String gitlabProductUsageDataEnabled,
        @Nullable String gitlabDedicatedInstance,
        @Nullable String gitlabEnvironmentToolkitInstance,
        @Nullable String gitlabShellOperationLimit,
        @Nullable String gitlabShellOperationPerActorLimit,
        @Nullable String gitlabProductUsageDataSource,
        @Nullable String pushEventHooksLimit,
        @Nullable String pushEventActivitiesLimit,
        @Nullable String customHttpCloneUrlRoot,
        @Nullable String snippetSizeLimit,
        @Nullable String descriptionAndNoteMaxSize,
        @Nullable String issuesCreateLimit,
        @Nullable String notesCreateLimit,
        @Nullable String notesCreateLimitAllowlistRaw,
        @Nullable String discussionsResolveLimit,
        @Nullable String mergeRequestsCreateLimit,
        @Nullable String mergeRequestsRebaseLimit,
        @Nullable String environmentDeleteRowsLimitPerUser,
        @Nullable String featureFlagUserListWriteBytesLimitPerUser,
        @Nullable String draftNotesCreateLimit,
        @Nullable String membersDeleteLimit,
        @Nullable String milestoneDestroyLimit,
        @Nullable String rawBlobRequestLimit,
        @Nullable String rawBlobRequestLimitUnauthenticated,
        @Nullable String releaseEvidenceCollectionsLimitPerUser,
        @Nullable String releaseWritesLimitPerProject,
        @Nullable String releaseWritesLimitPerUser,
        @Nullable String wikiPageMaxContentBytes,
        @Nullable String wikiAsciidocAllowUriIncludes,
        @Nullable String wikiReadRequestLimitUnauthenticated,
        @Nullable String rateLimitingResponseText,
        @Nullable String packageRegistryAllowAnyoneToPullOption,
        @Nullable String packageRegistryCleanupPoliciesWorkerCapacity,
        @Nullable String packageMetadataPurlTypes,
        @Nullable String keepLatestArtifact,
        @Nullable String whatsNewVariant,
        @Nullable String resourceAccessTokenNotifyInherited,
        @Nullable String resourceUsageLimits,
        @Nullable String sentryEnabled,
        @Nullable String sentryDsn,
        @Nullable String sentryClientsideDsn,
        @Nullable String sentryEnvironment,
        @Nullable String sentryClientsideTracesSampleRate,
        @Nullable String sidekiqJobLimiterMode,
        @Nullable String sidekiqJobLimiterCompressionThresholdBytes,
        @Nullable String sidekiqJobLimiterLimitBytes,
        @Nullable String sidekiqTimezoneOverride,
        @Nullable String enableArtifactExternalRedirectWarningPage,
        @Nullable String enableLanguageServerRestrictions,
        @Nullable String enableMemberPromotionManagement,
        @Nullable String searchRateLimit,
        @Nullable String searchRateLimitUnauthenticated,
        @Nullable String searchRateLimitAllowlistRaw,
        @Nullable String pipelineLimitPerProjectUserSha,
        @Nullable String pipelineLimitPerUser,
        @Nullable String pipelineCancelLimitPerUserProject,
        @Nullable String pipelineRetryLimitPerUserProject,
        @Nullable String pipelineScheduleManagementLimitPerUser,
        @Nullable String pipelineDeleteLimitPerUserProject,
        @Nullable String pipelineExecutionPoliciesPerConfigurationLimit,
        @Nullable String invitationFlowEnforcement,
        @Nullable String canCreateGroup,
        @Nullable String canCreateOrganization,
        @Nullable String bulkImportConcurrentPipelineBatchLimit,
        @Nullable String bulkImportEnabled,
        @Nullable String bulkImportMaxDownloadFileSize) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code passwordNumberRequired}, {@code passwordSymbolRequired},
     *     {@code passwordUppercaseRequired}, {@code passwordLowercaseRequired}, {@code personalAccessTokenPrefix},
     *     {@code instanceTokenPrefix}, {@code recaptchaPrivateKey}, {@code slackAppSecret},
     *     {@code slackAppSigningSecret}, {@code slackAppVerificationToken}, {@code resourceAccessTokenNotifyInherited}
     *     redacted
     */
    @Override
    public String toString() {
        return "GitLabApplicationSettingOtherMore[" + "passwordAuthenticationEnabled=" + passwordAuthenticationEnabled
                + ", passwordNumberRequired=<redacted>" + ", passwordSymbolRequired=<redacted>"
                + ", passwordUppercaseRequired=<redacted>" + ", passwordLowercaseRequired=<redacted>"
                + ", personalAccessTokenPrefix=<redacted>" + ", instanceTokenPrefix=<redacted>"
                + ", instanceLevelAiBetaFeaturesEnabled=" + instanceLevelAiBetaFeaturesEnabled + ", krokiEnabled="
                + krokiEnabled + ", krokiUrl=" + krokiUrl + ", krokiFormats=" + krokiFormats
                + ", krokiDiagramProxyEnabled=" + krokiDiagramProxyEnabled + ", plantumlEnabled=" + plantumlEnabled
                + ", plantumlUrl=" + plantumlUrl + ", plantumlDiagramProxyEnabled=" + plantumlDiagramProxyEnabled
                + ", diagramsnetEnabled=" + diagramsnetEnabled + ", diagramsnetUrl=" + diagramsnetUrl
                + ", pollingIntervalMultiplier=" + pollingIntervalMultiplier + ", prometheusMetricsEnabled="
                + prometheusMetricsEnabled + ", recaptchaEnabled=" + recaptchaEnabled
                + ", recaptchaPrivateKey=<redacted>" + ", recaptchaSiteKey=" + recaptchaSiteKey
                + ", loginRecaptchaProtectionEnabled=" + loginRecaptchaProtectionEnabled + ", receiveMaxInputSize="
                + receiveMaxInputSize + ", repositoryChecksEnabled=" + repositoryChecksEnabled
                + ", repositorySizeLimit=" + repositorySizeLimit + ", repositoryStoragesWeighted="
                + repositoryStoragesWeighted + ", rememberMeEnabled=" + rememberMeEnabled
                + ", restrictedVisibilityLevels=" + restrictedVisibilityLevels + ", rsaKeyRestriction="
                + rsaKeyRestriction + ", sessionExpireDelay=" + sessionExpireDelay + ", sessionExpireFromInit="
                + sessionExpireFromInit + ", sharedRunnersEnabled=" + sharedRunnersEnabled + ", sharedRunnersText="
                + sharedRunnersText + ", sharedRunnersMinutes=" + sharedRunnersMinutes + ", signInRestrictions="
                + signInRestrictions + ", signupEnabled=" + signupEnabled + ", silentModeEnabled=" + silentModeEnabled
                + ", silentAdminExportsEnabled=" + silentAdminExportsEnabled + ", slackAppEnabled=" + slackAppEnabled
                + ", slackAppId=" + slackAppId + ", slackAppSecret=<redacted>" + ", slackAppSigningSecret=<redacted>"
                + ", slackAppVerificationToken=<redacted>" + ", sourcegraphEnabled=" + sourcegraphEnabled
                + ", sourcegraphUrl=" + sourcegraphUrl + ", sourcegraphPublicOnly=" + sourcegraphPublicOnly
                + ", spamCheckEndpointEnabled=" + spamCheckEndpointEnabled + ", spamCheckEndpointUrl="
                + spamCheckEndpointUrl + ", spamCheckApiKey=" + spamCheckApiKey + ", terminalMaxSessionTime="
                + terminalMaxSessionTime + ", terms=" + terms + ", terraformStateEncryptionEnabled="
                + terraformStateEncryptionEnabled + ", topLevelGroupCreationEnabled=" + topLevelGroupCreationEnabled
                + ", protectedPathsRaw=" + protectedPathsRaw + ", protectedPathsForGetRequestRaw="
                + protectedPathsForGetRequestRaw + ", protectedCiVariables=" + protectedCiVariables
                + ", protectedBranchWriteLimit=" + protectedBranchWriteLimit + ", timeTrackingLimitToHours="
                + timeTrackingLimitToHours + ", twoFactorGracePeriod=" + twoFactorGracePeriod
                + ", updateRunnerVersionsEnabled=" + updateRunnerVersionsEnabled + ", uniqueIpsLimitEnabled="
                + uniqueIpsLimitEnabled + ", uniqueIpsLimitPerUser=" + uniqueIpsLimitPerUser
                + ", uniqueIpsLimitTimeWindow=" + uniqueIpsLimitTimeWindow + ", usagePingEnabled=" + usagePingEnabled
                + ", usagePingGenerationEnabled=" + usagePingGenerationEnabled + ", usagePingFeaturesEnabled="
                + usagePingFeaturesEnabled + ", useClickhouseForAnalytics=" + useClickhouseForAnalytics
                + ", useNatsForAuditStreaming=" + useNatsForAuditStreaming + ", versionCheckEnabled="
                + versionCheckEnabled + ", diffMaxPatchBytes=" + diffMaxPatchBytes + ", diffMaxFiles=" + diffMaxFiles
                + ", diffMaxLines=" + diffMaxLines + ", diffMaxVersions=" + diffMaxVersions + ", diffMaxCommits="
                + diffMaxCommits + ", commitEmailHostname=" + commitEmailHostname + ", localMarkdownVersion="
                + localMarkdownVersion + ", mailgunSigningKey=" + mailgunSigningKey + ", mailgunEventsEnabled="
                + mailgunEventsEnabled + ", snowplowCollectorHostname=" + snowplowCollectorHostname
                + ", snowplowCookieDomain=" + snowplowCookieDomain + ", snowplowDatabaseCollectorHostname="
                + snowplowDatabaseCollectorHostname + ", snowplowEnabled=" + snowplowEnabled + ", snowplowAppId="
                + snowplowAppId + ", gitlabProductUsageDataEnabled=" + gitlabProductUsageDataEnabled
                + ", gitlabDedicatedInstance=" + gitlabDedicatedInstance + ", gitlabEnvironmentToolkitInstance="
                + gitlabEnvironmentToolkitInstance + ", gitlabShellOperationLimit=" + gitlabShellOperationLimit
                + ", gitlabShellOperationPerActorLimit=" + gitlabShellOperationPerActorLimit
                + ", gitlabProductUsageDataSource=" + gitlabProductUsageDataSource + ", pushEventHooksLimit="
                + pushEventHooksLimit + ", pushEventActivitiesLimit=" + pushEventActivitiesLimit
                + ", customHttpCloneUrlRoot=" + customHttpCloneUrlRoot + ", snippetSizeLimit=" + snippetSizeLimit
                + ", descriptionAndNoteMaxSize=" + descriptionAndNoteMaxSize + ", issuesCreateLimit="
                + issuesCreateLimit + ", notesCreateLimit=" + notesCreateLimit + ", notesCreateLimitAllowlistRaw="
                + notesCreateLimitAllowlistRaw + ", discussionsResolveLimit=" + discussionsResolveLimit
                + ", mergeRequestsCreateLimit=" + mergeRequestsCreateLimit + ", mergeRequestsRebaseLimit="
                + mergeRequestsRebaseLimit + ", environmentDeleteRowsLimitPerUser=" + environmentDeleteRowsLimitPerUser
                + ", featureFlagUserListWriteBytesLimitPerUser=" + featureFlagUserListWriteBytesLimitPerUser
                + ", draftNotesCreateLimit=" + draftNotesCreateLimit + ", membersDeleteLimit=" + membersDeleteLimit
                + ", milestoneDestroyLimit=" + milestoneDestroyLimit + ", rawBlobRequestLimit=" + rawBlobRequestLimit
                + ", rawBlobRequestLimitUnauthenticated=" + rawBlobRequestLimitUnauthenticated
                + ", releaseEvidenceCollectionsLimitPerUser=" + releaseEvidenceCollectionsLimitPerUser
                + ", releaseWritesLimitPerProject=" + releaseWritesLimitPerProject + ", releaseWritesLimitPerUser="
                + releaseWritesLimitPerUser + ", wikiPageMaxContentBytes=" + wikiPageMaxContentBytes
                + ", wikiAsciidocAllowUriIncludes=" + wikiAsciidocAllowUriIncludes
                + ", wikiReadRequestLimitUnauthenticated=" + wikiReadRequestLimitUnauthenticated
                + ", rateLimitingResponseText=" + rateLimitingResponseText + ", packageRegistryAllowAnyoneToPullOption="
                + packageRegistryAllowAnyoneToPullOption + ", packageRegistryCleanupPoliciesWorkerCapacity="
                + packageRegistryCleanupPoliciesWorkerCapacity + ", packageMetadataPurlTypes="
                + packageMetadataPurlTypes + ", keepLatestArtifact=" + keepLatestArtifact + ", whatsNewVariant="
                + whatsNewVariant + ", resourceAccessTokenNotifyInherited=<redacted>" + ", resourceUsageLimits="
                + resourceUsageLimits + ", sentryEnabled=" + sentryEnabled + ", sentryDsn=" + sentryDsn
                + ", sentryClientsideDsn=" + sentryClientsideDsn + ", sentryEnvironment=" + sentryEnvironment
                + ", sentryClientsideTracesSampleRate=" + sentryClientsideTracesSampleRate + ", sidekiqJobLimiterMode="
                + sidekiqJobLimiterMode + ", sidekiqJobLimiterCompressionThresholdBytes="
                + sidekiqJobLimiterCompressionThresholdBytes + ", sidekiqJobLimiterLimitBytes="
                + sidekiqJobLimiterLimitBytes + ", sidekiqTimezoneOverride=" + sidekiqTimezoneOverride
                + ", enableArtifactExternalRedirectWarningPage=" + enableArtifactExternalRedirectWarningPage
                + ", enableLanguageServerRestrictions=" + enableLanguageServerRestrictions
                + ", enableMemberPromotionManagement=" + enableMemberPromotionManagement + ", searchRateLimit="
                + searchRateLimit + ", searchRateLimitUnauthenticated=" + searchRateLimitUnauthenticated
                + ", searchRateLimitAllowlistRaw=" + searchRateLimitAllowlistRaw + ", pipelineLimitPerProjectUserSha="
                + pipelineLimitPerProjectUserSha + ", pipelineLimitPerUser=" + pipelineLimitPerUser
                + ", pipelineCancelLimitPerUserProject=" + pipelineCancelLimitPerUserProject
                + ", pipelineRetryLimitPerUserProject=" + pipelineRetryLimitPerUserProject
                + ", pipelineScheduleManagementLimitPerUser=" + pipelineScheduleManagementLimitPerUser
                + ", pipelineDeleteLimitPerUserProject=" + pipelineDeleteLimitPerUserProject
                + ", pipelineExecutionPoliciesPerConfigurationLimit=" + pipelineExecutionPoliciesPerConfigurationLimit
                + ", invitationFlowEnforcement=" + invitationFlowEnforcement + ", canCreateGroup=" + canCreateGroup
                + ", canCreateOrganization=" + canCreateOrganization + ", bulkImportConcurrentPipelineBatchLimit="
                + bulkImportConcurrentPipelineBatchLimit + ", bulkImportEnabled=" + bulkImportEnabled
                + ", bulkImportMaxDownloadFileSize=" + bulkImportMaxDownloadFileSize + "]";
    }
}

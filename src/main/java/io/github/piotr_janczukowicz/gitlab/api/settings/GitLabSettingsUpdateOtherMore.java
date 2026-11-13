package io.github.piotr_janczukowicz.gitlab.api.settings;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireAtLeastIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabSettingsUpdatePayload}, flattened into it in JSON.
 *
 * @param issuesCreateLimit the issues create limit
 * @param rawBlobRequestLimit the raw blob request limit
 * @param rawBlobRequestLimitUnauthenticated the raw blob request limit unauthenticated
 * @param releaseEvidenceCollectionsLimitPerUser the release evidence collections limit per user
 * @param releaseWritesLimitPerProject the release writes limit per project
 * @param releaseWritesLimitPerUser the release writes limit per user
 * @param wikiPageMaxContentBytes the wiki page max content bytes
 * @param wikiAsciidocAllowUriIncludes the wiki asciidoc allow uri includes
 * @param wikiReadRequestLimitUnauthenticated the wiki read request limit unauthenticated
 * @param descriptionAndNoteMaxSize the description and note max size
 * @param whatsNewVariant the whats new variant
 * @param flocEnabled the floc enabled
 * @param showMigrateFromJenkinsBanner the show migrate from jenkins banner
 * @param enableArtifactExternalRedirectWarningPage the enable artifact external redirect warning page
 * @param enableLanguageServerRestrictions the enable language server restrictions
 * @param enableMemberPromotionManagement the enable member promotion management
 * @param pipelineLimitPerProjectUserSha the pipeline limit per project user sha
 * @param pipelineLimitPerUser the pipeline limit per user
 * @param pipelineCancelLimitPerUserProject the pipeline cancel limit per user project
 * @param pipelineRetryLimitPerUserProject the pipeline retry limit per user project
 * @param pipelineScheduleManagementLimitPerUser the pipeline schedule management limit per user
 * @param pipelineDeleteLimitPerUserProject the pipeline delete limit per user project
 * @param pipelineExecutionPoliciesPerConfigurationLimit the pipeline execution policies per configuration limit
 * @param jiraConnectApplicationKey the jira connect application key
 * @param jiraConnectPublicKeyStorageEnabled the jira connect public key storage enabled
 * @param jiraConnectProxyUrl the jira connect proxy url
 * @param jiraConnectDomainAllowlist the jira connect domain allowlist
 * @param jiraConnectDomainAllowlistRaw the jira connect domain allowlist raw
 * @param jiraForgeAppId the jira forge app id
 * @param jiraConnectAdditionalAudienceUrl the jira connect additional audience url
 * @param bulkImportConcurrentPipelineBatchLimit the bulk import concurrent pipeline batch limit
 * @param bulkImportEnabled the bulk import enabled
 * @param bulkImportMaxDownloadFile the bulk import max download file
 * @param bulkImportMaxDownloadFileSize the bulk import max download file size
 * @param concurrentRelationBatchExportLimit the concurrent relation batch export limit
 * @param concurrentGithubImportJobsLimit the concurrent github import jobs limit
 * @param concurrentBitbucketImportJobsLimit the concurrent bitbucket import jobs limit
 * @param concurrentBitbucketServerImportJobsLimit the concurrent bitbucket server import jobs limit
 * @param concurrentPullRequestImportJobsLimit the concurrent pull request import jobs limit
 * @param concurrentRelationExportLimit the concurrent relation export limit
 * @param autocompleteUsersLimit the autocomplete users limit
 * @param autocompleteUsersUnauthenticatedLimit the autocomplete users unauthenticated limit
 * @param gitPushPipelineLimit the git push pipeline limit
 * @param gitTwoFactorSessionExpiry the git two factor session expiry
 * @param gitRateLimitUsersAllowlist the git rate limit users allowlist
 * @param gitRateLimitUsersAlertlist the git rate limit users alertlist
 * @param securityPolicyGlobalGroupApproversEnabled the security policy global group approvers enabled
 * @param securityTxtContent the security txt content
 * @param securityScanStaleAfterDays the security scan stale after days
 * @param securityApprovalPoliciesLimit the security approval policies limit
 * @param securityMrReportCacheLifetimeMinutes the security mr report cache lifetime minutes
 * @param slackAppEnabled the slack app enabled
 * @param slackAppId the slack app id
 * @param slackAppSecret the slack app secret
 * @param slackAppSigningSecret the slack app signing secret
 * @param slackAppVerificationToken the slack app verification token
 * @param namespaceAggregationScheduleLeaseDurationInSeconds the namespace aggregation schedule lease duration in
 *     seconds
 * @param downstreamPipelineTriggerLimitPerProjectUserSha the downstream pipeline trigger limit per project user sha
 * @param jobRetryLimitPerUserProject the job retry limit per user project
 * @param jobPlayLimitPerUserProject the job play limit per user project
 * @param jobEraseLimitPerUserProject the job erase limit per user project
 * @param jobCancelLimitPerUserProject the job cancel limit per user project
 * @param aiActionApiRateLimit the ai action api rate limit
 * @param aiAuditEventsStreamingEnabled the ai audit events streaming enabled
 * @param codeSuggestionsApiRateLimit the code suggestions api rate limit
 * @param codeDropdownCustomClients the code dropdown custom clients
 * @param resourceUsageLimits the resource usage limits
 * @param resourceAccessTokenNotifyInherited the resource access token notify inherited
 * @param vscodeExtensionMarketplace the vscode extension marketplace
 * @param vscodeExtensionMarketplaceEnabled the vscode extension marketplace enabled
 * @param vscodeExtensionMarketplaceExtensionHostDomain the vscode extension marketplace extension host domain
 * @param vscodeExtensionMarketplaceSingleOriginFallbackEnabled the vscode extension marketplace single origin fallback
 *     enabled
 * @param minimumLanguageServerVersion the minimum language server version
 * @param minimumPasswordLength the minimum password length
 * @param terraformStateEncryptionEnabled the terraform state encryption enabled
 * @param loggingFieldSchemaVersion the logging field schema version
 * @param loggingFieldDualEmitTarget the logging field dual emit target
 * @param rsaKeyRestriction the rsa key restriction
 * @param dsaKeyRestriction the dsa key restriction
 * @param ecdsaKeyRestriction the ecdsa key restriction
 * @param ecdsaSkKeyRestriction the ecdsa sk key restriction
 * @param ed25519KeyRestriction the ed25519 key restriction
 * @param ed25519SkKeyRestriction the ed25519 sk key restriction
 * @param archiveBuildsInHumanReadable the archive builds in human readable
 * @param asciidocMaxIncludes the asciidoc max includes
 * @param authorizedKeysEnabled the authorized keys enabled
 * @param autoAcceptAwardedAchievements the auto accept awarded achievements
 * @param autoDevopsDomain the auto devops domain
 * @param autoDevopsEnabled the auto devops enabled
 * @param autoBanUserOnExcessiveProjectsDownload the auto ban user on excessive projects download
 * @param autoDuoCodeReviewEnabled the auto duo code review enabled
 * @param autoDuoCodeReviewOnPushEnabled the auto duo code review on push enabled
 * @param canCreateGroup the can create group
 * @param canCreateOrganization the can create organization
 * @param commitEmailHostname the commit email hostname
 * @param customHttpCloneUrlRoot the custom http clone url root
 * @param deleteInactiveProjects the delete inactive projects
 * @param deleteUnconfirmedUsers the delete unconfirmed users
 * @param deletionAdjournedPeriod the deletion adjourned period
 * @param diffMaxCommits the diff max commits
 * @param diffMaxFiles the diff max files
 * @param diffMaxLines the diff max lines
 * @param diffMaxPatchBytes the diff max patch bytes
 * @param diffMaxVersions the diff max versions
 * @param dnsRebindingProtectionEnabled the dns rebinding protection enabled
 * @param enforceTerms the enforce terms
 * @param enforceNamespaceStorageLimit the enforce namespace storage limit
 * @param enforcePiplCompliance the enforce pipl compliance
 * @param enforceCiInboundJobTokenScopeEnabled the enforce ci inbound job token scope enabled
 * @param enforceEmailSubaddressRestrictions the enforce email subaddress restrictions
 * @param enforceGranularTokens the enforce granular tokens
 * @param failedLoginAttemptsUnlockPeriodInMinutes the failed login attempts unlock period in minutes
 * @param featureFlagUserListWriteBytesLimitPerUser the feature flag user list write bytes limit per user
 * @param firstDayOfWeek the first day of week
 * @param githubGistsImportLimit the github gists import limit
 * @param gitlabDedicatedInstance the gitlab dedicated instance
 * @param gitlabEnvironmentToolkitInstance the gitlab environment toolkit instance
 * @param gitlabProductUsageDataEnabled the gitlab product usage data enabled
 * @param gitlabShellOperationLimit the gitlab shell operation limit
 * @param gitlabShellOperationPerActorLimit the gitlab shell operation per actor limit
 * @param hashedStorageEnabled the hashed storage enabled
 * @param hideThirdPartyOffers the hide third party offers
 * @param inactiveProjectsDeleteAfterMonths the inactive projects delete after months
 * @param inactiveProjectsMinSizeMb the inactive projects min size mb
 * @param inactiveProjectsSendWarningEmailAfterMonths the inactive projects send warning email after months
 * @param inactiveResourceAccessTokensDeleteAfterDays the inactive resource access tokens delete after days
 * @param includeOptionalMetricsInServicePing the include optional metrics in service ping
 * @param keepLatestArtifact the keep latest artifact
 * @param mirrorAvailable the mirror available
 * @param mirrorCapacityThreshold the mirror capacity threshold
 * @param mirrorMaxCapacity the mirror max capacity
 * @param mirrorMaxDelay the mirror max delay
 * @param notifyOnUnknownSignIn the notify on unknown sign in
 * @param offlineTransferExportsEnabled the offline transfer exports enabled
 * @param offlineTransferImportsEnabled the offline transfer imports enabled
 * @param packageRegistryAllowAnyoneToPullOption the package registry allow anyone to pull option
 * @param packageRegistryCleanupPoliciesWorkerCapacity the package registry cleanup policies worker capacity
 * @param packageMetadataPurlTypes the package metadata purl types
 * @param pagesDomainVerificationEnabled the pages domain verification enabled
 * @param pagesUniqueDomainDefaultEnabled the pages unique domain default enabled
 * @param pagesExtraDeploymentsDefaultExpirySeconds the pages extra deployments default expiry seconds
 * @param pagesDeploymentsApiLimit the pages deployments api limit
 * @param projectsApiRateLimitUnauthenticated the projects api rate limit unauthenticated
 * @param projectsApiLimit the projects api limit
 * @param protectedCiVariables the protected ci variables
 * @param protectedPathsRaw the protected paths raw
 * @param protectedPathsForGetRequestRaw the protected paths for get request raw
 * @param protectedBranchWriteLimit the protected branch write limit
 * @param rateLimitingResponseText the rate limiting response text
 * @param receiveMaxInputSize the receive max input size
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabSettingsUpdateOtherMore(
        @Nullable Integer issuesCreateLimit,
        @Nullable Integer rawBlobRequestLimit,
        @Nullable Integer rawBlobRequestLimitUnauthenticated,
        @Nullable Integer releaseEvidenceCollectionsLimitPerUser,
        @Nullable Integer releaseWritesLimitPerProject,
        @Nullable Integer releaseWritesLimitPerUser,
        @Nullable Long wikiPageMaxContentBytes,
        @Nullable Boolean wikiAsciidocAllowUriIncludes,
        @Nullable String wikiReadRequestLimitUnauthenticated,
        @Nullable Long descriptionAndNoteMaxSize,
        @Nullable GitLabSettingsUpdateWhatsNewVariant whatsNewVariant,
        @Nullable Boolean flocEnabled,
        @Nullable Boolean showMigrateFromJenkinsBanner,
        @Nullable Boolean enableArtifactExternalRedirectWarningPage,
        @Nullable Boolean enableLanguageServerRestrictions,
        @Nullable String enableMemberPromotionManagement,
        @Nullable Integer pipelineLimitPerProjectUserSha,
        @Nullable Integer pipelineLimitPerUser,
        @Nullable Integer pipelineCancelLimitPerUserProject,
        @Nullable Integer pipelineRetryLimitPerUserProject,
        @Nullable Integer pipelineScheduleManagementLimitPerUser,
        @Nullable Integer pipelineDeleteLimitPerUserProject,
        @Nullable String pipelineExecutionPoliciesPerConfigurationLimit,
        @Nullable String jiraConnectApplicationKey,
        @Nullable Boolean jiraConnectPublicKeyStorageEnabled,
        @Nullable String jiraConnectProxyUrl,
        @Nullable List<String> jiraConnectDomainAllowlist,
        @Nullable String jiraConnectDomainAllowlistRaw,
        @Nullable String jiraForgeAppId,
        @Nullable String jiraConnectAdditionalAudienceUrl,
        @Nullable Integer bulkImportConcurrentPipelineBatchLimit,
        @Nullable Boolean bulkImportEnabled,
        @Nullable Integer bulkImportMaxDownloadFile,
        @Nullable String bulkImportMaxDownloadFileSize,
        @Nullable Integer concurrentRelationBatchExportLimit,
        @Nullable Integer concurrentGithubImportJobsLimit,
        @Nullable Integer concurrentBitbucketImportJobsLimit,
        @Nullable Integer concurrentBitbucketServerImportJobsLimit,
        @Nullable Integer concurrentPullRequestImportJobsLimit,
        @Nullable String concurrentRelationExportLimit,
        @Nullable Integer autocompleteUsersLimit,
        @Nullable Integer autocompleteUsersUnauthenticatedLimit,
        @Nullable Integer gitPushPipelineLimit,
        @Nullable Integer gitTwoFactorSessionExpiry,
        @Nullable List<String> gitRateLimitUsersAllowlist,
        @Nullable List<Integer> gitRateLimitUsersAlertlist,
        @Nullable Boolean securityPolicyGlobalGroupApproversEnabled,
        @Nullable String securityTxtContent,
        @Nullable Integer securityScanStaleAfterDays,
        @Nullable String securityApprovalPoliciesLimit,
        @Nullable String securityMrReportCacheLifetimeMinutes,
        @Nullable Boolean slackAppEnabled,
        @Nullable String slackAppId,
        @Nullable String slackAppSecret,
        @Nullable String slackAppSigningSecret,
        @Nullable String slackAppVerificationToken,
        @Nullable Integer namespaceAggregationScheduleLeaseDurationInSeconds,
        @Nullable Integer downstreamPipelineTriggerLimitPerProjectUserSha,
        @Nullable Integer jobRetryLimitPerUserProject,
        @Nullable Integer jobPlayLimitPerUserProject,
        @Nullable Integer jobEraseLimitPerUserProject,
        @Nullable Integer jobCancelLimitPerUserProject,
        @Nullable Integer aiActionApiRateLimit,
        @Nullable String aiAuditEventsStreamingEnabled,
        @Nullable Integer codeSuggestionsApiRateLimit,
        @Nullable List<GitLabSettingsUpdateCodeDropdownCustomClient> codeDropdownCustomClients,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> resourceUsageLimits,

        @Nullable String resourceAccessTokenNotifyInherited,
        @Nullable GitLabSettingsUpdateVscodeExtensionMarketplace vscodeExtensionMarketplace,
        @Nullable String vscodeExtensionMarketplaceEnabled,
        @Nullable String vscodeExtensionMarketplaceExtensionHostDomain,
        @Nullable String vscodeExtensionMarketplaceSingleOriginFallbackEnabled,
        @Nullable String minimumLanguageServerVersion,
        @Nullable String minimumPasswordLength,
        @Nullable Boolean terraformStateEncryptionEnabled,
        @Nullable GitLabSettingsUpdateLoggingFieldSchemaVersion loggingFieldSchemaVersion,
        @Nullable GitLabSettingsUpdateLoggingFieldDualEmitTarget loggingFieldDualEmitTarget,
        @Nullable GitLabSettingsUpdateRsaKeyRestriction rsaKeyRestriction,
        @Nullable GitLabSettingsUpdateDsaKeyRestriction dsaKeyRestriction,
        @Nullable GitLabSettingsUpdateEcdsaKeyRestriction ecdsaKeyRestriction,
        @Nullable GitLabSettingsUpdateEcdsaSkKeyRestriction ecdsaSkKeyRestriction,
        @Nullable GitLabSettingsUpdateEd25519KeyRestriction ed25519KeyRestriction,
        @Nullable GitLabSettingsUpdateEd25519SkKeyRestriction ed25519SkKeyRestriction,
        @Nullable String archiveBuildsInHumanReadable,
        @Nullable String asciidocMaxIncludes,
        @Nullable String authorizedKeysEnabled,
        @Nullable String autoAcceptAwardedAchievements,
        @Nullable String autoDevopsDomain,
        @Nullable String autoDevopsEnabled,
        @Nullable Boolean autoBanUserOnExcessiveProjectsDownload,
        @Nullable Boolean autoDuoCodeReviewEnabled,
        @Nullable String autoDuoCodeReviewOnPushEnabled,
        @Nullable String canCreateGroup,
        @Nullable String canCreateOrganization,
        @Nullable String commitEmailHostname,
        @Nullable String customHttpCloneUrlRoot,
        @Nullable String deleteInactiveProjects,
        @Nullable String deleteUnconfirmedUsers,
        @Nullable String deletionAdjournedPeriod,
        @Nullable String diffMaxCommits,
        @Nullable String diffMaxFiles,
        @Nullable String diffMaxLines,
        @Nullable String diffMaxPatchBytes,
        @Nullable String diffMaxVersions,
        @Nullable String dnsRebindingProtectionEnabled,
        @Nullable String enforceTerms,
        @Nullable String enforceNamespaceStorageLimit,
        @Nullable String enforcePiplCompliance,
        @Nullable String enforceCiInboundJobTokenScopeEnabled,
        @Nullable String enforceEmailSubaddressRestrictions,
        @Nullable String enforceGranularTokens,
        @Nullable String failedLoginAttemptsUnlockPeriodInMinutes,
        @Nullable Integer featureFlagUserListWriteBytesLimitPerUser,
        @Nullable String firstDayOfWeek,
        @Nullable String githubGistsImportLimit,
        @Nullable String gitlabDedicatedInstance,
        @Nullable String gitlabEnvironmentToolkitInstance,
        @Nullable String gitlabProductUsageDataEnabled,
        @Nullable String gitlabShellOperationLimit,
        @Nullable Integer gitlabShellOperationPerActorLimit,
        @Nullable String hashedStorageEnabled,
        @Nullable String hideThirdPartyOffers,
        @Nullable String inactiveProjectsDeleteAfterMonths,
        @Nullable String inactiveProjectsMinSizeMb,
        @Nullable String inactiveProjectsSendWarningEmailAfterMonths,
        @Nullable String inactiveResourceAccessTokensDeleteAfterDays,
        @Nullable String includeOptionalMetricsInServicePing,
        @Nullable String keepLatestArtifact,
        @Nullable String mirrorAvailable,
        @Nullable String mirrorCapacityThreshold,
        @Nullable String mirrorMaxCapacity,
        @Nullable String mirrorMaxDelay,
        @Nullable String notifyOnUnknownSignIn,
        @Nullable String offlineTransferExportsEnabled,
        @Nullable String offlineTransferImportsEnabled,
        @Nullable String packageRegistryAllowAnyoneToPullOption,
        @Nullable String packageRegistryCleanupPoliciesWorkerCapacity,
        @Nullable String packageMetadataPurlTypes,
        @Nullable String pagesDomainVerificationEnabled,
        @Nullable String pagesUniqueDomainDefaultEnabled,
        @Nullable String pagesExtraDeploymentsDefaultExpirySeconds,
        @Nullable String pagesDeploymentsApiLimit,
        @Nullable String projectsApiRateLimitUnauthenticated,
        @Nullable String projectsApiLimit,
        @Nullable String protectedCiVariables,
        @Nullable String protectedPathsRaw,
        @Nullable String protectedPathsForGetRequestRaw,
        @Nullable String protectedBranchWriteLimit,
        @Nullable String rateLimitingResponseText,
        @Nullable String receiveMaxInputSize) {
    public GitLabSettingsUpdateOtherMore {
        if (jiraConnectDomainAllowlist != null) {
            jiraConnectDomainAllowlist = List.copyOf(jiraConnectDomainAllowlist);
        }
        if (gitRateLimitUsersAllowlist != null) {
            gitRateLimitUsersAllowlist = List.copyOf(gitRateLimitUsersAllowlist);
        }
        if (gitRateLimitUsersAlertlist != null) {
            gitRateLimitUsersAlertlist = List.copyOf(gitRateLimitUsersAlertlist);
        }
        requireAtLeastIfPresent(aiActionApiRateLimit, 1, "aiActionApiRateLimit");
        if (codeDropdownCustomClients != null) {
            codeDropdownCustomClients = List.copyOf(codeDropdownCustomClients);
        }
        if (resourceUsageLimits != null) {
            resourceUsageLimits = Map.copyOf(resourceUsageLimits);
        }
    }

    /**
     * Describes this record without its secret.
     *
     * @return text with {@code slackAppSecret}, {@code slackAppSigningSecret}, {@code slackAppVerificationToken},
     *     {@code resourceAccessTokenNotifyInherited}, {@code minimumPasswordLength}, {@code enforceGranularTokens},
     *     {@code inactiveResourceAccessTokensDeleteAfterDays} redacted
     */
    @Override
    public String toString() {
        return "GitLabSettingsUpdateOtherMore[" + "issuesCreateLimit=" + issuesCreateLimit + ", rawBlobRequestLimit="
                + rawBlobRequestLimit + ", rawBlobRequestLimitUnauthenticated=" + rawBlobRequestLimitUnauthenticated
                + ", releaseEvidenceCollectionsLimitPerUser=" + releaseEvidenceCollectionsLimitPerUser
                + ", releaseWritesLimitPerProject=" + releaseWritesLimitPerProject + ", releaseWritesLimitPerUser="
                + releaseWritesLimitPerUser + ", wikiPageMaxContentBytes=" + wikiPageMaxContentBytes
                + ", wikiAsciidocAllowUriIncludes=" + wikiAsciidocAllowUriIncludes
                + ", wikiReadRequestLimitUnauthenticated=" + wikiReadRequestLimitUnauthenticated
                + ", descriptionAndNoteMaxSize=" + descriptionAndNoteMaxSize + ", whatsNewVariant=" + whatsNewVariant
                + ", flocEnabled=" + flocEnabled + ", showMigrateFromJenkinsBanner=" + showMigrateFromJenkinsBanner
                + ", enableArtifactExternalRedirectWarningPage=" + enableArtifactExternalRedirectWarningPage
                + ", enableLanguageServerRestrictions=" + enableLanguageServerRestrictions
                + ", enableMemberPromotionManagement=" + enableMemberPromotionManagement
                + ", pipelineLimitPerProjectUserSha=" + pipelineLimitPerProjectUserSha + ", pipelineLimitPerUser="
                + pipelineLimitPerUser + ", pipelineCancelLimitPerUserProject=" + pipelineCancelLimitPerUserProject
                + ", pipelineRetryLimitPerUserProject=" + pipelineRetryLimitPerUserProject
                + ", pipelineScheduleManagementLimitPerUser=" + pipelineScheduleManagementLimitPerUser
                + ", pipelineDeleteLimitPerUserProject=" + pipelineDeleteLimitPerUserProject
                + ", pipelineExecutionPoliciesPerConfigurationLimit=" + pipelineExecutionPoliciesPerConfigurationLimit
                + ", jiraConnectApplicationKey=" + jiraConnectApplicationKey + ", jiraConnectPublicKeyStorageEnabled="
                + jiraConnectPublicKeyStorageEnabled + ", jiraConnectProxyUrl=" + jiraConnectProxyUrl
                + ", jiraConnectDomainAllowlist=" + jiraConnectDomainAllowlist + ", jiraConnectDomainAllowlistRaw="
                + jiraConnectDomainAllowlistRaw + ", jiraForgeAppId=" + jiraForgeAppId
                + ", jiraConnectAdditionalAudienceUrl=" + jiraConnectAdditionalAudienceUrl
                + ", bulkImportConcurrentPipelineBatchLimit=" + bulkImportConcurrentPipelineBatchLimit
                + ", bulkImportEnabled=" + bulkImportEnabled + ", bulkImportMaxDownloadFile="
                + bulkImportMaxDownloadFile + ", bulkImportMaxDownloadFileSize=" + bulkImportMaxDownloadFileSize
                + ", concurrentRelationBatchExportLimit=" + concurrentRelationBatchExportLimit
                + ", concurrentGithubImportJobsLimit=" + concurrentGithubImportJobsLimit
                + ", concurrentBitbucketImportJobsLimit=" + concurrentBitbucketImportJobsLimit
                + ", concurrentBitbucketServerImportJobsLimit=" + concurrentBitbucketServerImportJobsLimit
                + ", concurrentPullRequestImportJobsLimit=" + concurrentPullRequestImportJobsLimit
                + ", concurrentRelationExportLimit=" + concurrentRelationExportLimit + ", autocompleteUsersLimit="
                + autocompleteUsersLimit + ", autocompleteUsersUnauthenticatedLimit="
                + autocompleteUsersUnauthenticatedLimit + ", gitPushPipelineLimit=" + gitPushPipelineLimit
                + ", gitTwoFactorSessionExpiry=" + gitTwoFactorSessionExpiry + ", gitRateLimitUsersAllowlist="
                + gitRateLimitUsersAllowlist + ", gitRateLimitUsersAlertlist=" + gitRateLimitUsersAlertlist
                + ", securityPolicyGlobalGroupApproversEnabled=" + securityPolicyGlobalGroupApproversEnabled
                + ", securityTxtContent=" + securityTxtContent + ", securityScanStaleAfterDays="
                + securityScanStaleAfterDays + ", securityApprovalPoliciesLimit=" + securityApprovalPoliciesLimit
                + ", securityMrReportCacheLifetimeMinutes=" + securityMrReportCacheLifetimeMinutes
                + ", slackAppEnabled=" + slackAppEnabled + ", slackAppId=" + slackAppId + ", slackAppSecret=<redacted>"
                + ", slackAppSigningSecret=<redacted>" + ", slackAppVerificationToken=<redacted>"
                + ", namespaceAggregationScheduleLeaseDurationInSeconds="
                + namespaceAggregationScheduleLeaseDurationInSeconds
                + ", downstreamPipelineTriggerLimitPerProjectUserSha=" + downstreamPipelineTriggerLimitPerProjectUserSha
                + ", jobRetryLimitPerUserProject=" + jobRetryLimitPerUserProject + ", jobPlayLimitPerUserProject="
                + jobPlayLimitPerUserProject + ", jobEraseLimitPerUserProject=" + jobEraseLimitPerUserProject
                + ", jobCancelLimitPerUserProject=" + jobCancelLimitPerUserProject + ", aiActionApiRateLimit="
                + aiActionApiRateLimit + ", aiAuditEventsStreamingEnabled=" + aiAuditEventsStreamingEnabled
                + ", codeSuggestionsApiRateLimit=" + codeSuggestionsApiRateLimit + ", codeDropdownCustomClients="
                + codeDropdownCustomClients + ", resourceUsageLimits=" + resourceUsageLimits
                + ", resourceAccessTokenNotifyInherited=<redacted>" + ", vscodeExtensionMarketplace="
                + vscodeExtensionMarketplace + ", vscodeExtensionMarketplaceEnabled="
                + vscodeExtensionMarketplaceEnabled + ", vscodeExtensionMarketplaceExtensionHostDomain="
                + vscodeExtensionMarketplaceExtensionHostDomain
                + ", vscodeExtensionMarketplaceSingleOriginFallbackEnabled="
                + vscodeExtensionMarketplaceSingleOriginFallbackEnabled + ", minimumLanguageServerVersion="
                + minimumLanguageServerVersion + ", minimumPasswordLength=<redacted>"
                + ", terraformStateEncryptionEnabled=" + terraformStateEncryptionEnabled
                + ", loggingFieldSchemaVersion=" + loggingFieldSchemaVersion + ", loggingFieldDualEmitTarget="
                + loggingFieldDualEmitTarget + ", rsaKeyRestriction=" + rsaKeyRestriction + ", dsaKeyRestriction="
                + dsaKeyRestriction + ", ecdsaKeyRestriction=" + ecdsaKeyRestriction + ", ecdsaSkKeyRestriction="
                + ecdsaSkKeyRestriction + ", ed25519KeyRestriction=" + ed25519KeyRestriction
                + ", ed25519SkKeyRestriction=" + ed25519SkKeyRestriction + ", archiveBuildsInHumanReadable="
                + archiveBuildsInHumanReadable + ", asciidocMaxIncludes=" + asciidocMaxIncludes
                + ", authorizedKeysEnabled=" + authorizedKeysEnabled + ", autoAcceptAwardedAchievements="
                + autoAcceptAwardedAchievements + ", autoDevopsDomain=" + autoDevopsDomain + ", autoDevopsEnabled="
                + autoDevopsEnabled + ", autoBanUserOnExcessiveProjectsDownload="
                + autoBanUserOnExcessiveProjectsDownload + ", autoDuoCodeReviewEnabled=" + autoDuoCodeReviewEnabled
                + ", autoDuoCodeReviewOnPushEnabled=" + autoDuoCodeReviewOnPushEnabled + ", canCreateGroup="
                + canCreateGroup + ", canCreateOrganization=" + canCreateOrganization + ", commitEmailHostname="
                + commitEmailHostname + ", customHttpCloneUrlRoot=" + customHttpCloneUrlRoot
                + ", deleteInactiveProjects=" + deleteInactiveProjects + ", deleteUnconfirmedUsers="
                + deleteUnconfirmedUsers + ", deletionAdjournedPeriod=" + deletionAdjournedPeriod + ", diffMaxCommits="
                + diffMaxCommits + ", diffMaxFiles=" + diffMaxFiles + ", diffMaxLines=" + diffMaxLines
                + ", diffMaxPatchBytes=" + diffMaxPatchBytes + ", diffMaxVersions=" + diffMaxVersions
                + ", dnsRebindingProtectionEnabled=" + dnsRebindingProtectionEnabled + ", enforceTerms=" + enforceTerms
                + ", enforceNamespaceStorageLimit=" + enforceNamespaceStorageLimit + ", enforcePiplCompliance="
                + enforcePiplCompliance + ", enforceCiInboundJobTokenScopeEnabled="
                + enforceCiInboundJobTokenScopeEnabled + ", enforceEmailSubaddressRestrictions="
                + enforceEmailSubaddressRestrictions + ", enforceGranularTokens=<redacted>"
                + ", failedLoginAttemptsUnlockPeriodInMinutes=" + failedLoginAttemptsUnlockPeriodInMinutes
                + ", featureFlagUserListWriteBytesLimitPerUser=" + featureFlagUserListWriteBytesLimitPerUser
                + ", firstDayOfWeek=" + firstDayOfWeek + ", githubGistsImportLimit=" + githubGistsImportLimit
                + ", gitlabDedicatedInstance=" + gitlabDedicatedInstance + ", gitlabEnvironmentToolkitInstance="
                + gitlabEnvironmentToolkitInstance + ", gitlabProductUsageDataEnabled=" + gitlabProductUsageDataEnabled
                + ", gitlabShellOperationLimit=" + gitlabShellOperationLimit + ", gitlabShellOperationPerActorLimit="
                + gitlabShellOperationPerActorLimit + ", hashedStorageEnabled=" + hashedStorageEnabled
                + ", hideThirdPartyOffers=" + hideThirdPartyOffers + ", inactiveProjectsDeleteAfterMonths="
                + inactiveProjectsDeleteAfterMonths + ", inactiveProjectsMinSizeMb=" + inactiveProjectsMinSizeMb
                + ", inactiveProjectsSendWarningEmailAfterMonths=" + inactiveProjectsSendWarningEmailAfterMonths
                + ", inactiveResourceAccessTokensDeleteAfterDays=<redacted>" + ", includeOptionalMetricsInServicePing="
                + includeOptionalMetricsInServicePing + ", keepLatestArtifact=" + keepLatestArtifact
                + ", mirrorAvailable=" + mirrorAvailable + ", mirrorCapacityThreshold=" + mirrorCapacityThreshold
                + ", mirrorMaxCapacity=" + mirrorMaxCapacity + ", mirrorMaxDelay=" + mirrorMaxDelay
                + ", notifyOnUnknownSignIn=" + notifyOnUnknownSignIn + ", offlineTransferExportsEnabled="
                + offlineTransferExportsEnabled + ", offlineTransferImportsEnabled=" + offlineTransferImportsEnabled
                + ", packageRegistryAllowAnyoneToPullOption=" + packageRegistryAllowAnyoneToPullOption
                + ", packageRegistryCleanupPoliciesWorkerCapacity=" + packageRegistryCleanupPoliciesWorkerCapacity
                + ", packageMetadataPurlTypes=" + packageMetadataPurlTypes + ", pagesDomainVerificationEnabled="
                + pagesDomainVerificationEnabled + ", pagesUniqueDomainDefaultEnabled="
                + pagesUniqueDomainDefaultEnabled + ", pagesExtraDeploymentsDefaultExpirySeconds="
                + pagesExtraDeploymentsDefaultExpirySeconds + ", pagesDeploymentsApiLimit=" + pagesDeploymentsApiLimit
                + ", projectsApiRateLimitUnauthenticated=" + projectsApiRateLimitUnauthenticated + ", projectsApiLimit="
                + projectsApiLimit + ", protectedCiVariables=" + protectedCiVariables + ", protectedPathsRaw="
                + protectedPathsRaw + ", protectedPathsForGetRequestRaw=" + protectedPathsForGetRequestRaw
                + ", protectedBranchWriteLimit=" + protectedBranchWriteLimit + ", rateLimitingResponseText="
                + rateLimitingResponseText + ", receiveMaxInputSize=" + receiveMaxInputSize + "]";
    }
}

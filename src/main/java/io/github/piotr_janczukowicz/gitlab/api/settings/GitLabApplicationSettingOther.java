package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabApplicationSetting}, flattened into it in JSON.
 *
 * @param id the id
 * @param performanceBarAllowedGroupId the performance bar allowed group id
 * @param abuseNotificationEmail the abuse notification email
 * @param adminMode the admin mode
 * @param afterSignOutPath the after sign out path
 * @param afterSignUpText the after sign up text
 * @param akismetApiKey the akismet api key
 * @param akismetEnabled the akismet enabled
 * @param dnsRebindingProtectionEnabled the dns rebinding protection enabled
 * @param archiveBuildsInHumanReadable the archive builds in human readable
 * @param assetProxyEnabled the asset proxy enabled
 * @param assetProxyUrl the asset proxy url
 * @param assetProxyAllowlist the asset proxy allowlist
 * @param assetProxyWhitelist the asset proxy whitelist
 * @param staticObjectsExternalStorageAuthToken the static objects external storage auth token
 * @param staticObjectsExternalStorageUrl the static objects external storage url
 * @param authnDataRetentionCleanupEnabled the authn data retention cleanup enabled
 * @param authorizedKeysEnabled the authorized keys enabled
 * @param autoDevopsEnabled the auto devops enabled
 * @param autoDevopsDomain the auto devops domain
 * @param autoAcceptAwardedAchievements the auto accept awarded achievements
 * @param autoBanUserOnExcessiveProjectsDownload the auto ban user on excessive projects download
 * @param autoDuoCodeReviewEnabled the auto duo code review enabled
 * @param autocompleteUsersLimit the autocomplete users limit
 * @param autocompleteUsersUnauthenticatedLimit the autocomplete users unauthenticated limit
 * @param codeDropdownCustomClients the code dropdown custom clients
 * @param codeSuggestionsApiRateLimit the code suggestions api rate limit
 * @param concurrentGithubImportJobsLimit the concurrent github import jobs limit
 * @param concurrentBitbucketImportJobsLimit the concurrent bitbucket import jobs limit
 * @param concurrentBitbucketServerImportJobsLimit the concurrent bitbucket server import jobs limit
 * @param concurrentPullRequestImportJobsLimit the concurrent pull request import jobs limit
 * @param concurrentRelationBatchExportLimit the concurrent relation batch export limit
 * @param concurrentRelationExportLimit the concurrent relation export limit
 * @param importJobsConcurrencyLimit the import jobs concurrency limit
 * @param importSources the import sources
 * @param oauthAccessTokenExpiresIn the oauth access token expires in
 * @param decompressArchiveFileTimeout the decompress archive file timeout
 * @param deleteInactiveProjects the delete inactive projects
 * @param deleteUnconfirmedUsers the delete unconfirmed users
 * @param deletionAdjournedPeriod the deletion adjourned period
 * @param denyAllRequestsExceptAllowed the deny all requests except allowed
 * @param dependencyManagementSettings the dependency management settings
 * @param dependencyFirewallPoliciesPerConfigurationLimit the dependency firewall policies per configuration limit
 * @param dependencyScanningSbomScanApiUploadLimit the dependency scanning sbom scan api upload limit
 * @param dependencyScanningSbomScanApiDownloadLimit the dependency scanning sbom scan api download limit
 * @param disableAdminOauthScopes the disable admin oauth scopes
 * @param disableFeedToken the disable feed token
 * @param disablePasswordAuthenticationForUsersWithSsoIdentities the disable password authentication for users with sso
 *     identities
 * @param disableOverridingApproversPerMergeRequest the disable overriding approvers per merge request
 * @param disablePersonalAccessTokens the disable personal access tokens
 * @param blockJwtForReclaimedPaths the block jwt for reclaimed paths
 * @param rootMovedPermanentlyRedirection the root moved permanently redirection
 * @param disabledOauthSignInSources the disabled oauth sign in sources
 * @param disabledDirectCodeSuggestions the disabled direct code suggestions
 * @param domainDenylist the domain denylist
 * @param domainDenylistEnabled the domain denylist enabled
 * @param domainDenylistRaw the domain denylist raw
 * @param domainAllowlist the domain allowlist
 * @param domainAllowlistRaw the domain allowlist raw
 * @param outboundLocalRequestsAllowlistRaw the outbound local requests allowlist raw
 * @param outboundLocalRequestsWhitelist the outbound local requests whitelist
 * @param dsaKeyRestriction the dsa key restriction
 * @param ecdsaKeyRestriction the ecdsa key restriction
 * @param ecdsaSkKeyRestriction the ecdsa sk key restriction
 * @param ed25519KeyRestriction the ed25519 key restriction
 * @param ed25519SkKeyRestriction the ed25519 sk key restriction
 * @param eksIntegrationEnabled the eks integration enabled
 * @param eksAccountId the eks account id
 * @param eksAccessKeyId the eks access key id
 * @param emailAuthorInBody the email author in body
 * @param emailConfirmationSetting the email confirmation setting
 * @param emailOtpEnabled the email otp enabled
 * @param emailRestrictionsEnabled the email restrictions enabled
 * @param emailRestrictions the email restrictions
 * @param emailAdditionalText the email additional text
 * @param enabledGitAccessProtocol the enabled git access protocol
 * @param enabledExpandedLogging the enabled expanded logging
 * @param enforceCiInboundJobTokenScopeEnabled the enforce ci inbound job token scope enabled
 * @param enforceEmailSubaddressRestrictions the enforce email subaddress restrictions
 * @param enforceTerms the enforce terms
 * @param enforceGranularTokens the enforce granular tokens
 * @param enforceNamespaceStorageLimit the enforce namespace storage limit
 * @param enforcePiplCompliance the enforce pipl compliance
 * @param requireEmailVerificationOnAccountLocked the require email verification on account locked
 * @param requireShaForMerge the require sha for merge
 * @param requireAdminApprovalAfterUserSignup the require admin approval after user signup
 * @param requireAdminTwoFactorAuthentication the require admin two factor authentication
 * @param requireTwoFactorAuthentication the require two factor authentication
 * @param requirePersonalAccessTokenExpiry the require personal access token expiry
 * @param errorTrackingEnabled the error tracking enabled
 * @param errorTrackingApiUrl the error tracking api url
 * @param failedLoginAttemptsUnlockPeriodInMinutes the failed login attempts unlock period in minutes
 * @param firstDayOfWeek the first day of week
 * @param flocEnabled the floc enabled
 * @param forcePagesAccessControl the force pages access control
 * @param gitalyTimeoutDefault the gitaly timeout default
 * @param gitalyTimeoutMedium the gitaly timeout medium
 * @param gitalyTimeoutFast the gitaly timeout fast
 * @param gitpodEnabled the gitpod enabled
 * @param gitpodUrl the gitpod url
 * @param grafanaEnabled the grafana enabled
 * @param grafanaUrl the grafana url
 * @param gravatarEnabled the gravatar enabled
 * @param hashedStorageEnabled the hashed storage enabled
 * @param helpPageHideCommercialContent the help page hide commercial content
 * @param helpPageSupportUrl the help page support url
 * @param helpPageDocumentationBaseUrl the help page documentation base url
 * @param helpPageText the help page text
 * @param hideThirdPartyOffers the hide third party offers
 * @param homePageUrl the home page url
 * @param housekeepingEnabled the housekeeping enabled
 * @param housekeepingFullRepackPeriod the housekeeping full repack period
 * @param housekeepingGcPeriod the housekeeping gc period
 * @param housekeepingIncrementalRepackPeriod the housekeeping incremental repack period
 * @param housekeepingOptimizeRepositoryPeriod the housekeeping optimize repository period
 * @param housekeepingBitmapsEnabled the housekeeping bitmaps enabled
 * @param htmlEmailsEnabled the html emails enabled
 * @param iframeRenderingEnabled the iframe rendering enabled
 * @param iframeRenderingAllowlist the iframe rendering allowlist
 * @param iframeRenderingAllowlistRaw the iframe rendering allowlist raw
 * @param inactiveResourceAccessTokensDeleteAfterDays the inactive resource access tokens delete after days
 * @param inactiveProjectsDeleteAfterMonths the inactive projects delete after months
 * @param inactiveProjectsMinSizeMb the inactive projects min size mb
 * @param inactiveProjectsSendWarningEmailAfterMonths the inactive projects send warning email after months
 * @param includeOptionalMetricsInServicePing the include optional metrics in service ping
 * @param invisibleCaptchaEnabled the invisible captcha enabled
 * @param jiraConnectApplicationKey the jira connect application key
 * @param jiraConnectPublicKeyStorageEnabled the jira connect public key storage enabled
 * @param jiraConnectProxyUrl the jira connect proxy url
 * @param jiraConnectAdditionalAudienceUrl the jira connect additional audience url
 * @param jiraConnectDomainAllowlist the jira connect domain allowlist
 * @param jiraConnectDomainAllowlistRaw the jira connect domain allowlist raw
 * @param jiraForgeAppId the jira forge app id
 * @param mathRenderingLimitsEnabled the math rendering limits enabled
 * @param metricsMethodCallThreshold the metrics method call threshold
 * @param minimumPasswordLength the minimum password length
 * @param minimumLanguageServerVersion the minimum language server version
 * @param mirrorAvailable the mirror available
 * @param mirrorMaxCapacity the mirror max capacity
 * @param mirrorMaxDelay the mirror max delay
 * @param mirrorCapacityThreshold the mirror capacity threshold
 * @param notifyOnUnknownSignIn the notify on unknown sign in
 * @param o11yProvisionerUrl the o11y provisioner url
 * @param organizationClusterAgentAuthorizationEnabled the organization cluster agent authorization enabled
 * @param pagesDomainVerificationEnabled the pages domain verification enabled
 * @param pagesUniqueDomainDefaultEnabled the pages unique domain default enabled
 * @param pagesExtraDeploymentsDefaultExpirySeconds the pages extra deployments default expiry seconds
 * @param pagesDeploymentsApiLimit the pages deployments api limit
 * @param passwordAuthenticationEnabledForWeb the password authentication enabled for web
 * @param passwordAuthenticationEnabledForGit the password authentication enabled for git
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabApplicationSettingOther(
        @Nullable String id,
        @Nullable String performanceBarAllowedGroupId,
        @Nullable String abuseNotificationEmail,
        @Nullable String adminMode,
        @Nullable String afterSignOutPath,
        @Nullable String afterSignUpText,
        @Nullable String akismetApiKey,
        @Nullable String akismetEnabled,
        @Nullable String dnsRebindingProtectionEnabled,
        @Nullable String archiveBuildsInHumanReadable,
        @Nullable String assetProxyEnabled,
        @Nullable String assetProxyUrl,
        @Nullable String assetProxyAllowlist,
        @Nullable String assetProxyWhitelist,
        @Nullable String staticObjectsExternalStorageAuthToken,
        @Nullable String staticObjectsExternalStorageUrl,
        @Nullable String authnDataRetentionCleanupEnabled,
        @Nullable String authorizedKeysEnabled,
        @Nullable String autoDevopsEnabled,
        @Nullable String autoDevopsDomain,
        @Nullable String autoAcceptAwardedAchievements,
        @Nullable String autoBanUserOnExcessiveProjectsDownload,
        @Nullable String autoDuoCodeReviewEnabled,
        @Nullable String autocompleteUsersLimit,
        @Nullable String autocompleteUsersUnauthenticatedLimit,
        @Nullable String codeDropdownCustomClients,
        @Nullable String codeSuggestionsApiRateLimit,
        @Nullable String concurrentGithubImportJobsLimit,
        @Nullable String concurrentBitbucketImportJobsLimit,
        @Nullable String concurrentBitbucketServerImportJobsLimit,
        @Nullable String concurrentPullRequestImportJobsLimit,
        @Nullable String concurrentRelationBatchExportLimit,
        @Nullable String concurrentRelationExportLimit,
        @Nullable String importJobsConcurrencyLimit,
        @Nullable String importSources,
        @Nullable String oauthAccessTokenExpiresIn,
        @Nullable String decompressArchiveFileTimeout,
        @Nullable String deleteInactiveProjects,
        @Nullable String deleteUnconfirmedUsers,
        @Nullable String deletionAdjournedPeriod,
        @Nullable String denyAllRequestsExceptAllowed,
        @Nullable String dependencyManagementSettings,
        @Nullable String dependencyFirewallPoliciesPerConfigurationLimit,
        @Nullable String dependencyScanningSbomScanApiUploadLimit,
        @Nullable String dependencyScanningSbomScanApiDownloadLimit,
        @Nullable String disableAdminOauthScopes,
        @Nullable String disableFeedToken,
        @Nullable String disablePasswordAuthenticationForUsersWithSsoIdentities,
        @Nullable String disableOverridingApproversPerMergeRequest,
        @Nullable String disablePersonalAccessTokens,
        @Nullable String blockJwtForReclaimedPaths,
        @Nullable String rootMovedPermanentlyRedirection,
        @Nullable String disabledOauthSignInSources,
        @Nullable String disabledDirectCodeSuggestions,
        @Nullable String domainDenylist,
        @Nullable String domainDenylistEnabled,
        @Nullable String domainDenylistRaw,
        @Nullable String domainAllowlist,
        @Nullable String domainAllowlistRaw,
        @Nullable String outboundLocalRequestsAllowlistRaw,
        @Nullable String outboundLocalRequestsWhitelist,
        @Nullable String dsaKeyRestriction,
        @Nullable String ecdsaKeyRestriction,
        @Nullable String ecdsaSkKeyRestriction,
        @Nullable String ed25519KeyRestriction,
        @Nullable String ed25519SkKeyRestriction,
        @Nullable String eksIntegrationEnabled,
        @Nullable String eksAccountId,
        @Nullable String eksAccessKeyId,
        @Nullable String emailAuthorInBody,
        @Nullable String emailConfirmationSetting,
        @Nullable String emailOtpEnabled,
        @Nullable String emailRestrictionsEnabled,
        @Nullable String emailRestrictions,
        @Nullable String emailAdditionalText,
        @Nullable String enabledGitAccessProtocol,
        @Nullable String enabledExpandedLogging,
        @Nullable String enforceCiInboundJobTokenScopeEnabled,
        @Nullable String enforceEmailSubaddressRestrictions,
        @Nullable String enforceTerms,
        @Nullable String enforceGranularTokens,
        @Nullable String enforceNamespaceStorageLimit,
        @Nullable String enforcePiplCompliance,
        @Nullable String requireEmailVerificationOnAccountLocked,
        @Nullable String requireShaForMerge,
        @Nullable String requireAdminApprovalAfterUserSignup,
        @Nullable String requireAdminTwoFactorAuthentication,
        @Nullable String requireTwoFactorAuthentication,
        @Nullable String requirePersonalAccessTokenExpiry,
        @Nullable String errorTrackingEnabled,
        @Nullable String errorTrackingApiUrl,
        @Nullable String failedLoginAttemptsUnlockPeriodInMinutes,
        @Nullable String firstDayOfWeek,
        @Nullable String flocEnabled,
        @Nullable String forcePagesAccessControl,
        @Nullable String gitalyTimeoutDefault,
        @Nullable String gitalyTimeoutMedium,
        @Nullable String gitalyTimeoutFast,
        @Nullable String gitpodEnabled,
        @Nullable String gitpodUrl,
        @Nullable String grafanaEnabled,
        @Nullable String grafanaUrl,
        @Nullable String gravatarEnabled,
        @Nullable String hashedStorageEnabled,
        @Nullable String helpPageHideCommercialContent,
        @Nullable String helpPageSupportUrl,
        @Nullable String helpPageDocumentationBaseUrl,
        @Nullable String helpPageText,
        @Nullable String hideThirdPartyOffers,
        @Nullable String homePageUrl,
        @Nullable String housekeepingEnabled,
        @Nullable String housekeepingFullRepackPeriod,
        @Nullable String housekeepingGcPeriod,
        @Nullable String housekeepingIncrementalRepackPeriod,
        @Nullable String housekeepingOptimizeRepositoryPeriod,
        @Nullable String housekeepingBitmapsEnabled,
        @Nullable String htmlEmailsEnabled,
        @Nullable String iframeRenderingEnabled,
        @Nullable String iframeRenderingAllowlist,
        @Nullable String iframeRenderingAllowlistRaw,
        @Nullable String inactiveResourceAccessTokensDeleteAfterDays,
        @Nullable String inactiveProjectsDeleteAfterMonths,
        @Nullable String inactiveProjectsMinSizeMb,
        @Nullable String inactiveProjectsSendWarningEmailAfterMonths,
        @Nullable String includeOptionalMetricsInServicePing,
        @Nullable String invisibleCaptchaEnabled,
        @Nullable String jiraConnectApplicationKey,
        @Nullable String jiraConnectPublicKeyStorageEnabled,
        @Nullable String jiraConnectProxyUrl,
        @Nullable String jiraConnectAdditionalAudienceUrl,
        @Nullable String jiraConnectDomainAllowlist,
        @Nullable String jiraConnectDomainAllowlistRaw,
        @Nullable String jiraForgeAppId,
        @Nullable String mathRenderingLimitsEnabled,
        @Nullable String metricsMethodCallThreshold,
        @Nullable String minimumPasswordLength,
        @Nullable String minimumLanguageServerVersion,
        @Nullable String mirrorAvailable,
        @Nullable String mirrorMaxCapacity,
        @Nullable String mirrorMaxDelay,
        @Nullable String mirrorCapacityThreshold,
        @Nullable String notifyOnUnknownSignIn,
        @Nullable String o11yProvisionerUrl,
        @Nullable String organizationClusterAgentAuthorizationEnabled,
        @Nullable String pagesDomainVerificationEnabled,
        @Nullable String pagesUniqueDomainDefaultEnabled,
        @Nullable String pagesExtraDeploymentsDefaultExpirySeconds,
        @Nullable String pagesDeploymentsApiLimit,
        @Nullable String passwordAuthenticationEnabledForWeb,
        @Nullable String passwordAuthenticationEnabledForGit) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code staticObjectsExternalStorageAuthToken}, {@code oauthAccessTokenExpiresIn},
     *     {@code disableFeedToken}, {@code disablePasswordAuthenticationForUsersWithSsoIdentities},
     *     {@code disablePersonalAccessTokens}, {@code enforceGranularTokens}, {@code requirePersonalAccessTokenExpiry},
     *     {@code inactiveResourceAccessTokensDeleteAfterDays}, {@code minimumPasswordLength},
     *     {@code passwordAuthenticationEnabledForWeb}, {@code passwordAuthenticationEnabledForGit} redacted
     */
    @Override
    public String toString() {
        return "GitLabApplicationSettingOther[" + "id=" + id + ", performanceBarAllowedGroupId="
                + performanceBarAllowedGroupId + ", abuseNotificationEmail=" + abuseNotificationEmail + ", adminMode="
                + adminMode + ", afterSignOutPath=" + afterSignOutPath + ", afterSignUpText=" + afterSignUpText
                + ", akismetApiKey=" + akismetApiKey + ", akismetEnabled=" + akismetEnabled
                + ", dnsRebindingProtectionEnabled=" + dnsRebindingProtectionEnabled + ", archiveBuildsInHumanReadable="
                + archiveBuildsInHumanReadable + ", assetProxyEnabled=" + assetProxyEnabled + ", assetProxyUrl="
                + assetProxyUrl + ", assetProxyAllowlist=" + assetProxyAllowlist + ", assetProxyWhitelist="
                + assetProxyWhitelist + ", staticObjectsExternalStorageAuthToken=<redacted>"
                + ", staticObjectsExternalStorageUrl=" + staticObjectsExternalStorageUrl
                + ", authnDataRetentionCleanupEnabled=" + authnDataRetentionCleanupEnabled + ", authorizedKeysEnabled="
                + authorizedKeysEnabled + ", autoDevopsEnabled=" + autoDevopsEnabled + ", autoDevopsDomain="
                + autoDevopsDomain + ", autoAcceptAwardedAchievements=" + autoAcceptAwardedAchievements
                + ", autoBanUserOnExcessiveProjectsDownload=" + autoBanUserOnExcessiveProjectsDownload
                + ", autoDuoCodeReviewEnabled=" + autoDuoCodeReviewEnabled + ", autocompleteUsersLimit="
                + autocompleteUsersLimit + ", autocompleteUsersUnauthenticatedLimit="
                + autocompleteUsersUnauthenticatedLimit + ", codeDropdownCustomClients=" + codeDropdownCustomClients
                + ", codeSuggestionsApiRateLimit=" + codeSuggestionsApiRateLimit + ", concurrentGithubImportJobsLimit="
                + concurrentGithubImportJobsLimit + ", concurrentBitbucketImportJobsLimit="
                + concurrentBitbucketImportJobsLimit + ", concurrentBitbucketServerImportJobsLimit="
                + concurrentBitbucketServerImportJobsLimit + ", concurrentPullRequestImportJobsLimit="
                + concurrentPullRequestImportJobsLimit + ", concurrentRelationBatchExportLimit="
                + concurrentRelationBatchExportLimit + ", concurrentRelationExportLimit="
                + concurrentRelationExportLimit + ", importJobsConcurrencyLimit=" + importJobsConcurrencyLimit
                + ", importSources=" + importSources + ", oauthAccessTokenExpiresIn=<redacted>"
                + ", decompressArchiveFileTimeout=" + decompressArchiveFileTimeout + ", deleteInactiveProjects="
                + deleteInactiveProjects + ", deleteUnconfirmedUsers=" + deleteUnconfirmedUsers
                + ", deletionAdjournedPeriod=" + deletionAdjournedPeriod + ", denyAllRequestsExceptAllowed="
                + denyAllRequestsExceptAllowed + ", dependencyManagementSettings=" + dependencyManagementSettings
                + ", dependencyFirewallPoliciesPerConfigurationLimit=" + dependencyFirewallPoliciesPerConfigurationLimit
                + ", dependencyScanningSbomScanApiUploadLimit=" + dependencyScanningSbomScanApiUploadLimit
                + ", dependencyScanningSbomScanApiDownloadLimit=" + dependencyScanningSbomScanApiDownloadLimit
                + ", disableAdminOauthScopes=" + disableAdminOauthScopes + ", disableFeedToken=<redacted>"
                + ", disablePasswordAuthenticationForUsersWithSsoIdentities=<redacted>"
                + ", disableOverridingApproversPerMergeRequest=" + disableOverridingApproversPerMergeRequest
                + ", disablePersonalAccessTokens=<redacted>" + ", blockJwtForReclaimedPaths="
                + blockJwtForReclaimedPaths + ", rootMovedPermanentlyRedirection=" + rootMovedPermanentlyRedirection
                + ", disabledOauthSignInSources=" + disabledOauthSignInSources + ", disabledDirectCodeSuggestions="
                + disabledDirectCodeSuggestions + ", domainDenylist=" + domainDenylist + ", domainDenylistEnabled="
                + domainDenylistEnabled + ", domainDenylistRaw=" + domainDenylistRaw + ", domainAllowlist="
                + domainAllowlist + ", domainAllowlistRaw=" + domainAllowlistRaw
                + ", outboundLocalRequestsAllowlistRaw=" + outboundLocalRequestsAllowlistRaw
                + ", outboundLocalRequestsWhitelist=" + outboundLocalRequestsWhitelist + ", dsaKeyRestriction="
                + dsaKeyRestriction + ", ecdsaKeyRestriction=" + ecdsaKeyRestriction + ", ecdsaSkKeyRestriction="
                + ecdsaSkKeyRestriction + ", ed25519KeyRestriction=" + ed25519KeyRestriction
                + ", ed25519SkKeyRestriction=" + ed25519SkKeyRestriction + ", eksIntegrationEnabled="
                + eksIntegrationEnabled + ", eksAccountId=" + eksAccountId + ", eksAccessKeyId=" + eksAccessKeyId
                + ", emailAuthorInBody=" + emailAuthorInBody + ", emailConfirmationSetting=" + emailConfirmationSetting
                + ", emailOtpEnabled=" + emailOtpEnabled + ", emailRestrictionsEnabled=" + emailRestrictionsEnabled
                + ", emailRestrictions=" + emailRestrictions + ", emailAdditionalText=" + emailAdditionalText
                + ", enabledGitAccessProtocol=" + enabledGitAccessProtocol + ", enabledExpandedLogging="
                + enabledExpandedLogging + ", enforceCiInboundJobTokenScopeEnabled="
                + enforceCiInboundJobTokenScopeEnabled + ", enforceEmailSubaddressRestrictions="
                + enforceEmailSubaddressRestrictions + ", enforceTerms=" + enforceTerms
                + ", enforceGranularTokens=<redacted>" + ", enforceNamespaceStorageLimit="
                + enforceNamespaceStorageLimit + ", enforcePiplCompliance=" + enforcePiplCompliance
                + ", requireEmailVerificationOnAccountLocked=" + requireEmailVerificationOnAccountLocked
                + ", requireShaForMerge=" + requireShaForMerge + ", requireAdminApprovalAfterUserSignup="
                + requireAdminApprovalAfterUserSignup + ", requireAdminTwoFactorAuthentication="
                + requireAdminTwoFactorAuthentication + ", requireTwoFactorAuthentication="
                + requireTwoFactorAuthentication + ", requirePersonalAccessTokenExpiry=<redacted>"
                + ", errorTrackingEnabled=" + errorTrackingEnabled + ", errorTrackingApiUrl=" + errorTrackingApiUrl
                + ", failedLoginAttemptsUnlockPeriodInMinutes=" + failedLoginAttemptsUnlockPeriodInMinutes
                + ", firstDayOfWeek=" + firstDayOfWeek + ", flocEnabled=" + flocEnabled + ", forcePagesAccessControl="
                + forcePagesAccessControl + ", gitalyTimeoutDefault=" + gitalyTimeoutDefault + ", gitalyTimeoutMedium="
                + gitalyTimeoutMedium + ", gitalyTimeoutFast=" + gitalyTimeoutFast + ", gitpodEnabled=" + gitpodEnabled
                + ", gitpodUrl=" + gitpodUrl + ", grafanaEnabled=" + grafanaEnabled + ", grafanaUrl=" + grafanaUrl
                + ", gravatarEnabled=" + gravatarEnabled + ", hashedStorageEnabled=" + hashedStorageEnabled
                + ", helpPageHideCommercialContent=" + helpPageHideCommercialContent + ", helpPageSupportUrl="
                + helpPageSupportUrl + ", helpPageDocumentationBaseUrl=" + helpPageDocumentationBaseUrl
                + ", helpPageText=" + helpPageText + ", hideThirdPartyOffers=" + hideThirdPartyOffers + ", homePageUrl="
                + homePageUrl + ", housekeepingEnabled=" + housekeepingEnabled + ", housekeepingFullRepackPeriod="
                + housekeepingFullRepackPeriod + ", housekeepingGcPeriod=" + housekeepingGcPeriod
                + ", housekeepingIncrementalRepackPeriod=" + housekeepingIncrementalRepackPeriod
                + ", housekeepingOptimizeRepositoryPeriod=" + housekeepingOptimizeRepositoryPeriod
                + ", housekeepingBitmapsEnabled=" + housekeepingBitmapsEnabled + ", htmlEmailsEnabled="
                + htmlEmailsEnabled + ", iframeRenderingEnabled=" + iframeRenderingEnabled
                + ", iframeRenderingAllowlist=" + iframeRenderingAllowlist + ", iframeRenderingAllowlistRaw="
                + iframeRenderingAllowlistRaw + ", inactiveResourceAccessTokensDeleteAfterDays=<redacted>"
                + ", inactiveProjectsDeleteAfterMonths=" + inactiveProjectsDeleteAfterMonths
                + ", inactiveProjectsMinSizeMb=" + inactiveProjectsMinSizeMb
                + ", inactiveProjectsSendWarningEmailAfterMonths=" + inactiveProjectsSendWarningEmailAfterMonths
                + ", includeOptionalMetricsInServicePing=" + includeOptionalMetricsInServicePing
                + ", invisibleCaptchaEnabled=" + invisibleCaptchaEnabled + ", jiraConnectApplicationKey="
                + jiraConnectApplicationKey + ", jiraConnectPublicKeyStorageEnabled="
                + jiraConnectPublicKeyStorageEnabled + ", jiraConnectProxyUrl=" + jiraConnectProxyUrl
                + ", jiraConnectAdditionalAudienceUrl=" + jiraConnectAdditionalAudienceUrl
                + ", jiraConnectDomainAllowlist=" + jiraConnectDomainAllowlist + ", jiraConnectDomainAllowlistRaw="
                + jiraConnectDomainAllowlistRaw + ", jiraForgeAppId=" + jiraForgeAppId + ", mathRenderingLimitsEnabled="
                + mathRenderingLimitsEnabled + ", metricsMethodCallThreshold=" + metricsMethodCallThreshold
                + ", minimumPasswordLength=<redacted>" + ", minimumLanguageServerVersion="
                + minimumLanguageServerVersion + ", mirrorAvailable=" + mirrorAvailable + ", mirrorMaxCapacity="
                + mirrorMaxCapacity + ", mirrorMaxDelay=" + mirrorMaxDelay + ", mirrorCapacityThreshold="
                + mirrorCapacityThreshold + ", notifyOnUnknownSignIn=" + notifyOnUnknownSignIn + ", o11yProvisionerUrl="
                + o11yProvisionerUrl + ", organizationClusterAgentAuthorizationEnabled="
                + organizationClusterAgentAuthorizationEnabled + ", pagesDomainVerificationEnabled="
                + pagesDomainVerificationEnabled + ", pagesUniqueDomainDefaultEnabled="
                + pagesUniqueDomainDefaultEnabled + ", pagesExtraDeploymentsDefaultExpirySeconds="
                + pagesExtraDeploymentsDefaultExpirySeconds + ", pagesDeploymentsApiLimit=" + pagesDeploymentsApiLimit
                + ", passwordAuthenticationEnabledForWeb=<redacted>"
                + ", passwordAuthenticationEnabledForGit=<redacted>" + "]";
    }
}

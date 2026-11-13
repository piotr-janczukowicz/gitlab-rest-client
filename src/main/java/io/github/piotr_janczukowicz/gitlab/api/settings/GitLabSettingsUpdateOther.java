package io.github.piotr_janczukowicz.gitlab.api.settings;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabSettingsUpdatePayload}, flattened into it in JSON.
 *
 * @param adminMode the admin mode
 * @param adminNotificationEmail the admin notification email
 * @param abuseNotificationEmail the abuse notification email
 * @param afterSignUpText the after sign up text
 * @param afterSignOutPath the after sign out path
 * @param akismetEnabled the akismet enabled
 * @param akismetApiKey the akismet api key
 * @param assetProxyEnabled the asset proxy enabled
 * @param assetProxyUrl the asset proxy url
 * @param assetProxySecretKey the asset proxy secret key
 * @param assetProxyWhitelist the asset proxy whitelist
 * @param assetProxyAllowlist the asset proxy allowlist
 * @param authnDataRetentionCleanupEnabled the authn data retention cleanup enabled
 * @param containerRegistryTokenExpireDelay the container registry token expire delay
 * @param containerExpirationPoliciesEnableHistoricEntries the container expiration policies enable historic entries
 * @param containerRegistryCleanupTagsServiceMaxListSize the container registry cleanup tags service max list size
 * @param containerRegistryDeleteTagsServiceTimeout the container registry delete tags service timeout
 * @param containerRegistryExpirationPoliciesCaching the container registry expiration policies caching
 * @param containerRegistryExpirationPoliciesWorkerCapacity the container registry expiration policies worker capacity
 * @param oauthAccessTokenExpiresIn the oauth access token expires in
 * @param decompressArchiveFileTimeout the decompress archive file timeout
 * @param dependencyManagementSettings the dependency management settings
 * @param dependencyFirewallPoliciesPerConfigurationLimit the dependency firewall policies per configuration limit
 * @param dependencyScanningSbomScanApiUploadLimit the dependency scanning sbom scan api upload limit
 * @param dependencyScanningSbomScanApiDownloadLimit the dependency scanning sbom scan api download limit
 * @param disableAdminOauthScopes the disable admin oauth scopes
 * @param disableFeedToken the disable feed token
 * @param disablePasswordAuthenticationForUsersWithSsoIdentities the disable password authentication for users with sso
 *     identities
 * @param disablePersonalAccessTokens the disable personal access tokens
 * @param disableOverridingApproversPerMergeRequest the disable overriding approvers per merge request
 * @param disableInviteMembers the disable invite members
 * @param disabledOauthSignInSources the disabled oauth sign in sources
 * @param disabledDirectCodeSuggestions the disabled direct code suggestions
 * @param discussionsResolveLimit the discussions resolve limit
 * @param draftNotesCreateLimit the draft notes create limit
 * @param domainDenylistEnabled the domain denylist enabled
 * @param domainDenylist the domain denylist
 * @param domainAllowlist the domain allowlist
 * @param domainDenylistRaw the domain denylist raw
 * @param domainAllowlistRaw the domain allowlist raw
 * @param outboundLocalRequestsWhitelist the outbound local requests whitelist
 * @param outboundLocalRequestsAllowlistRaw the outbound local requests allowlist raw
 * @param emailOtpEnabled the email otp enabled
 * @param emailAuthorInBody the email author in body
 * @param emailConfirmationSetting the email confirmation setting
 * @param emailRestrictions the email restrictions
 * @param emailRestrictionsEnabled the email restrictions enabled
 * @param emailAdditionalText the email additional text
 * @param environmentDeleteRowsLimitPerUser the environment delete rows limit per user
 * @param iframeRenderingEnabled the iframe rendering enabled
 * @param iframeRenderingAllowlist the iframe rendering allowlist
 * @param iframeRenderingAllowlistRaw the iframe rendering allowlist raw
 * @param eksIntegrationEnabled the eks integration enabled
 * @param eksAccountId the eks account id
 * @param eksAccessKeyId the eks access key id
 * @param eksSecretAccessKey the eks secret access key
 * @param enabledGitAccessProtocol the enabled git access protocol
 * @param enabledExpandedLogging the enabled expanded logging
 * @param gitpodEnabled the gitpod enabled
 * @param gitpodUrl the gitpod url
 * @param gitalyTimeoutDefault the gitaly timeout default
 * @param gitalyTimeoutFast the gitaly timeout fast
 * @param gitalyTimeoutMedium the gitaly timeout medium
 * @param grafanaEnabled the grafana enabled
 * @param grafanaUrl the grafana url
 * @param gravatarEnabled the gravatar enabled
 * @param helpPageHideCommercialContent the help page hide commercial content
 * @param helpPageSupportUrl the help page support url
 * @param helpPageDocumentationBaseUrl the help page documentation base url
 * @param helpPageText the help page text
 * @param homePageUrl the home page url
 * @param housekeepingEnabled the housekeeping enabled
 * @param housekeepingFullRepackPeriod the housekeeping full repack period
 * @param housekeepingGcPeriod the housekeeping gc period
 * @param housekeepingIncrementalRepackPeriod the housekeeping incremental repack period
 * @param housekeepingOptimizeRepositoryPeriod the housekeeping optimize repository period
 * @param htmlEmailsEnabled the html emails enabled
 * @param importSources the import sources
 * @param importJobsConcurrencyLimit the import jobs concurrency limit
 * @param invisibleCaptchaEnabled the invisible captcha enabled
 * @param mergeRequestsCreateLimit the merge requests create limit
 * @param mergeRequestsRebaseLimit the merge requests rebase limit
 * @param metricsMethodCallThreshold the metrics method call threshold
 * @param o11yProvisionerApiKey the o11y provisioner api key
 * @param o11yProvisionerUrl the o11y provisioner url
 * @param passwordAuthenticationEnabled the password authentication enabled
 * @param passwordAuthenticationEnabledForWeb the password authentication enabled for web
 * @param passwordAuthenticationEnabledForGit the password authentication enabled for git
 * @param passwordLowercaseRequired the password lowercase required
 * @param passwordNumberRequired the password number required
 * @param passwordSymbolRequired the password symbol required
 * @param passwordUppercaseRequired the password uppercase required
 * @param signinEnabled the signin enabled
 * @param performanceBarAllowedGroupId the performance bar allowed group id
 * @param performanceBarAllowedGroupPath the performance bar allowed group path
 * @param performanceBarEnabled the performance bar enabled
 * @param personalAccessTokenPrefix the personal access token prefix
 * @param requirePersonalAccessTokenExpiry the require personal access token expiry
 * @param requireTwoFactorAuthentication the require two factor authentication
 * @param requireAdminApprovalAfterUserSignup the require admin approval after user signup
 * @param requireAdminTwoFactorAuthentication the require admin two factor authentication
 * @param requireEmailVerificationOnAccountLocked the require email verification on account locked
 * @param requireShaForMerge the require sha for merge
 * @param krokiEnabled the kroki enabled
 * @param krokiUrl the kroki url
 * @param krokiDiagramProxyEnabled the kroki diagram proxy enabled
 * @param krokiFormats the kroki formats
 * @param plantumlEnabled the plantuml enabled
 * @param plantumlUrl the plantuml url
 * @param plantumlDiagramProxyEnabled the plantuml diagram proxy enabled
 * @param diagramsnetEnabled the diagramsnet enabled
 * @param diagramsnetUrl the diagramsnet url
 * @param pollingIntervalMultiplier the polling interval multiplier
 * @param prometheusMetricsEnabled the prometheus metrics enabled
 * @param pushEventHooksLimit the push event hooks limit
 * @param pushEventActivitiesLimit the push event activities limit
 * @param recaptchaEnabled the recaptcha enabled
 * @param recaptchaSiteKey the recaptcha site key
 * @param recaptchaPrivateKey the recaptcha private key
 * @param loginRecaptchaProtectionEnabled the login recaptcha protection enabled
 * @param repositoryChecksEnabled the repository checks enabled
 * @param repositoryStoragesWeighted the repository storages weighted
 * @param repositorySizeLimit the repository size limit
 * @param twoFactorGracePeriod the two factor grace period
 * @param restrictedVisibilityLevels the restricted visibility levels
 * @param sessionExpireDelay the session expire delay
 * @param sessionExpireFromInit the session expire from init
 * @param sharedRunnersEnabled the shared runners enabled
 * @param sharedRunnersText the shared runners text
 * @param sharedRunnersMinutes the shared runners minutes
 * @param validRunnerRegistrars the valid runner registrars
 * @param signupEnabled the signup enabled
 * @param sourcegraphEnabled the sourcegraph enabled
 * @param sourcegraphPublicOnly the sourcegraph public only
 * @param sourcegraphUrl the sourcegraph url
 * @param spamCheckEndpointEnabled the spam check endpoint enabled
 * @param spamCheckEndpointUrl the spam check endpoint url
 * @param spamCheckApiKey the spam check api key
 * @param terminalMaxSessionTime the terminal max session time
 * @param usagePingEnabled the usage ping enabled
 * @param usagePingGenerationEnabled the usage ping generation enabled
 * @param usagePingFeaturesEnabled the usage ping features enabled
 * @param localMarkdownVersion the local markdown version
 * @param mailgunEventsEnabled the mailgun events enabled
 * @param mailgunSigningKey the mailgun signing key
 * @param snowplowEnabled the snowplow enabled
 * @param snowplowCollectorHostname the snowplow collector hostname
 * @param snowplowCookieDomain the snowplow cookie domain
 * @param snowplowAppId the snowplow app id
 * @param snowplowDatabaseCollectorHostname the snowplow database collector hostname
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabSettingsUpdateOther(
        @Nullable Boolean adminMode,
        @Nullable String adminNotificationEmail,
        @Nullable String abuseNotificationEmail,
        @Nullable String afterSignUpText,
        @Nullable String afterSignOutPath,
        @Nullable Boolean akismetEnabled,
        @Nullable String akismetApiKey,
        @Nullable Boolean assetProxyEnabled,
        @Nullable String assetProxyUrl,
        @Nullable String assetProxySecretKey,
        @Nullable List<String> assetProxyWhitelist,
        @Nullable List<String> assetProxyAllowlist,
        @Nullable Boolean authnDataRetentionCleanupEnabled,
        @Nullable Integer containerRegistryTokenExpireDelay,
        @Nullable String containerExpirationPoliciesEnableHistoricEntries,
        @Nullable String containerRegistryCleanupTagsServiceMaxListSize,
        @Nullable String containerRegistryDeleteTagsServiceTimeout,
        @Nullable String containerRegistryExpirationPoliciesCaching,
        @Nullable String containerRegistryExpirationPoliciesWorkerCapacity,
        @Nullable Integer oauthAccessTokenExpiresIn,
        @Nullable Integer decompressArchiveFileTimeout,
        @Nullable GitLabSettingsUpdateDependencyManagementSettings dependencyManagementSettings,
        @Nullable String dependencyFirewallPoliciesPerConfigurationLimit,
        @Nullable String dependencyScanningSbomScanApiUploadLimit,
        @Nullable String dependencyScanningSbomScanApiDownloadLimit,
        @Nullable Boolean disableAdminOauthScopes,
        @Nullable Boolean disableFeedToken,
        @Nullable String disablePasswordAuthenticationForUsersWithSsoIdentities,
        @Nullable Boolean disablePersonalAccessTokens,
        @Nullable Boolean disableOverridingApproversPerMergeRequest,
        @Nullable String disableInviteMembers,
        @Nullable List<String> disabledOauthSignInSources,
        @Nullable Boolean disabledDirectCodeSuggestions,
        @Nullable Integer discussionsResolveLimit,
        @Nullable Integer draftNotesCreateLimit,
        @Nullable Boolean domainDenylistEnabled,
        @Nullable List<String> domainDenylist,
        @Nullable List<String> domainAllowlist,
        @Nullable String domainDenylistRaw,
        @Nullable String domainAllowlistRaw,
        @Nullable List<String> outboundLocalRequestsWhitelist,
        @Nullable String outboundLocalRequestsAllowlistRaw,
        @Nullable Boolean emailOtpEnabled,
        @Nullable Boolean emailAuthorInBody,
        @Nullable GitLabSettingsUpdateEmailConfirmationSetting emailConfirmationSetting,
        @Nullable String emailRestrictions,
        @Nullable String emailRestrictionsEnabled,
        @Nullable String emailAdditionalText,
        @Nullable Integer environmentDeleteRowsLimitPerUser,
        @Nullable Boolean iframeRenderingEnabled,
        @Nullable List<String> iframeRenderingAllowlist,
        @Nullable String iframeRenderingAllowlistRaw,
        @Nullable Boolean eksIntegrationEnabled,
        @Nullable String eksAccountId,
        @Nullable String eksAccessKeyId,
        @Nullable String eksSecretAccessKey,
        @Nullable GitLabSettingsUpdateEnabledGitAccessProtocol enabledGitAccessProtocol,
        @Nullable String enabledExpandedLogging,
        @Nullable Boolean gitpodEnabled,
        @Nullable String gitpodUrl,
        @Nullable Integer gitalyTimeoutDefault,
        @Nullable Integer gitalyTimeoutFast,
        @Nullable Integer gitalyTimeoutMedium,
        @Nullable Boolean grafanaEnabled,
        @Nullable String grafanaUrl,
        @Nullable Boolean gravatarEnabled,
        @Nullable Boolean helpPageHideCommercialContent,
        @Nullable String helpPageSupportUrl,
        @Nullable String helpPageDocumentationBaseUrl,
        @Nullable String helpPageText,
        @Nullable String homePageUrl,
        @Nullable Boolean housekeepingEnabled,
        @Nullable Integer housekeepingFullRepackPeriod,
        @Nullable Integer housekeepingGcPeriod,
        @Nullable Integer housekeepingIncrementalRepackPeriod,
        @Nullable Integer housekeepingOptimizeRepositoryPeriod,
        @Nullable Boolean htmlEmailsEnabled,
        @Nullable List<GitLabSettingsUpdateImportSources> importSources,
        @Nullable String importJobsConcurrencyLimit,
        @Nullable Boolean invisibleCaptchaEnabled,
        @Nullable Integer mergeRequestsCreateLimit,
        @Nullable Integer mergeRequestsRebaseLimit,
        @Nullable Integer metricsMethodCallThreshold,
        @Nullable String o11yProvisionerApiKey,
        @Nullable String o11yProvisionerUrl,
        @Nullable Boolean passwordAuthenticationEnabled,
        @Nullable Boolean passwordAuthenticationEnabledForWeb,
        @Nullable Boolean passwordAuthenticationEnabledForGit,
        @Nullable String passwordLowercaseRequired,
        @Nullable String passwordNumberRequired,
        @Nullable String passwordSymbolRequired,
        @Nullable String passwordUppercaseRequired,
        @Nullable Boolean signinEnabled,
        @Nullable String performanceBarAllowedGroupId,
        @Nullable String performanceBarAllowedGroupPath,
        @Nullable String performanceBarEnabled,
        @Nullable String personalAccessTokenPrefix,
        @Nullable Boolean requirePersonalAccessTokenExpiry,
        @Nullable Boolean requireTwoFactorAuthentication,
        @Nullable Boolean requireAdminApprovalAfterUserSignup,
        @Nullable String requireAdminTwoFactorAuthentication,
        @Nullable String requireEmailVerificationOnAccountLocked,
        @Nullable String requireShaForMerge,
        @Nullable Boolean krokiEnabled,
        @Nullable String krokiUrl,
        @Nullable String krokiDiagramProxyEnabled,
        @Nullable String krokiFormats,
        @Nullable Boolean plantumlEnabled,
        @Nullable String plantumlUrl,
        @Nullable String plantumlDiagramProxyEnabled,
        @Nullable Boolean diagramsnetEnabled,
        @Nullable String diagramsnetUrl,
        @Nullable Double pollingIntervalMultiplier,
        @Nullable Boolean prometheusMetricsEnabled,
        @Nullable Integer pushEventHooksLimit,
        @Nullable Integer pushEventActivitiesLimit,
        @Nullable Boolean recaptchaEnabled,
        @Nullable String recaptchaSiteKey,
        @Nullable String recaptchaPrivateKey,
        @Nullable Boolean loginRecaptchaProtectionEnabled,
        @Nullable Boolean repositoryChecksEnabled,
        @Nullable Map<String, Integer> repositoryStoragesWeighted,
        @Nullable Integer repositorySizeLimit,
        @Nullable Integer twoFactorGracePeriod,
        @Nullable List<String> restrictedVisibilityLevels,
        @Nullable Integer sessionExpireDelay,
        @Nullable Boolean sessionExpireFromInit,
        @Nullable Boolean sharedRunnersEnabled,
        @Nullable String sharedRunnersText,
        @Nullable String sharedRunnersMinutes,
        @Nullable List<String> validRunnerRegistrars,
        @Nullable Boolean signupEnabled,
        @Nullable Boolean sourcegraphEnabled,
        @Nullable Boolean sourcegraphPublicOnly,
        @Nullable String sourcegraphUrl,
        @Nullable Boolean spamCheckEndpointEnabled,
        @Nullable String spamCheckEndpointUrl,
        @Nullable String spamCheckApiKey,
        @Nullable Integer terminalMaxSessionTime,
        @Nullable Boolean usagePingEnabled,
        @Nullable String usagePingGenerationEnabled,
        @Nullable String usagePingFeaturesEnabled,
        @Nullable Integer localMarkdownVersion,
        @Nullable Boolean mailgunEventsEnabled,
        @Nullable String mailgunSigningKey,
        @Nullable Boolean snowplowEnabled,
        @Nullable String snowplowCollectorHostname,
        @Nullable String snowplowCookieDomain,
        @Nullable String snowplowAppId,
        @Nullable String snowplowDatabaseCollectorHostname) {
    public GitLabSettingsUpdateOther {
        if (assetProxyWhitelist != null) {
            assetProxyWhitelist = List.copyOf(assetProxyWhitelist);
        }
        if (assetProxyAllowlist != null) {
            assetProxyAllowlist = List.copyOf(assetProxyAllowlist);
        }
        if (disabledOauthSignInSources != null) {
            disabledOauthSignInSources = List.copyOf(disabledOauthSignInSources);
        }
        if (domainDenylist != null) {
            domainDenylist = List.copyOf(domainDenylist);
        }
        if (domainAllowlist != null) {
            domainAllowlist = List.copyOf(domainAllowlist);
        }
        if (outboundLocalRequestsWhitelist != null) {
            outboundLocalRequestsWhitelist = List.copyOf(outboundLocalRequestsWhitelist);
        }
        if (iframeRenderingAllowlist != null) {
            iframeRenderingAllowlist = List.copyOf(iframeRenderingAllowlist);
        }
        if (importSources != null) {
            importSources = List.copyOf(importSources);
        }
        requireMaxLengthIfPresent(o11yProvisionerApiKey, 510, "o11yProvisionerApiKey");
        requireMaxLengthIfPresent(o11yProvisionerUrl, 255, "o11yProvisionerUrl");
        if (repositoryStoragesWeighted != null) {
            repositoryStoragesWeighted = Map.copyOf(repositoryStoragesWeighted);
        }
        if (restrictedVisibilityLevels != null) {
            restrictedVisibilityLevels = List.copyOf(restrictedVisibilityLevels);
        }
        if (validRunnerRegistrars != null) {
            validRunnerRegistrars = List.copyOf(validRunnerRegistrars);
        }
    }

    /**
     * Describes this record without its secret.
     *
     * @return text with {@code assetProxySecretKey}, {@code disablePasswordAuthenticationForUsersWithSsoIdentities},
     *     {@code eksSecretAccessKey}, {@code passwordLowercaseRequired}, {@code passwordNumberRequired},
     *     {@code passwordSymbolRequired}, {@code passwordUppercaseRequired}, {@code personalAccessTokenPrefix},
     *     {@code recaptchaPrivateKey} redacted
     */
    @Override
    public String toString() {
        return "GitLabSettingsUpdateOther[" + "adminMode=" + adminMode + ", adminNotificationEmail="
                + adminNotificationEmail + ", abuseNotificationEmail=" + abuseNotificationEmail + ", afterSignUpText="
                + afterSignUpText + ", afterSignOutPath=" + afterSignOutPath + ", akismetEnabled=" + akismetEnabled
                + ", akismetApiKey=" + akismetApiKey + ", assetProxyEnabled=" + assetProxyEnabled + ", assetProxyUrl="
                + assetProxyUrl + ", assetProxySecretKey=<redacted>" + ", assetProxyWhitelist=" + assetProxyWhitelist
                + ", assetProxyAllowlist=" + assetProxyAllowlist + ", authnDataRetentionCleanupEnabled="
                + authnDataRetentionCleanupEnabled + ", containerRegistryTokenExpireDelay="
                + containerRegistryTokenExpireDelay + ", containerExpirationPoliciesEnableHistoricEntries="
                + containerExpirationPoliciesEnableHistoricEntries + ", containerRegistryCleanupTagsServiceMaxListSize="
                + containerRegistryCleanupTagsServiceMaxListSize + ", containerRegistryDeleteTagsServiceTimeout="
                + containerRegistryDeleteTagsServiceTimeout + ", containerRegistryExpirationPoliciesCaching="
                + containerRegistryExpirationPoliciesCaching + ", containerRegistryExpirationPoliciesWorkerCapacity="
                + containerRegistryExpirationPoliciesWorkerCapacity + ", oauthAccessTokenExpiresIn="
                + oauthAccessTokenExpiresIn + ", decompressArchiveFileTimeout=" + decompressArchiveFileTimeout
                + ", dependencyManagementSettings=" + dependencyManagementSettings
                + ", dependencyFirewallPoliciesPerConfigurationLimit=" + dependencyFirewallPoliciesPerConfigurationLimit
                + ", dependencyScanningSbomScanApiUploadLimit=" + dependencyScanningSbomScanApiUploadLimit
                + ", dependencyScanningSbomScanApiDownloadLimit=" + dependencyScanningSbomScanApiDownloadLimit
                + ", disableAdminOauthScopes=" + disableAdminOauthScopes + ", disableFeedToken=" + disableFeedToken
                + ", disablePasswordAuthenticationForUsersWithSsoIdentities=<redacted>"
                + ", disablePersonalAccessTokens=" + disablePersonalAccessTokens
                + ", disableOverridingApproversPerMergeRequest=" + disableOverridingApproversPerMergeRequest
                + ", disableInviteMembers=" + disableInviteMembers + ", disabledOauthSignInSources="
                + disabledOauthSignInSources + ", disabledDirectCodeSuggestions=" + disabledDirectCodeSuggestions
                + ", discussionsResolveLimit=" + discussionsResolveLimit + ", draftNotesCreateLimit="
                + draftNotesCreateLimit + ", domainDenylistEnabled=" + domainDenylistEnabled + ", domainDenylist="
                + domainDenylist + ", domainAllowlist=" + domainAllowlist + ", domainDenylistRaw=" + domainDenylistRaw
                + ", domainAllowlistRaw=" + domainAllowlistRaw + ", outboundLocalRequestsWhitelist="
                + outboundLocalRequestsWhitelist + ", outboundLocalRequestsAllowlistRaw="
                + outboundLocalRequestsAllowlistRaw + ", emailOtpEnabled=" + emailOtpEnabled + ", emailAuthorInBody="
                + emailAuthorInBody + ", emailConfirmationSetting=" + emailConfirmationSetting + ", emailRestrictions="
                + emailRestrictions + ", emailRestrictionsEnabled=" + emailRestrictionsEnabled
                + ", emailAdditionalText=" + emailAdditionalText + ", environmentDeleteRowsLimitPerUser="
                + environmentDeleteRowsLimitPerUser + ", iframeRenderingEnabled=" + iframeRenderingEnabled
                + ", iframeRenderingAllowlist=" + iframeRenderingAllowlist + ", iframeRenderingAllowlistRaw="
                + iframeRenderingAllowlistRaw + ", eksIntegrationEnabled=" + eksIntegrationEnabled + ", eksAccountId="
                + eksAccountId + ", eksAccessKeyId=" + eksAccessKeyId + ", eksSecretAccessKey=<redacted>"
                + ", enabledGitAccessProtocol=" + enabledGitAccessProtocol + ", enabledExpandedLogging="
                + enabledExpandedLogging + ", gitpodEnabled=" + gitpodEnabled + ", gitpodUrl=" + gitpodUrl
                + ", gitalyTimeoutDefault=" + gitalyTimeoutDefault + ", gitalyTimeoutFast=" + gitalyTimeoutFast
                + ", gitalyTimeoutMedium=" + gitalyTimeoutMedium + ", grafanaEnabled=" + grafanaEnabled
                + ", grafanaUrl=" + grafanaUrl + ", gravatarEnabled=" + gravatarEnabled
                + ", helpPageHideCommercialContent=" + helpPageHideCommercialContent + ", helpPageSupportUrl="
                + helpPageSupportUrl + ", helpPageDocumentationBaseUrl=" + helpPageDocumentationBaseUrl
                + ", helpPageText=" + helpPageText + ", homePageUrl=" + homePageUrl + ", housekeepingEnabled="
                + housekeepingEnabled + ", housekeepingFullRepackPeriod=" + housekeepingFullRepackPeriod
                + ", housekeepingGcPeriod=" + housekeepingGcPeriod + ", housekeepingIncrementalRepackPeriod="
                + housekeepingIncrementalRepackPeriod + ", housekeepingOptimizeRepositoryPeriod="
                + housekeepingOptimizeRepositoryPeriod + ", htmlEmailsEnabled=" + htmlEmailsEnabled + ", importSources="
                + importSources + ", importJobsConcurrencyLimit=" + importJobsConcurrencyLimit
                + ", invisibleCaptchaEnabled=" + invisibleCaptchaEnabled + ", mergeRequestsCreateLimit="
                + mergeRequestsCreateLimit + ", mergeRequestsRebaseLimit=" + mergeRequestsRebaseLimit
                + ", metricsMethodCallThreshold=" + metricsMethodCallThreshold + ", o11yProvisionerApiKey="
                + o11yProvisionerApiKey + ", o11yProvisionerUrl=" + o11yProvisionerUrl
                + ", passwordAuthenticationEnabled=" + passwordAuthenticationEnabled
                + ", passwordAuthenticationEnabledForWeb=" + passwordAuthenticationEnabledForWeb
                + ", passwordAuthenticationEnabledForGit=" + passwordAuthenticationEnabledForGit
                + ", passwordLowercaseRequired=<redacted>" + ", passwordNumberRequired=<redacted>"
                + ", passwordSymbolRequired=<redacted>" + ", passwordUppercaseRequired=<redacted>" + ", signinEnabled="
                + signinEnabled + ", performanceBarAllowedGroupId=" + performanceBarAllowedGroupId
                + ", performanceBarAllowedGroupPath=" + performanceBarAllowedGroupPath + ", performanceBarEnabled="
                + performanceBarEnabled + ", personalAccessTokenPrefix=<redacted>"
                + ", requirePersonalAccessTokenExpiry=" + requirePersonalAccessTokenExpiry
                + ", requireTwoFactorAuthentication=" + requireTwoFactorAuthentication
                + ", requireAdminApprovalAfterUserSignup=" + requireAdminApprovalAfterUserSignup
                + ", requireAdminTwoFactorAuthentication=" + requireAdminTwoFactorAuthentication
                + ", requireEmailVerificationOnAccountLocked=" + requireEmailVerificationOnAccountLocked
                + ", requireShaForMerge=" + requireShaForMerge + ", krokiEnabled=" + krokiEnabled + ", krokiUrl="
                + krokiUrl + ", krokiDiagramProxyEnabled=" + krokiDiagramProxyEnabled + ", krokiFormats=" + krokiFormats
                + ", plantumlEnabled=" + plantumlEnabled + ", plantumlUrl=" + plantumlUrl
                + ", plantumlDiagramProxyEnabled=" + plantumlDiagramProxyEnabled + ", diagramsnetEnabled="
                + diagramsnetEnabled + ", diagramsnetUrl=" + diagramsnetUrl + ", pollingIntervalMultiplier="
                + pollingIntervalMultiplier + ", prometheusMetricsEnabled=" + prometheusMetricsEnabled
                + ", pushEventHooksLimit=" + pushEventHooksLimit + ", pushEventActivitiesLimit="
                + pushEventActivitiesLimit + ", recaptchaEnabled=" + recaptchaEnabled + ", recaptchaSiteKey="
                + recaptchaSiteKey + ", recaptchaPrivateKey=<redacted>" + ", loginRecaptchaProtectionEnabled="
                + loginRecaptchaProtectionEnabled + ", repositoryChecksEnabled=" + repositoryChecksEnabled
                + ", repositoryStoragesWeighted=" + repositoryStoragesWeighted + ", repositorySizeLimit="
                + repositorySizeLimit + ", twoFactorGracePeriod=" + twoFactorGracePeriod
                + ", restrictedVisibilityLevels=" + restrictedVisibilityLevels + ", sessionExpireDelay="
                + sessionExpireDelay + ", sessionExpireFromInit=" + sessionExpireFromInit + ", sharedRunnersEnabled="
                + sharedRunnersEnabled + ", sharedRunnersText=" + sharedRunnersText + ", sharedRunnersMinutes="
                + sharedRunnersMinutes + ", validRunnerRegistrars=" + validRunnerRegistrars + ", signupEnabled="
                + signupEnabled + ", sourcegraphEnabled=" + sourcegraphEnabled + ", sourcegraphPublicOnly="
                + sourcegraphPublicOnly + ", sourcegraphUrl=" + sourcegraphUrl + ", spamCheckEndpointEnabled="
                + spamCheckEndpointEnabled + ", spamCheckEndpointUrl=" + spamCheckEndpointUrl + ", spamCheckApiKey="
                + spamCheckApiKey + ", terminalMaxSessionTime=" + terminalMaxSessionTime + ", usagePingEnabled="
                + usagePingEnabled + ", usagePingGenerationEnabled=" + usagePingGenerationEnabled
                + ", usagePingFeaturesEnabled=" + usagePingFeaturesEnabled + ", localMarkdownVersion="
                + localMarkdownVersion + ", mailgunEventsEnabled=" + mailgunEventsEnabled + ", mailgunSigningKey="
                + mailgunSigningKey + ", snowplowEnabled=" + snowplowEnabled + ", snowplowCollectorHostname="
                + snowplowCollectorHostname + ", snowplowCookieDomain=" + snowplowCookieDomain + ", snowplowAppId="
                + snowplowAppId + ", snowplowDatabaseCollectorHostname=" + snowplowDatabaseCollectorHostname + "]";
    }
}

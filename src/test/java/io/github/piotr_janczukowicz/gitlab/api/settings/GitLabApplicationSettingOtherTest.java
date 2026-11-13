package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApplicationSettingOtherTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .id(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPerformanceBarAllowedGroupIdIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .performanceBarAllowedGroupId(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.performanceBarAllowedGroupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAbuseNotificationEmailIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .abuseNotificationEmail(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.abuseNotificationEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminModeIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .adminMode(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.adminMode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAfterSignOutPathIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .afterSignOutPath(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.afterSignOutPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAfterSignUpTextIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .afterSignUpText(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.afterSignUpText()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAkismetApiKeyIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .akismetApiKey(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.akismetApiKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAkismetEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .akismetEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.akismetEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDnsRebindingProtectionEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .dnsRebindingProtectionEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.dnsRebindingProtectionEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchiveBuildsInHumanReadableIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .archiveBuildsInHumanReadable(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.archiveBuildsInHumanReadable()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssetProxyEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .assetProxyEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.assetProxyEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssetProxyUrlIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .assetProxyUrl(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.assetProxyUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssetProxyAllowlistIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .assetProxyAllowlist(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.assetProxyAllowlist()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssetProxyWhitelistIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .assetProxyWhitelist(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.assetProxyWhitelist()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStaticObjectsExternalStorageAuthTokenIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .staticObjectsExternalStorageAuthToken(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.staticObjectsExternalStorageAuthToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStaticObjectsExternalStorageUrlIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .staticObjectsExternalStorageUrl(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.staticObjectsExternalStorageUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthnDataRetentionCleanupEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .authnDataRetentionCleanupEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.authnDataRetentionCleanupEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorizedKeysEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .authorizedKeysEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.authorizedKeysEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoDevopsEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .autoDevopsEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.autoDevopsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoDevopsDomainIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .autoDevopsDomain(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.autoDevopsDomain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoAcceptAwardedAchievementsIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .autoAcceptAwardedAchievements(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.autoAcceptAwardedAchievements()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoBanUserOnExcessiveProjectsDownloadIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .autoBanUserOnExcessiveProjectsDownload(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.autoBanUserOnExcessiveProjectsDownload()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoDuoCodeReviewEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .autoDuoCodeReviewEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.autoDuoCodeReviewEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutocompleteUsersLimitIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .autocompleteUsersLimit(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.autocompleteUsersLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutocompleteUsersUnauthenticatedLimitIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .autocompleteUsersUnauthenticatedLimit(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.autocompleteUsersUnauthenticatedLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCodeDropdownCustomClientsIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .codeDropdownCustomClients(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.codeDropdownCustomClients()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCodeSuggestionsApiRateLimitIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .codeSuggestionsApiRateLimit(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.codeSuggestionsApiRateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConcurrentGithubImportJobsLimitIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .concurrentGithubImportJobsLimit(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.concurrentGithubImportJobsLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConcurrentBitbucketImportJobsLimitIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .concurrentBitbucketImportJobsLimit(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.concurrentBitbucketImportJobsLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConcurrentBitbucketServerImportJobsLimitIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .concurrentBitbucketServerImportJobsLimit(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.concurrentBitbucketServerImportJobsLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConcurrentPullRequestImportJobsLimitIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .concurrentPullRequestImportJobsLimit(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.concurrentPullRequestImportJobsLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConcurrentRelationBatchExportLimitIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .concurrentRelationBatchExportLimit(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.concurrentRelationBatchExportLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConcurrentRelationExportLimitIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .concurrentRelationExportLimit(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.concurrentRelationExportLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportJobsConcurrencyLimitIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .importJobsConcurrencyLimit(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.importJobsConcurrencyLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportSourcesIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .importSources(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.importSources()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOauthAccessTokenExpiresInIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .oauthAccessTokenExpiresIn(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.oauthAccessTokenExpiresIn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDecompressArchiveFileTimeoutIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .decompressArchiveFileTimeout(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.decompressArchiveFileTimeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeleteInactiveProjectsIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .deleteInactiveProjects(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.deleteInactiveProjects()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeleteUnconfirmedUsersIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .deleteUnconfirmedUsers(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.deleteUnconfirmedUsers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeletionAdjournedPeriodIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .deletionAdjournedPeriod(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.deletionAdjournedPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDenyAllRequestsExceptAllowedIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .denyAllRequestsExceptAllowed(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.denyAllRequestsExceptAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyManagementSettingsIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .dependencyManagementSettings(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.dependencyManagementSettings()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyFirewallPoliciesPerConfigurationLimitIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .dependencyFirewallPoliciesPerConfigurationLimit(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.dependencyFirewallPoliciesPerConfigurationLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyScanningSbomScanApiUploadLimitIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .dependencyScanningSbomScanApiUploadLimit(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.dependencyScanningSbomScanApiUploadLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyScanningSbomScanApiDownloadLimitIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .dependencyScanningSbomScanApiDownloadLimit(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.dependencyScanningSbomScanApiDownloadLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDisableAdminOauthScopesIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .disableAdminOauthScopes(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.disableAdminOauthScopes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDisableFeedTokenIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .disableFeedToken(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.disableFeedToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDisablePasswordAuthenticationForUsersWithSsoIdentitiesIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .disablePasswordAuthenticationForUsersWithSsoIdentities(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.disablePasswordAuthenticationForUsersWithSsoIdentities())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDisableOverridingApproversPerMergeRequestIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .disableOverridingApproversPerMergeRequest(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.disableOverridingApproversPerMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDisablePersonalAccessTokensIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .disablePersonalAccessTokens(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.disablePersonalAccessTokens()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBlockJwtForReclaimedPathsIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .blockJwtForReclaimedPaths(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.blockJwtForReclaimedPaths()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRootMovedPermanentlyRedirectionIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .rootMovedPermanentlyRedirection(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.rootMovedPermanentlyRedirection()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDisabledOauthSignInSourcesIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .disabledOauthSignInSources(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.disabledOauthSignInSources()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDisabledDirectCodeSuggestionsIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .disabledDirectCodeSuggestions(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.disabledDirectCodeSuggestions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDomainDenylistIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .domainDenylist(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.domainDenylist()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDomainDenylistEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .domainDenylistEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.domainDenylistEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDomainDenylistRawIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .domainDenylistRaw(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.domainDenylistRaw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDomainAllowlistIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .domainAllowlist(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.domainAllowlist()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDomainAllowlistRawIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .domainAllowlistRaw(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.domainAllowlistRaw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOutboundLocalRequestsAllowlistRawIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .outboundLocalRequestsAllowlistRaw(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.outboundLocalRequestsAllowlistRaw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOutboundLocalRequestsWhitelistIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .outboundLocalRequestsWhitelist(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.outboundLocalRequestsWhitelist()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDsaKeyRestrictionIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .dsaKeyRestriction(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.dsaKeyRestriction()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEcdsaKeyRestrictionIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .ecdsaKeyRestriction(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.ecdsaKeyRestriction()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEcdsaSkKeyRestrictionIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .ecdsaSkKeyRestriction(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.ecdsaSkKeyRestriction()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEd25519KeyRestrictionIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .ed25519KeyRestriction(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.ed25519KeyRestriction()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEd25519SkKeyRestrictionIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .ed25519SkKeyRestriction(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.ed25519SkKeyRestriction()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEksIntegrationEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .eksIntegrationEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.eksIntegrationEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEksAccountIdIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .eksAccountId(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.eksAccountId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEksAccessKeyIdIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .eksAccessKeyId(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.eksAccessKeyId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailAuthorInBodyIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .emailAuthorInBody(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.emailAuthorInBody()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailConfirmationSettingIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .emailConfirmationSetting(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.emailConfirmationSetting()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailOtpEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .emailOtpEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.emailOtpEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailRestrictionsEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .emailRestrictionsEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.emailRestrictionsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailRestrictionsIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .emailRestrictions(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.emailRestrictions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailAdditionalTextIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .emailAdditionalText(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.emailAdditionalText()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnabledGitAccessProtocolIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .enabledGitAccessProtocol(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.enabledGitAccessProtocol()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnabledExpandedLoggingIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .enabledExpandedLogging(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.enabledExpandedLogging()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnforceCiInboundJobTokenScopeEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .enforceCiInboundJobTokenScopeEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.enforceCiInboundJobTokenScopeEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnforceEmailSubaddressRestrictionsIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .enforceEmailSubaddressRestrictions(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.enforceEmailSubaddressRestrictions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnforceTermsIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .enforceTerms(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.enforceTerms()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnforceGranularTokensIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .enforceGranularTokens(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.enforceGranularTokens()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnforceNamespaceStorageLimitIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .enforceNamespaceStorageLimit(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.enforceNamespaceStorageLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnforcePiplComplianceIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .enforcePiplCompliance(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.enforcePiplCompliance()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequireEmailVerificationOnAccountLockedIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .requireEmailVerificationOnAccountLocked(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.requireEmailVerificationOnAccountLocked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequireShaForMergeIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .requireShaForMerge(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.requireShaForMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequireAdminApprovalAfterUserSignupIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .requireAdminApprovalAfterUserSignup(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.requireAdminApprovalAfterUserSignup()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequireAdminTwoFactorAuthenticationIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .requireAdminTwoFactorAuthentication(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.requireAdminTwoFactorAuthentication()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequireTwoFactorAuthenticationIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .requireTwoFactorAuthentication(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.requireTwoFactorAuthentication()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequirePersonalAccessTokenExpiryIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .requirePersonalAccessTokenExpiry(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.requirePersonalAccessTokenExpiry()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenErrorTrackingEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .errorTrackingEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.errorTrackingEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenErrorTrackingApiUrlIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .errorTrackingApiUrl(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.errorTrackingApiUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFailedLoginAttemptsUnlockPeriodInMinutesIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .failedLoginAttemptsUnlockPeriodInMinutes(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.failedLoginAttemptsUnlockPeriodInMinutes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFirstDayOfWeekIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .firstDayOfWeek(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.firstDayOfWeek()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFlocEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .flocEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.flocEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenForcePagesAccessControlIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .forcePagesAccessControl(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.forcePagesAccessControl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitalyTimeoutDefaultIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .gitalyTimeoutDefault(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.gitalyTimeoutDefault()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitalyTimeoutMediumIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .gitalyTimeoutMedium(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.gitalyTimeoutMedium()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitalyTimeoutFastIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .gitalyTimeoutFast(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.gitalyTimeoutFast()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitpodEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .gitpodEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.gitpodEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitpodUrlIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .gitpodUrl(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.gitpodUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGrafanaEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .grafanaEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.grafanaEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGrafanaUrlIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .grafanaUrl(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.grafanaUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGravatarEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .gravatarEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.gravatarEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHashedStorageEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .hashedStorageEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.hashedStorageEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHelpPageHideCommercialContentIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .helpPageHideCommercialContent(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.helpPageHideCommercialContent()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHelpPageSupportUrlIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .helpPageSupportUrl(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.helpPageSupportUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHelpPageDocumentationBaseUrlIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .helpPageDocumentationBaseUrl(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.helpPageDocumentationBaseUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHelpPageTextIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .helpPageText(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.helpPageText()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHideThirdPartyOffersIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .hideThirdPartyOffers(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.hideThirdPartyOffers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHomePageUrlIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .homePageUrl(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.homePageUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHousekeepingEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .housekeepingEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.housekeepingEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHousekeepingFullRepackPeriodIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .housekeepingFullRepackPeriod(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.housekeepingFullRepackPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHousekeepingGcPeriodIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .housekeepingGcPeriod(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.housekeepingGcPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHousekeepingIncrementalRepackPeriodIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .housekeepingIncrementalRepackPeriod(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.housekeepingIncrementalRepackPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHousekeepingOptimizeRepositoryPeriodIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .housekeepingOptimizeRepositoryPeriod(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.housekeepingOptimizeRepositoryPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHousekeepingBitmapsEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .housekeepingBitmapsEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.housekeepingBitmapsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHtmlEmailsEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .htmlEmailsEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.htmlEmailsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIframeRenderingEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .iframeRenderingEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.iframeRenderingEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIframeRenderingAllowlistIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .iframeRenderingAllowlist(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.iframeRenderingAllowlist()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIframeRenderingAllowlistRawIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .iframeRenderingAllowlistRaw(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.iframeRenderingAllowlistRaw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInactiveResourceAccessTokensDeleteAfterDaysIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .inactiveResourceAccessTokensDeleteAfterDays(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.inactiveResourceAccessTokensDeleteAfterDays()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInactiveProjectsDeleteAfterMonthsIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .inactiveProjectsDeleteAfterMonths(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.inactiveProjectsDeleteAfterMonths()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInactiveProjectsMinSizeMbIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .inactiveProjectsMinSizeMb(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.inactiveProjectsMinSizeMb()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInactiveProjectsSendWarningEmailAfterMonthsIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .inactiveProjectsSendWarningEmailAfterMonths(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.inactiveProjectsSendWarningEmailAfterMonths()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeOptionalMetricsInServicePingIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .includeOptionalMetricsInServicePing(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.includeOptionalMetricsInServicePing()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInvisibleCaptchaEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .invisibleCaptchaEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.invisibleCaptchaEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraConnectApplicationKeyIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .jiraConnectApplicationKey(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.jiraConnectApplicationKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraConnectPublicKeyStorageEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .jiraConnectPublicKeyStorageEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.jiraConnectPublicKeyStorageEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraConnectProxyUrlIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .jiraConnectProxyUrl(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.jiraConnectProxyUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraConnectAdditionalAudienceUrlIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .jiraConnectAdditionalAudienceUrl(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.jiraConnectAdditionalAudienceUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraConnectDomainAllowlistIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .jiraConnectDomainAllowlist(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.jiraConnectDomainAllowlist()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraConnectDomainAllowlistRawIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .jiraConnectDomainAllowlistRaw(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.jiraConnectDomainAllowlistRaw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraForgeAppIdIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .jiraForgeAppId(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.jiraForgeAppId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMathRenderingLimitsEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .mathRenderingLimitsEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.mathRenderingLimitsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMetricsMethodCallThresholdIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .metricsMethodCallThreshold(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.metricsMethodCallThreshold()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumPasswordLengthIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .minimumPasswordLength(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.minimumPasswordLength()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumLanguageServerVersionIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .minimumLanguageServerVersion(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.minimumLanguageServerVersion()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorAvailableIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .mirrorAvailable(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.mirrorAvailable()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorMaxCapacityIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .mirrorMaxCapacity(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.mirrorMaxCapacity()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorMaxDelayIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .mirrorMaxDelay(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.mirrorMaxDelay()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorCapacityThresholdIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .mirrorCapacityThreshold(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.mirrorCapacityThreshold()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnUnknownSignInIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .notifyOnUnknownSignIn(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.notifyOnUnknownSignIn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenO11yProvisionerUrlIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .o11yProvisionerUrl(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.o11yProvisionerUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationClusterAgentAuthorizationEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .organizationClusterAgentAuthorizationEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.organizationClusterAgentAuthorizationEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesDomainVerificationEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .pagesDomainVerificationEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.pagesDomainVerificationEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesUniqueDomainDefaultEnabledIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .pagesUniqueDomainDefaultEnabled(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.pagesUniqueDomainDefaultEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesExtraDeploymentsDefaultExpirySecondsIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .pagesExtraDeploymentsDefaultExpirySeconds(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.pagesExtraDeploymentsDefaultExpirySeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesDeploymentsApiLimitIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .pagesDeploymentsApiLimit(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.pagesDeploymentsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordAuthenticationEnabledForWebIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .passwordAuthenticationEnabledForWeb(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.passwordAuthenticationEnabledForWeb()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordAuthenticationEnabledForGitIsNullable() {
        final GitLabApplicationSettingOtherBuilder builder = GitLabApplicationSettingOtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOther())
                .passwordAuthenticationEnabledForGit(null);

        final GitLabApplicationSettingOther built = builder.build();

        assertThat(built.passwordAuthenticationEnabledForGit()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplicationSettingOther value = SettingsCatalogFixtures.applicationSettingOther();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo("id");
            softly.assertThat(value.performanceBarAllowedGroupId()).isEqualTo("performance_bar_allowed_group_id");
            softly.assertThat(value.abuseNotificationEmail()).isEqualTo("abuse_notification_email");
            softly.assertThat(value.adminMode()).isEqualTo("admin_mode");
            softly.assertThat(value.afterSignOutPath()).isEqualTo("after_sign_out_path");
            softly.assertThat(value.afterSignUpText()).isEqualTo("after_sign_up_text");
            softly.assertThat(value.akismetApiKey()).isEqualTo("akismet_api_key");
            softly.assertThat(value.akismetEnabled()).isEqualTo("akismet_enabled");
            softly.assertThat(value.dnsRebindingProtectionEnabled()).isEqualTo("dns_rebinding_protection_enabled");
            softly.assertThat(value.archiveBuildsInHumanReadable()).isEqualTo("archive_builds_in_human_readable");
            softly.assertThat(value.assetProxyEnabled()).isEqualTo("asset_proxy_enabled");
            softly.assertThat(value.assetProxyUrl()).isEqualTo("asset_proxy_url");
            softly.assertThat(value.assetProxyAllowlist()).isEqualTo("asset_proxy_allowlist");
            softly.assertThat(value.assetProxyWhitelist()).isEqualTo("asset_proxy_whitelist");
            softly.assertThat(value.staticObjectsExternalStorageAuthToken())
                    .isEqualTo("static_objects_external_storage_auth_token");
            softly.assertThat(value.staticObjectsExternalStorageUrl()).isEqualTo("static_objects_external_storage_url");
            softly.assertThat(value.authnDataRetentionCleanupEnabled())
                    .isEqualTo("authn_data_retention_cleanup_enabled");
            softly.assertThat(value.authorizedKeysEnabled()).isEqualTo("authorized_keys_enabled");
            softly.assertThat(value.autoDevopsEnabled()).isEqualTo("auto_devops_enabled");
            softly.assertThat(value.autoDevopsDomain()).isEqualTo("auto_devops_domain");
            softly.assertThat(value.autoAcceptAwardedAchievements()).isEqualTo("auto_accept_awarded_achievements");
            softly.assertThat(value.autoBanUserOnExcessiveProjectsDownload())
                    .isEqualTo("auto_ban_user_on_excessive_projects_download");
            softly.assertThat(value.autoDuoCodeReviewEnabled()).isEqualTo("auto_duo_code_review_enabled");
            softly.assertThat(value.autocompleteUsersLimit()).isEqualTo("autocomplete_users_limit");
            softly.assertThat(value.autocompleteUsersUnauthenticatedLimit())
                    .isEqualTo("autocomplete_users_unauthenticated_limit");
            softly.assertThat(value.codeDropdownCustomClients()).isEqualTo("code_dropdown_custom_clients");
            softly.assertThat(value.codeSuggestionsApiRateLimit()).isEqualTo("code_suggestions_api_rate_limit");
            softly.assertThat(value.concurrentGithubImportJobsLimit()).isEqualTo("concurrent_github_import_jobs_limit");
            softly.assertThat(value.concurrentBitbucketImportJobsLimit())
                    .isEqualTo("concurrent_bitbucket_import_jobs_limit");
            softly.assertThat(value.concurrentBitbucketServerImportJobsLimit())
                    .isEqualTo("concurrent_bitbucket_server_import_jobs_limit");
            softly.assertThat(value.concurrentPullRequestImportJobsLimit())
                    .isEqualTo("concurrent_pull_request_import_jobs_limit");
            softly.assertThat(value.concurrentRelationBatchExportLimit())
                    .isEqualTo("concurrent_relation_batch_export_limit");
            softly.assertThat(value.concurrentRelationExportLimit()).isEqualTo("concurrent_relation_export_limit");
            softly.assertThat(value.importJobsConcurrencyLimit()).isEqualTo("import_jobs_concurrency_limit");
            softly.assertThat(value.importSources()).isEqualTo("import_sources");
            softly.assertThat(value.oauthAccessTokenExpiresIn()).isEqualTo("oauth_access_token_expires_in");
            softly.assertThat(value.decompressArchiveFileTimeout()).isEqualTo("decompress_archive_file_timeout");
            softly.assertThat(value.deleteInactiveProjects()).isEqualTo("delete_inactive_projects");
            softly.assertThat(value.deleteUnconfirmedUsers()).isEqualTo("delete_unconfirmed_users");
            softly.assertThat(value.deletionAdjournedPeriod()).isEqualTo("deletion_adjourned_period");
            softly.assertThat(value.denyAllRequestsExceptAllowed()).isEqualTo("deny_all_requests_except_allowed");
            softly.assertThat(value.dependencyManagementSettings()).isEqualTo("dependency_management_settings");
            softly.assertThat(value.dependencyFirewallPoliciesPerConfigurationLimit())
                    .isEqualTo("dependency_firewall_policies_per_configuration_limit");
            softly.assertThat(value.dependencyScanningSbomScanApiUploadLimit())
                    .isEqualTo("dependency_scanning_sbom_scan_api_upload_limit");
            softly.assertThat(value.dependencyScanningSbomScanApiDownloadLimit())
                    .isEqualTo("dependency_scanning_sbom_scan_api_download_limit");
            softly.assertThat(value.disableAdminOauthScopes()).isEqualTo("disable_admin_oauth_scopes");
            softly.assertThat(value.disableFeedToken()).isEqualTo("disable_feed_token");
            softly.assertThat(value.disablePasswordAuthenticationForUsersWithSsoIdentities())
                    .isEqualTo("disable_password_authentication_for_users_with_sso_identities");
            softly.assertThat(value.disableOverridingApproversPerMergeRequest())
                    .isEqualTo("disable_overriding_approvers_per_merge_request");
            softly.assertThat(value.disablePersonalAccessTokens()).isEqualTo("disable_personal_access_tokens");
            softly.assertThat(value.blockJwtForReclaimedPaths()).isEqualTo("block_jwt_for_reclaimed_paths");
            softly.assertThat(value.rootMovedPermanentlyRedirection()).isEqualTo("root_moved_permanently_redirection");
            softly.assertThat(value.disabledOauthSignInSources()).isEqualTo("disabled_oauth_sign_in_sources");
            softly.assertThat(value.disabledDirectCodeSuggestions()).isEqualTo("disabled_direct_code_suggestions");
            softly.assertThat(value.domainDenylist()).isEqualTo("domain_denylist");
            softly.assertThat(value.domainDenylistEnabled()).isEqualTo("domain_denylist_enabled");
            softly.assertThat(value.domainDenylistRaw()).isEqualTo("domain_denylist_raw");
            softly.assertThat(value.domainAllowlist()).isEqualTo("domain_allowlist");
            softly.assertThat(value.domainAllowlistRaw()).isEqualTo("domain_allowlist_raw");
            softly.assertThat(value.outboundLocalRequestsAllowlistRaw())
                    .isEqualTo("outbound_local_requests_allowlist_raw");
            softly.assertThat(value.outboundLocalRequestsWhitelist()).isEqualTo("outbound_local_requests_whitelist");
            softly.assertThat(value.dsaKeyRestriction()).isEqualTo("dsa_key_restriction");
            softly.assertThat(value.ecdsaKeyRestriction()).isEqualTo("ecdsa_key_restriction");
            softly.assertThat(value.ecdsaSkKeyRestriction()).isEqualTo("ecdsa_sk_key_restriction");
            softly.assertThat(value.ed25519KeyRestriction()).isEqualTo("ed25519_key_restriction");
            softly.assertThat(value.ed25519SkKeyRestriction()).isEqualTo("ed25519_sk_key_restriction");
            softly.assertThat(value.eksIntegrationEnabled()).isEqualTo("eks_integration_enabled");
            softly.assertThat(value.eksAccountId()).isEqualTo("eks_account_id");
            softly.assertThat(value.eksAccessKeyId()).isEqualTo("eks_access_key_id");
            softly.assertThat(value.emailAuthorInBody()).isEqualTo("email_author_in_body");
            softly.assertThat(value.emailConfirmationSetting()).isEqualTo("email_confirmation_setting");
            softly.assertThat(value.emailOtpEnabled()).isEqualTo("email_otp_enabled");
            softly.assertThat(value.emailRestrictionsEnabled()).isEqualTo("email_restrictions_enabled");
            softly.assertThat(value.emailRestrictions()).isEqualTo("email_restrictions");
            softly.assertThat(value.emailAdditionalText()).isEqualTo("email_additional_text");
            softly.assertThat(value.enabledGitAccessProtocol()).isEqualTo("enabled_git_access_protocol");
            softly.assertThat(value.enabledExpandedLogging()).isEqualTo("enabled_expanded_logging");
            softly.assertThat(value.enforceCiInboundJobTokenScopeEnabled())
                    .isEqualTo("enforce_ci_inbound_job_token_scope_enabled");
            softly.assertThat(value.enforceEmailSubaddressRestrictions())
                    .isEqualTo("enforce_email_subaddress_restrictions");
            softly.assertThat(value.enforceTerms()).isEqualTo("enforce_terms");
            softly.assertThat(value.enforceGranularTokens()).isEqualTo("enforce_granular_tokens");
            softly.assertThat(value.enforceNamespaceStorageLimit()).isEqualTo("enforce_namespace_storage_limit");
            softly.assertThat(value.enforcePiplCompliance()).isEqualTo("enforce_pipl_compliance");
            softly.assertThat(value.requireEmailVerificationOnAccountLocked())
                    .isEqualTo("require_email_verification_on_account_locked");
            softly.assertThat(value.requireShaForMerge()).isEqualTo("require_sha_for_merge");
            softly.assertThat(value.requireAdminApprovalAfterUserSignup())
                    .isEqualTo("require_admin_approval_after_user_signup");
            softly.assertThat(value.requireAdminTwoFactorAuthentication())
                    .isEqualTo("require_admin_two_factor_authentication");
            softly.assertThat(value.requireTwoFactorAuthentication()).isEqualTo("require_two_factor_authentication");
            softly.assertThat(value.requirePersonalAccessTokenExpiry())
                    .isEqualTo("require_personal_access_token_expiry");
            softly.assertThat(value.errorTrackingEnabled()).isEqualTo("error_tracking_enabled");
            softly.assertThat(value.errorTrackingApiUrl()).isEqualTo("error_tracking_api_url");
            softly.assertThat(value.failedLoginAttemptsUnlockPeriodInMinutes())
                    .isEqualTo("failed_login_attempts_unlock_period_in_minutes");
            softly.assertThat(value.firstDayOfWeek()).isEqualTo("first_day_of_week");
            softly.assertThat(value.flocEnabled()).isEqualTo("floc_enabled");
            softly.assertThat(value.forcePagesAccessControl()).isEqualTo("force_pages_access_control");
            softly.assertThat(value.gitalyTimeoutDefault()).isEqualTo("gitaly_timeout_default");
            softly.assertThat(value.gitalyTimeoutMedium()).isEqualTo("gitaly_timeout_medium");
            softly.assertThat(value.gitalyTimeoutFast()).isEqualTo("gitaly_timeout_fast");
            softly.assertThat(value.gitpodEnabled()).isEqualTo("gitpod_enabled");
            softly.assertThat(value.gitpodUrl()).isEqualTo("gitpod_url");
            softly.assertThat(value.grafanaEnabled()).isEqualTo("grafana_enabled");
            softly.assertThat(value.grafanaUrl()).isEqualTo("grafana_url");
            softly.assertThat(value.gravatarEnabled()).isEqualTo("gravatar_enabled");
            softly.assertThat(value.hashedStorageEnabled()).isEqualTo("hashed_storage_enabled");
            softly.assertThat(value.helpPageHideCommercialContent()).isEqualTo("help_page_hide_commercial_content");
            softly.assertThat(value.helpPageSupportUrl()).isEqualTo("help_page_support_url");
            softly.assertThat(value.helpPageDocumentationBaseUrl()).isEqualTo("help_page_documentation_base_url");
            softly.assertThat(value.helpPageText()).isEqualTo("help_page_text");
            softly.assertThat(value.hideThirdPartyOffers()).isEqualTo("hide_third_party_offers");
            softly.assertThat(value.homePageUrl()).isEqualTo("home_page_url");
            softly.assertThat(value.housekeepingEnabled()).isEqualTo("housekeeping_enabled");
            softly.assertThat(value.housekeepingFullRepackPeriod()).isEqualTo("housekeeping_full_repack_period");
            softly.assertThat(value.housekeepingGcPeriod()).isEqualTo("housekeeping_gc_period");
            softly.assertThat(value.housekeepingIncrementalRepackPeriod())
                    .isEqualTo("housekeeping_incremental_repack_period");
            softly.assertThat(value.housekeepingOptimizeRepositoryPeriod())
                    .isEqualTo("housekeeping_optimize_repository_period");
            softly.assertThat(value.housekeepingBitmapsEnabled()).isEqualTo("housekeeping_bitmaps_enabled");
            softly.assertThat(value.htmlEmailsEnabled()).isEqualTo("html_emails_enabled");
            softly.assertThat(value.iframeRenderingEnabled()).isEqualTo("iframe_rendering_enabled");
            softly.assertThat(value.iframeRenderingAllowlist()).isEqualTo("iframe_rendering_allowlist");
            softly.assertThat(value.iframeRenderingAllowlistRaw()).isEqualTo("iframe_rendering_allowlist_raw");
            softly.assertThat(value.inactiveResourceAccessTokensDeleteAfterDays())
                    .isEqualTo("inactive_resource_access_tokens_delete_after_days");
            softly.assertThat(value.inactiveProjectsDeleteAfterMonths())
                    .isEqualTo("inactive_projects_delete_after_months");
            softly.assertThat(value.inactiveProjectsMinSizeMb()).isEqualTo("inactive_projects_min_size_mb");
            softly.assertThat(value.inactiveProjectsSendWarningEmailAfterMonths())
                    .isEqualTo("inactive_projects_send_warning_email_after_months");
            softly.assertThat(value.includeOptionalMetricsInServicePing())
                    .isEqualTo("include_optional_metrics_in_service_ping");
            softly.assertThat(value.invisibleCaptchaEnabled()).isEqualTo("invisible_captcha_enabled");
            softly.assertThat(value.jiraConnectApplicationKey()).isEqualTo("jira_connect_application_key");
            softly.assertThat(value.jiraConnectPublicKeyStorageEnabled())
                    .isEqualTo("jira_connect_public_key_storage_enabled");
            softly.assertThat(value.jiraConnectProxyUrl()).isEqualTo("jira_connect_proxy_url");
            softly.assertThat(value.jiraConnectAdditionalAudienceUrl())
                    .isEqualTo("jira_connect_additional_audience_url");
            softly.assertThat(value.jiraConnectDomainAllowlist()).isEqualTo("jira_connect_domain_allowlist");
            softly.assertThat(value.jiraConnectDomainAllowlistRaw()).isEqualTo("jira_connect_domain_allowlist_raw");
            softly.assertThat(value.jiraForgeAppId()).isEqualTo("jira_forge_app_id");
            softly.assertThat(value.mathRenderingLimitsEnabled()).isEqualTo("math_rendering_limits_enabled");
            softly.assertThat(value.metricsMethodCallThreshold()).isEqualTo("metrics_method_call_threshold");
            softly.assertThat(value.minimumPasswordLength()).isEqualTo("minimum_password_length");
            softly.assertThat(value.minimumLanguageServerVersion()).isEqualTo("minimum_language_server_version");
            softly.assertThat(value.mirrorAvailable()).isEqualTo("mirror_available");
            softly.assertThat(value.mirrorMaxCapacity()).isEqualTo("mirror_max_capacity");
            softly.assertThat(value.mirrorMaxDelay()).isEqualTo("mirror_max_delay");
            softly.assertThat(value.mirrorCapacityThreshold()).isEqualTo("mirror_capacity_threshold");
            softly.assertThat(value.notifyOnUnknownSignIn()).isEqualTo("notify_on_unknown_sign_in");
            softly.assertThat(value.o11yProvisionerUrl()).isEqualTo("o11y_provisioner_url");
            softly.assertThat(value.organizationClusterAgentAuthorizationEnabled())
                    .isEqualTo("organization_cluster_agent_authorization_enabled");
            softly.assertThat(value.pagesDomainVerificationEnabled()).isEqualTo("pages_domain_verification_enabled");
            softly.assertThat(value.pagesUniqueDomainDefaultEnabled()).isEqualTo("pages_unique_domain_default_enabled");
            softly.assertThat(value.pagesExtraDeploymentsDefaultExpirySeconds())
                    .isEqualTo("pages_extra_deployments_default_expiry_seconds");
            softly.assertThat(value.pagesDeploymentsApiLimit()).isEqualTo("pages_deployments_api_limit");
            softly.assertThat(value.passwordAuthenticationEnabledForWeb())
                    .isEqualTo("password_authentication_enabled_for_web");
            softly.assertThat(value.passwordAuthenticationEnabledForGit())
                    .isEqualTo("password_authentication_enabled_for_git");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApplicationSettingOther original = SettingsCatalogFixtures.applicationSettingOther();

        final GitLabApplicationSettingOther rebuilt =
                GitLabApplicationSettingOtherBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenStaticObjectsExternalStorageAuthTokenIsACredential() {
        final GitLabApplicationSettingOther value = SettingsCatalogFixtures.applicationSettingOther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenOauthAccessTokenExpiresInIsACredential() {
        final GitLabApplicationSettingOther value = SettingsCatalogFixtures.applicationSettingOther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenDisableFeedTokenIsACredential() {
        final GitLabApplicationSettingOther value = SettingsCatalogFixtures.applicationSettingOther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenDisablePasswordAuthenticationForUsersWithSsoIdentitiesIsACredential() {
        final GitLabApplicationSettingOther value = SettingsCatalogFixtures.applicationSettingOther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenDisablePersonalAccessTokensIsACredential() {
        final GitLabApplicationSettingOther value = SettingsCatalogFixtures.applicationSettingOther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenEnforceGranularTokensIsACredential() {
        final GitLabApplicationSettingOther value = SettingsCatalogFixtures.applicationSettingOther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenRequirePersonalAccessTokenExpiryIsACredential() {
        final GitLabApplicationSettingOther value = SettingsCatalogFixtures.applicationSettingOther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenInactiveResourceAccessTokensDeleteAfterDaysIsACredential() {
        final GitLabApplicationSettingOther value = SettingsCatalogFixtures.applicationSettingOther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenMinimumPasswordLengthIsACredential() {
        final GitLabApplicationSettingOther value = SettingsCatalogFixtures.applicationSettingOther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenPasswordAuthenticationEnabledForWebIsACredential() {
        final GitLabApplicationSettingOther value = SettingsCatalogFixtures.applicationSettingOther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenPasswordAuthenticationEnabledForGitIsACredential() {
        final GitLabApplicationSettingOther value = SettingsCatalogFixtures.applicationSettingOther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApplicationSettingOther.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "performanceBarAllowedGroupId",
                        "abuseNotificationEmail",
                        "adminMode",
                        "afterSignOutPath",
                        "afterSignUpText",
                        "akismetApiKey",
                        "akismetEnabled",
                        "dnsRebindingProtectionEnabled",
                        "archiveBuildsInHumanReadable",
                        "assetProxyEnabled",
                        "assetProxyUrl",
                        "assetProxyAllowlist",
                        "assetProxyWhitelist",
                        "staticObjectsExternalStorageAuthToken",
                        "staticObjectsExternalStorageUrl",
                        "authnDataRetentionCleanupEnabled",
                        "authorizedKeysEnabled",
                        "autoDevopsEnabled",
                        "autoDevopsDomain",
                        "autoAcceptAwardedAchievements",
                        "autoBanUserOnExcessiveProjectsDownload",
                        "autoDuoCodeReviewEnabled",
                        "autocompleteUsersLimit",
                        "autocompleteUsersUnauthenticatedLimit",
                        "codeDropdownCustomClients",
                        "codeSuggestionsApiRateLimit",
                        "concurrentGithubImportJobsLimit",
                        "concurrentBitbucketImportJobsLimit",
                        "concurrentBitbucketServerImportJobsLimit",
                        "concurrentPullRequestImportJobsLimit",
                        "concurrentRelationBatchExportLimit",
                        "concurrentRelationExportLimit",
                        "importJobsConcurrencyLimit",
                        "importSources",
                        "oauthAccessTokenExpiresIn",
                        "decompressArchiveFileTimeout",
                        "deleteInactiveProjects",
                        "deleteUnconfirmedUsers",
                        "deletionAdjournedPeriod",
                        "denyAllRequestsExceptAllowed",
                        "dependencyManagementSettings",
                        "dependencyFirewallPoliciesPerConfigurationLimit",
                        "dependencyScanningSbomScanApiUploadLimit",
                        "dependencyScanningSbomScanApiDownloadLimit",
                        "disableAdminOauthScopes",
                        "disableFeedToken",
                        "disablePasswordAuthenticationForUsersWithSsoIdentities",
                        "disableOverridingApproversPerMergeRequest",
                        "disablePersonalAccessTokens",
                        "blockJwtForReclaimedPaths",
                        "rootMovedPermanentlyRedirection",
                        "disabledOauthSignInSources",
                        "disabledDirectCodeSuggestions",
                        "domainDenylist",
                        "domainDenylistEnabled",
                        "domainDenylistRaw",
                        "domainAllowlist",
                        "domainAllowlistRaw",
                        "outboundLocalRequestsAllowlistRaw",
                        "outboundLocalRequestsWhitelist",
                        "dsaKeyRestriction",
                        "ecdsaKeyRestriction",
                        "ecdsaSkKeyRestriction",
                        "ed25519KeyRestriction",
                        "ed25519SkKeyRestriction",
                        "eksIntegrationEnabled",
                        "eksAccountId",
                        "eksAccessKeyId",
                        "emailAuthorInBody",
                        "emailConfirmationSetting",
                        "emailOtpEnabled",
                        "emailRestrictionsEnabled",
                        "emailRestrictions",
                        "emailAdditionalText",
                        "enabledGitAccessProtocol",
                        "enabledExpandedLogging",
                        "enforceCiInboundJobTokenScopeEnabled",
                        "enforceEmailSubaddressRestrictions",
                        "enforceTerms",
                        "enforceGranularTokens",
                        "enforceNamespaceStorageLimit",
                        "enforcePiplCompliance",
                        "requireEmailVerificationOnAccountLocked",
                        "requireShaForMerge",
                        "requireAdminApprovalAfterUserSignup",
                        "requireAdminTwoFactorAuthentication",
                        "requireTwoFactorAuthentication",
                        "requirePersonalAccessTokenExpiry",
                        "errorTrackingEnabled",
                        "errorTrackingApiUrl",
                        "failedLoginAttemptsUnlockPeriodInMinutes",
                        "firstDayOfWeek",
                        "flocEnabled",
                        "forcePagesAccessControl",
                        "gitalyTimeoutDefault",
                        "gitalyTimeoutMedium",
                        "gitalyTimeoutFast",
                        "gitpodEnabled",
                        "gitpodUrl",
                        "grafanaEnabled",
                        "grafanaUrl",
                        "gravatarEnabled",
                        "hashedStorageEnabled",
                        "helpPageHideCommercialContent",
                        "helpPageSupportUrl",
                        "helpPageDocumentationBaseUrl",
                        "helpPageText",
                        "hideThirdPartyOffers",
                        "homePageUrl",
                        "housekeepingEnabled",
                        "housekeepingFullRepackPeriod",
                        "housekeepingGcPeriod",
                        "housekeepingIncrementalRepackPeriod",
                        "housekeepingOptimizeRepositoryPeriod",
                        "housekeepingBitmapsEnabled",
                        "htmlEmailsEnabled",
                        "iframeRenderingEnabled",
                        "iframeRenderingAllowlist",
                        "iframeRenderingAllowlistRaw",
                        "inactiveResourceAccessTokensDeleteAfterDays",
                        "inactiveProjectsDeleteAfterMonths",
                        "inactiveProjectsMinSizeMb",
                        "inactiveProjectsSendWarningEmailAfterMonths",
                        "includeOptionalMetricsInServicePing",
                        "invisibleCaptchaEnabled",
                        "jiraConnectApplicationKey",
                        "jiraConnectPublicKeyStorageEnabled",
                        "jiraConnectProxyUrl",
                        "jiraConnectAdditionalAudienceUrl",
                        "jiraConnectDomainAllowlist",
                        "jiraConnectDomainAllowlistRaw",
                        "jiraForgeAppId",
                        "mathRenderingLimitsEnabled",
                        "metricsMethodCallThreshold",
                        "minimumPasswordLength",
                        "minimumLanguageServerVersion",
                        "mirrorAvailable",
                        "mirrorMaxCapacity",
                        "mirrorMaxDelay",
                        "mirrorCapacityThreshold",
                        "notifyOnUnknownSignIn",
                        "o11yProvisionerUrl",
                        "organizationClusterAgentAuthorizationEnabled",
                        "pagesDomainVerificationEnabled",
                        "pagesUniqueDomainDefaultEnabled",
                        "pagesExtraDeploymentsDefaultExpirySeconds",
                        "pagesDeploymentsApiLimit",
                        "passwordAuthenticationEnabledForWeb",
                        "passwordAuthenticationEnabledForGit");
    }
}

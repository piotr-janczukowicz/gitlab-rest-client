package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdateOtherTest {

    @Test
    void constructor_shouldAcceptNull_whenAdminModeIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .adminMode(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.adminMode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminNotificationEmailIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .adminNotificationEmail(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.adminNotificationEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAbuseNotificationEmailIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .abuseNotificationEmail(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.abuseNotificationEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAfterSignUpTextIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .afterSignUpText(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.afterSignUpText()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAfterSignOutPathIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .afterSignOutPath(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.afterSignOutPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAkismetEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .akismetEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.akismetEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAkismetApiKeyIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .akismetApiKey(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.akismetApiKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssetProxyEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .assetProxyEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.assetProxyEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssetProxyUrlIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .assetProxyUrl(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.assetProxyUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssetProxySecretKeyIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .assetProxySecretKey(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.assetProxySecretKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssetProxyWhitelistIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .assetProxyWhitelist(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.assetProxyWhitelist()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssetProxyAllowlistIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .assetProxyAllowlist(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.assetProxyAllowlist()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthnDataRetentionCleanupEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .authnDataRetentionCleanupEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.authnDataRetentionCleanupEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryTokenExpireDelayIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .containerRegistryTokenExpireDelay(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.containerRegistryTokenExpireDelay()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerExpirationPoliciesEnableHistoricEntriesIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .containerExpirationPoliciesEnableHistoricEntries(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.containerExpirationPoliciesEnableHistoricEntries()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryCleanupTagsServiceMaxListSizeIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .containerRegistryCleanupTagsServiceMaxListSize(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.containerRegistryCleanupTagsServiceMaxListSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryDeleteTagsServiceTimeoutIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .containerRegistryDeleteTagsServiceTimeout(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.containerRegistryDeleteTagsServiceTimeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryExpirationPoliciesCachingIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .containerRegistryExpirationPoliciesCaching(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.containerRegistryExpirationPoliciesCaching()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryExpirationPoliciesWorkerCapacityIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .containerRegistryExpirationPoliciesWorkerCapacity(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.containerRegistryExpirationPoliciesWorkerCapacity()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOauthAccessTokenExpiresInIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .oauthAccessTokenExpiresIn(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.oauthAccessTokenExpiresIn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDecompressArchiveFileTimeoutIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .decompressArchiveFileTimeout(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.decompressArchiveFileTimeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyManagementSettingsIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .dependencyManagementSettings(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.dependencyManagementSettings()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyFirewallPoliciesPerConfigurationLimitIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .dependencyFirewallPoliciesPerConfigurationLimit(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.dependencyFirewallPoliciesPerConfigurationLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyScanningSbomScanApiUploadLimitIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .dependencyScanningSbomScanApiUploadLimit(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.dependencyScanningSbomScanApiUploadLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyScanningSbomScanApiDownloadLimitIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .dependencyScanningSbomScanApiDownloadLimit(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.dependencyScanningSbomScanApiDownloadLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDisableAdminOauthScopesIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .disableAdminOauthScopes(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.disableAdminOauthScopes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDisableFeedTokenIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .disableFeedToken(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.disableFeedToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDisablePasswordAuthenticationForUsersWithSsoIdentitiesIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .disablePasswordAuthenticationForUsersWithSsoIdentities(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.disablePasswordAuthenticationForUsersWithSsoIdentities())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDisablePersonalAccessTokensIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .disablePersonalAccessTokens(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.disablePersonalAccessTokens()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDisableOverridingApproversPerMergeRequestIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .disableOverridingApproversPerMergeRequest(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.disableOverridingApproversPerMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDisableInviteMembersIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .disableInviteMembers(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.disableInviteMembers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDisabledOauthSignInSourcesIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .disabledOauthSignInSources(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.disabledOauthSignInSources()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDisabledDirectCodeSuggestionsIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .disabledDirectCodeSuggestions(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.disabledDirectCodeSuggestions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiscussionsResolveLimitIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .discussionsResolveLimit(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.discussionsResolveLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDraftNotesCreateLimitIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .draftNotesCreateLimit(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.draftNotesCreateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDomainDenylistEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .domainDenylistEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.domainDenylistEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDomainDenylistIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .domainDenylist(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.domainDenylist()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDomainAllowlistIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .domainAllowlist(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.domainAllowlist()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDomainDenylistRawIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .domainDenylistRaw(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.domainDenylistRaw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDomainAllowlistRawIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .domainAllowlistRaw(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.domainAllowlistRaw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOutboundLocalRequestsWhitelistIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .outboundLocalRequestsWhitelist(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.outboundLocalRequestsWhitelist()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOutboundLocalRequestsAllowlistRawIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .outboundLocalRequestsAllowlistRaw(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.outboundLocalRequestsAllowlistRaw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailOtpEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .emailOtpEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.emailOtpEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailAuthorInBodyIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .emailAuthorInBody(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.emailAuthorInBody()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailConfirmationSettingIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .emailConfirmationSetting(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.emailConfirmationSetting()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailRestrictionsIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .emailRestrictions(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.emailRestrictions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailRestrictionsEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .emailRestrictionsEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.emailRestrictionsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailAdditionalTextIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .emailAdditionalText(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.emailAdditionalText()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentDeleteRowsLimitPerUserIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .environmentDeleteRowsLimitPerUser(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.environmentDeleteRowsLimitPerUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIframeRenderingEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .iframeRenderingEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.iframeRenderingEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIframeRenderingAllowlistIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .iframeRenderingAllowlist(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.iframeRenderingAllowlist()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIframeRenderingAllowlistRawIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .iframeRenderingAllowlistRaw(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.iframeRenderingAllowlistRaw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEksIntegrationEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .eksIntegrationEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.eksIntegrationEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEksAccountIdIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .eksAccountId(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.eksAccountId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEksAccessKeyIdIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .eksAccessKeyId(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.eksAccessKeyId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEksSecretAccessKeyIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .eksSecretAccessKey(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.eksSecretAccessKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnabledGitAccessProtocolIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .enabledGitAccessProtocol(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.enabledGitAccessProtocol()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnabledExpandedLoggingIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .enabledExpandedLogging(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.enabledExpandedLogging()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitpodEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .gitpodEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.gitpodEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitpodUrlIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .gitpodUrl(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.gitpodUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitalyTimeoutDefaultIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .gitalyTimeoutDefault(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.gitalyTimeoutDefault()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitalyTimeoutFastIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .gitalyTimeoutFast(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.gitalyTimeoutFast()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitalyTimeoutMediumIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .gitalyTimeoutMedium(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.gitalyTimeoutMedium()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGrafanaEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .grafanaEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.grafanaEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGrafanaUrlIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .grafanaUrl(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.grafanaUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGravatarEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .gravatarEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.gravatarEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHelpPageHideCommercialContentIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .helpPageHideCommercialContent(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.helpPageHideCommercialContent()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHelpPageSupportUrlIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .helpPageSupportUrl(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.helpPageSupportUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHelpPageDocumentationBaseUrlIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .helpPageDocumentationBaseUrl(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.helpPageDocumentationBaseUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHelpPageTextIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .helpPageText(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.helpPageText()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHomePageUrlIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .homePageUrl(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.homePageUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHousekeepingEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .housekeepingEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.housekeepingEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHousekeepingFullRepackPeriodIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .housekeepingFullRepackPeriod(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.housekeepingFullRepackPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHousekeepingGcPeriodIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .housekeepingGcPeriod(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.housekeepingGcPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHousekeepingIncrementalRepackPeriodIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .housekeepingIncrementalRepackPeriod(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.housekeepingIncrementalRepackPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHousekeepingOptimizeRepositoryPeriodIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .housekeepingOptimizeRepositoryPeriod(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.housekeepingOptimizeRepositoryPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHtmlEmailsEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .htmlEmailsEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.htmlEmailsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportSourcesIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .importSources(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.importSources()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportJobsConcurrencyLimitIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .importJobsConcurrencyLimit(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.importJobsConcurrencyLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInvisibleCaptchaEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .invisibleCaptchaEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.invisibleCaptchaEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsCreateLimitIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .mergeRequestsCreateLimit(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.mergeRequestsCreateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsRebaseLimitIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .mergeRequestsRebaseLimit(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.mergeRequestsRebaseLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMetricsMethodCallThresholdIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .metricsMethodCallThreshold(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.metricsMethodCallThreshold()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenO11yProvisionerApiKeyIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .o11yProvisionerApiKey(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.o11yProvisionerApiKey()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenO11yProvisionerApiKeyIsTooLong() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .o11yProvisionerApiKey("x".repeat(511));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenO11yProvisionerApiKeyHasTheMaximumLength() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .o11yProvisionerApiKey("x".repeat(510));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenO11yProvisionerUrlIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .o11yProvisionerUrl(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.o11yProvisionerUrl()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenO11yProvisionerUrlIsTooLong() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .o11yProvisionerUrl("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenO11yProvisionerUrlHasTheMaximumLength() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .o11yProvisionerUrl("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordAuthenticationEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .passwordAuthenticationEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.passwordAuthenticationEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordAuthenticationEnabledForWebIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .passwordAuthenticationEnabledForWeb(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.passwordAuthenticationEnabledForWeb()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordAuthenticationEnabledForGitIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .passwordAuthenticationEnabledForGit(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.passwordAuthenticationEnabledForGit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordLowercaseRequiredIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .passwordLowercaseRequired(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.passwordLowercaseRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordNumberRequiredIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .passwordNumberRequired(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.passwordNumberRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordSymbolRequiredIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .passwordSymbolRequired(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.passwordSymbolRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordUppercaseRequiredIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .passwordUppercaseRequired(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.passwordUppercaseRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSigninEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .signinEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.signinEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPerformanceBarAllowedGroupIdIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .performanceBarAllowedGroupId(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.performanceBarAllowedGroupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPerformanceBarAllowedGroupPathIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .performanceBarAllowedGroupPath(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.performanceBarAllowedGroupPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPerformanceBarEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .performanceBarEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.performanceBarEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPersonalAccessTokenPrefixIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .personalAccessTokenPrefix(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.personalAccessTokenPrefix()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequirePersonalAccessTokenExpiryIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .requirePersonalAccessTokenExpiry(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.requirePersonalAccessTokenExpiry()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequireTwoFactorAuthenticationIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .requireTwoFactorAuthentication(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.requireTwoFactorAuthentication()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequireAdminApprovalAfterUserSignupIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .requireAdminApprovalAfterUserSignup(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.requireAdminApprovalAfterUserSignup()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequireAdminTwoFactorAuthenticationIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .requireAdminTwoFactorAuthentication(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.requireAdminTwoFactorAuthentication()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequireEmailVerificationOnAccountLockedIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .requireEmailVerificationOnAccountLocked(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.requireEmailVerificationOnAccountLocked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequireShaForMergeIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .requireShaForMerge(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.requireShaForMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKrokiEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .krokiEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.krokiEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKrokiUrlIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .krokiUrl(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.krokiUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKrokiDiagramProxyEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .krokiDiagramProxyEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.krokiDiagramProxyEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKrokiFormatsIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .krokiFormats(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.krokiFormats()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlantumlEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .plantumlEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.plantumlEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlantumlUrlIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .plantumlUrl(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.plantumlUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlantumlDiagramProxyEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .plantumlDiagramProxyEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.plantumlDiagramProxyEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiagramsnetEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .diagramsnetEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.diagramsnetEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiagramsnetUrlIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .diagramsnetUrl(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.diagramsnetUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPollingIntervalMultiplierIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .pollingIntervalMultiplier(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.pollingIntervalMultiplier()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPrometheusMetricsEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .prometheusMetricsEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.prometheusMetricsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventHooksLimitIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .pushEventHooksLimit(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.pushEventHooksLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventActivitiesLimitIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .pushEventActivitiesLimit(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.pushEventActivitiesLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRecaptchaEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .recaptchaEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.recaptchaEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRecaptchaSiteKeyIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .recaptchaSiteKey(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.recaptchaSiteKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRecaptchaPrivateKeyIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .recaptchaPrivateKey(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.recaptchaPrivateKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLoginRecaptchaProtectionEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .loginRecaptchaProtectionEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.loginRecaptchaProtectionEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryChecksEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .repositoryChecksEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.repositoryChecksEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryStoragesWeightedIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .repositoryStoragesWeighted(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.repositoryStoragesWeighted()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositorySizeLimitIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .repositorySizeLimit(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.repositorySizeLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTwoFactorGracePeriodIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .twoFactorGracePeriod(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.twoFactorGracePeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRestrictedVisibilityLevelsIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .restrictedVisibilityLevels(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.restrictedVisibilityLevels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSessionExpireDelayIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .sessionExpireDelay(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.sessionExpireDelay()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSessionExpireFromInitIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .sessionExpireFromInit(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.sessionExpireFromInit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSharedRunnersEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .sharedRunnersEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.sharedRunnersEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSharedRunnersTextIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .sharedRunnersText(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.sharedRunnersText()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSharedRunnersMinutesIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .sharedRunnersMinutes(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.sharedRunnersMinutes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValidRunnerRegistrarsIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .validRunnerRegistrars(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.validRunnerRegistrars()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSignupEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .signupEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.signupEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourcegraphEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .sourcegraphEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.sourcegraphEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourcegraphPublicOnlyIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .sourcegraphPublicOnly(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.sourcegraphPublicOnly()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourcegraphUrlIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .sourcegraphUrl(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.sourcegraphUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSpamCheckEndpointEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .spamCheckEndpointEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.spamCheckEndpointEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSpamCheckEndpointUrlIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .spamCheckEndpointUrl(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.spamCheckEndpointUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSpamCheckApiKeyIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .spamCheckApiKey(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.spamCheckApiKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerminalMaxSessionTimeIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .terminalMaxSessionTime(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.terminalMaxSessionTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsagePingEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .usagePingEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.usagePingEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsagePingGenerationEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .usagePingGenerationEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.usagePingGenerationEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsagePingFeaturesEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .usagePingFeaturesEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.usagePingFeaturesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLocalMarkdownVersionIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .localMarkdownVersion(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.localMarkdownVersion()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMailgunEventsEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .mailgunEventsEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.mailgunEventsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMailgunSigningKeyIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .mailgunSigningKey(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.mailgunSigningKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnowplowEnabledIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .snowplowEnabled(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.snowplowEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnowplowCollectorHostnameIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .snowplowCollectorHostname(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.snowplowCollectorHostname()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnowplowCookieDomainIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .snowplowCookieDomain(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.snowplowCookieDomain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnowplowAppIdIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .snowplowAppId(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.snowplowAppId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnowplowDatabaseCollectorHostnameIsNullable() {
        final GitLabSettingsUpdateOtherBuilder builder = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .snowplowDatabaseCollectorHostname(null);

        final GitLabSettingsUpdateOther built = builder.build();

        assertThat(built.snowplowDatabaseCollectorHostname()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdateOther value = SettingsCatalogFixtures.settingsUpdateOther();

        assertSoftly(softly -> {
            softly.assertThat(value.adminMode()).isEqualTo(true);
            softly.assertThat(value.adminNotificationEmail()).isEqualTo("admin_notification_email");
            softly.assertThat(value.abuseNotificationEmail()).isEqualTo("abuse_notification_email");
            softly.assertThat(value.afterSignUpText()).isEqualTo("after_sign_up_text");
            softly.assertThat(value.afterSignOutPath()).isEqualTo("after_sign_out_path");
            softly.assertThat(value.akismetEnabled()).isEqualTo(true);
            softly.assertThat(value.akismetApiKey()).isEqualTo("akismet_api_key");
            softly.assertThat(value.assetProxyEnabled()).isEqualTo(true);
            softly.assertThat(value.assetProxyUrl()).isEqualTo("asset_proxy_url");
            softly.assertThat(value.assetProxySecretKey()).isEqualTo("asset_proxy_secret_key");
            softly.assertThat(value.assetProxyWhitelist()).isEqualTo(List.of("asset_proxy_whitelist"));
            softly.assertThat(value.assetProxyAllowlist()).isEqualTo(List.of("asset_proxy_allowlist"));
            softly.assertThat(value.authnDataRetentionCleanupEnabled()).isEqualTo(true);
            softly.assertThat(value.containerRegistryTokenExpireDelay()).isEqualTo(1);
            softly.assertThat(value.containerExpirationPoliciesEnableHistoricEntries())
                    .isEqualTo("container_expiration_policies_enable_historic_entries");
            softly.assertThat(value.containerRegistryCleanupTagsServiceMaxListSize())
                    .isEqualTo("container_registry_cleanup_tags_service_max_list_size");
            softly.assertThat(value.containerRegistryDeleteTagsServiceTimeout())
                    .isEqualTo("container_registry_delete_tags_service_timeout");
            softly.assertThat(value.containerRegistryExpirationPoliciesCaching())
                    .isEqualTo("container_registry_expiration_policies_caching");
            softly.assertThat(value.containerRegistryExpirationPoliciesWorkerCapacity())
                    .isEqualTo("container_registry_expiration_policies_worker_capacity");
            softly.assertThat(value.oauthAccessTokenExpiresIn()).isEqualTo(1);
            softly.assertThat(value.decompressArchiveFileTimeout()).isEqualTo(1);
            softly.assertThat(value.dependencyManagementSettings())
                    .isEqualTo(SettingsCatalogFixtures.settingsUpdateDependencyManagementSettings());
            softly.assertThat(value.dependencyFirewallPoliciesPerConfigurationLimit())
                    .isEqualTo("dependency_firewall_policies_per_configuration_limit");
            softly.assertThat(value.dependencyScanningSbomScanApiUploadLimit())
                    .isEqualTo("dependency_scanning_sbom_scan_api_upload_limit");
            softly.assertThat(value.dependencyScanningSbomScanApiDownloadLimit())
                    .isEqualTo("dependency_scanning_sbom_scan_api_download_limit");
            softly.assertThat(value.disableAdminOauthScopes()).isEqualTo(true);
            softly.assertThat(value.disableFeedToken()).isEqualTo(true);
            softly.assertThat(value.disablePasswordAuthenticationForUsersWithSsoIdentities())
                    .isEqualTo("disable_password_authentication_for_users_with_sso_identities");
            softly.assertThat(value.disablePersonalAccessTokens()).isEqualTo(true);
            softly.assertThat(value.disableOverridingApproversPerMergeRequest()).isEqualTo(true);
            softly.assertThat(value.disableInviteMembers()).isEqualTo("disable_invite_members");
            softly.assertThat(value.disabledOauthSignInSources()).isEqualTo(List.of("disabled_oauth_sign_in_sources"));
            softly.assertThat(value.disabledDirectCodeSuggestions()).isEqualTo(true);
            softly.assertThat(value.discussionsResolveLimit()).isEqualTo(1);
            softly.assertThat(value.draftNotesCreateLimit()).isEqualTo(1);
            softly.assertThat(value.domainDenylistEnabled()).isEqualTo(true);
            softly.assertThat(value.domainDenylist()).isEqualTo(List.of("domain_denylist"));
            softly.assertThat(value.domainAllowlist()).isEqualTo(List.of("domain_allowlist"));
            softly.assertThat(value.domainDenylistRaw()).isEqualTo("domain_denylist_raw");
            softly.assertThat(value.domainAllowlistRaw()).isEqualTo("domain_allowlist_raw");
            softly.assertThat(value.outboundLocalRequestsWhitelist())
                    .isEqualTo(List.of("outbound_local_requests_whitelist"));
            softly.assertThat(value.outboundLocalRequestsAllowlistRaw())
                    .isEqualTo("outbound_local_requests_allowlist_raw");
            softly.assertThat(value.emailOtpEnabled()).isEqualTo(true);
            softly.assertThat(value.emailAuthorInBody()).isEqualTo(true);
            softly.assertThat(value.emailConfirmationSetting())
                    .isEqualTo(GitLabSettingsUpdateEmailConfirmationSetting.OFF);
            softly.assertThat(value.emailRestrictions()).isEqualTo("email_restrictions");
            softly.assertThat(value.emailRestrictionsEnabled()).isEqualTo("email_restrictions_enabled");
            softly.assertThat(value.emailAdditionalText()).isEqualTo("email_additional_text");
            softly.assertThat(value.environmentDeleteRowsLimitPerUser()).isEqualTo(1);
            softly.assertThat(value.iframeRenderingEnabled()).isEqualTo(true);
            softly.assertThat(value.iframeRenderingAllowlist()).isEqualTo(List.of("iframe_rendering_allowlist"));
            softly.assertThat(value.iframeRenderingAllowlistRaw()).isEqualTo("iframe_rendering_allowlist_raw");
            softly.assertThat(value.eksIntegrationEnabled()).isEqualTo(true);
            softly.assertThat(value.eksAccountId()).isEqualTo("eks_account_id");
            softly.assertThat(value.eksAccessKeyId()).isEqualTo("eks_access_key_id");
            softly.assertThat(value.eksSecretAccessKey()).isEqualTo("eks_secret_access_key");
            softly.assertThat(value.enabledGitAccessProtocol())
                    .isEqualTo(GitLabSettingsUpdateEnabledGitAccessProtocol.SSH);
            softly.assertThat(value.enabledExpandedLogging()).isEqualTo("enabled_expanded_logging");
            softly.assertThat(value.gitpodEnabled()).isEqualTo(true);
            softly.assertThat(value.gitpodUrl()).isEqualTo("gitpod_url");
            softly.assertThat(value.gitalyTimeoutDefault()).isEqualTo(1);
            softly.assertThat(value.gitalyTimeoutFast()).isEqualTo(1);
            softly.assertThat(value.gitalyTimeoutMedium()).isEqualTo(1);
            softly.assertThat(value.grafanaEnabled()).isEqualTo(true);
            softly.assertThat(value.grafanaUrl()).isEqualTo("grafana_url");
            softly.assertThat(value.gravatarEnabled()).isEqualTo(true);
            softly.assertThat(value.helpPageHideCommercialContent()).isEqualTo(true);
            softly.assertThat(value.helpPageSupportUrl()).isEqualTo("help_page_support_url");
            softly.assertThat(value.helpPageDocumentationBaseUrl()).isEqualTo("help_page_documentation_base_url");
            softly.assertThat(value.helpPageText()).isEqualTo("help_page_text");
            softly.assertThat(value.homePageUrl()).isEqualTo("home_page_url");
            softly.assertThat(value.housekeepingEnabled()).isEqualTo(true);
            softly.assertThat(value.housekeepingFullRepackPeriod()).isEqualTo(1);
            softly.assertThat(value.housekeepingGcPeriod()).isEqualTo(1);
            softly.assertThat(value.housekeepingIncrementalRepackPeriod()).isEqualTo(1);
            softly.assertThat(value.housekeepingOptimizeRepositoryPeriod()).isEqualTo(1);
            softly.assertThat(value.htmlEmailsEnabled()).isEqualTo(true);
            softly.assertThat(value.importSources()).isEqualTo(List.of(GitLabSettingsUpdateImportSources.GITHUB));
            softly.assertThat(value.importJobsConcurrencyLimit()).isEqualTo("import_jobs_concurrency_limit");
            softly.assertThat(value.invisibleCaptchaEnabled()).isEqualTo(true);
            softly.assertThat(value.mergeRequestsCreateLimit()).isEqualTo(1);
            softly.assertThat(value.mergeRequestsRebaseLimit()).isEqualTo(1);
            softly.assertThat(value.metricsMethodCallThreshold()).isEqualTo(1);
            softly.assertThat(value.o11yProvisionerApiKey()).isEqualTo("o11y_provisioner_api_key");
            softly.assertThat(value.o11yProvisionerUrl()).isEqualTo("o11y_provisioner_url");
            softly.assertThat(value.passwordAuthenticationEnabled()).isEqualTo(true);
            softly.assertThat(value.passwordAuthenticationEnabledForWeb()).isEqualTo(true);
            softly.assertThat(value.passwordAuthenticationEnabledForGit()).isEqualTo(true);
            softly.assertThat(value.passwordLowercaseRequired()).isEqualTo("password_lowercase_required");
            softly.assertThat(value.passwordNumberRequired()).isEqualTo("password_number_required");
            softly.assertThat(value.passwordSymbolRequired()).isEqualTo("password_symbol_required");
            softly.assertThat(value.passwordUppercaseRequired()).isEqualTo("password_uppercase_required");
            softly.assertThat(value.signinEnabled()).isEqualTo(true);
            softly.assertThat(value.performanceBarAllowedGroupId()).isEqualTo("performance_bar_allowed_group_id");
            softly.assertThat(value.performanceBarAllowedGroupPath()).isEqualTo("performance_bar_allowed_group_path");
            softly.assertThat(value.performanceBarEnabled()).isEqualTo("performance_bar_enabled");
            softly.assertThat(value.personalAccessTokenPrefix()).isEqualTo("personal_access_token_prefix");
            softly.assertThat(value.requirePersonalAccessTokenExpiry()).isEqualTo(true);
            softly.assertThat(value.requireTwoFactorAuthentication()).isEqualTo(true);
            softly.assertThat(value.requireAdminApprovalAfterUserSignup()).isEqualTo(true);
            softly.assertThat(value.requireAdminTwoFactorAuthentication())
                    .isEqualTo("require_admin_two_factor_authentication");
            softly.assertThat(value.requireEmailVerificationOnAccountLocked())
                    .isEqualTo("require_email_verification_on_account_locked");
            softly.assertThat(value.requireShaForMerge()).isEqualTo("require_sha_for_merge");
            softly.assertThat(value.krokiEnabled()).isEqualTo(true);
            softly.assertThat(value.krokiUrl()).isEqualTo("kroki_url");
            softly.assertThat(value.krokiDiagramProxyEnabled()).isEqualTo("kroki_diagram_proxy_enabled");
            softly.assertThat(value.krokiFormats()).isEqualTo("kroki_formats");
            softly.assertThat(value.plantumlEnabled()).isEqualTo(true);
            softly.assertThat(value.plantumlUrl()).isEqualTo("plantuml_url");
            softly.assertThat(value.plantumlDiagramProxyEnabled()).isEqualTo("plantuml_diagram_proxy_enabled");
            softly.assertThat(value.diagramsnetEnabled()).isEqualTo(true);
            softly.assertThat(value.diagramsnetUrl()).isEqualTo("diagramsnet_url");
            softly.assertThat(value.pollingIntervalMultiplier()).isEqualTo(1.5);
            softly.assertThat(value.prometheusMetricsEnabled()).isEqualTo(true);
            softly.assertThat(value.pushEventHooksLimit()).isEqualTo(1);
            softly.assertThat(value.pushEventActivitiesLimit()).isEqualTo(1);
            softly.assertThat(value.recaptchaEnabled()).isEqualTo(true);
            softly.assertThat(value.recaptchaSiteKey()).isEqualTo("recaptcha_site_key");
            softly.assertThat(value.recaptchaPrivateKey()).isEqualTo("recaptcha_private_key");
            softly.assertThat(value.loginRecaptchaProtectionEnabled()).isEqualTo(true);
            softly.assertThat(value.repositoryChecksEnabled()).isEqualTo(true);
            softly.assertThat(value.repositoryStoragesWeighted()).isEqualTo(Map.of("key", 1));
            softly.assertThat(value.repositorySizeLimit()).isEqualTo(1);
            softly.assertThat(value.twoFactorGracePeriod()).isEqualTo(1);
            softly.assertThat(value.restrictedVisibilityLevels()).isEqualTo(List.of("restricted_visibility_levels"));
            softly.assertThat(value.sessionExpireDelay()).isEqualTo(1);
            softly.assertThat(value.sessionExpireFromInit()).isEqualTo(true);
            softly.assertThat(value.sharedRunnersEnabled()).isEqualTo(true);
            softly.assertThat(value.sharedRunnersText()).isEqualTo("shared_runners_text");
            softly.assertThat(value.sharedRunnersMinutes()).isEqualTo("shared_runners_minutes");
            softly.assertThat(value.validRunnerRegistrars()).isEqualTo(List.of("valid_runner_registrars"));
            softly.assertThat(value.signupEnabled()).isEqualTo(true);
            softly.assertThat(value.sourcegraphEnabled()).isEqualTo(true);
            softly.assertThat(value.sourcegraphPublicOnly()).isEqualTo(true);
            softly.assertThat(value.sourcegraphUrl()).isEqualTo("sourcegraph_url");
            softly.assertThat(value.spamCheckEndpointEnabled()).isEqualTo(true);
            softly.assertThat(value.spamCheckEndpointUrl()).isEqualTo("spam_check_endpoint_url");
            softly.assertThat(value.spamCheckApiKey()).isEqualTo("spam_check_api_key");
            softly.assertThat(value.terminalMaxSessionTime()).isEqualTo(1);
            softly.assertThat(value.usagePingEnabled()).isEqualTo(true);
            softly.assertThat(value.usagePingGenerationEnabled()).isEqualTo("usage_ping_generation_enabled");
            softly.assertThat(value.usagePingFeaturesEnabled()).isEqualTo("usage_ping_features_enabled");
            softly.assertThat(value.localMarkdownVersion()).isEqualTo(1);
            softly.assertThat(value.mailgunEventsEnabled()).isEqualTo(true);
            softly.assertThat(value.mailgunSigningKey()).isEqualTo("mailgun_signing_key");
            softly.assertThat(value.snowplowEnabled()).isEqualTo(true);
            softly.assertThat(value.snowplowCollectorHostname()).isEqualTo("snowplow_collector_hostname");
            softly.assertThat(value.snowplowCookieDomain()).isEqualTo("snowplow_cookie_domain");
            softly.assertThat(value.snowplowAppId()).isEqualTo("snowplow_app_id");
            softly.assertThat(value.snowplowDatabaseCollectorHostname())
                    .isEqualTo("snowplow_database_collector_hostname");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSettingsUpdateOther original = SettingsCatalogFixtures.settingsUpdateOther();

        final GitLabSettingsUpdateOther rebuilt =
                GitLabSettingsUpdateOtherBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenAssetProxyWhitelistSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("asset_proxy_whitelist"));
        final GitLabSettingsUpdateOther built = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .assetProxyWhitelist(source)
                .build();
        source.clear();

        assertThat(built.assetProxyWhitelist()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAssetProxyWhitelistIsRead() {
        final GitLabSettingsUpdateOther built = SettingsCatalogFixtures.settingsUpdateOther();
        final List<String> values = built.assetProxyWhitelist();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenAssetProxyAllowlistSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("asset_proxy_allowlist"));
        final GitLabSettingsUpdateOther built = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .assetProxyAllowlist(source)
                .build();
        source.clear();

        assertThat(built.assetProxyAllowlist()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAssetProxyAllowlistIsRead() {
        final GitLabSettingsUpdateOther built = SettingsCatalogFixtures.settingsUpdateOther();
        final List<String> values = built.assetProxyAllowlist();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenDisabledOauthSignInSourcesSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("disabled_oauth_sign_in_sources"));
        final GitLabSettingsUpdateOther built = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .disabledOauthSignInSources(source)
                .build();
        source.clear();

        assertThat(built.disabledOauthSignInSources()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenDisabledOauthSignInSourcesIsRead() {
        final GitLabSettingsUpdateOther built = SettingsCatalogFixtures.settingsUpdateOther();
        final List<String> values = built.disabledOauthSignInSources();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenDomainDenylistSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("domain_denylist"));
        final GitLabSettingsUpdateOther built = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .domainDenylist(source)
                .build();
        source.clear();

        assertThat(built.domainDenylist()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenDomainDenylistIsRead() {
        final GitLabSettingsUpdateOther built = SettingsCatalogFixtures.settingsUpdateOther();
        final List<String> values = built.domainDenylist();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenDomainAllowlistSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("domain_allowlist"));
        final GitLabSettingsUpdateOther built = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .domainAllowlist(source)
                .build();
        source.clear();

        assertThat(built.domainAllowlist()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenDomainAllowlistIsRead() {
        final GitLabSettingsUpdateOther built = SettingsCatalogFixtures.settingsUpdateOther();
        final List<String> values = built.domainAllowlist();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenOutboundLocalRequestsWhitelistSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("outbound_local_requests_whitelist"));
        final GitLabSettingsUpdateOther built = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .outboundLocalRequestsWhitelist(source)
                .build();
        source.clear();

        assertThat(built.outboundLocalRequestsWhitelist()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenOutboundLocalRequestsWhitelistIsRead() {
        final GitLabSettingsUpdateOther built = SettingsCatalogFixtures.settingsUpdateOther();
        final List<String> values = built.outboundLocalRequestsWhitelist();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenIframeRenderingAllowlistSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("iframe_rendering_allowlist"));
        final GitLabSettingsUpdateOther built = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .iframeRenderingAllowlist(source)
                .build();
        source.clear();

        assertThat(built.iframeRenderingAllowlist()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenIframeRenderingAllowlistIsRead() {
        final GitLabSettingsUpdateOther built = SettingsCatalogFixtures.settingsUpdateOther();
        final List<String> values = built.iframeRenderingAllowlist();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenImportSourcesSourceChangesLater() {
        final List<GitLabSettingsUpdateImportSources> source =
                new ArrayList<>(List.of(GitLabSettingsUpdateImportSources.GITHUB));
        final GitLabSettingsUpdateOther built = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .importSources(source)
                .build();
        source.clear();

        assertThat(built.importSources()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenImportSourcesIsRead() {
        final GitLabSettingsUpdateOther built = SettingsCatalogFixtures.settingsUpdateOther();
        final List<GitLabSettingsUpdateImportSources> values = built.importSources();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheMap_whenRepositoryStoragesWeightedSourceChangesLater() {
        final Map<String, Integer> source = new LinkedHashMap<>(Map.of("key", 1));
        final GitLabSettingsUpdateOther built = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .repositoryStoragesWeighted(source)
                .build();
        source.clear();

        assertThat(built.repositoryStoragesWeighted()).isNotEmpty();
    }

    @Test
    void constructor_shouldCopyTheList_whenRestrictedVisibilityLevelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("restricted_visibility_levels"));
        final GitLabSettingsUpdateOther built = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .restrictedVisibilityLevels(source)
                .build();
        source.clear();

        assertThat(built.restrictedVisibilityLevels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenRestrictedVisibilityLevelsIsRead() {
        final GitLabSettingsUpdateOther built = SettingsCatalogFixtures.settingsUpdateOther();
        final List<String> values = built.restrictedVisibilityLevels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenValidRunnerRegistrarsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("valid_runner_registrars"));
        final GitLabSettingsUpdateOther built = GitLabSettingsUpdateOtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOther())
                .validRunnerRegistrars(source)
                .build();
        source.clear();

        assertThat(built.validRunnerRegistrars()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenValidRunnerRegistrarsIsRead() {
        final GitLabSettingsUpdateOther built = SettingsCatalogFixtures.settingsUpdateOther();
        final List<String> values = built.validRunnerRegistrars();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void toString_shouldMaskTheValue_whenAssetProxySecretKeyIsACredential() {
        final GitLabSettingsUpdateOther value = SettingsCatalogFixtures.settingsUpdateOther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenDisablePasswordAuthenticationForUsersWithSsoIdentitiesIsACredential() {
        final GitLabSettingsUpdateOther value = SettingsCatalogFixtures.settingsUpdateOther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenEksSecretAccessKeyIsACredential() {
        final GitLabSettingsUpdateOther value = SettingsCatalogFixtures.settingsUpdateOther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenPasswordLowercaseRequiredIsACredential() {
        final GitLabSettingsUpdateOther value = SettingsCatalogFixtures.settingsUpdateOther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenPasswordNumberRequiredIsACredential() {
        final GitLabSettingsUpdateOther value = SettingsCatalogFixtures.settingsUpdateOther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenPasswordSymbolRequiredIsACredential() {
        final GitLabSettingsUpdateOther value = SettingsCatalogFixtures.settingsUpdateOther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenPasswordUppercaseRequiredIsACredential() {
        final GitLabSettingsUpdateOther value = SettingsCatalogFixtures.settingsUpdateOther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenPersonalAccessTokenPrefixIsACredential() {
        final GitLabSettingsUpdateOther value = SettingsCatalogFixtures.settingsUpdateOther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenRecaptchaPrivateKeyIsACredential() {
        final GitLabSettingsUpdateOther value = SettingsCatalogFixtures.settingsUpdateOther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSettingsUpdateOther.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "adminMode",
                        "adminNotificationEmail",
                        "abuseNotificationEmail",
                        "afterSignUpText",
                        "afterSignOutPath",
                        "akismetEnabled",
                        "akismetApiKey",
                        "assetProxyEnabled",
                        "assetProxyUrl",
                        "assetProxySecretKey",
                        "assetProxyWhitelist",
                        "assetProxyAllowlist",
                        "authnDataRetentionCleanupEnabled",
                        "containerRegistryTokenExpireDelay",
                        "containerExpirationPoliciesEnableHistoricEntries",
                        "containerRegistryCleanupTagsServiceMaxListSize",
                        "containerRegistryDeleteTagsServiceTimeout",
                        "containerRegistryExpirationPoliciesCaching",
                        "containerRegistryExpirationPoliciesWorkerCapacity",
                        "oauthAccessTokenExpiresIn",
                        "decompressArchiveFileTimeout",
                        "dependencyManagementSettings",
                        "dependencyFirewallPoliciesPerConfigurationLimit",
                        "dependencyScanningSbomScanApiUploadLimit",
                        "dependencyScanningSbomScanApiDownloadLimit",
                        "disableAdminOauthScopes",
                        "disableFeedToken",
                        "disablePasswordAuthenticationForUsersWithSsoIdentities",
                        "disablePersonalAccessTokens",
                        "disableOverridingApproversPerMergeRequest",
                        "disableInviteMembers",
                        "disabledOauthSignInSources",
                        "disabledDirectCodeSuggestions",
                        "discussionsResolveLimit",
                        "draftNotesCreateLimit",
                        "domainDenylistEnabled",
                        "domainDenylist",
                        "domainAllowlist",
                        "domainDenylistRaw",
                        "domainAllowlistRaw",
                        "outboundLocalRequestsWhitelist",
                        "outboundLocalRequestsAllowlistRaw",
                        "emailOtpEnabled",
                        "emailAuthorInBody",
                        "emailConfirmationSetting",
                        "emailRestrictions",
                        "emailRestrictionsEnabled",
                        "emailAdditionalText",
                        "environmentDeleteRowsLimitPerUser",
                        "iframeRenderingEnabled",
                        "iframeRenderingAllowlist",
                        "iframeRenderingAllowlistRaw",
                        "eksIntegrationEnabled",
                        "eksAccountId",
                        "eksAccessKeyId",
                        "eksSecretAccessKey",
                        "enabledGitAccessProtocol",
                        "enabledExpandedLogging",
                        "gitpodEnabled",
                        "gitpodUrl",
                        "gitalyTimeoutDefault",
                        "gitalyTimeoutFast",
                        "gitalyTimeoutMedium",
                        "grafanaEnabled",
                        "grafanaUrl",
                        "gravatarEnabled",
                        "helpPageHideCommercialContent",
                        "helpPageSupportUrl",
                        "helpPageDocumentationBaseUrl",
                        "helpPageText",
                        "homePageUrl",
                        "housekeepingEnabled",
                        "housekeepingFullRepackPeriod",
                        "housekeepingGcPeriod",
                        "housekeepingIncrementalRepackPeriod",
                        "housekeepingOptimizeRepositoryPeriod",
                        "htmlEmailsEnabled",
                        "importSources",
                        "importJobsConcurrencyLimit",
                        "invisibleCaptchaEnabled",
                        "mergeRequestsCreateLimit",
                        "mergeRequestsRebaseLimit",
                        "metricsMethodCallThreshold",
                        "o11yProvisionerApiKey",
                        "o11yProvisionerUrl",
                        "passwordAuthenticationEnabled",
                        "passwordAuthenticationEnabledForWeb",
                        "passwordAuthenticationEnabledForGit",
                        "passwordLowercaseRequired",
                        "passwordNumberRequired",
                        "passwordSymbolRequired",
                        "passwordUppercaseRequired",
                        "signinEnabled",
                        "performanceBarAllowedGroupId",
                        "performanceBarAllowedGroupPath",
                        "performanceBarEnabled",
                        "personalAccessTokenPrefix",
                        "requirePersonalAccessTokenExpiry",
                        "requireTwoFactorAuthentication",
                        "requireAdminApprovalAfterUserSignup",
                        "requireAdminTwoFactorAuthentication",
                        "requireEmailVerificationOnAccountLocked",
                        "requireShaForMerge",
                        "krokiEnabled",
                        "krokiUrl",
                        "krokiDiagramProxyEnabled",
                        "krokiFormats",
                        "plantumlEnabled",
                        "plantumlUrl",
                        "plantumlDiagramProxyEnabled",
                        "diagramsnetEnabled",
                        "diagramsnetUrl",
                        "pollingIntervalMultiplier",
                        "prometheusMetricsEnabled",
                        "pushEventHooksLimit",
                        "pushEventActivitiesLimit",
                        "recaptchaEnabled",
                        "recaptchaSiteKey",
                        "recaptchaPrivateKey",
                        "loginRecaptchaProtectionEnabled",
                        "repositoryChecksEnabled",
                        "repositoryStoragesWeighted",
                        "repositorySizeLimit",
                        "twoFactorGracePeriod",
                        "restrictedVisibilityLevels",
                        "sessionExpireDelay",
                        "sessionExpireFromInit",
                        "sharedRunnersEnabled",
                        "sharedRunnersText",
                        "sharedRunnersMinutes",
                        "validRunnerRegistrars",
                        "signupEnabled",
                        "sourcegraphEnabled",
                        "sourcegraphPublicOnly",
                        "sourcegraphUrl",
                        "spamCheckEndpointEnabled",
                        "spamCheckEndpointUrl",
                        "spamCheckApiKey",
                        "terminalMaxSessionTime",
                        "usagePingEnabled",
                        "usagePingGenerationEnabled",
                        "usagePingFeaturesEnabled",
                        "localMarkdownVersion",
                        "mailgunEventsEnabled",
                        "mailgunSigningKey",
                        "snowplowEnabled",
                        "snowplowCollectorHostname",
                        "snowplowCookieDomain",
                        "snowplowAppId",
                        "snowplowDatabaseCollectorHostname");
    }
}

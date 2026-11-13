package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdateOtherFurtherTest {

    @Test
    void constructor_shouldAcceptNull_whenRelationExportBatchSizeIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .relationExportBatchSize(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.relationExportBatchSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRememberMeEnabledIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .rememberMeEnabled(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.rememberMeEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchRateLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .searchRateLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.searchRateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchRateLimitUnauthenticatedIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .searchRateLimitUnauthenticated(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.searchRateLimitUnauthenticated()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchRateLimitAllowlistRawIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .searchRateLimitAllowlistRaw(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.searchRateLimitAllowlistRaw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSidekiqJobLimiterCompressionThresholdBytesIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .sidekiqJobLimiterCompressionThresholdBytes(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.sidekiqJobLimiterCompressionThresholdBytes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSidekiqJobLimiterLimitBytesIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .sidekiqJobLimiterLimitBytes(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.sidekiqJobLimiterLimitBytes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSidekiqJobLimiterModeIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .sidekiqJobLimiterMode(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.sidekiqJobLimiterMode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSidekiqTimezoneOverrideIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .sidekiqTimezoneOverride(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.sidekiqTimezoneOverride()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSignInRestrictionsIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .signInRestrictions(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.signInRestrictions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSilentAdminExportsEnabledIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .silentAdminExportsEnabled(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.silentAdminExportsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSilentModeEnabledIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .silentModeEnabled(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.silentModeEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetSizeLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .snippetSizeLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.snippetSizeLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStaticObjectsExternalStorageAuthTokenIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .staticObjectsExternalStorageAuthToken(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.staticObjectsExternalStorageAuthToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStaticObjectsExternalStorageUrlIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .staticObjectsExternalStorageUrl(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.staticObjectsExternalStorageUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSystemHooksCreateLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .systemHooksCreateLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.systemHooksCreateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTermsIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .terms(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.terms()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTimeTrackingLimitToHoursIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .timeTrackingLimitToHours(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.timeTrackingLimitToHours()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTopLevelGroupCreationEnabledIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .topLevelGroupCreationEnabled(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.topLevelGroupCreationEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUniqueIpsLimitEnabledIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .uniqueIpsLimitEnabled(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.uniqueIpsLimitEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUniqueIpsLimitPerUserIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .uniqueIpsLimitPerUser(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.uniqueIpsLimitPerUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUniqueIpsLimitTimeWindowIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .uniqueIpsLimitTimeWindow(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.uniqueIpsLimitTimeWindow()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdateRunnerVersionsEnabledIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .updateRunnerVersionsEnabled(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.updateRunnerVersionsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseClickhouseForAnalyticsIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .useClickhouseForAnalytics(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.useClickhouseForAnalytics()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseNatsForAuditStreamingIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .useNatsForAuditStreaming(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.useNatsForAuditStreaming()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionCheckEnabledIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .versionCheckEnabled(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.versionCheckEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebHookEventResendLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .webHookEventResendLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.webHookEventResendLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebHookTestLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .webHookTestLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.webHookTestLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveContextPauseIndexingIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .activeContextPauseIndexing(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.activeContextPauseIndexing()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecretDetectionTokenRevocationEnabledIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .secretDetectionTokenRevocationEnabled(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.secretDetectionTokenRevocationEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecretDetectionTokenRevocationUrlIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .secretDetectionTokenRevocationUrl(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.secretDetectionTokenRevocationUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecretDetectionRevocationTokenTypesUrlIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .secretDetectionRevocationTokenTypesUrl(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.secretDetectionRevocationTokenTypesUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecretPushProtectionAvailableIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .secretPushProtectionAvailable(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.secretPushProtectionAvailable()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecretDetectionTokenRevocationTokenIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .secretDetectionTokenRevocationToken(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.secretDetectionTokenRevocationToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecretDetectionServiceAuthTokenIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .secretDetectionServiceAuthToken(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.secretDetectionServiceAuthToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecretDetectionServiceUrlIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .secretDetectionServiceUrl(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.secretDetectionServiceUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFileTemplateProjectIdIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .fileTemplateProjectId(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.fileTemplateProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatingNameDisabledForUsersIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .updatingNameDisabledForUsers(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.updatingNameDisabledForUsers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreventMergeRequestsAuthorApprovalIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .preventMergeRequestsAuthorApproval(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.preventMergeRequestsAuthorApproval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreventMergeRequestsCommittersApprovalIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .preventMergeRequestsCommittersApproval(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.preventMergeRequestsCommittersApproval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMavenPackageRequestsForwardingIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .mavenPackageRequestsForwarding(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.mavenPackageRequestsForwarding()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNpmPackageRequestsForwardingIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .npmPackageRequestsForwarding(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.npmPackageRequestsForwarding()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPypiPackageRequestsForwardingIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .pypiPackageRequestsForwarding(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.pypiPackageRequestsForwarding()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRubygemsPackageRequestsForwardingIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .rubygemsPackageRequestsForwarding(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.rubygemsPackageRequestsForwarding()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVirtualRegistriesEndpointsApiLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .virtualRegistriesEndpointsApiLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.virtualRegistriesEndpointsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuditEventsApiLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .auditEventsApiLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.auditEventsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInsightsQueryLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .insightsQueryLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.insightsQueryLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrbitQueryLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .orbitQueryLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.orbitQueryLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrbitIndexingStatusLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .orbitIndexingStatusLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.orbitIndexingStatusLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrbitItemCountsLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .orbitItemCountsLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.orbitItemCountsLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrbitRateLimitAllowlistRawIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .orbitRateLimitAllowlistRaw(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.orbitRateLimitAllowlistRaw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrbitAutoIndexRootNamespaceIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .orbitAutoIndexRootNamespace(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.orbitAutoIndexRootNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrbitDapEnabledByDefaultIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .orbitDapEnabledByDefault(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.orbitDapEnabledByDefault()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubscriptionUsagePerMinuteLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .subscriptionUsagePerMinuteLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.subscriptionUsagePerMinuteLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubscriptionUsagePerHourLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .subscriptionUsagePerHourLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.subscriptionUsagePerHourLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubscriptionUsagePerDayLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .subscriptionUsagePerDayLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.subscriptionUsagePerDayLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBudgetCapUpdatePerMinuteLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .budgetCapUpdatePerMinuteLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.budgetCapUpdatePerMinuteLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBudgetCapUpdatePerHourLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .budgetCapUpdatePerHourLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.budgetCapUpdatePerHourLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBudgetCapUpdatePerDayLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .budgetCapUpdatePerDayLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.budgetCapUpdatePerDayLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaintenanceModeIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .maintenanceMode(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.maintenanceMode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaintenanceModeMessageIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .maintenanceModeMessage(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.maintenanceModeMessage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMakeProfilePrivateIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .makeProfilePrivate(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.makeProfilePrivate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceAccessTokensExpirationEnforcedIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .serviceAccessTokensExpirationEnforced(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.serviceAccessTokensExpirationEnforced()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReceptiveClusterAgentsEnabledIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .receptiveClusterAgentsEnabled(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.receptiveClusterAgentsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuiltInProjectTemplatesEnabledIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .builtInProjectTemplatesEnabled(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.builtInProjectTemplatesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowedIntegrationsIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .allowedIntegrations(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.allowedIntegrations()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutomaticPurchasedStorageAllocationIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .automaticPurchasedStorageAllocation(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.automaticPurchasedStorageAllocation()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCheckNamespacePlanIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .checkNamespacePlan(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.checkNamespacePlan()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGeoNodeAllowedIpsIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .geoNodeAllowedIps(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.geoNodeAllowedIps()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGeoStatusTimeoutIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .geoStatusTimeout(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.geoStatusTimeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGloballyAllowedIpsIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .globallyAllowedIps(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.globallyAllowedIps()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScanExecutionPoliciesActionLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .scanExecutionPoliciesActionLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.scanExecutionPoliciesActionLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScanExecutionPoliciesScheduleLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .scanExecutionPoliciesScheduleLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.scanExecutionPoliciesScheduleLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScanExecutionPoliciesPerConfigurationLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .scanExecutionPoliciesPerConfigurationLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.scanExecutionPoliciesPerConfigurationLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUnconfirmedUsersDeleteAfterDaysIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .unconfirmedUsersDeleteAfterDays(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.unconfirmedUsersDeleteAfterDays()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDenyAllRequestsExceptAllowedIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .denyAllRequestsExceptAllowed(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.denyAllRequestsExceptAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBlockJwtForReclaimedPathsIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .blockJwtForReclaimedPaths(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.blockJwtForReclaimedPaths()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRootMovedPermanentlyRedirectionIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .rootMovedPermanentlyRedirection(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.rootMovedPermanentlyRedirection()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenErrorTrackingEnabledIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .errorTrackingEnabled(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.errorTrackingEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenErrorTrackingApiUrlIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .errorTrackingApiUrl(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.errorTrackingApiUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenForcePagesAccessControlIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .forcePagesAccessControl(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.forcePagesAccessControl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMathRenderingLimitsEnabledIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .mathRenderingLimitsEnabled(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.mathRenderingLimitsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationClusterAgentAuthorizationEnabledIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .organizationClusterAgentAuthorizationEnabled(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.organizationClusterAgentAuthorizationEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInstanceTokenPrefixIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .instanceTokenPrefix(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.instanceTokenPrefix()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInstanceLevelAiBetaFeaturesEnabledIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .instanceLevelAiBetaFeaturesEnabled(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.instanceLevelAiBetaFeaturesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotesCreateLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .notesCreateLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.notesCreateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotesCreateLimitAllowlistRawIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .notesCreateLimitAllowlistRaw(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.notesCreateLimitAllowlistRaw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMembersDeleteLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .membersDeleteLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.membersDeleteLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneDestroyLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .milestoneDestroyLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.milestoneDestroyLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSentryEnabledIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .sentryEnabled(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.sentryEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSentryDsnIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .sentryDsn(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.sentryDsn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSentryClientsideDsnIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .sentryClientsideDsn(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.sentryClientsideDsn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSentryEnvironmentIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .sentryEnvironment(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.sentryEnvironment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSentryClientsideTracesSampleRateIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .sentryClientsideTracesSampleRate(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.sentryClientsideTracesSampleRate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInvitationFlowEnforcementIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .invitationFlowEnforcement(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.invitationFlowEnforcement()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeactivationEmailAdditionalTextIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .deactivationEmailAdditionalText(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.deactivationEmailAdditionalText()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlqlDbSecondsPerIpLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .glqlDbSecondsPerIpLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.glqlDbSecondsPerIpLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlqlDbSecondsPerQueryLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .glqlDbSecondsPerQueryLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.glqlDbSecondsPerQueryLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlqlDbSecondsPerUserLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .glqlDbSecondsPerUserLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.glqlDbSecondsPerUserLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlqlDuoDbSecondsPerUserLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .glqlDuoDbSecondsPerUserLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.glqlDuoDbSecondsPerUserLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupsApiLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .groupsApiLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.groupsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuableCsvImportLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .issuableCsvImportLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.issuableCsvImportLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelDeleteLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .labelDeleteLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.labelDeleteLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreateOrganizationApiLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .createOrganizationApiLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.createOrganizationApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCrossReferenceChecksLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .crossReferenceChecksLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.crossReferenceChecksLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagsCreateLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .tagsCreateLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.tagsCreateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTodosListApiLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .todosListApiLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.todosListApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemHierarchyAddChildrenLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .workItemHierarchyAddChildrenLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.workItemHierarchyAddChildrenLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemMoveLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .workItemMoveLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.workItemMoveLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemUpdateLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .workItemUpdateLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.workItemUpdateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenObservabilityBackendSslVerificationEnabledIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .observabilityBackendSslVerificationEnabled(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.observabilityBackendSslVerificationEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReindexingMinimumIndexSizeIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .reindexingMinimumIndexSize(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.reindexingMinimumIndexSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReindexingMinimumRelativeBloatSizeIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .reindexingMinimumRelativeBloatSize(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.reindexingMinimumRelativeBloatSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAnonymousSearchesAllowedIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .anonymousSearchesAllowed(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.anonymousSearchesAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDelayUserAccountSelfDeletionIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .delayUserAccountSelfDeletion(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.delayUserAccountSelfDeletion()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBackgroundOperationsMaxJobsIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .backgroundOperationsMaxJobs(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.backgroundOperationsMaxJobs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPgAshSamplingEnabledIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .pgAshSamplingEnabled(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.pgAshSamplingEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPgAshSampleIntervalSecondsIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .pgAshSampleIntervalSeconds(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.pgAshSampleIntervalSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGranularTokensEnforcedAfterIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .granularTokensEnforcedAfter(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.granularTokensEnforcedAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeactivateDormantUsersIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .deactivateDormantUsers(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.deactivateDormantUsers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeactivateDormantUsersPeriodIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .deactivateDormantUsersPeriod(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.deactivateDormantUsersPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNugetSkipMetadataUrlValidationIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .nugetSkipMetadataUrlValidation(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.nugetSkipMetadataUrlValidation()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHelmMaxPackagesCountIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .helmMaxPackagesCount(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.helmMaxPackagesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMcpServerEnabledIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .mcpServerEnabled(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.mcpServerEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDynamicClientRegistrationEnabledIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .dynamicClientRegistrationEnabled(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.dynamicClientRegistrationEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenModelPromptCacheEnabledIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .modelPromptCacheEnabled(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.modelPromptCacheEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProductAnalyticsEnabledIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .productAnalyticsEnabled(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.productAnalyticsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProductAnalyticsDataCollectorHostIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .productAnalyticsDataCollectorHost(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.productAnalyticsDataCollectorHost()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProductAnalyticsConfiguratorConnectionStringIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .productAnalyticsConfiguratorConnectionString(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.productAnalyticsConfiguratorConnectionString()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCubeApiBaseUrlIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .cubeApiBaseUrl(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.cubeApiBaseUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCubeApiKeyIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .cubeApiKey(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.cubeApiKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenToolApprovalForSessionEnabledIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .toolApprovalForSessionEnabled(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.toolApprovalForSessionEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenToolApprovalForSessionAvailabilityIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .toolApprovalForSessionAvailability(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.toolApprovalForSessionAvailability()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFoundationalAgentsDefaultEnabledIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .foundationalAgentsDefaultEnabled(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.foundationalAgentsDefaultEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFoundationalAgentsStatusesIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .foundationalAgentsStatuses(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.foundationalAgentsStatuses()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEpicMoveListLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .epicMoveListLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.epicMoveListLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityManagementPoliciesPerConfigurationLimitIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .vulnerabilityManagementPoliciesPerConfigurationLimit(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.vulnerabilityManagementPoliciesPerConfigurationLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPolicyStoreExperimentEnabledIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .policyStoreExperimentEnabled(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.policyStoreExperimentEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFetchObservabilityAlertsFromCloudIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .fetchObservabilityAlertsFromCloud(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.fetchObservabilityAlertsFromCloud()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticMigrationWorkerEnabledIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .elasticMigrationWorkerEnabled(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.elasticMigrationWorkerEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDisplayGitlabCreditsUserDataIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .displayGitlabCreditsUserData(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.displayGitlabCreditsUserData()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVacProjectIdsRawIsNullable() {
        final GitLabSettingsUpdateOtherFurtherBuilder builder = GitLabSettingsUpdateOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherFurther())
                .vacProjectIdsRaw(null);

        final GitLabSettingsUpdateOtherFurther built = builder.build();

        assertThat(built.vacProjectIdsRaw()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdateOtherFurther value = SettingsCatalogFixtures.settingsUpdateOtherFurther();

        assertSoftly(softly -> {
            softly.assertThat(value.relationExportBatchSize()).isEqualTo("relation_export_batch_size");
            softly.assertThat(value.rememberMeEnabled()).isEqualTo("remember_me_enabled");
            softly.assertThat(value.searchRateLimit()).isEqualTo("search_rate_limit");
            softly.assertThat(value.searchRateLimitUnauthenticated()).isEqualTo("search_rate_limit_unauthenticated");
            softly.assertThat(value.searchRateLimitAllowlistRaw()).isEqualTo("search_rate_limit_allowlist_raw");
            softly.assertThat(value.sidekiqJobLimiterCompressionThresholdBytes())
                    .isEqualTo("sidekiq_job_limiter_compression_threshold_bytes");
            softly.assertThat(value.sidekiqJobLimiterLimitBytes()).isEqualTo("sidekiq_job_limiter_limit_bytes");
            softly.assertThat(value.sidekiqJobLimiterMode()).isEqualTo(GitLabSettingsUpdateSidekiqJobLimiterMode.TRACK);
            softly.assertThat(value.sidekiqTimezoneOverride()).isEqualTo("sidekiq_timezone_override");
            softly.assertThat(value.signInRestrictions()).isEqualTo("sign_in_restrictions");
            softly.assertThat(value.silentAdminExportsEnabled()).isEqualTo("silent_admin_exports_enabled");
            softly.assertThat(value.silentModeEnabled()).isEqualTo("silent_mode_enabled");
            softly.assertThat(value.snippetSizeLimit()).isEqualTo("snippet_size_limit");
            softly.assertThat(value.staticObjectsExternalStorageAuthToken())
                    .isEqualTo("static_objects_external_storage_auth_token");
            softly.assertThat(value.staticObjectsExternalStorageUrl()).isEqualTo("static_objects_external_storage_url");
            softly.assertThat(value.systemHooksCreateLimit()).isEqualTo("system_hooks_create_limit");
            softly.assertThat(value.terms()).isEqualTo("terms");
            softly.assertThat(value.timeTrackingLimitToHours()).isEqualTo("time_tracking_limit_to_hours");
            softly.assertThat(value.topLevelGroupCreationEnabled()).isEqualTo("top_level_group_creation_enabled");
            softly.assertThat(value.uniqueIpsLimitEnabled()).isEqualTo("unique_ips_limit_enabled");
            softly.assertThat(value.uniqueIpsLimitPerUser()).isEqualTo("unique_ips_limit_per_user");
            softly.assertThat(value.uniqueIpsLimitTimeWindow()).isEqualTo("unique_ips_limit_time_window");
            softly.assertThat(value.updateRunnerVersionsEnabled()).isEqualTo("update_runner_versions_enabled");
            softly.assertThat(value.useClickhouseForAnalytics()).isEqualTo("use_clickhouse_for_analytics");
            softly.assertThat(value.useNatsForAuditStreaming()).isEqualTo(true);
            softly.assertThat(value.versionCheckEnabled()).isEqualTo("version_check_enabled");
            softly.assertThat(value.webHookEventResendLimit()).isEqualTo("web_hook_event_resend_limit");
            softly.assertThat(value.webHookTestLimit()).isEqualTo("web_hook_test_limit");
            softly.assertThat(value.activeContextPauseIndexing()).isEqualTo(true);
            softly.assertThat(value.secretDetectionTokenRevocationEnabled()).isEqualTo(true);
            softly.assertThat(value.secretDetectionTokenRevocationUrl())
                    .isEqualTo("secret_detection_token_revocation_url");
            softly.assertThat(value.secretDetectionRevocationTokenTypesUrl())
                    .isEqualTo("secret_detection_revocation_token_types_url");
            softly.assertThat(value.secretPushProtectionAvailable()).isEqualTo("secret_push_protection_available");
            softly.assertThat(value.secretDetectionTokenRevocationToken())
                    .isEqualTo("secret_detection_token_revocation_token");
            softly.assertThat(value.secretDetectionServiceAuthToken()).isEqualTo("secret_detection_service_auth_token");
            softly.assertThat(value.secretDetectionServiceUrl()).isEqualTo("secret_detection_service_url");
            softly.assertThat(value.fileTemplateProjectId()).isEqualTo(1L);
            softly.assertThat(value.updatingNameDisabledForUsers()).isEqualTo(true);
            softly.assertThat(value.preventMergeRequestsAuthorApproval()).isEqualTo(true);
            softly.assertThat(value.preventMergeRequestsCommittersApproval()).isEqualTo(true);
            softly.assertThat(value.mavenPackageRequestsForwarding()).isEqualTo(true);
            softly.assertThat(value.npmPackageRequestsForwarding()).isEqualTo(true);
            softly.assertThat(value.pypiPackageRequestsForwarding()).isEqualTo(true);
            softly.assertThat(value.rubygemsPackageRequestsForwarding()).isEqualTo(true);
            softly.assertThat(value.virtualRegistriesEndpointsApiLimit()).isEqualTo(1);
            softly.assertThat(value.auditEventsApiLimit()).isEqualTo(1);
            softly.assertThat(value.insightsQueryLimit()).isEqualTo(1);
            softly.assertThat(value.orbitQueryLimit()).isEqualTo(1);
            softly.assertThat(value.orbitIndexingStatusLimit()).isEqualTo(1);
            softly.assertThat(value.orbitItemCountsLimit()).isEqualTo(1);
            softly.assertThat(value.orbitRateLimitAllowlistRaw()).isEqualTo("orbit_rate_limit_allowlist_raw");
            softly.assertThat(value.orbitAutoIndexRootNamespace()).isEqualTo("orbit_auto_index_root_namespace");
            softly.assertThat(value.orbitDapEnabledByDefault()).isEqualTo("orbit_dap_enabled_by_default");
            softly.assertThat(value.subscriptionUsagePerMinuteLimit()).isEqualTo(1);
            softly.assertThat(value.subscriptionUsagePerHourLimit()).isEqualTo(1);
            softly.assertThat(value.subscriptionUsagePerDayLimit()).isEqualTo(1);
            softly.assertThat(value.budgetCapUpdatePerMinuteLimit()).isEqualTo(1);
            softly.assertThat(value.budgetCapUpdatePerHourLimit()).isEqualTo(1);
            softly.assertThat(value.budgetCapUpdatePerDayLimit()).isEqualTo(1);
            softly.assertThat(value.maintenanceMode()).isEqualTo(true);
            softly.assertThat(value.maintenanceModeMessage()).isEqualTo("maintenance_mode_message");
            softly.assertThat(value.makeProfilePrivate()).isEqualTo(true);
            softly.assertThat(value.serviceAccessTokensExpirationEnforced()).isEqualTo(true);
            softly.assertThat(value.receptiveClusterAgentsEnabled()).isEqualTo(true);
            softly.assertThat(value.builtInProjectTemplatesEnabled()).isEqualTo(true);
            softly.assertThat(value.allowedIntegrations()).isEqualTo("allowed_integrations");
            softly.assertThat(value.automaticPurchasedStorageAllocation())
                    .isEqualTo("automatic_purchased_storage_allocation");
            softly.assertThat(value.checkNamespacePlan()).isEqualTo("check_namespace_plan");
            softly.assertThat(value.geoNodeAllowedIps()).isEqualTo("geo_node_allowed_ips");
            softly.assertThat(value.geoStatusTimeout()).isEqualTo("geo_status_timeout");
            softly.assertThat(value.globallyAllowedIps()).isEqualTo("globally_allowed_ips");
            softly.assertThat(value.scanExecutionPoliciesActionLimit())
                    .isEqualTo("scan_execution_policies_action_limit");
            softly.assertThat(value.scanExecutionPoliciesScheduleLimit())
                    .isEqualTo("scan_execution_policies_schedule_limit");
            softly.assertThat(value.scanExecutionPoliciesPerConfigurationLimit())
                    .isEqualTo("scan_execution_policies_per_configuration_limit");
            softly.assertThat(value.unconfirmedUsersDeleteAfterDays()).isEqualTo("unconfirmed_users_delete_after_days");
            softly.assertThat(value.denyAllRequestsExceptAllowed()).isEqualTo("deny_all_requests_except_allowed");
            softly.assertThat(value.blockJwtForReclaimedPaths()).isEqualTo("block_jwt_for_reclaimed_paths");
            softly.assertThat(value.rootMovedPermanentlyRedirection()).isEqualTo("root_moved_permanently_redirection");
            softly.assertThat(value.errorTrackingEnabled()).isEqualTo("error_tracking_enabled");
            softly.assertThat(value.errorTrackingApiUrl()).isEqualTo("error_tracking_api_url");
            softly.assertThat(value.forcePagesAccessControl()).isEqualTo("force_pages_access_control");
            softly.assertThat(value.mathRenderingLimitsEnabled()).isEqualTo("math_rendering_limits_enabled");
            softly.assertThat(value.organizationClusterAgentAuthorizationEnabled())
                    .isEqualTo("organization_cluster_agent_authorization_enabled");
            softly.assertThat(value.instanceTokenPrefix()).isEqualTo("instance_token_prefix");
            softly.assertThat(value.instanceLevelAiBetaFeaturesEnabled())
                    .isEqualTo("instance_level_ai_beta_features_enabled");
            softly.assertThat(value.notesCreateLimit()).isEqualTo("notes_create_limit");
            softly.assertThat(value.notesCreateLimitAllowlistRaw()).isEqualTo("notes_create_limit_allowlist_raw");
            softly.assertThat(value.membersDeleteLimit()).isEqualTo("members_delete_limit");
            softly.assertThat(value.milestoneDestroyLimit()).isEqualTo("milestone_destroy_limit");
            softly.assertThat(value.sentryEnabled()).isEqualTo("sentry_enabled");
            softly.assertThat(value.sentryDsn()).isEqualTo("sentry_dsn");
            softly.assertThat(value.sentryClientsideDsn()).isEqualTo("sentry_clientside_dsn");
            softly.assertThat(value.sentryEnvironment()).isEqualTo("sentry_environment");
            softly.assertThat(value.sentryClientsideTracesSampleRate())
                    .isEqualTo("sentry_clientside_traces_sample_rate");
            softly.assertThat(value.invitationFlowEnforcement()).isEqualTo("invitation_flow_enforcement");
            softly.assertThat(value.deactivationEmailAdditionalText()).isEqualTo("deactivation_email_additional_text");
            softly.assertThat(value.glqlDbSecondsPerIpLimit()).isEqualTo("glql_db_seconds_per_ip_limit");
            softly.assertThat(value.glqlDbSecondsPerQueryLimit()).isEqualTo("glql_db_seconds_per_query_limit");
            softly.assertThat(value.glqlDbSecondsPerUserLimit()).isEqualTo("glql_db_seconds_per_user_limit");
            softly.assertThat(value.glqlDuoDbSecondsPerUserLimit()).isEqualTo("glql_duo_db_seconds_per_user_limit");
            softly.assertThat(value.groupsApiLimit()).isEqualTo("groups_api_limit");
            softly.assertThat(value.issuableCsvImportLimit()).isEqualTo("issuable_csv_import_limit");
            softly.assertThat(value.labelDeleteLimit()).isEqualTo("label_delete_limit");
            softly.assertThat(value.createOrganizationApiLimit()).isEqualTo("create_organization_api_limit");
            softly.assertThat(value.crossReferenceChecksLimit()).isEqualTo("cross_reference_checks_limit");
            softly.assertThat(value.tagsCreateLimit()).isEqualTo("tags_create_limit");
            softly.assertThat(value.todosListApiLimit()).isEqualTo("todos_list_api_limit");
            softly.assertThat(value.workItemHierarchyAddChildrenLimit())
                    .isEqualTo("work_item_hierarchy_add_children_limit");
            softly.assertThat(value.workItemMoveLimit()).isEqualTo("work_item_move_limit");
            softly.assertThat(value.workItemUpdateLimit()).isEqualTo("work_item_update_limit");
            softly.assertThat(value.observabilityBackendSslVerificationEnabled())
                    .isEqualTo("observability_backend_ssl_verification_enabled");
            softly.assertThat(value.reindexingMinimumIndexSize()).isEqualTo("reindexing_minimum_index_size");
            softly.assertThat(value.reindexingMinimumRelativeBloatSize())
                    .isEqualTo("reindexing_minimum_relative_bloat_size");
            softly.assertThat(value.anonymousSearchesAllowed()).isEqualTo("anonymous_searches_allowed");
            softly.assertThat(value.delayUserAccountSelfDeletion()).isEqualTo("delay_user_account_self_deletion");
            softly.assertThat(value.backgroundOperationsMaxJobs()).isEqualTo("background_operations_max_jobs");
            softly.assertThat(value.pgAshSamplingEnabled()).isEqualTo("pg_ash_sampling_enabled");
            softly.assertThat(value.pgAshSampleIntervalSeconds()).isEqualTo("pg_ash_sample_interval_seconds");
            softly.assertThat(value.granularTokensEnforcedAfter()).isEqualTo("granular_tokens_enforced_after");
            softly.assertThat(value.deactivateDormantUsers()).isEqualTo("deactivate_dormant_users");
            softly.assertThat(value.deactivateDormantUsersPeriod()).isEqualTo("deactivate_dormant_users_period");
            softly.assertThat(value.nugetSkipMetadataUrlValidation()).isEqualTo("nuget_skip_metadata_url_validation");
            softly.assertThat(value.helmMaxPackagesCount()).isEqualTo("helm_max_packages_count");
            softly.assertThat(value.mcpServerEnabled()).isEqualTo("mcp_server_enabled");
            softly.assertThat(value.dynamicClientRegistrationEnabled())
                    .isEqualTo("dynamic_client_registration_enabled");
            softly.assertThat(value.modelPromptCacheEnabled()).isEqualTo("model_prompt_cache_enabled");
            softly.assertThat(value.productAnalyticsEnabled()).isEqualTo("product_analytics_enabled");
            softly.assertThat(value.productAnalyticsDataCollectorHost())
                    .isEqualTo("product_analytics_data_collector_host");
            softly.assertThat(value.productAnalyticsConfiguratorConnectionString())
                    .isEqualTo("product_analytics_configurator_connection_string");
            softly.assertThat(value.cubeApiBaseUrl()).isEqualTo("cube_api_base_url");
            softly.assertThat(value.cubeApiKey()).isEqualTo("cube_api_key");
            softly.assertThat(value.toolApprovalForSessionEnabled()).isEqualTo("tool_approval_for_session_enabled");
            softly.assertThat(value.toolApprovalForSessionAvailability())
                    .isEqualTo("tool_approval_for_session_availability");
            softly.assertThat(value.foundationalAgentsDefaultEnabled())
                    .isEqualTo("foundational_agents_default_enabled");
            softly.assertThat(value.foundationalAgentsStatuses()).isEqualTo("foundational_agents_statuses");
            softly.assertThat(value.epicMoveListLimit()).isEqualTo("epic_move_list_limit");
            softly.assertThat(value.vulnerabilityManagementPoliciesPerConfigurationLimit())
                    .isEqualTo("vulnerability_management_policies_per_configuration_limit");
            softly.assertThat(value.policyStoreExperimentEnabled()).isEqualTo("policy_store_experiment_enabled");
            softly.assertThat(value.fetchObservabilityAlertsFromCloud())
                    .isEqualTo("fetch_observability_alerts_from_cloud");
            softly.assertThat(value.elasticMigrationWorkerEnabled()).isEqualTo("elastic_migration_worker_enabled");
            softly.assertThat(value.displayGitlabCreditsUserData()).isEqualTo("display_gitlab_credits_user_data");
            softly.assertThat(value.vacProjectIdsRaw()).isEqualTo("vac_project_ids_raw");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSettingsUpdateOtherFurther original = SettingsCatalogFixtures.settingsUpdateOtherFurther();

        final GitLabSettingsUpdateOtherFurther rebuilt =
                GitLabSettingsUpdateOtherFurtherBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenStaticObjectsExternalStorageAuthTokenIsACredential() {
        final GitLabSettingsUpdateOtherFurther value = SettingsCatalogFixtures.settingsUpdateOtherFurther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenSecretPushProtectionAvailableIsACredential() {
        final GitLabSettingsUpdateOtherFurther value = SettingsCatalogFixtures.settingsUpdateOtherFurther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenSecretDetectionTokenRevocationTokenIsACredential() {
        final GitLabSettingsUpdateOtherFurther value = SettingsCatalogFixtures.settingsUpdateOtherFurther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenSecretDetectionServiceAuthTokenIsACredential() {
        final GitLabSettingsUpdateOtherFurther value = SettingsCatalogFixtures.settingsUpdateOtherFurther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenInstanceTokenPrefixIsACredential() {
        final GitLabSettingsUpdateOtherFurther value = SettingsCatalogFixtures.settingsUpdateOtherFurther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenGranularTokensEnforcedAfterIsACredential() {
        final GitLabSettingsUpdateOtherFurther value = SettingsCatalogFixtures.settingsUpdateOtherFurther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSettingsUpdateOtherFurther.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "relationExportBatchSize",
                        "rememberMeEnabled",
                        "searchRateLimit",
                        "searchRateLimitUnauthenticated",
                        "searchRateLimitAllowlistRaw",
                        "sidekiqJobLimiterCompressionThresholdBytes",
                        "sidekiqJobLimiterLimitBytes",
                        "sidekiqJobLimiterMode",
                        "sidekiqTimezoneOverride",
                        "signInRestrictions",
                        "silentAdminExportsEnabled",
                        "silentModeEnabled",
                        "snippetSizeLimit",
                        "staticObjectsExternalStorageAuthToken",
                        "staticObjectsExternalStorageUrl",
                        "systemHooksCreateLimit",
                        "terms",
                        "timeTrackingLimitToHours",
                        "topLevelGroupCreationEnabled",
                        "uniqueIpsLimitEnabled",
                        "uniqueIpsLimitPerUser",
                        "uniqueIpsLimitTimeWindow",
                        "updateRunnerVersionsEnabled",
                        "useClickhouseForAnalytics",
                        "useNatsForAuditStreaming",
                        "versionCheckEnabled",
                        "webHookEventResendLimit",
                        "webHookTestLimit",
                        "activeContextPauseIndexing",
                        "secretDetectionTokenRevocationEnabled",
                        "secretDetectionTokenRevocationUrl",
                        "secretDetectionRevocationTokenTypesUrl",
                        "secretPushProtectionAvailable",
                        "secretDetectionTokenRevocationToken",
                        "secretDetectionServiceAuthToken",
                        "secretDetectionServiceUrl",
                        "fileTemplateProjectId",
                        "updatingNameDisabledForUsers",
                        "preventMergeRequestsAuthorApproval",
                        "preventMergeRequestsCommittersApproval",
                        "mavenPackageRequestsForwarding",
                        "npmPackageRequestsForwarding",
                        "pypiPackageRequestsForwarding",
                        "rubygemsPackageRequestsForwarding",
                        "virtualRegistriesEndpointsApiLimit",
                        "auditEventsApiLimit",
                        "insightsQueryLimit",
                        "orbitQueryLimit",
                        "orbitIndexingStatusLimit",
                        "orbitItemCountsLimit",
                        "orbitRateLimitAllowlistRaw",
                        "orbitAutoIndexRootNamespace",
                        "orbitDapEnabledByDefault",
                        "subscriptionUsagePerMinuteLimit",
                        "subscriptionUsagePerHourLimit",
                        "subscriptionUsagePerDayLimit",
                        "budgetCapUpdatePerMinuteLimit",
                        "budgetCapUpdatePerHourLimit",
                        "budgetCapUpdatePerDayLimit",
                        "maintenanceMode",
                        "maintenanceModeMessage",
                        "makeProfilePrivate",
                        "serviceAccessTokensExpirationEnforced",
                        "receptiveClusterAgentsEnabled",
                        "builtInProjectTemplatesEnabled",
                        "allowedIntegrations",
                        "automaticPurchasedStorageAllocation",
                        "checkNamespacePlan",
                        "geoNodeAllowedIps",
                        "geoStatusTimeout",
                        "globallyAllowedIps",
                        "scanExecutionPoliciesActionLimit",
                        "scanExecutionPoliciesScheduleLimit",
                        "scanExecutionPoliciesPerConfigurationLimit",
                        "unconfirmedUsersDeleteAfterDays",
                        "denyAllRequestsExceptAllowed",
                        "blockJwtForReclaimedPaths",
                        "rootMovedPermanentlyRedirection",
                        "errorTrackingEnabled",
                        "errorTrackingApiUrl",
                        "forcePagesAccessControl",
                        "mathRenderingLimitsEnabled",
                        "organizationClusterAgentAuthorizationEnabled",
                        "instanceTokenPrefix",
                        "instanceLevelAiBetaFeaturesEnabled",
                        "notesCreateLimit",
                        "notesCreateLimitAllowlistRaw",
                        "membersDeleteLimit",
                        "milestoneDestroyLimit",
                        "sentryEnabled",
                        "sentryDsn",
                        "sentryClientsideDsn",
                        "sentryEnvironment",
                        "sentryClientsideTracesSampleRate",
                        "invitationFlowEnforcement",
                        "deactivationEmailAdditionalText",
                        "glqlDbSecondsPerIpLimit",
                        "glqlDbSecondsPerQueryLimit",
                        "glqlDbSecondsPerUserLimit",
                        "glqlDuoDbSecondsPerUserLimit",
                        "groupsApiLimit",
                        "issuableCsvImportLimit",
                        "labelDeleteLimit",
                        "createOrganizationApiLimit",
                        "crossReferenceChecksLimit",
                        "tagsCreateLimit",
                        "todosListApiLimit",
                        "workItemHierarchyAddChildrenLimit",
                        "workItemMoveLimit",
                        "workItemUpdateLimit",
                        "observabilityBackendSslVerificationEnabled",
                        "reindexingMinimumIndexSize",
                        "reindexingMinimumRelativeBloatSize",
                        "anonymousSearchesAllowed",
                        "delayUserAccountSelfDeletion",
                        "backgroundOperationsMaxJobs",
                        "pgAshSamplingEnabled",
                        "pgAshSampleIntervalSeconds",
                        "granularTokensEnforcedAfter",
                        "deactivateDormantUsers",
                        "deactivateDormantUsersPeriod",
                        "nugetSkipMetadataUrlValidation",
                        "helmMaxPackagesCount",
                        "mcpServerEnabled",
                        "dynamicClientRegistrationEnabled",
                        "modelPromptCacheEnabled",
                        "productAnalyticsEnabled",
                        "productAnalyticsDataCollectorHost",
                        "productAnalyticsConfiguratorConnectionString",
                        "cubeApiBaseUrl",
                        "cubeApiKey",
                        "toolApprovalForSessionEnabled",
                        "toolApprovalForSessionAvailability",
                        "foundationalAgentsDefaultEnabled",
                        "foundationalAgentsStatuses",
                        "epicMoveListLimit",
                        "vulnerabilityManagementPoliciesPerConfigurationLimit",
                        "policyStoreExperimentEnabled",
                        "fetchObservabilityAlertsFromCloud",
                        "elasticMigrationWorkerEnabled",
                        "displayGitlabCreditsUserData",
                        "vacProjectIdsRaw");
    }
}

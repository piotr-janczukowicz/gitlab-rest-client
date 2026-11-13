package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdateThrottleTest {

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedApiEnabledIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedApiEnabled(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedApiEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedApiPeriodInSecondsIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedApiPeriodInSeconds(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedApiPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedApiRequestsPerPeriodIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedApiRequestsPerPeriod(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedApiRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedGitHttpEnabledIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedGitHttpEnabled(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedGitHttpEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedGitHttpPeriodInSecondsIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedGitHttpPeriodInSeconds(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedGitHttpPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedGitHttpRequestsPerPeriodIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedGitHttpRequestsPerPeriod(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedGitHttpRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedMcpEnabledIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedMcpEnabled(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedMcpEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedMcpPeriodInSecondsIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedMcpPeriodInSeconds(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedMcpPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedMcpRequestsPerPeriodIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedMcpRequestsPerPeriod(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedMcpRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedDependencyProxyEnabledIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedDependencyProxyEnabled(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedDependencyProxyEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedDependencyProxyPeriodInSecondsIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedDependencyProxyPeriodInSeconds(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedDependencyProxyPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedDependencyProxyRequestsPerPeriodIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedDependencyProxyRequestsPerPeriod(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedDependencyProxyRequestsPerPeriod())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedPackagesApiEnabledIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedPackagesApiEnabled(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedPackagesApiEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedPackagesApiPeriodInSecondsIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedPackagesApiPeriodInSeconds(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedPackagesApiPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedPackagesApiRequestsPerPeriodIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedPackagesApiRequestsPerPeriod(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedPackagesApiRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedWebEnabledIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedWebEnabled(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedWebEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedWebPeriodInSecondsIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedWebPeriodInSeconds(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedWebPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedWebRequestsPerPeriodIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedWebRequestsPerPeriod(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedWebRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedApiEnabledIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleUnauthenticatedApiEnabled(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedApiEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedApiPeriodInSecondsIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleUnauthenticatedApiPeriodInSeconds(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedApiPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedApiRequestsPerPeriodIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleUnauthenticatedApiRequestsPerPeriod(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedApiRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedEnabledIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleUnauthenticatedEnabled(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedGitHttpEnabledIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleUnauthenticatedGitHttpEnabled(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedGitHttpEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedGitHttpPeriodInSecondsIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleUnauthenticatedGitHttpPeriodInSeconds(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedGitHttpPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedGitHttpRequestsPerPeriodIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleUnauthenticatedGitHttpRequestsPerPeriod(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedGitHttpRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedPackagesApiEnabledIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleUnauthenticatedPackagesApiEnabled(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedPackagesApiEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedPackagesApiPeriodInSecondsIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleUnauthenticatedPackagesApiPeriodInSeconds(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedPackagesApiPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedPackagesApiRequestsPerPeriodIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleUnauthenticatedPackagesApiRequestsPerPeriod(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedPackagesApiRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedPeriodInSecondsIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleUnauthenticatedPeriodInSeconds(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedRequestsPerPeriodIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleUnauthenticatedRequestsPerPeriod(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedWebEnabledIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleUnauthenticatedWebEnabled(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedWebEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedWebPeriodInSecondsIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleUnauthenticatedWebPeriodInSeconds(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedWebPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedWebRequestsPerPeriodIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleUnauthenticatedWebRequestsPerPeriod(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedWebRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedGitLfsEnabledIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedGitLfsEnabled(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedGitLfsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedGitLfsPeriodInSecondsIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedGitLfsPeriodInSeconds(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedGitLfsPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedGitLfsRequestsPerPeriodIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedGitLfsRequestsPerPeriod(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedGitLfsRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedFilesApiEnabledIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedFilesApiEnabled(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedFilesApiEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedFilesApiPeriodInSecondsIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedFilesApiPeriodInSeconds(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedFilesApiPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedFilesApiRequestsPerPeriodIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedFilesApiRequestsPerPeriod(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedFilesApiRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedDeprecatedApiEnabledIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedDeprecatedApiEnabled(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedDeprecatedApiEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedDeprecatedApiPeriodInSecondsIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedDeprecatedApiPeriodInSeconds(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedDeprecatedApiPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedDeprecatedApiRequestsPerPeriodIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleAuthenticatedDeprecatedApiRequestsPerPeriod(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedDeprecatedApiRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedFilesApiEnabledIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleUnauthenticatedFilesApiEnabled(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedFilesApiEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedFilesApiPeriodInSecondsIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleUnauthenticatedFilesApiPeriodInSeconds(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedFilesApiPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedFilesApiRequestsPerPeriodIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleUnauthenticatedFilesApiRequestsPerPeriod(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedFilesApiRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedDeprecatedApiEnabledIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleUnauthenticatedDeprecatedApiEnabled(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedDeprecatedApiEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedDeprecatedApiPeriodInSecondsIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleUnauthenticatedDeprecatedApiPeriodInSeconds(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedDeprecatedApiPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedDeprecatedApiRequestsPerPeriodIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleUnauthenticatedDeprecatedApiRequestsPerPeriod(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedDeprecatedApiRequestsPerPeriod())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleProtectedPathsEnabledIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleProtectedPathsEnabled(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleProtectedPathsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleProtectedPathsPeriodInSecondsIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleProtectedPathsPeriodInSeconds(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleProtectedPathsPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleProtectedPathsRequestsPerPeriodIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleProtectedPathsRequestsPerPeriod(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleProtectedPathsRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleIncidentManagementNotificationEnabledIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleIncidentManagementNotificationEnabled(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleIncidentManagementNotificationEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleIncidentManagementNotificationPerPeriodIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleIncidentManagementNotificationPerPeriod(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleIncidentManagementNotificationPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleIncidentManagementNotificationPeriodInSecondsIsNullable() {
        final GitLabSettingsUpdateThrottleBuilder builder = GitLabSettingsUpdateThrottleBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateThrottle())
                .throttleIncidentManagementNotificationPeriodInSeconds(null);

        final GitLabSettingsUpdateThrottle built = builder.build();

        assertThat(built.throttleIncidentManagementNotificationPeriodInSeconds())
                .isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdateThrottle value = SettingsCatalogFixtures.settingsUpdateThrottle();

        assertSoftly(softly -> {
            softly.assertThat(value.throttleAuthenticatedApiEnabled()).isEqualTo("throttle_authenticated_api_enabled");
            softly.assertThat(value.throttleAuthenticatedApiPeriodInSeconds())
                    .isEqualTo("throttle_authenticated_api_period_in_seconds");
            softly.assertThat(value.throttleAuthenticatedApiRequestsPerPeriod())
                    .isEqualTo("throttle_authenticated_api_requests_per_period");
            softly.assertThat(value.throttleAuthenticatedGitHttpEnabled())
                    .isEqualTo("throttle_authenticated_git_http_enabled");
            softly.assertThat(value.throttleAuthenticatedGitHttpPeriodInSeconds())
                    .isEqualTo("throttle_authenticated_git_http_period_in_seconds");
            softly.assertThat(value.throttleAuthenticatedGitHttpRequestsPerPeriod())
                    .isEqualTo("throttle_authenticated_git_http_requests_per_period");
            softly.assertThat(value.throttleAuthenticatedMcpEnabled()).isEqualTo("throttle_authenticated_mcp_enabled");
            softly.assertThat(value.throttleAuthenticatedMcpPeriodInSeconds())
                    .isEqualTo("throttle_authenticated_mcp_period_in_seconds");
            softly.assertThat(value.throttleAuthenticatedMcpRequestsPerPeriod())
                    .isEqualTo("throttle_authenticated_mcp_requests_per_period");
            softly.assertThat(value.throttleAuthenticatedDependencyProxyEnabled())
                    .isEqualTo("throttle_authenticated_dependency_proxy_enabled");
            softly.assertThat(value.throttleAuthenticatedDependencyProxyPeriodInSeconds())
                    .isEqualTo("throttle_authenticated_dependency_proxy_period_in_seconds");
            softly.assertThat(value.throttleAuthenticatedDependencyProxyRequestsPerPeriod())
                    .isEqualTo("throttle_authenticated_dependency_proxy_requests_per_period");
            softly.assertThat(value.throttleAuthenticatedPackagesApiEnabled())
                    .isEqualTo("throttle_authenticated_packages_api_enabled");
            softly.assertThat(value.throttleAuthenticatedPackagesApiPeriodInSeconds())
                    .isEqualTo("throttle_authenticated_packages_api_period_in_seconds");
            softly.assertThat(value.throttleAuthenticatedPackagesApiRequestsPerPeriod())
                    .isEqualTo("throttle_authenticated_packages_api_requests_per_period");
            softly.assertThat(value.throttleAuthenticatedWebEnabled()).isEqualTo("throttle_authenticated_web_enabled");
            softly.assertThat(value.throttleAuthenticatedWebPeriodInSeconds())
                    .isEqualTo("throttle_authenticated_web_period_in_seconds");
            softly.assertThat(value.throttleAuthenticatedWebRequestsPerPeriod())
                    .isEqualTo("throttle_authenticated_web_requests_per_period");
            softly.assertThat(value.throttleUnauthenticatedApiEnabled())
                    .isEqualTo("throttle_unauthenticated_api_enabled");
            softly.assertThat(value.throttleUnauthenticatedApiPeriodInSeconds())
                    .isEqualTo("throttle_unauthenticated_api_period_in_seconds");
            softly.assertThat(value.throttleUnauthenticatedApiRequestsPerPeriod())
                    .isEqualTo("throttle_unauthenticated_api_requests_per_period");
            softly.assertThat(value.throttleUnauthenticatedEnabled()).isEqualTo("throttle_unauthenticated_enabled");
            softly.assertThat(value.throttleUnauthenticatedGitHttpEnabled())
                    .isEqualTo("throttle_unauthenticated_git_http_enabled");
            softly.assertThat(value.throttleUnauthenticatedGitHttpPeriodInSeconds())
                    .isEqualTo("throttle_unauthenticated_git_http_period_in_seconds");
            softly.assertThat(value.throttleUnauthenticatedGitHttpRequestsPerPeriod())
                    .isEqualTo("throttle_unauthenticated_git_http_requests_per_period");
            softly.assertThat(value.throttleUnauthenticatedPackagesApiEnabled())
                    .isEqualTo("throttle_unauthenticated_packages_api_enabled");
            softly.assertThat(value.throttleUnauthenticatedPackagesApiPeriodInSeconds())
                    .isEqualTo("throttle_unauthenticated_packages_api_period_in_seconds");
            softly.assertThat(value.throttleUnauthenticatedPackagesApiRequestsPerPeriod())
                    .isEqualTo("throttle_unauthenticated_packages_api_requests_per_period");
            softly.assertThat(value.throttleUnauthenticatedPeriodInSeconds())
                    .isEqualTo("throttle_unauthenticated_period_in_seconds");
            softly.assertThat(value.throttleUnauthenticatedRequestsPerPeriod())
                    .isEqualTo("throttle_unauthenticated_requests_per_period");
            softly.assertThat(value.throttleUnauthenticatedWebEnabled())
                    .isEqualTo("throttle_unauthenticated_web_enabled");
            softly.assertThat(value.throttleUnauthenticatedWebPeriodInSeconds())
                    .isEqualTo("throttle_unauthenticated_web_period_in_seconds");
            softly.assertThat(value.throttleUnauthenticatedWebRequestsPerPeriod())
                    .isEqualTo("throttle_unauthenticated_web_requests_per_period");
            softly.assertThat(value.throttleAuthenticatedGitLfsEnabled())
                    .isEqualTo("throttle_authenticated_git_lfs_enabled");
            softly.assertThat(value.throttleAuthenticatedGitLfsPeriodInSeconds())
                    .isEqualTo("throttle_authenticated_git_lfs_period_in_seconds");
            softly.assertThat(value.throttleAuthenticatedGitLfsRequestsPerPeriod())
                    .isEqualTo("throttle_authenticated_git_lfs_requests_per_period");
            softly.assertThat(value.throttleAuthenticatedFilesApiEnabled())
                    .isEqualTo("throttle_authenticated_files_api_enabled");
            softly.assertThat(value.throttleAuthenticatedFilesApiPeriodInSeconds())
                    .isEqualTo("throttle_authenticated_files_api_period_in_seconds");
            softly.assertThat(value.throttleAuthenticatedFilesApiRequestsPerPeriod())
                    .isEqualTo("throttle_authenticated_files_api_requests_per_period");
            softly.assertThat(value.throttleAuthenticatedDeprecatedApiEnabled())
                    .isEqualTo("throttle_authenticated_deprecated_api_enabled");
            softly.assertThat(value.throttleAuthenticatedDeprecatedApiPeriodInSeconds())
                    .isEqualTo("throttle_authenticated_deprecated_api_period_in_seconds");
            softly.assertThat(value.throttleAuthenticatedDeprecatedApiRequestsPerPeriod())
                    .isEqualTo("throttle_authenticated_deprecated_api_requests_per_period");
            softly.assertThat(value.throttleUnauthenticatedFilesApiEnabled())
                    .isEqualTo("throttle_unauthenticated_files_api_enabled");
            softly.assertThat(value.throttleUnauthenticatedFilesApiPeriodInSeconds())
                    .isEqualTo("throttle_unauthenticated_files_api_period_in_seconds");
            softly.assertThat(value.throttleUnauthenticatedFilesApiRequestsPerPeriod())
                    .isEqualTo("throttle_unauthenticated_files_api_requests_per_period");
            softly.assertThat(value.throttleUnauthenticatedDeprecatedApiEnabled())
                    .isEqualTo("throttle_unauthenticated_deprecated_api_enabled");
            softly.assertThat(value.throttleUnauthenticatedDeprecatedApiPeriodInSeconds())
                    .isEqualTo("throttle_unauthenticated_deprecated_api_period_in_seconds");
            softly.assertThat(value.throttleUnauthenticatedDeprecatedApiRequestsPerPeriod())
                    .isEqualTo("throttle_unauthenticated_deprecated_api_requests_per_period");
            softly.assertThat(value.throttleProtectedPathsEnabled()).isEqualTo("throttle_protected_paths_enabled");
            softly.assertThat(value.throttleProtectedPathsPeriodInSeconds())
                    .isEqualTo("throttle_protected_paths_period_in_seconds");
            softly.assertThat(value.throttleProtectedPathsRequestsPerPeriod())
                    .isEqualTo("throttle_protected_paths_requests_per_period");
            softly.assertThat(value.throttleIncidentManagementNotificationEnabled())
                    .isEqualTo("throttle_incident_management_notification_enabled");
            softly.assertThat(value.throttleIncidentManagementNotificationPerPeriod())
                    .isEqualTo("throttle_incident_management_notification_per_period");
            softly.assertThat(value.throttleIncidentManagementNotificationPeriodInSeconds())
                    .isEqualTo("throttle_incident_management_notification_period_in_seconds");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSettingsUpdateThrottle original = SettingsCatalogFixtures.settingsUpdateThrottle();

        final GitLabSettingsUpdateThrottle rebuilt =
                GitLabSettingsUpdateThrottleBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSettingsUpdateThrottle.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "throttleAuthenticatedApiEnabled",
                        "throttleAuthenticatedApiPeriodInSeconds",
                        "throttleAuthenticatedApiRequestsPerPeriod",
                        "throttleAuthenticatedGitHttpEnabled",
                        "throttleAuthenticatedGitHttpPeriodInSeconds",
                        "throttleAuthenticatedGitHttpRequestsPerPeriod",
                        "throttleAuthenticatedMcpEnabled",
                        "throttleAuthenticatedMcpPeriodInSeconds",
                        "throttleAuthenticatedMcpRequestsPerPeriod",
                        "throttleAuthenticatedDependencyProxyEnabled",
                        "throttleAuthenticatedDependencyProxyPeriodInSeconds",
                        "throttleAuthenticatedDependencyProxyRequestsPerPeriod",
                        "throttleAuthenticatedPackagesApiEnabled",
                        "throttleAuthenticatedPackagesApiPeriodInSeconds",
                        "throttleAuthenticatedPackagesApiRequestsPerPeriod",
                        "throttleAuthenticatedWebEnabled",
                        "throttleAuthenticatedWebPeriodInSeconds",
                        "throttleAuthenticatedWebRequestsPerPeriod",
                        "throttleUnauthenticatedApiEnabled",
                        "throttleUnauthenticatedApiPeriodInSeconds",
                        "throttleUnauthenticatedApiRequestsPerPeriod",
                        "throttleUnauthenticatedEnabled",
                        "throttleUnauthenticatedGitHttpEnabled",
                        "throttleUnauthenticatedGitHttpPeriodInSeconds",
                        "throttleUnauthenticatedGitHttpRequestsPerPeriod",
                        "throttleUnauthenticatedPackagesApiEnabled",
                        "throttleUnauthenticatedPackagesApiPeriodInSeconds",
                        "throttleUnauthenticatedPackagesApiRequestsPerPeriod",
                        "throttleUnauthenticatedPeriodInSeconds",
                        "throttleUnauthenticatedRequestsPerPeriod",
                        "throttleUnauthenticatedWebEnabled",
                        "throttleUnauthenticatedWebPeriodInSeconds",
                        "throttleUnauthenticatedWebRequestsPerPeriod",
                        "throttleAuthenticatedGitLfsEnabled",
                        "throttleAuthenticatedGitLfsPeriodInSeconds",
                        "throttleAuthenticatedGitLfsRequestsPerPeriod",
                        "throttleAuthenticatedFilesApiEnabled",
                        "throttleAuthenticatedFilesApiPeriodInSeconds",
                        "throttleAuthenticatedFilesApiRequestsPerPeriod",
                        "throttleAuthenticatedDeprecatedApiEnabled",
                        "throttleAuthenticatedDeprecatedApiPeriodInSeconds",
                        "throttleAuthenticatedDeprecatedApiRequestsPerPeriod",
                        "throttleUnauthenticatedFilesApiEnabled",
                        "throttleUnauthenticatedFilesApiPeriodInSeconds",
                        "throttleUnauthenticatedFilesApiRequestsPerPeriod",
                        "throttleUnauthenticatedDeprecatedApiEnabled",
                        "throttleUnauthenticatedDeprecatedApiPeriodInSeconds",
                        "throttleUnauthenticatedDeprecatedApiRequestsPerPeriod",
                        "throttleProtectedPathsEnabled",
                        "throttleProtectedPathsPeriodInSeconds",
                        "throttleProtectedPathsRequestsPerPeriod",
                        "throttleIncidentManagementNotificationEnabled",
                        "throttleIncidentManagementNotificationPerPeriod",
                        "throttleIncidentManagementNotificationPeriodInSeconds");
    }
}

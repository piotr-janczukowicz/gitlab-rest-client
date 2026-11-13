package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApplicationSettingThrottleTest {

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedApiEnabledIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedApiEnabled(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedApiEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedApiPeriodInSecondsIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedApiPeriodInSeconds(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedApiPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedApiRequestsPerPeriodIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedApiRequestsPerPeriod(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedApiRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedGitHttpEnabledIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedGitHttpEnabled(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedGitHttpEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedGitHttpPeriodInSecondsIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedGitHttpPeriodInSeconds(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedGitHttpPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedGitHttpRequestsPerPeriodIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedGitHttpRequestsPerPeriod(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedGitHttpRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedDependencyProxyEnabledIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedDependencyProxyEnabled(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedDependencyProxyEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedDependencyProxyPeriodInSecondsIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedDependencyProxyPeriodInSeconds(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedDependencyProxyPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedDependencyProxyRequestsPerPeriodIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedDependencyProxyRequestsPerPeriod(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedDependencyProxyRequestsPerPeriod())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedGitLfsEnabledIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedGitLfsEnabled(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedGitLfsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedGitLfsPeriodInSecondsIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedGitLfsPeriodInSeconds(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedGitLfsPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedGitLfsRequestsPerPeriodIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedGitLfsRequestsPerPeriod(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedGitLfsRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedWebEnabledIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedWebEnabled(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedWebEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedWebPeriodInSecondsIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedWebPeriodInSeconds(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedWebPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedWebRequestsPerPeriodIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedWebRequestsPerPeriod(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedWebRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedMcpEnabledIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedMcpEnabled(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedMcpEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedMcpPeriodInSecondsIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedMcpPeriodInSeconds(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedMcpPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedMcpRequestsPerPeriodIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedMcpRequestsPerPeriod(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedMcpRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedPackagesApiEnabledIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedPackagesApiEnabled(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedPackagesApiEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedPackagesApiPeriodInSecondsIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedPackagesApiPeriodInSeconds(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedPackagesApiPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedPackagesApiRequestsPerPeriodIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedPackagesApiRequestsPerPeriod(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedPackagesApiRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedFilesApiEnabledIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedFilesApiEnabled(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedFilesApiEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedFilesApiPeriodInSecondsIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedFilesApiPeriodInSeconds(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedFilesApiPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedFilesApiRequestsPerPeriodIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedFilesApiRequestsPerPeriod(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedFilesApiRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedDeprecatedApiEnabledIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedDeprecatedApiEnabled(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedDeprecatedApiEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedDeprecatedApiPeriodInSecondsIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedDeprecatedApiPeriodInSeconds(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedDeprecatedApiPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleAuthenticatedDeprecatedApiRequestsPerPeriodIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleAuthenticatedDeprecatedApiRequestsPerPeriod(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleAuthenticatedDeprecatedApiRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedApiEnabledIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleUnauthenticatedApiEnabled(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedApiEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedApiPeriodInSecondsIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleUnauthenticatedApiPeriodInSeconds(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedApiPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedApiRequestsPerPeriodIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleUnauthenticatedApiRequestsPerPeriod(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedApiRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedEnabledIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleUnauthenticatedEnabled(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedPeriodInSecondsIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleUnauthenticatedPeriodInSeconds(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedRequestsPerPeriodIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleUnauthenticatedRequestsPerPeriod(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedPackagesApiEnabledIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleUnauthenticatedPackagesApiEnabled(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedPackagesApiEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedPackagesApiPeriodInSecondsIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleUnauthenticatedPackagesApiPeriodInSeconds(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedPackagesApiPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedPackagesApiRequestsPerPeriodIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleUnauthenticatedPackagesApiRequestsPerPeriod(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedPackagesApiRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedFilesApiEnabledIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleUnauthenticatedFilesApiEnabled(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedFilesApiEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedFilesApiPeriodInSecondsIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleUnauthenticatedFilesApiPeriodInSeconds(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedFilesApiPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedFilesApiRequestsPerPeriodIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleUnauthenticatedFilesApiRequestsPerPeriod(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedFilesApiRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedGitHttpEnabledIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleUnauthenticatedGitHttpEnabled(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedGitHttpEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedGitHttpPeriodInSecondsIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleUnauthenticatedGitHttpPeriodInSeconds(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedGitHttpPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedGitHttpRequestsPerPeriodIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleUnauthenticatedGitHttpRequestsPerPeriod(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedGitHttpRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedDeprecatedApiEnabledIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleUnauthenticatedDeprecatedApiEnabled(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedDeprecatedApiEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedDeprecatedApiPeriodInSecondsIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleUnauthenticatedDeprecatedApiPeriodInSeconds(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedDeprecatedApiPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedDeprecatedApiRequestsPerPeriodIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleUnauthenticatedDeprecatedApiRequestsPerPeriod(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedDeprecatedApiRequestsPerPeriod())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleProtectedPathsEnabledIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleProtectedPathsEnabled(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleProtectedPathsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleProtectedPathsPeriodInSecondsIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleProtectedPathsPeriodInSeconds(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleProtectedPathsPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleProtectedPathsRequestsPerPeriodIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleProtectedPathsRequestsPerPeriod(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleProtectedPathsRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleIncidentManagementNotificationEnabledIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleIncidentManagementNotificationEnabled(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleIncidentManagementNotificationEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleIncidentManagementNotificationPerPeriodIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleIncidentManagementNotificationPerPeriod(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleIncidentManagementNotificationPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleIncidentManagementNotificationPeriodInSecondsIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleIncidentManagementNotificationPeriodInSeconds(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleIncidentManagementNotificationPeriodInSeconds())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedWebEnabledIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleUnauthenticatedWebEnabled(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedWebEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedWebPeriodInSecondsIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleUnauthenticatedWebPeriodInSeconds(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedWebPeriodInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleUnauthenticatedWebRequestsPerPeriodIsNullable() {
        final GitLabApplicationSettingThrottleBuilder builder = GitLabApplicationSettingThrottleBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingThrottle())
                .throttleUnauthenticatedWebRequestsPerPeriod(null);

        final GitLabApplicationSettingThrottle built = builder.build();

        assertThat(built.throttleUnauthenticatedWebRequestsPerPeriod()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplicationSettingThrottle value = SettingsCatalogFixtures.applicationSettingThrottle();

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
            softly.assertThat(value.throttleAuthenticatedDependencyProxyEnabled())
                    .isEqualTo("throttle_authenticated_dependency_proxy_enabled");
            softly.assertThat(value.throttleAuthenticatedDependencyProxyPeriodInSeconds())
                    .isEqualTo("throttle_authenticated_dependency_proxy_period_in_seconds");
            softly.assertThat(value.throttleAuthenticatedDependencyProxyRequestsPerPeriod())
                    .isEqualTo("throttle_authenticated_dependency_proxy_requests_per_period");
            softly.assertThat(value.throttleAuthenticatedGitLfsEnabled())
                    .isEqualTo("throttle_authenticated_git_lfs_enabled");
            softly.assertThat(value.throttleAuthenticatedGitLfsPeriodInSeconds())
                    .isEqualTo("throttle_authenticated_git_lfs_period_in_seconds");
            softly.assertThat(value.throttleAuthenticatedGitLfsRequestsPerPeriod())
                    .isEqualTo("throttle_authenticated_git_lfs_requests_per_period");
            softly.assertThat(value.throttleAuthenticatedWebEnabled()).isEqualTo("throttle_authenticated_web_enabled");
            softly.assertThat(value.throttleAuthenticatedWebPeriodInSeconds())
                    .isEqualTo("throttle_authenticated_web_period_in_seconds");
            softly.assertThat(value.throttleAuthenticatedWebRequestsPerPeriod())
                    .isEqualTo("throttle_authenticated_web_requests_per_period");
            softly.assertThat(value.throttleAuthenticatedMcpEnabled()).isEqualTo("throttle_authenticated_mcp_enabled");
            softly.assertThat(value.throttleAuthenticatedMcpPeriodInSeconds())
                    .isEqualTo("throttle_authenticated_mcp_period_in_seconds");
            softly.assertThat(value.throttleAuthenticatedMcpRequestsPerPeriod())
                    .isEqualTo("throttle_authenticated_mcp_requests_per_period");
            softly.assertThat(value.throttleAuthenticatedPackagesApiEnabled())
                    .isEqualTo("throttle_authenticated_packages_api_enabled");
            softly.assertThat(value.throttleAuthenticatedPackagesApiPeriodInSeconds())
                    .isEqualTo("throttle_authenticated_packages_api_period_in_seconds");
            softly.assertThat(value.throttleAuthenticatedPackagesApiRequestsPerPeriod())
                    .isEqualTo("throttle_authenticated_packages_api_requests_per_period");
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
            softly.assertThat(value.throttleUnauthenticatedApiEnabled())
                    .isEqualTo("throttle_unauthenticated_api_enabled");
            softly.assertThat(value.throttleUnauthenticatedApiPeriodInSeconds())
                    .isEqualTo("throttle_unauthenticated_api_period_in_seconds");
            softly.assertThat(value.throttleUnauthenticatedApiRequestsPerPeriod())
                    .isEqualTo("throttle_unauthenticated_api_requests_per_period");
            softly.assertThat(value.throttleUnauthenticatedEnabled()).isEqualTo("throttle_unauthenticated_enabled");
            softly.assertThat(value.throttleUnauthenticatedPeriodInSeconds())
                    .isEqualTo("throttle_unauthenticated_period_in_seconds");
            softly.assertThat(value.throttleUnauthenticatedRequestsPerPeriod())
                    .isEqualTo("throttle_unauthenticated_requests_per_period");
            softly.assertThat(value.throttleUnauthenticatedPackagesApiEnabled())
                    .isEqualTo("throttle_unauthenticated_packages_api_enabled");
            softly.assertThat(value.throttleUnauthenticatedPackagesApiPeriodInSeconds())
                    .isEqualTo("throttle_unauthenticated_packages_api_period_in_seconds");
            softly.assertThat(value.throttleUnauthenticatedPackagesApiRequestsPerPeriod())
                    .isEqualTo("throttle_unauthenticated_packages_api_requests_per_period");
            softly.assertThat(value.throttleUnauthenticatedFilesApiEnabled())
                    .isEqualTo("throttle_unauthenticated_files_api_enabled");
            softly.assertThat(value.throttleUnauthenticatedFilesApiPeriodInSeconds())
                    .isEqualTo("throttle_unauthenticated_files_api_period_in_seconds");
            softly.assertThat(value.throttleUnauthenticatedFilesApiRequestsPerPeriod())
                    .isEqualTo("throttle_unauthenticated_files_api_requests_per_period");
            softly.assertThat(value.throttleUnauthenticatedGitHttpEnabled())
                    .isEqualTo("throttle_unauthenticated_git_http_enabled");
            softly.assertThat(value.throttleUnauthenticatedGitHttpPeriodInSeconds())
                    .isEqualTo("throttle_unauthenticated_git_http_period_in_seconds");
            softly.assertThat(value.throttleUnauthenticatedGitHttpRequestsPerPeriod())
                    .isEqualTo("throttle_unauthenticated_git_http_requests_per_period");
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
            softly.assertThat(value.throttleUnauthenticatedWebEnabled())
                    .isEqualTo("throttle_unauthenticated_web_enabled");
            softly.assertThat(value.throttleUnauthenticatedWebPeriodInSeconds())
                    .isEqualTo("throttle_unauthenticated_web_period_in_seconds");
            softly.assertThat(value.throttleUnauthenticatedWebRequestsPerPeriod())
                    .isEqualTo("throttle_unauthenticated_web_requests_per_period");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApplicationSettingThrottle original = SettingsCatalogFixtures.applicationSettingThrottle();

        final GitLabApplicationSettingThrottle rebuilt =
                GitLabApplicationSettingThrottleBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApplicationSettingThrottle.class.getRecordComponents())
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
                        "throttleAuthenticatedDependencyProxyEnabled",
                        "throttleAuthenticatedDependencyProxyPeriodInSeconds",
                        "throttleAuthenticatedDependencyProxyRequestsPerPeriod",
                        "throttleAuthenticatedGitLfsEnabled",
                        "throttleAuthenticatedGitLfsPeriodInSeconds",
                        "throttleAuthenticatedGitLfsRequestsPerPeriod",
                        "throttleAuthenticatedWebEnabled",
                        "throttleAuthenticatedWebPeriodInSeconds",
                        "throttleAuthenticatedWebRequestsPerPeriod",
                        "throttleAuthenticatedMcpEnabled",
                        "throttleAuthenticatedMcpPeriodInSeconds",
                        "throttleAuthenticatedMcpRequestsPerPeriod",
                        "throttleAuthenticatedPackagesApiEnabled",
                        "throttleAuthenticatedPackagesApiPeriodInSeconds",
                        "throttleAuthenticatedPackagesApiRequestsPerPeriod",
                        "throttleAuthenticatedFilesApiEnabled",
                        "throttleAuthenticatedFilesApiPeriodInSeconds",
                        "throttleAuthenticatedFilesApiRequestsPerPeriod",
                        "throttleAuthenticatedDeprecatedApiEnabled",
                        "throttleAuthenticatedDeprecatedApiPeriodInSeconds",
                        "throttleAuthenticatedDeprecatedApiRequestsPerPeriod",
                        "throttleUnauthenticatedApiEnabled",
                        "throttleUnauthenticatedApiPeriodInSeconds",
                        "throttleUnauthenticatedApiRequestsPerPeriod",
                        "throttleUnauthenticatedEnabled",
                        "throttleUnauthenticatedPeriodInSeconds",
                        "throttleUnauthenticatedRequestsPerPeriod",
                        "throttleUnauthenticatedPackagesApiEnabled",
                        "throttleUnauthenticatedPackagesApiPeriodInSeconds",
                        "throttleUnauthenticatedPackagesApiRequestsPerPeriod",
                        "throttleUnauthenticatedFilesApiEnabled",
                        "throttleUnauthenticatedFilesApiPeriodInSeconds",
                        "throttleUnauthenticatedFilesApiRequestsPerPeriod",
                        "throttleUnauthenticatedGitHttpEnabled",
                        "throttleUnauthenticatedGitHttpPeriodInSeconds",
                        "throttleUnauthenticatedGitHttpRequestsPerPeriod",
                        "throttleUnauthenticatedDeprecatedApiEnabled",
                        "throttleUnauthenticatedDeprecatedApiPeriodInSeconds",
                        "throttleUnauthenticatedDeprecatedApiRequestsPerPeriod",
                        "throttleProtectedPathsEnabled",
                        "throttleProtectedPathsPeriodInSeconds",
                        "throttleProtectedPathsRequestsPerPeriod",
                        "throttleIncidentManagementNotificationEnabled",
                        "throttleIncidentManagementNotificationPerPeriod",
                        "throttleIncidentManagementNotificationPeriodInSeconds",
                        "throttleUnauthenticatedWebEnabled",
                        "throttleUnauthenticatedWebPeriodInSeconds",
                        "throttleUnauthenticatedWebRequestsPerPeriod");
    }
}

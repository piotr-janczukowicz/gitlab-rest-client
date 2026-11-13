package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApplicationSettingOtherMoreTest {

    @Test
    void constructor_shouldAcceptNull_whenPasswordAuthenticationEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .passwordAuthenticationEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.passwordAuthenticationEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordNumberRequiredIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .passwordNumberRequired(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.passwordNumberRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordSymbolRequiredIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .passwordSymbolRequired(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.passwordSymbolRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordUppercaseRequiredIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .passwordUppercaseRequired(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.passwordUppercaseRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordLowercaseRequiredIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .passwordLowercaseRequired(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.passwordLowercaseRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPersonalAccessTokenPrefixIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .personalAccessTokenPrefix(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.personalAccessTokenPrefix()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInstanceTokenPrefixIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .instanceTokenPrefix(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.instanceTokenPrefix()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInstanceLevelAiBetaFeaturesEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .instanceLevelAiBetaFeaturesEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.instanceLevelAiBetaFeaturesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKrokiEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .krokiEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.krokiEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKrokiUrlIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .krokiUrl(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.krokiUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKrokiFormatsIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .krokiFormats(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.krokiFormats()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKrokiDiagramProxyEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .krokiDiagramProxyEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.krokiDiagramProxyEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlantumlEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .plantumlEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.plantumlEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlantumlUrlIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .plantumlUrl(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.plantumlUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlantumlDiagramProxyEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .plantumlDiagramProxyEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.plantumlDiagramProxyEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiagramsnetEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .diagramsnetEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.diagramsnetEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiagramsnetUrlIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .diagramsnetUrl(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.diagramsnetUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPollingIntervalMultiplierIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .pollingIntervalMultiplier(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.pollingIntervalMultiplier()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPrometheusMetricsEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .prometheusMetricsEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.prometheusMetricsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRecaptchaEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .recaptchaEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.recaptchaEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRecaptchaPrivateKeyIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .recaptchaPrivateKey(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.recaptchaPrivateKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRecaptchaSiteKeyIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .recaptchaSiteKey(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.recaptchaSiteKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLoginRecaptchaProtectionEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .loginRecaptchaProtectionEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.loginRecaptchaProtectionEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReceiveMaxInputSizeIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .receiveMaxInputSize(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.receiveMaxInputSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryChecksEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .repositoryChecksEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.repositoryChecksEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositorySizeLimitIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .repositorySizeLimit(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.repositorySizeLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryStoragesWeightedIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .repositoryStoragesWeighted(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.repositoryStoragesWeighted()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRememberMeEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .rememberMeEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.rememberMeEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRestrictedVisibilityLevelsIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .restrictedVisibilityLevels(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.restrictedVisibilityLevels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRsaKeyRestrictionIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .rsaKeyRestriction(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.rsaKeyRestriction()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSessionExpireDelayIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .sessionExpireDelay(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.sessionExpireDelay()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSessionExpireFromInitIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .sessionExpireFromInit(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.sessionExpireFromInit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSharedRunnersEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .sharedRunnersEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.sharedRunnersEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSharedRunnersTextIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .sharedRunnersText(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.sharedRunnersText()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSharedRunnersMinutesIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .sharedRunnersMinutes(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.sharedRunnersMinutes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSignInRestrictionsIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .signInRestrictions(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.signInRestrictions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSignupEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .signupEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.signupEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSilentModeEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .silentModeEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.silentModeEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSilentAdminExportsEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .silentAdminExportsEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.silentAdminExportsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSlackAppEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .slackAppEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.slackAppEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSlackAppIdIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .slackAppId(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.slackAppId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSlackAppSecretIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .slackAppSecret(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.slackAppSecret()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSlackAppSigningSecretIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .slackAppSigningSecret(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.slackAppSigningSecret()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSlackAppVerificationTokenIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .slackAppVerificationToken(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.slackAppVerificationToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourcegraphEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .sourcegraphEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.sourcegraphEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourcegraphUrlIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .sourcegraphUrl(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.sourcegraphUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourcegraphPublicOnlyIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .sourcegraphPublicOnly(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.sourcegraphPublicOnly()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSpamCheckEndpointEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .spamCheckEndpointEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.spamCheckEndpointEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSpamCheckEndpointUrlIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .spamCheckEndpointUrl(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.spamCheckEndpointUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSpamCheckApiKeyIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .spamCheckApiKey(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.spamCheckApiKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerminalMaxSessionTimeIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .terminalMaxSessionTime(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.terminalMaxSessionTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTermsIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .terms(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.terms()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateEncryptionEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .terraformStateEncryptionEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.terraformStateEncryptionEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTopLevelGroupCreationEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .topLevelGroupCreationEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.topLevelGroupCreationEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedPathsRawIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .protectedPathsRaw(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.protectedPathsRaw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedPathsForGetRequestRawIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .protectedPathsForGetRequestRaw(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.protectedPathsForGetRequestRaw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedCiVariablesIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .protectedCiVariables(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.protectedCiVariables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedBranchWriteLimitIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .protectedBranchWriteLimit(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.protectedBranchWriteLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTimeTrackingLimitToHoursIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .timeTrackingLimitToHours(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.timeTrackingLimitToHours()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTwoFactorGracePeriodIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .twoFactorGracePeriod(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.twoFactorGracePeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdateRunnerVersionsEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .updateRunnerVersionsEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.updateRunnerVersionsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUniqueIpsLimitEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .uniqueIpsLimitEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.uniqueIpsLimitEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUniqueIpsLimitPerUserIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .uniqueIpsLimitPerUser(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.uniqueIpsLimitPerUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUniqueIpsLimitTimeWindowIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .uniqueIpsLimitTimeWindow(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.uniqueIpsLimitTimeWindow()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsagePingEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .usagePingEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.usagePingEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsagePingGenerationEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .usagePingGenerationEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.usagePingGenerationEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsagePingFeaturesEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .usagePingFeaturesEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.usagePingFeaturesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseClickhouseForAnalyticsIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .useClickhouseForAnalytics(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.useClickhouseForAnalytics()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseNatsForAuditStreamingIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .useNatsForAuditStreaming(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.useNatsForAuditStreaming()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionCheckEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .versionCheckEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.versionCheckEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiffMaxPatchBytesIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .diffMaxPatchBytes(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.diffMaxPatchBytes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiffMaxFilesIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .diffMaxFiles(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.diffMaxFiles()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiffMaxLinesIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .diffMaxLines(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.diffMaxLines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiffMaxVersionsIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .diffMaxVersions(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.diffMaxVersions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiffMaxCommitsIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .diffMaxCommits(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.diffMaxCommits()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitEmailHostnameIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .commitEmailHostname(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.commitEmailHostname()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLocalMarkdownVersionIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .localMarkdownVersion(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.localMarkdownVersion()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMailgunSigningKeyIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .mailgunSigningKey(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.mailgunSigningKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMailgunEventsEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .mailgunEventsEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.mailgunEventsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnowplowCollectorHostnameIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .snowplowCollectorHostname(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.snowplowCollectorHostname()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnowplowCookieDomainIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .snowplowCookieDomain(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.snowplowCookieDomain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnowplowDatabaseCollectorHostnameIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .snowplowDatabaseCollectorHostname(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.snowplowDatabaseCollectorHostname()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnowplowEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .snowplowEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.snowplowEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnowplowAppIdIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .snowplowAppId(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.snowplowAppId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitlabProductUsageDataEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .gitlabProductUsageDataEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.gitlabProductUsageDataEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitlabDedicatedInstanceIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .gitlabDedicatedInstance(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.gitlabDedicatedInstance()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitlabEnvironmentToolkitInstanceIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .gitlabEnvironmentToolkitInstance(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.gitlabEnvironmentToolkitInstance()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitlabShellOperationLimitIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .gitlabShellOperationLimit(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.gitlabShellOperationLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitlabShellOperationPerActorLimitIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .gitlabShellOperationPerActorLimit(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.gitlabShellOperationPerActorLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitlabProductUsageDataSourceIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .gitlabProductUsageDataSource(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.gitlabProductUsageDataSource()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventHooksLimitIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .pushEventHooksLimit(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.pushEventHooksLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventActivitiesLimitIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .pushEventActivitiesLimit(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.pushEventActivitiesLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomHttpCloneUrlRootIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .customHttpCloneUrlRoot(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.customHttpCloneUrlRoot()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetSizeLimitIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .snippetSizeLimit(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.snippetSizeLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionAndNoteMaxSizeIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .descriptionAndNoteMaxSize(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.descriptionAndNoteMaxSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesCreateLimitIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .issuesCreateLimit(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.issuesCreateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotesCreateLimitIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .notesCreateLimit(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.notesCreateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotesCreateLimitAllowlistRawIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .notesCreateLimitAllowlistRaw(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.notesCreateLimitAllowlistRaw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiscussionsResolveLimitIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .discussionsResolveLimit(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.discussionsResolveLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsCreateLimitIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .mergeRequestsCreateLimit(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.mergeRequestsCreateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsRebaseLimitIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .mergeRequestsRebaseLimit(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.mergeRequestsRebaseLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentDeleteRowsLimitPerUserIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .environmentDeleteRowsLimitPerUser(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.environmentDeleteRowsLimitPerUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFeatureFlagUserListWriteBytesLimitPerUserIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .featureFlagUserListWriteBytesLimitPerUser(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.featureFlagUserListWriteBytesLimitPerUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDraftNotesCreateLimitIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .draftNotesCreateLimit(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.draftNotesCreateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMembersDeleteLimitIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .membersDeleteLimit(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.membersDeleteLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneDestroyLimitIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .milestoneDestroyLimit(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.milestoneDestroyLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRawBlobRequestLimitIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .rawBlobRequestLimit(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.rawBlobRequestLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRawBlobRequestLimitUnauthenticatedIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .rawBlobRequestLimitUnauthenticated(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.rawBlobRequestLimitUnauthenticated()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReleaseEvidenceCollectionsLimitPerUserIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .releaseEvidenceCollectionsLimitPerUser(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.releaseEvidenceCollectionsLimitPerUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReleaseWritesLimitPerProjectIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .releaseWritesLimitPerProject(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.releaseWritesLimitPerProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReleaseWritesLimitPerUserIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .releaseWritesLimitPerUser(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.releaseWritesLimitPerUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageMaxContentBytesIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .wikiPageMaxContentBytes(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.wikiPageMaxContentBytes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiAsciidocAllowUriIncludesIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .wikiAsciidocAllowUriIncludes(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.wikiAsciidocAllowUriIncludes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiReadRequestLimitUnauthenticatedIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .wikiReadRequestLimitUnauthenticated(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.wikiReadRequestLimitUnauthenticated()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRateLimitingResponseTextIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .rateLimitingResponseText(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.rateLimitingResponseText()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageRegistryAllowAnyoneToPullOptionIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .packageRegistryAllowAnyoneToPullOption(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.packageRegistryAllowAnyoneToPullOption()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageRegistryCleanupPoliciesWorkerCapacityIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .packageRegistryCleanupPoliciesWorkerCapacity(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.packageRegistryCleanupPoliciesWorkerCapacity()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageMetadataPurlTypesIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .packageMetadataPurlTypes(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.packageMetadataPurlTypes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeepLatestArtifactIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .keepLatestArtifact(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.keepLatestArtifact()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWhatsNewVariantIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .whatsNewVariant(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.whatsNewVariant()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceAccessTokenNotifyInheritedIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .resourceAccessTokenNotifyInherited(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.resourceAccessTokenNotifyInherited()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceUsageLimitsIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .resourceUsageLimits(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.resourceUsageLimits()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSentryEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .sentryEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.sentryEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSentryDsnIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .sentryDsn(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.sentryDsn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSentryClientsideDsnIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .sentryClientsideDsn(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.sentryClientsideDsn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSentryEnvironmentIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .sentryEnvironment(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.sentryEnvironment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSentryClientsideTracesSampleRateIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .sentryClientsideTracesSampleRate(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.sentryClientsideTracesSampleRate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSidekiqJobLimiterModeIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .sidekiqJobLimiterMode(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.sidekiqJobLimiterMode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSidekiqJobLimiterCompressionThresholdBytesIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .sidekiqJobLimiterCompressionThresholdBytes(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.sidekiqJobLimiterCompressionThresholdBytes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSidekiqJobLimiterLimitBytesIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .sidekiqJobLimiterLimitBytes(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.sidekiqJobLimiterLimitBytes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSidekiqTimezoneOverrideIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .sidekiqTimezoneOverride(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.sidekiqTimezoneOverride()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnableArtifactExternalRedirectWarningPageIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .enableArtifactExternalRedirectWarningPage(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.enableArtifactExternalRedirectWarningPage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnableLanguageServerRestrictionsIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .enableLanguageServerRestrictions(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.enableLanguageServerRestrictions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnableMemberPromotionManagementIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .enableMemberPromotionManagement(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.enableMemberPromotionManagement()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchRateLimitIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .searchRateLimit(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.searchRateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchRateLimitUnauthenticatedIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .searchRateLimitUnauthenticated(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.searchRateLimitUnauthenticated()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchRateLimitAllowlistRawIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .searchRateLimitAllowlistRaw(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.searchRateLimitAllowlistRaw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineLimitPerProjectUserShaIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .pipelineLimitPerProjectUserSha(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.pipelineLimitPerProjectUserSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineLimitPerUserIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .pipelineLimitPerUser(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.pipelineLimitPerUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineCancelLimitPerUserProjectIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .pipelineCancelLimitPerUserProject(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.pipelineCancelLimitPerUserProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineRetryLimitPerUserProjectIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .pipelineRetryLimitPerUserProject(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.pipelineRetryLimitPerUserProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineScheduleManagementLimitPerUserIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .pipelineScheduleManagementLimitPerUser(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.pipelineScheduleManagementLimitPerUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineDeleteLimitPerUserProjectIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .pipelineDeleteLimitPerUserProject(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.pipelineDeleteLimitPerUserProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineExecutionPoliciesPerConfigurationLimitIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .pipelineExecutionPoliciesPerConfigurationLimit(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.pipelineExecutionPoliciesPerConfigurationLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInvitationFlowEnforcementIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .invitationFlowEnforcement(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.invitationFlowEnforcement()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCanCreateGroupIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .canCreateGroup(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.canCreateGroup()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCanCreateOrganizationIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .canCreateOrganization(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.canCreateOrganization()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBulkImportConcurrentPipelineBatchLimitIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .bulkImportConcurrentPipelineBatchLimit(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.bulkImportConcurrentPipelineBatchLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBulkImportEnabledIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .bulkImportEnabled(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.bulkImportEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBulkImportMaxDownloadFileSizeIsNullable() {
        final GitLabApplicationSettingOtherMoreBuilder builder = GitLabApplicationSettingOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherMore())
                .bulkImportMaxDownloadFileSize(null);

        final GitLabApplicationSettingOtherMore built = builder.build();

        assertThat(built.bulkImportMaxDownloadFileSize()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplicationSettingOtherMore value = SettingsCatalogFixtures.applicationSettingOtherMore();

        assertSoftly(softly -> {
            softly.assertThat(value.passwordAuthenticationEnabled()).isEqualTo("password_authentication_enabled");
            softly.assertThat(value.passwordNumberRequired()).isEqualTo("password_number_required");
            softly.assertThat(value.passwordSymbolRequired()).isEqualTo("password_symbol_required");
            softly.assertThat(value.passwordUppercaseRequired()).isEqualTo("password_uppercase_required");
            softly.assertThat(value.passwordLowercaseRequired()).isEqualTo("password_lowercase_required");
            softly.assertThat(value.personalAccessTokenPrefix()).isEqualTo("personal_access_token_prefix");
            softly.assertThat(value.instanceTokenPrefix()).isEqualTo("instance_token_prefix");
            softly.assertThat(value.instanceLevelAiBetaFeaturesEnabled())
                    .isEqualTo("instance_level_ai_beta_features_enabled");
            softly.assertThat(value.krokiEnabled()).isEqualTo("kroki_enabled");
            softly.assertThat(value.krokiUrl()).isEqualTo("kroki_url");
            softly.assertThat(value.krokiFormats()).isEqualTo("kroki_formats");
            softly.assertThat(value.krokiDiagramProxyEnabled()).isEqualTo("kroki_diagram_proxy_enabled");
            softly.assertThat(value.plantumlEnabled()).isEqualTo("plantuml_enabled");
            softly.assertThat(value.plantumlUrl()).isEqualTo("plantuml_url");
            softly.assertThat(value.plantumlDiagramProxyEnabled()).isEqualTo("plantuml_diagram_proxy_enabled");
            softly.assertThat(value.diagramsnetEnabled()).isEqualTo("diagramsnet_enabled");
            softly.assertThat(value.diagramsnetUrl()).isEqualTo("diagramsnet_url");
            softly.assertThat(value.pollingIntervalMultiplier()).isEqualTo("polling_interval_multiplier");
            softly.assertThat(value.prometheusMetricsEnabled()).isEqualTo("prometheus_metrics_enabled");
            softly.assertThat(value.recaptchaEnabled()).isEqualTo("recaptcha_enabled");
            softly.assertThat(value.recaptchaPrivateKey()).isEqualTo("recaptcha_private_key");
            softly.assertThat(value.recaptchaSiteKey()).isEqualTo("recaptcha_site_key");
            softly.assertThat(value.loginRecaptchaProtectionEnabled()).isEqualTo("login_recaptcha_protection_enabled");
            softly.assertThat(value.receiveMaxInputSize()).isEqualTo("receive_max_input_size");
            softly.assertThat(value.repositoryChecksEnabled()).isEqualTo("repository_checks_enabled");
            softly.assertThat(value.repositorySizeLimit()).isEqualTo("repository_size_limit");
            softly.assertThat(value.repositoryStoragesWeighted()).isEqualTo("repository_storages_weighted");
            softly.assertThat(value.rememberMeEnabled()).isEqualTo("remember_me_enabled");
            softly.assertThat(value.restrictedVisibilityLevels()).isEqualTo("restricted_visibility_levels");
            softly.assertThat(value.rsaKeyRestriction()).isEqualTo("rsa_key_restriction");
            softly.assertThat(value.sessionExpireDelay()).isEqualTo("session_expire_delay");
            softly.assertThat(value.sessionExpireFromInit()).isEqualTo("session_expire_from_init");
            softly.assertThat(value.sharedRunnersEnabled()).isEqualTo("shared_runners_enabled");
            softly.assertThat(value.sharedRunnersText()).isEqualTo("shared_runners_text");
            softly.assertThat(value.sharedRunnersMinutes()).isEqualTo("shared_runners_minutes");
            softly.assertThat(value.signInRestrictions()).isEqualTo("sign_in_restrictions");
            softly.assertThat(value.signupEnabled()).isEqualTo("signup_enabled");
            softly.assertThat(value.silentModeEnabled()).isEqualTo("silent_mode_enabled");
            softly.assertThat(value.silentAdminExportsEnabled()).isEqualTo("silent_admin_exports_enabled");
            softly.assertThat(value.slackAppEnabled()).isEqualTo("slack_app_enabled");
            softly.assertThat(value.slackAppId()).isEqualTo("slack_app_id");
            softly.assertThat(value.slackAppSecret()).isEqualTo("slack_app_secret");
            softly.assertThat(value.slackAppSigningSecret()).isEqualTo("slack_app_signing_secret");
            softly.assertThat(value.slackAppVerificationToken()).isEqualTo("slack_app_verification_token");
            softly.assertThat(value.sourcegraphEnabled()).isEqualTo("sourcegraph_enabled");
            softly.assertThat(value.sourcegraphUrl()).isEqualTo("sourcegraph_url");
            softly.assertThat(value.sourcegraphPublicOnly()).isEqualTo("sourcegraph_public_only");
            softly.assertThat(value.spamCheckEndpointEnabled()).isEqualTo("spam_check_endpoint_enabled");
            softly.assertThat(value.spamCheckEndpointUrl()).isEqualTo("spam_check_endpoint_url");
            softly.assertThat(value.spamCheckApiKey()).isEqualTo("spam_check_api_key");
            softly.assertThat(value.terminalMaxSessionTime()).isEqualTo("terminal_max_session_time");
            softly.assertThat(value.terms()).isEqualTo("terms");
            softly.assertThat(value.terraformStateEncryptionEnabled()).isEqualTo("terraform_state_encryption_enabled");
            softly.assertThat(value.topLevelGroupCreationEnabled()).isEqualTo("top_level_group_creation_enabled");
            softly.assertThat(value.protectedPathsRaw()).isEqualTo("protected_paths_raw");
            softly.assertThat(value.protectedPathsForGetRequestRaw()).isEqualTo("protected_paths_for_get_request_raw");
            softly.assertThat(value.protectedCiVariables()).isEqualTo("protected_ci_variables");
            softly.assertThat(value.protectedBranchWriteLimit()).isEqualTo("protected_branch_write_limit");
            softly.assertThat(value.timeTrackingLimitToHours()).isEqualTo("time_tracking_limit_to_hours");
            softly.assertThat(value.twoFactorGracePeriod()).isEqualTo("two_factor_grace_period");
            softly.assertThat(value.updateRunnerVersionsEnabled()).isEqualTo("update_runner_versions_enabled");
            softly.assertThat(value.uniqueIpsLimitEnabled()).isEqualTo("unique_ips_limit_enabled");
            softly.assertThat(value.uniqueIpsLimitPerUser()).isEqualTo("unique_ips_limit_per_user");
            softly.assertThat(value.uniqueIpsLimitTimeWindow()).isEqualTo("unique_ips_limit_time_window");
            softly.assertThat(value.usagePingEnabled()).isEqualTo("usage_ping_enabled");
            softly.assertThat(value.usagePingGenerationEnabled()).isEqualTo("usage_ping_generation_enabled");
            softly.assertThat(value.usagePingFeaturesEnabled()).isEqualTo("usage_ping_features_enabled");
            softly.assertThat(value.useClickhouseForAnalytics()).isEqualTo("use_clickhouse_for_analytics");
            softly.assertThat(value.useNatsForAuditStreaming()).isEqualTo(true);
            softly.assertThat(value.versionCheckEnabled()).isEqualTo("version_check_enabled");
            softly.assertThat(value.diffMaxPatchBytes()).isEqualTo("diff_max_patch_bytes");
            softly.assertThat(value.diffMaxFiles()).isEqualTo("diff_max_files");
            softly.assertThat(value.diffMaxLines()).isEqualTo("diff_max_lines");
            softly.assertThat(value.diffMaxVersions()).isEqualTo("diff_max_versions");
            softly.assertThat(value.diffMaxCommits()).isEqualTo("diff_max_commits");
            softly.assertThat(value.commitEmailHostname()).isEqualTo("commit_email_hostname");
            softly.assertThat(value.localMarkdownVersion()).isEqualTo("local_markdown_version");
            softly.assertThat(value.mailgunSigningKey()).isEqualTo("mailgun_signing_key");
            softly.assertThat(value.mailgunEventsEnabled()).isEqualTo("mailgun_events_enabled");
            softly.assertThat(value.snowplowCollectorHostname()).isEqualTo("snowplow_collector_hostname");
            softly.assertThat(value.snowplowCookieDomain()).isEqualTo("snowplow_cookie_domain");
            softly.assertThat(value.snowplowDatabaseCollectorHostname())
                    .isEqualTo("snowplow_database_collector_hostname");
            softly.assertThat(value.snowplowEnabled()).isEqualTo("snowplow_enabled");
            softly.assertThat(value.snowplowAppId()).isEqualTo("snowplow_app_id");
            softly.assertThat(value.gitlabProductUsageDataEnabled()).isEqualTo("gitlab_product_usage_data_enabled");
            softly.assertThat(value.gitlabDedicatedInstance()).isEqualTo("gitlab_dedicated_instance");
            softly.assertThat(value.gitlabEnvironmentToolkitInstance())
                    .isEqualTo("gitlab_environment_toolkit_instance");
            softly.assertThat(value.gitlabShellOperationLimit()).isEqualTo("gitlab_shell_operation_limit");
            softly.assertThat(value.gitlabShellOperationPerActorLimit())
                    .isEqualTo("gitlab_shell_operation_per_actor_limit");
            softly.assertThat(value.gitlabProductUsageDataSource()).isEqualTo("gitlab_product_usage_data_source");
            softly.assertThat(value.pushEventHooksLimit()).isEqualTo("push_event_hooks_limit");
            softly.assertThat(value.pushEventActivitiesLimit()).isEqualTo("push_event_activities_limit");
            softly.assertThat(value.customHttpCloneUrlRoot()).isEqualTo("custom_http_clone_url_root");
            softly.assertThat(value.snippetSizeLimit()).isEqualTo("snippet_size_limit");
            softly.assertThat(value.descriptionAndNoteMaxSize()).isEqualTo("description_and_note_max_size");
            softly.assertThat(value.issuesCreateLimit()).isEqualTo("issues_create_limit");
            softly.assertThat(value.notesCreateLimit()).isEqualTo("notes_create_limit");
            softly.assertThat(value.notesCreateLimitAllowlistRaw()).isEqualTo("notes_create_limit_allowlist_raw");
            softly.assertThat(value.discussionsResolveLimit()).isEqualTo("discussions_resolve_limit");
            softly.assertThat(value.mergeRequestsCreateLimit()).isEqualTo("merge_requests_create_limit");
            softly.assertThat(value.mergeRequestsRebaseLimit()).isEqualTo("merge_requests_rebase_limit");
            softly.assertThat(value.environmentDeleteRowsLimitPerUser())
                    .isEqualTo("environment_delete_rows_limit_per_user");
            softly.assertThat(value.featureFlagUserListWriteBytesLimitPerUser())
                    .isEqualTo("feature_flag_user_list_write_bytes_limit_per_user");
            softly.assertThat(value.draftNotesCreateLimit()).isEqualTo("draft_notes_create_limit");
            softly.assertThat(value.membersDeleteLimit()).isEqualTo("members_delete_limit");
            softly.assertThat(value.milestoneDestroyLimit()).isEqualTo("milestone_destroy_limit");
            softly.assertThat(value.rawBlobRequestLimit()).isEqualTo("raw_blob_request_limit");
            softly.assertThat(value.rawBlobRequestLimitUnauthenticated())
                    .isEqualTo("raw_blob_request_limit_unauthenticated");
            softly.assertThat(value.releaseEvidenceCollectionsLimitPerUser())
                    .isEqualTo("release_evidence_collections_limit_per_user");
            softly.assertThat(value.releaseWritesLimitPerProject()).isEqualTo("release_writes_limit_per_project");
            softly.assertThat(value.releaseWritesLimitPerUser()).isEqualTo("release_writes_limit_per_user");
            softly.assertThat(value.wikiPageMaxContentBytes()).isEqualTo("wiki_page_max_content_bytes");
            softly.assertThat(value.wikiAsciidocAllowUriIncludes()).isEqualTo("wiki_asciidoc_allow_uri_includes");
            softly.assertThat(value.wikiReadRequestLimitUnauthenticated())
                    .isEqualTo("wiki_read_request_limit_unauthenticated");
            softly.assertThat(value.rateLimitingResponseText()).isEqualTo("rate_limiting_response_text");
            softly.assertThat(value.packageRegistryAllowAnyoneToPullOption())
                    .isEqualTo("package_registry_allow_anyone_to_pull_option");
            softly.assertThat(value.packageRegistryCleanupPoliciesWorkerCapacity())
                    .isEqualTo("package_registry_cleanup_policies_worker_capacity");
            softly.assertThat(value.packageMetadataPurlTypes()).isEqualTo("package_metadata_purl_types");
            softly.assertThat(value.keepLatestArtifact()).isEqualTo("keep_latest_artifact");
            softly.assertThat(value.whatsNewVariant()).isEqualTo("whats_new_variant");
            softly.assertThat(value.resourceAccessTokenNotifyInherited())
                    .isEqualTo("resource_access_token_notify_inherited");
            softly.assertThat(value.resourceUsageLimits()).isEqualTo("resource_usage_limits");
            softly.assertThat(value.sentryEnabled()).isEqualTo("sentry_enabled");
            softly.assertThat(value.sentryDsn()).isEqualTo("sentry_dsn");
            softly.assertThat(value.sentryClientsideDsn()).isEqualTo("sentry_clientside_dsn");
            softly.assertThat(value.sentryEnvironment()).isEqualTo("sentry_environment");
            softly.assertThat(value.sentryClientsideTracesSampleRate())
                    .isEqualTo("sentry_clientside_traces_sample_rate");
            softly.assertThat(value.sidekiqJobLimiterMode()).isEqualTo("sidekiq_job_limiter_mode");
            softly.assertThat(value.sidekiqJobLimiterCompressionThresholdBytes())
                    .isEqualTo("sidekiq_job_limiter_compression_threshold_bytes");
            softly.assertThat(value.sidekiqJobLimiterLimitBytes()).isEqualTo("sidekiq_job_limiter_limit_bytes");
            softly.assertThat(value.sidekiqTimezoneOverride()).isEqualTo("sidekiq_timezone_override");
            softly.assertThat(value.enableArtifactExternalRedirectWarningPage())
                    .isEqualTo("enable_artifact_external_redirect_warning_page");
            softly.assertThat(value.enableLanguageServerRestrictions())
                    .isEqualTo("enable_language_server_restrictions");
            softly.assertThat(value.enableMemberPromotionManagement()).isEqualTo("enable_member_promotion_management");
            softly.assertThat(value.searchRateLimit()).isEqualTo("search_rate_limit");
            softly.assertThat(value.searchRateLimitUnauthenticated()).isEqualTo("search_rate_limit_unauthenticated");
            softly.assertThat(value.searchRateLimitAllowlistRaw()).isEqualTo("search_rate_limit_allowlist_raw");
            softly.assertThat(value.pipelineLimitPerProjectUserSha()).isEqualTo("pipeline_limit_per_project_user_sha");
            softly.assertThat(value.pipelineLimitPerUser()).isEqualTo("pipeline_limit_per_user");
            softly.assertThat(value.pipelineCancelLimitPerUserProject())
                    .isEqualTo("pipeline_cancel_limit_per_user_project");
            softly.assertThat(value.pipelineRetryLimitPerUserProject())
                    .isEqualTo("pipeline_retry_limit_per_user_project");
            softly.assertThat(value.pipelineScheduleManagementLimitPerUser())
                    .isEqualTo("pipeline_schedule_management_limit_per_user");
            softly.assertThat(value.pipelineDeleteLimitPerUserProject())
                    .isEqualTo("pipeline_delete_limit_per_user_project");
            softly.assertThat(value.pipelineExecutionPoliciesPerConfigurationLimit())
                    .isEqualTo("pipeline_execution_policies_per_configuration_limit");
            softly.assertThat(value.invitationFlowEnforcement()).isEqualTo("invitation_flow_enforcement");
            softly.assertThat(value.canCreateGroup()).isEqualTo("can_create_group");
            softly.assertThat(value.canCreateOrganization()).isEqualTo("can_create_organization");
            softly.assertThat(value.bulkImportConcurrentPipelineBatchLimit())
                    .isEqualTo("bulk_import_concurrent_pipeline_batch_limit");
            softly.assertThat(value.bulkImportEnabled()).isEqualTo("bulk_import_enabled");
            softly.assertThat(value.bulkImportMaxDownloadFileSize()).isEqualTo("bulk_import_max_download_file_size");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApplicationSettingOtherMore original = SettingsCatalogFixtures.applicationSettingOtherMore();

        final GitLabApplicationSettingOtherMore rebuilt =
                GitLabApplicationSettingOtherMoreBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenPasswordNumberRequiredIsACredential() {
        final GitLabApplicationSettingOtherMore value = SettingsCatalogFixtures.applicationSettingOtherMore();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenPasswordSymbolRequiredIsACredential() {
        final GitLabApplicationSettingOtherMore value = SettingsCatalogFixtures.applicationSettingOtherMore();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenPasswordUppercaseRequiredIsACredential() {
        final GitLabApplicationSettingOtherMore value = SettingsCatalogFixtures.applicationSettingOtherMore();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenPasswordLowercaseRequiredIsACredential() {
        final GitLabApplicationSettingOtherMore value = SettingsCatalogFixtures.applicationSettingOtherMore();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenPersonalAccessTokenPrefixIsACredential() {
        final GitLabApplicationSettingOtherMore value = SettingsCatalogFixtures.applicationSettingOtherMore();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenInstanceTokenPrefixIsACredential() {
        final GitLabApplicationSettingOtherMore value = SettingsCatalogFixtures.applicationSettingOtherMore();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenRecaptchaPrivateKeyIsACredential() {
        final GitLabApplicationSettingOtherMore value = SettingsCatalogFixtures.applicationSettingOtherMore();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenSlackAppSecretIsACredential() {
        final GitLabApplicationSettingOtherMore value = SettingsCatalogFixtures.applicationSettingOtherMore();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenSlackAppSigningSecretIsACredential() {
        final GitLabApplicationSettingOtherMore value = SettingsCatalogFixtures.applicationSettingOtherMore();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenSlackAppVerificationTokenIsACredential() {
        final GitLabApplicationSettingOtherMore value = SettingsCatalogFixtures.applicationSettingOtherMore();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenResourceAccessTokenNotifyInheritedIsACredential() {
        final GitLabApplicationSettingOtherMore value = SettingsCatalogFixtures.applicationSettingOtherMore();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApplicationSettingOtherMore.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "passwordAuthenticationEnabled",
                        "passwordNumberRequired",
                        "passwordSymbolRequired",
                        "passwordUppercaseRequired",
                        "passwordLowercaseRequired",
                        "personalAccessTokenPrefix",
                        "instanceTokenPrefix",
                        "instanceLevelAiBetaFeaturesEnabled",
                        "krokiEnabled",
                        "krokiUrl",
                        "krokiFormats",
                        "krokiDiagramProxyEnabled",
                        "plantumlEnabled",
                        "plantumlUrl",
                        "plantumlDiagramProxyEnabled",
                        "diagramsnetEnabled",
                        "diagramsnetUrl",
                        "pollingIntervalMultiplier",
                        "prometheusMetricsEnabled",
                        "recaptchaEnabled",
                        "recaptchaPrivateKey",
                        "recaptchaSiteKey",
                        "loginRecaptchaProtectionEnabled",
                        "receiveMaxInputSize",
                        "repositoryChecksEnabled",
                        "repositorySizeLimit",
                        "repositoryStoragesWeighted",
                        "rememberMeEnabled",
                        "restrictedVisibilityLevels",
                        "rsaKeyRestriction",
                        "sessionExpireDelay",
                        "sessionExpireFromInit",
                        "sharedRunnersEnabled",
                        "sharedRunnersText",
                        "sharedRunnersMinutes",
                        "signInRestrictions",
                        "signupEnabled",
                        "silentModeEnabled",
                        "silentAdminExportsEnabled",
                        "slackAppEnabled",
                        "slackAppId",
                        "slackAppSecret",
                        "slackAppSigningSecret",
                        "slackAppVerificationToken",
                        "sourcegraphEnabled",
                        "sourcegraphUrl",
                        "sourcegraphPublicOnly",
                        "spamCheckEndpointEnabled",
                        "spamCheckEndpointUrl",
                        "spamCheckApiKey",
                        "terminalMaxSessionTime",
                        "terms",
                        "terraformStateEncryptionEnabled",
                        "topLevelGroupCreationEnabled",
                        "protectedPathsRaw",
                        "protectedPathsForGetRequestRaw",
                        "protectedCiVariables",
                        "protectedBranchWriteLimit",
                        "timeTrackingLimitToHours",
                        "twoFactorGracePeriod",
                        "updateRunnerVersionsEnabled",
                        "uniqueIpsLimitEnabled",
                        "uniqueIpsLimitPerUser",
                        "uniqueIpsLimitTimeWindow",
                        "usagePingEnabled",
                        "usagePingGenerationEnabled",
                        "usagePingFeaturesEnabled",
                        "useClickhouseForAnalytics",
                        "useNatsForAuditStreaming",
                        "versionCheckEnabled",
                        "diffMaxPatchBytes",
                        "diffMaxFiles",
                        "diffMaxLines",
                        "diffMaxVersions",
                        "diffMaxCommits",
                        "commitEmailHostname",
                        "localMarkdownVersion",
                        "mailgunSigningKey",
                        "mailgunEventsEnabled",
                        "snowplowCollectorHostname",
                        "snowplowCookieDomain",
                        "snowplowDatabaseCollectorHostname",
                        "snowplowEnabled",
                        "snowplowAppId",
                        "gitlabProductUsageDataEnabled",
                        "gitlabDedicatedInstance",
                        "gitlabEnvironmentToolkitInstance",
                        "gitlabShellOperationLimit",
                        "gitlabShellOperationPerActorLimit",
                        "gitlabProductUsageDataSource",
                        "pushEventHooksLimit",
                        "pushEventActivitiesLimit",
                        "customHttpCloneUrlRoot",
                        "snippetSizeLimit",
                        "descriptionAndNoteMaxSize",
                        "issuesCreateLimit",
                        "notesCreateLimit",
                        "notesCreateLimitAllowlistRaw",
                        "discussionsResolveLimit",
                        "mergeRequestsCreateLimit",
                        "mergeRequestsRebaseLimit",
                        "environmentDeleteRowsLimitPerUser",
                        "featureFlagUserListWriteBytesLimitPerUser",
                        "draftNotesCreateLimit",
                        "membersDeleteLimit",
                        "milestoneDestroyLimit",
                        "rawBlobRequestLimit",
                        "rawBlobRequestLimitUnauthenticated",
                        "releaseEvidenceCollectionsLimitPerUser",
                        "releaseWritesLimitPerProject",
                        "releaseWritesLimitPerUser",
                        "wikiPageMaxContentBytes",
                        "wikiAsciidocAllowUriIncludes",
                        "wikiReadRequestLimitUnauthenticated",
                        "rateLimitingResponseText",
                        "packageRegistryAllowAnyoneToPullOption",
                        "packageRegistryCleanupPoliciesWorkerCapacity",
                        "packageMetadataPurlTypes",
                        "keepLatestArtifact",
                        "whatsNewVariant",
                        "resourceAccessTokenNotifyInherited",
                        "resourceUsageLimits",
                        "sentryEnabled",
                        "sentryDsn",
                        "sentryClientsideDsn",
                        "sentryEnvironment",
                        "sentryClientsideTracesSampleRate",
                        "sidekiqJobLimiterMode",
                        "sidekiqJobLimiterCompressionThresholdBytes",
                        "sidekiqJobLimiterLimitBytes",
                        "sidekiqTimezoneOverride",
                        "enableArtifactExternalRedirectWarningPage",
                        "enableLanguageServerRestrictions",
                        "enableMemberPromotionManagement",
                        "searchRateLimit",
                        "searchRateLimitUnauthenticated",
                        "searchRateLimitAllowlistRaw",
                        "pipelineLimitPerProjectUserSha",
                        "pipelineLimitPerUser",
                        "pipelineCancelLimitPerUserProject",
                        "pipelineRetryLimitPerUserProject",
                        "pipelineScheduleManagementLimitPerUser",
                        "pipelineDeleteLimitPerUserProject",
                        "pipelineExecutionPoliciesPerConfigurationLimit",
                        "invitationFlowEnforcement",
                        "canCreateGroup",
                        "canCreateOrganization",
                        "bulkImportConcurrentPipelineBatchLimit",
                        "bulkImportEnabled",
                        "bulkImportMaxDownloadFileSize");
    }
}

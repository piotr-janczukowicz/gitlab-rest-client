package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdateExternalTest {

    @Test
    void constructor_shouldAcceptNull_whenExternalAuthClientCertIsNullable() {
        final GitLabSettingsUpdateExternalBuilder builder = GitLabSettingsUpdateExternalBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateExternal())
                .externalAuthClientCert(null);

        final GitLabSettingsUpdateExternal built = builder.build();

        assertThat(built.externalAuthClientCert()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalAuthClientKeyIsNullable() {
        final GitLabSettingsUpdateExternalBuilder builder = GitLabSettingsUpdateExternalBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateExternal())
                .externalAuthClientKey(null);

        final GitLabSettingsUpdateExternal built = builder.build();

        assertThat(built.externalAuthClientKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalAuthClientKeyPassIsNullable() {
        final GitLabSettingsUpdateExternalBuilder builder = GitLabSettingsUpdateExternalBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateExternal())
                .externalAuthClientKeyPass(null);

        final GitLabSettingsUpdateExternal built = builder.build();

        assertThat(built.externalAuthClientKeyPass()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalAuthorizationServiceDefaultLabelIsNullable() {
        final GitLabSettingsUpdateExternalBuilder builder = GitLabSettingsUpdateExternalBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateExternal())
                .externalAuthorizationServiceDefaultLabel(null);

        final GitLabSettingsUpdateExternal built = builder.build();

        assertThat(built.externalAuthorizationServiceDefaultLabel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalAuthorizationServiceEnabledIsNullable() {
        final GitLabSettingsUpdateExternalBuilder builder = GitLabSettingsUpdateExternalBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateExternal())
                .externalAuthorizationServiceEnabled(null);

        final GitLabSettingsUpdateExternal built = builder.build();

        assertThat(built.externalAuthorizationServiceEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalAuthorizationServiceTimeoutIsNullable() {
        final GitLabSettingsUpdateExternalBuilder builder = GitLabSettingsUpdateExternalBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateExternal())
                .externalAuthorizationServiceTimeout(null);

        final GitLabSettingsUpdateExternal built = builder.build();

        assertThat(built.externalAuthorizationServiceTimeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalAuthorizationServiceUrlIsNullable() {
        final GitLabSettingsUpdateExternalBuilder builder = GitLabSettingsUpdateExternalBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateExternal())
                .externalAuthorizationServiceUrl(null);

        final GitLabSettingsUpdateExternal built = builder.build();

        assertThat(built.externalAuthorizationServiceUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalPipelineValidationServiceTimeoutIsNullable() {
        final GitLabSettingsUpdateExternalBuilder builder = GitLabSettingsUpdateExternalBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateExternal())
                .externalPipelineValidationServiceTimeout(null);

        final GitLabSettingsUpdateExternal built = builder.build();

        assertThat(built.externalPipelineValidationServiceTimeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalPipelineValidationServiceTokenIsNullable() {
        final GitLabSettingsUpdateExternalBuilder builder = GitLabSettingsUpdateExternalBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateExternal())
                .externalPipelineValidationServiceToken(null);

        final GitLabSettingsUpdateExternal built = builder.build();

        assertThat(built.externalPipelineValidationServiceToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalPipelineValidationServiceUrlIsNullable() {
        final GitLabSettingsUpdateExternalBuilder builder = GitLabSettingsUpdateExternalBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateExternal())
                .externalPipelineValidationServiceUrl(null);

        final GitLabSettingsUpdateExternal built = builder.build();

        assertThat(built.externalPipelineValidationServiceUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdateExternal value = SettingsCatalogFixtures.settingsUpdateExternal();

        assertSoftly(softly -> {
            softly.assertThat(value.externalAuthClientCert()).isEqualTo("external_auth_client_cert");
            softly.assertThat(value.externalAuthClientKey()).isEqualTo("external_auth_client_key");
            softly.assertThat(value.externalAuthClientKeyPass()).isEqualTo("external_auth_client_key_pass");
            softly.assertThat(value.externalAuthorizationServiceDefaultLabel())
                    .isEqualTo("external_authorization_service_default_label");
            softly.assertThat(value.externalAuthorizationServiceEnabled())
                    .isEqualTo("external_authorization_service_enabled");
            softly.assertThat(value.externalAuthorizationServiceTimeout())
                    .isEqualTo("external_authorization_service_timeout");
            softly.assertThat(value.externalAuthorizationServiceUrl()).isEqualTo("external_authorization_service_url");
            softly.assertThat(value.externalPipelineValidationServiceTimeout())
                    .isEqualTo("external_pipeline_validation_service_timeout");
            softly.assertThat(value.externalPipelineValidationServiceToken())
                    .isEqualTo("external_pipeline_validation_service_token");
            softly.assertThat(value.externalPipelineValidationServiceUrl())
                    .isEqualTo("external_pipeline_validation_service_url");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSettingsUpdateExternal original = SettingsCatalogFixtures.settingsUpdateExternal();

        final GitLabSettingsUpdateExternal rebuilt =
                GitLabSettingsUpdateExternalBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenExternalPipelineValidationServiceTokenIsACredential() {
        final GitLabSettingsUpdateExternal value = SettingsCatalogFixtures.settingsUpdateExternal();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSettingsUpdateExternal.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "externalAuthClientCert",
                        "externalAuthClientKey",
                        "externalAuthClientKeyPass",
                        "externalAuthorizationServiceDefaultLabel",
                        "externalAuthorizationServiceEnabled",
                        "externalAuthorizationServiceTimeout",
                        "externalAuthorizationServiceUrl",
                        "externalPipelineValidationServiceTimeout",
                        "externalPipelineValidationServiceToken",
                        "externalPipelineValidationServiceUrl");
    }
}

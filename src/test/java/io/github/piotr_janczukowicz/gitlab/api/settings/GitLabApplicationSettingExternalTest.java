package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApplicationSettingExternalTest {

    @Test
    void constructor_shouldAcceptNull_whenExternalPipelineValidationServiceTimeoutIsNullable() {
        final GitLabApplicationSettingExternalBuilder builder = GitLabApplicationSettingExternalBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingExternal())
                .externalPipelineValidationServiceTimeout(null);

        final GitLabApplicationSettingExternal built = builder.build();

        assertThat(built.externalPipelineValidationServiceTimeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalPipelineValidationServiceTokenIsNullable() {
        final GitLabApplicationSettingExternalBuilder builder = GitLabApplicationSettingExternalBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingExternal())
                .externalPipelineValidationServiceToken(null);

        final GitLabApplicationSettingExternal built = builder.build();

        assertThat(built.externalPipelineValidationServiceToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalPipelineValidationServiceUrlIsNullable() {
        final GitLabApplicationSettingExternalBuilder builder = GitLabApplicationSettingExternalBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingExternal())
                .externalPipelineValidationServiceUrl(null);

        final GitLabApplicationSettingExternal built = builder.build();

        assertThat(built.externalPipelineValidationServiceUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalAuthClientCertIsNullable() {
        final GitLabApplicationSettingExternalBuilder builder = GitLabApplicationSettingExternalBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingExternal())
                .externalAuthClientCert(null);

        final GitLabApplicationSettingExternal built = builder.build();

        assertThat(built.externalAuthClientCert()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalAuthClientKeyIsNullable() {
        final GitLabApplicationSettingExternalBuilder builder = GitLabApplicationSettingExternalBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingExternal())
                .externalAuthClientKey(null);

        final GitLabApplicationSettingExternal built = builder.build();

        assertThat(built.externalAuthClientKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalAuthClientKeyPassIsNullable() {
        final GitLabApplicationSettingExternalBuilder builder = GitLabApplicationSettingExternalBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingExternal())
                .externalAuthClientKeyPass(null);

        final GitLabApplicationSettingExternal built = builder.build();

        assertThat(built.externalAuthClientKeyPass()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalAuthorizationServiceDefaultLabelIsNullable() {
        final GitLabApplicationSettingExternalBuilder builder = GitLabApplicationSettingExternalBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingExternal())
                .externalAuthorizationServiceDefaultLabel(null);

        final GitLabApplicationSettingExternal built = builder.build();

        assertThat(built.externalAuthorizationServiceDefaultLabel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalAuthorizationServiceEnabledIsNullable() {
        final GitLabApplicationSettingExternalBuilder builder = GitLabApplicationSettingExternalBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingExternal())
                .externalAuthorizationServiceEnabled(null);

        final GitLabApplicationSettingExternal built = builder.build();

        assertThat(built.externalAuthorizationServiceEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalAuthorizationServiceTimeoutIsNullable() {
        final GitLabApplicationSettingExternalBuilder builder = GitLabApplicationSettingExternalBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingExternal())
                .externalAuthorizationServiceTimeout(null);

        final GitLabApplicationSettingExternal built = builder.build();

        assertThat(built.externalAuthorizationServiceTimeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalAuthorizationServiceUrlIsNullable() {
        final GitLabApplicationSettingExternalBuilder builder = GitLabApplicationSettingExternalBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingExternal())
                .externalAuthorizationServiceUrl(null);

        final GitLabApplicationSettingExternal built = builder.build();

        assertThat(built.externalAuthorizationServiceUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplicationSettingExternal value = SettingsCatalogFixtures.applicationSettingExternal();

        assertSoftly(softly -> {
            softly.assertThat(value.externalPipelineValidationServiceTimeout())
                    .isEqualTo("external_pipeline_validation_service_timeout");
            softly.assertThat(value.externalPipelineValidationServiceToken())
                    .isEqualTo("external_pipeline_validation_service_token");
            softly.assertThat(value.externalPipelineValidationServiceUrl())
                    .isEqualTo("external_pipeline_validation_service_url");
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
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApplicationSettingExternal original = SettingsCatalogFixtures.applicationSettingExternal();

        final GitLabApplicationSettingExternal rebuilt =
                GitLabApplicationSettingExternalBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenExternalPipelineValidationServiceTokenIsACredential() {
        final GitLabApplicationSettingExternal value = SettingsCatalogFixtures.applicationSettingExternal();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApplicationSettingExternal.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "externalPipelineValidationServiceTimeout",
                        "externalPipelineValidationServiceToken",
                        "externalPipelineValidationServiceUrl",
                        "externalAuthClientCert",
                        "externalAuthClientKey",
                        "externalAuthClientKeyPass",
                        "externalAuthorizationServiceDefaultLabel",
                        "externalAuthorizationServiceEnabled",
                        "externalAuthorizationServiceTimeout",
                        "externalAuthorizationServiceUrl");
    }
}

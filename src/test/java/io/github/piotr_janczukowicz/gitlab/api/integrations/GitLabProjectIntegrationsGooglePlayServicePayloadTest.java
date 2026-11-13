package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsGooglePlayServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenPackageNameIsNullable() {
        final GitLabProjectIntegrationsGooglePlayServicePayloadBuilder builder =
                GitLabProjectIntegrationsGooglePlayServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGooglePlayServicePayload())
                        .packageName(null);

        final GitLabProjectIntegrationsGooglePlayServicePayload built = builder.build();

        assertThat(built.packageName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceAccountKeyFileNameIsNullable() {
        final GitLabProjectIntegrationsGooglePlayServicePayloadBuilder builder =
                GitLabProjectIntegrationsGooglePlayServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGooglePlayServicePayload())
                        .serviceAccountKeyFileName(null);

        final GitLabProjectIntegrationsGooglePlayServicePayload built = builder.build();

        assertThat(built.serviceAccountKeyFileName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceAccountKeyIsNullable() {
        final GitLabProjectIntegrationsGooglePlayServicePayloadBuilder builder =
                GitLabProjectIntegrationsGooglePlayServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGooglePlayServicePayload())
                        .serviceAccountKey(null);

        final GitLabProjectIntegrationsGooglePlayServicePayload built = builder.build();

        assertThat(built.serviceAccountKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGooglePlayProtectedRefsIsNullable() {
        final GitLabProjectIntegrationsGooglePlayServicePayloadBuilder builder =
                GitLabProjectIntegrationsGooglePlayServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGooglePlayServicePayload())
                        .googlePlayProtectedRefs(null);

        final GitLabProjectIntegrationsGooglePlayServicePayload built = builder.build();

        assertThat(built.googlePlayProtectedRefs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsGooglePlayServicePayloadBuilder builder =
                GitLabProjectIntegrationsGooglePlayServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGooglePlayServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsGooglePlayServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsGooglePlayServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsGooglePlayServicePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.packageName()).isEqualTo("package_name");
            softly.assertThat(value.serviceAccountKeyFileName()).isEqualTo("service_account_key_file_name");
            softly.assertThat(value.serviceAccountKey()).isEqualTo("service_account_key");
            softly.assertThat(value.googlePlayProtectedRefs()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsGooglePlayServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsGooglePlayServicePayload();

        final GitLabProjectIntegrationsGooglePlayServicePayload rebuilt =
                GitLabProjectIntegrationsGooglePlayServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsGooglePlayServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "packageName",
                        "serviceAccountKeyFileName",
                        "serviceAccountKey",
                        "googlePlayProtectedRefs",
                        "useInheritedSettings");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsGooglePlayPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenPackageNameIsNullable() {
        final GitLabProjectIntegrationsGooglePlayPayloadBuilder builder =
                GitLabProjectIntegrationsGooglePlayPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGooglePlayPayload())
                        .packageName(null);

        final GitLabProjectIntegrationsGooglePlayPayload built = builder.build();

        assertThat(built.packageName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceAccountKeyFileNameIsNullable() {
        final GitLabProjectIntegrationsGooglePlayPayloadBuilder builder =
                GitLabProjectIntegrationsGooglePlayPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGooglePlayPayload())
                        .serviceAccountKeyFileName(null);

        final GitLabProjectIntegrationsGooglePlayPayload built = builder.build();

        assertThat(built.serviceAccountKeyFileName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceAccountKeyIsNullable() {
        final GitLabProjectIntegrationsGooglePlayPayloadBuilder builder =
                GitLabProjectIntegrationsGooglePlayPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGooglePlayPayload())
                        .serviceAccountKey(null);

        final GitLabProjectIntegrationsGooglePlayPayload built = builder.build();

        assertThat(built.serviceAccountKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGooglePlayProtectedRefsIsNullable() {
        final GitLabProjectIntegrationsGooglePlayPayloadBuilder builder =
                GitLabProjectIntegrationsGooglePlayPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGooglePlayPayload())
                        .googlePlayProtectedRefs(null);

        final GitLabProjectIntegrationsGooglePlayPayload built = builder.build();

        assertThat(built.googlePlayProtectedRefs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsGooglePlayPayloadBuilder builder =
                GitLabProjectIntegrationsGooglePlayPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGooglePlayPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsGooglePlayPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsGooglePlayPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsGooglePlayPayload();

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
        final GitLabProjectIntegrationsGooglePlayPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsGooglePlayPayload();

        final GitLabProjectIntegrationsGooglePlayPayload rebuilt =
                GitLabProjectIntegrationsGooglePlayPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsGooglePlayPayload.class.getRecordComponents())
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

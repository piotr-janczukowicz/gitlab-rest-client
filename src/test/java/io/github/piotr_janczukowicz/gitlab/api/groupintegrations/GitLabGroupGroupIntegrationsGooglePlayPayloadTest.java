package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsGooglePlayPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenPackageNameIsNullable() {
        final GitLabGroupGroupIntegrationsGooglePlayPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGooglePlayPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGooglePlayPayload())
                        .packageName(null);

        final GitLabGroupGroupIntegrationsGooglePlayPayload built = builder.build();

        assertThat(built.packageName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceAccountKeyFileNameIsNullable() {
        final GitLabGroupGroupIntegrationsGooglePlayPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGooglePlayPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGooglePlayPayload())
                        .serviceAccountKeyFileName(null);

        final GitLabGroupGroupIntegrationsGooglePlayPayload built = builder.build();

        assertThat(built.serviceAccountKeyFileName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceAccountKeyIsNullable() {
        final GitLabGroupGroupIntegrationsGooglePlayPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGooglePlayPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGooglePlayPayload())
                        .serviceAccountKey(null);

        final GitLabGroupGroupIntegrationsGooglePlayPayload built = builder.build();

        assertThat(built.serviceAccountKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGooglePlayProtectedRefsIsNullable() {
        final GitLabGroupGroupIntegrationsGooglePlayPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGooglePlayPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGooglePlayPayload())
                        .googlePlayProtectedRefs(null);

        final GitLabGroupGroupIntegrationsGooglePlayPayload built = builder.build();

        assertThat(built.googlePlayProtectedRefs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsGooglePlayPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGooglePlayPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGooglePlayPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsGooglePlayPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsGooglePlayPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGooglePlayPayload();

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
        final GitLabGroupGroupIntegrationsGooglePlayPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGooglePlayPayload();

        final GitLabGroupGroupIntegrationsGooglePlayPayload rebuilt =
                GitLabGroupGroupIntegrationsGooglePlayPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsGooglePlayPayload.class.getRecordComponents())
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

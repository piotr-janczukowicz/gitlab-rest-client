package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsAppleAppStorePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenAppStoreIssuerIdIsNullable() {
        final GitLabProjectIntegrationsAppleAppStorePayloadBuilder builder =
                GitLabProjectIntegrationsAppleAppStorePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAppleAppStorePayload())
                        .appStoreIssuerId(null);

        final GitLabProjectIntegrationsAppleAppStorePayload built = builder.build();

        assertThat(built.appStoreIssuerId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppStoreKeyIdIsNullable() {
        final GitLabProjectIntegrationsAppleAppStorePayloadBuilder builder =
                GitLabProjectIntegrationsAppleAppStorePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAppleAppStorePayload())
                        .appStoreKeyId(null);

        final GitLabProjectIntegrationsAppleAppStorePayload built = builder.build();

        assertThat(built.appStoreKeyId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppStorePrivateKeyFileNameIsNullable() {
        final GitLabProjectIntegrationsAppleAppStorePayloadBuilder builder =
                GitLabProjectIntegrationsAppleAppStorePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAppleAppStorePayload())
                        .appStorePrivateKeyFileName(null);

        final GitLabProjectIntegrationsAppleAppStorePayload built = builder.build();

        assertThat(built.appStorePrivateKeyFileName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppStorePrivateKeyIsNullable() {
        final GitLabProjectIntegrationsAppleAppStorePayloadBuilder builder =
                GitLabProjectIntegrationsAppleAppStorePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAppleAppStorePayload())
                        .appStorePrivateKey(null);

        final GitLabProjectIntegrationsAppleAppStorePayload built = builder.build();

        assertThat(built.appStorePrivateKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppStoreProtectedRefsIsNullable() {
        final GitLabProjectIntegrationsAppleAppStorePayloadBuilder builder =
                GitLabProjectIntegrationsAppleAppStorePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAppleAppStorePayload())
                        .appStoreProtectedRefs(null);

        final GitLabProjectIntegrationsAppleAppStorePayload built = builder.build();

        assertThat(built.appStoreProtectedRefs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsAppleAppStorePayloadBuilder builder =
                GitLabProjectIntegrationsAppleAppStorePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAppleAppStorePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsAppleAppStorePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsAppleAppStorePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsAppleAppStorePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.appStoreIssuerId()).isEqualTo("app_store_issuer_id");
            softly.assertThat(value.appStoreKeyId()).isEqualTo("app_store_key_id");
            softly.assertThat(value.appStorePrivateKeyFileName()).isEqualTo("app_store_private_key_file_name");
            softly.assertThat(value.appStorePrivateKey()).isEqualTo("app_store_private_key");
            softly.assertThat(value.appStoreProtectedRefs()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsAppleAppStorePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsAppleAppStorePayload();

        final GitLabProjectIntegrationsAppleAppStorePayload rebuilt =
                GitLabProjectIntegrationsAppleAppStorePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenAppStorePrivateKeyIsACredential() {
        final GitLabProjectIntegrationsAppleAppStorePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsAppleAppStorePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsAppleAppStorePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "appStoreIssuerId",
                        "appStoreKeyId",
                        "appStorePrivateKeyFileName",
                        "appStorePrivateKey",
                        "appStoreProtectedRefs",
                        "useInheritedSettings");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsAppleAppStoreServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenAppStoreIssuerIdIsNullable() {
        final GitLabProjectIntegrationsAppleAppStoreServicePayloadBuilder builder =
                GitLabProjectIntegrationsAppleAppStoreServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAppleAppStoreServicePayload())
                        .appStoreIssuerId(null);

        final GitLabProjectIntegrationsAppleAppStoreServicePayload built = builder.build();

        assertThat(built.appStoreIssuerId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppStoreKeyIdIsNullable() {
        final GitLabProjectIntegrationsAppleAppStoreServicePayloadBuilder builder =
                GitLabProjectIntegrationsAppleAppStoreServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAppleAppStoreServicePayload())
                        .appStoreKeyId(null);

        final GitLabProjectIntegrationsAppleAppStoreServicePayload built = builder.build();

        assertThat(built.appStoreKeyId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppStorePrivateKeyFileNameIsNullable() {
        final GitLabProjectIntegrationsAppleAppStoreServicePayloadBuilder builder =
                GitLabProjectIntegrationsAppleAppStoreServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAppleAppStoreServicePayload())
                        .appStorePrivateKeyFileName(null);

        final GitLabProjectIntegrationsAppleAppStoreServicePayload built = builder.build();

        assertThat(built.appStorePrivateKeyFileName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppStorePrivateKeyIsNullable() {
        final GitLabProjectIntegrationsAppleAppStoreServicePayloadBuilder builder =
                GitLabProjectIntegrationsAppleAppStoreServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAppleAppStoreServicePayload())
                        .appStorePrivateKey(null);

        final GitLabProjectIntegrationsAppleAppStoreServicePayload built = builder.build();

        assertThat(built.appStorePrivateKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppStoreProtectedRefsIsNullable() {
        final GitLabProjectIntegrationsAppleAppStoreServicePayloadBuilder builder =
                GitLabProjectIntegrationsAppleAppStoreServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAppleAppStoreServicePayload())
                        .appStoreProtectedRefs(null);

        final GitLabProjectIntegrationsAppleAppStoreServicePayload built = builder.build();

        assertThat(built.appStoreProtectedRefs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsAppleAppStoreServicePayloadBuilder builder =
                GitLabProjectIntegrationsAppleAppStoreServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAppleAppStoreServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsAppleAppStoreServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsAppleAppStoreServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsAppleAppStoreServicePayload();

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
        final GitLabProjectIntegrationsAppleAppStoreServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsAppleAppStoreServicePayload();

        final GitLabProjectIntegrationsAppleAppStoreServicePayload rebuilt =
                GitLabProjectIntegrationsAppleAppStoreServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenAppStorePrivateKeyIsACredential() {
        final GitLabProjectIntegrationsAppleAppStoreServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsAppleAppStoreServicePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsAppleAppStoreServicePayload.class.getRecordComponents())
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

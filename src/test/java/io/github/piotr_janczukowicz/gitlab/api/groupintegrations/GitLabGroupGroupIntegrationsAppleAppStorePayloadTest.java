package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsAppleAppStorePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenAppStoreIssuerIdIsNullable() {
        final GitLabGroupGroupIntegrationsAppleAppStorePayloadBuilder builder =
                GitLabGroupGroupIntegrationsAppleAppStorePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsAppleAppStorePayload())
                        .appStoreIssuerId(null);

        final GitLabGroupGroupIntegrationsAppleAppStorePayload built = builder.build();

        assertThat(built.appStoreIssuerId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppStoreKeyIdIsNullable() {
        final GitLabGroupGroupIntegrationsAppleAppStorePayloadBuilder builder =
                GitLabGroupGroupIntegrationsAppleAppStorePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsAppleAppStorePayload())
                        .appStoreKeyId(null);

        final GitLabGroupGroupIntegrationsAppleAppStorePayload built = builder.build();

        assertThat(built.appStoreKeyId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppStorePrivateKeyFileNameIsNullable() {
        final GitLabGroupGroupIntegrationsAppleAppStorePayloadBuilder builder =
                GitLabGroupGroupIntegrationsAppleAppStorePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsAppleAppStorePayload())
                        .appStorePrivateKeyFileName(null);

        final GitLabGroupGroupIntegrationsAppleAppStorePayload built = builder.build();

        assertThat(built.appStorePrivateKeyFileName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppStorePrivateKeyIsNullable() {
        final GitLabGroupGroupIntegrationsAppleAppStorePayloadBuilder builder =
                GitLabGroupGroupIntegrationsAppleAppStorePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsAppleAppStorePayload())
                        .appStorePrivateKey(null);

        final GitLabGroupGroupIntegrationsAppleAppStorePayload built = builder.build();

        assertThat(built.appStorePrivateKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppStoreProtectedRefsIsNullable() {
        final GitLabGroupGroupIntegrationsAppleAppStorePayloadBuilder builder =
                GitLabGroupGroupIntegrationsAppleAppStorePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsAppleAppStorePayload())
                        .appStoreProtectedRefs(null);

        final GitLabGroupGroupIntegrationsAppleAppStorePayload built = builder.build();

        assertThat(built.appStoreProtectedRefs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsAppleAppStorePayloadBuilder builder =
                GitLabGroupGroupIntegrationsAppleAppStorePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsAppleAppStorePayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsAppleAppStorePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsAppleAppStorePayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsAppleAppStorePayload();

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
        final GitLabGroupGroupIntegrationsAppleAppStorePayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsAppleAppStorePayload();

        final GitLabGroupGroupIntegrationsAppleAppStorePayload rebuilt =
                GitLabGroupGroupIntegrationsAppleAppStorePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenAppStorePrivateKeyIsACredential() {
        final GitLabGroupGroupIntegrationsAppleAppStorePayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsAppleAppStorePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupIntegrationsAppleAppStorePayload.class.getRecordComponents())
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

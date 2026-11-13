package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsDiffblueCoverPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDiffblueLicenseKeyIsNullable() {
        final GitLabGroupGroupIntegrationsDiffblueCoverPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiffblueCoverPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiffblueCoverPayload())
                        .diffblueLicenseKey(null);

        final GitLabGroupGroupIntegrationsDiffblueCoverPayload built = builder.build();

        assertThat(built.diffblueLicenseKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiffblueAccessTokenNameIsNullable() {
        final GitLabGroupGroupIntegrationsDiffblueCoverPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiffblueCoverPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiffblueCoverPayload())
                        .diffblueAccessTokenName(null);

        final GitLabGroupGroupIntegrationsDiffblueCoverPayload built = builder.build();

        assertThat(built.diffblueAccessTokenName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiffblueAccessTokenSecretIsNullable() {
        final GitLabGroupGroupIntegrationsDiffblueCoverPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiffblueCoverPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiffblueCoverPayload())
                        .diffblueAccessTokenSecret(null);

        final GitLabGroupGroupIntegrationsDiffblueCoverPayload built = builder.build();

        assertThat(built.diffblueAccessTokenSecret()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsDiffblueCoverPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiffblueCoverPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiffblueCoverPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsDiffblueCoverPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsDiffblueCoverPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiffblueCoverPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.diffblueLicenseKey()).isEqualTo("diffblue_license_key");
            softly.assertThat(value.diffblueAccessTokenName()).isEqualTo("diffblue_access_token_name");
            softly.assertThat(value.diffblueAccessTokenSecret()).isEqualTo("diffblue_access_token_secret");
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsDiffblueCoverPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiffblueCoverPayload();

        final GitLabGroupGroupIntegrationsDiffblueCoverPayload rebuilt =
                GitLabGroupGroupIntegrationsDiffblueCoverPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenDiffblueAccessTokenSecretIsACredential() {
        final GitLabGroupGroupIntegrationsDiffblueCoverPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiffblueCoverPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupIntegrationsDiffblueCoverPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "diffblueLicenseKey",
                        "diffblueAccessTokenName",
                        "diffblueAccessTokenSecret",
                        "useInheritedSettings");
    }
}

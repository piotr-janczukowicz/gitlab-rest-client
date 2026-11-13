package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsDiffblueCoverPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDiffblueLicenseKeyIsNullable() {
        final GitLabProjectIntegrationsDiffblueCoverPayloadBuilder builder =
                GitLabProjectIntegrationsDiffblueCoverPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiffblueCoverPayload())
                        .diffblueLicenseKey(null);

        final GitLabProjectIntegrationsDiffblueCoverPayload built = builder.build();

        assertThat(built.diffblueLicenseKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiffblueAccessTokenNameIsNullable() {
        final GitLabProjectIntegrationsDiffblueCoverPayloadBuilder builder =
                GitLabProjectIntegrationsDiffblueCoverPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiffblueCoverPayload())
                        .diffblueAccessTokenName(null);

        final GitLabProjectIntegrationsDiffblueCoverPayload built = builder.build();

        assertThat(built.diffblueAccessTokenName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiffblueAccessTokenSecretIsNullable() {
        final GitLabProjectIntegrationsDiffblueCoverPayloadBuilder builder =
                GitLabProjectIntegrationsDiffblueCoverPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiffblueCoverPayload())
                        .diffblueAccessTokenSecret(null);

        final GitLabProjectIntegrationsDiffblueCoverPayload built = builder.build();

        assertThat(built.diffblueAccessTokenSecret()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsDiffblueCoverPayloadBuilder builder =
                GitLabProjectIntegrationsDiffblueCoverPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiffblueCoverPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsDiffblueCoverPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsDiffblueCoverPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsDiffblueCoverPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.diffblueLicenseKey()).isEqualTo("diffblue_license_key");
            softly.assertThat(value.diffblueAccessTokenName()).isEqualTo("diffblue_access_token_name");
            softly.assertThat(value.diffblueAccessTokenSecret()).isEqualTo("diffblue_access_token_secret");
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsDiffblueCoverPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsDiffblueCoverPayload();

        final GitLabProjectIntegrationsDiffblueCoverPayload rebuilt =
                GitLabProjectIntegrationsDiffblueCoverPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenDiffblueAccessTokenSecretIsACredential() {
        final GitLabProjectIntegrationsDiffblueCoverPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsDiffblueCoverPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsDiffblueCoverPayload.class.getRecordComponents())
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

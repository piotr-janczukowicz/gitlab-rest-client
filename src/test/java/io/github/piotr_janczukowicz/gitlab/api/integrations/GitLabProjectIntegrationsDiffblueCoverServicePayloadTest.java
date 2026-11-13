package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsDiffblueCoverServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDiffblueLicenseKeyIsNullable() {
        final GitLabProjectIntegrationsDiffblueCoverServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiffblueCoverServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiffblueCoverServicePayload())
                        .diffblueLicenseKey(null);

        final GitLabProjectIntegrationsDiffblueCoverServicePayload built = builder.build();

        assertThat(built.diffblueLicenseKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiffblueAccessTokenNameIsNullable() {
        final GitLabProjectIntegrationsDiffblueCoverServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiffblueCoverServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiffblueCoverServicePayload())
                        .diffblueAccessTokenName(null);

        final GitLabProjectIntegrationsDiffblueCoverServicePayload built = builder.build();

        assertThat(built.diffblueAccessTokenName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiffblueAccessTokenSecretIsNullable() {
        final GitLabProjectIntegrationsDiffblueCoverServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiffblueCoverServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiffblueCoverServicePayload())
                        .diffblueAccessTokenSecret(null);

        final GitLabProjectIntegrationsDiffblueCoverServicePayload built = builder.build();

        assertThat(built.diffblueAccessTokenSecret()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsDiffblueCoverServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiffblueCoverServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiffblueCoverServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsDiffblueCoverServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsDiffblueCoverServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsDiffblueCoverServicePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.diffblueLicenseKey()).isEqualTo("diffblue_license_key");
            softly.assertThat(value.diffblueAccessTokenName()).isEqualTo("diffblue_access_token_name");
            softly.assertThat(value.diffblueAccessTokenSecret()).isEqualTo("diffblue_access_token_secret");
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsDiffblueCoverServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsDiffblueCoverServicePayload();

        final GitLabProjectIntegrationsDiffblueCoverServicePayload rebuilt =
                GitLabProjectIntegrationsDiffblueCoverServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenDiffblueAccessTokenSecretIsACredential() {
        final GitLabProjectIntegrationsDiffblueCoverServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsDiffblueCoverServicePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsDiffblueCoverServicePayload.class.getRecordComponents())
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

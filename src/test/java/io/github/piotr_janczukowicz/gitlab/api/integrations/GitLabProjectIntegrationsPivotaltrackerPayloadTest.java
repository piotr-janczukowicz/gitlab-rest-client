package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsPivotaltrackerPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsPivotaltrackerPayloadBuilder builder =
                GitLabProjectIntegrationsPivotaltrackerPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPivotaltrackerPayload())
                        .token(null);

        final GitLabProjectIntegrationsPivotaltrackerPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRestrictToBranchIsNullable() {
        final GitLabProjectIntegrationsPivotaltrackerPayloadBuilder builder =
                GitLabProjectIntegrationsPivotaltrackerPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPivotaltrackerPayload())
                        .restrictToBranch(null);

        final GitLabProjectIntegrationsPivotaltrackerPayload built = builder.build();

        assertThat(built.restrictToBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsPivotaltrackerPayloadBuilder builder =
                GitLabProjectIntegrationsPivotaltrackerPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPivotaltrackerPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsPivotaltrackerPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsPivotaltrackerPayloadBuilder builder =
                GitLabProjectIntegrationsPivotaltrackerPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPivotaltrackerPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsPivotaltrackerPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsPivotaltrackerPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsPivotaltrackerPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.restrictToBranch()).isEqualTo("restrict_to_branch");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsPivotaltrackerPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsPivotaltrackerPayload();

        final GitLabProjectIntegrationsPivotaltrackerPayload rebuilt =
                GitLabProjectIntegrationsPivotaltrackerPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsPivotaltrackerPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsPivotaltrackerPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsPivotaltrackerPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("token", "restrictToBranch", "pushEvents", "useInheritedSettings");
    }
}

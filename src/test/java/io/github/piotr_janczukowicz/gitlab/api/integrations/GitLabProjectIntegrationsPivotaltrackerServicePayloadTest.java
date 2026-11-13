package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsPivotaltrackerServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsPivotaltrackerServicePayloadBuilder builder =
                GitLabProjectIntegrationsPivotaltrackerServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPivotaltrackerServicePayload())
                        .token(null);

        final GitLabProjectIntegrationsPivotaltrackerServicePayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRestrictToBranchIsNullable() {
        final GitLabProjectIntegrationsPivotaltrackerServicePayloadBuilder builder =
                GitLabProjectIntegrationsPivotaltrackerServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPivotaltrackerServicePayload())
                        .restrictToBranch(null);

        final GitLabProjectIntegrationsPivotaltrackerServicePayload built = builder.build();

        assertThat(built.restrictToBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsPivotaltrackerServicePayloadBuilder builder =
                GitLabProjectIntegrationsPivotaltrackerServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPivotaltrackerServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsPivotaltrackerServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsPivotaltrackerServicePayloadBuilder builder =
                GitLabProjectIntegrationsPivotaltrackerServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPivotaltrackerServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsPivotaltrackerServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsPivotaltrackerServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsPivotaltrackerServicePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.restrictToBranch()).isEqualTo("restrict_to_branch");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsPivotaltrackerServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsPivotaltrackerServicePayload();

        final GitLabProjectIntegrationsPivotaltrackerServicePayload rebuilt =
                GitLabProjectIntegrationsPivotaltrackerServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsPivotaltrackerServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsPivotaltrackerServicePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsPivotaltrackerServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("token", "restrictToBranch", "pushEvents", "useInheritedSettings");
    }
}

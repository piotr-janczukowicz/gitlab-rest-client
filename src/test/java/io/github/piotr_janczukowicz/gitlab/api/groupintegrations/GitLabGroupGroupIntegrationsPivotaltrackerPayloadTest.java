package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsPivotaltrackerPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabGroupGroupIntegrationsPivotaltrackerPayloadBuilder builder =
                GitLabGroupGroupIntegrationsPivotaltrackerPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPivotaltrackerPayload())
                        .token(null);

        final GitLabGroupGroupIntegrationsPivotaltrackerPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRestrictToBranchIsNullable() {
        final GitLabGroupGroupIntegrationsPivotaltrackerPayloadBuilder builder =
                GitLabGroupGroupIntegrationsPivotaltrackerPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPivotaltrackerPayload())
                        .restrictToBranch(null);

        final GitLabGroupGroupIntegrationsPivotaltrackerPayload built = builder.build();

        assertThat(built.restrictToBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsPivotaltrackerPayloadBuilder builder =
                GitLabGroupGroupIntegrationsPivotaltrackerPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPivotaltrackerPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsPivotaltrackerPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsPivotaltrackerPayloadBuilder builder =
                GitLabGroupGroupIntegrationsPivotaltrackerPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPivotaltrackerPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsPivotaltrackerPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsPivotaltrackerPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPivotaltrackerPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.restrictToBranch()).isEqualTo("restrict_to_branch");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsPivotaltrackerPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPivotaltrackerPayload();

        final GitLabGroupGroupIntegrationsPivotaltrackerPayload rebuilt =
                GitLabGroupGroupIntegrationsPivotaltrackerPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabGroupGroupIntegrationsPivotaltrackerPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPivotaltrackerPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupIntegrationsPivotaltrackerPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("token", "restrictToBranch", "pushEvents", "useInheritedSettings");
    }
}

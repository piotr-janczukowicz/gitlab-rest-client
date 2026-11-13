package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsAsanaPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenApiKeyIsNullable() {
        final GitLabGroupGroupIntegrationsAsanaPayloadBuilder builder =
                GitLabGroupGroupIntegrationsAsanaPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsAsanaPayload())
                        .apiKey(null);

        final GitLabGroupGroupIntegrationsAsanaPayload built = builder.build();

        assertThat(built.apiKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRestrictToBranchIsNullable() {
        final GitLabGroupGroupIntegrationsAsanaPayloadBuilder builder =
                GitLabGroupGroupIntegrationsAsanaPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsAsanaPayload())
                        .restrictToBranch(null);

        final GitLabGroupGroupIntegrationsAsanaPayload built = builder.build();

        assertThat(built.restrictToBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsAsanaPayloadBuilder builder =
                GitLabGroupGroupIntegrationsAsanaPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsAsanaPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsAsanaPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsAsanaPayloadBuilder builder =
                GitLabGroupGroupIntegrationsAsanaPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsAsanaPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsAsanaPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsAsanaPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsAsanaPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.apiKey()).isEqualTo("api_key");
            softly.assertThat(value.restrictToBranch()).isEqualTo("restrict_to_branch");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsAsanaPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsAsanaPayload();

        final GitLabGroupGroupIntegrationsAsanaPayload rebuilt =
                GitLabGroupGroupIntegrationsAsanaPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsAsanaPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("apiKey", "restrictToBranch", "pushEvents", "useInheritedSettings");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsClickupPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectUrlIsNullable() {
        final GitLabGroupGroupIntegrationsClickupPayloadBuilder builder =
                GitLabGroupGroupIntegrationsClickupPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsClickupPayload())
                        .projectUrl(null);

        final GitLabGroupGroupIntegrationsClickupPayload built = builder.build();

        assertThat(built.projectUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesUrlIsNullable() {
        final GitLabGroupGroupIntegrationsClickupPayloadBuilder builder =
                GitLabGroupGroupIntegrationsClickupPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsClickupPayload())
                        .issuesUrl(null);

        final GitLabGroupGroupIntegrationsClickupPayload built = builder.build();

        assertThat(built.issuesUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsClickupPayloadBuilder builder =
                GitLabGroupGroupIntegrationsClickupPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsClickupPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsClickupPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsClickupPayloadBuilder builder =
                GitLabGroupGroupIntegrationsClickupPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsClickupPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsClickupPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsClickupPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsClickupPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.projectUrl()).isEqualTo("project_url");
            softly.assertThat(value.issuesUrl()).isEqualTo("issues_url");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsClickupPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsClickupPayload();

        final GitLabGroupGroupIntegrationsClickupPayload rebuilt =
                GitLabGroupGroupIntegrationsClickupPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsClickupPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("projectUrl", "issuesUrl", "pushEvents", "useInheritedSettings");
    }
}

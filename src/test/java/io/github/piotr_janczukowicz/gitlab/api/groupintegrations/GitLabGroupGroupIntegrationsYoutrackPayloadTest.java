package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsYoutrackPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectUrlIsNullable() {
        final GitLabGroupGroupIntegrationsYoutrackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsYoutrackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsYoutrackPayload())
                        .projectUrl(null);

        final GitLabGroupGroupIntegrationsYoutrackPayload built = builder.build();

        assertThat(built.projectUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesUrlIsNullable() {
        final GitLabGroupGroupIntegrationsYoutrackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsYoutrackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsYoutrackPayload())
                        .issuesUrl(null);

        final GitLabGroupGroupIntegrationsYoutrackPayload built = builder.build();

        assertThat(built.issuesUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsYoutrackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsYoutrackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsYoutrackPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsYoutrackPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsYoutrackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsYoutrackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsYoutrackPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsYoutrackPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsYoutrackPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsYoutrackPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.projectUrl()).isEqualTo("project_url");
            softly.assertThat(value.issuesUrl()).isEqualTo("issues_url");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsYoutrackPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsYoutrackPayload();

        final GitLabGroupGroupIntegrationsYoutrackPayload rebuilt =
                GitLabGroupGroupIntegrationsYoutrackPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsYoutrackPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("projectUrl", "issuesUrl", "pushEvents", "useInheritedSettings");
    }
}

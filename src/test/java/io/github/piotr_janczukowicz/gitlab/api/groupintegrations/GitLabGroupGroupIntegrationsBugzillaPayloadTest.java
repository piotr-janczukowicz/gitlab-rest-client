package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsBugzillaPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectUrlIsNullable() {
        final GitLabGroupGroupIntegrationsBugzillaPayloadBuilder builder =
                GitLabGroupGroupIntegrationsBugzillaPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBugzillaPayload())
                        .projectUrl(null);

        final GitLabGroupGroupIntegrationsBugzillaPayload built = builder.build();

        assertThat(built.projectUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesUrlIsNullable() {
        final GitLabGroupGroupIntegrationsBugzillaPayloadBuilder builder =
                GitLabGroupGroupIntegrationsBugzillaPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBugzillaPayload())
                        .issuesUrl(null);

        final GitLabGroupGroupIntegrationsBugzillaPayload built = builder.build();

        assertThat(built.issuesUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewIssueUrlIsNullable() {
        final GitLabGroupGroupIntegrationsBugzillaPayloadBuilder builder =
                GitLabGroupGroupIntegrationsBugzillaPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBugzillaPayload())
                        .newIssueUrl(null);

        final GitLabGroupGroupIntegrationsBugzillaPayload built = builder.build();

        assertThat(built.newIssueUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsBugzillaPayloadBuilder builder =
                GitLabGroupGroupIntegrationsBugzillaPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBugzillaPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsBugzillaPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsBugzillaPayloadBuilder builder =
                GitLabGroupGroupIntegrationsBugzillaPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBugzillaPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsBugzillaPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsBugzillaPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBugzillaPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.projectUrl()).isEqualTo("project_url");
            softly.assertThat(value.issuesUrl()).isEqualTo("issues_url");
            softly.assertThat(value.newIssueUrl()).isEqualTo("new_issue_url");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsBugzillaPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBugzillaPayload();

        final GitLabGroupGroupIntegrationsBugzillaPayload rebuilt =
                GitLabGroupGroupIntegrationsBugzillaPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsBugzillaPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("projectUrl", "issuesUrl", "newIssueUrl", "pushEvents", "useInheritedSettings");
    }
}

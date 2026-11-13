package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsRedminePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectUrlIsNullable() {
        final GitLabGroupGroupIntegrationsRedminePayloadBuilder builder =
                GitLabGroupGroupIntegrationsRedminePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsRedminePayload())
                        .projectUrl(null);

        final GitLabGroupGroupIntegrationsRedminePayload built = builder.build();

        assertThat(built.projectUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesUrlIsNullable() {
        final GitLabGroupGroupIntegrationsRedminePayloadBuilder builder =
                GitLabGroupGroupIntegrationsRedminePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsRedminePayload())
                        .issuesUrl(null);

        final GitLabGroupGroupIntegrationsRedminePayload built = builder.build();

        assertThat(built.issuesUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewIssueUrlIsNullable() {
        final GitLabGroupGroupIntegrationsRedminePayloadBuilder builder =
                GitLabGroupGroupIntegrationsRedminePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsRedminePayload())
                        .newIssueUrl(null);

        final GitLabGroupGroupIntegrationsRedminePayload built = builder.build();

        assertThat(built.newIssueUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsRedminePayloadBuilder builder =
                GitLabGroupGroupIntegrationsRedminePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsRedminePayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsRedminePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsRedminePayloadBuilder builder =
                GitLabGroupGroupIntegrationsRedminePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsRedminePayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsRedminePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsRedminePayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsRedminePayload();

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
        final GitLabGroupGroupIntegrationsRedminePayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsRedminePayload();

        final GitLabGroupGroupIntegrationsRedminePayload rebuilt =
                GitLabGroupGroupIntegrationsRedminePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsRedminePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("projectUrl", "issuesUrl", "newIssueUrl", "pushEvents", "useInheritedSettings");
    }
}

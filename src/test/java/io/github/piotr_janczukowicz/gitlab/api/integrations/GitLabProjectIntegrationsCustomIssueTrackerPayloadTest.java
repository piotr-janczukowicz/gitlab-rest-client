package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsCustomIssueTrackerPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectUrlIsNullable() {
        final GitLabProjectIntegrationsCustomIssueTrackerPayloadBuilder builder =
                GitLabProjectIntegrationsCustomIssueTrackerPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCustomIssueTrackerPayload())
                        .projectUrl(null);

        final GitLabProjectIntegrationsCustomIssueTrackerPayload built = builder.build();

        assertThat(built.projectUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesUrlIsNullable() {
        final GitLabProjectIntegrationsCustomIssueTrackerPayloadBuilder builder =
                GitLabProjectIntegrationsCustomIssueTrackerPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCustomIssueTrackerPayload())
                        .issuesUrl(null);

        final GitLabProjectIntegrationsCustomIssueTrackerPayload built = builder.build();

        assertThat(built.issuesUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewIssueUrlIsNullable() {
        final GitLabProjectIntegrationsCustomIssueTrackerPayloadBuilder builder =
                GitLabProjectIntegrationsCustomIssueTrackerPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCustomIssueTrackerPayload())
                        .newIssueUrl(null);

        final GitLabProjectIntegrationsCustomIssueTrackerPayload built = builder.build();

        assertThat(built.newIssueUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsCustomIssueTrackerPayloadBuilder builder =
                GitLabProjectIntegrationsCustomIssueTrackerPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCustomIssueTrackerPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsCustomIssueTrackerPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsCustomIssueTrackerPayloadBuilder builder =
                GitLabProjectIntegrationsCustomIssueTrackerPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCustomIssueTrackerPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsCustomIssueTrackerPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsCustomIssueTrackerPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsCustomIssueTrackerPayload();

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
        final GitLabProjectIntegrationsCustomIssueTrackerPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsCustomIssueTrackerPayload();

        final GitLabProjectIntegrationsCustomIssueTrackerPayload rebuilt =
                GitLabProjectIntegrationsCustomIssueTrackerPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsCustomIssueTrackerPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("projectUrl", "issuesUrl", "newIssueUrl", "pushEvents", "useInheritedSettings");
    }
}

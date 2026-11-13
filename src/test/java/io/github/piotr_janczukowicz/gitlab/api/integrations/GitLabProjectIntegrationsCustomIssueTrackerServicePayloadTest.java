package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsCustomIssueTrackerServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectUrlIsNullable() {
        final GitLabProjectIntegrationsCustomIssueTrackerServicePayloadBuilder builder =
                GitLabProjectIntegrationsCustomIssueTrackerServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCustomIssueTrackerServicePayload())
                        .projectUrl(null);

        final GitLabProjectIntegrationsCustomIssueTrackerServicePayload built = builder.build();

        assertThat(built.projectUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesUrlIsNullable() {
        final GitLabProjectIntegrationsCustomIssueTrackerServicePayloadBuilder builder =
                GitLabProjectIntegrationsCustomIssueTrackerServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCustomIssueTrackerServicePayload())
                        .issuesUrl(null);

        final GitLabProjectIntegrationsCustomIssueTrackerServicePayload built = builder.build();

        assertThat(built.issuesUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewIssueUrlIsNullable() {
        final GitLabProjectIntegrationsCustomIssueTrackerServicePayloadBuilder builder =
                GitLabProjectIntegrationsCustomIssueTrackerServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCustomIssueTrackerServicePayload())
                        .newIssueUrl(null);

        final GitLabProjectIntegrationsCustomIssueTrackerServicePayload built = builder.build();

        assertThat(built.newIssueUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsCustomIssueTrackerServicePayloadBuilder builder =
                GitLabProjectIntegrationsCustomIssueTrackerServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCustomIssueTrackerServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsCustomIssueTrackerServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsCustomIssueTrackerServicePayloadBuilder builder =
                GitLabProjectIntegrationsCustomIssueTrackerServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCustomIssueTrackerServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsCustomIssueTrackerServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsCustomIssueTrackerServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsCustomIssueTrackerServicePayload();

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
        final GitLabProjectIntegrationsCustomIssueTrackerServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsCustomIssueTrackerServicePayload();

        final GitLabProjectIntegrationsCustomIssueTrackerServicePayload rebuilt =
                GitLabProjectIntegrationsCustomIssueTrackerServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsCustomIssueTrackerServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("projectUrl", "issuesUrl", "newIssueUrl", "pushEvents", "useInheritedSettings");
    }
}

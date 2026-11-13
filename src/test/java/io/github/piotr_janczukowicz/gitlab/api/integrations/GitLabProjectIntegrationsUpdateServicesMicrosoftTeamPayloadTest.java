package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWebhookIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMicrosoftTeamPayload())
                        .webhook(null);

        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayload built = builder.build();

        assertThat(built.webhook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMicrosoftTeamPayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMicrosoftTeamPayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMicrosoftTeamPayload())
                        .branchesToBeNotified(null);

        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMicrosoftTeamPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMicrosoftTeamPayload())
                        .issuesEvents(null);

        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMicrosoftTeamPayload())
                        .confidentialIssuesEvents(null);

        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMicrosoftTeamPayload())
                        .workItemEvents(null);

        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMicrosoftTeamPayload())
                        .confidentialWorkItemEvents(null);

        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMicrosoftTeamPayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMicrosoftTeamPayload())
                        .noteEvents(null);

        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMicrosoftTeamPayload())
                        .confidentialNoteEvents(null);

        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMicrosoftTeamPayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMicrosoftTeamPayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMicrosoftTeamPayload())
                        .wikiPageEvents(null);

        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMicrosoftTeamPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMicrosoftTeamPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.webhook()).isEqualTo("webhook");
            softly.assertThat(value.notifyOnlyBrokenPipelines()).isEqualTo(true);
            softly.assertThat(value.notifyOnlyWhenPipelineStatusChanges()).isEqualTo(true);
            softly.assertThat(value.branchesToBeNotified()).isEqualTo("branches_to_be_notified");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.issuesEvents()).isEqualTo(true);
            softly.assertThat(value.confidentialIssuesEvents()).isEqualTo(true);
            softly.assertThat(value.workItemEvents()).isEqualTo(true);
            softly.assertThat(value.confidentialWorkItemEvents()).isEqualTo(true);
            softly.assertThat(value.mergeRequestsEvents()).isEqualTo(true);
            softly.assertThat(value.noteEvents()).isEqualTo(true);
            softly.assertThat(value.confidentialNoteEvents()).isEqualTo(true);
            softly.assertThat(value.tagPushEvents()).isEqualTo(true);
            softly.assertThat(value.pipelineEvents()).isEqualTo(true);
            softly.assertThat(value.wikiPageEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMicrosoftTeamPayload();

        final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayload rebuilt =
                GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "webhook",
                        "notifyOnlyBrokenPipelines",
                        "notifyOnlyWhenPipelineStatusChanges",
                        "branchesToBeNotified",
                        "pushEvents",
                        "issuesEvents",
                        "confidentialIssuesEvents",
                        "workItemEvents",
                        "confidentialWorkItemEvents",
                        "mergeRequestsEvents",
                        "noteEvents",
                        "confidentialNoteEvents",
                        "tagPushEvents",
                        "pipelineEvents",
                        "wikiPageEvents",
                        "useInheritedSettings");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsDiscordPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWebhookIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .webhook(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.webhook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .branchesToBeNotified(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushChannelIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .pushChannel(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.pushChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueChannelIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .issueChannel(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.issueChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentChannelIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .incidentChannel(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.incidentChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertChannelIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .alertChannel(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.alertChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssueChannelIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .confidentialIssueChannel(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.confidentialIssueChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestChannelIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .mergeRequestChannel(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.mergeRequestChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteChannelIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .noteChannel(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.noteChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteChannelIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .confidentialNoteChannel(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.confidentialNoteChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushChannelIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .tagPushChannel(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.tagPushChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentChannelIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .deploymentChannel(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.deploymentChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineChannelIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .pipelineChannel(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.pipelineChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageChannelIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .wikiPageChannel(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.wikiPageChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityChannelIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .vulnerabilityChannel(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.vulnerabilityChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .issuesEvents(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .confidentialIssuesEvents(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .workItemEvents(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .confidentialWorkItemEvents(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .mergeRequestsEvents(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .noteEvents(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .confidentialNoteEvents(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .tagPushEvents(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .pipelineEvents(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .wikiPageEvents(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentEventsIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .deploymentEvents(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.deploymentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsDiscordPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsDiscordPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsDiscordPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.webhook()).isEqualTo("webhook");
            softly.assertThat(value.notifyOnlyBrokenPipelines()).isEqualTo(true);
            softly.assertThat(value.notifyOnlyWhenPipelineStatusChanges()).isEqualTo(true);
            softly.assertThat(value.branchesToBeNotified()).isEqualTo("branches_to_be_notified");
            softly.assertThat(value.pushChannel()).isEqualTo("push_channel");
            softly.assertThat(value.issueChannel()).isEqualTo("issue_channel");
            softly.assertThat(value.incidentChannel()).isEqualTo("incident_channel");
            softly.assertThat(value.alertChannel()).isEqualTo("alert_channel");
            softly.assertThat(value.confidentialIssueChannel()).isEqualTo("confidential_issue_channel");
            softly.assertThat(value.mergeRequestChannel()).isEqualTo("merge_request_channel");
            softly.assertThat(value.noteChannel()).isEqualTo("note_channel");
            softly.assertThat(value.confidentialNoteChannel()).isEqualTo("confidential_note_channel");
            softly.assertThat(value.tagPushChannel()).isEqualTo("tag_push_channel");
            softly.assertThat(value.deploymentChannel()).isEqualTo("deployment_channel");
            softly.assertThat(value.pipelineChannel()).isEqualTo("pipeline_channel");
            softly.assertThat(value.wikiPageChannel()).isEqualTo("wiki_page_channel");
            softly.assertThat(value.vulnerabilityChannel()).isEqualTo("vulnerability_channel");
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
            softly.assertThat(value.deploymentEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsDiscordPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload();

        final GitLabGroupGroupIntegrationsDiscordPayload rebuilt =
                GitLabGroupGroupIntegrationsDiscordPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsDiscordPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "webhook",
                        "notifyOnlyBrokenPipelines",
                        "notifyOnlyWhenPipelineStatusChanges",
                        "branchesToBeNotified",
                        "pushChannel",
                        "issueChannel",
                        "incidentChannel",
                        "alertChannel",
                        "confidentialIssueChannel",
                        "mergeRequestChannel",
                        "noteChannel",
                        "confidentialNoteChannel",
                        "tagPushChannel",
                        "deploymentChannel",
                        "pipelineChannel",
                        "wikiPageChannel",
                        "vulnerabilityChannel",
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
                        "deploymentEvents",
                        "useInheritedSettings");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsSlackPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWebhookIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .webhook(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.webhook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .username(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChannelIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .channel(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.channel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .branchesToBeNotified(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsToBeNotifiedIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .labelsToBeNotified(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.labelsToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsToBeNotifiedBehaviorIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .labelsToBeNotifiedBehavior(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.labelsToBeNotifiedBehavior()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushChannelIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .pushChannel(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.pushChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueChannelIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .issueChannel(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.issueChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentChannelIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .incidentChannel(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.incidentChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertChannelIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .alertChannel(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.alertChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssueChannelIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .confidentialIssueChannel(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.confidentialIssueChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestChannelIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .mergeRequestChannel(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.mergeRequestChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteChannelIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .noteChannel(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.noteChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteChannelIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .confidentialNoteChannel(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.confidentialNoteChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushChannelIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .tagPushChannel(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.tagPushChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentChannelIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .deploymentChannel(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.deploymentChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineChannelIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .pipelineChannel(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.pipelineChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageChannelIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .wikiPageChannel(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.wikiPageChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityChannelIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .vulnerabilityChannel(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.vulnerabilityChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .issuesEvents(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .confidentialIssuesEvents(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .mergeRequestsEvents(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .noteEvents(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .confidentialNoteEvents(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .tagPushEvents(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .pipelineEvents(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .wikiPageEvents(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentEventsIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .deploymentEvents(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.deploymentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentEventsIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .incidentEvents(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.incidentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .workItemEvents(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .confidentialWorkItemEvents(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityEventsIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .vulnerabilityEvents(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.vulnerabilityEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertEventsIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .alertEvents(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.alertEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsSlackPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsSlackPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsSlackPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.webhook()).isEqualTo("webhook");
            softly.assertThat(value.username()).isEqualTo("username");
            softly.assertThat(value.channel()).isEqualTo("channel");
            softly.assertThat(value.notifyOnlyBrokenPipelines()).isEqualTo(true);
            softly.assertThat(value.notifyOnlyWhenPipelineStatusChanges()).isEqualTo(true);
            softly.assertThat(value.branchesToBeNotified()).isEqualTo("branches_to_be_notified");
            softly.assertThat(value.labelsToBeNotified()).isEqualTo("labels_to_be_notified");
            softly.assertThat(value.labelsToBeNotifiedBehavior()).isEqualTo("labels_to_be_notified_behavior");
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
            softly.assertThat(value.mergeRequestsEvents()).isEqualTo(true);
            softly.assertThat(value.noteEvents()).isEqualTo(true);
            softly.assertThat(value.confidentialNoteEvents()).isEqualTo(true);
            softly.assertThat(value.tagPushEvents()).isEqualTo(true);
            softly.assertThat(value.pipelineEvents()).isEqualTo(true);
            softly.assertThat(value.wikiPageEvents()).isEqualTo(true);
            softly.assertThat(value.deploymentEvents()).isEqualTo(true);
            softly.assertThat(value.incidentEvents()).isEqualTo(true);
            softly.assertThat(value.workItemEvents()).isEqualTo(true);
            softly.assertThat(value.confidentialWorkItemEvents()).isEqualTo(true);
            softly.assertThat(value.vulnerabilityEvents()).isEqualTo(true);
            softly.assertThat(value.alertEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsSlackPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload();

        final GitLabGroupGroupIntegrationsSlackPayload rebuilt =
                GitLabGroupGroupIntegrationsSlackPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsSlackPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "webhook",
                        "username",
                        "channel",
                        "notifyOnlyBrokenPipelines",
                        "notifyOnlyWhenPipelineStatusChanges",
                        "branchesToBeNotified",
                        "labelsToBeNotified",
                        "labelsToBeNotifiedBehavior",
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
                        "mergeRequestsEvents",
                        "noteEvents",
                        "confidentialNoteEvents",
                        "tagPushEvents",
                        "pipelineEvents",
                        "wikiPageEvents",
                        "deploymentEvents",
                        "incidentEvents",
                        "workItemEvents",
                        "confidentialWorkItemEvents",
                        "vulnerabilityEvents",
                        "alertEvents",
                        "useInheritedSettings");
    }
}

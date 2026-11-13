package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsMattermostPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWebhookIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .webhook(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.webhook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .username(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChannelIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .channel(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.channel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .branchesToBeNotified(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsToBeNotifiedIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .labelsToBeNotified(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.labelsToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsToBeNotifiedBehaviorIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .labelsToBeNotifiedBehavior(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.labelsToBeNotifiedBehavior()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushChannelIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .pushChannel(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.pushChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueChannelIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .issueChannel(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.issueChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentChannelIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .incidentChannel(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.incidentChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertChannelIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .alertChannel(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.alertChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssueChannelIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .confidentialIssueChannel(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.confidentialIssueChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestChannelIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .mergeRequestChannel(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.mergeRequestChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteChannelIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .noteChannel(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.noteChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteChannelIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .confidentialNoteChannel(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.confidentialNoteChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushChannelIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .tagPushChannel(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.tagPushChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentChannelIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .deploymentChannel(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.deploymentChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineChannelIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .pipelineChannel(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.pipelineChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageChannelIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .wikiPageChannel(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.wikiPageChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityChannelIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .vulnerabilityChannel(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.vulnerabilityChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .issuesEvents(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .confidentialIssuesEvents(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .mergeRequestsEvents(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .noteEvents(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .confidentialNoteEvents(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .tagPushEvents(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .pipelineEvents(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .wikiPageEvents(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .deploymentEvents(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.deploymentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .incidentEvents(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.incidentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .workItemEvents(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .confidentialWorkItemEvents(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .vulnerabilityEvents(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.vulnerabilityEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsMattermostPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsMattermostPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsMattermostPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload();

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
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsMattermostPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload();

        final GitLabGroupGroupIntegrationsMattermostPayload rebuilt =
                GitLabGroupGroupIntegrationsMattermostPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsMattermostPayload.class.getRecordComponents())
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
                        "useInheritedSettings");
    }
}

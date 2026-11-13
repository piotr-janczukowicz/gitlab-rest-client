package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenChannelIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .channel(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.channel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .branchesToBeNotified(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsToBeNotifiedIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .labelsToBeNotified(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.labelsToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsToBeNotifiedBehaviorIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .labelsToBeNotifiedBehavior(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.labelsToBeNotifiedBehavior()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushChannelIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .pushChannel(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.pushChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueChannelIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .issueChannel(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.issueChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentChannelIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .incidentChannel(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.incidentChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertChannelIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .alertChannel(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.alertChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssueChannelIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .confidentialIssueChannel(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.confidentialIssueChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestChannelIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .mergeRequestChannel(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.mergeRequestChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteChannelIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .noteChannel(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.noteChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteChannelIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .confidentialNoteChannel(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.confidentialNoteChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushChannelIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .tagPushChannel(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.tagPushChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentChannelIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .deploymentChannel(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.deploymentChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineChannelIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .pipelineChannel(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.pipelineChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageChannelIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .wikiPageChannel(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.wikiPageChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityChannelIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .vulnerabilityChannel(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.vulnerabilityChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .issuesEvents(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .confidentialIssuesEvents(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .mergeRequestsEvents(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .noteEvents(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .confidentialNoteEvents(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .tagPushEvents(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .pipelineEvents(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .wikiPageEvents(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentEventsIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .deploymentEvents(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.deploymentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentEventsIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .incidentEvents(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.incidentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .workItemEvents(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .confidentialWorkItemEvents(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityEventsIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .vulnerabilityEvents(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.vulnerabilityEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertEventsIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .alertEvents(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.alertEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload();

        assertSoftly(softly -> {
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
        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload();

        final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload rebuilt =
                GitLabGroupGroupIntegrationsGitlabSlackApplicationPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
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

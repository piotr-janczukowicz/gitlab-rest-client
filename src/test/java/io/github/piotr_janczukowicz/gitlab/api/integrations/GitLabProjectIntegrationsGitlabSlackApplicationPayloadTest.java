package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsGitlabSlackApplicationPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .channel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.channel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .branchesToBeNotified(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .labelsToBeNotified(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.labelsToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsToBeNotifiedBehaviorIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .labelsToBeNotifiedBehavior(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.labelsToBeNotifiedBehavior()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .pushChannel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.pushChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .issueChannel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.issueChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .incidentChannel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.incidentChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .alertChannel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.alertChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssueChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .confidentialIssueChannel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.confidentialIssueChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .mergeRequestChannel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.mergeRequestChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .noteChannel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.noteChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .confidentialNoteChannel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.confidentialNoteChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .tagPushChannel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.tagPushChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .deploymentChannel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.deploymentChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .pipelineChannel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.pipelineChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .wikiPageChannel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.wikiPageChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .vulnerabilityChannel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.vulnerabilityChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .issuesEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .confidentialIssuesEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .noteEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .confidentialNoteEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .wikiPageEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .deploymentEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.deploymentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .incidentEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.incidentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .workItemEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .confidentialWorkItemEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .vulnerabilityEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.vulnerabilityEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .alertEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.alertEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsGitlabSlackApplicationPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload();

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
        final GitLabProjectIntegrationsGitlabSlackApplicationPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload();

        final GitLabProjectIntegrationsGitlabSlackApplicationPayload rebuilt =
                GitLabProjectIntegrationsGitlabSlackApplicationPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsGitlabSlackApplicationPayload.class.getRecordComponents())
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

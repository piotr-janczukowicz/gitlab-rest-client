package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .channel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.channel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .branchesToBeNotified(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .labelsToBeNotified(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.labelsToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsToBeNotifiedBehaviorIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .labelsToBeNotifiedBehavior(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.labelsToBeNotifiedBehavior()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .pushChannel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.pushChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .issueChannel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.issueChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .incidentChannel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.incidentChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .alertChannel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.alertChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssueChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .confidentialIssueChannel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.confidentialIssueChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .mergeRequestChannel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.mergeRequestChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .noteChannel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.noteChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .confidentialNoteChannel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.confidentialNoteChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .tagPushChannel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.tagPushChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .deploymentChannel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.deploymentChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .pipelineChannel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.pipelineChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .wikiPageChannel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.wikiPageChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityChannelIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .vulnerabilityChannel(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.vulnerabilityChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .issuesEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .confidentialIssuesEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .noteEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .confidentialNoteEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .wikiPageEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .deploymentEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.deploymentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .incidentEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.incidentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .workItemEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .confidentialWorkItemEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .vulnerabilityEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.vulnerabilityEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertEventsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .alertEvents(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.alertEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload();

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
        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload();

        final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload rebuilt =
                GitLabProjectIntegrationsGitlabSlackApplicationServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsGitlabSlackApplicationServicePayload.class.getRecordComponents())
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

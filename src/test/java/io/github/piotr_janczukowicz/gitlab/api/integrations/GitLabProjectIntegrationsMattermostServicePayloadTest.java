package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsMattermostServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWebhookIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .webhook(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.webhook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .username(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .channel(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.channel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .branchesToBeNotified(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .labelsToBeNotified(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.labelsToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsToBeNotifiedBehaviorIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .labelsToBeNotifiedBehavior(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.labelsToBeNotifiedBehavior()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .pushChannel(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.pushChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .issueChannel(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.issueChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .incidentChannel(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.incidentChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .alertChannel(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.alertChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssueChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .confidentialIssueChannel(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.confidentialIssueChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .mergeRequestChannel(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.mergeRequestChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .noteChannel(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.noteChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .confidentialNoteChannel(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.confidentialNoteChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .tagPushChannel(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.tagPushChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .deploymentChannel(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.deploymentChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .pipelineChannel(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.pipelineChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .wikiPageChannel(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.wikiPageChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .vulnerabilityChannel(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.vulnerabilityChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .issuesEvents(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .confidentialIssuesEvents(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .noteEvents(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .confidentialNoteEvents(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .wikiPageEvents(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .deploymentEvents(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.deploymentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .incidentEvents(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.incidentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .workItemEvents(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .confidentialWorkItemEvents(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .vulnerabilityEvents(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.vulnerabilityEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsMattermostServicePayloadBuilder builder =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsMattermostServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsMattermostServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload();

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
        final GitLabProjectIntegrationsMattermostServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload();

        final GitLabProjectIntegrationsMattermostServicePayload rebuilt =
                GitLabProjectIntegrationsMattermostServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsMattermostServicePayload.class.getRecordComponents())
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

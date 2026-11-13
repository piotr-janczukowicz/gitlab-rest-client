package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsMattermostPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWebhookIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .webhook(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.webhook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .username(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .channel(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.channel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .branchesToBeNotified(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .labelsToBeNotified(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.labelsToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsToBeNotifiedBehaviorIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .labelsToBeNotifiedBehavior(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.labelsToBeNotifiedBehavior()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .pushChannel(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.pushChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .issueChannel(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.issueChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .incidentChannel(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.incidentChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .alertChannel(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.alertChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssueChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .confidentialIssueChannel(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.confidentialIssueChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .mergeRequestChannel(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.mergeRequestChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .noteChannel(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.noteChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .confidentialNoteChannel(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.confidentialNoteChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .tagPushChannel(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.tagPushChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .deploymentChannel(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.deploymentChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .pipelineChannel(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.pipelineChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .wikiPageChannel(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.wikiPageChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityChannelIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .vulnerabilityChannel(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.vulnerabilityChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .issuesEvents(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .confidentialIssuesEvents(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .noteEvents(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .confidentialNoteEvents(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .wikiPageEvents(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .deploymentEvents(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.deploymentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .incidentEvents(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.incidentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .workItemEvents(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .confidentialWorkItemEvents(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityEventsIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .vulnerabilityEvents(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.vulnerabilityEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsMattermostPayloadBuilder builder =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsMattermostPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsMattermostPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload();

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
        final GitLabProjectIntegrationsMattermostPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload();

        final GitLabProjectIntegrationsMattermostPayload rebuilt =
                GitLabProjectIntegrationsMattermostPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsMattermostPayload.class.getRecordComponents())
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

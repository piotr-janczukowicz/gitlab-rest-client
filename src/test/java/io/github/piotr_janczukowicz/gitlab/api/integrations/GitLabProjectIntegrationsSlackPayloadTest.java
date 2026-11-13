package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsSlackPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWebhookIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .webhook(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.webhook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .username(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChannelIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .channel(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.channel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .branchesToBeNotified(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .labelsToBeNotified(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.labelsToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsToBeNotifiedBehaviorIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .labelsToBeNotifiedBehavior(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.labelsToBeNotifiedBehavior()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushChannelIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .pushChannel(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.pushChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueChannelIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .issueChannel(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.issueChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentChannelIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .incidentChannel(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.incidentChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertChannelIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .alertChannel(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.alertChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssueChannelIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .confidentialIssueChannel(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.confidentialIssueChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestChannelIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .mergeRequestChannel(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.mergeRequestChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteChannelIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .noteChannel(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.noteChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteChannelIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .confidentialNoteChannel(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.confidentialNoteChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushChannelIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .tagPushChannel(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.tagPushChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentChannelIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .deploymentChannel(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.deploymentChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineChannelIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .pipelineChannel(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.pipelineChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageChannelIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .wikiPageChannel(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.wikiPageChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityChannelIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .vulnerabilityChannel(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.vulnerabilityChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .issuesEvents(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .confidentialIssuesEvents(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .noteEvents(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .confidentialNoteEvents(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .wikiPageEvents(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentEventsIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .deploymentEvents(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.deploymentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentEventsIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .incidentEvents(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.incidentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .workItemEvents(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .confidentialWorkItemEvents(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityEventsIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .vulnerabilityEvents(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.vulnerabilityEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertEventsIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .alertEvents(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.alertEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsSlackPayloadBuilder builder =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsSlackPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsSlackPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload();

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
        final GitLabProjectIntegrationsSlackPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsSlackPayload();

        final GitLabProjectIntegrationsSlackPayload rebuilt =
                GitLabProjectIntegrationsSlackPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsSlackPayload.class.getRecordComponents())
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

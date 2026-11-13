package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsSlackServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWebhookIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .webhook(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.webhook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .username(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChannelIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .channel(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.channel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .branchesToBeNotified(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .labelsToBeNotified(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.labelsToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsToBeNotifiedBehaviorIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .labelsToBeNotifiedBehavior(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.labelsToBeNotifiedBehavior()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushChannelIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .pushChannel(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.pushChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueChannelIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .issueChannel(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.issueChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentChannelIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .incidentChannel(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.incidentChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertChannelIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .alertChannel(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.alertChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssueChannelIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .confidentialIssueChannel(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.confidentialIssueChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestChannelIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .mergeRequestChannel(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.mergeRequestChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteChannelIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .noteChannel(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.noteChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteChannelIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .confidentialNoteChannel(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.confidentialNoteChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushChannelIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .tagPushChannel(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.tagPushChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentChannelIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .deploymentChannel(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.deploymentChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineChannelIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .pipelineChannel(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.pipelineChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageChannelIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .wikiPageChannel(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.wikiPageChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityChannelIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .vulnerabilityChannel(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.vulnerabilityChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .issuesEvents(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .confidentialIssuesEvents(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .noteEvents(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .confidentialNoteEvents(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .wikiPageEvents(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentEventsIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .deploymentEvents(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.deploymentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentEventsIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .incidentEvents(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.incidentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .workItemEvents(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .confidentialWorkItemEvents(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityEventsIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .vulnerabilityEvents(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.vulnerabilityEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertEventsIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .alertEvents(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.alertEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsSlackServicePayloadBuilder builder =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsSlackServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsSlackServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload();

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
        final GitLabProjectIntegrationsSlackServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload();

        final GitLabProjectIntegrationsSlackServicePayload rebuilt =
                GitLabProjectIntegrationsSlackServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsSlackServicePayload.class.getRecordComponents())
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

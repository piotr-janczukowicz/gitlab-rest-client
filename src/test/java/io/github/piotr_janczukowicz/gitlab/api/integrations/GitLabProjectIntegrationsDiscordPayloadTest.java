package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsDiscordPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWebhookIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .webhook(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.webhook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .branchesToBeNotified(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushChannelIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .pushChannel(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.pushChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueChannelIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .issueChannel(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.issueChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentChannelIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .incidentChannel(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.incidentChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertChannelIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .alertChannel(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.alertChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssueChannelIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .confidentialIssueChannel(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.confidentialIssueChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestChannelIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .mergeRequestChannel(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.mergeRequestChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteChannelIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .noteChannel(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.noteChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteChannelIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .confidentialNoteChannel(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.confidentialNoteChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushChannelIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .tagPushChannel(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.tagPushChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentChannelIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .deploymentChannel(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.deploymentChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineChannelIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .pipelineChannel(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.pipelineChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageChannelIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .wikiPageChannel(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.wikiPageChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityChannelIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .vulnerabilityChannel(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.vulnerabilityChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .issuesEvents(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .confidentialIssuesEvents(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .workItemEvents(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .confidentialWorkItemEvents(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .noteEvents(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .confidentialNoteEvents(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .wikiPageEvents(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentEventsIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .deploymentEvents(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.deploymentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsDiscordPayloadBuilder builder =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsDiscordPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsDiscordPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload();

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
        final GitLabProjectIntegrationsDiscordPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload();

        final GitLabProjectIntegrationsDiscordPayload rebuilt =
                GitLabProjectIntegrationsDiscordPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsDiscordPayload.class.getRecordComponents())
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

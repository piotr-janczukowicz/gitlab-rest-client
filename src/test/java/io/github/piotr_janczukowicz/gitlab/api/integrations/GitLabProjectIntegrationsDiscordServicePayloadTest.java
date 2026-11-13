package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsDiscordServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWebhookIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .webhook(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.webhook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .branchesToBeNotified(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushChannelIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .pushChannel(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.pushChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueChannelIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .issueChannel(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.issueChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentChannelIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .incidentChannel(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.incidentChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertChannelIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .alertChannel(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.alertChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssueChannelIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .confidentialIssueChannel(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.confidentialIssueChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestChannelIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .mergeRequestChannel(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.mergeRequestChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteChannelIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .noteChannel(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.noteChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteChannelIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .confidentialNoteChannel(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.confidentialNoteChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushChannelIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .tagPushChannel(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.tagPushChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentChannelIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .deploymentChannel(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.deploymentChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineChannelIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .pipelineChannel(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.pipelineChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageChannelIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .wikiPageChannel(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.wikiPageChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityChannelIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .vulnerabilityChannel(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.vulnerabilityChannel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .issuesEvents(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .confidentialIssuesEvents(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .workItemEvents(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .confidentialWorkItemEvents(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .noteEvents(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .confidentialNoteEvents(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .wikiPageEvents(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentEventsIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .deploymentEvents(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.deploymentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsDiscordServicePayloadBuilder builder =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsDiscordServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsDiscordServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload();

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
        final GitLabProjectIntegrationsDiscordServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload();

        final GitLabProjectIntegrationsDiscordServicePayload rebuilt =
                GitLabProjectIntegrationsDiscordServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsDiscordServicePayload.class.getRecordComponents())
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

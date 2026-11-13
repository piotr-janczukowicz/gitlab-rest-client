package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsHangoutsChatServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWebhookIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatServicePayload())
                        .webhook(null);

        final GitLabProjectIntegrationsHangoutsChatServicePayload built = builder.build();

        assertThat(built.webhook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatServicePayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabProjectIntegrationsHangoutsChatServicePayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatServicePayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabProjectIntegrationsHangoutsChatServicePayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatServicePayload())
                        .branchesToBeNotified(null);

        final GitLabProjectIntegrationsHangoutsChatServicePayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsHangoutsChatServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatServicePayload())
                        .issuesEvents(null);

        final GitLabProjectIntegrationsHangoutsChatServicePayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatServicePayload())
                        .confidentialIssuesEvents(null);

        final GitLabProjectIntegrationsHangoutsChatServicePayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatServicePayload())
                        .workItemEvents(null);

        final GitLabProjectIntegrationsHangoutsChatServicePayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatServicePayload())
                        .confidentialWorkItemEvents(null);

        final GitLabProjectIntegrationsHangoutsChatServicePayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatServicePayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsHangoutsChatServicePayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatServicePayload())
                        .noteEvents(null);

        final GitLabProjectIntegrationsHangoutsChatServicePayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatServicePayload())
                        .confidentialNoteEvents(null);

        final GitLabProjectIntegrationsHangoutsChatServicePayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatServicePayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsHangoutsChatServicePayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatServicePayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsHangoutsChatServicePayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatServicePayload())
                        .wikiPageEvents(null);

        final GitLabProjectIntegrationsHangoutsChatServicePayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsHangoutsChatServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsHangoutsChatServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatServicePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.webhook()).isEqualTo("webhook");
            softly.assertThat(value.notifyOnlyBrokenPipelines()).isEqualTo(true);
            softly.assertThat(value.notifyOnlyWhenPipelineStatusChanges()).isEqualTo(true);
            softly.assertThat(value.branchesToBeNotified()).isEqualTo("branches_to_be_notified");
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
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsHangoutsChatServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatServicePayload();

        final GitLabProjectIntegrationsHangoutsChatServicePayload rebuilt =
                GitLabProjectIntegrationsHangoutsChatServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsHangoutsChatServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "webhook",
                        "notifyOnlyBrokenPipelines",
                        "notifyOnlyWhenPipelineStatusChanges",
                        "branchesToBeNotified",
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
                        "useInheritedSettings");
    }
}

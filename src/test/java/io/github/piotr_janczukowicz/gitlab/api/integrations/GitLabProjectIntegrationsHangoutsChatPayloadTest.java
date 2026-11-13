package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsHangoutsChatPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWebhookIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatPayload())
                        .webhook(null);

        final GitLabProjectIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.webhook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatPayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabProjectIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatPayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabProjectIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatPayload())
                        .branchesToBeNotified(null);

        final GitLabProjectIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatPayload())
                        .issuesEvents(null);

        final GitLabProjectIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatPayload())
                        .confidentialIssuesEvents(null);

        final GitLabProjectIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatPayload())
                        .workItemEvents(null);

        final GitLabProjectIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatPayload())
                        .confidentialWorkItemEvents(null);

        final GitLabProjectIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatPayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatPayload())
                        .noteEvents(null);

        final GitLabProjectIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatPayload())
                        .confidentialNoteEvents(null);

        final GitLabProjectIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatPayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatPayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatPayload())
                        .wikiPageEvents(null);

        final GitLabProjectIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabProjectIntegrationsHangoutsChatPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsHangoutsChatPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatPayload();

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
        final GitLabProjectIntegrationsHangoutsChatPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatPayload();

        final GitLabProjectIntegrationsHangoutsChatPayload rebuilt =
                GitLabProjectIntegrationsHangoutsChatPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsHangoutsChatPayload.class.getRecordComponents())
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

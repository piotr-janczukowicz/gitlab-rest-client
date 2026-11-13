package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsPumbleServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWebhookIsNullable() {
        final GitLabProjectIntegrationsPumbleServicePayloadBuilder builder =
                GitLabProjectIntegrationsPumbleServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumbleServicePayload())
                        .webhook(null);

        final GitLabProjectIntegrationsPumbleServicePayload built = builder.build();

        assertThat(built.webhook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabProjectIntegrationsPumbleServicePayloadBuilder builder =
                GitLabProjectIntegrationsPumbleServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumbleServicePayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabProjectIntegrationsPumbleServicePayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabProjectIntegrationsPumbleServicePayloadBuilder builder =
                GitLabProjectIntegrationsPumbleServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumbleServicePayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabProjectIntegrationsPumbleServicePayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsPumbleServicePayloadBuilder builder =
                GitLabProjectIntegrationsPumbleServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumbleServicePayload())
                        .branchesToBeNotified(null);

        final GitLabProjectIntegrationsPumbleServicePayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsPumbleServicePayloadBuilder builder =
                GitLabProjectIntegrationsPumbleServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumbleServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsPumbleServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsPumbleServicePayloadBuilder builder =
                GitLabProjectIntegrationsPumbleServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumbleServicePayload())
                        .issuesEvents(null);

        final GitLabProjectIntegrationsPumbleServicePayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsPumbleServicePayloadBuilder builder =
                GitLabProjectIntegrationsPumbleServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumbleServicePayload())
                        .confidentialIssuesEvents(null);

        final GitLabProjectIntegrationsPumbleServicePayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsPumbleServicePayloadBuilder builder =
                GitLabProjectIntegrationsPumbleServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumbleServicePayload())
                        .workItemEvents(null);

        final GitLabProjectIntegrationsPumbleServicePayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsPumbleServicePayloadBuilder builder =
                GitLabProjectIntegrationsPumbleServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumbleServicePayload())
                        .confidentialWorkItemEvents(null);

        final GitLabProjectIntegrationsPumbleServicePayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsPumbleServicePayloadBuilder builder =
                GitLabProjectIntegrationsPumbleServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumbleServicePayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsPumbleServicePayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectIntegrationsPumbleServicePayloadBuilder builder =
                GitLabProjectIntegrationsPumbleServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumbleServicePayload())
                        .noteEvents(null);

        final GitLabProjectIntegrationsPumbleServicePayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabProjectIntegrationsPumbleServicePayloadBuilder builder =
                GitLabProjectIntegrationsPumbleServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumbleServicePayload())
                        .confidentialNoteEvents(null);

        final GitLabProjectIntegrationsPumbleServicePayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsPumbleServicePayloadBuilder builder =
                GitLabProjectIntegrationsPumbleServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumbleServicePayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsPumbleServicePayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsPumbleServicePayloadBuilder builder =
                GitLabProjectIntegrationsPumbleServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumbleServicePayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsPumbleServicePayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabProjectIntegrationsPumbleServicePayloadBuilder builder =
                GitLabProjectIntegrationsPumbleServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumbleServicePayload())
                        .wikiPageEvents(null);

        final GitLabProjectIntegrationsPumbleServicePayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsPumbleServicePayloadBuilder builder =
                GitLabProjectIntegrationsPumbleServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumbleServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsPumbleServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsPumbleServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsPumbleServicePayload();

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
        final GitLabProjectIntegrationsPumbleServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsPumbleServicePayload();

        final GitLabProjectIntegrationsPumbleServicePayload rebuilt =
                GitLabProjectIntegrationsPumbleServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsPumbleServicePayload.class.getRecordComponents())
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

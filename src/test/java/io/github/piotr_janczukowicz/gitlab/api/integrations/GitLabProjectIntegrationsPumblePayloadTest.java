package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsPumblePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWebhookIsNullable() {
        final GitLabProjectIntegrationsPumblePayloadBuilder builder =
                GitLabProjectIntegrationsPumblePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumblePayload())
                        .webhook(null);

        final GitLabProjectIntegrationsPumblePayload built = builder.build();

        assertThat(built.webhook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabProjectIntegrationsPumblePayloadBuilder builder =
                GitLabProjectIntegrationsPumblePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumblePayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabProjectIntegrationsPumblePayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabProjectIntegrationsPumblePayloadBuilder builder =
                GitLabProjectIntegrationsPumblePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumblePayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabProjectIntegrationsPumblePayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsPumblePayloadBuilder builder =
                GitLabProjectIntegrationsPumblePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumblePayload())
                        .branchesToBeNotified(null);

        final GitLabProjectIntegrationsPumblePayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsPumblePayloadBuilder builder =
                GitLabProjectIntegrationsPumblePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumblePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsPumblePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsPumblePayloadBuilder builder =
                GitLabProjectIntegrationsPumblePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumblePayload())
                        .issuesEvents(null);

        final GitLabProjectIntegrationsPumblePayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsPumblePayloadBuilder builder =
                GitLabProjectIntegrationsPumblePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumblePayload())
                        .confidentialIssuesEvents(null);

        final GitLabProjectIntegrationsPumblePayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsPumblePayloadBuilder builder =
                GitLabProjectIntegrationsPumblePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumblePayload())
                        .workItemEvents(null);

        final GitLabProjectIntegrationsPumblePayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsPumblePayloadBuilder builder =
                GitLabProjectIntegrationsPumblePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumblePayload())
                        .confidentialWorkItemEvents(null);

        final GitLabProjectIntegrationsPumblePayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsPumblePayloadBuilder builder =
                GitLabProjectIntegrationsPumblePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumblePayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsPumblePayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectIntegrationsPumblePayloadBuilder builder =
                GitLabProjectIntegrationsPumblePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumblePayload())
                        .noteEvents(null);

        final GitLabProjectIntegrationsPumblePayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabProjectIntegrationsPumblePayloadBuilder builder =
                GitLabProjectIntegrationsPumblePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumblePayload())
                        .confidentialNoteEvents(null);

        final GitLabProjectIntegrationsPumblePayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsPumblePayloadBuilder builder =
                GitLabProjectIntegrationsPumblePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumblePayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsPumblePayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsPumblePayloadBuilder builder =
                GitLabProjectIntegrationsPumblePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumblePayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsPumblePayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabProjectIntegrationsPumblePayloadBuilder builder =
                GitLabProjectIntegrationsPumblePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumblePayload())
                        .wikiPageEvents(null);

        final GitLabProjectIntegrationsPumblePayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsPumblePayloadBuilder builder =
                GitLabProjectIntegrationsPumblePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPumblePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsPumblePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsPumblePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsPumblePayload();

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
        final GitLabProjectIntegrationsPumblePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsPumblePayload();

        final GitLabProjectIntegrationsPumblePayload rebuilt =
                GitLabProjectIntegrationsPumblePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsPumblePayload.class.getRecordComponents())
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

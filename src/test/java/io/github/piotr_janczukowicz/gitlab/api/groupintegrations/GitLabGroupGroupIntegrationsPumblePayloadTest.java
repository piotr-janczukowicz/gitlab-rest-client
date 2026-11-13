package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsPumblePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWebhookIsNullable() {
        final GitLabGroupGroupIntegrationsPumblePayloadBuilder builder =
                GitLabGroupGroupIntegrationsPumblePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPumblePayload())
                        .webhook(null);

        final GitLabGroupGroupIntegrationsPumblePayload built = builder.build();

        assertThat(built.webhook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabGroupGroupIntegrationsPumblePayloadBuilder builder =
                GitLabGroupGroupIntegrationsPumblePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPumblePayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabGroupGroupIntegrationsPumblePayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabGroupGroupIntegrationsPumblePayloadBuilder builder =
                GitLabGroupGroupIntegrationsPumblePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPumblePayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabGroupGroupIntegrationsPumblePayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabGroupGroupIntegrationsPumblePayloadBuilder builder =
                GitLabGroupGroupIntegrationsPumblePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPumblePayload())
                        .branchesToBeNotified(null);

        final GitLabGroupGroupIntegrationsPumblePayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsPumblePayloadBuilder builder =
                GitLabGroupGroupIntegrationsPumblePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPumblePayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsPumblePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabGroupGroupIntegrationsPumblePayloadBuilder builder =
                GitLabGroupGroupIntegrationsPumblePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPumblePayload())
                        .issuesEvents(null);

        final GitLabGroupGroupIntegrationsPumblePayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabGroupGroupIntegrationsPumblePayloadBuilder builder =
                GitLabGroupGroupIntegrationsPumblePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPumblePayload())
                        .confidentialIssuesEvents(null);

        final GitLabGroupGroupIntegrationsPumblePayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabGroupGroupIntegrationsPumblePayloadBuilder builder =
                GitLabGroupGroupIntegrationsPumblePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPumblePayload())
                        .workItemEvents(null);

        final GitLabGroupGroupIntegrationsPumblePayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabGroupGroupIntegrationsPumblePayloadBuilder builder =
                GitLabGroupGroupIntegrationsPumblePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPumblePayload())
                        .confidentialWorkItemEvents(null);

        final GitLabGroupGroupIntegrationsPumblePayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabGroupGroupIntegrationsPumblePayloadBuilder builder =
                GitLabGroupGroupIntegrationsPumblePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPumblePayload())
                        .mergeRequestsEvents(null);

        final GitLabGroupGroupIntegrationsPumblePayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabGroupGroupIntegrationsPumblePayloadBuilder builder =
                GitLabGroupGroupIntegrationsPumblePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPumblePayload())
                        .noteEvents(null);

        final GitLabGroupGroupIntegrationsPumblePayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabGroupGroupIntegrationsPumblePayloadBuilder builder =
                GitLabGroupGroupIntegrationsPumblePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPumblePayload())
                        .confidentialNoteEvents(null);

        final GitLabGroupGroupIntegrationsPumblePayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsPumblePayloadBuilder builder =
                GitLabGroupGroupIntegrationsPumblePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPumblePayload())
                        .tagPushEvents(null);

        final GitLabGroupGroupIntegrationsPumblePayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabGroupGroupIntegrationsPumblePayloadBuilder builder =
                GitLabGroupGroupIntegrationsPumblePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPumblePayload())
                        .pipelineEvents(null);

        final GitLabGroupGroupIntegrationsPumblePayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabGroupGroupIntegrationsPumblePayloadBuilder builder =
                GitLabGroupGroupIntegrationsPumblePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPumblePayload())
                        .wikiPageEvents(null);

        final GitLabGroupGroupIntegrationsPumblePayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsPumblePayloadBuilder builder =
                GitLabGroupGroupIntegrationsPumblePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPumblePayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsPumblePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsPumblePayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPumblePayload();

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
        final GitLabGroupGroupIntegrationsPumblePayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPumblePayload();

        final GitLabGroupGroupIntegrationsPumblePayload rebuilt =
                GitLabGroupGroupIntegrationsPumblePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsPumblePayload.class.getRecordComponents())
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

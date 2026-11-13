package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsHangoutsChatPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWebhookIsNullable() {
        final GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsHangoutsChatPayload())
                        .webhook(null);

        final GitLabGroupGroupIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.webhook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsHangoutsChatPayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabGroupGroupIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsHangoutsChatPayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabGroupGroupIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsHangoutsChatPayload())
                        .branchesToBeNotified(null);

        final GitLabGroupGroupIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsHangoutsChatPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsHangoutsChatPayload())
                        .issuesEvents(null);

        final GitLabGroupGroupIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsHangoutsChatPayload())
                        .confidentialIssuesEvents(null);

        final GitLabGroupGroupIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsHangoutsChatPayload())
                        .workItemEvents(null);

        final GitLabGroupGroupIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsHangoutsChatPayload())
                        .confidentialWorkItemEvents(null);

        final GitLabGroupGroupIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsHangoutsChatPayload())
                        .mergeRequestsEvents(null);

        final GitLabGroupGroupIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsHangoutsChatPayload())
                        .noteEvents(null);

        final GitLabGroupGroupIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsHangoutsChatPayload())
                        .confidentialNoteEvents(null);

        final GitLabGroupGroupIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsHangoutsChatPayload())
                        .tagPushEvents(null);

        final GitLabGroupGroupIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsHangoutsChatPayload())
                        .pipelineEvents(null);

        final GitLabGroupGroupIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsHangoutsChatPayload())
                        .wikiPageEvents(null);

        final GitLabGroupGroupIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder builder =
                GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsHangoutsChatPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsHangoutsChatPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsHangoutsChatPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsHangoutsChatPayload();

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
        final GitLabGroupGroupIntegrationsHangoutsChatPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsHangoutsChatPayload();

        final GitLabGroupGroupIntegrationsHangoutsChatPayload rebuilt =
                GitLabGroupGroupIntegrationsHangoutsChatPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupIntegrationsHangoutsChatPayload.class.getRecordComponents())
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

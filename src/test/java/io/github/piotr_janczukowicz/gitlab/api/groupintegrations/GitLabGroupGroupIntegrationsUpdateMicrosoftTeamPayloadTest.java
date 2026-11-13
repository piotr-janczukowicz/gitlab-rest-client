package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWebhookIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMicrosoftTeamPayload())
                        .webhook(null);

        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.webhook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMicrosoftTeamPayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMicrosoftTeamPayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMicrosoftTeamPayload())
                        .branchesToBeNotified(null);

        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMicrosoftTeamPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMicrosoftTeamPayload())
                        .issuesEvents(null);

        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMicrosoftTeamPayload())
                        .confidentialIssuesEvents(null);

        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMicrosoftTeamPayload())
                        .workItemEvents(null);

        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMicrosoftTeamPayload())
                        .confidentialWorkItemEvents(null);

        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMicrosoftTeamPayload())
                        .mergeRequestsEvents(null);

        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMicrosoftTeamPayload())
                        .noteEvents(null);

        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMicrosoftTeamPayload())
                        .confidentialNoteEvents(null);

        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMicrosoftTeamPayload())
                        .tagPushEvents(null);

        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMicrosoftTeamPayload())
                        .pipelineEvents(null);

        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMicrosoftTeamPayload())
                        .wikiPageEvents(null);

        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMicrosoftTeamPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMicrosoftTeamPayload();

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
        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMicrosoftTeamPayload();

        final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayload rebuilt =
                GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayload.class.getRecordComponents())
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

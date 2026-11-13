package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWebhookIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateWebexTeamPayload())
                        .webhook(null);

        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.webhook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateWebexTeamPayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateWebexTeamPayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateWebexTeamPayload())
                        .branchesToBeNotified(null);

        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateWebexTeamPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateWebexTeamPayload())
                        .issuesEvents(null);

        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateWebexTeamPayload())
                        .confidentialIssuesEvents(null);

        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateWebexTeamPayload())
                        .workItemEvents(null);

        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateWebexTeamPayload())
                        .confidentialWorkItemEvents(null);

        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateWebexTeamPayload())
                        .mergeRequestsEvents(null);

        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateWebexTeamPayload())
                        .noteEvents(null);

        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateWebexTeamPayload())
                        .confidentialNoteEvents(null);

        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateWebexTeamPayload())
                        .tagPushEvents(null);

        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateWebexTeamPayload())
                        .pipelineEvents(null);

        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateWebexTeamPayload())
                        .wikiPageEvents(null);

        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateWebexTeamPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateWebexTeamPayload();

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
        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateWebexTeamPayload();

        final GitLabGroupGroupIntegrationsUpdateWebexTeamPayload rebuilt =
                GitLabGroupGroupIntegrationsUpdateWebexTeamPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupIntegrationsUpdateWebexTeamPayload.class.getRecordComponents())
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

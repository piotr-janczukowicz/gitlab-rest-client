package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWebhookIsNullable() {
        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateMicrosoftTeamPayload())
                        .webhook(null);

        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.webhook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateMicrosoftTeamPayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateMicrosoftTeamPayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateMicrosoftTeamPayload())
                        .branchesToBeNotified(null);

        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateMicrosoftTeamPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateMicrosoftTeamPayload())
                        .issuesEvents(null);

        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateMicrosoftTeamPayload())
                        .confidentialIssuesEvents(null);

        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateMicrosoftTeamPayload())
                        .workItemEvents(null);

        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateMicrosoftTeamPayload())
                        .confidentialWorkItemEvents(null);

        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateMicrosoftTeamPayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateMicrosoftTeamPayload())
                        .noteEvents(null);

        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateMicrosoftTeamPayload())
                        .confidentialNoteEvents(null);

        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateMicrosoftTeamPayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateMicrosoftTeamPayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateMicrosoftTeamPayload())
                        .wikiPageEvents(null);

        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateMicrosoftTeamPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsUpdateMicrosoftTeamPayload();

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
        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsUpdateMicrosoftTeamPayload();

        final GitLabProjectIntegrationsUpdateMicrosoftTeamPayload rebuilt =
                GitLabProjectIntegrationsUpdateMicrosoftTeamPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsUpdateMicrosoftTeamPayload.class.getRecordComponents())
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

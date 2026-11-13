package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsUpdateWebexTeamPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWebhookIsNullable() {
        final GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateWebexTeamPayload())
                        .webhook(null);

        final GitLabProjectIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.webhook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateWebexTeamPayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabProjectIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateWebexTeamPayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabProjectIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateWebexTeamPayload())
                        .branchesToBeNotified(null);

        final GitLabProjectIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateWebexTeamPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateWebexTeamPayload())
                        .issuesEvents(null);

        final GitLabProjectIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateWebexTeamPayload())
                        .confidentialIssuesEvents(null);

        final GitLabProjectIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateWebexTeamPayload())
                        .workItemEvents(null);

        final GitLabProjectIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateWebexTeamPayload())
                        .confidentialWorkItemEvents(null);

        final GitLabProjectIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateWebexTeamPayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateWebexTeamPayload())
                        .noteEvents(null);

        final GitLabProjectIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateWebexTeamPayload())
                        .confidentialNoteEvents(null);

        final GitLabProjectIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateWebexTeamPayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateWebexTeamPayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateWebexTeamPayload())
                        .wikiPageEvents(null);

        final GitLabProjectIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateWebexTeamPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsUpdateWebexTeamPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsUpdateWebexTeamPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsUpdateWebexTeamPayload();

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
        final GitLabProjectIntegrationsUpdateWebexTeamPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsUpdateWebexTeamPayload();

        final GitLabProjectIntegrationsUpdateWebexTeamPayload rebuilt =
                GitLabProjectIntegrationsUpdateWebexTeamPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsUpdateWebexTeamPayload.class.getRecordComponents())
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

package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWebhookIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesWebexTeamPayload())
                        .webhook(null);

        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayload built = builder.build();

        assertThat(built.webhook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesWebexTeamPayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesWebexTeamPayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesWebexTeamPayload())
                        .branchesToBeNotified(null);

        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesWebexTeamPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesWebexTeamPayload())
                        .issuesEvents(null);

        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesWebexTeamPayload())
                        .confidentialIssuesEvents(null);

        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesWebexTeamPayload())
                        .workItemEvents(null);

        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesWebexTeamPayload())
                        .confidentialWorkItemEvents(null);

        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesWebexTeamPayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesWebexTeamPayload())
                        .noteEvents(null);

        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesWebexTeamPayload())
                        .confidentialNoteEvents(null);

        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesWebexTeamPayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesWebexTeamPayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesWebexTeamPayload())
                        .wikiPageEvents(null);

        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesWebexTeamPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesWebexTeamPayload();

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
        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesWebexTeamPayload();

        final GitLabProjectIntegrationsUpdateServicesWebexTeamPayload rebuilt =
                GitLabProjectIntegrationsUpdateServicesWebexTeamPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsUpdateServicesWebexTeamPayload.class.getRecordComponents())
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

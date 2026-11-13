package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsTelegramPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenHostnameIsNullable() {
        final GitLabProjectIntegrationsTelegramPayloadBuilder builder =
                GitLabProjectIntegrationsTelegramPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload())
                        .hostname(null);

        final GitLabProjectIntegrationsTelegramPayload built = builder.build();

        assertThat(built.hostname()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsTelegramPayloadBuilder builder =
                GitLabProjectIntegrationsTelegramPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload())
                        .token(null);

        final GitLabProjectIntegrationsTelegramPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRoomIsNullable() {
        final GitLabProjectIntegrationsTelegramPayloadBuilder builder =
                GitLabProjectIntegrationsTelegramPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload())
                        .room(null);

        final GitLabProjectIntegrationsTelegramPayload built = builder.build();

        assertThat(built.room()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThreadIsNullable() {
        final GitLabProjectIntegrationsTelegramPayloadBuilder builder =
                GitLabProjectIntegrationsTelegramPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload())
                        .thread(null);

        final GitLabProjectIntegrationsTelegramPayload built = builder.build();

        assertThat(built.thread()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabProjectIntegrationsTelegramPayloadBuilder builder =
                GitLabProjectIntegrationsTelegramPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabProjectIntegrationsTelegramPayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabProjectIntegrationsTelegramPayloadBuilder builder =
                GitLabProjectIntegrationsTelegramPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabProjectIntegrationsTelegramPayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsTelegramPayloadBuilder builder =
                GitLabProjectIntegrationsTelegramPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload())
                        .branchesToBeNotified(null);

        final GitLabProjectIntegrationsTelegramPayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsTelegramPayloadBuilder builder =
                GitLabProjectIntegrationsTelegramPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsTelegramPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsTelegramPayloadBuilder builder =
                GitLabProjectIntegrationsTelegramPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload())
                        .issuesEvents(null);

        final GitLabProjectIntegrationsTelegramPayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsTelegramPayloadBuilder builder =
                GitLabProjectIntegrationsTelegramPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload())
                        .confidentialIssuesEvents(null);

        final GitLabProjectIntegrationsTelegramPayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsTelegramPayloadBuilder builder =
                GitLabProjectIntegrationsTelegramPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsTelegramPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectIntegrationsTelegramPayloadBuilder builder =
                GitLabProjectIntegrationsTelegramPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload())
                        .noteEvents(null);

        final GitLabProjectIntegrationsTelegramPayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabProjectIntegrationsTelegramPayloadBuilder builder =
                GitLabProjectIntegrationsTelegramPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload())
                        .confidentialNoteEvents(null);

        final GitLabProjectIntegrationsTelegramPayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsTelegramPayloadBuilder builder =
                GitLabProjectIntegrationsTelegramPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsTelegramPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsTelegramPayloadBuilder builder =
                GitLabProjectIntegrationsTelegramPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsTelegramPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabProjectIntegrationsTelegramPayloadBuilder builder =
                GitLabProjectIntegrationsTelegramPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload())
                        .wikiPageEvents(null);

        final GitLabProjectIntegrationsTelegramPayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentEventsIsNullable() {
        final GitLabProjectIntegrationsTelegramPayloadBuilder builder =
                GitLabProjectIntegrationsTelegramPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload())
                        .incidentEvents(null);

        final GitLabProjectIntegrationsTelegramPayload built = builder.build();

        assertThat(built.incidentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsTelegramPayloadBuilder builder =
                GitLabProjectIntegrationsTelegramPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload())
                        .workItemEvents(null);

        final GitLabProjectIntegrationsTelegramPayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsTelegramPayloadBuilder builder =
                GitLabProjectIntegrationsTelegramPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload())
                        .confidentialWorkItemEvents(null);

        final GitLabProjectIntegrationsTelegramPayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityEventsIsNullable() {
        final GitLabProjectIntegrationsTelegramPayloadBuilder builder =
                GitLabProjectIntegrationsTelegramPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload())
                        .vulnerabilityEvents(null);

        final GitLabProjectIntegrationsTelegramPayload built = builder.build();

        assertThat(built.vulnerabilityEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsTelegramPayloadBuilder builder =
                GitLabProjectIntegrationsTelegramPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsTelegramPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsTelegramPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.hostname()).isEqualTo("hostname");
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.room()).isEqualTo("room");
            softly.assertThat(value.thread()).isEqualTo("thread");
            softly.assertThat(value.notifyOnlyBrokenPipelines()).isEqualTo(true);
            softly.assertThat(value.notifyOnlyWhenPipelineStatusChanges()).isEqualTo(true);
            softly.assertThat(value.branchesToBeNotified()).isEqualTo("branches_to_be_notified");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.issuesEvents()).isEqualTo(true);
            softly.assertThat(value.confidentialIssuesEvents()).isEqualTo(true);
            softly.assertThat(value.mergeRequestsEvents()).isEqualTo(true);
            softly.assertThat(value.noteEvents()).isEqualTo(true);
            softly.assertThat(value.confidentialNoteEvents()).isEqualTo(true);
            softly.assertThat(value.tagPushEvents()).isEqualTo(true);
            softly.assertThat(value.pipelineEvents()).isEqualTo(true);
            softly.assertThat(value.wikiPageEvents()).isEqualTo(true);
            softly.assertThat(value.incidentEvents()).isEqualTo(true);
            softly.assertThat(value.workItemEvents()).isEqualTo(true);
            softly.assertThat(value.confidentialWorkItemEvents()).isEqualTo(true);
            softly.assertThat(value.vulnerabilityEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsTelegramPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload();

        final GitLabProjectIntegrationsTelegramPayload rebuilt =
                GitLabProjectIntegrationsTelegramPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsTelegramPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsTelegramPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "hostname",
                        "token",
                        "room",
                        "thread",
                        "notifyOnlyBrokenPipelines",
                        "notifyOnlyWhenPipelineStatusChanges",
                        "branchesToBeNotified",
                        "pushEvents",
                        "issuesEvents",
                        "confidentialIssuesEvents",
                        "mergeRequestsEvents",
                        "noteEvents",
                        "confidentialNoteEvents",
                        "tagPushEvents",
                        "pipelineEvents",
                        "wikiPageEvents",
                        "incidentEvents",
                        "workItemEvents",
                        "confidentialWorkItemEvents",
                        "vulnerabilityEvents",
                        "useInheritedSettings");
    }
}

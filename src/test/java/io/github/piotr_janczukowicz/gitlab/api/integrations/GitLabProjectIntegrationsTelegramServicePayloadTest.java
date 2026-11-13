package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsTelegramServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenHostnameIsNullable() {
        final GitLabProjectIntegrationsTelegramServicePayloadBuilder builder =
                GitLabProjectIntegrationsTelegramServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload())
                        .hostname(null);

        final GitLabProjectIntegrationsTelegramServicePayload built = builder.build();

        assertThat(built.hostname()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsTelegramServicePayloadBuilder builder =
                GitLabProjectIntegrationsTelegramServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload())
                        .token(null);

        final GitLabProjectIntegrationsTelegramServicePayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRoomIsNullable() {
        final GitLabProjectIntegrationsTelegramServicePayloadBuilder builder =
                GitLabProjectIntegrationsTelegramServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload())
                        .room(null);

        final GitLabProjectIntegrationsTelegramServicePayload built = builder.build();

        assertThat(built.room()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThreadIsNullable() {
        final GitLabProjectIntegrationsTelegramServicePayloadBuilder builder =
                GitLabProjectIntegrationsTelegramServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload())
                        .thread(null);

        final GitLabProjectIntegrationsTelegramServicePayload built = builder.build();

        assertThat(built.thread()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabProjectIntegrationsTelegramServicePayloadBuilder builder =
                GitLabProjectIntegrationsTelegramServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabProjectIntegrationsTelegramServicePayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabProjectIntegrationsTelegramServicePayloadBuilder builder =
                GitLabProjectIntegrationsTelegramServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabProjectIntegrationsTelegramServicePayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsTelegramServicePayloadBuilder builder =
                GitLabProjectIntegrationsTelegramServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload())
                        .branchesToBeNotified(null);

        final GitLabProjectIntegrationsTelegramServicePayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsTelegramServicePayloadBuilder builder =
                GitLabProjectIntegrationsTelegramServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsTelegramServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsTelegramServicePayloadBuilder builder =
                GitLabProjectIntegrationsTelegramServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload())
                        .issuesEvents(null);

        final GitLabProjectIntegrationsTelegramServicePayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsTelegramServicePayloadBuilder builder =
                GitLabProjectIntegrationsTelegramServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload())
                        .confidentialIssuesEvents(null);

        final GitLabProjectIntegrationsTelegramServicePayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsTelegramServicePayloadBuilder builder =
                GitLabProjectIntegrationsTelegramServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsTelegramServicePayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectIntegrationsTelegramServicePayloadBuilder builder =
                GitLabProjectIntegrationsTelegramServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload())
                        .noteEvents(null);

        final GitLabProjectIntegrationsTelegramServicePayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabProjectIntegrationsTelegramServicePayloadBuilder builder =
                GitLabProjectIntegrationsTelegramServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload())
                        .confidentialNoteEvents(null);

        final GitLabProjectIntegrationsTelegramServicePayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsTelegramServicePayloadBuilder builder =
                GitLabProjectIntegrationsTelegramServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsTelegramServicePayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsTelegramServicePayloadBuilder builder =
                GitLabProjectIntegrationsTelegramServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsTelegramServicePayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabProjectIntegrationsTelegramServicePayloadBuilder builder =
                GitLabProjectIntegrationsTelegramServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload())
                        .wikiPageEvents(null);

        final GitLabProjectIntegrationsTelegramServicePayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentEventsIsNullable() {
        final GitLabProjectIntegrationsTelegramServicePayloadBuilder builder =
                GitLabProjectIntegrationsTelegramServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload())
                        .incidentEvents(null);

        final GitLabProjectIntegrationsTelegramServicePayload built = builder.build();

        assertThat(built.incidentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsTelegramServicePayloadBuilder builder =
                GitLabProjectIntegrationsTelegramServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload())
                        .workItemEvents(null);

        final GitLabProjectIntegrationsTelegramServicePayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsTelegramServicePayloadBuilder builder =
                GitLabProjectIntegrationsTelegramServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload())
                        .confidentialWorkItemEvents(null);

        final GitLabProjectIntegrationsTelegramServicePayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityEventsIsNullable() {
        final GitLabProjectIntegrationsTelegramServicePayloadBuilder builder =
                GitLabProjectIntegrationsTelegramServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload())
                        .vulnerabilityEvents(null);

        final GitLabProjectIntegrationsTelegramServicePayload built = builder.build();

        assertThat(built.vulnerabilityEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsTelegramServicePayloadBuilder builder =
                GitLabProjectIntegrationsTelegramServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsTelegramServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsTelegramServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload();

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
        final GitLabProjectIntegrationsTelegramServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload();

        final GitLabProjectIntegrationsTelegramServicePayload rebuilt =
                GitLabProjectIntegrationsTelegramServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsTelegramServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsTelegramServicePayload.class.getRecordComponents())
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

package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsTelegramPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenHostnameIsNullable() {
        final GitLabGroupGroupIntegrationsTelegramPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTelegramPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload())
                        .hostname(null);

        final GitLabGroupGroupIntegrationsTelegramPayload built = builder.build();

        assertThat(built.hostname()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabGroupGroupIntegrationsTelegramPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTelegramPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload())
                        .token(null);

        final GitLabGroupGroupIntegrationsTelegramPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRoomIsNullable() {
        final GitLabGroupGroupIntegrationsTelegramPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTelegramPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload())
                        .room(null);

        final GitLabGroupGroupIntegrationsTelegramPayload built = builder.build();

        assertThat(built.room()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThreadIsNullable() {
        final GitLabGroupGroupIntegrationsTelegramPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTelegramPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload())
                        .thread(null);

        final GitLabGroupGroupIntegrationsTelegramPayload built = builder.build();

        assertThat(built.thread()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabGroupGroupIntegrationsTelegramPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTelegramPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabGroupGroupIntegrationsTelegramPayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabGroupGroupIntegrationsTelegramPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTelegramPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabGroupGroupIntegrationsTelegramPayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabGroupGroupIntegrationsTelegramPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTelegramPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload())
                        .branchesToBeNotified(null);

        final GitLabGroupGroupIntegrationsTelegramPayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsTelegramPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTelegramPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsTelegramPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabGroupGroupIntegrationsTelegramPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTelegramPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload())
                        .issuesEvents(null);

        final GitLabGroupGroupIntegrationsTelegramPayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabGroupGroupIntegrationsTelegramPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTelegramPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload())
                        .confidentialIssuesEvents(null);

        final GitLabGroupGroupIntegrationsTelegramPayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabGroupGroupIntegrationsTelegramPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTelegramPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload())
                        .mergeRequestsEvents(null);

        final GitLabGroupGroupIntegrationsTelegramPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabGroupGroupIntegrationsTelegramPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTelegramPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload())
                        .noteEvents(null);

        final GitLabGroupGroupIntegrationsTelegramPayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabGroupGroupIntegrationsTelegramPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTelegramPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload())
                        .confidentialNoteEvents(null);

        final GitLabGroupGroupIntegrationsTelegramPayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsTelegramPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTelegramPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload())
                        .tagPushEvents(null);

        final GitLabGroupGroupIntegrationsTelegramPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabGroupGroupIntegrationsTelegramPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTelegramPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload())
                        .pipelineEvents(null);

        final GitLabGroupGroupIntegrationsTelegramPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabGroupGroupIntegrationsTelegramPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTelegramPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload())
                        .wikiPageEvents(null);

        final GitLabGroupGroupIntegrationsTelegramPayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentEventsIsNullable() {
        final GitLabGroupGroupIntegrationsTelegramPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTelegramPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload())
                        .incidentEvents(null);

        final GitLabGroupGroupIntegrationsTelegramPayload built = builder.build();

        assertThat(built.incidentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabGroupGroupIntegrationsTelegramPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTelegramPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload())
                        .workItemEvents(null);

        final GitLabGroupGroupIntegrationsTelegramPayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabGroupGroupIntegrationsTelegramPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTelegramPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload())
                        .confidentialWorkItemEvents(null);

        final GitLabGroupGroupIntegrationsTelegramPayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityEventsIsNullable() {
        final GitLabGroupGroupIntegrationsTelegramPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTelegramPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload())
                        .vulnerabilityEvents(null);

        final GitLabGroupGroupIntegrationsTelegramPayload built = builder.build();

        assertThat(built.vulnerabilityEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsTelegramPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTelegramPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsTelegramPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsTelegramPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload();

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
        final GitLabGroupGroupIntegrationsTelegramPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload();

        final GitLabGroupGroupIntegrationsTelegramPayload rebuilt =
                GitLabGroupGroupIntegrationsTelegramPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabGroupGroupIntegrationsTelegramPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsTelegramPayload.class.getRecordComponents())
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

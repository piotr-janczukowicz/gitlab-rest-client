package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsMatrixPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenHostnameIsNullable() {
        final GitLabGroupGroupIntegrationsMatrixPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMatrixPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload())
                        .hostname(null);

        final GitLabGroupGroupIntegrationsMatrixPayload built = builder.build();

        assertThat(built.hostname()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabGroupGroupIntegrationsMatrixPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMatrixPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload())
                        .token(null);

        final GitLabGroupGroupIntegrationsMatrixPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRoomIsNullable() {
        final GitLabGroupGroupIntegrationsMatrixPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMatrixPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload())
                        .room(null);

        final GitLabGroupGroupIntegrationsMatrixPayload built = builder.build();

        assertThat(built.room()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabGroupGroupIntegrationsMatrixPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMatrixPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabGroupGroupIntegrationsMatrixPayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabGroupGroupIntegrationsMatrixPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMatrixPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabGroupGroupIntegrationsMatrixPayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabGroupGroupIntegrationsMatrixPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMatrixPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload())
                        .branchesToBeNotified(null);

        final GitLabGroupGroupIntegrationsMatrixPayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMatrixPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMatrixPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsMatrixPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMatrixPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMatrixPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload())
                        .issuesEvents(null);

        final GitLabGroupGroupIntegrationsMatrixPayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMatrixPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMatrixPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload())
                        .confidentialIssuesEvents(null);

        final GitLabGroupGroupIntegrationsMatrixPayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMatrixPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMatrixPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload())
                        .mergeRequestsEvents(null);

        final GitLabGroupGroupIntegrationsMatrixPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMatrixPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMatrixPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload())
                        .noteEvents(null);

        final GitLabGroupGroupIntegrationsMatrixPayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMatrixPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMatrixPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload())
                        .confidentialNoteEvents(null);

        final GitLabGroupGroupIntegrationsMatrixPayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMatrixPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMatrixPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload())
                        .tagPushEvents(null);

        final GitLabGroupGroupIntegrationsMatrixPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMatrixPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMatrixPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload())
                        .pipelineEvents(null);

        final GitLabGroupGroupIntegrationsMatrixPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMatrixPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMatrixPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload())
                        .wikiPageEvents(null);

        final GitLabGroupGroupIntegrationsMatrixPayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMatrixPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMatrixPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload())
                        .incidentEvents(null);

        final GitLabGroupGroupIntegrationsMatrixPayload built = builder.build();

        assertThat(built.incidentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMatrixPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMatrixPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload())
                        .workItemEvents(null);

        final GitLabGroupGroupIntegrationsMatrixPayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMatrixPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMatrixPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload())
                        .confidentialWorkItemEvents(null);

        final GitLabGroupGroupIntegrationsMatrixPayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMatrixPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMatrixPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload())
                        .vulnerabilityEvents(null);

        final GitLabGroupGroupIntegrationsMatrixPayload built = builder.build();

        assertThat(built.vulnerabilityEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsMatrixPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMatrixPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsMatrixPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsMatrixPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.hostname()).isEqualTo("hostname");
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.room()).isEqualTo("room");
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
        final GitLabGroupGroupIntegrationsMatrixPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload();

        final GitLabGroupGroupIntegrationsMatrixPayload rebuilt =
                GitLabGroupGroupIntegrationsMatrixPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabGroupGroupIntegrationsMatrixPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsMatrixPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "hostname",
                        "token",
                        "room",
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

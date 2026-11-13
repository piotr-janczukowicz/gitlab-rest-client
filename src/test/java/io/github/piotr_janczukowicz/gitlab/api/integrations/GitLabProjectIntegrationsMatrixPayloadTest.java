package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsMatrixPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenHostnameIsNullable() {
        final GitLabProjectIntegrationsMatrixPayloadBuilder builder =
                GitLabProjectIntegrationsMatrixPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload())
                        .hostname(null);

        final GitLabProjectIntegrationsMatrixPayload built = builder.build();

        assertThat(built.hostname()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsMatrixPayloadBuilder builder =
                GitLabProjectIntegrationsMatrixPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload())
                        .token(null);

        final GitLabProjectIntegrationsMatrixPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRoomIsNullable() {
        final GitLabProjectIntegrationsMatrixPayloadBuilder builder =
                GitLabProjectIntegrationsMatrixPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload())
                        .room(null);

        final GitLabProjectIntegrationsMatrixPayload built = builder.build();

        assertThat(built.room()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabProjectIntegrationsMatrixPayloadBuilder builder =
                GitLabProjectIntegrationsMatrixPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabProjectIntegrationsMatrixPayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabProjectIntegrationsMatrixPayloadBuilder builder =
                GitLabProjectIntegrationsMatrixPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabProjectIntegrationsMatrixPayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsMatrixPayloadBuilder builder =
                GitLabProjectIntegrationsMatrixPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload())
                        .branchesToBeNotified(null);

        final GitLabProjectIntegrationsMatrixPayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsMatrixPayloadBuilder builder =
                GitLabProjectIntegrationsMatrixPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsMatrixPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsMatrixPayloadBuilder builder =
                GitLabProjectIntegrationsMatrixPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload())
                        .issuesEvents(null);

        final GitLabProjectIntegrationsMatrixPayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsMatrixPayloadBuilder builder =
                GitLabProjectIntegrationsMatrixPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload())
                        .confidentialIssuesEvents(null);

        final GitLabProjectIntegrationsMatrixPayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsMatrixPayloadBuilder builder =
                GitLabProjectIntegrationsMatrixPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsMatrixPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectIntegrationsMatrixPayloadBuilder builder =
                GitLabProjectIntegrationsMatrixPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload())
                        .noteEvents(null);

        final GitLabProjectIntegrationsMatrixPayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabProjectIntegrationsMatrixPayloadBuilder builder =
                GitLabProjectIntegrationsMatrixPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload())
                        .confidentialNoteEvents(null);

        final GitLabProjectIntegrationsMatrixPayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsMatrixPayloadBuilder builder =
                GitLabProjectIntegrationsMatrixPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsMatrixPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsMatrixPayloadBuilder builder =
                GitLabProjectIntegrationsMatrixPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsMatrixPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabProjectIntegrationsMatrixPayloadBuilder builder =
                GitLabProjectIntegrationsMatrixPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload())
                        .wikiPageEvents(null);

        final GitLabProjectIntegrationsMatrixPayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentEventsIsNullable() {
        final GitLabProjectIntegrationsMatrixPayloadBuilder builder =
                GitLabProjectIntegrationsMatrixPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload())
                        .incidentEvents(null);

        final GitLabProjectIntegrationsMatrixPayload built = builder.build();

        assertThat(built.incidentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsMatrixPayloadBuilder builder =
                GitLabProjectIntegrationsMatrixPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload())
                        .workItemEvents(null);

        final GitLabProjectIntegrationsMatrixPayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsMatrixPayloadBuilder builder =
                GitLabProjectIntegrationsMatrixPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload())
                        .confidentialWorkItemEvents(null);

        final GitLabProjectIntegrationsMatrixPayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityEventsIsNullable() {
        final GitLabProjectIntegrationsMatrixPayloadBuilder builder =
                GitLabProjectIntegrationsMatrixPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload())
                        .vulnerabilityEvents(null);

        final GitLabProjectIntegrationsMatrixPayload built = builder.build();

        assertThat(built.vulnerabilityEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsMatrixPayloadBuilder builder =
                GitLabProjectIntegrationsMatrixPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsMatrixPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsMatrixPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload();

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
        final GitLabProjectIntegrationsMatrixPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload();

        final GitLabProjectIntegrationsMatrixPayload rebuilt =
                GitLabProjectIntegrationsMatrixPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsMatrixPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsMatrixPayload.class.getRecordComponents())
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

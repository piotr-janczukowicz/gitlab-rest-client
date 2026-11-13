package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsMatrixServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenHostnameIsNullable() {
        final GitLabProjectIntegrationsMatrixServicePayloadBuilder builder =
                GitLabProjectIntegrationsMatrixServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload())
                        .hostname(null);

        final GitLabProjectIntegrationsMatrixServicePayload built = builder.build();

        assertThat(built.hostname()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsMatrixServicePayloadBuilder builder =
                GitLabProjectIntegrationsMatrixServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload())
                        .token(null);

        final GitLabProjectIntegrationsMatrixServicePayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRoomIsNullable() {
        final GitLabProjectIntegrationsMatrixServicePayloadBuilder builder =
                GitLabProjectIntegrationsMatrixServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload())
                        .room(null);

        final GitLabProjectIntegrationsMatrixServicePayload built = builder.build();

        assertThat(built.room()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabProjectIntegrationsMatrixServicePayloadBuilder builder =
                GitLabProjectIntegrationsMatrixServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabProjectIntegrationsMatrixServicePayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabProjectIntegrationsMatrixServicePayloadBuilder builder =
                GitLabProjectIntegrationsMatrixServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabProjectIntegrationsMatrixServicePayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsMatrixServicePayloadBuilder builder =
                GitLabProjectIntegrationsMatrixServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload())
                        .branchesToBeNotified(null);

        final GitLabProjectIntegrationsMatrixServicePayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsMatrixServicePayloadBuilder builder =
                GitLabProjectIntegrationsMatrixServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsMatrixServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsMatrixServicePayloadBuilder builder =
                GitLabProjectIntegrationsMatrixServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload())
                        .issuesEvents(null);

        final GitLabProjectIntegrationsMatrixServicePayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsMatrixServicePayloadBuilder builder =
                GitLabProjectIntegrationsMatrixServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload())
                        .confidentialIssuesEvents(null);

        final GitLabProjectIntegrationsMatrixServicePayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsMatrixServicePayloadBuilder builder =
                GitLabProjectIntegrationsMatrixServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsMatrixServicePayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectIntegrationsMatrixServicePayloadBuilder builder =
                GitLabProjectIntegrationsMatrixServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload())
                        .noteEvents(null);

        final GitLabProjectIntegrationsMatrixServicePayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabProjectIntegrationsMatrixServicePayloadBuilder builder =
                GitLabProjectIntegrationsMatrixServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload())
                        .confidentialNoteEvents(null);

        final GitLabProjectIntegrationsMatrixServicePayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsMatrixServicePayloadBuilder builder =
                GitLabProjectIntegrationsMatrixServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsMatrixServicePayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsMatrixServicePayloadBuilder builder =
                GitLabProjectIntegrationsMatrixServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsMatrixServicePayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabProjectIntegrationsMatrixServicePayloadBuilder builder =
                GitLabProjectIntegrationsMatrixServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload())
                        .wikiPageEvents(null);

        final GitLabProjectIntegrationsMatrixServicePayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentEventsIsNullable() {
        final GitLabProjectIntegrationsMatrixServicePayloadBuilder builder =
                GitLabProjectIntegrationsMatrixServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload())
                        .incidentEvents(null);

        final GitLabProjectIntegrationsMatrixServicePayload built = builder.build();

        assertThat(built.incidentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsMatrixServicePayloadBuilder builder =
                GitLabProjectIntegrationsMatrixServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload())
                        .workItemEvents(null);

        final GitLabProjectIntegrationsMatrixServicePayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsMatrixServicePayloadBuilder builder =
                GitLabProjectIntegrationsMatrixServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload())
                        .confidentialWorkItemEvents(null);

        final GitLabProjectIntegrationsMatrixServicePayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityEventsIsNullable() {
        final GitLabProjectIntegrationsMatrixServicePayloadBuilder builder =
                GitLabProjectIntegrationsMatrixServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload())
                        .vulnerabilityEvents(null);

        final GitLabProjectIntegrationsMatrixServicePayload built = builder.build();

        assertThat(built.vulnerabilityEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsMatrixServicePayloadBuilder builder =
                GitLabProjectIntegrationsMatrixServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsMatrixServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsMatrixServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload();

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
        final GitLabProjectIntegrationsMatrixServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload();

        final GitLabProjectIntegrationsMatrixServicePayload rebuilt =
                GitLabProjectIntegrationsMatrixServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsMatrixServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsMatrixServicePayload.class.getRecordComponents())
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

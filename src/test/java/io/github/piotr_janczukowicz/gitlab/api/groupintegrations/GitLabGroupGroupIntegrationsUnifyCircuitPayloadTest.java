package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsUnifyCircuitPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWebhookIsNullable() {
        final GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUnifyCircuitPayload())
                        .webhook(null);

        final GitLabGroupGroupIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.webhook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUnifyCircuitPayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabGroupGroupIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUnifyCircuitPayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabGroupGroupIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUnifyCircuitPayload())
                        .branchesToBeNotified(null);

        final GitLabGroupGroupIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUnifyCircuitPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUnifyCircuitPayload())
                        .issuesEvents(null);

        final GitLabGroupGroupIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUnifyCircuitPayload())
                        .confidentialIssuesEvents(null);

        final GitLabGroupGroupIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUnifyCircuitPayload())
                        .workItemEvents(null);

        final GitLabGroupGroupIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUnifyCircuitPayload())
                        .confidentialWorkItemEvents(null);

        final GitLabGroupGroupIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUnifyCircuitPayload())
                        .mergeRequestsEvents(null);

        final GitLabGroupGroupIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUnifyCircuitPayload())
                        .noteEvents(null);

        final GitLabGroupGroupIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUnifyCircuitPayload())
                        .confidentialNoteEvents(null);

        final GitLabGroupGroupIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUnifyCircuitPayload())
                        .tagPushEvents(null);

        final GitLabGroupGroupIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUnifyCircuitPayload())
                        .pipelineEvents(null);

        final GitLabGroupGroupIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUnifyCircuitPayload())
                        .wikiPageEvents(null);

        final GitLabGroupGroupIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUnifyCircuitPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsUnifyCircuitPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUnifyCircuitPayload();

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
        final GitLabGroupGroupIntegrationsUnifyCircuitPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUnifyCircuitPayload();

        final GitLabGroupGroupIntegrationsUnifyCircuitPayload rebuilt =
                GitLabGroupGroupIntegrationsUnifyCircuitPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupIntegrationsUnifyCircuitPayload.class.getRecordComponents())
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

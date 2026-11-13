package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsUnifyCircuitServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWebhookIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitServicePayload())
                        .webhook(null);

        final GitLabProjectIntegrationsUnifyCircuitServicePayload built = builder.build();

        assertThat(built.webhook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitServicePayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabProjectIntegrationsUnifyCircuitServicePayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitServicePayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabProjectIntegrationsUnifyCircuitServicePayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitServicePayload())
                        .branchesToBeNotified(null);

        final GitLabProjectIntegrationsUnifyCircuitServicePayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsUnifyCircuitServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitServicePayload())
                        .issuesEvents(null);

        final GitLabProjectIntegrationsUnifyCircuitServicePayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitServicePayload())
                        .confidentialIssuesEvents(null);

        final GitLabProjectIntegrationsUnifyCircuitServicePayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitServicePayload())
                        .workItemEvents(null);

        final GitLabProjectIntegrationsUnifyCircuitServicePayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitServicePayload())
                        .confidentialWorkItemEvents(null);

        final GitLabProjectIntegrationsUnifyCircuitServicePayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitServicePayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsUnifyCircuitServicePayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitServicePayload())
                        .noteEvents(null);

        final GitLabProjectIntegrationsUnifyCircuitServicePayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitServicePayload())
                        .confidentialNoteEvents(null);

        final GitLabProjectIntegrationsUnifyCircuitServicePayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitServicePayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsUnifyCircuitServicePayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitServicePayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsUnifyCircuitServicePayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitServicePayload())
                        .wikiPageEvents(null);

        final GitLabProjectIntegrationsUnifyCircuitServicePayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsUnifyCircuitServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsUnifyCircuitServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitServicePayload();

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
        final GitLabProjectIntegrationsUnifyCircuitServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitServicePayload();

        final GitLabProjectIntegrationsUnifyCircuitServicePayload rebuilt =
                GitLabProjectIntegrationsUnifyCircuitServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsUnifyCircuitServicePayload.class.getRecordComponents())
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

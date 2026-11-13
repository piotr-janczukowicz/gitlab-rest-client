package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsUnifyCircuitPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWebhookIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitPayload())
                        .webhook(null);

        final GitLabProjectIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.webhook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitPayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabProjectIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitPayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabProjectIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitPayload())
                        .branchesToBeNotified(null);

        final GitLabProjectIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitPayload())
                        .issuesEvents(null);

        final GitLabProjectIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitPayload())
                        .confidentialIssuesEvents(null);

        final GitLabProjectIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitPayload())
                        .workItemEvents(null);

        final GitLabProjectIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.workItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialWorkItemEventsIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitPayload())
                        .confidentialWorkItemEvents(null);

        final GitLabProjectIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.confidentialWorkItemEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitPayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitPayload())
                        .noteEvents(null);

        final GitLabProjectIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitPayload())
                        .confidentialNoteEvents(null);

        final GitLabProjectIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitPayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitPayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitPayload())
                        .wikiPageEvents(null);

        final GitLabProjectIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsUnifyCircuitPayloadBuilder builder =
                GitLabProjectIntegrationsUnifyCircuitPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsUnifyCircuitPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsUnifyCircuitPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitPayload();

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
        final GitLabProjectIntegrationsUnifyCircuitPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitPayload();

        final GitLabProjectIntegrationsUnifyCircuitPayload rebuilt =
                GitLabProjectIntegrationsUnifyCircuitPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsUnifyCircuitPayload.class.getRecordComponents())
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

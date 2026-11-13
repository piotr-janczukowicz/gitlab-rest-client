package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsPipelinesEmailPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenRecipientsIsNullable() {
        final GitLabProjectIntegrationsPipelinesEmailPayloadBuilder builder =
                GitLabProjectIntegrationsPipelinesEmailPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailPayload())
                        .recipients(null);

        final GitLabProjectIntegrationsPipelinesEmailPayload built = builder.build();

        assertThat(built.recipients()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabProjectIntegrationsPipelinesEmailPayloadBuilder builder =
                GitLabProjectIntegrationsPipelinesEmailPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailPayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabProjectIntegrationsPipelinesEmailPayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabProjectIntegrationsPipelinesEmailPayloadBuilder builder =
                GitLabProjectIntegrationsPipelinesEmailPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailPayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabProjectIntegrationsPipelinesEmailPayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyDefaultBranchIsNullable() {
        final GitLabProjectIntegrationsPipelinesEmailPayloadBuilder builder =
                GitLabProjectIntegrationsPipelinesEmailPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailPayload())
                        .notifyOnlyDefaultBranch(null);

        final GitLabProjectIntegrationsPipelinesEmailPayload built = builder.build();

        assertThat(built.notifyOnlyDefaultBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsPipelinesEmailPayloadBuilder builder =
                GitLabProjectIntegrationsPipelinesEmailPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailPayload())
                        .branchesToBeNotified(null);

        final GitLabProjectIntegrationsPipelinesEmailPayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyChildPipelinesIsNullable() {
        final GitLabProjectIntegrationsPipelinesEmailPayloadBuilder builder =
                GitLabProjectIntegrationsPipelinesEmailPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailPayload())
                        .notifyChildPipelines(null);

        final GitLabProjectIntegrationsPipelinesEmailPayload built = builder.build();

        assertThat(built.notifyChildPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsPipelinesEmailPayloadBuilder builder =
                GitLabProjectIntegrationsPipelinesEmailPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailPayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsPipelinesEmailPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsPipelinesEmailPayloadBuilder builder =
                GitLabProjectIntegrationsPipelinesEmailPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsPipelinesEmailPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsPipelinesEmailPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.recipients()).isEqualTo("recipients");
            softly.assertThat(value.notifyOnlyBrokenPipelines()).isEqualTo(true);
            softly.assertThat(value.notifyOnlyWhenPipelineStatusChanges()).isEqualTo(true);
            softly.assertThat(value.notifyOnlyDefaultBranch()).isEqualTo(true);
            softly.assertThat(value.branchesToBeNotified()).isEqualTo("branches_to_be_notified");
            softly.assertThat(value.notifyChildPipelines()).isEqualTo(true);
            softly.assertThat(value.pipelineEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsPipelinesEmailPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailPayload();

        final GitLabProjectIntegrationsPipelinesEmailPayload rebuilt =
                GitLabProjectIntegrationsPipelinesEmailPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsPipelinesEmailPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "recipients",
                        "notifyOnlyBrokenPipelines",
                        "notifyOnlyWhenPipelineStatusChanges",
                        "notifyOnlyDefaultBranch",
                        "branchesToBeNotified",
                        "notifyChildPipelines",
                        "pipelineEvents",
                        "useInheritedSettings");
    }
}

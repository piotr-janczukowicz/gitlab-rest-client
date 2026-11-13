package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsPipelinesEmailPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenRecipientsIsNullable() {
        final GitLabGroupGroupIntegrationsPipelinesEmailPayloadBuilder builder =
                GitLabGroupGroupIntegrationsPipelinesEmailPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPipelinesEmailPayload())
                        .recipients(null);

        final GitLabGroupGroupIntegrationsPipelinesEmailPayload built = builder.build();

        assertThat(built.recipients()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabGroupGroupIntegrationsPipelinesEmailPayloadBuilder builder =
                GitLabGroupGroupIntegrationsPipelinesEmailPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPipelinesEmailPayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabGroupGroupIntegrationsPipelinesEmailPayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabGroupGroupIntegrationsPipelinesEmailPayloadBuilder builder =
                GitLabGroupGroupIntegrationsPipelinesEmailPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPipelinesEmailPayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabGroupGroupIntegrationsPipelinesEmailPayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyDefaultBranchIsNullable() {
        final GitLabGroupGroupIntegrationsPipelinesEmailPayloadBuilder builder =
                GitLabGroupGroupIntegrationsPipelinesEmailPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPipelinesEmailPayload())
                        .notifyOnlyDefaultBranch(null);

        final GitLabGroupGroupIntegrationsPipelinesEmailPayload built = builder.build();

        assertThat(built.notifyOnlyDefaultBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabGroupGroupIntegrationsPipelinesEmailPayloadBuilder builder =
                GitLabGroupGroupIntegrationsPipelinesEmailPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPipelinesEmailPayload())
                        .branchesToBeNotified(null);

        final GitLabGroupGroupIntegrationsPipelinesEmailPayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyChildPipelinesIsNullable() {
        final GitLabGroupGroupIntegrationsPipelinesEmailPayloadBuilder builder =
                GitLabGroupGroupIntegrationsPipelinesEmailPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPipelinesEmailPayload())
                        .notifyChildPipelines(null);

        final GitLabGroupGroupIntegrationsPipelinesEmailPayload built = builder.build();

        assertThat(built.notifyChildPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabGroupGroupIntegrationsPipelinesEmailPayloadBuilder builder =
                GitLabGroupGroupIntegrationsPipelinesEmailPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPipelinesEmailPayload())
                        .pipelineEvents(null);

        final GitLabGroupGroupIntegrationsPipelinesEmailPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsPipelinesEmailPayloadBuilder builder =
                GitLabGroupGroupIntegrationsPipelinesEmailPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPipelinesEmailPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsPipelinesEmailPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsPipelinesEmailPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPipelinesEmailPayload();

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
        final GitLabGroupGroupIntegrationsPipelinesEmailPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPipelinesEmailPayload();

        final GitLabGroupGroupIntegrationsPipelinesEmailPayload rebuilt =
                GitLabGroupGroupIntegrationsPipelinesEmailPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupIntegrationsPipelinesEmailPayload.class.getRecordComponents())
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

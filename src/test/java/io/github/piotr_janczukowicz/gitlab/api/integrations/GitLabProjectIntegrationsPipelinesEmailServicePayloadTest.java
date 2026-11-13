package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsPipelinesEmailServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenRecipientsIsNullable() {
        final GitLabProjectIntegrationsPipelinesEmailServicePayloadBuilder builder =
                GitLabProjectIntegrationsPipelinesEmailServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailServicePayload())
                        .recipients(null);

        final GitLabProjectIntegrationsPipelinesEmailServicePayload built = builder.build();

        assertThat(built.recipients()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyBrokenPipelinesIsNullable() {
        final GitLabProjectIntegrationsPipelinesEmailServicePayloadBuilder builder =
                GitLabProjectIntegrationsPipelinesEmailServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailServicePayload())
                        .notifyOnlyBrokenPipelines(null);

        final GitLabProjectIntegrationsPipelinesEmailServicePayload built = builder.build();

        assertThat(built.notifyOnlyBrokenPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyWhenPipelineStatusChangesIsNullable() {
        final GitLabProjectIntegrationsPipelinesEmailServicePayloadBuilder builder =
                GitLabProjectIntegrationsPipelinesEmailServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailServicePayload())
                        .notifyOnlyWhenPipelineStatusChanges(null);

        final GitLabProjectIntegrationsPipelinesEmailServicePayload built = builder.build();

        assertThat(built.notifyOnlyWhenPipelineStatusChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnlyDefaultBranchIsNullable() {
        final GitLabProjectIntegrationsPipelinesEmailServicePayloadBuilder builder =
                GitLabProjectIntegrationsPipelinesEmailServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailServicePayload())
                        .notifyOnlyDefaultBranch(null);

        final GitLabProjectIntegrationsPipelinesEmailServicePayload built = builder.build();

        assertThat(built.notifyOnlyDefaultBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabProjectIntegrationsPipelinesEmailServicePayloadBuilder builder =
                GitLabProjectIntegrationsPipelinesEmailServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailServicePayload())
                        .branchesToBeNotified(null);

        final GitLabProjectIntegrationsPipelinesEmailServicePayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyChildPipelinesIsNullable() {
        final GitLabProjectIntegrationsPipelinesEmailServicePayloadBuilder builder =
                GitLabProjectIntegrationsPipelinesEmailServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailServicePayload())
                        .notifyChildPipelines(null);

        final GitLabProjectIntegrationsPipelinesEmailServicePayload built = builder.build();

        assertThat(built.notifyChildPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsPipelinesEmailServicePayloadBuilder builder =
                GitLabProjectIntegrationsPipelinesEmailServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailServicePayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsPipelinesEmailServicePayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsPipelinesEmailServicePayloadBuilder builder =
                GitLabProjectIntegrationsPipelinesEmailServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsPipelinesEmailServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsPipelinesEmailServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailServicePayload();

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
        final GitLabProjectIntegrationsPipelinesEmailServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailServicePayload();

        final GitLabProjectIntegrationsPipelinesEmailServicePayload rebuilt =
                GitLabProjectIntegrationsPipelinesEmailServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsPipelinesEmailServicePayload.class.getRecordComponents())
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

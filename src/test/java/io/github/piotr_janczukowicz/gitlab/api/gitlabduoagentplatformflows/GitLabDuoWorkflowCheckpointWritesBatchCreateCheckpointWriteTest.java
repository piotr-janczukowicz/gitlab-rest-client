package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWriteTest {

    @Test
    void constructor_shouldAcceptNull_whenTaskIsNullable() {
        final GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWriteBuilder builder =
                GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWriteBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoWorkflowCheckpointWritesBatchCreateCheckpointWrite())
                        .task(null);

        final GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWrite built = builder.build();

        assertThat(built.task()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIdxIsNullable() {
        final GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWriteBuilder builder =
                GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWriteBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoWorkflowCheckpointWritesBatchCreateCheckpointWrite())
                        .idx(null);

        final GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWrite built = builder.build();

        assertThat(built.idx()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChannelIsNullable() {
        final GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWriteBuilder builder =
                GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWriteBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoWorkflowCheckpointWritesBatchCreateCheckpointWrite())
                        .channel(null);

        final GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWrite built = builder.build();

        assertThat(built.channel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWriteTypeIsNullable() {
        final GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWriteBuilder builder =
                GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWriteBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoWorkflowCheckpointWritesBatchCreateCheckpointWrite())
                        .writeType(null);

        final GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWrite built = builder.build();

        assertThat(built.writeType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDataIsNullable() {
        final GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWriteBuilder builder =
                GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWriteBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoWorkflowCheckpointWritesBatchCreateCheckpointWrite())
                        .data(null);

        final GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWrite built = builder.build();

        assertThat(built.data()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWrite value =
                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointWritesBatchCreateCheckpointWrite();

        assertSoftly(softly -> {
            softly.assertThat(value.task()).isEqualTo("task");
            softly.assertThat(value.idx()).isEqualTo(1);
            softly.assertThat(value.channel()).isEqualTo("channel");
            softly.assertThat(value.writeType()).isEqualTo("write_type");
            softly.assertThat(value.data()).isEqualTo("data");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWrite original =
                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointWritesBatchCreateCheckpointWrite();

        final GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWrite rebuilt =
                GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWriteBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWrite.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("task", "idx", "channel", "writeType", "data");
    }
}

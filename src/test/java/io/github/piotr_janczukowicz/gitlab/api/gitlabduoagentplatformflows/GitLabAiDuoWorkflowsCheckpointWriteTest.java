package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAiDuoWorkflowsCheckpointWriteTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabAiDuoWorkflowsCheckpointWriteBuilder builder = GitLabAiDuoWorkflowsCheckpointWriteBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpointWrite())
                .id(null);

        final GitLabAiDuoWorkflowsCheckpointWrite built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThreadTsIsNullable() {
        final GitLabAiDuoWorkflowsCheckpointWriteBuilder builder = GitLabAiDuoWorkflowsCheckpointWriteBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpointWrite())
                .threadTs(null);

        final GitLabAiDuoWorkflowsCheckpointWrite built = builder.build();

        assertThat(built.threadTs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTaskIsNullable() {
        final GitLabAiDuoWorkflowsCheckpointWriteBuilder builder = GitLabAiDuoWorkflowsCheckpointWriteBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpointWrite())
                .task(null);

        final GitLabAiDuoWorkflowsCheckpointWrite built = builder.build();

        assertThat(built.task()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIdxIsNullable() {
        final GitLabAiDuoWorkflowsCheckpointWriteBuilder builder = GitLabAiDuoWorkflowsCheckpointWriteBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpointWrite())
                .idx(null);

        final GitLabAiDuoWorkflowsCheckpointWrite built = builder.build();

        assertThat(built.idx()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChannelIsNullable() {
        final GitLabAiDuoWorkflowsCheckpointWriteBuilder builder = GitLabAiDuoWorkflowsCheckpointWriteBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpointWrite())
                .channel(null);

        final GitLabAiDuoWorkflowsCheckpointWrite built = builder.build();

        assertThat(built.channel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWriteTypeIsNullable() {
        final GitLabAiDuoWorkflowsCheckpointWriteBuilder builder = GitLabAiDuoWorkflowsCheckpointWriteBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpointWrite())
                .writeType(null);

        final GitLabAiDuoWorkflowsCheckpointWrite built = builder.build();

        assertThat(built.writeType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDataIsNullable() {
        final GitLabAiDuoWorkflowsCheckpointWriteBuilder builder = GitLabAiDuoWorkflowsCheckpointWriteBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpointWrite())
                .data(null);

        final GitLabAiDuoWorkflowsCheckpointWrite built = builder.build();

        assertThat(built.data()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAiDuoWorkflowsCheckpointWrite value =
                GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpointWrite();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.threadTs()).isEqualTo("thread_ts");
            softly.assertThat(value.task()).isEqualTo("task");
            softly.assertThat(value.idx()).isEqualTo(1);
            softly.assertThat(value.channel()).isEqualTo("channel");
            softly.assertThat(value.writeType()).isEqualTo("write_type");
            softly.assertThat(value.data()).isEqualTo("data");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAiDuoWorkflowsCheckpointWrite original =
                GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpointWrite();

        final GitLabAiDuoWorkflowsCheckpointWrite rebuilt =
                GitLabAiDuoWorkflowsCheckpointWriteBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAiDuoWorkflowsCheckpointWrite.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "threadTs", "task", "idx", "channel", "writeType", "data");
    }
}

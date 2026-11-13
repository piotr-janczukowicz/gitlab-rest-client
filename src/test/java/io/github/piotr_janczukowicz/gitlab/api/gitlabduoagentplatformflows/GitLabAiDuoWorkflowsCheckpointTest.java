package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAiDuoWorkflowsCheckpointTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabAiDuoWorkflowsCheckpointBuilder builder = GitLabAiDuoWorkflowsCheckpointBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpoint())
                .id(null);

        final GitLabAiDuoWorkflowsCheckpoint built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThreadTsIsNullable() {
        final GitLabAiDuoWorkflowsCheckpointBuilder builder = GitLabAiDuoWorkflowsCheckpointBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpoint())
                .threadTs(null);

        final GitLabAiDuoWorkflowsCheckpoint built = builder.build();

        assertThat(built.threadTs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenParentTsIsNullable() {
        final GitLabAiDuoWorkflowsCheckpointBuilder builder = GitLabAiDuoWorkflowsCheckpointBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpoint())
                .parentTs(null);

        final GitLabAiDuoWorkflowsCheckpoint built = builder.build();

        assertThat(built.parentTs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCheckpointNsIsNullable() {
        final GitLabAiDuoWorkflowsCheckpointBuilder builder = GitLabAiDuoWorkflowsCheckpointBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpoint())
                .checkpointNs(null);

        final GitLabAiDuoWorkflowsCheckpoint built = builder.build();

        assertThat(built.checkpointNs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCheckpointIsNullable() {
        final GitLabAiDuoWorkflowsCheckpointBuilder builder = GitLabAiDuoWorkflowsCheckpointBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpoint())
                .checkpoint(null);

        final GitLabAiDuoWorkflowsCheckpoint built = builder.build();

        assertThat(built.checkpoint()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCompressedCheckpointIsNullable() {
        final GitLabAiDuoWorkflowsCheckpointBuilder builder = GitLabAiDuoWorkflowsCheckpointBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpoint())
                .compressedCheckpoint(null);

        final GitLabAiDuoWorkflowsCheckpoint built = builder.build();

        assertThat(built.compressedCheckpoint()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCheckpointWritesIsNullable() {
        final GitLabAiDuoWorkflowsCheckpointBuilder builder = GitLabAiDuoWorkflowsCheckpointBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpoint())
                .checkpointWrites(null);

        final GitLabAiDuoWorkflowsCheckpoint built = builder.build();

        assertThat(built.checkpointWrites()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCurrentThreadIsNullable() {
        final GitLabAiDuoWorkflowsCheckpointBuilder builder = GitLabAiDuoWorkflowsCheckpointBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpoint())
                .currentThread(null);

        final GitLabAiDuoWorkflowsCheckpoint built = builder.build();

        assertThat(built.currentThread()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMetadataIsNullable() {
        final GitLabAiDuoWorkflowsCheckpointBuilder builder = GitLabAiDuoWorkflowsCheckpointBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpoint())
                .metadata(null);

        final GitLabAiDuoWorkflowsCheckpoint built = builder.build();

        assertThat(built.metadata()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAiDuoWorkflowsCheckpoint value =
                GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpoint();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.threadTs()).isEqualTo("thread_ts");
            softly.assertThat(value.parentTs()).isEqualTo("parent_ts");
            softly.assertThat(value.checkpointNs()).isEqualTo("checkpoint_ns");
            softly.assertThat(value.checkpoint()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.compressedCheckpoint()).isEqualTo("compressed_checkpoint");
            softly.assertThat(value.checkpointWrites())
                    .isEqualTo(List.of(GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpointWrite()));
            softly.assertThat(value.currentThread()).isEqualTo(1);
            softly.assertThat(value.metadata()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAiDuoWorkflowsCheckpoint original =
                GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsCheckpoint();

        final GitLabAiDuoWorkflowsCheckpoint rebuilt =
                GitLabAiDuoWorkflowsCheckpointBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAiDuoWorkflowsCheckpoint.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "threadTs",
                        "parentTs",
                        "checkpointNs",
                        "checkpoint",
                        "compressedCheckpoint",
                        "checkpointWrites",
                        "currentThread",
                        "metadata");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAiDuoWorkflowsBasicCheckpointTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabAiDuoWorkflowsBasicCheckpointBuilder builder = GitLabAiDuoWorkflowsBasicCheckpointBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsBasicCheckpoint())
                .id(null);

        final GitLabAiDuoWorkflowsBasicCheckpoint built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThreadTsIsNullable() {
        final GitLabAiDuoWorkflowsBasicCheckpointBuilder builder = GitLabAiDuoWorkflowsBasicCheckpointBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsBasicCheckpoint())
                .threadTs(null);

        final GitLabAiDuoWorkflowsBasicCheckpoint built = builder.build();

        assertThat(built.threadTs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenParentTsIsNullable() {
        final GitLabAiDuoWorkflowsBasicCheckpointBuilder builder = GitLabAiDuoWorkflowsBasicCheckpointBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsBasicCheckpoint())
                .parentTs(null);

        final GitLabAiDuoWorkflowsBasicCheckpoint built = builder.build();

        assertThat(built.parentTs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCheckpointNsIsNullable() {
        final GitLabAiDuoWorkflowsBasicCheckpointBuilder builder = GitLabAiDuoWorkflowsBasicCheckpointBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsBasicCheckpoint())
                .checkpointNs(null);

        final GitLabAiDuoWorkflowsBasicCheckpoint built = builder.build();

        assertThat(built.checkpointNs()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAiDuoWorkflowsBasicCheckpoint value =
                GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsBasicCheckpoint();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.threadTs()).isEqualTo("thread_ts");
            softly.assertThat(value.parentTs()).isEqualTo("parent_ts");
            softly.assertThat(value.checkpointNs()).isEqualTo("checkpoint_ns");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAiDuoWorkflowsBasicCheckpoint original =
                GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsBasicCheckpoint();

        final GitLabAiDuoWorkflowsBasicCheckpoint rebuilt =
                GitLabAiDuoWorkflowsBasicCheckpointBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAiDuoWorkflowsBasicCheckpoint.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "threadTs", "parentTs", "checkpointNs");
    }
}

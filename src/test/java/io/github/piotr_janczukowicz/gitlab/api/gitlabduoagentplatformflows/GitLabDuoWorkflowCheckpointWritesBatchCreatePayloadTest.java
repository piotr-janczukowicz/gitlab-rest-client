package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDuoWorkflowCheckpointWritesBatchCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenThreadTsIsNullable() {
        final GitLabDuoWorkflowCheckpointWritesBatchCreatePayloadBuilder builder =
                GitLabDuoWorkflowCheckpointWritesBatchCreatePayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoWorkflowCheckpointWritesBatchCreatePayload())
                        .threadTs(null);

        final GitLabDuoWorkflowCheckpointWritesBatchCreatePayload built = builder.build();

        assertThat(built.threadTs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCheckpointWritesIsNullable() {
        final GitLabDuoWorkflowCheckpointWritesBatchCreatePayloadBuilder builder =
                GitLabDuoWorkflowCheckpointWritesBatchCreatePayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoWorkflowCheckpointWritesBatchCreatePayload())
                        .checkpointWrites(null);

        final GitLabDuoWorkflowCheckpointWritesBatchCreatePayload built = builder.build();

        assertThat(built.checkpointWrites()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoWorkflowCheckpointWritesBatchCreatePayload value =
                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointWritesBatchCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.threadTs()).isEqualTo("thread_ts");
            softly.assertThat(value.checkpointWrites())
                    .isEqualTo(List.of(
                            GitlabduoagentplatformflowsCatalogFixtures
                                    .duoWorkflowCheckpointWritesBatchCreateCheckpointWrite()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoWorkflowCheckpointWritesBatchCreatePayload original =
                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointWritesBatchCreatePayload();

        final GitLabDuoWorkflowCheckpointWritesBatchCreatePayload rebuilt =
                GitLabDuoWorkflowCheckpointWritesBatchCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenCheckpointWritesSourceChangesLater() {
        final List<GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWrite> source = new ArrayList<>(List.of(
                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointWritesBatchCreateCheckpointWrite()));
        final GitLabDuoWorkflowCheckpointWritesBatchCreatePayload built =
                GitLabDuoWorkflowCheckpointWritesBatchCreatePayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoWorkflowCheckpointWritesBatchCreatePayload())
                        .checkpointWrites(source)
                        .build();
        source.clear();

        assertThat(built.checkpointWrites()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenCheckpointWritesIsRead() {
        final GitLabDuoWorkflowCheckpointWritesBatchCreatePayload built =
                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointWritesBatchCreatePayload();
        final List<GitLabDuoWorkflowCheckpointWritesBatchCreateCheckpointWrite> values = built.checkpointWrites();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabDuoWorkflowCheckpointWritesBatchCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("threadTs", "checkpointWrites");
    }
}

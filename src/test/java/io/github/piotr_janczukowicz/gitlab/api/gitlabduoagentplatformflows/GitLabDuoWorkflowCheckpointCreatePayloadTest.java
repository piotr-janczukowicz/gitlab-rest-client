package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDuoWorkflowCheckpointCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenThreadTsIsNullable() {
        final GitLabDuoWorkflowCheckpointCreatePayloadBuilder builder =
                GitLabDuoWorkflowCheckpointCreatePayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreatePayload())
                        .threadTs(null);

        final GitLabDuoWorkflowCheckpointCreatePayload built = builder.build();

        assertThat(built.threadTs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenParentTsIsNullable() {
        final GitLabDuoWorkflowCheckpointCreatePayloadBuilder builder =
                GitLabDuoWorkflowCheckpointCreatePayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreatePayload())
                        .parentTs(null);

        final GitLabDuoWorkflowCheckpointCreatePayload built = builder.build();

        assertThat(built.parentTs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCheckpointNsIsNullable() {
        final GitLabDuoWorkflowCheckpointCreatePayloadBuilder builder =
                GitLabDuoWorkflowCheckpointCreatePayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreatePayload())
                        .checkpointNs(null);

        final GitLabDuoWorkflowCheckpointCreatePayload built = builder.build();

        assertThat(built.checkpointNs()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenCheckpointNsIsTooLong() {
        final GitLabDuoWorkflowCheckpointCreatePayloadBuilder builder =
                GitLabDuoWorkflowCheckpointCreatePayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreatePayload())
                        .checkpointNs("x".repeat(4097));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenCheckpointNsHasTheMaximumLength() {
        final GitLabDuoWorkflowCheckpointCreatePayloadBuilder builder =
                GitLabDuoWorkflowCheckpointCreatePayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreatePayload())
                        .checkpointNs("x".repeat(4096));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCheckpointIsNullable() {
        final GitLabDuoWorkflowCheckpointCreatePayloadBuilder builder =
                GitLabDuoWorkflowCheckpointCreatePayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreatePayload())
                        .checkpoint(null);

        final GitLabDuoWorkflowCheckpointCreatePayload built = builder.build();

        assertThat(built.checkpoint()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCompressedCheckpointIsNullable() {
        final GitLabDuoWorkflowCheckpointCreatePayloadBuilder builder =
                GitLabDuoWorkflowCheckpointCreatePayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreatePayload())
                        .compressedCheckpoint(null);

        final GitLabDuoWorkflowCheckpointCreatePayload built = builder.build();

        assertThat(built.compressedCheckpoint()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMetadataIsNullable() {
        final GitLabDuoWorkflowCheckpointCreatePayloadBuilder builder =
                GitLabDuoWorkflowCheckpointCreatePayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreatePayload())
                        .metadata(null);

        final GitLabDuoWorkflowCheckpointCreatePayload built = builder.build();

        assertThat(built.metadata()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenModelMetadataJsonIsNullable() {
        final GitLabDuoWorkflowCheckpointCreatePayloadBuilder builder =
                GitLabDuoWorkflowCheckpointCreatePayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreatePayload())
                        .modelMetadataJson(null);

        final GitLabDuoWorkflowCheckpointCreatePayload built = builder.build();

        assertThat(built.modelMetadataJson()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFlowMetadataJsonIsNullable() {
        final GitLabDuoWorkflowCheckpointCreatePayloadBuilder builder =
                GitLabDuoWorkflowCheckpointCreatePayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreatePayload())
                        .flowMetadataJson(null);

        final GitLabDuoWorkflowCheckpointCreatePayload built = builder.build();

        assertThat(built.flowMetadataJson()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCurrentThreadIsNullable() {
        final GitLabDuoWorkflowCheckpointCreatePayloadBuilder builder =
                GitLabDuoWorkflowCheckpointCreatePayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreatePayload())
                        .currentThread(null);

        final GitLabDuoWorkflowCheckpointCreatePayload built = builder.build();

        assertThat(built.currentThread()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChannelKeysIsNullable() {
        final GitLabDuoWorkflowCheckpointCreatePayloadBuilder builder =
                GitLabDuoWorkflowCheckpointCreatePayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreatePayload())
                        .channelKeys(null);

        final GitLabDuoWorkflowCheckpointCreatePayload built = builder.build();

        assertThat(built.channelKeys()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChannelBlobsIsNullable() {
        final GitLabDuoWorkflowCheckpointCreatePayloadBuilder builder =
                GitLabDuoWorkflowCheckpointCreatePayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreatePayload())
                        .channelBlobs(null);

        final GitLabDuoWorkflowCheckpointCreatePayload built = builder.build();

        assertThat(built.channelBlobs()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoWorkflowCheckpointCreatePayload value =
                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.threadTs()).isEqualTo("thread_ts");
            softly.assertThat(value.parentTs()).isEqualTo("parent_ts");
            softly.assertThat(value.checkpointNs()).isEqualTo("checkpoint_ns");
            softly.assertThat(value.checkpoint()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.compressedCheckpoint()).isEqualTo("compressed_checkpoint");
            softly.assertThat(value.metadata()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.modelMetadataJson()).isEqualTo("model_metadata_json");
            softly.assertThat(value.flowMetadataJson()).isEqualTo("flow_metadata_json");
            softly.assertThat(value.currentThread()).isEqualTo(1);
            softly.assertThat(value.channelKeys()).isEqualTo(List.of("channel_keys"));
            softly.assertThat(value.channelBlobs())
                    .isEqualTo(List.of(
                            GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreateChannelBlob()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoWorkflowCheckpointCreatePayload original =
                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreatePayload();

        final GitLabDuoWorkflowCheckpointCreatePayload rebuilt =
                GitLabDuoWorkflowCheckpointCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenCheckpointSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabDuoWorkflowCheckpointCreatePayload built = GitLabDuoWorkflowCheckpointCreatePayloadBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreatePayload())
                .checkpoint(source)
                .build();
        source.clear();

        assertThat(built.checkpoint()).isNotEmpty();
    }

    @Test
    void constructor_shouldCopyTheMap_whenMetadataSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabDuoWorkflowCheckpointCreatePayload built = GitLabDuoWorkflowCheckpointCreatePayloadBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreatePayload())
                .metadata(source)
                .build();
        source.clear();

        assertThat(built.metadata()).isNotEmpty();
    }

    @Test
    void constructor_shouldCopyTheList_whenChannelKeysSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("channel_keys"));
        final GitLabDuoWorkflowCheckpointCreatePayload built = GitLabDuoWorkflowCheckpointCreatePayloadBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreatePayload())
                .channelKeys(source)
                .build();
        source.clear();

        assertThat(built.channelKeys()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenChannelKeysIsRead() {
        final GitLabDuoWorkflowCheckpointCreatePayload built =
                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreatePayload();
        final List<String> values = built.channelKeys();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenChannelBlobsSourceChangesLater() {
        final List<GitLabDuoWorkflowCheckpointCreateChannelBlob> source = new ArrayList<>(
                List.of(GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreateChannelBlob()));
        final GitLabDuoWorkflowCheckpointCreatePayload built = GitLabDuoWorkflowCheckpointCreatePayloadBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreatePayload())
                .channelBlobs(source)
                .build();
        source.clear();

        assertThat(built.channelBlobs()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenChannelBlobsIsRead() {
        final GitLabDuoWorkflowCheckpointCreatePayload built =
                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreatePayload();
        final List<GitLabDuoWorkflowCheckpointCreateChannelBlob> values = built.channelBlobs();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDuoWorkflowCheckpointCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "threadTs",
                        "parentTs",
                        "checkpointNs",
                        "checkpoint",
                        "compressedCheckpoint",
                        "metadata",
                        "modelMetadataJson",
                        "flowMetadataJson",
                        "currentThread",
                        "channelKeys",
                        "channelBlobs");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDuoWorkflowCheckpointCreateChannelBlobTest {

    @Test
    void constructor_shouldAcceptNull_whenChannelIsNullable() {
        final GitLabDuoWorkflowCheckpointCreateChannelBlobBuilder builder =
                GitLabDuoWorkflowCheckpointCreateChannelBlobBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreateChannelBlob())
                        .channel(null);

        final GitLabDuoWorkflowCheckpointCreateChannelBlob built = builder.build();

        assertThat(built.channel()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenChannelIsTooLong() {
        final GitLabDuoWorkflowCheckpointCreateChannelBlobBuilder builder =
                GitLabDuoWorkflowCheckpointCreateChannelBlobBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreateChannelBlob())
                        .channel("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenChannelHasTheMaximumLength() {
        final GitLabDuoWorkflowCheckpointCreateChannelBlobBuilder builder =
                GitLabDuoWorkflowCheckpointCreateChannelBlobBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreateChannelBlob())
                        .channel("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabDuoWorkflowCheckpointCreateChannelBlobBuilder builder =
                GitLabDuoWorkflowCheckpointCreateChannelBlobBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreateChannelBlob())
                        .version(null);

        final GitLabDuoWorkflowCheckpointCreateChannelBlob built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenVersionIsTooLong() {
        final GitLabDuoWorkflowCheckpointCreateChannelBlobBuilder builder =
                GitLabDuoWorkflowCheckpointCreateChannelBlobBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreateChannelBlob())
                        .version("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenVersionHasTheMaximumLength() {
        final GitLabDuoWorkflowCheckpointCreateChannelBlobBuilder builder =
                GitLabDuoWorkflowCheckpointCreateChannelBlobBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreateChannelBlob())
                        .version("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWriteTypeIsNullable() {
        final GitLabDuoWorkflowCheckpointCreateChannelBlobBuilder builder =
                GitLabDuoWorkflowCheckpointCreateChannelBlobBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreateChannelBlob())
                        .writeType(null);

        final GitLabDuoWorkflowCheckpointCreateChannelBlob built = builder.build();

        assertThat(built.writeType()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenWriteTypeIsTooLong() {
        final GitLabDuoWorkflowCheckpointCreateChannelBlobBuilder builder =
                GitLabDuoWorkflowCheckpointCreateChannelBlobBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreateChannelBlob())
                        .writeType("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenWriteTypeHasTheMaximumLength() {
        final GitLabDuoWorkflowCheckpointCreateChannelBlobBuilder builder =
                GitLabDuoWorkflowCheckpointCreateChannelBlobBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreateChannelBlob())
                        .writeType("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenStepActionIsNull() {
        final GitLabDuoWorkflowCheckpointCreateChannelBlobBuilder builder =
                GitLabDuoWorkflowCheckpointCreateChannelBlobBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreateChannelBlob())
                        .stepAction(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("stepAction");
    }

    @Test
    void constructor_shouldAcceptNull_whenDataIsNullable() {
        final GitLabDuoWorkflowCheckpointCreateChannelBlobBuilder builder =
                GitLabDuoWorkflowCheckpointCreateChannelBlobBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreateChannelBlob())
                        .data(null);

        final GitLabDuoWorkflowCheckpointCreateChannelBlob built = builder.build();

        assertThat(built.data()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoWorkflowCheckpointCreateChannelBlob value =
                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreateChannelBlob();

        assertSoftly(softly -> {
            softly.assertThat(value.channel()).isEqualTo("channel");
            softly.assertThat(value.version()).isEqualTo("version");
            softly.assertThat(value.writeType()).isEqualTo("write_type");
            softly.assertThat(value.stepAction())
                    .isEqualTo(GitLabDuoWorkflowCheckpointCreateChannelBlobStepAction.CONVERSATION);
            softly.assertThat(value.data()).isEqualTo("data");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoWorkflowCheckpointCreateChannelBlob original =
                GitlabduoagentplatformflowsCatalogFixtures.duoWorkflowCheckpointCreateChannelBlob();

        final GitLabDuoWorkflowCheckpointCreateChannelBlob rebuilt =
                GitLabDuoWorkflowCheckpointCreateChannelBlobBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDuoWorkflowCheckpointCreateChannelBlob.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("channel", "version", "writeType", "stepAction", "data");
    }
}

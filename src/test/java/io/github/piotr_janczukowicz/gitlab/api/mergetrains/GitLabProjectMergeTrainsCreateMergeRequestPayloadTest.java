package io.github.piotr_janczukowicz.gitlab.api.mergetrains;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMergeTrainsCreateMergeRequestPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenShaIsNullable() {
        final GitLabProjectMergeTrainsCreateMergeRequestPayloadBuilder builder =
                GitLabProjectMergeTrainsCreateMergeRequestPayloadBuilder.builder(
                                MergetrainsCatalogFixtures.projectMergeTrainsCreateMergeRequestPayload())
                        .sha(null);

        final GitLabProjectMergeTrainsCreateMergeRequestPayload built = builder.build();

        assertThat(built.sha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSquashIsNullable() {
        final GitLabProjectMergeTrainsCreateMergeRequestPayloadBuilder builder =
                GitLabProjectMergeTrainsCreateMergeRequestPayloadBuilder.builder(
                                MergetrainsCatalogFixtures.projectMergeTrainsCreateMergeRequestPayload())
                        .squash(null);

        final GitLabProjectMergeTrainsCreateMergeRequestPayload built = builder.build();

        assertThat(built.squash()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWhenPipelineSucceedsIsNullable() {
        final GitLabProjectMergeTrainsCreateMergeRequestPayloadBuilder builder =
                GitLabProjectMergeTrainsCreateMergeRequestPayloadBuilder.builder(
                                MergetrainsCatalogFixtures.projectMergeTrainsCreateMergeRequestPayload())
                        .whenPipelineSucceeds(null);

        final GitLabProjectMergeTrainsCreateMergeRequestPayload built = builder.build();

        assertThat(built.whenPipelineSucceeds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoMergeIsNullable() {
        final GitLabProjectMergeTrainsCreateMergeRequestPayloadBuilder builder =
                GitLabProjectMergeTrainsCreateMergeRequestPayloadBuilder.builder(
                                MergetrainsCatalogFixtures.projectMergeTrainsCreateMergeRequestPayload())
                        .autoMerge(null);

        final GitLabProjectMergeTrainsCreateMergeRequestPayload built = builder.build();

        assertThat(built.autoMerge()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMergeTrainsCreateMergeRequestPayload value =
                MergetrainsCatalogFixtures.projectMergeTrainsCreateMergeRequestPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.sha()).isEqualTo("sha");
            softly.assertThat(value.squash()).isEqualTo(true);
            softly.assertThat(value.whenPipelineSucceeds()).isEqualTo(true);
            softly.assertThat(value.autoMerge()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectMergeTrainsCreateMergeRequestPayload original =
                MergetrainsCatalogFixtures.projectMergeTrainsCreateMergeRequestPayload();

        final GitLabProjectMergeTrainsCreateMergeRequestPayload rebuilt =
                GitLabProjectMergeTrainsCreateMergeRequestPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectMergeTrainsCreateMergeRequestPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("sha", "squash", "whenPipelineSucceeds", "autoMerge");
    }
}

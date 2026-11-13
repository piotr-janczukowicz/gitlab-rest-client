package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMergeRequestsMergePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenMergeCommitMessageIsNullable() {
        final GitLabProjectMergeRequestsMergePayloadBuilder builder =
                GitLabProjectMergeRequestsMergePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsMergePayload())
                        .mergeCommitMessage(null);

        final GitLabProjectMergeRequestsMergePayload built = builder.build();

        assertThat(built.mergeCommitMessage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSquashCommitMessageIsNullable() {
        final GitLabProjectMergeRequestsMergePayloadBuilder builder =
                GitLabProjectMergeRequestsMergePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsMergePayload())
                        .squashCommitMessage(null);

        final GitLabProjectMergeRequestsMergePayload built = builder.build();

        assertThat(built.squashCommitMessage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShouldRemoveSourceBranchIsNullable() {
        final GitLabProjectMergeRequestsMergePayloadBuilder builder =
                GitLabProjectMergeRequestsMergePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsMergePayload())
                        .shouldRemoveSourceBranch(null);

        final GitLabProjectMergeRequestsMergePayload built = builder.build();

        assertThat(built.shouldRemoveSourceBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeWhenPipelineSucceedsIsNullable() {
        final GitLabProjectMergeRequestsMergePayloadBuilder builder =
                GitLabProjectMergeRequestsMergePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsMergePayload())
                        .mergeWhenPipelineSucceeds(null);

        final GitLabProjectMergeRequestsMergePayload built = builder.build();

        assertThat(built.mergeWhenPipelineSucceeds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoMergeIsNullable() {
        final GitLabProjectMergeRequestsMergePayloadBuilder builder =
                GitLabProjectMergeRequestsMergePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsMergePayload())
                        .autoMerge(null);

        final GitLabProjectMergeRequestsMergePayload built = builder.build();

        assertThat(built.autoMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShaIsNullable() {
        final GitLabProjectMergeRequestsMergePayloadBuilder builder =
                GitLabProjectMergeRequestsMergePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsMergePayload())
                        .sha(null);

        final GitLabProjectMergeRequestsMergePayload built = builder.build();

        assertThat(built.sha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSquashIsNullable() {
        final GitLabProjectMergeRequestsMergePayloadBuilder builder =
                GitLabProjectMergeRequestsMergePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsMergePayload())
                        .squash(null);

        final GitLabProjectMergeRequestsMergePayload built = builder.build();

        assertThat(built.squash()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSkipMergeTrainIsNullable() {
        final GitLabProjectMergeRequestsMergePayloadBuilder builder =
                GitLabProjectMergeRequestsMergePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsMergePayload())
                        .skipMergeTrain(null);

        final GitLabProjectMergeRequestsMergePayload built = builder.build();

        assertThat(built.skipMergeTrain()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMergeRequestsMergePayload value =
                MergerequestsCatalogFixtures.projectMergeRequestsMergePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.mergeCommitMessage()).isEqualTo("merge_commit_message");
            softly.assertThat(value.squashCommitMessage()).isEqualTo("squash_commit_message");
            softly.assertThat(value.shouldRemoveSourceBranch()).isEqualTo(true);
            softly.assertThat(value.mergeWhenPipelineSucceeds()).isEqualTo(true);
            softly.assertThat(value.autoMerge()).isEqualTo(true);
            softly.assertThat(value.sha()).isEqualTo("sha");
            softly.assertThat(value.squash()).isEqualTo(true);
            softly.assertThat(value.skipMergeTrain()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectMergeRequestsMergePayload original =
                MergerequestsCatalogFixtures.projectMergeRequestsMergePayload();

        final GitLabProjectMergeRequestsMergePayload rebuilt =
                GitLabProjectMergeRequestsMergePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectMergeRequestsMergePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "mergeCommitMessage",
                        "squashCommitMessage",
                        "shouldRemoveSourceBranch",
                        "mergeWhenPipelineSucceeds",
                        "autoMerge",
                        "sha",
                        "squash",
                        "skipMergeTrain");
    }
}

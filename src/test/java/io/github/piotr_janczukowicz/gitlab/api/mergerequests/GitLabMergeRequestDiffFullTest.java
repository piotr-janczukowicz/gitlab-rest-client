package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMergeRequestDiffFullTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabMergeRequestDiffFullBuilder builder = GitLabMergeRequestDiffFullBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestDiffFull())
                .id(null);

        final GitLabMergeRequestDiffFull built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHeadCommitShaIsNullable() {
        final GitLabMergeRequestDiffFullBuilder builder = GitLabMergeRequestDiffFullBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestDiffFull())
                .headCommitSha(null);

        final GitLabMergeRequestDiffFull built = builder.build();

        assertThat(built.headCommitSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBaseCommitShaIsNullable() {
        final GitLabMergeRequestDiffFullBuilder builder = GitLabMergeRequestDiffFullBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestDiffFull())
                .baseCommitSha(null);

        final GitLabMergeRequestDiffFull built = builder.build();

        assertThat(built.baseCommitSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartCommitShaIsNullable() {
        final GitLabMergeRequestDiffFullBuilder builder = GitLabMergeRequestDiffFullBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestDiffFull())
                .startCommitSha(null);

        final GitLabMergeRequestDiffFull built = builder.build();

        assertThat(built.startCommitSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabMergeRequestDiffFullBuilder builder = GitLabMergeRequestDiffFullBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestDiffFull())
                .createdAt(null);

        final GitLabMergeRequestDiffFull built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestIdIsNullable() {
        final GitLabMergeRequestDiffFullBuilder builder = GitLabMergeRequestDiffFullBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestDiffFull())
                .mergeRequestId(null);

        final GitLabMergeRequestDiffFull built = builder.build();

        assertThat(built.mergeRequestId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabMergeRequestDiffFullBuilder builder = GitLabMergeRequestDiffFullBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestDiffFull())
                .state(null);

        final GitLabMergeRequestDiffFull built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRealSizeIsNullable() {
        final GitLabMergeRequestDiffFullBuilder builder = GitLabMergeRequestDiffFullBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestDiffFull())
                .realSize(null);

        final GitLabMergeRequestDiffFull built = builder.build();

        assertThat(built.realSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPatchIdShaIsNullable() {
        final GitLabMergeRequestDiffFullBuilder builder = GitLabMergeRequestDiffFullBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestDiffFull())
                .patchIdSha(null);

        final GitLabMergeRequestDiffFull built = builder.build();

        assertThat(built.patchIdSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitsIsNullable() {
        final GitLabMergeRequestDiffFullBuilder builder = GitLabMergeRequestDiffFullBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestDiffFull())
                .commits(null);

        final GitLabMergeRequestDiffFull built = builder.build();

        assertThat(built.commits()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiffsIsNullable() {
        final GitLabMergeRequestDiffFullBuilder builder = GitLabMergeRequestDiffFullBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestDiffFull())
                .diffs(null);

        final GitLabMergeRequestDiffFull built = builder.build();

        assertThat(built.diffs()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMergeRequestDiffFull value = MergerequestsCatalogFixtures.mergeRequestDiffFull();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.headCommitSha()).isEqualTo("1234abcd");
            softly.assertThat(value.baseCommitSha()).isEqualTo("1234abcd");
            softly.assertThat(value.startCommitSha()).isEqualTo("1234abcd");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.mergeRequestId()).isEqualTo(1L);
            softly.assertThat(value.state()).isEqualTo("collected");
            softly.assertThat(value.realSize()).isEqualTo("1");
            softly.assertThat(value.patchIdSha()).isEqualTo("1234abcd");
            softly.assertThat(value.commits()).isEqualTo(List.of(CommonCatalogFixtures.commit()));
            softly.assertThat(value.diffs()).isEqualTo(List.of(CommonCatalogFixtures.diff()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMergeRequestDiffFull original = MergerequestsCatalogFixtures.mergeRequestDiffFull();

        final GitLabMergeRequestDiffFull rebuilt =
                GitLabMergeRequestDiffFullBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMergeRequestDiffFull.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "headCommitSha",
                        "baseCommitSha",
                        "startCommitSha",
                        "createdAt",
                        "mergeRequestId",
                        "state",
                        "realSize",
                        "patchIdSha",
                        "commits",
                        "diffs");
    }
}

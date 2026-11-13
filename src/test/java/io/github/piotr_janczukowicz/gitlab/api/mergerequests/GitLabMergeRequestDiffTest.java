package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMergeRequestDiffTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabMergeRequestDiffBuilder builder = GitLabMergeRequestDiffBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestDiff())
                .id(null);

        final GitLabMergeRequestDiff built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHeadCommitShaIsNullable() {
        final GitLabMergeRequestDiffBuilder builder = GitLabMergeRequestDiffBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestDiff())
                .headCommitSha(null);

        final GitLabMergeRequestDiff built = builder.build();

        assertThat(built.headCommitSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBaseCommitShaIsNullable() {
        final GitLabMergeRequestDiffBuilder builder = GitLabMergeRequestDiffBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestDiff())
                .baseCommitSha(null);

        final GitLabMergeRequestDiff built = builder.build();

        assertThat(built.baseCommitSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartCommitShaIsNullable() {
        final GitLabMergeRequestDiffBuilder builder = GitLabMergeRequestDiffBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestDiff())
                .startCommitSha(null);

        final GitLabMergeRequestDiff built = builder.build();

        assertThat(built.startCommitSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabMergeRequestDiffBuilder builder = GitLabMergeRequestDiffBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestDiff())
                .createdAt(null);

        final GitLabMergeRequestDiff built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestIdIsNullable() {
        final GitLabMergeRequestDiffBuilder builder = GitLabMergeRequestDiffBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestDiff())
                .mergeRequestId(null);

        final GitLabMergeRequestDiff built = builder.build();

        assertThat(built.mergeRequestId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabMergeRequestDiffBuilder builder = GitLabMergeRequestDiffBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestDiff())
                .state(null);

        final GitLabMergeRequestDiff built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRealSizeIsNullable() {
        final GitLabMergeRequestDiffBuilder builder = GitLabMergeRequestDiffBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestDiff())
                .realSize(null);

        final GitLabMergeRequestDiff built = builder.build();

        assertThat(built.realSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPatchIdShaIsNullable() {
        final GitLabMergeRequestDiffBuilder builder = GitLabMergeRequestDiffBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestDiff())
                .patchIdSha(null);

        final GitLabMergeRequestDiff built = builder.build();

        assertThat(built.patchIdSha()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMergeRequestDiff value = MergerequestsCatalogFixtures.mergeRequestDiff();

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
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMergeRequestDiff original = MergerequestsCatalogFixtures.mergeRequestDiff();

        final GitLabMergeRequestDiff rebuilt =
                GitLabMergeRequestDiffBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMergeRequestDiff.class.getRecordComponents())
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
                        "patchIdSha");
    }
}

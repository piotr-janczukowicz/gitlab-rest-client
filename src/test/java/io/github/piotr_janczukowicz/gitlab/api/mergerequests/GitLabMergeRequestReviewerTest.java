package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMergeRequestReviewerTest {

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabMergeRequestReviewerBuilder builder = GitLabMergeRequestReviewerBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestReviewer())
                .user(null);

        final GitLabMergeRequestReviewer built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabMergeRequestReviewerBuilder builder = GitLabMergeRequestReviewerBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestReviewer())
                .state(null);

        final GitLabMergeRequestReviewer built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabMergeRequestReviewerBuilder builder = GitLabMergeRequestReviewerBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestReviewer())
                .createdAt(null);

        final GitLabMergeRequestReviewer built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMergeRequestReviewer value = MergerequestsCatalogFixtures.mergeRequestReviewer();

        assertSoftly(softly -> {
            softly.assertThat(value.user()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.state()).isEqualTo("unreviewed");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMergeRequestReviewer original = MergerequestsCatalogFixtures.mergeRequestReviewer();

        final GitLabMergeRequestReviewer rebuilt =
                GitLabMergeRequestReviewerBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMergeRequestReviewer.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("user", "state", "createdAt");
    }
}

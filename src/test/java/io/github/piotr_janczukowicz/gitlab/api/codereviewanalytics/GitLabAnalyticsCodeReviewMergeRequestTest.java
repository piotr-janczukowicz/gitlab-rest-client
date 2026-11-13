package io.github.piotr_janczukowicz.gitlab.api.codereviewanalytics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAnalyticsCodeReviewMergeRequestTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabAnalyticsCodeReviewMergeRequestBuilder builder =
                GitLabAnalyticsCodeReviewMergeRequestBuilder.builder(
                                CodereviewanalyticsCatalogFixtures.analyticsCodeReviewMergeRequest())
                        .id(null);

        final GitLabAnalyticsCodeReviewMergeRequest built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabAnalyticsCodeReviewMergeRequestBuilder builder =
                GitLabAnalyticsCodeReviewMergeRequestBuilder.builder(
                                CodereviewanalyticsCatalogFixtures.analyticsCodeReviewMergeRequest())
                        .iid(null);

        final GitLabAnalyticsCodeReviewMergeRequest built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabAnalyticsCodeReviewMergeRequestBuilder builder =
                GitLabAnalyticsCodeReviewMergeRequestBuilder.builder(
                                CodereviewanalyticsCatalogFixtures.analyticsCodeReviewMergeRequest())
                        .projectId(null);

        final GitLabAnalyticsCodeReviewMergeRequest built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabAnalyticsCodeReviewMergeRequestBuilder builder =
                GitLabAnalyticsCodeReviewMergeRequestBuilder.builder(
                                CodereviewanalyticsCatalogFixtures.analyticsCodeReviewMergeRequest())
                        .title(null);

        final GitLabAnalyticsCodeReviewMergeRequest built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabAnalyticsCodeReviewMergeRequestBuilder builder =
                GitLabAnalyticsCodeReviewMergeRequestBuilder.builder(
                                CodereviewanalyticsCatalogFixtures.analyticsCodeReviewMergeRequest())
                        .description(null);

        final GitLabAnalyticsCodeReviewMergeRequest built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabAnalyticsCodeReviewMergeRequestBuilder builder =
                GitLabAnalyticsCodeReviewMergeRequestBuilder.builder(
                                CodereviewanalyticsCatalogFixtures.analyticsCodeReviewMergeRequest())
                        .state(null);

        final GitLabAnalyticsCodeReviewMergeRequest built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabAnalyticsCodeReviewMergeRequestBuilder builder =
                GitLabAnalyticsCodeReviewMergeRequestBuilder.builder(
                                CodereviewanalyticsCatalogFixtures.analyticsCodeReviewMergeRequest())
                        .createdAt(null);

        final GitLabAnalyticsCodeReviewMergeRequest built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabAnalyticsCodeReviewMergeRequestBuilder builder =
                GitLabAnalyticsCodeReviewMergeRequestBuilder.builder(
                                CodereviewanalyticsCatalogFixtures.analyticsCodeReviewMergeRequest())
                        .updatedAt(null);

        final GitLabAnalyticsCodeReviewMergeRequest built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabAnalyticsCodeReviewMergeRequestBuilder builder =
                GitLabAnalyticsCodeReviewMergeRequestBuilder.builder(
                                CodereviewanalyticsCatalogFixtures.analyticsCodeReviewMergeRequest())
                        .webUrl(null);

        final GitLabAnalyticsCodeReviewMergeRequest built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIsNullable() {
        final GitLabAnalyticsCodeReviewMergeRequestBuilder builder =
                GitLabAnalyticsCodeReviewMergeRequestBuilder.builder(
                                CodereviewanalyticsCatalogFixtures.analyticsCodeReviewMergeRequest())
                        .milestone(null);

        final GitLabAnalyticsCodeReviewMergeRequest built = builder.build();

        assertThat(built.milestone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIsNullable() {
        final GitLabAnalyticsCodeReviewMergeRequestBuilder builder =
                GitLabAnalyticsCodeReviewMergeRequestBuilder.builder(
                                CodereviewanalyticsCatalogFixtures.analyticsCodeReviewMergeRequest())
                        .author(null);

        final GitLabAnalyticsCodeReviewMergeRequest built = builder.build();

        assertThat(built.author()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovedByIsNullable() {
        final GitLabAnalyticsCodeReviewMergeRequestBuilder builder =
                GitLabAnalyticsCodeReviewMergeRequestBuilder.builder(
                                CodereviewanalyticsCatalogFixtures.analyticsCodeReviewMergeRequest())
                        .approvedBy(null);

        final GitLabAnalyticsCodeReviewMergeRequest built = builder.build();

        assertThat(built.approvedBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotesCountIsNullable() {
        final GitLabAnalyticsCodeReviewMergeRequestBuilder builder =
                GitLabAnalyticsCodeReviewMergeRequestBuilder.builder(
                                CodereviewanalyticsCatalogFixtures.analyticsCodeReviewMergeRequest())
                        .notesCount(null);

        final GitLabAnalyticsCodeReviewMergeRequest built = builder.build();

        assertThat(built.notesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReviewTimeIsNullable() {
        final GitLabAnalyticsCodeReviewMergeRequestBuilder builder =
                GitLabAnalyticsCodeReviewMergeRequestBuilder.builder(
                                CodereviewanalyticsCatalogFixtures.analyticsCodeReviewMergeRequest())
                        .reviewTime(null);

        final GitLabAnalyticsCodeReviewMergeRequest built = builder.build();

        assertThat(built.reviewTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiffStatsIsNullable() {
        final GitLabAnalyticsCodeReviewMergeRequestBuilder builder =
                GitLabAnalyticsCodeReviewMergeRequestBuilder.builder(
                                CodereviewanalyticsCatalogFixtures.analyticsCodeReviewMergeRequest())
                        .diffStats(null);

        final GitLabAnalyticsCodeReviewMergeRequest built = builder.build();

        assertThat(built.diffStats()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAnalyticsCodeReviewMergeRequest value =
                CodereviewanalyticsCatalogFixtures.analyticsCodeReviewMergeRequest();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.iid()).isEqualTo(1L);
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.title()).isEqualTo("Test MR 1580978354");
            softly.assertThat(value.description()).isEqualTo("Repellendus impedit et vel velit dignissimos.");
            softly.assertThat(value.state()).isEqualTo("closed");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.webUrl())
                    .isEqualTo("http://local.gitlab.test:8181/root/merge-train-race-condition/-/merge_requests/59");
            softly.assertThat(value.milestone()).isEqualTo(CommonCatalogFixtures.milestone());
            softly.assertThat(value.author()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.approvedBy()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.notesCount()).isEqualTo(1);
            softly.assertThat(value.reviewTime()).isEqualTo(1);
            softly.assertThat(value.diffStats()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAnalyticsCodeReviewMergeRequest original =
                CodereviewanalyticsCatalogFixtures.analyticsCodeReviewMergeRequest();

        final GitLabAnalyticsCodeReviewMergeRequest rebuilt =
                GitLabAnalyticsCodeReviewMergeRequestBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAnalyticsCodeReviewMergeRequest.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "iid",
                        "projectId",
                        "title",
                        "description",
                        "state",
                        "createdAt",
                        "updatedAt",
                        "webUrl",
                        "milestone",
                        "author",
                        "approvedBy",
                        "notesCount",
                        "reviewTime",
                        "diffStats");
    }
}

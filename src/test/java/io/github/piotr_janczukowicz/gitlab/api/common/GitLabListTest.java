package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabListTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabListBuilder builder =
                GitLabListBuilder.builder(CommonCatalogFixtures.list()).id(null);

        final GitLabList built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelIsNullable() {
        final GitLabListBuilder builder =
                GitLabListBuilder.builder(CommonCatalogFixtures.list()).label(null);

        final GitLabList built = builder.build();

        assertThat(built.label()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPositionIsNullable() {
        final GitLabListBuilder builder =
                GitLabListBuilder.builder(CommonCatalogFixtures.list()).position(null);

        final GitLabList built = builder.build();

        assertThat(built.position()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIsNullable() {
        final GitLabListBuilder builder =
                GitLabListBuilder.builder(CommonCatalogFixtures.list()).milestone(null);

        final GitLabList built = builder.build();

        assertThat(built.milestone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIterationIsNullable() {
        final GitLabListBuilder builder =
                GitLabListBuilder.builder(CommonCatalogFixtures.list()).iteration(null);

        final GitLabList built = builder.build();

        assertThat(built.iteration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIsNullable() {
        final GitLabListBuilder builder =
                GitLabListBuilder.builder(CommonCatalogFixtures.list()).assignee(null);

        final GitLabList built = builder.build();

        assertThat(built.assignee()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabListBuilder builder =
                GitLabListBuilder.builder(CommonCatalogFixtures.list()).status(null);

        final GitLabList built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxIssueCountIsNullable() {
        final GitLabListBuilder builder =
                GitLabListBuilder.builder(CommonCatalogFixtures.list()).maxIssueCount(null);

        final GitLabList built = builder.build();

        assertThat(built.maxIssueCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxIssueWeightIsNullable() {
        final GitLabListBuilder builder =
                GitLabListBuilder.builder(CommonCatalogFixtures.list()).maxIssueWeight(null);

        final GitLabList built = builder.build();

        assertThat(built.maxIssueWeight()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLimitMetricIsNullable() {
        final GitLabListBuilder builder =
                GitLabListBuilder.builder(CommonCatalogFixtures.list()).limitMetric(null);

        final GitLabList built = builder.build();

        assertThat(built.limitMetric()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabList value = CommonCatalogFixtures.list();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.label()).isEqualTo(CommonCatalogFixtures.labelBasic());
            softly.assertThat(value.position()).isEqualTo(1);
            softly.assertThat(value.milestone()).isEqualTo(CommonCatalogFixtures.milestone());
            softly.assertThat(value.iteration()).isEqualTo(CommonCatalogFixtures.iteration());
            softly.assertThat(value.assignee()).isEqualTo(CommonCatalogFixtures.userSafe());
            softly.assertThat(value.status()).isEqualTo(CommonCatalogFixtures.workItemsStatus());
            softly.assertThat(value.maxIssueCount()).isEqualTo(1);
            softly.assertThat(value.maxIssueWeight()).isEqualTo(1);
            softly.assertThat(value.limitMetric()).isEqualTo("issue_count");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabList original = CommonCatalogFixtures.list();

        final GitLabList rebuilt = GitLabListBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabList.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "label",
                        "position",
                        "milestone",
                        "iteration",
                        "assignee",
                        "status",
                        "maxIssueCount",
                        "maxIssueWeight",
                        "limitMetric");
    }
}

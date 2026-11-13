package io.github.piotr_janczukowicz.gitlab.api.codereviewanalytics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCodeReviewAnalyticsListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenLabelNameIsNullable() {
        final GitLabCodeReviewAnalyticsListFilterBuilder builder = GitLabCodeReviewAnalyticsListFilterBuilder.builder(
                        GitLabCodeReviewAnalyticsListFilterBuilder.builder()
                                .labelName(List.of("label_name"))
                                .milestoneTitle("milestone_title")
                                .notLabelName(List.of("not[label_name]"))
                                .notMilestoneTitle("not[milestone_title]")
                                .build())
                .labelName(null);

        final GitLabCodeReviewAnalyticsListFilter built = builder.build();

        assertThat(built.labelName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneTitleIsNullable() {
        final GitLabCodeReviewAnalyticsListFilterBuilder builder = GitLabCodeReviewAnalyticsListFilterBuilder.builder(
                        GitLabCodeReviewAnalyticsListFilterBuilder.builder()
                                .labelName(List.of("label_name"))
                                .milestoneTitle("milestone_title")
                                .notLabelName(List.of("not[label_name]"))
                                .notMilestoneTitle("not[milestone_title]")
                                .build())
                .milestoneTitle(null);

        final GitLabCodeReviewAnalyticsListFilter built = builder.build();

        assertThat(built.milestoneTitle()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotLabelNameIsNullable() {
        final GitLabCodeReviewAnalyticsListFilterBuilder builder = GitLabCodeReviewAnalyticsListFilterBuilder.builder(
                        GitLabCodeReviewAnalyticsListFilterBuilder.builder()
                                .labelName(List.of("label_name"))
                                .milestoneTitle("milestone_title")
                                .notLabelName(List.of("not[label_name]"))
                                .notMilestoneTitle("not[milestone_title]")
                                .build())
                .notLabelName(null);

        final GitLabCodeReviewAnalyticsListFilter built = builder.build();

        assertThat(built.notLabelName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotMilestoneTitleIsNullable() {
        final GitLabCodeReviewAnalyticsListFilterBuilder builder = GitLabCodeReviewAnalyticsListFilterBuilder.builder(
                        GitLabCodeReviewAnalyticsListFilterBuilder.builder()
                                .labelName(List.of("label_name"))
                                .milestoneTitle("milestone_title")
                                .notLabelName(List.of("not[label_name]"))
                                .notMilestoneTitle("not[milestone_title]")
                                .build())
                .notMilestoneTitle(null);

        final GitLabCodeReviewAnalyticsListFilter built = builder.build();

        assertThat(built.notMilestoneTitle()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCodeReviewAnalyticsListFilter value = GitLabCodeReviewAnalyticsListFilterBuilder.builder()
                .labelName(List.of("label_name"))
                .milestoneTitle("milestone_title")
                .notLabelName(List.of("not[label_name]"))
                .notMilestoneTitle("not[milestone_title]")
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.labelName()).isEqualTo(List.of("label_name"));
            softly.assertThat(value.milestoneTitle()).isEqualTo("milestone_title");
            softly.assertThat(value.notLabelName()).isEqualTo(List.of("not[label_name]"));
            softly.assertThat(value.notMilestoneTitle()).isEqualTo("not[milestone_title]");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCodeReviewAnalyticsListFilter original = GitLabCodeReviewAnalyticsListFilterBuilder.builder()
                .labelName(List.of("label_name"))
                .milestoneTitle("milestone_title")
                .notLabelName(List.of("not[label_name]"))
                .notMilestoneTitle("not[milestone_title]")
                .build();

        final GitLabCodeReviewAnalyticsListFilter rebuilt =
                GitLabCodeReviewAnalyticsListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenLabelNameSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("label_name"));
        final GitLabCodeReviewAnalyticsListFilter built = GitLabCodeReviewAnalyticsListFilterBuilder.builder(
                        GitLabCodeReviewAnalyticsListFilterBuilder.builder()
                                .labelName(List.of("label_name"))
                                .milestoneTitle("milestone_title")
                                .notLabelName(List.of("not[label_name]"))
                                .notMilestoneTitle("not[milestone_title]")
                                .build())
                .labelName(source)
                .build();
        source.clear();

        assertThat(built.labelName()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenLabelNameIsRead() {
        final GitLabCodeReviewAnalyticsListFilter built = GitLabCodeReviewAnalyticsListFilterBuilder.builder()
                .labelName(List.of("label_name"))
                .milestoneTitle("milestone_title")
                .notLabelName(List.of("not[label_name]"))
                .notMilestoneTitle("not[milestone_title]")
                .build();
        final List<String> values = built.labelName();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenNotLabelNameSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("not[label_name]"));
        final GitLabCodeReviewAnalyticsListFilter built = GitLabCodeReviewAnalyticsListFilterBuilder.builder(
                        GitLabCodeReviewAnalyticsListFilterBuilder.builder()
                                .labelName(List.of("label_name"))
                                .milestoneTitle("milestone_title")
                                .notLabelName(List.of("not[label_name]"))
                                .notMilestoneTitle("not[milestone_title]")
                                .build())
                .notLabelName(source)
                .build();
        source.clear();

        assertThat(built.notLabelName()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenNotLabelNameIsRead() {
        final GitLabCodeReviewAnalyticsListFilter built = GitLabCodeReviewAnalyticsListFilterBuilder.builder()
                .labelName(List.of("label_name"))
                .milestoneTitle("milestone_title")
                .notLabelName(List.of("not[label_name]"))
                .notMilestoneTitle("not[milestone_title]")
                .build();
        final List<String> values = built.notLabelName();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCodeReviewAnalyticsListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("labelName", "milestoneTitle", "notLabelName", "notMilestoneTitle");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabCodeReviewAnalyticsListFilter empty = GitLabCodeReviewAnalyticsListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabCodeReviewAnalyticsListFilter filter = GitLabCodeReviewAnalyticsListFilterBuilder.builder()
                .labelName(List.of("label_name"))
                .milestoneTitle("milestone_title")
                .notLabelName(List.of("not[label_name]"))
                .notMilestoneTitle("not[milestone_title]")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("label_name", "label_name"),
                        Map.entry("milestone_title", "milestone_title"),
                        Map.entry("not[label_name]", "not[label_name]"),
                        Map.entry("not[milestone_title]", "not[milestone_title]"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabCodeReviewAnalyticsListFilter filter = GitLabCodeReviewAnalyticsListFilterBuilder.builder()
                .labelName(List.of("label_name"))
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("label_name", "label_name"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabCodeReviewAnalyticsListFilter filter = GitLabCodeReviewAnalyticsListFilterBuilder.builder()
                .labelName(List.of("label_name"))
                .milestoneTitle("milestone_title")
                .notLabelName(List.of("not[label_name]"))
                .notMilestoneTitle("not[milestone_title]")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

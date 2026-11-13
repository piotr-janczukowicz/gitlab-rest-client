package io.github.piotr_janczukowicz.gitlab.api.projectmilestones;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectMilestonesListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabProjectProjectMilestonesListFilterBuilder builder =
                GitLabProjectProjectMilestonesListFilterBuilder.builder(
                                GitLabProjectProjectMilestonesListFilterBuilder.builder()
                                        .state(GitLabProjectProjectMilestonesListState.ACTIVE)
                                        .iids(List.of(1))
                                        .title("title")
                                        .search("search")
                                        .searchTitle("search_title")
                                        .includeParentMilestones(true)
                                        .includeAncestors(true)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .containingDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .startDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .endDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .sort(GitLabProjectProjectMilestonesListSort.DUE_DATE_ASC)
                                        .build())
                        .state(null);

        final GitLabProjectProjectMilestonesListFilter built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidsIsNullable() {
        final GitLabProjectProjectMilestonesListFilterBuilder builder =
                GitLabProjectProjectMilestonesListFilterBuilder.builder(
                                GitLabProjectProjectMilestonesListFilterBuilder.builder()
                                        .state(GitLabProjectProjectMilestonesListState.ACTIVE)
                                        .iids(List.of(1))
                                        .title("title")
                                        .search("search")
                                        .searchTitle("search_title")
                                        .includeParentMilestones(true)
                                        .includeAncestors(true)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .containingDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .startDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .endDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .sort(GitLabProjectProjectMilestonesListSort.DUE_DATE_ASC)
                                        .build())
                        .iids(null);

        final GitLabProjectProjectMilestonesListFilter built = builder.build();

        assertThat(built.iids()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabProjectProjectMilestonesListFilterBuilder builder =
                GitLabProjectProjectMilestonesListFilterBuilder.builder(
                                GitLabProjectProjectMilestonesListFilterBuilder.builder()
                                        .state(GitLabProjectProjectMilestonesListState.ACTIVE)
                                        .iids(List.of(1))
                                        .title("title")
                                        .search("search")
                                        .searchTitle("search_title")
                                        .includeParentMilestones(true)
                                        .includeAncestors(true)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .containingDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .startDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .endDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .sort(GitLabProjectProjectMilestonesListSort.DUE_DATE_ASC)
                                        .build())
                        .title(null);

        final GitLabProjectProjectMilestonesListFilter built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabProjectProjectMilestonesListFilterBuilder builder =
                GitLabProjectProjectMilestonesListFilterBuilder.builder(
                                GitLabProjectProjectMilestonesListFilterBuilder.builder()
                                        .state(GitLabProjectProjectMilestonesListState.ACTIVE)
                                        .iids(List.of(1))
                                        .title("title")
                                        .search("search")
                                        .searchTitle("search_title")
                                        .includeParentMilestones(true)
                                        .includeAncestors(true)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .containingDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .startDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .endDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .sort(GitLabProjectProjectMilestonesListSort.DUE_DATE_ASC)
                                        .build())
                        .search(null);

        final GitLabProjectProjectMilestonesListFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchTitleIsNullable() {
        final GitLabProjectProjectMilestonesListFilterBuilder builder =
                GitLabProjectProjectMilestonesListFilterBuilder.builder(
                                GitLabProjectProjectMilestonesListFilterBuilder.builder()
                                        .state(GitLabProjectProjectMilestonesListState.ACTIVE)
                                        .iids(List.of(1))
                                        .title("title")
                                        .search("search")
                                        .searchTitle("search_title")
                                        .includeParentMilestones(true)
                                        .includeAncestors(true)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .containingDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .startDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .endDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .sort(GitLabProjectProjectMilestonesListSort.DUE_DATE_ASC)
                                        .build())
                        .searchTitle(null);

        final GitLabProjectProjectMilestonesListFilter built = builder.build();

        assertThat(built.searchTitle()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeParentMilestonesIsNullable() {
        final GitLabProjectProjectMilestonesListFilterBuilder builder =
                GitLabProjectProjectMilestonesListFilterBuilder.builder(
                                GitLabProjectProjectMilestonesListFilterBuilder.builder()
                                        .state(GitLabProjectProjectMilestonesListState.ACTIVE)
                                        .iids(List.of(1))
                                        .title("title")
                                        .search("search")
                                        .searchTitle("search_title")
                                        .includeParentMilestones(true)
                                        .includeAncestors(true)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .containingDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .startDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .endDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .sort(GitLabProjectProjectMilestonesListSort.DUE_DATE_ASC)
                                        .build())
                        .includeParentMilestones(null);

        final GitLabProjectProjectMilestonesListFilter built = builder.build();

        assertThat(built.includeParentMilestones()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeAncestorsIsNullable() {
        final GitLabProjectProjectMilestonesListFilterBuilder builder =
                GitLabProjectProjectMilestonesListFilterBuilder.builder(
                                GitLabProjectProjectMilestonesListFilterBuilder.builder()
                                        .state(GitLabProjectProjectMilestonesListState.ACTIVE)
                                        .iids(List.of(1))
                                        .title("title")
                                        .search("search")
                                        .searchTitle("search_title")
                                        .includeParentMilestones(true)
                                        .includeAncestors(true)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .containingDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .startDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .endDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .sort(GitLabProjectProjectMilestonesListSort.DUE_DATE_ASC)
                                        .build())
                        .includeAncestors(null);

        final GitLabProjectProjectMilestonesListFilter built = builder.build();

        assertThat(built.includeAncestors()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedBeforeIsNullable() {
        final GitLabProjectProjectMilestonesListFilterBuilder builder =
                GitLabProjectProjectMilestonesListFilterBuilder.builder(
                                GitLabProjectProjectMilestonesListFilterBuilder.builder()
                                        .state(GitLabProjectProjectMilestonesListState.ACTIVE)
                                        .iids(List.of(1))
                                        .title("title")
                                        .search("search")
                                        .searchTitle("search_title")
                                        .includeParentMilestones(true)
                                        .includeAncestors(true)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .containingDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .startDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .endDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .sort(GitLabProjectProjectMilestonesListSort.DUE_DATE_ASC)
                                        .build())
                        .updatedBefore(null);

        final GitLabProjectProjectMilestonesListFilter built = builder.build();

        assertThat(built.updatedBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAfterIsNullable() {
        final GitLabProjectProjectMilestonesListFilterBuilder builder =
                GitLabProjectProjectMilestonesListFilterBuilder.builder(
                                GitLabProjectProjectMilestonesListFilterBuilder.builder()
                                        .state(GitLabProjectProjectMilestonesListState.ACTIVE)
                                        .iids(List.of(1))
                                        .title("title")
                                        .search("search")
                                        .searchTitle("search_title")
                                        .includeParentMilestones(true)
                                        .includeAncestors(true)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .containingDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .startDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .endDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .sort(GitLabProjectProjectMilestonesListSort.DUE_DATE_ASC)
                                        .build())
                        .updatedAfter(null);

        final GitLabProjectProjectMilestonesListFilter built = builder.build();

        assertThat(built.updatedAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainingDateIsNullable() {
        final GitLabProjectProjectMilestonesListFilterBuilder builder =
                GitLabProjectProjectMilestonesListFilterBuilder.builder(
                                GitLabProjectProjectMilestonesListFilterBuilder.builder()
                                        .state(GitLabProjectProjectMilestonesListState.ACTIVE)
                                        .iids(List.of(1))
                                        .title("title")
                                        .search("search")
                                        .searchTitle("search_title")
                                        .includeParentMilestones(true)
                                        .includeAncestors(true)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .containingDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .startDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .endDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .sort(GitLabProjectProjectMilestonesListSort.DUE_DATE_ASC)
                                        .build())
                        .containingDate(null);

        final GitLabProjectProjectMilestonesListFilter built = builder.build();

        assertThat(built.containingDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateIsNullable() {
        final GitLabProjectProjectMilestonesListFilterBuilder builder =
                GitLabProjectProjectMilestonesListFilterBuilder.builder(
                                GitLabProjectProjectMilestonesListFilterBuilder.builder()
                                        .state(GitLabProjectProjectMilestonesListState.ACTIVE)
                                        .iids(List.of(1))
                                        .title("title")
                                        .search("search")
                                        .searchTitle("search_title")
                                        .includeParentMilestones(true)
                                        .includeAncestors(true)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .containingDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .startDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .endDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .sort(GitLabProjectProjectMilestonesListSort.DUE_DATE_ASC)
                                        .build())
                        .startDate(null);

        final GitLabProjectProjectMilestonesListFilter built = builder.build();

        assertThat(built.startDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEndDateIsNullable() {
        final GitLabProjectProjectMilestonesListFilterBuilder builder =
                GitLabProjectProjectMilestonesListFilterBuilder.builder(
                                GitLabProjectProjectMilestonesListFilterBuilder.builder()
                                        .state(GitLabProjectProjectMilestonesListState.ACTIVE)
                                        .iids(List.of(1))
                                        .title("title")
                                        .search("search")
                                        .searchTitle("search_title")
                                        .includeParentMilestones(true)
                                        .includeAncestors(true)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .containingDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .startDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .endDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .sort(GitLabProjectProjectMilestonesListSort.DUE_DATE_ASC)
                                        .build())
                        .endDate(null);

        final GitLabProjectProjectMilestonesListFilter built = builder.build();

        assertThat(built.endDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabProjectProjectMilestonesListFilterBuilder builder =
                GitLabProjectProjectMilestonesListFilterBuilder.builder(
                                GitLabProjectProjectMilestonesListFilterBuilder.builder()
                                        .state(GitLabProjectProjectMilestonesListState.ACTIVE)
                                        .iids(List.of(1))
                                        .title("title")
                                        .search("search")
                                        .searchTitle("search_title")
                                        .includeParentMilestones(true)
                                        .includeAncestors(true)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .containingDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .startDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .endDate(Instant.parse("2026-01-01T00:00:00Z"))
                                        .sort(GitLabProjectProjectMilestonesListSort.DUE_DATE_ASC)
                                        .build())
                        .sort(null);

        final GitLabProjectProjectMilestonesListFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectMilestonesListFilter value = GitLabProjectProjectMilestonesListFilterBuilder.builder()
                .state(GitLabProjectProjectMilestonesListState.ACTIVE)
                .iids(List.of(1))
                .title("title")
                .search("search")
                .searchTitle("search_title")
                .includeParentMilestones(true)
                .includeAncestors(true)
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .containingDate(Instant.parse("2026-01-01T00:00:00Z"))
                .startDate(Instant.parse("2026-01-01T00:00:00Z"))
                .endDate(Instant.parse("2026-01-01T00:00:00Z"))
                .sort(GitLabProjectProjectMilestonesListSort.DUE_DATE_ASC)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.state()).isEqualTo(GitLabProjectProjectMilestonesListState.ACTIVE);
            softly.assertThat(value.iids()).isEqualTo(List.of(1));
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.searchTitle()).isEqualTo("search_title");
            softly.assertThat(value.includeParentMilestones()).isEqualTo(true);
            softly.assertThat(value.includeAncestors()).isEqualTo(true);
            softly.assertThat(value.updatedBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.containingDate()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.startDate()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.endDate()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.sort()).isEqualTo(GitLabProjectProjectMilestonesListSort.DUE_DATE_ASC);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectMilestonesListFilter original =
                GitLabProjectProjectMilestonesListFilterBuilder.builder()
                        .state(GitLabProjectProjectMilestonesListState.ACTIVE)
                        .iids(List.of(1))
                        .title("title")
                        .search("search")
                        .searchTitle("search_title")
                        .includeParentMilestones(true)
                        .includeAncestors(true)
                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .containingDate(Instant.parse("2026-01-01T00:00:00Z"))
                        .startDate(Instant.parse("2026-01-01T00:00:00Z"))
                        .endDate(Instant.parse("2026-01-01T00:00:00Z"))
                        .sort(GitLabProjectProjectMilestonesListSort.DUE_DATE_ASC)
                        .build();

        final GitLabProjectProjectMilestonesListFilter rebuilt =
                GitLabProjectProjectMilestonesListFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenIidsSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabProjectProjectMilestonesListFilter built = GitLabProjectProjectMilestonesListFilterBuilder.builder(
                        GitLabProjectProjectMilestonesListFilterBuilder.builder()
                                .state(GitLabProjectProjectMilestonesListState.ACTIVE)
                                .iids(List.of(1))
                                .title("title")
                                .search("search")
                                .searchTitle("search_title")
                                .includeParentMilestones(true)
                                .includeAncestors(true)
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .containingDate(Instant.parse("2026-01-01T00:00:00Z"))
                                .startDate(Instant.parse("2026-01-01T00:00:00Z"))
                                .endDate(Instant.parse("2026-01-01T00:00:00Z"))
                                .sort(GitLabProjectProjectMilestonesListSort.DUE_DATE_ASC)
                                .build())
                .iids(source)
                .build();
        source.clear();

        assertThat(built.iids()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenIidsIsRead() {
        final GitLabProjectProjectMilestonesListFilter built = GitLabProjectProjectMilestonesListFilterBuilder.builder()
                .state(GitLabProjectProjectMilestonesListState.ACTIVE)
                .iids(List.of(1))
                .title("title")
                .search("search")
                .searchTitle("search_title")
                .includeParentMilestones(true)
                .includeAncestors(true)
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .containingDate(Instant.parse("2026-01-01T00:00:00Z"))
                .startDate(Instant.parse("2026-01-01T00:00:00Z"))
                .endDate(Instant.parse("2026-01-01T00:00:00Z"))
                .sort(GitLabProjectProjectMilestonesListSort.DUE_DATE_ASC)
                .build();
        final List<Integer> values = built.iids();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectMilestonesListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "state",
                        "iids",
                        "title",
                        "search",
                        "searchTitle",
                        "includeParentMilestones",
                        "includeAncestors",
                        "updatedBefore",
                        "updatedAfter",
                        "containingDate",
                        "startDate",
                        "endDate",
                        "sort");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectMilestonesListFilter empty = GitLabProjectProjectMilestonesListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectMilestonesListFilter filter =
                GitLabProjectProjectMilestonesListFilterBuilder.builder()
                        .state(GitLabProjectProjectMilestonesListState.ACTIVE)
                        .iids(List.of(1))
                        .title("title")
                        .search("search")
                        .searchTitle("search_title")
                        .includeParentMilestones(true)
                        .includeAncestors(true)
                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .containingDate(Instant.parse("2026-01-01T00:00:00Z"))
                        .startDate(Instant.parse("2026-01-01T00:00:00Z"))
                        .endDate(Instant.parse("2026-01-01T00:00:00Z"))
                        .sort(GitLabProjectProjectMilestonesListSort.DUE_DATE_ASC)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("state", "active"),
                        Map.entry("iids", "1"),
                        Map.entry("title", "title"),
                        Map.entry("search", "search"),
                        Map.entry("search_title", "search_title"),
                        Map.entry("include_parent_milestones", "true"),
                        Map.entry("include_ancestors", "true"),
                        Map.entry("updated_before", "2026-01-01T00:00:00Z"),
                        Map.entry("updated_after", "2026-01-01T00:00:00Z"),
                        Map.entry("containing_date", "2026-01-01T00:00:00Z"),
                        Map.entry("start_date", "2026-01-01T00:00:00Z"),
                        Map.entry("end_date", "2026-01-01T00:00:00Z"),
                        Map.entry("sort", "due_date_asc"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectProjectMilestonesListFilter filter =
                GitLabProjectProjectMilestonesListFilterBuilder.builder()
                        .state(GitLabProjectProjectMilestonesListState.ACTIVE)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("state", "active"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectMilestonesListFilter filter =
                GitLabProjectProjectMilestonesListFilterBuilder.builder()
                        .state(GitLabProjectProjectMilestonesListState.ACTIVE)
                        .iids(List.of(1))
                        .title("title")
                        .search("search")
                        .searchTitle("search_title")
                        .includeParentMilestones(true)
                        .includeAncestors(true)
                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .containingDate(Instant.parse("2026-01-01T00:00:00Z"))
                        .startDate(Instant.parse("2026-01-01T00:00:00Z"))
                        .endDate(Instant.parse("2026-01-01T00:00:00Z"))
                        .sort(GitLabProjectProjectMilestonesListSort.DUE_DATE_ASC)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

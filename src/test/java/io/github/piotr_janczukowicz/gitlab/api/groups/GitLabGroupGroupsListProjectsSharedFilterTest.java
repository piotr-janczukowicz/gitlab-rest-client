package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupsListProjectsSharedFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenArchivedIsNullable() {
        final GitLabGroupGroupsListProjectsSharedFilterBuilder builder =
                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder(
                                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder()
                                        .archived(true)
                                        .visibility(GitLabGroupGroupsListProjectsSharedVisibility.PRIVATE)
                                        .search("search")
                                        .orderBy(GitLabGroupGroupsListProjectsSharedOrderBy.ID)
                                        .sort(GitLabGroupGroupsListProjectsSharedSort.ASC)
                                        .simple(true)
                                        .starred(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .minAccessLevel(GitLabGroupGroupsListProjectsSharedMinAccessLevel.GUEST)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .archived(null);

        final GitLabGroupGroupsListProjectsSharedFilter built = builder.build();

        assertThat(built.archived()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVisibilityIsNullable() {
        final GitLabGroupGroupsListProjectsSharedFilterBuilder builder =
                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder(
                                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder()
                                        .archived(true)
                                        .visibility(GitLabGroupGroupsListProjectsSharedVisibility.PRIVATE)
                                        .search("search")
                                        .orderBy(GitLabGroupGroupsListProjectsSharedOrderBy.ID)
                                        .sort(GitLabGroupGroupsListProjectsSharedSort.ASC)
                                        .simple(true)
                                        .starred(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .minAccessLevel(GitLabGroupGroupsListProjectsSharedMinAccessLevel.GUEST)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .visibility(null);

        final GitLabGroupGroupsListProjectsSharedFilter built = builder.build();

        assertThat(built.visibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabGroupGroupsListProjectsSharedFilterBuilder builder =
                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder(
                                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder()
                                        .archived(true)
                                        .visibility(GitLabGroupGroupsListProjectsSharedVisibility.PRIVATE)
                                        .search("search")
                                        .orderBy(GitLabGroupGroupsListProjectsSharedOrderBy.ID)
                                        .sort(GitLabGroupGroupsListProjectsSharedSort.ASC)
                                        .simple(true)
                                        .starred(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .minAccessLevel(GitLabGroupGroupsListProjectsSharedMinAccessLevel.GUEST)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .search(null);

        final GitLabGroupGroupsListProjectsSharedFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabGroupGroupsListProjectsSharedFilterBuilder builder =
                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder(
                                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder()
                                        .archived(true)
                                        .visibility(GitLabGroupGroupsListProjectsSharedVisibility.PRIVATE)
                                        .search("search")
                                        .orderBy(GitLabGroupGroupsListProjectsSharedOrderBy.ID)
                                        .sort(GitLabGroupGroupsListProjectsSharedSort.ASC)
                                        .simple(true)
                                        .starred(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .minAccessLevel(GitLabGroupGroupsListProjectsSharedMinAccessLevel.GUEST)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .orderBy(null);

        final GitLabGroupGroupsListProjectsSharedFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabGroupGroupsListProjectsSharedFilterBuilder builder =
                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder(
                                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder()
                                        .archived(true)
                                        .visibility(GitLabGroupGroupsListProjectsSharedVisibility.PRIVATE)
                                        .search("search")
                                        .orderBy(GitLabGroupGroupsListProjectsSharedOrderBy.ID)
                                        .sort(GitLabGroupGroupsListProjectsSharedSort.ASC)
                                        .simple(true)
                                        .starred(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .minAccessLevel(GitLabGroupGroupsListProjectsSharedMinAccessLevel.GUEST)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .sort(null);

        final GitLabGroupGroupsListProjectsSharedFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSimpleIsNullable() {
        final GitLabGroupGroupsListProjectsSharedFilterBuilder builder =
                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder(
                                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder()
                                        .archived(true)
                                        .visibility(GitLabGroupGroupsListProjectsSharedVisibility.PRIVATE)
                                        .search("search")
                                        .orderBy(GitLabGroupGroupsListProjectsSharedOrderBy.ID)
                                        .sort(GitLabGroupGroupsListProjectsSharedSort.ASC)
                                        .simple(true)
                                        .starred(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .minAccessLevel(GitLabGroupGroupsListProjectsSharedMinAccessLevel.GUEST)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .simple(null);

        final GitLabGroupGroupsListProjectsSharedFilter built = builder.build();

        assertThat(built.simple()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStarredIsNullable() {
        final GitLabGroupGroupsListProjectsSharedFilterBuilder builder =
                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder(
                                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder()
                                        .archived(true)
                                        .visibility(GitLabGroupGroupsListProjectsSharedVisibility.PRIVATE)
                                        .search("search")
                                        .orderBy(GitLabGroupGroupsListProjectsSharedOrderBy.ID)
                                        .sort(GitLabGroupGroupsListProjectsSharedSort.ASC)
                                        .simple(true)
                                        .starred(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .minAccessLevel(GitLabGroupGroupsListProjectsSharedMinAccessLevel.GUEST)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .starred(null);

        final GitLabGroupGroupsListProjectsSharedFilter built = builder.build();

        assertThat(built.starred()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithIssuesEnabledIsNullable() {
        final GitLabGroupGroupsListProjectsSharedFilterBuilder builder =
                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder(
                                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder()
                                        .archived(true)
                                        .visibility(GitLabGroupGroupsListProjectsSharedVisibility.PRIVATE)
                                        .search("search")
                                        .orderBy(GitLabGroupGroupsListProjectsSharedOrderBy.ID)
                                        .sort(GitLabGroupGroupsListProjectsSharedSort.ASC)
                                        .simple(true)
                                        .starred(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .minAccessLevel(GitLabGroupGroupsListProjectsSharedMinAccessLevel.GUEST)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .withIssuesEnabled(null);

        final GitLabGroupGroupsListProjectsSharedFilter built = builder.build();

        assertThat(built.withIssuesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithMergeRequestsEnabledIsNullable() {
        final GitLabGroupGroupsListProjectsSharedFilterBuilder builder =
                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder(
                                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder()
                                        .archived(true)
                                        .visibility(GitLabGroupGroupsListProjectsSharedVisibility.PRIVATE)
                                        .search("search")
                                        .orderBy(GitLabGroupGroupsListProjectsSharedOrderBy.ID)
                                        .sort(GitLabGroupGroupsListProjectsSharedSort.ASC)
                                        .simple(true)
                                        .starred(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .minAccessLevel(GitLabGroupGroupsListProjectsSharedMinAccessLevel.GUEST)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .withMergeRequestsEnabled(null);

        final GitLabGroupGroupsListProjectsSharedFilter built = builder.build();

        assertThat(built.withMergeRequestsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinAccessLevelIsNullable() {
        final GitLabGroupGroupsListProjectsSharedFilterBuilder builder =
                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder(
                                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder()
                                        .archived(true)
                                        .visibility(GitLabGroupGroupsListProjectsSharedVisibility.PRIVATE)
                                        .search("search")
                                        .orderBy(GitLabGroupGroupsListProjectsSharedOrderBy.ID)
                                        .sort(GitLabGroupGroupsListProjectsSharedSort.ASC)
                                        .simple(true)
                                        .starred(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .minAccessLevel(GitLabGroupGroupsListProjectsSharedMinAccessLevel.GUEST)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .minAccessLevel(null);

        final GitLabGroupGroupsListProjectsSharedFilter built = builder.build();

        assertThat(built.minAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithCustomAttributesIsNullable() {
        final GitLabGroupGroupsListProjectsSharedFilterBuilder builder =
                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder(
                                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder()
                                        .archived(true)
                                        .visibility(GitLabGroupGroupsListProjectsSharedVisibility.PRIVATE)
                                        .search("search")
                                        .orderBy(GitLabGroupGroupsListProjectsSharedOrderBy.ID)
                                        .sort(GitLabGroupGroupsListProjectsSharedSort.ASC)
                                        .simple(true)
                                        .starred(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .minAccessLevel(GitLabGroupGroupsListProjectsSharedMinAccessLevel.GUEST)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .withCustomAttributes(null);

        final GitLabGroupGroupsListProjectsSharedFilter built = builder.build();

        assertThat(built.withCustomAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabGroupGroupsListProjectsSharedFilterBuilder builder =
                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder(
                                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder()
                                        .archived(true)
                                        .visibility(GitLabGroupGroupsListProjectsSharedVisibility.PRIVATE)
                                        .search("search")
                                        .orderBy(GitLabGroupGroupsListProjectsSharedOrderBy.ID)
                                        .sort(GitLabGroupGroupsListProjectsSharedSort.ASC)
                                        .simple(true)
                                        .starred(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .minAccessLevel(GitLabGroupGroupsListProjectsSharedMinAccessLevel.GUEST)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .customAttributes(null);

        final GitLabGroupGroupsListProjectsSharedFilter built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsListProjectsSharedFilter value =
                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder()
                        .archived(true)
                        .visibility(GitLabGroupGroupsListProjectsSharedVisibility.PRIVATE)
                        .search("search")
                        .orderBy(GitLabGroupGroupsListProjectsSharedOrderBy.ID)
                        .sort(GitLabGroupGroupsListProjectsSharedSort.ASC)
                        .simple(true)
                        .starred(true)
                        .withIssuesEnabled(true)
                        .withMergeRequestsEnabled(true)
                        .minAccessLevel(GitLabGroupGroupsListProjectsSharedMinAccessLevel.GUEST)
                        .withCustomAttributes(true)
                        .customAttributes(Map.of("key", "value"))
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.archived()).isEqualTo(true);
            softly.assertThat(value.visibility()).isEqualTo(GitLabGroupGroupsListProjectsSharedVisibility.PRIVATE);
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.orderBy()).isEqualTo(GitLabGroupGroupsListProjectsSharedOrderBy.ID);
            softly.assertThat(value.sort()).isEqualTo(GitLabGroupGroupsListProjectsSharedSort.ASC);
            softly.assertThat(value.simple()).isEqualTo(true);
            softly.assertThat(value.starred()).isEqualTo(true);
            softly.assertThat(value.withIssuesEnabled()).isEqualTo(true);
            softly.assertThat(value.withMergeRequestsEnabled()).isEqualTo(true);
            softly.assertThat(value.minAccessLevel())
                    .isEqualTo(GitLabGroupGroupsListProjectsSharedMinAccessLevel.GUEST);
            softly.assertThat(value.withCustomAttributes()).isEqualTo(true);
            softly.assertThat(value.customAttributes()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupsListProjectsSharedFilter original =
                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder()
                        .archived(true)
                        .visibility(GitLabGroupGroupsListProjectsSharedVisibility.PRIVATE)
                        .search("search")
                        .orderBy(GitLabGroupGroupsListProjectsSharedOrderBy.ID)
                        .sort(GitLabGroupGroupsListProjectsSharedSort.ASC)
                        .simple(true)
                        .starred(true)
                        .withIssuesEnabled(true)
                        .withMergeRequestsEnabled(true)
                        .minAccessLevel(GitLabGroupGroupsListProjectsSharedMinAccessLevel.GUEST)
                        .withCustomAttributes(true)
                        .customAttributes(Map.of("key", "value"))
                        .build();

        final GitLabGroupGroupsListProjectsSharedFilter rebuilt =
                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenCustomAttributesSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabGroupGroupsListProjectsSharedFilter built =
                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder(
                                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder()
                                        .archived(true)
                                        .visibility(GitLabGroupGroupsListProjectsSharedVisibility.PRIVATE)
                                        .search("search")
                                        .orderBy(GitLabGroupGroupsListProjectsSharedOrderBy.ID)
                                        .sort(GitLabGroupGroupsListProjectsSharedSort.ASC)
                                        .simple(true)
                                        .starred(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .minAccessLevel(GitLabGroupGroupsListProjectsSharedMinAccessLevel.GUEST)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .customAttributes(source)
                        .build();
        source.clear();

        assertThat(built.customAttributes()).isNotEmpty();
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupsListProjectsSharedFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "archived",
                        "visibility",
                        "search",
                        "orderBy",
                        "sort",
                        "simple",
                        "starred",
                        "withIssuesEnabled",
                        "withMergeRequestsEnabled",
                        "minAccessLevel",
                        "withCustomAttributes",
                        "customAttributes");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupGroupsListProjectsSharedFilter empty = GitLabGroupGroupsListProjectsSharedFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupGroupsListProjectsSharedFilter filter =
                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder()
                        .archived(true)
                        .visibility(GitLabGroupGroupsListProjectsSharedVisibility.PRIVATE)
                        .search("search")
                        .orderBy(GitLabGroupGroupsListProjectsSharedOrderBy.ID)
                        .sort(GitLabGroupGroupsListProjectsSharedSort.ASC)
                        .simple(true)
                        .starred(true)
                        .withIssuesEnabled(true)
                        .withMergeRequestsEnabled(true)
                        .minAccessLevel(GitLabGroupGroupsListProjectsSharedMinAccessLevel.GUEST)
                        .withCustomAttributes(true)
                        .customAttributes(Map.of("key", "value"))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("archived", "true"),
                        Map.entry("visibility", "private"),
                        Map.entry("search", "search"),
                        Map.entry("order_by", "id"),
                        Map.entry("sort", "asc"),
                        Map.entry("simple", "true"),
                        Map.entry("starred", "true"),
                        Map.entry("with_issues_enabled", "true"),
                        Map.entry("with_merge_requests_enabled", "true"),
                        Map.entry("min_access_level", "10"),
                        Map.entry("with_custom_attributes", "true"),
                        Map.entry("custom_attributes[key]", "value"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupGroupsListProjectsSharedFilter filter =
                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder()
                        .archived(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("archived", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupGroupsListProjectsSharedFilter filter =
                GitLabGroupGroupsListProjectsSharedFilterBuilder.builder()
                        .archived(true)
                        .visibility(GitLabGroupGroupsListProjectsSharedVisibility.PRIVATE)
                        .search("search")
                        .orderBy(GitLabGroupGroupsListProjectsSharedOrderBy.ID)
                        .sort(GitLabGroupGroupsListProjectsSharedSort.ASC)
                        .simple(true)
                        .starred(true)
                        .withIssuesEnabled(true)
                        .withMergeRequestsEnabled(true)
                        .minAccessLevel(GitLabGroupGroupsListProjectsSharedMinAccessLevel.GUEST)
                        .withCustomAttributes(true)
                        .customAttributes(Map.of("key", "value"))
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

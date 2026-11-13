package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupsListSharedFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenSkipGroupsIsNullable() {
        final GitLabGroupGroupsListSharedFilterBuilder builder = GitLabGroupGroupsListSharedFilterBuilder.builder(
                        GitLabGroupGroupsListSharedFilterBuilder.builder()
                                .skipGroups(List.of(1))
                                .visibility(GitLabGroupGroupsListSharedVisibility.PRIVATE)
                                .search("search")
                                .minAccessLevel(GitLabGroupGroupsListSharedMinAccessLevel.GUEST)
                                .orderBy(GitLabGroupGroupsListSharedOrderBy.NAME)
                                .sort(GitLabGroupGroupsListSharedSort.ASC)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build())
                .skipGroups(null);

        final GitLabGroupGroupsListSharedFilter built = builder.build();

        assertThat(built.skipGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVisibilityIsNullable() {
        final GitLabGroupGroupsListSharedFilterBuilder builder = GitLabGroupGroupsListSharedFilterBuilder.builder(
                        GitLabGroupGroupsListSharedFilterBuilder.builder()
                                .skipGroups(List.of(1))
                                .visibility(GitLabGroupGroupsListSharedVisibility.PRIVATE)
                                .search("search")
                                .minAccessLevel(GitLabGroupGroupsListSharedMinAccessLevel.GUEST)
                                .orderBy(GitLabGroupGroupsListSharedOrderBy.NAME)
                                .sort(GitLabGroupGroupsListSharedSort.ASC)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build())
                .visibility(null);

        final GitLabGroupGroupsListSharedFilter built = builder.build();

        assertThat(built.visibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabGroupGroupsListSharedFilterBuilder builder = GitLabGroupGroupsListSharedFilterBuilder.builder(
                        GitLabGroupGroupsListSharedFilterBuilder.builder()
                                .skipGroups(List.of(1))
                                .visibility(GitLabGroupGroupsListSharedVisibility.PRIVATE)
                                .search("search")
                                .minAccessLevel(GitLabGroupGroupsListSharedMinAccessLevel.GUEST)
                                .orderBy(GitLabGroupGroupsListSharedOrderBy.NAME)
                                .sort(GitLabGroupGroupsListSharedSort.ASC)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build())
                .search(null);

        final GitLabGroupGroupsListSharedFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinAccessLevelIsNullable() {
        final GitLabGroupGroupsListSharedFilterBuilder builder = GitLabGroupGroupsListSharedFilterBuilder.builder(
                        GitLabGroupGroupsListSharedFilterBuilder.builder()
                                .skipGroups(List.of(1))
                                .visibility(GitLabGroupGroupsListSharedVisibility.PRIVATE)
                                .search("search")
                                .minAccessLevel(GitLabGroupGroupsListSharedMinAccessLevel.GUEST)
                                .orderBy(GitLabGroupGroupsListSharedOrderBy.NAME)
                                .sort(GitLabGroupGroupsListSharedSort.ASC)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build())
                .minAccessLevel(null);

        final GitLabGroupGroupsListSharedFilter built = builder.build();

        assertThat(built.minAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabGroupGroupsListSharedFilterBuilder builder = GitLabGroupGroupsListSharedFilterBuilder.builder(
                        GitLabGroupGroupsListSharedFilterBuilder.builder()
                                .skipGroups(List.of(1))
                                .visibility(GitLabGroupGroupsListSharedVisibility.PRIVATE)
                                .search("search")
                                .minAccessLevel(GitLabGroupGroupsListSharedMinAccessLevel.GUEST)
                                .orderBy(GitLabGroupGroupsListSharedOrderBy.NAME)
                                .sort(GitLabGroupGroupsListSharedSort.ASC)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build())
                .orderBy(null);

        final GitLabGroupGroupsListSharedFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabGroupGroupsListSharedFilterBuilder builder = GitLabGroupGroupsListSharedFilterBuilder.builder(
                        GitLabGroupGroupsListSharedFilterBuilder.builder()
                                .skipGroups(List.of(1))
                                .visibility(GitLabGroupGroupsListSharedVisibility.PRIVATE)
                                .search("search")
                                .minAccessLevel(GitLabGroupGroupsListSharedMinAccessLevel.GUEST)
                                .orderBy(GitLabGroupGroupsListSharedOrderBy.NAME)
                                .sort(GitLabGroupGroupsListSharedSort.ASC)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build())
                .sort(null);

        final GitLabGroupGroupsListSharedFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithCustomAttributesIsNullable() {
        final GitLabGroupGroupsListSharedFilterBuilder builder = GitLabGroupGroupsListSharedFilterBuilder.builder(
                        GitLabGroupGroupsListSharedFilterBuilder.builder()
                                .skipGroups(List.of(1))
                                .visibility(GitLabGroupGroupsListSharedVisibility.PRIVATE)
                                .search("search")
                                .minAccessLevel(GitLabGroupGroupsListSharedMinAccessLevel.GUEST)
                                .orderBy(GitLabGroupGroupsListSharedOrderBy.NAME)
                                .sort(GitLabGroupGroupsListSharedSort.ASC)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build())
                .withCustomAttributes(null);

        final GitLabGroupGroupsListSharedFilter built = builder.build();

        assertThat(built.withCustomAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabGroupGroupsListSharedFilterBuilder builder = GitLabGroupGroupsListSharedFilterBuilder.builder(
                        GitLabGroupGroupsListSharedFilterBuilder.builder()
                                .skipGroups(List.of(1))
                                .visibility(GitLabGroupGroupsListSharedVisibility.PRIVATE)
                                .search("search")
                                .minAccessLevel(GitLabGroupGroupsListSharedMinAccessLevel.GUEST)
                                .orderBy(GitLabGroupGroupsListSharedOrderBy.NAME)
                                .sort(GitLabGroupGroupsListSharedSort.ASC)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build())
                .customAttributes(null);

        final GitLabGroupGroupsListSharedFilter built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsListSharedFilter value = GitLabGroupGroupsListSharedFilterBuilder.builder()
                .skipGroups(List.of(1))
                .visibility(GitLabGroupGroupsListSharedVisibility.PRIVATE)
                .search("search")
                .minAccessLevel(GitLabGroupGroupsListSharedMinAccessLevel.GUEST)
                .orderBy(GitLabGroupGroupsListSharedOrderBy.NAME)
                .sort(GitLabGroupGroupsListSharedSort.ASC)
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.skipGroups()).isEqualTo(List.of(1));
            softly.assertThat(value.visibility()).isEqualTo(GitLabGroupGroupsListSharedVisibility.PRIVATE);
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.minAccessLevel()).isEqualTo(GitLabGroupGroupsListSharedMinAccessLevel.GUEST);
            softly.assertThat(value.orderBy()).isEqualTo(GitLabGroupGroupsListSharedOrderBy.NAME);
            softly.assertThat(value.sort()).isEqualTo(GitLabGroupGroupsListSharedSort.ASC);
            softly.assertThat(value.withCustomAttributes()).isEqualTo(true);
            softly.assertThat(value.customAttributes()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupsListSharedFilter original = GitLabGroupGroupsListSharedFilterBuilder.builder()
                .skipGroups(List.of(1))
                .visibility(GitLabGroupGroupsListSharedVisibility.PRIVATE)
                .search("search")
                .minAccessLevel(GitLabGroupGroupsListSharedMinAccessLevel.GUEST)
                .orderBy(GitLabGroupGroupsListSharedOrderBy.NAME)
                .sort(GitLabGroupGroupsListSharedSort.ASC)
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .build();

        final GitLabGroupGroupsListSharedFilter rebuilt =
                GitLabGroupGroupsListSharedFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenSkipGroupsSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabGroupGroupsListSharedFilter built = GitLabGroupGroupsListSharedFilterBuilder.builder(
                        GitLabGroupGroupsListSharedFilterBuilder.builder()
                                .skipGroups(List.of(1))
                                .visibility(GitLabGroupGroupsListSharedVisibility.PRIVATE)
                                .search("search")
                                .minAccessLevel(GitLabGroupGroupsListSharedMinAccessLevel.GUEST)
                                .orderBy(GitLabGroupGroupsListSharedOrderBy.NAME)
                                .sort(GitLabGroupGroupsListSharedSort.ASC)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build())
                .skipGroups(source)
                .build();
        source.clear();

        assertThat(built.skipGroups()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenSkipGroupsIsRead() {
        final GitLabGroupGroupsListSharedFilter built = GitLabGroupGroupsListSharedFilterBuilder.builder()
                .skipGroups(List.of(1))
                .visibility(GitLabGroupGroupsListSharedVisibility.PRIVATE)
                .search("search")
                .minAccessLevel(GitLabGroupGroupsListSharedMinAccessLevel.GUEST)
                .orderBy(GitLabGroupGroupsListSharedOrderBy.NAME)
                .sort(GitLabGroupGroupsListSharedSort.ASC)
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .build();
        final List<Integer> values = built.skipGroups();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheMap_whenCustomAttributesSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabGroupGroupsListSharedFilter built = GitLabGroupGroupsListSharedFilterBuilder.builder(
                        GitLabGroupGroupsListSharedFilterBuilder.builder()
                                .skipGroups(List.of(1))
                                .visibility(GitLabGroupGroupsListSharedVisibility.PRIVATE)
                                .search("search")
                                .minAccessLevel(GitLabGroupGroupsListSharedMinAccessLevel.GUEST)
                                .orderBy(GitLabGroupGroupsListSharedOrderBy.NAME)
                                .sort(GitLabGroupGroupsListSharedSort.ASC)
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
        final String[] names = Arrays.stream(GitLabGroupGroupsListSharedFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "skipGroups",
                        "visibility",
                        "search",
                        "minAccessLevel",
                        "orderBy",
                        "sort",
                        "withCustomAttributes",
                        "customAttributes");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupGroupsListSharedFilter empty = GitLabGroupGroupsListSharedFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupGroupsListSharedFilter filter = GitLabGroupGroupsListSharedFilterBuilder.builder()
                .skipGroups(List.of(1))
                .visibility(GitLabGroupGroupsListSharedVisibility.PRIVATE)
                .search("search")
                .minAccessLevel(GitLabGroupGroupsListSharedMinAccessLevel.GUEST)
                .orderBy(GitLabGroupGroupsListSharedOrderBy.NAME)
                .sort(GitLabGroupGroupsListSharedSort.ASC)
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("skip_groups", "1"),
                        Map.entry("visibility", "private"),
                        Map.entry("search", "search"),
                        Map.entry("min_access_level", "10"),
                        Map.entry("order_by", "name"),
                        Map.entry("sort", "asc"),
                        Map.entry("with_custom_attributes", "true"),
                        Map.entry("custom_attributes[key]", "value"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupGroupsListSharedFilter filter = GitLabGroupGroupsListSharedFilterBuilder.builder()
                .skipGroups(List.of(1))
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("skip_groups", "1"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupGroupsListSharedFilter filter = GitLabGroupGroupsListSharedFilterBuilder.builder()
                .skipGroups(List.of(1))
                .visibility(GitLabGroupGroupsListSharedVisibility.PRIVATE)
                .search("search")
                .minAccessLevel(GitLabGroupGroupsListSharedMinAccessLevel.GUEST)
                .orderBy(GitLabGroupGroupsListSharedOrderBy.NAME)
                .sort(GitLabGroupGroupsListSharedSort.ASC)
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

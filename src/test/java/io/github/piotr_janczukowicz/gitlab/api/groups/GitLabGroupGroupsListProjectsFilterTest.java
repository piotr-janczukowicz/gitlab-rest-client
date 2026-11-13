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
class GitLabGroupGroupsListProjectsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabGroupGroupsListProjectsFilterBuilder builder = GitLabGroupGroupsListProjectsFilterBuilder.builder(
                        GitLabGroupGroupsListProjectsFilterBuilder.builder()
                                .active(true)
                                .archived(true)
                                .visibility(GitLabGroupGroupsListProjectsVisibility.PRIVATE)
                                .search("search")
                                .orderBy(GitLabGroupGroupsListProjectsOrderBy.ID)
                                .sort(GitLabGroupGroupsListProjectsSort.ASC)
                                .simple(true)
                                .owned(true)
                                .starred(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withShared(true)
                                .includeSubgroups(true)
                                .includeAncestorGroups(true)
                                .minAccessLevel(GitLabGroupGroupsListProjectsMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .withSecurityReports(true)
                                .build())
                .active(null);

        final GitLabGroupGroupsListProjectsFilter built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchivedIsNullable() {
        final GitLabGroupGroupsListProjectsFilterBuilder builder = GitLabGroupGroupsListProjectsFilterBuilder.builder(
                        GitLabGroupGroupsListProjectsFilterBuilder.builder()
                                .active(true)
                                .archived(true)
                                .visibility(GitLabGroupGroupsListProjectsVisibility.PRIVATE)
                                .search("search")
                                .orderBy(GitLabGroupGroupsListProjectsOrderBy.ID)
                                .sort(GitLabGroupGroupsListProjectsSort.ASC)
                                .simple(true)
                                .owned(true)
                                .starred(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withShared(true)
                                .includeSubgroups(true)
                                .includeAncestorGroups(true)
                                .minAccessLevel(GitLabGroupGroupsListProjectsMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .withSecurityReports(true)
                                .build())
                .archived(null);

        final GitLabGroupGroupsListProjectsFilter built = builder.build();

        assertThat(built.archived()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVisibilityIsNullable() {
        final GitLabGroupGroupsListProjectsFilterBuilder builder = GitLabGroupGroupsListProjectsFilterBuilder.builder(
                        GitLabGroupGroupsListProjectsFilterBuilder.builder()
                                .active(true)
                                .archived(true)
                                .visibility(GitLabGroupGroupsListProjectsVisibility.PRIVATE)
                                .search("search")
                                .orderBy(GitLabGroupGroupsListProjectsOrderBy.ID)
                                .sort(GitLabGroupGroupsListProjectsSort.ASC)
                                .simple(true)
                                .owned(true)
                                .starred(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withShared(true)
                                .includeSubgroups(true)
                                .includeAncestorGroups(true)
                                .minAccessLevel(GitLabGroupGroupsListProjectsMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .withSecurityReports(true)
                                .build())
                .visibility(null);

        final GitLabGroupGroupsListProjectsFilter built = builder.build();

        assertThat(built.visibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabGroupGroupsListProjectsFilterBuilder builder = GitLabGroupGroupsListProjectsFilterBuilder.builder(
                        GitLabGroupGroupsListProjectsFilterBuilder.builder()
                                .active(true)
                                .archived(true)
                                .visibility(GitLabGroupGroupsListProjectsVisibility.PRIVATE)
                                .search("search")
                                .orderBy(GitLabGroupGroupsListProjectsOrderBy.ID)
                                .sort(GitLabGroupGroupsListProjectsSort.ASC)
                                .simple(true)
                                .owned(true)
                                .starred(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withShared(true)
                                .includeSubgroups(true)
                                .includeAncestorGroups(true)
                                .minAccessLevel(GitLabGroupGroupsListProjectsMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .withSecurityReports(true)
                                .build())
                .search(null);

        final GitLabGroupGroupsListProjectsFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabGroupGroupsListProjectsFilterBuilder builder = GitLabGroupGroupsListProjectsFilterBuilder.builder(
                        GitLabGroupGroupsListProjectsFilterBuilder.builder()
                                .active(true)
                                .archived(true)
                                .visibility(GitLabGroupGroupsListProjectsVisibility.PRIVATE)
                                .search("search")
                                .orderBy(GitLabGroupGroupsListProjectsOrderBy.ID)
                                .sort(GitLabGroupGroupsListProjectsSort.ASC)
                                .simple(true)
                                .owned(true)
                                .starred(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withShared(true)
                                .includeSubgroups(true)
                                .includeAncestorGroups(true)
                                .minAccessLevel(GitLabGroupGroupsListProjectsMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .withSecurityReports(true)
                                .build())
                .orderBy(null);

        final GitLabGroupGroupsListProjectsFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabGroupGroupsListProjectsFilterBuilder builder = GitLabGroupGroupsListProjectsFilterBuilder.builder(
                        GitLabGroupGroupsListProjectsFilterBuilder.builder()
                                .active(true)
                                .archived(true)
                                .visibility(GitLabGroupGroupsListProjectsVisibility.PRIVATE)
                                .search("search")
                                .orderBy(GitLabGroupGroupsListProjectsOrderBy.ID)
                                .sort(GitLabGroupGroupsListProjectsSort.ASC)
                                .simple(true)
                                .owned(true)
                                .starred(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withShared(true)
                                .includeSubgroups(true)
                                .includeAncestorGroups(true)
                                .minAccessLevel(GitLabGroupGroupsListProjectsMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .withSecurityReports(true)
                                .build())
                .sort(null);

        final GitLabGroupGroupsListProjectsFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSimpleIsNullable() {
        final GitLabGroupGroupsListProjectsFilterBuilder builder = GitLabGroupGroupsListProjectsFilterBuilder.builder(
                        GitLabGroupGroupsListProjectsFilterBuilder.builder()
                                .active(true)
                                .archived(true)
                                .visibility(GitLabGroupGroupsListProjectsVisibility.PRIVATE)
                                .search("search")
                                .orderBy(GitLabGroupGroupsListProjectsOrderBy.ID)
                                .sort(GitLabGroupGroupsListProjectsSort.ASC)
                                .simple(true)
                                .owned(true)
                                .starred(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withShared(true)
                                .includeSubgroups(true)
                                .includeAncestorGroups(true)
                                .minAccessLevel(GitLabGroupGroupsListProjectsMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .withSecurityReports(true)
                                .build())
                .simple(null);

        final GitLabGroupGroupsListProjectsFilter built = builder.build();

        assertThat(built.simple()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOwnedIsNullable() {
        final GitLabGroupGroupsListProjectsFilterBuilder builder = GitLabGroupGroupsListProjectsFilterBuilder.builder(
                        GitLabGroupGroupsListProjectsFilterBuilder.builder()
                                .active(true)
                                .archived(true)
                                .visibility(GitLabGroupGroupsListProjectsVisibility.PRIVATE)
                                .search("search")
                                .orderBy(GitLabGroupGroupsListProjectsOrderBy.ID)
                                .sort(GitLabGroupGroupsListProjectsSort.ASC)
                                .simple(true)
                                .owned(true)
                                .starred(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withShared(true)
                                .includeSubgroups(true)
                                .includeAncestorGroups(true)
                                .minAccessLevel(GitLabGroupGroupsListProjectsMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .withSecurityReports(true)
                                .build())
                .owned(null);

        final GitLabGroupGroupsListProjectsFilter built = builder.build();

        assertThat(built.owned()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStarredIsNullable() {
        final GitLabGroupGroupsListProjectsFilterBuilder builder = GitLabGroupGroupsListProjectsFilterBuilder.builder(
                        GitLabGroupGroupsListProjectsFilterBuilder.builder()
                                .active(true)
                                .archived(true)
                                .visibility(GitLabGroupGroupsListProjectsVisibility.PRIVATE)
                                .search("search")
                                .orderBy(GitLabGroupGroupsListProjectsOrderBy.ID)
                                .sort(GitLabGroupGroupsListProjectsSort.ASC)
                                .simple(true)
                                .owned(true)
                                .starred(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withShared(true)
                                .includeSubgroups(true)
                                .includeAncestorGroups(true)
                                .minAccessLevel(GitLabGroupGroupsListProjectsMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .withSecurityReports(true)
                                .build())
                .starred(null);

        final GitLabGroupGroupsListProjectsFilter built = builder.build();

        assertThat(built.starred()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithIssuesEnabledIsNullable() {
        final GitLabGroupGroupsListProjectsFilterBuilder builder = GitLabGroupGroupsListProjectsFilterBuilder.builder(
                        GitLabGroupGroupsListProjectsFilterBuilder.builder()
                                .active(true)
                                .archived(true)
                                .visibility(GitLabGroupGroupsListProjectsVisibility.PRIVATE)
                                .search("search")
                                .orderBy(GitLabGroupGroupsListProjectsOrderBy.ID)
                                .sort(GitLabGroupGroupsListProjectsSort.ASC)
                                .simple(true)
                                .owned(true)
                                .starred(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withShared(true)
                                .includeSubgroups(true)
                                .includeAncestorGroups(true)
                                .minAccessLevel(GitLabGroupGroupsListProjectsMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .withSecurityReports(true)
                                .build())
                .withIssuesEnabled(null);

        final GitLabGroupGroupsListProjectsFilter built = builder.build();

        assertThat(built.withIssuesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithMergeRequestsEnabledIsNullable() {
        final GitLabGroupGroupsListProjectsFilterBuilder builder = GitLabGroupGroupsListProjectsFilterBuilder.builder(
                        GitLabGroupGroupsListProjectsFilterBuilder.builder()
                                .active(true)
                                .archived(true)
                                .visibility(GitLabGroupGroupsListProjectsVisibility.PRIVATE)
                                .search("search")
                                .orderBy(GitLabGroupGroupsListProjectsOrderBy.ID)
                                .sort(GitLabGroupGroupsListProjectsSort.ASC)
                                .simple(true)
                                .owned(true)
                                .starred(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withShared(true)
                                .includeSubgroups(true)
                                .includeAncestorGroups(true)
                                .minAccessLevel(GitLabGroupGroupsListProjectsMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .withSecurityReports(true)
                                .build())
                .withMergeRequestsEnabled(null);

        final GitLabGroupGroupsListProjectsFilter built = builder.build();

        assertThat(built.withMergeRequestsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithSharedIsNullable() {
        final GitLabGroupGroupsListProjectsFilterBuilder builder = GitLabGroupGroupsListProjectsFilterBuilder.builder(
                        GitLabGroupGroupsListProjectsFilterBuilder.builder()
                                .active(true)
                                .archived(true)
                                .visibility(GitLabGroupGroupsListProjectsVisibility.PRIVATE)
                                .search("search")
                                .orderBy(GitLabGroupGroupsListProjectsOrderBy.ID)
                                .sort(GitLabGroupGroupsListProjectsSort.ASC)
                                .simple(true)
                                .owned(true)
                                .starred(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withShared(true)
                                .includeSubgroups(true)
                                .includeAncestorGroups(true)
                                .minAccessLevel(GitLabGroupGroupsListProjectsMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .withSecurityReports(true)
                                .build())
                .withShared(null);

        final GitLabGroupGroupsListProjectsFilter built = builder.build();

        assertThat(built.withShared()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeSubgroupsIsNullable() {
        final GitLabGroupGroupsListProjectsFilterBuilder builder = GitLabGroupGroupsListProjectsFilterBuilder.builder(
                        GitLabGroupGroupsListProjectsFilterBuilder.builder()
                                .active(true)
                                .archived(true)
                                .visibility(GitLabGroupGroupsListProjectsVisibility.PRIVATE)
                                .search("search")
                                .orderBy(GitLabGroupGroupsListProjectsOrderBy.ID)
                                .sort(GitLabGroupGroupsListProjectsSort.ASC)
                                .simple(true)
                                .owned(true)
                                .starred(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withShared(true)
                                .includeSubgroups(true)
                                .includeAncestorGroups(true)
                                .minAccessLevel(GitLabGroupGroupsListProjectsMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .withSecurityReports(true)
                                .build())
                .includeSubgroups(null);

        final GitLabGroupGroupsListProjectsFilter built = builder.build();

        assertThat(built.includeSubgroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeAncestorGroupsIsNullable() {
        final GitLabGroupGroupsListProjectsFilterBuilder builder = GitLabGroupGroupsListProjectsFilterBuilder.builder(
                        GitLabGroupGroupsListProjectsFilterBuilder.builder()
                                .active(true)
                                .archived(true)
                                .visibility(GitLabGroupGroupsListProjectsVisibility.PRIVATE)
                                .search("search")
                                .orderBy(GitLabGroupGroupsListProjectsOrderBy.ID)
                                .sort(GitLabGroupGroupsListProjectsSort.ASC)
                                .simple(true)
                                .owned(true)
                                .starred(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withShared(true)
                                .includeSubgroups(true)
                                .includeAncestorGroups(true)
                                .minAccessLevel(GitLabGroupGroupsListProjectsMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .withSecurityReports(true)
                                .build())
                .includeAncestorGroups(null);

        final GitLabGroupGroupsListProjectsFilter built = builder.build();

        assertThat(built.includeAncestorGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinAccessLevelIsNullable() {
        final GitLabGroupGroupsListProjectsFilterBuilder builder = GitLabGroupGroupsListProjectsFilterBuilder.builder(
                        GitLabGroupGroupsListProjectsFilterBuilder.builder()
                                .active(true)
                                .archived(true)
                                .visibility(GitLabGroupGroupsListProjectsVisibility.PRIVATE)
                                .search("search")
                                .orderBy(GitLabGroupGroupsListProjectsOrderBy.ID)
                                .sort(GitLabGroupGroupsListProjectsSort.ASC)
                                .simple(true)
                                .owned(true)
                                .starred(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withShared(true)
                                .includeSubgroups(true)
                                .includeAncestorGroups(true)
                                .minAccessLevel(GitLabGroupGroupsListProjectsMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .withSecurityReports(true)
                                .build())
                .minAccessLevel(null);

        final GitLabGroupGroupsListProjectsFilter built = builder.build();

        assertThat(built.minAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithCustomAttributesIsNullable() {
        final GitLabGroupGroupsListProjectsFilterBuilder builder = GitLabGroupGroupsListProjectsFilterBuilder.builder(
                        GitLabGroupGroupsListProjectsFilterBuilder.builder()
                                .active(true)
                                .archived(true)
                                .visibility(GitLabGroupGroupsListProjectsVisibility.PRIVATE)
                                .search("search")
                                .orderBy(GitLabGroupGroupsListProjectsOrderBy.ID)
                                .sort(GitLabGroupGroupsListProjectsSort.ASC)
                                .simple(true)
                                .owned(true)
                                .starred(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withShared(true)
                                .includeSubgroups(true)
                                .includeAncestorGroups(true)
                                .minAccessLevel(GitLabGroupGroupsListProjectsMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .withSecurityReports(true)
                                .build())
                .withCustomAttributes(null);

        final GitLabGroupGroupsListProjectsFilter built = builder.build();

        assertThat(built.withCustomAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabGroupGroupsListProjectsFilterBuilder builder = GitLabGroupGroupsListProjectsFilterBuilder.builder(
                        GitLabGroupGroupsListProjectsFilterBuilder.builder()
                                .active(true)
                                .archived(true)
                                .visibility(GitLabGroupGroupsListProjectsVisibility.PRIVATE)
                                .search("search")
                                .orderBy(GitLabGroupGroupsListProjectsOrderBy.ID)
                                .sort(GitLabGroupGroupsListProjectsSort.ASC)
                                .simple(true)
                                .owned(true)
                                .starred(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withShared(true)
                                .includeSubgroups(true)
                                .includeAncestorGroups(true)
                                .minAccessLevel(GitLabGroupGroupsListProjectsMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .withSecurityReports(true)
                                .build())
                .customAttributes(null);

        final GitLabGroupGroupsListProjectsFilter built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithSecurityReportsIsNullable() {
        final GitLabGroupGroupsListProjectsFilterBuilder builder = GitLabGroupGroupsListProjectsFilterBuilder.builder(
                        GitLabGroupGroupsListProjectsFilterBuilder.builder()
                                .active(true)
                                .archived(true)
                                .visibility(GitLabGroupGroupsListProjectsVisibility.PRIVATE)
                                .search("search")
                                .orderBy(GitLabGroupGroupsListProjectsOrderBy.ID)
                                .sort(GitLabGroupGroupsListProjectsSort.ASC)
                                .simple(true)
                                .owned(true)
                                .starred(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withShared(true)
                                .includeSubgroups(true)
                                .includeAncestorGroups(true)
                                .minAccessLevel(GitLabGroupGroupsListProjectsMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .withSecurityReports(true)
                                .build())
                .withSecurityReports(null);

        final GitLabGroupGroupsListProjectsFilter built = builder.build();

        assertThat(built.withSecurityReports()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsListProjectsFilter value = GitLabGroupGroupsListProjectsFilterBuilder.builder()
                .active(true)
                .archived(true)
                .visibility(GitLabGroupGroupsListProjectsVisibility.PRIVATE)
                .search("search")
                .orderBy(GitLabGroupGroupsListProjectsOrderBy.ID)
                .sort(GitLabGroupGroupsListProjectsSort.ASC)
                .simple(true)
                .owned(true)
                .starred(true)
                .withIssuesEnabled(true)
                .withMergeRequestsEnabled(true)
                .withShared(true)
                .includeSubgroups(true)
                .includeAncestorGroups(true)
                .minAccessLevel(GitLabGroupGroupsListProjectsMinAccessLevel.GUEST)
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .withSecurityReports(true)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.active()).isEqualTo(true);
            softly.assertThat(value.archived()).isEqualTo(true);
            softly.assertThat(value.visibility()).isEqualTo(GitLabGroupGroupsListProjectsVisibility.PRIVATE);
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.orderBy()).isEqualTo(GitLabGroupGroupsListProjectsOrderBy.ID);
            softly.assertThat(value.sort()).isEqualTo(GitLabGroupGroupsListProjectsSort.ASC);
            softly.assertThat(value.simple()).isEqualTo(true);
            softly.assertThat(value.owned()).isEqualTo(true);
            softly.assertThat(value.starred()).isEqualTo(true);
            softly.assertThat(value.withIssuesEnabled()).isEqualTo(true);
            softly.assertThat(value.withMergeRequestsEnabled()).isEqualTo(true);
            softly.assertThat(value.withShared()).isEqualTo(true);
            softly.assertThat(value.includeSubgroups()).isEqualTo(true);
            softly.assertThat(value.includeAncestorGroups()).isEqualTo(true);
            softly.assertThat(value.minAccessLevel()).isEqualTo(GitLabGroupGroupsListProjectsMinAccessLevel.GUEST);
            softly.assertThat(value.withCustomAttributes()).isEqualTo(true);
            softly.assertThat(value.customAttributes()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.withSecurityReports()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupsListProjectsFilter original = GitLabGroupGroupsListProjectsFilterBuilder.builder()
                .active(true)
                .archived(true)
                .visibility(GitLabGroupGroupsListProjectsVisibility.PRIVATE)
                .search("search")
                .orderBy(GitLabGroupGroupsListProjectsOrderBy.ID)
                .sort(GitLabGroupGroupsListProjectsSort.ASC)
                .simple(true)
                .owned(true)
                .starred(true)
                .withIssuesEnabled(true)
                .withMergeRequestsEnabled(true)
                .withShared(true)
                .includeSubgroups(true)
                .includeAncestorGroups(true)
                .minAccessLevel(GitLabGroupGroupsListProjectsMinAccessLevel.GUEST)
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .withSecurityReports(true)
                .build();

        final GitLabGroupGroupsListProjectsFilter rebuilt =
                GitLabGroupGroupsListProjectsFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenCustomAttributesSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabGroupGroupsListProjectsFilter built = GitLabGroupGroupsListProjectsFilterBuilder.builder(
                        GitLabGroupGroupsListProjectsFilterBuilder.builder()
                                .active(true)
                                .archived(true)
                                .visibility(GitLabGroupGroupsListProjectsVisibility.PRIVATE)
                                .search("search")
                                .orderBy(GitLabGroupGroupsListProjectsOrderBy.ID)
                                .sort(GitLabGroupGroupsListProjectsSort.ASC)
                                .simple(true)
                                .owned(true)
                                .starred(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withShared(true)
                                .includeSubgroups(true)
                                .includeAncestorGroups(true)
                                .minAccessLevel(GitLabGroupGroupsListProjectsMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .withSecurityReports(true)
                                .build())
                .customAttributes(source)
                .build();
        source.clear();

        assertThat(built.customAttributes()).isNotEmpty();
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupsListProjectsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "active",
                        "archived",
                        "visibility",
                        "search",
                        "orderBy",
                        "sort",
                        "simple",
                        "owned",
                        "starred",
                        "withIssuesEnabled",
                        "withMergeRequestsEnabled",
                        "withShared",
                        "includeSubgroups",
                        "includeAncestorGroups",
                        "minAccessLevel",
                        "withCustomAttributes",
                        "customAttributes",
                        "withSecurityReports");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupGroupsListProjectsFilter empty = GitLabGroupGroupsListProjectsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupGroupsListProjectsFilter filter = GitLabGroupGroupsListProjectsFilterBuilder.builder()
                .active(true)
                .archived(true)
                .visibility(GitLabGroupGroupsListProjectsVisibility.PRIVATE)
                .search("search")
                .orderBy(GitLabGroupGroupsListProjectsOrderBy.ID)
                .sort(GitLabGroupGroupsListProjectsSort.ASC)
                .simple(true)
                .owned(true)
                .starred(true)
                .withIssuesEnabled(true)
                .withMergeRequestsEnabled(true)
                .withShared(true)
                .includeSubgroups(true)
                .includeAncestorGroups(true)
                .minAccessLevel(GitLabGroupGroupsListProjectsMinAccessLevel.GUEST)
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .withSecurityReports(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("active", "true"),
                        Map.entry("archived", "true"),
                        Map.entry("visibility", "private"),
                        Map.entry("search", "search"),
                        Map.entry("order_by", "id"),
                        Map.entry("sort", "asc"),
                        Map.entry("simple", "true"),
                        Map.entry("owned", "true"),
                        Map.entry("starred", "true"),
                        Map.entry("with_issues_enabled", "true"),
                        Map.entry("with_merge_requests_enabled", "true"),
                        Map.entry("with_shared", "true"),
                        Map.entry("include_subgroups", "true"),
                        Map.entry("include_ancestor_groups", "true"),
                        Map.entry("min_access_level", "10"),
                        Map.entry("with_custom_attributes", "true"),
                        Map.entry("custom_attributes[key]", "value"),
                        Map.entry("with_security_reports", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupGroupsListProjectsFilter filter = GitLabGroupGroupsListProjectsFilterBuilder.builder()
                .active(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("active", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupGroupsListProjectsFilter filter = GitLabGroupGroupsListProjectsFilterBuilder.builder()
                .active(true)
                .archived(true)
                .visibility(GitLabGroupGroupsListProjectsVisibility.PRIVATE)
                .search("search")
                .orderBy(GitLabGroupGroupsListProjectsOrderBy.ID)
                .sort(GitLabGroupGroupsListProjectsSort.ASC)
                .simple(true)
                .owned(true)
                .starred(true)
                .withIssuesEnabled(true)
                .withMergeRequestsEnabled(true)
                .withShared(true)
                .includeSubgroups(true)
                .includeAncestorGroups(true)
                .minAccessLevel(GitLabGroupGroupsListProjectsMinAccessLevel.GUEST)
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .withSecurityReports(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

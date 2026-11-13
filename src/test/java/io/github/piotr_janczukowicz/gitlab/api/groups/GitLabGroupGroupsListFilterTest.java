package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupsListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenStatisticsIsNullable() {
        final GitLabGroupGroupsListFilterBuilder builder = GitLabGroupGroupsListFilterBuilder.builder(
                        GitLabGroupGroupsListFilterBuilder.builder()
                                .statistics(true)
                                .archived(true)
                                .skipGroups(List.of(1))
                                .allAvailable(true)
                                .visibility(GitLabGroupGroupsListVisibility.PRIVATE)
                                .search("search")
                                .owned(true)
                                .minAccessLevel(GitLabGroupGroupsListMinAccessLevel.GUEST)
                                .topLevelOnly(true)
                                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                .active(true)
                                .repositoryStorage("repository_storage")
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build())
                .statistics(null);

        final GitLabGroupGroupsListFilter built = builder.build();

        assertThat(built.statistics()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchivedIsNullable() {
        final GitLabGroupGroupsListFilterBuilder builder = GitLabGroupGroupsListFilterBuilder.builder(
                        GitLabGroupGroupsListFilterBuilder.builder()
                                .statistics(true)
                                .archived(true)
                                .skipGroups(List.of(1))
                                .allAvailable(true)
                                .visibility(GitLabGroupGroupsListVisibility.PRIVATE)
                                .search("search")
                                .owned(true)
                                .minAccessLevel(GitLabGroupGroupsListMinAccessLevel.GUEST)
                                .topLevelOnly(true)
                                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                .active(true)
                                .repositoryStorage("repository_storage")
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build())
                .archived(null);

        final GitLabGroupGroupsListFilter built = builder.build();

        assertThat(built.archived()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSkipGroupsIsNullable() {
        final GitLabGroupGroupsListFilterBuilder builder = GitLabGroupGroupsListFilterBuilder.builder(
                        GitLabGroupGroupsListFilterBuilder.builder()
                                .statistics(true)
                                .archived(true)
                                .skipGroups(List.of(1))
                                .allAvailable(true)
                                .visibility(GitLabGroupGroupsListVisibility.PRIVATE)
                                .search("search")
                                .owned(true)
                                .minAccessLevel(GitLabGroupGroupsListMinAccessLevel.GUEST)
                                .topLevelOnly(true)
                                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                .active(true)
                                .repositoryStorage("repository_storage")
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build())
                .skipGroups(null);

        final GitLabGroupGroupsListFilter built = builder.build();

        assertThat(built.skipGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllAvailableIsNullable() {
        final GitLabGroupGroupsListFilterBuilder builder = GitLabGroupGroupsListFilterBuilder.builder(
                        GitLabGroupGroupsListFilterBuilder.builder()
                                .statistics(true)
                                .archived(true)
                                .skipGroups(List.of(1))
                                .allAvailable(true)
                                .visibility(GitLabGroupGroupsListVisibility.PRIVATE)
                                .search("search")
                                .owned(true)
                                .minAccessLevel(GitLabGroupGroupsListMinAccessLevel.GUEST)
                                .topLevelOnly(true)
                                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                .active(true)
                                .repositoryStorage("repository_storage")
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build())
                .allAvailable(null);

        final GitLabGroupGroupsListFilter built = builder.build();

        assertThat(built.allAvailable()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVisibilityIsNullable() {
        final GitLabGroupGroupsListFilterBuilder builder = GitLabGroupGroupsListFilterBuilder.builder(
                        GitLabGroupGroupsListFilterBuilder.builder()
                                .statistics(true)
                                .archived(true)
                                .skipGroups(List.of(1))
                                .allAvailable(true)
                                .visibility(GitLabGroupGroupsListVisibility.PRIVATE)
                                .search("search")
                                .owned(true)
                                .minAccessLevel(GitLabGroupGroupsListMinAccessLevel.GUEST)
                                .topLevelOnly(true)
                                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                .active(true)
                                .repositoryStorage("repository_storage")
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build())
                .visibility(null);

        final GitLabGroupGroupsListFilter built = builder.build();

        assertThat(built.visibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabGroupGroupsListFilterBuilder builder = GitLabGroupGroupsListFilterBuilder.builder(
                        GitLabGroupGroupsListFilterBuilder.builder()
                                .statistics(true)
                                .archived(true)
                                .skipGroups(List.of(1))
                                .allAvailable(true)
                                .visibility(GitLabGroupGroupsListVisibility.PRIVATE)
                                .search("search")
                                .owned(true)
                                .minAccessLevel(GitLabGroupGroupsListMinAccessLevel.GUEST)
                                .topLevelOnly(true)
                                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                .active(true)
                                .repositoryStorage("repository_storage")
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build())
                .search(null);

        final GitLabGroupGroupsListFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOwnedIsNullable() {
        final GitLabGroupGroupsListFilterBuilder builder = GitLabGroupGroupsListFilterBuilder.builder(
                        GitLabGroupGroupsListFilterBuilder.builder()
                                .statistics(true)
                                .archived(true)
                                .skipGroups(List.of(1))
                                .allAvailable(true)
                                .visibility(GitLabGroupGroupsListVisibility.PRIVATE)
                                .search("search")
                                .owned(true)
                                .minAccessLevel(GitLabGroupGroupsListMinAccessLevel.GUEST)
                                .topLevelOnly(true)
                                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                .active(true)
                                .repositoryStorage("repository_storage")
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build())
                .owned(null);

        final GitLabGroupGroupsListFilter built = builder.build();

        assertThat(built.owned()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinAccessLevelIsNullable() {
        final GitLabGroupGroupsListFilterBuilder builder = GitLabGroupGroupsListFilterBuilder.builder(
                        GitLabGroupGroupsListFilterBuilder.builder()
                                .statistics(true)
                                .archived(true)
                                .skipGroups(List.of(1))
                                .allAvailable(true)
                                .visibility(GitLabGroupGroupsListVisibility.PRIVATE)
                                .search("search")
                                .owned(true)
                                .minAccessLevel(GitLabGroupGroupsListMinAccessLevel.GUEST)
                                .topLevelOnly(true)
                                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                .active(true)
                                .repositoryStorage("repository_storage")
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build())
                .minAccessLevel(null);

        final GitLabGroupGroupsListFilter built = builder.build();

        assertThat(built.minAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTopLevelOnlyIsNullable() {
        final GitLabGroupGroupsListFilterBuilder builder = GitLabGroupGroupsListFilterBuilder.builder(
                        GitLabGroupGroupsListFilterBuilder.builder()
                                .statistics(true)
                                .archived(true)
                                .skipGroups(List.of(1))
                                .allAvailable(true)
                                .visibility(GitLabGroupGroupsListVisibility.PRIVATE)
                                .search("search")
                                .owned(true)
                                .minAccessLevel(GitLabGroupGroupsListMinAccessLevel.GUEST)
                                .topLevelOnly(true)
                                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                .active(true)
                                .repositoryStorage("repository_storage")
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build())
                .topLevelOnly(null);

        final GitLabGroupGroupsListFilter built = builder.build();

        assertThat(built.topLevelOnly()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMarkedForDeletionOnIsNullable() {
        final GitLabGroupGroupsListFilterBuilder builder = GitLabGroupGroupsListFilterBuilder.builder(
                        GitLabGroupGroupsListFilterBuilder.builder()
                                .statistics(true)
                                .archived(true)
                                .skipGroups(List.of(1))
                                .allAvailable(true)
                                .visibility(GitLabGroupGroupsListVisibility.PRIVATE)
                                .search("search")
                                .owned(true)
                                .minAccessLevel(GitLabGroupGroupsListMinAccessLevel.GUEST)
                                .topLevelOnly(true)
                                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                .active(true)
                                .repositoryStorage("repository_storage")
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build())
                .markedForDeletionOn(null);

        final GitLabGroupGroupsListFilter built = builder.build();

        assertThat(built.markedForDeletionOn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabGroupGroupsListFilterBuilder builder = GitLabGroupGroupsListFilterBuilder.builder(
                        GitLabGroupGroupsListFilterBuilder.builder()
                                .statistics(true)
                                .archived(true)
                                .skipGroups(List.of(1))
                                .allAvailable(true)
                                .visibility(GitLabGroupGroupsListVisibility.PRIVATE)
                                .search("search")
                                .owned(true)
                                .minAccessLevel(GitLabGroupGroupsListMinAccessLevel.GUEST)
                                .topLevelOnly(true)
                                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                .active(true)
                                .repositoryStorage("repository_storage")
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build())
                .active(null);

        final GitLabGroupGroupsListFilter built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryStorageIsNullable() {
        final GitLabGroupGroupsListFilterBuilder builder = GitLabGroupGroupsListFilterBuilder.builder(
                        GitLabGroupGroupsListFilterBuilder.builder()
                                .statistics(true)
                                .archived(true)
                                .skipGroups(List.of(1))
                                .allAvailable(true)
                                .visibility(GitLabGroupGroupsListVisibility.PRIVATE)
                                .search("search")
                                .owned(true)
                                .minAccessLevel(GitLabGroupGroupsListMinAccessLevel.GUEST)
                                .topLevelOnly(true)
                                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                .active(true)
                                .repositoryStorage("repository_storage")
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build())
                .repositoryStorage(null);

        final GitLabGroupGroupsListFilter built = builder.build();

        assertThat(built.repositoryStorage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithCustomAttributesIsNullable() {
        final GitLabGroupGroupsListFilterBuilder builder = GitLabGroupGroupsListFilterBuilder.builder(
                        GitLabGroupGroupsListFilterBuilder.builder()
                                .statistics(true)
                                .archived(true)
                                .skipGroups(List.of(1))
                                .allAvailable(true)
                                .visibility(GitLabGroupGroupsListVisibility.PRIVATE)
                                .search("search")
                                .owned(true)
                                .minAccessLevel(GitLabGroupGroupsListMinAccessLevel.GUEST)
                                .topLevelOnly(true)
                                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                .active(true)
                                .repositoryStorage("repository_storage")
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build())
                .withCustomAttributes(null);

        final GitLabGroupGroupsListFilter built = builder.build();

        assertThat(built.withCustomAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabGroupGroupsListFilterBuilder builder = GitLabGroupGroupsListFilterBuilder.builder(
                        GitLabGroupGroupsListFilterBuilder.builder()
                                .statistics(true)
                                .archived(true)
                                .skipGroups(List.of(1))
                                .allAvailable(true)
                                .visibility(GitLabGroupGroupsListVisibility.PRIVATE)
                                .search("search")
                                .owned(true)
                                .minAccessLevel(GitLabGroupGroupsListMinAccessLevel.GUEST)
                                .topLevelOnly(true)
                                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                .active(true)
                                .repositoryStorage("repository_storage")
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build())
                .customAttributes(null);

        final GitLabGroupGroupsListFilter built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsListFilter value = GitLabGroupGroupsListFilterBuilder.builder()
                .statistics(true)
                .archived(true)
                .skipGroups(List.of(1))
                .allAvailable(true)
                .visibility(GitLabGroupGroupsListVisibility.PRIVATE)
                .search("search")
                .owned(true)
                .minAccessLevel(GitLabGroupGroupsListMinAccessLevel.GUEST)
                .topLevelOnly(true)
                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                .active(true)
                .repositoryStorage("repository_storage")
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.statistics()).isEqualTo(true);
            softly.assertThat(value.archived()).isEqualTo(true);
            softly.assertThat(value.skipGroups()).isEqualTo(List.of(1));
            softly.assertThat(value.allAvailable()).isEqualTo(true);
            softly.assertThat(value.visibility()).isEqualTo(GitLabGroupGroupsListVisibility.PRIVATE);
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.owned()).isEqualTo(true);
            softly.assertThat(value.minAccessLevel()).isEqualTo(GitLabGroupGroupsListMinAccessLevel.GUEST);
            softly.assertThat(value.topLevelOnly()).isEqualTo(true);
            softly.assertThat(value.markedForDeletionOn()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.active()).isEqualTo(true);
            softly.assertThat(value.repositoryStorage()).isEqualTo("repository_storage");
            softly.assertThat(value.withCustomAttributes()).isEqualTo(true);
            softly.assertThat(value.customAttributes()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupsListFilter original = GitLabGroupGroupsListFilterBuilder.builder()
                .statistics(true)
                .archived(true)
                .skipGroups(List.of(1))
                .allAvailable(true)
                .visibility(GitLabGroupGroupsListVisibility.PRIVATE)
                .search("search")
                .owned(true)
                .minAccessLevel(GitLabGroupGroupsListMinAccessLevel.GUEST)
                .topLevelOnly(true)
                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                .active(true)
                .repositoryStorage("repository_storage")
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .build();

        final GitLabGroupGroupsListFilter rebuilt =
                GitLabGroupGroupsListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenSkipGroupsSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabGroupGroupsListFilter built = GitLabGroupGroupsListFilterBuilder.builder(
                        GitLabGroupGroupsListFilterBuilder.builder()
                                .statistics(true)
                                .archived(true)
                                .skipGroups(List.of(1))
                                .allAvailable(true)
                                .visibility(GitLabGroupGroupsListVisibility.PRIVATE)
                                .search("search")
                                .owned(true)
                                .minAccessLevel(GitLabGroupGroupsListMinAccessLevel.GUEST)
                                .topLevelOnly(true)
                                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                .active(true)
                                .repositoryStorage("repository_storage")
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
        final GitLabGroupGroupsListFilter built = GitLabGroupGroupsListFilterBuilder.builder()
                .statistics(true)
                .archived(true)
                .skipGroups(List.of(1))
                .allAvailable(true)
                .visibility(GitLabGroupGroupsListVisibility.PRIVATE)
                .search("search")
                .owned(true)
                .minAccessLevel(GitLabGroupGroupsListMinAccessLevel.GUEST)
                .topLevelOnly(true)
                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                .active(true)
                .repositoryStorage("repository_storage")
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
        final GitLabGroupGroupsListFilter built = GitLabGroupGroupsListFilterBuilder.builder(
                        GitLabGroupGroupsListFilterBuilder.builder()
                                .statistics(true)
                                .archived(true)
                                .skipGroups(List.of(1))
                                .allAvailable(true)
                                .visibility(GitLabGroupGroupsListVisibility.PRIVATE)
                                .search("search")
                                .owned(true)
                                .minAccessLevel(GitLabGroupGroupsListMinAccessLevel.GUEST)
                                .topLevelOnly(true)
                                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                .active(true)
                                .repositoryStorage("repository_storage")
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
        final String[] names = Arrays.stream(GitLabGroupGroupsListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "statistics",
                        "archived",
                        "skipGroups",
                        "allAvailable",
                        "visibility",
                        "search",
                        "owned",
                        "minAccessLevel",
                        "topLevelOnly",
                        "markedForDeletionOn",
                        "active",
                        "repositoryStorage",
                        "withCustomAttributes",
                        "customAttributes");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupGroupsListFilter empty = GitLabGroupGroupsListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupGroupsListFilter filter = GitLabGroupGroupsListFilterBuilder.builder()
                .statistics(true)
                .archived(true)
                .skipGroups(List.of(1))
                .allAvailable(true)
                .visibility(GitLabGroupGroupsListVisibility.PRIVATE)
                .search("search")
                .owned(true)
                .minAccessLevel(GitLabGroupGroupsListMinAccessLevel.GUEST)
                .topLevelOnly(true)
                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                .active(true)
                .repositoryStorage("repository_storage")
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("statistics", "true"),
                        Map.entry("archived", "true"),
                        Map.entry("skip_groups", "1"),
                        Map.entry("all_available", "true"),
                        Map.entry("visibility", "private"),
                        Map.entry("search", "search"),
                        Map.entry("owned", "true"),
                        Map.entry("min_access_level", "10"),
                        Map.entry("top_level_only", "true"),
                        Map.entry("marked_for_deletion_on", "2026-01-01"),
                        Map.entry("active", "true"),
                        Map.entry("repository_storage", "repository_storage"),
                        Map.entry("with_custom_attributes", "true"),
                        Map.entry("custom_attributes[key]", "value"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupGroupsListFilter filter =
                GitLabGroupGroupsListFilterBuilder.builder().statistics(true).build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("statistics", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupGroupsListFilter filter = GitLabGroupGroupsListFilterBuilder.builder()
                .statistics(true)
                .archived(true)
                .skipGroups(List.of(1))
                .allAvailable(true)
                .visibility(GitLabGroupGroupsListVisibility.PRIVATE)
                .search("search")
                .owned(true)
                .minAccessLevel(GitLabGroupGroupsListMinAccessLevel.GUEST)
                .topLevelOnly(true)
                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                .active(true)
                .repositoryStorage("repository_storage")
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

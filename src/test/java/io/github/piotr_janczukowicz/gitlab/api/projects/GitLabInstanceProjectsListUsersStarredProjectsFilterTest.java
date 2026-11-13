package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceProjectsListUsersStarredProjectsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .orderBy(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .sort(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchivedIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .archived(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.archived()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVisibilityIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .visibility(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.visibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .search(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchNamespacesIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .searchNamespaces(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.searchNamespaces()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOwnedIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .owned(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.owned()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStarredIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .starred(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.starred()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportedIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .imported(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.imported()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMembershipIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .membership(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.membership()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithIssuesEnabledIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .withIssuesEnabled(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.withIssuesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithMergeRequestsEnabledIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .withMergeRequestsEnabled(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.withMergeRequestsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithProgrammingLanguageIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .withProgrammingLanguage(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.withProgrammingLanguage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinAccessLevelIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .minAccessLevel(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.minAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIdAfterIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .idAfter(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.idAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIdBeforeIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .idBefore(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.idBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastActivityAfterIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .lastActivityAfter(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.lastActivityAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastActivityBeforeIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .lastActivityBefore(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.lastActivityBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryStorageIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .repositoryStorage(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.repositoryStorage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTopicIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .topic(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.topic()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTopicIdIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .topicId(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.topicId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedBeforeIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .updatedBefore(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.updatedBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAfterIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .updatedAfter(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.updatedAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludePendingDeleteIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .includePendingDelete(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.includePendingDelete()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMarkedForDeletionOnIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .markedForDeletionOn(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.markedForDeletionOn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .active(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiChecksumFailedIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .wikiChecksumFailed(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.wikiChecksumFailed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryChecksumFailedIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .repositoryChecksumFailed(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.repositoryChecksumFailed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeHiddenIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .includeHidden(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.includeHidden()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSimpleIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .simple(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.simple()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatisticsIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .statistics(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.statistics()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithCustomAttributesIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .withCustomAttributes(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.withCustomAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .customAttributes(null);

        final GitLabInstanceProjectsListUsersStarredProjectsFilter built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilter value =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                        .archived(true)
                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                        .search("search")
                        .searchNamespaces(true)
                        .owned(true)
                        .starred(true)
                        .imported(true)
                        .membership(true)
                        .withIssuesEnabled(true)
                        .withMergeRequestsEnabled(true)
                        .withProgrammingLanguage("with_programming_language")
                        .minAccessLevel(GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                        .idAfter(1)
                        .idBefore(1)
                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .repositoryStorage("repository_storage")
                        .topic(List.of("topic"))
                        .topicId(1L)
                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .includePendingDelete(true)
                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                        .active(true)
                        .wikiChecksumFailed(true)
                        .repositoryChecksumFailed(true)
                        .includeHidden(true)
                        .simple(true)
                        .statistics(true)
                        .withCustomAttributes(true)
                        .customAttributes(Map.of("key", "value"))
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.orderBy()).isEqualTo(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID);
            softly.assertThat(value.sort()).isEqualTo(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC);
            softly.assertThat(value.archived()).isEqualTo(true);
            softly.assertThat(value.visibility())
                    .isEqualTo(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE);
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.searchNamespaces()).isEqualTo(true);
            softly.assertThat(value.owned()).isEqualTo(true);
            softly.assertThat(value.starred()).isEqualTo(true);
            softly.assertThat(value.imported()).isEqualTo(true);
            softly.assertThat(value.membership()).isEqualTo(true);
            softly.assertThat(value.withIssuesEnabled()).isEqualTo(true);
            softly.assertThat(value.withMergeRequestsEnabled()).isEqualTo(true);
            softly.assertThat(value.withProgrammingLanguage()).isEqualTo("with_programming_language");
            softly.assertThat(value.minAccessLevel())
                    .isEqualTo(GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST);
            softly.assertThat(value.idAfter()).isEqualTo(1);
            softly.assertThat(value.idBefore()).isEqualTo(1);
            softly.assertThat(value.lastActivityAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.lastActivityBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.repositoryStorage()).isEqualTo("repository_storage");
            softly.assertThat(value.topic()).isEqualTo(List.of("topic"));
            softly.assertThat(value.topicId()).isEqualTo(1L);
            softly.assertThat(value.updatedBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.includePendingDelete()).isEqualTo(true);
            softly.assertThat(value.markedForDeletionOn()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.active()).isEqualTo(true);
            softly.assertThat(value.wikiChecksumFailed()).isEqualTo(true);
            softly.assertThat(value.repositoryChecksumFailed()).isEqualTo(true);
            softly.assertThat(value.includeHidden()).isEqualTo(true);
            softly.assertThat(value.simple()).isEqualTo(true);
            softly.assertThat(value.statistics()).isEqualTo(true);
            softly.assertThat(value.withCustomAttributes()).isEqualTo(true);
            softly.assertThat(value.customAttributes()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilter original =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                        .archived(true)
                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                        .search("search")
                        .searchNamespaces(true)
                        .owned(true)
                        .starred(true)
                        .imported(true)
                        .membership(true)
                        .withIssuesEnabled(true)
                        .withMergeRequestsEnabled(true)
                        .withProgrammingLanguage("with_programming_language")
                        .minAccessLevel(GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                        .idAfter(1)
                        .idBefore(1)
                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .repositoryStorage("repository_storage")
                        .topic(List.of("topic"))
                        .topicId(1L)
                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .includePendingDelete(true)
                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                        .active(true)
                        .wikiChecksumFailed(true)
                        .repositoryChecksumFailed(true)
                        .includeHidden(true)
                        .simple(true)
                        .statistics(true)
                        .withCustomAttributes(true)
                        .customAttributes(Map.of("key", "value"))
                        .build();

        final GitLabInstanceProjectsListUsersStarredProjectsFilter rebuilt =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenTopicSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("topic"));
        final GitLabInstanceProjectsListUsersStarredProjectsFilter built =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .topic(source)
                        .build();
        source.clear();

        assertThat(built.topic()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenTopicIsRead() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilter built =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                        .archived(true)
                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                        .search("search")
                        .searchNamespaces(true)
                        .owned(true)
                        .starred(true)
                        .imported(true)
                        .membership(true)
                        .withIssuesEnabled(true)
                        .withMergeRequestsEnabled(true)
                        .withProgrammingLanguage("with_programming_language")
                        .minAccessLevel(GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                        .idAfter(1)
                        .idBefore(1)
                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .repositoryStorage("repository_storage")
                        .topic(List.of("topic"))
                        .topicId(1L)
                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .includePendingDelete(true)
                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                        .active(true)
                        .wikiChecksumFailed(true)
                        .repositoryChecksumFailed(true)
                        .includeHidden(true)
                        .simple(true)
                        .statistics(true)
                        .withCustomAttributes(true)
                        .customAttributes(Map.of("key", "value"))
                        .build();
        final List<String> values = built.topic();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheMap_whenCustomAttributesSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabInstanceProjectsListUsersStarredProjectsFilter built =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                        .archived(true)
                                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                        .search("search")
                                        .searchNamespaces(true)
                                        .owned(true)
                                        .starred(true)
                                        .imported(true)
                                        .membership(true)
                                        .withIssuesEnabled(true)
                                        .withMergeRequestsEnabled(true)
                                        .withProgrammingLanguage("with_programming_language")
                                        .minAccessLevel(
                                                GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                                        .idAfter(1)
                                        .idBefore(1)
                                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .repositoryStorage("repository_storage")
                                        .topic(List.of("topic"))
                                        .topicId(1L)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .includePendingDelete(true)
                                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                        .active(true)
                                        .wikiChecksumFailed(true)
                                        .repositoryChecksumFailed(true)
                                        .includeHidden(true)
                                        .simple(true)
                                        .statistics(true)
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
        final String[] names = Arrays.stream(
                        GitLabInstanceProjectsListUsersStarredProjectsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "orderBy",
                        "sort",
                        "archived",
                        "visibility",
                        "search",
                        "searchNamespaces",
                        "owned",
                        "starred",
                        "imported",
                        "membership",
                        "withIssuesEnabled",
                        "withMergeRequestsEnabled",
                        "withProgrammingLanguage",
                        "minAccessLevel",
                        "idAfter",
                        "idBefore",
                        "lastActivityAfter",
                        "lastActivityBefore",
                        "repositoryStorage",
                        "topic",
                        "topicId",
                        "updatedBefore",
                        "updatedAfter",
                        "includePendingDelete",
                        "markedForDeletionOn",
                        "active",
                        "wikiChecksumFailed",
                        "repositoryChecksumFailed",
                        "includeHidden",
                        "simple",
                        "statistics",
                        "withCustomAttributes",
                        "customAttributes");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilter empty =
                GitLabInstanceProjectsListUsersStarredProjectsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilter filter =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                        .archived(true)
                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                        .search("search")
                        .searchNamespaces(true)
                        .owned(true)
                        .starred(true)
                        .imported(true)
                        .membership(true)
                        .withIssuesEnabled(true)
                        .withMergeRequestsEnabled(true)
                        .withProgrammingLanguage("with_programming_language")
                        .minAccessLevel(GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                        .idAfter(1)
                        .idBefore(1)
                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .repositoryStorage("repository_storage")
                        .topic(List.of("topic"))
                        .topicId(1L)
                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .includePendingDelete(true)
                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                        .active(true)
                        .wikiChecksumFailed(true)
                        .repositoryChecksumFailed(true)
                        .includeHidden(true)
                        .simple(true)
                        .statistics(true)
                        .withCustomAttributes(true)
                        .customAttributes(Map.of("key", "value"))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("order_by", "id"),
                        Map.entry("sort", "asc"),
                        Map.entry("archived", "true"),
                        Map.entry("visibility", "private"),
                        Map.entry("search", "search"),
                        Map.entry("search_namespaces", "true"),
                        Map.entry("owned", "true"),
                        Map.entry("starred", "true"),
                        Map.entry("imported", "true"),
                        Map.entry("membership", "true"),
                        Map.entry("with_issues_enabled", "true"),
                        Map.entry("with_merge_requests_enabled", "true"),
                        Map.entry("with_programming_language", "with_programming_language"),
                        Map.entry("min_access_level", "10"),
                        Map.entry("id_after", "1"),
                        Map.entry("id_before", "1"),
                        Map.entry("last_activity_after", "2026-01-01T00:00:00Z"),
                        Map.entry("last_activity_before", "2026-01-01T00:00:00Z"),
                        Map.entry("repository_storage", "repository_storage"),
                        Map.entry("topic", "topic"),
                        Map.entry("topic_id", "1"),
                        Map.entry("updated_before", "2026-01-01T00:00:00Z"),
                        Map.entry("updated_after", "2026-01-01T00:00:00Z"),
                        Map.entry("include_pending_delete", "true"),
                        Map.entry("marked_for_deletion_on", "2026-01-01"),
                        Map.entry("active", "true"),
                        Map.entry("wiki_checksum_failed", "true"),
                        Map.entry("repository_checksum_failed", "true"),
                        Map.entry("include_hidden", "true"),
                        Map.entry("simple", "true"),
                        Map.entry("statistics", "true"),
                        Map.entry("with_custom_attributes", "true"),
                        Map.entry("custom_attributes[key]", "value"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilter filter =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("order_by", "id"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabInstanceProjectsListUsersStarredProjectsFilter filter =
                GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                        .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                        .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                        .archived(true)
                        .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                        .search("search")
                        .searchNamespaces(true)
                        .owned(true)
                        .starred(true)
                        .imported(true)
                        .membership(true)
                        .withIssuesEnabled(true)
                        .withMergeRequestsEnabled(true)
                        .withProgrammingLanguage("with_programming_language")
                        .minAccessLevel(GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
                        .idAfter(1)
                        .idBefore(1)
                        .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .repositoryStorage("repository_storage")
                        .topic(List.of("topic"))
                        .topicId(1L)
                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .includePendingDelete(true)
                        .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                        .active(true)
                        .wikiChecksumFailed(true)
                        .repositoryChecksumFailed(true)
                        .includeHidden(true)
                        .simple(true)
                        .statistics(true)
                        .withCustomAttributes(true)
                        .customAttributes(Map.of("key", "value"))
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

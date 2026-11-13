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
class GitLabInstanceProjectsListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchivedIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.archived()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVisibilityIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.visibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchNamespacesIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.searchNamespaces()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOwnedIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.owned()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStarredIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.starred()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportedIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.imported()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMembershipIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.membership()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithIssuesEnabledIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.withIssuesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithMergeRequestsEnabledIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.withMergeRequestsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithProgrammingLanguageIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.withProgrammingLanguage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinAccessLevelIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.minAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIdAfterIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.idAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIdBeforeIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.idBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastActivityAfterIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.lastActivityAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastActivityBeforeIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.lastActivityBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryStorageIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.repositoryStorage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTopicIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.topic()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTopicIdIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.topicId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedBeforeIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.updatedBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAfterIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.updatedAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludePendingDeleteIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.includePendingDelete()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMarkedForDeletionOnIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.markedForDeletionOn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiChecksumFailedIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.wikiChecksumFailed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryChecksumFailedIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.repositoryChecksumFailed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeHiddenIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.includeHidden()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSimpleIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.simple()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatisticsIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.statistics()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithCustomAttributesIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.withCustomAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabInstanceProjectsListFilterBuilder builder = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceProjectsListFilter value = GitLabInstanceProjectsListFilterBuilder.builder()
                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                .sort(GitLabInstanceProjectsListSort.ASC)
                .archived(true)
                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                .search("search")
                .searchNamespaces(true)
                .owned(true)
                .starred(true)
                .imported(true)
                .membership(true)
                .withIssuesEnabled(true)
                .withMergeRequestsEnabled(true)
                .withProgrammingLanguage("with_programming_language")
                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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
            softly.assertThat(value.orderBy()).isEqualTo(GitLabInstanceProjectsListOrderBy.ID);
            softly.assertThat(value.sort()).isEqualTo(GitLabInstanceProjectsListSort.ASC);
            softly.assertThat(value.archived()).isEqualTo(true);
            softly.assertThat(value.visibility()).isEqualTo(GitLabInstanceProjectsListVisibility.PRIVATE);
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.searchNamespaces()).isEqualTo(true);
            softly.assertThat(value.owned()).isEqualTo(true);
            softly.assertThat(value.starred()).isEqualTo(true);
            softly.assertThat(value.imported()).isEqualTo(true);
            softly.assertThat(value.membership()).isEqualTo(true);
            softly.assertThat(value.withIssuesEnabled()).isEqualTo(true);
            softly.assertThat(value.withMergeRequestsEnabled()).isEqualTo(true);
            softly.assertThat(value.withProgrammingLanguage()).isEqualTo("with_programming_language");
            softly.assertThat(value.minAccessLevel()).isEqualTo(GitLabInstanceProjectsListMinAccessLevel.GUEST);
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
        final GitLabInstanceProjectsListFilter original = GitLabInstanceProjectsListFilterBuilder.builder()
                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                .sort(GitLabInstanceProjectsListSort.ASC)
                .archived(true)
                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                .search("search")
                .searchNamespaces(true)
                .owned(true)
                .starred(true)
                .imported(true)
                .membership(true)
                .withIssuesEnabled(true)
                .withMergeRequestsEnabled(true)
                .withProgrammingLanguage("with_programming_language")
                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

        final GitLabInstanceProjectsListFilter rebuilt =
                GitLabInstanceProjectsListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenTopicSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("topic"));
        final GitLabInstanceProjectsListFilter built = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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
        final GitLabInstanceProjectsListFilter built = GitLabInstanceProjectsListFilterBuilder.builder()
                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                .sort(GitLabInstanceProjectsListSort.ASC)
                .archived(true)
                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                .search("search")
                .searchNamespaces(true)
                .owned(true)
                .starred(true)
                .imported(true)
                .membership(true)
                .withIssuesEnabled(true)
                .withMergeRequestsEnabled(true)
                .withProgrammingLanguage("with_programming_language")
                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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
        final GitLabInstanceProjectsListFilter built = GitLabInstanceProjectsListFilterBuilder.builder(
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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
        final String[] names = Arrays.stream(GitLabInstanceProjectsListFilter.class.getRecordComponents())
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
        final GitLabInstanceProjectsListFilter empty = GitLabInstanceProjectsListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabInstanceProjectsListFilter filter = GitLabInstanceProjectsListFilterBuilder.builder()
                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                .sort(GitLabInstanceProjectsListSort.ASC)
                .archived(true)
                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                .search("search")
                .searchNamespaces(true)
                .owned(true)
                .starred(true)
                .imported(true)
                .membership(true)
                .withIssuesEnabled(true)
                .withMergeRequestsEnabled(true)
                .withProgrammingLanguage("with_programming_language")
                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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
        final GitLabInstanceProjectsListFilter filter = GitLabInstanceProjectsListFilterBuilder.builder()
                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("order_by", "id"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabInstanceProjectsListFilter filter = GitLabInstanceProjectsListFilterBuilder.builder()
                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                .sort(GitLabInstanceProjectsListSort.ASC)
                .archived(true)
                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                .search("search")
                .searchNamespaces(true)
                .owned(true)
                .starred(true)
                .imported(true)
                .membership(true)
                .withIssuesEnabled(true)
                .withMergeRequestsEnabled(true)
                .withProgrammingLanguage("with_programming_language")
                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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

package io.github.piotr_janczukowicz.gitlab.api.epics;

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
class GitLabGroupEpicsListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabGroupEpicsListFilterBuilder builder = GitLabGroupEpicsListFilterBuilder.builder(
                        GitLabGroupEpicsListFilterBuilder.builder()
                                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                                .sort(GitLabGroupEpicsListSort.ASC)
                                .search("search")
                                .state(GitLabGroupEpicsListState.OPENED)
                                .authorId(1L)
                                .authorUsername("author_username")
                                .labels(List.of("labels"))
                                .withLabelsDetails(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .notLabels(List.of("not[labels]"))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .build())
                .orderBy(null);

        final GitLabGroupEpicsListFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabGroupEpicsListFilterBuilder builder = GitLabGroupEpicsListFilterBuilder.builder(
                        GitLabGroupEpicsListFilterBuilder.builder()
                                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                                .sort(GitLabGroupEpicsListSort.ASC)
                                .search("search")
                                .state(GitLabGroupEpicsListState.OPENED)
                                .authorId(1L)
                                .authorUsername("author_username")
                                .labels(List.of("labels"))
                                .withLabelsDetails(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .notLabels(List.of("not[labels]"))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .build())
                .sort(null);

        final GitLabGroupEpicsListFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabGroupEpicsListFilterBuilder builder = GitLabGroupEpicsListFilterBuilder.builder(
                        GitLabGroupEpicsListFilterBuilder.builder()
                                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                                .sort(GitLabGroupEpicsListSort.ASC)
                                .search("search")
                                .state(GitLabGroupEpicsListState.OPENED)
                                .authorId(1L)
                                .authorUsername("author_username")
                                .labels(List.of("labels"))
                                .withLabelsDetails(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .notLabels(List.of("not[labels]"))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .build())
                .search(null);

        final GitLabGroupEpicsListFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabGroupEpicsListFilterBuilder builder = GitLabGroupEpicsListFilterBuilder.builder(
                        GitLabGroupEpicsListFilterBuilder.builder()
                                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                                .sort(GitLabGroupEpicsListSort.ASC)
                                .search("search")
                                .state(GitLabGroupEpicsListState.OPENED)
                                .authorId(1L)
                                .authorUsername("author_username")
                                .labels(List.of("labels"))
                                .withLabelsDetails(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .notLabels(List.of("not[labels]"))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .build())
                .state(null);

        final GitLabGroupEpicsListFilter built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIdIsNullable() {
        final GitLabGroupEpicsListFilterBuilder builder = GitLabGroupEpicsListFilterBuilder.builder(
                        GitLabGroupEpicsListFilterBuilder.builder()
                                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                                .sort(GitLabGroupEpicsListSort.ASC)
                                .search("search")
                                .state(GitLabGroupEpicsListState.OPENED)
                                .authorId(1L)
                                .authorUsername("author_username")
                                .labels(List.of("labels"))
                                .withLabelsDetails(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .notLabels(List.of("not[labels]"))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .build())
                .authorId(null);

        final GitLabGroupEpicsListFilter built = builder.build();

        assertThat(built.authorId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorUsernameIsNullable() {
        final GitLabGroupEpicsListFilterBuilder builder = GitLabGroupEpicsListFilterBuilder.builder(
                        GitLabGroupEpicsListFilterBuilder.builder()
                                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                                .sort(GitLabGroupEpicsListSort.ASC)
                                .search("search")
                                .state(GitLabGroupEpicsListState.OPENED)
                                .authorId(1L)
                                .authorUsername("author_username")
                                .labels(List.of("labels"))
                                .withLabelsDetails(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .notLabels(List.of("not[labels]"))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .build())
                .authorUsername(null);

        final GitLabGroupEpicsListFilter built = builder.build();

        assertThat(built.authorUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabGroupEpicsListFilterBuilder builder = GitLabGroupEpicsListFilterBuilder.builder(
                        GitLabGroupEpicsListFilterBuilder.builder()
                                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                                .sort(GitLabGroupEpicsListSort.ASC)
                                .search("search")
                                .state(GitLabGroupEpicsListState.OPENED)
                                .authorId(1L)
                                .authorUsername("author_username")
                                .labels(List.of("labels"))
                                .withLabelsDetails(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .notLabels(List.of("not[labels]"))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .build())
                .labels(null);

        final GitLabGroupEpicsListFilter built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithLabelsDetailsIsNullable() {
        final GitLabGroupEpicsListFilterBuilder builder = GitLabGroupEpicsListFilterBuilder.builder(
                        GitLabGroupEpicsListFilterBuilder.builder()
                                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                                .sort(GitLabGroupEpicsListSort.ASC)
                                .search("search")
                                .state(GitLabGroupEpicsListState.OPENED)
                                .authorId(1L)
                                .authorUsername("author_username")
                                .labels(List.of("labels"))
                                .withLabelsDetails(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .notLabels(List.of("not[labels]"))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .build())
                .withLabelsDetails(null);

        final GitLabGroupEpicsListFilter built = builder.build();

        assertThat(built.withLabelsDetails()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAfterIsNullable() {
        final GitLabGroupEpicsListFilterBuilder builder = GitLabGroupEpicsListFilterBuilder.builder(
                        GitLabGroupEpicsListFilterBuilder.builder()
                                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                                .sort(GitLabGroupEpicsListSort.ASC)
                                .search("search")
                                .state(GitLabGroupEpicsListState.OPENED)
                                .authorId(1L)
                                .authorUsername("author_username")
                                .labels(List.of("labels"))
                                .withLabelsDetails(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .notLabels(List.of("not[labels]"))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .build())
                .createdAfter(null);

        final GitLabGroupEpicsListFilter built = builder.build();

        assertThat(built.createdAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedBeforeIsNullable() {
        final GitLabGroupEpicsListFilterBuilder builder = GitLabGroupEpicsListFilterBuilder.builder(
                        GitLabGroupEpicsListFilterBuilder.builder()
                                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                                .sort(GitLabGroupEpicsListSort.ASC)
                                .search("search")
                                .state(GitLabGroupEpicsListState.OPENED)
                                .authorId(1L)
                                .authorUsername("author_username")
                                .labels(List.of("labels"))
                                .withLabelsDetails(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .notLabels(List.of("not[labels]"))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .build())
                .createdBefore(null);

        final GitLabGroupEpicsListFilter built = builder.build();

        assertThat(built.createdBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAfterIsNullable() {
        final GitLabGroupEpicsListFilterBuilder builder = GitLabGroupEpicsListFilterBuilder.builder(
                        GitLabGroupEpicsListFilterBuilder.builder()
                                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                                .sort(GitLabGroupEpicsListSort.ASC)
                                .search("search")
                                .state(GitLabGroupEpicsListState.OPENED)
                                .authorId(1L)
                                .authorUsername("author_username")
                                .labels(List.of("labels"))
                                .withLabelsDetails(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .notLabels(List.of("not[labels]"))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .build())
                .updatedAfter(null);

        final GitLabGroupEpicsListFilter built = builder.build();

        assertThat(built.updatedAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedBeforeIsNullable() {
        final GitLabGroupEpicsListFilterBuilder builder = GitLabGroupEpicsListFilterBuilder.builder(
                        GitLabGroupEpicsListFilterBuilder.builder()
                                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                                .sort(GitLabGroupEpicsListSort.ASC)
                                .search("search")
                                .state(GitLabGroupEpicsListState.OPENED)
                                .authorId(1L)
                                .authorUsername("author_username")
                                .labels(List.of("labels"))
                                .withLabelsDetails(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .notLabels(List.of("not[labels]"))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .build())
                .updatedBefore(null);

        final GitLabGroupEpicsListFilter built = builder.build();

        assertThat(built.updatedBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeAncestorGroupsIsNullable() {
        final GitLabGroupEpicsListFilterBuilder builder = GitLabGroupEpicsListFilterBuilder.builder(
                        GitLabGroupEpicsListFilterBuilder.builder()
                                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                                .sort(GitLabGroupEpicsListSort.ASC)
                                .search("search")
                                .state(GitLabGroupEpicsListState.OPENED)
                                .authorId(1L)
                                .authorUsername("author_username")
                                .labels(List.of("labels"))
                                .withLabelsDetails(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .notLabels(List.of("not[labels]"))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .build())
                .includeAncestorGroups(null);

        final GitLabGroupEpicsListFilter built = builder.build();

        assertThat(built.includeAncestorGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeDescendantGroupsIsNullable() {
        final GitLabGroupEpicsListFilterBuilder builder = GitLabGroupEpicsListFilterBuilder.builder(
                        GitLabGroupEpicsListFilterBuilder.builder()
                                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                                .sort(GitLabGroupEpicsListSort.ASC)
                                .search("search")
                                .state(GitLabGroupEpicsListState.OPENED)
                                .authorId(1L)
                                .authorUsername("author_username")
                                .labels(List.of("labels"))
                                .withLabelsDetails(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .notLabels(List.of("not[labels]"))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .build())
                .includeDescendantGroups(null);

        final GitLabGroupEpicsListFilter built = builder.build();

        assertThat(built.includeDescendantGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMyReactionEmojiIsNullable() {
        final GitLabGroupEpicsListFilterBuilder builder = GitLabGroupEpicsListFilterBuilder.builder(
                        GitLabGroupEpicsListFilterBuilder.builder()
                                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                                .sort(GitLabGroupEpicsListSort.ASC)
                                .search("search")
                                .state(GitLabGroupEpicsListState.OPENED)
                                .authorId(1L)
                                .authorUsername("author_username")
                                .labels(List.of("labels"))
                                .withLabelsDetails(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .notLabels(List.of("not[labels]"))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .build())
                .myReactionEmoji(null);

        final GitLabGroupEpicsListFilter built = builder.build();

        assertThat(built.myReactionEmoji()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabGroupEpicsListFilterBuilder builder = GitLabGroupEpicsListFilterBuilder.builder(
                        GitLabGroupEpicsListFilterBuilder.builder()
                                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                                .sort(GitLabGroupEpicsListSort.ASC)
                                .search("search")
                                .state(GitLabGroupEpicsListState.OPENED)
                                .authorId(1L)
                                .authorUsername("author_username")
                                .labels(List.of("labels"))
                                .withLabelsDetails(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .notLabels(List.of("not[labels]"))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .build())
                .confidential(null);

        final GitLabGroupEpicsListFilter built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotLabelsIsNullable() {
        final GitLabGroupEpicsListFilterBuilder builder = GitLabGroupEpicsListFilterBuilder.builder(
                        GitLabGroupEpicsListFilterBuilder.builder()
                                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                                .sort(GitLabGroupEpicsListSort.ASC)
                                .search("search")
                                .state(GitLabGroupEpicsListState.OPENED)
                                .authorId(1L)
                                .authorUsername("author_username")
                                .labels(List.of("labels"))
                                .withLabelsDetails(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .notLabels(List.of("not[labels]"))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .build())
                .notLabels(null);

        final GitLabGroupEpicsListFilter built = builder.build();

        assertThat(built.notLabels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAuthorIdIsNullable() {
        final GitLabGroupEpicsListFilterBuilder builder = GitLabGroupEpicsListFilterBuilder.builder(
                        GitLabGroupEpicsListFilterBuilder.builder()
                                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                                .sort(GitLabGroupEpicsListSort.ASC)
                                .search("search")
                                .state(GitLabGroupEpicsListState.OPENED)
                                .authorId(1L)
                                .authorUsername("author_username")
                                .labels(List.of("labels"))
                                .withLabelsDetails(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .notLabels(List.of("not[labels]"))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .build())
                .notAuthorId(null);

        final GitLabGroupEpicsListFilter built = builder.build();

        assertThat(built.notAuthorId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAuthorUsernameIsNullable() {
        final GitLabGroupEpicsListFilterBuilder builder = GitLabGroupEpicsListFilterBuilder.builder(
                        GitLabGroupEpicsListFilterBuilder.builder()
                                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                                .sort(GitLabGroupEpicsListSort.ASC)
                                .search("search")
                                .state(GitLabGroupEpicsListState.OPENED)
                                .authorId(1L)
                                .authorUsername("author_username")
                                .labels(List.of("labels"))
                                .withLabelsDetails(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .notLabels(List.of("not[labels]"))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .build())
                .notAuthorUsername(null);

        final GitLabGroupEpicsListFilter built = builder.build();

        assertThat(built.notAuthorUsername()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupEpicsListFilter value = GitLabGroupEpicsListFilterBuilder.builder()
                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                .sort(GitLabGroupEpicsListSort.ASC)
                .search("search")
                .state(GitLabGroupEpicsListState.OPENED)
                .authorId(1L)
                .authorUsername("author_username")
                .labels(List.of("labels"))
                .withLabelsDetails(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .includeAncestorGroups(true)
                .includeDescendantGroups(true)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .notLabels(List.of("not[labels]"))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.orderBy()).isEqualTo(GitLabGroupEpicsListOrderBy.CREATED_AT);
            softly.assertThat(value.sort()).isEqualTo(GitLabGroupEpicsListSort.ASC);
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.state()).isEqualTo(GitLabGroupEpicsListState.OPENED);
            softly.assertThat(value.authorId()).isEqualTo(1L);
            softly.assertThat(value.authorUsername()).isEqualTo("author_username");
            softly.assertThat(value.labels()).isEqualTo(List.of("labels"));
            softly.assertThat(value.withLabelsDetails()).isEqualTo(true);
            softly.assertThat(value.createdAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.includeAncestorGroups()).isEqualTo(true);
            softly.assertThat(value.includeDescendantGroups()).isEqualTo(true);
            softly.assertThat(value.myReactionEmoji()).isEqualTo("my_reaction_emoji");
            softly.assertThat(value.confidential()).isEqualTo(true);
            softly.assertThat(value.notLabels()).isEqualTo(List.of("not[labels]"));
            softly.assertThat(value.notAuthorId()).isEqualTo(1);
            softly.assertThat(value.notAuthorUsername()).isEqualTo("not[author_username]");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupEpicsListFilter original = GitLabGroupEpicsListFilterBuilder.builder()
                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                .sort(GitLabGroupEpicsListSort.ASC)
                .search("search")
                .state(GitLabGroupEpicsListState.OPENED)
                .authorId(1L)
                .authorUsername("author_username")
                .labels(List.of("labels"))
                .withLabelsDetails(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .includeAncestorGroups(true)
                .includeDescendantGroups(true)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .notLabels(List.of("not[labels]"))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .build();

        final GitLabGroupEpicsListFilter rebuilt =
                GitLabGroupEpicsListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("labels"));
        final GitLabGroupEpicsListFilter built = GitLabGroupEpicsListFilterBuilder.builder(
                        GitLabGroupEpicsListFilterBuilder.builder()
                                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                                .sort(GitLabGroupEpicsListSort.ASC)
                                .search("search")
                                .state(GitLabGroupEpicsListState.OPENED)
                                .authorId(1L)
                                .authorUsername("author_username")
                                .labels(List.of("labels"))
                                .withLabelsDetails(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .notLabels(List.of("not[labels]"))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .build())
                .labels(source)
                .build();
        source.clear();

        assertThat(built.labels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenLabelsIsRead() {
        final GitLabGroupEpicsListFilter built = GitLabGroupEpicsListFilterBuilder.builder()
                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                .sort(GitLabGroupEpicsListSort.ASC)
                .search("search")
                .state(GitLabGroupEpicsListState.OPENED)
                .authorId(1L)
                .authorUsername("author_username")
                .labels(List.of("labels"))
                .withLabelsDetails(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .includeAncestorGroups(true)
                .includeDescendantGroups(true)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .notLabels(List.of("not[labels]"))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .build();
        final List<String> values = built.labels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenNotLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("not[labels]"));
        final GitLabGroupEpicsListFilter built = GitLabGroupEpicsListFilterBuilder.builder(
                        GitLabGroupEpicsListFilterBuilder.builder()
                                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                                .sort(GitLabGroupEpicsListSort.ASC)
                                .search("search")
                                .state(GitLabGroupEpicsListState.OPENED)
                                .authorId(1L)
                                .authorUsername("author_username")
                                .labels(List.of("labels"))
                                .withLabelsDetails(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .notLabels(List.of("not[labels]"))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .build())
                .notLabels(source)
                .build();
        source.clear();

        assertThat(built.notLabels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenNotLabelsIsRead() {
        final GitLabGroupEpicsListFilter built = GitLabGroupEpicsListFilterBuilder.builder()
                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                .sort(GitLabGroupEpicsListSort.ASC)
                .search("search")
                .state(GitLabGroupEpicsListState.OPENED)
                .authorId(1L)
                .authorUsername("author_username")
                .labels(List.of("labels"))
                .withLabelsDetails(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .includeAncestorGroups(true)
                .includeDescendantGroups(true)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .notLabels(List.of("not[labels]"))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .build();
        final List<String> values = built.notLabels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupEpicsListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "orderBy",
                        "sort",
                        "search",
                        "state",
                        "authorId",
                        "authorUsername",
                        "labels",
                        "withLabelsDetails",
                        "createdAfter",
                        "createdBefore",
                        "updatedAfter",
                        "updatedBefore",
                        "includeAncestorGroups",
                        "includeDescendantGroups",
                        "myReactionEmoji",
                        "confidential",
                        "notLabels",
                        "notAuthorId",
                        "notAuthorUsername");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupEpicsListFilter empty = GitLabGroupEpicsListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupEpicsListFilter filter = GitLabGroupEpicsListFilterBuilder.builder()
                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                .sort(GitLabGroupEpicsListSort.ASC)
                .search("search")
                .state(GitLabGroupEpicsListState.OPENED)
                .authorId(1L)
                .authorUsername("author_username")
                .labels(List.of("labels"))
                .withLabelsDetails(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .includeAncestorGroups(true)
                .includeDescendantGroups(true)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .notLabels(List.of("not[labels]"))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("order_by", "created_at"),
                        Map.entry("sort", "asc"),
                        Map.entry("search", "search"),
                        Map.entry("state", "opened"),
                        Map.entry("author_id", "1"),
                        Map.entry("author_username", "author_username"),
                        Map.entry("labels", "labels"),
                        Map.entry("with_labels_details", "true"),
                        Map.entry("created_after", "2026-01-01T00:00:00Z"),
                        Map.entry("created_before", "2026-01-01T00:00:00Z"),
                        Map.entry("updated_after", "2026-01-01T00:00:00Z"),
                        Map.entry("updated_before", "2026-01-01T00:00:00Z"),
                        Map.entry("include_ancestor_groups", "true"),
                        Map.entry("include_descendant_groups", "true"),
                        Map.entry("my_reaction_emoji", "my_reaction_emoji"),
                        Map.entry("confidential", "true"),
                        Map.entry("not[labels]", "not[labels]"),
                        Map.entry("not[author_id]", "1"),
                        Map.entry("not[author_username]", "not[author_username]"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupEpicsListFilter filter = GitLabGroupEpicsListFilterBuilder.builder()
                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("order_by", "created_at"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupEpicsListFilter filter = GitLabGroupEpicsListFilterBuilder.builder()
                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                .sort(GitLabGroupEpicsListSort.ASC)
                .search("search")
                .state(GitLabGroupEpicsListState.OPENED)
                .authorId(1L)
                .authorUsername("author_username")
                .labels(List.of("labels"))
                .withLabelsDetails(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .includeAncestorGroups(true)
                .includeDescendantGroups(true)
                .myReactionEmoji("my_reaction_emoji")
                .confidential(true)
                .notLabels(List.of("not[labels]"))
                .notAuthorId(1)
                .notAuthorUsername("not[author_username]")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

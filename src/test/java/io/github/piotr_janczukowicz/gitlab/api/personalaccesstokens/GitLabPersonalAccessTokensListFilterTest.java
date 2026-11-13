package io.github.piotr_janczukowicz.gitlab.api.personalaccesstokens;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPersonalAccessTokensListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabPersonalAccessTokensListFilterBuilder builder = GitLabPersonalAccessTokensListFilterBuilder.builder(
                        GitLabPersonalAccessTokensListFilterBuilder.builder()
                                .userId(1L)
                                .revoked(true)
                                .state(GitLabPersonalAccessTokensListState.ALL)
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .expiresBefore(LocalDate.parse("2026-01-01"))
                                .expiresAfter(LocalDate.parse("2026-01-01"))
                                .search("search")
                                .sort("sort")
                                .build())
                .userId(null);

        final GitLabPersonalAccessTokensListFilter built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRevokedIsNullable() {
        final GitLabPersonalAccessTokensListFilterBuilder builder = GitLabPersonalAccessTokensListFilterBuilder.builder(
                        GitLabPersonalAccessTokensListFilterBuilder.builder()
                                .userId(1L)
                                .revoked(true)
                                .state(GitLabPersonalAccessTokensListState.ALL)
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .expiresBefore(LocalDate.parse("2026-01-01"))
                                .expiresAfter(LocalDate.parse("2026-01-01"))
                                .search("search")
                                .sort("sort")
                                .build())
                .revoked(null);

        final GitLabPersonalAccessTokensListFilter built = builder.build();

        assertThat(built.revoked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabPersonalAccessTokensListFilterBuilder builder = GitLabPersonalAccessTokensListFilterBuilder.builder(
                        GitLabPersonalAccessTokensListFilterBuilder.builder()
                                .userId(1L)
                                .revoked(true)
                                .state(GitLabPersonalAccessTokensListState.ALL)
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .expiresBefore(LocalDate.parse("2026-01-01"))
                                .expiresAfter(LocalDate.parse("2026-01-01"))
                                .search("search")
                                .sort("sort")
                                .build())
                .state(null);

        final GitLabPersonalAccessTokensListFilter built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedBeforeIsNullable() {
        final GitLabPersonalAccessTokensListFilterBuilder builder = GitLabPersonalAccessTokensListFilterBuilder.builder(
                        GitLabPersonalAccessTokensListFilterBuilder.builder()
                                .userId(1L)
                                .revoked(true)
                                .state(GitLabPersonalAccessTokensListState.ALL)
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .expiresBefore(LocalDate.parse("2026-01-01"))
                                .expiresAfter(LocalDate.parse("2026-01-01"))
                                .search("search")
                                .sort("sort")
                                .build())
                .createdBefore(null);

        final GitLabPersonalAccessTokensListFilter built = builder.build();

        assertThat(built.createdBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAfterIsNullable() {
        final GitLabPersonalAccessTokensListFilterBuilder builder = GitLabPersonalAccessTokensListFilterBuilder.builder(
                        GitLabPersonalAccessTokensListFilterBuilder.builder()
                                .userId(1L)
                                .revoked(true)
                                .state(GitLabPersonalAccessTokensListState.ALL)
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .expiresBefore(LocalDate.parse("2026-01-01"))
                                .expiresAfter(LocalDate.parse("2026-01-01"))
                                .search("search")
                                .sort("sort")
                                .build())
                .createdAfter(null);

        final GitLabPersonalAccessTokensListFilter built = builder.build();

        assertThat(built.createdAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUsedBeforeIsNullable() {
        final GitLabPersonalAccessTokensListFilterBuilder builder = GitLabPersonalAccessTokensListFilterBuilder.builder(
                        GitLabPersonalAccessTokensListFilterBuilder.builder()
                                .userId(1L)
                                .revoked(true)
                                .state(GitLabPersonalAccessTokensListState.ALL)
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .expiresBefore(LocalDate.parse("2026-01-01"))
                                .expiresAfter(LocalDate.parse("2026-01-01"))
                                .search("search")
                                .sort("sort")
                                .build())
                .lastUsedBefore(null);

        final GitLabPersonalAccessTokensListFilter built = builder.build();

        assertThat(built.lastUsedBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUsedAfterIsNullable() {
        final GitLabPersonalAccessTokensListFilterBuilder builder = GitLabPersonalAccessTokensListFilterBuilder.builder(
                        GitLabPersonalAccessTokensListFilterBuilder.builder()
                                .userId(1L)
                                .revoked(true)
                                .state(GitLabPersonalAccessTokensListState.ALL)
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .expiresBefore(LocalDate.parse("2026-01-01"))
                                .expiresAfter(LocalDate.parse("2026-01-01"))
                                .search("search")
                                .sort("sort")
                                .build())
                .lastUsedAfter(null);

        final GitLabPersonalAccessTokensListFilter built = builder.build();

        assertThat(built.lastUsedAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresBeforeIsNullable() {
        final GitLabPersonalAccessTokensListFilterBuilder builder = GitLabPersonalAccessTokensListFilterBuilder.builder(
                        GitLabPersonalAccessTokensListFilterBuilder.builder()
                                .userId(1L)
                                .revoked(true)
                                .state(GitLabPersonalAccessTokensListState.ALL)
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .expiresBefore(LocalDate.parse("2026-01-01"))
                                .expiresAfter(LocalDate.parse("2026-01-01"))
                                .search("search")
                                .sort("sort")
                                .build())
                .expiresBefore(null);

        final GitLabPersonalAccessTokensListFilter built = builder.build();

        assertThat(built.expiresBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAfterIsNullable() {
        final GitLabPersonalAccessTokensListFilterBuilder builder = GitLabPersonalAccessTokensListFilterBuilder.builder(
                        GitLabPersonalAccessTokensListFilterBuilder.builder()
                                .userId(1L)
                                .revoked(true)
                                .state(GitLabPersonalAccessTokensListState.ALL)
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .expiresBefore(LocalDate.parse("2026-01-01"))
                                .expiresAfter(LocalDate.parse("2026-01-01"))
                                .search("search")
                                .sort("sort")
                                .build())
                .expiresAfter(null);

        final GitLabPersonalAccessTokensListFilter built = builder.build();

        assertThat(built.expiresAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabPersonalAccessTokensListFilterBuilder builder = GitLabPersonalAccessTokensListFilterBuilder.builder(
                        GitLabPersonalAccessTokensListFilterBuilder.builder()
                                .userId(1L)
                                .revoked(true)
                                .state(GitLabPersonalAccessTokensListState.ALL)
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .expiresBefore(LocalDate.parse("2026-01-01"))
                                .expiresAfter(LocalDate.parse("2026-01-01"))
                                .search("search")
                                .sort("sort")
                                .build())
                .search(null);

        final GitLabPersonalAccessTokensListFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabPersonalAccessTokensListFilterBuilder builder = GitLabPersonalAccessTokensListFilterBuilder.builder(
                        GitLabPersonalAccessTokensListFilterBuilder.builder()
                                .userId(1L)
                                .revoked(true)
                                .state(GitLabPersonalAccessTokensListState.ALL)
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .expiresBefore(LocalDate.parse("2026-01-01"))
                                .expiresAfter(LocalDate.parse("2026-01-01"))
                                .search("search")
                                .sort("sort")
                                .build())
                .sort(null);

        final GitLabPersonalAccessTokensListFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPersonalAccessTokensListFilter value = GitLabPersonalAccessTokensListFilterBuilder.builder()
                .userId(1L)
                .revoked(true)
                .state(GitLabPersonalAccessTokensListState.ALL)
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .lastUsedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .lastUsedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .expiresBefore(LocalDate.parse("2026-01-01"))
                .expiresAfter(LocalDate.parse("2026-01-01"))
                .search("search")
                .sort("sort")
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.userId()).isEqualTo(1L);
            softly.assertThat(value.revoked()).isEqualTo(true);
            softly.assertThat(value.state()).isEqualTo(GitLabPersonalAccessTokensListState.ALL);
            softly.assertThat(value.createdBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.lastUsedBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.lastUsedAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.expiresBefore()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.expiresAfter()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.sort()).isEqualTo("sort");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPersonalAccessTokensListFilter original = GitLabPersonalAccessTokensListFilterBuilder.builder()
                .userId(1L)
                .revoked(true)
                .state(GitLabPersonalAccessTokensListState.ALL)
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .lastUsedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .lastUsedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .expiresBefore(LocalDate.parse("2026-01-01"))
                .expiresAfter(LocalDate.parse("2026-01-01"))
                .search("search")
                .sort("sort")
                .build();

        final GitLabPersonalAccessTokensListFilter rebuilt =
                GitLabPersonalAccessTokensListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPersonalAccessTokensListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "userId",
                        "revoked",
                        "state",
                        "createdBefore",
                        "createdAfter",
                        "lastUsedBefore",
                        "lastUsedAfter",
                        "expiresBefore",
                        "expiresAfter",
                        "search",
                        "sort");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabPersonalAccessTokensListFilter empty = GitLabPersonalAccessTokensListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabPersonalAccessTokensListFilter filter = GitLabPersonalAccessTokensListFilterBuilder.builder()
                .userId(1L)
                .revoked(true)
                .state(GitLabPersonalAccessTokensListState.ALL)
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .lastUsedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .lastUsedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .expiresBefore(LocalDate.parse("2026-01-01"))
                .expiresAfter(LocalDate.parse("2026-01-01"))
                .search("search")
                .sort("sort")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("user_id", "1"),
                        Map.entry("revoked", "true"),
                        Map.entry("state", "all"),
                        Map.entry("created_before", "2026-01-01T00:00:00Z"),
                        Map.entry("created_after", "2026-01-01T00:00:00Z"),
                        Map.entry("last_used_before", "2026-01-01T00:00:00Z"),
                        Map.entry("last_used_after", "2026-01-01T00:00:00Z"),
                        Map.entry("expires_before", "2026-01-01"),
                        Map.entry("expires_after", "2026-01-01"),
                        Map.entry("search", "search"),
                        Map.entry("sort", "sort"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabPersonalAccessTokensListFilter filter =
                GitLabPersonalAccessTokensListFilterBuilder.builder().userId(1L).build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("user_id", "1"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabPersonalAccessTokensListFilter filter = GitLabPersonalAccessTokensListFilterBuilder.builder()
                .userId(1L)
                .revoked(true)
                .state(GitLabPersonalAccessTokensListState.ALL)
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .lastUsedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .lastUsedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .expiresBefore(LocalDate.parse("2026-01-01"))
                .expiresAfter(LocalDate.parse("2026-01-01"))
                .search("search")
                .sort("sort")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

package io.github.piotr_janczukowicz.gitlab.api.releases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectReleasesListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabProjectReleasesListFilterBuilder builder = GitLabProjectReleasesListFilterBuilder.builder(
                        GitLabProjectReleasesListFilterBuilder.builder()
                                .orderBy(GitLabProjectReleasesListOrderBy.RELEASED_AT)
                                .sort(GitLabProjectReleasesListSort.ASC)
                                .includeHtmlDescription(true)
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .build())
                .orderBy(null);

        final GitLabProjectReleasesListFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabProjectReleasesListFilterBuilder builder = GitLabProjectReleasesListFilterBuilder.builder(
                        GitLabProjectReleasesListFilterBuilder.builder()
                                .orderBy(GitLabProjectReleasesListOrderBy.RELEASED_AT)
                                .sort(GitLabProjectReleasesListSort.ASC)
                                .includeHtmlDescription(true)
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .build())
                .sort(null);

        final GitLabProjectReleasesListFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeHtmlDescriptionIsNullable() {
        final GitLabProjectReleasesListFilterBuilder builder = GitLabProjectReleasesListFilterBuilder.builder(
                        GitLabProjectReleasesListFilterBuilder.builder()
                                .orderBy(GitLabProjectReleasesListOrderBy.RELEASED_AT)
                                .sort(GitLabProjectReleasesListSort.ASC)
                                .includeHtmlDescription(true)
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .build())
                .includeHtmlDescription(null);

        final GitLabProjectReleasesListFilter built = builder.build();

        assertThat(built.includeHtmlDescription()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedBeforeIsNullable() {
        final GitLabProjectReleasesListFilterBuilder builder = GitLabProjectReleasesListFilterBuilder.builder(
                        GitLabProjectReleasesListFilterBuilder.builder()
                                .orderBy(GitLabProjectReleasesListOrderBy.RELEASED_AT)
                                .sort(GitLabProjectReleasesListSort.ASC)
                                .includeHtmlDescription(true)
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .build())
                .updatedBefore(null);

        final GitLabProjectReleasesListFilter built = builder.build();

        assertThat(built.updatedBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAfterIsNullable() {
        final GitLabProjectReleasesListFilterBuilder builder = GitLabProjectReleasesListFilterBuilder.builder(
                        GitLabProjectReleasesListFilterBuilder.builder()
                                .orderBy(GitLabProjectReleasesListOrderBy.RELEASED_AT)
                                .sort(GitLabProjectReleasesListSort.ASC)
                                .includeHtmlDescription(true)
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .build())
                .updatedAfter(null);

        final GitLabProjectReleasesListFilter built = builder.build();

        assertThat(built.updatedAfter()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectReleasesListFilter value = GitLabProjectReleasesListFilterBuilder.builder()
                .orderBy(GitLabProjectReleasesListOrderBy.RELEASED_AT)
                .sort(GitLabProjectReleasesListSort.ASC)
                .includeHtmlDescription(true)
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.orderBy()).isEqualTo(GitLabProjectReleasesListOrderBy.RELEASED_AT);
            softly.assertThat(value.sort()).isEqualTo(GitLabProjectReleasesListSort.ASC);
            softly.assertThat(value.includeHtmlDescription()).isEqualTo(true);
            softly.assertThat(value.updatedBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectReleasesListFilter original = GitLabProjectReleasesListFilterBuilder.builder()
                .orderBy(GitLabProjectReleasesListOrderBy.RELEASED_AT)
                .sort(GitLabProjectReleasesListSort.ASC)
                .includeHtmlDescription(true)
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .build();

        final GitLabProjectReleasesListFilter rebuilt =
                GitLabProjectReleasesListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectReleasesListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("orderBy", "sort", "includeHtmlDescription", "updatedBefore", "updatedAfter");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectReleasesListFilter empty = GitLabProjectReleasesListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectReleasesListFilter filter = GitLabProjectReleasesListFilterBuilder.builder()
                .orderBy(GitLabProjectReleasesListOrderBy.RELEASED_AT)
                .sort(GitLabProjectReleasesListSort.ASC)
                .includeHtmlDescription(true)
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("order_by", "released_at"),
                        Map.entry("sort", "asc"),
                        Map.entry("include_html_description", "true"),
                        Map.entry("updated_before", "2026-01-01T00:00:00Z"),
                        Map.entry("updated_after", "2026-01-01T00:00:00Z"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectReleasesListFilter filter = GitLabProjectReleasesListFilterBuilder.builder()
                .orderBy(GitLabProjectReleasesListOrderBy.RELEASED_AT)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("order_by", "released_at"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectReleasesListFilter filter = GitLabProjectReleasesListFilterBuilder.builder()
                .orderBy(GitLabProjectReleasesListOrderBy.RELEASED_AT)
                .sort(GitLabProjectReleasesListSort.ASC)
                .includeHtmlDescription(true)
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

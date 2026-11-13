package io.github.piotr_janczukowicz.gitlab.api.pipelines;

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
class GitLabProjectPipelinesListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenSourceIsNullable() {
        final GitLabProjectPipelinesListFilterBuilder builder = GitLabProjectPipelinesListFilterBuilder.builder(
                        GitLabProjectPipelinesListFilterBuilder.builder()
                                .source(GitLabProjectPipelinesListSource.UNKNOWN)
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .orderBy(GitLabProjectPipelinesListOrderBy.CREATED_AT)
                                .sort(GitLabProjectPipelinesListSort.DESC)
                                .cursor("cursor")
                                .build())
                .source(null);

        final GitLabProjectPipelinesListFilter built = builder.build();

        assertThat(built.source()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedBeforeIsNullable() {
        final GitLabProjectPipelinesListFilterBuilder builder = GitLabProjectPipelinesListFilterBuilder.builder(
                        GitLabProjectPipelinesListFilterBuilder.builder()
                                .source(GitLabProjectPipelinesListSource.UNKNOWN)
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .orderBy(GitLabProjectPipelinesListOrderBy.CREATED_AT)
                                .sort(GitLabProjectPipelinesListSort.DESC)
                                .cursor("cursor")
                                .build())
                .createdBefore(null);

        final GitLabProjectPipelinesListFilter built = builder.build();

        assertThat(built.createdBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAfterIsNullable() {
        final GitLabProjectPipelinesListFilterBuilder builder = GitLabProjectPipelinesListFilterBuilder.builder(
                        GitLabProjectPipelinesListFilterBuilder.builder()
                                .source(GitLabProjectPipelinesListSource.UNKNOWN)
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .orderBy(GitLabProjectPipelinesListOrderBy.CREATED_AT)
                                .sort(GitLabProjectPipelinesListSort.DESC)
                                .cursor("cursor")
                                .build())
                .createdAfter(null);

        final GitLabProjectPipelinesListFilter built = builder.build();

        assertThat(built.createdAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabProjectPipelinesListFilterBuilder builder = GitLabProjectPipelinesListFilterBuilder.builder(
                        GitLabProjectPipelinesListFilterBuilder.builder()
                                .source(GitLabProjectPipelinesListSource.UNKNOWN)
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .orderBy(GitLabProjectPipelinesListOrderBy.CREATED_AT)
                                .sort(GitLabProjectPipelinesListSort.DESC)
                                .cursor("cursor")
                                .build())
                .orderBy(null);

        final GitLabProjectPipelinesListFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabProjectPipelinesListFilterBuilder builder = GitLabProjectPipelinesListFilterBuilder.builder(
                        GitLabProjectPipelinesListFilterBuilder.builder()
                                .source(GitLabProjectPipelinesListSource.UNKNOWN)
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .orderBy(GitLabProjectPipelinesListOrderBy.CREATED_AT)
                                .sort(GitLabProjectPipelinesListSort.DESC)
                                .cursor("cursor")
                                .build())
                .sort(null);

        final GitLabProjectPipelinesListFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCursorIsNullable() {
        final GitLabProjectPipelinesListFilterBuilder builder = GitLabProjectPipelinesListFilterBuilder.builder(
                        GitLabProjectPipelinesListFilterBuilder.builder()
                                .source(GitLabProjectPipelinesListSource.UNKNOWN)
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .orderBy(GitLabProjectPipelinesListOrderBy.CREATED_AT)
                                .sort(GitLabProjectPipelinesListSort.DESC)
                                .cursor("cursor")
                                .build())
                .cursor(null);

        final GitLabProjectPipelinesListFilter built = builder.build();

        assertThat(built.cursor()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPipelinesListFilter value = GitLabProjectPipelinesListFilterBuilder.builder()
                .source(GitLabProjectPipelinesListSource.UNKNOWN)
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .orderBy(GitLabProjectPipelinesListOrderBy.CREATED_AT)
                .sort(GitLabProjectPipelinesListSort.DESC)
                .cursor("cursor")
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.source()).isEqualTo(GitLabProjectPipelinesListSource.UNKNOWN);
            softly.assertThat(value.createdBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.orderBy()).isEqualTo(GitLabProjectPipelinesListOrderBy.CREATED_AT);
            softly.assertThat(value.sort()).isEqualTo(GitLabProjectPipelinesListSort.DESC);
            softly.assertThat(value.cursor()).isEqualTo("cursor");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPipelinesListFilter original = GitLabProjectPipelinesListFilterBuilder.builder()
                .source(GitLabProjectPipelinesListSource.UNKNOWN)
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .orderBy(GitLabProjectPipelinesListOrderBy.CREATED_AT)
                .sort(GitLabProjectPipelinesListSort.DESC)
                .cursor("cursor")
                .build();

        final GitLabProjectPipelinesListFilter rebuilt =
                GitLabProjectPipelinesListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPipelinesListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("source", "createdBefore", "createdAfter", "orderBy", "sort", "cursor");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectPipelinesListFilter empty = GitLabProjectPipelinesListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectPipelinesListFilter filter = GitLabProjectPipelinesListFilterBuilder.builder()
                .source(GitLabProjectPipelinesListSource.UNKNOWN)
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .orderBy(GitLabProjectPipelinesListOrderBy.CREATED_AT)
                .sort(GitLabProjectPipelinesListSort.DESC)
                .cursor("cursor")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("source", "unknown"),
                        Map.entry("created_before", "2026-01-01T00:00:00Z"),
                        Map.entry("created_after", "2026-01-01T00:00:00Z"),
                        Map.entry("order_by", "created_at"),
                        Map.entry("sort", "desc"),
                        Map.entry("cursor", "cursor"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectPipelinesListFilter filter = GitLabProjectPipelinesListFilterBuilder.builder()
                .source(GitLabProjectPipelinesListSource.UNKNOWN)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("source", "unknown"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectPipelinesListFilter filter = GitLabProjectPipelinesListFilterBuilder.builder()
                .source(GitLabProjectPipelinesListSource.UNKNOWN)
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .orderBy(GitLabProjectPipelinesListOrderBy.CREATED_AT)
                .sort(GitLabProjectPipelinesListSort.DESC)
                .cursor("cursor")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

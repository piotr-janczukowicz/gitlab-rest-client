package io.github.piotr_janczukowicz.gitlab.api.iterations;

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
class GitLabProjectIterationsListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabProjectIterationsListFilterBuilder builder = GitLabProjectIterationsListFilterBuilder.builder(
                        GitLabProjectIterationsListFilterBuilder.builder()
                                .state(GitLabProjectIterationsListState.OPENED)
                                .search("search")
                                .inValue(List.of(GitLabProjectIterationsListIn.TITLE))
                                .includeAncestors(true)
                                .includeDescendants(true)
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .build())
                .state(null);

        final GitLabProjectIterationsListFilter built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabProjectIterationsListFilterBuilder builder = GitLabProjectIterationsListFilterBuilder.builder(
                        GitLabProjectIterationsListFilterBuilder.builder()
                                .state(GitLabProjectIterationsListState.OPENED)
                                .search("search")
                                .inValue(List.of(GitLabProjectIterationsListIn.TITLE))
                                .includeAncestors(true)
                                .includeDescendants(true)
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .build())
                .search(null);

        final GitLabProjectIterationsListFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInValueIsNullable() {
        final GitLabProjectIterationsListFilterBuilder builder = GitLabProjectIterationsListFilterBuilder.builder(
                        GitLabProjectIterationsListFilterBuilder.builder()
                                .state(GitLabProjectIterationsListState.OPENED)
                                .search("search")
                                .inValue(List.of(GitLabProjectIterationsListIn.TITLE))
                                .includeAncestors(true)
                                .includeDescendants(true)
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .build())
                .inValue(null);

        final GitLabProjectIterationsListFilter built = builder.build();

        assertThat(built.inValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeAncestorsIsNullable() {
        final GitLabProjectIterationsListFilterBuilder builder = GitLabProjectIterationsListFilterBuilder.builder(
                        GitLabProjectIterationsListFilterBuilder.builder()
                                .state(GitLabProjectIterationsListState.OPENED)
                                .search("search")
                                .inValue(List.of(GitLabProjectIterationsListIn.TITLE))
                                .includeAncestors(true)
                                .includeDescendants(true)
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .build())
                .includeAncestors(null);

        final GitLabProjectIterationsListFilter built = builder.build();

        assertThat(built.includeAncestors()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeDescendantsIsNullable() {
        final GitLabProjectIterationsListFilterBuilder builder = GitLabProjectIterationsListFilterBuilder.builder(
                        GitLabProjectIterationsListFilterBuilder.builder()
                                .state(GitLabProjectIterationsListState.OPENED)
                                .search("search")
                                .inValue(List.of(GitLabProjectIterationsListIn.TITLE))
                                .includeAncestors(true)
                                .includeDescendants(true)
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .build())
                .includeDescendants(null);

        final GitLabProjectIterationsListFilter built = builder.build();

        assertThat(built.includeDescendants()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedBeforeIsNullable() {
        final GitLabProjectIterationsListFilterBuilder builder = GitLabProjectIterationsListFilterBuilder.builder(
                        GitLabProjectIterationsListFilterBuilder.builder()
                                .state(GitLabProjectIterationsListState.OPENED)
                                .search("search")
                                .inValue(List.of(GitLabProjectIterationsListIn.TITLE))
                                .includeAncestors(true)
                                .includeDescendants(true)
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .build())
                .updatedBefore(null);

        final GitLabProjectIterationsListFilter built = builder.build();

        assertThat(built.updatedBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAfterIsNullable() {
        final GitLabProjectIterationsListFilterBuilder builder = GitLabProjectIterationsListFilterBuilder.builder(
                        GitLabProjectIterationsListFilterBuilder.builder()
                                .state(GitLabProjectIterationsListState.OPENED)
                                .search("search")
                                .inValue(List.of(GitLabProjectIterationsListIn.TITLE))
                                .includeAncestors(true)
                                .includeDescendants(true)
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .build())
                .updatedAfter(null);

        final GitLabProjectIterationsListFilter built = builder.build();

        assertThat(built.updatedAfter()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIterationsListFilter value = GitLabProjectIterationsListFilterBuilder.builder()
                .state(GitLabProjectIterationsListState.OPENED)
                .search("search")
                .inValue(List.of(GitLabProjectIterationsListIn.TITLE))
                .includeAncestors(true)
                .includeDescendants(true)
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.state()).isEqualTo(GitLabProjectIterationsListState.OPENED);
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.inValue()).isEqualTo(List.of(GitLabProjectIterationsListIn.TITLE));
            softly.assertThat(value.includeAncestors()).isEqualTo(true);
            softly.assertThat(value.includeDescendants()).isEqualTo(true);
            softly.assertThat(value.updatedBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIterationsListFilter original = GitLabProjectIterationsListFilterBuilder.builder()
                .state(GitLabProjectIterationsListState.OPENED)
                .search("search")
                .inValue(List.of(GitLabProjectIterationsListIn.TITLE))
                .includeAncestors(true)
                .includeDescendants(true)
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .build();

        final GitLabProjectIterationsListFilter rebuilt =
                GitLabProjectIterationsListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenInValueSourceChangesLater() {
        final List<GitLabProjectIterationsListIn> source =
                new ArrayList<>(List.of(GitLabProjectIterationsListIn.TITLE));
        final GitLabProjectIterationsListFilter built = GitLabProjectIterationsListFilterBuilder.builder(
                        GitLabProjectIterationsListFilterBuilder.builder()
                                .state(GitLabProjectIterationsListState.OPENED)
                                .search("search")
                                .inValue(List.of(GitLabProjectIterationsListIn.TITLE))
                                .includeAncestors(true)
                                .includeDescendants(true)
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .build())
                .inValue(source)
                .build();
        source.clear();

        assertThat(built.inValue()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenInValueIsRead() {
        final GitLabProjectIterationsListFilter built = GitLabProjectIterationsListFilterBuilder.builder()
                .state(GitLabProjectIterationsListState.OPENED)
                .search("search")
                .inValue(List.of(GitLabProjectIterationsListIn.TITLE))
                .includeAncestors(true)
                .includeDescendants(true)
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
        final List<GitLabProjectIterationsListIn> values = built.inValue();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIterationsListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "state",
                        "search",
                        "inValue",
                        "includeAncestors",
                        "includeDescendants",
                        "updatedBefore",
                        "updatedAfter");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectIterationsListFilter empty = GitLabProjectIterationsListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectIterationsListFilter filter = GitLabProjectIterationsListFilterBuilder.builder()
                .state(GitLabProjectIterationsListState.OPENED)
                .search("search")
                .inValue(List.of(GitLabProjectIterationsListIn.TITLE))
                .includeAncestors(true)
                .includeDescendants(true)
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("state", "opened"),
                        Map.entry("search", "search"),
                        Map.entry("in", "title"),
                        Map.entry("include_ancestors", "true"),
                        Map.entry("include_descendants", "true"),
                        Map.entry("updated_before", "2026-01-01T00:00:00Z"),
                        Map.entry("updated_after", "2026-01-01T00:00:00Z"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectIterationsListFilter filter = GitLabProjectIterationsListFilterBuilder.builder()
                .state(GitLabProjectIterationsListState.OPENED)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("state", "opened"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectIterationsListFilter filter = GitLabProjectIterationsListFilterBuilder.builder()
                .state(GitLabProjectIterationsListState.OPENED)
                .search("search")
                .inValue(List.of(GitLabProjectIterationsListIn.TITLE))
                .includeAncestors(true)
                .includeDescendants(true)
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

package io.github.piotr_janczukowicz.gitlab.api.groupiterations;

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
class GitLabGroupGroupIterationsListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabGroupGroupIterationsListFilterBuilder builder = GitLabGroupGroupIterationsListFilterBuilder.builder(
                        GitLabGroupGroupIterationsListFilterBuilder.builder()
                                .state(GitLabGroupGroupIterationsListState.OPENED)
                                .search("search")
                                .inValue(List.of(GitLabGroupGroupIterationsListIn.TITLE))
                                .includeAncestors(true)
                                .includeDescendants(true)
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .build())
                .state(null);

        final GitLabGroupGroupIterationsListFilter built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabGroupGroupIterationsListFilterBuilder builder = GitLabGroupGroupIterationsListFilterBuilder.builder(
                        GitLabGroupGroupIterationsListFilterBuilder.builder()
                                .state(GitLabGroupGroupIterationsListState.OPENED)
                                .search("search")
                                .inValue(List.of(GitLabGroupGroupIterationsListIn.TITLE))
                                .includeAncestors(true)
                                .includeDescendants(true)
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .build())
                .search(null);

        final GitLabGroupGroupIterationsListFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInValueIsNullable() {
        final GitLabGroupGroupIterationsListFilterBuilder builder = GitLabGroupGroupIterationsListFilterBuilder.builder(
                        GitLabGroupGroupIterationsListFilterBuilder.builder()
                                .state(GitLabGroupGroupIterationsListState.OPENED)
                                .search("search")
                                .inValue(List.of(GitLabGroupGroupIterationsListIn.TITLE))
                                .includeAncestors(true)
                                .includeDescendants(true)
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .build())
                .inValue(null);

        final GitLabGroupGroupIterationsListFilter built = builder.build();

        assertThat(built.inValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeAncestorsIsNullable() {
        final GitLabGroupGroupIterationsListFilterBuilder builder = GitLabGroupGroupIterationsListFilterBuilder.builder(
                        GitLabGroupGroupIterationsListFilterBuilder.builder()
                                .state(GitLabGroupGroupIterationsListState.OPENED)
                                .search("search")
                                .inValue(List.of(GitLabGroupGroupIterationsListIn.TITLE))
                                .includeAncestors(true)
                                .includeDescendants(true)
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .build())
                .includeAncestors(null);

        final GitLabGroupGroupIterationsListFilter built = builder.build();

        assertThat(built.includeAncestors()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeDescendantsIsNullable() {
        final GitLabGroupGroupIterationsListFilterBuilder builder = GitLabGroupGroupIterationsListFilterBuilder.builder(
                        GitLabGroupGroupIterationsListFilterBuilder.builder()
                                .state(GitLabGroupGroupIterationsListState.OPENED)
                                .search("search")
                                .inValue(List.of(GitLabGroupGroupIterationsListIn.TITLE))
                                .includeAncestors(true)
                                .includeDescendants(true)
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .build())
                .includeDescendants(null);

        final GitLabGroupGroupIterationsListFilter built = builder.build();

        assertThat(built.includeDescendants()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedBeforeIsNullable() {
        final GitLabGroupGroupIterationsListFilterBuilder builder = GitLabGroupGroupIterationsListFilterBuilder.builder(
                        GitLabGroupGroupIterationsListFilterBuilder.builder()
                                .state(GitLabGroupGroupIterationsListState.OPENED)
                                .search("search")
                                .inValue(List.of(GitLabGroupGroupIterationsListIn.TITLE))
                                .includeAncestors(true)
                                .includeDescendants(true)
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .build())
                .updatedBefore(null);

        final GitLabGroupGroupIterationsListFilter built = builder.build();

        assertThat(built.updatedBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAfterIsNullable() {
        final GitLabGroupGroupIterationsListFilterBuilder builder = GitLabGroupGroupIterationsListFilterBuilder.builder(
                        GitLabGroupGroupIterationsListFilterBuilder.builder()
                                .state(GitLabGroupGroupIterationsListState.OPENED)
                                .search("search")
                                .inValue(List.of(GitLabGroupGroupIterationsListIn.TITLE))
                                .includeAncestors(true)
                                .includeDescendants(true)
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .build())
                .updatedAfter(null);

        final GitLabGroupGroupIterationsListFilter built = builder.build();

        assertThat(built.updatedAfter()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIterationsListFilter value = GitLabGroupGroupIterationsListFilterBuilder.builder()
                .state(GitLabGroupGroupIterationsListState.OPENED)
                .search("search")
                .inValue(List.of(GitLabGroupGroupIterationsListIn.TITLE))
                .includeAncestors(true)
                .includeDescendants(true)
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.state()).isEqualTo(GitLabGroupGroupIterationsListState.OPENED);
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.inValue()).isEqualTo(List.of(GitLabGroupGroupIterationsListIn.TITLE));
            softly.assertThat(value.includeAncestors()).isEqualTo(true);
            softly.assertThat(value.includeDescendants()).isEqualTo(true);
            softly.assertThat(value.updatedBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIterationsListFilter original = GitLabGroupGroupIterationsListFilterBuilder.builder()
                .state(GitLabGroupGroupIterationsListState.OPENED)
                .search("search")
                .inValue(List.of(GitLabGroupGroupIterationsListIn.TITLE))
                .includeAncestors(true)
                .includeDescendants(true)
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .build();

        final GitLabGroupGroupIterationsListFilter rebuilt =
                GitLabGroupGroupIterationsListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenInValueSourceChangesLater() {
        final List<GitLabGroupGroupIterationsListIn> source =
                new ArrayList<>(List.of(GitLabGroupGroupIterationsListIn.TITLE));
        final GitLabGroupGroupIterationsListFilter built = GitLabGroupGroupIterationsListFilterBuilder.builder(
                        GitLabGroupGroupIterationsListFilterBuilder.builder()
                                .state(GitLabGroupGroupIterationsListState.OPENED)
                                .search("search")
                                .inValue(List.of(GitLabGroupGroupIterationsListIn.TITLE))
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
        final GitLabGroupGroupIterationsListFilter built = GitLabGroupGroupIterationsListFilterBuilder.builder()
                .state(GitLabGroupGroupIterationsListState.OPENED)
                .search("search")
                .inValue(List.of(GitLabGroupGroupIterationsListIn.TITLE))
                .includeAncestors(true)
                .includeDescendants(true)
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
        final List<GitLabGroupGroupIterationsListIn> values = built.inValue();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIterationsListFilter.class.getRecordComponents())
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
        final GitLabGroupGroupIterationsListFilter empty = GitLabGroupGroupIterationsListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupGroupIterationsListFilter filter = GitLabGroupGroupIterationsListFilterBuilder.builder()
                .state(GitLabGroupGroupIterationsListState.OPENED)
                .search("search")
                .inValue(List.of(GitLabGroupGroupIterationsListIn.TITLE))
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
        final GitLabGroupGroupIterationsListFilter filter = GitLabGroupGroupIterationsListFilterBuilder.builder()
                .state(GitLabGroupGroupIterationsListState.OPENED)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("state", "opened"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupGroupIterationsListFilter filter = GitLabGroupGroupIterationsListFilterBuilder.builder()
                .state(GitLabGroupGroupIterationsListState.OPENED)
                .search("search")
                .inValue(List.of(GitLabGroupGroupIterationsListIn.TITLE))
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

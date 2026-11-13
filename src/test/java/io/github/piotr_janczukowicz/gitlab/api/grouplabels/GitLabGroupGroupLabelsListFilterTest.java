package io.github.piotr_janczukowicz.gitlab.api.grouplabels;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupLabelsListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenWithCountsIsNullable() {
        final GitLabGroupGroupLabelsListFilterBuilder builder = GitLabGroupGroupLabelsListFilterBuilder.builder(
                        GitLabGroupGroupLabelsListFilterBuilder.builder()
                                .withCounts(true)
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .onlyGroupLabels(true)
                                .search("search")
                                .archived(true)
                                .build())
                .withCounts(null);

        final GitLabGroupGroupLabelsListFilter built = builder.build();

        assertThat(built.withCounts()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeAncestorGroupsIsNullable() {
        final GitLabGroupGroupLabelsListFilterBuilder builder = GitLabGroupGroupLabelsListFilterBuilder.builder(
                        GitLabGroupGroupLabelsListFilterBuilder.builder()
                                .withCounts(true)
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .onlyGroupLabels(true)
                                .search("search")
                                .archived(true)
                                .build())
                .includeAncestorGroups(null);

        final GitLabGroupGroupLabelsListFilter built = builder.build();

        assertThat(built.includeAncestorGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeDescendantGroupsIsNullable() {
        final GitLabGroupGroupLabelsListFilterBuilder builder = GitLabGroupGroupLabelsListFilterBuilder.builder(
                        GitLabGroupGroupLabelsListFilterBuilder.builder()
                                .withCounts(true)
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .onlyGroupLabels(true)
                                .search("search")
                                .archived(true)
                                .build())
                .includeDescendantGroups(null);

        final GitLabGroupGroupLabelsListFilter built = builder.build();

        assertThat(built.includeDescendantGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlyGroupLabelsIsNullable() {
        final GitLabGroupGroupLabelsListFilterBuilder builder = GitLabGroupGroupLabelsListFilterBuilder.builder(
                        GitLabGroupGroupLabelsListFilterBuilder.builder()
                                .withCounts(true)
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .onlyGroupLabels(true)
                                .search("search")
                                .archived(true)
                                .build())
                .onlyGroupLabels(null);

        final GitLabGroupGroupLabelsListFilter built = builder.build();

        assertThat(built.onlyGroupLabels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabGroupGroupLabelsListFilterBuilder builder = GitLabGroupGroupLabelsListFilterBuilder.builder(
                        GitLabGroupGroupLabelsListFilterBuilder.builder()
                                .withCounts(true)
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .onlyGroupLabels(true)
                                .search("search")
                                .archived(true)
                                .build())
                .search(null);

        final GitLabGroupGroupLabelsListFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchivedIsNullable() {
        final GitLabGroupGroupLabelsListFilterBuilder builder = GitLabGroupGroupLabelsListFilterBuilder.builder(
                        GitLabGroupGroupLabelsListFilterBuilder.builder()
                                .withCounts(true)
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .onlyGroupLabels(true)
                                .search("search")
                                .archived(true)
                                .build())
                .archived(null);

        final GitLabGroupGroupLabelsListFilter built = builder.build();

        assertThat(built.archived()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupLabelsListFilter value = GitLabGroupGroupLabelsListFilterBuilder.builder()
                .withCounts(true)
                .includeAncestorGroups(true)
                .includeDescendantGroups(true)
                .onlyGroupLabels(true)
                .search("search")
                .archived(true)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.withCounts()).isEqualTo(true);
            softly.assertThat(value.includeAncestorGroups()).isEqualTo(true);
            softly.assertThat(value.includeDescendantGroups()).isEqualTo(true);
            softly.assertThat(value.onlyGroupLabels()).isEqualTo(true);
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.archived()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupLabelsListFilter original = GitLabGroupGroupLabelsListFilterBuilder.builder()
                .withCounts(true)
                .includeAncestorGroups(true)
                .includeDescendantGroups(true)
                .onlyGroupLabels(true)
                .search("search")
                .archived(true)
                .build();

        final GitLabGroupGroupLabelsListFilter rebuilt =
                GitLabGroupGroupLabelsListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupLabelsListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "withCounts",
                        "includeAncestorGroups",
                        "includeDescendantGroups",
                        "onlyGroupLabels",
                        "search",
                        "archived");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupGroupLabelsListFilter empty = GitLabGroupGroupLabelsListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupGroupLabelsListFilter filter = GitLabGroupGroupLabelsListFilterBuilder.builder()
                .withCounts(true)
                .includeAncestorGroups(true)
                .includeDescendantGroups(true)
                .onlyGroupLabels(true)
                .search("search")
                .archived(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("with_counts", "true"),
                        Map.entry("include_ancestor_groups", "true"),
                        Map.entry("include_descendant_groups", "true"),
                        Map.entry("only_group_labels", "true"),
                        Map.entry("search", "search"),
                        Map.entry("archived", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupGroupLabelsListFilter filter = GitLabGroupGroupLabelsListFilterBuilder.builder()
                .withCounts(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("with_counts", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupGroupLabelsListFilter filter = GitLabGroupGroupLabelsListFilterBuilder.builder()
                .withCounts(true)
                .includeAncestorGroups(true)
                .includeDescendantGroups(true)
                .onlyGroupLabels(true)
                .search("search")
                .archived(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

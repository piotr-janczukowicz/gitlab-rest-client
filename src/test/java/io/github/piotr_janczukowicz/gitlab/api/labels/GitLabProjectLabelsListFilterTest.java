package io.github.piotr_janczukowicz.gitlab.api.labels;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectLabelsListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenWithCountsIsNullable() {
        final GitLabProjectLabelsListFilterBuilder builder = GitLabProjectLabelsListFilterBuilder.builder(
                        GitLabProjectLabelsListFilterBuilder.builder()
                                .withCounts(true)
                                .includeAncestorGroups(true)
                                .search("search")
                                .archived(true)
                                .build())
                .withCounts(null);

        final GitLabProjectLabelsListFilter built = builder.build();

        assertThat(built.withCounts()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeAncestorGroupsIsNullable() {
        final GitLabProjectLabelsListFilterBuilder builder = GitLabProjectLabelsListFilterBuilder.builder(
                        GitLabProjectLabelsListFilterBuilder.builder()
                                .withCounts(true)
                                .includeAncestorGroups(true)
                                .search("search")
                                .archived(true)
                                .build())
                .includeAncestorGroups(null);

        final GitLabProjectLabelsListFilter built = builder.build();

        assertThat(built.includeAncestorGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabProjectLabelsListFilterBuilder builder = GitLabProjectLabelsListFilterBuilder.builder(
                        GitLabProjectLabelsListFilterBuilder.builder()
                                .withCounts(true)
                                .includeAncestorGroups(true)
                                .search("search")
                                .archived(true)
                                .build())
                .search(null);

        final GitLabProjectLabelsListFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchivedIsNullable() {
        final GitLabProjectLabelsListFilterBuilder builder = GitLabProjectLabelsListFilterBuilder.builder(
                        GitLabProjectLabelsListFilterBuilder.builder()
                                .withCounts(true)
                                .includeAncestorGroups(true)
                                .search("search")
                                .archived(true)
                                .build())
                .archived(null);

        final GitLabProjectLabelsListFilter built = builder.build();

        assertThat(built.archived()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectLabelsListFilter value = GitLabProjectLabelsListFilterBuilder.builder()
                .withCounts(true)
                .includeAncestorGroups(true)
                .search("search")
                .archived(true)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.withCounts()).isEqualTo(true);
            softly.assertThat(value.includeAncestorGroups()).isEqualTo(true);
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.archived()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectLabelsListFilter original = GitLabProjectLabelsListFilterBuilder.builder()
                .withCounts(true)
                .includeAncestorGroups(true)
                .search("search")
                .archived(true)
                .build();

        final GitLabProjectLabelsListFilter rebuilt =
                GitLabProjectLabelsListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectLabelsListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("withCounts", "includeAncestorGroups", "search", "archived");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectLabelsListFilter empty = GitLabProjectLabelsListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectLabelsListFilter filter = GitLabProjectLabelsListFilterBuilder.builder()
                .withCounts(true)
                .includeAncestorGroups(true)
                .search("search")
                .archived(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("with_counts", "true"),
                        Map.entry("include_ancestor_groups", "true"),
                        Map.entry("search", "search"),
                        Map.entry("archived", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectLabelsListFilter filter =
                GitLabProjectLabelsListFilterBuilder.builder().withCounts(true).build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("with_counts", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectLabelsListFilter filter = GitLabProjectLabelsListFilterBuilder.builder()
                .withCounts(true)
                .includeAncestorGroups(true)
                .search("search")
                .archived(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

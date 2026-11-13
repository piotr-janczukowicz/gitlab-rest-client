package io.github.piotr_janczukowicz.gitlab.api.notes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectNotesListSnippetsNotesFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabProjectNotesListSnippetsNotesFilterBuilder builder =
                GitLabProjectNotesListSnippetsNotesFilterBuilder.builder(
                                GitLabProjectNotesListSnippetsNotesFilterBuilder.builder()
                                        .orderBy(GitLabProjectNotesListSnippetsNotesOrderBy.CREATED_AT)
                                        .sort(GitLabProjectNotesListSnippetsNotesSort.ASC)
                                        .activityFilter(GitLabProjectNotesListSnippetsNotesActivityFilter.ALL_NOTES)
                                        .build())
                        .orderBy(null);

        final GitLabProjectNotesListSnippetsNotesFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabProjectNotesListSnippetsNotesFilterBuilder builder =
                GitLabProjectNotesListSnippetsNotesFilterBuilder.builder(
                                GitLabProjectNotesListSnippetsNotesFilterBuilder.builder()
                                        .orderBy(GitLabProjectNotesListSnippetsNotesOrderBy.CREATED_AT)
                                        .sort(GitLabProjectNotesListSnippetsNotesSort.ASC)
                                        .activityFilter(GitLabProjectNotesListSnippetsNotesActivityFilter.ALL_NOTES)
                                        .build())
                        .sort(null);

        final GitLabProjectNotesListSnippetsNotesFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActivityFilterIsNullable() {
        final GitLabProjectNotesListSnippetsNotesFilterBuilder builder =
                GitLabProjectNotesListSnippetsNotesFilterBuilder.builder(
                                GitLabProjectNotesListSnippetsNotesFilterBuilder.builder()
                                        .orderBy(GitLabProjectNotesListSnippetsNotesOrderBy.CREATED_AT)
                                        .sort(GitLabProjectNotesListSnippetsNotesSort.ASC)
                                        .activityFilter(GitLabProjectNotesListSnippetsNotesActivityFilter.ALL_NOTES)
                                        .build())
                        .activityFilter(null);

        final GitLabProjectNotesListSnippetsNotesFilter built = builder.build();

        assertThat(built.activityFilter()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectNotesListSnippetsNotesFilter value =
                GitLabProjectNotesListSnippetsNotesFilterBuilder.builder()
                        .orderBy(GitLabProjectNotesListSnippetsNotesOrderBy.CREATED_AT)
                        .sort(GitLabProjectNotesListSnippetsNotesSort.ASC)
                        .activityFilter(GitLabProjectNotesListSnippetsNotesActivityFilter.ALL_NOTES)
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.orderBy()).isEqualTo(GitLabProjectNotesListSnippetsNotesOrderBy.CREATED_AT);
            softly.assertThat(value.sort()).isEqualTo(GitLabProjectNotesListSnippetsNotesSort.ASC);
            softly.assertThat(value.activityFilter())
                    .isEqualTo(GitLabProjectNotesListSnippetsNotesActivityFilter.ALL_NOTES);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectNotesListSnippetsNotesFilter original =
                GitLabProjectNotesListSnippetsNotesFilterBuilder.builder()
                        .orderBy(GitLabProjectNotesListSnippetsNotesOrderBy.CREATED_AT)
                        .sort(GitLabProjectNotesListSnippetsNotesSort.ASC)
                        .activityFilter(GitLabProjectNotesListSnippetsNotesActivityFilter.ALL_NOTES)
                        .build();

        final GitLabProjectNotesListSnippetsNotesFilter rebuilt =
                GitLabProjectNotesListSnippetsNotesFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectNotesListSnippetsNotesFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("orderBy", "sort", "activityFilter");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectNotesListSnippetsNotesFilter empty = GitLabProjectNotesListSnippetsNotesFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectNotesListSnippetsNotesFilter filter =
                GitLabProjectNotesListSnippetsNotesFilterBuilder.builder()
                        .orderBy(GitLabProjectNotesListSnippetsNotesOrderBy.CREATED_AT)
                        .sort(GitLabProjectNotesListSnippetsNotesSort.ASC)
                        .activityFilter(GitLabProjectNotesListSnippetsNotesActivityFilter.ALL_NOTES)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("order_by", "created_at"),
                        Map.entry("sort", "asc"),
                        Map.entry("activity_filter", "all_notes"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectNotesListSnippetsNotesFilter filter =
                GitLabProjectNotesListSnippetsNotesFilterBuilder.builder()
                        .orderBy(GitLabProjectNotesListSnippetsNotesOrderBy.CREATED_AT)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("order_by", "created_at"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectNotesListSnippetsNotesFilter filter =
                GitLabProjectNotesListSnippetsNotesFilterBuilder.builder()
                        .orderBy(GitLabProjectNotesListSnippetsNotesOrderBy.CREATED_AT)
                        .sort(GitLabProjectNotesListSnippetsNotesSort.ASC)
                        .activityFilter(GitLabProjectNotesListSnippetsNotesActivityFilter.ALL_NOTES)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

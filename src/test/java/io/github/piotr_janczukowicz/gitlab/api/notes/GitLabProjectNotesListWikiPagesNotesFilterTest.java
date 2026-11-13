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
class GitLabProjectNotesListWikiPagesNotesFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabProjectNotesListWikiPagesNotesFilterBuilder builder =
                GitLabProjectNotesListWikiPagesNotesFilterBuilder.builder(
                                GitLabProjectNotesListWikiPagesNotesFilterBuilder.builder()
                                        .orderBy(GitLabProjectNotesListWikiPagesNotesOrderBy.CREATED_AT)
                                        .sort(GitLabProjectNotesListWikiPagesNotesSort.ASC)
                                        .activityFilter(GitLabProjectNotesListWikiPagesNotesActivityFilter.ALL_NOTES)
                                        .build())
                        .orderBy(null);

        final GitLabProjectNotesListWikiPagesNotesFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabProjectNotesListWikiPagesNotesFilterBuilder builder =
                GitLabProjectNotesListWikiPagesNotesFilterBuilder.builder(
                                GitLabProjectNotesListWikiPagesNotesFilterBuilder.builder()
                                        .orderBy(GitLabProjectNotesListWikiPagesNotesOrderBy.CREATED_AT)
                                        .sort(GitLabProjectNotesListWikiPagesNotesSort.ASC)
                                        .activityFilter(GitLabProjectNotesListWikiPagesNotesActivityFilter.ALL_NOTES)
                                        .build())
                        .sort(null);

        final GitLabProjectNotesListWikiPagesNotesFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActivityFilterIsNullable() {
        final GitLabProjectNotesListWikiPagesNotesFilterBuilder builder =
                GitLabProjectNotesListWikiPagesNotesFilterBuilder.builder(
                                GitLabProjectNotesListWikiPagesNotesFilterBuilder.builder()
                                        .orderBy(GitLabProjectNotesListWikiPagesNotesOrderBy.CREATED_AT)
                                        .sort(GitLabProjectNotesListWikiPagesNotesSort.ASC)
                                        .activityFilter(GitLabProjectNotesListWikiPagesNotesActivityFilter.ALL_NOTES)
                                        .build())
                        .activityFilter(null);

        final GitLabProjectNotesListWikiPagesNotesFilter built = builder.build();

        assertThat(built.activityFilter()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectNotesListWikiPagesNotesFilter value =
                GitLabProjectNotesListWikiPagesNotesFilterBuilder.builder()
                        .orderBy(GitLabProjectNotesListWikiPagesNotesOrderBy.CREATED_AT)
                        .sort(GitLabProjectNotesListWikiPagesNotesSort.ASC)
                        .activityFilter(GitLabProjectNotesListWikiPagesNotesActivityFilter.ALL_NOTES)
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.orderBy()).isEqualTo(GitLabProjectNotesListWikiPagesNotesOrderBy.CREATED_AT);
            softly.assertThat(value.sort()).isEqualTo(GitLabProjectNotesListWikiPagesNotesSort.ASC);
            softly.assertThat(value.activityFilter())
                    .isEqualTo(GitLabProjectNotesListWikiPagesNotesActivityFilter.ALL_NOTES);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectNotesListWikiPagesNotesFilter original =
                GitLabProjectNotesListWikiPagesNotesFilterBuilder.builder()
                        .orderBy(GitLabProjectNotesListWikiPagesNotesOrderBy.CREATED_AT)
                        .sort(GitLabProjectNotesListWikiPagesNotesSort.ASC)
                        .activityFilter(GitLabProjectNotesListWikiPagesNotesActivityFilter.ALL_NOTES)
                        .build();

        final GitLabProjectNotesListWikiPagesNotesFilter rebuilt =
                GitLabProjectNotesListWikiPagesNotesFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectNotesListWikiPagesNotesFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("orderBy", "sort", "activityFilter");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectNotesListWikiPagesNotesFilter empty = GitLabProjectNotesListWikiPagesNotesFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectNotesListWikiPagesNotesFilter filter =
                GitLabProjectNotesListWikiPagesNotesFilterBuilder.builder()
                        .orderBy(GitLabProjectNotesListWikiPagesNotesOrderBy.CREATED_AT)
                        .sort(GitLabProjectNotesListWikiPagesNotesSort.ASC)
                        .activityFilter(GitLabProjectNotesListWikiPagesNotesActivityFilter.ALL_NOTES)
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
        final GitLabProjectNotesListWikiPagesNotesFilter filter =
                GitLabProjectNotesListWikiPagesNotesFilterBuilder.builder()
                        .orderBy(GitLabProjectNotesListWikiPagesNotesOrderBy.CREATED_AT)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("order_by", "created_at"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectNotesListWikiPagesNotesFilter filter =
                GitLabProjectNotesListWikiPagesNotesFilterBuilder.builder()
                        .orderBy(GitLabProjectNotesListWikiPagesNotesOrderBy.CREATED_AT)
                        .sort(GitLabProjectNotesListWikiPagesNotesSort.ASC)
                        .activityFilter(GitLabProjectNotesListWikiPagesNotesActivityFilter.ALL_NOTES)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

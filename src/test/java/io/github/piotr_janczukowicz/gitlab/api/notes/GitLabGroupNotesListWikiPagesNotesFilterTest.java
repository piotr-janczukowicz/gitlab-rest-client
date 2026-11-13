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
class GitLabGroupNotesListWikiPagesNotesFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabGroupNotesListWikiPagesNotesFilterBuilder builder =
                GitLabGroupNotesListWikiPagesNotesFilterBuilder.builder(
                                GitLabGroupNotesListWikiPagesNotesFilterBuilder.builder()
                                        .orderBy(GitLabGroupNotesListWikiPagesNotesOrderBy.CREATED_AT)
                                        .sort(GitLabGroupNotesListWikiPagesNotesSort.ASC)
                                        .activityFilter(GitLabGroupNotesListWikiPagesNotesActivityFilter.ALL_NOTES)
                                        .build())
                        .orderBy(null);

        final GitLabGroupNotesListWikiPagesNotesFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabGroupNotesListWikiPagesNotesFilterBuilder builder =
                GitLabGroupNotesListWikiPagesNotesFilterBuilder.builder(
                                GitLabGroupNotesListWikiPagesNotesFilterBuilder.builder()
                                        .orderBy(GitLabGroupNotesListWikiPagesNotesOrderBy.CREATED_AT)
                                        .sort(GitLabGroupNotesListWikiPagesNotesSort.ASC)
                                        .activityFilter(GitLabGroupNotesListWikiPagesNotesActivityFilter.ALL_NOTES)
                                        .build())
                        .sort(null);

        final GitLabGroupNotesListWikiPagesNotesFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActivityFilterIsNullable() {
        final GitLabGroupNotesListWikiPagesNotesFilterBuilder builder =
                GitLabGroupNotesListWikiPagesNotesFilterBuilder.builder(
                                GitLabGroupNotesListWikiPagesNotesFilterBuilder.builder()
                                        .orderBy(GitLabGroupNotesListWikiPagesNotesOrderBy.CREATED_AT)
                                        .sort(GitLabGroupNotesListWikiPagesNotesSort.ASC)
                                        .activityFilter(GitLabGroupNotesListWikiPagesNotesActivityFilter.ALL_NOTES)
                                        .build())
                        .activityFilter(null);

        final GitLabGroupNotesListWikiPagesNotesFilter built = builder.build();

        assertThat(built.activityFilter()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupNotesListWikiPagesNotesFilter value = GitLabGroupNotesListWikiPagesNotesFilterBuilder.builder()
                .orderBy(GitLabGroupNotesListWikiPagesNotesOrderBy.CREATED_AT)
                .sort(GitLabGroupNotesListWikiPagesNotesSort.ASC)
                .activityFilter(GitLabGroupNotesListWikiPagesNotesActivityFilter.ALL_NOTES)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.orderBy()).isEqualTo(GitLabGroupNotesListWikiPagesNotesOrderBy.CREATED_AT);
            softly.assertThat(value.sort()).isEqualTo(GitLabGroupNotesListWikiPagesNotesSort.ASC);
            softly.assertThat(value.activityFilter())
                    .isEqualTo(GitLabGroupNotesListWikiPagesNotesActivityFilter.ALL_NOTES);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupNotesListWikiPagesNotesFilter original =
                GitLabGroupNotesListWikiPagesNotesFilterBuilder.builder()
                        .orderBy(GitLabGroupNotesListWikiPagesNotesOrderBy.CREATED_AT)
                        .sort(GitLabGroupNotesListWikiPagesNotesSort.ASC)
                        .activityFilter(GitLabGroupNotesListWikiPagesNotesActivityFilter.ALL_NOTES)
                        .build();

        final GitLabGroupNotesListWikiPagesNotesFilter rebuilt =
                GitLabGroupNotesListWikiPagesNotesFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupNotesListWikiPagesNotesFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("orderBy", "sort", "activityFilter");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupNotesListWikiPagesNotesFilter empty = GitLabGroupNotesListWikiPagesNotesFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupNotesListWikiPagesNotesFilter filter =
                GitLabGroupNotesListWikiPagesNotesFilterBuilder.builder()
                        .orderBy(GitLabGroupNotesListWikiPagesNotesOrderBy.CREATED_AT)
                        .sort(GitLabGroupNotesListWikiPagesNotesSort.ASC)
                        .activityFilter(GitLabGroupNotesListWikiPagesNotesActivityFilter.ALL_NOTES)
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
        final GitLabGroupNotesListWikiPagesNotesFilter filter =
                GitLabGroupNotesListWikiPagesNotesFilterBuilder.builder()
                        .orderBy(GitLabGroupNotesListWikiPagesNotesOrderBy.CREATED_AT)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("order_by", "created_at"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupNotesListWikiPagesNotesFilter filter =
                GitLabGroupNotesListWikiPagesNotesFilterBuilder.builder()
                        .orderBy(GitLabGroupNotesListWikiPagesNotesOrderBy.CREATED_AT)
                        .sort(GitLabGroupNotesListWikiPagesNotesSort.ASC)
                        .activityFilter(GitLabGroupNotesListWikiPagesNotesActivityFilter.ALL_NOTES)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

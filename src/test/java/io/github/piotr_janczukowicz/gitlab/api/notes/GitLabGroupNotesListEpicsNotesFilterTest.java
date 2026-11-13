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
class GitLabGroupNotesListEpicsNotesFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabGroupNotesListEpicsNotesFilterBuilder builder = GitLabGroupNotesListEpicsNotesFilterBuilder.builder(
                        GitLabGroupNotesListEpicsNotesFilterBuilder.builder()
                                .orderBy(GitLabGroupNotesListEpicsNotesOrderBy.CREATED_AT)
                                .sort(GitLabGroupNotesListEpicsNotesSort.ASC)
                                .activityFilter(GitLabGroupNotesListEpicsNotesActivityFilter.ALL_NOTES)
                                .build())
                .orderBy(null);

        final GitLabGroupNotesListEpicsNotesFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabGroupNotesListEpicsNotesFilterBuilder builder = GitLabGroupNotesListEpicsNotesFilterBuilder.builder(
                        GitLabGroupNotesListEpicsNotesFilterBuilder.builder()
                                .orderBy(GitLabGroupNotesListEpicsNotesOrderBy.CREATED_AT)
                                .sort(GitLabGroupNotesListEpicsNotesSort.ASC)
                                .activityFilter(GitLabGroupNotesListEpicsNotesActivityFilter.ALL_NOTES)
                                .build())
                .sort(null);

        final GitLabGroupNotesListEpicsNotesFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActivityFilterIsNullable() {
        final GitLabGroupNotesListEpicsNotesFilterBuilder builder = GitLabGroupNotesListEpicsNotesFilterBuilder.builder(
                        GitLabGroupNotesListEpicsNotesFilterBuilder.builder()
                                .orderBy(GitLabGroupNotesListEpicsNotesOrderBy.CREATED_AT)
                                .sort(GitLabGroupNotesListEpicsNotesSort.ASC)
                                .activityFilter(GitLabGroupNotesListEpicsNotesActivityFilter.ALL_NOTES)
                                .build())
                .activityFilter(null);

        final GitLabGroupNotesListEpicsNotesFilter built = builder.build();

        assertThat(built.activityFilter()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupNotesListEpicsNotesFilter value = GitLabGroupNotesListEpicsNotesFilterBuilder.builder()
                .orderBy(GitLabGroupNotesListEpicsNotesOrderBy.CREATED_AT)
                .sort(GitLabGroupNotesListEpicsNotesSort.ASC)
                .activityFilter(GitLabGroupNotesListEpicsNotesActivityFilter.ALL_NOTES)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.orderBy()).isEqualTo(GitLabGroupNotesListEpicsNotesOrderBy.CREATED_AT);
            softly.assertThat(value.sort()).isEqualTo(GitLabGroupNotesListEpicsNotesSort.ASC);
            softly.assertThat(value.activityFilter()).isEqualTo(GitLabGroupNotesListEpicsNotesActivityFilter.ALL_NOTES);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupNotesListEpicsNotesFilter original = GitLabGroupNotesListEpicsNotesFilterBuilder.builder()
                .orderBy(GitLabGroupNotesListEpicsNotesOrderBy.CREATED_AT)
                .sort(GitLabGroupNotesListEpicsNotesSort.ASC)
                .activityFilter(GitLabGroupNotesListEpicsNotesActivityFilter.ALL_NOTES)
                .build();

        final GitLabGroupNotesListEpicsNotesFilter rebuilt =
                GitLabGroupNotesListEpicsNotesFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupNotesListEpicsNotesFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("orderBy", "sort", "activityFilter");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupNotesListEpicsNotesFilter empty = GitLabGroupNotesListEpicsNotesFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupNotesListEpicsNotesFilter filter = GitLabGroupNotesListEpicsNotesFilterBuilder.builder()
                .orderBy(GitLabGroupNotesListEpicsNotesOrderBy.CREATED_AT)
                .sort(GitLabGroupNotesListEpicsNotesSort.ASC)
                .activityFilter(GitLabGroupNotesListEpicsNotesActivityFilter.ALL_NOTES)
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
        final GitLabGroupNotesListEpicsNotesFilter filter = GitLabGroupNotesListEpicsNotesFilterBuilder.builder()
                .orderBy(GitLabGroupNotesListEpicsNotesOrderBy.CREATED_AT)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("order_by", "created_at"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupNotesListEpicsNotesFilter filter = GitLabGroupNotesListEpicsNotesFilterBuilder.builder()
                .orderBy(GitLabGroupNotesListEpicsNotesOrderBy.CREATED_AT)
                .sort(GitLabGroupNotesListEpicsNotesSort.ASC)
                .activityFilter(GitLabGroupNotesListEpicsNotesActivityFilter.ALL_NOTES)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

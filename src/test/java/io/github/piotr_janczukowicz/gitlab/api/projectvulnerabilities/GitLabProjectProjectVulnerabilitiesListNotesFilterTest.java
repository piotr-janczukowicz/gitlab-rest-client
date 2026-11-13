package io.github.piotr_janczukowicz.gitlab.api.projectvulnerabilities;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectVulnerabilitiesListNotesFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabProjectProjectVulnerabilitiesListNotesFilterBuilder builder =
                GitLabProjectProjectVulnerabilitiesListNotesFilterBuilder.builder(
                                GitLabProjectProjectVulnerabilitiesListNotesFilterBuilder.builder()
                                        .orderBy(GitLabProjectProjectVulnerabilitiesListNotesOrderBy.CREATED_AT)
                                        .sort(GitLabProjectProjectVulnerabilitiesListNotesSort.ASC)
                                        .activityFilter(
                                                GitLabProjectProjectVulnerabilitiesListNotesActivityFilter.ALL_NOTES)
                                        .build())
                        .orderBy(null);

        final GitLabProjectProjectVulnerabilitiesListNotesFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabProjectProjectVulnerabilitiesListNotesFilterBuilder builder =
                GitLabProjectProjectVulnerabilitiesListNotesFilterBuilder.builder(
                                GitLabProjectProjectVulnerabilitiesListNotesFilterBuilder.builder()
                                        .orderBy(GitLabProjectProjectVulnerabilitiesListNotesOrderBy.CREATED_AT)
                                        .sort(GitLabProjectProjectVulnerabilitiesListNotesSort.ASC)
                                        .activityFilter(
                                                GitLabProjectProjectVulnerabilitiesListNotesActivityFilter.ALL_NOTES)
                                        .build())
                        .sort(null);

        final GitLabProjectProjectVulnerabilitiesListNotesFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActivityFilterIsNullable() {
        final GitLabProjectProjectVulnerabilitiesListNotesFilterBuilder builder =
                GitLabProjectProjectVulnerabilitiesListNotesFilterBuilder.builder(
                                GitLabProjectProjectVulnerabilitiesListNotesFilterBuilder.builder()
                                        .orderBy(GitLabProjectProjectVulnerabilitiesListNotesOrderBy.CREATED_AT)
                                        .sort(GitLabProjectProjectVulnerabilitiesListNotesSort.ASC)
                                        .activityFilter(
                                                GitLabProjectProjectVulnerabilitiesListNotesActivityFilter.ALL_NOTES)
                                        .build())
                        .activityFilter(null);

        final GitLabProjectProjectVulnerabilitiesListNotesFilter built = builder.build();

        assertThat(built.activityFilter()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectVulnerabilitiesListNotesFilter value =
                GitLabProjectProjectVulnerabilitiesListNotesFilterBuilder.builder()
                        .orderBy(GitLabProjectProjectVulnerabilitiesListNotesOrderBy.CREATED_AT)
                        .sort(GitLabProjectProjectVulnerabilitiesListNotesSort.ASC)
                        .activityFilter(GitLabProjectProjectVulnerabilitiesListNotesActivityFilter.ALL_NOTES)
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.orderBy())
                    .isEqualTo(GitLabProjectProjectVulnerabilitiesListNotesOrderBy.CREATED_AT);
            softly.assertThat(value.sort()).isEqualTo(GitLabProjectProjectVulnerabilitiesListNotesSort.ASC);
            softly.assertThat(value.activityFilter())
                    .isEqualTo(GitLabProjectProjectVulnerabilitiesListNotesActivityFilter.ALL_NOTES);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectVulnerabilitiesListNotesFilter original =
                GitLabProjectProjectVulnerabilitiesListNotesFilterBuilder.builder()
                        .orderBy(GitLabProjectProjectVulnerabilitiesListNotesOrderBy.CREATED_AT)
                        .sort(GitLabProjectProjectVulnerabilitiesListNotesSort.ASC)
                        .activityFilter(GitLabProjectProjectVulnerabilitiesListNotesActivityFilter.ALL_NOTES)
                        .build();

        final GitLabProjectProjectVulnerabilitiesListNotesFilter rebuilt =
                GitLabProjectProjectVulnerabilitiesListNotesFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectVulnerabilitiesListNotesFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("orderBy", "sort", "activityFilter");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectVulnerabilitiesListNotesFilter empty =
                GitLabProjectProjectVulnerabilitiesListNotesFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectVulnerabilitiesListNotesFilter filter =
                GitLabProjectProjectVulnerabilitiesListNotesFilterBuilder.builder()
                        .orderBy(GitLabProjectProjectVulnerabilitiesListNotesOrderBy.CREATED_AT)
                        .sort(GitLabProjectProjectVulnerabilitiesListNotesSort.ASC)
                        .activityFilter(GitLabProjectProjectVulnerabilitiesListNotesActivityFilter.ALL_NOTES)
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
        final GitLabProjectProjectVulnerabilitiesListNotesFilter filter =
                GitLabProjectProjectVulnerabilitiesListNotesFilterBuilder.builder()
                        .orderBy(GitLabProjectProjectVulnerabilitiesListNotesOrderBy.CREATED_AT)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("order_by", "created_at"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectVulnerabilitiesListNotesFilter filter =
                GitLabProjectProjectVulnerabilitiesListNotesFilterBuilder.builder()
                        .orderBy(GitLabProjectProjectVulnerabilitiesListNotesOrderBy.CREATED_AT)
                        .sort(GitLabProjectProjectVulnerabilitiesListNotesSort.ASC)
                        .activityFilter(GitLabProjectProjectVulnerabilitiesListNotesActivityFilter.ALL_NOTES)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

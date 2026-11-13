package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceProjectsListUsersContributedProjectsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabInstanceProjectsListUsersContributedProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersContributedProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersContributedProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersContributedProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersContributedProjectsSort.ASC)
                                        .simple(true)
                                        .build())
                        .orderBy(null);

        final GitLabInstanceProjectsListUsersContributedProjectsFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabInstanceProjectsListUsersContributedProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersContributedProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersContributedProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersContributedProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersContributedProjectsSort.ASC)
                                        .simple(true)
                                        .build())
                        .sort(null);

        final GitLabInstanceProjectsListUsersContributedProjectsFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSimpleIsNullable() {
        final GitLabInstanceProjectsListUsersContributedProjectsFilterBuilder builder =
                GitLabInstanceProjectsListUsersContributedProjectsFilterBuilder.builder(
                                GitLabInstanceProjectsListUsersContributedProjectsFilterBuilder.builder()
                                        .orderBy(GitLabInstanceProjectsListUsersContributedProjectsOrderBy.ID)
                                        .sort(GitLabInstanceProjectsListUsersContributedProjectsSort.ASC)
                                        .simple(true)
                                        .build())
                        .simple(null);

        final GitLabInstanceProjectsListUsersContributedProjectsFilter built = builder.build();

        assertThat(built.simple()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceProjectsListUsersContributedProjectsFilter value =
                GitLabInstanceProjectsListUsersContributedProjectsFilterBuilder.builder()
                        .orderBy(GitLabInstanceProjectsListUsersContributedProjectsOrderBy.ID)
                        .sort(GitLabInstanceProjectsListUsersContributedProjectsSort.ASC)
                        .simple(true)
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.orderBy()).isEqualTo(GitLabInstanceProjectsListUsersContributedProjectsOrderBy.ID);
            softly.assertThat(value.sort()).isEqualTo(GitLabInstanceProjectsListUsersContributedProjectsSort.ASC);
            softly.assertThat(value.simple()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceProjectsListUsersContributedProjectsFilter original =
                GitLabInstanceProjectsListUsersContributedProjectsFilterBuilder.builder()
                        .orderBy(GitLabInstanceProjectsListUsersContributedProjectsOrderBy.ID)
                        .sort(GitLabInstanceProjectsListUsersContributedProjectsSort.ASC)
                        .simple(true)
                        .build();

        final GitLabInstanceProjectsListUsersContributedProjectsFilter rebuilt =
                GitLabInstanceProjectsListUsersContributedProjectsFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabInstanceProjectsListUsersContributedProjectsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("orderBy", "sort", "simple");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabInstanceProjectsListUsersContributedProjectsFilter empty =
                GitLabInstanceProjectsListUsersContributedProjectsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabInstanceProjectsListUsersContributedProjectsFilter filter =
                GitLabInstanceProjectsListUsersContributedProjectsFilterBuilder.builder()
                        .orderBy(GitLabInstanceProjectsListUsersContributedProjectsOrderBy.ID)
                        .sort(GitLabInstanceProjectsListUsersContributedProjectsSort.ASC)
                        .simple(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(Map.entry("order_by", "id"), Map.entry("sort", "asc"), Map.entry("simple", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabInstanceProjectsListUsersContributedProjectsFilter filter =
                GitLabInstanceProjectsListUsersContributedProjectsFilterBuilder.builder()
                        .orderBy(GitLabInstanceProjectsListUsersContributedProjectsOrderBy.ID)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("order_by", "id"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabInstanceProjectsListUsersContributedProjectsFilter filter =
                GitLabInstanceProjectsListUsersContributedProjectsFilterBuilder.builder()
                        .orderBy(GitLabInstanceProjectsListUsersContributedProjectsOrderBy.ID)
                        .sort(GitLabInstanceProjectsListUsersContributedProjectsSort.ASC)
                        .simple(true)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

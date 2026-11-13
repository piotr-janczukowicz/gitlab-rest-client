package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupServiceAccountsListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabGroupServiceAccountsListFilterBuilder builder = GitLabGroupServiceAccountsListFilterBuilder.builder(
                        GitLabGroupServiceAccountsListFilterBuilder.builder()
                                .orderBy(GitLabGroupServiceAccountsListOrderBy.ID)
                                .sort(GitLabGroupServiceAccountsListSort.ASC)
                                .build())
                .orderBy(null);

        final GitLabGroupServiceAccountsListFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabGroupServiceAccountsListFilterBuilder builder = GitLabGroupServiceAccountsListFilterBuilder.builder(
                        GitLabGroupServiceAccountsListFilterBuilder.builder()
                                .orderBy(GitLabGroupServiceAccountsListOrderBy.ID)
                                .sort(GitLabGroupServiceAccountsListSort.ASC)
                                .build())
                .sort(null);

        final GitLabGroupServiceAccountsListFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupServiceAccountsListFilter value = GitLabGroupServiceAccountsListFilterBuilder.builder()
                .orderBy(GitLabGroupServiceAccountsListOrderBy.ID)
                .sort(GitLabGroupServiceAccountsListSort.ASC)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.orderBy()).isEqualTo(GitLabGroupServiceAccountsListOrderBy.ID);
            softly.assertThat(value.sort()).isEqualTo(GitLabGroupServiceAccountsListSort.ASC);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupServiceAccountsListFilter original = GitLabGroupServiceAccountsListFilterBuilder.builder()
                .orderBy(GitLabGroupServiceAccountsListOrderBy.ID)
                .sort(GitLabGroupServiceAccountsListSort.ASC)
                .build();

        final GitLabGroupServiceAccountsListFilter rebuilt =
                GitLabGroupServiceAccountsListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupServiceAccountsListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("orderBy", "sort");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupServiceAccountsListFilter empty = GitLabGroupServiceAccountsListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupServiceAccountsListFilter filter = GitLabGroupServiceAccountsListFilterBuilder.builder()
                .orderBy(GitLabGroupServiceAccountsListOrderBy.ID)
                .sort(GitLabGroupServiceAccountsListSort.ASC)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("order_by", "id"), Map.entry("sort", "asc"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupServiceAccountsListFilter filter = GitLabGroupServiceAccountsListFilterBuilder.builder()
                .orderBy(GitLabGroupServiceAccountsListOrderBy.ID)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("order_by", "id"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupServiceAccountsListFilter filter = GitLabGroupServiceAccountsListFilterBuilder.builder()
                .orderBy(GitLabGroupServiceAccountsListOrderBy.ID)
                .sort(GitLabGroupServiceAccountsListSort.ASC)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

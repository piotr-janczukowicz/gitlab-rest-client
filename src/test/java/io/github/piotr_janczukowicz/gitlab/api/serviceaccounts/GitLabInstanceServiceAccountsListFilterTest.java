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
class GitLabInstanceServiceAccountsListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabInstanceServiceAccountsListFilterBuilder builder =
                GitLabInstanceServiceAccountsListFilterBuilder.builder(
                                GitLabInstanceServiceAccountsListFilterBuilder.builder()
                                        .orderBy(GitLabInstanceServiceAccountsListOrderBy.ID)
                                        .sort(GitLabInstanceServiceAccountsListSort.ASC)
                                        .build())
                        .orderBy(null);

        final GitLabInstanceServiceAccountsListFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabInstanceServiceAccountsListFilterBuilder builder =
                GitLabInstanceServiceAccountsListFilterBuilder.builder(
                                GitLabInstanceServiceAccountsListFilterBuilder.builder()
                                        .orderBy(GitLabInstanceServiceAccountsListOrderBy.ID)
                                        .sort(GitLabInstanceServiceAccountsListSort.ASC)
                                        .build())
                        .sort(null);

        final GitLabInstanceServiceAccountsListFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceServiceAccountsListFilter value = GitLabInstanceServiceAccountsListFilterBuilder.builder()
                .orderBy(GitLabInstanceServiceAccountsListOrderBy.ID)
                .sort(GitLabInstanceServiceAccountsListSort.ASC)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.orderBy()).isEqualTo(GitLabInstanceServiceAccountsListOrderBy.ID);
            softly.assertThat(value.sort()).isEqualTo(GitLabInstanceServiceAccountsListSort.ASC);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceServiceAccountsListFilter original =
                GitLabInstanceServiceAccountsListFilterBuilder.builder()
                        .orderBy(GitLabInstanceServiceAccountsListOrderBy.ID)
                        .sort(GitLabInstanceServiceAccountsListSort.ASC)
                        .build();

        final GitLabInstanceServiceAccountsListFilter rebuilt =
                GitLabInstanceServiceAccountsListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceServiceAccountsListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("orderBy", "sort");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabInstanceServiceAccountsListFilter empty = GitLabInstanceServiceAccountsListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabInstanceServiceAccountsListFilter filter = GitLabInstanceServiceAccountsListFilterBuilder.builder()
                .orderBy(GitLabInstanceServiceAccountsListOrderBy.ID)
                .sort(GitLabInstanceServiceAccountsListSort.ASC)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("order_by", "id"), Map.entry("sort", "asc"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabInstanceServiceAccountsListFilter filter = GitLabInstanceServiceAccountsListFilterBuilder.builder()
                .orderBy(GitLabInstanceServiceAccountsListOrderBy.ID)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("order_by", "id"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabInstanceServiceAccountsListFilter filter = GitLabInstanceServiceAccountsListFilterBuilder.builder()
                .orderBy(GitLabInstanceServiceAccountsListOrderBy.ID)
                .sort(GitLabInstanceServiceAccountsListSort.ASC)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

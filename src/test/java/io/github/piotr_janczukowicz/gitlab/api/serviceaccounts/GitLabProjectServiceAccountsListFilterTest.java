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
class GitLabProjectServiceAccountsListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabProjectServiceAccountsListFilterBuilder builder =
                GitLabProjectServiceAccountsListFilterBuilder.builder(
                                GitLabProjectServiceAccountsListFilterBuilder.builder()
                                        .orderBy(GitLabProjectServiceAccountsListOrderBy.ID)
                                        .sort(GitLabProjectServiceAccountsListSort.ASC)
                                        .build())
                        .orderBy(null);

        final GitLabProjectServiceAccountsListFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabProjectServiceAccountsListFilterBuilder builder =
                GitLabProjectServiceAccountsListFilterBuilder.builder(
                                GitLabProjectServiceAccountsListFilterBuilder.builder()
                                        .orderBy(GitLabProjectServiceAccountsListOrderBy.ID)
                                        .sort(GitLabProjectServiceAccountsListSort.ASC)
                                        .build())
                        .sort(null);

        final GitLabProjectServiceAccountsListFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectServiceAccountsListFilter value = GitLabProjectServiceAccountsListFilterBuilder.builder()
                .orderBy(GitLabProjectServiceAccountsListOrderBy.ID)
                .sort(GitLabProjectServiceAccountsListSort.ASC)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.orderBy()).isEqualTo(GitLabProjectServiceAccountsListOrderBy.ID);
            softly.assertThat(value.sort()).isEqualTo(GitLabProjectServiceAccountsListSort.ASC);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectServiceAccountsListFilter original = GitLabProjectServiceAccountsListFilterBuilder.builder()
                .orderBy(GitLabProjectServiceAccountsListOrderBy.ID)
                .sort(GitLabProjectServiceAccountsListSort.ASC)
                .build();

        final GitLabProjectServiceAccountsListFilter rebuilt =
                GitLabProjectServiceAccountsListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectServiceAccountsListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("orderBy", "sort");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectServiceAccountsListFilter empty = GitLabProjectServiceAccountsListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectServiceAccountsListFilter filter = GitLabProjectServiceAccountsListFilterBuilder.builder()
                .orderBy(GitLabProjectServiceAccountsListOrderBy.ID)
                .sort(GitLabProjectServiceAccountsListSort.ASC)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("order_by", "id"), Map.entry("sort", "asc"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectServiceAccountsListFilter filter = GitLabProjectServiceAccountsListFilterBuilder.builder()
                .orderBy(GitLabProjectServiceAccountsListOrderBy.ID)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("order_by", "id"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectServiceAccountsListFilter filter = GitLabProjectServiceAccountsListFilterBuilder.builder()
                .orderBy(GitLabProjectServiceAccountsListOrderBy.ID)
                .sort(GitLabProjectServiceAccountsListSort.ASC)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

package io.github.piotr_janczukowicz.gitlab.api.featureflaguserlists;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectFeatureFlagUserListsListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabProjectFeatureFlagUserListsListFilterBuilder builder =
                GitLabProjectFeatureFlagUserListsListFilterBuilder.builder(
                                GitLabProjectFeatureFlagUserListsListFilterBuilder.builder()
                                        .search("search")
                                        .build())
                        .search(null);

        final GitLabProjectFeatureFlagUserListsListFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectFeatureFlagUserListsListFilter value =
                GitLabProjectFeatureFlagUserListsListFilterBuilder.builder()
                        .search("search")
                        .build();

        assertThat(value.search()).isEqualTo("search");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectFeatureFlagUserListsListFilter original =
                GitLabProjectFeatureFlagUserListsListFilterBuilder.builder()
                        .search("search")
                        .build();

        final GitLabProjectFeatureFlagUserListsListFilter rebuilt =
                GitLabProjectFeatureFlagUserListsListFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectFeatureFlagUserListsListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("search");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectFeatureFlagUserListsListFilter empty = GitLabProjectFeatureFlagUserListsListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectFeatureFlagUserListsListFilter filter =
                GitLabProjectFeatureFlagUserListsListFilterBuilder.builder()
                        .search("search")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("search", "search"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectFeatureFlagUserListsListFilter filter =
                GitLabProjectFeatureFlagUserListsListFilterBuilder.builder()
                        .search("search")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("search", "search"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectFeatureFlagUserListsListFilter filter =
                GitLabProjectFeatureFlagUserListsListFilterBuilder.builder()
                        .search("search")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

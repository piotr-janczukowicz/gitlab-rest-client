package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupsListTransferLocationsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabGroupGroupsListTransferLocationsFilterBuilder builder =
                GitLabGroupGroupsListTransferLocationsFilterBuilder.builder(
                                GitLabGroupGroupsListTransferLocationsFilterBuilder.builder()
                                        .search("search")
                                        .build())
                        .search(null);

        final GitLabGroupGroupsListTransferLocationsFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsListTransferLocationsFilter value =
                GitLabGroupGroupsListTransferLocationsFilterBuilder.builder()
                        .search("search")
                        .build();

        assertThat(value.search()).isEqualTo("search");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupsListTransferLocationsFilter original =
                GitLabGroupGroupsListTransferLocationsFilterBuilder.builder()
                        .search("search")
                        .build();

        final GitLabGroupGroupsListTransferLocationsFilter rebuilt =
                GitLabGroupGroupsListTransferLocationsFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupsListTransferLocationsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("search");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupGroupsListTransferLocationsFilter empty = GitLabGroupGroupsListTransferLocationsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupGroupsListTransferLocationsFilter filter =
                GitLabGroupGroupsListTransferLocationsFilterBuilder.builder()
                        .search("search")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("search", "search"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupGroupsListTransferLocationsFilter filter =
                GitLabGroupGroupsListTransferLocationsFilterBuilder.builder()
                        .search("search")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("search", "search"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupGroupsListTransferLocationsFilter filter =
                GitLabGroupGroupsListTransferLocationsFilterBuilder.builder()
                        .search("search")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

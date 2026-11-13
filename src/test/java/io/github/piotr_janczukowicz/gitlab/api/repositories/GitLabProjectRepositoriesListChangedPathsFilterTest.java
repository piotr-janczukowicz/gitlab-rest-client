package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectRepositoriesListChangedPathsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenFindRenamesIsNullable() {
        final GitLabProjectRepositoriesListChangedPathsFilterBuilder builder =
                GitLabProjectRepositoriesListChangedPathsFilterBuilder.builder(
                                GitLabProjectRepositoriesListChangedPathsFilterBuilder.builder()
                                        .findRenames(true)
                                        .build())
                        .findRenames(null);

        final GitLabProjectRepositoriesListChangedPathsFilter built = builder.build();

        assertThat(built.findRenames()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectRepositoriesListChangedPathsFilter value =
                GitLabProjectRepositoriesListChangedPathsFilterBuilder.builder()
                        .findRenames(true)
                        .build();

        assertThat(value.findRenames()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectRepositoriesListChangedPathsFilter original =
                GitLabProjectRepositoriesListChangedPathsFilterBuilder.builder()
                        .findRenames(true)
                        .build();

        final GitLabProjectRepositoriesListChangedPathsFilter rebuilt =
                GitLabProjectRepositoriesListChangedPathsFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectRepositoriesListChangedPathsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("findRenames");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectRepositoriesListChangedPathsFilter empty =
                GitLabProjectRepositoriesListChangedPathsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectRepositoriesListChangedPathsFilter filter =
                GitLabProjectRepositoriesListChangedPathsFilterBuilder.builder()
                        .findRenames(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("find_renames", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectRepositoriesListChangedPathsFilter filter =
                GitLabProjectRepositoriesListChangedPathsFilterBuilder.builder()
                        .findRenames(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("find_renames", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectRepositoriesListChangedPathsFilter filter =
                GitLabProjectRepositoriesListChangedPathsFilterBuilder.builder()
                        .findRenames(true)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectRepositoriesGetDivergingCommitsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenMaxCountIsNullable() {
        final GitLabProjectRepositoriesGetDivergingCommitsFilterBuilder builder =
                GitLabProjectRepositoriesGetDivergingCommitsFilterBuilder.builder(
                                GitLabProjectRepositoriesGetDivergingCommitsFilterBuilder.builder()
                                        .maxCount(1)
                                        .build())
                        .maxCount(null);

        final GitLabProjectRepositoriesGetDivergingCommitsFilter built = builder.build();

        assertThat(built.maxCount()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenMaxCountIsBelowTheMinimum() {
        final GitLabProjectRepositoriesGetDivergingCommitsFilterBuilder builder =
                GitLabProjectRepositoriesGetDivergingCommitsFilterBuilder.builder(
                                GitLabProjectRepositoriesGetDivergingCommitsFilterBuilder.builder()
                                        .maxCount(1)
                                        .build())
                        .maxCount(-1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenMaxCountIsTheMinimum() {
        final GitLabProjectRepositoriesGetDivergingCommitsFilterBuilder builder =
                GitLabProjectRepositoriesGetDivergingCommitsFilterBuilder.builder(
                                GitLabProjectRepositoriesGetDivergingCommitsFilterBuilder.builder()
                                        .maxCount(1)
                                        .build())
                        .maxCount(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectRepositoriesGetDivergingCommitsFilter value =
                GitLabProjectRepositoriesGetDivergingCommitsFilterBuilder.builder()
                        .maxCount(1)
                        .build();

        assertThat(value.maxCount()).isEqualTo(1);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectRepositoriesGetDivergingCommitsFilter original =
                GitLabProjectRepositoriesGetDivergingCommitsFilterBuilder.builder()
                        .maxCount(1)
                        .build();

        final GitLabProjectRepositoriesGetDivergingCommitsFilter rebuilt =
                GitLabProjectRepositoriesGetDivergingCommitsFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectRepositoriesGetDivergingCommitsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("maxCount");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectRepositoriesGetDivergingCommitsFilter empty =
                GitLabProjectRepositoriesGetDivergingCommitsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectRepositoriesGetDivergingCommitsFilter filter =
                GitLabProjectRepositoriesGetDivergingCommitsFilterBuilder.builder()
                        .maxCount(1)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("max_count", "1"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectRepositoriesGetDivergingCommitsFilter filter =
                GitLabProjectRepositoriesGetDivergingCommitsFilterBuilder.builder()
                        .maxCount(1)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("max_count", "1"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectRepositoriesGetDivergingCommitsFilter filter =
                GitLabProjectRepositoriesGetDivergingCommitsFilterBuilder.builder()
                        .maxCount(1)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

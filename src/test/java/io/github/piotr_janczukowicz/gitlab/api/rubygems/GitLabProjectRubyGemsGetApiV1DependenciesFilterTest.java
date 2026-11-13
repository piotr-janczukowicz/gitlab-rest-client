package io.github.piotr_janczukowicz.gitlab.api.rubygems;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectRubyGemsGetApiV1DependenciesFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenGemsIsNullable() {
        final GitLabProjectRubyGemsGetApiV1DependenciesFilterBuilder builder =
                GitLabProjectRubyGemsGetApiV1DependenciesFilterBuilder.builder(
                                GitLabProjectRubyGemsGetApiV1DependenciesFilterBuilder.builder()
                                        .gems(List.of("gems"))
                                        .build())
                        .gems(null);

        final GitLabProjectRubyGemsGetApiV1DependenciesFilter built = builder.build();

        assertThat(built.gems()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectRubyGemsGetApiV1DependenciesFilter value =
                GitLabProjectRubyGemsGetApiV1DependenciesFilterBuilder.builder()
                        .gems(List.of("gems"))
                        .build();

        assertThat(value.gems()).isEqualTo(List.of("gems"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectRubyGemsGetApiV1DependenciesFilter original =
                GitLabProjectRubyGemsGetApiV1DependenciesFilterBuilder.builder()
                        .gems(List.of("gems"))
                        .build();

        final GitLabProjectRubyGemsGetApiV1DependenciesFilter rebuilt =
                GitLabProjectRubyGemsGetApiV1DependenciesFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenGemsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("gems"));
        final GitLabProjectRubyGemsGetApiV1DependenciesFilter built =
                GitLabProjectRubyGemsGetApiV1DependenciesFilterBuilder.builder(
                                GitLabProjectRubyGemsGetApiV1DependenciesFilterBuilder.builder()
                                        .gems(List.of("gems"))
                                        .build())
                        .gems(source)
                        .build();
        source.clear();

        assertThat(built.gems()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenGemsIsRead() {
        final GitLabProjectRubyGemsGetApiV1DependenciesFilter built =
                GitLabProjectRubyGemsGetApiV1DependenciesFilterBuilder.builder()
                        .gems(List.of("gems"))
                        .build();
        final List<String> values = built.gems();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectRubyGemsGetApiV1DependenciesFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("gems");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectRubyGemsGetApiV1DependenciesFilter empty =
                GitLabProjectRubyGemsGetApiV1DependenciesFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectRubyGemsGetApiV1DependenciesFilter filter =
                GitLabProjectRubyGemsGetApiV1DependenciesFilterBuilder.builder()
                        .gems(List.of("gems"))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("gems", "gems"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectRubyGemsGetApiV1DependenciesFilter filter =
                GitLabProjectRubyGemsGetApiV1DependenciesFilterBuilder.builder()
                        .gems(List.of("gems"))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("gems", "gems"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectRubyGemsGetApiV1DependenciesFilter filter =
                GitLabProjectRubyGemsGetApiV1DependenciesFilterBuilder.builder()
                        .gems(List.of("gems"))
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

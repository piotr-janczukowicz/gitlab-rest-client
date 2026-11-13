package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectRepositoriesGetHealthFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenGenerateIsNullable() {
        final GitLabProjectRepositoriesGetHealthFilterBuilder builder =
                GitLabProjectRepositoriesGetHealthFilterBuilder.builder(
                                GitLabProjectRepositoriesGetHealthFilterBuilder.builder()
                                        .generate(true)
                                        .build())
                        .generate(null);

        final GitLabProjectRepositoriesGetHealthFilter built = builder.build();

        assertThat(built.generate()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectRepositoriesGetHealthFilter value = GitLabProjectRepositoriesGetHealthFilterBuilder.builder()
                .generate(true)
                .build();

        assertThat(value.generate()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectRepositoriesGetHealthFilter original =
                GitLabProjectRepositoriesGetHealthFilterBuilder.builder()
                        .generate(true)
                        .build();

        final GitLabProjectRepositoriesGetHealthFilter rebuilt =
                GitLabProjectRepositoriesGetHealthFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectRepositoriesGetHealthFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("generate");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectRepositoriesGetHealthFilter empty = GitLabProjectRepositoriesGetHealthFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectRepositoriesGetHealthFilter filter =
                GitLabProjectRepositoriesGetHealthFilterBuilder.builder()
                        .generate(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("generate", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectRepositoriesGetHealthFilter filter =
                GitLabProjectRepositoriesGetHealthFilterBuilder.builder()
                        .generate(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("generate", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectRepositoriesGetHealthFilter filter =
                GitLabProjectRepositoriesGetHealthFilterBuilder.builder()
                        .generate(true)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

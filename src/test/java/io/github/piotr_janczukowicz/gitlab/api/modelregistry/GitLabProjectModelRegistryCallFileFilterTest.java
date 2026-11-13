package io.github.piotr_janczukowicz.gitlab.api.modelregistry;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectModelRegistryCallFileFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabProjectModelRegistryCallFileFilterBuilder builder =
                GitLabProjectModelRegistryCallFileFilterBuilder.builder(
                                GitLabProjectModelRegistryCallFileFilterBuilder.builder()
                                        .status(GitLabProjectModelRegistryCallFileStatus.DEFAULT)
                                        .build())
                        .status(null);

        final GitLabProjectModelRegistryCallFileFilter built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectModelRegistryCallFileFilter value = GitLabProjectModelRegistryCallFileFilterBuilder.builder()
                .status(GitLabProjectModelRegistryCallFileStatus.DEFAULT)
                .build();

        assertThat(value.status()).isEqualTo(GitLabProjectModelRegistryCallFileStatus.DEFAULT);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectModelRegistryCallFileFilter original =
                GitLabProjectModelRegistryCallFileFilterBuilder.builder()
                        .status(GitLabProjectModelRegistryCallFileStatus.DEFAULT)
                        .build();

        final GitLabProjectModelRegistryCallFileFilter rebuilt =
                GitLabProjectModelRegistryCallFileFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectModelRegistryCallFileFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("status");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectModelRegistryCallFileFilter empty = GitLabProjectModelRegistryCallFileFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectModelRegistryCallFileFilter filter =
                GitLabProjectModelRegistryCallFileFilterBuilder.builder()
                        .status(GitLabProjectModelRegistryCallFileStatus.DEFAULT)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("status", "default"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectModelRegistryCallFileFilter filter =
                GitLabProjectModelRegistryCallFileFilterBuilder.builder()
                        .status(GitLabProjectModelRegistryCallFileStatus.DEFAULT)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("status", "default"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectModelRegistryCallFileFilter filter =
                GitLabProjectModelRegistryCallFileFilterBuilder.builder()
                        .status(GitLabProjectModelRegistryCallFileStatus.DEFAULT)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

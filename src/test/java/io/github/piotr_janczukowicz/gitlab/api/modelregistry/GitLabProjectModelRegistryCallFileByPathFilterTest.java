package io.github.piotr_janczukowicz.gitlab.api.modelregistry;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectModelRegistryCallFileByPathFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabProjectModelRegistryCallFileByPathFilterBuilder builder =
                GitLabProjectModelRegistryCallFileByPathFilterBuilder.builder(
                                GitLabProjectModelRegistryCallFileByPathFilterBuilder.builder()
                                        .status(GitLabProjectModelRegistryCallFileByPathStatus.DEFAULT)
                                        .build())
                        .status(null);

        final GitLabProjectModelRegistryCallFileByPathFilter built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectModelRegistryCallFileByPathFilter value =
                GitLabProjectModelRegistryCallFileByPathFilterBuilder.builder()
                        .status(GitLabProjectModelRegistryCallFileByPathStatus.DEFAULT)
                        .build();

        assertThat(value.status()).isEqualTo(GitLabProjectModelRegistryCallFileByPathStatus.DEFAULT);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectModelRegistryCallFileByPathFilter original =
                GitLabProjectModelRegistryCallFileByPathFilterBuilder.builder()
                        .status(GitLabProjectModelRegistryCallFileByPathStatus.DEFAULT)
                        .build();

        final GitLabProjectModelRegistryCallFileByPathFilter rebuilt =
                GitLabProjectModelRegistryCallFileByPathFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectModelRegistryCallFileByPathFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("status");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectModelRegistryCallFileByPathFilter empty =
                GitLabProjectModelRegistryCallFileByPathFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectModelRegistryCallFileByPathFilter filter =
                GitLabProjectModelRegistryCallFileByPathFilterBuilder.builder()
                        .status(GitLabProjectModelRegistryCallFileByPathStatus.DEFAULT)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("status", "default"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectModelRegistryCallFileByPathFilter filter =
                GitLabProjectModelRegistryCallFileByPathFilterBuilder.builder()
                        .status(GitLabProjectModelRegistryCallFileByPathStatus.DEFAULT)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("status", "default"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectModelRegistryCallFileByPathFilter filter =
                GitLabProjectModelRegistryCallFileByPathFilterBuilder.builder()
                        .status(GitLabProjectModelRegistryCallFileByPathStatus.DEFAULT)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPipelinesGetLatestFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabProjectPipelinesGetLatestFilterBuilder builder =
                GitLabProjectPipelinesGetLatestFilterBuilder.builder(
                                GitLabProjectPipelinesGetLatestFilterBuilder.builder()
                                        .ref("ref")
                                        .build())
                        .ref(null);

        final GitLabProjectPipelinesGetLatestFilter built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPipelinesGetLatestFilter value = GitLabProjectPipelinesGetLatestFilterBuilder.builder()
                .ref("ref")
                .build();

        assertThat(value.ref()).isEqualTo("ref");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPipelinesGetLatestFilter original = GitLabProjectPipelinesGetLatestFilterBuilder.builder()
                .ref("ref")
                .build();

        final GitLabProjectPipelinesGetLatestFilter rebuilt =
                GitLabProjectPipelinesGetLatestFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPipelinesGetLatestFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("ref");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectPipelinesGetLatestFilter empty = GitLabProjectPipelinesGetLatestFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectPipelinesGetLatestFilter filter = GitLabProjectPipelinesGetLatestFilterBuilder.builder()
                .ref("ref")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("ref", "ref"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectPipelinesGetLatestFilter filter = GitLabProjectPipelinesGetLatestFilterBuilder.builder()
                .ref("ref")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("ref", "ref"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectPipelinesGetLatestFilter filter = GitLabProjectPipelinesGetLatestFilterBuilder.builder()
                .ref("ref")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

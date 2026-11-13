package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsCallMlMlflowApiMlflowArtifactsArtifactsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabProjectProjectsCallMlMlflowApiMlflowArtifactsArtifactsFilterBuilder builder =
                GitLabProjectProjectsCallMlMlflowApiMlflowArtifactsArtifactsFilterBuilder.builder(
                                GitLabProjectProjectsCallMlMlflowApiMlflowArtifactsArtifactsFilterBuilder.builder()
                                        .path("path")
                                        .build())
                        .path(null);

        final GitLabProjectProjectsCallMlMlflowApiMlflowArtifactsArtifactsFilter built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsCallMlMlflowApiMlflowArtifactsArtifactsFilter value =
                GitLabProjectProjectsCallMlMlflowApiMlflowArtifactsArtifactsFilterBuilder.builder()
                        .path("path")
                        .build();

        assertThat(value.path()).isEqualTo("path");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsCallMlMlflowApiMlflowArtifactsArtifactsFilter original =
                GitLabProjectProjectsCallMlMlflowApiMlflowArtifactsArtifactsFilterBuilder.builder()
                        .path("path")
                        .build();

        final GitLabProjectProjectsCallMlMlflowApiMlflowArtifactsArtifactsFilter rebuilt =
                GitLabProjectProjectsCallMlMlflowApiMlflowArtifactsArtifactsFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsCallMlMlflowApiMlflowArtifactsArtifactsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("path");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectsCallMlMlflowApiMlflowArtifactsArtifactsFilter empty =
                GitLabProjectProjectsCallMlMlflowApiMlflowArtifactsArtifactsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectsCallMlMlflowApiMlflowArtifactsArtifactsFilter filter =
                GitLabProjectProjectsCallMlMlflowApiMlflowArtifactsArtifactsFilterBuilder.builder()
                        .path("path")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("path", "path"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectProjectsCallMlMlflowApiMlflowArtifactsArtifactsFilter filter =
                GitLabProjectProjectsCallMlMlflowApiMlflowArtifactsArtifactsFilterBuilder.builder()
                        .path("path")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("path", "path"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectsCallMlMlflowApiMlflowArtifactsArtifactsFilter filter =
                GitLabProjectProjectsCallMlMlflowApiMlflowArtifactsArtifactsFilterBuilder.builder()
                        .path("path")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

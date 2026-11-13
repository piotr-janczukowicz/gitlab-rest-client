package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsDeleteMlMlflowApiMlflowRegisteredModelsDeleteFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectProjectsDeleteMlMlflowApiMlflowRegisteredModelsDeleteFilterBuilder builder =
                GitLabProjectProjectsDeleteMlMlflowApiMlflowRegisteredModelsDeleteFilterBuilder.builder(
                                GitLabProjectProjectsDeleteMlMlflowApiMlflowRegisteredModelsDeleteFilterBuilder
                                        .builder()
                                        .name("name")
                                        .build())
                        .name(null);

        final GitLabProjectProjectsDeleteMlMlflowApiMlflowRegisteredModelsDeleteFilter built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsDeleteMlMlflowApiMlflowRegisteredModelsDeleteFilter value =
                GitLabProjectProjectsDeleteMlMlflowApiMlflowRegisteredModelsDeleteFilterBuilder.builder()
                        .name("name")
                        .build();

        assertThat(value.name()).isEqualTo("name");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsDeleteMlMlflowApiMlflowRegisteredModelsDeleteFilter original =
                GitLabProjectProjectsDeleteMlMlflowApiMlflowRegisteredModelsDeleteFilterBuilder.builder()
                        .name("name")
                        .build();

        final GitLabProjectProjectsDeleteMlMlflowApiMlflowRegisteredModelsDeleteFilter rebuilt =
                GitLabProjectProjectsDeleteMlMlflowApiMlflowRegisteredModelsDeleteFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsDeleteMlMlflowApiMlflowRegisteredModelsDeleteFilter.class
                                .getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectsDeleteMlMlflowApiMlflowRegisteredModelsDeleteFilter empty =
                GitLabProjectProjectsDeleteMlMlflowApiMlflowRegisteredModelsDeleteFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectsDeleteMlMlflowApiMlflowRegisteredModelsDeleteFilter filter =
                GitLabProjectProjectsDeleteMlMlflowApiMlflowRegisteredModelsDeleteFilterBuilder.builder()
                        .name("name")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("name", "name"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectProjectsDeleteMlMlflowApiMlflowRegisteredModelsDeleteFilter filter =
                GitLabProjectProjectsDeleteMlMlflowApiMlflowRegisteredModelsDeleteFilterBuilder.builder()
                        .name("name")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("name", "name"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectsDeleteMlMlflowApiMlflowRegisteredModelsDeleteFilter filter =
                GitLabProjectProjectsDeleteMlMlflowApiMlflowRegisteredModelsDeleteFilterBuilder.builder()
                        .name("name")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

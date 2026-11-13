package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilterBuilder builder =
                GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilterBuilder.builder(
                                GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilterBuilder.builder()
                                        .name("name")
                                        .alias("alias")
                                        .build())
                        .name(null);

        final GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilter built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAliasIsNullable() {
        final GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilterBuilder builder =
                GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilterBuilder.builder(
                                GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilterBuilder.builder()
                                        .name("name")
                                        .alias("alias")
                                        .build())
                        .alias(null);

        final GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilter built = builder.build();

        assertThat(built.alias()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilter value =
                GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilterBuilder.builder()
                        .name("name")
                        .alias("alias")
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.alias()).isEqualTo("alias");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilter original =
                GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilterBuilder.builder()
                        .name("name")
                        .alias("alias")
                        .build();

        final GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilter rebuilt =
                GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilter.class
                                .getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "alias");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilter empty =
                GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilter filter =
                GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilterBuilder.builder()
                        .name("name")
                        .alias("alias")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("name", "name"), Map.entry("alias", "alias"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilter filter =
                GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilterBuilder.builder()
                        .name("name")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("name", "name"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilter filter =
                GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilterBuilder.builder()
                        .name("name")
                        .alias("alias")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

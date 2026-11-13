package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsGetFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenStatisticsIsNullable() {
        final GitLabProjectProjectsGetFilterBuilder builder = GitLabProjectProjectsGetFilterBuilder.builder(
                        GitLabProjectProjectsGetFilterBuilder.builder()
                                .statistics(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .license(true)
                                .build())
                .statistics(null);

        final GitLabProjectProjectsGetFilter built = builder.build();

        assertThat(built.statistics()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithCustomAttributesIsNullable() {
        final GitLabProjectProjectsGetFilterBuilder builder = GitLabProjectProjectsGetFilterBuilder.builder(
                        GitLabProjectProjectsGetFilterBuilder.builder()
                                .statistics(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .license(true)
                                .build())
                .withCustomAttributes(null);

        final GitLabProjectProjectsGetFilter built = builder.build();

        assertThat(built.withCustomAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabProjectProjectsGetFilterBuilder builder = GitLabProjectProjectsGetFilterBuilder.builder(
                        GitLabProjectProjectsGetFilterBuilder.builder()
                                .statistics(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .license(true)
                                .build())
                .customAttributes(null);

        final GitLabProjectProjectsGetFilter built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLicenseIsNullable() {
        final GitLabProjectProjectsGetFilterBuilder builder = GitLabProjectProjectsGetFilterBuilder.builder(
                        GitLabProjectProjectsGetFilterBuilder.builder()
                                .statistics(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .license(true)
                                .build())
                .license(null);

        final GitLabProjectProjectsGetFilter built = builder.build();

        assertThat(built.license()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsGetFilter value = GitLabProjectProjectsGetFilterBuilder.builder()
                .statistics(true)
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .license(true)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.statistics()).isEqualTo(true);
            softly.assertThat(value.withCustomAttributes()).isEqualTo(true);
            softly.assertThat(value.customAttributes()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.license()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsGetFilter original = GitLabProjectProjectsGetFilterBuilder.builder()
                .statistics(true)
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .license(true)
                .build();

        final GitLabProjectProjectsGetFilter rebuilt =
                GitLabProjectProjectsGetFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenCustomAttributesSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabProjectProjectsGetFilter built = GitLabProjectProjectsGetFilterBuilder.builder(
                        GitLabProjectProjectsGetFilterBuilder.builder()
                                .statistics(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .license(true)
                                .build())
                .customAttributes(source)
                .build();
        source.clear();

        assertThat(built.customAttributes()).isNotEmpty();
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectsGetFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("statistics", "withCustomAttributes", "customAttributes", "license");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectsGetFilter empty = GitLabProjectProjectsGetFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectsGetFilter filter = GitLabProjectProjectsGetFilterBuilder.builder()
                .statistics(true)
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .license(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("statistics", "true"),
                        Map.entry("with_custom_attributes", "true"),
                        Map.entry("custom_attributes[key]", "value"),
                        Map.entry("license", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectProjectsGetFilter filter =
                GitLabProjectProjectsGetFilterBuilder.builder().statistics(true).build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("statistics", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectsGetFilter filter = GitLabProjectProjectsGetFilterBuilder.builder()
                .statistics(true)
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .license(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

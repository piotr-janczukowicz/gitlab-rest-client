package io.github.piotr_janczukowicz.gitlab.api.groups;

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
class GitLabGroupGroupsGetFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenWithCustomAttributesIsNullable() {
        final GitLabGroupGroupsGetFilterBuilder builder = GitLabGroupGroupsGetFilterBuilder.builder(
                        GitLabGroupGroupsGetFilterBuilder.builder()
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .withProjects(true)
                                .build())
                .withCustomAttributes(null);

        final GitLabGroupGroupsGetFilter built = builder.build();

        assertThat(built.withCustomAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabGroupGroupsGetFilterBuilder builder = GitLabGroupGroupsGetFilterBuilder.builder(
                        GitLabGroupGroupsGetFilterBuilder.builder()
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .withProjects(true)
                                .build())
                .customAttributes(null);

        final GitLabGroupGroupsGetFilter built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithProjectsIsNullable() {
        final GitLabGroupGroupsGetFilterBuilder builder = GitLabGroupGroupsGetFilterBuilder.builder(
                        GitLabGroupGroupsGetFilterBuilder.builder()
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .withProjects(true)
                                .build())
                .withProjects(null);

        final GitLabGroupGroupsGetFilter built = builder.build();

        assertThat(built.withProjects()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsGetFilter value = GitLabGroupGroupsGetFilterBuilder.builder()
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .withProjects(true)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.withCustomAttributes()).isEqualTo(true);
            softly.assertThat(value.customAttributes()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.withProjects()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupsGetFilter original = GitLabGroupGroupsGetFilterBuilder.builder()
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .withProjects(true)
                .build();

        final GitLabGroupGroupsGetFilter rebuilt =
                GitLabGroupGroupsGetFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenCustomAttributesSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabGroupGroupsGetFilter built = GitLabGroupGroupsGetFilterBuilder.builder(
                        GitLabGroupGroupsGetFilterBuilder.builder()
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .withProjects(true)
                                .build())
                .customAttributes(source)
                .build();
        source.clear();

        assertThat(built.customAttributes()).isNotEmpty();
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupsGetFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("withCustomAttributes", "customAttributes", "withProjects");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupGroupsGetFilter empty = GitLabGroupGroupsGetFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupGroupsGetFilter filter = GitLabGroupGroupsGetFilterBuilder.builder()
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .withProjects(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("with_custom_attributes", "true"),
                        Map.entry("custom_attributes[key]", "value"),
                        Map.entry("with_projects", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupGroupsGetFilter filter = GitLabGroupGroupsGetFilterBuilder.builder()
                .withCustomAttributes(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("with_custom_attributes", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupGroupsGetFilter filter = GitLabGroupGroupsGetFilterBuilder.builder()
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .withProjects(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

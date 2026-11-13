package io.github.piotr_janczukowicz.gitlab.api.containerregistry;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectContainerRegistryDeleteTagFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenNameRegexDeleteIsNullable() {
        final GitLabProjectContainerRegistryDeleteTagFilterBuilder builder =
                GitLabProjectContainerRegistryDeleteTagFilterBuilder.builder(
                                GitLabProjectContainerRegistryDeleteTagFilterBuilder.builder()
                                        .nameRegexDelete("name_regex_delete")
                                        .nameRegex("name_regex")
                                        .nameRegexKeep("name_regex_keep")
                                        .keepN(1)
                                        .olderThan("older_than")
                                        .build())
                        .nameRegexDelete(null);

        final GitLabProjectContainerRegistryDeleteTagFilter built = builder.build();

        assertThat(built.nameRegexDelete()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameRegexIsNullable() {
        final GitLabProjectContainerRegistryDeleteTagFilterBuilder builder =
                GitLabProjectContainerRegistryDeleteTagFilterBuilder.builder(
                                GitLabProjectContainerRegistryDeleteTagFilterBuilder.builder()
                                        .nameRegexDelete("name_regex_delete")
                                        .nameRegex("name_regex")
                                        .nameRegexKeep("name_regex_keep")
                                        .keepN(1)
                                        .olderThan("older_than")
                                        .build())
                        .nameRegex(null);

        final GitLabProjectContainerRegistryDeleteTagFilter built = builder.build();

        assertThat(built.nameRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameRegexKeepIsNullable() {
        final GitLabProjectContainerRegistryDeleteTagFilterBuilder builder =
                GitLabProjectContainerRegistryDeleteTagFilterBuilder.builder(
                                GitLabProjectContainerRegistryDeleteTagFilterBuilder.builder()
                                        .nameRegexDelete("name_regex_delete")
                                        .nameRegex("name_regex")
                                        .nameRegexKeep("name_regex_keep")
                                        .keepN(1)
                                        .olderThan("older_than")
                                        .build())
                        .nameRegexKeep(null);

        final GitLabProjectContainerRegistryDeleteTagFilter built = builder.build();

        assertThat(built.nameRegexKeep()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeepNIsNullable() {
        final GitLabProjectContainerRegistryDeleteTagFilterBuilder builder =
                GitLabProjectContainerRegistryDeleteTagFilterBuilder.builder(
                                GitLabProjectContainerRegistryDeleteTagFilterBuilder.builder()
                                        .nameRegexDelete("name_regex_delete")
                                        .nameRegex("name_regex")
                                        .nameRegexKeep("name_regex_keep")
                                        .keepN(1)
                                        .olderThan("older_than")
                                        .build())
                        .keepN(null);

        final GitLabProjectContainerRegistryDeleteTagFilter built = builder.build();

        assertThat(built.keepN()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOlderThanIsNullable() {
        final GitLabProjectContainerRegistryDeleteTagFilterBuilder builder =
                GitLabProjectContainerRegistryDeleteTagFilterBuilder.builder(
                                GitLabProjectContainerRegistryDeleteTagFilterBuilder.builder()
                                        .nameRegexDelete("name_regex_delete")
                                        .nameRegex("name_regex")
                                        .nameRegexKeep("name_regex_keep")
                                        .keepN(1)
                                        .olderThan("older_than")
                                        .build())
                        .olderThan(null);

        final GitLabProjectContainerRegistryDeleteTagFilter built = builder.build();

        assertThat(built.olderThan()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectContainerRegistryDeleteTagFilter value =
                GitLabProjectContainerRegistryDeleteTagFilterBuilder.builder()
                        .nameRegexDelete("name_regex_delete")
                        .nameRegex("name_regex")
                        .nameRegexKeep("name_regex_keep")
                        .keepN(1)
                        .olderThan("older_than")
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.nameRegexDelete()).isEqualTo("name_regex_delete");
            softly.assertThat(value.nameRegex()).isEqualTo("name_regex");
            softly.assertThat(value.nameRegexKeep()).isEqualTo("name_regex_keep");
            softly.assertThat(value.keepN()).isEqualTo(1);
            softly.assertThat(value.olderThan()).isEqualTo("older_than");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectContainerRegistryDeleteTagFilter original =
                GitLabProjectContainerRegistryDeleteTagFilterBuilder.builder()
                        .nameRegexDelete("name_regex_delete")
                        .nameRegex("name_regex")
                        .nameRegexKeep("name_regex_keep")
                        .keepN(1)
                        .olderThan("older_than")
                        .build();

        final GitLabProjectContainerRegistryDeleteTagFilter rebuilt =
                GitLabProjectContainerRegistryDeleteTagFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectContainerRegistryDeleteTagFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("nameRegexDelete", "nameRegex", "nameRegexKeep", "keepN", "olderThan");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectContainerRegistryDeleteTagFilter empty =
                GitLabProjectContainerRegistryDeleteTagFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectContainerRegistryDeleteTagFilter filter =
                GitLabProjectContainerRegistryDeleteTagFilterBuilder.builder()
                        .nameRegexDelete("name_regex_delete")
                        .nameRegex("name_regex")
                        .nameRegexKeep("name_regex_keep")
                        .keepN(1)
                        .olderThan("older_than")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("name_regex_delete", "name_regex_delete"),
                        Map.entry("name_regex", "name_regex"),
                        Map.entry("name_regex_keep", "name_regex_keep"),
                        Map.entry("keep_n", "1"),
                        Map.entry("older_than", "older_than"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectContainerRegistryDeleteTagFilter filter =
                GitLabProjectContainerRegistryDeleteTagFilterBuilder.builder()
                        .nameRegexDelete("name_regex_delete")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("name_regex_delete", "name_regex_delete"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectContainerRegistryDeleteTagFilter filter =
                GitLabProjectContainerRegistryDeleteTagFilterBuilder.builder()
                        .nameRegexDelete("name_regex_delete")
                        .nameRegex("name_regex")
                        .nameRegexKeep("name_regex_keep")
                        .keepN(1)
                        .olderThan("older_than")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

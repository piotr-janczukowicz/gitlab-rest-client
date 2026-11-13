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
class GitLabProjectContainerRegistryGetFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenTagsIsNullable() {
        final GitLabProjectContainerRegistryGetFilterBuilder builder =
                GitLabProjectContainerRegistryGetFilterBuilder.builder(
                                GitLabProjectContainerRegistryGetFilterBuilder.builder()
                                        .tags(true)
                                        .tagsCount(true)
                                        .size(true)
                                        .build())
                        .tags(null);

        final GitLabProjectContainerRegistryGetFilter built = builder.build();

        assertThat(built.tags()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagsCountIsNullable() {
        final GitLabProjectContainerRegistryGetFilterBuilder builder =
                GitLabProjectContainerRegistryGetFilterBuilder.builder(
                                GitLabProjectContainerRegistryGetFilterBuilder.builder()
                                        .tags(true)
                                        .tagsCount(true)
                                        .size(true)
                                        .build())
                        .tagsCount(null);

        final GitLabProjectContainerRegistryGetFilter built = builder.build();

        assertThat(built.tagsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSizeIsNullable() {
        final GitLabProjectContainerRegistryGetFilterBuilder builder =
                GitLabProjectContainerRegistryGetFilterBuilder.builder(
                                GitLabProjectContainerRegistryGetFilterBuilder.builder()
                                        .tags(true)
                                        .tagsCount(true)
                                        .size(true)
                                        .build())
                        .size(null);

        final GitLabProjectContainerRegistryGetFilter built = builder.build();

        assertThat(built.size()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectContainerRegistryGetFilter value = GitLabProjectContainerRegistryGetFilterBuilder.builder()
                .tags(true)
                .tagsCount(true)
                .size(true)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.tags()).isEqualTo(true);
            softly.assertThat(value.tagsCount()).isEqualTo(true);
            softly.assertThat(value.size()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectContainerRegistryGetFilter original =
                GitLabProjectContainerRegistryGetFilterBuilder.builder()
                        .tags(true)
                        .tagsCount(true)
                        .size(true)
                        .build();

        final GitLabProjectContainerRegistryGetFilter rebuilt =
                GitLabProjectContainerRegistryGetFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectContainerRegistryGetFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("tags", "tagsCount", "size");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectContainerRegistryGetFilter empty = GitLabProjectContainerRegistryGetFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectContainerRegistryGetFilter filter = GitLabProjectContainerRegistryGetFilterBuilder.builder()
                .tags(true)
                .tagsCount(true)
                .size(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(Map.entry("tags", "true"), Map.entry("tags_count", "true"), Map.entry("size", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectContainerRegistryGetFilter filter = GitLabProjectContainerRegistryGetFilterBuilder.builder()
                .tags(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("tags", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectContainerRegistryGetFilter filter = GitLabProjectContainerRegistryGetFilterBuilder.builder()
                .tags(true)
                .tagsCount(true)
                .size(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

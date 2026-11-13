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
class GitLabProjectContainerRegistryListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenTagsIsNullable() {
        final GitLabProjectContainerRegistryListFilterBuilder builder =
                GitLabProjectContainerRegistryListFilterBuilder.builder(
                                GitLabProjectContainerRegistryListFilterBuilder.builder()
                                        .tags(true)
                                        .tagsCount(true)
                                        .build())
                        .tags(null);

        final GitLabProjectContainerRegistryListFilter built = builder.build();

        assertThat(built.tags()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagsCountIsNullable() {
        final GitLabProjectContainerRegistryListFilterBuilder builder =
                GitLabProjectContainerRegistryListFilterBuilder.builder(
                                GitLabProjectContainerRegistryListFilterBuilder.builder()
                                        .tags(true)
                                        .tagsCount(true)
                                        .build())
                        .tagsCount(null);

        final GitLabProjectContainerRegistryListFilter built = builder.build();

        assertThat(built.tagsCount()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectContainerRegistryListFilter value = GitLabProjectContainerRegistryListFilterBuilder.builder()
                .tags(true)
                .tagsCount(true)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.tags()).isEqualTo(true);
            softly.assertThat(value.tagsCount()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectContainerRegistryListFilter original =
                GitLabProjectContainerRegistryListFilterBuilder.builder()
                        .tags(true)
                        .tagsCount(true)
                        .build();

        final GitLabProjectContainerRegistryListFilter rebuilt =
                GitLabProjectContainerRegistryListFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectContainerRegistryListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("tags", "tagsCount");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectContainerRegistryListFilter empty = GitLabProjectContainerRegistryListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectContainerRegistryListFilter filter =
                GitLabProjectContainerRegistryListFilterBuilder.builder()
                        .tags(true)
                        .tagsCount(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("tags", "true"), Map.entry("tags_count", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectContainerRegistryListFilter filter =
                GitLabProjectContainerRegistryListFilterBuilder.builder()
                        .tags(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("tags", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectContainerRegistryListFilter filter =
                GitLabProjectContainerRegistryListFilterBuilder.builder()
                        .tags(true)
                        .tagsCount(true)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}

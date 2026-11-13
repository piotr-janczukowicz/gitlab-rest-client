package io.github.piotr_janczukowicz.gitlab.api.gitlabduochatcompletions;

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
class GitLabDuoChatCompletionsCreateAdditionalContextTest {

    @Test
    void constructor_shouldRefuseNull_whenCategoryIsNull() {
        final GitLabDuoChatCompletionsCreateAdditionalContextBuilder builder =
                GitLabDuoChatCompletionsCreateAdditionalContextBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreateAdditionalContext())
                        .category(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("category");
    }

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabDuoChatCompletionsCreateAdditionalContextBuilder builder =
                GitLabDuoChatCompletionsCreateAdditionalContextBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreateAdditionalContext())
                        .id(null);

        final GitLabDuoChatCompletionsCreateAdditionalContext built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenIdIsTooLong() {
        final GitLabDuoChatCompletionsCreateAdditionalContextBuilder builder =
                GitLabDuoChatCompletionsCreateAdditionalContextBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreateAdditionalContext())
                        .id("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenIdHasTheMaximumLength() {
        final GitLabDuoChatCompletionsCreateAdditionalContextBuilder builder =
                GitLabDuoChatCompletionsCreateAdditionalContextBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreateAdditionalContext())
                        .id("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabDuoChatCompletionsCreateAdditionalContextBuilder builder =
                GitLabDuoChatCompletionsCreateAdditionalContextBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreateAdditionalContext())
                        .content(null);

        final GitLabDuoChatCompletionsCreateAdditionalContext built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenContentIsTooLong() {
        final GitLabDuoChatCompletionsCreateAdditionalContextBuilder builder =
                GitLabDuoChatCompletionsCreateAdditionalContextBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreateAdditionalContext())
                        .content("x".repeat(1001));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenContentHasTheMaximumLength() {
        final GitLabDuoChatCompletionsCreateAdditionalContextBuilder builder =
                GitLabDuoChatCompletionsCreateAdditionalContextBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreateAdditionalContext())
                        .content("x".repeat(1000));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMetadataIsNullable() {
        final GitLabDuoChatCompletionsCreateAdditionalContextBuilder builder =
                GitLabDuoChatCompletionsCreateAdditionalContextBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreateAdditionalContext())
                        .metadata(null);

        final GitLabDuoChatCompletionsCreateAdditionalContext built = builder.build();

        assertThat(built.metadata()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoChatCompletionsCreateAdditionalContext value =
                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreateAdditionalContext();

        assertSoftly(softly -> {
            softly.assertThat(value.category()).isEqualTo(GitLabDuoChatCompletionsCreateAdditionalContextCategory.FILE);
            softly.assertThat(value.id()).isEqualTo("id");
            softly.assertThat(value.content()).isEqualTo("content");
            softly.assertThat(value.metadata()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoChatCompletionsCreateAdditionalContext original =
                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreateAdditionalContext();

        final GitLabDuoChatCompletionsCreateAdditionalContext rebuilt =
                GitLabDuoChatCompletionsCreateAdditionalContextBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenMetadataSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabDuoChatCompletionsCreateAdditionalContext built =
                GitLabDuoChatCompletionsCreateAdditionalContextBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreateAdditionalContext())
                        .metadata(source)
                        .build();
        source.clear();

        assertThat(built.metadata()).isNotEmpty();
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabDuoChatCompletionsCreateAdditionalContext.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("category", "id", "content", "metadata");
    }
}

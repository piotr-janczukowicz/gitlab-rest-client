package io.github.piotr_janczukowicz.gitlab.api.gitlabduochatcompletions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDuoChatCompletionsCreateCurrentFileTest {

    @Test
    void constructor_shouldAcceptNull_whenFileNameIsNullable() {
        final GitLabDuoChatCompletionsCreateCurrentFileBuilder builder =
                GitLabDuoChatCompletionsCreateCurrentFileBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreateCurrentFile())
                        .fileName(null);

        final GitLabDuoChatCompletionsCreateCurrentFile built = builder.build();

        assertThat(built.fileName()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenFileNameIsTooLong() {
        final GitLabDuoChatCompletionsCreateCurrentFileBuilder builder =
                GitLabDuoChatCompletionsCreateCurrentFileBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreateCurrentFile())
                        .fileName("x".repeat(1001));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenFileNameHasTheMaximumLength() {
        final GitLabDuoChatCompletionsCreateCurrentFileBuilder builder =
                GitLabDuoChatCompletionsCreateCurrentFileBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreateCurrentFile())
                        .fileName("x".repeat(1000));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContentAboveCursorIsNullable() {
        final GitLabDuoChatCompletionsCreateCurrentFileBuilder builder =
                GitLabDuoChatCompletionsCreateCurrentFileBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreateCurrentFile())
                        .contentAboveCursor(null);

        final GitLabDuoChatCompletionsCreateCurrentFile built = builder.build();

        assertThat(built.contentAboveCursor()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContentBelowCursorIsNullable() {
        final GitLabDuoChatCompletionsCreateCurrentFileBuilder builder =
                GitLabDuoChatCompletionsCreateCurrentFileBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreateCurrentFile())
                        .contentBelowCursor(null);

        final GitLabDuoChatCompletionsCreateCurrentFile built = builder.build();

        assertThat(built.contentBelowCursor()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectedTextIsNullable() {
        final GitLabDuoChatCompletionsCreateCurrentFileBuilder builder =
                GitLabDuoChatCompletionsCreateCurrentFileBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreateCurrentFile())
                        .selectedText(null);

        final GitLabDuoChatCompletionsCreateCurrentFile built = builder.build();

        assertThat(built.selectedText()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoChatCompletionsCreateCurrentFile value =
                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreateCurrentFile();

        assertSoftly(softly -> {
            softly.assertThat(value.fileName()).isEqualTo("file_name");
            softly.assertThat(value.contentAboveCursor()).isEqualTo("content_above_cursor");
            softly.assertThat(value.contentBelowCursor()).isEqualTo("content_below_cursor");
            softly.assertThat(value.selectedText()).isEqualTo("selected_text");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoChatCompletionsCreateCurrentFile original =
                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreateCurrentFile();

        final GitLabDuoChatCompletionsCreateCurrentFile rebuilt =
                GitLabDuoChatCompletionsCreateCurrentFileBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDuoChatCompletionsCreateCurrentFile.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("fileName", "contentAboveCursor", "contentBelowCursor", "selectedText");
    }
}

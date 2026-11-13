package io.github.piotr_janczukowicz.gitlab.api.codesuggestions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCodeSuggestionsCreateCompletionCurrentFileTest {

    @Test
    void constructor_shouldAcceptNull_whenFileNameIsNullable() {
        final GitLabCodeSuggestionsCreateCompletionCurrentFileBuilder builder =
                GitLabCodeSuggestionsCreateCompletionCurrentFileBuilder.builder(
                                CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionCurrentFile())
                        .fileName(null);

        final GitLabCodeSuggestionsCreateCompletionCurrentFile built = builder.build();

        assertThat(built.fileName()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenFileNameIsTooLong() {
        final GitLabCodeSuggestionsCreateCompletionCurrentFileBuilder builder =
                GitLabCodeSuggestionsCreateCompletionCurrentFileBuilder.builder(
                                CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionCurrentFile())
                        .fileName("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenFileNameHasTheMaximumLength() {
        final GitLabCodeSuggestionsCreateCompletionCurrentFileBuilder builder =
                GitLabCodeSuggestionsCreateCompletionCurrentFileBuilder.builder(
                                CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionCurrentFile())
                        .fileName("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContentAboveCursorIsNullable() {
        final GitLabCodeSuggestionsCreateCompletionCurrentFileBuilder builder =
                GitLabCodeSuggestionsCreateCompletionCurrentFileBuilder.builder(
                                CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionCurrentFile())
                        .contentAboveCursor(null);

        final GitLabCodeSuggestionsCreateCompletionCurrentFile built = builder.build();

        assertThat(built.contentAboveCursor()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContentBelowCursorIsNullable() {
        final GitLabCodeSuggestionsCreateCompletionCurrentFileBuilder builder =
                GitLabCodeSuggestionsCreateCompletionCurrentFileBuilder.builder(
                                CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionCurrentFile())
                        .contentBelowCursor(null);

        final GitLabCodeSuggestionsCreateCompletionCurrentFile built = builder.build();

        assertThat(built.contentBelowCursor()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCodeSuggestionsCreateCompletionCurrentFile value =
                CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionCurrentFile();

        assertSoftly(softly -> {
            softly.assertThat(value.fileName()).isEqualTo("file_name");
            softly.assertThat(value.contentAboveCursor()).isEqualTo("content_above_cursor");
            softly.assertThat(value.contentBelowCursor()).isEqualTo("content_below_cursor");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCodeSuggestionsCreateCompletionCurrentFile original =
                CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionCurrentFile();

        final GitLabCodeSuggestionsCreateCompletionCurrentFile rebuilt =
                GitLabCodeSuggestionsCreateCompletionCurrentFileBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabCodeSuggestionsCreateCompletionCurrentFile.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("fileName", "contentAboveCursor", "contentBelowCursor");
    }
}

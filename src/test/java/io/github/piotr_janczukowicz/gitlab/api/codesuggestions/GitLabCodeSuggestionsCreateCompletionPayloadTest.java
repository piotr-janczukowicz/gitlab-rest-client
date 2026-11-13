package io.github.piotr_janczukowicz.gitlab.api.codesuggestions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCodeSuggestionsCreateCompletionPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenCurrentFileIsNullable() {
        final GitLabCodeSuggestionsCreateCompletionPayloadBuilder builder =
                GitLabCodeSuggestionsCreateCompletionPayloadBuilder.builder(
                                CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionPayload())
                        .currentFile(null);

        final GitLabCodeSuggestionsCreateCompletionPayload built = builder.build();

        assertThat(built.currentFile()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIntentIsNullable() {
        final GitLabCodeSuggestionsCreateCompletionPayloadBuilder builder =
                GitLabCodeSuggestionsCreateCompletionPayloadBuilder.builder(
                                CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionPayload())
                        .intent(null);

        final GitLabCodeSuggestionsCreateCompletionPayload built = builder.build();

        assertThat(built.intent()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGenerationTypeIsNullable() {
        final GitLabCodeSuggestionsCreateCompletionPayloadBuilder builder =
                GitLabCodeSuggestionsCreateCompletionPayloadBuilder.builder(
                                CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionPayload())
                        .generationType(null);

        final GitLabCodeSuggestionsCreateCompletionPayload built = builder.build();

        assertThat(built.generationType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStreamIsNullable() {
        final GitLabCodeSuggestionsCreateCompletionPayloadBuilder builder =
                GitLabCodeSuggestionsCreateCompletionPayloadBuilder.builder(
                        CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionPayload())
                        .stream((Boolean) null);

        final GitLabCodeSuggestionsCreateCompletionPayload built = builder.build();

        assertThat(built.stream()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectPathIsNullable() {
        final GitLabCodeSuggestionsCreateCompletionPayloadBuilder builder =
                GitLabCodeSuggestionsCreateCompletionPayloadBuilder.builder(
                                CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionPayload())
                        .projectPath(null);

        final GitLabCodeSuggestionsCreateCompletionPayload built = builder.build();

        assertThat(built.projectPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserInstructionIsNullable() {
        final GitLabCodeSuggestionsCreateCompletionPayloadBuilder builder =
                GitLabCodeSuggestionsCreateCompletionPayloadBuilder.builder(
                                CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionPayload())
                        .userInstruction(null);

        final GitLabCodeSuggestionsCreateCompletionPayload built = builder.build();

        assertThat(built.userInstruction()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContextIsNullable() {
        final GitLabCodeSuggestionsCreateCompletionPayloadBuilder builder =
                GitLabCodeSuggestionsCreateCompletionPayloadBuilder.builder(
                                CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionPayload())
                        .context(null);

        final GitLabCodeSuggestionsCreateCompletionPayload built = builder.build();

        assertThat(built.context()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCodeSuggestionsCreateCompletionPayload value =
                CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.currentFile())
                    .isEqualTo(CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionCurrentFile());
            softly.assertThat(value.intent()).isEqualTo(GitLabCodeSuggestionsCreateCompletionIntent.COMPLETION);
            softly.assertThat(value.generationType())
                    .isEqualTo(GitLabCodeSuggestionsCreateCompletionGenerationType.COMMENT);
            softly.assertThat(value.stream()).isEqualTo(true);
            softly.assertThat(value.projectPath()).isEqualTo("namespace/project");
            softly.assertThat(value.userInstruction()).isEqualTo("user_instruction");
            softly.assertThat(value.context())
                    .isEqualTo(List.of(CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionContext()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCodeSuggestionsCreateCompletionPayload original =
                CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionPayload();

        final GitLabCodeSuggestionsCreateCompletionPayload rebuilt =
                GitLabCodeSuggestionsCreateCompletionPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenContextSourceChangesLater() {
        final List<GitLabCodeSuggestionsCreateCompletionContext> source =
                new ArrayList<>(List.of(CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionContext()));
        final GitLabCodeSuggestionsCreateCompletionPayload built =
                GitLabCodeSuggestionsCreateCompletionPayloadBuilder.builder(
                                CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionPayload())
                        .context(source)
                        .build();
        source.clear();

        assertThat(built.context()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenContextIsRead() {
        final GitLabCodeSuggestionsCreateCompletionPayload built =
                CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionPayload();
        final List<GitLabCodeSuggestionsCreateCompletionContext> values = built.context();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCodeSuggestionsCreateCompletionPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "currentFile",
                        "intent",
                        "generationType",
                        "stream",
                        "projectPath",
                        "userInstruction",
                        "context");
    }
}

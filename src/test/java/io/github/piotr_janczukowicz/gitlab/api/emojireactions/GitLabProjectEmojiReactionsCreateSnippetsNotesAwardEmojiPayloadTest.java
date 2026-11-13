package io.github.piotr_janczukowicz.gitlab.api.emojireactions;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectEmojiReactionsCreateSnippetsNotesAwardEmojiPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectEmojiReactionsCreateSnippetsNotesAwardEmojiPayloadBuilder builder =
                GitLabProjectEmojiReactionsCreateSnippetsNotesAwardEmojiPayloadBuilder.builder(
                                EmojireactionsCatalogFixtures
                                        .projectEmojiReactionsCreateSnippetsNotesAwardEmojiPayload())
                        .name(null);

        final GitLabProjectEmojiReactionsCreateSnippetsNotesAwardEmojiPayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectEmojiReactionsCreateSnippetsNotesAwardEmojiPayload value =
                EmojireactionsCatalogFixtures.projectEmojiReactionsCreateSnippetsNotesAwardEmojiPayload();

        assertThat(value.name()).isEqualTo("name");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectEmojiReactionsCreateSnippetsNotesAwardEmojiPayload original =
                EmojireactionsCatalogFixtures.projectEmojiReactionsCreateSnippetsNotesAwardEmojiPayload();

        final GitLabProjectEmojiReactionsCreateSnippetsNotesAwardEmojiPayload rebuilt =
                GitLabProjectEmojiReactionsCreateSnippetsNotesAwardEmojiPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectEmojiReactionsCreateSnippetsNotesAwardEmojiPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name");
    }
}

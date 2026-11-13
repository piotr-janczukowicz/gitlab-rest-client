package io.github.piotr_janczukowicz.gitlab.api.emojireactions;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectEmojiReactionsCreateSnippetsAwardEmojiPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectEmojiReactionsCreateSnippetsAwardEmojiPayloadBuilder builder =
                GitLabProjectEmojiReactionsCreateSnippetsAwardEmojiPayloadBuilder.builder(
                                EmojireactionsCatalogFixtures.projectEmojiReactionsCreateSnippetsAwardEmojiPayload())
                        .name(null);

        final GitLabProjectEmojiReactionsCreateSnippetsAwardEmojiPayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectEmojiReactionsCreateSnippetsAwardEmojiPayload value =
                EmojireactionsCatalogFixtures.projectEmojiReactionsCreateSnippetsAwardEmojiPayload();

        assertThat(value.name()).isEqualTo("name");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectEmojiReactionsCreateSnippetsAwardEmojiPayload original =
                EmojireactionsCatalogFixtures.projectEmojiReactionsCreateSnippetsAwardEmojiPayload();

        final GitLabProjectEmojiReactionsCreateSnippetsAwardEmojiPayload rebuilt =
                GitLabProjectEmojiReactionsCreateSnippetsAwardEmojiPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectEmojiReactionsCreateSnippetsAwardEmojiPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name");
    }
}

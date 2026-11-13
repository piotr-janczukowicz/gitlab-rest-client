package io.github.piotr_janczukowicz.gitlab.api.emojireactions;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectEmojiReactionsCreateIssuesNotesAwardEmojiPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectEmojiReactionsCreateIssuesNotesAwardEmojiPayloadBuilder builder =
                GitLabProjectEmojiReactionsCreateIssuesNotesAwardEmojiPayloadBuilder.builder(
                                EmojireactionsCatalogFixtures.projectEmojiReactionsCreateIssuesNotesAwardEmojiPayload())
                        .name(null);

        final GitLabProjectEmojiReactionsCreateIssuesNotesAwardEmojiPayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectEmojiReactionsCreateIssuesNotesAwardEmojiPayload value =
                EmojireactionsCatalogFixtures.projectEmojiReactionsCreateIssuesNotesAwardEmojiPayload();

        assertThat(value.name()).isEqualTo("name");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectEmojiReactionsCreateIssuesNotesAwardEmojiPayload original =
                EmojireactionsCatalogFixtures.projectEmojiReactionsCreateIssuesNotesAwardEmojiPayload();

        final GitLabProjectEmojiReactionsCreateIssuesNotesAwardEmojiPayload rebuilt =
                GitLabProjectEmojiReactionsCreateIssuesNotesAwardEmojiPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectEmojiReactionsCreateIssuesNotesAwardEmojiPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name");
    }
}

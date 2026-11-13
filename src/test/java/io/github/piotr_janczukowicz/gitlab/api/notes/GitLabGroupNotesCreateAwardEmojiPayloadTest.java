package io.github.piotr_janczukowicz.gitlab.api.notes;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupNotesCreateAwardEmojiPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupNotesCreateAwardEmojiPayloadBuilder builder =
                GitLabGroupNotesCreateAwardEmojiPayloadBuilder.builder(
                                NotesCatalogFixtures.groupNotesCreateAwardEmojiPayload())
                        .name(null);

        final GitLabGroupNotesCreateAwardEmojiPayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupNotesCreateAwardEmojiPayload value = NotesCatalogFixtures.groupNotesCreateAwardEmojiPayload();

        assertThat(value.name()).isEqualTo("name");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupNotesCreateAwardEmojiPayload original =
                NotesCatalogFixtures.groupNotesCreateAwardEmojiPayload();

        final GitLabGroupNotesCreateAwardEmojiPayload rebuilt =
                GitLabGroupNotesCreateAwardEmojiPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupNotesCreateAwardEmojiPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.emojireactions;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectEmojiReactionsCreateRequestsNotesAwardEmojiPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectEmojiReactionsCreateRequestsNotesAwardEmojiPayloadBuilder builder =
                GitLabProjectEmojiReactionsCreateRequestsNotesAwardEmojiPayloadBuilder.builder(
                                EmojireactionsCatalogFixtures
                                        .projectEmojiReactionsCreateRequestsNotesAwardEmojiPayload())
                        .name(null);

        final GitLabProjectEmojiReactionsCreateRequestsNotesAwardEmojiPayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectEmojiReactionsCreateRequestsNotesAwardEmojiPayload value =
                EmojireactionsCatalogFixtures.projectEmojiReactionsCreateRequestsNotesAwardEmojiPayload();

        assertThat(value.name()).isEqualTo("name");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectEmojiReactionsCreateRequestsNotesAwardEmojiPayload original =
                EmojireactionsCatalogFixtures.projectEmojiReactionsCreateRequestsNotesAwardEmojiPayload();

        final GitLabProjectEmojiReactionsCreateRequestsNotesAwardEmojiPayload rebuilt =
                GitLabProjectEmojiReactionsCreateRequestsNotesAwardEmojiPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectEmojiReactionsCreateRequestsNotesAwardEmojiPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name");
    }
}

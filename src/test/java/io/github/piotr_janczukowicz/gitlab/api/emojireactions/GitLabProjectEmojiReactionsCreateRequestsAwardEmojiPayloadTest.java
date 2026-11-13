package io.github.piotr_janczukowicz.gitlab.api.emojireactions;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectEmojiReactionsCreateRequestsAwardEmojiPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectEmojiReactionsCreateRequestsAwardEmojiPayloadBuilder builder =
                GitLabProjectEmojiReactionsCreateRequestsAwardEmojiPayloadBuilder.builder(
                                EmojireactionsCatalogFixtures.projectEmojiReactionsCreateRequestsAwardEmojiPayload())
                        .name(null);

        final GitLabProjectEmojiReactionsCreateRequestsAwardEmojiPayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectEmojiReactionsCreateRequestsAwardEmojiPayload value =
                EmojireactionsCatalogFixtures.projectEmojiReactionsCreateRequestsAwardEmojiPayload();

        assertThat(value.name()).isEqualTo("name");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectEmojiReactionsCreateRequestsAwardEmojiPayload original =
                EmojireactionsCatalogFixtures.projectEmojiReactionsCreateRequestsAwardEmojiPayload();

        final GitLabProjectEmojiReactionsCreateRequestsAwardEmojiPayload rebuilt =
                GitLabProjectEmojiReactionsCreateRequestsAwardEmojiPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectEmojiReactionsCreateRequestsAwardEmojiPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name");
    }
}

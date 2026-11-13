package io.github.piotr_janczukowicz.gitlab.api.emojireactions;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectEmojiReactionsCreateIssuesAwardEmojiPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectEmojiReactionsCreateIssuesAwardEmojiPayloadBuilder builder =
                GitLabProjectEmojiReactionsCreateIssuesAwardEmojiPayloadBuilder.builder(
                                EmojireactionsCatalogFixtures.projectEmojiReactionsCreateIssuesAwardEmojiPayload())
                        .name(null);

        final GitLabProjectEmojiReactionsCreateIssuesAwardEmojiPayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectEmojiReactionsCreateIssuesAwardEmojiPayload value =
                EmojireactionsCatalogFixtures.projectEmojiReactionsCreateIssuesAwardEmojiPayload();

        assertThat(value.name()).isEqualTo("name");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectEmojiReactionsCreateIssuesAwardEmojiPayload original =
                EmojireactionsCatalogFixtures.projectEmojiReactionsCreateIssuesAwardEmojiPayload();

        final GitLabProjectEmojiReactionsCreateIssuesAwardEmojiPayload rebuilt =
                GitLabProjectEmojiReactionsCreateIssuesAwardEmojiPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectEmojiReactionsCreateIssuesAwardEmojiPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name");
    }
}

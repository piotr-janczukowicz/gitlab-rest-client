package io.github.piotr_janczukowicz.gitlab.api.suggestions;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSuggestionsApplyPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenCommitMessageIsNullable() {
        final GitLabSuggestionsApplyPayloadBuilder builder = GitLabSuggestionsApplyPayloadBuilder.builder(
                        SuggestionsCatalogFixtures.suggestionsApplyPayload())
                .commitMessage(null);

        final GitLabSuggestionsApplyPayload built = builder.build();

        assertThat(built.commitMessage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSuggestionsApplyPayload value = SuggestionsCatalogFixtures.suggestionsApplyPayload();

        assertThat(value.commitMessage()).isEqualTo("commit_message");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSuggestionsApplyPayload original = SuggestionsCatalogFixtures.suggestionsApplyPayload();

        final GitLabSuggestionsApplyPayload rebuilt =
                GitLabSuggestionsApplyPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSuggestionsApplyPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("commitMessage");
    }
}

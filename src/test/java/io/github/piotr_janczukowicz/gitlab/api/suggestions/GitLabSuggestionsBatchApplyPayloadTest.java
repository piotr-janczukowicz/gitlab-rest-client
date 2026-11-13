package io.github.piotr_janczukowicz.gitlab.api.suggestions;

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
class GitLabSuggestionsBatchApplyPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenIdsIsNullable() {
        final GitLabSuggestionsBatchApplyPayloadBuilder builder = GitLabSuggestionsBatchApplyPayloadBuilder.builder(
                        SuggestionsCatalogFixtures.suggestionsBatchApplyPayload())
                .ids(null);

        final GitLabSuggestionsBatchApplyPayload built = builder.build();

        assertThat(built.ids()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitMessageIsNullable() {
        final GitLabSuggestionsBatchApplyPayloadBuilder builder = GitLabSuggestionsBatchApplyPayloadBuilder.builder(
                        SuggestionsCatalogFixtures.suggestionsBatchApplyPayload())
                .commitMessage(null);

        final GitLabSuggestionsBatchApplyPayload built = builder.build();

        assertThat(built.commitMessage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSuggestionsBatchApplyPayload value = SuggestionsCatalogFixtures.suggestionsBatchApplyPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.ids()).isEqualTo(List.of(1));
            softly.assertThat(value.commitMessage()).isEqualTo("commit_message");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSuggestionsBatchApplyPayload original = SuggestionsCatalogFixtures.suggestionsBatchApplyPayload();

        final GitLabSuggestionsBatchApplyPayload rebuilt =
                GitLabSuggestionsBatchApplyPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenIdsSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabSuggestionsBatchApplyPayload built = GitLabSuggestionsBatchApplyPayloadBuilder.builder(
                        SuggestionsCatalogFixtures.suggestionsBatchApplyPayload())
                .ids(source)
                .build();
        source.clear();

        assertThat(built.ids()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenIdsIsRead() {
        final GitLabSuggestionsBatchApplyPayload built = SuggestionsCatalogFixtures.suggestionsBatchApplyPayload();
        final List<Integer> values = built.ids();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSuggestionsBatchApplyPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("ids", "commitMessage");
    }
}

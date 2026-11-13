package io.github.piotr_janczukowicz.gitlab.api.search;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAiSemanticCodeSnippetRangeTest {

    @Test
    void constructor_shouldAcceptNull_whenStartLineIsNullable() {
        final GitLabAiSemanticCodeSnippetRangeBuilder builder = GitLabAiSemanticCodeSnippetRangeBuilder.builder(
                        SearchCatalogFixtures.aiSemanticCodeSnippetRange())
                .startLine(null);

        final GitLabAiSemanticCodeSnippetRange built = builder.build();

        assertThat(built.startLine()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEndLineIsNullable() {
        final GitLabAiSemanticCodeSnippetRangeBuilder builder = GitLabAiSemanticCodeSnippetRangeBuilder.builder(
                        SearchCatalogFixtures.aiSemanticCodeSnippetRange())
                .endLine(null);

        final GitLabAiSemanticCodeSnippetRange built = builder.build();

        assertThat(built.endLine()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabAiSemanticCodeSnippetRangeBuilder builder = GitLabAiSemanticCodeSnippetRangeBuilder.builder(
                        SearchCatalogFixtures.aiSemanticCodeSnippetRange())
                .content(null);

        final GitLabAiSemanticCodeSnippetRange built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScoreIsNullable() {
        final GitLabAiSemanticCodeSnippetRangeBuilder builder = GitLabAiSemanticCodeSnippetRangeBuilder.builder(
                        SearchCatalogFixtures.aiSemanticCodeSnippetRange())
                .score(null);

        final GitLabAiSemanticCodeSnippetRange built = builder.build();

        assertThat(built.score()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAiSemanticCodeSnippetRange value = SearchCatalogFixtures.aiSemanticCodeSnippetRange();

        assertSoftly(softly -> {
            softly.assertThat(value.startLine()).isEqualTo(1);
            softly.assertThat(value.endLine()).isEqualTo(1);
            softly.assertThat(value.content()).isEqualTo("def authenticate\n  ...\nend");
            softly.assertThat(value.score()).isEqualTo(1.5);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAiSemanticCodeSnippetRange original = SearchCatalogFixtures.aiSemanticCodeSnippetRange();

        final GitLabAiSemanticCodeSnippetRange rebuilt =
                GitLabAiSemanticCodeSnippetRangeBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAiSemanticCodeSnippetRange.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("startLine", "endLine", "content", "score");
    }
}

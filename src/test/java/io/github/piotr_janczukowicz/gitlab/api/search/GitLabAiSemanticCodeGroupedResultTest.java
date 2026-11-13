package io.github.piotr_janczukowicz.gitlab.api.search;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAiSemanticCodeGroupedResultTest {

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabAiSemanticCodeGroupedResultBuilder builder = GitLabAiSemanticCodeGroupedResultBuilder.builder(
                        SearchCatalogFixtures.aiSemanticCodeGroupedResult())
                .path(null);

        final GitLabAiSemanticCodeGroupedResult built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBlobIdIsNullable() {
        final GitLabAiSemanticCodeGroupedResultBuilder builder = GitLabAiSemanticCodeGroupedResultBuilder.builder(
                        SearchCatalogFixtures.aiSemanticCodeGroupedResult())
                .blobId(null);

        final GitLabAiSemanticCodeGroupedResult built = builder.build();

        assertThat(built.blobId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFileUrlIsNullable() {
        final GitLabAiSemanticCodeGroupedResultBuilder builder = GitLabAiSemanticCodeGroupedResultBuilder.builder(
                        SearchCatalogFixtures.aiSemanticCodeGroupedResult())
                .fileUrl(null);

        final GitLabAiSemanticCodeGroupedResult built = builder.build();

        assertThat(built.fileUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScoreIsNullable() {
        final GitLabAiSemanticCodeGroupedResultBuilder builder = GitLabAiSemanticCodeGroupedResultBuilder.builder(
                        SearchCatalogFixtures.aiSemanticCodeGroupedResult())
                .score(null);

        final GitLabAiSemanticCodeGroupedResult built = builder.build();

        assertThat(built.score()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetRangesIsNullable() {
        final GitLabAiSemanticCodeGroupedResultBuilder builder = GitLabAiSemanticCodeGroupedResultBuilder.builder(
                        SearchCatalogFixtures.aiSemanticCodeGroupedResult())
                .snippetRanges(null);

        final GitLabAiSemanticCodeGroupedResult built = builder.build();

        assertThat(built.snippetRanges()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAiSemanticCodeGroupedResult value = SearchCatalogFixtures.aiSemanticCodeGroupedResult();

        assertSoftly(softly -> {
            softly.assertThat(value.path()).isEqualTo("app/models/user.rb");
            softly.assertThat(value.blobId()).isEqualTo("abc123def456");
            softly.assertThat(value.fileUrl()).isEqualTo("https://gitlab.com/group/project/-/blob/main/user.rb");
            softly.assertThat(value.score()).isEqualTo(1.5);
            softly.assertThat(value.snippetRanges())
                    .isEqualTo(List.of(SearchCatalogFixtures.aiSemanticCodeSnippetRange()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAiSemanticCodeGroupedResult original = SearchCatalogFixtures.aiSemanticCodeGroupedResult();

        final GitLabAiSemanticCodeGroupedResult rebuilt =
                GitLabAiSemanticCodeGroupedResultBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAiSemanticCodeGroupedResult.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("path", "blobId", "fileUrl", "score", "snippetRanges");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.search;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAiSemanticCodeResponseTest {

    @Test
    void constructor_shouldAcceptNull_whenConfidenceIsNullable() {
        final GitLabAiSemanticCodeResponseBuilder builder = GitLabAiSemanticCodeResponseBuilder.builder(
                        SearchCatalogFixtures.aiSemanticCodeResponse())
                .confidence(null);

        final GitLabAiSemanticCodeResponse built = builder.build();

        assertThat(built.confidence()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResultsIsNullable() {
        final GitLabAiSemanticCodeResponseBuilder builder = GitLabAiSemanticCodeResponseBuilder.builder(
                        SearchCatalogFixtures.aiSemanticCodeResponse())
                .results(null);

        final GitLabAiSemanticCodeResponse built = builder.build();

        assertThat(built.results()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAiSemanticCodeResponse value = SearchCatalogFixtures.aiSemanticCodeResponse();

        assertSoftly(softly -> {
            softly.assertThat(value.confidence()).isEqualTo("high");
            softly.assertThat(value.results()).isEqualTo(List.of(SearchCatalogFixtures.aiSemanticCodeGroupedResult()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAiSemanticCodeResponse original = SearchCatalogFixtures.aiSemanticCodeResponse();

        final GitLabAiSemanticCodeResponse rebuilt =
                GitLabAiSemanticCodeResponseBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAiSemanticCodeResponse.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("confidence", "results");
    }
}

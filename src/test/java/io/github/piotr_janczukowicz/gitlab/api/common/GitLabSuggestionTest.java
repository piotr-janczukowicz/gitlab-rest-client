package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSuggestionTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabSuggestionBuilder builder = GitLabSuggestionBuilder.builder(CommonCatalogFixtures.suggestion())
                .id(null);

        final GitLabSuggestion built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFromLineIsNullable() {
        final GitLabSuggestionBuilder builder = GitLabSuggestionBuilder.builder(CommonCatalogFixtures.suggestion())
                .fromLine(null);

        final GitLabSuggestion built = builder.build();

        assertThat(built.fromLine()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenToLineIsNullable() {
        final GitLabSuggestionBuilder builder = GitLabSuggestionBuilder.builder(CommonCatalogFixtures.suggestion())
                .toLine(null);

        final GitLabSuggestion built = builder.build();

        assertThat(built.toLine()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppliableIsNullable() {
        final GitLabSuggestionBuilder builder = GitLabSuggestionBuilder.builder(CommonCatalogFixtures.suggestion())
                .appliable(null);

        final GitLabSuggestion built = builder.build();

        assertThat(built.appliable()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppliedIsNullable() {
        final GitLabSuggestionBuilder builder = GitLabSuggestionBuilder.builder(CommonCatalogFixtures.suggestion())
                .applied(null);

        final GitLabSuggestion built = builder.build();

        assertThat(built.applied()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFromContentIsNullable() {
        final GitLabSuggestionBuilder builder = GitLabSuggestionBuilder.builder(CommonCatalogFixtures.suggestion())
                .fromContent(null);

        final GitLabSuggestion built = builder.build();

        assertThat(built.fromContent()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenToContentIsNullable() {
        final GitLabSuggestionBuilder builder = GitLabSuggestionBuilder.builder(CommonCatalogFixtures.suggestion())
                .toContent(null);

        final GitLabSuggestion built = builder.build();

        assertThat(built.toContent()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSuggestion value = CommonCatalogFixtures.suggestion();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.fromLine()).isEqualTo(1);
            softly.assertThat(value.toLine()).isEqualTo(1);
            softly.assertThat(value.appliable()).isEqualTo(true);
            softly.assertThat(value.applied()).isEqualTo(true);
            softly.assertThat(value.fromContent()).isEqualTo("Original content\n");
            softly.assertThat(value.toContent()).isEqualTo("New content\n");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSuggestion original = CommonCatalogFixtures.suggestion();

        final GitLabSuggestion rebuilt =
                GitLabSuggestionBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSuggestion.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("id", "fromLine", "toLine", "appliable", "applied", "fromContent", "toContent");
    }
}

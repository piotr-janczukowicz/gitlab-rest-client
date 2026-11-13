package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabEpicIssueLinksTest {

    @Test
    void constructor_shouldAcceptNull_whenSelfIsNullable() {
        final GitLabEpicIssueLinksBuilder builder = GitLabEpicIssueLinksBuilder.builder(
                        CommonCatalogFixtures.epicIssueLinks())
                .self(null);

        final GitLabEpicIssueLinks built = builder.build();

        assertThat(built.self()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotesIsNullable() {
        final GitLabEpicIssueLinksBuilder builder = GitLabEpicIssueLinksBuilder.builder(
                        CommonCatalogFixtures.epicIssueLinks())
                .notes(null);

        final GitLabEpicIssueLinks built = builder.build();

        assertThat(built.notes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAwardEmojiIsNullable() {
        final GitLabEpicIssueLinksBuilder builder = GitLabEpicIssueLinksBuilder.builder(
                        CommonCatalogFixtures.epicIssueLinks())
                .awardEmoji(null);

        final GitLabEpicIssueLinks built = builder.build();

        assertThat(built.awardEmoji()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIsNullable() {
        final GitLabEpicIssueLinksBuilder builder = GitLabEpicIssueLinksBuilder.builder(
                        CommonCatalogFixtures.epicIssueLinks())
                .project(null);

        final GitLabEpicIssueLinks built = builder.build();

        assertThat(built.project()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClosedAsDuplicateOfIsNullable() {
        final GitLabEpicIssueLinksBuilder builder = GitLabEpicIssueLinksBuilder.builder(
                        CommonCatalogFixtures.epicIssueLinks())
                .closedAsDuplicateOf(null);

        final GitLabEpicIssueLinks built = builder.build();

        assertThat(built.closedAsDuplicateOf()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabEpicIssueLinks value = CommonCatalogFixtures.epicIssueLinks();

        assertSoftly(softly -> {
            softly.assertThat(value.self()).isEqualTo("http://example.com/api/v4/projects/1/issues/2");
            softly.assertThat(value.notes()).isEqualTo("http://example.com/api/v4/projects/1/issues/2/notes");
            softly.assertThat(value.awardEmoji())
                    .isEqualTo("http://example.com/api/v4/projects/1/issues/2/award_emoji");
            softly.assertThat(value.project()).isEqualTo("http://example.com/api/v4/projects/1");
            softly.assertThat(value.closedAsDuplicateOf()).isEqualTo("http://example.com/api/v4/projects/1/issues/75");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabEpicIssueLinks original = CommonCatalogFixtures.epicIssueLinks();

        final GitLabEpicIssueLinks rebuilt =
                GitLabEpicIssueLinksBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabEpicIssueLinks.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("self", "notes", "awardEmoji", "project", "closedAsDuplicateOf");
    }
}

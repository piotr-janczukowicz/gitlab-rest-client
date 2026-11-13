package io.github.piotr_janczukowicz.gitlab.api.issuelinks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabRelatedIssueLinksTest {

    @Test
    void constructor_shouldAcceptNull_whenSelfIsNullable() {
        final GitLabRelatedIssueLinksBuilder builder = GitLabRelatedIssueLinksBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssueLinks())
                .self(null);

        final GitLabRelatedIssueLinks built = builder.build();

        assertThat(built.self()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotesIsNullable() {
        final GitLabRelatedIssueLinksBuilder builder = GitLabRelatedIssueLinksBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssueLinks())
                .notes(null);

        final GitLabRelatedIssueLinks built = builder.build();

        assertThat(built.notes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAwardEmojiIsNullable() {
        final GitLabRelatedIssueLinksBuilder builder = GitLabRelatedIssueLinksBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssueLinks())
                .awardEmoji(null);

        final GitLabRelatedIssueLinks built = builder.build();

        assertThat(built.awardEmoji()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIsNullable() {
        final GitLabRelatedIssueLinksBuilder builder = GitLabRelatedIssueLinksBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssueLinks())
                .project(null);

        final GitLabRelatedIssueLinks built = builder.build();

        assertThat(built.project()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClosedAsDuplicateOfIsNullable() {
        final GitLabRelatedIssueLinksBuilder builder = GitLabRelatedIssueLinksBuilder.builder(
                        IssuelinksCatalogFixtures.relatedIssueLinks())
                .closedAsDuplicateOf(null);

        final GitLabRelatedIssueLinks built = builder.build();

        assertThat(built.closedAsDuplicateOf()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabRelatedIssueLinks value = IssuelinksCatalogFixtures.relatedIssueLinks();

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
        final GitLabRelatedIssueLinks original = IssuelinksCatalogFixtures.relatedIssueLinks();

        final GitLabRelatedIssueLinks rebuilt =
                GitLabRelatedIssueLinksBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabRelatedIssueLinks.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("self", "notes", "awardEmoji", "project", "closedAsDuplicateOf");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.issues;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabIssueLinksTest {

    @Test
    void constructor_shouldAcceptNull_whenSelfIsNullable() {
        final GitLabIssueLinksBuilder builder = GitLabIssueLinksBuilder.builder(IssuesCatalogFixtures.issueLinks())
                .self(null);

        final GitLabIssueLinks built = builder.build();

        assertThat(built.self()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotesIsNullable() {
        final GitLabIssueLinksBuilder builder = GitLabIssueLinksBuilder.builder(IssuesCatalogFixtures.issueLinks())
                .notes(null);

        final GitLabIssueLinks built = builder.build();

        assertThat(built.notes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAwardEmojiIsNullable() {
        final GitLabIssueLinksBuilder builder = GitLabIssueLinksBuilder.builder(IssuesCatalogFixtures.issueLinks())
                .awardEmoji(null);

        final GitLabIssueLinks built = builder.build();

        assertThat(built.awardEmoji()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIsNullable() {
        final GitLabIssueLinksBuilder builder = GitLabIssueLinksBuilder.builder(IssuesCatalogFixtures.issueLinks())
                .project(null);

        final GitLabIssueLinks built = builder.build();

        assertThat(built.project()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClosedAsDuplicateOfIsNullable() {
        final GitLabIssueLinksBuilder builder = GitLabIssueLinksBuilder.builder(IssuesCatalogFixtures.issueLinks())
                .closedAsDuplicateOf(null);

        final GitLabIssueLinks built = builder.build();

        assertThat(built.closedAsDuplicateOf()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabIssueLinks value = IssuesCatalogFixtures.issueLinks();

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
        final GitLabIssueLinks original = IssuesCatalogFixtures.issueLinks();

        final GitLabIssueLinks rebuilt =
                GitLabIssueLinksBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabIssueLinks.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("self", "notes", "awardEmoji", "project", "closedAsDuplicateOf");
    }
}

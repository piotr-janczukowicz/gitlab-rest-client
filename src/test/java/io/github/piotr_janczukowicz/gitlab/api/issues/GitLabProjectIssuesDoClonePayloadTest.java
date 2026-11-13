package io.github.piotr_janczukowicz.gitlab.api.issues;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIssuesDoClonePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenToProjectIdIsNullable() {
        final GitLabProjectIssuesDoClonePayloadBuilder builder = GitLabProjectIssuesDoClonePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesDoClonePayload())
                .toProjectId(null);

        final GitLabProjectIssuesDoClonePayload built = builder.build();

        assertThat(built.toProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithNotesIsNullable() {
        final GitLabProjectIssuesDoClonePayloadBuilder builder = GitLabProjectIssuesDoClonePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesDoClonePayload())
                .withNotes(null);

        final GitLabProjectIssuesDoClonePayload built = builder.build();

        assertThat(built.withNotes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIssuesDoClonePayload value = IssuesCatalogFixtures.projectIssuesDoClonePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.toProjectId()).isEqualTo(1L);
            softly.assertThat(value.withNotes()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIssuesDoClonePayload original = IssuesCatalogFixtures.projectIssuesDoClonePayload();

        final GitLabProjectIssuesDoClonePayload rebuilt =
                GitLabProjectIssuesDoClonePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIssuesDoClonePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("toProjectId", "withNotes");
    }
}

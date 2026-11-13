package io.github.piotr_janczukowicz.gitlab.api.draftnotes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDraftNoteTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabDraftNoteBuilder builder = GitLabDraftNoteBuilder.builder(DraftnotesCatalogFixtures.draftNote())
                .id(null);

        final GitLabDraftNote built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIdIsNullable() {
        final GitLabDraftNoteBuilder builder = GitLabDraftNoteBuilder.builder(DraftnotesCatalogFixtures.draftNote())
                .authorId(null);

        final GitLabDraftNote built = builder.build();

        assertThat(built.authorId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestIdIsNullable() {
        final GitLabDraftNoteBuilder builder = GitLabDraftNoteBuilder.builder(DraftnotesCatalogFixtures.draftNote())
                .mergeRequestId(null);

        final GitLabDraftNote built = builder.build();

        assertThat(built.mergeRequestId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResolveDiscussionIsNullable() {
        final GitLabDraftNoteBuilder builder = GitLabDraftNoteBuilder.builder(DraftnotesCatalogFixtures.draftNote())
                .resolveDiscussion(null);

        final GitLabDraftNote built = builder.build();

        assertThat(built.resolveDiscussion()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiscussionIdIsNullable() {
        final GitLabDraftNoteBuilder builder = GitLabDraftNoteBuilder.builder(DraftnotesCatalogFixtures.draftNote())
                .discussionId(null);

        final GitLabDraftNote built = builder.build();

        assertThat(built.discussionId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteIsNullable() {
        final GitLabDraftNoteBuilder builder = GitLabDraftNoteBuilder.builder(DraftnotesCatalogFixtures.draftNote())
                .note(null);

        final GitLabDraftNote built = builder.build();

        assertThat(built.note()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitIdIsNullable() {
        final GitLabDraftNoteBuilder builder = GitLabDraftNoteBuilder.builder(DraftnotesCatalogFixtures.draftNote())
                .commitId(null);

        final GitLabDraftNote built = builder.build();

        assertThat(built.commitId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLineCodeIsNullable() {
        final GitLabDraftNoteBuilder builder = GitLabDraftNoteBuilder.builder(DraftnotesCatalogFixtures.draftNote())
                .lineCode(null);

        final GitLabDraftNote built = builder.build();

        assertThat(built.lineCode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPositionIsNullable() {
        final GitLabDraftNoteBuilder builder = GitLabDraftNoteBuilder.builder(DraftnotesCatalogFixtures.draftNote())
                .position(null);

        final GitLabDraftNote built = builder.build();

        assertThat(built.position()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDraftNote value = DraftnotesCatalogFixtures.draftNote();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.authorId()).isEqualTo(1L);
            softly.assertThat(value.mergeRequestId()).isEqualTo(1L);
            softly.assertThat(value.resolveDiscussion()).isEqualTo(true);
            softly.assertThat(value.discussionId()).isEqualTo("6a9c1750b37d513a43987b574953fceb50b03ce7");
            softly.assertThat(value.note()).isEqualTo("This is a note");
            softly.assertThat(value.commitId()).isEqualTo("6104942438c14ec7bd21c6cd5bd995272b3faff6");
            softly.assertThat(value.lineCode()).isEqualTo("1c497fbb3a46b78edf0_2_4");
            softly.assertThat(value.position()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDraftNote original = DraftnotesCatalogFixtures.draftNote();

        final GitLabDraftNote rebuilt = GitLabDraftNoteBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDraftNote.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "authorId",
                        "mergeRequestId",
                        "resolveDiscussion",
                        "discussionId",
                        "note",
                        "commitId",
                        "lineCode",
                        "position");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.draftnotes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDraftNotesCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNoteIsNullable() {
        final GitLabProjectDraftNotesCreatePayloadBuilder builder = GitLabProjectDraftNotesCreatePayloadBuilder.builder(
                        DraftnotesCatalogFixtures.projectDraftNotesCreatePayload())
                .note(null);

        final GitLabProjectDraftNotesCreatePayload built = builder.build();

        assertThat(built.note()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInReplyToDiscussionIdIsNullable() {
        final GitLabProjectDraftNotesCreatePayloadBuilder builder = GitLabProjectDraftNotesCreatePayloadBuilder.builder(
                        DraftnotesCatalogFixtures.projectDraftNotesCreatePayload())
                .inReplyToDiscussionId(null);

        final GitLabProjectDraftNotesCreatePayload built = builder.build();

        assertThat(built.inReplyToDiscussionId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitIdIsNullable() {
        final GitLabProjectDraftNotesCreatePayloadBuilder builder = GitLabProjectDraftNotesCreatePayloadBuilder.builder(
                        DraftnotesCatalogFixtures.projectDraftNotesCreatePayload())
                .commitId(null);

        final GitLabProjectDraftNotesCreatePayload built = builder.build();

        assertThat(built.commitId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResolveDiscussionIsNullable() {
        final GitLabProjectDraftNotesCreatePayloadBuilder builder = GitLabProjectDraftNotesCreatePayloadBuilder.builder(
                        DraftnotesCatalogFixtures.projectDraftNotesCreatePayload())
                .resolveDiscussion(null);

        final GitLabProjectDraftNotesCreatePayload built = builder.build();

        assertThat(built.resolveDiscussion()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPositionIsNullable() {
        final GitLabProjectDraftNotesCreatePayloadBuilder builder = GitLabProjectDraftNotesCreatePayloadBuilder.builder(
                        DraftnotesCatalogFixtures.projectDraftNotesCreatePayload())
                .position(null);

        final GitLabProjectDraftNotesCreatePayload built = builder.build();

        assertThat(built.position()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDraftNotesCreatePayload value = DraftnotesCatalogFixtures.projectDraftNotesCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.note()).isEqualTo("note");
            softly.assertThat(value.inReplyToDiscussionId()).isEqualTo("in_reply_to_discussion_id");
            softly.assertThat(value.commitId()).isEqualTo("commit_id");
            softly.assertThat(value.resolveDiscussion()).isEqualTo(true);
            softly.assertThat(value.position()).isEqualTo(DraftnotesCatalogFixtures.projectDraftNotesCreatePosition());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDraftNotesCreatePayload original =
                DraftnotesCatalogFixtures.projectDraftNotesCreatePayload();

        final GitLabProjectDraftNotesCreatePayload rebuilt =
                GitLabProjectDraftNotesCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectDraftNotesCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("note", "inReplyToDiscussionId", "commitId", "resolveDiscussion", "position");
    }
}

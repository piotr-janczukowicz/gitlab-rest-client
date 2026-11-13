package io.github.piotr_janczukowicz.gitlab.api.draftnotes;

import java.util.Map;

public final class DraftnotesCatalogFixtures {

    private DraftnotesCatalogFixtures() {}

    public static GitLabDraftNote draftNote() {
        return GitLabDraftNoteBuilder.builder()
                .id(1L)
                .authorId(1L)
                .mergeRequestId(1L)
                .resolveDiscussion(true)
                .discussionId("6a9c1750b37d513a43987b574953fceb50b03ce7")
                .note("This is a note")
                .commitId("6104942438c14ec7bd21c6cd5bd995272b3faff6")
                .lineCode("1c497fbb3a46b78edf0_2_4")
                .position(Map.of("key", "value"))
                .build();
    }

    public static GitLabProjectDraftNotesBulkPublishPayload projectDraftNotesBulkPublishPayload() {
        return GitLabProjectDraftNotesBulkPublishPayloadBuilder.builder()
                .reviewerState(GitLabProjectDraftNotesBulkPublishReviewerState.REQUESTED_CHANGES)
                .note("note")
                .internal(true)
                .build();
    }

    public static GitLabProjectDraftNotesCreatePayload projectDraftNotesCreatePayload() {
        return GitLabProjectDraftNotesCreatePayloadBuilder.builder()
                .note("note")
                .inReplyToDiscussionId("in_reply_to_discussion_id")
                .commitId("commit_id")
                .resolveDiscussion(true)
                .position(DraftnotesCatalogFixtures.projectDraftNotesCreatePosition())
                .build();
    }

    public static GitLabProjectDraftNotesCreatePosition projectDraftNotesCreatePosition() {
        return GitLabProjectDraftNotesCreatePositionBuilder.builder()
                .baseSha("base_sha")
                .startSha("start_sha")
                .headSha("head_sha")
                .positionType(GitLabProjectDraftNotesCreatePositionType.TEXT)
                .newPath("new_path")
                .newLine(1)
                .oldPath("old_path")
                .oldLine(1)
                .width(1)
                .height(1)
                .x(1)
                .y(1)
                .lineRange(DraftnotesCatalogFixtures.projectDraftNotesCreatePositionLineRange())
                .build();
    }

    public static GitLabProjectDraftNotesCreatePositionLineRange projectDraftNotesCreatePositionLineRange() {
        return GitLabProjectDraftNotesCreatePositionLineRangeBuilder.builder()
                .start(DraftnotesCatalogFixtures.projectDraftNotesCreatePositionLineRangeStart())
                .end(DraftnotesCatalogFixtures.projectDraftNotesCreatePositionLineRangeEnd())
                .build();
    }

    public static GitLabProjectDraftNotesCreatePositionLineRangeEnd projectDraftNotesCreatePositionLineRangeEnd() {
        return GitLabProjectDraftNotesCreatePositionLineRangeEndBuilder.builder()
                .lineCode("line_code")
                .type("type")
                .oldLine(1)
                .newLine(1)
                .build();
    }

    public static GitLabProjectDraftNotesCreatePositionLineRangeStart projectDraftNotesCreatePositionLineRangeStart() {
        return GitLabProjectDraftNotesCreatePositionLineRangeStartBuilder.builder()
                .lineCode("line_code")
                .type("type")
                .oldLine(1)
                .newLine(1)
                .build();
    }

    public static GitLabProjectDraftNotesUpdatePayload projectDraftNotesUpdatePayload() {
        return GitLabProjectDraftNotesUpdatePayloadBuilder.builder()
                .note("note")
                .position(DraftnotesCatalogFixtures.projectDraftNotesUpdatePosition())
                .build();
    }

    public static GitLabProjectDraftNotesUpdatePosition projectDraftNotesUpdatePosition() {
        return GitLabProjectDraftNotesUpdatePositionBuilder.builder()
                .baseSha("base_sha")
                .startSha("start_sha")
                .headSha("head_sha")
                .positionType(GitLabProjectDraftNotesUpdatePositionType.TEXT)
                .newPath("new_path")
                .newLine(1)
                .oldPath("old_path")
                .oldLine(1)
                .width(1)
                .height(1)
                .x(1)
                .y(1)
                .lineRange(DraftnotesCatalogFixtures.projectDraftNotesUpdatePositionLineRange())
                .build();
    }

    public static GitLabProjectDraftNotesUpdatePositionLineRange projectDraftNotesUpdatePositionLineRange() {
        return GitLabProjectDraftNotesUpdatePositionLineRangeBuilder.builder()
                .start(DraftnotesCatalogFixtures.projectDraftNotesUpdatePositionLineRangeStart())
                .end(DraftnotesCatalogFixtures.projectDraftNotesUpdatePositionLineRangeEnd())
                .build();
    }

    public static GitLabProjectDraftNotesUpdatePositionLineRangeEnd projectDraftNotesUpdatePositionLineRangeEnd() {
        return GitLabProjectDraftNotesUpdatePositionLineRangeEndBuilder.builder()
                .lineCode("line_code")
                .type("type")
                .oldLine(1)
                .newLine(1)
                .build();
    }

    public static GitLabProjectDraftNotesUpdatePositionLineRangeStart projectDraftNotesUpdatePositionLineRangeStart() {
        return GitLabProjectDraftNotesUpdatePositionLineRangeStartBuilder.builder()
                .lineCode("line_code")
                .type("type")
                .oldLine(1)
                .newLine(1)
                .build();
    }
}

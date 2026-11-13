package io.github.piotr_janczukowicz.gitlab.api.notes;

import java.time.Instant;

public final class NotesCatalogFixtures {

    private NotesCatalogFixtures() {}

    public static GitLabGroupNotesCreateAwardEmojiPayload groupNotesCreateAwardEmojiPayload() {
        return GitLabGroupNotesCreateAwardEmojiPayloadBuilder.builder()
                .name("name")
                .build();
    }

    public static GitLabGroupNotesCreateDiscussionsNotesPayload groupNotesCreateDiscussionsNotesPayload() {
        return GitLabGroupNotesCreateDiscussionsNotesPayloadBuilder.builder()
                .body("body")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabGroupNotesCreateEpicsNotesPayload groupNotesCreateEpicsNotesPayload() {
        return GitLabGroupNotesCreateEpicsNotesPayloadBuilder.builder()
                .body("body")
                .confidential(true)
                .internal(true)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .mergeRequestDiffHeadSha("merge_request_diff_head_sha")
                .build();
    }

    public static GitLabGroupNotesCreateWikiPagesNotePayload groupNotesCreateWikiPagesNotePayload() {
        return GitLabGroupNotesCreateWikiPagesNotePayloadBuilder.builder()
                .body("body")
                .confidential(true)
                .internal(true)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .mergeRequestDiffHeadSha("merge_request_diff_head_sha")
                .build();
    }

    public static GitLabGroupNotesUpdateDiscussionsNotesPayload groupNotesUpdateDiscussionsNotesPayload() {
        return GitLabGroupNotesUpdateDiscussionsNotesPayloadBuilder.builder()
                .body("body")
                .resolved(true)
                .build();
    }

    public static GitLabGroupNotesUpdateEpicsNotesPayload groupNotesUpdateEpicsNotesPayload() {
        return GitLabGroupNotesUpdateEpicsNotesPayloadBuilder.builder()
                .body("body")
                .confidential(true)
                .build();
    }

    public static GitLabGroupNotesUpdateWikiPagesNotePayload groupNotesUpdateWikiPagesNotePayload() {
        return GitLabGroupNotesUpdateWikiPagesNotePayloadBuilder.builder()
                .body("body")
                .confidential(true)
                .build();
    }

    public static GitLabProjectNotesCreateIssuesDiscussionsNotesPayload
            projectNotesCreateIssuesDiscussionsNotesPayload() {
        return GitLabProjectNotesCreateIssuesDiscussionsNotesPayloadBuilder.builder()
                .body("body")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabProjectNotesCreateIssuesNotesPayload projectNotesCreateIssuesNotesPayload() {
        return GitLabProjectNotesCreateIssuesNotesPayloadBuilder.builder()
                .body("body")
                .confidential(true)
                .internal(true)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .mergeRequestDiffHeadSha("merge_request_diff_head_sha")
                .build();
    }

    public static GitLabProjectNotesCreateRequestsDiscussionsNotesPayload
            projectNotesCreateRequestsDiscussionsNotesPayload() {
        return GitLabProjectNotesCreateRequestsDiscussionsNotesPayloadBuilder.builder()
                .body("body")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabProjectNotesCreateRequestsNotesPayload projectNotesCreateRequestsNotesPayload() {
        return GitLabProjectNotesCreateRequestsNotesPayloadBuilder.builder()
                .body("body")
                .confidential(true)
                .internal(true)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .mergeRequestDiffHeadSha("merge_request_diff_head_sha")
                .build();
    }

    public static GitLabProjectNotesCreateSnippetsDiscussionsNotesPayload
            projectNotesCreateSnippetsDiscussionsNotesPayload() {
        return GitLabProjectNotesCreateSnippetsDiscussionsNotesPayloadBuilder.builder()
                .body("body")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabProjectNotesCreateSnippetsNotesPayload projectNotesCreateSnippetsNotesPayload() {
        return GitLabProjectNotesCreateSnippetsNotesPayloadBuilder.builder()
                .body("body")
                .confidential(true)
                .internal(true)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .mergeRequestDiffHeadSha("merge_request_diff_head_sha")
                .build();
    }

    public static GitLabProjectNotesCreateWikiPagesNotePayload projectNotesCreateWikiPagesNotePayload() {
        return GitLabProjectNotesCreateWikiPagesNotePayloadBuilder.builder()
                .body("body")
                .confidential(true)
                .internal(true)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .mergeRequestDiffHeadSha("merge_request_diff_head_sha")
                .build();
    }

    public static GitLabProjectNotesUpdateIssuesDiscussionsNotesPayload
            projectNotesUpdateIssuesDiscussionsNotesPayload() {
        return GitLabProjectNotesUpdateIssuesDiscussionsNotesPayloadBuilder.builder()
                .body("body")
                .resolved(true)
                .build();
    }

    public static GitLabProjectNotesUpdateIssuesNotesPayload projectNotesUpdateIssuesNotesPayload() {
        return GitLabProjectNotesUpdateIssuesNotesPayloadBuilder.builder()
                .body("body")
                .confidential(true)
                .build();
    }

    public static GitLabProjectNotesUpdateRequestsDiscussionsNotesPayload
            projectNotesUpdateRequestsDiscussionsNotesPayload() {
        return GitLabProjectNotesUpdateRequestsDiscussionsNotesPayloadBuilder.builder()
                .body("body")
                .resolved(true)
                .build();
    }

    public static GitLabProjectNotesUpdateRequestsNotesPayload projectNotesUpdateRequestsNotesPayload() {
        return GitLabProjectNotesUpdateRequestsNotesPayloadBuilder.builder()
                .body("body")
                .confidential(true)
                .build();
    }

    public static GitLabProjectNotesUpdateSnippetsDiscussionsNotesPayload
            projectNotesUpdateSnippetsDiscussionsNotesPayload() {
        return GitLabProjectNotesUpdateSnippetsDiscussionsNotesPayloadBuilder.builder()
                .body("body")
                .resolved(true)
                .build();
    }

    public static GitLabProjectNotesUpdateSnippetsNotesPayload projectNotesUpdateSnippetsNotesPayload() {
        return GitLabProjectNotesUpdateSnippetsNotesPayloadBuilder.builder()
                .body("body")
                .confidential(true)
                .build();
    }

    public static GitLabProjectNotesUpdateWikiPagesNotePayload projectNotesUpdateWikiPagesNotePayload() {
        return GitLabProjectNotesUpdateWikiPagesNotePayloadBuilder.builder()
                .body("body")
                .confidential(true)
                .build();
    }
}

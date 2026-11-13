package io.github.piotr_janczukowicz.gitlab.api.discussions;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;
import java.util.List;

public final class DiscussionsCatalogFixtures {

    private DiscussionsCatalogFixtures() {}

    public static GitLabDiscussion discussion() {
        return GitLabDiscussionBuilder.builder()
                .id("6a9c1750b37d513a43987b574953fceb50b03ce7")
                .individualNote(true)
                .resolvable(true)
                .resolved(true)
                .notes(List.of(CommonCatalogFixtures.note()))
                .build();
    }

    public static GitLabGroupDiscussionsCreatePayload groupDiscussionsCreatePayload() {
        return GitLabGroupDiscussionsCreatePayloadBuilder.builder()
                .body("body")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabGroupDiscussionsUpdatePayload groupDiscussionsUpdatePayload() {
        return GitLabGroupDiscussionsUpdatePayloadBuilder.builder()
                .resolved(true)
                .build();
    }

    public static GitLabProjectCommitDiscussionCreatePayload projectCommitDiscussionCreatePayload() {
        return GitLabProjectCommitDiscussionCreatePayloadBuilder.builder()
                .body("body")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .position(DiscussionsCatalogFixtures.projectCommitDiscussionCreatePosition())
                .build();
    }

    public static GitLabProjectCommitDiscussionCreatePosition projectCommitDiscussionCreatePosition() {
        return GitLabProjectCommitDiscussionCreatePositionBuilder.builder()
                .baseSha("base_sha")
                .startSha("start_sha")
                .headSha("head_sha")
                .positionType(GitLabProjectCommitDiscussionCreatePositionType.TEXT)
                .newPath("new_path")
                .newLine(1)
                .oldPath("old_path")
                .oldLine(1)
                .width(1)
                .height(1)
                .x(1)
                .y(1)
                .lineRange(DiscussionsCatalogFixtures.projectCommitDiscussionCreatePositionLineRange())
                .build();
    }

    public static GitLabProjectCommitDiscussionCreatePositionLineRange
            projectCommitDiscussionCreatePositionLineRange() {
        return GitLabProjectCommitDiscussionCreatePositionLineRangeBuilder.builder()
                .start(DiscussionsCatalogFixtures.projectCommitDiscussionCreatePositionLineRangeStart())
                .end(DiscussionsCatalogFixtures.projectCommitDiscussionCreatePositionLineRangeEnd())
                .build();
    }

    public static GitLabProjectCommitDiscussionCreatePositionLineRangeEnd
            projectCommitDiscussionCreatePositionLineRangeEnd() {
        return GitLabProjectCommitDiscussionCreatePositionLineRangeEndBuilder.builder()
                .lineCode("line_code")
                .type("type")
                .oldLine(1)
                .newLine(1)
                .build();
    }

    public static GitLabProjectCommitDiscussionCreatePositionLineRangeStart
            projectCommitDiscussionCreatePositionLineRangeStart() {
        return GitLabProjectCommitDiscussionCreatePositionLineRangeStartBuilder.builder()
                .lineCode("line_code")
                .type("type")
                .oldLine(1)
                .newLine(1)
                .build();
    }

    public static GitLabProjectDiscussionsCreateIssuesDiscussionsPayload
            projectDiscussionsCreateIssuesDiscussionsPayload() {
        return GitLabProjectDiscussionsCreateIssuesDiscussionsPayloadBuilder.builder()
                .body("body")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabProjectDiscussionsCreateRepositoryCommitsDiscussionsNotePayload
            projectDiscussionsCreateRepositoryCommitsDiscussionsNotePayload() {
        return GitLabProjectDiscussionsCreateRepositoryCommitsDiscussionsNotePayloadBuilder.builder()
                .body("body")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabProjectDiscussionsCreateRequestsDiscussionsPayload
            projectDiscussionsCreateRequestsDiscussionsPayload() {
        return GitLabProjectDiscussionsCreateRequestsDiscussionsPayloadBuilder.builder()
                .body("body")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .position(DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPosition())
                .build();
    }

    public static GitLabProjectDiscussionsCreateRequestsDiscussionsPosition
            projectDiscussionsCreateRequestsDiscussionsPosition() {
        return GitLabProjectDiscussionsCreateRequestsDiscussionsPositionBuilder.builder()
                .baseSha("base_sha")
                .startSha("start_sha")
                .headSha("head_sha")
                .positionType(GitLabProjectDiscussionsCreateRequestsDiscussionsPositionType.TEXT)
                .newPath("new_path")
                .newLine(1)
                .oldPath("old_path")
                .oldLine(1)
                .width(1)
                .height(1)
                .x(1)
                .y(1)
                .lineRange(DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPositionLineRange())
                .build();
    }

    public static GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRange
            projectDiscussionsCreateRequestsDiscussionsPositionLineRange() {
        return GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeBuilder.builder()
                .start(DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPositionLineRangeStart())
                .end(DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPositionLineRangeEnd())
                .build();
    }

    public static GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeEnd
            projectDiscussionsCreateRequestsDiscussionsPositionLineRangeEnd() {
        return GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeEndBuilder.builder()
                .lineCode("line_code")
                .type("type")
                .oldLine(1)
                .newLine(1)
                .build();
    }

    public static GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeStart
            projectDiscussionsCreateRequestsDiscussionsPositionLineRangeStart() {
        return GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeStartBuilder.builder()
                .lineCode("line_code")
                .type("type")
                .oldLine(1)
                .newLine(1)
                .build();
    }

    public static GitLabProjectDiscussionsCreateSnippetsDiscussionsPayload
            projectDiscussionsCreateSnippetsDiscussionsPayload() {
        return GitLabProjectDiscussionsCreateSnippetsDiscussionsPayloadBuilder.builder()
                .body("body")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabProjectDiscussionsUpdateIssuesDiscussionsPayload
            projectDiscussionsUpdateIssuesDiscussionsPayload() {
        return GitLabProjectDiscussionsUpdateIssuesDiscussionsPayloadBuilder.builder()
                .resolved(true)
                .build();
    }

    public static GitLabProjectDiscussionsUpdateRepositoryCommitsDiscussionsNotePayload
            projectDiscussionsUpdateRepositoryCommitsDiscussionsNotePayload() {
        return GitLabProjectDiscussionsUpdateRepositoryCommitsDiscussionsNotePayloadBuilder.builder()
                .body("body")
                .resolved(true)
                .build();
    }

    public static GitLabProjectDiscussionsUpdateRequestsDiscussionsPayload
            projectDiscussionsUpdateRequestsDiscussionsPayload() {
        return GitLabProjectDiscussionsUpdateRequestsDiscussionsPayloadBuilder.builder()
                .resolved(true)
                .build();
    }
}

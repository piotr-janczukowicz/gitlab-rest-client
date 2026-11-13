package io.github.piotr_janczukowicz.gitlab.api.projectvulnerabilities;

import java.time.Instant;

public final class ProjectvulnerabilitiesCatalogFixtures {

    private ProjectvulnerabilitiesCatalogFixtures() {}

    public static GitLabProjectProjectVulnerabilitiesCreateNotePayload
            projectProjectVulnerabilitiesCreateNotePayload() {
        return GitLabProjectProjectVulnerabilitiesCreateNotePayloadBuilder.builder()
                .body("body")
                .confidential(true)
                .internal(true)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .mergeRequestDiffHeadSha("merge_request_diff_head_sha")
                .build();
    }

    public static GitLabProjectProjectVulnerabilitiesCreatePayload projectProjectVulnerabilitiesCreatePayload() {
        return GitLabProjectProjectVulnerabilitiesCreatePayloadBuilder.builder()
                .findingId(1L)
                .build();
    }

    public static GitLabProjectProjectVulnerabilitiesUpdateNotePayload
            projectProjectVulnerabilitiesUpdateNotePayload() {
        return GitLabProjectProjectVulnerabilitiesUpdateNotePayloadBuilder.builder()
                .body("body")
                .confidential(true)
                .build();
    }
}

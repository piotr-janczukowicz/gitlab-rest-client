package io.github.piotr_janczukowicz.gitlab.api.mergerequestcontextcommits;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public final class MergerequestcontextcommitsCatalogFixtures {

    private MergerequestcontextcommitsCatalogFixtures() {}

    public static GitLabCommitWithLink commitWithLink() {
        return GitLabCommitWithLinkBuilder.builder()
                .id("2695effb5807a22ff3d138d593fd856244e155e7")
                .shortId("2695effb")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .parentIds(List.of("2a4b78934375d7f53875269ffd4f45fd83a84ebe"))
                .title("Initial commit")
                .message("Initial commit")
                .authorName("John Smith")
                .authorEmail("john@example.com")
                .authoredDate(Instant.parse("2026-01-01T00:00:00Z"))
                .committerName("Jack Smith")
                .committerEmail("jack@example.com")
                .committedDate(Instant.parse("2026-01-01T00:00:00Z"))
                .trailers(Map.of("key", "value"))
                .extendedTrailers(Map.of("key", "value"))
                .webUrl(
                        "https://gitlab.example.com/janedoe/gitlab-foss/-/commit/ed899a2f4b50b4370feeea94676502b42383c746")
                .author(MergerequestcontextcommitsCatalogFixtures.userPath())
                .authorGravatarUrl("https://www.gravatar.com/avatar/abc")
                .commitUrl("https://gitlab.example.com/project/-/commit/abc")
                .commitPath("/project/-/commit/abc")
                .descriptionHtml("<p>description</p>")
                .titleHtml("<p>title</p>")
                .signatureHtml("<p>signature</p>")
                .prevCommitId("2695effb5807a22ff3d138d593fd856244e155e7")
                .nextCommitId("2695effb5807a22ff3d138d593fd856244e155e7")
                .pipelineStatusPath("/project/pipelines/1")
                .build();
    }

    public static GitLabProjectMergeRequestContextCommitsCreatePayload
            projectMergeRequestContextCommitsCreatePayload() {
        return GitLabProjectMergeRequestContextCommitsCreatePayloadBuilder.builder()
                .commits(List.of("commits"))
                .build();
    }

    public static GitLabUserPath userPath() {
        return GitLabUserPathBuilder.builder()
                .id(1L)
                .username("admin")
                .publicEmail("john@example.com")
                .name("Administrator")
                .state("active")
                .locked(true)
                .avatarUrl("https://gravatar.com/avatar/1")
                .avatarPath("/user/avatar/28/The-Big-Lebowski-400-400.png")
                .customAttributes(List.of(CommonCatalogFixtures.customAttribute()))
                .webUrl("https://gitlab.example.com/root")
                .statusTooltipHtml("status_tooltip_html")
                .showStatus("show_status")
                .availability("availability")
                .path("path")
                .build();
    }
}

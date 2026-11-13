package io.github.piotr_janczukowicz.gitlab.api.repositoryfiles;

import java.time.Instant;
import java.util.List;

public final class RepositoryfilesCatalogFixtures {

    private RepositoryfilesCatalogFixtures() {}

    public static GitLabBlameRange blameRange() {
        return GitLabBlameRangeBuilder.builder()
                .commit(RepositoryfilesCatalogFixtures.blameRangeCommit())
                .lines(List.of("lorem ipsum"))
                .build();
    }

    public static GitLabBlameRangeCommit blameRangeCommit() {
        return GitLabBlameRangeCommitBuilder.builder()
                .id("2695effb5807a22ff3d138d593fd856244e155e7")
                .parentIds(List.of("2a4b78934375d7f53875269ffd4f45fd83a84ebe"))
                .message("Initial commit")
                .authoredDate(Instant.parse("2026-01-01T00:00:00Z"))
                .authorName("John Smith")
                .authorEmail("john@example.com")
                .committedDate(Instant.parse("2026-01-01T00:00:00Z"))
                .committerName("Jack Smith")
                .committerEmail("jack@example.com")
                .build();
    }

    public static GitLabProjectRepositoryFilesCreateResponse projectRepositoryFilesCreateResponse() {
        return GitLabProjectRepositoryFilesCreateResponseBuilder.builder()
                .filePath("file_path")
                .branch("branch")
                .build();
    }

    public static GitLabProjectRepositoryFilesGetResponse projectRepositoryFilesGetResponse() {
        return GitLabProjectRepositoryFilesGetResponseBuilder.builder()
                .fileName("file_name")
                .filePath("file_path")
                .size(1L)
                .encoding("encoding")
                .content("content")
                .contentSha256("content_sha256")
                .ref("ref")
                .blobId("blob_id")
                .commitId("commit_id")
                .lastCommitId("last_commit_id")
                .executeFilemode(true)
                .build();
    }

    public static GitLabProjectRepositoryFilesUpdateResponse projectRepositoryFilesUpdateResponse() {
        return GitLabProjectRepositoryFilesUpdateResponseBuilder.builder()
                .filePath("file_path")
                .branch("branch")
                .build();
    }
}

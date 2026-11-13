package io.github.piotr_janczukowicz.gitlab.api.codesnippets;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public final class CodesnippetsCatalogFixtures {

    private CodesnippetsCatalogFixtures() {}

    public static GitLabCodeSnippetsCreateFile codeSnippetsCreateFile() {
        return GitLabCodeSnippetsCreateFileBuilder.builder()
                .filePath("file_path")
                .content("content")
                .build();
    }

    public static GitLabCodeSnippetsCreatePayload codeSnippetsCreatePayload() {
        return GitLabCodeSnippetsCreatePayloadBuilder.builder()
                .title("title")
                .description("description")
                .visibility(GitLabCodeSnippetsCreateVisibility.PRIVATE)
                .files(List.of(CodesnippetsCatalogFixtures.codeSnippetsCreateFile()))
                .content("content")
                .fileName("file_name")
                .build();
    }

    public static GitLabCodeSnippetsCreateRepositoryStorageMovePayload
            codeSnippetsCreateRepositoryStorageMovePayload() {
        return GitLabCodeSnippetsCreateRepositoryStorageMovePayloadBuilder.builder()
                .destinationStorageName("destination_storage_name")
                .build();
    }

    public static GitLabCodeSnippetsUpdateFile codeSnippetsUpdateFile() {
        return GitLabCodeSnippetsUpdateFileBuilder.builder()
                .action(GitLabCodeSnippetsUpdateFileAction.CREATE)
                .content("content")
                .filePath("file_path")
                .previousPath("previous_path")
                .build();
    }

    public static GitLabCodeSnippetsUpdatePayload codeSnippetsUpdatePayload() {
        return GitLabCodeSnippetsUpdatePayloadBuilder.builder()
                .content("content")
                .description("description")
                .fileName("file_name")
                .title("title")
                .visibility(GitLabCodeSnippetsUpdateVisibility.PRIVATE)
                .files(List.of(CodesnippetsCatalogFixtures.codeSnippetsUpdateFile()))
                .build();
    }

    public static GitLabPersonalSnippet personalSnippet() {
        return GitLabPersonalSnippetBuilder.builder()
                .id(1L)
                .title("test")
                .description("Ruby test snippet")
                .visibility("public")
                .author(CommonCatalogFixtures.userBasic())
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .projectId(1L)
                .webUrl("http://example.com/example/example/snippets/1")
                .rawUrl("http://example.com/example/example/snippets/1/raw")
                .sshUrlToRepo("ssh://user@gitlab.example.com/snippets/65.git")
                .httpUrlToRepo("https://gitlab.example.com/snippets/65.git")
                .fileName("add.rb")
                .files(List.of(Map.of("key", "value")))
                .imported(true)
                .importedFrom("none")
                .repositoryStorage("default")
                .build();
    }

    public static GitLabSnippet snippet() {
        return GitLabSnippetBuilder.builder()
                .id(1L)
                .title("test")
                .description("Ruby test snippet")
                .visibility("public")
                .author(CommonCatalogFixtures.userBasic())
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .projectId(1L)
                .webUrl("http://example.com/example/example/snippets/1")
                .rawUrl("http://example.com/example/example/snippets/1/raw")
                .sshUrlToRepo("ssh://user@gitlab.example.com/snippets/65.git")
                .httpUrlToRepo("https://gitlab.example.com/snippets/65.git")
                .fileName("add.rb")
                .files(List.of(Map.of("key", "value")))
                .imported(true)
                .importedFrom("none")
                .repositoryStorage("default")
                .build();
    }
}

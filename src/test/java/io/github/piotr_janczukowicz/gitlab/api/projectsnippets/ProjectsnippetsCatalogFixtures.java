package io.github.piotr_janczukowicz.gitlab.api.projectsnippets;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public final class ProjectsnippetsCatalogFixtures {

    private ProjectsnippetsCatalogFixtures() {}

    public static GitLabProjectProjectSnippetsCreateFile projectProjectSnippetsCreateFile() {
        return GitLabProjectProjectSnippetsCreateFileBuilder.builder()
                .filePath("file_path")
                .content("content")
                .build();
    }

    public static GitLabProjectProjectSnippetsCreatePayload projectProjectSnippetsCreatePayload() {
        return GitLabProjectProjectSnippetsCreatePayloadBuilder.builder()
                .title("title")
                .description("description")
                .visibility(GitLabProjectProjectSnippetsCreateVisibility.PRIVATE)
                .files(List.of(ProjectsnippetsCatalogFixtures.projectProjectSnippetsCreateFile()))
                .content("content")
                .fileName("file_name")
                .build();
    }

    public static GitLabProjectProjectSnippetsUpdateFile projectProjectSnippetsUpdateFile() {
        return GitLabProjectProjectSnippetsUpdateFileBuilder.builder()
                .action(GitLabProjectProjectSnippetsUpdateFileAction.CREATE)
                .content("content")
                .filePath("file_path")
                .previousPath("previous_path")
                .build();
    }

    public static GitLabProjectProjectSnippetsUpdatePayload projectProjectSnippetsUpdatePayload() {
        return GitLabProjectProjectSnippetsUpdatePayloadBuilder.builder()
                .content("content")
                .description("description")
                .fileName("file_name")
                .title("title")
                .visibility(GitLabProjectProjectSnippetsUpdateVisibility.PRIVATE)
                .files(List.of(ProjectsnippetsCatalogFixtures.projectProjectSnippetsUpdateFile()))
                .build();
    }

    public static GitLabProjectSnippet projectSnippet() {
        return GitLabProjectSnippetBuilder.builder()
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

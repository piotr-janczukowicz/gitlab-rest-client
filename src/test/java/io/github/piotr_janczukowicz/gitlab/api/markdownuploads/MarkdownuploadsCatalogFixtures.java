package io.github.piotr_janczukowicz.gitlab.api.markdownuploads;

public final class MarkdownuploadsCatalogFixtures {

    private MarkdownuploadsCatalogFixtures() {}

    public static GitLabProjectUpload projectUpload() {
        return GitLabProjectUploadBuilder.builder()
                .id(1L)
                .alt("filename")
                .url("/uploads/secret/filename")
                .fullPath("/-/project/1/uploads/secret/filename")
                .markdown("[filename](/uploads/secret/filename)")
                .build();
    }
}

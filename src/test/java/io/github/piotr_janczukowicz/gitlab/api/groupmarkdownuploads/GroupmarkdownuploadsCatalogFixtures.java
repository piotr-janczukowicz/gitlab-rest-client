package io.github.piotr_janczukowicz.gitlab.api.groupmarkdownuploads;

public final class GroupmarkdownuploadsCatalogFixtures {

    private GroupmarkdownuploadsCatalogFixtures() {}

    public static GitLabGroupUpload groupUpload() {
        return GitLabGroupUploadBuilder.builder()
                .id(1L)
                .alt("alt")
                .url("url")
                .fullPath("full_path")
                .markdown("markdown")
                .build();
    }
}

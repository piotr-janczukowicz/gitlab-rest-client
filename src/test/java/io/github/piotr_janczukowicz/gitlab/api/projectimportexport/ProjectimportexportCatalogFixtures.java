package io.github.piotr_janczukowicz.gitlab.api.projectimportexport;

import java.time.Instant;
import java.util.List;

public final class ProjectimportexportCatalogFixtures {

    private ProjectimportexportCatalogFixtures() {}

    public static GitLabProjectExportStatus projectExportStatus() {
        return GitLabProjectExportStatusBuilder.builder()
                .id(1L)
                .description("desc")
                .name("project1")
                .nameWithNamespace("John Doe / project1")
                .path("project1")
                .pathWithNamespace("namespace1/project1")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .exportStatus(GitLabProjectExportStatusExportStatus.QUEUED)
                .links(ProjectimportexportCatalogFixtures.projectExportStatusLinks())
                .build();
    }

    public static GitLabProjectExportStatusLinks projectExportStatusLinks() {
        return GitLabProjectExportStatusLinksBuilder.builder()
                .apiUrl("https://gitlab.example.com/api/v4/projects/1/export/download")
                .webUrl("https://gitlab.example.com/gitlab-org/gitlab-test/download_export")
                .build();
    }

    public static GitLabProjectProjectImportExportCreateProjectPayload
            projectProjectImportExportCreateProjectPayload() {
        return GitLabProjectProjectImportExportCreateProjectPayloadBuilder.builder()
                .description("description")
                .upload(ProjectimportexportCatalogFixtures.projectProjectImportExportCreateProjectUpload())
                .excludedRelations(List.of("excluded_relations"))
                .build();
    }

    public static GitLabProjectProjectImportExportCreateProjectUpload projectProjectImportExportCreateProjectUpload() {
        return GitLabProjectProjectImportExportCreateProjectUploadBuilder.builder()
                .url("url")
                .httpMethod(GitLabProjectProjectImportExportCreateProjectUploadHttpMethod.PUT)
                .build();
    }

    public static GitLabProjectProjectImportExportGitPayload projectProjectImportExportGitPayload() {
        return GitLabProjectProjectImportExportGitPayloadBuilder.builder()
                .importUrl("import_url")
                .importUrlUser("import_url_user")
                .importUrlPassword("import_url_password")
                .build();
    }
}

package io.github.piotr_janczukowicz.gitlab.api.projectimport;

public final class ProjectimportCatalogFixtures {

    private ProjectimportCatalogFixtures() {}

    public static GitLabProjectImportCreatePayload projectImportCreatePayload() {
        return GitLabProjectImportCreatePayloadBuilder.builder()
                .bitbucketEmail("bitbucket_email")
                .bitbucketApiToken("bitbucket_api_token")
                .repoPath("repo_path")
                .targetNamespace("target_namespace")
                .newName("new_name")
                .build();
    }
}

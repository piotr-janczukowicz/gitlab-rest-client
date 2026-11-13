package io.github.piotr_janczukowicz.gitlab.api.importrepositoryfromgithub;

import java.util.Map;

public final class ImportrepositoryfromgithubCatalogFixtures {

    private ImportrepositoryfromgithubCatalogFixtures() {}

    public static GitLabImportRepositoryFromGitHubCancelPayload importRepositoryFromGitHubCancelPayload() {
        return GitLabImportRepositoryFromGitHubCancelPayloadBuilder.builder()
                .projectId(1L)
                .build();
    }

    public static GitLabImportRepositoryFromGitHubCreateGistPayload importRepositoryFromGitHubCreateGistPayload() {
        return GitLabImportRepositoryFromGitHubCreateGistPayloadBuilder.builder()
                .personalAccessToken("personal_access_token")
                .build();
    }

    public static GitLabImportRepositoryFromGitHubCreatePayload importRepositoryFromGitHubCreatePayload() {
        return GitLabImportRepositoryFromGitHubCreatePayloadBuilder.builder()
                .personalAccessToken("personal_access_token")
                .repoId(1L)
                .newName("new_name")
                .targetNamespace("target_namespace")
                .githubHostname("github_hostname")
                .optionalStages(Map.of("key", "value"))
                .timeoutStrategy(GitLabImportRepositoryFromGitHubCreateTimeoutStrategy.OPTIMISTIC)
                .paginationLimit(1)
                .build();
    }
}

package io.github.piotr_janczukowicz.gitlab.api.repositorysubmodules;

public final class RepositorysubmodulesCatalogFixtures {

    private RepositorysubmodulesCatalogFixtures() {}

    public static GitLabProjectRepositorySubmodulesUpdatePayload projectRepositorySubmodulesUpdatePayload() {
        return GitLabProjectRepositorySubmodulesUpdatePayloadBuilder.builder()
                .commitSha("ed899a2f4b50b4370feeea94676502b42383c746")
                .branch("main")
                .commitMessage("Commit message")
                .build();
    }
}

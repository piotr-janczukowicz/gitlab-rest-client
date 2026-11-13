package io.github.piotr_janczukowicz.gitlab.api.protectedcontainerregistry;

public final class ProtectedcontainerregistryCatalogFixtures {

    private ProtectedcontainerregistryCatalogFixtures() {}

    public static GitLabContainerRegistryRuleCreatePayload containerRegistryRuleCreatePayload() {
        return GitLabContainerRegistryRuleCreatePayloadBuilder.builder()
                .repositoryPathPattern("repository_path_pattern")
                .minimumAccessLevelForPush(GitLabContainerRegistryRuleCreateMinimumAccessLevelForPush.MAINTAINER)
                .minimumAccessLevelForDelete(GitLabContainerRegistryRuleCreateMinimumAccessLevelForDelete.MAINTAINER)
                .build();
    }

    public static GitLabContainerRegistryRuleUpdatePayload containerRegistryRuleUpdatePayload() {
        return GitLabContainerRegistryRuleUpdatePayloadBuilder.builder()
                .repositoryPathPattern("repository_path_pattern")
                .minimumAccessLevelForPush(GitLabContainerRegistryRuleUpdateMinimumAccessLevelForPush.EMPTY)
                .minimumAccessLevelForDelete(GitLabContainerRegistryRuleUpdateMinimumAccessLevelForDelete.EMPTY)
                .build();
    }

    public static GitLabProjectContainerRegistryProtectionRule projectContainerRegistryProtectionRule() {
        return GitLabProjectContainerRegistryProtectionRuleBuilder.builder()
                .id(1L)
                .projectId(1L)
                .repositoryPathPattern("flightjs/flight0")
                .minimumAccessLevelForPush("maintainer")
                .minimumAccessLevelForDelete("maintainer")
                .build();
    }
}

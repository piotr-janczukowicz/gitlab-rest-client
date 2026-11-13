package io.github.piotr_janczukowicz.gitlab.api.containerregistryprotectiontagrules;

public final class ContainerregistryprotectiontagrulesCatalogFixtures {

    private ContainerregistryprotectiontagrulesCatalogFixtures() {}

    public static GitLabContainerTagRuleCreatePayload containerTagRuleCreatePayload() {
        return GitLabContainerTagRuleCreatePayloadBuilder.builder()
                .tagNamePattern("tag_name_pattern")
                .minimumAccessLevelForPush(GitLabContainerTagRuleCreateMinimumAccessLevelForPush.MAINTAINER)
                .minimumAccessLevelForDelete(GitLabContainerTagRuleCreateMinimumAccessLevelForDelete.MAINTAINER)
                .build();
    }

    public static GitLabContainerTagRuleUpdatePayload containerTagRuleUpdatePayload() {
        return GitLabContainerTagRuleUpdatePayloadBuilder.builder()
                .tagNamePattern("tag_name_pattern")
                .minimumAccessLevelForPush(GitLabContainerTagRuleUpdateMinimumAccessLevelForPush.EMPTY)
                .minimumAccessLevelForDelete(GitLabContainerTagRuleUpdateMinimumAccessLevelForDelete.EMPTY)
                .build();
    }

    public static GitLabProjectContainerRegistryProtectionTagRule projectContainerRegistryProtectionTagRule() {
        return GitLabProjectContainerRegistryProtectionTagRuleBuilder.builder()
                .id(1L)
                .projectId(1L)
                .tagNamePattern("v*-release")
                .minimumAccessLevelForPush("maintainer")
                .minimumAccessLevelForDelete("maintainer")
                .build();
    }
}

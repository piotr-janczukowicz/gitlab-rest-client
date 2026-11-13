package io.github.piotr_janczukowicz.gitlab.api.protectedenvironments;

import java.util.List;

public final class ProtectedenvironmentsCatalogFixtures {

    private ProtectedenvironmentsCatalogFixtures() {}

    public static GitLabProjectProtectedEnvironmentCreateApprovalRule projectProtectedEnvironmentCreateApprovalRule() {
        return GitLabProjectProtectedEnvironmentCreateApprovalRuleBuilder.builder()
                .userId(1L)
                .groupId(1L)
                .groupInheritanceType(GitLabProjectProtectedEnvironmentCreateApprovalRuleGroupInheritanceType.N_0)
                .id(1L)
                .destroy(true)
                .accessLevel(GitLabProjectProtectedEnvironmentCreateApprovalRuleAccessLevel.MAINTAINER)
                .requiredApprovals(1)
                .build();
    }

    public static GitLabProjectProtectedEnvironmentCreateDeployAccessLevel
            projectProtectedEnvironmentCreateDeployAccessLevel() {
        return GitLabProjectProtectedEnvironmentCreateDeployAccessLevelBuilder.builder()
                .userId(1L)
                .groupId(1L)
                .groupInheritanceType(GitLabProjectProtectedEnvironmentCreateDeployAccessLevelGroupInheritanceType.N_0)
                .accessLevel(GitLabProjectProtectedEnvironmentCreateDeployAccessLevelAccessLevel.MAINTAINER)
                .build();
    }

    public static GitLabProjectProtectedEnvironmentCreatePayload projectProtectedEnvironmentCreatePayload() {
        return GitLabProjectProtectedEnvironmentCreatePayloadBuilder.builder()
                .name("name")
                .requiredApprovalCount(1)
                .deployAccessLevels(List.of(
                        ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreateDeployAccessLevel()))
                .approvalRules(
                        List.of(ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreateApprovalRule()))
                .build();
    }

    public static GitLabProjectProtectedEnvironmentUpdateApprovalRule projectProtectedEnvironmentUpdateApprovalRule() {
        return GitLabProjectProtectedEnvironmentUpdateApprovalRuleBuilder.builder()
                .userId(1L)
                .groupId(1L)
                .groupInheritanceType(GitLabProjectProtectedEnvironmentUpdateApprovalRuleGroupInheritanceType.N_0)
                .id(1L)
                .destroy(true)
                .accessLevel(GitLabProjectProtectedEnvironmentUpdateApprovalRuleAccessLevel.MAINTAINER)
                .requiredApprovals(1)
                .build();
    }

    public static GitLabProjectProtectedEnvironmentUpdateDeployAccessLevel
            projectProtectedEnvironmentUpdateDeployAccessLevel() {
        return GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelBuilder.builder()
                .userId(1L)
                .groupId(1L)
                .groupInheritanceType(GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelGroupInheritanceType.N_0)
                .id(1L)
                .destroy(true)
                .accessLevel(GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelAccessLevel.MAINTAINER)
                .build();
    }

    public static GitLabProjectProtectedEnvironmentUpdatePayload projectProtectedEnvironmentUpdatePayload() {
        return GitLabProjectProtectedEnvironmentUpdatePayloadBuilder.builder()
                .requiredApprovalCount(1)
                .deployAccessLevels(List.of(
                        ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentUpdateDeployAccessLevel()))
                .approvalRules(
                        List.of(ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentUpdateApprovalRule()))
                .build();
    }
}

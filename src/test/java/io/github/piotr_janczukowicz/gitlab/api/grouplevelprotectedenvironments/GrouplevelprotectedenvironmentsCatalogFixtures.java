package io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedenvironments;

import java.util.List;

public final class GrouplevelprotectedenvironmentsCatalogFixtures {

    private GrouplevelprotectedenvironmentsCatalogFixtures() {}

    public static GitLabGroupProtectedEnvironmentCreateApprovalRule groupProtectedEnvironmentCreateApprovalRule() {
        return GitLabGroupProtectedEnvironmentCreateApprovalRuleBuilder.builder()
                .userId(1L)
                .groupId(1L)
                .groupInheritanceType(GitLabGroupProtectedEnvironmentCreateApprovalRuleGroupInheritanceType.N_0)
                .id(1L)
                .destroy(true)
                .accessLevel(GitLabGroupProtectedEnvironmentCreateApprovalRuleAccessLevel.MAINTAINER)
                .requiredApprovals(1)
                .build();
    }

    public static GitLabGroupProtectedEnvironmentCreateDeployAccessLevel
            groupProtectedEnvironmentCreateDeployAccessLevel() {
        return GitLabGroupProtectedEnvironmentCreateDeployAccessLevelBuilder.builder()
                .userId(1L)
                .groupId(1L)
                .groupInheritanceType(GitLabGroupProtectedEnvironmentCreateDeployAccessLevelGroupInheritanceType.N_0)
                .accessLevel(GitLabGroupProtectedEnvironmentCreateDeployAccessLevelAccessLevel.MAINTAINER)
                .build();
    }

    public static GitLabGroupProtectedEnvironmentCreatePayload groupProtectedEnvironmentCreatePayload() {
        return GitLabGroupProtectedEnvironmentCreatePayloadBuilder.builder()
                .name(GitLabGroupProtectedEnvironmentCreateName.PRODUCTION)
                .requiredApprovalCount(1)
                .deployAccessLevels(List.of(
                        GrouplevelprotectedenvironmentsCatalogFixtures
                                .groupProtectedEnvironmentCreateDeployAccessLevel()))
                .approvalRules(List.of(
                        GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentCreateApprovalRule()))
                .build();
    }

    public static GitLabGroupProtectedEnvironmentUpdateApprovalRule groupProtectedEnvironmentUpdateApprovalRule() {
        return GitLabGroupProtectedEnvironmentUpdateApprovalRuleBuilder.builder()
                .userId(1L)
                .groupId(1L)
                .groupInheritanceType(GitLabGroupProtectedEnvironmentUpdateApprovalRuleGroupInheritanceType.N_0)
                .id(1L)
                .destroy(true)
                .accessLevel(GitLabGroupProtectedEnvironmentUpdateApprovalRuleAccessLevel.MAINTAINER)
                .requiredApprovals(1)
                .build();
    }

    public static GitLabGroupProtectedEnvironmentUpdateDeployAccessLevel
            groupProtectedEnvironmentUpdateDeployAccessLevel() {
        return GitLabGroupProtectedEnvironmentUpdateDeployAccessLevelBuilder.builder()
                .userId(1L)
                .groupId(1L)
                .groupInheritanceType(GitLabGroupProtectedEnvironmentUpdateDeployAccessLevelGroupInheritanceType.N_0)
                .id(1L)
                .destroy(true)
                .accessLevel(GitLabGroupProtectedEnvironmentUpdateDeployAccessLevelAccessLevel.MAINTAINER)
                .build();
    }

    public static GitLabGroupProtectedEnvironmentUpdatePayload groupProtectedEnvironmentUpdatePayload() {
        return GitLabGroupProtectedEnvironmentUpdatePayloadBuilder.builder()
                .requiredApprovalCount(1)
                .deployAccessLevels(List.of(
                        GrouplevelprotectedenvironmentsCatalogFixtures
                                .groupProtectedEnvironmentUpdateDeployAccessLevel()))
                .approvalRules(List.of(
                        GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentUpdateApprovalRule()))
                .build();
    }
}

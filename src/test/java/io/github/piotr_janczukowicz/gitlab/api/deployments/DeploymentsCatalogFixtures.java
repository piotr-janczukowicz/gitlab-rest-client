package io.github.piotr_janczukowicz.gitlab.api.deployments;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;
import java.util.List;

public final class DeploymentsCatalogFixtures {

    private DeploymentsCatalogFixtures() {}

    public static GitLabDeploymentApproval deploymentApproval() {
        return GitLabDeploymentApprovalBuilder.builder()
                .user(CommonCatalogFixtures.userBasic())
                .status("approved")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .comment("LGTM")
                .build();
    }

    public static GitLabDeploymentApprovalSummary deploymentApprovalSummary() {
        return GitLabDeploymentApprovalSummaryBuilder.builder()
                .rules(List.of(DeploymentsCatalogFixtures.protectedEnvironmentsApprovalRuleForSummary()))
                .build();
    }

    public static GitLabDeploymentExtended deploymentExtended() {
        return GitLabDeploymentExtendedBuilder.builder()
                .id(1L)
                .iid(1L)
                .ref("main")
                .sha("99d03678b90d914dbb1b109132516d71a4a03ea8")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .user(CommonCatalogFixtures.userBasic())
                .environment(CommonCatalogFixtures.environmentBasic())
                .deployable(CommonCatalogFixtures.ciJob())
                .status("created")
                .pendingApprovalCount(1)
                .approvals(List.of(DeploymentsCatalogFixtures.deploymentApproval()))
                .approvalSummary(DeploymentsCatalogFixtures.deploymentApprovalSummary())
                .build();
    }

    public static GitLabProjectDeploymentsApprovalPayload projectDeploymentsApprovalPayload() {
        return GitLabProjectDeploymentsApprovalPayloadBuilder.builder()
                .status(GitLabProjectDeploymentsApprovalStatus.APPROVED)
                .comment("comment")
                .representedAs("represented_as")
                .build();
    }

    public static GitLabProjectDeploymentsCreatePayload projectDeploymentsCreatePayload() {
        return GitLabProjectDeploymentsCreatePayloadBuilder.builder()
                .environment("environment")
                .sha("sha")
                .ref("ref")
                .tag(true)
                .status(GitLabProjectDeploymentsCreateStatus.RUNNING)
                .build();
    }

    public static GitLabProjectDeploymentsUpdatePayload projectDeploymentsUpdatePayload() {
        return GitLabProjectDeploymentsUpdatePayloadBuilder.builder()
                .status(GitLabProjectDeploymentsUpdateStatus.RUNNING)
                .build();
    }

    public static GitLabProtectedEnvironmentsApprovalRuleForSummary protectedEnvironmentsApprovalRuleForSummary() {
        return GitLabProtectedEnvironmentsApprovalRuleForSummaryBuilder.builder()
                .id(1L)
                .userId(1L)
                .groupId(1L)
                .accessLevel(1)
                .accessLevelDescription("access_level_description")
                .requiredApprovals(1)
                .groupInheritanceType(1)
                .deploymentApprovals(DeploymentsCatalogFixtures.deploymentApproval())
                .build();
    }
}

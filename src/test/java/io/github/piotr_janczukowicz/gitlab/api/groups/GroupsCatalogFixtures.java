package io.github.piotr_janczukowicz.gitlab.api.groups;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public final class GroupsCatalogFixtures {

    private GroupsCatalogFixtures() {}

    public static GitLabAiSettings aiSettings() {
        return GitLabAiSettingsBuilder.builder()
                .duoAgentPlatformEnabled(true)
                .duoWorkflowMcpEnabled(true)
                .foundationalAgentsDefaultEnabled(true)
                .aiCatalogRestrictedToGroupHierarchy(true)
                .aiUsageDataCollectionEnabled(true)
                .promptInjectionProtectionLevel("no_checks")
                .webSearchEnabled(true)
                .includeRecommendedAllowed(true)
                .allowAllUnixSockets(true)
                .allowProjectExtension(true)
                .requireSandbox(true)
                .minimumAccessLevelExecute("developer")
                .minimumAccessLevelExecuteAsync("developer")
                .minimumAccessLevelManage("maintainer")
                .minimumAccessLevelEnableOnProjects("maintainer")
                .build();
    }

    public static GitLabClusterGroup clusterGroup() {
        return GitLabClusterGroupBuilder.builder()
                .id("id")
                .name("name")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .domain("domain")
                .enabled("enabled")
                .managed("managed")
                .providerType("provider_type")
                .platformType("platform_type")
                .environmentScope("environment_scope")
                .clusterType("cluster_type")
                .namespacePerEnvironment("namespace_per_environment")
                .user(CommonCatalogFixtures.userBasic())
                .platformKubernetes(CommonCatalogFixtures.platformKubernetes())
                .providerGcp(CommonCatalogFixtures.providerGcp())
                .managementProject(CommonCatalogFixtures.projectIdentity())
                .group(CommonCatalogFixtures.basicGroupDetails())
                .build();
    }

    public static GitLabGroupApprovalRule groupApprovalRule() {
        return GitLabGroupApprovalRuleBuilder.builder()
                .id(1L)
                .name("QA")
                .ruleType("regular")
                .eligibleApprovers(List.of(CommonCatalogFixtures.userBasic()))
                .approvalsRequired(1)
                .users(List.of(CommonCatalogFixtures.userBasic()))
                .groups(List.of(CommonCatalogFixtures.group()))
                .containsHiddenGroups(true)
                .reportType("report_type")
                .protectedBranches(CommonCatalogFixtures.protectedBranch())
                .appliesToAllProtectedBranches(true)
                .build();
    }

    public static GitLabGroupClusterUserCreatePayload groupClusterUserCreatePayload() {
        return GitLabGroupClusterUserCreatePayloadBuilder.builder()
                .name("name")
                .enabled(true)
                .environmentScope("environment_scope")
                .namespacePerEnvironment(true)
                .domain("domain")
                .managementProjectId(1L)
                .managed(true)
                .platformKubernetesAttributes(
                        GroupsCatalogFixtures.groupClusterUserCreatePlatformKubernetesAttributes())
                .build();
    }

    public static GitLabGroupClusterUserCreatePlatformKubernetesAttributes
            groupClusterUserCreatePlatformKubernetesAttributes() {
        return GitLabGroupClusterUserCreatePlatformKubernetesAttributesBuilder.builder()
                .apiUrl("api_url")
                .token("token")
                .caCert("ca_cert")
                .namespace("namespace")
                .authorizationType(
                        GitLabGroupClusterUserCreatePlatformKubernetesAttributesAuthorizationType.UNKNOWN_AUTHORIZATION)
                .build();
    }

    public static GitLabGroupDetail groupDetail() {
        return GitLabGroupDetailBuilder.builder()
                .id(1L)
                .webUrl("http://gitlab.example.com/groups/diaspora")
                .name("Diaspora")
                .path("path")
                .description("description")
                .visibility("visibility")
                .shareWithGroupLock(true)
                .requireTwoFactorAuthentication(true)
                .twoFactorGracePeriod(1)
                .projectCreationLevel("project_creation_level")
                .autoDevopsEnabled("auto_devops_enabled")
                .subgroupCreationLevel("subgroup_creation_level")
                .emailsDisabled(true)
                .emailsEnabled(true)
                .showDiffPreviewInEmail(true)
                .mentionsDisabled(true)
                .lfsEnabled(true)
                .archived(true)
                .mathRenderingLimitsEnabled(true)
                .lockMathRenderingLimitsEnabled(true)
                .crmEnabled(true)
                .resourceAccessTokenNotifyInherited(true)
                .lockResourceAccessTokenNotifyInherited(true)
                .defaultBranch("default_branch")
                .defaultBranchProtection(1)
                .defaultBranchProtectionDefaults(GroupsCatalogFixtures.groupDetailDefaultBranchProtectionDefaults())
                .avatarUrl("avatar_url")
                .requestAccessEnabled(true)
                .fullName("full_name")
                .fullPath("full_path")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .parentId("parent_id")
                .organizationId(1L)
                .sharedRunnersSetting("shared_runners_setting")
                .maxArtifactsSize(1L)
                .customAttributes(List.of(CommonCatalogFixtures.customAttribute()))
                .statistics(GroupsCatalogFixtures.groupDetailStatistics())
                .markedForDeletionOn("marked_for_deletion_on")
                .rootStorageStatistics(CommonCatalogFixtures.namespaceRootStorageStatistics())
                .ldapCn("ldap_cn")
                .ldapAccess("ldap_access")
                .ldapGroupLinks(CommonCatalogFixtures.ldapGroupLink())
                .samlGroupLinks(CommonCatalogFixtures.samlGroupLink())
                .fileTemplateProjectId(1L)
                .wikiAccessLevel("wiki_access_level")
                .repositoryStorage("repository_storage")
                .duoCoreFeaturesEnabled(true)
                .duoFeaturesEnabled(true)
                .lockDuoFeaturesEnabled(true)
                .autoDuoCodeReviewEnabled("auto_duo_code_review_enabled")
                .duoCodeReviewDepthAllowed(true)
                .duoCodeReviewDefaultDepth("standard")
                .duoCodeReviewDecisionsEnabled("duo_code_review_decisions_enabled")
                .webBasedCommitSigningEnabled("web_based_commit_signing_enabled")
                .allowPersonalSnippets("allow_personal_snippets")
                .duoNamespaceAccessRules("duo_namespace_access_rules")
                .builtInProjectTemplatesEnabled(true)
                .lockBuiltInProjectTemplatesEnabled(true)
                .requireShaForMerge(true)
                .lockRequireShaForMerge(true)
                .requireTwoFactorAuthenticationFromAncestor(true)
                .sharedWithGroups(List.of(Map.of("key", "value")))
                .runnersToken("b8bc4a7a29eb76ea83cf79e4908c2b")
                .enabledGitAccessProtocol("ssh")
                .preventSharingGroupsOutsideHierarchy(true)
                .stepUpAuthRequiredOauthProvider("step_up_auth_required_oauth_provider")
                .projects(List.of(CommonCatalogFixtures.project()))
                .sharedProjects(List.of(CommonCatalogFixtures.project()))
                .sharedRunnersMinutesLimit(1)
                .extraSharedRunnersMinutesLimit(1)
                .preventForkingOutsideGroup(true)
                .serviceAccessTokensExpirationEnforced(true)
                .experimentFeaturesEnabled(true)
                .aiSettings(GroupsCatalogFixtures.aiSettings())
                .duoRemoteFlowsEnabled(true)
                .lockDuoRemoteFlowsEnabled(true)
                .membershipLock(true)
                .ipRestrictionRanges("ip_restriction_ranges")
                .allowedEmailDomainsList("allowed_email_domains_list")
                .onlyAllowMergeIfPipelineSucceeds(true)
                .allowMergeOnSkippedPipeline(true)
                .onlyAllowMergeIfAllDiscussionsAreResolved(true)
                .uniqueProjectDownloadLimit("unique_project_download_limit")
                .uniqueProjectDownloadLimitIntervalInSeconds("unique_project_download_limit_interval_in_seconds")
                .uniqueProjectDownloadLimitAllowlist("unique_project_download_limit_allowlist")
                .uniqueProjectDownloadLimitAlertlist("unique_project_download_limit_alertlist")
                .autoBanUserOnExcessiveProjectsDownload("auto_ban_user_on_excessive_projects_download")
                .build();
    }

    public static GitLabGroupDetailDefaultBranchProtectionDefaults groupDetailDefaultBranchProtectionDefaults() {
        return GitLabGroupDetailDefaultBranchProtectionDefaultsBuilder.builder()
                .allowedToPush(List.of(GroupsCatalogFixtures.groupDetailDefaultBranchProtectionDefaultsAllowedToPush()))
                .allowForcePush(true)
                .allowedToMerge(
                        List.of(GroupsCatalogFixtures.groupDetailDefaultBranchProtectionDefaultsAllowedToMerge()))
                .codeOwnerApprovalRequired(true)
                .developerCanInitialPush(true)
                .build();
    }

    public static GitLabGroupDetailDefaultBranchProtectionDefaultsAllowedToMerge
            groupDetailDefaultBranchProtectionDefaultsAllowedToMerge() {
        return GitLabGroupDetailDefaultBranchProtectionDefaultsAllowedToMergeBuilder.builder()
                .accessLevel(GitLabGroupDetailBranchProtectionMergeAccessLevel.DEVELOPER)
                .build();
    }

    public static GitLabGroupDetailDefaultBranchProtectionDefaultsAllowedToPush
            groupDetailDefaultBranchProtectionDefaultsAllowedToPush() {
        return GitLabGroupDetailDefaultBranchProtectionDefaultsAllowedToPushBuilder.builder()
                .accessLevel(GitLabGroupDetailBranchProtectionPushAccessLevel.DEVELOPER)
                .build();
    }

    public static GitLabGroupDetailStatistics groupDetailStatistics() {
        return GitLabGroupDetailStatisticsBuilder.builder()
                .storageSize("storage_size")
                .repositorySize("repository_size")
                .wikiSize("wiki_size")
                .lfsObjectsSize("lfs_objects_size")
                .jobArtifactsSize("job_artifacts_size")
                .pipelineArtifactsSize("pipeline_artifacts_size")
                .packagesSize("packages_size")
                .snippetsSize("snippets_size")
                .uploadsSize("uploads_size")
                .build();
    }

    public static GitLabGroupGroupsCreateApprovalRulePayload groupGroupsCreateApprovalRulePayload() {
        return GitLabGroupGroupsCreateApprovalRulePayloadBuilder.builder()
                .name("name")
                .approvalsRequired(1)
                .ruleType("regular")
                .userIds(List.of(1L))
                .groupIds(List.of(1L))
                .build();
    }

    public static GitLabGroupGroupsCreateDebianDistributionPayload groupGroupsCreateDebianDistributionPayload() {
        return GitLabGroupGroupsCreateDebianDistributionPayloadBuilder.builder()
                .codename("sid")
                .suite("unstable")
                .origin("Grep")
                .label("grep.be")
                .description("My description")
                .validTimeDurationSeconds(1)
                .components(List.of("components"))
                .architectures(List.of("architectures"))
                .build();
    }

    public static GitLabGroupGroupsCreateDependencyListExportPayload groupGroupsCreateDependencyListExportPayload() {
        return GitLabGroupGroupsCreateDependencyListExportPayloadBuilder.builder()
                .sendEmail(true)
                .exportType(GitLabGroupGroupsCreateDependencyListExportType.JSON_ARRAY)
                .build();
    }

    public static GitLabGroupGroupsCreateRepositoryStorageMovePayload groupGroupsCreateRepositoryStorageMovePayload() {
        return GitLabGroupGroupsCreateRepositoryStorageMovePayloadBuilder.builder()
                .destinationStorageName("destination_storage_name")
                .build();
    }

    public static GitLabGroupGroupsRotateManagePersonalAccessTokenPayload
            groupGroupsRotateManagePersonalAccessTokenPayload() {
        return GitLabGroupGroupsRotateManagePersonalAccessTokenPayloadBuilder.builder()
                .expiresAt(LocalDate.parse("2026-01-01"))
                .build();
    }

    public static GitLabGroupGroupsRotateManageResourceAccessTokenPayload
            groupGroupsRotateManageResourceAccessTokenPayload() {
        return GitLabGroupGroupsRotateManageResourceAccessTokenPayloadBuilder.builder()
                .expiresAt(LocalDate.parse("2026-01-01"))
                .build();
    }

    public static GitLabGroupGroupsSharePayload groupGroupsSharePayload() {
        return GitLabGroupGroupsSharePayloadBuilder.builder()
                .groupId(1L)
                .groupAccess(GitLabGroupGroupsShareGroupAccess.N_5)
                .expiresAt(LocalDate.parse("2026-01-01"))
                .memberRoleId(1L)
                .build();
    }

    public static GitLabGroupGroupsTransferPayload groupGroupsTransferPayload() {
        return GitLabGroupGroupsTransferPayloadBuilder.builder().groupId(1L).build();
    }

    public static GitLabGroupGroupsTransferToOrganizationPayload groupGroupsTransferToOrganizationPayload() {
        return GitLabGroupGroupsTransferToOrganizationPayloadBuilder.builder()
                .organizationId(1L)
                .build();
    }

    public static GitLabGroupGroupsUpdateApprovalRulePayload groupGroupsUpdateApprovalRulePayload() {
        return GitLabGroupGroupsUpdateApprovalRulePayloadBuilder.builder()
                .name("name")
                .approvalsRequired(1)
                .ruleType("regular")
                .userIds(List.of(1L))
                .groupIds(List.of(1L))
                .build();
    }

    public static GitLabGroupGroupsUpdateClusterPayload groupGroupsUpdateClusterPayload() {
        return GitLabGroupGroupsUpdateClusterPayloadBuilder.builder()
                .name("name")
                .enabled(true)
                .domain("domain")
                .environmentScope("environment_scope")
                .namespacePerEnvironment(true)
                .managementProjectId(1L)
                .managed(true)
                .platformKubernetesAttributes(
                        GroupsCatalogFixtures.groupGroupsUpdateClusterPlatformKubernetesAttributes())
                .build();
    }

    public static GitLabGroupGroupsUpdateClusterPlatformKubernetesAttributes
            groupGroupsUpdateClusterPlatformKubernetesAttributes() {
        return GitLabGroupGroupsUpdateClusterPlatformKubernetesAttributesBuilder.builder()
                .apiUrl("api_url")
                .token("token")
                .caCert("ca_cert")
                .namespace("namespace")
                .build();
    }

    public static GitLabGroupGroupsUpdateDebianDistributionPayload groupGroupsUpdateDebianDistributionPayload() {
        return GitLabGroupGroupsUpdateDebianDistributionPayloadBuilder.builder()
                .suite("unstable")
                .origin("Grep")
                .label("grep.be")
                .description("My description")
                .validTimeDurationSeconds(1)
                .components(List.of("components"))
                .architectures(List.of("architectures"))
                .build();
    }

    public static GitLabGroupGroupsUpdateSamlPayload groupGroupsUpdateSamlPayload() {
        return GitLabGroupGroupsUpdateSamlPayloadBuilder.builder()
                .externUid("extern_uid")
                .build();
    }

    public static GitLabGroupGroupsUpdateScimPayload groupGroupsUpdateScimPayload() {
        return GitLabGroupGroupsUpdateScimPayloadBuilder.builder()
                .externUid("extern_uid")
                .build();
    }

    public static GitLabSshKeyWithUserId sshKeyWithUserId() {
        return GitLabSshKeyWithUserIdBuilder.builder()
                .id(1L)
                .title("Sample key 25")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .lastUsedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .usageType("auth")
                .userId(1L)
                .build();
    }
}

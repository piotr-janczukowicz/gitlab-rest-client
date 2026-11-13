package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupDetailTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .id(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .webUrl(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .name(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .path(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .description(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVisibilityIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .visibility(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.visibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShareWithGroupLockIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .shareWithGroupLock(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.shareWithGroupLock()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequireTwoFactorAuthenticationIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .requireTwoFactorAuthentication(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.requireTwoFactorAuthentication()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTwoFactorGracePeriodIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .twoFactorGracePeriod(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.twoFactorGracePeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectCreationLevelIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .projectCreationLevel(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.projectCreationLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoDevopsEnabledIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .autoDevopsEnabled(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.autoDevopsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubgroupCreationLevelIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .subgroupCreationLevel(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.subgroupCreationLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailsDisabledIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .emailsDisabled(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.emailsDisabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailsEnabledIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .emailsEnabled(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.emailsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShowDiffPreviewInEmailIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .showDiffPreviewInEmail(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.showDiffPreviewInEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMentionsDisabledIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .mentionsDisabled(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.mentionsDisabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsEnabledIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .lfsEnabled(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.lfsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchivedIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .archived(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.archived()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMathRenderingLimitsEnabledIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .mathRenderingLimitsEnabled(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.mathRenderingLimitsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockMathRenderingLimitsEnabledIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .lockMathRenderingLimitsEnabled(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.lockMathRenderingLimitsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCrmEnabledIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .crmEnabled(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.crmEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceAccessTokenNotifyInheritedIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .resourceAccessTokenNotifyInherited(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.resourceAccessTokenNotifyInherited()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockResourceAccessTokenNotifyInheritedIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .lockResourceAccessTokenNotifyInherited(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.lockResourceAccessTokenNotifyInherited()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultBranchIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .defaultBranch(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.defaultBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultBranchProtectionIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .defaultBranchProtection(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.defaultBranchProtection()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultBranchProtectionDefaultsIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .defaultBranchProtectionDefaults(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.defaultBranchProtectionDefaults()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarUrlIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .avatarUrl(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.avatarUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequestAccessEnabledIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .requestAccessEnabled(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.requestAccessEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFullNameIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .fullName(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.fullName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFullPathIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .fullPath(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.fullPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .createdAt(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenParentIdIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .parentId(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.parentId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationIdIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .organizationId(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.organizationId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSharedRunnersSettingIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .sharedRunnersSetting(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.sharedRunnersSetting()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxArtifactsSizeIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .maxArtifactsSize(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.maxArtifactsSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .customAttributes(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatisticsIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .statistics(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.statistics()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMarkedForDeletionOnIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .markedForDeletionOn(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.markedForDeletionOn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRootStorageStatisticsIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .rootStorageStatistics(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.rootStorageStatistics()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLdapCnIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .ldapCn(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.ldapCn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLdapAccessIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .ldapAccess(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.ldapAccess()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLdapGroupLinksIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .ldapGroupLinks(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.ldapGroupLinks()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSamlGroupLinksIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .samlGroupLinks(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.samlGroupLinks()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFileTemplateProjectIdIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .fileTemplateProjectId(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.fileTemplateProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiAccessLevelIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .wikiAccessLevel(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.wikiAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryStorageIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .repositoryStorage(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.repositoryStorage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCoreFeaturesEnabledIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .duoCoreFeaturesEnabled(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.duoCoreFeaturesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoFeaturesEnabledIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .duoFeaturesEnabled(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.duoFeaturesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockDuoFeaturesEnabledIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .lockDuoFeaturesEnabled(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.lockDuoFeaturesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoDuoCodeReviewEnabledIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .autoDuoCodeReviewEnabled(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.autoDuoCodeReviewEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCodeReviewDepthAllowedIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .duoCodeReviewDepthAllowed(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.duoCodeReviewDepthAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCodeReviewDefaultDepthIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .duoCodeReviewDefaultDepth(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.duoCodeReviewDefaultDepth()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCodeReviewDecisionsEnabledIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .duoCodeReviewDecisionsEnabled(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.duoCodeReviewDecisionsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebBasedCommitSigningEnabledIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .webBasedCommitSigningEnabled(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.webBasedCommitSigningEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowPersonalSnippetsIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .allowPersonalSnippets(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.allowPersonalSnippets()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoNamespaceAccessRulesIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .duoNamespaceAccessRules(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.duoNamespaceAccessRules()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuiltInProjectTemplatesEnabledIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .builtInProjectTemplatesEnabled(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.builtInProjectTemplatesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockBuiltInProjectTemplatesEnabledIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .lockBuiltInProjectTemplatesEnabled(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.lockBuiltInProjectTemplatesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequireShaForMergeIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .requireShaForMerge(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.requireShaForMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockRequireShaForMergeIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .lockRequireShaForMerge(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.lockRequireShaForMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequireTwoFactorAuthenticationFromAncestorIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .requireTwoFactorAuthenticationFromAncestor(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.requireTwoFactorAuthenticationFromAncestor()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSharedWithGroupsIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .sharedWithGroups(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.sharedWithGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnersTokenIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .runnersToken(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.runnersToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnabledGitAccessProtocolIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .enabledGitAccessProtocol(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.enabledGitAccessProtocol()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreventSharingGroupsOutsideHierarchyIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .preventSharingGroupsOutsideHierarchy(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.preventSharingGroupsOutsideHierarchy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStepUpAuthRequiredOauthProviderIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .stepUpAuthRequiredOauthProvider(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.stepUpAuthRequiredOauthProvider()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectsIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .projects(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.projects()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSharedProjectsIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .sharedProjects(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.sharedProjects()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSharedRunnersMinutesLimitIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .sharedRunnersMinutesLimit(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.sharedRunnersMinutesLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExtraSharedRunnersMinutesLimitIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .extraSharedRunnersMinutesLimit(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.extraSharedRunnersMinutesLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreventForkingOutsideGroupIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .preventForkingOutsideGroup(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.preventForkingOutsideGroup()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceAccessTokensExpirationEnforcedIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .serviceAccessTokensExpirationEnforced(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.serviceAccessTokensExpirationEnforced()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExperimentFeaturesEnabledIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .experimentFeaturesEnabled(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.experimentFeaturesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiSettingsIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .aiSettings(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.aiSettings()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoRemoteFlowsEnabledIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .duoRemoteFlowsEnabled(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.duoRemoteFlowsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockDuoRemoteFlowsEnabledIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .lockDuoRemoteFlowsEnabled(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.lockDuoRemoteFlowsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMembershipLockIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .membershipLock(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.membershipLock()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIpRestrictionRangesIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .ipRestrictionRanges(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.ipRestrictionRanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowedEmailDomainsListIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .allowedEmailDomainsList(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.allowedEmailDomainsList()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlyAllowMergeIfPipelineSucceedsIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .onlyAllowMergeIfPipelineSucceeds(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.onlyAllowMergeIfPipelineSucceeds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowMergeOnSkippedPipelineIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .allowMergeOnSkippedPipeline(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.allowMergeOnSkippedPipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlyAllowMergeIfAllDiscussionsAreResolvedIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .onlyAllowMergeIfAllDiscussionsAreResolved(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.onlyAllowMergeIfAllDiscussionsAreResolved()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUniqueProjectDownloadLimitIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .uniqueProjectDownloadLimit(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.uniqueProjectDownloadLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUniqueProjectDownloadLimitIntervalInSecondsIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .uniqueProjectDownloadLimitIntervalInSeconds(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.uniqueProjectDownloadLimitIntervalInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUniqueProjectDownloadLimitAllowlistIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .uniqueProjectDownloadLimitAllowlist(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.uniqueProjectDownloadLimitAllowlist()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUniqueProjectDownloadLimitAlertlistIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .uniqueProjectDownloadLimitAlertlist(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.uniqueProjectDownloadLimitAlertlist()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoBanUserOnExcessiveProjectsDownloadIsNullable() {
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .autoBanUserOnExcessiveProjectsDownload(null);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.autoBanUserOnExcessiveProjectsDownload()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupDetail value = GroupsCatalogFixtures.groupDetail();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.webUrl()).isEqualTo("http://gitlab.example.com/groups/diaspora");
            softly.assertThat(value.name()).isEqualTo("Diaspora");
            softly.assertThat(value.path()).isEqualTo("path");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.visibility()).isEqualTo("visibility");
            softly.assertThat(value.shareWithGroupLock()).isEqualTo(true);
            softly.assertThat(value.requireTwoFactorAuthentication()).isEqualTo(true);
            softly.assertThat(value.twoFactorGracePeriod()).isEqualTo(1);
            softly.assertThat(value.projectCreationLevel()).isEqualTo("project_creation_level");
            softly.assertThat(value.autoDevopsEnabled()).isEqualTo("auto_devops_enabled");
            softly.assertThat(value.subgroupCreationLevel()).isEqualTo("subgroup_creation_level");
            softly.assertThat(value.emailsDisabled()).isEqualTo(true);
            softly.assertThat(value.emailsEnabled()).isEqualTo(true);
            softly.assertThat(value.showDiffPreviewInEmail()).isEqualTo(true);
            softly.assertThat(value.mentionsDisabled()).isEqualTo(true);
            softly.assertThat(value.lfsEnabled()).isEqualTo(true);
            softly.assertThat(value.archived()).isEqualTo(true);
            softly.assertThat(value.mathRenderingLimitsEnabled()).isEqualTo(true);
            softly.assertThat(value.lockMathRenderingLimitsEnabled()).isEqualTo(true);
            softly.assertThat(value.crmEnabled()).isEqualTo(true);
            softly.assertThat(value.resourceAccessTokenNotifyInherited()).isEqualTo(true);
            softly.assertThat(value.lockResourceAccessTokenNotifyInherited()).isEqualTo(true);
            softly.assertThat(value.defaultBranch()).isEqualTo("default_branch");
            softly.assertThat(value.defaultBranchProtection()).isEqualTo(1);
            softly.assertThat(value.defaultBranchProtectionDefaults())
                    .isEqualTo(GroupsCatalogFixtures.groupDetailDefaultBranchProtectionDefaults());
            softly.assertThat(value.avatarUrl()).isEqualTo("avatar_url");
            softly.assertThat(value.requestAccessEnabled()).isEqualTo(true);
            softly.assertThat(value.fullName()).isEqualTo("full_name");
            softly.assertThat(value.fullPath()).isEqualTo("full_path");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.parentId()).isEqualTo("parent_id");
            softly.assertThat(value.organizationId()).isEqualTo(1L);
            softly.assertThat(value.sharedRunnersSetting()).isEqualTo("shared_runners_setting");
            softly.assertThat(value.maxArtifactsSize()).isEqualTo(1L);
            softly.assertThat(value.customAttributes()).isEqualTo(List.of(CommonCatalogFixtures.customAttribute()));
            softly.assertThat(value.statistics()).isEqualTo(GroupsCatalogFixtures.groupDetailStatistics());
            softly.assertThat(value.markedForDeletionOn()).isEqualTo("marked_for_deletion_on");
            softly.assertThat(value.rootStorageStatistics())
                    .isEqualTo(CommonCatalogFixtures.namespaceRootStorageStatistics());
            softly.assertThat(value.ldapCn()).isEqualTo("ldap_cn");
            softly.assertThat(value.ldapAccess()).isEqualTo("ldap_access");
            softly.assertThat(value.ldapGroupLinks()).isEqualTo(CommonCatalogFixtures.ldapGroupLink());
            softly.assertThat(value.samlGroupLinks()).isEqualTo(CommonCatalogFixtures.samlGroupLink());
            softly.assertThat(value.fileTemplateProjectId()).isEqualTo(1L);
            softly.assertThat(value.wikiAccessLevel()).isEqualTo("wiki_access_level");
            softly.assertThat(value.repositoryStorage()).isEqualTo("repository_storage");
            softly.assertThat(value.duoCoreFeaturesEnabled()).isEqualTo(true);
            softly.assertThat(value.duoFeaturesEnabled()).isEqualTo(true);
            softly.assertThat(value.lockDuoFeaturesEnabled()).isEqualTo(true);
            softly.assertThat(value.autoDuoCodeReviewEnabled()).isEqualTo("auto_duo_code_review_enabled");
            softly.assertThat(value.duoCodeReviewDepthAllowed()).isEqualTo(true);
            softly.assertThat(value.duoCodeReviewDefaultDepth()).isEqualTo("standard");
            softly.assertThat(value.duoCodeReviewDecisionsEnabled()).isEqualTo("duo_code_review_decisions_enabled");
            softly.assertThat(value.webBasedCommitSigningEnabled()).isEqualTo("web_based_commit_signing_enabled");
            softly.assertThat(value.allowPersonalSnippets()).isEqualTo("allow_personal_snippets");
            softly.assertThat(value.duoNamespaceAccessRules()).isEqualTo("duo_namespace_access_rules");
            softly.assertThat(value.builtInProjectTemplatesEnabled()).isEqualTo(true);
            softly.assertThat(value.lockBuiltInProjectTemplatesEnabled()).isEqualTo(true);
            softly.assertThat(value.requireShaForMerge()).isEqualTo(true);
            softly.assertThat(value.lockRequireShaForMerge()).isEqualTo(true);
            softly.assertThat(value.requireTwoFactorAuthenticationFromAncestor())
                    .isEqualTo(true);
            softly.assertThat(value.sharedWithGroups()).isEqualTo(List.of(Map.of("key", "value")));
            softly.assertThat(value.runnersToken()).isEqualTo("b8bc4a7a29eb76ea83cf79e4908c2b");
            softly.assertThat(value.enabledGitAccessProtocol()).isEqualTo("ssh");
            softly.assertThat(value.preventSharingGroupsOutsideHierarchy()).isEqualTo(true);
            softly.assertThat(value.stepUpAuthRequiredOauthProvider())
                    .isEqualTo("step_up_auth_required_oauth_provider");
            softly.assertThat(value.projects()).isEqualTo(List.of(CommonCatalogFixtures.project()));
            softly.assertThat(value.sharedProjects()).isEqualTo(List.of(CommonCatalogFixtures.project()));
            softly.assertThat(value.sharedRunnersMinutesLimit()).isEqualTo(1);
            softly.assertThat(value.extraSharedRunnersMinutesLimit()).isEqualTo(1);
            softly.assertThat(value.preventForkingOutsideGroup()).isEqualTo(true);
            softly.assertThat(value.serviceAccessTokensExpirationEnforced()).isEqualTo(true);
            softly.assertThat(value.experimentFeaturesEnabled()).isEqualTo(true);
            softly.assertThat(value.aiSettings()).isEqualTo(GroupsCatalogFixtures.aiSettings());
            softly.assertThat(value.duoRemoteFlowsEnabled()).isEqualTo(true);
            softly.assertThat(value.lockDuoRemoteFlowsEnabled()).isEqualTo(true);
            softly.assertThat(value.membershipLock()).isEqualTo(true);
            softly.assertThat(value.ipRestrictionRanges()).isEqualTo("ip_restriction_ranges");
            softly.assertThat(value.allowedEmailDomainsList()).isEqualTo("allowed_email_domains_list");
            softly.assertThat(value.onlyAllowMergeIfPipelineSucceeds()).isEqualTo(true);
            softly.assertThat(value.allowMergeOnSkippedPipeline()).isEqualTo(true);
            softly.assertThat(value.onlyAllowMergeIfAllDiscussionsAreResolved()).isEqualTo(true);
            softly.assertThat(value.uniqueProjectDownloadLimit()).isEqualTo("unique_project_download_limit");
            softly.assertThat(value.uniqueProjectDownloadLimitIntervalInSeconds())
                    .isEqualTo("unique_project_download_limit_interval_in_seconds");
            softly.assertThat(value.uniqueProjectDownloadLimitAllowlist())
                    .isEqualTo("unique_project_download_limit_allowlist");
            softly.assertThat(value.uniqueProjectDownloadLimitAlertlist())
                    .isEqualTo("unique_project_download_limit_alertlist");
            softly.assertThat(value.autoBanUserOnExcessiveProjectsDownload())
                    .isEqualTo("auto_ban_user_on_excessive_projects_download");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupDetail original = GroupsCatalogFixtures.groupDetail();

        final GitLabGroupDetail rebuilt =
                GitLabGroupDetailBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenRunnersTokenIsACredential() {
        final GitLabGroupDetail value = GroupsCatalogFixtures.groupDetail();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabGroupDetailBuilder builder = GitLabGroupDetailBuilder.builder(GroupsCatalogFixtures.groupDetail())
                .createdAt(instant);

        final GitLabGroupDetail built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupDetail.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "webUrl",
                        "name",
                        "path",
                        "description",
                        "visibility",
                        "shareWithGroupLock",
                        "requireTwoFactorAuthentication",
                        "twoFactorGracePeriod",
                        "projectCreationLevel",
                        "autoDevopsEnabled",
                        "subgroupCreationLevel",
                        "emailsDisabled",
                        "emailsEnabled",
                        "showDiffPreviewInEmail",
                        "mentionsDisabled",
                        "lfsEnabled",
                        "archived",
                        "mathRenderingLimitsEnabled",
                        "lockMathRenderingLimitsEnabled",
                        "crmEnabled",
                        "resourceAccessTokenNotifyInherited",
                        "lockResourceAccessTokenNotifyInherited",
                        "defaultBranch",
                        "defaultBranchProtection",
                        "defaultBranchProtectionDefaults",
                        "avatarUrl",
                        "requestAccessEnabled",
                        "fullName",
                        "fullPath",
                        "createdAt",
                        "parentId",
                        "organizationId",
                        "sharedRunnersSetting",
                        "maxArtifactsSize",
                        "customAttributes",
                        "statistics",
                        "markedForDeletionOn",
                        "rootStorageStatistics",
                        "ldapCn",
                        "ldapAccess",
                        "ldapGroupLinks",
                        "samlGroupLinks",
                        "fileTemplateProjectId",
                        "wikiAccessLevel",
                        "repositoryStorage",
                        "duoCoreFeaturesEnabled",
                        "duoFeaturesEnabled",
                        "lockDuoFeaturesEnabled",
                        "autoDuoCodeReviewEnabled",
                        "duoCodeReviewDepthAllowed",
                        "duoCodeReviewDefaultDepth",
                        "duoCodeReviewDecisionsEnabled",
                        "webBasedCommitSigningEnabled",
                        "allowPersonalSnippets",
                        "duoNamespaceAccessRules",
                        "builtInProjectTemplatesEnabled",
                        "lockBuiltInProjectTemplatesEnabled",
                        "requireShaForMerge",
                        "lockRequireShaForMerge",
                        "requireTwoFactorAuthenticationFromAncestor",
                        "sharedWithGroups",
                        "runnersToken",
                        "enabledGitAccessProtocol",
                        "preventSharingGroupsOutsideHierarchy",
                        "stepUpAuthRequiredOauthProvider",
                        "projects",
                        "sharedProjects",
                        "sharedRunnersMinutesLimit",
                        "extraSharedRunnersMinutesLimit",
                        "preventForkingOutsideGroup",
                        "serviceAccessTokensExpirationEnforced",
                        "experimentFeaturesEnabled",
                        "aiSettings",
                        "duoRemoteFlowsEnabled",
                        "lockDuoRemoteFlowsEnabled",
                        "membershipLock",
                        "ipRestrictionRanges",
                        "allowedEmailDomainsList",
                        "onlyAllowMergeIfPipelineSucceeds",
                        "allowMergeOnSkippedPipeline",
                        "onlyAllowMergeIfAllDiscussionsAreResolved",
                        "uniqueProjectDownloadLimit",
                        "uniqueProjectDownloadLimitIntervalInSeconds",
                        "uniqueProjectDownloadLimitAllowlist",
                        "uniqueProjectDownloadLimitAlertlist",
                        "autoBanUserOnExcessiveProjectsDownload");
    }
}

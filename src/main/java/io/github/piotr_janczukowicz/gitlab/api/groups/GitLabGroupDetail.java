package io.github.piotr_janczukowicz.gitlab.api.groups;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCustomAttribute;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabLdapGroupLink;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNamespaceRootStorageStatistics;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProject;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabSamlGroupLink;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab group detail.
 *
 * @param id the id
 * @param webUrl the web url
 * @param name the name
 * @param path the path
 * @param description the description
 * @param visibility the visibility
 * @param shareWithGroupLock the share with group lock
 * @param requireTwoFactorAuthentication the require two factor authentication
 * @param twoFactorGracePeriod the two factor grace period
 * @param projectCreationLevel the project creation level
 * @param autoDevopsEnabled the auto devops enabled
 * @param subgroupCreationLevel the subgroup creation level
 * @param emailsDisabled the emails disabled
 * @param emailsEnabled the emails enabled
 * @param showDiffPreviewInEmail the show diff preview in email
 * @param mentionsDisabled the mentions disabled
 * @param lfsEnabled the lfs enabled
 * @param archived the archived
 * @param mathRenderingLimitsEnabled the math rendering limits enabled
 * @param lockMathRenderingLimitsEnabled the lock math rendering limits enabled
 * @param crmEnabled the crm enabled
 * @param resourceAccessTokenNotifyInherited the resource access token notify inherited
 * @param lockResourceAccessTokenNotifyInherited the lock resource access token notify inherited
 * @param defaultBranch the default branch
 * @param defaultBranchProtection the default branch protection
 * @param defaultBranchProtectionDefaults the default branch protection defaults
 * @param avatarUrl the avatar url
 * @param requestAccessEnabled the request access enabled
 * @param fullName the full name
 * @param fullPath the full path
 * @param createdAt the created at
 * @param parentId the parent id
 * @param organizationId the organization id
 * @param sharedRunnersSetting the shared runners setting
 * @param maxArtifactsSize the max artifacts size
 * @param customAttributes the custom attributes
 * @param statistics the statistics
 * @param markedForDeletionOn the marked for deletion on
 * @param rootStorageStatistics the root storage statistics
 * @param ldapCn the ldap cn
 * @param ldapAccess the ldap access
 * @param ldapGroupLinks the ldap group links
 * @param samlGroupLinks the saml group links
 * @param fileTemplateProjectId the file template project id
 * @param wikiAccessLevel the wiki access level
 * @param repositoryStorage the repository storage
 * @param duoCoreFeaturesEnabled the duo core features enabled
 * @param duoFeaturesEnabled the duo features enabled
 * @param lockDuoFeaturesEnabled the lock duo features enabled
 * @param autoDuoCodeReviewEnabled the auto duo code review enabled
 * @param duoCodeReviewDepthAllowed the duo code review depth allowed
 * @param duoCodeReviewDefaultDepth the duo code review default depth
 * @param duoCodeReviewDecisionsEnabled the duo code review decisions enabled
 * @param webBasedCommitSigningEnabled the web based commit signing enabled
 * @param allowPersonalSnippets the allow personal snippets
 * @param duoNamespaceAccessRules the duo namespace access rules
 * @param builtInProjectTemplatesEnabled the built in project templates enabled
 * @param lockBuiltInProjectTemplatesEnabled the lock built in project templates enabled
 * @param requireShaForMerge the require sha for merge
 * @param lockRequireShaForMerge the lock require sha for merge
 * @param requireTwoFactorAuthenticationFromAncestor the require two factor authentication from ancestor
 * @param sharedWithGroups the shared with groups
 * @param runnersToken the runners token
 * @param enabledGitAccessProtocol the enabled git access protocol
 * @param preventSharingGroupsOutsideHierarchy the prevent sharing groups outside hierarchy
 * @param stepUpAuthRequiredOauthProvider the step up auth required oauth provider
 * @param projects the projects
 * @param sharedProjects the shared projects
 * @param sharedRunnersMinutesLimit the shared runners minutes limit
 * @param extraSharedRunnersMinutesLimit the extra shared runners minutes limit
 * @param preventForkingOutsideGroup the prevent forking outside group
 * @param serviceAccessTokensExpirationEnforced the service access tokens expiration enforced
 * @param experimentFeaturesEnabled the experiment features enabled
 * @param aiSettings the ai settings
 * @param duoRemoteFlowsEnabled the duo remote flows enabled
 * @param lockDuoRemoteFlowsEnabled the lock duo remote flows enabled
 * @param membershipLock the membership lock
 * @param ipRestrictionRanges the ip restriction ranges
 * @param allowedEmailDomainsList the allowed email domains list
 * @param onlyAllowMergeIfPipelineSucceeds the only allow merge if pipeline succeeds
 * @param allowMergeOnSkippedPipeline the allow merge on skipped pipeline
 * @param onlyAllowMergeIfAllDiscussionsAreResolved the only allow merge if all discussions are resolved
 * @param uniqueProjectDownloadLimit the unique project download limit
 * @param uniqueProjectDownloadLimitIntervalInSeconds the unique project download limit interval in seconds
 * @param uniqueProjectDownloadLimitAllowlist the unique project download limit allowlist
 * @param uniqueProjectDownloadLimitAlertlist the unique project download limit alertlist
 * @param autoBanUserOnExcessiveProjectsDownload the auto ban user on excessive projects download
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesGroupDetail")
public record GitLabGroupDetail(
        @Nullable Long id,
        @Nullable String webUrl,
        @Nullable String name,
        @Nullable String path,
        @Nullable String description,
        @Nullable String visibility,
        @Nullable Boolean shareWithGroupLock,
        @Nullable Boolean requireTwoFactorAuthentication,
        @Nullable Integer twoFactorGracePeriod,
        @Nullable String projectCreationLevel,
        @Nullable String autoDevopsEnabled,
        @Nullable String subgroupCreationLevel,
        @Nullable Boolean emailsDisabled,
        @Nullable Boolean emailsEnabled,
        @Nullable Boolean showDiffPreviewInEmail,
        @Nullable Boolean mentionsDisabled,
        @Nullable Boolean lfsEnabled,
        @Nullable Boolean archived,
        @Nullable Boolean mathRenderingLimitsEnabled,
        @Nullable Boolean lockMathRenderingLimitsEnabled,
        @Nullable Boolean crmEnabled,
        @Nullable Boolean resourceAccessTokenNotifyInherited,
        @Nullable Boolean lockResourceAccessTokenNotifyInherited,
        @Nullable String defaultBranch,
        @Nullable Integer defaultBranchProtection,
        @Nullable GitLabGroupDetailDefaultBranchProtectionDefaults defaultBranchProtectionDefaults,
        @Nullable String avatarUrl,
        @Nullable Boolean requestAccessEnabled,
        @Nullable String fullName,
        @Nullable String fullPath,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (created_at)")
        Instant createdAt,

        @Nullable String parentId,
        @Nullable Long organizationId,
        @Nullable String sharedRunnersSetting,
        @Nullable Long maxArtifactsSize,
        @Nullable List<GitLabCustomAttribute> customAttributes,
        @Nullable GitLabGroupDetailStatistics statistics,
        @Nullable String markedForDeletionOn,
        @Nullable GitLabNamespaceRootStorageStatistics rootStorageStatistics,
        @Nullable String ldapCn,
        @Nullable String ldapAccess,
        @Nullable GitLabLdapGroupLink ldapGroupLinks,
        @Nullable GitLabSamlGroupLink samlGroupLinks,
        @Nullable Long fileTemplateProjectId,
        @Nullable String wikiAccessLevel,
        @Nullable String repositoryStorage,
        @Nullable Boolean duoCoreFeaturesEnabled,
        @Nullable Boolean duoFeaturesEnabled,
        @Nullable Boolean lockDuoFeaturesEnabled,
        @Nullable String autoDuoCodeReviewEnabled,
        @Nullable Boolean duoCodeReviewDepthAllowed,
        @Nullable String duoCodeReviewDefaultDepth,
        @Nullable String duoCodeReviewDecisionsEnabled,
        @Nullable String webBasedCommitSigningEnabled,
        @Nullable String allowPersonalSnippets,
        @Nullable String duoNamespaceAccessRules,
        @Nullable Boolean builtInProjectTemplatesEnabled,
        @Nullable Boolean lockBuiltInProjectTemplatesEnabled,
        @Nullable Boolean requireShaForMerge,
        @Nullable Boolean lockRequireShaForMerge,
        @Nullable Boolean requireTwoFactorAuthenticationFromAncestor,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        List<Map<String, Object>> sharedWithGroups,

        @Nullable String runnersToken,
        @Nullable String enabledGitAccessProtocol,
        @Nullable Boolean preventSharingGroupsOutsideHierarchy,
        @Nullable String stepUpAuthRequiredOauthProvider,
        @Nullable List<GitLabProject> projects,
        @Nullable List<GitLabProject> sharedProjects,
        @Nullable Integer sharedRunnersMinutesLimit,
        @Nullable Integer extraSharedRunnersMinutesLimit,
        @Nullable Boolean preventForkingOutsideGroup,
        @Nullable Boolean serviceAccessTokensExpirationEnforced,
        @Nullable Boolean experimentFeaturesEnabled,
        @Nullable GitLabAiSettings aiSettings,
        @Nullable Boolean duoRemoteFlowsEnabled,
        @Nullable Boolean lockDuoRemoteFlowsEnabled,
        @Nullable Boolean membershipLock,
        @Nullable String ipRestrictionRanges,
        @Nullable String allowedEmailDomainsList,
        @Nullable Boolean onlyAllowMergeIfPipelineSucceeds,
        @Nullable Boolean allowMergeOnSkippedPipeline,
        @Nullable Boolean onlyAllowMergeIfAllDiscussionsAreResolved,
        @Nullable String uniqueProjectDownloadLimit,
        @Nullable String uniqueProjectDownloadLimitIntervalInSeconds,
        @Nullable String uniqueProjectDownloadLimitAllowlist,
        @Nullable String uniqueProjectDownloadLimitAlertlist,
        @Nullable String autoBanUserOnExcessiveProjectsDownload) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code runnersToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabGroupDetail[" + "id=" + id + ", webUrl=" + webUrl + ", name=" + name + ", path=" + path
                + ", description=" + description + ", visibility=" + visibility + ", shareWithGroupLock="
                + shareWithGroupLock + ", requireTwoFactorAuthentication=" + requireTwoFactorAuthentication
                + ", twoFactorGracePeriod=" + twoFactorGracePeriod + ", projectCreationLevel=" + projectCreationLevel
                + ", autoDevopsEnabled=" + autoDevopsEnabled + ", subgroupCreationLevel=" + subgroupCreationLevel
                + ", emailsDisabled=" + emailsDisabled + ", emailsEnabled=" + emailsEnabled
                + ", showDiffPreviewInEmail=" + showDiffPreviewInEmail + ", mentionsDisabled=" + mentionsDisabled
                + ", lfsEnabled=" + lfsEnabled + ", archived=" + archived + ", mathRenderingLimitsEnabled="
                + mathRenderingLimitsEnabled + ", lockMathRenderingLimitsEnabled=" + lockMathRenderingLimitsEnabled
                + ", crmEnabled=" + crmEnabled + ", resourceAccessTokenNotifyInherited="
                + resourceAccessTokenNotifyInherited + ", lockResourceAccessTokenNotifyInherited="
                + lockResourceAccessTokenNotifyInherited + ", defaultBranch=" + defaultBranch
                + ", defaultBranchProtection=" + defaultBranchProtection + ", defaultBranchProtectionDefaults="
                + defaultBranchProtectionDefaults + ", avatarUrl=" + avatarUrl + ", requestAccessEnabled="
                + requestAccessEnabled + ", fullName=" + fullName + ", fullPath=" + fullPath + ", createdAt="
                + createdAt + ", parentId=" + parentId + ", organizationId=" + organizationId
                + ", sharedRunnersSetting=" + sharedRunnersSetting + ", maxArtifactsSize=" + maxArtifactsSize
                + ", customAttributes=" + customAttributes + ", statistics=" + statistics + ", markedForDeletionOn="
                + markedForDeletionOn + ", rootStorageStatistics=" + rootStorageStatistics + ", ldapCn=" + ldapCn
                + ", ldapAccess=" + ldapAccess + ", ldapGroupLinks=" + ldapGroupLinks + ", samlGroupLinks="
                + samlGroupLinks + ", fileTemplateProjectId=" + fileTemplateProjectId + ", wikiAccessLevel="
                + wikiAccessLevel + ", repositoryStorage=" + repositoryStorage + ", duoCoreFeaturesEnabled="
                + duoCoreFeaturesEnabled + ", duoFeaturesEnabled=" + duoFeaturesEnabled + ", lockDuoFeaturesEnabled="
                + lockDuoFeaturesEnabled + ", autoDuoCodeReviewEnabled=" + autoDuoCodeReviewEnabled
                + ", duoCodeReviewDepthAllowed=" + duoCodeReviewDepthAllowed + ", duoCodeReviewDefaultDepth="
                + duoCodeReviewDefaultDepth + ", duoCodeReviewDecisionsEnabled=" + duoCodeReviewDecisionsEnabled
                + ", webBasedCommitSigningEnabled=" + webBasedCommitSigningEnabled + ", allowPersonalSnippets="
                + allowPersonalSnippets + ", duoNamespaceAccessRules=" + duoNamespaceAccessRules
                + ", builtInProjectTemplatesEnabled=" + builtInProjectTemplatesEnabled
                + ", lockBuiltInProjectTemplatesEnabled=" + lockBuiltInProjectTemplatesEnabled + ", requireShaForMerge="
                + requireShaForMerge + ", lockRequireShaForMerge=" + lockRequireShaForMerge
                + ", requireTwoFactorAuthenticationFromAncestor=" + requireTwoFactorAuthenticationFromAncestor
                + ", sharedWithGroups=" + sharedWithGroups + ", runnersToken=<redacted>" + ", enabledGitAccessProtocol="
                + enabledGitAccessProtocol + ", preventSharingGroupsOutsideHierarchy="
                + preventSharingGroupsOutsideHierarchy + ", stepUpAuthRequiredOauthProvider="
                + stepUpAuthRequiredOauthProvider + ", projects=" + projects + ", sharedProjects=" + sharedProjects
                + ", sharedRunnersMinutesLimit=" + sharedRunnersMinutesLimit + ", extraSharedRunnersMinutesLimit="
                + extraSharedRunnersMinutesLimit + ", preventForkingOutsideGroup=" + preventForkingOutsideGroup
                + ", serviceAccessTokensExpirationEnforced=" + serviceAccessTokensExpirationEnforced
                + ", experimentFeaturesEnabled=" + experimentFeaturesEnabled + ", aiSettings=" + aiSettings
                + ", duoRemoteFlowsEnabled=" + duoRemoteFlowsEnabled + ", lockDuoRemoteFlowsEnabled="
                + lockDuoRemoteFlowsEnabled + ", membershipLock=" + membershipLock + ", ipRestrictionRanges="
                + ipRestrictionRanges + ", allowedEmailDomainsList=" + allowedEmailDomainsList
                + ", onlyAllowMergeIfPipelineSucceeds=" + onlyAllowMergeIfPipelineSucceeds
                + ", allowMergeOnSkippedPipeline=" + allowMergeOnSkippedPipeline
                + ", onlyAllowMergeIfAllDiscussionsAreResolved=" + onlyAllowMergeIfAllDiscussionsAreResolved
                + ", uniqueProjectDownloadLimit=" + uniqueProjectDownloadLimit
                + ", uniqueProjectDownloadLimitIntervalInSeconds=" + uniqueProjectDownloadLimitIntervalInSeconds
                + ", uniqueProjectDownloadLimitAllowlist=" + uniqueProjectDownloadLimitAllowlist
                + ", uniqueProjectDownloadLimitAlertlist=" + uniqueProjectDownloadLimitAlertlist
                + ", autoBanUserOnExcessiveProjectsDownload=" + autoBanUserOnExcessiveProjectsDownload + "]";
    }
}

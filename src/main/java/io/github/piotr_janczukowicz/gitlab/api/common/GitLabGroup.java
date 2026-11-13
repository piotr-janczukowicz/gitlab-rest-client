package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab group.
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
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesGroup")
public record GitLabGroup(
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
        @Nullable Boolean autoDevopsEnabled,
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
        @Nullable GitLabGroupDefaultBranchProtectionDefaults defaultBranchProtectionDefaults,
        @Nullable String avatarUrl,
        @Nullable Boolean requestAccessEnabled,
        @Nullable String fullName,
        @Nullable String fullPath,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (created_at)")
        Instant createdAt,

        @Nullable Long parentId,
        @Nullable Long organizationId,
        @Nullable String sharedRunnersSetting,
        @Nullable Long maxArtifactsSize,
        @Nullable List<GitLabCustomAttribute> customAttributes,
        @Nullable GitLabGroupStatistics statistics,
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
        @Nullable Boolean webBasedCommitSigningEnabled,
        @Nullable String allowPersonalSnippets,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        List<Map<String, Object>> duoNamespaceAccessRules,

        @Nullable Boolean builtInProjectTemplatesEnabled,
        @Nullable Boolean lockBuiltInProjectTemplatesEnabled) {}

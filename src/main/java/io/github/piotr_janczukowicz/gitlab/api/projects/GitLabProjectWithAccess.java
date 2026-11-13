package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBasicProjectDetails;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabContainerExpirationPolicy;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCustomAttribute;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabLicenseBasic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNamespaceBasic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProjectStatistics;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab project with access.
 *
 * @param id the id
 * @param description the description
 * @param name the name
 * @param nameWithNamespace the name with namespace
 * @param path the path
 * @param pathWithNamespace the path with namespace
 * @param createdAt the created at
 * @param defaultBranch the default branch
 * @param tagList the tag list
 * @param topics the topics
 * @param sshUrlToRepo the ssh url to repo
 * @param httpUrlToRepo the http url to repo
 * @param webUrl the web url
 * @param readmeUrl the readme url
 * @param forksCount the forks count
 * @param licenseUrl the license url
 * @param license the license
 * @param avatarUrl the avatar url
 * @param starCount the star count
 * @param lastActivityAt the last activity at
 * @param visibility the visibility
 * @param namespace the namespace
 * @param customAttributes the custom attributes
 * @param repositoryStorage the repository storage
 * @param forkedFromProject the forked from project
 * @param containerRegistryImagePrefix the container registry image prefix
 * @param links the links
 * @param markedForDeletionAt the marked for deletion at
 * @param markedForDeletionOn the marked for deletion on
 * @param packagesEnabled the packages enabled
 * @param emptyRepo the empty repo
 * @param archived the archived
 * @param owner the owner
 * @param resolveOutdatedDiffDiscussions the resolve outdated diff discussions
 * @param containerExpirationPolicy the container expiration policy
 * @param repositoryObjectFormat the repository object format
 * @param issuesEnabled the issues enabled
 * @param mergeRequestsEnabled the merge requests enabled
 * @param wikiEnabled the wiki enabled
 * @param jobsEnabled the jobs enabled
 * @param snippetsEnabled the snippets enabled
 * @param containerRegistryEnabled the container registry enabled
 * @param serviceDeskEnabled the service desk enabled
 * @param serviceDeskAddress the service desk address
 * @param canCreateMergeRequestIn the can create merge request in
 * @param issuesAccessLevel the issues access level
 * @param repositoryAccessLevel the repository access level
 * @param mergeRequestsAccessLevel the merge requests access level
 * @param forkingAccessLevel the forking access level
 * @param wikiAccessLevel the wiki access level
 * @param buildsAccessLevel the builds access level
 * @param snippetsAccessLevel the snippets access level
 * @param pagesAccessLevel the pages access level
 * @param analyticsAccessLevel the analytics access level
 * @param containerRegistryAccessLevel the container registry access level
 * @param securityAndComplianceAccessLevel the security and compliance access level
 * @param releasesAccessLevel the releases access level
 * @param environmentsAccessLevel the environments access level
 * @param featureFlagsAccessLevel the feature flags access level
 * @param infrastructureAccessLevel the infrastructure access level
 * @param monitorAccessLevel the monitor access level
 * @param modelExperimentsAccessLevel the model experiments access level
 * @param modelRegistryAccessLevel the model registry access level
 * @param packageRegistryAccessLevel the package registry access level
 * @param emailsDisabled the emails disabled
 * @param emailsEnabled the emails enabled
 * @param showDiffPreviewInEmail the show diff preview in email
 * @param sharedRunnersEnabled the shared runners enabled
 * @param lfsEnabled the lfs enabled
 * @param creatorId the creator id
 * @param mrDefaultTargetSelf the mr default target self
 * @param importUrl the import url
 * @param importType the import type
 * @param importStatus the import status
 * @param importError the import error
 * @param openIssuesCount the open issues count
 * @param descriptionHtml the description html
 * @param updatedAt the updated at
 * @param ciDefaultGitDepth the ci default git depth
 * @param ciDeletePipelinesInSeconds the ci delete pipelines in seconds
 * @param ciForwardDeploymentEnabled the ci forward deployment enabled
 * @param ciForwardDeploymentRollbackAllowed the ci forward deployment rollback allowed
 * @param ciJobTokenScopeEnabled the ci job token scope enabled
 * @param ciSeparatedCaches the ci separated caches
 * @param ciAllowForkPipelinesToRunInParentProject the ci allow fork pipelines to run in parent project
 * @param ciIdTokenSubClaimComponents the ci id token sub claim components
 * @param buildGitStrategy the build git strategy
 * @param keepLatestArtifact the keep latest artifact
 * @param restrictUserDefinedVariables the restrict user defined variables
 * @param ciPipelineVariablesMinimumOverrideRole the ci pipeline variables minimum override role
 * @param runnerTokenExpirationInterval the runner token expiration interval
 * @param groupRunnersEnabled the group runners enabled
 * @param resourceGroupDefaultProcessMode the resource group default process mode
 * @param autoCancelPendingPipelines the auto cancel pending pipelines
 * @param buildTimeout the build timeout
 * @param autoDevopsEnabled the auto devops enabled
 * @param autoDevopsDeployStrategy the auto devops deploy strategy
 * @param ciPushRepositoryForJobTokenAllowed the ci push repository for job token allowed
 * @param protectMergeRequestPipelines the protect merge request pipelines
 * @param ciDisplayPipelineVariables the ci display pipeline variables
 * @param ciSkipBranchPipelinesForMrs the ci skip branch pipelines for mrs
 * @param runnersToken the runners token
 * @param ciConfigPath the ci config path
 * @param publicJobs the public jobs
 * @param sharedWithGroups the shared with groups
 * @param onlyAllowMergeIfPipelineSucceeds the only allow merge if pipeline succeeds
 * @param allowMergeOnSkippedPipeline the allow merge on skipped pipeline
 * @param requestAccessEnabled the request access enabled
 * @param onlyAllowMergeIfAllDiscussionsAreResolved the only allow merge if all discussions are resolved
 * @param removeSourceBranchAfterMerge the remove source branch after merge
 * @param printingMergeRequestLinkEnabled the printing merge request link enabled
 * @param mergeMethod the merge method
 * @param squashOption the squash option
 * @param automaticRebaseEnabled the automatic rebase enabled
 * @param enforceAuthChecksOnUploads the enforce auth checks on uploads
 * @param suggestionCommitMessage the suggestion commit message
 * @param mergeCommitTemplate the merge commit template
 * @param squashCommitTemplate the squash commit template
 * @param mrDefaultTitleTemplate the mr default title template
 * @param issueBranchTemplate the issue branch template
 * @param statistics the statistics
 * @param warnAboutPotentiallyUnwantedCharacters the warn about potentially unwanted characters
 * @param autocloseReferencedIssues the autoclose referenced issues
 * @param maxArtifactsSize the max artifacts size
 * @param approvalsBeforeMerge the approvals before merge
 * @param mirror the mirror
 * @param mirrorUserId the mirror user id
 * @param mirrorTriggerBuilds the mirror trigger builds
 * @param onlyMirrorProtectedBranches the only mirror protected branches
 * @param mirrorOverwritesDivergedBranches the mirror overwrites diverged branches
 * @param externalAuthorizationClassificationLabel the external authorization classification label
 * @param requirementsEnabled the requirements enabled
 * @param requirementsAccessLevel the requirements access level
 * @param securityAndComplianceEnabled the security and compliance enabled
 * @param secretPushProtectionEnabled the secret push protection enabled
 * @param preReceiveSecretDetectionEnabled the pre receive secret detection enabled
 * @param complianceFrameworks the compliance frameworks
 * @param issuesTemplate the issues template
 * @param mergeRequestsTemplate the merge requests template
 * @param ciRestrictPipelineCancellationRole the ci restrict pipeline cancellation role
 * @param mergePipelinesEnabled the merge pipelines enabled
 * @param mergeTrainsEnabled the merge trains enabled
 * @param mergeTrainsSkipTrainAllowed the merge trains skip train allowed
 * @param mergeTrainEnforcement the merge train enforcement
 * @param maxPipelinesPerMergeTrain the max pipelines per merge train
 * @param onlyAllowMergeIfAllStatusChecksPassed the only allow merge if all status checks passed
 * @param allowPipelineTriggerApproveDeployment the allow pipeline trigger approve deployment
 * @param preventMergeWithoutJiraIssue the prevent merge without jira issue
 * @param autoDuoCodeReviewEnabled the auto duo code review enabled
 * @param duoCodeReviewDecisionsEnabled the duo code review decisions enabled
 * @param duoCodeReviewDepthAllowed the duo code review depth allowed
 * @param duoCodeReviewDefaultDepth the duo code review default depth
 * @param reviewerAssignmentStrategy the reviewer assignment strategy
 * @param duoRemoteFlowsEnabled the duo remote flows enabled
 * @param duoFoundationalFlowsEnabled the duo foundational flows enabled
 * @param duoScheduledAutomationsEnabled the duo scheduled automations enabled
 * @param duoSastFpDetectionEnabled the duo sast fp detection enabled
 * @param duoSecretDetectionFpEnabled the duo secret detection fp enabled
 * @param duoDependencyBumpBreakingChangesEnabled the duo dependency bump breaking changes enabled
 * @param duoSastVrWorkflowEnabled the duo sast vr workflow enabled
 * @param webBasedCommitSigningEnabled the web based commit signing enabled
 * @param sppRepositoryPipelineAccess the spp repository pipeline access
 * @param securityPolicyPipelineMustSucceed the security policy pipeline must succeed
 * @param mergeRequestTitleRegex the merge request title regex
 * @param mergeRequestTitleRegexDescription the merge request title regex description
 * @param permissions the permissions
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProjectWithAccess")
public record GitLabProjectWithAccess(
        @Nullable Long id,
        @Nullable String description,
        @Nullable String name,
        @Nullable String nameWithNamespace,
        @Nullable String path,
        @Nullable String pathWithNamespace,
        @Nullable Instant createdAt,
        @Nullable String defaultBranch,
        @Nullable List<String> tagList,
        @Nullable List<String> topics,
        @Nullable String sshUrlToRepo,
        @Nullable String httpUrlToRepo,
        @Nullable String webUrl,
        @Nullable String readmeUrl,
        @Nullable Integer forksCount,
        @Nullable String licenseUrl,
        @Nullable GitLabLicenseBasic license,
        @Nullable String avatarUrl,
        @Nullable Integer starCount,
        @Nullable Instant lastActivityAt,
        @Nullable String visibility,
        @Nullable GitLabNamespaceBasic namespace,
        @Nullable GitLabCustomAttribute customAttributes,
        @Nullable String repositoryStorage,
        @Nullable GitLabBasicProjectDetails forkedFromProject,
        @Nullable String containerRegistryImagePrefix,
        @Nullable @JsonProperty("_links") GitLabProjectWithAccessLinks links,
        @Nullable Instant markedForDeletionAt,
        @Nullable Instant markedForDeletionOn,
        @Nullable Boolean packagesEnabled,
        @Nullable Boolean emptyRepo,
        @Nullable Boolean archived,
        @Nullable GitLabUserBasic owner,
        @Nullable Boolean resolveOutdatedDiffDiscussions,
        @Nullable GitLabContainerExpirationPolicy containerExpirationPolicy,
        @Nullable String repositoryObjectFormat,
        @Nullable Boolean issuesEnabled,
        @Nullable Boolean mergeRequestsEnabled,
        @Nullable Boolean wikiEnabled,
        @Nullable Boolean jobsEnabled,
        @Nullable Boolean snippetsEnabled,
        @Nullable Boolean containerRegistryEnabled,
        @Nullable Boolean serviceDeskEnabled,
        @Nullable String serviceDeskAddress,
        @Nullable Boolean canCreateMergeRequestIn,
        @Nullable String issuesAccessLevel,
        @Nullable String repositoryAccessLevel,
        @Nullable String mergeRequestsAccessLevel,
        @Nullable String forkingAccessLevel,
        @Nullable String wikiAccessLevel,
        @Nullable String buildsAccessLevel,
        @Nullable String snippetsAccessLevel,
        @Nullable String pagesAccessLevel,
        @Nullable String analyticsAccessLevel,
        @Nullable String containerRegistryAccessLevel,
        @Nullable String securityAndComplianceAccessLevel,
        @Nullable String releasesAccessLevel,
        @Nullable String environmentsAccessLevel,
        @Nullable String featureFlagsAccessLevel,
        @Nullable String infrastructureAccessLevel,
        @Nullable String monitorAccessLevel,
        @Nullable String modelExperimentsAccessLevel,
        @Nullable String modelRegistryAccessLevel,
        @Nullable String packageRegistryAccessLevel,
        @Nullable Boolean emailsDisabled,
        @Nullable Boolean emailsEnabled,
        @Nullable Boolean showDiffPreviewInEmail,
        @Nullable Boolean sharedRunnersEnabled,
        @Nullable Boolean lfsEnabled,
        @Nullable Long creatorId,
        @Nullable Boolean mrDefaultTargetSelf,
        @Nullable String importUrl,
        @Nullable String importType,
        @Nullable String importStatus,
        @Nullable String importError,
        @Nullable Integer openIssuesCount,
        @Nullable String descriptionHtml,
        @Nullable Instant updatedAt,
        @Nullable Integer ciDefaultGitDepth,
        @Nullable Integer ciDeletePipelinesInSeconds,
        @Nullable Boolean ciForwardDeploymentEnabled,
        @Nullable Boolean ciForwardDeploymentRollbackAllowed,
        @Nullable Boolean ciJobTokenScopeEnabled,
        @Nullable Boolean ciSeparatedCaches,
        @Nullable Boolean ciAllowForkPipelinesToRunInParentProject,
        @Nullable List<String> ciIdTokenSubClaimComponents,
        @Nullable String buildGitStrategy,
        @Nullable Boolean keepLatestArtifact,
        @Nullable Boolean restrictUserDefinedVariables,
        @Nullable String ciPipelineVariablesMinimumOverrideRole,
        @Nullable Integer runnerTokenExpirationInterval,
        @Nullable Boolean groupRunnersEnabled,
        @Nullable String resourceGroupDefaultProcessMode,
        @Nullable String autoCancelPendingPipelines,
        @Nullable Integer buildTimeout,
        @Nullable Boolean autoDevopsEnabled,
        @Nullable String autoDevopsDeployStrategy,
        @Nullable Boolean ciPushRepositoryForJobTokenAllowed,
        @Nullable Boolean protectMergeRequestPipelines,
        @Nullable Boolean ciDisplayPipelineVariables,
        @Nullable Boolean ciSkipBranchPipelinesForMrs,
        @Nullable String runnersToken,
        @Nullable String ciConfigPath,
        @Nullable Boolean publicJobs,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        List<Map<String, Object>> sharedWithGroups,

        @Nullable Boolean onlyAllowMergeIfPipelineSucceeds,
        @Nullable Boolean allowMergeOnSkippedPipeline,
        @Nullable Boolean requestAccessEnabled,
        @Nullable Boolean onlyAllowMergeIfAllDiscussionsAreResolved,
        @Nullable Boolean removeSourceBranchAfterMerge,
        @Nullable Boolean printingMergeRequestLinkEnabled,
        @Nullable String mergeMethod,
        @Nullable String squashOption,
        @Nullable Boolean automaticRebaseEnabled,
        @Nullable Boolean enforceAuthChecksOnUploads,
        @Nullable String suggestionCommitMessage,
        @Nullable String mergeCommitTemplate,
        @Nullable String squashCommitTemplate,
        @Nullable String mrDefaultTitleTemplate,
        @Nullable String issueBranchTemplate,
        @Nullable GitLabProjectStatistics statistics,
        @Nullable Boolean warnAboutPotentiallyUnwantedCharacters,
        @Nullable Boolean autocloseReferencedIssues,
        @Nullable Long maxArtifactsSize,
        @Nullable String approvalsBeforeMerge,
        @Nullable String mirror,
        @Nullable String mirrorUserId,
        @Nullable String mirrorTriggerBuilds,
        @Nullable String onlyMirrorProtectedBranches,
        @Nullable String mirrorOverwritesDivergedBranches,
        @Nullable String externalAuthorizationClassificationLabel,
        @Nullable String requirementsEnabled,
        @Nullable String requirementsAccessLevel,
        @Nullable String securityAndComplianceEnabled,
        @Nullable Boolean secretPushProtectionEnabled,
        @Nullable Boolean preReceiveSecretDetectionEnabled,
        @Nullable String complianceFrameworks,
        @Nullable String issuesTemplate,
        @Nullable String mergeRequestsTemplate,
        @Nullable String ciRestrictPipelineCancellationRole,
        @Nullable String mergePipelinesEnabled,
        @Nullable String mergeTrainsEnabled,
        @Nullable String mergeTrainsSkipTrainAllowed,
        @Nullable String mergeTrainEnforcement,
        @Nullable String maxPipelinesPerMergeTrain,
        @Nullable String onlyAllowMergeIfAllStatusChecksPassed,
        @Nullable Boolean allowPipelineTriggerApproveDeployment,
        @Nullable String preventMergeWithoutJiraIssue,
        @Nullable String autoDuoCodeReviewEnabled,
        @Nullable String duoCodeReviewDecisionsEnabled,
        @Nullable Boolean duoCodeReviewDepthAllowed,
        @Nullable String duoCodeReviewDefaultDepth,
        @Nullable String reviewerAssignmentStrategy,
        @Nullable String duoRemoteFlowsEnabled,
        @Nullable String duoFoundationalFlowsEnabled,
        @Nullable String duoScheduledAutomationsEnabled,
        @Nullable String duoSastFpDetectionEnabled,
        @Nullable String duoSecretDetectionFpEnabled,
        @Nullable String duoDependencyBumpBreakingChangesEnabled,
        @Nullable String duoSastVrWorkflowEnabled,
        @Nullable String webBasedCommitSigningEnabled,
        @Nullable Boolean sppRepositoryPipelineAccess,
        @Nullable Boolean securityPolicyPipelineMustSucceed,
        @Nullable String mergeRequestTitleRegex,
        @Nullable String mergeRequestTitleRegexDescription,
        @Nullable GitLabProjectWithAccessPermissions permissions) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code runnersToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectWithAccess[" + "id=" + id + ", description=" + description + ", name=" + name
                + ", nameWithNamespace=" + nameWithNamespace + ", path=" + path + ", pathWithNamespace="
                + pathWithNamespace + ", createdAt=" + createdAt + ", defaultBranch=" + defaultBranch + ", tagList="
                + tagList + ", topics=" + topics + ", sshUrlToRepo=" + sshUrlToRepo + ", httpUrlToRepo=" + httpUrlToRepo
                + ", webUrl=" + webUrl + ", readmeUrl=" + readmeUrl + ", forksCount=" + forksCount + ", licenseUrl="
                + licenseUrl + ", license=" + license + ", avatarUrl=" + avatarUrl + ", starCount=" + starCount
                + ", lastActivityAt=" + lastActivityAt + ", visibility=" + visibility + ", namespace=" + namespace
                + ", customAttributes=" + customAttributes + ", repositoryStorage=" + repositoryStorage
                + ", forkedFromProject=" + forkedFromProject + ", containerRegistryImagePrefix="
                + containerRegistryImagePrefix + ", links=" + links + ", markedForDeletionAt=" + markedForDeletionAt
                + ", markedForDeletionOn=" + markedForDeletionOn + ", packagesEnabled=" + packagesEnabled
                + ", emptyRepo=" + emptyRepo + ", archived=" + archived + ", owner=" + owner
                + ", resolveOutdatedDiffDiscussions=" + resolveOutdatedDiffDiscussions + ", containerExpirationPolicy="
                + containerExpirationPolicy + ", repositoryObjectFormat=" + repositoryObjectFormat + ", issuesEnabled="
                + issuesEnabled + ", mergeRequestsEnabled=" + mergeRequestsEnabled + ", wikiEnabled=" + wikiEnabled
                + ", jobsEnabled=" + jobsEnabled + ", snippetsEnabled=" + snippetsEnabled
                + ", containerRegistryEnabled=" + containerRegistryEnabled + ", serviceDeskEnabled="
                + serviceDeskEnabled + ", serviceDeskAddress=" + serviceDeskAddress + ", canCreateMergeRequestIn="
                + canCreateMergeRequestIn + ", issuesAccessLevel=" + issuesAccessLevel + ", repositoryAccessLevel="
                + repositoryAccessLevel + ", mergeRequestsAccessLevel=" + mergeRequestsAccessLevel
                + ", forkingAccessLevel=" + forkingAccessLevel + ", wikiAccessLevel=" + wikiAccessLevel
                + ", buildsAccessLevel=" + buildsAccessLevel + ", snippetsAccessLevel=" + snippetsAccessLevel
                + ", pagesAccessLevel=" + pagesAccessLevel + ", analyticsAccessLevel=" + analyticsAccessLevel
                + ", containerRegistryAccessLevel=" + containerRegistryAccessLevel
                + ", securityAndComplianceAccessLevel=" + securityAndComplianceAccessLevel + ", releasesAccessLevel="
                + releasesAccessLevel + ", environmentsAccessLevel=" + environmentsAccessLevel
                + ", featureFlagsAccessLevel=" + featureFlagsAccessLevel + ", infrastructureAccessLevel="
                + infrastructureAccessLevel + ", monitorAccessLevel=" + monitorAccessLevel
                + ", modelExperimentsAccessLevel=" + modelExperimentsAccessLevel + ", modelRegistryAccessLevel="
                + modelRegistryAccessLevel + ", packageRegistryAccessLevel=" + packageRegistryAccessLevel
                + ", emailsDisabled=" + emailsDisabled + ", emailsEnabled=" + emailsEnabled
                + ", showDiffPreviewInEmail=" + showDiffPreviewInEmail + ", sharedRunnersEnabled="
                + sharedRunnersEnabled + ", lfsEnabled=" + lfsEnabled + ", creatorId=" + creatorId
                + ", mrDefaultTargetSelf=" + mrDefaultTargetSelf + ", importUrl=" + importUrl + ", importType="
                + importType + ", importStatus=" + importStatus + ", importError=" + importError + ", openIssuesCount="
                + openIssuesCount + ", descriptionHtml=" + descriptionHtml + ", updatedAt=" + updatedAt
                + ", ciDefaultGitDepth=" + ciDefaultGitDepth + ", ciDeletePipelinesInSeconds="
                + ciDeletePipelinesInSeconds + ", ciForwardDeploymentEnabled=" + ciForwardDeploymentEnabled
                + ", ciForwardDeploymentRollbackAllowed=" + ciForwardDeploymentRollbackAllowed
                + ", ciJobTokenScopeEnabled=" + ciJobTokenScopeEnabled + ", ciSeparatedCaches=" + ciSeparatedCaches
                + ", ciAllowForkPipelinesToRunInParentProject=" + ciAllowForkPipelinesToRunInParentProject
                + ", ciIdTokenSubClaimComponents=" + ciIdTokenSubClaimComponents + ", buildGitStrategy="
                + buildGitStrategy + ", keepLatestArtifact=" + keepLatestArtifact + ", restrictUserDefinedVariables="
                + restrictUserDefinedVariables + ", ciPipelineVariablesMinimumOverrideRole="
                + ciPipelineVariablesMinimumOverrideRole + ", runnerTokenExpirationInterval="
                + runnerTokenExpirationInterval + ", groupRunnersEnabled=" + groupRunnersEnabled
                + ", resourceGroupDefaultProcessMode=" + resourceGroupDefaultProcessMode
                + ", autoCancelPendingPipelines=" + autoCancelPendingPipelines + ", buildTimeout=" + buildTimeout
                + ", autoDevopsEnabled=" + autoDevopsEnabled + ", autoDevopsDeployStrategy=" + autoDevopsDeployStrategy
                + ", ciPushRepositoryForJobTokenAllowed=" + ciPushRepositoryForJobTokenAllowed
                + ", protectMergeRequestPipelines=" + protectMergeRequestPipelines + ", ciDisplayPipelineVariables="
                + ciDisplayPipelineVariables + ", ciSkipBranchPipelinesForMrs=" + ciSkipBranchPipelinesForMrs
                + ", runnersToken=<redacted>" + ", ciConfigPath=" + ciConfigPath + ", publicJobs=" + publicJobs
                + ", sharedWithGroups=" + sharedWithGroups + ", onlyAllowMergeIfPipelineSucceeds="
                + onlyAllowMergeIfPipelineSucceeds + ", allowMergeOnSkippedPipeline=" + allowMergeOnSkippedPipeline
                + ", requestAccessEnabled=" + requestAccessEnabled + ", onlyAllowMergeIfAllDiscussionsAreResolved="
                + onlyAllowMergeIfAllDiscussionsAreResolved + ", removeSourceBranchAfterMerge="
                + removeSourceBranchAfterMerge + ", printingMergeRequestLinkEnabled=" + printingMergeRequestLinkEnabled
                + ", mergeMethod=" + mergeMethod + ", squashOption=" + squashOption + ", automaticRebaseEnabled="
                + automaticRebaseEnabled + ", enforceAuthChecksOnUploads=" + enforceAuthChecksOnUploads
                + ", suggestionCommitMessage=" + suggestionCommitMessage + ", mergeCommitTemplate="
                + mergeCommitTemplate + ", squashCommitTemplate=" + squashCommitTemplate + ", mrDefaultTitleTemplate="
                + mrDefaultTitleTemplate + ", issueBranchTemplate=" + issueBranchTemplate + ", statistics=" + statistics
                + ", warnAboutPotentiallyUnwantedCharacters=" + warnAboutPotentiallyUnwantedCharacters
                + ", autocloseReferencedIssues=" + autocloseReferencedIssues + ", maxArtifactsSize=" + maxArtifactsSize
                + ", approvalsBeforeMerge=" + approvalsBeforeMerge + ", mirror=" + mirror + ", mirrorUserId="
                + mirrorUserId + ", mirrorTriggerBuilds=" + mirrorTriggerBuilds + ", onlyMirrorProtectedBranches="
                + onlyMirrorProtectedBranches + ", mirrorOverwritesDivergedBranches=" + mirrorOverwritesDivergedBranches
                + ", externalAuthorizationClassificationLabel=" + externalAuthorizationClassificationLabel
                + ", requirementsEnabled=" + requirementsEnabled + ", requirementsAccessLevel="
                + requirementsAccessLevel + ", securityAndComplianceEnabled=" + securityAndComplianceEnabled
                + ", secretPushProtectionEnabled=" + secretPushProtectionEnabled + ", preReceiveSecretDetectionEnabled="
                + preReceiveSecretDetectionEnabled + ", complianceFrameworks=" + complianceFrameworks
                + ", issuesTemplate=" + issuesTemplate + ", mergeRequestsTemplate=" + mergeRequestsTemplate
                + ", ciRestrictPipelineCancellationRole=" + ciRestrictPipelineCancellationRole
                + ", mergePipelinesEnabled=" + mergePipelinesEnabled + ", mergeTrainsEnabled=" + mergeTrainsEnabled
                + ", mergeTrainsSkipTrainAllowed=" + mergeTrainsSkipTrainAllowed + ", mergeTrainEnforcement="
                + mergeTrainEnforcement + ", maxPipelinesPerMergeTrain=" + maxPipelinesPerMergeTrain
                + ", onlyAllowMergeIfAllStatusChecksPassed=" + onlyAllowMergeIfAllStatusChecksPassed
                + ", allowPipelineTriggerApproveDeployment=" + allowPipelineTriggerApproveDeployment
                + ", preventMergeWithoutJiraIssue=" + preventMergeWithoutJiraIssue + ", autoDuoCodeReviewEnabled="
                + autoDuoCodeReviewEnabled + ", duoCodeReviewDecisionsEnabled=" + duoCodeReviewDecisionsEnabled
                + ", duoCodeReviewDepthAllowed=" + duoCodeReviewDepthAllowed + ", duoCodeReviewDefaultDepth="
                + duoCodeReviewDefaultDepth + ", reviewerAssignmentStrategy=" + reviewerAssignmentStrategy
                + ", duoRemoteFlowsEnabled=" + duoRemoteFlowsEnabled + ", duoFoundationalFlowsEnabled="
                + duoFoundationalFlowsEnabled + ", duoScheduledAutomationsEnabled=" + duoScheduledAutomationsEnabled
                + ", duoSastFpDetectionEnabled=" + duoSastFpDetectionEnabled + ", duoSecretDetectionFpEnabled="
                + duoSecretDetectionFpEnabled + ", duoDependencyBumpBreakingChangesEnabled="
                + duoDependencyBumpBreakingChangesEnabled + ", duoSastVrWorkflowEnabled=" + duoSastVrWorkflowEnabled
                + ", webBasedCommitSigningEnabled=" + webBasedCommitSigningEnabled + ", sppRepositoryPipelineAccess="
                + sppRepositoryPipelineAccess + ", securityPolicyPipelineMustSucceed="
                + securityPolicyPipelineMustSucceed + ", mergeRequestTitleRegex=" + mergeRequestTitleRegex
                + ", mergeRequestTitleRegexDescription=" + mergeRequestTitleRegexDescription + ", permissions="
                + permissions + "]";
    }
}

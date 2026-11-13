package io.github.piotr_janczukowicz.gitlab.api.memberroles;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4MemberRoles}.
 *
 * @param baseAccessLevel the base access level
 * @param name the name
 * @param description the description
 * @param applySecurityScanProfiles the apply security scan profiles
 * @param adminMergeRequest the admin merge request
 * @param archiveProject the archive project
 * @param archiveSubgroup the archive subgroup
 * @param adminAiCatalogItemConsumer the admin ai catalog item consumer
 * @param createSecurityScanProfiles the create security scan profiles
 * @param destroyPackage the destroy package
 * @param removeProject the remove project
 * @param deleteSecurityScanProfiles the delete security scan profiles
 * @param removeGroup the remove group
 * @param manageSecurityPolicyLink the manage security policy link
 * @param adminAiCatalogItem the admin ai catalog item
 * @param adminComplianceFramework the admin compliance framework
 * @param adminCicdVariables the admin cicd variables
 * @param manageDeployTokens the manage deploy tokens
 * @param manageGroupAccessTokens the manage group access tokens
 * @param adminGroupMember the admin group member
 * @param adminIntegrations the admin integrations
 * @param manageMergeRequestSettings the manage merge request settings
 * @param manageProjectAccessTokens the manage project access tokens
 * @param adminProtectedBranch the admin protected branch
 * @param adminProtectedEnvironments the admin protected environments
 * @param adminPushRules the admin push rules
 * @param adminRunners the admin runners
 * @param adminSecurityAttributes the admin security attributes
 * @param adminTerraformState the admin terraform state
 * @param adminVulnerability the admin vulnerability
 * @param adminWebHook the admin web hook
 * @param pullContainerImage the pull container image
 * @param pushContainerImage the push container image
 * @param readAgentArtifacts the read agent artifacts
 * @param readComplianceDashboard the read compliance dashboard
 * @param readSecurityScanProfiles the read security scan profiles
 * @param readVirtualRegistry the read virtual registry
 * @param updateSecAiWorkflowSettings the update sec ai workflow settings
 * @param updateSecurityScanProfiles the update security scan profiles
 * @param readAdminCicd the read admin cicd
 * @param readCrmContact the read crm contact
 * @param readDependency the read dependency
 * @param readAdminGroups the read admin groups
 * @param readAdminProjects the read admin projects
 * @param readCode the read code
 * @param readRunners the read runners
 * @param readSecurityAttribute the read security attribute
 * @param readAdminSubscription the read admin subscription
 * @param readAdminMonitoring the read admin monitoring
 * @param readAdminUsers the read admin users
 * @param readVulnerability the read vulnerability
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4MemberRoles/requestBody")
public record GitLabGroupMemberRolesCreatePayload(
        GitLabGroupMemberRolesCreateBaseAccessLevel baseAccessLevel,
        @Nullable String name,
        @Nullable String description,
        @Nullable Boolean applySecurityScanProfiles,
        @Nullable Boolean adminMergeRequest,
        @Nullable Boolean archiveProject,
        @Nullable Boolean archiveSubgroup,
        @Nullable Boolean adminAiCatalogItemConsumer,
        @Nullable Boolean createSecurityScanProfiles,
        @Nullable Boolean destroyPackage,
        @Nullable Boolean removeProject,
        @Nullable Boolean deleteSecurityScanProfiles,
        @Nullable Boolean removeGroup,
        @Nullable Boolean manageSecurityPolicyLink,
        @Nullable Boolean adminAiCatalogItem,
        @Nullable Boolean adminComplianceFramework,
        @Nullable Boolean adminCicdVariables,
        @Nullable Boolean manageDeployTokens,
        @Nullable Boolean manageGroupAccessTokens,
        @Nullable Boolean adminGroupMember,
        @Nullable Boolean adminIntegrations,
        @Nullable Boolean manageMergeRequestSettings,
        @Nullable Boolean manageProjectAccessTokens,
        @Nullable Boolean adminProtectedBranch,
        @Nullable Boolean adminProtectedEnvironments,
        @Nullable Boolean adminPushRules,
        @Nullable Boolean adminRunners,
        @Nullable Boolean adminSecurityAttributes,
        @Nullable Boolean adminTerraformState,
        @Nullable Boolean adminVulnerability,
        @Nullable Boolean adminWebHook,
        @Nullable Boolean pullContainerImage,
        @Nullable Boolean pushContainerImage,
        @Nullable Boolean readAgentArtifacts,
        @Nullable Boolean readComplianceDashboard,
        @Nullable Boolean readSecurityScanProfiles,
        @Nullable Boolean readVirtualRegistry,
        @Nullable Boolean updateSecAiWorkflowSettings,
        @Nullable Boolean updateSecurityScanProfiles,
        @Nullable Boolean readAdminCicd,
        @Nullable Boolean readCrmContact,
        @Nullable Boolean readDependency,
        @Nullable Boolean readAdminGroups,
        @Nullable Boolean readAdminProjects,
        @Nullable Boolean readCode,
        @Nullable Boolean readRunners,
        @Nullable Boolean readSecurityAttribute,
        @Nullable Boolean readAdminSubscription,
        @Nullable Boolean readAdminMonitoring,
        @Nullable Boolean readAdminUsers,
        @Nullable Boolean readVulnerability) {
    public GitLabGroupMemberRolesCreatePayload {
        requireNonNull(baseAccessLevel, "baseAccessLevel");
    }
}

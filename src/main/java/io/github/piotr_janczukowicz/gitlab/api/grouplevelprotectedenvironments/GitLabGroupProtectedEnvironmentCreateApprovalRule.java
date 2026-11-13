package io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedenvironments;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab group protected environment create approval rule of a GitLab resource.
 *
 * @param userId the user id
 * @param groupId the group id
 * @param groupInheritanceType the group inheritance type
 * @param id the id
 * @param destroy the destroy
 * @param accessLevel the access level
 * @param requiredApprovals the required approvals
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GroupsIdProtectedEnvironments/requestBody/properties/approval_rules/items")
public record GitLabGroupProtectedEnvironmentCreateApprovalRule(
        @Nullable Long userId,
        @Nullable Long groupId,
        @Nullable GitLabGroupProtectedEnvironmentCreateApprovalRuleGroupInheritanceType groupInheritanceType,
        @Nullable Long id,
        @Nullable @JsonProperty("_destroy") Boolean destroy,
        @Nullable GitLabGroupProtectedEnvironmentCreateApprovalRuleAccessLevel accessLevel,
        @Nullable Integer requiredApprovals) {}

package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab protected environments approval rule.
 *
 * @param id the id
 * @param userId the user id
 * @param groupId the group id
 * @param accessLevel the access level
 * @param accessLevelDescription the access level description
 * @param requiredApprovals the required approvals
 * @param groupInheritanceType the group inheritance type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProtectedEnvironmentsApprovalRule")
public record GitLabProtectedEnvironmentsApprovalRule(
        @Nullable Long id,
        @Nullable Long userId,
        @Nullable Long groupId,
        @Nullable Integer accessLevel,
        @Nullable String accessLevelDescription,
        @Nullable Integer requiredApprovals,
        @Nullable Integer groupInheritanceType) {}

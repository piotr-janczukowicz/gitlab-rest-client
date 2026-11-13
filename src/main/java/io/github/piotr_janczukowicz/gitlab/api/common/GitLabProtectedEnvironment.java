package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab protected environment.
 *
 * @param name the name
 * @param deployAccessLevels the deploy access levels
 * @param requiredApprovalCount the required approval count
 * @param approvalRules the approval rules
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProtectedEnvironment")
public record GitLabProtectedEnvironment(
        @Nullable String name,
        @Nullable GitLabProtectedEnvironmentsDeployAccessLevel deployAccessLevels,
        @Nullable Integer requiredApprovalCount,
        @Nullable GitLabProtectedEnvironmentsApprovalRule approvalRules) {}

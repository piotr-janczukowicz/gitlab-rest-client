package io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedenvironments;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4GroupsIdProtectedEnvironments}.
 *
 * @param name the name
 * @param requiredApprovalCount the required approval count
 * @param deployAccessLevels the deploy access levels
 * @param approvalRules the approval rules
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GroupsIdProtectedEnvironments/requestBody")
public record GitLabGroupProtectedEnvironmentCreatePayload(
        GitLabGroupProtectedEnvironmentCreateName name,
        @Nullable Integer requiredApprovalCount,
        @Nullable List<GitLabGroupProtectedEnvironmentCreateDeployAccessLevel> deployAccessLevels,
        @Nullable List<GitLabGroupProtectedEnvironmentCreateApprovalRule> approvalRules) {
    public GitLabGroupProtectedEnvironmentCreatePayload {
        requireNonNull(name, "name");
        if (deployAccessLevels != null) {
            deployAccessLevels = List.copyOf(deployAccessLevels);
        }
        if (approvalRules != null) {
            approvalRules = List.copyOf(approvalRules);
        }
    }
}

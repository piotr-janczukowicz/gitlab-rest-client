package io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedenvironments;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GroupsIdProtectedEnvironmentsName}.
 *
 * @param requiredApprovalCount the required approval count
 * @param deployAccessLevels the deploy access levels
 * @param approvalRules the approval rules
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdProtectedEnvironmentsName/requestBody")
public record GitLabGroupProtectedEnvironmentUpdatePayload(
        @Nullable Integer requiredApprovalCount,
        @Nullable List<GitLabGroupProtectedEnvironmentUpdateDeployAccessLevel> deployAccessLevels,
        @Nullable List<GitLabGroupProtectedEnvironmentUpdateApprovalRule> approvalRules) {
    public GitLabGroupProtectedEnvironmentUpdatePayload {
        if (deployAccessLevels != null) {
            deployAccessLevels = List.copyOf(deployAccessLevels);
        }
        if (approvalRules != null) {
            approvalRules = List.copyOf(approvalRules);
        }
    }
}

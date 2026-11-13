package io.github.piotr_janczukowicz.gitlab.api.protectedenvironments;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdProtectedEnvironmentsName}.
 *
 * @param requiredApprovalCount the required approval count
 * @param deployAccessLevels the deploy access levels
 * @param approvalRules the approval rules
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdProtectedEnvironmentsName/requestBody")
public record GitLabProjectProtectedEnvironmentUpdatePayload(
        @Nullable Integer requiredApprovalCount,
        @Nullable List<GitLabProjectProtectedEnvironmentUpdateDeployAccessLevel> deployAccessLevels,
        @Nullable List<GitLabProjectProtectedEnvironmentUpdateApprovalRule> approvalRules) {
    public GitLabProjectProtectedEnvironmentUpdatePayload {
        if (deployAccessLevels != null) {
            deployAccessLevels = List.copyOf(deployAccessLevels);
        }
        if (approvalRules != null) {
            approvalRules = List.copyOf(approvalRules);
        }
    }
}

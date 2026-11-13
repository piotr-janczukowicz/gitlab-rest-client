package io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovals;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdMergeRequestsMergeRequestIidApprovalRules}.
 *
 * @param name the name
 * @param approvalsRequired the approvals required
 * @param approvalProjectRuleId the approval project rule id
 * @param userIds the user ids
 * @param groupIds the group ids
 * @param usernames the usernames
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdMergeRequestsMergeRequestIidApprovalRules/requestBody")
public record GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload(
        @Nullable String name,
        @Nullable Integer approvalsRequired,
        @Nullable Long approvalProjectRuleId,
        @Nullable List<Long> userIds,
        @Nullable List<Long> groupIds,
        @Nullable List<String> usernames) {
    public GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload {
        if (userIds != null) {
            userIds = List.copyOf(userIds);
        }
        if (groupIds != null) {
            groupIds = List.copyOf(groupIds);
        }
        if (usernames != null) {
            usernames = List.copyOf(usernames);
        }
    }
}

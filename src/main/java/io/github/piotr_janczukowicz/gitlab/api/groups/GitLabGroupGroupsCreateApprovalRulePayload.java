package io.github.piotr_janczukowicz.gitlab.api.groups;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4GroupsIdApprovalRules}.
 *
 * @param name the name
 * @param approvalsRequired the approvals required
 * @param ruleType the rule type
 * @param userIds the user ids
 * @param groupIds the group ids
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GroupsIdApprovalRules/requestBody")
public record GitLabGroupGroupsCreateApprovalRulePayload(
        @Nullable String name,
        @Nullable Integer approvalsRequired,
        @Nullable String ruleType,
        @Nullable List<Long> userIds,
        @Nullable List<Long> groupIds) {
    public GitLabGroupGroupsCreateApprovalRulePayload {
        if (userIds != null) {
            userIds = List.copyOf(userIds);
        }
        if (groupIds != null) {
            groupIds = List.copyOf(groupIds);
        }
    }
}

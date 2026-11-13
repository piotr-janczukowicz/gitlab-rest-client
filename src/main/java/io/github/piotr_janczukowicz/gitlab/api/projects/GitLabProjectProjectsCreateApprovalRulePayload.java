package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdApprovalRules}.
 *
 * @param name the name
 * @param approvalsRequired the approvals required
 * @param ruleType the rule type
 * @param users the users
 * @param userIds the user ids
 * @param groups the groups
 * @param groupIds the group ids
 * @param usernames the usernames
 * @param protectedBranchIds the protected branch ids
 * @param appliesToAllProtectedBranches the applies to all protected branches
 * @param reportType the report type
 * @param coverageMinimumThreshold the coverage minimum threshold
 * @param vulnerabilitiesAllowed the vulnerabilities allowed
 * @param scanners the scanners
 * @param severityLevels the severity levels
 * @param vulnerabilityStates the vulnerability states
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdApprovalRules/requestBody")
public record GitLabProjectProjectsCreateApprovalRulePayload(
        @Nullable String name,
        @Nullable Integer approvalsRequired,
        @Nullable String ruleType,
        @Nullable List<Integer> users,
        @Nullable List<Long> userIds,
        @Nullable List<Integer> groups,
        @Nullable List<Long> groupIds,
        @Nullable List<String> usernames,
        @Nullable List<Long> protectedBranchIds,
        @Nullable Boolean appliesToAllProtectedBranches,
        @Nullable GitLabProjectProjectsCreateApprovalRuleReportType reportType,
        @Nullable Double coverageMinimumThreshold,
        @Nullable Integer vulnerabilitiesAllowed,
        @Nullable List<String> scanners,
        @Nullable List<String> severityLevels,
        @Nullable List<String> vulnerabilityStates) {
    public GitLabProjectProjectsCreateApprovalRulePayload {
        if (users != null) {
            users = List.copyOf(users);
        }
        if (userIds != null) {
            userIds = List.copyOf(userIds);
        }
        if (groups != null) {
            groups = List.copyOf(groups);
        }
        if (groupIds != null) {
            groupIds = List.copyOf(groupIds);
        }
        if (usernames != null) {
            usernames = List.copyOf(usernames);
        }
        if (protectedBranchIds != null) {
            protectedBranchIds = List.copyOf(protectedBranchIds);
        }
        if (scanners != null) {
            scanners = List.copyOf(scanners);
        }
        if (severityLevels != null) {
            severityLevels = List.copyOf(severityLevels);
        }
        if (vulnerabilityStates != null) {
            vulnerabilityStates = List.copyOf(vulnerabilityStates);
        }
    }
}

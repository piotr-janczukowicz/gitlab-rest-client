package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabGroup;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProtectedBranch;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab project approval rule.
 *
 * @param id the id
 * @param name the name
 * @param ruleType the rule type
 * @param eligibleApprovers the eligible approvers
 * @param approvalsRequired the approvals required
 * @param users the users
 * @param groups the groups
 * @param containsHiddenGroups the contains hidden groups
 * @param reportType the report type
 * @param protectedBranches the protected branches
 * @param appliesToAllProtectedBranches the applies to all protected branches
 * @param coverageMinimumThreshold the coverage minimum threshold
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProjectApprovalRule")
public record GitLabProjectApprovalRule(
        @Nullable Long id,
        @Nullable String name,
        @Nullable String ruleType,
        @Nullable List<GitLabUserBasic> eligibleApprovers,
        @Nullable Integer approvalsRequired,
        @Nullable List<GitLabUserBasic> users,
        @Nullable List<GitLabGroup> groups,
        @Nullable Boolean containsHiddenGroups,
        @Nullable String reportType,
        @Nullable List<GitLabProtectedBranch> protectedBranches,
        @Nullable Boolean appliesToAllProtectedBranches,
        @Nullable Double coverageMinimumThreshold) {}

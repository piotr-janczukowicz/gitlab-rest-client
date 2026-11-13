package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab merge request approval rule source rule.
 *
 * @param approvalsRequired the approvals required
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMergeRequestApprovalRuleSourceRule")
public record GitLabMergeRequestApprovalRuleSourceRule(
        @Nullable Integer approvalsRequired) {}

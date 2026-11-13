package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab merge request approval state.
 *
 * @param approvalRulesOverwritten the approval rules overwritten
 * @param rules the rules
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMergeRequestApprovalState")
public record GitLabMergeRequestApprovalState(
        @Nullable Boolean approvalRulesOverwritten,
        @Nullable List<GitLabMergeRequestApprovalStateRule> rules) {}

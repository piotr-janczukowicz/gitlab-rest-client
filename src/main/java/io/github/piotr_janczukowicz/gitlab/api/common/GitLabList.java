package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab list.
 *
 * @param id the id
 * @param label the label
 * @param position the position
 * @param milestone the milestone
 * @param iteration the iteration
 * @param assignee the assignee
 * @param status the status
 * @param maxIssueCount the max issue count
 * @param maxIssueWeight the max issue weight
 * @param limitMetric the limit metric
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesList")
public record GitLabList(
        @Nullable Long id,
        @Nullable GitLabLabelBasic label,
        @Nullable Integer position,
        @Nullable GitLabMilestone milestone,
        @Nullable GitLabIteration iteration,
        @Nullable GitLabUserSafe assignee,
        @Nullable GitLabWorkItemsStatus status,
        @Nullable Integer maxIssueCount,
        @Nullable Integer maxIssueWeight,
        @Nullable String limitMetric) {}

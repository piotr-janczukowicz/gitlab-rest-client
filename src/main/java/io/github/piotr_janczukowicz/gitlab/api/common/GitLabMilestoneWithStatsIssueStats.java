package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab milestone with stats issue stats of a GitLab resource.
 *
 * @param total the total
 * @param closed the closed
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMilestoneWithStats/properties/issue_stats")
public record GitLabMilestoneWithStatsIssueStats(
        @Nullable Integer total, @Nullable Integer closed) {}

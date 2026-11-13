package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab issuable time stats.
 *
 * @param timeEstimate the time estimate
 * @param totalTimeSpent the total time spent
 * @param humanTimeEstimate the human time estimate
 * @param humanTotalTimeSpent the human total time spent
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesIssuableTimeStats")
public record GitLabIssuableTimeStats(
        @Nullable Integer timeEstimate,
        @Nullable Integer totalTimeSpent,
        @Nullable String humanTimeEstimate,
        @Nullable String humanTotalTimeSpent) {}

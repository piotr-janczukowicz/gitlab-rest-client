package io.github.piotr_janczukowicz.gitlab.api.analytics;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab analytics group activity merge requests count.
 *
 * @param mergeRequestsCount the merge requests count
 * @param tooLarge the too large
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAnalyticsGroupActivityMergeRequestsCount")
public record GitLabAnalyticsGroupActivityMergeRequestsCount(
        @Nullable Integer mergeRequestsCount, @Nullable Boolean tooLarge) {}

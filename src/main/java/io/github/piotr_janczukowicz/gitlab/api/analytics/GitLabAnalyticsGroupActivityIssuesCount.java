package io.github.piotr_janczukowicz.gitlab.api.analytics;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab analytics group activity issues count.
 *
 * @param issuesCount the issues count
 * @param tooLarge the too large
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAnalyticsGroupActivityIssuesCount")
public record GitLabAnalyticsGroupActivityIssuesCount(
        @Nullable Integer issuesCount, @Nullable Boolean tooLarge) {}

package io.github.piotr_janczukowicz.gitlab.api.projectstatistics;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab project daily statistics.
 *
 * @param fetches the fetches
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProjectDailyStatistics")
public record GitLabProjectDailyStatistics(@Nullable GitLabProjectDailyStatisticsFetches fetches) {}

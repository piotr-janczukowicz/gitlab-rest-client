package io.github.piotr_janczukowicz.gitlab.api.projectstatistics;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProjectDailyFetches;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project daily statistics fetches of a GitLab resource.
 *
 * @param total the total
 * @param days the days
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProjectDailyStatistics/properties/fetches")
public record GitLabProjectDailyStatisticsFetches(
        @Nullable Integer total, @Nullable List<GitLabProjectDailyFetches> days) {}

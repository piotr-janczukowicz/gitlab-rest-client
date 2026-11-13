package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.LocalDate;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab analytics deployment frequency.
 *
 * @param value the value
 * @param fromValue the from
 * @param to the to
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAnalyticsDeploymentFrequency")
public record GitLabAnalyticsDeploymentFrequency(
        @Nullable Integer value,
        @Nullable @JsonProperty("from") LocalDate fromValue,
        @Nullable LocalDate to) {}

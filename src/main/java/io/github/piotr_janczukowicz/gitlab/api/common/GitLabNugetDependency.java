package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab nuget dependency.
 *
 * @param atId the id
 * @param atType the type
 * @param id the id
 * @param range the range
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesNugetDependency")
public record GitLabNugetDependency(
        @Nullable @JsonProperty("@id") String atId,
        @Nullable @JsonProperty("@type") String atType,
        @Nullable String id,
        @Nullable String range) {}

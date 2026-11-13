package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab nuget dependency group.
 *
 * @param atId the id
 * @param atType the type
 * @param targetFramework the target framework
 * @param dependencies the dependencies
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesNugetDependencyGroup")
public record GitLabNugetDependencyGroup(
        @Nullable @JsonProperty("@id") String atId,
        @Nullable @JsonProperty("@type") String atType,
        @Nullable @JsonProperty("targetFramework") String targetFramework,
        @Nullable List<GitLabNugetDependency> dependencies) {}

package io.github.piotr_janczukowicz.gitlab.api.nugetpackages;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab nuget packages versions.
 *
 * @param versions the versions
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesNugetPackagesVersions")
public record GitLabNugetPackagesVersions(@Nullable List<String> versions) {}

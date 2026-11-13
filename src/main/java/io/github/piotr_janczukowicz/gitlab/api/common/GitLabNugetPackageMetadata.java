package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab nuget package metadata.
 *
 * @param atId the id
 * @param packageContent the package content
 * @param catalogEntry the catalog entry
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesNugetPackageMetadata")
public record GitLabNugetPackageMetadata(
        @Nullable @JsonProperty("@id") String atId,
        @Nullable @JsonProperty("packageContent") String packageContent,
        @Nullable @JsonProperty("catalogEntry") GitLabNugetPackageMetadataCatalogEntry catalogEntry) {}

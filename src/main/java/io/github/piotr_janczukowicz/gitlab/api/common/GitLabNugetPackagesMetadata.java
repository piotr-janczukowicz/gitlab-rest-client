package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab nuget packages metadata.
 *
 * @param count the count
 * @param items the items
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesNugetPackagesMetadata")
public record GitLabNugetPackagesMetadata(
        @Nullable Integer count, @Nullable List<GitLabNugetPackagesMetadataItem> items) {}

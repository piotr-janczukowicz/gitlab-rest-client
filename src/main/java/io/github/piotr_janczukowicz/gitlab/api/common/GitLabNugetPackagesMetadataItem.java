package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab nuget packages metadata item.
 *
 * @param atId the id
 * @param lower the lower
 * @param upper the upper
 * @param count the count
 * @param items the items
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesNugetPackagesMetadataItem")
public record GitLabNugetPackagesMetadataItem(
        @Nullable @JsonProperty("@id") String atId,
        @Nullable String lower,
        @Nullable String upper,
        @Nullable Integer count,
        @Nullable List<GitLabNugetPackageMetadata> items) {}

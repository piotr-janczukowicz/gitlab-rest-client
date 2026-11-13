package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab nuget search result version.
 *
 * @param atId the id
 * @param version the version
 * @param downloads the downloads
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesNugetSearchResultVersion")
public record GitLabNugetSearchResultVersion(
        @Nullable @JsonProperty("@id") String atId,
        @Nullable String version,
        @Nullable Integer downloads) {}

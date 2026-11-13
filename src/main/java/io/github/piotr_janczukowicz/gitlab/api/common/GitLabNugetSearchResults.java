package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab nuget search results.
 *
 * @param totalHits the total hits
 * @param data the data
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesNugetSearchResults")
public record GitLabNugetSearchResults(
        @Nullable @JsonProperty("totalHits") Integer totalHits,
        @Nullable List<GitLabNugetSearchResult> data) {}

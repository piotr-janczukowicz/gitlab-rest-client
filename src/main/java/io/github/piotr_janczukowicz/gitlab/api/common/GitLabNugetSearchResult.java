package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab nuget search result.
 *
 * @param atType the type
 * @param id the id
 * @param title the title
 * @param totalDownloads the total downloads
 * @param verified the verified
 * @param version the version
 * @param versions the versions
 * @param tags the tags
 * @param authors the authors
 * @param description the description
 * @param summary the summary
 * @param projectUrl the project url
 * @param licenseUrl the license url
 * @param iconUrl the icon url
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesNugetSearchResult")
public record GitLabNugetSearchResult(
        @Nullable @JsonProperty("@type") String atType,
        @Nullable String id,
        @Nullable String title,
        @Nullable @JsonProperty("totalDownloads") Integer totalDownloads,
        @Nullable Boolean verified,
        @Nullable String version,
        @Nullable List<GitLabNugetSearchResultVersion> versions,
        @Nullable String tags,
        @Nullable String authors,
        @Nullable String description,
        @Nullable String summary,
        @Nullable @JsonProperty("projectUrl") String projectUrl,
        @Nullable @JsonProperty("licenseUrl") String licenseUrl,
        @Nullable @JsonProperty("iconUrl") String iconUrl) {}

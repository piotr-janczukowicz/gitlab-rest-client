package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab nuget package metadata catalog entry.
 *
 * @param atId the id
 * @param dependencyGroups the dependency groups
 * @param id the id
 * @param version the version
 * @param tags the tags
 * @param packageContent the package content
 * @param authors the authors
 * @param description the description
 * @param summary the summary
 * @param projectUrl the project url
 * @param licenseUrl the license url
 * @param iconUrl the icon url
 * @param published the published
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesNugetPackageMetadataCatalogEntry")
public record GitLabNugetPackageMetadataCatalogEntry(
        @Nullable @JsonProperty("@id") String atId,
        @Nullable @JsonProperty("dependencyGroups") List<GitLabNugetDependencyGroup> dependencyGroups,
        @Nullable String id,
        @Nullable String version,
        @Nullable String tags,
        @Nullable @JsonProperty("packageContent") String packageContent,
        @Nullable String authors,
        @Nullable String description,
        @Nullable String summary,
        @Nullable @JsonProperty("projectUrl") String projectUrl,
        @Nullable @JsonProperty("licenseUrl") String licenseUrl,
        @Nullable @JsonProperty("iconUrl") String iconUrl,
        @Nullable String published) {}

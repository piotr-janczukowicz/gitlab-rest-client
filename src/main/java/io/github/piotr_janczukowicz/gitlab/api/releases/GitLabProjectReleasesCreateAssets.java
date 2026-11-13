package io.github.piotr_janczukowicz.gitlab.api.releases;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project releases create assets of a GitLab resource.
 *
 * @param links the links
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdReleases/requestBody/properties/assets")
public record GitLabProjectReleasesCreateAssets(@Nullable List<GitLabProjectReleasesCreateAssetsLink> links) {
    public GitLabProjectReleasesCreateAssets {
        if (links != null) {
            links = List.copyOf(links);
        }
    }
}

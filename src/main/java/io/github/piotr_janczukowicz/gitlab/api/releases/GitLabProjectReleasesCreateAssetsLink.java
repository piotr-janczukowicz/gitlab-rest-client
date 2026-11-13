package io.github.piotr_janczukowicz.gitlab.api.releases;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project releases create assets link of a GitLab resource.
 *
 * @param name the name
 * @param url the url
 * @param directAssetPath the direct asset path
 * @param filepath the filepath
 * @param linkType the link type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdReleases/requestBody/properties/assets/properties/links/items")
public record GitLabProjectReleasesCreateAssetsLink(
        @Nullable String name,
        @Nullable String url,
        @Nullable String directAssetPath,
        @Nullable String filepath,
        @Nullable GitLabProjectReleasesCreateAssetsLinkType linkType) {}

package io.github.piotr_janczukowicz.gitlab.api.releaselinks;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab release link.
 *
 * @param id the id
 * @param name the name
 * @param url the url
 * @param directAssetUrl the direct asset url
 * @param linkType the link type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesReleasesLink")
public record GitLabReleaseLink(
        @Nullable Long id,
        @Nullable String name,
        @Nullable String url,
        @Nullable String directAssetUrl,
        @Nullable String linkType) {}

package io.github.piotr_janczukowicz.gitlab.api.releaselinks;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdReleasesTagNameAssetsLinks}.
 *
 * @param name the name
 * @param url the url
 * @param directAssetPath the direct asset path
 * @param filepath the filepath
 * @param linkType the link type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdReleasesTagNameAssetsLinks/requestBody")
public record GitLabProjectReleaseLinksCreatePayload(
        @Nullable String name,
        @Nullable String url,
        @Nullable String directAssetPath,
        @Nullable String filepath,
        @Nullable GitLabProjectReleaseLinksCreateLinkType linkType) {}

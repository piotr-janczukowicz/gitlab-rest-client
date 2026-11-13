package io.github.piotr_janczukowicz.gitlab.api.geo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab geo info refs upload pack data of a GitLab resource.
 *
 * @param glId the gl id
 * @param primaryRepo the primary repo
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GeoProxyGitSshInfoRefsUploadPack/requestBody/properties/data")
public record GitLabGeoInfoRefsUploadPackData(
        @Nullable String glId, @Nullable String primaryRepo) {}

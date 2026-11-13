package io.github.piotr_janczukowicz.gitlab.api.projectimportexport;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project export status links of a GitLab resource.
 *
 * @param apiUrl the api url
 * @param webUrl the web url
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProjectExportStatus/properties/_links")
public record GitLabProjectExportStatusLinks(
        @Nullable String apiUrl, @Nullable String webUrl) {}

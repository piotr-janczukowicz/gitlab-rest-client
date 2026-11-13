package io.github.piotr_janczukowicz.gitlab.api.geonodes;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab geo node links of a GitLab resource.
 *
 * @param self the self
 * @param status the status
 * @param repair the repair
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesGeoNode/properties/_links")
public record GitLabGeoNodeLinks(
        @Nullable String self,
        @Nullable String status,
        @Nullable String repair) {}

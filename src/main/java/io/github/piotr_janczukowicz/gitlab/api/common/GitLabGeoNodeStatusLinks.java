package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab geo node status links of a GitLab resource.
 *
 * @param self the self
 * @param node the node
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesGeoNodeStatus/properties/_links")
public record GitLabGeoNodeStatusLinks(
        @Nullable String self, @Nullable String node) {}

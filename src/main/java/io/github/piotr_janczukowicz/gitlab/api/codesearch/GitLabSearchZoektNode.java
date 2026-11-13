package io.github.piotr_janczukowicz.gitlab.api.codesearch;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab search zoekt node.
 *
 * @param id the id
 * @param indexBaseUrl the index base url
 * @param searchBaseUrl the search base url
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesSearchZoektNode")
public record GitLabSearchZoektNode(
        @Nullable Long id,
        @Nullable String indexBaseUrl,
        @Nullable String searchBaseUrl) {}

package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab basic group details.
 *
 * @param id the id
 * @param webUrl the web url
 * @param name the name
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesBasicGroupDetails")
public record GitLabBasicGroupDetails(
        @Nullable Long id,
        @Nullable String webUrl,
        @Nullable String name) {}

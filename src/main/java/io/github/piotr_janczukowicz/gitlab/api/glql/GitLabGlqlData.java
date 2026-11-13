package io.github.piotr_janczukowicz.gitlab.api.glql;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab glql data.
 *
 * @param count the count
 * @param pageInfo the page info
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesGlqlData")
public record GitLabGlqlData(
        @Nullable Integer count,
        @Nullable @JsonProperty("pageInfo") GitLabGlqlPageInfo pageInfo) {}

package io.github.piotr_janczukowicz.gitlab.api.glql;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab glql page info.
 *
 * @param endCursor the end cursor
 * @param hasNextPage the has next page
 * @param hasPreviousPage the has previous page
 * @param startCursor the start cursor
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesGlqlPageInfo")
public record GitLabGlqlPageInfo(
        @Nullable @JsonProperty("endCursor") String endCursor,
        @Nullable @JsonProperty("hasNextPage") Boolean hasNextPage,
        @Nullable @JsonProperty("hasPreviousPage") Boolean hasPreviousPage,
        @Nullable @JsonProperty("startCursor") String startCursor) {}

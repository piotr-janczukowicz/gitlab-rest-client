package io.github.piotr_janczukowicz.gitlab.api.glql;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4Glql}.
 *
 * @param glqlYaml the glql yaml
 * @param after the after
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4Glql/requestBody")
public record GitLabGLQLCreatePayload(
        @Nullable String glqlYaml, @Nullable String after) {}

package io.github.piotr_janczukowicz.gitlab.api.orbit;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4OrbitContext}.
 *
 * @param tokens the tokens
 * @param expand the expand
 * @param responseFormat the response format
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4OrbitContext/requestBody")
public record GitLabOrbitContextPayload(
        @Nullable List<String> tokens,
        @Nullable Boolean expand,
        @Nullable GitLabOrbitContextResponseFormat responseFormat) {
    public GitLabOrbitContextPayload {
        if (tokens != null) {
            tokens = List.copyOf(tokens);
        }
    }
}

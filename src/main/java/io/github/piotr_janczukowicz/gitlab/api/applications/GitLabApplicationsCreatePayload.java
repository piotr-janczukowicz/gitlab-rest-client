package io.github.piotr_janczukowicz.gitlab.api.applications;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4Applications}.
 *
 * @param name the name
 * @param redirectUri the redirect uri
 * @param scopes the scopes
 * @param confidential the confidential
 * @param granularScopes the granular scopes
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4Applications/requestBody")
public record GitLabApplicationsCreatePayload(
        @Nullable String name,
        @Nullable String redirectUri,
        @Nullable String scopes,
        @Nullable Boolean confidential,
        @Nullable List<GitLabApplicationsCreateGranularScope> granularScopes) {
    public GitLabApplicationsCreatePayload {
        if (granularScopes != null) {
            granularScopes = List.copyOf(granularScopes);
        }
    }
}

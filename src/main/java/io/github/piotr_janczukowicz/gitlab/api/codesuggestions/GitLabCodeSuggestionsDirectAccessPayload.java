package io.github.piotr_janczukowicz.gitlab.api.codesuggestions;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4CodeSuggestionsDirectAccess}.
 *
 * @param projectPath the project path
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4CodeSuggestionsDirectAccess/requestBody")
public record GitLabCodeSuggestionsDirectAccessPayload(
        @Nullable String projectPath) {}

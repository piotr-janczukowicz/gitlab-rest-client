package io.github.piotr_janczukowicz.gitlab.api.suggestions;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4SuggestionsIdApply}.
 *
 * @param commitMessage the commit message
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4SuggestionsIdApply/requestBody")
public record GitLabSuggestionsApplyPayload(@Nullable String commitMessage) {}

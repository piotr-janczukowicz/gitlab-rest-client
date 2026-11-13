package io.github.piotr_janczukowicz.gitlab.api.markdown;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4Markdown}.
 *
 * @param text the text
 * @param gfm the gfm
 * @param project the project
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4Markdown/requestBody")
public record GitLabMarkdownCreatePayload(
        @Nullable String text,
        @Nullable Boolean gfm,
        @Nullable String project) {}

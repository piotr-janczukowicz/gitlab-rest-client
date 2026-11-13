package io.github.piotr_janczukowicz.gitlab.api.codesnippets;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab code snippets create file of a GitLab resource.
 *
 * @param filePath the file path
 * @param content the content
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4Snippets/requestBody/properties/files/items")
public record GitLabCodeSnippetsCreateFile(
        @Nullable String filePath, @Nullable String content) {}

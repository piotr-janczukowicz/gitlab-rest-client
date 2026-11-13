package io.github.piotr_janczukowicz.gitlab.api.projectsnippets;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project project snippets create file of a GitLab resource.
 *
 * @param filePath the file path
 * @param content the content
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdSnippets/requestBody/properties/files/items")
public record GitLabProjectProjectSnippetsCreateFile(
        @Nullable String filePath, @Nullable String content) {}

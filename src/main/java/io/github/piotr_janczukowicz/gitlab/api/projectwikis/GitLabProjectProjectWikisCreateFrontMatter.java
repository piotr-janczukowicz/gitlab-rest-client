package io.github.piotr_janczukowicz.gitlab.api.projectwikis;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project project wikis create front matter of a GitLab resource.
 *
 * @param title the title
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdWikis/requestBody/properties/front_matter")
public record GitLabProjectProjectWikisCreateFrontMatter(
        @Nullable String title) {}

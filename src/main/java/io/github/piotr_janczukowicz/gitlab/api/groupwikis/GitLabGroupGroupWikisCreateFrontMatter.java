package io.github.piotr_janczukowicz.gitlab.api.groupwikis;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab group group wikis create front matter of a GitLab resource.
 *
 * @param title the title
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GroupsIdWikis/requestBody/properties/front_matter")
public record GitLabGroupGroupWikisCreateFrontMatter(
        @Nullable String title) {}

package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab detailed status entity action of a GitLab resource.
 *
 * @param icon the icon
 * @param title the title
 * @param path the path
 * @param method the method
 * @param buttonTitle the button title
 * @param confirmationMessage the confirmation message
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/DetailedStatusEntity/properties/action")
public record GitLabDetailedStatusEntityAction(
        @Nullable String icon,
        @Nullable String title,
        @Nullable String path,
        @Nullable String method,
        @Nullable String buttonTitle,
        @Nullable String confirmationMessage) {}

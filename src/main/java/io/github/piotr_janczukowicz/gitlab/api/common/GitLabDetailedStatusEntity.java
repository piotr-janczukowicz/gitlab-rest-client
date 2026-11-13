package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab detailed status entity.
 *
 * @param icon the icon
 * @param text the text
 * @param label the label
 * @param group the group
 * @param tooltip the tooltip
 * @param hasDetails the has details
 * @param detailsPath the details path
 * @param illustration the illustration
 * @param favicon the favicon
 * @param action the action
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/DetailedStatusEntity")
public record GitLabDetailedStatusEntity(
        @Nullable String icon,
        @Nullable String text,
        @Nullable String label,
        @Nullable String group,
        @Nullable String tooltip,
        @Nullable Boolean hasDetails,
        @Nullable String detailsPath,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> illustration,

        @Nullable String favicon,
        @Nullable GitLabDetailedStatusEntityAction action) {}

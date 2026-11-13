package io.github.piotr_janczukowicz.gitlab.api.glql;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab glql field.
 *
 * @param key the key
 * @param label the label
 * @param name the name
 * @param field the field
 * @param type the type
 * @param parameters the parameters
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesGlqlField")
public record GitLabGlqlField(
        @Nullable String key,
        @Nullable String label,
        @Nullable String name,
        @Nullable String field,
        @Nullable String type,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> parameters) {}

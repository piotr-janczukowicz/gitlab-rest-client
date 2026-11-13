package io.github.piotr_janczukowicz.gitlab.api.protectedtags;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdProtectedTags}.
 *
 * @param name the name
 * @param createAccessLevel the create access level
 * @param allowedToCreate the allowed to create
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdProtectedTags/requestBody")
public record GitLabProjectProtectedTagsCreatePayload(
        @Nullable String name,
        @Nullable GitLabProjectProtectedTagsCreateAccessLevel createAccessLevel,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        List<Map<String, Object>> allowedToCreate) {
    public GitLabProjectProtectedTagsCreatePayload {
        if (allowedToCreate != null) {
            allowedToCreate = List.copyOf(allowedToCreate);
        }
    }
}

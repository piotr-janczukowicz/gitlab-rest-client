package io.github.piotr_janczukowicz.gitlab.api.orbit;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab orbit context entity.
 *
 * @param token the token
 * @param resolvedToken the resolved token
 * @param type the type
 * @param id the id
 * @param found the found
 * @param summary the summary
 * @param error the error
 * @param expansion the expansion
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesOrbitContextEntity")
public record GitLabOrbitContextEntity(
        @Nullable String token,
        @Nullable String resolvedToken,
        @Nullable String type,
        @Nullable String id,
        @Nullable Boolean found,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> summary,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> error,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> expansion) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token}, {@code resolvedToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabOrbitContextEntity[" + "token=<redacted>" + ", resolvedToken=<redacted>" + ", type=" + type
                + ", id=" + id + ", found=" + found + ", summary=" + summary + ", error=" + error + ", expansion="
                + expansion + "]";
    }
}

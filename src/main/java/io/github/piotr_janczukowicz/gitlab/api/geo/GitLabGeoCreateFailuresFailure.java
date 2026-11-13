package io.github.piotr_janczukowicz.gitlab.api.geo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * The git lab geo create failures failure of a GitLab resource.
 *
 * @param errorType the error type
 * @param replicableName the replicable name
 * @param replicableId the replicable id
 * @param verificationRetryCount the verification retry count
 * @param context the context
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GeoFailures/requestBody/properties/failures/items")
public record GitLabGeoCreateFailuresFailure(
        @Nullable String errorType,
        @Nullable String replicableName,
        @Nullable Long replicableId,
        @Nullable Integer verificationRetryCount,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> context) {
    public GitLabGeoCreateFailuresFailure {
        if (context != null) {
            context = Map.copyOf(context);
        }
    }
}

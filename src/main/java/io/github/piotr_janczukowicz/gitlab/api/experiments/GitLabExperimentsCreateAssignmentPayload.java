package io.github.piotr_janczukowicz.gitlab.api.experiments;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ExperimentsExperimentNameAssignments}.
 *
 * @param variant the variant
 * @param context the context
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ExperimentsExperimentNameAssignments/requestBody")
public record GitLabExperimentsCreateAssignmentPayload(
        @Nullable String variant,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> context) {
    public GitLabExperimentsCreateAssignmentPayload {
        if (context != null) {
            context = Map.copyOf(context);
        }
    }
}

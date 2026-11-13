package io.github.piotr_janczukowicz.gitlab.api.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdJobsJobIdRetry}.
 *
 * @param inputs the inputs
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdJobsJobIdRetry/requestBody")
public record GitLabProjectJobsRetryPayload(
        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> inputs) {
    public GitLabProjectJobsRetryPayload {
        if (inputs != null) {
            inputs = Map.copyOf(inputs);
        }
    }
}

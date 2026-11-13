package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdRefRefTriggerPipeline}.
 *
 * @param token the token
 * @param variables the variables
 * @param inputs the inputs
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdRefRefTriggerPipeline/requestBody")
public record GitLabProjectProjectsPipelineRefTriggerPayload(
        @Nullable String token,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> variables,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> inputs) {
    public GitLabProjectProjectsPipelineRefTriggerPayload {
        if (variables != null) {
            variables = Map.copyOf(variables);
        }
        if (inputs != null) {
            inputs = Map.copyOf(inputs);
        }
    }

    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectProjectsPipelineRefTriggerPayload[" + "token=<redacted>" + ", variables=" + variables
                + ", inputs=" + inputs + "]";
    }
}

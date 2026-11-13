package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdPipeline}.
 *
 * @param ref the ref
 * @param variables the variables
 * @param inputs the inputs
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdPipeline/requestBody")
public record GitLabProjectPipelinesCreatePayload(
        @Nullable String ref,
        @Nullable List<GitLabProjectPipelinesCreateVariable> variables,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> inputs) {
    public GitLabProjectPipelinesCreatePayload {
        if (variables != null) {
            variables = List.copyOf(variables);
        }
        if (inputs != null) {
            inputs = Map.copyOf(inputs);
        }
    }
}

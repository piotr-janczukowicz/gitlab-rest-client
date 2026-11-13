package io.github.piotr_janczukowicz.gitlab.api.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdJobsJobIdPlay}.
 *
 * @param jobVariablesAttributes the job variables attributes
 * @param jobInputs the job inputs
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdJobsJobIdPlay/requestBody")
public record GitLabProjectJobsPlayPayload(
        @Nullable List<GitLabProjectJobsPlayJobVariablesAttribute> jobVariablesAttributes,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> jobInputs) {
    public GitLabProjectJobsPlayPayload {
        if (jobVariablesAttributes != null) {
            jobVariablesAttributes = List.copyOf(jobVariablesAttributes);
        }
        if (jobInputs != null) {
            jobInputs = Map.copyOf(jobInputs);
        }
    }
}

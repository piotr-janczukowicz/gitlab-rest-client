package io.github.piotr_janczukowicz.gitlab.api.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code patchApiV4JobsIdTrace}.
 *
 * @param token the token
 * @param debugTrace the debug trace
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/patchApiV4JobsIdTrace/requestBody")
public record GitLabInstanceJobsTracePayload(
        @Nullable String token, @Nullable Boolean debugTrace) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabInstanceJobsTracePayload[" + "token=<redacted>" + ", debugTrace=" + debugTrace + "]";
    }
}

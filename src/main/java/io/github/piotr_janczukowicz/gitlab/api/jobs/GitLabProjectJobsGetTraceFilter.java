package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireAtLeastIfPresent;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireBetweenIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdJobsJobIdTrace}, without paging.
 *
 * @param byteOffset the byte offset
 * @param byteLimit the byte limit
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdJobsJobIdTrace/parameters")
public record GitLabProjectJobsGetTraceFilter(
        @Nullable Integer byteOffset, @Nullable Integer byteLimit) {
    public GitLabProjectJobsGetTraceFilter {
        requireAtLeastIfPresent(byteOffset, 0, "byteOffset");
        requireBetweenIfPresent(byteLimit, 1, 512_000, "byteLimit");
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectJobsGetTraceFilter empty() {
        return GitLabProjectJobsGetTraceFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("byte_offset", byteOffset)
                .value("byte_limit", byteLimit)
                .build();
    }
}

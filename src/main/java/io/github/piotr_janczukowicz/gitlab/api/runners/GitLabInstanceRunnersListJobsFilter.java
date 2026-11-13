package io.github.piotr_janczukowicz.gitlab.api.runners;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4RunnersIdJobs}, without paging.
 *
 * @param systemId the system id
 * @param status the status
 * @param cursor the cursor
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4RunnersIdJobs/parameters")
public record GitLabInstanceRunnersListJobsFilter(
        @Nullable String systemId,
        @Nullable GitLabInstanceRunnersListJobsStatus status,
        @Nullable String cursor) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabInstanceRunnersListJobsFilter empty() {
        return GitLabInstanceRunnersListJobsFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("system_id", systemId)
                .wire("status", status, GitLabInstanceRunnersListJobsStatus::wireValue)
                .text("cursor", cursor)
                .build();
    }
}

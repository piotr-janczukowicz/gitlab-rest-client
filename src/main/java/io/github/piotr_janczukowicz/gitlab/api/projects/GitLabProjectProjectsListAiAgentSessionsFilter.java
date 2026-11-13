package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdAiAgentSessions}, without paging.
 *
 * @param agentType the agent type
 * @param status the status
 * @param createdAfter the created after
 * @param createdBefore the created before
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdAiAgentSessions/parameters")
public record GitLabProjectProjectsListAiAgentSessionsFilter(
        @Nullable GitLabProjectProjectsListAiAgentSessionsAgentType agentType,
        @Nullable GitLabProjectProjectsListAiAgentSessionsStatus status,
        @Nullable Instant createdAfter,
        @Nullable Instant createdBefore) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectProjectsListAiAgentSessionsFilter empty() {
        return GitLabProjectProjectsListAiAgentSessionsFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("agent_type", agentType, GitLabProjectProjectsListAiAgentSessionsAgentType::wireValue)
                .wire("status", status, GitLabProjectProjectsListAiAgentSessionsStatus::wireValue)
                .value("created_after", createdAfter)
                .value("created_before", createdBefore)
                .build();
    }
}

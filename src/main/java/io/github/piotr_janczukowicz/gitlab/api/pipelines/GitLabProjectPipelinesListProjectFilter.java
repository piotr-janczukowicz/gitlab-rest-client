package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdPipelines}, without paging.
 *
 * @param scope the scope
 * @param status the status
 * @param ref the ref
 * @param sha the sha
 * @param yamlErrors the yaml errors
 * @param username the username
 * @param updatedBefore the updated before
 * @param updatedAfter the updated after
 * @param createdBefore the created before
 * @param createdAfter the created after
 * @param orderBy the order by
 * @param sort the sort
 * @param source the source
 * @param name the name
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdPipelines/parameters")
public record GitLabProjectPipelinesListProjectFilter(
        @Nullable GitLabProjectPipelinesListProjectScope scope,
        @Nullable GitLabProjectPipelinesListProjectStatus status,
        @Nullable String ref,
        @Nullable String sha,
        @Nullable Boolean yamlErrors,
        @Nullable String username,
        @Nullable Instant updatedBefore,
        @Nullable Instant updatedAfter,
        @Nullable Instant createdBefore,
        @Nullable Instant createdAfter,
        @Nullable GitLabProjectPipelinesListProjectOrderBy orderBy,
        @Nullable GitLabProjectPipelinesListProjectSort sort,
        @Nullable GitLabProjectPipelinesListProjectSource source,
        @Nullable String name) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectPipelinesListProjectFilter empty() {
        return GitLabProjectPipelinesListProjectFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("scope", scope, GitLabProjectPipelinesListProjectScope::wireValue)
                .wire("status", status, GitLabProjectPipelinesListProjectStatus::wireValue)
                .text("ref", ref)
                .text("sha", sha)
                .value("yaml_errors", yamlErrors)
                .text("username", username)
                .value("updated_before", updatedBefore)
                .value("updated_after", updatedAfter)
                .value("created_before", createdBefore)
                .value("created_after", createdAfter)
                .wire("order_by", orderBy, GitLabProjectPipelinesListProjectOrderBy::wireValue)
                .wire("sort", sort, GitLabProjectPipelinesListProjectSort::wireValue)
                .wire("source", source, GitLabProjectPipelinesListProjectSource::wireValue)
                .text("name", name)
                .build();
    }
}

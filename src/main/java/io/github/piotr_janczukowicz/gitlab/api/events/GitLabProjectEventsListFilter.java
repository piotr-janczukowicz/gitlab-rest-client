package io.github.piotr_janczukowicz.gitlab.api.events;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.LocalDate;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdEvents}, without paging.
 *
 * @param action the action
 * @param targetType the target type
 * @param before the before
 * @param after the after
 * @param sort the sort
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdEvents/parameters")
public record GitLabProjectEventsListFilter(
        @Nullable String action,
        @Nullable GitLabProjectEventsListTargetType targetType,
        @Nullable LocalDate before,
        @Nullable LocalDate after,
        @Nullable GitLabProjectEventsListSort sort) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectEventsListFilter empty() {
        return GitLabProjectEventsListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("action", action)
                .wire("target_type", targetType, GitLabProjectEventsListTargetType::wireValue)
                .value("before", before)
                .value("after", after)
                .wire("sort", sort, GitLabProjectEventsListSort::wireValue)
                .build();
    }
}

package io.github.piotr_janczukowicz.gitlab.api.events;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.LocalDate;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4UsersIdEvents}, without paging.
 *
 * @param action the action
 * @param targetType the target type
 * @param before the before
 * @param after the after
 * @param sort the sort
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4UsersIdEvents/parameters")
public record GitLabInstanceEventsListUsersEventsFilter(
        @Nullable String action,
        @Nullable GitLabInstanceEventsListUsersEventsTargetType targetType,
        @Nullable LocalDate before,
        @Nullable LocalDate after,
        @Nullable GitLabInstanceEventsListUsersEventsSort sort) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabInstanceEventsListUsersEventsFilter empty() {
        return GitLabInstanceEventsListUsersEventsFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("action", action)
                .wire("target_type", targetType, GitLabInstanceEventsListUsersEventsTargetType::wireValue)
                .value("before", before)
                .value("after", after)
                .wire("sort", sort, GitLabInstanceEventsListUsersEventsSort::wireValue)
                .build();
    }
}

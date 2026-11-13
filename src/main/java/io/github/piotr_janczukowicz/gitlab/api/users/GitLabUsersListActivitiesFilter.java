package io.github.piotr_janczukowicz.gitlab.api.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4UserActivities}, without paging.
 *
 * @param fromValue the from
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4UserActivities/parameters")
public record GitLabUsersListActivitiesFilter(
        @Nullable @JsonProperty("from") Instant fromValue) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabUsersListActivitiesFilter empty() {
        return GitLabUsersListActivitiesFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder().value("from", fromValue).build();
    }
}

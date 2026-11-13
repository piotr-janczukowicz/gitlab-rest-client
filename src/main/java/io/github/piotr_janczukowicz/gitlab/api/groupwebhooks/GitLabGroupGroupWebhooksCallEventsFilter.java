package io.github.piotr_janczukowicz.gitlab.api.groupwebhooks;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4GroupsIdHooksHookIdEvents}, without paging.
 *
 * @param status the status
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4GroupsIdHooksHookIdEvents/parameters")
public record GitLabGroupGroupWebhooksCallEventsFilter(
        @Nullable List<GitLabGroupGroupWebhooksCallEventsStatus> status) {
    public GitLabGroupGroupWebhooksCallEventsFilter {
        if (status != null) {
            status = List.copyOf(status);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupGroupWebhooksCallEventsFilter empty() {
        return GitLabGroupGroupWebhooksCallEventsFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wireList("status", status, GitLabGroupGroupWebhooksCallEventsStatus::wireValue)
                .build();
    }
}

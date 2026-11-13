package io.github.piotr_janczukowicz.gitlab.api.projectwebhooks;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdHooksHookIdEvents}, without paging.
 *
 * @param status the status
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdHooksHookIdEvents/parameters")
public record GitLabProjectProjectWebhooksCallEventsFilter(
        @Nullable List<GitLabProjectProjectWebhooksCallEventsStatus> status) {
    public GitLabProjectProjectWebhooksCallEventsFilter {
        if (status != null) {
            status = List.copyOf(status);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectProjectWebhooksCallEventsFilter empty() {
        return GitLabProjectProjectWebhooksCallEventsFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wireList("status", status, GitLabProjectProjectWebhooksCallEventsStatus::wireValue)
                .build();
    }
}

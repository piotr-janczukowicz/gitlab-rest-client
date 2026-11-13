package io.github.piotr_janczukowicz.gitlab.api.unleash;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4FeatureFlagsUnleashProjectId}, without paging.
 *
 * @param instanceId the instance id
 * @param appName the app name
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4FeatureFlagsUnleashProjectId/parameters")
public record GitLabUnleashCallFilter(
        @Nullable String instanceId, @Nullable String appName) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabUnleashCallFilter empty() {
        return GitLabUnleashCallFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("instance_id", instanceId)
                .text("app_name", appName)
                .build();
    }
}

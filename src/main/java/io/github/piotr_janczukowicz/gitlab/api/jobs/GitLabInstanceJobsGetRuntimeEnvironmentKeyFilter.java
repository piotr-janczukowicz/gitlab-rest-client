package io.github.piotr_janczukowicz.gitlab.api.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4JobsIdRuntimeEnvironmentKey}, without paging.
 *
 * @param token the token
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4JobsIdRuntimeEnvironmentKey/parameters")
public record GitLabInstanceJobsGetRuntimeEnvironmentKeyFilter(
        @Nullable String token) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabInstanceJobsGetRuntimeEnvironmentKeyFilter[" + "token=<redacted>" + "]";
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabInstanceJobsGetRuntimeEnvironmentKeyFilter empty() {
        return GitLabInstanceJobsGetRuntimeEnvironmentKeyFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder().text("token", token).build();
    }
}

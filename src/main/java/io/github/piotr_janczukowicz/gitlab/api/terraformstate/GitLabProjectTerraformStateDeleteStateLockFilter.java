package io.github.piotr_janczukowicz.gitlab.api.terraformstate;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code deleteApiV4ProjectsIdTerraformStateNameLock}, without paging.
 *
 * @param lockId the id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/deleteApiV4ProjectsIdTerraformStateNameLock/parameters")
public record GitLabProjectTerraformStateDeleteStateLockFilter(
        @Nullable @JsonProperty("ID") String lockId) {
    public GitLabProjectTerraformStateDeleteStateLockFilter {
        requireMaxLengthIfPresent(lockId, 255, "lockId");
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectTerraformStateDeleteStateLockFilter empty() {
        return GitLabProjectTerraformStateDeleteStateLockFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder().text("ID", lockId).build();
    }
}

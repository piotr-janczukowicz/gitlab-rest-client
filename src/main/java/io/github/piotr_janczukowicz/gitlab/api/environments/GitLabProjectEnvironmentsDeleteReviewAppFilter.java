package io.github.piotr_janczukowicz.gitlab.api.environments;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireBetweenIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code deleteApiV4ProjectsIdEnvironmentsReviewApps}, without paging.
 *
 * @param before the before
 * @param limit the limit
 * @param dryRun the dry run
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/deleteApiV4ProjectsIdEnvironmentsReviewApps/parameters")
public record GitLabProjectEnvironmentsDeleteReviewAppFilter(
        @Nullable Instant before,
        @Nullable Integer limit,
        @Nullable Boolean dryRun) {
    public GitLabProjectEnvironmentsDeleteReviewAppFilter {
        requireBetweenIfPresent(limit, 1, 1000, "limit");
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectEnvironmentsDeleteReviewAppFilter empty() {
        return GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("before", before)
                .value("limit", limit)
                .value("dry_run", dryRun)
                .build();
    }
}

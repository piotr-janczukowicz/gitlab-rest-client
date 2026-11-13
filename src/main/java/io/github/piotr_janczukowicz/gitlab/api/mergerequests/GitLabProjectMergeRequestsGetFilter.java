package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdMergeRequestsMergeRequestIid}, without paging.
 *
 * @param renderHtml the render html
 * @param includeDivergedCommitsCount the include diverged commits count
 * @param includeRebaseInProgress the include rebase in progress
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdMergeRequestsMergeRequestIid/parameters")
public record GitLabProjectMergeRequestsGetFilter(
        @Nullable Boolean renderHtml,
        @Nullable Boolean includeDivergedCommitsCount,
        @Nullable Boolean includeRebaseInProgress) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectMergeRequestsGetFilter empty() {
        return GitLabProjectMergeRequestsGetFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("render_html", renderHtml)
                .value("include_diverged_commits_count", includeDivergedCommitsCount)
                .value("include_rebase_in_progress", includeRebaseInProgress)
                .build();
    }
}

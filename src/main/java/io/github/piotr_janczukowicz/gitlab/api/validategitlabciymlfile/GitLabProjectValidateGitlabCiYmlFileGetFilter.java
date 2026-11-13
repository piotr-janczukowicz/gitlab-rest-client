package io.github.piotr_janczukowicz.gitlab.api.validategitlabciymlfile;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdCiLint}, without paging.
 *
 * @param sha the sha
 * @param contentRef the content ref
 * @param dryRun the dry run
 * @param includeJobs the include jobs
 * @param ref the ref
 * @param dryRunRef the dry run ref
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdCiLint/parameters")
public record GitLabProjectValidateGitlabCiYmlFileGetFilter(
        @Nullable String sha,
        @Nullable String contentRef,
        @Nullable Boolean dryRun,
        @Nullable Boolean includeJobs,
        @Nullable String ref,
        @Nullable String dryRunRef) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectValidateGitlabCiYmlFileGetFilter empty() {
        return GitLabProjectValidateGitlabCiYmlFileGetFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("sha", sha)
                .text("content_ref", contentRef)
                .value("dry_run", dryRun)
                .value("include_jobs", includeJobs)
                .text("ref", ref)
                .text("dry_run_ref", dryRunRef)
                .build();
    }
}

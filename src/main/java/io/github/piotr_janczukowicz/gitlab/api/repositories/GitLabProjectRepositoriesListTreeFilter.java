package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdRepositoryTree}, without paging.
 *
 * @param ref the ref
 * @param path the path
 * @param recursive the recursive
 * @param withLastCommit the with last commit
 * @param pageToken the page token
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdRepositoryTree/parameters")
public record GitLabProjectRepositoriesListTreeFilter(
        @Nullable String ref,
        @Nullable String path,
        @Nullable Boolean recursive,
        @Nullable Boolean withLastCommit,
        @Nullable String pageToken) {
    public GitLabProjectRepositoriesListTreeFilter {
        requireMaxLengthIfPresent(ref, 1024, "ref");
        requireMaxLengthIfPresent(path, 1024, "path");
    }

    /**
     * Describes this record without its secret.
     *
     * @return text with {@code pageToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectRepositoriesListTreeFilter[" + "ref=" + ref + ", path=" + path + ", recursive=" + recursive
                + ", withLastCommit=" + withLastCommit + ", pageToken=<redacted>" + "]";
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectRepositoriesListTreeFilter empty() {
        return GitLabProjectRepositoriesListTreeFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("ref", ref)
                .text("path", path)
                .value("recursive", recursive)
                .value("with_last_commit", withLastCommit)
                .text("page_token", pageToken)
                .build();
    }
}

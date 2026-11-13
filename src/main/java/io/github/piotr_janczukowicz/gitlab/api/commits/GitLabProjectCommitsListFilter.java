package io.github.piotr_janczukowicz.gitlab.api.commits;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdRepositoryCommits}, without paging.
 *
 * @param refName the ref name
 * @param since the since
 * @param until the until
 * @param path the path
 * @param follow the follow
 * @param author the author
 * @param all the all
 * @param withStats the with stats
 * @param firstParent the first parent
 * @param order the order
 * @param trailers the trailers
 * @param pageToken the page token
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdRepositoryCommits/parameters")
public record GitLabProjectCommitsListFilter(
        @Nullable String refName,
        @Nullable Instant since,
        @Nullable Instant until,
        @Nullable String path,
        @Nullable Boolean follow,
        @Nullable String author,
        @Nullable Boolean all,
        @Nullable Boolean withStats,
        @Nullable Boolean firstParent,
        @Nullable GitLabProjectCommitsListOrder order,
        @Nullable Boolean trailers,
        @Nullable String pageToken) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code pageToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectCommitsListFilter[" + "refName=" + refName + ", since=" + since + ", until=" + until
                + ", path=" + path + ", follow=" + follow + ", author=" + author + ", all=" + all + ", withStats="
                + withStats + ", firstParent=" + firstParent + ", order=" + order + ", trailers=" + trailers
                + ", pageToken=<redacted>" + "]";
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectCommitsListFilter empty() {
        return GitLabProjectCommitsListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("ref_name", refName)
                .value("since", since)
                .value("until", until)
                .text("path", path)
                .value("follow", follow)
                .text("author", author)
                .value("all", all)
                .value("with_stats", withStats)
                .value("first_parent", firstParent)
                .wire("order", order, GitLabProjectCommitsListOrder::wireValue)
                .value("trailers", trailers)
                .text("page_token", pageToken)
                .build();
    }
}

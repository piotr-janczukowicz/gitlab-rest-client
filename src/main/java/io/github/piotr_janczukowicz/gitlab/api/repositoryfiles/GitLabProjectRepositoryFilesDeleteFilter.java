package io.github.piotr_janczukowicz.gitlab.api.repositoryfiles;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code deleteApiV4ProjectsIdRepositoryFilesFilePath}, without paging.
 *
 * @param startBranch the start branch
 * @param authorEmail the author email
 * @param authorName the author name
 * @param lastCommitId the last commit id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/deleteApiV4ProjectsIdRepositoryFilesFilePath/parameters")
public record GitLabProjectRepositoryFilesDeleteFilter(
        @Nullable String startBranch,
        @Nullable String authorEmail,
        @Nullable String authorName,
        @Nullable String lastCommitId) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectRepositoryFilesDeleteFilter empty() {
        return GitLabProjectRepositoryFilesDeleteFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("start_branch", startBranch)
                .text("author_email", authorEmail)
                .text("author_name", authorName)
                .text("last_commit_id", lastCommitId)
                .build();
    }
}

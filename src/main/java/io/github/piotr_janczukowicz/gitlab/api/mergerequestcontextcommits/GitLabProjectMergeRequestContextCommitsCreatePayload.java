package io.github.piotr_janczukowicz.gitlab.api.mergerequestcontextcommits;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdMergeRequestsMergeRequestIidContextCommits}.
 *
 * @param commits the commits
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdMergeRequestsMergeRequestIidContextCommits/requestBody")
public record GitLabProjectMergeRequestContextCommitsCreatePayload(
        @Nullable List<String> commits) {
    public GitLabProjectMergeRequestContextCommitsCreatePayload {
        if (commits != null) {
            commits = List.copyOf(commits);
        }
    }
}

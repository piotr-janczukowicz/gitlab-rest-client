package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdMergeRequestsMergeRequestIidSuggestedReviewers}.
 *
 * @param suggestions the suggestions
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdMergeRequestsMergeRequestIidSuggestedReviewers/requestBody")
public record GitLabProjectSuggestedReviewerCreatePayload(
        @Nullable List<GitLabProjectSuggestedReviewerCreateSuggestion> suggestions) {
    public GitLabProjectSuggestedReviewerCreatePayload {
        if (suggestions != null) {
            suggestions = List.copyOf(suggestions);
        }
    }
}

package io.github.piotr_janczukowicz.gitlab.api.suggestions;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4SuggestionsBatchApply}.
 *
 * @param ids the ids
 * @param commitMessage the commit message
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4SuggestionsBatchApply/requestBody")
public record GitLabSuggestionsBatchApplyPayload(
        @Nullable List<Integer> ids, @Nullable String commitMessage) {
    public GitLabSuggestionsBatchApplyPayload {
        if (ids != null) {
            ids = List.copyOf(ids);
        }
    }
}

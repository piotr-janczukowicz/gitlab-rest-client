package io.github.piotr_janczukowicz.gitlab.api.gitlabduo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4DuoCodeReviewEvaluations}.
 *
 * @param diffs the diffs
 * @param mrTitle the mr title
 * @param mrDescription the mr description
 * @param filesContent the files content
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4DuoCodeReviewEvaluations/requestBody")
public record GitLabDuoCreatePayload(
        @Nullable String diffs,
        @Nullable String mrTitle,
        @Nullable String mrDescription,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> filesContent) {
    public GitLabDuoCreatePayload {
        if (filesContent != null) {
            filesContent = Map.copyOf(filesContent);
        }
    }
}

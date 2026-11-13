package io.github.piotr_janczukowicz.gitlab.api.search;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireBetweenIfPresent;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdDashSearchSemantic}, without paging.
 *
 * @param directoryPath the directory path
 * @param knn the knn
 * @param limit the limit
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdDashSearchSemantic/parameters")
public record GitLabProjectSearchGetSemanticFilter(
        @Nullable String directoryPath,
        @Nullable Integer knn,
        @Nullable Integer limit) {
    public GitLabProjectSearchGetSemanticFilter {
        requireMaxLengthIfPresent(directoryPath, 100, "directoryPath");
        requireBetweenIfPresent(knn, 1, 100, "knn");
        requireBetweenIfPresent(limit, 1, 100, "limit");
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectSearchGetSemanticFilter empty() {
        return GitLabProjectSearchGetSemanticFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("directory_path", directoryPath)
                .value("knn", knn)
                .value("limit", limit)
                .build();
    }
}

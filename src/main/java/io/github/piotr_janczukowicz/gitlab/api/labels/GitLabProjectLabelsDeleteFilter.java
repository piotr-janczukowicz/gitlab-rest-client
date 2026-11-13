package io.github.piotr_janczukowicz.gitlab.api.labels;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code deleteApiV4ProjectsIdLabels}, without paging.
 *
 * @param labelId the label id
 * @param name the name
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/deleteApiV4ProjectsIdLabels/parameters")
public record GitLabProjectLabelsDeleteFilter(
        @Nullable Long labelId, @Nullable String name) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectLabelsDeleteFilter empty() {
        return GitLabProjectLabelsDeleteFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("label_id", labelId)
                .text("name", name)
                .build();
    }
}

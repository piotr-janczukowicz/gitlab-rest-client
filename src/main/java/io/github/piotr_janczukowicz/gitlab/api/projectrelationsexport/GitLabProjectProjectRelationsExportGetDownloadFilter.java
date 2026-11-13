package io.github.piotr_janczukowicz.gitlab.api.projectrelationsexport;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdExportRelationsDownload}, without paging.
 *
 * @param batched the batched
 * @param batchNumber the batch number
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdExportRelationsDownload/parameters")
public record GitLabProjectProjectRelationsExportGetDownloadFilter(
        @Nullable Boolean batched, @Nullable Integer batchNumber) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectProjectRelationsExportGetDownloadFilter empty() {
        return GitLabProjectProjectRelationsExportGetDownloadFilterBuilder.builder()
                .build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("batched", batched)
                .value("batch_number", batchNumber)
                .build();
    }
}

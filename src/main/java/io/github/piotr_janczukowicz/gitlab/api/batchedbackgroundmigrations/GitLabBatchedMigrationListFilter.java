package io.github.piotr_janczukowicz.gitlab.api.batchedbackgroundmigrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4AdminBatchedBackgroundOperations}, without paging.
 *
 * @param database the database
 * @param jobClassName the job class name
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4AdminBatchedBackgroundOperations/parameters")
public record GitLabBatchedMigrationListFilter(
        @Nullable GitLabBatchedMigrationListDatabase database,
        @Nullable String jobClassName) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabBatchedMigrationListFilter empty() {
        return GitLabBatchedMigrationListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("database", database, GitLabBatchedMigrationListDatabase::wireValue)
                .text("job_class_name", jobClassName)
                .build();
    }
}

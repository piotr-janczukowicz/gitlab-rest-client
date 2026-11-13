package io.github.piotr_janczukowicz.gitlab.api.batchedbackgroundmigrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4AdminBatchedBackgroundMigrationsId}, without paging.
 *
 * @param database the database
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4AdminBatchedBackgroundMigrationsId/parameters")
public record GitLabBatchedBackgroundMigrationsGetFilter(
        @Nullable GitLabBatchedBackgroundMigrationsGetDatabase database) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabBatchedBackgroundMigrationsGetFilter empty() {
        return GitLabBatchedBackgroundMigrationsGetFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("database", database, GitLabBatchedBackgroundMigrationsGetDatabase::wireValue)
                .build();
    }
}

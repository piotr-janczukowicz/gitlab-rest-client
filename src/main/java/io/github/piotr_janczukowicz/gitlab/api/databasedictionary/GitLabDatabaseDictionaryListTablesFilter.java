package io.github.piotr_janczukowicz.gitlab.api.databasedictionary;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4DatabasesDatabaseNameDictionaryTables}, without paging.
 *
 * @param tableSize the table size
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4DatabasesDatabaseNameDictionaryTables/parameters")
public record GitLabDatabaseDictionaryListTablesFilter(
        @Nullable GitLabDatabaseDictionaryListTablesTableSize tableSize) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabDatabaseDictionaryListTablesFilter empty() {
        return GitLabDatabaseDictionaryListTablesFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("table_size", tableSize, GitLabDatabaseDictionaryListTablesTableSize::wireValue)
                .build();
    }
}

package io.github.piotr_janczukowicz.gitlab.api.databasedictionary;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of database dictionary. */
public final class GitLabDatabaseDictionaryApi extends GitLabResourceApi {
    private static final PathTemplate LIST_TABLES = PathTemplate.of("/databases/{database_name}/dictionary/tables");
    private static final PathTemplate GET_DICTIONARY_TABLE =
            PathTemplate.of("/admin/databases/{database_name}/dictionary/tables/{table_name}");
    private static final JsonType<List<GitLabDictionaryTable>> DICTIONARY_TABLE_LIST_TYPE =
            JsonTypes.listOf(GitLabDictionaryTable.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabDatabaseDictionaryApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List tables ({@code GET /databases/{database_name}/dictionary/tables}).
     *
     * @param databaseName the database name
     * @return the items
     * @throws NullPointerException if {@code databaseName} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabDictionaryTable> listTables(final GitLabDatabaseDictionaryListTablesDatabaseName databaseName)
            throws IOException {
        return listTables(databaseName, GitLabDatabaseDictionaryListTablesFilter.empty());
    }

    /**
     * List tables ({@code GET /databases/{database_name}/dictionary/tables}).
     *
     * @param databaseName the database name
     * @param filter the optional query parameters
     * @return the items
     * @throws NullPointerException if {@code databaseName} or {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabDictionaryTable> listTables(
            final GitLabDatabaseDictionaryListTablesDatabaseName databaseName,
            final GitLabDatabaseDictionaryListTablesFilter filter)
            throws IOException {
        requireNonNull(databaseName, "databaseName");
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetch(
                get(LIST_TABLES, databaseName.wireValue()).withQuery(queryParameters), DICTIONARY_TABLE_LIST_TYPE);
    }

    /**
     * Get dictionary table ({@code GET /admin/databases/{database_name}/dictionary/tables/{table_name}}).
     *
     * @param databaseName the database name
     * @param tableName the table name
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code tableName} is blank
     * @throws NullPointerException if {@code databaseName} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabDictionaryTable> getDictionaryTable(
            final GitLabDatabaseDictionaryGetDictionaryTableDatabaseName databaseName, final String tableName)
            throws IOException {
        requireNonNull(databaseName, "databaseName");
        requireNotBlank(tableName, "tableName");
        return caller.fetchOrEmpty(
                get(GET_DICTIONARY_TABLE, databaseName.wireValue(), tableName), GitLabDictionaryTable.class);
    }
}

package io.github.piotr_janczukowicz.gitlab.api.databasedictionary;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabDatabaseDictionaryApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void listTables_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/databases/main/dictionary/tables",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabDictionaryTable.class, "dictionary-table.json") + "]"));

        final List<GitLabDictionaryTable> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabDatabaseDictionaryApi(GitLabCaller.of(client))
                    .listTables(GitLabDatabaseDictionaryListTablesDatabaseName.MAIN);
        }

        assertThat(result).containsExactly(DatabasedictionaryCatalogFixtures.dictionaryTable());
        HTTP.verifyRequested(GET, "/api/v4/databases/main/dictionary/tables");
    }

    @Test
    void getDictionaryTable_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/admin/databases/main/dictionary/tables/table_name",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabDictionaryTable.class, "dictionary-table.json")));

        final Optional<GitLabDictionaryTable> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabDatabaseDictionaryApi(GitLabCaller.of(client))
                    .getDictionaryTable(GitLabDatabaseDictionaryGetDictionaryTableDatabaseName.MAIN, "table_name");
        }

        assertThat(result).contains(DatabasedictionaryCatalogFixtures.dictionaryTable());
        HTTP.verifyRequested(GET, "/api/v4/admin/databases/main/dictionary/tables/table_name");
    }

    @Test
    void getDictionaryTable_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/admin/databases/main/dictionary/tables/table_name", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabDatabaseDictionaryApi(GitLabCaller.of(client))
                    .getDictionaryTable(GitLabDatabaseDictionaryGetDictionaryTableDatabaseName.MAIN, "table_name")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/admin/databases/main/dictionary/tables/table_name");
    }
}

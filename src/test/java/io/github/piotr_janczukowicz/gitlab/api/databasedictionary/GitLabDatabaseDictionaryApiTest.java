package io.github.piotr_janczukowicz.gitlab.api.databasedictionary;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDatabaseDictionaryApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabDatabaseDictionaryApi api() {
        return new GitLabDatabaseDictionaryApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabDatabaseDictionaryApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void listTables_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabDictionaryTable.class, "dictionary-table.json") + "]"));

        final List<GitLabDictionaryTable> result =
                api().listTables(GitLabDatabaseDictionaryListTablesDatabaseName.MAIN);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(DatabasedictionaryCatalogFixtures.dictionaryTable());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/databases/main/dictionary/tables");
        });
    }

    @Test
    void getDictionaryTable_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabDictionaryTable.class, "dictionary-table.json")));

        final Optional<GitLabDictionaryTable> result =
                api().getDictionaryTable(GitLabDatabaseDictionaryGetDictionaryTableDatabaseName.MAIN, "table_name");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(DatabasedictionaryCatalogFixtures.dictionaryTable());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/admin/databases/main/dictionary/tables/table_name");
        });
    }

    @Test
    void getDictionaryTable_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabDictionaryTable> result =
                api().getDictionaryTable(GitLabDatabaseDictionaryGetDictionaryTableDatabaseName.MAIN, "table_name");

        assertThat(result).isEmpty();
    }
}

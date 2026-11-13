package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBulkImport;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOfflineTransfersApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabOfflineTransfersApi api() {
        return new GitLabOfflineTransfersApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabOfflineTransfersApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabImportOfflineExport.class, "import-offline-export.json")
                                + "]"));

        final GitLabPage<GitLabImportOfflineExport> page = api().list();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(OfflinetransfersCatalogFixtures.importOfflineExport());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/offline_exports");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabImportOfflineExport.class, "import-offline-export.json")
                                + "]"));

        final GitLabPage<GitLabImportOfflineExport> page = api().list(GitLabOfflineTransfersListFilterBuilder.builder()
                .sort(GitLabOfflineTransfersListSort.ASC)
                .status(GitLabOfflineTransfersListStatus.CREATED)
                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(OfflinetransfersCatalogFixtures.importOfflineExport());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/offline_exports");
            softly.assertThat(request.uri()).hasParameter("sort", "asc");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabImportOfflineExport.class, "import-offline-export.json")
                                + "]"));

        final GitLabPage<GitLabImportOfflineExport> page = api().list(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(OfflinetransfersCatalogFixtures.importOfflineExport());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/offline_exports");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabImportOfflineExport.class, "import-offline-export.json")
                                + "]"));

        final GitLabPage<GitLabImportOfflineExport> page = api().list(
                        GitLabOfflineTransfersListFilterBuilder.builder()
                                .sort(GitLabOfflineTransfersListSort.ASC)
                                .status(GitLabOfflineTransfersListStatus.CREATED)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(OfflinetransfersCatalogFixtures.importOfflineExport());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/offline_exports");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("sort", "asc");
        });
    }

    @Test
    void createExports_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createExports(OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/offline_exports");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"bucket\":");
        });
    }

    @Test
    void createExports_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().createExports(OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void call_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().call(1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/offline_exports/1");
    }

    @Test
    void call_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().call(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createImports_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabBulkImport.class, "bulk-import.json")));

        final GitLabBulkImport result =
                api().createImports(OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.bulkImport());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/offline_imports");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"bucket\":");
        });
    }

    @Test
    void createImports_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().createImports(OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}

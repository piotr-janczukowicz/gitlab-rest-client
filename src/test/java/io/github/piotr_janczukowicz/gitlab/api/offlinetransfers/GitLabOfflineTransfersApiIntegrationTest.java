package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBulkImport;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabOfflineTransfersApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/offline_exports",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabImportOfflineExport.class, "import-offline-export.json")
                                + "]")
                        .header("Link", "<" + base + "/api/v4/offline_exports?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(GitLabImportOfflineExport.class, "import-offline-export.json") + "]"));

        final List<GitLabImportOfflineExport> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabOfflineTransfersApi(GitLabCaller.of(client))
                    .list()
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        OfflinetransfersCatalogFixtures.importOfflineExport(),
                        OfflinetransfersCatalogFixtures.importOfflineExport());
        HTTP.verifyRequested(GET, "/api/v4/offline_exports", 2);
    }

    @Test
    void createExports_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/offline_exports", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabOfflineTransfersApi(GitLabCaller.of(client))
                    .createExports(OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/offline_exports");
    }

    @Test
    void createExports_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/offline_exports", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabOfflineTransfersApi api = new GitLabOfflineTransfersApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.createExports(OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/offline_exports");
    }

    @Test
    void call_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/offline_exports/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabOfflineTransfersApi(GitLabCaller.of(client)).call(1L);
        }

        HTTP.verifyRequested(GET, "/api/v4/offline_exports/1");
    }

    @Test
    void call_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/offline_exports/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabOfflineTransfersApi api = new GitLabOfflineTransfersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.call(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/offline_exports/1");
    }

    @Test
    void createImports_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/offline_imports",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabBulkImport.class, "bulk-import.json")));

        final GitLabBulkImport result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabOfflineTransfersApi(GitLabCaller.of(client))
                    .createImports(OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.bulkImport());
        HTTP.verifyRequested(POST, "/api/v4/offline_imports");
    }

    @Test
    void createImports_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/offline_imports", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabOfflineTransfersApi api = new GitLabOfflineTransfersApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.createImports(OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/offline_imports");
    }
}

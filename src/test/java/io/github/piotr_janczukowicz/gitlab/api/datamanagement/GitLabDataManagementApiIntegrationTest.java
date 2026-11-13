package io.github.piotr_janczukowicz.gitlab.api.datamanagement;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabDataManagementApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/admin/data_management/model_name/record_identifier",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabAdminModel.class, "admin-model-1.json")));

        final Optional<GitLabAdminModel> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabDataManagementApi(GitLabCaller.of(client)).get("model_name", "record_identifier");
        }

        assertThat(result).contains(DatamanagementCatalogFixtures.adminModel());
        HTTP.verifyRequested(GET, "/api/v4/admin/data_management/model_name/record_identifier");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/admin/data_management/model_name/record_identifier", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabDataManagementApi(GitLabCaller.of(client))
                    .get("model_name", "record_identifier")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/admin/data_management/model_name/record_identifier");
    }

    @Test
    void checksumByRecordIdentifier_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/admin/data_management/model_name/1/checksum",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabAdminModel.class, "admin-model-1.json")));

        final GitLabAdminModel result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabDataManagementApi(GitLabCaller.of(client)).checksumByRecordIdentifier("model_name", 1);
        }

        assertThat(result).isEqualTo(DatamanagementCatalogFixtures.adminModel());
        HTTP.verifyRequested(PUT, "/api/v4/admin/data_management/model_name/1/checksum");
    }

    @Test
    void checksumByRecordIdentifier_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/admin/data_management/model_name/1/checksum", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDataManagementApi api = new GitLabDataManagementApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.checksumByRecordIdentifier("model_name", 1));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/admin/data_management/model_name/1/checksum");
    }

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/admin/data_management/model_name",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabAdminModel.class, "admin-model-1.json") + "]")
                        .header("Link", "<" + base + "/api/v4/admin/data_management/model_name?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabAdminModel.class, "admin-model-1.json") + "]"));

        final List<GitLabAdminModel> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabDataManagementApi(GitLabCaller.of(client))
                    .list("model_name")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        DatamanagementCatalogFixtures.adminModel(), DatamanagementCatalogFixtures.adminModel());
        HTTP.verifyRequested(GET, "/api/v4/admin/data_management/model_name", 2);
    }

    @Test
    void checksum_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/admin/data_management/model_name/checksum",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabAdminModel.class, "admin-model-1.json")));

        final GitLabAdminModel result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabDataManagementApi(GitLabCaller.of(client))
                    .checksum("model_name", DatamanagementCatalogFixtures.dataManagementChecksumPayload());
        }

        assertThat(result).isEqualTo(DatamanagementCatalogFixtures.adminModel());
        HTTP.verifyRequested(PUT, "/api/v4/admin/data_management/model_name/checksum");
    }

    @Test
    void checksum_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/admin/data_management/model_name/checksum", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDataManagementApi api = new GitLabDataManagementApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.checksum("model_name", DatamanagementCatalogFixtures.dataManagementChecksumPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/admin/data_management/model_name/checksum");
    }
}

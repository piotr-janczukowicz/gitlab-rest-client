package io.github.piotr_janczukowicz.gitlab.api.datamanagement;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
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
class GitLabDataManagementApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabDataManagementApi api() {
        return new GitLabDataManagementApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabDataManagementApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void get_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabDataManagementApi lowTier =
                new GitLabDataManagementApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.get("model_name", "record_identifier"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void get_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabDataManagementApi lowTier =
                new GitLabDataManagementApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.get("model_name", "record_identifier"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabAdminModel.class, "admin-model-1.json")));

        final Optional<GitLabAdminModel> result = api().get("model_name", "record_identifier");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(DatamanagementCatalogFixtures.adminModel());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/admin/data_management/model_name/record_identifier");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabAdminModel> result = api().get("model_name", "record_identifier");

        assertThat(result).isEmpty();
    }

    @Test
    void checksumByRecordIdentifier_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabDataManagementApi lowTier =
                new GitLabDataManagementApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.checksumByRecordIdentifier("model_name", 1));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void checksumByRecordIdentifier_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabDataManagementApi lowTier =
                new GitLabDataManagementApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.checksumByRecordIdentifier("model_name", 1));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void checksumByRecordIdentifier_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabAdminModel.class, "admin-model-1.json")));

        final GitLabAdminModel result = api().checksumByRecordIdentifier("model_name", 1);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(DatamanagementCatalogFixtures.adminModel());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/admin/data_management/model_name/1/checksum");
        });
    }

    @Test
    void checksumByRecordIdentifier_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().checksumByRecordIdentifier("model_name", 1));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void list_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabDataManagementApi lowTier =
                new GitLabDataManagementApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list("model_name"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void list_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabDataManagementApi lowTier =
                new GitLabDataManagementApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list("model_name"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAdminModel.class, "admin-model-1.json") + "]"));

        final GitLabPage<GitLabAdminModel> page = api().list("model_name");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(DatamanagementCatalogFixtures.adminModel());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/admin/data_management/model_name");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAdminModel.class, "admin-model-1.json") + "]"));

        final GitLabPage<GitLabAdminModel> page = api().list(
                        "model_name",
                        GitLabDataManagementListFilterBuilder.builder()
                                .identifiers(List.of("identifiers"))
                                .checksumState(GitLabDataManagementListChecksumState.PENDING)
                                .cursor("cursor")
                                .sort(GitLabDataManagementListSort.ASC)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(DatamanagementCatalogFixtures.adminModel());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/admin/data_management/model_name");
            softly.assertThat(request.uri()).hasParameter("identifiers", "identifiers");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAdminModel.class, "admin-model-1.json") + "]"));

        final GitLabPage<GitLabAdminModel> page = api().list("model_name", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(DatamanagementCatalogFixtures.adminModel());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/admin/data_management/model_name");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAdminModel.class, "admin-model-1.json") + "]"));

        final GitLabPage<GitLabAdminModel> page = api().list(
                        "model_name",
                        GitLabDataManagementListFilterBuilder.builder()
                                .identifiers(List.of("identifiers"))
                                .checksumState(GitLabDataManagementListChecksumState.PENDING)
                                .cursor("cursor")
                                .sort(GitLabDataManagementListSort.ASC)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(DatamanagementCatalogFixtures.adminModel());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/admin/data_management/model_name");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("identifiers", "identifiers");
        });
    }

    @Test
    void checksum_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabDataManagementApi lowTier =
                new GitLabDataManagementApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(
                () -> lowTier.checksum("model_name", DatamanagementCatalogFixtures.dataManagementChecksumPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void checksum_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabDataManagementApi lowTier =
                new GitLabDataManagementApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(
                () -> lowTier.checksum("model_name", DatamanagementCatalogFixtures.dataManagementChecksumPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void checksum_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabAdminModel.class, "admin-model-1.json")));

        final GitLabAdminModel result =
                api().checksum("model_name", DatamanagementCatalogFixtures.dataManagementChecksumPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(DatamanagementCatalogFixtures.adminModel());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/admin/data_management/model_name/checksum");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"identifiers\":");
        });
    }

    @Test
    void checksum_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().checksum("model_name", DatamanagementCatalogFixtures.dataManagementChecksumPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}

package io.github.piotr_janczukowicz.gitlab.api.groupimportandexport;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBulkImportsExportStatus;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.HttpStreamResponse;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.io.ByteArrayOutputStream;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

@UnitTest
class GitLabGroupGroupImportAndExportApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabGroupGroupImportAndExportApi api() {
        return new GitLabGroupGroupImportAndExportApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabGroupGroupImportAndExportApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void authorize_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().authorize();

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/groups/import/authorize");
    }

    @Test
    void authorize_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().authorize());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void create_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().create(MultipartFormData.builder().text("field", "value").build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/groups/import");
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().create(MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getDownload_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        final long written = api().getDownload("group/sub/project", out);

        assertSoftly(softly -> {
            softly.assertThat(written).isEqualTo(3L);
            softly.assertThat(out).hasToString("abc");
        });
    }

    @Test
    void getDownload_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final Path target = directory.resolve("download.bin");

        final Path written = api().getDownload("group/sub/project", target);

        assertThat(written).hasContent("abc");
    }

    @Test
    void createGroup_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createGroup("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/export");
    }

    @Test
    void createGroup_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createGroup("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createExportRelation_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createExportRelation(
                        "group/sub/project",
                        GroupimportandexportCatalogFixtures.groupGroupImportAndExportCreateExportRelationPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/export_relations");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"batched\":");
        });
    }

    @Test
    void createExportRelation_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createExportRelation(
                        "group/sub/project",
                        GroupimportandexportCatalogFixtures.groupGroupImportAndExportCreateExportRelationPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getExportRelationsDownload_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        final long written = api().getExportRelationsDownload("group/sub/project", "relation", out);

        assertSoftly(softly -> {
            softly.assertThat(written).isEqualTo(3L);
            softly.assertThat(out).hasToString("abc");
        });
    }

    @Test
    void getExportRelationsDownload_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory)
            throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final Path target = directory.resolve("download.bin");

        final Path written = api().getExportRelationsDownload("group/sub/project", "relation", target);

        assertThat(written).hasContent("abc");
    }

    @Test
    void listExportRelationsStatus_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabBulkImportsExportStatus.class, "bulk-imports-export-status.json")
                                + "]"));

        final List<GitLabBulkImportsExportStatus> result = api().listExportRelationsStatus("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(CommonCatalogFixtures.bulkImportsExportStatus());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/export_relations/status");
        });
    }
}

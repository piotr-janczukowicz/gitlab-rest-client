package io.github.piotr_janczukowicz.gitlab.api.dependencymanagement;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.HttpStreamResponse;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

@UnitTest
class GitLabDependencyManagementApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabDependencyManagementApi api() {
        return new GitLabDependencyManagementApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabDependencyManagementApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void call_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabDependencyManagementApi lowTier =
                new GitLabDependencyManagementApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.call("export_id"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void call_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabDependencyManagementApi lowTier =
                new GitLabDependencyManagementApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.call("export_id"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void call_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().call("export_id");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/dependency_list_exports/export_id");
    }

    @Test
    void call_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().call("export_id"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void get_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabDependencyManagementApi lowTier =
                new GitLabDependencyManagementApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.get("export_id", OutputStream.nullOutputStream()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void get_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabDependencyManagementApi lowTier =
                new GitLabDependencyManagementApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.get("export_id", OutputStream.nullOutputStream()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void get_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        final long written = api().get("export_id", out);

        assertSoftly(softly -> {
            softly.assertThat(written).isEqualTo(3L);
            softly.assertThat(out).hasToString("abc");
        });
    }

    @Test
    void get_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final Path target = directory.resolve("download.bin");

        final Path written = api().get("export_id", target);

        assertThat(written).hasContent("abc");
    }

    @Test
    void callVulnerabilities_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabDependencyManagementApi lowTier =
                new GitLabDependencyManagementApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.callVulnerabilities("id"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void callVulnerabilities_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabDependencyManagementApi lowTier =
                new GitLabDependencyManagementApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.callVulnerabilities("id"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void callVulnerabilities_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callVulnerabilities("id");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/occurrences/vulnerabilities");
            softly.assertThat(request.uri()).hasParameter("id", "id");
        });
    }

    @Test
    void callVulnerabilities_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callVulnerabilities("id"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}

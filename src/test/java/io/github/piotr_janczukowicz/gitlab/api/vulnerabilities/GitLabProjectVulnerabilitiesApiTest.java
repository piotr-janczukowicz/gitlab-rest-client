package io.github.piotr_janczukowicz.gitlab.api.vulnerabilities;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabVulnerability;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.HttpStreamResponse;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

@UnitTest
class GitLabProjectVulnerabilitiesApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectVulnerabilitiesApi api() {
        return new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectVulnerabilitiesApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void createSecurityProjectsVulnerabilityExport_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createSecurityProjectsVulnerabilityExport(
                "group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilityExportPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createSecurityProjectsVulnerabilityExport_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createSecurityProjectsVulnerabilityExport(
                "group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilityExportPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createSecurityProjectsVulnerabilityExport_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabVulnerabilityExport.class, "vulnerability-export.json")));

        final GitLabVulnerabilityExport result = api().createSecurityProjectsVulnerabilityExport(
                        "group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilityExportPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(VulnerabilitiesCatalogFixtures.vulnerabilityExport());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/security/projects/group%2Fsub%2Fproject/vulnerability_exports");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"export_format\":");
        });
    }

    @Test
    void createSecurityProjectsVulnerabilityExport_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createSecurityProjectsVulnerabilityExport(
                        "group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilityExportPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createSecurityGroupsVulnerabilityExport_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createSecurityGroupsVulnerabilityExport(
                "group/sub/project", VulnerabilitiesCatalogFixtures.groupVulnerabilityExportPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createSecurityGroupsVulnerabilityExport_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createSecurityGroupsVulnerabilityExport(
                "group/sub/project", VulnerabilitiesCatalogFixtures.groupVulnerabilityExportPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createSecurityGroupsVulnerabilityExport_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabVulnerabilityExport.class, "vulnerability-export.json")));

        final GitLabVulnerabilityExport result = api().createSecurityGroupsVulnerabilityExport(
                        "group/sub/project", VulnerabilitiesCatalogFixtures.groupVulnerabilityExportPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(VulnerabilitiesCatalogFixtures.vulnerabilityExport());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/security/groups/group%2Fsub%2Fproject/vulnerability_exports");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"export_format\":");
        });
    }

    @Test
    void createSecurityGroupsVulnerabilityExport_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createSecurityGroupsVulnerabilityExport(
                        "group/sub/project", VulnerabilitiesCatalogFixtures.groupVulnerabilityExportPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createSecurityVulnerabilityExport_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() ->
                lowTier.createSecurityVulnerabilityExport(VulnerabilitiesCatalogFixtures.vulnerabilityExportPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createSecurityVulnerabilityExport_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() ->
                lowTier.createSecurityVulnerabilityExport(VulnerabilitiesCatalogFixtures.vulnerabilityExportPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createSecurityVulnerabilityExport_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabVulnerabilityExport.class, "vulnerability-export.json")));

        final GitLabVulnerabilityExport result =
                api().createSecurityVulnerabilityExport(VulnerabilitiesCatalogFixtures.vulnerabilityExportPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(VulnerabilitiesCatalogFixtures.vulnerabilityExport());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/security/vulnerability_exports");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"export_format\":");
        });
    }

    @Test
    void createSecurityVulnerabilityExport_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().createSecurityVulnerabilityExport(VulnerabilitiesCatalogFixtures.vulnerabilityExportPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getSecurityVulnerabilityExport_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getSecurityVulnerabilityExport(1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getSecurityVulnerabilityExport_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getSecurityVulnerabilityExport(1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getSecurityVulnerabilityExport_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabVulnerabilityExport.class, "vulnerability-export.json")));

        final Optional<GitLabVulnerabilityExport> result = api().getSecurityVulnerabilityExport(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(VulnerabilitiesCatalogFixtures.vulnerabilityExport());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/security/vulnerability_exports/1");
        });
    }

    @Test
    void getSecurityVulnerabilityExport_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabVulnerabilityExport> result = api().getSecurityVulnerabilityExport(1L);

        assertThat(result).isEmpty();
    }

    @Test
    void getSecurityVulnerabilityExportsDownload_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(
                () -> lowTier.getSecurityVulnerabilityExportsDownload(1L, OutputStream.nullOutputStream()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getSecurityVulnerabilityExportsDownload_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(
                () -> lowTier.getSecurityVulnerabilityExportsDownload(1L, OutputStream.nullOutputStream()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getSecurityVulnerabilityExportsDownload_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        final long written = api().getSecurityVulnerabilityExportsDownload(1L, out);

        assertSoftly(softly -> {
            softly.assertThat(written).isEqualTo(3L);
            softly.assertThat(out).hasToString("abc");
        });
    }

    @Test
    void getSecurityVulnerabilityExportsDownload_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory)
            throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final Path target = directory.resolve("download.bin");

        final Path written = api().getSecurityVulnerabilityExportsDownload(1L, target);

        assertThat(written).hasContent("abc");
    }

    @Test
    void createSecurityProjectsVulnerabilityArchiveExport_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createSecurityProjectsVulnerabilityArchiveExport(
                "group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilityArchiveExportPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createSecurityProjectsVulnerabilityArchiveExport_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createSecurityProjectsVulnerabilityArchiveExport(
                "group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilityArchiveExportPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createSecurityProjectsVulnerabilityArchiveExport_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabVulnerabilityArchiveExport.class, "vulnerability-archive-export.json")));

        final GitLabVulnerabilityArchiveExport result = api().createSecurityProjectsVulnerabilityArchiveExport(
                        "group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilityArchiveExportPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(VulnerabilitiesCatalogFixtures.vulnerabilityArchiveExport());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/security/projects/group%2Fsub%2Fproject/vulnerability_archive_exports");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"start_date\":");
        });
    }

    @Test
    void createSecurityProjectsVulnerabilityArchiveExport_shouldThrowNotFound_whenResponseIsNotFound()
            throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createSecurityProjectsVulnerabilityArchiveExport(
                        "group/sub/project",
                        VulnerabilitiesCatalogFixtures.projectVulnerabilityArchiveExportPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getSecurityVulnerabilityArchiveExport_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getSecurityVulnerabilityArchiveExport(1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getSecurityVulnerabilityArchiveExport_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getSecurityVulnerabilityArchiveExport(1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getSecurityVulnerabilityArchiveExport_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabVulnerabilityArchiveExport.class, "vulnerability-archive-export.json")));

        final Optional<GitLabVulnerabilityArchiveExport> result = api().getSecurityVulnerabilityArchiveExport(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(VulnerabilitiesCatalogFixtures.vulnerabilityArchiveExport());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/security/vulnerability_archive_exports/1");
        });
    }

    @Test
    void getSecurityVulnerabilityArchiveExport_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabVulnerabilityArchiveExport> result = api().getSecurityVulnerabilityArchiveExport(1L);

        assertThat(result).isEmpty();
    }

    @Test
    void getSecurityVulnerabilityArchiveExportsDownload_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(
                () -> lowTier.getSecurityVulnerabilityArchiveExportsDownload(1L, OutputStream.nullOutputStream()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getSecurityVulnerabilityArchiveExportsDownload_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(
                () -> lowTier.getSecurityVulnerabilityArchiveExportsDownload(1L, OutputStream.nullOutputStream()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getSecurityVulnerabilityArchiveExportsDownload_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        final long written = api().getSecurityVulnerabilityArchiveExportsDownload(1L, out);

        assertSoftly(softly -> {
            softly.assertThat(written).isEqualTo(3L);
            softly.assertThat(out).hasToString("abc");
        });
    }

    @Test
    void getSecurityVulnerabilityArchiveExportsDownload_shouldWriteTheFile_whenTheTargetIsAPath(
            @TempDir final Path directory) throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final Path target = directory.resolve("download.bin");

        final Path written = api().getSecurityVulnerabilityArchiveExportsDownload(1L, target);

        assertThat(written).hasContent("abc");
    }

    @Test
    void listIssueLinks_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listIssueLinks(1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listIssueLinks_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listIssueLinks(1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listIssueLinks_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabVulnerabilityRelatedIssue.class, "vulnerability-related-issue.json")
                                + "]"));

        final List<GitLabVulnerabilityRelatedIssue> result = api().listIssueLinks(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(VulnerabilitiesCatalogFixtures.vulnerabilityRelatedIssue());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/vulnerabilities/1/issue_links");
        });
    }

    @Test
    void createIssueLink_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createIssueLink(
                1L, VulnerabilitiesCatalogFixtures.projectVulnerabilitiesCreateIssueLinkPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createIssueLink_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createIssueLink(
                1L, VulnerabilitiesCatalogFixtures.projectVulnerabilitiesCreateIssueLinkPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createIssueLink_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabVulnerabilityIssueLink.class, "vulnerability-issue-link.json")));

        final GitLabVulnerabilityIssueLink result = api().createIssueLink(
                        1L, VulnerabilitiesCatalogFixtures.projectVulnerabilitiesCreateIssueLinkPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(VulnerabilitiesCatalogFixtures.vulnerabilityIssueLink());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/vulnerabilities/1/issue_links");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"target_issue_iid\":");
        });
    }

    @Test
    void createIssueLink_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createIssueLink(
                        1L, VulnerabilitiesCatalogFixtures.projectVulnerabilitiesCreateIssueLinkPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteIssueLink_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteIssueLink(1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void deleteIssueLink_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteIssueLink(1L, 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void deleteIssueLink_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabVulnerabilityIssueLink.class, "vulnerability-issue-link.json")));

        final Optional<GitLabVulnerabilityIssueLink> result = api().deleteIssueLink(1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(VulnerabilitiesCatalogFixtures.vulnerabilityIssueLink());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("DELETE /api/v4/vulnerabilities/1/issue_links/1");
        });
    }

    @Test
    void deleteIssueLink_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteIssueLink(1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteIssueLink_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        final Optional<GitLabVulnerabilityIssueLink> result = api().deleteIssueLink(1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void aiDetectionFlag_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.aiDetectionFlag(
                "vulnerability_id", VulnerabilitiesCatalogFixtures.projectVulnerabilitiesAiDetectionFlagPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void aiDetectionFlag_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.aiDetectionFlag(
                "vulnerability_id", VulnerabilitiesCatalogFixtures.projectVulnerabilitiesAiDetectionFlagPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void aiDetectionFlag_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().aiDetectionFlag(
                        "vulnerability_id",
                        VulnerabilitiesCatalogFixtures.projectVulnerabilitiesAiDetectionFlagPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/vulnerabilities/vulnerability_id/flags/ai_detection");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"confidence_score\":");
        });
    }

    @Test
    void aiDetectionFlag_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().aiDetectionFlag(
                        "vulnerability_id",
                        VulnerabilitiesCatalogFixtures.projectVulnerabilitiesAiDetectionFlagPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void get_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.get("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void get_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.get("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabVulnerability.class, "vulnerability.json")));

        final Optional<GitLabVulnerability> result = api().get("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.vulnerability());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/vulnerabilities/group%2Fsub%2Fproject");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabVulnerability> result = api().get("group/sub/project");

        assertThat(result).isEmpty();
    }

    @Test
    void resolve_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.resolve(
                "group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilitiesResolvePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void resolve_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.resolve(
                "group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilitiesResolvePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void resolve_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabVulnerability.class, "vulnerability.json")));

        final GitLabVulnerability result = api().resolve(
                        "group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilitiesResolvePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.vulnerability());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/vulnerabilities/group%2Fsub%2Fproject/resolve");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"comment\":");
        });
    }

    @Test
    void resolve_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().resolve(
                        "group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilitiesResolvePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void dismiss_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.dismiss("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void dismiss_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.dismiss("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void dismiss_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabVulnerability.class, "vulnerability.json")));

        final GitLabVulnerability result = api().dismiss("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.vulnerability());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/vulnerabilities/group%2Fsub%2Fproject/dismiss");
        });
    }

    @Test
    void dismiss_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().dismiss("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void confirm_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.confirm(
                "group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilitiesConfirmPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void confirm_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.confirm(
                "group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilitiesConfirmPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void confirm_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabVulnerability.class, "vulnerability.json")));

        final GitLabVulnerability result = api().confirm(
                        "group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilitiesConfirmPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.vulnerability());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/vulnerabilities/group%2Fsub%2Fproject/confirm");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"comment\":");
        });
    }

    @Test
    void confirm_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().confirm(
                        "group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilitiesConfirmPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void revert_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.revert(
                "group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilitiesRevertPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void revert_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectVulnerabilitiesApi lowTier =
                new GitLabProjectVulnerabilitiesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.revert(
                "group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilitiesRevertPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void revert_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabVulnerability.class, "vulnerability.json")));

        final GitLabVulnerability result =
                api().revert("group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilitiesRevertPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.vulnerability());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/vulnerabilities/group%2Fsub%2Fproject/revert");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"comment\":");
        });
    }

    @Test
    void revert_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().revert(
                        "group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilitiesRevertPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}

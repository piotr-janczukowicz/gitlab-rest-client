package io.github.piotr_janczukowicz.gitlab.api.vulnerabilities;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabVulnerability;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.io.ByteArrayOutputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.io.TempDir;

@IntegrationTest
class GitLabProjectVulnerabilitiesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void createSecurityProjectsVulnerabilityExport_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/security/projects/group%2Fsub%2Fproject/vulnerability_exports",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabVulnerabilityExport.class, "vulnerability-export.json")));

        final GitLabVulnerabilityExport result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client))
                    .createSecurityProjectsVulnerabilityExport(
                            "group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilityExportPayload());
        }

        assertThat(result).isEqualTo(VulnerabilitiesCatalogFixtures.vulnerabilityExport());
        HTTP.verifyRequested(POST, "/api/v4/security/projects/group%2Fsub%2Fproject/vulnerability_exports");
    }

    @Test
    void createSecurityProjectsVulnerabilityExport_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/security/projects/group%2Fsub%2Fproject/vulnerability_exports",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectVulnerabilitiesApi api = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createSecurityProjectsVulnerabilityExport(
                    "group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilityExportPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/security/projects/group%2Fsub%2Fproject/vulnerability_exports");
    }

    @Test
    void createSecurityGroupsVulnerabilityExport_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/security/groups/group%2Fsub%2Fproject/vulnerability_exports",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabVulnerabilityExport.class, "vulnerability-export.json")));

        final GitLabVulnerabilityExport result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client))
                    .createSecurityGroupsVulnerabilityExport(
                            "group/sub/project", VulnerabilitiesCatalogFixtures.groupVulnerabilityExportPayload());
        }

        assertThat(result).isEqualTo(VulnerabilitiesCatalogFixtures.vulnerabilityExport());
        HTTP.verifyRequested(POST, "/api/v4/security/groups/group%2Fsub%2Fproject/vulnerability_exports");
    }

    @Test
    void createSecurityGroupsVulnerabilityExport_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/security/groups/group%2Fsub%2Fproject/vulnerability_exports",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectVulnerabilitiesApi api = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createSecurityGroupsVulnerabilityExport(
                    "group/sub/project", VulnerabilitiesCatalogFixtures.groupVulnerabilityExportPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/security/groups/group%2Fsub%2Fproject/vulnerability_exports");
    }

    @Test
    void createSecurityVulnerabilityExport_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/security/vulnerability_exports",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabVulnerabilityExport.class, "vulnerability-export.json")));

        final GitLabVulnerabilityExport result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client))
                    .createSecurityVulnerabilityExport(VulnerabilitiesCatalogFixtures.vulnerabilityExportPayload());
        }

        assertThat(result).isEqualTo(VulnerabilitiesCatalogFixtures.vulnerabilityExport());
        HTTP.verifyRequested(POST, "/api/v4/security/vulnerability_exports");
    }

    @Test
    void createSecurityVulnerabilityExport_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/security/vulnerability_exports", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectVulnerabilitiesApi api = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.createSecurityVulnerabilityExport(VulnerabilitiesCatalogFixtures.vulnerabilityExportPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/security/vulnerability_exports");
    }

    @Test
    void getSecurityVulnerabilityExport_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/security/vulnerability_exports/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabVulnerabilityExport.class, "vulnerability-export.json")));

        final Optional<GitLabVulnerabilityExport> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client)).getSecurityVulnerabilityExport(1L);
        }

        assertThat(result).contains(VulnerabilitiesCatalogFixtures.vulnerabilityExport());
        HTTP.verifyRequested(GET, "/api/v4/security/vulnerability_exports/1");
    }

    @Test
    void getSecurityVulnerabilityExport_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/security/vulnerability_exports/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client))
                    .getSecurityVulnerabilityExport(1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/security/vulnerability_exports/1");
    }

    @Test
    void getSecurityVulnerabilityExportsDownload_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/security/vulnerability_exports/1/download",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client))
                    .getSecurityVulnerabilityExportsDownload(1L, out);
        }

        assertThat(out.toByteArray()).containsExactly(1, 2, 3);
    }

    @Test
    void getSecurityVulnerabilityExportsDownload_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory)
            throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/security/vulnerability_exports/1/download",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));
        final Path target = directory.resolve("download.bin");

        final Path written;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            written = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client))
                    .getSecurityVulnerabilityExportsDownload(1L, target);
        }

        assertThat(written).hasBinaryContent(new byte[] {1, 2, 3});
    }

    @Test
    void createSecurityProjectsVulnerabilityArchiveExport_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/security/projects/group%2Fsub%2Fproject/vulnerability_archive_exports",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabVulnerabilityArchiveExport.class, "vulnerability-archive-export.json")));

        final GitLabVulnerabilityArchiveExport result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client))
                    .createSecurityProjectsVulnerabilityArchiveExport(
                            "group/sub/project",
                            VulnerabilitiesCatalogFixtures.projectVulnerabilityArchiveExportPayload());
        }

        assertThat(result).isEqualTo(VulnerabilitiesCatalogFixtures.vulnerabilityArchiveExport());
        HTTP.verifyRequested(POST, "/api/v4/security/projects/group%2Fsub%2Fproject/vulnerability_archive_exports");
    }

    @Test
    void createSecurityProjectsVulnerabilityArchiveExport_shouldAnswerNotFound_whenResponseIsNotFound()
            throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/security/projects/group%2Fsub%2Fproject/vulnerability_archive_exports",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectVulnerabilitiesApi api = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createSecurityProjectsVulnerabilityArchiveExport(
                    "group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilityArchiveExportPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/security/projects/group%2Fsub%2Fproject/vulnerability_archive_exports");
    }

    @Test
    void getSecurityVulnerabilityArchiveExport_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/security/vulnerability_archive_exports/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabVulnerabilityArchiveExport.class, "vulnerability-archive-export.json")));

        final Optional<GitLabVulnerabilityArchiveExport> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client))
                    .getSecurityVulnerabilityArchiveExport(1L);
        }

        assertThat(result).contains(VulnerabilitiesCatalogFixtures.vulnerabilityArchiveExport());
        HTTP.verifyRequested(GET, "/api/v4/security/vulnerability_archive_exports/1");
    }

    @Test
    void getSecurityVulnerabilityArchiveExport_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/security/vulnerability_archive_exports/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client))
                    .getSecurityVulnerabilityArchiveExport(1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/security/vulnerability_archive_exports/1");
    }

    @Test
    void getSecurityVulnerabilityArchiveExportsDownload_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/security/vulnerability_archive_exports/1/download",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client))
                    .getSecurityVulnerabilityArchiveExportsDownload(1L, out);
        }

        assertThat(out.toByteArray()).containsExactly(1, 2, 3);
    }

    @Test
    void getSecurityVulnerabilityArchiveExportsDownload_shouldWriteTheFile_whenTheTargetIsAPath(
            @TempDir final Path directory) throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/security/vulnerability_archive_exports/1/download",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));
        final Path target = directory.resolve("download.bin");

        final Path written;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            written = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client))
                    .getSecurityVulnerabilityArchiveExportsDownload(1L, target);
        }

        assertThat(written).hasBinaryContent(new byte[] {1, 2, 3});
    }

    @Test
    void listIssueLinks_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/vulnerabilities/1/issue_links",
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(
                                GitLabVulnerabilityRelatedIssue.class, "vulnerability-related-issue.json")
                        + "]"));

        final List<GitLabVulnerabilityRelatedIssue> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client)).listIssueLinks(1L);
        }

        assertThat(result).containsExactly(VulnerabilitiesCatalogFixtures.vulnerabilityRelatedIssue());
        HTTP.verifyRequested(GET, "/api/v4/vulnerabilities/1/issue_links");
    }

    @Test
    void createIssueLink_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/vulnerabilities/1/issue_links",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabVulnerabilityIssueLink.class, "vulnerability-issue-link.json")));

        final GitLabVulnerabilityIssueLink result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client))
                    .createIssueLink(1L, VulnerabilitiesCatalogFixtures.projectVulnerabilitiesCreateIssueLinkPayload());
        }

        assertThat(result).isEqualTo(VulnerabilitiesCatalogFixtures.vulnerabilityIssueLink());
        HTTP.verifyRequested(POST, "/api/v4/vulnerabilities/1/issue_links");
    }

    @Test
    void createIssueLink_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/vulnerabilities/1/issue_links", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectVulnerabilitiesApi api = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createIssueLink(
                    1L, VulnerabilitiesCatalogFixtures.projectVulnerabilitiesCreateIssueLinkPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/vulnerabilities/1/issue_links");
    }

    @Test
    void deleteIssueLink_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/vulnerabilities/1/issue_links/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabVulnerabilityIssueLink.class, "vulnerability-issue-link.json")));

        final Optional<GitLabVulnerabilityIssueLink> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client)).deleteIssueLink(1L, 1L);
        }

        assertThat(result).contains(VulnerabilitiesCatalogFixtures.vulnerabilityIssueLink());
        HTTP.verifyRequested(DELETE, "/api/v4/vulnerabilities/1/issue_links/1");
    }

    @Test
    void deleteIssueLink_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/vulnerabilities/1/issue_links/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectVulnerabilitiesApi api = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteIssueLink(1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/vulnerabilities/1/issue_links/1");
    }

    @Test
    void deleteIssueLink_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/vulnerabilities/1/issue_links/1", GitLabApiStubSupport.noContent());

        final Optional<GitLabVulnerabilityIssueLink> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client)).deleteIssueLink(1L, 1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/vulnerabilities/1/issue_links/1");
    }

    @Test
    void aiDetectionFlag_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST, "/api/v4/vulnerabilities/vulnerability_id/flags/ai_detection", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client))
                    .aiDetectionFlag(
                            "vulnerability_id",
                            VulnerabilitiesCatalogFixtures.projectVulnerabilitiesAiDetectionFlagPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/vulnerabilities/vulnerability_id/flags/ai_detection");
    }

    @Test
    void aiDetectionFlag_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/vulnerabilities/vulnerability_id/flags/ai_detection", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectVulnerabilitiesApi api = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.aiDetectionFlag(
                    "vulnerability_id", VulnerabilitiesCatalogFixtures.projectVulnerabilitiesAiDetectionFlagPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/vulnerabilities/vulnerability_id/flags/ai_detection");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/vulnerabilities/group%2Fsub%2Fproject",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabVulnerability.class, "vulnerability.json")));

        final Optional<GitLabVulnerability> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client)).get("group/sub/project");
        }

        assertThat(result).contains(CommonCatalogFixtures.vulnerability());
        HTTP.verifyRequested(GET, "/api/v4/vulnerabilities/group%2Fsub%2Fproject");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/vulnerabilities/group%2Fsub%2Fproject", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client))
                    .get("group/sub/project")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/vulnerabilities/group%2Fsub%2Fproject");
    }

    @Test
    void resolve_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/vulnerabilities/group%2Fsub%2Fproject/resolve",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabVulnerability.class, "vulnerability.json")));

        final GitLabVulnerability result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client))
                    .resolve(
                            "group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilitiesResolvePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.vulnerability());
        HTTP.verifyRequested(POST, "/api/v4/vulnerabilities/group%2Fsub%2Fproject/resolve");
    }

    @Test
    void resolve_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/vulnerabilities/group%2Fsub%2Fproject/resolve", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectVulnerabilitiesApi api = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.resolve(
                    "group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilitiesResolvePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/vulnerabilities/group%2Fsub%2Fproject/resolve");
    }

    @Test
    void dismiss_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/vulnerabilities/group%2Fsub%2Fproject/dismiss",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabVulnerability.class, "vulnerability.json")));

        final GitLabVulnerability result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client)).dismiss("group/sub/project");
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.vulnerability());
        HTTP.verifyRequested(POST, "/api/v4/vulnerabilities/group%2Fsub%2Fproject/dismiss");
    }

    @Test
    void dismiss_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/vulnerabilities/group%2Fsub%2Fproject/dismiss", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectVulnerabilitiesApi api = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.dismiss("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/vulnerabilities/group%2Fsub%2Fproject/dismiss");
    }

    @Test
    void confirm_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/vulnerabilities/group%2Fsub%2Fproject/confirm",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabVulnerability.class, "vulnerability.json")));

        final GitLabVulnerability result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client))
                    .confirm(
                            "group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilitiesConfirmPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.vulnerability());
        HTTP.verifyRequested(POST, "/api/v4/vulnerabilities/group%2Fsub%2Fproject/confirm");
    }

    @Test
    void confirm_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/vulnerabilities/group%2Fsub%2Fproject/confirm", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectVulnerabilitiesApi api = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.confirm(
                    "group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilitiesConfirmPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/vulnerabilities/group%2Fsub%2Fproject/confirm");
    }

    @Test
    void revert_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/vulnerabilities/group%2Fsub%2Fproject/revert",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabVulnerability.class, "vulnerability.json")));

        final GitLabVulnerability result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client))
                    .revert("group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilitiesRevertPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.vulnerability());
        HTTP.verifyRequested(POST, "/api/v4/vulnerabilities/group%2Fsub%2Fproject/revert");
    }

    @Test
    void revert_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/vulnerabilities/group%2Fsub%2Fproject/revert", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectVulnerabilitiesApi api = new GitLabProjectVulnerabilitiesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.revert(
                    "group/sub/project", VulnerabilitiesCatalogFixtures.projectVulnerabilitiesRevertPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/vulnerabilities/group%2Fsub%2Fproject/revert");
    }
}

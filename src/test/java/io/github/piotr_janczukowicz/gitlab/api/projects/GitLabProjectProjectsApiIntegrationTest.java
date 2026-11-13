package io.github.piotr_janczukowicz.gitlab.api.projects;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.PATCH;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabAuditEvent;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiPipeline;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMergeRequest;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProject;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProjectImportStatus;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProjectRepositoryStorageMove;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.io.ByteArrayOutputStream;
import java.nio.file.Path;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.io.TempDir;

@IntegrationTest
class GitLabProjectProjectsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void statusComplianceExternalControl_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PATCH,
                "/api/v4/projects/group%2Fsub%2Fproject/compliance_external_controls/1/status",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .statusComplianceExternalControl(
                            "group/sub/project",
                            1L,
                            ProjectsCatalogFixtures.projectProjectsStatusComplianceExternalControlPayload());
        }

        HTTP.verifyRequested(PATCH, "/api/v4/projects/group%2Fsub%2Fproject/compliance_external_controls/1/status");
    }

    @Test
    void statusComplianceExternalControl_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PATCH,
                "/api/v4/projects/group%2Fsub%2Fproject/compliance_external_controls/1/status",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.statusComplianceExternalControl(
                    "group/sub/project",
                    1L,
                    ProjectsCatalogFixtures.projectProjectsStatusComplianceExternalControlPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PATCH, "/api/v4/projects/group%2Fsub%2Fproject/compliance_external_controls/1/status");
    }

    @Test
    void createSecurityScansSast_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/security_scans/sast/sast_endpoint",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .createSecurityScansSast(
                            "group/sub/project",
                            "sast_endpoint",
                            ProjectsCatalogFixtures.projectProjectsCreateSecurityScansSastPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/security_scans/sast/sast_endpoint");
    }

    @Test
    void createSecurityScansSast_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/security_scans/sast/sast_endpoint",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createSecurityScansSast(
                    "group/sub/project",
                    "sast_endpoint",
                    ProjectsCatalogFixtures.projectProjectsCreateSecurityScansSastPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/security_scans/sast/sast_endpoint");
    }

    @Test
    void listAiAgentSessions_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ai_agent/sessions",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(
                                        GitLabAiExternalAgentsSession.class, "ai-external-agents-session.json")
                                + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/ai_agent/sessions?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(GitLabAiExternalAgentsSession.class, "ai-external-agents-session.json")
                        + "]"));

        final List<GitLabAiExternalAgentsSession> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .listAiAgentSessions("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        ProjectsCatalogFixtures.aiExternalAgentsSession(),
                        ProjectsCatalogFixtures.aiExternalAgentsSession());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/ai_agent/sessions", 2);
    }

    @Test
    void createAiAgentSession_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ai_agent/sessions",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabAiExternalAgentsSession.class, "ai-external-agents-session.json")));

        final GitLabAiExternalAgentsSession result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .createAiAgentSession(
                            "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateAiAgentSessionPayload());
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.aiExternalAgentsSession());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/ai_agent/sessions");
    }

    @Test
    void createAiAgentSession_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/ai_agent/sessions", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createAiAgentSession(
                    "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateAiAgentSessionPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/ai_agent/sessions");
    }

    @Test
    void updateAiAgentSession_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PATCH,
                "/api/v4/projects/group%2Fsub%2Fproject/ai_agent/sessions/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabAiExternalAgentsSession.class, "ai-external-agents-session.json")));

        final GitLabAiExternalAgentsSession result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .updateAiAgentSession(
                            "group/sub/project",
                            1L,
                            ProjectsCatalogFixtures.projectProjectsUpdateAiAgentSessionPayload());
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.aiExternalAgentsSession());
        HTTP.verifyRequested(PATCH, "/api/v4/projects/group%2Fsub%2Fproject/ai_agent/sessions/1");
    }

    @Test
    void updateAiAgentSession_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PATCH, "/api/v4/projects/group%2Fsub%2Fproject/ai_agent/sessions/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateAiAgentSession(
                    "group/sub/project", 1L, ProjectsCatalogFixtures.projectProjectsUpdateAiAgentSessionPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PATCH, "/api/v4/projects/group%2Fsub%2Fproject/ai_agent/sessions/1");
    }

    @Test
    void createAiAgentIdentity_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ai_agent/identities",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabAiExternalAgentsIdentity.class, "ai-external-agents-identity.json")));

        final GitLabAiExternalAgentsIdentity result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .createAiAgentIdentity(
                            "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateAiAgentIdentityPayload());
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.aiExternalAgentsIdentity());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/ai_agent/identities");
    }

    @Test
    void createAiAgentIdentity_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/ai_agent/identities", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createAiAgentIdentity(
                    "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateAiAgentIdentityPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/ai_agent/identities");
    }

    @Test
    void createAiAgentAuditEvent_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/ai_agent/audit_events", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .createAiAgentAuditEvent(
                            "group/sub/project",
                            ProjectsCatalogFixtures.projectProjectsCreateAiAgentAuditEventPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/ai_agent/audit_events");
    }

    @Test
    void createAiAgentAuditEvent_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/ai_agent/audit_events", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createAiAgentAuditEvent(
                    "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateAiAgentAuditEventPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/ai_agent/audit_events");
    }

    @Test
    void createDependencyListExport_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/dependency_list_exports",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .createDependencyListExport(
                            "group/sub/project",
                            ProjectsCatalogFixtures.projectProjectsCreateDependencyListExportPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/dependency_list_exports");
    }

    @Test
    void createDependencyListExport_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/dependency_list_exports",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createDependencyListExport(
                    "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateDependencyListExportPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/dependency_list_exports");
    }

    @Test
    void listAnalyticsDeploymentFrequency_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/analytics/deployment_frequency",
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(
                                GitLabAnalyticsDeploymentFrequency.class, "analytics-deployment-frequency.json")
                        + "]"));

        final List<GitLabAnalyticsDeploymentFrequency> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .listAnalyticsDeploymentFrequency(
                            "group/sub/project", "environment", Instant.parse("2026-01-01T00:00:00Z"));
        }

        assertThat(result).containsExactly(ProjectsCatalogFixtures.analyticsDeploymentFrequency());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/analytics/deployment_frequency");
    }

    @Test
    void listManagedLicenses_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/managed_licenses",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabManagedLicense.class, "managed-license.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/managed_licenses?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabManagedLicense.class, "managed-license.json") + "]"));

        final List<GitLabManagedLicense> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .listManagedLicenses("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(ProjectsCatalogFixtures.managedLicense(), ProjectsCatalogFixtures.managedLicense());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/managed_licenses", 2);
    }

    @Test
    void createManagedLicense_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/managed_licenses",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabManagedLicense.class, "managed-license.json")));

        final GitLabManagedLicense result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .createManagedLicense(
                            "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateManagedLicensePayload());
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.managedLicense());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/managed_licenses");
    }

    @Test
    void createManagedLicense_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/managed_licenses", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createManagedLicense(
                    "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateManagedLicensePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/managed_licenses");
    }

    @Test
    void getManagedLicense_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/managed_licenses/managed_license_id",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabManagedLicense.class, "managed-license.json")));

        final Optional<GitLabManagedLicense> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .getManagedLicense("group/sub/project", "managed_license_id");
        }

        assertThat(result).contains(ProjectsCatalogFixtures.managedLicense());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/managed_licenses/managed_license_id");
    }

    @Test
    void getManagedLicense_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/managed_licenses/managed_license_id",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .getManagedLicense("group/sub/project", "managed_license_id")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/managed_licenses/managed_license_id");
    }

    @Test
    void updateManagedLicense_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PATCH,
                "/api/v4/projects/group%2Fsub%2Fproject/managed_licenses/managed_license_id",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabManagedLicense.class, "managed-license.json")));

        final GitLabManagedLicense result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .updateManagedLicense(
                            "group/sub/project",
                            "managed_license_id",
                            ProjectsCatalogFixtures.projectProjectsUpdateManagedLicensePayload());
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.managedLicense());
        HTTP.verifyRequested(PATCH, "/api/v4/projects/group%2Fsub%2Fproject/managed_licenses/managed_license_id");
    }

    @Test
    void updateManagedLicense_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PATCH,
                "/api/v4/projects/group%2Fsub%2Fproject/managed_licenses/managed_license_id",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateManagedLicense(
                    "group/sub/project",
                    "managed_license_id",
                    ProjectsCatalogFixtures.projectProjectsUpdateManagedLicensePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PATCH, "/api/v4/projects/group%2Fsub%2Fproject/managed_licenses/managed_license_id");
    }

    @Test
    void deleteManagedLicense_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/managed_licenses/managed_license_id",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .deleteManagedLicense("group/sub/project", "managed_license_id");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/managed_licenses/managed_license_id");
    }

    @Test
    void deleteManagedLicense_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/managed_licenses/managed_license_id",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteManagedLicense("group/sub/project", "managed_license_id"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/managed_licenses/managed_license_id");
    }

    @Test
    void callDependencyProxyPackagesNpm_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/dependency_proxy/packages/npm/package_name/-/file_name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .callDependencyProxyPackagesNpm("group/sub/project", "package_name", "file_name");
        }

        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/dependency_proxy/packages/npm/package_name/-/file_name");
    }

    @Test
    void callDependencyProxyPackagesNpm_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/dependency_proxy/packages/npm/package_name/-/file_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.callDependencyProxyPackagesNpm("group/sub/project", "package_name", "file_name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/dependency_proxy/packages/npm/package_name/-/file_name");
    }

    @Test
    void getDependencyProxyPackagesMaven_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/dependency_proxy/packages/maven/path/file_name",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .getDependencyProxyPackagesMaven("group/sub/project", "path", "file_name", out);
        }

        assertThat(out.toByteArray()).containsExactly(1, 2, 3);
    }

    @Test
    void getDependencyProxyPackagesMaven_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory)
            throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/dependency_proxy/packages/maven/path/file_name",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));
        final Path target = directory.resolve("download.bin");

        final Path written;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            written = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .getDependencyProxyPackagesMaven("group/sub/project", "path", "file_name", target);
        }

        assertThat(written).hasBinaryContent(new byte[] {1, 2, 3});
    }

    @Test
    void getApprovalSettings_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/approval_settings",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabProjectApprovalSettings.class, "project-approval-settings.json")));

        final GitLabProjectApprovalSettings result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client)).getApprovalSettings("group/sub/project");
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.projectApprovalSettings());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/approval_settings");
    }

    @Test
    void getApprovalSettings_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/approval_settings", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getApprovalSettings("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/approval_settings");
    }

    @Test
    void createApprovalSettingsRule_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/approval_settings/rules",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabProjectApprovalSettingRule.class, "project-approval-setting-rule.json")));

        final GitLabProjectApprovalSettingRule result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .createApprovalSettingsRule(
                            "group/sub/project",
                            ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload());
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.projectApprovalSettingRule());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/approval_settings/rules");
    }

    @Test
    void createApprovalSettingsRule_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/approval_settings/rules",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createApprovalSettingsRule(
                    "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/approval_settings/rules");
    }

    @Test
    void updateApprovalSettingsRule_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/approval_settings/rules/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabProjectApprovalSettingRule.class, "project-approval-setting-rule.json")));

        final GitLabProjectApprovalSettingRule result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .updateApprovalSettingsRule(
                            "group/sub/project",
                            1L,
                            ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload());
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.projectApprovalSettingRule());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/approval_settings/rules/1");
    }

    @Test
    void updateApprovalSettingsRule_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/approval_settings/rules/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateApprovalSettingsRule(
                    "group/sub/project",
                    1L,
                    ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/approval_settings/rules/1");
    }

    @Test
    void deleteApprovalSettingsRule_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/approval_settings/rules/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client)).deleteApprovalSettingsRule("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/approval_settings/rules/1");
    }

    @Test
    void deleteApprovalSettingsRule_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/approval_settings/rules/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteApprovalSettingsRule("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/approval_settings/rules/1");
    }

    @Test
    void listApprovalRules_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/approval_rules",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabProjectApprovalRule.class, "project-approval-rule.json")
                                + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/approval_rules?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(GitLabProjectApprovalRule.class, "project-approval-rule.json") + "]"));

        final List<GitLabProjectApprovalRule> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .listApprovalRules("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        ProjectsCatalogFixtures.projectApprovalRule(), ProjectsCatalogFixtures.projectApprovalRule());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/approval_rules", 2);
    }

    @Test
    void createApprovalRule_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/approval_rules",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabProjectApprovalRule.class, "project-approval-rule.json")));

        final GitLabProjectApprovalRule result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .createApprovalRule(
                            "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload());
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.projectApprovalRule());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/approval_rules");
    }

    @Test
    void createApprovalRule_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/approval_rules", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createApprovalRule(
                    "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/approval_rules");
    }

    @Test
    void getApprovalRule_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/approval_rules/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabProjectApprovalRule.class, "project-approval-rule.json")));

        final Optional<GitLabProjectApprovalRule> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client)).getApprovalRule("group/sub/project", 1L);
        }

        assertThat(result).contains(ProjectsCatalogFixtures.projectApprovalRule());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/approval_rules/1");
    }

    @Test
    void getApprovalRule_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/approval_rules/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .getApprovalRule("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/approval_rules/1");
    }

    @Test
    void updateApprovalRule_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/approval_rules/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabProjectApprovalRule.class, "project-approval-rule.json")));

        final GitLabProjectApprovalRule result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .updateApprovalRule(
                            "group/sub/project",
                            1L,
                            ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload());
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.projectApprovalRule());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/approval_rules/1");
    }

    @Test
    void updateApprovalRule_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/approval_rules/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateApprovalRule(
                    "group/sub/project", 1L, ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/approval_rules/1");
    }

    @Test
    void deleteApprovalRule_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/approval_rules/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client)).deleteApprovalRule("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/approval_rules/1");
    }

    @Test
    void deleteApprovalRule_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/approval_rules/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteApprovalRule("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/approval_rules/1");
    }

    @Test
    void callMlMlflowApiMlflowArtifactsArtifacts_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow-artifacts/artifacts",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .callMlMlflowApiMlflowArtifactsArtifacts("group/sub/project");
        }

        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow-artifacts/artifacts");
    }

    @Test
    void callMlMlflowApiMlflowArtifactsArtifacts_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow-artifacts/artifacts",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callMlMlflowApiMlflowArtifactsArtifacts("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow-artifacts/artifacts");
    }

    @Test
    void callMlMlflowApiMlflowArtifactsArtifact_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow-artifacts/artifacts/model_version/file_path",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .callMlMlflowApiMlflowArtifactsArtifact("group/sub/project", "model_version", "file_path");
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow-artifacts/artifacts/model_version/file_path");
    }

    @Test
    void callMlMlflowApiMlflowArtifactsArtifact_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow-artifacts/artifacts/model_version/file_path",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.callMlMlflowApiMlflowArtifactsArtifact("group/sub/project", "model_version", "file_path"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow-artifacts/artifacts/model_version/file_path");
    }

    @Test
    void createMlMlflowApiMlflowRegisteredModel_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/create",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabMlMlflowRegisteredModel.class, "ml-mlflow-registered-model.json")));

        final GitLabMlMlflowRegisteredModel result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .createMlMlflowApiMlflowRegisteredModel(
                            "group/sub/project",
                            ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowRegisteredModelPayload());
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowRegisteredModel());
        HTTP.verifyRequested(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/create");
    }

    @Test
    void createMlMlflowApiMlflowRegisteredModel_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/create",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createMlMlflowApiMlflowRegisteredModel(
                    "group/sub/project",
                    ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowRegisteredModelPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/create");
    }

    @Test
    void getMlMlflowApiMlflowRegisteredModelsGet_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/get",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabMlMlflowRegisteredModel.class, "ml-mlflow-registered-model.json")));

        final GitLabMlMlflowRegisteredModel result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .getMlMlflowApiMlflowRegisteredModelsGet("group/sub/project");
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowRegisteredModel());
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/get");
    }

    @Test
    void getMlMlflowApiMlflowRegisteredModelsGet_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/get",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getMlMlflowApiMlflowRegisteredModelsGet("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/get");
    }

    @Test
    void updateMlMlflowApiMlflowRegisteredModel_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PATCH,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/update",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabMlMlflowRegisteredModel.class, "ml-mlflow-registered-model.json")));

        final GitLabMlMlflowRegisteredModel result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .updateMlMlflowApiMlflowRegisteredModel(
                            "group/sub/project",
                            ProjectsCatalogFixtures.projectProjectsUpdateMlMlflowApiMlflowRegisteredModelPayload());
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowRegisteredModel());
        HTTP.verifyRequested(
                PATCH, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/update");
    }

    @Test
    void updateMlMlflowApiMlflowRegisteredModel_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PATCH,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/update",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateMlMlflowApiMlflowRegisteredModel(
                    "group/sub/project",
                    ProjectsCatalogFixtures.projectProjectsUpdateMlMlflowApiMlflowRegisteredModelPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PATCH, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/update");
    }

    @Test
    void createMlMlflowApiMlflowRegisteredModelsGetLatestVersion_shouldReturnTheResource_whenResponseIsOk()
            throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/get-latest-versions",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabMlMlflowModelVersion.class, "ml-mlflow-model-version.json")));

        final GitLabMlMlflowModelVersion result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .createMlMlflowApiMlflowRegisteredModelsGetLatestVersion(
                            "group/sub/project",
                            ProjectsCatalogFixtures.projectMlflowRegisteredModelLatestVersionsPayload());
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowModelVersion());
        HTTP.verifyRequested(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/get-latest-versions");
    }

    @Test
    void createMlMlflowApiMlflowRegisteredModelsGetLatestVersion_shouldAnswerNotFound_whenResponseIsNotFound()
            throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/get-latest-versions",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createMlMlflowApiMlflowRegisteredModelsGetLatestVersion(
                    "group/sub/project", ProjectsCatalogFixtures.projectMlflowRegisteredModelLatestVersionsPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/get-latest-versions");
    }

    @Test
    void deleteMlMlflowApiMlflowRegisteredModelsDelete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/delete",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabMlMlflowRegisteredModel.class, "ml-mlflow-registered-model.json")));

        final Optional<GitLabMlMlflowRegisteredModel> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .deleteMlMlflowApiMlflowRegisteredModelsDelete("group/sub/project");
        }

        assertThat(result).contains(ProjectsCatalogFixtures.mlMlflowRegisteredModel());
        HTTP.verifyRequested(
                DELETE, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/delete");
    }

    @Test
    void deleteMlMlflowApiMlflowRegisteredModelsDelete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/delete",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteMlMlflowApiMlflowRegisteredModelsDelete("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                DELETE, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/delete");
    }

    @Test
    void deleteMlMlflowApiMlflowRegisteredModelsDelete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/delete",
                GitLabApiStubSupport.noContent());

        final Optional<GitLabMlMlflowRegisteredModel> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .deleteMlMlflowApiMlflowRegisteredModelsDelete("group/sub/project");
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(
                DELETE, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/delete");
    }

    @Test
    void getMlMlflowApiMlflowRegisteredModelsSearch_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/search",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabMlMlflowListRegisteredModels.class, "ml-mlflow-list-registered-models.json")));

        final GitLabMlMlflowListRegisteredModels result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .getMlMlflowApiMlflowRegisteredModelsSearch("group/sub/project");
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowListRegisteredModels());
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/search");
    }

    @Test
    void getMlMlflowApiMlflowRegisteredModelsSearch_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/search",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getMlMlflowApiMlflowRegisteredModelsSearch("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/search");
    }

    @Test
    void callMlMlflowApiMlflowRegisteredModelsAlias_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/alias",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .callMlMlflowApiMlflowRegisteredModelsAlias("group/sub/project");
        }

        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/alias");
    }

    @Test
    void callMlMlflowApiMlflowRegisteredModelsAlias_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/alias",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callMlMlflowApiMlflowRegisteredModelsAlias("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/alias");
    }

    @Test
    void createMlMlflowApiMlflowRun_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/create",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMlMlflowRun.class, "ml-mlflow-run.json")));

        final GitLabMlMlflowRun result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .createMlMlflowApiMlflowRun(
                            "group/sub/project",
                            ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowRunPayload());
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowRun());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/create");
    }

    @Test
    void createMlMlflowApiMlflowRun_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/create",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createMlMlflowApiMlflowRun(
                    "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowRunPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/create");
    }

    @Test
    void getMlMlflowApiMlflowRunsGet_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/get",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMlMlflowRun.class, "ml-mlflow-run.json")));

        final GitLabMlMlflowRun result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .getMlMlflowApiMlflowRunsGet("group/sub/project", "run_id");
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowRun());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/get");
    }

    @Test
    void getMlMlflowApiMlflowRunsGet_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/get",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getMlMlflowApiMlflowRunsGet("group/sub/project", "run_id"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/get");
    }

    @Test
    void searchMlMlflowApiMlflowRun_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/search",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMlMlflowRun.class, "ml-mlflow-run.json")));

        final GitLabMlMlflowRun result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .searchMlMlflowApiMlflowRun(
                            "group/sub/project",
                            ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowRunPayload());
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowRun());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/search");
    }

    @Test
    void searchMlMlflowApiMlflowRun_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/search",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.searchMlMlflowApiMlflowRun(
                    "group/sub/project", ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowRunPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/search");
    }

    @Test
    void updateMlMlflowApiMlflowRun_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/update",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabMlMlflowUpdateRun.class, "ml-mlflow-update-run.json")));

        final GitLabMlMlflowUpdateRun result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .updateMlMlflowApiMlflowRun(
                            "group/sub/project",
                            ProjectsCatalogFixtures.projectProjectsUpdateMlMlflowApiMlflowRunPayload());
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowUpdateRun());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/update");
    }

    @Test
    void updateMlMlflowApiMlflowRun_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/update",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateMlMlflowApiMlflowRun(
                    "group/sub/project", ProjectsCatalogFixtures.projectProjectsUpdateMlMlflowApiMlflowRunPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/update");
    }

    @Test
    void logMetricMlMlflowApiMlflowRun_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/log-metric",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .logMetricMlMlflowApiMlflowRun(
                            "group/sub/project",
                            ProjectsCatalogFixtures.projectProjectsLogMetricMlMlflowApiMlflowRunPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/log-metric");
    }

    @Test
    void logMetricMlMlflowApiMlflowRun_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/log-metric",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.logMetricMlMlflowApiMlflowRun(
                    "group/sub/project",
                    ProjectsCatalogFixtures.projectProjectsLogMetricMlMlflowApiMlflowRunPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/log-metric");
    }

    @Test
    void logParameterMlMlflowApiMlflowRun_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/log-parameter",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .logParameterMlMlflowApiMlflowRun(
                            "group/sub/project",
                            ProjectsCatalogFixtures.projectProjectsLogParameterMlMlflowApiMlflowRunPayload());
        }

        HTTP.verifyRequested(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/log-parameter");
    }

    @Test
    void logParameterMlMlflowApiMlflowRun_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/log-parameter",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.logParameterMlMlflowApiMlflowRun(
                    "group/sub/project",
                    ProjectsCatalogFixtures.projectProjectsLogParameterMlMlflowApiMlflowRunPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/log-parameter");
    }

    @Test
    void setTagMlMlflowApiMlflowRun_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/set-tag",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .setTagMlMlflowApiMlflowRun(
                            "group/sub/project",
                            ProjectsCatalogFixtures.projectProjectsSetTagMlMlflowApiMlflowRunPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/set-tag");
    }

    @Test
    void setTagMlMlflowApiMlflowRun_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/set-tag",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.setTagMlMlflowApiMlflowRun(
                    "group/sub/project", ProjectsCatalogFixtures.projectProjectsSetTagMlMlflowApiMlflowRunPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/set-tag");
    }

    @Test
    void logBatchMlMlflowApiMlflowRun_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/log-batch",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .logBatchMlMlflowApiMlflowRun(
                            "group/sub/project",
                            ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/log-batch");
    }

    @Test
    void logBatchMlMlflowApiMlflowRun_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/log-batch",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.logBatchMlMlflowApiMlflowRun(
                    "group/sub/project", ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/log-batch");
    }

    @Test
    void deleteMlMlflowApiMlflowRun_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/delete",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .deleteMlMlflowApiMlflowRun(
                            "group/sub/project",
                            ProjectsCatalogFixtures.projectProjectsDeleteMlMlflowApiMlflowRunPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/delete");
    }

    @Test
    void deleteMlMlflowApiMlflowRun_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/delete",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteMlMlflowApiMlflowRun(
                    "group/sub/project", ProjectsCatalogFixtures.projectProjectsDeleteMlMlflowApiMlflowRunPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/delete");
    }

    @Test
    void createMlMlflowApiMlflowModelVersion_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/model-versions/create",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabMlMlflowModelVersion.class, "ml-mlflow-model-version.json")));

        final GitLabMlMlflowModelVersion result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .createMlMlflowApiMlflowModelVersion(
                            "group/sub/project",
                            ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowModelVersionPayload());
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowModelVersion());
        HTTP.verifyRequested(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/model-versions/create");
    }

    @Test
    void createMlMlflowApiMlflowModelVersion_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/model-versions/create",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createMlMlflowApiMlflowModelVersion(
                    "group/sub/project",
                    ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowModelVersionPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/model-versions/create");
    }

    @Test
    void getMlMlflowApiMlflowModelVersionsGetDownloadUri_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/model-versions/get-download-uri",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabMlMlflowGetDownload.class, "ml-mlflow-get-download.json")));

        final GitLabMlMlflowGetDownload result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .getMlMlflowApiMlflowModelVersionsGetDownloadUri("group/sub/project", "name", 1);
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowGetDownload());
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/model-versions/get-download-uri");
    }

    @Test
    void getMlMlflowApiMlflowModelVersionsGetDownloadUri_shouldAnswerNotFound_whenResponseIsNotFound()
            throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/model-versions/get-download-uri",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.getMlMlflowApiMlflowModelVersionsGetDownloadUri("group/sub/project", "name", 1));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/model-versions/get-download-uri");
    }

    @Test
    void getMlMlflowApiMlflowModelVersionsGet_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/model-versions/get",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabMlMlflowModelVersion.class, "ml-mlflow-model-version.json")));

        final GitLabMlMlflowModelVersion result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .getMlMlflowApiMlflowModelVersionsGet("group/sub/project", "name", "version");
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowModelVersion());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/model-versions/get");
    }

    @Test
    void getMlMlflowApiMlflowModelVersionsGet_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/model-versions/get",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.getMlMlflowApiMlflowModelVersionsGet("group/sub/project", "name", "version"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/model-versions/get");
    }

    @Test
    void updateMlMlflowApiMlflowModelVersion_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PATCH,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/model-versions/update",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabMlMlflowModelVersion.class, "ml-mlflow-model-version.json")));

        final GitLabMlMlflowModelVersion result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .updateMlMlflowApiMlflowModelVersion(
                            "group/sub/project",
                            ProjectsCatalogFixtures.projectProjectsUpdateMlMlflowApiMlflowModelVersionPayload());
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowModelVersion());
        HTTP.verifyRequested(
                PATCH, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/model-versions/update");
    }

    @Test
    void updateMlMlflowApiMlflowModelVersion_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PATCH,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/model-versions/update",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateMlMlflowApiMlflowModelVersion(
                    "group/sub/project",
                    ProjectsCatalogFixtures.projectProjectsUpdateMlMlflowApiMlflowModelVersionPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PATCH, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/model-versions/update");
    }

    @Test
    void getMlMlflowApiMlflowMetricsGetHistory_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/metrics/get-history",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabMlMlflowGetMetricHistory.class, "ml-mlflow-get-metric-history.json")));

        final GitLabMlMlflowGetMetricHistory result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .getMlMlflowApiMlflowMetricsGetHistory("group/sub/project", "run_id", "metric_key");
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowGetMetricHistory());
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/metrics/get-history");
    }

    @Test
    void getMlMlflowApiMlflowMetricsGetHistory_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/metrics/get-history",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.getMlMlflowApiMlflowMetricsGetHistory("group/sub/project", "run_id", "metric_key"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/metrics/get-history");
    }

    @Test
    void getMlMlflowApiMlflowExperimentsGet_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/get",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabMlMlflowGetExperiment.class, "ml-mlflow-get-experiment.json")));

        final GitLabMlMlflowGetExperiment result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .getMlMlflowApiMlflowExperimentsGet("group/sub/project");
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowGetExperiment());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/get");
    }

    @Test
    void getMlMlflowApiMlflowExperimentsGet_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/get",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getMlMlflowApiMlflowExperimentsGet("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/get");
    }

    @Test
    void getMlMlflowApiMlflowExperimentsGetByName_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/get-by-name",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabMlMlflowGetExperiment.class, "ml-mlflow-get-experiment.json")));

        final GitLabMlMlflowGetExperiment result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .getMlMlflowApiMlflowExperimentsGetByName("group/sub/project");
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowGetExperiment());
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/get-by-name");
    }

    @Test
    void getMlMlflowApiMlflowExperimentsGetByName_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/get-by-name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getMlMlflowApiMlflowExperimentsGetByName("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/get-by-name");
    }

    @Test
    void getMlMlflowApiMlflowExperimentsList_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/list",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabMlMlflowListExperiment.class, "ml-mlflow-list-experiment.json")));

        final GitLabMlMlflowListExperiment result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .getMlMlflowApiMlflowExperimentsList("group/sub/project");
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowListExperiment());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/list");
    }

    @Test
    void getMlMlflowApiMlflowExperimentsList_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/list",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getMlMlflowApiMlflowExperimentsList("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/list");
    }

    @Test
    void searchMlMlflowApiMlflowExperiment_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/search",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabMlMlflowListExperiment.class, "ml-mlflow-list-experiment.json")));

        final GitLabMlMlflowListExperiment result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .searchMlMlflowApiMlflowExperiment(
                            "group/sub/project",
                            ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowExperimentPayload());
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowListExperiment());
        HTTP.verifyRequested(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/search");
    }

    @Test
    void searchMlMlflowApiMlflowExperiment_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/search",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.searchMlMlflowApiMlflowExperiment(
                    "group/sub/project",
                    ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowExperimentPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/search");
    }

    @Test
    void createMlMlflowApiMlflowExperiment_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/create",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabMlMlflowNewExperiment.class, "ml-mlflow-new-experiment.json")));

        final GitLabMlMlflowNewExperiment result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .createMlMlflowApiMlflowExperiment(
                            "group/sub/project",
                            ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowExperimentPayload());
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowNewExperiment());
        HTTP.verifyRequested(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/create");
    }

    @Test
    void createMlMlflowApiMlflowExperiment_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/create",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createMlMlflowApiMlflowExperiment(
                    "group/sub/project",
                    ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowExperimentPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/create");
    }

    @Test
    void setExperimentTagMlMlflowApiMlflowExperiment_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/set-experiment-tag",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .setExperimentTagMlMlflowApiMlflowExperiment(
                            "group/sub/project",
                            ProjectsCatalogFixtures
                                    .projectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayload());
        }

        HTTP.verifyRequested(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/set-experiment-tag");
    }

    @Test
    void setExperimentTagMlMlflowApiMlflowExperiment_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/set-experiment-tag",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.setExperimentTagMlMlflowApiMlflowExperiment(
                    "group/sub/project",
                    ProjectsCatalogFixtures.projectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/set-experiment-tag");
    }

    @Test
    void deleteMlMlflowApiMlflowExperiment_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/delete",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .deleteMlMlflowApiMlflowExperiment(
                            "group/sub/project",
                            ProjectsCatalogFixtures.projectProjectsDeleteMlMlflowApiMlflowExperimentPayload());
        }

        HTTP.verifyRequested(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/delete");
    }

    @Test
    void deleteMlMlflowApiMlflowExperiment_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/delete",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteMlMlflowApiMlflowExperiment(
                    "group/sub/project",
                    ProjectsCatalogFixtures.projectProjectsDeleteMlMlflowApiMlflowExperimentPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/delete");
    }

    @Test
    void listRepositoryStorageMoves_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository_storage_moves",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(
                                        GitLabProjectRepositoryStorageMove.class,
                                        "project-repository-storage-move.json")
                                + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/repository_storage_moves?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(
                                GitLabProjectRepositoryStorageMove.class, "project-repository-storage-move.json")
                        + "]"));

        final List<GitLabProjectRepositoryStorageMove> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .listRepositoryStorageMoves("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        CommonCatalogFixtures.projectRepositoryStorageMove(),
                        CommonCatalogFixtures.projectRepositoryStorageMove());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository_storage_moves", 2);
    }

    @Test
    void createRepositoryStorageMove_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/repository_storage_moves",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabProjectRepositoryStorageMove.class, "project-repository-storage-move.json")));

        final GitLabProjectRepositoryStorageMove result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .createRepositoryStorageMove(
                            "group/sub/project",
                            ProjectsCatalogFixtures.projectProjectsCreateRepositoryStorageMovePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.projectRepositoryStorageMove());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository_storage_moves");
    }

    @Test
    void createRepositoryStorageMove_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/repository_storage_moves",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createRepositoryStorageMove(
                    "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateRepositoryStorageMovePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository_storage_moves");
    }

    @Test
    void getRepositoryStorageMove_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository_storage_moves/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabProjectRepositoryStorageMove.class, "project-repository-storage-move.json")));

        final Optional<GitLabProjectRepositoryStorageMove> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .getRepositoryStorageMove("group/sub/project", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.projectRepositoryStorageMove());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository_storage_moves/1");
    }

    @Test
    void getRepositoryStorageMove_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository_storage_moves/1",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .getRepositoryStorageMove("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository_storage_moves/1");
    }

    @Test
    void restore_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/restore",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProject.class, "project.json")));

        final GitLabProject result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client)).restore("group/sub/project");
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.project());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/restore");
    }

    @Test
    void restore_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/restore", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.restore("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/restore");
    }

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabProjectWithAccess.class, "project-with-access.json") + "]")
                        .header("Link", "<" + base + "/api/v4/projects?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabProjectWithAccess.class, "project-with-access.json") + "]"));

        final List<GitLabProjectWithAccess> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectProjectsApi(GitLabCaller.of(client)).list().all();
        }

        assertThat(items)
                .containsExactly(
                        ProjectsCatalogFixtures.projectWithAccess(), ProjectsCatalogFixtures.projectWithAccess());
        HTTP.verifyRequested(GET, "/api/v4/projects", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProject.class, "project.json")));

        final GitLabProject result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .create(MultipartFormData.builder().text("field", "value").build());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.project());
        HTTP.verifyRequested(POST, "/api/v4/projects");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects");
    }

    @Test
    void createUser_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/user/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProject.class, "project.json")));

        final GitLabProject result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .createUser(
                            1L,
                            MultipartFormData.builder().text("field", "value").build());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.project());
        HTTP.verifyRequested(POST, "/api/v4/projects/user/1");
    }

    @Test
    void createUser_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/user/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createUser(
                    1L, MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/user/1");
    }

    @Test
    void listShareLocations_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/1/share_locations",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabPublicGroupDetails.class, "public-group-details.json") + "]"));

        final List<GitLabPublicGroupDetails> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client)).listShareLocations(1L);
        }

        assertThat(result).containsExactly(ProjectsCatalogFixtures.publicGroupDetails());
        HTTP.verifyRequested(GET, "/api/v4/projects/1/share_locations");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabProjectWithAccessAndCatalog.class, "project-with-access-and-catalog.json")));

        final Optional<GitLabProjectWithAccessAndCatalog> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client)).get("group/sub/project");
        }

        assertThat(result).contains(ProjectsCatalogFixtures.projectWithAccessAndCatalog());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .get("group/sub/project")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabProjectWithCatalog.class, "project-with-catalog.json")));

        final GitLabProjectWithCatalog result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            MultipartFormData.builder().text("field", "value").build());
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.projectWithCatalog());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project",
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client)).delete("group/sub/project");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject");
    }

    @Test
    void callPagesAccess_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/pages_access", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client)).callPagesAccess("group/sub/project");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/pages_access");
    }

    @Test
    void callPagesAccess_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/pages_access", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callPagesAccess("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/pages_access");
    }

    @Test
    void archive_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/archive",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProject.class, "project.json")));

        final GitLabProject result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client)).archive("group/sub/project");
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.project());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/archive");
    }

    @Test
    void archive_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/archive", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.archive("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/archive");
    }

    @Test
    void unarchive_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/unarchive",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProject.class, "project.json")));

        final GitLabProject result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client)).unarchive("group/sub/project");
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.project());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/unarchive");
    }

    @Test
    void unarchive_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/unarchive", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.unarchive("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/unarchive");
    }

    @Test
    void getLanguages_shouldReturnTheValuesByName_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/languages",
                GitLabApiStubSupport.okJson("{\"alpha\":1.5}"));

        final Map<String, Double> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client)).getLanguages("group/sub/project");
        }

        assertThat(result).containsOnly(Map.entry("alpha", 1.5));
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/languages");
    }

    @Test
    void getLanguages_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/languages", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getLanguages("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/languages");
    }

    @Test
    void share_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/share",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabProjectGroupLink.class, "project-group-link.json")));

        final GitLabProjectGroupLink result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .share("group/sub/project", ProjectsCatalogFixtures.projectProjectsSharePayload());
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.projectGroupLink());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/share");
    }

    @Test
    void share_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/share", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.share("group/sub/project", ProjectsCatalogFixtures.projectProjectsSharePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/share");
    }

    @Test
    void deleteShare_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/share/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client)).deleteShare("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/share/1");
    }

    @Test
    void deleteShare_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/share/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteShare("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/share/1");
    }

    @Test
    void createImportProjectMember_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/import_project_members/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client)).createImportProjectMember("group/sub/project", 1L);
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/import_project_members/1");
    }

    @Test
    void createImportProjectMember_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/import_project_members/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createImportProjectMember("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/import_project_members/1");
    }

    @Test
    void listUsers_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/users",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabUserBasic.class, "user-basic.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/projects/group%2Fsub%2Fproject/users?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabUserBasic.class, "user-basic.json") + "]"));

        final List<GitLabUserBasic> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .listUsers("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.userBasic(), CommonCatalogFixtures.userBasic());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/users", 2);
    }

    @Test
    void listGroups_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/groups",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabPublicGroupDetails.class, "public-group-details.json")
                                        + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/projects/group%2Fsub%2Fproject/groups?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabPublicGroupDetails.class, "public-group-details.json") + "]"));

        final List<GitLabPublicGroupDetails> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .listGroups("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        ProjectsCatalogFixtures.publicGroupDetails(), ProjectsCatalogFixtures.publicGroupDetails());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/groups", 2);
    }

    @Test
    void listInvitedGroups_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/invited_groups",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabPublicGroupDetails.class, "public-group-details.json")
                                        + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/invited_groups?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabPublicGroupDetails.class, "public-group-details.json") + "]"));

        final List<GitLabPublicGroupDetails> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .listInvitedGroups("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        ProjectsCatalogFixtures.publicGroupDetails(), ProjectsCatalogFixtures.publicGroupDetails());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/invited_groups", 2);
    }

    @Test
    void housekeeping_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/housekeeping", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .housekeeping("group/sub/project", ProjectsCatalogFixtures.projectProjectsHousekeepingPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/housekeeping");
    }

    @Test
    void housekeeping_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/housekeeping", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.housekeeping(
                    "group/sub/project", ProjectsCatalogFixtures.projectProjectsHousekeepingPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/housekeeping");
    }

    @Test
    void repositorySize_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository_size", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client)).repositorySize("group/sub/project");
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository_size");
    }

    @Test
    void repositorySize_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository_size", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.repositorySize("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository_size");
    }

    @Test
    void transfer_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/transfer",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProject.class, "project.json")));

        final GitLabProject result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .transfer("group/sub/project", ProjectsCatalogFixtures.projectProjectsTransferPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.project());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/transfer");
    }

    @Test
    void transfer_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/transfer", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.transfer("group/sub/project", ProjectsCatalogFixtures.projectProjectsTransferPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/transfer");
    }

    @Test
    void listTransferLocations_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/transfer_locations",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabPublicGroupDetails.class, "public-group-details.json")
                                        + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/transfer_locations?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabPublicGroupDetails.class, "public-group-details.json") + "]"));

        final List<GitLabPublicGroupDetails> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .listTransferLocations("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        ProjectsCatalogFixtures.publicGroupDetails(), ProjectsCatalogFixtures.publicGroupDetails());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/transfer_locations", 2);
    }

    @Test
    void getStorage_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/storage",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabProjectRepositoryStorage.class, "project-repository-storage.json")));

        final GitLabProjectRepositoryStorage result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client)).getStorage("group/sub/project");
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.projectRepositoryStorage());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/storage");
    }

    @Test
    void getStorage_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/storage", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getStorage("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/storage");
    }

    @Test
    void listAuditEvents_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/audit_events",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabAuditEvent.class, "audit-event.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/audit_events?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabAuditEvent.class, "audit-event.json") + "]"));

        final List<GitLabAuditEvent> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .listAuditEvents("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.auditEvent(), CommonCatalogFixtures.auditEvent());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/audit_events", 2);
    }

    @Test
    void getAuditEvent_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/audit_events/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabAuditEvent.class, "audit-event.json")));

        final Optional<GitLabAuditEvent> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client)).getAuditEvent("group/sub/project", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.auditEvent());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/audit_events/1");
    }

    @Test
    void getAuditEvent_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/audit_events/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .getAuditEvent("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/audit_events/1");
    }

    @Test
    void getSnapshot_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/snapshot",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client)).getSnapshot("group/sub/project", out);
        }

        assertThat(out.toByteArray()).containsExactly(1, 2, 3);
    }

    @Test
    void getSnapshot_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/snapshot",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));
        final Path target = directory.resolve("download.bin");

        final Path written;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            written = new GitLabProjectProjectsApi(GitLabCaller.of(client)).getSnapshot("group/sub/project", target);
        }

        assertThat(written).hasBinaryContent(new byte[] {1, 2, 3});
    }

    @Test
    void remoteImport_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/remote-import",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabProjectImportStatus.class, "project-import-status.json")));

        final GitLabProjectImportStatus result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .remoteImport(
                            MultipartFormData.builder().text("field", "value").build());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.projectImportStatus());
        HTTP.verifyRequested(POST, "/api/v4/projects/remote-import");
    }

    @Test
    void remoteImport_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/remote-import", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.remoteImport(
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/remote-import");
    }

    @Test
    void authorizeImportRelation_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/import-relation/authorize", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client)).authorizeImportRelation();
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/import-relation/authorize");
    }

    @Test
    void authorizeImportRelation_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/import-relation/authorize", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorizeImportRelation());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/import-relation/authorize");
    }

    @Test
    void importRelation_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/import-relation",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabRelationImportTracker.class, "relation-import-tracker.json")));

        final GitLabRelationImportTracker result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .importRelation(
                            MultipartFormData.builder().text("field", "value").build());
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.relationImportTracker());
        HTTP.verifyRequested(POST, "/api/v4/projects/import-relation");
    }

    @Test
    void importRelation_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/import-relation", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.importRelation(
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/import-relation");
    }

    @Test
    void listRelationImports_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/relation-imports",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabRelationImportTracker.class, "relation-import-tracker.json")
                                + "]"));

        final List<GitLabRelationImportTracker> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client)).listRelationImports("group/sub/project");
        }

        assertThat(result).containsExactly(ProjectsCatalogFixtures.relationImportTracker());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/relation-imports");
    }

    @Test
    void remoteImportS3_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/remote-import-s3",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabProjectImportStatus.class, "project-import-status.json")));

        final GitLabProjectImportStatus result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .remoteImportS3(
                            MultipartFormData.builder().text("field", "value").build());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.projectImportStatus());
        HTTP.verifyRequested(POST, "/api/v4/projects/remote-import-s3");
    }

    @Test
    void remoteImportS3_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/remote-import-s3", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.remoteImportS3(
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/remote-import-s3");
    }

    @Test
    void getAvatar_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/avatar",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client)).getAvatar("group/sub/project", out);
        }

        assertThat(out.toByteArray()).containsExactly(1, 2, 3);
    }

    @Test
    void getAvatar_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/avatar",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));
        final Path target = directory.resolve("download.bin");

        final Path written;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            written = new GitLabProjectProjectsApi(GitLabCaller.of(client)).getAvatar("group/sub/project", target);
        }

        assertThat(written).hasBinaryContent(new byte[] {1, 2, 3});
    }

    @Test
    void createCiConfig_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/create_ci_config",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMergeRequest.class, "merge-request.json")));

        final GitLabMergeRequest result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client)).createCiConfig("group/sub/project");
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.mergeRequest());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/create_ci_config");
    }

    @Test
    void createCiConfig_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/create_ci_config", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createCiConfig("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/create_ci_config");
    }

    @Test
    void createGithubWebhook_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/1/github/webhooks", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client)).createGithubWebhook(1L);
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/1/github/webhooks");
    }

    @Test
    void createGithubWebhook_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/1/github/webhooks", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createGithubWebhook(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/1/github/webhooks");
    }

    @Test
    void pipelineTrigger_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/trigger/pipeline",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiPipeline.class, "ci-pipeline.json")));

        final GitLabCiPipeline result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .pipelineTrigger(
                            "group/sub/project", ProjectsCatalogFixtures.projectProjectsPipelineTriggerPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciPipeline());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/trigger/pipeline");
    }

    @Test
    void pipelineTrigger_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/trigger/pipeline", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.pipelineTrigger(
                    "group/sub/project", ProjectsCatalogFixtures.projectProjectsPipelineTriggerPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/trigger/pipeline");
    }

    @Test
    void pipelineRefTrigger_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ref/ref/trigger/pipeline",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiPipeline.class, "ci-pipeline.json")));

        final GitLabCiPipeline result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .pipelineRefTrigger(
                            "group/sub/project",
                            "ref",
                            ProjectsCatalogFixtures.projectProjectsPipelineRefTriggerPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciPipeline());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/ref/ref/trigger/pipeline");
    }

    @Test
    void pipelineRefTrigger_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ref/ref/trigger/pipeline",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.pipelineRefTrigger(
                    "group/sub/project", "ref", ProjectsCatalogFixtures.projectProjectsPipelineRefTriggerPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/ref/ref/trigger/pipeline");
    }

    @Test
    void deleteArtifact_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/artifacts", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectsApi(GitLabCaller.of(client)).deleteArtifact("group/sub/project");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/artifacts");
    }

    @Test
    void deleteArtifact_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/artifacts", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteArtifact("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/artifacts");
    }

    @Test
    void publishCatalog_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/catalog/publish",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabCiCatalogResourcesVersion.class, "ci-catalog-resources-version.json")));

        final GitLabCiCatalogResourcesVersion result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectsApi(GitLabCaller.of(client))
                    .publishCatalog(
                            "group/sub/project", ProjectsCatalogFixtures.projectProjectsPublishCatalogPayload());
        }

        assertThat(result).isEqualTo(ProjectsCatalogFixtures.ciCatalogResourcesVersion());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/catalog/publish");
    }

    @Test
    void publishCatalog_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/catalog/publish", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectsApi api = new GitLabProjectProjectsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.publishCatalog(
                    "group/sub/project", ProjectsCatalogFixtures.projectProjectsPublishCatalogPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/catalog/publish");
    }
}

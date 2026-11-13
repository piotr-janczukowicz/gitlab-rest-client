package io.github.piotr_janczukowicz.gitlab.api.projects;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabAuditEvent;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiPipeline;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMergeRequest;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProject;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProjectImportStatus;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProjectRepositoryStorageMove;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.HttpStreamResponse;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

@UnitTest
class GitLabProjectProjectsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectProjectsApi api() {
        return new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectProjectsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void statusComplianceExternalControl_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().statusComplianceExternalControl(
                        "group/sub/project",
                        1L,
                        ProjectsCatalogFixtures.projectProjectsStatusComplianceExternalControlPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PATCH /api/v4/projects/group%2Fsub%2Fproject/compliance_external_controls/1/status");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"status\":");
        });
    }

    @Test
    void statusComplianceExternalControl_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().statusComplianceExternalControl(
                        "group/sub/project",
                        1L,
                        ProjectsCatalogFixtures.projectProjectsStatusComplianceExternalControlPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createSecurityScansSast_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createSecurityScansSast(
                "group/sub/project",
                "sast_endpoint",
                ProjectsCatalogFixtures.projectProjectsCreateSecurityScansSastPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createSecurityScansSast_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createSecurityScansSast(
                "group/sub/project",
                "sast_endpoint",
                ProjectsCatalogFixtures.projectProjectsCreateSecurityScansSastPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createSecurityScansSast_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createSecurityScansSast(
                        "group/sub/project",
                        "sast_endpoint",
                        ProjectsCatalogFixtures.projectProjectsCreateSecurityScansSastPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/security_scans/sast/sast_endpoint");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"file_path\":");
        });
    }

    @Test
    void createSecurityScansSast_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createSecurityScansSast(
                        "group/sub/project",
                        "sast_endpoint",
                        ProjectsCatalogFixtures.projectProjectsCreateSecurityScansSastPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listAiAgentSessions_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listAiAgentSessions("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listAiAgentSessions_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listAiAgentSessions("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listAiAgentSessions_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabAiExternalAgentsSession.class, "ai-external-agents-session.json")
                                + "]"));

        final GitLabPage<GitLabAiExternalAgentsSession> page = api().listAiAgentSessions("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.aiExternalAgentsSession());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/ai_agent/sessions");
        });
    }

    @Test
    void listAiAgentSessions_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabAiExternalAgentsSession.class, "ai-external-agents-session.json")
                                + "]"));

        final GitLabPage<GitLabAiExternalAgentsSession> page = api().listAiAgentSessions(
                        "group/sub/project",
                        GitLabProjectProjectsListAiAgentSessionsFilterBuilder.builder()
                                .agentType(GitLabProjectProjectsListAiAgentSessionsAgentType.CLAUDE_CODE)
                                .status(GitLabProjectProjectsListAiAgentSessionsStatus.CREATED)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.aiExternalAgentsSession());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/ai_agent/sessions");
            softly.assertThat(request.uri()).hasParameter("agent_type", "claude-code");
        });
    }

    @Test
    void listAiAgentSessions_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabAiExternalAgentsSession.class, "ai-external-agents-session.json")
                                + "]"));

        final GitLabPage<GitLabAiExternalAgentsSession> page =
                api().listAiAgentSessions("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.aiExternalAgentsSession());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/ai_agent/sessions");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listAiAgentSessions_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabAiExternalAgentsSession.class, "ai-external-agents-session.json")
                                + "]"));

        final GitLabPage<GitLabAiExternalAgentsSession> page = api().listAiAgentSessions(
                        "group/sub/project",
                        GitLabProjectProjectsListAiAgentSessionsFilterBuilder.builder()
                                .agentType(GitLabProjectProjectsListAiAgentSessionsAgentType.CLAUDE_CODE)
                                .status(GitLabProjectProjectsListAiAgentSessionsStatus.CREATED)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.aiExternalAgentsSession());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/ai_agent/sessions");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("agent_type", "claude-code");
        });
    }

    @Test
    void createAiAgentSession_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createAiAgentSession(
                "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateAiAgentSessionPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createAiAgentSession_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createAiAgentSession(
                "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateAiAgentSessionPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createAiAgentSession_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabAiExternalAgentsSession.class, "ai-external-agents-session.json")));

        final GitLabAiExternalAgentsSession result = api().createAiAgentSession(
                        "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateAiAgentSessionPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.aiExternalAgentsSession());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/ai_agent/sessions");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"agent_type\":");
        });
    }

    @Test
    void createAiAgentSession_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createAiAgentSession(
                        "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateAiAgentSessionPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateAiAgentSession_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.updateAiAgentSession(
                "group/sub/project", 1L, ProjectsCatalogFixtures.projectProjectsUpdateAiAgentSessionPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void updateAiAgentSession_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.updateAiAgentSession(
                "group/sub/project", 1L, ProjectsCatalogFixtures.projectProjectsUpdateAiAgentSessionPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void updateAiAgentSession_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabAiExternalAgentsSession.class, "ai-external-agents-session.json")));

        final GitLabAiExternalAgentsSession result = api().updateAiAgentSession(
                        "group/sub/project", 1L, ProjectsCatalogFixtures.projectProjectsUpdateAiAgentSessionPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.aiExternalAgentsSession());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PATCH /api/v4/projects/group%2Fsub%2Fproject/ai_agent/sessions/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"status\":");
        });
    }

    @Test
    void updateAiAgentSession_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateAiAgentSession(
                        "group/sub/project", 1L, ProjectsCatalogFixtures.projectProjectsUpdateAiAgentSessionPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createAiAgentIdentity_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createAiAgentIdentity(
                "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateAiAgentIdentityPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createAiAgentIdentity_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createAiAgentIdentity(
                "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateAiAgentIdentityPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createAiAgentIdentity_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabAiExternalAgentsIdentity.class, "ai-external-agents-identity.json")));

        final GitLabAiExternalAgentsIdentity result = api().createAiAgentIdentity(
                        "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateAiAgentIdentityPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.aiExternalAgentsIdentity());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/ai_agent/identities");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"agent_type\":");
        });
    }

    @Test
    void createAiAgentIdentity_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createAiAgentIdentity(
                        "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateAiAgentIdentityPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createAiAgentAuditEvent_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createAiAgentAuditEvent(
                "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateAiAgentAuditEventPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createAiAgentAuditEvent_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createAiAgentAuditEvent(
                "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateAiAgentAuditEventPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createAiAgentAuditEvent_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createAiAgentAuditEvent(
                        "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateAiAgentAuditEventPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/ai_agent/audit_events");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"session_id\":");
        });
    }

    @Test
    void createAiAgentAuditEvent_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createAiAgentAuditEvent(
                        "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateAiAgentAuditEventPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createDependencyListExport_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createDependencyListExport(
                "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateDependencyListExportPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createDependencyListExport_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createDependencyListExport(
                "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateDependencyListExportPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createDependencyListExport_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createDependencyListExport(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsCreateDependencyListExportPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/dependency_list_exports");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"send_email\":");
        });
    }

    @Test
    void createDependencyListExport_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createDependencyListExport(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsCreateDependencyListExportPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listAnalyticsDeploymentFrequency_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listAnalyticsDeploymentFrequency(
                "group/sub/project", "environment", Instant.parse("2026-01-01T00:00:00Z")));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listAnalyticsDeploymentFrequency_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listAnalyticsDeploymentFrequency(
                "group/sub/project", "environment", Instant.parse("2026-01-01T00:00:00Z")));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listAnalyticsDeploymentFrequency_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabAnalyticsDeploymentFrequency.class, "analytics-deployment-frequency.json")
                                + "]"));

        final List<GitLabAnalyticsDeploymentFrequency> result = api().listAnalyticsDeploymentFrequency(
                        "group/sub/project", "environment", Instant.parse("2026-01-01T00:00:00Z"));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(ProjectsCatalogFixtures.analyticsDeploymentFrequency());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/analytics/deployment_frequency");
            softly.assertThat(request.uri()).hasParameter("environment", "environment");
        });
    }

    @Test
    void listManagedLicenses_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabManagedLicense.class, "managed-license.json") + "]"));

        final GitLabPage<GitLabManagedLicense> page = api().listManagedLicenses("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.managedLicense());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/managed_licenses");
        });
    }

    @Test
    void listManagedLicenses_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabManagedLicense.class, "managed-license.json") + "]"));

        final GitLabPage<GitLabManagedLicense> page =
                api().listManagedLicenses("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.managedLicense());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/managed_licenses");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createManagedLicense_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabManagedLicense.class, "managed-license.json")));

        final GitLabManagedLicense result = api().createManagedLicense(
                        "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateManagedLicensePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.managedLicense());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/managed_licenses");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void createManagedLicense_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createManagedLicense(
                        "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateManagedLicensePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getManagedLicense_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabManagedLicense.class, "managed-license.json")));

        final Optional<GitLabManagedLicense> result =
                api().getManagedLicense("group/sub/project", "managed_license_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(ProjectsCatalogFixtures.managedLicense());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/managed_licenses/managed_license_id");
        });
    }

    @Test
    void getManagedLicense_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabManagedLicense> result =
                api().getManagedLicense("group/sub/project", "managed_license_id");

        assertThat(result).isEmpty();
    }

    @Test
    void updateManagedLicense_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabManagedLicense.class, "managed-license.json")));

        final GitLabManagedLicense result = api().updateManagedLicense(
                        "group/sub/project",
                        "managed_license_id",
                        ProjectsCatalogFixtures.projectProjectsUpdateManagedLicensePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.managedLicense());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PATCH /api/v4/projects/group%2Fsub%2Fproject/managed_licenses/managed_license_id");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void updateManagedLicense_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateManagedLicense(
                        "group/sub/project",
                        "managed_license_id",
                        ProjectsCatalogFixtures.projectProjectsUpdateManagedLicensePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteManagedLicense_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteManagedLicense("group/sub/project", "managed_license_id");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/managed_licenses/managed_license_id");
    }

    @Test
    void deleteManagedLicense_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().deleteManagedLicense("group/sub/project", "managed_license_id"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callDependencyProxyPackagesNpm_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(
                () -> lowTier.callDependencyProxyPackagesNpm("group/sub/project", "package_name", "file_name"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void callDependencyProxyPackagesNpm_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(
                () -> lowTier.callDependencyProxyPackagesNpm("group/sub/project", "package_name", "file_name"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void callDependencyProxyPackagesNpm_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callDependencyProxyPackagesNpm("group/sub/project", "package_name", "file_name");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/projects/group%2Fsub%2Fproject/dependency_proxy/packages/npm/package_name/-/file_name");
    }

    @Test
    void callDependencyProxyPackagesNpm_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().callDependencyProxyPackagesNpm("group/sub/project", "package_name", "file_name"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getDependencyProxyPackagesMaven_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getDependencyProxyPackagesMaven(
                "group/sub/project", "path", "file_name", OutputStream.nullOutputStream()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getDependencyProxyPackagesMaven_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getDependencyProxyPackagesMaven(
                "group/sub/project", "path", "file_name", OutputStream.nullOutputStream()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getDependencyProxyPackagesMaven_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        final long written = api().getDependencyProxyPackagesMaven("group/sub/project", "path", "file_name", out);

        assertSoftly(softly -> {
            softly.assertThat(written).isEqualTo(3L);
            softly.assertThat(out).hasToString("abc");
        });
    }

    @Test
    void getDependencyProxyPackagesMaven_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory)
            throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final Path target = directory.resolve("download.bin");

        final Path written = api().getDependencyProxyPackagesMaven("group/sub/project", "path", "file_name", target);

        assertThat(written).hasContent("abc");
    }

    @Test
    void getApprovalSettings_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getApprovalSettings("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getApprovalSettings_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getApprovalSettings("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getApprovalSettings_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabProjectApprovalSettings.class, "project-approval-settings.json")));

        final GitLabProjectApprovalSettings result = api().getApprovalSettings("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.projectApprovalSettings());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/approval_settings");
        });
    }

    @Test
    void getApprovalSettings_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getApprovalSettings("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getApprovalSettings_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabProjectApprovalSettings.class, "project-approval-settings.json")));

        api().getApprovalSettings(
                        "group/sub/project",
                        GitLabProjectProjectsGetApprovalSettingsFilterBuilder.builder()
                                .targetBranch("target_branch")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("target_branch", "target_branch");
    }

    @Test
    void createApprovalSettingsRule_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createApprovalSettingsRule(
                "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createApprovalSettingsRule_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createApprovalSettingsRule(
                "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createApprovalSettingsRule_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabProjectApprovalSettingRule.class, "project-approval-setting-rule.json")));

        final GitLabProjectApprovalSettingRule result = api().createApprovalSettingsRule(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.projectApprovalSettingRule());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/approval_settings/rules");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void createApprovalSettingsRule_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createApprovalSettingsRule(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsCreateApprovalSettingsRulePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateApprovalSettingsRule_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.updateApprovalSettingsRule(
                "group/sub/project", 1L, ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void updateApprovalSettingsRule_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.updateApprovalSettingsRule(
                "group/sub/project", 1L, ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void updateApprovalSettingsRule_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabProjectApprovalSettingRule.class, "project-approval-setting-rule.json")));

        final GitLabProjectApprovalSettingRule result = api().updateApprovalSettingsRule(
                        "group/sub/project",
                        1L,
                        ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.projectApprovalSettingRule());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/approval_settings/rules/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void updateApprovalSettingsRule_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateApprovalSettingsRule(
                        "group/sub/project",
                        1L,
                        ProjectsCatalogFixtures.projectProjectsUpdateApprovalSettingsRulePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteApprovalSettingsRule_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteApprovalSettingsRule("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void deleteApprovalSettingsRule_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteApprovalSettingsRule("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void deleteApprovalSettingsRule_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteApprovalSettingsRule("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/approval_settings/rules/1");
    }

    @Test
    void deleteApprovalSettingsRule_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteApprovalSettingsRule("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listApprovalRules_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listApprovalRules("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listApprovalRules_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listApprovalRules("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listApprovalRules_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabProjectApprovalRule.class, "project-approval-rule.json")
                                + "]"));

        final GitLabPage<GitLabProjectApprovalRule> page = api().listApprovalRules("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.projectApprovalRule());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/approval_rules");
        });
    }

    @Test
    void listApprovalRules_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabProjectApprovalRule.class, "project-approval-rule.json")
                                + "]"));

        final GitLabPage<GitLabProjectApprovalRule> page =
                api().listApprovalRules("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.projectApprovalRule());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/approval_rules");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createApprovalRule_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createApprovalRule(
                "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createApprovalRule_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createApprovalRule(
                "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createApprovalRule_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabProjectApprovalRule.class, "project-approval-rule.json")));

        final GitLabProjectApprovalRule result = api().createApprovalRule(
                        "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.projectApprovalRule());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/approval_rules");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void createApprovalRule_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createApprovalRule(
                        "group/sub/project", ProjectsCatalogFixtures.projectProjectsCreateApprovalRulePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getApprovalRule_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getApprovalRule("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getApprovalRule_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getApprovalRule("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getApprovalRule_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabProjectApprovalRule.class, "project-approval-rule.json")));

        final Optional<GitLabProjectApprovalRule> result = api().getApprovalRule("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(ProjectsCatalogFixtures.projectApprovalRule());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/approval_rules/1");
        });
    }

    @Test
    void getApprovalRule_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabProjectApprovalRule> result = api().getApprovalRule("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void updateApprovalRule_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.updateApprovalRule(
                "group/sub/project", 1L, ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void updateApprovalRule_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.updateApprovalRule(
                "group/sub/project", 1L, ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void updateApprovalRule_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabProjectApprovalRule.class, "project-approval-rule.json")));

        final GitLabProjectApprovalRule result = api().updateApprovalRule(
                        "group/sub/project", 1L, ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.projectApprovalRule());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/approval_rules/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void updateApprovalRule_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateApprovalRule(
                        "group/sub/project", 1L, ProjectsCatalogFixtures.projectProjectsUpdateApprovalRulePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteApprovalRule_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteApprovalRule("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void deleteApprovalRule_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteApprovalRule("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void deleteApprovalRule_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteApprovalRule("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/approval_rules/1");
    }

    @Test
    void deleteApprovalRule_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteApprovalRule("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callMlMlflowApiMlflowArtifactsArtifacts_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callMlMlflowApiMlflowArtifactsArtifacts("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow-artifacts/artifacts");
    }

    @Test
    void callMlMlflowApiMlflowArtifactsArtifacts_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().callMlMlflowApiMlflowArtifactsArtifacts("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callMlMlflowApiMlflowArtifactsArtifacts_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callMlMlflowApiMlflowArtifactsArtifacts(
                        "group/sub/project",
                        GitLabProjectProjectsCallMlMlflowApiMlflowArtifactsArtifactsFilterBuilder.builder()
                                .path("path")
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("path", "path");
    }

    @Test
    void callMlMlflowApiMlflowArtifactsArtifact_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callMlMlflowApiMlflowArtifactsArtifact("group/sub/project", "model_version", "file_path");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow-artifacts/artifacts/model_version/file_path");
    }

    @Test
    void callMlMlflowApiMlflowArtifactsArtifact_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().callMlMlflowApiMlflowArtifactsArtifact("group/sub/project", "model_version", "file_path"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createMlMlflowApiMlflowRegisteredModel_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabMlMlflowRegisteredModel.class, "ml-mlflow-registered-model.json")));

        final GitLabMlMlflowRegisteredModel result = api().createMlMlflowApiMlflowRegisteredModel(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowRegisteredModelPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowRegisteredModel());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "POST /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/create");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void createMlMlflowApiMlflowRegisteredModel_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createMlMlflowApiMlflowRegisteredModel(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowRegisteredModelPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getMlMlflowApiMlflowRegisteredModelsGet_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabMlMlflowRegisteredModel.class, "ml-mlflow-registered-model.json")));

        final GitLabMlMlflowRegisteredModel result = api().getMlMlflowApiMlflowRegisteredModelsGet("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowRegisteredModel());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/get");
        });
    }

    @Test
    void getMlMlflowApiMlflowRegisteredModelsGet_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().getMlMlflowApiMlflowRegisteredModelsGet("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getMlMlflowApiMlflowRegisteredModelsGet_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabMlMlflowRegisteredModel.class, "ml-mlflow-registered-model.json")));

        api().getMlMlflowApiMlflowRegisteredModelsGet(
                        "group/sub/project",
                        GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsGetFilterBuilder.builder()
                                .name("name")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("name", "name");
    }

    @Test
    void updateMlMlflowApiMlflowRegisteredModel_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabMlMlflowRegisteredModel.class, "ml-mlflow-registered-model.json")));

        final GitLabMlMlflowRegisteredModel result = api().updateMlMlflowApiMlflowRegisteredModel(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsUpdateMlMlflowApiMlflowRegisteredModelPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowRegisteredModel());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "PATCH /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/update");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void updateMlMlflowApiMlflowRegisteredModel_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateMlMlflowApiMlflowRegisteredModel(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsUpdateMlMlflowApiMlflowRegisteredModelPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createMlMlflowApiMlflowRegisteredModelsGetLatestVersion_shouldReturnTheResource_whenResponseIsOk()
            throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabMlMlflowModelVersion.class, "ml-mlflow-model-version.json")));

        final GitLabMlMlflowModelVersion result = api().createMlMlflowApiMlflowRegisteredModelsGetLatestVersion(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectMlflowRegisteredModelLatestVersionsPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowModelVersion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "POST /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/get-latest-versions");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void createMlMlflowApiMlflowRegisteredModelsGetLatestVersion_shouldThrowNotFound_whenResponseIsNotFound()
            throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createMlMlflowApiMlflowRegisteredModelsGetLatestVersion(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectMlflowRegisteredModelLatestVersionsPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteMlMlflowApiMlflowRegisteredModelsDelete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabMlMlflowRegisteredModel.class, "ml-mlflow-registered-model.json")));

        final Optional<GitLabMlMlflowRegisteredModel> result =
                api().deleteMlMlflowApiMlflowRegisteredModelsDelete("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(ProjectsCatalogFixtures.mlMlflowRegisteredModel());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "DELETE /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/delete");
        });
    }

    @Test
    void deleteMlMlflowApiMlflowRegisteredModelsDelete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().deleteMlMlflowApiMlflowRegisteredModelsDelete("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteMlMlflowApiMlflowRegisteredModelsDelete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        final Optional<GitLabMlMlflowRegisteredModel> result =
                api().deleteMlMlflowApiMlflowRegisteredModelsDelete("group/sub/project");

        assertThat(result).isEmpty();
    }

    @Test
    void deleteMlMlflowApiMlflowRegisteredModelsDelete_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabMlMlflowRegisteredModel.class, "ml-mlflow-registered-model.json")));

        api().deleteMlMlflowApiMlflowRegisteredModelsDelete(
                        "group/sub/project",
                        GitLabProjectProjectsDeleteMlMlflowApiMlflowRegisteredModelsDeleteFilterBuilder.builder()
                                .name("name")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("name", "name");
    }

    @Test
    void getMlMlflowApiMlflowRegisteredModelsSearch_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabMlMlflowListRegisteredModels.class, "ml-mlflow-list-registered-models.json")));

        final GitLabMlMlflowListRegisteredModels result =
                api().getMlMlflowApiMlflowRegisteredModelsSearch("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowListRegisteredModels());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/search");
        });
    }

    @Test
    void getMlMlflowApiMlflowRegisteredModelsSearch_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().getMlMlflowApiMlflowRegisteredModelsSearch("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getMlMlflowApiMlflowRegisteredModelsSearch_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabMlMlflowListRegisteredModels.class, "ml-mlflow-list-registered-models.json")));

        api().getMlMlflowApiMlflowRegisteredModelsSearch(
                        "group/sub/project",
                        GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilterBuilder.builder()
                                .filter("filter")
                                .maxResults(1)
                                .orderBy(List.of("text"))
                                .pageToken("page_token")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("filter", "filter");
    }

    @Test
    void callMlMlflowApiMlflowRegisteredModelsAlias_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callMlMlflowApiMlflowRegisteredModelsAlias("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/registered-models/alias");
    }

    @Test
    void callMlMlflowApiMlflowRegisteredModelsAlias_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().callMlMlflowApiMlflowRegisteredModelsAlias("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callMlMlflowApiMlflowRegisteredModelsAlias_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callMlMlflowApiMlflowRegisteredModelsAlias(
                        "group/sub/project",
                        GitLabProjectProjectsCallMlMlflowApiMlflowRegisteredModelsAliasFilterBuilder.builder()
                                .name("name")
                                .alias("alias")
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("name", "name");
    }

    @Test
    void createMlMlflowApiMlflowRun_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabMlMlflowRun.class, "ml-mlflow-run.json")));

        final GitLabMlMlflowRun result = api().createMlMlflowApiMlflowRun(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowRunPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowRun());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/create");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"experiment_id\":");
        });
    }

    @Test
    void createMlMlflowApiMlflowRun_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createMlMlflowApiMlflowRun(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowRunPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getMlMlflowApiMlflowRunsGet_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabMlMlflowRun.class, "ml-mlflow-run.json")));

        final GitLabMlMlflowRun result = api().getMlMlflowApiMlflowRunsGet("group/sub/project", "run_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowRun());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/get");
            softly.assertThat(request.uri()).hasParameter("run_id", "run_id");
        });
    }

    @Test
    void getMlMlflowApiMlflowRunsGet_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getMlMlflowApiMlflowRunsGet("group/sub/project", "run_id"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getMlMlflowApiMlflowRunsGet_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabMlMlflowRun.class, "ml-mlflow-run.json")));

        api().getMlMlflowApiMlflowRunsGet(
                        "group/sub/project",
                        "run_id",
                        GitLabProjectProjectsGetMlMlflowApiMlflowRunsGetFilterBuilder.builder()
                                .runUuid("run_uuid")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("run_uuid", "run_uuid");
    }

    @Test
    void searchMlMlflowApiMlflowRun_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabMlMlflowRun.class, "ml-mlflow-run.json")));

        final GitLabMlMlflowRun result = api().searchMlMlflowApiMlflowRun(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowRunPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowRun());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/search");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"experiment_ids\":");
        });
    }

    @Test
    void searchMlMlflowApiMlflowRun_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().searchMlMlflowApiMlflowRun(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowRunPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateMlMlflowApiMlflowRun_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabMlMlflowUpdateRun.class, "ml-mlflow-update-run.json")));

        final GitLabMlMlflowUpdateRun result = api().updateMlMlflowApiMlflowRun(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsUpdateMlMlflowApiMlflowRunPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowUpdateRun());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/update");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"run_id\":");
        });
    }

    @Test
    void updateMlMlflowApiMlflowRun_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateMlMlflowApiMlflowRun(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsUpdateMlMlflowApiMlflowRunPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void logMetricMlMlflowApiMlflowRun_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().logMetricMlMlflowApiMlflowRun(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsLogMetricMlMlflowApiMlflowRunPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/log-metric");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"run_id\":");
        });
    }

    @Test
    void logMetricMlMlflowApiMlflowRun_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().logMetricMlMlflowApiMlflowRun(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsLogMetricMlMlflowApiMlflowRunPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void logParameterMlMlflowApiMlflowRun_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().logParameterMlMlflowApiMlflowRun(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsLogParameterMlMlflowApiMlflowRunPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "POST /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/log-parameter");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"run_id\":");
        });
    }

    @Test
    void logParameterMlMlflowApiMlflowRun_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().logParameterMlMlflowApiMlflowRun(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsLogParameterMlMlflowApiMlflowRunPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void setTagMlMlflowApiMlflowRun_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().setTagMlMlflowApiMlflowRun(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsSetTagMlMlflowApiMlflowRunPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/set-tag");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"run_id\":");
        });
    }

    @Test
    void setTagMlMlflowApiMlflowRun_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().setTagMlMlflowApiMlflowRun(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsSetTagMlMlflowApiMlflowRunPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void logBatchMlMlflowApiMlflowRun_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().logBatchMlMlflowApiMlflowRun(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/log-batch");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"run_id\":");
        });
    }

    @Test
    void logBatchMlMlflowApiMlflowRun_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().logBatchMlMlflowApiMlflowRun(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteMlMlflowApiMlflowRun_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteMlMlflowApiMlflowRun(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsDeleteMlMlflowApiMlflowRunPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/runs/delete");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"run_id\":");
        });
    }

    @Test
    void deleteMlMlflowApiMlflowRun_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteMlMlflowApiMlflowRun(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsDeleteMlMlflowApiMlflowRunPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createMlMlflowApiMlflowModelVersion_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabMlMlflowModelVersion.class, "ml-mlflow-model-version.json")));

        final GitLabMlMlflowModelVersion result = api().createMlMlflowApiMlflowModelVersion(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowModelVersionPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowModelVersion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "POST /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/model-versions/create");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void createMlMlflowApiMlflowModelVersion_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createMlMlflowApiMlflowModelVersion(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowModelVersionPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getMlMlflowApiMlflowModelVersionsGetDownloadUri_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabMlMlflowGetDownload.class, "ml-mlflow-get-download.json")));

        final GitLabMlMlflowGetDownload result =
                api().getMlMlflowApiMlflowModelVersionsGetDownloadUri("group/sub/project", "name", 1);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowGetDownload());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/model-versions/get-download-uri");
            softly.assertThat(request.uri()).hasParameter("name", "name");
        });
    }

    @Test
    void getMlMlflowApiMlflowModelVersionsGetDownloadUri_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().getMlMlflowApiMlflowModelVersionsGetDownloadUri("group/sub/project", "name", 1));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getMlMlflowApiMlflowModelVersionsGet_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabMlMlflowModelVersion.class, "ml-mlflow-model-version.json")));

        final GitLabMlMlflowModelVersion result =
                api().getMlMlflowApiMlflowModelVersionsGet("group/sub/project", "name", "version");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowModelVersion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/model-versions/get");
            softly.assertThat(request.uri()).hasParameter("name", "name");
        });
    }

    @Test
    void getMlMlflowApiMlflowModelVersionsGet_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().getMlMlflowApiMlflowModelVersionsGet("group/sub/project", "name", "version"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateMlMlflowApiMlflowModelVersion_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabMlMlflowModelVersion.class, "ml-mlflow-model-version.json")));

        final GitLabMlMlflowModelVersion result = api().updateMlMlflowApiMlflowModelVersion(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsUpdateMlMlflowApiMlflowModelVersionPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowModelVersion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "PATCH /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/model-versions/update");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void updateMlMlflowApiMlflowModelVersion_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateMlMlflowApiMlflowModelVersion(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsUpdateMlMlflowApiMlflowModelVersionPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getMlMlflowApiMlflowMetricsGetHistory_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabMlMlflowGetMetricHistory.class, "ml-mlflow-get-metric-history.json")));

        final GitLabMlMlflowGetMetricHistory result =
                api().getMlMlflowApiMlflowMetricsGetHistory("group/sub/project", "run_id", "metric_key");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowGetMetricHistory());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/metrics/get-history");
            softly.assertThat(request.uri()).hasParameter("run_id", "run_id");
        });
    }

    @Test
    void getMlMlflowApiMlflowMetricsGetHistory_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().getMlMlflowApiMlflowMetricsGetHistory("group/sub/project", "run_id", "metric_key"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getMlMlflowApiMlflowMetricsGetHistory_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabMlMlflowGetMetricHistory.class, "ml-mlflow-get-metric-history.json")));

        api().getMlMlflowApiMlflowMetricsGetHistory(
                        "group/sub/project",
                        "run_id",
                        "metric_key",
                        GitLabProjectProjectsGetMlMlflowApiMlflowMetricsGetHistoryFilterBuilder.builder()
                                .maxResults(1)
                                .pageToken("page_token")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("max_results", "1");
    }

    @Test
    void getMlMlflowApiMlflowExperimentsGet_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabMlMlflowGetExperiment.class, "ml-mlflow-get-experiment.json")));

        final GitLabMlMlflowGetExperiment result = api().getMlMlflowApiMlflowExperimentsGet("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowGetExperiment());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/get");
        });
    }

    @Test
    void getMlMlflowApiMlflowExperimentsGet_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getMlMlflowApiMlflowExperimentsGet("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getMlMlflowApiMlflowExperimentsGet_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabMlMlflowGetExperiment.class, "ml-mlflow-get-experiment.json")));

        api().getMlMlflowApiMlflowExperimentsGet(
                        "group/sub/project",
                        GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetFilterBuilder.builder()
                                .experimentId("experiment_id")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("experiment_id", "experiment_id");
    }

    @Test
    void getMlMlflowApiMlflowExperimentsGetByName_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabMlMlflowGetExperiment.class, "ml-mlflow-get-experiment.json")));

        final GitLabMlMlflowGetExperiment result = api().getMlMlflowApiMlflowExperimentsGetByName("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowGetExperiment());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/get-by-name");
        });
    }

    @Test
    void getMlMlflowApiMlflowExperimentsGetByName_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().getMlMlflowApiMlflowExperimentsGetByName("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getMlMlflowApiMlflowExperimentsGetByName_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabMlMlflowGetExperiment.class, "ml-mlflow-get-experiment.json")));

        api().getMlMlflowApiMlflowExperimentsGetByName(
                        "group/sub/project",
                        GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsGetByNameFilterBuilder.builder()
                                .experimentName("experiment_name")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("experiment_name", "experiment_name");
    }

    @Test
    void getMlMlflowApiMlflowExperimentsList_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabMlMlflowListExperiment.class, "ml-mlflow-list-experiment.json")));

        final GitLabMlMlflowListExperiment result = api().getMlMlflowApiMlflowExperimentsList("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowListExperiment());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/list");
        });
    }

    @Test
    void getMlMlflowApiMlflowExperimentsList_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getMlMlflowApiMlflowExperimentsList("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getMlMlflowApiMlflowExperimentsList_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabMlMlflowListExperiment.class, "ml-mlflow-list-experiment.json")));

        api().getMlMlflowApiMlflowExperimentsList(
                        "group/sub/project",
                        GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilterBuilder.builder()
                                .maxResults(1)
                                .pageToken("page_token")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("max_results", "1");
    }

    @Test
    void searchMlMlflowApiMlflowExperiment_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabMlMlflowListExperiment.class, "ml-mlflow-list-experiment.json")));

        final GitLabMlMlflowListExperiment result = api().searchMlMlflowApiMlflowExperiment(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowExperimentPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowListExperiment());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "POST /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/search");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"max_results\":");
        });
    }

    @Test
    void searchMlMlflowApiMlflowExperiment_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().searchMlMlflowApiMlflowExperiment(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsSearchMlMlflowApiMlflowExperimentPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createMlMlflowApiMlflowExperiment_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabMlMlflowNewExperiment.class, "ml-mlflow-new-experiment.json")));

        final GitLabMlMlflowNewExperiment result = api().createMlMlflowApiMlflowExperiment(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowExperimentPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.mlMlflowNewExperiment());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "POST /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/create");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void createMlMlflowApiMlflowExperiment_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createMlMlflowApiMlflowExperiment(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsCreateMlMlflowApiMlflowExperimentPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void setExperimentTagMlMlflowApiMlflowExperiment_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().setExperimentTagMlMlflowApiMlflowExperiment(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "POST /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/set-experiment-tag");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"experiment_id\":");
        });
    }

    @Test
    void setExperimentTagMlMlflowApiMlflowExperiment_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().setExperimentTagMlMlflowApiMlflowExperiment(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsSetExperimentTagMlMlflowApiMlflowExperimentPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteMlMlflowApiMlflowExperiment_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteMlMlflowApiMlflowExperiment(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsDeleteMlMlflowApiMlflowExperimentPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "POST /api/v4/projects/group%2Fsub%2Fproject/ml/mlflow/api/2.0/mlflow/experiments/delete");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"experiment_id\":");
        });
    }

    @Test
    void deleteMlMlflowApiMlflowExperiment_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteMlMlflowApiMlflowExperiment(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsDeleteMlMlflowApiMlflowExperimentPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listRepositoryStorageMoves_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabProjectRepositoryStorageMove.class,
                                        "project-repository-storage-move.json")
                                + "]"));

        final GitLabPage<GitLabProjectRepositoryStorageMove> page =
                api().listRepositoryStorageMoves("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.projectRepositoryStorageMove());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository_storage_moves");
        });
    }

    @Test
    void listRepositoryStorageMoves_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabProjectRepositoryStorageMove.class,
                                        "project-repository-storage-move.json")
                                + "]"));

        final GitLabPage<GitLabProjectRepositoryStorageMove> page =
                api().listRepositoryStorageMoves("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.projectRepositoryStorageMove());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository_storage_moves");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createRepositoryStorageMove_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabProjectRepositoryStorageMove.class, "project-repository-storage-move.json")));

        final GitLabProjectRepositoryStorageMove result = api().createRepositoryStorageMove(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsCreateRepositoryStorageMovePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.projectRepositoryStorageMove());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/repository_storage_moves");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"destination_storage_name\":");
        });
    }

    @Test
    void createRepositoryStorageMove_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createRepositoryStorageMove(
                        "group/sub/project",
                        ProjectsCatalogFixtures.projectProjectsCreateRepositoryStorageMovePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getRepositoryStorageMove_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabProjectRepositoryStorageMove.class, "project-repository-storage-move.json")));

        final Optional<GitLabProjectRepositoryStorageMove> result =
                api().getRepositoryStorageMove("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.projectRepositoryStorageMove());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository_storage_moves/1");
        });
    }

    @Test
    void getRepositoryStorageMove_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabProjectRepositoryStorageMove> result =
                api().getRepositoryStorageMove("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void restore_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabProject.class, "project.json")));

        final GitLabProject result = api().restore("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.project());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/restore");
        });
    }

    @Test
    void restore_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().restore("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabProjectWithAccess.class, "project-with-access.json") + "]"));

        final GitLabPage<GitLabProjectWithAccess> page = api().list();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.projectWithAccess());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/projects");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabProjectWithAccess.class, "project-with-access.json") + "]"));

        final GitLabPage<GitLabProjectWithAccess> page = api().list(GitLabProjectProjectsListFilterBuilder.builder()
                .archived(true)
                .visibility(GitLabProjectProjectsListVisibility.PRIVATE)
                .search("search")
                .searchNamespaces(true)
                .owned(true)
                .starred(true)
                .imported(true)
                .membership(true)
                .withIssuesEnabled(true)
                .withMergeRequestsEnabled(true)
                .withProgrammingLanguage("with_programming_language")
                .minAccessLevel(GitLabProjectProjectsListMinAccessLevel.GUEST)
                .idAfter(1)
                .idBefore(1)
                .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .repositoryStorage("repository_storage")
                .topic(List.of("topic"))
                .topicId(1L)
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .includePendingDelete(true)
                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                .active(true)
                .wikiChecksumFailed(true)
                .repositoryChecksumFailed(true)
                .includeHidden(true)
                .simple(true)
                .statistics(true)
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.projectWithAccess());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/projects");
            softly.assertThat(request.uri()).hasParameter("archived", "true");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabProjectWithAccess.class, "project-with-access.json") + "]"));

        final GitLabPage<GitLabProjectWithAccess> page = api().list(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.projectWithAccess());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/projects");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabProjectWithAccess.class, "project-with-access.json") + "]"));

        final GitLabPage<GitLabProjectWithAccess> page = api().list(
                        GitLabProjectProjectsListFilterBuilder.builder()
                                .archived(true)
                                .visibility(GitLabProjectProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabProjectProjectsListMinAccessLevel.GUEST)
                                .idAfter(1)
                                .idBefore(1)
                                .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .repositoryStorage("repository_storage")
                                .topic(List.of("topic"))
                                .topicId(1L)
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .includePendingDelete(true)
                                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                .active(true)
                                .wikiChecksumFailed(true)
                                .repositoryChecksumFailed(true)
                                .includeHidden(true)
                                .simple(true)
                                .statistics(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.projectWithAccess());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/projects");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("archived", "true");
        });
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabProject.class, "project.json")));

        final GitLabProject result =
                api().create(MultipartFormData.builder().text("field", "value").build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.project());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/projects");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().create(MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createUser_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabProject.class, "project.json")));

        final GitLabProject result = api().createUser(
                        1L, MultipartFormData.builder().text("field", "value").build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.project());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/projects/user/1");
        });
    }

    @Test
    void createUser_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createUser(
                        1L, MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listShareLocations_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPublicGroupDetails.class, "public-group-details.json") + "]"));

        final List<GitLabPublicGroupDetails> result = api().listShareLocations(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(ProjectsCatalogFixtures.publicGroupDetails());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/projects/1/share_locations");
        });
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabProjectWithAccessAndCatalog.class, "project-with-access-and-catalog.json")));

        final Optional<GitLabProjectWithAccessAndCatalog> result = api().get("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(ProjectsCatalogFixtures.projectWithAccessAndCatalog());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabProjectWithAccessAndCatalog> result = api().get("group/sub/project");

        assertThat(result).isEmpty();
    }

    @Test
    void get_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabProjectWithAccessAndCatalog.class, "project-with-access-and-catalog.json")));

        api().get(
                        "group/sub/project",
                        GitLabProjectProjectsGetFilterBuilder.builder()
                                .statistics(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .license(true)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("statistics", "true");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabProjectWithCatalog.class, "project-with-catalog.json")));

        final GitLabProjectWithCatalog result = api().update(
                        "group/sub/project",
                        MultipartFormData.builder().text("field", "value").build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.projectWithCatalog());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().update(
                        "group/sub/project",
                        MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callPagesAccess_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callPagesAccess("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pages_access");
    }

    @Test
    void callPagesAccess_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callPagesAccess("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void archive_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabProject.class, "project.json")));

        final GitLabProject result = api().archive("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.project());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/archive");
        });
    }

    @Test
    void archive_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().archive("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void unarchive_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabProject.class, "project.json")));

        final GitLabProject result = api().unarchive("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.project());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/unarchive");
        });
    }

    @Test
    void unarchive_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().unarchive("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getLanguages_shouldReturnTheValuesByName_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, "{\"alpha\":1.5}"));

        final Map<String, Double> result = api().getLanguages("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsOnly(Map.entry("alpha", 1.5));
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/languages");
        });
    }

    @Test
    void getLanguages_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getLanguages("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void share_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabProjectGroupLink.class, "project-group-link.json")));

        final GitLabProjectGroupLink result =
                api().share("group/sub/project", ProjectsCatalogFixtures.projectProjectsSharePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.projectGroupLink());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/share");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"group_id\":");
        });
    }

    @Test
    void share_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().share("group/sub/project", ProjectsCatalogFixtures.projectProjectsSharePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteShare_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteShare("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/share/1");
    }

    @Test
    void deleteShare_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteShare("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createImportProjectMember_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createImportProjectMember("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/import_project_members/1");
    }

    @Test
    void createImportProjectMember_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createImportProjectMember("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listUsers_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabUserBasic.class, "user-basic.json") + "]"));

        final GitLabPage<GitLabUserBasic> page = api().listUsers("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.userBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/users");
        });
    }

    @Test
    void listUsers_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabUserBasic.class, "user-basic.json") + "]"));

        final GitLabPage<GitLabUserBasic> page = api().listUsers(
                        "group/sub/project",
                        GitLabProjectProjectsListUsersFilterBuilder.builder()
                                .search("search")
                                .skipUsers(List.of(1))
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.userBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/users");
            softly.assertThat(request.uri()).hasParameter("search", "search");
        });
    }

    @Test
    void listUsers_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabUserBasic.class, "user-basic.json") + "]"));

        final GitLabPage<GitLabUserBasic> page = api().listUsers("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.userBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/users");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listUsers_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabUserBasic.class, "user-basic.json") + "]"));

        final GitLabPage<GitLabUserBasic> page = api().listUsers(
                        "group/sub/project",
                        GitLabProjectProjectsListUsersFilterBuilder.builder()
                                .search("search")
                                .skipUsers(List.of(1))
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.userBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/users");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("search", "search");
        });
    }

    @Test
    void listGroups_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPublicGroupDetails.class, "public-group-details.json") + "]"));

        final GitLabPage<GitLabPublicGroupDetails> page = api().listGroups("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.publicGroupDetails());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/groups");
        });
    }

    @Test
    void listGroups_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPublicGroupDetails.class, "public-group-details.json") + "]"));

        final GitLabPage<GitLabPublicGroupDetails> page = api().listGroups(
                        "group/sub/project",
                        GitLabProjectProjectsListGroupsFilterBuilder.builder()
                                .search("search")
                                .skipGroups(List.of(1))
                                .withShared(true)
                                .sharedVisibleOnly(true)
                                .sharedMinAccessLevel(GitLabProjectProjectsListGroupsSharedMinAccessLevel.GUEST)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.publicGroupDetails());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/groups");
            softly.assertThat(request.uri()).hasParameter("search", "search");
        });
    }

    @Test
    void listGroups_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPublicGroupDetails.class, "public-group-details.json") + "]"));

        final GitLabPage<GitLabPublicGroupDetails> page =
                api().listGroups("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.publicGroupDetails());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/groups");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listGroups_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPublicGroupDetails.class, "public-group-details.json") + "]"));

        final GitLabPage<GitLabPublicGroupDetails> page = api().listGroups(
                        "group/sub/project",
                        GitLabProjectProjectsListGroupsFilterBuilder.builder()
                                .search("search")
                                .skipGroups(List.of(1))
                                .withShared(true)
                                .sharedVisibleOnly(true)
                                .sharedMinAccessLevel(GitLabProjectProjectsListGroupsSharedMinAccessLevel.GUEST)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.publicGroupDetails());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/groups");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("search", "search");
        });
    }

    @Test
    void listInvitedGroups_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPublicGroupDetails.class, "public-group-details.json") + "]"));

        final GitLabPage<GitLabPublicGroupDetails> page = api().listInvitedGroups("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.publicGroupDetails());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/invited_groups");
        });
    }

    @Test
    void listInvitedGroups_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPublicGroupDetails.class, "public-group-details.json") + "]"));

        final GitLabPage<GitLabPublicGroupDetails> page = api().listInvitedGroups(
                        "group/sub/project",
                        GitLabProjectProjectsListInvitedGroupsFilterBuilder.builder()
                                .relation(List.of(GitLabProjectProjectsListInvitedGroupsRelation.DIRECT))
                                .search("search")
                                .minAccessLevel(GitLabProjectProjectsListInvitedGroupsMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.publicGroupDetails());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/invited_groups");
            softly.assertThat(request.uri()).hasParameter("relation", "direct");
        });
    }

    @Test
    void listInvitedGroups_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPublicGroupDetails.class, "public-group-details.json") + "]"));

        final GitLabPage<GitLabPublicGroupDetails> page =
                api().listInvitedGroups("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.publicGroupDetails());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/invited_groups");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listInvitedGroups_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPublicGroupDetails.class, "public-group-details.json") + "]"));

        final GitLabPage<GitLabPublicGroupDetails> page = api().listInvitedGroups(
                        "group/sub/project",
                        GitLabProjectProjectsListInvitedGroupsFilterBuilder.builder()
                                .relation(List.of(GitLabProjectProjectsListInvitedGroupsRelation.DIRECT))
                                .search("search")
                                .minAccessLevel(GitLabProjectProjectsListInvitedGroupsMinAccessLevel.GUEST)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.publicGroupDetails());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/invited_groups");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("relation", "direct");
        });
    }

    @Test
    void housekeeping_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().housekeeping("group/sub/project", ProjectsCatalogFixtures.projectProjectsHousekeepingPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/housekeeping");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"task\":");
        });
    }

    @Test
    void housekeeping_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().housekeeping("group/sub/project", ProjectsCatalogFixtures.projectProjectsHousekeepingPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void repositorySize_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().repositorySize("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/repository_size");
    }

    @Test
    void repositorySize_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().repositorySize("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void transfer_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabProject.class, "project.json")));

        final GitLabProject result =
                api().transfer("group/sub/project", ProjectsCatalogFixtures.projectProjectsTransferPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.project());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/transfer");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"namespace\":");
        });
    }

    @Test
    void transfer_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().transfer("group/sub/project", ProjectsCatalogFixtures.projectProjectsTransferPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listTransferLocations_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPublicGroupDetails.class, "public-group-details.json") + "]"));

        final GitLabPage<GitLabPublicGroupDetails> page = api().listTransferLocations("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.publicGroupDetails());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/transfer_locations");
        });
    }

    @Test
    void listTransferLocations_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPublicGroupDetails.class, "public-group-details.json") + "]"));

        final GitLabPage<GitLabPublicGroupDetails> page = api().listTransferLocations(
                        "group/sub/project",
                        GitLabProjectProjectsListTransferLocationsFilterBuilder.builder()
                                .search("search")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.publicGroupDetails());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/transfer_locations");
            softly.assertThat(request.uri()).hasParameter("search", "search");
        });
    }

    @Test
    void listTransferLocations_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPublicGroupDetails.class, "public-group-details.json") + "]"));

        final GitLabPage<GitLabPublicGroupDetails> page =
                api().listTransferLocations("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.publicGroupDetails());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/transfer_locations");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listTransferLocations_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPublicGroupDetails.class, "public-group-details.json") + "]"));

        final GitLabPage<GitLabPublicGroupDetails> page = api().listTransferLocations(
                        "group/sub/project",
                        GitLabProjectProjectsListTransferLocationsFilterBuilder.builder()
                                .search("search")
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.publicGroupDetails());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/transfer_locations");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("search", "search");
        });
    }

    @Test
    void getStorage_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabProjectRepositoryStorage.class, "project-repository-storage.json")));

        final GitLabProjectRepositoryStorage result = api().getStorage("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.projectRepositoryStorage());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/storage");
        });
    }

    @Test
    void getStorage_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getStorage("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listAuditEvents_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listAuditEvents("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listAuditEvents_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listAuditEvents("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listAuditEvents_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAuditEvent.class, "audit-event.json") + "]"));

        final GitLabPage<GitLabAuditEvent> page = api().listAuditEvents("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.auditEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/audit_events");
        });
    }

    @Test
    void listAuditEvents_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAuditEvent.class, "audit-event.json") + "]"));

        final GitLabPage<GitLabAuditEvent> page = api().listAuditEvents(
                        "group/sub/project",
                        GitLabProjectProjectsListAuditEventsFilterBuilder.builder()
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.auditEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/audit_events");
            softly.assertThat(request.uri()).hasParameter("created_after", "2026-01-01T00:00:00Z");
        });
    }

    @Test
    void listAuditEvents_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAuditEvent.class, "audit-event.json") + "]"));

        final GitLabPage<GitLabAuditEvent> page = api().listAuditEvents("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.auditEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/audit_events");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listAuditEvents_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAuditEvent.class, "audit-event.json") + "]"));

        final GitLabPage<GitLabAuditEvent> page = api().listAuditEvents(
                        "group/sub/project",
                        GitLabProjectProjectsListAuditEventsFilterBuilder.builder()
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.auditEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/audit_events");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("created_after", "2026-01-01T00:00:00Z");
        });
    }

    @Test
    void getAuditEvent_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getAuditEvent("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getAuditEvent_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectsApi lowTier =
                new GitLabProjectProjectsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getAuditEvent("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getAuditEvent_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabAuditEvent.class, "audit-event.json")));

        final Optional<GitLabAuditEvent> result = api().getAuditEvent("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.auditEvent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/audit_events/1");
        });
    }

    @Test
    void getAuditEvent_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabAuditEvent> result = api().getAuditEvent("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void getSnapshot_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        final long written = api().getSnapshot("group/sub/project", out);

        assertSoftly(softly -> {
            softly.assertThat(written).isEqualTo(3L);
            softly.assertThat(out).hasToString("abc");
        });
    }

    @Test
    void getSnapshot_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final Path target = directory.resolve("download.bin");

        final Path written = api().getSnapshot("group/sub/project", target);

        assertThat(written).hasContent("abc");
    }

    @Test
    void remoteImport_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabProjectImportStatus.class, "project-import-status.json")));

        final GitLabProjectImportStatus result = api().remoteImport(
                        MultipartFormData.builder().text("field", "value").build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.projectImportStatus());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/projects/remote-import");
        });
    }

    @Test
    void remoteImport_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().remoteImport(
                        MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void authorizeImportRelation_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().authorizeImportRelation();

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/projects/import-relation/authorize");
    }

    @Test
    void authorizeImportRelation_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().authorizeImportRelation());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void importRelation_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabRelationImportTracker.class, "relation-import-tracker.json")));

        final GitLabRelationImportTracker result = api().importRelation(
                        MultipartFormData.builder().text("field", "value").build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.relationImportTracker());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/projects/import-relation");
        });
    }

    @Test
    void importRelation_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().importRelation(
                        MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listRelationImports_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabRelationImportTracker.class, "relation-import-tracker.json")
                                + "]"));

        final List<GitLabRelationImportTracker> result = api().listRelationImports("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(ProjectsCatalogFixtures.relationImportTracker());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/relation-imports");
        });
    }

    @Test
    void remoteImportS3_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabProjectImportStatus.class, "project-import-status.json")));

        final GitLabProjectImportStatus result = api().remoteImportS3(
                        MultipartFormData.builder().text("field", "value").build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.projectImportStatus());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/projects/remote-import-s3");
        });
    }

    @Test
    void remoteImportS3_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().remoteImportS3(
                        MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getAvatar_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        final long written = api().getAvatar("group/sub/project", out);

        assertSoftly(softly -> {
            softly.assertThat(written).isEqualTo(3L);
            softly.assertThat(out).hasToString("abc");
        });
    }

    @Test
    void getAvatar_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final Path target = directory.resolve("download.bin");

        final Path written = api().getAvatar("group/sub/project", target);

        assertThat(written).hasContent("abc");
    }

    @Test
    void createCiConfig_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabMergeRequest.class, "merge-request.json")));

        final GitLabMergeRequest result = api().createCiConfig("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.mergeRequest());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/create_ci_config");
        });
    }

    @Test
    void createCiConfig_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createCiConfig("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createGithubWebhook_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createGithubWebhook(1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/projects/1/github/webhooks");
    }

    @Test
    void createGithubWebhook_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createGithubWebhook(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void pipelineTrigger_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCiPipeline.class, "ci-pipeline.json")));

        final GitLabCiPipeline result = api().pipelineTrigger(
                        "group/sub/project", ProjectsCatalogFixtures.projectProjectsPipelineTriggerPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.ciPipeline());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/trigger/pipeline");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"token\":");
        });
    }

    @Test
    void pipelineTrigger_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().pipelineTrigger(
                        "group/sub/project", ProjectsCatalogFixtures.projectProjectsPipelineTriggerPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void pipelineRefTrigger_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCiPipeline.class, "ci-pipeline.json")));

        final GitLabCiPipeline result = api().pipelineRefTrigger(
                        "group/sub/project", "ref", ProjectsCatalogFixtures.projectProjectsPipelineRefTriggerPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.ciPipeline());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/ref/ref/trigger/pipeline");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"token\":");
        });
    }

    @Test
    void pipelineRefTrigger_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().pipelineRefTrigger(
                        "group/sub/project",
                        "ref",
                        ProjectsCatalogFixtures.projectProjectsPipelineRefTriggerPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteArtifact_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteArtifact("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/artifacts");
    }

    @Test
    void deleteArtifact_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteArtifact("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void publishCatalog_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabCiCatalogResourcesVersion.class, "ci-catalog-resources-version.json")));

        final GitLabCiCatalogResourcesVersion result = api().publishCatalog(
                        "group/sub/project", ProjectsCatalogFixtures.projectProjectsPublishCatalogPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsCatalogFixtures.ciCatalogResourcesVersion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/catalog/publish");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"metadata\":");
        });
    }

    @Test
    void publishCatalog_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().publishCatalog(
                        "group/sub/project", ProjectsCatalogFixtures.projectProjectsPublishCatalogPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}

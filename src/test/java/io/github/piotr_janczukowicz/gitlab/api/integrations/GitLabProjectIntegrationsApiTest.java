package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIntegration;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIntegrationBasic;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
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
class GitLabProjectIntegrationsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectIntegrationsApi api() {
        return new GitLabProjectIntegrationsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectIntegrationsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void createSlackOption_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createSlackOption();

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/integrations/slack/options");
    }

    @Test
    void createSlackOption_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createSlackOption());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createSlackInteraction_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createSlackInteraction();

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/integrations/slack/interactions");
    }

    @Test
    void createSlackInteraction_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createSlackInteraction());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createSlackEvent_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createSlackEvent(IntegrationsCatalogFixtures.projectIntegrationsCreateSlackEventPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/integrations/slack/events");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"token\":");
        });
    }

    @Test
    void createSlackEvent_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().createSlackEvent(IntegrationsCatalogFixtures.projectIntegrationsCreateSlackEventPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listServices_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json") + "]"));

        final List<GitLabIntegrationBasic> result = api().listServices("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/services");
        });
    }

    @Test
    void appleAppStoreService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().appleAppStoreService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsAppleAppStoreServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/apple-app-store");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"app_store_issuer_id\":");
        });
    }

    @Test
    void appleAppStoreService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().appleAppStoreService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsAppleAppStoreServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void asanaService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().asanaService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsAsanaServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/asana");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"api_key\":");
        });
    }

    @Test
    void asanaService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().asanaService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsAsanaServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void assemblaService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().assemblaService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsAssemblaServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/assembla");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"token\":");
        });
    }

    @Test
    void assemblaService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().assemblaService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsAssemblaServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void bambooService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().bambooService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsBambooServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/bamboo");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"enable_ssl_verification\":");
        });
    }

    @Test
    void bambooService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().bambooService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsBambooServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void bugzillaService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().bugzillaService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsBugzillaServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/bugzilla");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_url\":");
        });
    }

    @Test
    void bugzillaService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().bugzillaService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsBugzillaServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void buildkiteService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().buildkiteService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsBuildkiteServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/buildkite");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_url\":");
        });
    }

    @Test
    void buildkiteService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().buildkiteService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsBuildkiteServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void campfireService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().campfireService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsCampfireServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/campfire");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"token\":");
        });
    }

    @Test
    void campfireService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().campfireService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsCampfireServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void confluenceService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().confluenceService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsConfluenceServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/confluence");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"confluence_url\":");
        });
    }

    @Test
    void confluenceService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().confluenceService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsConfluenceServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void customIssueTrackerService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().customIssueTrackerService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsCustomIssueTrackerServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/custom-issue-tracker");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_url\":");
        });
    }

    @Test
    void customIssueTrackerService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().customIssueTrackerService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsCustomIssueTrackerServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void datadogService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().datadogService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsDatadogServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/datadog");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"datadog_site\":");
        });
    }

    @Test
    void datadogService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().datadogService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsDatadogServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void diffblueCoverService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().diffblueCoverService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsDiffblueCoverServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/diffblue-cover");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"diffblue_license_key\":");
        });
    }

    @Test
    void diffblueCoverService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().diffblueCoverService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsDiffblueCoverServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void discordService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().discordService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/discord");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"webhook\":");
        });
    }

    @Test
    void discordService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().discordService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void droneCiService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().droneCiService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsDroneCiServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/drone-ci");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"enable_ssl_verification\":");
        });
    }

    @Test
    void droneCiService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().droneCiService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsDroneCiServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void emailsOnPushService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().emailsOnPushService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsEmailsOnPushServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/emails-on-push");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"send_from_committer_email\":");
        });
    }

    @Test
    void emailsOnPushService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().emailsOnPushService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsEmailsOnPushServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void externalWikiService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().externalWikiService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsExternalWikiServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/external-wiki");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"external_wiki_url\":");
        });
    }

    @Test
    void externalWikiService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().externalWikiService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsExternalWikiServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void gitlabSlackApplicationService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().gitlabSlackApplicationService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/gitlab-slack-application");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"channel\":");
        });
    }

    @Test
    void gitlabSlackApplicationService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().gitlabSlackApplicationService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void googlePlayService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().googlePlayService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsGooglePlayServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/google-play");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"package_name\":");
        });
    }

    @Test
    void googlePlayService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().googlePlayService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsGooglePlayServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void hangoutsChatService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().hangoutsChatService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/hangouts-chat");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"webhook\":");
        });
    }

    @Test
    void hangoutsChatService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().hangoutsChatService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void harborService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().harborService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsHarborServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/harbor");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"url\":");
        });
    }

    @Test
    void harborService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().harborService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsHarborServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void irkerService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().irkerService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsIrkerServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/irker");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"server_host\":");
        });
    }

    @Test
    void irkerService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().irkerService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsIrkerServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateServicesJenkin_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().updateServicesJenkin(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesJenkinPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/jenkins");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"enable_ssl_verification\":");
        });
    }

    @Test
    void updateServicesJenkin_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateServicesJenkin(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesJenkinPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void jiraService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().jiraService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/jira");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"url\":");
        });
    }

    @Test
    void jiraService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().jiraService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void jiraCloudAppService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().jiraCloudAppService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsJiraCloudAppServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/jira-cloud-app");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"jira_cloud_app_service_ids\":");
        });
    }

    @Test
    void jiraCloudAppService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().jiraCloudAppService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsJiraCloudAppServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void linearService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().linearService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsLinearServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/linear");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"workspace_url\":");
        });
    }

    @Test
    void linearService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().linearService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsLinearServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void matrixService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().matrixService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/matrix");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"hostname\":");
        });
    }

    @Test
    void matrixService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().matrixService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateServicesMattermostSlashCommand_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().updateServicesMattermostSlashCommand(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMattermostSlashCommandPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/mattermost-slash-commands");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"token\":");
        });
    }

    @Test
    void updateServicesMattermostSlashCommand_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateServicesMattermostSlashCommand(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMattermostSlashCommandPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void packagistService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().packagistService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPackagistServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/packagist");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"username\":");
        });
    }

    @Test
    void packagistService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().packagistService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPackagistServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void phorgeService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().phorgeService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPhorgeServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/phorge");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_url\":");
        });
    }

    @Test
    void phorgeService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().phorgeService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPhorgeServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void pipelinesEmailService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().pipelinesEmailService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/pipelines-email");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"recipients\":");
        });
    }

    @Test
    void pipelinesEmailService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().pipelinesEmailService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void pivotaltrackerService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().pivotaltrackerService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsPivotaltrackerServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/pivotaltracker");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"token\":");
        });
    }

    @Test
    void pivotaltrackerService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().pivotaltrackerService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsPivotaltrackerServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void pumbleService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().pumbleService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPumbleServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/pumble");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"webhook\":");
        });
    }

    @Test
    void pumbleService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().pumbleService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPumbleServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void pushoverService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().pushoverService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPushoverServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/pushover");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"api_key\":");
        });
    }

    @Test
    void pushoverService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().pushoverService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPushoverServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void redmineService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().redmineService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsRedmineServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/redmine");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_url\":");
        });
    }

    @Test
    void redmineService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().redmineService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsRedmineServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void ewmService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().ewmService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsEwmServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/ewm");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_url\":");
        });
    }

    @Test
    void ewmService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().ewmService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsEwmServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void youtrackService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().youtrackService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsYoutrackServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/youtrack");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_url\":");
        });
    }

    @Test
    void youtrackService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().youtrackService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsYoutrackServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void clickupService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().clickupService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsClickupServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/clickup");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_url\":");
        });
    }

    @Test
    void clickupService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().clickupService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsClickupServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void slackService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().slackService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/slack");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"webhook\":");
        });
    }

    @Test
    void slackService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().slackService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateServicesMicrosoftTeam_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().updateServicesMicrosoftTeam(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMicrosoftTeamPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/microsoft-teams");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"webhook\":");
        });
    }

    @Test
    void updateServicesMicrosoftTeam_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateServicesMicrosoftTeam(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMicrosoftTeamPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void mattermostService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().mattermostService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/mattermost");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"webhook\":");
        });
    }

    @Test
    void mattermostService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().mattermostService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void teamcityService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().teamcityService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsTeamcityServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/teamcity");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"enable_ssl_verification\":");
        });
    }

    @Test
    void teamcityService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().teamcityService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsTeamcityServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void telegramService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().telegramService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/telegram");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"hostname\":");
        });
    }

    @Test
    void telegramService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().telegramService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void unifyCircuitService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().unifyCircuitService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/unify-circuit");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"webhook\":");
        });
    }

    @Test
    void unifyCircuitService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().unifyCircuitService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateServicesWebexTeam_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().updateServicesWebexTeam(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesWebexTeamPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/webex-teams");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"webhook\":");
        });
    }

    @Test
    void updateServicesWebexTeam_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateServicesWebexTeam(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesWebexTeamPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void zentaoService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().zentaoService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsZentaoServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/zentao");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"url\":");
        });
    }

    @Test
    void zentaoService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().zentaoService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsZentaoServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void squashTmService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().squashTmService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsSquashTmServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/squash-tm");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"url\":");
        });
    }

    @Test
    void squashTmService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().squashTmService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsSquashTmServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void githubService_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectIntegrationsApi lowTier =
                new GitLabProjectIntegrationsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.githubService(
                "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsGithubServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void githubService_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectIntegrationsApi lowTier =
                new GitLabProjectIntegrationsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.githubService(
                "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsGithubServicePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void githubService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().githubService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsGithubServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/github");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"token\":");
        });
    }

    @Test
    void githubService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().githubService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsGithubServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void gitGuardianService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().gitGuardianService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsGitGuardianServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/git-guardian");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"api_url\":");
        });
    }

    @Test
    void gitGuardianService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().gitGuardianService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsGitGuardianServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void googleCloudPlatformArtifactRegistryService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().googleCloudPlatformArtifactRegistryService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectServiceGoogleCloudArtifactRegistryPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "PUT /api/v4/projects/group%2Fsub%2Fproject/services/google-cloud-platform-artifact-registry");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"artifact_registry_project_id\":");
        });
    }

    @Test
    void googleCloudPlatformArtifactRegistryService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().googleCloudPlatformArtifactRegistryService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectServiceGoogleCloudArtifactRegistryPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void googleCloudPlatformWorkloadIdentityFederationService_shouldReturnTheResource_whenResponseIsOk()
            throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().googleCloudPlatformWorkloadIdentityFederationService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectServiceGoogleCloudWorkloadIdentityFederationPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "PUT /api/v4/projects/group%2Fsub%2Fproject/services/google-cloud-platform-workload-identity-federation");
            softly.assertThat(GitLabApiTestClients.bodyText(request))
                    .contains("\"workload_identity_federation_project_id\":");
        });
    }

    @Test
    void googleCloudPlatformWorkloadIdentityFederationService_shouldThrowNotFound_whenResponseIsNotFound()
            throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().googleCloudPlatformWorkloadIdentityFederationService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectServiceGoogleCloudWorkloadIdentityFederationPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void mockCiService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().mockCiService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsMockCiServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/mock-ci");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"enable_ssl_verification\":");
        });
    }

    @Test
    void mockCiService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().mockCiService(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsMockCiServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void mockMonitoringService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().mockMonitoringService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsMockMonitoringServicePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/services/mock-monitoring");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"use_inherited_settings\":");
        });
    }

    @Test
    void mockMonitoringService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().mockMonitoringService(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsMockMonitoringServicePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabIntegration.class, "integration.json")));

        final Optional<GitLabIntegration> result =
                api().getService("group/sub/project", GitLabProjectIntegrationsGetServiceSlug.APPLE_APP_STORE);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.integration());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/services/apple-app-store");
        });
    }

    @Test
    void getService_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabIntegration> result =
                api().getService("group/sub/project", GitLabProjectIntegrationsGetServiceSlug.APPLE_APP_STORE);

        assertThat(result).isEmpty();
    }

    @Test
    void deleteService_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteService("group/sub/project", GitLabProjectIntegrationsDeleteServiceSlug.APPLE_APP_STORE);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/services/apple-app-store");
    }

    @Test
    void deleteService_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().deleteService("group/sub/project", GitLabProjectIntegrationsDeleteServiceSlug.APPLE_APP_STORE));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void triggerServicesMattermostSlashCommand_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().triggerServicesMattermostSlashCommand(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsTriggerServicesMattermostSlashCommandPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "POST /api/v4/projects/group%2Fsub%2Fproject/services/mattermost_slash_commands/trigger");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"token\":");
        });
    }

    @Test
    void triggerServicesMattermostSlashCommand_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().triggerServicesMattermostSlashCommand(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsTriggerServicesMattermostSlashCommandPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json") + "]"));

        final List<GitLabIntegrationBasic> result = api().list("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/integrations");
        });
    }

    @Test
    void appleAppStore_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().appleAppStore(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsAppleAppStorePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/apple-app-store");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"app_store_issuer_id\":");
        });
    }

    @Test
    void appleAppStore_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().appleAppStore(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsAppleAppStorePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void asana_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().asana("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsAsanaPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/asana");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"api_key\":");
        });
    }

    @Test
    void asana_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().asana("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsAsanaPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void assembla_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().assembla("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsAssemblaPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/assembla");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"token\":");
        });
    }

    @Test
    void assembla_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().assembla("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsAssemblaPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void bamboo_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().bamboo("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsBambooPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/bamboo");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"enable_ssl_verification\":");
        });
    }

    @Test
    void bamboo_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().bamboo("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsBambooPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void bugzilla_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().bugzilla("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsBugzillaPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/bugzilla");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_url\":");
        });
    }

    @Test
    void bugzilla_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().bugzilla("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsBugzillaPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void buildkite_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().buildkite("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsBuildkitePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/buildkite");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_url\":");
        });
    }

    @Test
    void buildkite_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().buildkite(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsBuildkitePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void campfire_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().campfire("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsCampfirePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/campfire");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"token\":");
        });
    }

    @Test
    void campfire_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().campfire("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsCampfirePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void confluence_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().confluence(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsConfluencePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/confluence");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"confluence_url\":");
        });
    }

    @Test
    void confluence_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().confluence(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsConfluencePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void customIssueTracker_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().customIssueTracker(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsCustomIssueTrackerPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/custom-issue-tracker");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_url\":");
        });
    }

    @Test
    void customIssueTracker_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().customIssueTracker(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsCustomIssueTrackerPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void datadog_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().datadog("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsDatadogPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/datadog");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"datadog_site\":");
        });
    }

    @Test
    void datadog_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().datadog("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsDatadogPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void diffblueCover_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().diffblueCover(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsDiffblueCoverPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/diffblue-cover");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"diffblue_license_key\":");
        });
    }

    @Test
    void diffblueCover_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().diffblueCover(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsDiffblueCoverPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void discord_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().discord("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/discord");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"webhook\":");
        });
    }

    @Test
    void discord_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().discord("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void droneCi_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().droneCi("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsDroneCiPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/drone-ci");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"enable_ssl_verification\":");
        });
    }

    @Test
    void droneCi_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().droneCi("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsDroneCiPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void emailsOnPush_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().emailsOnPush(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsEmailsOnPushPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/emails-on-push");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"send_from_committer_email\":");
        });
    }

    @Test
    void emailsOnPush_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().emailsOnPush(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsEmailsOnPushPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void externalWiki_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().externalWiki(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsExternalWikiPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/external-wiki");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"external_wiki_url\":");
        });
    }

    @Test
    void externalWiki_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().externalWiki(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsExternalWikiPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void gitlabSlackApplication_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().gitlabSlackApplication(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/gitlab-slack-application");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"channel\":");
        });
    }

    @Test
    void gitlabSlackApplication_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().gitlabSlackApplication(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void googlePlay_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().googlePlay(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsGooglePlayPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/google-play");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"package_name\":");
        });
    }

    @Test
    void googlePlay_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().googlePlay(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsGooglePlayPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void hangoutsChat_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().hangoutsChat(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/hangouts-chat");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"webhook\":");
        });
    }

    @Test
    void hangoutsChat_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().hangoutsChat(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void harbor_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().harbor("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsHarborPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/harbor");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"url\":");
        });
    }

    @Test
    void harbor_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().harbor("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsHarborPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void irker_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().irker("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsIrkerPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/irker");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"server_host\":");
        });
    }

    @Test
    void irker_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().irker("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsIrkerPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateJenkin_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().updateJenkin(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsUpdateJenkinPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/jenkins");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"enable_ssl_verification\":");
        });
    }

    @Test
    void updateJenkin_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateJenkin(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsUpdateJenkinPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void jira_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().jira("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsJiraPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/jira");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"url\":");
        });
    }

    @Test
    void jira_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().jira("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsJiraPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void jiraCloudApp_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().jiraCloudApp(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsJiraCloudAppPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/jira-cloud-app");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"jira_cloud_app_service_ids\":");
        });
    }

    @Test
    void jiraCloudApp_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().jiraCloudApp(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsJiraCloudAppPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void linear_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().linear("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsLinearPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/linear");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"workspace_url\":");
        });
    }

    @Test
    void linear_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().linear("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsLinearPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void matrix_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().matrix("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/matrix");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"hostname\":");
        });
    }

    @Test
    void matrix_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().matrix("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateMattermostSlashCommand_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().updateMattermostSlashCommand(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsUpdateMattermostSlashCommandPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/mattermost-slash-commands");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"token\":");
        });
    }

    @Test
    void updateMattermostSlashCommand_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateMattermostSlashCommand(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsUpdateMattermostSlashCommandPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void packagist_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().packagist("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPackagistPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/packagist");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"username\":");
        });
    }

    @Test
    void packagist_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().packagist(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPackagistPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void phorge_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().phorge("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPhorgePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/phorge");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_url\":");
        });
    }

    @Test
    void phorge_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().phorge("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPhorgePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void pipelinesEmail_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().pipelinesEmail(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/pipelines-email");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"recipients\":");
        });
    }

    @Test
    void pipelinesEmail_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().pipelinesEmail(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void pivotaltracker_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().pivotaltracker(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPivotaltrackerPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/pivotaltracker");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"token\":");
        });
    }

    @Test
    void pivotaltracker_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().pivotaltracker(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPivotaltrackerPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void pumble_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().pumble("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPumblePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/pumble");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"webhook\":");
        });
    }

    @Test
    void pumble_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().pumble("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPumblePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void pushover_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().pushover("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPushoverPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/pushover");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"api_key\":");
        });
    }

    @Test
    void pushover_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().pushover("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPushoverPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void redmine_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().redmine("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsRedminePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/redmine");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_url\":");
        });
    }

    @Test
    void redmine_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().redmine("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsRedminePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void ewm_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().ewm("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsEwmPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/ewm");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_url\":");
        });
    }

    @Test
    void ewm_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().ewm("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsEwmPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void youtrack_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().youtrack("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsYoutrackPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/youtrack");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_url\":");
        });
    }

    @Test
    void youtrack_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().youtrack("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsYoutrackPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void clickup_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().clickup("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsClickupPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/clickup");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_url\":");
        });
    }

    @Test
    void clickup_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().clickup("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsClickupPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void slack_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().slack("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsSlackPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/slack");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"webhook\":");
        });
    }

    @Test
    void slack_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().slack("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsSlackPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateMicrosoftTeam_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().updateMicrosoftTeam(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsUpdateMicrosoftTeamPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/microsoft-teams");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"webhook\":");
        });
    }

    @Test
    void updateMicrosoftTeam_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateMicrosoftTeam(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsUpdateMicrosoftTeamPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void mattermost_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().mattermost(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/mattermost");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"webhook\":");
        });
    }

    @Test
    void mattermost_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().mattermost(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void teamcity_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().teamcity("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsTeamcityPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/teamcity");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"enable_ssl_verification\":");
        });
    }

    @Test
    void teamcity_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().teamcity("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsTeamcityPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void telegram_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().telegram("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/telegram");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"hostname\":");
        });
    }

    @Test
    void telegram_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().telegram("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void unifyCircuit_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().unifyCircuit(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/unify-circuit");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"webhook\":");
        });
    }

    @Test
    void unifyCircuit_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().unifyCircuit(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateWebexTeam_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().updateWebexTeam(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsUpdateWebexTeamPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/webex-teams");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"webhook\":");
        });
    }

    @Test
    void updateWebexTeam_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateWebexTeam(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsUpdateWebexTeamPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void zentao_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().zentao("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsZentaoPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/zentao");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"url\":");
        });
    }

    @Test
    void zentao_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().zentao("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsZentaoPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void squashTm_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().squashTm("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsSquashTmPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/squash-tm");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"url\":");
        });
    }

    @Test
    void squashTm_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().squashTm("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsSquashTmPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void github_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectIntegrationsApi lowTier =
                new GitLabProjectIntegrationsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() ->
                lowTier.github("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsGithubPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void github_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectIntegrationsApi lowTier =
                new GitLabProjectIntegrationsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() ->
                lowTier.github("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsGithubPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void github_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().github("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsGithubPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/github");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"token\":");
        });
    }

    @Test
    void github_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().github("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsGithubPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void gitGuardian_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().gitGuardian(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsGitGuardianPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/git-guardian");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"api_url\":");
        });
    }

    @Test
    void gitGuardian_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().gitGuardian(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsGitGuardianPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void googleCloudPlatformArtifactRegistry_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().googleCloudPlatformArtifactRegistry(
                        "group/sub/project", IntegrationsCatalogFixtures.projectGoogleCloudArtifactRegistryPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/google-cloud-platform-artifact-registry");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"artifact_registry_project_id\":");
        });
    }

    @Test
    void googleCloudPlatformArtifactRegistry_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().googleCloudPlatformArtifactRegistry(
                        "group/sub/project", IntegrationsCatalogFixtures.projectGoogleCloudArtifactRegistryPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void googleCloudPlatformWorkloadIdentityFederation_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().googleCloudPlatformWorkloadIdentityFederation(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectGoogleCloudWorkloadIdentityFederationPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/google-cloud-platform-workload-identity-federation");
            softly.assertThat(GitLabApiTestClients.bodyText(request))
                    .contains("\"workload_identity_federation_project_id\":");
        });
    }

    @Test
    void googleCloudPlatformWorkloadIdentityFederation_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().googleCloudPlatformWorkloadIdentityFederation(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectGoogleCloudWorkloadIdentityFederationPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void mockCi_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().mockCi("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsMockCiPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/mock-ci");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"enable_ssl_verification\":");
        });
    }

    @Test
    void mockCi_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().mockCi("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsMockCiPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void mockMonitoring_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().mockMonitoring(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsMockMonitoringPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/integrations/mock-monitoring");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"use_inherited_settings\":");
        });
    }

    @Test
    void mockMonitoring_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().mockMonitoring(
                        "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsMockMonitoringPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabIntegration.class, "integration.json")));

        final Optional<GitLabIntegration> result =
                api().get("group/sub/project", GitLabProjectIntegrationsGetSlug.APPLE_APP_STORE);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.integration());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/integrations/apple-app-store");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabIntegration> result =
                api().get("group/sub/project", GitLabProjectIntegrationsGetSlug.APPLE_APP_STORE);

        assertThat(result).isEmpty();
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete("group/sub/project", GitLabProjectIntegrationsDeleteSlug.APPLE_APP_STORE);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/integrations/apple-app-store");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().delete("group/sub/project", GitLabProjectIntegrationsDeleteSlug.APPLE_APP_STORE));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void triggerMattermostSlashCommand_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().triggerMattermostSlashCommand(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsTriggerMattermostSlashCommandPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "POST /api/v4/projects/group%2Fsub%2Fproject/integrations/mattermost_slash_commands/trigger");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"token\":");
        });
    }

    @Test
    void triggerMattermostSlashCommand_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().triggerMattermostSlashCommand(
                        "group/sub/project",
                        IntegrationsCatalogFixtures.projectIntegrationsTriggerMattermostSlashCommandPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void triggerSlack_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().triggerSlack(IntegrationsCatalogFixtures.projectIntegrationsTriggerSlackPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/slack/trigger");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"text\":");
        });
    }

    @Test
    void triggerSlack_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().triggerSlack(IntegrationsCatalogFixtures.projectIntegrationsTriggerSlackPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}

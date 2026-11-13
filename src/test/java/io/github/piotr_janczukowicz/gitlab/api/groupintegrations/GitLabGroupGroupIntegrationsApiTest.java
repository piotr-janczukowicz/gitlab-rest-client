package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

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
class GitLabGroupGroupIntegrationsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabGroupGroupIntegrationsApi api() {
        return new GitLabGroupGroupIntegrationsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabGroupGroupIntegrationsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
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
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/integrations");
        });
    }

    @Test
    void appleAppStore_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().appleAppStore(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsAppleAppStorePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/apple-app-store");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"app_store_issuer_id\":");
        });
    }

    @Test
    void appleAppStore_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().appleAppStore(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsAppleAppStorePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void asana_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().asana("group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsAsanaPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/asana");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"api_key\":");
        });
    }

    @Test
    void asana_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().asana(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsAsanaPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void assembla_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().assembla(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsAssemblaPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/assembla");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"token\":");
        });
    }

    @Test
    void assembla_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().assembla(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsAssemblaPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void bamboo_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().bamboo(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsBambooPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/bamboo");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"enable_ssl_verification\":");
        });
    }

    @Test
    void bamboo_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().bamboo(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsBambooPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void bugzilla_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().bugzilla(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsBugzillaPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/bugzilla");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_url\":");
        });
    }

    @Test
    void bugzilla_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().bugzilla(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsBugzillaPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void buildkite_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().buildkite(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsBuildkitePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/buildkite");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_url\":");
        });
    }

    @Test
    void buildkite_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().buildkite(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsBuildkitePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void campfire_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().campfire(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsCampfirePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/campfire");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"token\":");
        });
    }

    @Test
    void campfire_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().campfire(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsCampfirePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void confluence_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().confluence(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsConfluencePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/confluence");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"confluence_url\":");
        });
    }

    @Test
    void confluence_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().confluence(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsConfluencePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void customIssueTracker_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().customIssueTracker(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsCustomIssueTrackerPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/custom-issue-tracker");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_url\":");
        });
    }

    @Test
    void customIssueTracker_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().customIssueTracker(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsCustomIssueTrackerPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void datadog_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().datadog(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsDatadogPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/datadog");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"datadog_site\":");
        });
    }

    @Test
    void datadog_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().datadog(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsDatadogPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void diffblueCover_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().diffblueCover(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiffblueCoverPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/diffblue-cover");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"diffblue_license_key\":");
        });
    }

    @Test
    void diffblueCover_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().diffblueCover(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiffblueCoverPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void discord_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().discord(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/discord");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"webhook\":");
        });
    }

    @Test
    void discord_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().discord(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void droneCi_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().droneCi(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsDroneCiPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/drone-ci");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"enable_ssl_verification\":");
        });
    }

    @Test
    void droneCi_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().droneCi(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsDroneCiPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void emailsOnPush_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().emailsOnPush(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsEmailsOnPushPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/emails-on-push");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"send_from_committer_email\":");
        });
    }

    @Test
    void emailsOnPush_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().emailsOnPush(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsEmailsOnPushPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void externalWiki_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().externalWiki(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsExternalWikiPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/external-wiki");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"external_wiki_url\":");
        });
    }

    @Test
    void externalWiki_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().externalWiki(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsExternalWikiPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void gitlabSlackApplication_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().gitlabSlackApplication(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/gitlab-slack-application");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"channel\":");
        });
    }

    @Test
    void gitlabSlackApplication_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().gitlabSlackApplication(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void googlePlay_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().googlePlay(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsGooglePlayPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/google-play");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"package_name\":");
        });
    }

    @Test
    void googlePlay_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().googlePlay(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsGooglePlayPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void hangoutsChat_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().hangoutsChat(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsHangoutsChatPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/hangouts-chat");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"webhook\":");
        });
    }

    @Test
    void hangoutsChat_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().hangoutsChat(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsHangoutsChatPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void harbor_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().harbor(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsHarborPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/harbor");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"url\":");
        });
    }

    @Test
    void harbor_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().harbor(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsHarborPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void irker_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().irker("group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsIrkerPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/irker");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"server_host\":");
        });
    }

    @Test
    void irker_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().irker(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsIrkerPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateJenkin_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().updateJenkin(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateJenkinPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/jenkins");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"enable_ssl_verification\":");
        });
    }

    @Test
    void updateJenkin_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateJenkin(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateJenkinPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void jira_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().jira("group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/jira");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"url\":");
        });
    }

    @Test
    void jira_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().jira("group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void jiraCloudApp_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().jiraCloudApp(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraCloudAppPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/jira-cloud-app");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"jira_cloud_app_service_ids\":");
        });
    }

    @Test
    void jiraCloudApp_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().jiraCloudApp(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraCloudAppPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void linear_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().linear(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsLinearPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/linear");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"workspace_url\":");
        });
    }

    @Test
    void linear_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().linear(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsLinearPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void matrix_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().matrix(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/matrix");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"hostname\":");
        });
    }

    @Test
    void matrix_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().matrix(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateMattermostSlashCommand_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().updateMattermostSlashCommand(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMattermostSlashCommandPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/mattermost-slash-commands");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"token\":");
        });
    }

    @Test
    void updateMattermostSlashCommand_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateMattermostSlashCommand(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMattermostSlashCommandPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void packagist_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().packagist(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsPackagistPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/packagist");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"username\":");
        });
    }

    @Test
    void packagist_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().packagist(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsPackagistPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void phorge_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().phorge(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsPhorgePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/phorge");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_url\":");
        });
    }

    @Test
    void phorge_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().phorge(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsPhorgePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void pipelinesEmail_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().pipelinesEmail(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsPipelinesEmailPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/pipelines-email");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"recipients\":");
        });
    }

    @Test
    void pipelinesEmail_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().pipelinesEmail(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsPipelinesEmailPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void pivotaltracker_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().pivotaltracker(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsPivotaltrackerPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/pivotaltracker");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"token\":");
        });
    }

    @Test
    void pivotaltracker_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().pivotaltracker(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsPivotaltrackerPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void pumble_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().pumble(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsPumblePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/pumble");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"webhook\":");
        });
    }

    @Test
    void pumble_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().pumble(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsPumblePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void pushover_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().pushover(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsPushoverPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/pushover");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"api_key\":");
        });
    }

    @Test
    void pushover_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().pushover(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsPushoverPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void redmine_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().redmine(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsRedminePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/redmine");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_url\":");
        });
    }

    @Test
    void redmine_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().redmine(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsRedminePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void ewm_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().ewm("group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsEwmPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/ewm");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_url\":");
        });
    }

    @Test
    void ewm_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().ewm("group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsEwmPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void youtrack_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().youtrack(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsYoutrackPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/youtrack");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_url\":");
        });
    }

    @Test
    void youtrack_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().youtrack(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsYoutrackPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void clickup_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().clickup(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsClickupPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/clickup");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_url\":");
        });
    }

    @Test
    void clickup_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().clickup(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsClickupPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void slack_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result =
                api().slack("group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/slack");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"webhook\":");
        });
    }

    @Test
    void slack_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().slack(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateMicrosoftTeam_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().updateMicrosoftTeam(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMicrosoftTeamPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/microsoft-teams");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"webhook\":");
        });
    }

    @Test
    void updateMicrosoftTeam_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateMicrosoftTeam(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMicrosoftTeamPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void mattermost_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().mattermost(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/mattermost");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"webhook\":");
        });
    }

    @Test
    void mattermost_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().mattermost(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void teamcity_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().teamcity(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsTeamcityPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/teamcity");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"enable_ssl_verification\":");
        });
    }

    @Test
    void teamcity_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().teamcity(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsTeamcityPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void telegram_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().telegram(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/telegram");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"hostname\":");
        });
    }

    @Test
    void telegram_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().telegram(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void unifyCircuit_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().unifyCircuit(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsUnifyCircuitPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/unify-circuit");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"webhook\":");
        });
    }

    @Test
    void unifyCircuit_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().unifyCircuit(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsUnifyCircuitPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateWebexTeam_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().updateWebexTeam(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateWebexTeamPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/webex-teams");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"webhook\":");
        });
    }

    @Test
    void updateWebexTeam_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateWebexTeam(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateWebexTeamPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void zentao_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().zentao(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsZentaoPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/zentao");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"url\":");
        });
    }

    @Test
    void zentao_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().zentao(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsZentaoPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void squashTm_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().squashTm(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsSquashTmPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/squash-tm");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"url\":");
        });
    }

    @Test
    void squashTm_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().squashTm(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsSquashTmPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void github_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupIntegrationsApi lowTier =
                new GitLabGroupGroupIntegrationsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.github(
                "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsGithubPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void github_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupIntegrationsApi lowTier =
                new GitLabGroupGroupIntegrationsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.github(
                "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsGithubPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void github_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().github(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsGithubPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/github");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"token\":");
        });
    }

    @Test
    void github_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().github(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsGithubPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void gitGuardian_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().gitGuardian(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitGuardianPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/git-guardian");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"api_url\":");
        });
    }

    @Test
    void gitGuardian_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().gitGuardian(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitGuardianPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void googleCloudPlatformArtifactRegistry_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().googleCloudPlatformArtifactRegistry(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGoogleCloudArtifactRegistryPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/google-cloud-platform-artifact-registry");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"artifact_registry_project_id\":");
        });
    }

    @Test
    void googleCloudPlatformArtifactRegistry_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().googleCloudPlatformArtifactRegistry(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGoogleCloudArtifactRegistryPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void googleCloudPlatformWorkloadIdentityFederation_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().googleCloudPlatformWorkloadIdentityFederation(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGoogleCloudWorkloadIdentityFederationPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/google-cloud-platform-workload-identity-federation");
            softly.assertThat(GitLabApiTestClients.bodyText(request))
                    .contains("\"workload_identity_federation_project_id\":");
        });
    }

    @Test
    void googleCloudPlatformWorkloadIdentityFederation_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().googleCloudPlatformWorkloadIdentityFederation(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGoogleCloudWorkloadIdentityFederationPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void mockCi_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().mockCi(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsMockCiPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/mock-ci");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"enable_ssl_verification\":");
        });
    }

    @Test
    void mockCi_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().mockCi(
                        "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsMockCiPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void mockMonitoring_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result = api().mockMonitoring(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsMockMonitoringPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/integrations/mock-monitoring");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"use_inherited_settings\":");
        });
    }

    @Test
    void mockMonitoring_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().mockMonitoring(
                        "group/sub/project",
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsMockMonitoringPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabIntegration.class, "integration.json")));

        final Optional<GitLabIntegration> result =
                api().get("group/sub/project", GitLabGroupGroupIntegrationsGetSlug.APPLE_APP_STORE);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.integration());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/integrations/apple-app-store");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabIntegration> result =
                api().get("group/sub/project", GitLabGroupGroupIntegrationsGetSlug.APPLE_APP_STORE);

        assertThat(result).isEmpty();
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete("group/sub/project", GitLabGroupGroupIntegrationsDeleteSlug.APPLE_APP_STORE);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/integrations/apple-app-store");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().delete("group/sub/project", GitLabGroupGroupIntegrationsDeleteSlug.APPLE_APP_STORE));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}

package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIntegration;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIntegrationBasic;
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
class GitLabProjectIntegrationsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void createSlackOption_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/integrations/slack/options", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectIntegrationsApi(GitLabCaller.of(client)).createSlackOption();
        }

        HTTP.verifyRequested(POST, "/api/v4/integrations/slack/options");
    }

    @Test
    void createSlackOption_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/integrations/slack/options", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createSlackOption());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/integrations/slack/options");
    }

    @Test
    void createSlackInteraction_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/integrations/slack/interactions", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectIntegrationsApi(GitLabCaller.of(client)).createSlackInteraction();
        }

        HTTP.verifyRequested(POST, "/api/v4/integrations/slack/interactions");
    }

    @Test
    void createSlackInteraction_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/integrations/slack/interactions", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createSlackInteraction());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/integrations/slack/interactions");
    }

    @Test
    void createSlackEvent_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/integrations/slack/events", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .createSlackEvent(IntegrationsCatalogFixtures.projectIntegrationsCreateSlackEventPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/integrations/slack/events");
    }

    @Test
    void createSlackEvent_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/integrations/slack/events", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.createSlackEvent(IntegrationsCatalogFixtures.projectIntegrationsCreateSlackEventPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/integrations/slack/events");
    }

    @Test
    void listServices_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/services",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json") + "]"));

        final List<GitLabIntegrationBasic> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client)).listServices("group/sub/project");
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/services");
    }

    @Test
    void appleAppStoreService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/apple-app-store",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .appleAppStoreService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsAppleAppStoreServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/apple-app-store");
    }

    @Test
    void appleAppStoreService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/apple-app-store",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.appleAppStoreService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsAppleAppStoreServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/apple-app-store");
    }

    @Test
    void asanaService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/asana",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .asanaService(
                            "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsAsanaServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/asana");
    }

    @Test
    void asanaService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/asana", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.asanaService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsAsanaServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/asana");
    }

    @Test
    void assemblaService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/assembla",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .assemblaService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsAssemblaServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/assembla");
    }

    @Test
    void assemblaService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/assembla", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.assemblaService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsAssemblaServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/assembla");
    }

    @Test
    void bambooService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/bamboo",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .bambooService(
                            "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsBambooServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/bamboo");
    }

    @Test
    void bambooService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/bamboo", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.bambooService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsBambooServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/bamboo");
    }

    @Test
    void bugzillaService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/bugzilla",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .bugzillaService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsBugzillaServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/bugzilla");
    }

    @Test
    void bugzillaService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/bugzilla", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.bugzillaService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsBugzillaServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/bugzilla");
    }

    @Test
    void buildkiteService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/buildkite",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .buildkiteService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsBuildkiteServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/buildkite");
    }

    @Test
    void buildkiteService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/buildkite", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.buildkiteService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsBuildkiteServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/buildkite");
    }

    @Test
    void campfireService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/campfire",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .campfireService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsCampfireServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/campfire");
    }

    @Test
    void campfireService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/campfire", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.campfireService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsCampfireServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/campfire");
    }

    @Test
    void confluenceService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/confluence",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .confluenceService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsConfluenceServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/confluence");
    }

    @Test
    void confluenceService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/confluence", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.confluenceService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsConfluenceServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/confluence");
    }

    @Test
    void customIssueTrackerService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/custom-issue-tracker",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .customIssueTrackerService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsCustomIssueTrackerServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/custom-issue-tracker");
    }

    @Test
    void customIssueTrackerService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/custom-issue-tracker",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.customIssueTrackerService(
                    "group/sub/project",
                    IntegrationsCatalogFixtures.projectIntegrationsCustomIssueTrackerServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/custom-issue-tracker");
    }

    @Test
    void datadogService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/datadog",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .datadogService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsDatadogServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/datadog");
    }

    @Test
    void datadogService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/datadog", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.datadogService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsDatadogServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/datadog");
    }

    @Test
    void diffblueCoverService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/diffblue-cover",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .diffblueCoverService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsDiffblueCoverServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/diffblue-cover");
    }

    @Test
    void diffblueCoverService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/diffblue-cover", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.diffblueCoverService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsDiffblueCoverServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/diffblue-cover");
    }

    @Test
    void discordService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/discord",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .discordService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/discord");
    }

    @Test
    void discordService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/discord", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.discordService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsDiscordServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/discord");
    }

    @Test
    void droneCiService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/drone-ci",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .droneCiService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsDroneCiServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/drone-ci");
    }

    @Test
    void droneCiService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/drone-ci", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.droneCiService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsDroneCiServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/drone-ci");
    }

    @Test
    void emailsOnPushService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/emails-on-push",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .emailsOnPushService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsEmailsOnPushServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/emails-on-push");
    }

    @Test
    void emailsOnPushService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/emails-on-push", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.emailsOnPushService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsEmailsOnPushServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/emails-on-push");
    }

    @Test
    void externalWikiService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/external-wiki",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .externalWikiService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsExternalWikiServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/external-wiki");
    }

    @Test
    void externalWikiService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/external-wiki", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.externalWikiService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsExternalWikiServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/external-wiki");
    }

    @Test
    void gitlabSlackApplicationService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/gitlab-slack-application",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .gitlabSlackApplicationService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/gitlab-slack-application");
    }

    @Test
    void gitlabSlackApplicationService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/gitlab-slack-application",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.gitlabSlackApplicationService(
                    "group/sub/project",
                    IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/gitlab-slack-application");
    }

    @Test
    void googlePlayService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/google-play",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .googlePlayService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsGooglePlayServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/google-play");
    }

    @Test
    void googlePlayService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/google-play", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.googlePlayService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsGooglePlayServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/google-play");
    }

    @Test
    void hangoutsChatService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/hangouts-chat",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .hangoutsChatService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/hangouts-chat");
    }

    @Test
    void hangoutsChatService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/hangouts-chat", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.hangoutsChatService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/hangouts-chat");
    }

    @Test
    void harborService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/harbor",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .harborService(
                            "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsHarborServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/harbor");
    }

    @Test
    void harborService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/harbor", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.harborService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsHarborServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/harbor");
    }

    @Test
    void irkerService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/irker",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .irkerService(
                            "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsIrkerServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/irker");
    }

    @Test
    void irkerService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/irker", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.irkerService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsIrkerServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/irker");
    }

    @Test
    void updateServicesJenkin_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/jenkins",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .updateServicesJenkin(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesJenkinPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/jenkins");
    }

    @Test
    void updateServicesJenkin_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/jenkins", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateServicesJenkin(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesJenkinPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/jenkins");
    }

    @Test
    void jiraService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/jira",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .jiraService(
                            "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/jira");
    }

    @Test
    void jiraService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/jira", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.jiraService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/jira");
    }

    @Test
    void jiraCloudAppService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/jira-cloud-app",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .jiraCloudAppService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsJiraCloudAppServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/jira-cloud-app");
    }

    @Test
    void jiraCloudAppService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/jira-cloud-app", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.jiraCloudAppService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsJiraCloudAppServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/jira-cloud-app");
    }

    @Test
    void linearService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/linear",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .linearService(
                            "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsLinearServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/linear");
    }

    @Test
    void linearService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/linear", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.linearService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsLinearServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/linear");
    }

    @Test
    void matrixService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/matrix",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .matrixService(
                            "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/matrix");
    }

    @Test
    void matrixService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/matrix", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.matrixService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsMatrixServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/matrix");
    }

    @Test
    void updateServicesMattermostSlashCommand_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/mattermost-slash-commands",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .updateServicesMattermostSlashCommand(
                            "group/sub/project",
                            IntegrationsCatalogFixtures
                                    .projectIntegrationsUpdateServicesMattermostSlashCommandPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/mattermost-slash-commands");
    }

    @Test
    void updateServicesMattermostSlashCommand_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/mattermost-slash-commands",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateServicesMattermostSlashCommand(
                    "group/sub/project",
                    IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMattermostSlashCommandPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/mattermost-slash-commands");
    }

    @Test
    void packagistService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/packagist",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .packagistService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsPackagistServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/packagist");
    }

    @Test
    void packagistService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/packagist", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.packagistService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPackagistServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/packagist");
    }

    @Test
    void phorgeService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/phorge",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .phorgeService(
                            "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPhorgeServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/phorge");
    }

    @Test
    void phorgeService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/phorge", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.phorgeService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPhorgeServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/phorge");
    }

    @Test
    void pipelinesEmailService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/pipelines-email",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .pipelinesEmailService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/pipelines-email");
    }

    @Test
    void pipelinesEmailService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/pipelines-email",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.pipelinesEmailService(
                    "group/sub/project",
                    IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/pipelines-email");
    }

    @Test
    void pivotaltrackerService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/pivotaltracker",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .pivotaltrackerService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsPivotaltrackerServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/pivotaltracker");
    }

    @Test
    void pivotaltrackerService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/pivotaltracker", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.pivotaltrackerService(
                    "group/sub/project",
                    IntegrationsCatalogFixtures.projectIntegrationsPivotaltrackerServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/pivotaltracker");
    }

    @Test
    void pumbleService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/pumble",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .pumbleService(
                            "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPumbleServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/pumble");
    }

    @Test
    void pumbleService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/pumble", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.pumbleService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPumbleServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/pumble");
    }

    @Test
    void pushoverService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/pushover",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .pushoverService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsPushoverServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/pushover");
    }

    @Test
    void pushoverService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/pushover", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.pushoverService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPushoverServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/pushover");
    }

    @Test
    void redmineService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/redmine",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .redmineService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsRedmineServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/redmine");
    }

    @Test
    void redmineService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/redmine", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.redmineService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsRedmineServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/redmine");
    }

    @Test
    void ewmService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/ewm",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .ewmService(
                            "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsEwmServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/ewm");
    }

    @Test
    void ewmService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/ewm", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.ewmService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsEwmServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/ewm");
    }

    @Test
    void youtrackService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/youtrack",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .youtrackService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsYoutrackServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/youtrack");
    }

    @Test
    void youtrackService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/youtrack", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.youtrackService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsYoutrackServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/youtrack");
    }

    @Test
    void clickupService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/clickup",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .clickupService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsClickupServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/clickup");
    }

    @Test
    void clickupService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/clickup", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.clickupService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsClickupServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/clickup");
    }

    @Test
    void slackService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/slack",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .slackService(
                            "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/slack");
    }

    @Test
    void slackService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/slack", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.slackService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsSlackServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/slack");
    }

    @Test
    void updateServicesMicrosoftTeam_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/microsoft-teams",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .updateServicesMicrosoftTeam(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMicrosoftTeamPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/microsoft-teams");
    }

    @Test
    void updateServicesMicrosoftTeam_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/microsoft-teams",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateServicesMicrosoftTeam(
                    "group/sub/project",
                    IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMicrosoftTeamPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/microsoft-teams");
    }

    @Test
    void mattermostService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/mattermost",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .mattermostService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/mattermost");
    }

    @Test
    void mattermostService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/mattermost", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.mattermostService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsMattermostServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/mattermost");
    }

    @Test
    void teamcityService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/teamcity",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .teamcityService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsTeamcityServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/teamcity");
    }

    @Test
    void teamcityService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/teamcity", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.teamcityService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsTeamcityServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/teamcity");
    }

    @Test
    void telegramService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/telegram",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .telegramService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/telegram");
    }

    @Test
    void telegramService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/telegram", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.telegramService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsTelegramServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/telegram");
    }

    @Test
    void unifyCircuitService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/unify-circuit",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .unifyCircuitService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/unify-circuit");
    }

    @Test
    void unifyCircuitService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/unify-circuit", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.unifyCircuitService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/unify-circuit");
    }

    @Test
    void updateServicesWebexTeam_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/webex-teams",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .updateServicesWebexTeam(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesWebexTeamPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/webex-teams");
    }

    @Test
    void updateServicesWebexTeam_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/webex-teams", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateServicesWebexTeam(
                    "group/sub/project",
                    IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesWebexTeamPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/webex-teams");
    }

    @Test
    void zentaoService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/zentao",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .zentaoService(
                            "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsZentaoServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/zentao");
    }

    @Test
    void zentaoService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/zentao", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.zentaoService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsZentaoServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/zentao");
    }

    @Test
    void squashTmService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/squash-tm",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .squashTmService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsSquashTmServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/squash-tm");
    }

    @Test
    void squashTmService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/squash-tm", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.squashTmService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsSquashTmServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/squash-tm");
    }

    @Test
    void githubService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/github",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .githubService(
                            "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsGithubServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/github");
    }

    @Test
    void githubService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/github", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.githubService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsGithubServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/github");
    }

    @Test
    void gitGuardianService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/git-guardian",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .gitGuardianService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsGitGuardianServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/git-guardian");
    }

    @Test
    void gitGuardianService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/git-guardian", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.gitGuardianService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsGitGuardianServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/git-guardian");
    }

    @Test
    void googleCloudPlatformArtifactRegistryService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/google-cloud-platform-artifact-registry",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .googleCloudPlatformArtifactRegistryService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectServiceGoogleCloudArtifactRegistryPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/google-cloud-platform-artifact-registry");
    }

    @Test
    void googleCloudPlatformArtifactRegistryService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/google-cloud-platform-artifact-registry",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.googleCloudPlatformArtifactRegistryService(
                    "group/sub/project",
                    IntegrationsCatalogFixtures.projectServiceGoogleCloudArtifactRegistryPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/google-cloud-platform-artifact-registry");
    }

    @Test
    void googleCloudPlatformWorkloadIdentityFederationService_shouldReturnTheResource_whenResponseIsOk()
            throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/google-cloud-platform-workload-identity-federation",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .googleCloudPlatformWorkloadIdentityFederationService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectServiceGoogleCloudWorkloadIdentityFederationPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/google-cloud-platform-workload-identity-federation");
    }

    @Test
    void googleCloudPlatformWorkloadIdentityFederationService_shouldAnswerNotFound_whenResponseIsNotFound()
            throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/google-cloud-platform-workload-identity-federation",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.googleCloudPlatformWorkloadIdentityFederationService(
                    "group/sub/project",
                    IntegrationsCatalogFixtures.projectServiceGoogleCloudWorkloadIdentityFederationPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/google-cloud-platform-workload-identity-federation");
    }

    @Test
    void mockCiService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/mock-ci",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .mockCiService(
                            "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsMockCiServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/mock-ci");
    }

    @Test
    void mockCiService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/mock-ci", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.mockCiService(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsMockCiServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/mock-ci");
    }

    @Test
    void mockMonitoringService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/mock-monitoring",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .mockMonitoringService(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsMockMonitoringServicePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/mock-monitoring");
    }

    @Test
    void mockMonitoringService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/services/mock-monitoring",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.mockMonitoringService(
                    "group/sub/project",
                    IntegrationsCatalogFixtures.projectIntegrationsMockMonitoringServicePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/services/mock-monitoring");
    }

    @Test
    void getService_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/services/apple-app-store",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabIntegration.class, "integration.json")));

        final Optional<GitLabIntegration> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .getService("group/sub/project", GitLabProjectIntegrationsGetServiceSlug.APPLE_APP_STORE);
        }

        assertThat(result).contains(CommonCatalogFixtures.integration());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/services/apple-app-store");
    }

    @Test
    void getService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/services/apple-app-store",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .getService("group/sub/project", GitLabProjectIntegrationsGetServiceSlug.APPLE_APP_STORE)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/services/apple-app-store");
    }

    @Test
    void deleteService_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/services/apple-app-store",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .deleteService("group/sub/project", GitLabProjectIntegrationsDeleteServiceSlug.APPLE_APP_STORE);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/services/apple-app-store");
    }

    @Test
    void deleteService_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/services/apple-app-store",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.deleteService("group/sub/project", GitLabProjectIntegrationsDeleteServiceSlug.APPLE_APP_STORE));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/services/apple-app-store");
    }

    @Test
    void triggerServicesMattermostSlashCommand_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/services/mattermost_slash_commands/trigger",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .triggerServicesMattermostSlashCommand(
                            "group/sub/project",
                            IntegrationsCatalogFixtures
                                    .projectIntegrationsTriggerServicesMattermostSlashCommandPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/services/mattermost_slash_commands/trigger");
    }

    @Test
    void triggerServicesMattermostSlashCommand_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/services/mattermost_slash_commands/trigger",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.triggerServicesMattermostSlashCommand(
                    "group/sub/project",
                    IntegrationsCatalogFixtures.projectIntegrationsTriggerServicesMattermostSlashCommandPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/services/mattermost_slash_commands/trigger");
    }

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json") + "]"));

        final List<GitLabIntegrationBasic> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client)).list("group/sub/project");
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/integrations");
    }

    @Test
    void appleAppStore_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/apple-app-store",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .appleAppStore(
                            "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsAppleAppStorePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/apple-app-store");
    }

    @Test
    void appleAppStore_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/apple-app-store",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.appleAppStore(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsAppleAppStorePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/apple-app-store");
    }

    @Test
    void asana_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/asana",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .asana("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsAsanaPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/asana");
    }

    @Test
    void asana_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/asana", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.asana("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsAsanaPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/asana");
    }

    @Test
    void assembla_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/assembla",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .assembla("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsAssemblaPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/assembla");
    }

    @Test
    void assembla_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/assembla", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.assembla(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsAssemblaPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/assembla");
    }

    @Test
    void bamboo_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/bamboo",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .bamboo("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsBambooPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/bamboo");
    }

    @Test
    void bamboo_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/bamboo", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.bamboo("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsBambooPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/bamboo");
    }

    @Test
    void bugzilla_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/bugzilla",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .bugzilla("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsBugzillaPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/bugzilla");
    }

    @Test
    void bugzilla_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/bugzilla", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.bugzilla(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsBugzillaPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/bugzilla");
    }

    @Test
    void buildkite_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/buildkite",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .buildkite("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsBuildkitePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/buildkite");
    }

    @Test
    void buildkite_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/buildkite", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.buildkite(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsBuildkitePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/buildkite");
    }

    @Test
    void campfire_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/campfire",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .campfire("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsCampfirePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/campfire");
    }

    @Test
    void campfire_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/campfire", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.campfire(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsCampfirePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/campfire");
    }

    @Test
    void confluence_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/confluence",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .confluence(
                            "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsConfluencePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/confluence");
    }

    @Test
    void confluence_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/confluence", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.confluence(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsConfluencePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/confluence");
    }

    @Test
    void customIssueTracker_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/custom-issue-tracker",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .customIssueTracker(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsCustomIssueTrackerPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/custom-issue-tracker");
    }

    @Test
    void customIssueTracker_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/custom-issue-tracker",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.customIssueTracker(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsCustomIssueTrackerPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/custom-issue-tracker");
    }

    @Test
    void datadog_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/datadog",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .datadog("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsDatadogPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/datadog");
    }

    @Test
    void datadog_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/datadog", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.datadog("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsDatadogPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/datadog");
    }

    @Test
    void diffblueCover_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/diffblue-cover",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .diffblueCover(
                            "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsDiffblueCoverPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/diffblue-cover");
    }

    @Test
    void diffblueCover_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/diffblue-cover",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.diffblueCover(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsDiffblueCoverPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/diffblue-cover");
    }

    @Test
    void discord_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/discord",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .discord("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/discord");
    }

    @Test
    void discord_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/discord", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.discord("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsDiscordPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/discord");
    }

    @Test
    void droneCi_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/drone-ci",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .droneCi("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsDroneCiPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/drone-ci");
    }

    @Test
    void droneCi_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/drone-ci", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.droneCi("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsDroneCiPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/drone-ci");
    }

    @Test
    void emailsOnPush_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/emails-on-push",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .emailsOnPush(
                            "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsEmailsOnPushPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/emails-on-push");
    }

    @Test
    void emailsOnPush_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/emails-on-push",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.emailsOnPush(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsEmailsOnPushPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/emails-on-push");
    }

    @Test
    void externalWiki_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/external-wiki",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .externalWiki(
                            "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsExternalWikiPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/external-wiki");
    }

    @Test
    void externalWiki_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/external-wiki",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.externalWiki(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsExternalWikiPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/external-wiki");
    }

    @Test
    void gitlabSlackApplication_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/gitlab-slack-application",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .gitlabSlackApplication(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/gitlab-slack-application");
    }

    @Test
    void gitlabSlackApplication_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/gitlab-slack-application",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.gitlabSlackApplication(
                    "group/sub/project",
                    IntegrationsCatalogFixtures.projectIntegrationsGitlabSlackApplicationPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/gitlab-slack-application");
    }

    @Test
    void googlePlay_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/google-play",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .googlePlay(
                            "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsGooglePlayPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/google-play");
    }

    @Test
    void googlePlay_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/google-play",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.googlePlay(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsGooglePlayPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/google-play");
    }

    @Test
    void hangoutsChat_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/hangouts-chat",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .hangoutsChat(
                            "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/hangouts-chat");
    }

    @Test
    void hangoutsChat_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/hangouts-chat",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.hangoutsChat(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsHangoutsChatPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/hangouts-chat");
    }

    @Test
    void harbor_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/harbor",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .harbor("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsHarborPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/harbor");
    }

    @Test
    void harbor_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/harbor", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.harbor("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsHarborPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/harbor");
    }

    @Test
    void irker_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/irker",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .irker("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsIrkerPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/irker");
    }

    @Test
    void irker_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/irker", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.irker("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsIrkerPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/irker");
    }

    @Test
    void updateJenkin_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/jenkins",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .updateJenkin(
                            "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsUpdateJenkinPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/jenkins");
    }

    @Test
    void updateJenkin_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/jenkins", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateJenkin(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsUpdateJenkinPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/jenkins");
    }

    @Test
    void jira_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/jira",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .jira("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsJiraPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/jira");
    }

    @Test
    void jira_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/jira", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.jira("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsJiraPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/jira");
    }

    @Test
    void jiraCloudApp_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/jira-cloud-app",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .jiraCloudApp(
                            "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsJiraCloudAppPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/jira-cloud-app");
    }

    @Test
    void jiraCloudApp_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/jira-cloud-app",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.jiraCloudApp(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsJiraCloudAppPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/jira-cloud-app");
    }

    @Test
    void linear_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/linear",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .linear("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsLinearPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/linear");
    }

    @Test
    void linear_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/linear", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.linear("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsLinearPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/linear");
    }

    @Test
    void matrix_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/matrix",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .matrix("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/matrix");
    }

    @Test
    void matrix_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/matrix", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.matrix("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsMatrixPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/matrix");
    }

    @Test
    void updateMattermostSlashCommand_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/mattermost-slash-commands",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .updateMattermostSlashCommand(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsUpdateMattermostSlashCommandPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/mattermost-slash-commands");
    }

    @Test
    void updateMattermostSlashCommand_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/mattermost-slash-commands",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateMattermostSlashCommand(
                    "group/sub/project",
                    IntegrationsCatalogFixtures.projectIntegrationsUpdateMattermostSlashCommandPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/mattermost-slash-commands");
    }

    @Test
    void packagist_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/packagist",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .packagist("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPackagistPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/packagist");
    }

    @Test
    void packagist_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/packagist", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.packagist(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPackagistPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/packagist");
    }

    @Test
    void phorge_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/phorge",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .phorge("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPhorgePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/phorge");
    }

    @Test
    void phorge_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/phorge", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.phorge("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPhorgePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/phorge");
    }

    @Test
    void pipelinesEmail_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/pipelines-email",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .pipelinesEmail(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/pipelines-email");
    }

    @Test
    void pipelinesEmail_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/pipelines-email",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.pipelinesEmail(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPipelinesEmailPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/pipelines-email");
    }

    @Test
    void pivotaltracker_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/pivotaltracker",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .pivotaltracker(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsPivotaltrackerPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/pivotaltracker");
    }

    @Test
    void pivotaltracker_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/pivotaltracker",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.pivotaltracker(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPivotaltrackerPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/pivotaltracker");
    }

    @Test
    void pumble_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/pumble",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .pumble("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPumblePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/pumble");
    }

    @Test
    void pumble_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/pumble", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.pumble("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPumblePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/pumble");
    }

    @Test
    void pushover_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/pushover",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .pushover("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPushoverPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/pushover");
    }

    @Test
    void pushover_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/pushover", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.pushover(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsPushoverPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/pushover");
    }

    @Test
    void redmine_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/redmine",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .redmine("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsRedminePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/redmine");
    }

    @Test
    void redmine_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/redmine", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.redmine("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsRedminePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/redmine");
    }

    @Test
    void ewm_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/ewm",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .ewm("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsEwmPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/ewm");
    }

    @Test
    void ewm_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/ewm", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.ewm("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsEwmPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/ewm");
    }

    @Test
    void youtrack_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/youtrack",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .youtrack("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsYoutrackPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/youtrack");
    }

    @Test
    void youtrack_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/youtrack", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.youtrack(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsYoutrackPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/youtrack");
    }

    @Test
    void clickup_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/clickup",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .clickup("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsClickupPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/clickup");
    }

    @Test
    void clickup_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/clickup", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.clickup("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsClickupPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/clickup");
    }

    @Test
    void slack_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/slack",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .slack("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsSlackPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/slack");
    }

    @Test
    void slack_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/slack", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.slack("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsSlackPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/slack");
    }

    @Test
    void updateMicrosoftTeam_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/microsoft-teams",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .updateMicrosoftTeam(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsUpdateMicrosoftTeamPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/microsoft-teams");
    }

    @Test
    void updateMicrosoftTeam_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/microsoft-teams",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateMicrosoftTeam(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsUpdateMicrosoftTeamPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/microsoft-teams");
    }

    @Test
    void mattermost_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/mattermost",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .mattermost(
                            "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/mattermost");
    }

    @Test
    void mattermost_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/mattermost", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.mattermost(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsMattermostPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/mattermost");
    }

    @Test
    void teamcity_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/teamcity",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .teamcity("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsTeamcityPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/teamcity");
    }

    @Test
    void teamcity_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/teamcity", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.teamcity(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsTeamcityPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/teamcity");
    }

    @Test
    void telegram_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/telegram",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .telegram("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/telegram");
    }

    @Test
    void telegram_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/telegram", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.telegram(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsTelegramPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/telegram");
    }

    @Test
    void unifyCircuit_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/unify-circuit",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .unifyCircuit(
                            "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/unify-circuit");
    }

    @Test
    void unifyCircuit_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/unify-circuit",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.unifyCircuit(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsUnifyCircuitPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/unify-circuit");
    }

    @Test
    void updateWebexTeam_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/webex-teams",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .updateWebexTeam(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsUpdateWebexTeamPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/webex-teams");
    }

    @Test
    void updateWebexTeam_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/webex-teams",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateWebexTeam(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsUpdateWebexTeamPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/webex-teams");
    }

    @Test
    void zentao_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/zentao",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .zentao("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsZentaoPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/zentao");
    }

    @Test
    void zentao_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/zentao", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.zentao("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsZentaoPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/zentao");
    }

    @Test
    void squashTm_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/squash-tm",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .squashTm("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsSquashTmPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/squash-tm");
    }

    @Test
    void squashTm_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/squash-tm", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.squashTm(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsSquashTmPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/squash-tm");
    }

    @Test
    void github_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/github",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .github("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsGithubPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/github");
    }

    @Test
    void github_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/github", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.github("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsGithubPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/github");
    }

    @Test
    void gitGuardian_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/git-guardian",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .gitGuardian(
                            "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsGitGuardianPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/git-guardian");
    }

    @Test
    void gitGuardian_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/git-guardian",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.gitGuardian(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsGitGuardianPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/git-guardian");
    }

    @Test
    void googleCloudPlatformArtifactRegistry_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/google-cloud-platform-artifact-registry",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .googleCloudPlatformArtifactRegistry(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectGoogleCloudArtifactRegistryPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/google-cloud-platform-artifact-registry");
    }

    @Test
    void googleCloudPlatformArtifactRegistry_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/google-cloud-platform-artifact-registry",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.googleCloudPlatformArtifactRegistry(
                    "group/sub/project", IntegrationsCatalogFixtures.projectGoogleCloudArtifactRegistryPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/google-cloud-platform-artifact-registry");
    }

    @Test
    void googleCloudPlatformWorkloadIdentityFederation_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/google-cloud-platform-workload-identity-federation",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .googleCloudPlatformWorkloadIdentityFederation(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectGoogleCloudWorkloadIdentityFederationPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/google-cloud-platform-workload-identity-federation");
    }

    @Test
    void googleCloudPlatformWorkloadIdentityFederation_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/google-cloud-platform-workload-identity-federation",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.googleCloudPlatformWorkloadIdentityFederation(
                    "group/sub/project",
                    IntegrationsCatalogFixtures.projectGoogleCloudWorkloadIdentityFederationPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/google-cloud-platform-workload-identity-federation");
    }

    @Test
    void mockCi_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/mock-ci",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .mockCi("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsMockCiPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/mock-ci");
    }

    @Test
    void mockCi_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/mock-ci", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.mockCi("group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsMockCiPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/mock-ci");
    }

    @Test
    void mockMonitoring_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/mock-monitoring",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .mockMonitoring(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsMockMonitoringPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/mock-monitoring");
    }

    @Test
    void mockMonitoring_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/mock-monitoring",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.mockMonitoring(
                    "group/sub/project", IntegrationsCatalogFixtures.projectIntegrationsMockMonitoringPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/integrations/mock-monitoring");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/apple-app-store",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabIntegration.class, "integration.json")));

        final Optional<GitLabIntegration> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .get("group/sub/project", GitLabProjectIntegrationsGetSlug.APPLE_APP_STORE);
        }

        assertThat(result).contains(CommonCatalogFixtures.integration());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/integrations/apple-app-store");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/apple-app-store",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .get("group/sub/project", GitLabProjectIntegrationsGetSlug.APPLE_APP_STORE)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/integrations/apple-app-store");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/apple-app-store",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .delete("group/sub/project", GitLabProjectIntegrationsDeleteSlug.APPLE_APP_STORE);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/integrations/apple-app-store");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/apple-app-store",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.delete("group/sub/project", GitLabProjectIntegrationsDeleteSlug.APPLE_APP_STORE));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/integrations/apple-app-store");
    }

    @Test
    void triggerMattermostSlashCommand_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/mattermost_slash_commands/trigger",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .triggerMattermostSlashCommand(
                            "group/sub/project",
                            IntegrationsCatalogFixtures.projectIntegrationsTriggerMattermostSlashCommandPayload());
        }

        HTTP.verifyRequested(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/integrations/mattermost_slash_commands/trigger");
    }

    @Test
    void triggerMattermostSlashCommand_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/integrations/mattermost_slash_commands/trigger",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.triggerMattermostSlashCommand(
                    "group/sub/project",
                    IntegrationsCatalogFixtures.projectIntegrationsTriggerMattermostSlashCommandPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/integrations/mattermost_slash_commands/trigger");
    }

    @Test
    void triggerSlack_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/slack/trigger", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectIntegrationsApi(GitLabCaller.of(client))
                    .triggerSlack(IntegrationsCatalogFixtures.projectIntegrationsTriggerSlackPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/slack/trigger");
    }

    @Test
    void triggerSlack_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/slack/trigger", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIntegrationsApi api = new GitLabProjectIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.triggerSlack(IntegrationsCatalogFixtures.projectIntegrationsTriggerSlackPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/slack/trigger");
    }
}

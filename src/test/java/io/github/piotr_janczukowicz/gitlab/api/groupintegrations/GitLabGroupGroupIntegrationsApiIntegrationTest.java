package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
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
class GitLabGroupGroupIntegrationsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json") + "]"));

        final List<GitLabIntegrationBasic> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client)).list("group/sub/project");
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/integrations");
    }

    @Test
    void appleAppStore_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/apple-app-store",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .appleAppStore(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsAppleAppStorePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/apple-app-store");
    }

    @Test
    void appleAppStore_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/apple-app-store",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.appleAppStore(
                    "group/sub/project",
                    GroupintegrationsCatalogFixtures.groupGroupIntegrationsAppleAppStorePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/apple-app-store");
    }

    @Test
    void asana_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/asana",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .asana("group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsAsanaPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/asana");
    }

    @Test
    void asana_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/asana", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.asana(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsAsanaPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/asana");
    }

    @Test
    void assembla_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/assembla",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .assembla(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsAssemblaPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/assembla");
    }

    @Test
    void assembla_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/assembla", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.assembla(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsAssemblaPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/assembla");
    }

    @Test
    void bamboo_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/bamboo",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .bamboo(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsBambooPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/bamboo");
    }

    @Test
    void bamboo_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/bamboo", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.bamboo(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsBambooPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/bamboo");
    }

    @Test
    void bugzilla_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/bugzilla",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .bugzilla(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsBugzillaPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/bugzilla");
    }

    @Test
    void bugzilla_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/bugzilla", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.bugzilla(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsBugzillaPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/bugzilla");
    }

    @Test
    void buildkite_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/buildkite",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .buildkite(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsBuildkitePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/buildkite");
    }

    @Test
    void buildkite_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/buildkite", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.buildkite(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsBuildkitePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/buildkite");
    }

    @Test
    void campfire_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/campfire",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .campfire(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsCampfirePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/campfire");
    }

    @Test
    void campfire_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/campfire", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.campfire(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsCampfirePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/campfire");
    }

    @Test
    void confluence_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/confluence",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .confluence(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsConfluencePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/confluence");
    }

    @Test
    void confluence_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/confluence", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.confluence(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsConfluencePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/confluence");
    }

    @Test
    void customIssueTracker_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/custom-issue-tracker",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .customIssueTracker(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsCustomIssueTrackerPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/custom-issue-tracker");
    }

    @Test
    void customIssueTracker_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/custom-issue-tracker",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.customIssueTracker(
                    "group/sub/project",
                    GroupintegrationsCatalogFixtures.groupGroupIntegrationsCustomIssueTrackerPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/custom-issue-tracker");
    }

    @Test
    void datadog_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/datadog",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .datadog(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsDatadogPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/datadog");
    }

    @Test
    void datadog_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/datadog", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.datadog(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsDatadogPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/datadog");
    }

    @Test
    void diffblueCover_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/diffblue-cover",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .diffblueCover(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiffblueCoverPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/diffblue-cover");
    }

    @Test
    void diffblueCover_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/diffblue-cover",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.diffblueCover(
                    "group/sub/project",
                    GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiffblueCoverPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/diffblue-cover");
    }

    @Test
    void discord_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/discord",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .discord(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/discord");
    }

    @Test
    void discord_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/discord", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.discord(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsDiscordPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/discord");
    }

    @Test
    void droneCi_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/drone-ci",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .droneCi(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsDroneCiPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/drone-ci");
    }

    @Test
    void droneCi_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/drone-ci", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.droneCi(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsDroneCiPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/drone-ci");
    }

    @Test
    void emailsOnPush_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/emails-on-push",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .emailsOnPush(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsEmailsOnPushPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/emails-on-push");
    }

    @Test
    void emailsOnPush_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/emails-on-push",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.emailsOnPush(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsEmailsOnPushPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/emails-on-push");
    }

    @Test
    void externalWiki_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/external-wiki",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .externalWiki(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsExternalWikiPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/external-wiki");
    }

    @Test
    void externalWiki_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/external-wiki",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.externalWiki(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsExternalWikiPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/external-wiki");
    }

    @Test
    void gitlabSlackApplication_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/gitlab-slack-application",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .gitlabSlackApplication(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/gitlab-slack-application");
    }

    @Test
    void gitlabSlackApplication_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/gitlab-slack-application",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.gitlabSlackApplication(
                    "group/sub/project",
                    GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitlabSlackApplicationPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/gitlab-slack-application");
    }

    @Test
    void googlePlay_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/google-play",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .googlePlay(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsGooglePlayPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/google-play");
    }

    @Test
    void googlePlay_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/google-play", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.googlePlay(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsGooglePlayPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/google-play");
    }

    @Test
    void hangoutsChat_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/hangouts-chat",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .hangoutsChat(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsHangoutsChatPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/hangouts-chat");
    }

    @Test
    void hangoutsChat_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/hangouts-chat",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.hangoutsChat(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsHangoutsChatPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/hangouts-chat");
    }

    @Test
    void harbor_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/harbor",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .harbor(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsHarborPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/harbor");
    }

    @Test
    void harbor_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/harbor", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.harbor(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsHarborPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/harbor");
    }

    @Test
    void irker_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/irker",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .irker("group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsIrkerPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/irker");
    }

    @Test
    void irker_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/irker", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.irker(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsIrkerPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/irker");
    }

    @Test
    void updateJenkin_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/jenkins",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .updateJenkin(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateJenkinPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/jenkins");
    }

    @Test
    void updateJenkin_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/jenkins", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateJenkin(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateJenkinPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/jenkins");
    }

    @Test
    void jira_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/jira",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .jira("group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/jira");
    }

    @Test
    void jira_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/jira", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.jira(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/jira");
    }

    @Test
    void jiraCloudApp_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/jira-cloud-app",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .jiraCloudApp(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraCloudAppPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/jira-cloud-app");
    }

    @Test
    void jiraCloudApp_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/jira-cloud-app",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.jiraCloudApp(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraCloudAppPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/jira-cloud-app");
    }

    @Test
    void linear_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/linear",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .linear(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsLinearPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/linear");
    }

    @Test
    void linear_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/linear", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.linear(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsLinearPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/linear");
    }

    @Test
    void matrix_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/matrix",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .matrix(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/matrix");
    }

    @Test
    void matrix_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/matrix", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.matrix(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsMatrixPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/matrix");
    }

    @Test
    void updateMattermostSlashCommand_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/mattermost-slash-commands",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .updateMattermostSlashCommand(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures
                                    .groupGroupIntegrationsUpdateMattermostSlashCommandPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/mattermost-slash-commands");
    }

    @Test
    void updateMattermostSlashCommand_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/mattermost-slash-commands",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateMattermostSlashCommand(
                    "group/sub/project",
                    GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMattermostSlashCommandPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/mattermost-slash-commands");
    }

    @Test
    void packagist_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/packagist",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .packagist(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsPackagistPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/packagist");
    }

    @Test
    void packagist_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/packagist", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.packagist(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsPackagistPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/packagist");
    }

    @Test
    void phorge_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/phorge",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .phorge(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsPhorgePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/phorge");
    }

    @Test
    void phorge_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/phorge", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.phorge(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsPhorgePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/phorge");
    }

    @Test
    void pipelinesEmail_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/pipelines-email",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .pipelinesEmail(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsPipelinesEmailPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/pipelines-email");
    }

    @Test
    void pipelinesEmail_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/pipelines-email",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.pipelinesEmail(
                    "group/sub/project",
                    GroupintegrationsCatalogFixtures.groupGroupIntegrationsPipelinesEmailPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/pipelines-email");
    }

    @Test
    void pivotaltracker_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/pivotaltracker",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .pivotaltracker(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsPivotaltrackerPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/pivotaltracker");
    }

    @Test
    void pivotaltracker_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/pivotaltracker",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.pivotaltracker(
                    "group/sub/project",
                    GroupintegrationsCatalogFixtures.groupGroupIntegrationsPivotaltrackerPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/pivotaltracker");
    }

    @Test
    void pumble_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/pumble",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .pumble(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsPumblePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/pumble");
    }

    @Test
    void pumble_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/pumble", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.pumble(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsPumblePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/pumble");
    }

    @Test
    void pushover_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/pushover",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .pushover(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsPushoverPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/pushover");
    }

    @Test
    void pushover_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/pushover", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.pushover(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsPushoverPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/pushover");
    }

    @Test
    void redmine_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/redmine",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .redmine(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsRedminePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/redmine");
    }

    @Test
    void redmine_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/redmine", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.redmine(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsRedminePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/redmine");
    }

    @Test
    void ewm_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/ewm",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .ewm("group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsEwmPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/ewm");
    }

    @Test
    void ewm_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/ewm", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.ewm("group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsEwmPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/ewm");
    }

    @Test
    void youtrack_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/youtrack",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .youtrack(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsYoutrackPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/youtrack");
    }

    @Test
    void youtrack_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/youtrack", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.youtrack(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsYoutrackPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/youtrack");
    }

    @Test
    void clickup_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/clickup",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .clickup(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsClickupPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/clickup");
    }

    @Test
    void clickup_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/clickup", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.clickup(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsClickupPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/clickup");
    }

    @Test
    void slack_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/slack",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .slack("group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/slack");
    }

    @Test
    void slack_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/slack", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.slack(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsSlackPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/slack");
    }

    @Test
    void updateMicrosoftTeam_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/microsoft-teams",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .updateMicrosoftTeam(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMicrosoftTeamPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/microsoft-teams");
    }

    @Test
    void updateMicrosoftTeam_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/microsoft-teams",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateMicrosoftTeam(
                    "group/sub/project",
                    GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMicrosoftTeamPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/microsoft-teams");
    }

    @Test
    void mattermost_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/mattermost",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .mattermost(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/mattermost");
    }

    @Test
    void mattermost_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/mattermost", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.mattermost(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsMattermostPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/mattermost");
    }

    @Test
    void teamcity_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/teamcity",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .teamcity(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsTeamcityPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/teamcity");
    }

    @Test
    void teamcity_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/teamcity", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.teamcity(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsTeamcityPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/teamcity");
    }

    @Test
    void telegram_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/telegram",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .telegram(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/telegram");
    }

    @Test
    void telegram_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/telegram", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.telegram(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsTelegramPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/telegram");
    }

    @Test
    void unifyCircuit_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/unify-circuit",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .unifyCircuit(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsUnifyCircuitPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/unify-circuit");
    }

    @Test
    void unifyCircuit_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/unify-circuit",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.unifyCircuit(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsUnifyCircuitPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/unify-circuit");
    }

    @Test
    void updateWebexTeam_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/webex-teams",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .updateWebexTeam(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateWebexTeamPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/webex-teams");
    }

    @Test
    void updateWebexTeam_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/webex-teams", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateWebexTeam(
                    "group/sub/project",
                    GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateWebexTeamPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/webex-teams");
    }

    @Test
    void zentao_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/zentao",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .zentao(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsZentaoPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/zentao");
    }

    @Test
    void zentao_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/zentao", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.zentao(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsZentaoPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/zentao");
    }

    @Test
    void squashTm_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/squash-tm",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .squashTm(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsSquashTmPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/squash-tm");
    }

    @Test
    void squashTm_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/squash-tm", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.squashTm(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsSquashTmPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/squash-tm");
    }

    @Test
    void github_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/github",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .github(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsGithubPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/github");
    }

    @Test
    void github_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/github", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.github(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsGithubPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/github");
    }

    @Test
    void gitGuardian_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/git-guardian",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .gitGuardian(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitGuardianPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/git-guardian");
    }

    @Test
    void gitGuardian_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/git-guardian", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.gitGuardian(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitGuardianPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/git-guardian");
    }

    @Test
    void googleCloudPlatformArtifactRegistry_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/google-cloud-platform-artifact-registry",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .googleCloudPlatformArtifactRegistry(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGoogleCloudArtifactRegistryPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(
                PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/google-cloud-platform-artifact-registry");
    }

    @Test
    void googleCloudPlatformArtifactRegistry_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/google-cloud-platform-artifact-registry",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.googleCloudPlatformArtifactRegistry(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGoogleCloudArtifactRegistryPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/google-cloud-platform-artifact-registry");
    }

    @Test
    void googleCloudPlatformWorkloadIdentityFederation_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/google-cloud-platform-workload-identity-federation",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .googleCloudPlatformWorkloadIdentityFederation(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGoogleCloudWorkloadIdentityFederationPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/google-cloud-platform-workload-identity-federation");
    }

    @Test
    void googleCloudPlatformWorkloadIdentityFederation_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/google-cloud-platform-workload-identity-federation",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.googleCloudPlatformWorkloadIdentityFederation(
                    "group/sub/project",
                    GroupintegrationsCatalogFixtures.groupGoogleCloudWorkloadIdentityFederationPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/google-cloud-platform-workload-identity-federation");
    }

    @Test
    void mockCi_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/mock-ci",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .mockCi(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsMockCiPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/mock-ci");
    }

    @Test
    void mockCi_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/mock-ci", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.mockCi(
                    "group/sub/project", GroupintegrationsCatalogFixtures.groupGroupIntegrationsMockCiPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/mock-ci");
    }

    @Test
    void mockMonitoring_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/mock-monitoring",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabIntegrationBasic.class, "integration-basic.json")));

        final GitLabIntegrationBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .mockMonitoring(
                            "group/sub/project",
                            GroupintegrationsCatalogFixtures.groupGroupIntegrationsMockMonitoringPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.integrationBasic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/mock-monitoring");
    }

    @Test
    void mockMonitoring_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/mock-monitoring",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.mockMonitoring(
                    "group/sub/project",
                    GroupintegrationsCatalogFixtures.groupGroupIntegrationsMockMonitoringPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/integrations/mock-monitoring");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/apple-app-store",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabIntegration.class, "integration.json")));

        final Optional<GitLabIntegration> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .get("group/sub/project", GitLabGroupGroupIntegrationsGetSlug.APPLE_APP_STORE);
        }

        assertThat(result).contains(CommonCatalogFixtures.integration());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/integrations/apple-app-store");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/apple-app-store",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .get("group/sub/project", GitLabGroupGroupIntegrationsGetSlug.APPLE_APP_STORE)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/integrations/apple-app-store");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/apple-app-store",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client))
                    .delete("group/sub/project", GitLabGroupGroupIntegrationsDeleteSlug.APPLE_APP_STORE);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/integrations/apple-app-store");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/integrations/apple-app-store",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupIntegrationsApi api = new GitLabGroupGroupIntegrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.delete("group/sub/project", GitLabGroupGroupIntegrationsDeleteSlug.APPLE_APP_STORE));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/integrations/apple-app-store");
    }
}

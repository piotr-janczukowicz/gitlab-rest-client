package io.github.piotr_janczukowicz.gitlab.api.agents;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabClusterAgent;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectAgentsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectAgentsApi api() {
        return new GitLabProjectAgentsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectAgentsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void getUrlConfigurations_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectAgentsApi lowTier =
                new GitLabProjectAgentsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getUrlConfigurations("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getUrlConfigurations_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectAgentsApi lowTier =
                new GitLabProjectAgentsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getUrlConfigurations("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getUrlConfigurations_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabClusterAgentUrlConfiguration.class, "cluster-agent-url-configuration.json")));

        final Optional<GitLabClusterAgentUrlConfiguration> result = api().getUrlConfigurations("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(AgentsCatalogFixtures.clusterAgentUrlConfiguration());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/url_configurations");
        });
    }

    @Test
    void getUrlConfigurations_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabClusterAgentUrlConfiguration> result = api().getUrlConfigurations("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void createUrlConfiguration_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectAgentsApi lowTier =
                new GitLabProjectAgentsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createUrlConfiguration(
                "group/sub/project", 1L, AgentsCatalogFixtures.projectAgentsCreateUrlConfigurationPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createUrlConfiguration_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectAgentsApi lowTier =
                new GitLabProjectAgentsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createUrlConfiguration(
                "group/sub/project", 1L, AgentsCatalogFixtures.projectAgentsCreateUrlConfigurationPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createUrlConfiguration_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabClusterAgentUrlConfiguration.class, "cluster-agent-url-configuration.json")));

        final GitLabClusterAgentUrlConfiguration result = api().createUrlConfiguration(
                        "group/sub/project", 1L, AgentsCatalogFixtures.projectAgentsCreateUrlConfigurationPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(AgentsCatalogFixtures.clusterAgentUrlConfiguration());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/url_configurations");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"url\":");
        });
    }

    @Test
    void createUrlConfiguration_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createUrlConfiguration(
                        "group/sub/project", 1L, AgentsCatalogFixtures.projectAgentsCreateUrlConfigurationPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getUrlConfiguration_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectAgentsApi lowTier =
                new GitLabProjectAgentsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getUrlConfiguration("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getUrlConfiguration_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectAgentsApi lowTier =
                new GitLabProjectAgentsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getUrlConfiguration("group/sub/project", 1L, 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getUrlConfiguration_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabClusterAgentUrlConfiguration.class, "cluster-agent-url-configuration.json")));

        final Optional<GitLabClusterAgentUrlConfiguration> result =
                api().getUrlConfiguration("group/sub/project", 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(AgentsCatalogFixtures.clusterAgentUrlConfiguration());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/url_configurations/1");
        });
    }

    @Test
    void getUrlConfiguration_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabClusterAgentUrlConfiguration> result =
                api().getUrlConfiguration("group/sub/project", 1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void deleteUrlConfiguration_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectAgentsApi lowTier =
                new GitLabProjectAgentsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteUrlConfiguration("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void deleteUrlConfiguration_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectAgentsApi lowTier =
                new GitLabProjectAgentsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteUrlConfiguration("group/sub/project", 1L, 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void deleteUrlConfiguration_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteUrlConfiguration("group/sub/project", 1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/url_configurations/1");
    }

    @Test
    void deleteUrlConfiguration_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteUrlConfiguration("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabClusterAgent.class, "cluster-agent.json") + "]"));

        final GitLabPage<GitLabClusterAgent> page = api().list("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.clusterAgent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/cluster_agents");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabClusterAgent.class, "cluster-agent.json") + "]"));

        final GitLabPage<GitLabClusterAgent> page = api().list("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.clusterAgent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/cluster_agents");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabClusterAgent.class, "cluster-agent.json")));

        final GitLabClusterAgent result =
                api().create("group/sub/project", AgentsCatalogFixtures.projectAgentsCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.clusterAgent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/cluster_agents");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().create("group/sub/project", AgentsCatalogFixtures.projectAgentsCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabClusterAgent.class, "cluster-agent.json")));

        final Optional<GitLabClusterAgent> result = api().get("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.clusterAgent());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabClusterAgent> result = api().get("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listTokens_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabClusterAgentTokenBasic.class, "cluster-agent-token-basic.json")
                                + "]"));

        final GitLabPage<GitLabClusterAgentTokenBasic> page = api().listTokens("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(AgentsCatalogFixtures.clusterAgentTokenBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/tokens");
        });
    }

    @Test
    void listTokens_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabClusterAgentTokenBasic.class, "cluster-agent-token-basic.json")
                                + "]"));

        final GitLabPage<GitLabClusterAgentTokenBasic> page =
                api().listTokens("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(AgentsCatalogFixtures.clusterAgentTokenBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/tokens");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createToken_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabClusterAgentTokenWithToken.class, "cluster-agent-token-with-token.json")));

        final GitLabClusterAgentTokenWithToken result =
                api().createToken("group/sub/project", 1L, AgentsCatalogFixtures.projectAgentsCreateTokenPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(AgentsCatalogFixtures.clusterAgentTokenWithToken());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/tokens");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void createToken_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().createToken("group/sub/project", 1L, AgentsCatalogFixtures.projectAgentsCreateTokenPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getToken_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabClusterAgentToken.class, "cluster-agent-token.json")));

        final Optional<GitLabClusterAgentToken> result = api().getToken("group/sub/project", 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(AgentsCatalogFixtures.clusterAgentToken());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/tokens/1");
        });
    }

    @Test
    void getToken_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabClusterAgentToken> result = api().getToken("group/sub/project", 1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void deleteToken_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteToken("group/sub/project", 1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/tokens/1");
    }

    @Test
    void deleteToken_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteToken("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}

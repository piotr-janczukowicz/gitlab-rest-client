package io.github.piotr_janczukowicz.gitlab.api.agents;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabClusterAgent;
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
class GitLabProjectAgentsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void getUrlConfigurations_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/url_configurations",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabClusterAgentUrlConfiguration.class, "cluster-agent-url-configuration.json")));

        final Optional<GitLabClusterAgentUrlConfiguration> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectAgentsApi(GitLabCaller.of(client)).getUrlConfigurations("group/sub/project", 1L);
        }

        assertThat(result).contains(AgentsCatalogFixtures.clusterAgentUrlConfiguration());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/url_configurations");
    }

    @Test
    void getUrlConfigurations_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/url_configurations",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectAgentsApi(GitLabCaller.of(client))
                    .getUrlConfigurations("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/url_configurations");
    }

    @Test
    void createUrlConfiguration_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/url_configurations",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabClusterAgentUrlConfiguration.class, "cluster-agent-url-configuration.json")));

        final GitLabClusterAgentUrlConfiguration result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectAgentsApi(GitLabCaller.of(client))
                    .createUrlConfiguration(
                            "group/sub/project",
                            1L,
                            AgentsCatalogFixtures.projectAgentsCreateUrlConfigurationPayload());
        }

        assertThat(result).isEqualTo(AgentsCatalogFixtures.clusterAgentUrlConfiguration());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/url_configurations");
    }

    @Test
    void createUrlConfiguration_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/url_configurations",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectAgentsApi api = new GitLabProjectAgentsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createUrlConfiguration(
                    "group/sub/project", 1L, AgentsCatalogFixtures.projectAgentsCreateUrlConfigurationPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/url_configurations");
    }

    @Test
    void getUrlConfiguration_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/url_configurations/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabClusterAgentUrlConfiguration.class, "cluster-agent-url-configuration.json")));

        final Optional<GitLabClusterAgentUrlConfiguration> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectAgentsApi(GitLabCaller.of(client))
                    .getUrlConfiguration("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(AgentsCatalogFixtures.clusterAgentUrlConfiguration());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/url_configurations/1");
    }

    @Test
    void getUrlConfiguration_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/url_configurations/1",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectAgentsApi(GitLabCaller.of(client))
                    .getUrlConfiguration("group/sub/project", 1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/url_configurations/1");
    }

    @Test
    void deleteUrlConfiguration_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/url_configurations/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectAgentsApi(GitLabCaller.of(client)).deleteUrlConfiguration("group/sub/project", 1L, 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/url_configurations/1");
    }

    @Test
    void deleteUrlConfiguration_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/url_configurations/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectAgentsApi api = new GitLabProjectAgentsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteUrlConfiguration("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/url_configurations/1");
    }

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabClusterAgent.class, "cluster-agent.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabClusterAgent.class, "cluster-agent.json") + "]"));

        final List<GitLabClusterAgent> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectAgentsApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.clusterAgent(), CommonCatalogFixtures.clusterAgent());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabClusterAgent.class, "cluster-agent.json")));

        final GitLabClusterAgent result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectAgentsApi(GitLabCaller.of(client))
                    .create("group/sub/project", AgentsCatalogFixtures.projectAgentsCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.clusterAgent());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectAgentsApi api = new GitLabProjectAgentsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.create("group/sub/project", AgentsCatalogFixtures.projectAgentsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabClusterAgent.class, "cluster-agent.json")));

        final Optional<GitLabClusterAgent> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectAgentsApi(GitLabCaller.of(client)).get("group/sub/project", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.clusterAgent());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectAgentsApi(GitLabCaller.of(client))
                    .get("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectAgentsApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectAgentsApi api = new GitLabProjectAgentsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1");
    }

    @Test
    void listTokens_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/tokens",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(
                                        GitLabClusterAgentTokenBasic.class, "cluster-agent-token-basic.json")
                                + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/tokens?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabClusterAgentTokenBasic.class, "cluster-agent-token-basic.json")
                                + "]"));

        final List<GitLabClusterAgentTokenBasic> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectAgentsApi(GitLabCaller.of(client))
                    .listTokens("group/sub/project", 1L)
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        AgentsCatalogFixtures.clusterAgentTokenBasic(), AgentsCatalogFixtures.clusterAgentTokenBasic());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/tokens", 2);
    }

    @Test
    void createToken_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/tokens",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabClusterAgentTokenWithToken.class, "cluster-agent-token-with-token.json")));

        final GitLabClusterAgentTokenWithToken result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectAgentsApi(GitLabCaller.of(client))
                    .createToken("group/sub/project", 1L, AgentsCatalogFixtures.projectAgentsCreateTokenPayload());
        }

        assertThat(result).isEqualTo(AgentsCatalogFixtures.clusterAgentTokenWithToken());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/tokens");
    }

    @Test
    void createToken_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/tokens",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectAgentsApi api = new GitLabProjectAgentsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.createToken("group/sub/project", 1L, AgentsCatalogFixtures.projectAgentsCreateTokenPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/tokens");
    }

    @Test
    void getToken_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/tokens/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabClusterAgentToken.class, "cluster-agent-token.json")));

        final Optional<GitLabClusterAgentToken> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectAgentsApi(GitLabCaller.of(client)).getToken("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(AgentsCatalogFixtures.clusterAgentToken());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/tokens/1");
    }

    @Test
    void getToken_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/tokens/1",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectAgentsApi(GitLabCaller.of(client))
                    .getToken("group/sub/project", 1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/tokens/1");
    }

    @Test
    void deleteToken_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/tokens/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectAgentsApi(GitLabCaller.of(client)).deleteToken("group/sub/project", 1L, 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/tokens/1");
    }

    @Test
    void deleteToken_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/tokens/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectAgentsApi api = new GitLabProjectAgentsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteToken("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/cluster_agents/1/tokens/1");
    }
}

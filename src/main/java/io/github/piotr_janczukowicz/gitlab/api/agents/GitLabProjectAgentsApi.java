package io.github.piotr_janczukowicz.gitlab.api.agents;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabClusterAgent;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.RequiresTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.client.pagination.GitLabListSpec;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPageRequest;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of project agents. */
public final class GitLabProjectAgentsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate GET_URL_CONFIGURATIONS =
            PathTemplate.of("/projects/{id}/cluster_agents/{agent_id}/url_configurations");
    private static final PathTemplate GET_URL_CONFIGURATION =
            PathTemplate.of("/projects/{id}/cluster_agents/{agent_id}/url_configurations/{url_configuration_id}");
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/cluster_agents");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/cluster_agents/{agent_id}");
    private static final PathTemplate LIST_TOKENS = PathTemplate.of("/projects/{id}/cluster_agents/{agent_id}/tokens");
    private static final PathTemplate GET_TOKEN =
            PathTemplate.of("/projects/{id}/cluster_agents/{agent_id}/tokens/{token_id}");
    private static final JsonType<List<GitLabClusterAgent>> CLUSTER_AGENT_LIST_TYPE =
            JsonTypes.listOf(GitLabClusterAgent.class);
    private static final JsonType<List<GitLabClusterAgentTokenBasic>> CLUSTER_AGENT_TOKEN_BASIC_LIST_TYPE =
            JsonTypes.listOf(GitLabClusterAgentTokenBasic.class);
    private static final GitLabListSpec<GitLabClusterAgent> CLUSTER_AGENT_SPEC =
            GitLabListSpec.offset(CLUSTER_AGENT_LIST_TYPE);
    private static final GitLabListSpec<GitLabClusterAgentTokenBasic> CLUSTER_AGENT_TOKEN_BASIC_SPEC =
            GitLabListSpec.offset(CLUSTER_AGENT_TOKEN_BASIC_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectAgentsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get url configurations ({@code GET /projects/{id}/cluster_agents/{agent_id}/url_configurations}).
     *
     * @param id the id
     * @param agentId the agent id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public Optional<GitLabClusterAgentUrlConfiguration> getUrlConfigurations(final String id, final long agentId)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4ProjectsIdClusterAgentsAgentIdUrlConfigurations");
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_URL_CONFIGURATIONS, id, agentId), GitLabClusterAgentUrlConfiguration.class);
    }

    /**
     * Create url configuration ({@code POST /projects/{id}/cluster_agents/{agent_id}/url_configurations}).
     *
     * @param id the id
     * @param agentId the agent id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabClusterAgentUrlConfiguration createUrlConfiguration(
            final String id, final long agentId, final GitLabProjectAgentsCreateUrlConfigurationPayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4ProjectsIdClusterAgentsAgentIdUrlConfigurations");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(GET_URL_CONFIGURATIONS, id, agentId), payload),
                GitLabClusterAgentUrlConfiguration.class);
    }

    /**
     * Get url configuration ({@code GET
     * /projects/{id}/cluster_agents/{agent_id}/url_configurations/{url_configuration_id}}).
     *
     * @param id the id
     * @param agentId the agent id
     * @param urlConfigurationId the url configuration id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public Optional<GitLabClusterAgentUrlConfiguration> getUrlConfiguration(
            final String id, final long agentId, final long urlConfigurationId) throws IOException {
        caller.requireTier(
                GitLabTier.ULTIMATE, "getApiV4ProjectsIdClusterAgentsAgentIdUrlConfigurationsUrlConfigurationId");
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(
                get(GET_URL_CONFIGURATION, id, agentId, urlConfigurationId), GitLabClusterAgentUrlConfiguration.class);
    }

    /**
     * Delete url configuration ({@code DELETE
     * /projects/{id}/cluster_agents/{agent_id}/url_configurations/{url_configuration_id}}).
     *
     * @param id the id
     * @param agentId the agent id
     * @param urlConfigurationId the url configuration id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void deleteUrlConfiguration(final String id, final long agentId, final long urlConfigurationId)
            throws IOException {
        caller.requireTier(
                GitLabTier.ULTIMATE, "deleteApiV4ProjectsIdClusterAgentsAgentIdUrlConfigurationsUrlConfigurationId");
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET_URL_CONFIGURATION, id, agentId, urlConfigurationId));
    }

    /**
     * List ({@code GET /projects/{id}/cluster_agents}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabClusterAgent> list(final String id) throws IOException {
        return list(id, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/cluster_agents}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabClusterAgent> list(final String id, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, CLUSTER_AGENT_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/cluster_agents}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabClusterAgent create(final String id, final GitLabProjectAgentsCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabClusterAgent.class);
    }

    /**
     * Get ({@code GET /projects/{id}/cluster_agents/{agent_id}}).
     *
     * @param id the id
     * @param agentId the agent id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabClusterAgent> get(final String id, final long agentId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET, id, agentId), GitLabClusterAgent.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/cluster_agents/{agent_id}}).
     *
     * @param id the id
     * @param agentId the agent id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final long agentId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET, id, agentId));
    }

    /**
     * List tokens ({@code GET /projects/{id}/cluster_agents/{agent_id}/tokens}).
     *
     * @param id the id
     * @param agentId the agent id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabClusterAgentTokenBasic> listTokens(final String id, final long agentId) throws IOException {
        return listTokens(id, agentId, GitLabPageRequest.byPage());
    }

    /**
     * List tokens ({@code GET /projects/{id}/cluster_agents/{agent_id}/tokens}).
     *
     * @param id the id
     * @param agentId the agent id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabClusterAgentTokenBasic> listTokens(
            final String id, final long agentId, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(LIST_TOKENS, Map.of(), request, CLUSTER_AGENT_TOKEN_BASIC_SPEC, id, agentId);
    }

    /**
     * Create token ({@code POST /projects/{id}/cluster_agents/{agent_id}/tokens}).
     *
     * @param id the id
     * @param agentId the agent id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabClusterAgentTokenWithToken createToken(
            final String id, final long agentId, final GitLabProjectAgentsCreateTokenPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(LIST_TOKENS, id, agentId), payload), GitLabClusterAgentTokenWithToken.class);
    }

    /**
     * Get token ({@code GET /projects/{id}/cluster_agents/{agent_id}/tokens/{token_id}}).
     *
     * @param id the id
     * @param agentId the agent id
     * @param tokenId the token id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabClusterAgentToken> getToken(final String id, final long agentId, final long tokenId)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_TOKEN, id, agentId, tokenId), GitLabClusterAgentToken.class);
    }

    /**
     * Delete token ({@code DELETE /projects/{id}/cluster_agents/{agent_id}/tokens/{token_id}}).
     *
     * @param id the id
     * @param agentId the agent id
     * @param tokenId the token id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteToken(final String id, final long agentId, final long tokenId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET_TOKEN, id, agentId, tokenId));
    }
}

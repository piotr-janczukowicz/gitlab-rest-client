package io.github.piotr_janczukowicz.gitlab.api.knowledgegraph;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.RequiresTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of knowledge graph. */
public final class GitLabKnowledgeGraphApi extends GitLabResourceApi {
    private static final PathTemplate GET_NAMESPACES = PathTemplate.of("/admin/knowledge_graph/namespaces");
    private static final PathTemplate UPDATE_NAMESPACE = PathTemplate.of("/admin/knowledge_graph/namespaces/{id}");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabKnowledgeGraphApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get namespaces ({@code GET /admin/knowledge_graph/namespaces}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabAnalyticsKnowledgeGraphEnabledNamespace getNamespaces() throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4AdminKnowledgeGraphNamespaces");
        return caller.fetch(get(GET_NAMESPACES), GitLabAnalyticsKnowledgeGraphEnabledNamespace.class);
    }

    /**
     * Update namespace ({@code PUT /admin/knowledge_graph/namespaces/{id}}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabAnalyticsKnowledgeGraphEnabledNamespace updateNamespace(final String id) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "putApiV4AdminKnowledgeGraphNamespacesId");
        requireNotBlank(id, "id");
        return caller.fetch(put(UPDATE_NAMESPACE, id), GitLabAnalyticsKnowledgeGraphEnabledNamespace.class);
    }

    /**
     * Delete namespace ({@code DELETE /admin/knowledge_graph/namespaces/{id}}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void deleteNamespace(final String id) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4AdminKnowledgeGraphNamespacesId");
        requireNotBlank(id, "id");
        caller.send(delete(UPDATE_NAMESPACE, id));
    }
}

package io.github.piotr_janczukowicz.gitlab.api.containerregistryprotectiontagrules;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;

/** The GitLab operations of project container registry protection tag rules. */
public final class GitLabProjectContainerRegistryProtectionTagRulesApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/registry/protection/tag/rules");
    private static final PathTemplate UPDATE =
            PathTemplate.of("/projects/{id}/registry/protection/tag/rules/{protection_rule_id}");
    private static final JsonType<List<GitLabProjectContainerRegistryProtectionTagRule>>
            PROJECT_CONTAINER_REGISTRY_PROTECTION_TAG_RULE_LIST_TYPE =
                    JsonTypes.listOf(GitLabProjectContainerRegistryProtectionTagRule.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectContainerRegistryProtectionTagRulesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/registry/protection/tag/rules}).
     *
     * @param id the id
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabProjectContainerRegistryProtectionTagRule> list(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(LIST, id), PROJECT_CONTAINER_REGISTRY_PROTECTION_TAG_RULE_LIST_TYPE);
    }

    /**
     * Create ({@code POST /projects/{id}/registry/protection/tag/rules}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectContainerRegistryProtectionTagRule create(
            final String id, final GitLabContainerTagRuleCreatePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(
                caller.json(post(LIST, id), payload), GitLabProjectContainerRegistryProtectionTagRule.class);
    }

    /**
     * Update ({@code PATCH /projects/{id}/registry/protection/tag/rules/{protection_rule_id}}).
     *
     * @param id the id
     * @param protectionRuleId the protection rule id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectContainerRegistryProtectionTagRule update(
            final String id, final long protectionRuleId, final GitLabContainerTagRuleUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(
                caller.json(patch(UPDATE, id, protectionRuleId), payload),
                GitLabProjectContainerRegistryProtectionTagRule.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/registry/protection/tag/rules/{protection_rule_id}}).
     *
     * @param id the id
     * @param protectionRuleId the protection rule id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final long protectionRuleId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(UPDATE, id, protectionRuleId));
    }
}

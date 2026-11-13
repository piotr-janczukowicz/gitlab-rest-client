package io.github.piotr_janczukowicz.gitlab.api.protectedcontainerregistry;

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

/** The GitLab operations of project protected container registry. */
public final class GitLabProjectProtectedContainerRegistryApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST_REGISTRY_PROTECTION_REPOSITORY_RULE =
            PathTemplate.of("/projects/{id}/registry/protection/repository/rules");
    private static final PathTemplate UPDATE_REGISTRY_PROTECTION_REPOSITORY_RU =
            PathTemplate.of("/projects/{id}/registry/protection/repository/rules/{protection_rule_id}");
    private static final JsonType<List<GitLabProjectContainerRegistryProtectionRule>>
            PROJECT_CONTAINER_REGISTRY_PROTECTION_RULE_LIST_TYPE =
                    JsonTypes.listOf(GitLabProjectContainerRegistryProtectionRule.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectProtectedContainerRegistryApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List registry protection repository rules ({@code GET /projects/{id}/registry/protection/repository/rules}).
     *
     * @param id the id
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabProjectContainerRegistryProtectionRule> listRegistryProtectionRepositoryRules(final String id)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(
                get(LIST_REGISTRY_PROTECTION_REPOSITORY_RULE, id),
                PROJECT_CONTAINER_REGISTRY_PROTECTION_RULE_LIST_TYPE);
    }

    /**
     * Create registry protection repository rule ({@code POST /projects/{id}/registry/protection/repository/rules}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectContainerRegistryProtectionRule createRegistryProtectionRepositoryRule(
            final String id, final GitLabContainerRegistryRuleCreatePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(
                caller.json(post(LIST_REGISTRY_PROTECTION_REPOSITORY_RULE, id), payload),
                GitLabProjectContainerRegistryProtectionRule.class);
    }

    /**
     * Update registry protection repository rule ({@code PATCH
     * /projects/{id}/registry/protection/repository/rules/{protection_rule_id}}).
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
    public GitLabProjectContainerRegistryProtectionRule updateRegistryProtectionRepositoryRule(
            final String id, final long protectionRuleId, final GitLabContainerRegistryRuleUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(
                caller.json(patch(UPDATE_REGISTRY_PROTECTION_REPOSITORY_RU, id, protectionRuleId), payload),
                GitLabProjectContainerRegistryProtectionRule.class);
    }

    /**
     * Delete registry protection repository rule ({@code DELETE
     * /projects/{id}/registry/protection/repository/rules/{protection_rule_id}}).
     *
     * @param id the id
     * @param protectionRuleId the protection rule id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteRegistryProtectionRepositoryRule(final String id, final long protectionRuleId)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(UPDATE_REGISTRY_PROTECTION_REPOSITORY_RU, id, protectionRuleId));
    }
}

package io.github.piotr_janczukowicz.gitlab.api.protectedpackages;

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

/** The GitLab operations of project protected packages. */
public final class GitLabProjectProtectedPackagesApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/packages/protection/rules");
    private static final PathTemplate UPDATE =
            PathTemplate.of("/projects/{id}/packages/protection/rules/{package_protection_rule_id}");
    private static final JsonType<List<GitLabProjectPackagesProtectionRule>>
            PROJECT_PACKAGES_PROTECTION_RULE_LIST_TYPE = JsonTypes.listOf(GitLabProjectPackagesProtectionRule.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectProtectedPackagesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/packages/protection/rules}).
     *
     * @param id the id
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabProjectPackagesProtectionRule> list(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(LIST, id), PROJECT_PACKAGES_PROTECTION_RULE_LIST_TYPE);
    }

    /**
     * Create ({@code POST /projects/{id}/packages/protection/rules}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectPackagesProtectionRule create(
            final String id, final GitLabProjectProtectedPackagesCreatePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabProjectPackagesProtectionRule.class);
    }

    /**
     * Update ({@code PATCH /projects/{id}/packages/protection/rules/{package_protection_rule_id}}).
     *
     * @param id the id
     * @param packageProtectionRuleId the package protection rule id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectPackagesProtectionRule update(
            final String id,
            final long packageProtectionRuleId,
            final GitLabProjectProtectedPackagesUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(
                caller.json(patch(UPDATE, id, packageProtectionRuleId), payload),
                GitLabProjectPackagesProtectionRule.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/packages/protection/rules/{package_protection_rule_id}}).
     *
     * @param id the id
     * @param packageProtectionRuleId the package protection rule id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final long packageProtectionRuleId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(UPDATE, id, packageProtectionRuleId));
    }
}

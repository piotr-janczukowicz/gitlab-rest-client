package io.github.piotr_janczukowicz.gitlab.api.terraformstate;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

/** The GitLab operations of project terraform state. */
public final class GitLabProjectTerraformStateApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_NAME = "name";
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate GET_STATE_VERSION =
            PathTemplate.of("/projects/{id}/terraform/state/{name}/versions/{serial}");
    private static final PathTemplate LIST_STATE_PROTECTION_RULES =
            PathTemplate.of("/projects/{id}/terraform/state_protection_rules");
    private static final PathTemplate UPDATE_STATE_PROTECTION_RULE =
            PathTemplate.of("/projects/{id}/terraform/state_protection_rules/{terraform_state_protection_rule_id}");
    private static final PathTemplate CALL_STATE = PathTemplate.of("/projects/{id}/terraform/state/{name}");
    private static final PathTemplate AUTHORIZE_STATE =
            PathTemplate.of("/projects/{id}/terraform/state/{name}/authorize");
    private static final PathTemplate CREATE_STATE_LOCK = PathTemplate.of("/projects/{id}/terraform/state/{name}/lock");
    private static final JsonType<List<GitLabTerraformStateProtectionRule>> TERRAFORM_STATE_PROTECTION_RULE_LIST_TYPE =
            JsonTypes.listOf(GitLabTerraformStateProtectionRule.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectTerraformStateApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get state version ({@code GET /projects/{id}/terraform/state/{name}/versions/{serial}}).
     *
     * @param id the id
     * @param name the name
     * @param serial the serial
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id} or {@code name} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getStateVersion(final String id, final String name, final int serial, final OutputStream out)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(name, PARAM_NAME);
        requireNonNull(out, "out");
        return caller.download(get(GET_STATE_VERSION, id, name, serial), out);
    }

    /**
     * Get state version ({@code GET /projects/{id}/terraform/state/{name}/versions/{serial}}).
     *
     * @param id the id
     * @param name the name
     * @param serial the serial
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id} or {@code name} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getStateVersion(final String id, final String name, final int serial, final Path target)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(name, PARAM_NAME);
        requireNonNull(target, "target");
        return caller.download(get(GET_STATE_VERSION, id, name, serial), target);
    }

    /**
     * Delete state version ({@code DELETE /projects/{id}/terraform/state/{name}/versions/{serial}}).
     *
     * @param id the id
     * @param name the name
     * @param serial the serial
     * @throws IllegalArgumentException if {@code id} or {@code name} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteStateVersion(final String id, final String name, final int serial) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(name, PARAM_NAME);
        caller.send(delete(GET_STATE_VERSION, id, name, serial));
    }

    /**
     * List state protection rules ({@code GET /projects/{id}/terraform/state_protection_rules}).
     *
     * @param id the id
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabTerraformStateProtectionRule> listStateProtectionRules(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(LIST_STATE_PROTECTION_RULES, id), TERRAFORM_STATE_PROTECTION_RULE_LIST_TYPE);
    }

    /**
     * Create state protection rule ({@code POST /projects/{id}/terraform/state_protection_rules}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabTerraformStateProtectionRule createStateProtectionRule(
            final String id, final GitLabProjectTerraformStateRuleCreatePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(LIST_STATE_PROTECTION_RULES, id), payload), GitLabTerraformStateProtectionRule.class);
    }

    /**
     * Update state protection rule ({@code PATCH
     * /projects/{id}/terraform/state_protection_rules/{terraform_state_protection_rule_id}}).
     *
     * @param id the id
     * @param terraformStateProtectionRuleId the terraform state protection rule id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabTerraformStateProtectionRule updateStateProtectionRule(
            final String id,
            final long terraformStateProtectionRuleId,
            final GitLabProjectTerraformStateRuleUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(patch(UPDATE_STATE_PROTECTION_RULE, id, terraformStateProtectionRuleId), payload),
                GitLabTerraformStateProtectionRule.class);
    }

    /**
     * Delete state protection rule ({@code DELETE
     * /projects/{id}/terraform/state_protection_rules/{terraform_state_protection_rule_id}}).
     *
     * @param id the id
     * @param terraformStateProtectionRuleId the terraform state protection rule id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteStateProtectionRule(final String id, final long terraformStateProtectionRuleId)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(UPDATE_STATE_PROTECTION_RULE, id, terraformStateProtectionRuleId));
    }

    /**
     * Call state ({@code GET /projects/{id}/terraform/state/{name}}).
     *
     * @param id the id
     * @param name the name
     * @throws IllegalArgumentException if {@code id} or {@code name} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callState(final String id, final String name) throws IOException {
        callState(id, name, GitLabProjectTerraformStateCallStateFilter.empty());
    }

    /**
     * Call state ({@code GET /projects/{id}/terraform/state/{name}}).
     *
     * @param id the id
     * @param name the name
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id} or {@code name} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callState(final String id, final String name, final GitLabProjectTerraformStateCallStateFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(name, PARAM_NAME);
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(get(CALL_STATE, id, name).withQuery(queryParameters));
    }

    /**
     * Create state ({@code POST /projects/{id}/terraform/state/{name}}).
     *
     * @param id the id
     * @param name the name
     * @param form the form to send
     * @throws IllegalArgumentException if {@code id} or {@code name} is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createState(final String id, final String name, final MultipartFormData form) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(name, PARAM_NAME);
        requireNonNull(form, "form");
        caller.send(caller.multipart(post(CALL_STATE, id, name), form));
    }

    /**
     * Delete state ({@code DELETE /projects/{id}/terraform/state/{name}}).
     *
     * @param id the id
     * @param name the name
     * @throws IllegalArgumentException if {@code id} or {@code name} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteState(final String id, final String name) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(name, PARAM_NAME);
        caller.send(delete(CALL_STATE, id, name));
    }

    /**
     * Authorize state ({@code POST /projects/{id}/terraform/state/{name}/authorize}).
     *
     * @param id the id
     * @param name the name
     * @throws IllegalArgumentException if {@code id} or {@code name} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void authorizeState(final String id, final String name) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(name, PARAM_NAME);
        caller.send(post(AUTHORIZE_STATE, id, name));
    }

    /**
     * Create state lock ({@code POST /projects/{id}/terraform/state/{name}/lock}).
     *
     * @param id the id
     * @param name the name
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} or {@code name} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createStateLock(
            final String id, final String name, final GitLabProjectTerraformStateCreateStateLockPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(name, PARAM_NAME);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(CREATE_STATE_LOCK, id, name), payload));
    }

    /**
     * Delete state lock ({@code DELETE /projects/{id}/terraform/state/{name}/lock}).
     *
     * @param id the id
     * @param name the name
     * @throws IllegalArgumentException if {@code id} or {@code name} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteStateLock(final String id, final String name) throws IOException {
        deleteStateLock(id, name, GitLabProjectTerraformStateDeleteStateLockFilter.empty());
    }

    /**
     * Delete state lock ({@code DELETE /projects/{id}/terraform/state/{name}/lock}).
     *
     * @param id the id
     * @param name the name
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id} or {@code name} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteStateLock(
            final String id, final String name, final GitLabProjectTerraformStateDeleteStateLockFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(name, PARAM_NAME);
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(delete(CREATE_STATE_LOCK, id, name).withQuery(queryParameters));
    }
}

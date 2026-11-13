package io.github.piotr_janczukowicz.gitlab.api.projectcicdjobtokenscope;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBasicGroupDetails;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBasicProjectDetails;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.pagination.GitLabListSpec;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPageRequest;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/** The GitLab operations of project project cicdjob token scope. */
public final class GitLabProjectProjectCICDJobTokenScopeApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/job_token_scope");
    private static final PathTemplate LIST_ALLOWLIST = PathTemplate.of("/projects/{id}/job_token_scope/allowlist");
    private static final PathTemplate LIST_GROUPS_ALLOWLIST =
            PathTemplate.of("/projects/{id}/job_token_scope/groups_allowlist");
    private static final PathTemplate DELETE_GROUPS_ALLOWLIST =
            PathTemplate.of("/projects/{id}/job_token_scope/groups_allowlist/{target_group_id}");
    private static final PathTemplate DELETE_ALLOWLIST =
            PathTemplate.of("/projects/{id}/job_token_scope/allowlist/{target_project_id}");
    private static final JsonType<List<GitLabBasicProjectDetails>> BASIC_PROJECT_DETAILS_LIST_TYPE =
            JsonTypes.listOf(GitLabBasicProjectDetails.class);
    private static final JsonType<List<GitLabBasicGroupDetails>> BASIC_GROUP_DETAILS_LIST_TYPE =
            JsonTypes.listOf(GitLabBasicGroupDetails.class);
    private static final GitLabListSpec<GitLabBasicProjectDetails> BASIC_PROJECT_DETAILS_SPEC =
            GitLabListSpec.offset(BASIC_PROJECT_DETAILS_LIST_TYPE);
    private static final GitLabListSpec<GitLabBasicGroupDetails> BASIC_GROUP_DETAILS_SPEC =
            GitLabListSpec.offset(BASIC_GROUP_DETAILS_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectProjectCICDJobTokenScopeApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get ({@code GET /projects/{id}/job_token_scope}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectJobTokenScope get(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(GET, id), GitLabProjectJobTokenScope.class);
    }

    /**
     * Update ({@code PATCH /projects/{id}/job_token_scope}).
     *
     * @param id the id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void update(final String id, final GitLabProjectProjectCICDJobTokenScopeUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(patch(GET, id), payload));
    }

    /**
     * List allowlist ({@code GET /projects/{id}/job_token_scope/allowlist}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBasicProjectDetails> listAllowlist(final String id) throws IOException {
        return listAllowlist(id, GitLabPageRequest.byPage());
    }

    /**
     * List allowlist ({@code GET /projects/{id}/job_token_scope/allowlist}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBasicProjectDetails> listAllowlist(final String id, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(LIST_ALLOWLIST, Map.of(), request, BASIC_PROJECT_DETAILS_SPEC, id);
    }

    /**
     * Create allowlist ({@code POST /projects/{id}/job_token_scope/allowlist}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectScopeLink createAllowlist(
            final long id, final GitLabProjectProjectCICDJobTokenScopeCreateAllowlistPayload payload)
            throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_ALLOWLIST, id), payload), GitLabProjectScopeLink.class);
    }

    /**
     * List groups allowlist ({@code GET /projects/{id}/job_token_scope/groups_allowlist}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBasicGroupDetails> listGroupsAllowlist(final String id) throws IOException {
        return listGroupsAllowlist(id, GitLabPageRequest.byPage());
    }

    /**
     * List groups allowlist ({@code GET /projects/{id}/job_token_scope/groups_allowlist}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBasicGroupDetails> listGroupsAllowlist(final String id, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(LIST_GROUPS_ALLOWLIST, Map.of(), request, BASIC_GROUP_DETAILS_SPEC, id);
    }

    /**
     * Create groups allowlist ({@code POST /projects/{id}/job_token_scope/groups_allowlist}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabGroupScopeLink createGroupsAllowlist(
            final long id, final GitLabProjectProjectCICDJobTokenScopeCreateGroupsAllowlistPayload payload)
            throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_GROUPS_ALLOWLIST, id), payload), GitLabGroupScopeLink.class);
    }

    /**
     * Delete groups allowlist ({@code DELETE /projects/{id}/job_token_scope/groups_allowlist/{target_group_id}}).
     *
     * @param id the id
     * @param targetGroupId the target group id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteGroupsAllowlist(final long id, final long targetGroupId) throws IOException {
        caller.send(delete(DELETE_GROUPS_ALLOWLIST, id, targetGroupId));
    }

    /**
     * Delete allowlist ({@code DELETE /projects/{id}/job_token_scope/allowlist/{target_project_id}}).
     *
     * @param id the id
     * @param targetProjectId the target project id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteAllowlist(final long id, final long targetProjectId) throws IOException {
        caller.send(delete(DELETE_ALLOWLIST, id, targetProjectId));
    }
}

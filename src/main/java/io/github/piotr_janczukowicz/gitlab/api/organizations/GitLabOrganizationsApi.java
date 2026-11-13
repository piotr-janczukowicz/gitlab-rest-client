package io.github.piotr_janczukowicz.gitlab.api.organizations;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.pagination.GitLabListSpec;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPageRequest;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/** The GitLab operations of organizations. */
public final class GitLabOrganizationsApi extends GitLabResourceApi {
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate CREATE = PathTemplate.of("/organizations");
    private static final PathTemplate DELETE = PathTemplate.of("/organizations/{id}");
    private static final PathTemplate RESTORE = PathTemplate.of("/organizations/{id}/restore");
    private static final PathTemplate CREATE_TRANSFER_USER = PathTemplate.of("/organizations/{id}/transfer_users");
    private static final PathTemplate LIST_USERS = PathTemplate.of("/organizations/{id}/users");
    private static final PathTemplate UPDATE_USER = PathTemplate.of("/organizations/{id}/users/{user_id}");
    private static final JsonType<List<GitLabOrganizationUser>> ORGANIZATION_USER_LIST_TYPE =
            JsonTypes.listOf(GitLabOrganizationUser.class);
    private static final GitLabListSpec<GitLabOrganizationUser> ORGANIZATION_USER_SPEC =
            GitLabListSpec.offset(ORGANIZATION_USER_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabOrganizationsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Create ({@code POST /organizations}).
     *
     * @param form the form to send
     * @return the resource
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabOrganization create(final MultipartFormData form) throws IOException {
        requireNonNull(form, "form");
        return caller.fetch(caller.multipart(post(CREATE), form), GitLabOrganization.class);
    }

    /**
     * Delete ({@code DELETE /organizations/{id}}).
     *
     * @param id the id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final long id) throws IOException {
        caller.send(delete(DELETE, id));
    }

    /**
     * Restore ({@code POST /organizations/{id}/restore}).
     *
     * @param id the id
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabOrganization restore(final long id) throws IOException {
        return caller.fetch(post(RESTORE, id), GitLabOrganization.class);
    }

    /**
     * Create transfer user ({@code POST /organizations/{id}/transfer_users}).
     *
     * @param id the id
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createTransferUser(final long id, final GitLabOrganizationsCreateTransferUserPayload payload)
            throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(CREATE_TRANSFER_USER, id), payload));
    }

    /**
     * List users ({@code GET /organizations/{id}/users}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabOrganizationUser> listUsers(final long id) throws IOException {
        return listUsers(id, GitLabOrganizationsListUsersFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List users ({@code GET /organizations/{id}/users}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabOrganizationUser> listUsers(final long id, final GitLabPageRequest request)
            throws IOException {
        return listUsers(id, GitLabOrganizationsListUsersFilter.empty(), request);
    }

    /**
     * List users ({@code GET /organizations/{id}/users}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabOrganizationUser> listUsers(final long id, final GitLabOrganizationsListUsersFilter filter)
            throws IOException {
        return listUsers(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List users ({@code GET /organizations/{id}/users}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabOrganizationUser> listUsers(
            final long id, final GitLabOrganizationsListUsersFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_USERS, queryParameters, request, ORGANIZATION_USER_SPEC, id);
    }

    /**
     * Create user ({@code POST /organizations/{id}/users}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabOrganizationUser createUser(final long id, final GitLabOrganizationsCreateUserPayload payload)
            throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_USERS, id), payload), GitLabOrganizationUser.class);
    }

    /**
     * Update user ({@code PUT /organizations/{id}/users/{user_id}}).
     *
     * @param id the id
     * @param userId the user id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabOrganizationUser updateUser(
            final long id, final long userId, final GitLabOrganizationsUpdateUserPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(UPDATE_USER, id, userId), payload), GitLabOrganizationUser.class);
    }

    /**
     * Delete user ({@code DELETE /organizations/{id}/users/{user_id}}).
     *
     * @param id the id
     * @param userId the user id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteUser(final long id, final long userId) throws IOException {
        caller.send(delete(UPDATE_USER, id, userId));
    }
}

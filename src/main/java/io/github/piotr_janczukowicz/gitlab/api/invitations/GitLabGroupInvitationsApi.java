package io.github.piotr_janczukowicz.gitlab.api.invitations;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
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

/** The GitLab operations of group invitations. */
public final class GitLabGroupInvitationsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST = PathTemplate.of("/groups/{id}/invitations");
    private static final PathTemplate UPDATE = PathTemplate.of("/groups/{id}/invitations/{email}");
    private static final JsonType<List<GitLabInvitation>> INVITATION_LIST_TYPE =
            JsonTypes.listOf(GitLabInvitation.class);
    private static final GitLabListSpec<GitLabInvitation> INVITATION_SPEC = GitLabListSpec.offset(INVITATION_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupInvitationsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /groups/{id}/invitations}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabInvitation> list(final String id) throws IOException {
        return list(id, GitLabGroupInvitationsListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /groups/{id}/invitations}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabInvitation> list(final String id, final GitLabPageRequest request) throws IOException {
        return list(id, GitLabGroupInvitationsListFilter.empty(), request);
    }

    /**
     * List ({@code GET /groups/{id}/invitations}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabInvitation> list(final String id, final GitLabGroupInvitationsListFilter filter)
            throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /groups/{id}/invitations}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabInvitation> list(
            final String id, final GitLabGroupInvitationsListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, INVITATION_SPEC, id);
    }

    /**
     * Create ({@code POST /groups/{id}/invitations}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabInvitation create(final String id, final GitLabGroupInvitationsCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabInvitation.class);
    }

    /**
     * Update ({@code PUT /groups/{id}/invitations/{email}}).
     *
     * @param id the id
     * @param email the email
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code email} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabInvitation update(
            final String id, final String email, final GitLabGroupInvitationsUpdatePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(email, "email");
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(UPDATE, id, email), payload), GitLabInvitation.class);
    }

    /**
     * Delete ({@code DELETE /groups/{id}/invitations/{email}}).
     *
     * @param id the id
     * @param email the email
     * @throws IllegalArgumentException if {@code id} or {@code email} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final String email) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(email, "email");
        caller.send(delete(UPDATE, id, email));
    }
}

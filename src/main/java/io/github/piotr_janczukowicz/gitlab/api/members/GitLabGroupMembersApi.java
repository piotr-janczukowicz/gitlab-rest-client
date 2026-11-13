package io.github.piotr_janczukowicz.gitlab.api.members;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMember;
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
import java.util.Optional;

/** The GitLab operations of group members. */
public final class GitLabGroupMembersApi extends GitLabResourceApi {
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_ID = "id";
    private static final String PARAM_PAYLOAD = "payload";
    private static final String PARAM_REQUEST = "request";
    private static final PathTemplate LIST = PathTemplate.of("/groups/{id}/members");
    private static final PathTemplate LIST_ALL = PathTemplate.of("/groups/{id}/members/all");
    private static final PathTemplate GET = PathTemplate.of("/groups/{id}/members/{user_id}");
    private static final PathTemplate GET_ALL = PathTemplate.of("/groups/{id}/members/all/{user_id}");
    private static final PathTemplate CREATE_OVERRIDE = PathTemplate.of("/groups/{id}/members/{user_id}/override");
    private static final PathTemplate APPROVE = PathTemplate.of("/groups/{id}/members/{member_id}/approve");
    private static final PathTemplate APPROVE_ALL = PathTemplate.of("/groups/{id}/members/approve_all");
    private static final PathTemplate CALL_PENDING_MEMBERS = PathTemplate.of("/groups/{id}/pending_members");
    private static final PathTemplate STATE = PathTemplate.of("/groups/{id}/members/{user_id}/state");
    private static final PathTemplate LIST_BILLABLE_MEMBERS_MEMBERSHIPS =
            PathTemplate.of("/groups/{id}/billable_members/{user_id}/memberships");
    private static final PathTemplate LIST_BILLABLE_MEMBERS_INDIRECT =
            PathTemplate.of("/groups/{id}/billable_members/{user_id}/indirect");
    private static final PathTemplate DELETE_BILLABLE_MEMBER =
            PathTemplate.of("/groups/{id}/billable_members/{user_id}");
    private static final JsonType<List<GitLabMember>> MEMBER_LIST_TYPE = JsonTypes.listOf(GitLabMember.class);
    private static final JsonType<List<GitLabBillableMembership>> BILLABLE_MEMBERSHIP_LIST_TYPE =
            JsonTypes.listOf(GitLabBillableMembership.class);
    private static final GitLabListSpec<GitLabMember> MEMBER_SPEC = GitLabListSpec.offset(MEMBER_LIST_TYPE);
    private static final GitLabListSpec<GitLabBillableMembership> BILLABLE_MEMBERSHIP_SPEC =
            GitLabListSpec.offset(BILLABLE_MEMBERSHIP_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupMembersApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /groups/{id}/members}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMember> list(final String id) throws IOException {
        return list(id, GitLabGroupMembersListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /groups/{id}/members}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMember> list(final String id, final GitLabPageRequest request) throws IOException {
        return list(id, GitLabGroupMembersListFilter.empty(), request);
    }

    /**
     * List ({@code GET /groups/{id}/members}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMember> list(final String id, final GitLabGroupMembersListFilter filter)
            throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /groups/{id}/members}).
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
    public GitLabPage<GitLabMember> list(
            final String id, final GitLabGroupMembersListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, MEMBER_SPEC, id);
    }

    /**
     * Create ({@code POST /groups/{id}/members}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMember create(final String id, final GitLabGroupMembersCreatePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabMember.class);
    }

    /**
     * List all ({@code GET /groups/{id}/members/all}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMember> listAll(final String id) throws IOException {
        return listAll(id, GitLabGroupMembersListAllFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List all ({@code GET /groups/{id}/members/all}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMember> listAll(final String id, final GitLabPageRequest request) throws IOException {
        return listAll(id, GitLabGroupMembersListAllFilter.empty(), request);
    }

    /**
     * List all ({@code GET /groups/{id}/members/all}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMember> listAll(final String id, final GitLabGroupMembersListAllFilter filter)
            throws IOException {
        return listAll(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List all ({@code GET /groups/{id}/members/all}).
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
    public GitLabPage<GitLabMember> listAll(
            final String id, final GitLabGroupMembersListAllFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_ALL, queryParameters, request, MEMBER_SPEC, id);
    }

    /**
     * Get ({@code GET /groups/{id}/members/{user_id}}).
     *
     * @param id the id
     * @param userId the user id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabMember> get(final String id, final long userId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET, id, userId), GitLabMember.class);
    }

    /**
     * Update ({@code PUT /groups/{id}/members/{user_id}}).
     *
     * @param id the id
     * @param userId the user id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMember update(final String id, final long userId, final GitLabGroupMembersUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET, id, userId), payload), GitLabMember.class);
    }

    /**
     * Delete ({@code DELETE /groups/{id}/members/{user_id}}).
     *
     * @param id the id
     * @param userId the user id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final long userId) throws IOException {
        delete(id, userId, GitLabGroupMembersDeleteFilter.empty());
    }

    /**
     * Delete ({@code DELETE /groups/{id}/members/{user_id}}).
     *
     * @param id the id
     * @param userId the user id
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final long userId, final GitLabGroupMembersDeleteFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(delete(GET, id, userId).withQuery(queryParameters));
    }

    /**
     * Get all ({@code GET /groups/{id}/members/all/{user_id}}).
     *
     * @param id the id
     * @param userId the user id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabMember> getAll(final String id, final long userId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_ALL, id, userId), GitLabMember.class);
    }

    /**
     * Create override ({@code POST /groups/{id}/members/{user_id}/override}).
     *
     * @param id the id
     * @param userId the user id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMember createOverride(final String id, final long userId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(CREATE_OVERRIDE, id, userId), GitLabMember.class);
    }

    /**
     * Delete override ({@code DELETE /groups/{id}/members/{user_id}/override}).
     *
     * @param id the id
     * @param userId the user id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabMember> deleteOverride(final String id, final long userId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOptional(delete(CREATE_OVERRIDE, id, userId), GitLabMember.class);
    }

    /**
     * Approve ({@code PUT /groups/{id}/members/{member_id}/approve}).
     *
     * @param id the id
     * @param memberId the member id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void approve(final String id, final long memberId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(put(APPROVE, id, memberId));
    }

    /**
     * Approve all ({@code POST /groups/{id}/members/approve_all}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void approveAll(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(post(APPROVE_ALL, id));
    }

    /**
     * Call pending members ({@code GET /groups/{id}/pending_members}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callPendingMembers(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(get(CALL_PENDING_MEMBERS, id));
    }

    /**
     * State ({@code PUT /groups/{id}/members/{user_id}/state}).
     *
     * @param id the id
     * @param userId the user id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void state(final String id, final long userId, final GitLabGroupMembersStatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(put(STATE, id, userId), payload));
    }

    /**
     * List billable members memberships ({@code GET /groups/{id}/billable_members/{user_id}/memberships}).
     *
     * @param id the id
     * @param userId the user id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBillableMembership> listBillableMembersMemberships(final String id, final long userId)
            throws IOException {
        return listBillableMembersMemberships(id, userId, GitLabPageRequest.byPage());
    }

    /**
     * List billable members memberships ({@code GET /groups/{id}/billable_members/{user_id}/memberships}).
     *
     * @param id the id
     * @param userId the user id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBillableMembership> listBillableMembersMemberships(
            final String id, final long userId, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_BILLABLE_MEMBERS_MEMBERSHIPS, Map.of(), request, BILLABLE_MEMBERSHIP_SPEC, id, userId);
    }

    /**
     * List billable members indirect ({@code GET /groups/{id}/billable_members/{user_id}/indirect}).
     *
     * @param id the id
     * @param userId the user id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBillableMembership> listBillableMembersIndirect(final String id, final long userId)
            throws IOException {
        return listBillableMembersIndirect(id, userId, GitLabPageRequest.byPage());
    }

    /**
     * List billable members indirect ({@code GET /groups/{id}/billable_members/{user_id}/indirect}).
     *
     * @param id the id
     * @param userId the user id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBillableMembership> listBillableMembersIndirect(
            final String id, final long userId, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_BILLABLE_MEMBERS_INDIRECT, Map.of(), request, BILLABLE_MEMBERSHIP_SPEC, id, userId);
    }

    /**
     * Delete billable member ({@code DELETE /groups/{id}/billable_members/{user_id}}).
     *
     * @param id the id
     * @param userId the user id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteBillableMember(final String id, final long userId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(DELETE_BILLABLE_MEMBER, id, userId));
    }
}

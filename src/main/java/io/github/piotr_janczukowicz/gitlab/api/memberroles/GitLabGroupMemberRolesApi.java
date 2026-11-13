package io.github.piotr_janczukowicz.gitlab.api.memberroles;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMemberRole;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.RequiresTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;

/** The GitLab operations of group member roles. */
public final class GitLabGroupMemberRolesApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate LIST_GROUP = PathTemplate.of("/groups/{id}/member_roles");
    private static final PathTemplate DELETE_GROUP = PathTemplate.of("/groups/{id}/member_roles/{member_role_id}");
    private static final PathTemplate LIST = PathTemplate.of("/member_roles");
    private static final PathTemplate DELETE = PathTemplate.of("/member_roles/{member_role_id}");
    private static final PathTemplate LIST_ADMIN_MEMBER_ROLES = PathTemplate.of("/admin_member_roles");
    private static final PathTemplate DELETE_ADMIN_MEMBER_ROLE =
            PathTemplate.of("/admin_member_roles/{member_role_id}");
    private static final JsonType<List<GitLabMemberRole>> MEMBER_ROLE_LIST_TYPE =
            JsonTypes.listOf(GitLabMemberRole.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupMemberRolesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List group ({@code GET /groups/{id}/member_roles}).
     *
     * @param id the id
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public List<GitLabMemberRole> listGroup(final String id) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4GroupsIdMemberRoles");
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(LIST_GROUP, id), MEMBER_ROLE_LIST_TYPE);
    }

    /**
     * Create group ({@code POST /groups/{id}/member_roles}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabMemberRole createGroup(final String id, final GitLabGroupMemberRolesCreateGroupPayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4GroupsIdMemberRoles");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_GROUP, id), payload), GitLabMemberRole.class);
    }

    /**
     * Delete group ({@code DELETE /groups/{id}/member_roles/{member_role_id}}).
     *
     * @param id the id
     * @param memberRoleId the member role id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void deleteGroup(final String id, final long memberRoleId) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "deleteApiV4GroupsIdMemberRolesMemberRoleId");
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(DELETE_GROUP, id, memberRoleId));
    }

    /**
     * List ({@code GET /member_roles}).
     *
     * @return the items
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public List<GitLabMemberRole> list() throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4MemberRoles");
        return caller.fetch(get(LIST), MEMBER_ROLE_LIST_TYPE);
    }

    /**
     * Create ({@code POST /member_roles}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabMemberRole create(final GitLabGroupMemberRolesCreatePayload payload) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4MemberRoles");
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST), payload), GitLabMemberRole.class);
    }

    /**
     * Delete ({@code DELETE /member_roles/{member_role_id}}).
     *
     * @param memberRoleId the member role id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void delete(final long memberRoleId) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "deleteApiV4MemberRolesMemberRoleId");
        caller.send(delete(DELETE, memberRoleId));
    }

    /**
     * List admin member roles ({@code GET /admin_member_roles}).
     *
     * @return the items
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public List<GitLabMemberRole> listAdminMemberRoles() throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4AdminMemberRoles");
        return caller.fetch(get(LIST_ADMIN_MEMBER_ROLES), MEMBER_ROLE_LIST_TYPE);
    }

    /**
     * Create admin member role ({@code POST /admin_member_roles}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabMemberRole createAdminMemberRole(final GitLabGroupMemberRolesCreateAdminMemberRolePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4AdminMemberRoles");
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_ADMIN_MEMBER_ROLES), payload), GitLabMemberRole.class);
    }

    /**
     * Delete admin member role ({@code DELETE /admin_member_roles/{member_role_id}}).
     *
     * @param memberRoleId the member role id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void deleteAdminMemberRole(final long memberRoleId) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "deleteApiV4AdminMemberRolesMemberRoleId");
        caller.send(delete(DELETE_ADMIN_MEMBER_ROLE, memberRoleId));
    }
}

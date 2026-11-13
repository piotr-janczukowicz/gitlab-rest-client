package io.github.piotr_janczukowicz.gitlab.api.groups;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabAuditEvent;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiResetTokenResult;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiRunnerWithUuid;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCluster;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabContainerRegistryRepository;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabGroup;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabGroupRepositoryStorageMove;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIdentityDetail;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMember;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNugetPackageMetadata;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNugetPackagesMetadata;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNugetSearchResults;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNugetServiceIndex;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabPackage;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabPackageDebianDistribution;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabPersonalAccessTokenWithToken;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProject;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserPublic;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.RequiresTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.client.pagination.GitLabListSpec;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPageRequest;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of group groups. */
public final class GitLabGroupGroupsApi extends GitLabResourceApi {
    private static final String PARAM_CODENAME = "codename";
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_ID = "id";
    private static final String PARAM_PACKAGENAME = "packageName";
    private static final String PARAM_PAYLOAD = "payload";
    private static final String PARAM_REQUEST = "request";
    private static final String PARAM_UID = "uid";
    private static final PathTemplate CREATE_DEPENDENCY_LIST_EXPORT =
            PathTemplate.of("/groups/{id}/dependency_list_exports");
    private static final PathTemplate LIST_REPOSITORY_STORAGE_MOVES =
            PathTemplate.of("/groups/{id}/repository_storage_moves");
    private static final PathTemplate GET_REPOSITORY_STORAGE_MOVE =
            PathTemplate.of("/groups/{id}/repository_storage_moves/{repository_storage_move_id}");
    private static final PathTemplate CALL_MANAGE_PERSONAL_ACCESS_TOKENS =
            PathTemplate.of("/groups/{id}/manage/personal_access_tokens");
    private static final PathTemplate DELETE_MANAGE_PERSONAL_ACCESS_TOKEN =
            PathTemplate.of("/groups/{id}/manage/personal_access_tokens/{pat_id}");
    private static final PathTemplate ROTATE_MANAGE_PERSONAL_ACCESS_TOKEN =
            PathTemplate.of("/groups/{id}/manage/personal_access_tokens/{pat_id}/rotate");
    private static final PathTemplate CALL_MANAGE_RESOURCE_ACCESS_TOKENS =
            PathTemplate.of("/groups/{id}/manage/resource_access_tokens");
    private static final PathTemplate DELETE_MANAGE_RESOURCE_ACCESS_TOKEN =
            PathTemplate.of("/groups/{id}/manage/resource_access_tokens/{prat_id}");
    private static final PathTemplate ROTATE_MANAGE_RESOURCE_ACCESS_TOKEN =
            PathTemplate.of("/groups/{id}/manage/resource_access_tokens/{prat_id}/rotate");
    private static final PathTemplate LIST_MANAGE_SSH_KEYS = PathTemplate.of("/groups/{id}/manage/ssh_keys");
    private static final PathTemplate DELETE_MANAGE_SSH_KEY = PathTemplate.of("/groups/{id}/manage/ssh_keys/{key_id}");
    private static final PathTemplate GET_SAML = PathTemplate.of("/groups/{id}/saml/{uid}");
    private static final PathTemplate GET_SCIM = PathTemplate.of("/groups/{id}/scim/{uid}");
    private static final PathTemplate LIST_APPROVAL_RULES = PathTemplate.of("/groups/{id}/approval_rules");
    private static final PathTemplate UPDATE_APPROVAL_RULE =
            PathTemplate.of("/groups/{id}/approval_rules/{approval_rule_id}");
    private static final PathTemplate CALL_PACKAGES_PYPI_FILE =
            PathTemplate.of("/groups/{id}/-/packages/pypi/files/{sha256}/{file_identifier}");
    private static final PathTemplate CALL_PACKAGES_PYPI_SIMPLE =
            PathTemplate.of("/groups/{id}/-/packages/pypi/simple");
    private static final PathTemplate CALL_PACKAGES_PYPI_SIMPLE_BY_PACKAGE_NAM =
            PathTemplate.of("/groups/{id}/-/packages/pypi/simple/{package_name}");
    private static final PathTemplate GET_PACKAGES_NUGET_INDEX = PathTemplate.of("/groups/{id}/-/packages/nuget/index");
    private static final PathTemplate CALL_PACKAGES_NUGET_SYMBOLFILE =
            PathTemplate.of("/groups/{id}/-/packages/nuget/symbolfiles/{file_name}/{signature}/{same_file_name}");
    private static final PathTemplate CALL_PACKAGES_NUGET_V2 = PathTemplate.of("/groups/{id}/-/packages/nuget/v2");
    private static final PathTemplate CALL_PACKAGES_NUGET_V2_METADATA =
            PathTemplate.of("/groups/{id}/-/packages/nuget/v2/$metadata");
    private static final PathTemplate GET_PACKAGES_NUGET_METADATA_INDEX =
            PathTemplate.of("/groups/{id}/-/packages/nuget/metadata/{package_name}/index");
    private static final PathTemplate GET_PACKAGES_NUGET_METADATA =
            PathTemplate.of("/groups/{id}/-/packages/nuget/metadata/{package_name}/{package_version}");
    private static final PathTemplate GET_PACKAGES_NUGET_QUERY = PathTemplate.of("/groups/{id}/-/packages/nuget/query");
    private static final PathTemplate LIST_BILLABLE_MEMBERS = PathTemplate.of("/groups/{id}/billable_members");
    private static final PathTemplate CALL_PACKAGES_MAVEN =
            PathTemplate.of("/groups/{id}/-/packages/maven/{path}/{file_name}");
    private static final PathTemplate LIST_PACKAGES = PathTemplate.of("/groups/{id}/packages");
    private static final PathTemplate LIST_DEBIAN_DISTRIBUTIONS =
            PathTemplate.of("/groups/{id}/-/debian_distributions");
    private static final PathTemplate GET_DEBIAN_DISTRIBUTION =
            PathTemplate.of("/groups/{id}/-/debian_distributions/{codename}");
    private static final PathTemplate GET_DEBIAN_DISTRIBUTIONS_KEY_ASC =
            PathTemplate.of("/groups/{id}/-/debian_distributions/{codename}/key.asc");
    private static final PathTemplate LIST_REGISTRY_REPOSITORIES =
            PathTemplate.of("/groups/{id}/registry/repositories");
    private static final PathTemplate LIST_CLUSTERS = PathTemplate.of("/groups/{id}/clusters");
    private static final PathTemplate GET_CLUSTER = PathTemplate.of("/groups/{id}/clusters/{cluster_id}");
    private static final PathTemplate USER_CLUSTER = PathTemplate.of("/groups/{id}/clusters/user");
    private static final PathTemplate GET_AVATAR = PathTemplate.of("/groups/{id}/avatar");
    private static final PathTemplate LIST_RUNNERS = PathTemplate.of("/groups/{id}/runners");
    private static final PathTemplate RESET_REGISTRATION_TOKEN_RUNNER =
            PathTemplate.of("/groups/{id}/runners/reset_registration_token");
    private static final PathTemplate LIST = PathTemplate.of("/groups");
    private static final PathTemplate GET = PathTemplate.of("/groups/{id}");
    private static final PathTemplate ARCHIVE = PathTemplate.of("/groups/{id}/archive");
    private static final PathTemplate UNARCHIVE = PathTemplate.of("/groups/{id}/unarchive");
    private static final PathTemplate RESTORE = PathTemplate.of("/groups/{id}/restore");
    private static final PathTemplate LIST_SHARED = PathTemplate.of("/groups/{id}/groups/shared");
    private static final PathTemplate LIST_INVITED_GROUPS = PathTemplate.of("/groups/{id}/invited_groups");
    private static final PathTemplate LIST_PROJECTS = PathTemplate.of("/groups/{id}/projects");
    private static final PathTemplate LIST_PROJECTS_SHARED = PathTemplate.of("/groups/{id}/projects/shared");
    private static final PathTemplate LIST_GROUP = PathTemplate.of("/groups/{id}/subgroups");
    private static final PathTemplate LIST_DESCENDANT_GROUPS = PathTemplate.of("/groups/{id}/descendant_groups");
    private static final PathTemplate CREATE_PROJECT = PathTemplate.of("/groups/{id}/projects/{project_id}");
    private static final PathTemplate LIST_TRANSFER_LOCATIONS = PathTemplate.of("/groups/{id}/transfer_locations");
    private static final PathTemplate TRANSFER = PathTemplate.of("/groups/{id}/transfer");
    private static final PathTemplate TRANSFER_TO_ORGANIZATION =
            PathTemplate.of("/groups/{id}/transfer_to_organization");
    private static final PathTemplate SHARE = PathTemplate.of("/groups/{id}/share");
    private static final PathTemplate DELETE_SHARE = PathTemplate.of("/groups/{id}/share/{group_id}");
    private static final PathTemplate DELETE_SHARED_PROJECT =
            PathTemplate.of("/groups/{id}/shared_projects/{project_id}");
    private static final PathTemplate LDAP_SYNC = PathTemplate.of("/groups/{id}/ldap_sync");
    private static final PathTemplate LIST_AUDIT_EVENTS = PathTemplate.of("/groups/{id}/audit_events");
    private static final PathTemplate GET_AUDIT_EVENT = PathTemplate.of("/groups/{id}/audit_events/{audit_event_id}");
    private static final PathTemplate LIST_SAML_USERS = PathTemplate.of("/groups/{id}/saml_users");
    private static final PathTemplate LIST_PROVISIONED_USERS = PathTemplate.of("/groups/{id}/provisioned_users");
    private static final JsonType<List<GitLabGroupRepositoryStorageMove>> GROUP_REPOSITORY_STORAGE_MOVE_LIST_TYPE =
            JsonTypes.listOf(GitLabGroupRepositoryStorageMove.class);
    private static final JsonType<List<GitLabSshKeyWithUserId>> SSH_KEY_WITH_USER_ID_LIST_TYPE =
            JsonTypes.listOf(GitLabSshKeyWithUserId.class);
    private static final JsonType<List<GitLabGroupApprovalRule>> GROUP_APPROVAL_RULE_LIST_TYPE =
            JsonTypes.listOf(GitLabGroupApprovalRule.class);
    private static final JsonType<List<GitLabMember>> MEMBER_LIST_TYPE = JsonTypes.listOf(GitLabMember.class);
    private static final JsonType<List<GitLabPackage>> PACKAGE_LIST_TYPE = JsonTypes.listOf(GitLabPackage.class);
    private static final JsonType<List<GitLabPackageDebianDistribution>> PACKAGE_DEBIAN_DISTRIBUTION_LIST_TYPE =
            JsonTypes.listOf(GitLabPackageDebianDistribution.class);
    private static final JsonType<List<GitLabContainerRegistryRepository>> CONTAINER_REGISTRY_REPOSITORY_LIST_TYPE =
            JsonTypes.listOf(GitLabContainerRegistryRepository.class);
    private static final JsonType<List<GitLabCluster>> CLUSTER_LIST_TYPE = JsonTypes.listOf(GitLabCluster.class);
    private static final JsonType<List<GitLabCiRunnerWithUuid>> CI_RUNNER_WITH_UUID_LIST_TYPE =
            JsonTypes.listOf(GitLabCiRunnerWithUuid.class);
    private static final JsonType<List<GitLabGroup>> GROUP_LIST_TYPE = JsonTypes.listOf(GitLabGroup.class);
    private static final JsonType<List<GitLabProject>> PROJECT_LIST_TYPE = JsonTypes.listOf(GitLabProject.class);
    private static final JsonType<List<GitLabAuditEvent>> AUDIT_EVENT_LIST_TYPE =
            JsonTypes.listOf(GitLabAuditEvent.class);
    private static final JsonType<List<GitLabUserPublic>> USER_PUBLIC_LIST_TYPE =
            JsonTypes.listOf(GitLabUserPublic.class);
    private static final GitLabListSpec<GitLabGroupRepositoryStorageMove> GROUP_REPOSITORY_STORAGE_MOVE_SPEC =
            GitLabListSpec.offset(GROUP_REPOSITORY_STORAGE_MOVE_LIST_TYPE);
    private static final GitLabListSpec<GitLabSshKeyWithUserId> SSH_KEY_WITH_USER_ID_SPEC =
            GitLabListSpec.offset(SSH_KEY_WITH_USER_ID_LIST_TYPE);
    private static final GitLabListSpec<GitLabGroupApprovalRule> GROUP_APPROVAL_RULE_SPEC =
            GitLabListSpec.offset(GROUP_APPROVAL_RULE_LIST_TYPE);
    private static final GitLabListSpec<GitLabMember> MEMBER_SPEC = GitLabListSpec.offset(MEMBER_LIST_TYPE);
    private static final GitLabListSpec<GitLabPackage> PACKAGE_SPEC = GitLabListSpec.offset(PACKAGE_LIST_TYPE);
    private static final GitLabListSpec<GitLabPackageDebianDistribution> PACKAGE_DEBIAN_DISTRIBUTION_SPEC =
            GitLabListSpec.offset(PACKAGE_DEBIAN_DISTRIBUTION_LIST_TYPE);
    private static final GitLabListSpec<GitLabContainerRegistryRepository> CONTAINER_REGISTRY_REPOSITORY_SPEC =
            GitLabListSpec.offset(CONTAINER_REGISTRY_REPOSITORY_LIST_TYPE);
    private static final GitLabListSpec<GitLabCluster> CLUSTER_SPEC = GitLabListSpec.offset(CLUSTER_LIST_TYPE);
    private static final GitLabListSpec<GitLabCiRunnerWithUuid> CI_RUNNER_WITH_UUID_SPEC =
            GitLabListSpec.offset(CI_RUNNER_WITH_UUID_LIST_TYPE);
    private static final GitLabListSpec<GitLabGroup> GROUP_KEYSET_SPEC = GitLabListSpec.offsetOrKeyset(GROUP_LIST_TYPE);
    private static final GitLabListSpec<GitLabGroup> GROUP_SPEC = GitLabListSpec.offset(GROUP_LIST_TYPE);
    private static final GitLabListSpec<GitLabProject> PROJECT_SPEC = GitLabListSpec.offset(PROJECT_LIST_TYPE);
    private static final GitLabListSpec<GitLabAuditEvent> AUDIT_EVENT_KEYSET_SPEC =
            GitLabListSpec.offsetOrKeyset(AUDIT_EVENT_LIST_TYPE);
    private static final GitLabListSpec<GitLabUserPublic> USER_PUBLIC_SPEC =
            GitLabListSpec.offset(USER_PUBLIC_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupGroupsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Create dependency list export ({@code POST /groups/{id}/dependency_list_exports}).
     *
     * @param id the id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void createDependencyListExport(
            final String id, final GitLabGroupGroupsCreateDependencyListExportPayload payload) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4GroupsIdDependencyListExports");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(CREATE_DEPENDENCY_LIST_EXPORT, id), payload));
    }

    /**
     * List repository storage moves ({@code GET /groups/{id}/repository_storage_moves}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabGroupRepositoryStorageMove> listRepositoryStorageMoves(final String id) throws IOException {
        return listRepositoryStorageMoves(id, GitLabPageRequest.byPage());
    }

    /**
     * List repository storage moves ({@code GET /groups/{id}/repository_storage_moves}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabGroupRepositoryStorageMove> listRepositoryStorageMoves(
            final String id, final GitLabPageRequest request) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdRepositoryStorageMoves");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_REPOSITORY_STORAGE_MOVES, Map.of(), request, GROUP_REPOSITORY_STORAGE_MOVE_SPEC, id);
    }

    /**
     * Create repository storage move ({@code POST /groups/{id}/repository_storage_moves}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabGroupRepositoryStorageMove createRepositoryStorageMove(
            final String id, final GitLabGroupGroupsCreateRepositoryStorageMovePayload payload) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4GroupsIdRepositoryStorageMoves");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(LIST_REPOSITORY_STORAGE_MOVES, id), payload), GitLabGroupRepositoryStorageMove.class);
    }

    /**
     * Get repository storage move ({@code GET /groups/{id}/repository_storage_moves/{repository_storage_move_id}}).
     *
     * @param id the id
     * @param repositoryStorageMoveId the repository storage move id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabGroupRepositoryStorageMove> getRepositoryStorageMove(
            final String id, final long repositoryStorageMoveId) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdRepositoryStorageMovesRepositoryStorageMoveId");
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(
                get(GET_REPOSITORY_STORAGE_MOVE, id, repositoryStorageMoveId), GitLabGroupRepositoryStorageMove.class);
    }

    /**
     * Call manage personal access tokens ({@code GET /groups/{id}/manage/personal_access_tokens}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void callManagePersonalAccessTokens(final String id) throws IOException {
        callManagePersonalAccessTokens(id, GitLabGroupGroupsCallManagePersonalAccessTokensFilter.empty());
    }

    /**
     * Call manage personal access tokens ({@code GET /groups/{id}/manage/personal_access_tokens}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void callManagePersonalAccessTokens(
            final String id, final GitLabGroupGroupsCallManagePersonalAccessTokensFilter filter) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4GroupsIdManagePersonalAccessTokens");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(get(CALL_MANAGE_PERSONAL_ACCESS_TOKENS, id).withQuery(queryParameters));
    }

    /**
     * Delete manage personal access token ({@code DELETE /groups/{id}/manage/personal_access_tokens/{pat_id}}).
     *
     * @param id the id
     * @param patId the pat id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void deleteManagePersonalAccessToken(final String id, final long patId) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "deleteApiV4GroupsIdManagePersonalAccessTokensPatId");
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(DELETE_MANAGE_PERSONAL_ACCESS_TOKEN, id, patId));
    }

    /**
     * Rotate manage personal access token ({@code POST /groups/{id}/manage/personal_access_tokens/{pat_id}/rotate}).
     *
     * @param id the id
     * @param patId the pat id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabPersonalAccessTokenWithToken rotateManagePersonalAccessToken(
            final String id, final long patId, final GitLabGroupGroupsRotateManagePersonalAccessTokenPayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4GroupsIdManagePersonalAccessTokensPatIdRotate");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(ROTATE_MANAGE_PERSONAL_ACCESS_TOKEN, id, patId), payload),
                GitLabPersonalAccessTokenWithToken.class);
    }

    /**
     * Call manage resource access tokens ({@code GET /groups/{id}/manage/resource_access_tokens}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void callManageResourceAccessTokens(final String id) throws IOException {
        callManageResourceAccessTokens(id, GitLabGroupGroupsCallManageResourceAccessTokensFilter.empty());
    }

    /**
     * Call manage resource access tokens ({@code GET /groups/{id}/manage/resource_access_tokens}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void callManageResourceAccessTokens(
            final String id, final GitLabGroupGroupsCallManageResourceAccessTokensFilter filter) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4GroupsIdManageResourceAccessTokens");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(get(CALL_MANAGE_RESOURCE_ACCESS_TOKENS, id).withQuery(queryParameters));
    }

    /**
     * Delete manage resource access token ({@code DELETE /groups/{id}/manage/resource_access_tokens/{prat_id}}).
     *
     * @param id the id
     * @param pratId the prat id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void deleteManageResourceAccessToken(final String id, final long pratId) throws IOException {
        deleteManageResourceAccessToken(id, pratId, GitLabGroupGroupsDeleteManageResourceAccessTokenFilter.empty());
    }

    /**
     * Delete manage resource access token ({@code DELETE /groups/{id}/manage/resource_access_tokens/{prat_id}}).
     *
     * @param id the id
     * @param pratId the prat id
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void deleteManageResourceAccessToken(
            final String id, final long pratId, final GitLabGroupGroupsDeleteManageResourceAccessTokenFilter filter)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "deleteApiV4GroupsIdManageResourceAccessTokensPratId");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(delete(DELETE_MANAGE_RESOURCE_ACCESS_TOKEN, id, pratId).withQuery(queryParameters));
    }

    /**
     * Rotate manage resource access token ({@code POST /groups/{id}/manage/resource_access_tokens/{prat_id}/rotate}).
     *
     * @param id the id
     * @param pratId the prat id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void rotateManageResourceAccessToken(
            final String id, final long pratId, final GitLabGroupGroupsRotateManageResourceAccessTokenPayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4GroupsIdManageResourceAccessTokensPratIdRotate");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(ROTATE_MANAGE_RESOURCE_ACCESS_TOKEN, id, pratId), payload));
    }

    /**
     * List manage ssh keys ({@code GET /groups/{id}/manage/ssh_keys}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabPage<GitLabSshKeyWithUserId> listManageSshKeys(final String id) throws IOException {
        return listManageSshKeys(id, GitLabGroupGroupsListManageSshKeysFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List manage ssh keys ({@code GET /groups/{id}/manage/ssh_keys}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabPage<GitLabSshKeyWithUserId> listManageSshKeys(final String id, final GitLabPageRequest request)
            throws IOException {
        return listManageSshKeys(id, GitLabGroupGroupsListManageSshKeysFilter.empty(), request);
    }

    /**
     * List manage ssh keys ({@code GET /groups/{id}/manage/ssh_keys}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabPage<GitLabSshKeyWithUserId> listManageSshKeys(
            final String id, final GitLabGroupGroupsListManageSshKeysFilter filter) throws IOException {
        return listManageSshKeys(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List manage ssh keys ({@code GET /groups/{id}/manage/ssh_keys}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabPage<GitLabSshKeyWithUserId> listManageSshKeys(
            final String id, final GitLabGroupGroupsListManageSshKeysFilter filter, final GitLabPageRequest request)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4GroupsIdManageSshKeys");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_MANAGE_SSH_KEYS, queryParameters, request, SSH_KEY_WITH_USER_ID_SPEC, id);
    }

    /**
     * Delete manage ssh key ({@code DELETE /groups/{id}/manage/ssh_keys/{key_id}}).
     *
     * @param id the id
     * @param keyId the key id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void deleteManageSshKey(final String id, final long keyId) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "deleteApiV4GroupsIdManageSshKeysKeyId");
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(DELETE_MANAGE_SSH_KEY, id, keyId));
    }

    /**
     * Get saml ({@code GET /groups/{id}/saml/{uid}}).
     *
     * @param id the id
     * @param uid the uid
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code uid} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabIdentityDetail> getSaml(final String id, final String uid) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdSamlUid");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(uid, PARAM_UID);
        return caller.fetchOrEmpty(get(GET_SAML, id, uid), GitLabIdentityDetail.class);
    }

    /**
     * Update saml ({@code PATCH /groups/{id}/saml/{uid}}).
     *
     * @param id the id
     * @param uid the uid
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code uid} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabIdentityDetail updateSaml(
            final String id, final String uid, final GitLabGroupGroupsUpdateSamlPayload payload) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "patchApiV4GroupsIdSamlUid");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(uid, PARAM_UID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(patch(GET_SAML, id, uid), payload), GitLabIdentityDetail.class);
    }

    /**
     * Delete saml ({@code DELETE /groups/{id}/saml/{uid}}).
     *
     * @param id the id
     * @param uid the uid
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} or {@code uid} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabIdentityDetail> deleteSaml(final String id, final String uid) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4GroupsIdSamlUid");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(uid, PARAM_UID);
        return caller.fetchOptional(delete(GET_SAML, id, uid), GitLabIdentityDetail.class);
    }

    /**
     * Get scim ({@code GET /groups/{id}/scim/{uid}}).
     *
     * @param id the id
     * @param uid the uid
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code uid} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabIdentityDetail> getScim(final String id, final String uid) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdScimUid");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(uid, PARAM_UID);
        return caller.fetchOrEmpty(get(GET_SCIM, id, uid), GitLabIdentityDetail.class);
    }

    /**
     * Update scim ({@code PATCH /groups/{id}/scim/{uid}}).
     *
     * @param id the id
     * @param uid the uid
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code uid} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabIdentityDetail updateScim(
            final String id, final String uid, final GitLabGroupGroupsUpdateScimPayload payload) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "patchApiV4GroupsIdScimUid");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(uid, PARAM_UID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(patch(GET_SCIM, id, uid), payload), GitLabIdentityDetail.class);
    }

    /**
     * Delete scim ({@code DELETE /groups/{id}/scim/{uid}}).
     *
     * @param id the id
     * @param uid the uid
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} or {@code uid} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabIdentityDetail> deleteScim(final String id, final String uid) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4GroupsIdScimUid");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(uid, PARAM_UID);
        return caller.fetchOptional(delete(GET_SCIM, id, uid), GitLabIdentityDetail.class);
    }

    /**
     * List approval rules ({@code GET /groups/{id}/approval_rules}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabGroupApprovalRule> listApprovalRules(final String id) throws IOException {
        return listApprovalRules(id, GitLabPageRequest.byPage());
    }

    /**
     * List approval rules ({@code GET /groups/{id}/approval_rules}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabGroupApprovalRule> listApprovalRules(final String id, final GitLabPageRequest request)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdApprovalRules");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_APPROVAL_RULES, Map.of(), request, GROUP_APPROVAL_RULE_SPEC, id);
    }

    /**
     * Create approval rule ({@code POST /groups/{id}/approval_rules}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabGroupApprovalRule createApprovalRule(
            final String id, final GitLabGroupGroupsCreateApprovalRulePayload payload) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4GroupsIdApprovalRules");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_APPROVAL_RULES, id), payload), GitLabGroupApprovalRule.class);
    }

    /**
     * Update approval rule ({@code PUT /groups/{id}/approval_rules/{approval_rule_id}}).
     *
     * @param id the id
     * @param approvalRuleId the approval rule id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabGroupApprovalRule updateApprovalRule(
            final String id, final long approvalRuleId, final GitLabGroupGroupsUpdateApprovalRulePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "putApiV4GroupsIdApprovalRulesApprovalRuleId");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(UPDATE_APPROVAL_RULE, id, approvalRuleId), payload), GitLabGroupApprovalRule.class);
    }

    /**
     * Call packages pypi file ({@code GET /groups/{id}/-/packages/pypi/files/{sha256}/{file_identifier}}).
     *
     * @param id the id
     * @param sha256 the sha256
     * @param fileIdentifier the file identifier
     * @throws IllegalArgumentException if {@code id}, {@code sha256} or {@code fileIdentifier} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callPackagesPypiFile(final String id, final String sha256, final String fileIdentifier)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(sha256, "sha256");
        requireNotBlank(fileIdentifier, "fileIdentifier");
        caller.send(get(CALL_PACKAGES_PYPI_FILE, id, sha256, fileIdentifier));
    }

    /**
     * Call packages pypi simple ({@code GET /groups/{id}/-/packages/pypi/simple}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callPackagesPypiSimple(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(get(CALL_PACKAGES_PYPI_SIMPLE, id));
    }

    /**
     * Call packages pypi simple by package name ({@code GET /groups/{id}/-/packages/pypi/simple/{package_name}}).
     *
     * @param id the id
     * @param packageName the package name
     * @throws IllegalArgumentException if {@code id} or {@code packageName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callPackagesPypiSimpleByPackageName(final String id, final String packageName) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        caller.send(get(CALL_PACKAGES_PYPI_SIMPLE_BY_PACKAGE_NAM, id, packageName));
    }

    /**
     * Get packages nuget index ({@code GET /groups/{id}/-/packages/nuget/index}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabNugetServiceIndex getPackagesNugetIndex(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(GET_PACKAGES_NUGET_INDEX, id), GitLabNugetServiceIndex.class);
    }

    /**
     * Call packages nuget symbolfile ({@code GET
     * /groups/{id}/-/packages/nuget/symbolfiles/{file_name}/{signature}/{same_file_name}}).
     *
     * @param id the id
     * @param fileName the file name
     * @param signature the signature
     * @param sameFileName the same file name
     * @throws IllegalArgumentException if {@code id}, {@code fileName}, {@code signature} or {@code sameFileName} is
     *     blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callPackagesNugetSymbolfile(
            final String id, final String fileName, final String signature, final String sameFileName)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(fileName, "fileName");
        requireNotBlank(signature, "signature");
        requireNotBlank(sameFileName, "sameFileName");
        caller.send(get(CALL_PACKAGES_NUGET_SYMBOLFILE, id, fileName, signature, sameFileName));
    }

    /**
     * Call packages nuget v2 ({@code GET /groups/{id}/-/packages/nuget/v2}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callPackagesNugetV2(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(get(CALL_PACKAGES_NUGET_V2, id));
    }

    /**
     * Call packages nuget v2 metadata ({@code GET /groups/{id}/-/packages/nuget/v2/$metadata}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callPackagesNugetV2Metadata(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(get(CALL_PACKAGES_NUGET_V2_METADATA, id));
    }

    /**
     * Get packages nuget metadata index ({@code GET /groups/{id}/-/packages/nuget/metadata/{package_name}/index}).
     *
     * @param id the id
     * @param packageName the package name
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code packageName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabNugetPackagesMetadata> getPackagesNugetMetadataIndex(
            final String id, final String packageName) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        return caller.fetchOrEmpty(
                get(GET_PACKAGES_NUGET_METADATA_INDEX, id, packageName), GitLabNugetPackagesMetadata.class);
    }

    /**
     * Get packages nuget metadata ({@code GET
     * /groups/{id}/-/packages/nuget/metadata/{package_name}/{package_version}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id}, {@code packageName} or {@code packageVersion} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabNugetPackageMetadata> getPackagesNugetMetadata(
            final String id, final String packageName, final String packageVersion) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, "packageVersion");
        return caller.fetchOrEmpty(
                get(GET_PACKAGES_NUGET_METADATA, id, packageName, packageVersion), GitLabNugetPackageMetadata.class);
    }

    /**
     * Get packages nuget query ({@code GET /groups/{id}/-/packages/nuget/query}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabNugetSearchResults getPackagesNugetQuery(final String id) throws IOException {
        return getPackagesNugetQuery(id, GitLabGroupGroupsGetPackagesNugetQueryFilter.empty());
    }

    /**
     * Get packages nuget query ({@code GET /groups/{id}/-/packages/nuget/query}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabNugetSearchResults getPackagesNugetQuery(
            final String id, final GitLabGroupGroupsGetPackagesNugetQueryFilter filter) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetch(
                get(GET_PACKAGES_NUGET_QUERY, id).withQuery(queryParameters), GitLabNugetSearchResults.class);
    }

    /**
     * List billable members ({@code GET /groups/{id}/billable_members}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMember> listBillableMembers(final String id) throws IOException {
        return listBillableMembers(id, GitLabGroupGroupsListBillableMembersFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List billable members ({@code GET /groups/{id}/billable_members}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMember> listBillableMembers(final String id, final GitLabPageRequest request)
            throws IOException {
        return listBillableMembers(id, GitLabGroupGroupsListBillableMembersFilter.empty(), request);
    }

    /**
     * List billable members ({@code GET /groups/{id}/billable_members}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMember> listBillableMembers(
            final String id, final GitLabGroupGroupsListBillableMembersFilter filter) throws IOException {
        return listBillableMembers(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List billable members ({@code GET /groups/{id}/billable_members}).
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
    public GitLabPage<GitLabMember> listBillableMembers(
            final String id, final GitLabGroupGroupsListBillableMembersFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_BILLABLE_MEMBERS, queryParameters, request, MEMBER_SPEC, id);
    }

    /**
     * Call packages maven ({@code GET /groups/{id}/-/packages/maven/{path}/{file_name}}).
     *
     * @param id the id
     * @param path the path
     * @param fileName the file name
     * @throws IllegalArgumentException if {@code id}, {@code path} or {@code fileName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callPackagesMaven(final String id, final String path, final String fileName) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(path, "path");
        requireNotBlank(fileName, "fileName");
        caller.send(get(CALL_PACKAGES_MAVEN, id, path, fileName));
    }

    /**
     * List packages ({@code GET /groups/{id}/packages}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPackage> listPackages(final String id) throws IOException {
        return listPackages(id, GitLabGroupGroupsListPackagesFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List packages ({@code GET /groups/{id}/packages}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPackage> listPackages(final String id, final GitLabPageRequest request) throws IOException {
        return listPackages(id, GitLabGroupGroupsListPackagesFilter.empty(), request);
    }

    /**
     * List packages ({@code GET /groups/{id}/packages}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPackage> listPackages(final String id, final GitLabGroupGroupsListPackagesFilter filter)
            throws IOException {
        return listPackages(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List packages ({@code GET /groups/{id}/packages}).
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
    public GitLabPage<GitLabPackage> listPackages(
            final String id, final GitLabGroupGroupsListPackagesFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_PACKAGES, queryParameters, request, PACKAGE_SPEC, id);
    }

    /**
     * List debian distributions ({@code GET /groups/{id}/-/debian_distributions}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPackageDebianDistribution> listDebianDistributions(final String id) throws IOException {
        return listDebianDistributions(
                id, GitLabGroupGroupsListDebianDistributionsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List debian distributions ({@code GET /groups/{id}/-/debian_distributions}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPackageDebianDistribution> listDebianDistributions(
            final String id, final GitLabPageRequest request) throws IOException {
        return listDebianDistributions(id, GitLabGroupGroupsListDebianDistributionsFilter.empty(), request);
    }

    /**
     * List debian distributions ({@code GET /groups/{id}/-/debian_distributions}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPackageDebianDistribution> listDebianDistributions(
            final String id, final GitLabGroupGroupsListDebianDistributionsFilter filter) throws IOException {
        return listDebianDistributions(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List debian distributions ({@code GET /groups/{id}/-/debian_distributions}).
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
    public GitLabPage<GitLabPackageDebianDistribution> listDebianDistributions(
            final String id,
            final GitLabGroupGroupsListDebianDistributionsFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_DEBIAN_DISTRIBUTIONS, queryParameters, request, PACKAGE_DEBIAN_DISTRIBUTION_SPEC, id);
    }

    /**
     * Create debian distribution ({@code POST /groups/{id}/-/debian_distributions}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPackageDebianDistribution createDebianDistribution(
            final String id, final GitLabGroupGroupsCreateDebianDistributionPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(LIST_DEBIAN_DISTRIBUTIONS, id), payload), GitLabPackageDebianDistribution.class);
    }

    /**
     * Get debian distribution ({@code GET /groups/{id}/-/debian_distributions/{codename}}).
     *
     * @param id the id
     * @param codename the codename
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code codename} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabPackageDebianDistribution> getDebianDistribution(final String id, final String codename)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(codename, PARAM_CODENAME);
        return caller.fetchOrEmpty(get(GET_DEBIAN_DISTRIBUTION, id, codename), GitLabPackageDebianDistribution.class);
    }

    /**
     * Update debian distribution ({@code PUT /groups/{id}/-/debian_distributions/{codename}}).
     *
     * @param id the id
     * @param codename the codename
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code codename} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPackageDebianDistribution updateDebianDistribution(
            final String id, final String codename, final GitLabGroupGroupsUpdateDebianDistributionPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(codename, PARAM_CODENAME);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(GET_DEBIAN_DISTRIBUTION, id, codename), payload),
                GitLabPackageDebianDistribution.class);
    }

    /**
     * Delete debian distribution ({@code DELETE /groups/{id}/-/debian_distributions/{codename}}).
     *
     * @param id the id
     * @param codename the codename
     * @throws IllegalArgumentException if {@code id} or {@code codename} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteDebianDistribution(final String id, final String codename) throws IOException {
        deleteDebianDistribution(id, codename, GitLabGroupGroupsDeleteDebianDistributionFilter.empty());
    }

    /**
     * Delete debian distribution ({@code DELETE /groups/{id}/-/debian_distributions/{codename}}).
     *
     * @param id the id
     * @param codename the codename
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id} or {@code codename} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteDebianDistribution(
            final String id, final String codename, final GitLabGroupGroupsDeleteDebianDistributionFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(codename, PARAM_CODENAME);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(delete(GET_DEBIAN_DISTRIBUTION, id, codename).withQuery(queryParameters));
    }

    /**
     * Get debian distributions key asc ({@code GET /groups/{id}/-/debian_distributions/{codename}/key.asc}).
     *
     * @param id the id
     * @param codename the codename
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code codename} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabPackageDebianDistribution> getDebianDistributionsKeyAsc(
            final String id, final String codename) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(codename, PARAM_CODENAME);
        return caller.fetchOrEmpty(
                get(GET_DEBIAN_DISTRIBUTIONS_KEY_ASC, id, codename), GitLabPackageDebianDistribution.class);
    }

    /**
     * List registry repositories ({@code GET /groups/{id}/registry/repositories}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabContainerRegistryRepository> listRegistryRepositories(final String id) throws IOException {
        return listRegistryRepositories(id, GitLabPageRequest.byPage());
    }

    /**
     * List registry repositories ({@code GET /groups/{id}/registry/repositories}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabContainerRegistryRepository> listRegistryRepositories(
            final String id, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_REGISTRY_REPOSITORIES, Map.of(), request, CONTAINER_REGISTRY_REPOSITORY_SPEC, id);
    }

    /**
     * List clusters ({@code GET /groups/{id}/clusters}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCluster> listClusters(final String id) throws IOException {
        return listClusters(id, GitLabPageRequest.byPage());
    }

    /**
     * List clusters ({@code GET /groups/{id}/clusters}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCluster> listClusters(final String id, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_CLUSTERS, Map.of(), request, CLUSTER_SPEC, id);
    }

    /**
     * Get cluster ({@code GET /groups/{id}/clusters/{cluster_id}}).
     *
     * @param id the id
     * @param clusterId the cluster id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabClusterGroup> getCluster(final String id, final long clusterId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_CLUSTER, id, clusterId), GitLabClusterGroup.class);
    }

    /**
     * Update cluster ({@code PUT /groups/{id}/clusters/{cluster_id}}).
     *
     * @param id the id
     * @param clusterId the cluster id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabClusterGroup updateCluster(
            final String id, final long clusterId, final GitLabGroupGroupsUpdateClusterPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET_CLUSTER, id, clusterId), payload), GitLabClusterGroup.class);
    }

    /**
     * Delete cluster ({@code DELETE /groups/{id}/clusters/{cluster_id}}).
     *
     * @param id the id
     * @param clusterId the cluster id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabClusterGroup> deleteCluster(final String id, final long clusterId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOptional(delete(GET_CLUSTER, id, clusterId), GitLabClusterGroup.class);
    }

    /**
     * User cluster ({@code POST /groups/{id}/clusters/user}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabClusterGroup userCluster(final String id, final GitLabGroupClusterUserCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(USER_CLUSTER, id), payload), GitLabClusterGroup.class);
    }

    /**
     * Get avatar ({@code GET /groups/{id}/avatar}).
     *
     * @param id the id
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getAvatar(final String id, final OutputStream out) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(out, "out");
        return caller.download(get(GET_AVATAR, id), out);
    }

    /**
     * Get avatar ({@code GET /groups/{id}/avatar}).
     *
     * @param id the id
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getAvatar(final String id, final Path target) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(target, "target");
        return caller.download(get(GET_AVATAR, id), target);
    }

    /**
     * List runners ({@code GET /groups/{id}/runners}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiRunnerWithUuid> listRunners(final String id) throws IOException {
        return listRunners(id, GitLabGroupGroupsListRunnersFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List runners ({@code GET /groups/{id}/runners}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiRunnerWithUuid> listRunners(final String id, final GitLabPageRequest request)
            throws IOException {
        return listRunners(id, GitLabGroupGroupsListRunnersFilter.empty(), request);
    }

    /**
     * List runners ({@code GET /groups/{id}/runners}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiRunnerWithUuid> listRunners(
            final String id, final GitLabGroupGroupsListRunnersFilter filter) throws IOException {
        return listRunners(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List runners ({@code GET /groups/{id}/runners}).
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
    public GitLabPage<GitLabCiRunnerWithUuid> listRunners(
            final String id, final GitLabGroupGroupsListRunnersFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_RUNNERS, queryParameters, request, CI_RUNNER_WITH_UUID_SPEC, id);
    }

    /**
     * Reset registration token runner ({@code POST /groups/{id}/runners/reset_registration_token}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiResetTokenResult resetRegistrationTokenRunner(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(RESET_REGISTRATION_TOKEN_RUNNER, id), GitLabCiResetTokenResult.class);
    }

    /**
     * List ({@code GET /groups}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabGroup> list() throws IOException {
        return list(GitLabGroupGroupsListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /groups}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabGroup> list(final GitLabPageRequest request) throws IOException {
        return list(GitLabGroupGroupsListFilter.empty(), request);
    }

    /**
     * List ({@code GET /groups}).
     *
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabGroup> list(final GitLabGroupGroupsListFilter filter) throws IOException {
        return list(filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /groups}).
     *
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabGroup> list(final GitLabGroupGroupsListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, GROUP_KEYSET_SPEC);
    }

    /**
     * Create ({@code POST /groups}).
     *
     * @param form the form to send
     * @return the resource
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabGroup create(final MultipartFormData form) throws IOException {
        requireNonNull(form, "form");
        return caller.fetch(caller.multipart(post(LIST), form), GitLabGroup.class);
    }

    /**
     * Get ({@code GET /groups/{id}}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabGroupDetail> get(final String id) throws IOException {
        return get(id, GitLabGroupGroupsGetFilter.empty());
    }

    /**
     * Get ({@code GET /groups/{id}}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabGroupDetail> get(final String id, final GitLabGroupGroupsGetFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOrEmpty(get(GET, id).withQuery(queryParameters), GitLabGroupDetail.class);
    }

    /**
     * Update ({@code PUT /groups/{id}}).
     *
     * @param id the id
     * @param form the form to send
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabGroupDetail update(final String id, final MultipartFormData form) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(form, "form");
        return caller.fetch(caller.multipart(put(GET, id), form), GitLabGroupDetail.class);
    }

    /**
     * Delete ({@code DELETE /groups/{id}}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET, id));
    }

    /**
     * Archive ({@code POST /groups/{id}/archive}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabGroup archive(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(ARCHIVE, id), GitLabGroup.class);
    }

    /**
     * Unarchive ({@code POST /groups/{id}/unarchive}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabGroup unarchive(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(UNARCHIVE, id), GitLabGroup.class);
    }

    /**
     * Restore ({@code POST /groups/{id}/restore}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void restore(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(post(RESTORE, id));
    }

    /**
     * List shared ({@code GET /groups/{id}/groups/shared}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabGroup> listShared(final String id) throws IOException {
        return listShared(id, GitLabGroupGroupsListSharedFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List shared ({@code GET /groups/{id}/groups/shared}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabGroup> listShared(final String id, final GitLabPageRequest request) throws IOException {
        return listShared(id, GitLabGroupGroupsListSharedFilter.empty(), request);
    }

    /**
     * List shared ({@code GET /groups/{id}/groups/shared}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabGroup> listShared(final String id, final GitLabGroupGroupsListSharedFilter filter)
            throws IOException {
        return listShared(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List shared ({@code GET /groups/{id}/groups/shared}).
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
    public GitLabPage<GitLabGroup> listShared(
            final String id, final GitLabGroupGroupsListSharedFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_SHARED, queryParameters, request, GROUP_SPEC, id);
    }

    /**
     * List invited groups ({@code GET /groups/{id}/invited_groups}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabGroup> listInvitedGroups(final String id) throws IOException {
        return listInvitedGroups(id, GitLabGroupGroupsListInvitedGroupsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List invited groups ({@code GET /groups/{id}/invited_groups}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabGroup> listInvitedGroups(final String id, final GitLabPageRequest request)
            throws IOException {
        return listInvitedGroups(id, GitLabGroupGroupsListInvitedGroupsFilter.empty(), request);
    }

    /**
     * List invited groups ({@code GET /groups/{id}/invited_groups}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabGroup> listInvitedGroups(
            final String id, final GitLabGroupGroupsListInvitedGroupsFilter filter) throws IOException {
        return listInvitedGroups(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List invited groups ({@code GET /groups/{id}/invited_groups}).
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
    public GitLabPage<GitLabGroup> listInvitedGroups(
            final String id, final GitLabGroupGroupsListInvitedGroupsFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_INVITED_GROUPS, queryParameters, request, GROUP_SPEC, id);
    }

    /**
     * List projects ({@code GET /groups/{id}/projects}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProject> listProjects(final String id) throws IOException {
        return listProjects(id, GitLabGroupGroupsListProjectsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List projects ({@code GET /groups/{id}/projects}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProject> listProjects(final String id, final GitLabPageRequest request) throws IOException {
        return listProjects(id, GitLabGroupGroupsListProjectsFilter.empty(), request);
    }

    /**
     * List projects ({@code GET /groups/{id}/projects}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProject> listProjects(final String id, final GitLabGroupGroupsListProjectsFilter filter)
            throws IOException {
        return listProjects(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List projects ({@code GET /groups/{id}/projects}).
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
    public GitLabPage<GitLabProject> listProjects(
            final String id, final GitLabGroupGroupsListProjectsFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_PROJECTS, queryParameters, request, PROJECT_SPEC, id);
    }

    /**
     * List projects shared ({@code GET /groups/{id}/projects/shared}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProject> listProjectsShared(final String id) throws IOException {
        return listProjectsShared(id, GitLabGroupGroupsListProjectsSharedFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List projects shared ({@code GET /groups/{id}/projects/shared}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProject> listProjectsShared(final String id, final GitLabPageRequest request)
            throws IOException {
        return listProjectsShared(id, GitLabGroupGroupsListProjectsSharedFilter.empty(), request);
    }

    /**
     * List projects shared ({@code GET /groups/{id}/projects/shared}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabProject> listProjectsShared(
            final String id, final GitLabGroupGroupsListProjectsSharedFilter filter) throws IOException {
        return listProjectsShared(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List projects shared ({@code GET /groups/{id}/projects/shared}).
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
    public GitLabPage<GitLabProject> listProjectsShared(
            final String id, final GitLabGroupGroupsListProjectsSharedFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_PROJECTS_SHARED, queryParameters, request, PROJECT_SPEC, id);
    }

    /**
     * List group ({@code GET /groups/{id}/subgroups}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabGroup> listGroup(final String id) throws IOException {
        return listGroup(id, GitLabGroupGroupsListGroupFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List group ({@code GET /groups/{id}/subgroups}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabGroup> listGroup(final String id, final GitLabPageRequest request) throws IOException {
        return listGroup(id, GitLabGroupGroupsListGroupFilter.empty(), request);
    }

    /**
     * List group ({@code GET /groups/{id}/subgroups}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabGroup> listGroup(final String id, final GitLabGroupGroupsListGroupFilter filter)
            throws IOException {
        return listGroup(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List group ({@code GET /groups/{id}/subgroups}).
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
    public GitLabPage<GitLabGroup> listGroup(
            final String id, final GitLabGroupGroupsListGroupFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_GROUP, queryParameters, request, GROUP_SPEC, id);
    }

    /**
     * List descendant groups ({@code GET /groups/{id}/descendant_groups}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabGroup> listDescendantGroups(final String id) throws IOException {
        return listDescendantGroups(
                id, GitLabGroupGroupsListDescendantGroupsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List descendant groups ({@code GET /groups/{id}/descendant_groups}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabGroup> listDescendantGroups(final String id, final GitLabPageRequest request)
            throws IOException {
        return listDescendantGroups(id, GitLabGroupGroupsListDescendantGroupsFilter.empty(), request);
    }

    /**
     * List descendant groups ({@code GET /groups/{id}/descendant_groups}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabGroup> listDescendantGroups(
            final String id, final GitLabGroupGroupsListDescendantGroupsFilter filter) throws IOException {
        return listDescendantGroups(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List descendant groups ({@code GET /groups/{id}/descendant_groups}).
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
    public GitLabPage<GitLabGroup> listDescendantGroups(
            final String id, final GitLabGroupGroupsListDescendantGroupsFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_DESCENDANT_GROUPS, queryParameters, request, GROUP_SPEC, id);
    }

    /**
     * Create project ({@code POST /groups/{id}/projects/{project_id}}).
     *
     * @param id the id
     * @param projectId the project id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code projectId} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabGroupDetail createProject(final String id, final String projectId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(projectId, "projectId");
        return caller.fetch(post(CREATE_PROJECT, id, projectId), GitLabGroupDetail.class);
    }

    /**
     * List transfer locations ({@code GET /groups/{id}/transfer_locations}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabGroup> listTransferLocations(final String id) throws IOException {
        return listTransferLocations(
                id, GitLabGroupGroupsListTransferLocationsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List transfer locations ({@code GET /groups/{id}/transfer_locations}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabGroup> listTransferLocations(final String id, final GitLabPageRequest request)
            throws IOException {
        return listTransferLocations(id, GitLabGroupGroupsListTransferLocationsFilter.empty(), request);
    }

    /**
     * List transfer locations ({@code GET /groups/{id}/transfer_locations}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabGroup> listTransferLocations(
            final String id, final GitLabGroupGroupsListTransferLocationsFilter filter) throws IOException {
        return listTransferLocations(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List transfer locations ({@code GET /groups/{id}/transfer_locations}).
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
    public GitLabPage<GitLabGroup> listTransferLocations(
            final String id, final GitLabGroupGroupsListTransferLocationsFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_TRANSFER_LOCATIONS, queryParameters, request, GROUP_SPEC, id);
    }

    /**
     * Transfer ({@code POST /groups/{id}/transfer}).
     *
     * @param id the id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void transfer(final String id, final GitLabGroupGroupsTransferPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(TRANSFER, id), payload));
    }

    /**
     * Transfer to organization ({@code POST /groups/{id}/transfer_to_organization}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabGroupDetail transferToOrganization(
            final String id, final GitLabGroupGroupsTransferToOrganizationPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(TRANSFER_TO_ORGANIZATION, id), payload), GitLabGroupDetail.class);
    }

    /**
     * Share ({@code POST /groups/{id}/share}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabGroupDetail share(final String id, final GitLabGroupGroupsSharePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(SHARE, id), payload), GitLabGroupDetail.class);
    }

    /**
     * Delete share ({@code DELETE /groups/{id}/share/{group_id}}).
     *
     * @param id the id
     * @param groupId the group id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteShare(final String id, final long groupId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(DELETE_SHARE, id, groupId));
    }

    /**
     * Delete shared project ({@code DELETE /groups/{id}/shared_projects/{project_id}}).
     *
     * @param id the id
     * @param projectId the project id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteSharedProject(final String id, final long projectId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(DELETE_SHARED_PROJECT, id, projectId));
    }

    /**
     * Ldap sync ({@code POST /groups/{id}/ldap_sync}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void ldapSync(final String id) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4GroupsIdLdapSync");
        requireNotBlank(id, PARAM_ID);
        caller.send(post(LDAP_SYNC, id));
    }

    /**
     * List audit events ({@code GET /groups/{id}/audit_events}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAuditEvent> listAuditEvents(final String id) throws IOException {
        return listAuditEvents(id, GitLabGroupGroupsListAuditEventsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List audit events ({@code GET /groups/{id}/audit_events}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAuditEvent> listAuditEvents(final String id, final GitLabPageRequest request)
            throws IOException {
        return listAuditEvents(id, GitLabGroupGroupsListAuditEventsFilter.empty(), request);
    }

    /**
     * List audit events ({@code GET /groups/{id}/audit_events}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAuditEvent> listAuditEvents(
            final String id, final GitLabGroupGroupsListAuditEventsFilter filter) throws IOException {
        return listAuditEvents(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List audit events ({@code GET /groups/{id}/audit_events}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAuditEvent> listAuditEvents(
            final String id, final GitLabGroupGroupsListAuditEventsFilter filter, final GitLabPageRequest request)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdAuditEvents");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_AUDIT_EVENTS, queryParameters, request, AUDIT_EVENT_KEYSET_SPEC, id);
    }

    /**
     * Get audit event ({@code GET /groups/{id}/audit_events/{audit_event_id}}).
     *
     * @param id the id
     * @param auditEventId the audit event id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabAuditEvent> getAuditEvent(final String id, final long auditEventId) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdAuditEventsAuditEventId");
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_AUDIT_EVENT, id, auditEventId), GitLabAuditEvent.class);
    }

    /**
     * List saml users ({@code GET /groups/{id}/saml_users}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabUserPublic> listSamlUsers(final String id) throws IOException {
        return listSamlUsers(id, GitLabGroupGroupsListSamlUsersFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List saml users ({@code GET /groups/{id}/saml_users}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabUserPublic> listSamlUsers(final String id, final GitLabPageRequest request)
            throws IOException {
        return listSamlUsers(id, GitLabGroupGroupsListSamlUsersFilter.empty(), request);
    }

    /**
     * List saml users ({@code GET /groups/{id}/saml_users}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabUserPublic> listSamlUsers(
            final String id, final GitLabGroupGroupsListSamlUsersFilter filter) throws IOException {
        return listSamlUsers(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List saml users ({@code GET /groups/{id}/saml_users}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabUserPublic> listSamlUsers(
            final String id, final GitLabGroupGroupsListSamlUsersFilter filter, final GitLabPageRequest request)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdSamlUsers");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_SAML_USERS, queryParameters, request, USER_PUBLIC_SPEC, id);
    }

    /**
     * List provisioned users ({@code GET /groups/{id}/provisioned_users}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabUserPublic> listProvisionedUsers(final String id) throws IOException {
        return listProvisionedUsers(
                id, GitLabGroupGroupsListProvisionedUsersFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List provisioned users ({@code GET /groups/{id}/provisioned_users}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabUserPublic> listProvisionedUsers(final String id, final GitLabPageRequest request)
            throws IOException {
        return listProvisionedUsers(id, GitLabGroupGroupsListProvisionedUsersFilter.empty(), request);
    }

    /**
     * List provisioned users ({@code GET /groups/{id}/provisioned_users}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabUserPublic> listProvisionedUsers(
            final String id, final GitLabGroupGroupsListProvisionedUsersFilter filter) throws IOException {
        return listProvisionedUsers(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List provisioned users ({@code GET /groups/{id}/provisioned_users}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabUserPublic> listProvisionedUsers(
            final String id, final GitLabGroupGroupsListProvisionedUsersFilter filter, final GitLabPageRequest request)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdProvisionedUsers");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_PROVISIONED_USERS, queryParameters, request, USER_PUBLIC_SPEC, id);
    }
}

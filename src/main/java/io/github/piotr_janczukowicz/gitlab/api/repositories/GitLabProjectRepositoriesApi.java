package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCommit;
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

/** The GitLab operations of project repositories. */
public final class GitLabProjectRepositoriesApi extends GitLabResourceApi {
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_FROM = "from";
    private static final String PARAM_FROMVALUE = "fromValue";
    private static final String PARAM_ID = "id";
    private static final String PARAM_REQUEST = "request";
    private static final String PARAM_TO = "to";
    private static final PathTemplate LIST_TREE = PathTemplate.of("/projects/{id}/repository/tree");
    private static final PathTemplate CALL_BLOBS_RAW = PathTemplate.of("/projects/{id}/repository/blobs/{sha}/raw");
    private static final PathTemplate CALL_BLOB = PathTemplate.of("/projects/{id}/repository/blobs/{sha}");
    private static final PathTemplate CALL_ARCHIVE = PathTemplate.of("/projects/{id}/repository/archive");
    private static final PathTemplate GET_COMPARE = PathTemplate.of("/projects/{id}/repository/compare");
    private static final PathTemplate GET_HEALTH = PathTemplate.of("/projects/{id}/repository/health");
    private static final PathTemplate LIST_CONTRIBUTORS = PathTemplate.of("/projects/{id}/repository/contributors");
    private static final PathTemplate GET_MERGE_BASE = PathTemplate.of("/projects/{id}/repository/merge_base");
    private static final PathTemplate BATCH_BLOB = PathTemplate.of("/projects/{id}/repository/blobs/batch");
    private static final PathTemplate LIST_CHANGED_PATHS = PathTemplate.of("/projects/{id}/repository/changed_paths");
    private static final PathTemplate GET_DIVERGING_COMMITS =
            PathTemplate.of("/projects/{id}/repository/diverging_commits");
    private static final PathTemplate LIST_DIFF_STATS = PathTemplate.of("/projects/{id}/repository/diff_stats");
    private static final PathTemplate GET_CHANGELOG = PathTemplate.of("/projects/{id}/repository/changelog");
    private static final JsonType<List<GitLabTreeObject>> TREE_OBJECT_LIST_TYPE =
            JsonTypes.listOf(GitLabTreeObject.class);
    private static final JsonType<List<GitLabContributor>> CONTRIBUTOR_LIST_TYPE =
            JsonTypes.listOf(GitLabContributor.class);
    private static final JsonType<List<GitLabBatchBlob>> BATCH_BLOB_LIST_TYPE = JsonTypes.listOf(GitLabBatchBlob.class);
    private static final JsonType<List<GitLabChangedPath>> CHANGED_PATH_LIST_TYPE =
            JsonTypes.listOf(GitLabChangedPath.class);
    private static final JsonType<List<GitLabDiffStat>> DIFF_STAT_LIST_TYPE = JsonTypes.listOf(GitLabDiffStat.class);
    private static final GitLabListSpec<GitLabTreeObject> TREE_OBJECT_KEYSET_SPEC =
            GitLabListSpec.offsetOrKeyset(TREE_OBJECT_LIST_TYPE);
    private static final GitLabListSpec<GitLabContributor> CONTRIBUTOR_SPEC =
            GitLabListSpec.offset(CONTRIBUTOR_LIST_TYPE);
    private static final GitLabListSpec<GitLabChangedPath> CHANGED_PATH_SPEC =
            GitLabListSpec.offset(CHANGED_PATH_LIST_TYPE);
    private static final GitLabListSpec<GitLabDiffStat> DIFF_STAT_SPEC = GitLabListSpec.offset(DIFF_STAT_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectRepositoriesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List tree ({@code GET /projects/{id}/repository/tree}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabTreeObject> listTree(final String id) throws IOException {
        return listTree(id, GitLabProjectRepositoriesListTreeFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List tree ({@code GET /projects/{id}/repository/tree}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabTreeObject> listTree(final String id, final GitLabPageRequest request) throws IOException {
        return listTree(id, GitLabProjectRepositoriesListTreeFilter.empty(), request);
    }

    /**
     * List tree ({@code GET /projects/{id}/repository/tree}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabTreeObject> listTree(final String id, final GitLabProjectRepositoriesListTreeFilter filter)
            throws IOException {
        return listTree(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List tree ({@code GET /projects/{id}/repository/tree}).
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
    public GitLabPage<GitLabTreeObject> listTree(
            final String id, final GitLabProjectRepositoriesListTreeFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_TREE, queryParameters, request, TREE_OBJECT_KEYSET_SPEC, id);
    }

    /**
     * Call blobs raw ({@code GET /projects/{id}/repository/blobs/{sha}/raw}).
     *
     * @param id the id
     * @param sha the sha
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callBlobsRaw(final String id, final String sha) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(sha, "sha");
        caller.send(get(CALL_BLOBS_RAW, id, sha));
    }

    /**
     * Call blob ({@code GET /projects/{id}/repository/blobs/{sha}}).
     *
     * @param id the id
     * @param sha the sha
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callBlob(final String id, final String sha) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(sha, "sha");
        caller.send(get(CALL_BLOB, id, sha));
    }

    /**
     * Call archive ({@code GET /projects/{id}/repository/archive}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callArchive(final String id) throws IOException {
        callArchive(id, GitLabProjectRepositoriesCallArchiveFilter.empty());
    }

    /**
     * Call archive ({@code GET /projects/{id}/repository/archive}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callArchive(final String id, final GitLabProjectRepositoriesCallArchiveFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(get(CALL_ARCHIVE, id).withQuery(queryParameters));
    }

    /**
     * Get compare ({@code GET /projects/{id}/repository/compare}).
     *
     * @param id the id
     * @param fromValue the from
     * @param to the to
     * @return the resource
     * @throws IllegalArgumentException if {@code id}, {@code fromValue} or {@code to} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCompare getCompare(final String id, final String fromValue, final String to) throws IOException {
        return getCompare(id, fromValue, to, GitLabProjectRepositoriesGetCompareFilter.empty());
    }

    /**
     * Get compare ({@code GET /projects/{id}/repository/compare}).
     *
     * @param id the id
     * @param fromValue the from
     * @param to the to
     * @param filter the optional query parameters
     * @return the resource
     * @throws IllegalArgumentException if {@code id}, {@code fromValue} or {@code to} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCompare getCompare(
            final String id,
            final String fromValue,
            final String to,
            final GitLabProjectRepositoriesGetCompareFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(fromValue, PARAM_FROMVALUE);
        requireNotBlank(to, PARAM_TO);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .all(filter.toQueryParameters())
                .text(PARAM_FROM, fromValue)
                .text(PARAM_TO, to)
                .build();
        return caller.fetch(get(GET_COMPARE, id).withQuery(queryParameters), GitLabCompare.class);
    }

    /**
     * Get health ({@code GET /projects/{id}/repository/health}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabRepositoryHealth getHealth(final String id) throws IOException {
        return getHealth(id, GitLabProjectRepositoriesGetHealthFilter.empty());
    }

    /**
     * Get health ({@code GET /projects/{id}/repository/health}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabRepositoryHealth getHealth(final String id, final GitLabProjectRepositoriesGetHealthFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetch(get(GET_HEALTH, id).withQuery(queryParameters), GitLabRepositoryHealth.class);
    }

    /**
     * List contributors ({@code GET /projects/{id}/repository/contributors}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabContributor> listContributors(final String id) throws IOException {
        return listContributors(
                id, GitLabProjectRepositoriesListContributorsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List contributors ({@code GET /projects/{id}/repository/contributors}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabContributor> listContributors(final String id, final GitLabPageRequest request)
            throws IOException {
        return listContributors(id, GitLabProjectRepositoriesListContributorsFilter.empty(), request);
    }

    /**
     * List contributors ({@code GET /projects/{id}/repository/contributors}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabContributor> listContributors(
            final String id, final GitLabProjectRepositoriesListContributorsFilter filter) throws IOException {
        return listContributors(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List contributors ({@code GET /projects/{id}/repository/contributors}).
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
    public GitLabPage<GitLabContributor> listContributors(
            final String id,
            final GitLabProjectRepositoriesListContributorsFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_CONTRIBUTORS, queryParameters, request, CONTRIBUTOR_SPEC, id);
    }

    /**
     * Get merge base ({@code GET /projects/{id}/repository/merge_base}).
     *
     * @param id the id
     * @param refs the refs
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code refs} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCommit getMergeBase(final String id, final List<String> refs) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(refs, "refs");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().list("refs", refs).build();
        return caller.fetch(get(GET_MERGE_BASE, id).withQuery(queryParameters), GitLabCommit.class);
    }

    /**
     * Batch blob ({@code POST /projects/{id}/repository/blobs/batch}).
     *
     * @param id the id
     * @param payload the request body
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabBatchBlob> batchBlob(final String id, final GitLabProjectRepositoriesBatchBlobPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(BATCH_BLOB, id), payload), BATCH_BLOB_LIST_TYPE);
    }

    /**
     * List changed paths ({@code GET /projects/{id}/repository/changed_paths}).
     *
     * @param id the id
     * @param fromValue the from
     * @param to the to
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id}, {@code fromValue} or {@code to} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabChangedPath> listChangedPaths(final String id, final String fromValue, final String to)
            throws IOException {
        return listChangedPaths(
                id, fromValue, to, GitLabProjectRepositoriesListChangedPathsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List changed paths ({@code GET /projects/{id}/repository/changed_paths}).
     *
     * @param id the id
     * @param fromValue the from
     * @param to the to
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id}, {@code fromValue} or {@code to} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabChangedPath> listChangedPaths(
            final String id, final String fromValue, final String to, final GitLabPageRequest request)
            throws IOException {
        return listChangedPaths(id, fromValue, to, GitLabProjectRepositoriesListChangedPathsFilter.empty(), request);
    }

    /**
     * List changed paths ({@code GET /projects/{id}/repository/changed_paths}).
     *
     * @param id the id
     * @param fromValue the from
     * @param to the to
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id}, {@code fromValue} or {@code to} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabChangedPath> listChangedPaths(
            final String id,
            final String fromValue,
            final String to,
            final GitLabProjectRepositoriesListChangedPathsFilter filter)
            throws IOException {
        return listChangedPaths(id, fromValue, to, filter, GitLabPageRequest.byPage());
    }

    /**
     * List changed paths ({@code GET /projects/{id}/repository/changed_paths}).
     *
     * @param id the id
     * @param fromValue the from
     * @param to the to
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id}, {@code fromValue} or {@code to} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabChangedPath> listChangedPaths(
            final String id,
            final String fromValue,
            final String to,
            final GitLabProjectRepositoriesListChangedPathsFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(fromValue, PARAM_FROMVALUE);
        requireNotBlank(to, PARAM_TO);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .all(filter.toQueryParameters())
                .text(PARAM_FROM, fromValue)
                .text(PARAM_TO, to)
                .build();
        return pageList(LIST_CHANGED_PATHS, queryParameters, request, CHANGED_PATH_SPEC, id);
    }

    /**
     * Get diverging commits ({@code GET /projects/{id}/repository/diverging_commits}).
     *
     * @param id the id
     * @param fromValue the from
     * @param to the to
     * @return the resource
     * @throws IllegalArgumentException if {@code id}, {@code fromValue} or {@code to} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabDivergingCommitCount getDivergingCommits(final String id, final String fromValue, final String to)
            throws IOException {
        return getDivergingCommits(id, fromValue, to, GitLabProjectRepositoriesGetDivergingCommitsFilter.empty());
    }

    /**
     * Get diverging commits ({@code GET /projects/{id}/repository/diverging_commits}).
     *
     * @param id the id
     * @param fromValue the from
     * @param to the to
     * @param filter the optional query parameters
     * @return the resource
     * @throws IllegalArgumentException if {@code id}, {@code fromValue} or {@code to} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabDivergingCommitCount getDivergingCommits(
            final String id,
            final String fromValue,
            final String to,
            final GitLabProjectRepositoriesGetDivergingCommitsFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(fromValue, PARAM_FROMVALUE);
        requireNotBlank(to, PARAM_TO);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .all(filter.toQueryParameters())
                .text(PARAM_FROM, fromValue)
                .text(PARAM_TO, to)
                .build();
        return caller.fetch(
                get(GET_DIVERGING_COMMITS, id).withQuery(queryParameters), GitLabDivergingCommitCount.class);
    }

    /**
     * List diff stats ({@code GET /projects/{id}/repository/diff_stats}).
     *
     * @param id the id
     * @param fromValue the from
     * @param to the to
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id}, {@code fromValue} or {@code to} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDiffStat> listDiffStats(final String id, final String fromValue, final String to)
            throws IOException {
        return listDiffStats(id, fromValue, to, GitLabPageRequest.byPage());
    }

    /**
     * List diff stats ({@code GET /projects/{id}/repository/diff_stats}).
     *
     * @param id the id
     * @param fromValue the from
     * @param to the to
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id}, {@code fromValue} or {@code to} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDiffStat> listDiffStats(
            final String id, final String fromValue, final String to, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(fromValue, PARAM_FROMVALUE);
        requireNotBlank(to, PARAM_TO);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .text(PARAM_FROM, fromValue)
                .text(PARAM_TO, to)
                .build();
        return pageList(LIST_DIFF_STATS, queryParameters, request, DIFF_STAT_SPEC, id);
    }

    /**
     * Get changelog ({@code GET /projects/{id}/repository/changelog}).
     *
     * @param id the id
     * @param version the version
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code version} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabChangelog getChangelog(final String id, final String version) throws IOException {
        return getChangelog(id, version, GitLabProjectRepositoriesGetChangelogFilter.empty());
    }

    /**
     * Get changelog ({@code GET /projects/{id}/repository/changelog}).
     *
     * @param id the id
     * @param version the version
     * @param filter the optional query parameters
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code version} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabChangelog getChangelog(
            final String id, final String version, final GitLabProjectRepositoriesGetChangelogFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(version, "version");
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .all(filter.toQueryParameters())
                .text("version", version)
                .build();
        return caller.fetch(get(GET_CHANGELOG, id).withQuery(queryParameters), GitLabChangelog.class);
    }

    /**
     * Create changelog ({@code POST /projects/{id}/repository/changelog}).
     *
     * @param id the id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createChangelog(final String id, final GitLabProjectRepositoriesCreateChangelogPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        caller.send(caller.json(post(GET_CHANGELOG, id), payload));
    }
}

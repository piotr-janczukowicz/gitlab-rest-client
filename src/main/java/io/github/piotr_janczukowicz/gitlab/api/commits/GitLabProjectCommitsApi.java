package io.github.piotr_janczukowicz.gitlab.api.commits;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCommit;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCommitDetail;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabDiff;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMergeRequestBasic;
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
import java.util.Optional;

/** The GitLab operations of project commits. */
public final class GitLabProjectCommitsApi extends GitLabResourceApi {
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_ID = "id";
    private static final String PARAM_PAYLOAD = "payload";
    private static final String PARAM_REQUEST = "request";
    private static final String PARAM_SHA = "sha";
    private static final PathTemplate LIST_STATUSES =
            PathTemplate.of("/projects/{id}/repository/commits/{sha}/statuses");
    private static final PathTemplate CREATE = PathTemplate.of("/projects/{id}/statuses/{sha}");
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/repository/commits");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/repository/commits/{sha}");
    private static final PathTemplate LIST_DIFF = PathTemplate.of("/projects/{id}/repository/commits/{sha}/diff");
    private static final PathTemplate LIST_COMMENTS =
            PathTemplate.of("/projects/{id}/repository/commits/{sha}/comments");
    private static final PathTemplate GET_SEQUENCE =
            PathTemplate.of("/projects/{id}/repository/commits/{sha}/sequence");
    private static final PathTemplate CHERRY_PICK =
            PathTemplate.of("/projects/{id}/repository/commits/{sha}/cherry_pick");
    private static final PathTemplate REVERT = PathTemplate.of("/projects/{id}/repository/commits/{sha}/revert");
    private static final PathTemplate LIST_REFS = PathTemplate.of("/projects/{id}/repository/commits/{sha}/refs");
    private static final PathTemplate LIST_MERGE_REQUESTS =
            PathTemplate.of("/projects/{id}/repository/commits/{sha}/merge_requests");
    private static final PathTemplate GET_SIGNATURE =
            PathTemplate.of("/projects/{id}/repository/commits/{sha}/signature");
    private static final JsonType<List<GitLabCommitStatus>> COMMIT_STATUS_LIST_TYPE =
            JsonTypes.listOf(GitLabCommitStatus.class);
    private static final JsonType<List<GitLabCommit>> COMMIT_LIST_TYPE = JsonTypes.listOf(GitLabCommit.class);
    private static final JsonType<List<GitLabDiff>> DIFF_LIST_TYPE = JsonTypes.listOf(GitLabDiff.class);
    private static final JsonType<List<GitLabCommitNote>> COMMIT_NOTE_LIST_TYPE =
            JsonTypes.listOf(GitLabCommitNote.class);
    private static final JsonType<List<GitLabBasicRef>> BASIC_REF_LIST_TYPE = JsonTypes.listOf(GitLabBasicRef.class);
    private static final JsonType<List<GitLabMergeRequestBasic>> MERGE_REQUEST_BASIC_LIST_TYPE =
            JsonTypes.listOf(GitLabMergeRequestBasic.class);
    private static final GitLabListSpec<GitLabCommitStatus> COMMIT_STATUS_SPEC =
            GitLabListSpec.offset(COMMIT_STATUS_LIST_TYPE);
    private static final GitLabListSpec<GitLabCommit> COMMIT_SPEC = GitLabListSpec.offset(COMMIT_LIST_TYPE);
    private static final GitLabListSpec<GitLabDiff> DIFF_SPEC = GitLabListSpec.offset(DIFF_LIST_TYPE);
    private static final GitLabListSpec<GitLabCommitNote> COMMIT_NOTE_SPEC =
            GitLabListSpec.offset(COMMIT_NOTE_LIST_TYPE);
    private static final GitLabListSpec<GitLabBasicRef> BASIC_REF_SPEC = GitLabListSpec.offset(BASIC_REF_LIST_TYPE);
    private static final GitLabListSpec<GitLabMergeRequestBasic> MERGE_REQUEST_BASIC_SPEC =
            GitLabListSpec.offset(MERGE_REQUEST_BASIC_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectCommitsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List statuses ({@code GET /projects/{id}/repository/commits/{sha}/statuses}).
     *
     * @param id the id
     * @param sha the sha
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCommitStatus> listStatuses(final String id, final String sha) throws IOException {
        return listStatuses(id, sha, GitLabProjectCommitsListStatusesFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List statuses ({@code GET /projects/{id}/repository/commits/{sha}/statuses}).
     *
     * @param id the id
     * @param sha the sha
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCommitStatus> listStatuses(
            final String id, final String sha, final GitLabPageRequest request) throws IOException {
        return listStatuses(id, sha, GitLabProjectCommitsListStatusesFilter.empty(), request);
    }

    /**
     * List statuses ({@code GET /projects/{id}/repository/commits/{sha}/statuses}).
     *
     * @param id the id
     * @param sha the sha
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCommitStatus> listStatuses(
            final String id, final String sha, final GitLabProjectCommitsListStatusesFilter filter) throws IOException {
        return listStatuses(id, sha, filter, GitLabPageRequest.byPage());
    }

    /**
     * List statuses ({@code GET /projects/{id}/repository/commits/{sha}/statuses}).
     *
     * @param id the id
     * @param sha the sha
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCommitStatus> listStatuses(
            final String id,
            final String sha,
            final GitLabProjectCommitsListStatusesFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(sha, PARAM_SHA);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_STATUSES, queryParameters, request, COMMIT_STATUS_SPEC, id, sha);
    }

    /**
     * Create ({@code POST /projects/{id}/statuses/{sha}}).
     *
     * @param id the id
     * @param sha the sha
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCommitStatus create(final String id, final String sha, final GitLabProjectCommitsCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(sha, PARAM_SHA);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(CREATE, id, sha), payload), GitLabCommitStatus.class);
    }

    /**
     * List ({@code GET /projects/{id}/repository/commits}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCommit> list(final String id) throws IOException {
        return list(id, GitLabProjectCommitsListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/repository/commits}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCommit> list(final String id, final GitLabPageRequest request) throws IOException {
        return list(id, GitLabProjectCommitsListFilter.empty(), request);
    }

    /**
     * List ({@code GET /projects/{id}/repository/commits}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCommit> list(final String id, final GitLabProjectCommitsListFilter filter)
            throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/repository/commits}).
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
    public GitLabPage<GitLabCommit> list(
            final String id, final GitLabProjectCommitsListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, COMMIT_SPEC, id);
    }

    /**
     * Create commits ({@code POST /projects/{id}/repository/commits}).
     *
     * @param id the id
     * @param form the form to send
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCommitDetail createCommits(final String id, final MultipartFormData form) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(form, "form");
        return caller.fetch(caller.multipart(post(LIST, id), form), GitLabCommitDetail.class);
    }

    /**
     * Get ({@code GET /projects/{id}/repository/commits/{sha}}).
     *
     * @param id the id
     * @param sha the sha
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCommitDetail> get(final String id, final String sha) throws IOException {
        return get(id, sha, GitLabProjectCommitsGetFilter.empty());
    }

    /**
     * Get ({@code GET /projects/{id}/repository/commits/{sha}}).
     *
     * @param id the id
     * @param sha the sha
     * @param filter the optional query parameters
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCommitDetail> get(
            final String id, final String sha, final GitLabProjectCommitsGetFilter filter) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(sha, PARAM_SHA);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOrEmpty(get(GET, id, sha).withQuery(queryParameters), GitLabCommitDetail.class);
    }

    /**
     * List diff ({@code GET /projects/{id}/repository/commits/{sha}/diff}).
     *
     * @param id the id
     * @param sha the sha
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDiff> listDiff(final String id, final String sha) throws IOException {
        return listDiff(id, sha, GitLabProjectCommitsListDiffFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List diff ({@code GET /projects/{id}/repository/commits/{sha}/diff}).
     *
     * @param id the id
     * @param sha the sha
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDiff> listDiff(final String id, final String sha, final GitLabPageRequest request)
            throws IOException {
        return listDiff(id, sha, GitLabProjectCommitsListDiffFilter.empty(), request);
    }

    /**
     * List diff ({@code GET /projects/{id}/repository/commits/{sha}/diff}).
     *
     * @param id the id
     * @param sha the sha
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDiff> listDiff(
            final String id, final String sha, final GitLabProjectCommitsListDiffFilter filter) throws IOException {
        return listDiff(id, sha, filter, GitLabPageRequest.byPage());
    }

    /**
     * List diff ({@code GET /projects/{id}/repository/commits/{sha}/diff}).
     *
     * @param id the id
     * @param sha the sha
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabDiff> listDiff(
            final String id,
            final String sha,
            final GitLabProjectCommitsListDiffFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(sha, PARAM_SHA);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_DIFF, queryParameters, request, DIFF_SPEC, id, sha);
    }

    /**
     * List comments ({@code GET /projects/{id}/repository/commits/{sha}/comments}).
     *
     * @param id the id
     * @param sha the sha
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCommitNote> listComments(final String id, final String sha) throws IOException {
        return listComments(id, sha, GitLabPageRequest.byPage());
    }

    /**
     * List comments ({@code GET /projects/{id}/repository/commits/{sha}/comments}).
     *
     * @param id the id
     * @param sha the sha
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCommitNote> listComments(final String id, final String sha, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(sha, PARAM_SHA);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_COMMENTS, Map.of(), request, COMMIT_NOTE_SPEC, id, sha);
    }

    /**
     * Create comment ({@code POST /projects/{id}/repository/commits/{sha}/comments}).
     *
     * @param id the id
     * @param sha the sha
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCommitNote createComment(
            final String id, final String sha, final GitLabProjectCommitsCreateCommentPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(sha, PARAM_SHA);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_COMMENTS, id, sha), payload), GitLabCommitNote.class);
    }

    /**
     * Get sequence ({@code GET /projects/{id}/repository/commits/{sha}/sequence}).
     *
     * @param id the id
     * @param sha the sha
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCommitSequence> getSequence(final String id, final String sha) throws IOException {
        return getSequence(id, sha, GitLabProjectCommitsGetSequenceFilter.empty());
    }

    /**
     * Get sequence ({@code GET /projects/{id}/repository/commits/{sha}/sequence}).
     *
     * @param id the id
     * @param sha the sha
     * @param filter the optional query parameters
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCommitSequence> getSequence(
            final String id, final String sha, final GitLabProjectCommitsGetSequenceFilter filter) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(sha, PARAM_SHA);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOrEmpty(get(GET_SEQUENCE, id, sha).withQuery(queryParameters), GitLabCommitSequence.class);
    }

    /**
     * Cherry pick ({@code POST /projects/{id}/repository/commits/{sha}/cherry_pick}).
     *
     * @param id the id
     * @param sha the sha
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCommit cherryPick(
            final String id, final String sha, final GitLabProjectCommitsCherryPickPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(sha, PARAM_SHA);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(CHERRY_PICK, id, sha), payload), GitLabCommit.class);
    }

    /**
     * Revert ({@code POST /projects/{id}/repository/commits/{sha}/revert}).
     *
     * @param id the id
     * @param sha the sha
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCommit revert(final String id, final String sha, final GitLabProjectCommitsRevertPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(sha, PARAM_SHA);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(REVERT, id, sha), payload), GitLabCommit.class);
    }

    /**
     * List refs ({@code GET /projects/{id}/repository/commits/{sha}/refs}).
     *
     * @param id the id
     * @param sha the sha
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBasicRef> listRefs(final String id, final String sha) throws IOException {
        return listRefs(id, sha, GitLabProjectCommitsListRefsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List refs ({@code GET /projects/{id}/repository/commits/{sha}/refs}).
     *
     * @param id the id
     * @param sha the sha
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBasicRef> listRefs(final String id, final String sha, final GitLabPageRequest request)
            throws IOException {
        return listRefs(id, sha, GitLabProjectCommitsListRefsFilter.empty(), request);
    }

    /**
     * List refs ({@code GET /projects/{id}/repository/commits/{sha}/refs}).
     *
     * @param id the id
     * @param sha the sha
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBasicRef> listRefs(
            final String id, final String sha, final GitLabProjectCommitsListRefsFilter filter) throws IOException {
        return listRefs(id, sha, filter, GitLabPageRequest.byPage());
    }

    /**
     * List refs ({@code GET /projects/{id}/repository/commits/{sha}/refs}).
     *
     * @param id the id
     * @param sha the sha
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBasicRef> listRefs(
            final String id,
            final String sha,
            final GitLabProjectCommitsListRefsFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(sha, PARAM_SHA);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_REFS, queryParameters, request, BASIC_REF_SPEC, id, sha);
    }

    /**
     * List merge requests ({@code GET /projects/{id}/repository/commits/{sha}/merge_requests}).
     *
     * @param id the id
     * @param sha the sha
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMergeRequestBasic> listMergeRequests(final String id, final String sha) throws IOException {
        return listMergeRequests(
                id, sha, GitLabProjectCommitsListMergeRequestsFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List merge requests ({@code GET /projects/{id}/repository/commits/{sha}/merge_requests}).
     *
     * @param id the id
     * @param sha the sha
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMergeRequestBasic> listMergeRequests(
            final String id, final String sha, final GitLabPageRequest request) throws IOException {
        return listMergeRequests(id, sha, GitLabProjectCommitsListMergeRequestsFilter.empty(), request);
    }

    /**
     * List merge requests ({@code GET /projects/{id}/repository/commits/{sha}/merge_requests}).
     *
     * @param id the id
     * @param sha the sha
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMergeRequestBasic> listMergeRequests(
            final String id, final String sha, final GitLabProjectCommitsListMergeRequestsFilter filter)
            throws IOException {
        return listMergeRequests(id, sha, filter, GitLabPageRequest.byPage());
    }

    /**
     * List merge requests ({@code GET /projects/{id}/repository/commits/{sha}/merge_requests}).
     *
     * @param id the id
     * @param sha the sha
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMergeRequestBasic> listMergeRequests(
            final String id,
            final String sha,
            final GitLabProjectCommitsListMergeRequestsFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(sha, PARAM_SHA);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_MERGE_REQUESTS, queryParameters, request, MERGE_REQUEST_BASIC_SPEC, id, sha);
    }

    /**
     * Get signature ({@code GET /projects/{id}/repository/commits/{sha}/signature}).
     *
     * @param id the id
     * @param sha the sha
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCommitSignature> getSignature(final String id, final String sha) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(sha, PARAM_SHA);
        return caller.fetchOrEmpty(get(GET_SIGNATURE, id, sha), GitLabCommitSignature.class);
    }
}

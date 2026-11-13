package io.github.piotr_janczukowicz.gitlab.api.resourcegroup;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiJobBasic;
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
import java.util.Optional;

/** The GitLab operations of project resource group. */
public final class GitLabProjectResourceGroupApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_KEY = "key";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/resource_groups");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/resource_groups/{key}");
    private static final PathTemplate GET_CURRENT_JOB =
            PathTemplate.of("/projects/{id}/resource_groups/{key}/current_job");
    private static final PathTemplate LIST_UPCOMING_JOBS =
            PathTemplate.of("/projects/{id}/resource_groups/{key}/upcoming_jobs");
    private static final JsonType<List<GitLabCiResourceGroup>> CI_RESOURCE_GROUP_LIST_TYPE =
            JsonTypes.listOf(GitLabCiResourceGroup.class);
    private static final JsonType<List<GitLabCiJobBasic>> CI_JOB_BASIC_LIST_TYPE =
            JsonTypes.listOf(GitLabCiJobBasic.class);
    private static final GitLabListSpec<GitLabCiResourceGroup> CI_RESOURCE_GROUP_SPEC =
            GitLabListSpec.offset(CI_RESOURCE_GROUP_LIST_TYPE);
    private static final GitLabListSpec<GitLabCiJobBasic> CI_JOB_BASIC_SPEC =
            GitLabListSpec.offset(CI_JOB_BASIC_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectResourceGroupApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/resource_groups}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiResourceGroup> list(final String id) throws IOException {
        return list(id, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/resource_groups}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiResourceGroup> list(final String id, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, CI_RESOURCE_GROUP_SPEC, id);
    }

    /**
     * Get ({@code GET /projects/{id}/resource_groups/{key}}).
     *
     * @param id the id
     * @param key the key
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code key} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCiResourceGroup> get(final String id, final String key) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(key, PARAM_KEY);
        return caller.fetchOrEmpty(get(GET, id, key), GitLabCiResourceGroup.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/resource_groups/{key}}).
     *
     * @param id the id
     * @param key the key
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code key} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiResourceGroup update(
            final String id, final String key, final GitLabProjectResourceGroupUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(key, PARAM_KEY);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id, key), payload), GitLabCiResourceGroup.class);
    }

    /**
     * Get current job ({@code GET /projects/{id}/resource_groups/{key}/current_job}).
     *
     * @param id the id
     * @param key the key
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code key} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCiJobBasic> getCurrentJob(final String id, final String key) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(key, PARAM_KEY);
        return caller.fetchOrEmpty(get(GET_CURRENT_JOB, id, key), GitLabCiJobBasic.class);
    }

    /**
     * List upcoming jobs ({@code GET /projects/{id}/resource_groups/{key}/upcoming_jobs}).
     *
     * @param id the id
     * @param key the key
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code key} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiJobBasic> listUpcomingJobs(final String id, final String key) throws IOException {
        return listUpcomingJobs(id, key, GitLabPageRequest.byPage());
    }

    /**
     * List upcoming jobs ({@code GET /projects/{id}/resource_groups/{key}/upcoming_jobs}).
     *
     * @param id the id
     * @param key the key
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code key} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiJobBasic> listUpcomingJobs(
            final String id, final String key, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(key, PARAM_KEY);
        requireNonNull(request, "request");
        return pageList(LIST_UPCOMING_JOBS, Map.of(), request, CI_JOB_BASIC_SPEC, id, key);
    }
}

package io.github.piotr_janczukowicz.gitlab.api.pipelineschedules;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiPipelineBasic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiVariable;
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

/** The GitLab operations of project pipeline schedules. */
public final class GitLabProjectPipelineSchedulesApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_KEY = "key";
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/pipeline_schedules");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/pipeline_schedules/{pipeline_schedule_id}");
    private static final PathTemplate LIST_PIPELINES =
            PathTemplate.of("/projects/{id}/pipeline_schedules/{pipeline_schedule_id}/pipelines");
    private static final PathTemplate TAKE_OWNERSHIP =
            PathTemplate.of("/projects/{id}/pipeline_schedules/{pipeline_schedule_id}/take_ownership");
    private static final PathTemplate PLAY =
            PathTemplate.of("/projects/{id}/pipeline_schedules/{pipeline_schedule_id}/play");
    private static final PathTemplate CREATE_VARIABLE =
            PathTemplate.of("/projects/{id}/pipeline_schedules/{pipeline_schedule_id}/variables");
    private static final PathTemplate GET_VARIABLE =
            PathTemplate.of("/projects/{id}/pipeline_schedules/{pipeline_schedule_id}/variables/{key}");
    private static final JsonType<List<GitLabCiPipelineSchedule>> CI_PIPELINE_SCHEDULE_LIST_TYPE =
            JsonTypes.listOf(GitLabCiPipelineSchedule.class);
    private static final JsonType<List<GitLabCiPipelineBasic>> CI_PIPELINE_BASIC_LIST_TYPE =
            JsonTypes.listOf(GitLabCiPipelineBasic.class);
    private static final GitLabListSpec<GitLabCiPipelineSchedule> CI_PIPELINE_SCHEDULE_SPEC =
            GitLabListSpec.offset(CI_PIPELINE_SCHEDULE_LIST_TYPE);
    private static final GitLabListSpec<GitLabCiPipelineBasic> CI_PIPELINE_BASIC_SPEC =
            GitLabListSpec.offset(CI_PIPELINE_BASIC_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectPipelineSchedulesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/pipeline_schedules}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiPipelineSchedule> list(final String id) throws IOException {
        return list(id, GitLabProjectPipelineSchedulesListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/pipeline_schedules}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiPipelineSchedule> list(final String id, final GitLabPageRequest request)
            throws IOException {
        return list(id, GitLabProjectPipelineSchedulesListFilter.empty(), request);
    }

    /**
     * List ({@code GET /projects/{id}/pipeline_schedules}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiPipelineSchedule> list(
            final String id, final GitLabProjectPipelineSchedulesListFilter filter) throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/pipeline_schedules}).
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
    public GitLabPage<GitLabCiPipelineSchedule> list(
            final String id, final GitLabProjectPipelineSchedulesListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, CI_PIPELINE_SCHEDULE_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/pipeline_schedules}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiPipelineScheduleDetails create(
            final String id, final GitLabProjectPipelineSchedulesCreatePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabCiPipelineScheduleDetails.class);
    }

    /**
     * Get ({@code GET /projects/{id}/pipeline_schedules/{pipeline_schedule_id}}).
     *
     * @param id the id
     * @param pipelineScheduleId the pipeline schedule id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCiPipelineScheduleDetails> get(final String id, final long pipelineScheduleId)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET, id, pipelineScheduleId), GitLabCiPipelineScheduleDetails.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/pipeline_schedules/{pipeline_schedule_id}}).
     *
     * @param id the id
     * @param pipelineScheduleId the pipeline schedule id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiPipelineScheduleDetails update(
            final String id, final long pipelineScheduleId, final GitLabProjectPipelineSchedulesUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(GET, id, pipelineScheduleId), payload), GitLabCiPipelineScheduleDetails.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/pipeline_schedules/{pipeline_schedule_id}}).
     *
     * @param id the id
     * @param pipelineScheduleId the pipeline schedule id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final long pipelineScheduleId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET, id, pipelineScheduleId));
    }

    /**
     * List pipelines ({@code GET /projects/{id}/pipeline_schedules/{pipeline_schedule_id}/pipelines}).
     *
     * @param id the id
     * @param pipelineScheduleId the pipeline schedule id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiPipelineBasic> listPipelines(final String id, final long pipelineScheduleId)
            throws IOException {
        return listPipelines(
                id,
                pipelineScheduleId,
                GitLabProjectPipelineSchedulesListPipelinesFilter.empty(),
                GitLabPageRequest.byPage());
    }

    /**
     * List pipelines ({@code GET /projects/{id}/pipeline_schedules/{pipeline_schedule_id}/pipelines}).
     *
     * @param id the id
     * @param pipelineScheduleId the pipeline schedule id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiPipelineBasic> listPipelines(
            final String id, final long pipelineScheduleId, final GitLabPageRequest request) throws IOException {
        return listPipelines(
                id, pipelineScheduleId, GitLabProjectPipelineSchedulesListPipelinesFilter.empty(), request);
    }

    /**
     * List pipelines ({@code GET /projects/{id}/pipeline_schedules/{pipeline_schedule_id}/pipelines}).
     *
     * @param id the id
     * @param pipelineScheduleId the pipeline schedule id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiPipelineBasic> listPipelines(
            final String id,
            final long pipelineScheduleId,
            final GitLabProjectPipelineSchedulesListPipelinesFilter filter)
            throws IOException {
        return listPipelines(id, pipelineScheduleId, filter, GitLabPageRequest.byPage());
    }

    /**
     * List pipelines ({@code GET /projects/{id}/pipeline_schedules/{pipeline_schedule_id}/pipelines}).
     *
     * @param id the id
     * @param pipelineScheduleId the pipeline schedule id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiPipelineBasic> listPipelines(
            final String id,
            final long pipelineScheduleId,
            final GitLabProjectPipelineSchedulesListPipelinesFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_PIPELINES, queryParameters, request, CI_PIPELINE_BASIC_SPEC, id, pipelineScheduleId);
    }

    /**
     * Take ownership ({@code POST /projects/{id}/pipeline_schedules/{pipeline_schedule_id}/take_ownership}).
     *
     * @param id the id
     * @param pipelineScheduleId the pipeline schedule id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiPipelineScheduleDetails takeOwnership(final String id, final long pipelineScheduleId)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(TAKE_OWNERSHIP, id, pipelineScheduleId), GitLabCiPipelineScheduleDetails.class);
    }

    /**
     * Play ({@code POST /projects/{id}/pipeline_schedules/{pipeline_schedule_id}/play}).
     *
     * @param id the id
     * @param pipelineScheduleId the pipeline schedule id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void play(final String id, final long pipelineScheduleId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(post(PLAY, id, pipelineScheduleId));
    }

    /**
     * Create variable ({@code POST /projects/{id}/pipeline_schedules/{pipeline_schedule_id}/variables}).
     *
     * @param id the id
     * @param pipelineScheduleId the pipeline schedule id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiVariable createVariable(
            final String id,
            final long pipelineScheduleId,
            final GitLabProjectPipelineSchedulesCreateVariablePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(CREATE_VARIABLE, id, pipelineScheduleId), payload), GitLabCiVariable.class);
    }

    /**
     * Get variable ({@code GET /projects/{id}/pipeline_schedules/{pipeline_schedule_id}/variables/{key}}).
     *
     * @param id the id
     * @param pipelineScheduleId the pipeline schedule id
     * @param key the key
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code key} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCiVariable> getVariable(final String id, final long pipelineScheduleId, final String key)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(key, PARAM_KEY);
        return caller.fetchOrEmpty(get(GET_VARIABLE, id, pipelineScheduleId, key), GitLabCiVariable.class);
    }

    /**
     * Update variable ({@code PUT /projects/{id}/pipeline_schedules/{pipeline_schedule_id}/variables/{key}}).
     *
     * @param id the id
     * @param pipelineScheduleId the pipeline schedule id
     * @param key the key
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code key} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiVariable updateVariable(
            final String id,
            final long pipelineScheduleId,
            final String key,
            final GitLabProjectPipelineSchedulesUpdateVariablePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(key, PARAM_KEY);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(GET_VARIABLE, id, pipelineScheduleId, key), payload), GitLabCiVariable.class);
    }

    /**
     * Delete variable ({@code DELETE /projects/{id}/pipeline_schedules/{pipeline_schedule_id}/variables/{key}}).
     *
     * @param id the id
     * @param pipelineScheduleId the pipeline schedule id
     * @param key the key
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} or {@code key} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCiVariable> deleteVariable(final String id, final long pipelineScheduleId, final String key)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(key, PARAM_KEY);
        return caller.fetchOptional(delete(GET_VARIABLE, id, pipelineScheduleId, key), GitLabCiVariable.class);
    }
}

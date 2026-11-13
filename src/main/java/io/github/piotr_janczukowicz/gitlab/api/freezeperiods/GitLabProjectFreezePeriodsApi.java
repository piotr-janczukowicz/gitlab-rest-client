package io.github.piotr_janczukowicz.gitlab.api.freezeperiods;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

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

/** The GitLab operations of project freeze periods. */
public final class GitLabProjectFreezePeriodsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/freeze_periods");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/freeze_periods/{freeze_period_id}");
    private static final JsonType<List<GitLabFreezePeriod>> FREEZE_PERIOD_LIST_TYPE =
            JsonTypes.listOf(GitLabFreezePeriod.class);
    private static final GitLabListSpec<GitLabFreezePeriod> FREEZE_PERIOD_SPEC =
            GitLabListSpec.offset(FREEZE_PERIOD_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectFreezePeriodsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/freeze_periods}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabFreezePeriod> list(final String id) throws IOException {
        return list(id, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/freeze_periods}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabFreezePeriod> list(final String id, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, FREEZE_PERIOD_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/freeze_periods}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabFreezePeriod create(final String id, final GitLabProjectFreezePeriodsCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabFreezePeriod.class);
    }

    /**
     * Get ({@code GET /projects/{id}/freeze_periods/{freeze_period_id}}).
     *
     * @param id the id
     * @param freezePeriodId the freeze period id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabFreezePeriod> get(final String id, final long freezePeriodId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET, id, freezePeriodId), GitLabFreezePeriod.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/freeze_periods/{freeze_period_id}}).
     *
     * @param id the id
     * @param freezePeriodId the freeze period id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabFreezePeriod update(
            final String id, final long freezePeriodId, final GitLabProjectFreezePeriodsUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id, freezePeriodId), payload), GitLabFreezePeriod.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/freeze_periods/{freeze_period_id}}).
     *
     * @param id the id
     * @param freezePeriodId the freeze period id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabFreezePeriod> delete(final String id, final long freezePeriodId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOptional(delete(GET, id, freezePeriodId), GitLabFreezePeriod.class);
    }
}

package io.github.piotr_janczukowicz.gitlab.api.epiclinks;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabEpic;
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
import java.util.Optional;

/** The GitLab operations of group epic links. */
public final class GitLabGroupEpicLinksApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST = PathTemplate.of("/groups/{id}/epics/{epic_iid}/epics");
    private static final PathTemplate CREATE_BY_CHILD_EPIC_ID =
            PathTemplate.of("/groups/{id}/epics/{epic_iid}/epics/{child_epic_id}");
    private static final JsonType<List<GitLabEpic>> EPIC_LIST_TYPE = JsonTypes.listOf(GitLabEpic.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupEpicLinksApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /groups/{id}/(-/)epics/{epic_iid}/epics}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public List<GitLabEpic> list(final String id, final long epicIid) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4GroupsIdDashEpicsEpicIidEpics");
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(LIST, id, epicIid), EPIC_LIST_TYPE);
    }

    /**
     * Create ({@code POST /groups/{id}/(-/)epics/{epic_iid}/epics}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabEpic create(final String id, final long epicIid, final GitLabGroupEpicLinksCreatePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4GroupsIdDashEpicsEpicIidEpics");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id, epicIid), payload), GitLabEpic.class);
    }

    /**
     * Create by child epic id ({@code POST /groups/{id}/(-/)epics/{epic_iid}/epics/{child_epic_id}}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @param childEpicId the child epic id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabEpic createByChildEpicId(final String id, final long epicIid, final long childEpicId)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4GroupsIdDashEpicsEpicIidEpicsChildEpicId");
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(CREATE_BY_CHILD_EPIC_ID, id, epicIid, childEpicId), GitLabEpic.class);
    }

    /**
     * Update ({@code PUT /groups/{id}/(-/)epics/{epic_iid}/epics/{child_epic_id}}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @param childEpicId the child epic id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabEpic update(
            final String id,
            final long epicIid,
            final long childEpicId,
            final GitLabGroupEpicLinksUpdatePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "putApiV4GroupsIdDashEpicsEpicIidEpicsChildEpicId");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(
                caller.json(put(CREATE_BY_CHILD_EPIC_ID, id, epicIid, childEpicId), payload), GitLabEpic.class);
    }

    /**
     * Delete ({@code DELETE /groups/{id}/(-/)epics/{epic_iid}/epics/{child_epic_id}}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @param childEpicId the child epic id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public Optional<GitLabEpic> delete(final String id, final long epicIid, final long childEpicId) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "deleteApiV4GroupsIdDashEpicsEpicIidEpicsChildEpicId");
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOptional(delete(CREATE_BY_CHILD_EPIC_ID, id, epicIid, childEpicId), GitLabEpic.class);
    }
}

package io.github.piotr_janczukowicz.gitlab.api.linkedepics;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabRelatedEpic;
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

/** The GitLab operations of group linked epics. */
public final class GitLabGroupLinkedEpicsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST = PathTemplate.of("/groups/{id}/epics/{epic_iid}/related_epics");
    private static final PathTemplate DELETE =
            PathTemplate.of("/groups/{id}/epics/{epic_iid}/related_epics/{related_epic_link_id}");
    private static final JsonType<List<GitLabRelatedEpic>> RELATED_EPIC_LIST_TYPE =
            JsonTypes.listOf(GitLabRelatedEpic.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupLinkedEpicsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /groups/{id}/epics/{epic_iid}/related_epics}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public List<GitLabRelatedEpic> list(final String id, final long epicIid) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdEpicsEpicIidRelatedEpics");
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(LIST, id, epicIid), RELATED_EPIC_LIST_TYPE);
    }

    /**
     * Create ({@code POST /groups/{id}/epics/{epic_iid}/related_epics}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabRelatedEpicLink create(
            final String id, final long epicIid, final GitLabGroupLinkedEpicsCreatePayload payload) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4GroupsIdEpicsEpicIidRelatedEpics");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST, id, epicIid), payload), GitLabRelatedEpicLink.class);
    }

    /**
     * Delete ({@code DELETE /groups/{id}/epics/{epic_iid}/related_epics/{related_epic_link_id}}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @param relatedEpicLinkId the related epic link id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabRelatedEpicLink> delete(final String id, final long epicIid, final long relatedEpicLinkId)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4GroupsIdEpicsEpicIidRelatedEpicsRelatedEpicLinkId");
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOptional(delete(DELETE, id, epicIid, relatedEpicLinkId), GitLabRelatedEpicLink.class);
    }
}

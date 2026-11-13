package io.github.piotr_janczukowicz.gitlab.api.epics;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabAwardEmoji;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabEpic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabEpicIssue;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabRelatedEpic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabTodo;
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
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of group epics. */
public final class GitLabGroupEpicsApi extends GitLabResourceApi {
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_ID = "id";
    private static final String PARAM_PAYLOAD = "payload";
    private static final String PARAM_REQUEST = "request";
    private static final PathTemplate LIST_RELATED_EPIC_LINKS = PathTemplate.of("/groups/{id}/related_epic_links");
    private static final PathTemplate LIST = PathTemplate.of("/groups/{id}/epics");
    private static final PathTemplate LIST_DASHED = PathTemplate.of("/groups/{id}/-/epics");
    private static final PathTemplate GET = PathTemplate.of("/groups/{id}/epics/{epic_iid}");
    private static final PathTemplate GET_DASHED = PathTemplate.of("/groups/{id}/-/epics/{epic_iid}");
    private static final PathTemplate LIST_ISSUES = PathTemplate.of("/groups/{id}/-/epics/{epic_iid}/issues");
    private static final PathTemplate TODO = PathTemplate.of("/groups/{id}/epics/{epic_iid}/todo");
    private static final PathTemplate LIST_AWARD_EMOJI = PathTemplate.of("/groups/{id}/epics/{epic_iid}/award_emoji");
    private static final PathTemplate GET_AWARD_EMOJI =
            PathTemplate.of("/groups/{id}/epics/{epic_iid}/award_emoji/{award_id}");
    private static final JsonType<List<GitLabRelatedEpic>> RELATED_EPIC_LIST_TYPE =
            JsonTypes.listOf(GitLabRelatedEpic.class);
    private static final JsonType<List<GitLabEpic>> EPIC_LIST_TYPE = JsonTypes.listOf(GitLabEpic.class);
    private static final JsonType<List<GitLabEpicIssue>> EPIC_ISSUE_LIST_TYPE = JsonTypes.listOf(GitLabEpicIssue.class);
    private static final JsonType<List<GitLabAwardEmoji>> AWARD_EMOJI_LIST_TYPE =
            JsonTypes.listOf(GitLabAwardEmoji.class);
    private static final GitLabListSpec<GitLabRelatedEpic> RELATED_EPIC_SPEC =
            GitLabListSpec.offset(RELATED_EPIC_LIST_TYPE);
    private static final GitLabListSpec<GitLabEpic> EPIC_SPEC = GitLabListSpec.offset(EPIC_LIST_TYPE);
    private static final GitLabListSpec<GitLabEpicIssue> EPIC_ISSUE_SPEC = GitLabListSpec.offset(EPIC_ISSUE_LIST_TYPE);
    private static final GitLabListSpec<GitLabAwardEmoji> AWARD_EMOJI_SPEC =
            GitLabListSpec.offset(AWARD_EMOJI_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupEpicsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List related epic links ({@code GET /groups/{id}/related_epic_links}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabRelatedEpic> listRelatedEpicLinks(final String id) throws IOException {
        return listRelatedEpicLinks(id, GitLabGroupEpicsListRelatedEpicLinksFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List related epic links ({@code GET /groups/{id}/related_epic_links}).
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
    public GitLabPage<GitLabRelatedEpic> listRelatedEpicLinks(final String id, final GitLabPageRequest request)
            throws IOException {
        return listRelatedEpicLinks(id, GitLabGroupEpicsListRelatedEpicLinksFilter.empty(), request);
    }

    /**
     * List related epic links ({@code GET /groups/{id}/related_epic_links}).
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
    public GitLabPage<GitLabRelatedEpic> listRelatedEpicLinks(
            final String id, final GitLabGroupEpicsListRelatedEpicLinksFilter filter) throws IOException {
        return listRelatedEpicLinks(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List related epic links ({@code GET /groups/{id}/related_epic_links}).
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
    public GitLabPage<GitLabRelatedEpic> listRelatedEpicLinks(
            final String id, final GitLabGroupEpicsListRelatedEpicLinksFilter filter, final GitLabPageRequest request)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdRelatedEpicLinks");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_RELATED_EPIC_LINKS, queryParameters, request, RELATED_EPIC_SPEC, id);
    }

    /**
     * List ({@code GET /groups/{id}/epics}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabEpic> list(final String id) throws IOException {
        return list(id, GitLabGroupEpicsListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /groups/{id}/epics}).
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
    public GitLabPage<GitLabEpic> list(final String id, final GitLabPageRequest request) throws IOException {
        return list(id, GitLabGroupEpicsListFilter.empty(), request);
    }

    /**
     * List ({@code GET /groups/{id}/epics}).
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
    public GitLabPage<GitLabEpic> list(final String id, final GitLabGroupEpicsListFilter filter) throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /groups/{id}/epics}).
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
    public GitLabPage<GitLabEpic> list(
            final String id, final GitLabGroupEpicsListFilter filter, final GitLabPageRequest request)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdEpics");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, EPIC_SPEC, id);
    }

    /**
     * List dashed ({@code GET /groups/{id}/-/epics}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabEpic> listDashed(final String id) throws IOException {
        return listDashed(id, GitLabGroupEpicsListDashedFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List dashed ({@code GET /groups/{id}/-/epics}).
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
    public GitLabPage<GitLabEpic> listDashed(final String id, final GitLabPageRequest request) throws IOException {
        return listDashed(id, GitLabGroupEpicsListDashedFilter.empty(), request);
    }

    /**
     * List dashed ({@code GET /groups/{id}/-/epics}).
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
    public GitLabPage<GitLabEpic> listDashed(final String id, final GitLabGroupEpicsListDashedFilter filter)
            throws IOException {
        return listDashed(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List dashed ({@code GET /groups/{id}/-/epics}).
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
    public GitLabPage<GitLabEpic> listDashed(
            final String id, final GitLabGroupEpicsListDashedFilter filter, final GitLabPageRequest request)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdDashEpics");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_DASHED, queryParameters, request, EPIC_SPEC, id);
    }

    /**
     * Get ({@code GET /groups/{id}/epics/{epic_iid}}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabEpic> get(final String id, final long epicIid) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdEpicsEpicIid");
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET, id, epicIid), GitLabEpic.class);
    }

    /**
     * Get dashed ({@code GET /groups/{id}/-/epics/{epic_iid}}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabEpic> getDashed(final String id, final long epicIid) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdDashEpicsEpicIid");
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_DASHED, id, epicIid), GitLabEpic.class);
    }

    /**
     * Create ({@code POST /groups/{id}/(-/)epics}).
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
    public GitLabEpic create(final String id, final GitLabGroupEpicsCreatePayload payload) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4GroupsIdDashEpics");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabEpic.class);
    }

    /**
     * Update ({@code PUT /groups/{id}/(-/)epics/{epic_iid}}).
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
    public GitLabEpic update(final String id, final long epicIid, final GitLabGroupEpicsUpdatePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "putApiV4GroupsIdDashEpicsEpicIid");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET, id, epicIid), payload), GitLabEpic.class);
    }

    /**
     * Delete ({@code DELETE /groups/{id}/(-/)epics/{epic_iid}}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void delete(final String id, final long epicIid) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4GroupsIdDashEpicsEpicIid");
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET, id, epicIid));
    }

    /**
     * List issues ({@code GET /groups/{id}/-/epics/{epic_iid}/issues}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code epicIid} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabEpicIssue> listIssues(final String id, final String epicIid) throws IOException {
        return listIssues(id, epicIid, GitLabPageRequest.byPage());
    }

    /**
     * List issues ({@code GET /groups/{id}/-/epics/{epic_iid}/issues}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} or {@code epicIid} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabEpicIssue> listIssues(
            final String id, final String epicIid, final GitLabPageRequest request) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdDashEpicsEpicIidIssues");
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(epicIid, "epicIid");
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_ISSUES, Map.of(), request, EPIC_ISSUE_SPEC, id, epicIid);
    }

    /**
     * Todo ({@code POST /groups/{id}/epics/{epic_iid}/todo}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabTodo todo(final String id, final long epicIid) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4GroupsIdEpicsEpicIidTodo");
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(TODO, id, epicIid), GitLabTodo.class);
    }

    /**
     * List award emoji ({@code GET /groups/{id}/epics/{epic_iid}/award_emoji}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAwardEmoji> listAwardEmoji(final String id, final long epicIid) throws IOException {
        return listAwardEmoji(id, epicIid, GitLabPageRequest.byPage());
    }

    /**
     * List award emoji ({@code GET /groups/{id}/epics/{epic_iid}/award_emoji}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAwardEmoji> listAwardEmoji(
            final String id, final long epicIid, final GitLabPageRequest request) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdEpicsEpicIidAwardEmoji");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, PARAM_REQUEST);
        return pageList(LIST_AWARD_EMOJI, Map.of(), request, AWARD_EMOJI_SPEC, id, epicIid);
    }

    /**
     * Create award emoji ({@code POST /groups/{id}/epics/{epic_iid}/award_emoji}).
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
    public GitLabAwardEmoji createAwardEmoji(
            final String id, final long epicIid, final GitLabGroupEpicsCreateAwardEmojiPayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4GroupsIdEpicsEpicIidAwardEmoji");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_AWARD_EMOJI, id, epicIid), payload), GitLabAwardEmoji.class);
    }

    /**
     * Get award emoji ({@code GET /groups/{id}/epics/{epic_iid}/award_emoji/{award_id}}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @param awardId the award id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabAwardEmoji> getAwardEmoji(final String id, final long epicIid, final long awardId)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4GroupsIdEpicsEpicIidAwardEmojiAwardId");
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET_AWARD_EMOJI, id, epicIid, awardId), GitLabAwardEmoji.class);
    }

    /**
     * Delete award emoji ({@code DELETE /groups/{id}/epics/{epic_iid}/award_emoji/{award_id}}).
     *
     * @param id the id
     * @param epicIid the epic iid
     * @param awardId the award id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void deleteAwardEmoji(final String id, final long epicIid, final long awardId) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "deleteApiV4GroupsIdEpicsEpicIidAwardEmojiAwardId");
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET_AWARD_EMOJI, id, epicIid, awardId));
    }
}

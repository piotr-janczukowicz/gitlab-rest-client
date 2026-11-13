package io.github.piotr_janczukowicz.gitlab.api.auditevents;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabAuditEvent;
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

/** The GitLab operations of audit events. */
public final class GitLabAuditEventsApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/audit_events");
    private static final PathTemplate GET = PathTemplate.of("/audit_events/{id}");
    private static final JsonType<List<GitLabAuditEvent>> AUDIT_EVENT_LIST_TYPE =
            JsonTypes.listOf(GitLabAuditEvent.class);
    private static final GitLabListSpec<GitLabAuditEvent> AUDIT_EVENT_KEYSET_SPEC =
            GitLabListSpec.offsetOrKeyset(AUDIT_EVENT_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabAuditEventsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /audit_events}).
     *
     * @param entityType the entity type
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code entityType} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAuditEvent> list(final GitLabAuditEventsListEntityType entityType) throws IOException {
        return list(entityType, GitLabAuditEventsListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /audit_events}).
     *
     * @param entityType the entity type
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code entityType} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAuditEvent> list(
            final GitLabAuditEventsListEntityType entityType, final GitLabPageRequest request) throws IOException {
        return list(entityType, GitLabAuditEventsListFilter.empty(), request);
    }

    /**
     * List ({@code GET /audit_events}).
     *
     * @param entityType the entity type
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code entityType} or {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAuditEvent> list(
            final GitLabAuditEventsListEntityType entityType, final GitLabAuditEventsListFilter filter)
            throws IOException {
        return list(entityType, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /audit_events}).
     *
     * @param entityType the entity type
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code entityType}, {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAuditEvent> list(
            final GitLabAuditEventsListEntityType entityType,
            final GitLabAuditEventsListFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4AuditEvents");
        requireNonNull(entityType, "entityType");
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .all(filter.toQueryParameters())
                .wire("entity_type", entityType, GitLabAuditEventsListEntityType::wireValue)
                .build();
        return pageList(LIST, queryParameters, request, AUDIT_EVENT_KEYSET_SPEC);
    }

    /**
     * Get ({@code GET /audit_events/{id}}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabAuditEvent> get(final long id) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4AuditEventsId");
        return caller.fetchOrEmpty(get(GET, id), GitLabAuditEvent.class);
    }
}

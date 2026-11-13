package io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBulkImport;
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

/** The GitLab operations of group and project migration by direct transfer. */
public final class GitLabGroupAndProjectMigrationByDirectTransferApi extends GitLabResourceApi {
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_REQUEST = "request";
    private static final PathTemplate LIST = PathTemplate.of("/bulk_imports");
    private static final PathTemplate LIST_ENTITIES = PathTemplate.of("/bulk_imports/entities");
    private static final PathTemplate GET = PathTemplate.of("/bulk_imports/{import_id}");
    private static final PathTemplate LIST_ENTITIES_BY_IMPORT_ID =
            PathTemplate.of("/bulk_imports/{import_id}/entities");
    private static final PathTemplate GET_ENTITY = PathTemplate.of("/bulk_imports/{import_id}/entities/{entity_id}");
    private static final PathTemplate LIST_ENTITIES_FAILURES =
            PathTemplate.of("/bulk_imports/{import_id}/entities/{entity_id}/failures");
    private static final PathTemplate CANCEL = PathTemplate.of("/bulk_imports/{import_id}/cancel");
    private static final JsonType<List<GitLabBulkImport>> BULK_IMPORT_LIST_TYPE =
            JsonTypes.listOf(GitLabBulkImport.class);
    private static final JsonType<List<GitLabBulkImportsEntity>> BULK_IMPORTS_ENTITY_LIST_TYPE =
            JsonTypes.listOf(GitLabBulkImportsEntity.class);
    private static final JsonType<List<GitLabBulkImportsEntityFailure>> BULK_IMPORTS_ENTITY_FAILURE_LIST_TYPE =
            JsonTypes.listOf(GitLabBulkImportsEntityFailure.class);
    private static final GitLabListSpec<GitLabBulkImport> BULK_IMPORT_SPEC =
            GitLabListSpec.offset(BULK_IMPORT_LIST_TYPE);
    private static final GitLabListSpec<GitLabBulkImportsEntity> BULK_IMPORTS_ENTITY_SPEC =
            GitLabListSpec.offset(BULK_IMPORTS_ENTITY_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupAndProjectMigrationByDirectTransferApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /bulk_imports}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBulkImport> list() throws IOException {
        return list(GitLabGroupAndProjectMigrationByDirectTransferListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /bulk_imports}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBulkImport> list(final GitLabPageRequest request) throws IOException {
        return list(GitLabGroupAndProjectMigrationByDirectTransferListFilter.empty(), request);
    }

    /**
     * List ({@code GET /bulk_imports}).
     *
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBulkImport> list(final GitLabGroupAndProjectMigrationByDirectTransferListFilter filter)
            throws IOException {
        return list(filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /bulk_imports}).
     *
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBulkImport> list(
            final GitLabGroupAndProjectMigrationByDirectTransferListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, BULK_IMPORT_SPEC);
    }

    /**
     * Create ({@code POST /bulk_imports}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabBulkImport create(final GitLabGroupAndProjectMigrationByDirectTransferCreatePayload payload)
            throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST), payload), GitLabBulkImport.class);
    }

    /**
     * List entities ({@code GET /bulk_imports/entities}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBulkImportsEntity> listEntities() throws IOException {
        return listEntities(
                GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List entities ({@code GET /bulk_imports/entities}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBulkImportsEntity> listEntities(final GitLabPageRequest request) throws IOException {
        return listEntities(GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilter.empty(), request);
    }

    /**
     * List entities ({@code GET /bulk_imports/entities}).
     *
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBulkImportsEntity> listEntities(
            final GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilter filter) throws IOException {
        return listEntities(filter, GitLabPageRequest.byPage());
    }

    /**
     * List entities ({@code GET /bulk_imports/entities}).
     *
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBulkImportsEntity> listEntities(
            final GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_ENTITIES, queryParameters, request, BULK_IMPORTS_ENTITY_SPEC);
    }

    /**
     * Get ({@code GET /bulk_imports/{import_id}}).
     *
     * @param importId the import id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabBulkImport> get(final long importId) throws IOException {
        return caller.fetchOrEmpty(get(GET, importId), GitLabBulkImport.class);
    }

    /**
     * List entities by import id ({@code GET /bulk_imports/{import_id}/entities}).
     *
     * @param importId the import id
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBulkImportsEntity> listEntitiesByImportId(final long importId) throws IOException {
        return listEntitiesByImportId(importId, GitLabBulkImportEntityListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List entities by import id ({@code GET /bulk_imports/{import_id}/entities}).
     *
     * @param importId the import id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBulkImportsEntity> listEntitiesByImportId(
            final long importId, final GitLabPageRequest request) throws IOException {
        return listEntitiesByImportId(importId, GitLabBulkImportEntityListFilter.empty(), request);
    }

    /**
     * List entities by import id ({@code GET /bulk_imports/{import_id}/entities}).
     *
     * @param importId the import id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBulkImportsEntity> listEntitiesByImportId(
            final long importId, final GitLabBulkImportEntityListFilter filter) throws IOException {
        return listEntitiesByImportId(importId, filter, GitLabPageRequest.byPage());
    }

    /**
     * List entities by import id ({@code GET /bulk_imports/{import_id}/entities}).
     *
     * @param importId the import id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabBulkImportsEntity> listEntitiesByImportId(
            final long importId, final GitLabBulkImportEntityListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_ENTITIES_BY_IMPORT_ID, queryParameters, request, BULK_IMPORTS_ENTITY_SPEC, importId);
    }

    /**
     * Get entity ({@code GET /bulk_imports/{import_id}/entities/{entity_id}}).
     *
     * @param importId the import id
     * @param entityId the entity id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabBulkImportsEntity> getEntity(final long importId, final long entityId) throws IOException {
        return caller.fetchOrEmpty(get(GET_ENTITY, importId, entityId), GitLabBulkImportsEntity.class);
    }

    /**
     * List entities failures ({@code GET /bulk_imports/{import_id}/entities/{entity_id}/failures}).
     *
     * @param importId the import id
     * @param entityId the entity id
     * @return the items
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabBulkImportsEntityFailure> listEntitiesFailures(final long importId, final long entityId)
            throws IOException {
        return caller.fetch(get(LIST_ENTITIES_FAILURES, importId, entityId), BULK_IMPORTS_ENTITY_FAILURE_LIST_TYPE);
    }

    /**
     * Cancel ({@code POST /bulk_imports/{import_id}/cancel}).
     *
     * @param importId the import id
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabBulkImport cancel(final long importId) throws IOException {
        return caller.fetch(post(CANCEL, importId), GitLabBulkImport.class);
    }
}

package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

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

/** The GitLab operations of offline transfers. */
public final class GitLabOfflineTransfersApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/offline_exports");
    private static final PathTemplate CALL = PathTemplate.of("/offline_exports/{id}");
    private static final PathTemplate CREATE_IMPORTS = PathTemplate.of("/offline_imports");
    private static final JsonType<List<GitLabImportOfflineExport>> IMPORT_OFFLINE_EXPORT_LIST_TYPE =
            JsonTypes.listOf(GitLabImportOfflineExport.class);
    private static final GitLabListSpec<GitLabImportOfflineExport> IMPORT_OFFLINE_EXPORT_SPEC =
            GitLabListSpec.offset(IMPORT_OFFLINE_EXPORT_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabOfflineTransfersApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /offline_exports}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabImportOfflineExport> list() throws IOException {
        return list(GitLabOfflineTransfersListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /offline_exports}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabImportOfflineExport> list(final GitLabPageRequest request) throws IOException {
        return list(GitLabOfflineTransfersListFilter.empty(), request);
    }

    /**
     * List ({@code GET /offline_exports}).
     *
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabImportOfflineExport> list(final GitLabOfflineTransfersListFilter filter)
            throws IOException {
        return list(filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /offline_exports}).
     *
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabImportOfflineExport> list(
            final GitLabOfflineTransfersListFilter filter, final GitLabPageRequest request) throws IOException {
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, IMPORT_OFFLINE_EXPORT_SPEC);
    }

    /**
     * Create exports ({@code POST /offline_exports}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createExports(final GitLabOfflineTransfersCreateExportsPayload payload) throws IOException {
        requireNonNull(payload, "payload");
        caller.send(caller.json(post(LIST), payload));
    }

    /**
     * Call ({@code GET /offline_exports/{id}}).
     *
     * @param id the id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void call(final long id) throws IOException {
        caller.send(get(CALL, id));
    }

    /**
     * Create imports ({@code POST /offline_imports}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabBulkImport createImports(final GitLabOfflineTransfersCreateImportsPayload payload) throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(CREATE_IMPORTS), payload), GitLabBulkImport.class);
    }
}

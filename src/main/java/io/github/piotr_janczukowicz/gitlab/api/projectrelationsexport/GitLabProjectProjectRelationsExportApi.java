package io.github.piotr_janczukowicz.gitlab.api.projectrelationsexport;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBulkImportsExportStatus;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

/** The GitLab operations of project project relations export. */
public final class GitLabProjectProjectRelationsExportApi extends GitLabResourceApi {
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_ID = "id";
    private static final String PARAM_RELATION = "relation";
    private static final PathTemplate CREATE = PathTemplate.of("/projects/{id}/export_relations");
    private static final PathTemplate GET_DOWNLOAD = PathTemplate.of("/projects/{id}/export_relations/download");
    private static final PathTemplate LIST_STATUS = PathTemplate.of("/projects/{id}/export_relations/status");
    private static final JsonType<List<GitLabBulkImportsExportStatus>> BULK_IMPORTS_EXPORT_STATUS_LIST_TYPE =
            JsonTypes.listOf(GitLabBulkImportsExportStatus.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectProjectRelationsExportApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Create ({@code POST /projects/{id}/export_relations}).
     *
     * @param id the id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void create(final String id, final GitLabProjectProjectRelationsExportCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        caller.send(caller.json(post(CREATE, id), payload));
    }

    /**
     * Get download ({@code GET /projects/{id}/export_relations/download}).
     *
     * @param id the id
     * @param relation the relation
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id} or {@code relation} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getDownload(final String id, final String relation, final OutputStream out) throws IOException {
        return getDownload(id, relation, GitLabProjectProjectRelationsExportGetDownloadFilter.empty(), out);
    }

    /**
     * Get download ({@code GET /projects/{id}/export_relations/download}).
     *
     * @param id the id
     * @param relation the relation
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id} or {@code relation} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getDownload(final String id, final String relation, final Path target) throws IOException {
        return getDownload(id, relation, GitLabProjectProjectRelationsExportGetDownloadFilter.empty(), target);
    }

    /**
     * Get download ({@code GET /projects/{id}/export_relations/download}).
     *
     * @param id the id
     * @param relation the relation
     * @param filter the optional query parameters
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id} or {@code relation} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getDownload(
            final String id,
            final String relation,
            final GitLabProjectProjectRelationsExportGetDownloadFilter filter,
            final OutputStream out)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(relation, PARAM_RELATION);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(out, "out");
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .all(filter.toQueryParameters())
                .text(PARAM_RELATION, relation)
                .build();
        return caller.download(get(GET_DOWNLOAD, id).withQuery(queryParameters), out);
    }

    /**
     * Get download ({@code GET /projects/{id}/export_relations/download}).
     *
     * @param id the id
     * @param relation the relation
     * @param filter the optional query parameters
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id} or {@code relation} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getDownload(
            final String id,
            final String relation,
            final GitLabProjectProjectRelationsExportGetDownloadFilter filter,
            final Path target)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(relation, PARAM_RELATION);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(target, "target");
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .all(filter.toQueryParameters())
                .text(PARAM_RELATION, relation)
                .build();
        return caller.download(get(GET_DOWNLOAD, id).withQuery(queryParameters), target);
    }

    /**
     * List status ({@code GET /projects/{id}/export_relations/status}).
     *
     * @param id the id
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabBulkImportsExportStatus> listStatus(final String id) throws IOException {
        return listStatus(id, GitLabProjectProjectRelationsExportListStatusFilter.empty());
    }

    /**
     * List status ({@code GET /projects/{id}/export_relations/status}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabBulkImportsExportStatus> listStatus(
            final String id, final GitLabProjectProjectRelationsExportListStatusFilter filter) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetch(get(LIST_STATUS, id).withQuery(queryParameters), BULK_IMPORTS_EXPORT_STATUS_LIST_TYPE);
    }
}

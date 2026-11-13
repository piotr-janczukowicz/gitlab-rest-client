package io.github.piotr_janczukowicz.gitlab.api.groupimportandexport;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBulkImportsExportStatus;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

/** The GitLab operations of group group import and export. */
public final class GitLabGroupGroupImportAndExportApi extends GitLabResourceApi {
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_ID = "id";
    private static final String PARAM_RELATION = "relation";
    private static final PathTemplate AUTHORIZE = PathTemplate.of("/groups/import/authorize");
    private static final PathTemplate CREATE = PathTemplate.of("/groups/import");
    private static final PathTemplate GET_DOWNLOAD = PathTemplate.of("/groups/{id}/export/download");
    private static final PathTemplate CREATE_GROUP = PathTemplate.of("/groups/{id}/export");
    private static final PathTemplate CREATE_EXPORT_RELATION = PathTemplate.of("/groups/{id}/export_relations");
    private static final PathTemplate GET_EXPORT_RELATIONS_DOWNLOAD =
            PathTemplate.of("/groups/{id}/export_relations/download");
    private static final PathTemplate LIST_EXPORT_RELATIONS_STATUS =
            PathTemplate.of("/groups/{id}/export_relations/status");
    private static final JsonType<List<GitLabBulkImportsExportStatus>> BULK_IMPORTS_EXPORT_STATUS_LIST_TYPE =
            JsonTypes.listOf(GitLabBulkImportsExportStatus.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupGroupImportAndExportApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Authorize ({@code POST /groups/import/authorize}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void authorize() throws IOException {
        caller.send(post(AUTHORIZE));
    }

    /**
     * Create ({@code POST /groups/import}).
     *
     * @param form the form to send
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void create(final MultipartFormData form) throws IOException {
        requireNonNull(form, "form");
        caller.send(caller.multipart(post(CREATE), form));
    }

    /**
     * Get download ({@code GET /groups/{id}/export/download}).
     *
     * @param id the id
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getDownload(final String id, final OutputStream out) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(out, "out");
        return caller.download(get(GET_DOWNLOAD, id), out);
    }

    /**
     * Get download ({@code GET /groups/{id}/export/download}).
     *
     * @param id the id
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getDownload(final String id, final Path target) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(target, "target");
        return caller.download(get(GET_DOWNLOAD, id), target);
    }

    /**
     * Create group ({@code POST /groups/{id}/export}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createGroup(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(post(CREATE_GROUP, id));
    }

    /**
     * Create export relation ({@code POST /groups/{id}/export_relations}).
     *
     * @param id the id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createExportRelation(
            final String id, final GitLabGroupGroupImportAndExportCreateExportRelationPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        caller.send(caller.json(post(CREATE_EXPORT_RELATION, id), payload));
    }

    /**
     * Get export relations download ({@code GET /groups/{id}/export_relations/download}).
     *
     * @param id the id
     * @param relation the relation
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id} or {@code relation} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getExportRelationsDownload(final String id, final String relation, final OutputStream out)
            throws IOException {
        return getExportRelationsDownload(
                id, relation, GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilter.empty(), out);
    }

    /**
     * Get export relations download ({@code GET /groups/{id}/export_relations/download}).
     *
     * @param id the id
     * @param relation the relation
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id} or {@code relation} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getExportRelationsDownload(final String id, final String relation, final Path target)
            throws IOException {
        return getExportRelationsDownload(
                id, relation, GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilter.empty(), target);
    }

    /**
     * Get export relations download ({@code GET /groups/{id}/export_relations/download}).
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
    public long getExportRelationsDownload(
            final String id,
            final String relation,
            final GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilter filter,
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
        return caller.download(get(GET_EXPORT_RELATIONS_DOWNLOAD, id).withQuery(queryParameters), out);
    }

    /**
     * Get export relations download ({@code GET /groups/{id}/export_relations/download}).
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
    public Path getExportRelationsDownload(
            final String id,
            final String relation,
            final GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilter filter,
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
        return caller.download(get(GET_EXPORT_RELATIONS_DOWNLOAD, id).withQuery(queryParameters), target);
    }

    /**
     * List export relations status ({@code GET /groups/{id}/export_relations/status}).
     *
     * @param id the id
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabBulkImportsExportStatus> listExportRelationsStatus(final String id) throws IOException {
        return listExportRelationsStatus(id, GitLabGroupGroupImportAndExportListExportRelationsStatusFilter.empty());
    }

    /**
     * List export relations status ({@code GET /groups/{id}/export_relations/status}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabBulkImportsExportStatus> listExportRelationsStatus(
            final String id, final GitLabGroupGroupImportAndExportListExportRelationsStatusFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetch(
                get(LIST_EXPORT_RELATIONS_STATUS, id).withQuery(queryParameters), BULK_IMPORTS_EXPORT_STATUS_LIST_TYPE);
    }
}

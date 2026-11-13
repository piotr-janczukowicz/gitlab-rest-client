package io.github.piotr_janczukowicz.gitlab.api.projectimportexport;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProjectImportStatus;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;

/** The GitLab operations of project project import export. */
public final class GitLabProjectProjectImportExportApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate AUTHORIZE = PathTemplate.of("/projects/import/authorize");
    private static final PathTemplate CREATE = PathTemplate.of("/projects/import");
    private static final PathTemplate GET_IMPORT = PathTemplate.of("/projects/{id}/import");
    private static final PathTemplate GIT = PathTemplate.of("/projects/{id}/import/git");
    private static final PathTemplate GET_EXPORT = PathTemplate.of("/projects/{id}/export");
    private static final PathTemplate GET_DOWNLOAD = PathTemplate.of("/projects/{id}/export/download");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectProjectImportExportApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Authorize ({@code POST /projects/import/authorize}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void authorize() throws IOException {
        caller.send(post(AUTHORIZE));
    }

    /**
     * Create ({@code POST /projects/import}).
     *
     * @param form the form to send
     * @return the resource
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectImportStatus create(final MultipartFormData form) throws IOException {
        requireNonNull(form, "form");
        return caller.fetch(caller.multipart(post(CREATE), form), GitLabProjectImportStatus.class);
    }

    /**
     * Get import ({@code GET /projects/{id}/import}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectImportStatus getImport(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(GET_IMPORT, id), GitLabProjectImportStatus.class);
    }

    /**
     * Git ({@code POST /projects/{id}/import/git}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectImportStatus git(final String id, final GitLabProjectProjectImportExportGitPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(GIT, id), payload), GitLabProjectImportStatus.class);
    }

    /**
     * Get export ({@code GET /projects/{id}/export}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectExportStatus getExport(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(GET_EXPORT, id), GitLabProjectExportStatus.class);
    }

    /**
     * Create project ({@code POST /projects/{id}/export}).
     *
     * @param id the id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createProject(final String id, final GitLabProjectProjectImportExportCreateProjectPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        caller.send(caller.json(post(GET_EXPORT, id), payload));
    }

    /**
     * Get download ({@code GET /projects/{id}/export/download}).
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
     * Get download ({@code GET /projects/{id}/export/download}).
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
}

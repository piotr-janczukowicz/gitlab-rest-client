package io.github.piotr_janczukowicz.gitlab.api.groupmarkdownuploads;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMarkdownUploadAdmin;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.pagination.GitLabListSpec;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPageRequest;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

/** The GitLab operations of group group markdown uploads. */
public final class GitLabGroupGroupMarkdownUploadsApi extends GitLabResourceApi {
    private static final String PARAM_FILENAME = "filename";
    private static final String PARAM_ID = "id";
    private static final String PARAM_SECRET = "secret";
    private static final PathTemplate AUTHORIZE = PathTemplate.of("/groups/{id}/uploads/authorize");
    private static final PathTemplate LIST = PathTemplate.of("/groups/{id}/uploads");
    private static final PathTemplate GET_BY_UPLOAD_ID = PathTemplate.of("/groups/{id}/uploads/{upload_id}");
    private static final PathTemplate GET_BY_SECRET_AND_FILENAME =
            PathTemplate.of("/groups/{id}/uploads/{secret}/{filename}");
    private static final JsonType<List<GitLabMarkdownUploadAdmin>> MARKDOWN_UPLOAD_ADMIN_LIST_TYPE =
            JsonTypes.listOf(GitLabMarkdownUploadAdmin.class);
    private static final GitLabListSpec<GitLabMarkdownUploadAdmin> MARKDOWN_UPLOAD_ADMIN_SPEC =
            GitLabListSpec.offset(MARKDOWN_UPLOAD_ADMIN_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupGroupMarkdownUploadsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Authorize ({@code POST /groups/{id}/uploads/authorize}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void authorize(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(post(AUTHORIZE, id));
    }

    /**
     * List ({@code GET /groups/{id}/uploads}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMarkdownUploadAdmin> list(final String id) throws IOException {
        return list(id, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /groups/{id}/uploads}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabMarkdownUploadAdmin> list(final String id, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, MARKDOWN_UPLOAD_ADMIN_SPEC, id);
    }

    /**
     * Create ({@code POST /groups/{id}/uploads}).
     *
     * @param id the id
     * @param form the form to send
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabGroupUpload create(final String id, final MultipartFormData form) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(form, "form");
        return caller.fetch(caller.multipart(post(LIST, id), form), GitLabGroupUpload.class);
    }

    /**
     * Get by upload id ({@code GET /groups/{id}/uploads/{upload_id}}).
     *
     * @param id the id
     * @param uploadId the upload id
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getByUploadId(final String id, final long uploadId, final OutputStream out) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(out, "out");
        return caller.download(get(GET_BY_UPLOAD_ID, id, uploadId), out);
    }

    /**
     * Get by upload id ({@code GET /groups/{id}/uploads/{upload_id}}).
     *
     * @param id the id
     * @param uploadId the upload id
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getByUploadId(final String id, final long uploadId, final Path target) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(target, "target");
        return caller.download(get(GET_BY_UPLOAD_ID, id, uploadId), target);
    }

    /**
     * Delete by upload id ({@code DELETE /groups/{id}/uploads/{upload_id}}).
     *
     * @param id the id
     * @param uploadId the upload id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteByUploadId(final String id, final long uploadId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET_BY_UPLOAD_ID, id, uploadId));
    }

    /**
     * Get by secret and filename ({@code GET /groups/{id}/uploads/{secret}/{filename}}).
     *
     * @param id the id
     * @param secret the secret
     * @param filename the filename
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id}, {@code secret} or {@code filename} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getBySecretAndFilename(
            final String id, final String secret, final String filename, final OutputStream out) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(secret, PARAM_SECRET);
        requireNotBlank(filename, PARAM_FILENAME);
        requireNonNull(out, "out");
        return caller.download(get(GET_BY_SECRET_AND_FILENAME, id, secret, filename), out);
    }

    /**
     * Get by secret and filename ({@code GET /groups/{id}/uploads/{secret}/{filename}}).
     *
     * @param id the id
     * @param secret the secret
     * @param filename the filename
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id}, {@code secret} or {@code filename} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getBySecretAndFilename(final String id, final String secret, final String filename, final Path target)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(secret, PARAM_SECRET);
        requireNotBlank(filename, PARAM_FILENAME);
        requireNonNull(target, "target");
        return caller.download(get(GET_BY_SECRET_AND_FILENAME, id, secret, filename), target);
    }

    /**
     * Delete by secret and filename ({@code DELETE /groups/{id}/uploads/{secret}/{filename}}).
     *
     * @param id the id
     * @param secret the secret
     * @param filename the filename
     * @throws IllegalArgumentException if {@code id}, {@code secret} or {@code filename} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteBySecretAndFilename(final String id, final String secret, final String filename)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(secret, PARAM_SECRET);
        requireNotBlank(filename, PARAM_FILENAME);
        caller.send(delete(GET_BY_SECRET_AND_FILENAME, id, secret, filename));
    }
}

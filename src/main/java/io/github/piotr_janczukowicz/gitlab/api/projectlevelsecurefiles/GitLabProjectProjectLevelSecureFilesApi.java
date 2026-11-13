package io.github.piotr_janczukowicz.gitlab.api.projectlevelsecurefiles;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

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
import java.util.Optional;

/** The GitLab operations of project project level secure files. */
public final class GitLabProjectProjectLevelSecureFilesApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/secure_files");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/secure_files/{secure_file_id}");
    private static final PathTemplate GET_DOWNLOAD =
            PathTemplate.of("/projects/{id}/secure_files/{secure_file_id}/download");
    private static final JsonType<List<GitLabCiSecureFile>> CI_SECURE_FILE_LIST_TYPE =
            JsonTypes.listOf(GitLabCiSecureFile.class);
    private static final GitLabListSpec<GitLabCiSecureFile> CI_SECURE_FILE_SPEC =
            GitLabListSpec.offset(CI_SECURE_FILE_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectProjectLevelSecureFilesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/secure_files}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiSecureFile> list(final String id) throws IOException {
        return list(id, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/secure_files}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabCiSecureFile> list(final String id, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, CI_SECURE_FILE_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/secure_files}).
     *
     * @param id the id
     * @param form the form to send
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCiSecureFile create(final String id, final MultipartFormData form) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(form, "form");
        return caller.fetch(caller.multipart(post(LIST, id), form), GitLabCiSecureFile.class);
    }

    /**
     * Get ({@code GET /projects/{id}/secure_files/{secure_file_id}}).
     *
     * @param id the id
     * @param secureFileId the secure file id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCiSecureFile> get(final String id, final long secureFileId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET, id, secureFileId), GitLabCiSecureFile.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/secure_files/{secure_file_id}}).
     *
     * @param id the id
     * @param secureFileId the secure file id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final long secureFileId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET, id, secureFileId));
    }

    /**
     * Get download ({@code GET /projects/{id}/secure_files/{secure_file_id}/download}).
     *
     * @param id the id
     * @param secureFileId the secure file id
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getDownload(final String id, final long secureFileId, final OutputStream out) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(out, "out");
        return caller.download(get(GET_DOWNLOAD, id, secureFileId), out);
    }

    /**
     * Get download ({@code GET /projects/{id}/secure_files/{secure_file_id}/download}).
     *
     * @param id the id
     * @param secureFileId the secure file id
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getDownload(final String id, final long secureFileId, final Path target) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(target, "target");
        return caller.download(get(GET_DOWNLOAD, id, secureFileId), target);
    }
}

package io.github.piotr_janczukowicz.gitlab.api.repositoryfiles;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.http.HttpMethod;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.http.client.HttpCall;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of project repository files. */
public final class GitLabProjectRepositoryFilesApi extends GitLabResourceApi {
    private static final String PARAM_FILEPATH = "filePath";
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_ID = "id";
    private static final String PARAM_REF = "ref";
    private static final PathTemplate LIST_BLAME = PathTemplate.of("/projects/{id}/repository/files/{file_path}/blame");
    private static final PathTemplate GET_RAW = PathTemplate.of("/projects/{id}/repository/files/{file_path}/raw");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/repository/files/{file_path}");
    private static final JsonType<List<GitLabBlameRange>> BLAME_RANGE_LIST_TYPE =
            JsonTypes.listOf(GitLabBlameRange.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectRepositoryFilesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List blame ({@code GET /projects/{id}/repository/files/{file_path}/blame}).
     *
     * @param id the id
     * @param filePath the file path
     * @param ref the ref
     * @param rangeStart the range start
     * @param rangeEnd the range end
     * @return the items
     * @throws IllegalArgumentException if {@code id}, {@code filePath} or {@code ref} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabBlameRange> listBlame(
            final String id, final String filePath, final String ref, final int rangeStart, final int rangeEnd)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(filePath, PARAM_FILEPATH);
        requireNotBlank(ref, PARAM_REF);
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .text(PARAM_REF, ref)
                .value("range[start]", rangeStart)
                .value("range[end]", rangeEnd)
                .build();
        return caller.fetch(get(LIST_BLAME, id, filePath).withQuery(queryParameters), BLAME_RANGE_LIST_TYPE);
    }

    /**
     * Head blame ({@code HEAD /projects/{id}/repository/files/{file_path}/blame}).
     *
     * @param id the id
     * @param filePath the file path
     * @param ref the ref
     * @return whether the resource exists
     * @throws IllegalArgumentException if {@code id}, {@code filePath} or {@code ref} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public boolean headBlame(final String id, final String filePath, final String ref) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(filePath, PARAM_FILEPATH);
        requireNotBlank(ref, PARAM_REF);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().text(PARAM_REF, ref).build();
        return caller.isExisting(
                HttpCall.of(HttpMethod.HEAD, LIST_BLAME.expand(id, filePath)).withQuery(queryParameters));
    }

    /**
     * Get raw ({@code GET /projects/{id}/repository/files/{file_path}/raw}).
     *
     * @param id the id
     * @param filePath the file path
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id} or {@code filePath} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getRaw(final String id, final String filePath, final OutputStream out) throws IOException {
        return getRaw(id, filePath, GitLabProjectRepositoryFilesGetRawFilter.empty(), out);
    }

    /**
     * Get raw ({@code GET /projects/{id}/repository/files/{file_path}/raw}).
     *
     * @param id the id
     * @param filePath the file path
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id} or {@code filePath} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getRaw(final String id, final String filePath, final Path target) throws IOException {
        return getRaw(id, filePath, GitLabProjectRepositoryFilesGetRawFilter.empty(), target);
    }

    /**
     * Get raw ({@code GET /projects/{id}/repository/files/{file_path}/raw}).
     *
     * @param id the id
     * @param filePath the file path
     * @param filter the optional query parameters
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id} or {@code filePath} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getRaw(
            final String id,
            final String filePath,
            final GitLabProjectRepositoryFilesGetRawFilter filter,
            final OutputStream out)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(filePath, PARAM_FILEPATH);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(out, "out");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.download(get(GET_RAW, id, filePath).withQuery(queryParameters), out);
    }

    /**
     * Get raw ({@code GET /projects/{id}/repository/files/{file_path}/raw}).
     *
     * @param id the id
     * @param filePath the file path
     * @param filter the optional query parameters
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id} or {@code filePath} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getRaw(
            final String id,
            final String filePath,
            final GitLabProjectRepositoryFilesGetRawFilter filter,
            final Path target)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(filePath, PARAM_FILEPATH);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(target, "target");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.download(get(GET_RAW, id, filePath).withQuery(queryParameters), target);
    }

    /**
     * Get ({@code GET /projects/{id}/repository/files/{file_path}}).
     *
     * @param id the id
     * @param filePath the file path
     * @param ref the ref
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id}, {@code filePath} or {@code ref} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabProjectRepositoryFilesGetResponse> get(
            final String id, final String filePath, final String ref) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(filePath, PARAM_FILEPATH);
        requireNotBlank(ref, PARAM_REF);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().text(PARAM_REF, ref).build();
        return caller.fetchOrEmpty(
                get(GET, id, filePath).withQuery(queryParameters), GitLabProjectRepositoryFilesGetResponse.class);
    }

    /**
     * Create ({@code POST /projects/{id}/repository/files/{file_path}}).
     *
     * @param id the id
     * @param filePath the file path
     * @param form the form to send
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code filePath} is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectRepositoryFilesCreateResponse create(
            final String id, final String filePath, final MultipartFormData form) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(filePath, PARAM_FILEPATH);
        requireNonNull(form, "form");
        return caller.fetch(
                caller.multipart(post(GET, id, filePath), form), GitLabProjectRepositoryFilesCreateResponse.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/repository/files/{file_path}}).
     *
     * @param id the id
     * @param filePath the file path
     * @param form the form to send
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code filePath} is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabProjectRepositoryFilesUpdateResponse update(
            final String id, final String filePath, final MultipartFormData form) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(filePath, PARAM_FILEPATH);
        requireNonNull(form, "form");
        return caller.fetch(
                caller.multipart(put(GET, id, filePath), form), GitLabProjectRepositoryFilesUpdateResponse.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/repository/files/{file_path}}).
     *
     * @param id the id
     * @param filePath the file path
     * @param branch the branch
     * @param commitMessage the commit message
     * @throws IllegalArgumentException if {@code id}, {@code filePath}, {@code branch} or {@code commitMessage} is
     *     blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final String filePath, final String branch, final String commitMessage)
            throws IOException {
        delete(id, filePath, branch, commitMessage, GitLabProjectRepositoryFilesDeleteFilter.empty());
    }

    /**
     * Delete ({@code DELETE /projects/{id}/repository/files/{file_path}}).
     *
     * @param id the id
     * @param filePath the file path
     * @param branch the branch
     * @param commitMessage the commit message
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id}, {@code filePath}, {@code branch} or {@code commitMessage} is
     *     blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(
            final String id,
            final String filePath,
            final String branch,
            final String commitMessage,
            final GitLabProjectRepositoryFilesDeleteFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(filePath, PARAM_FILEPATH);
        requireNotBlank(branch, "branch");
        requireNotBlank(commitMessage, "commitMessage");
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .all(filter.toQueryParameters())
                .text("branch", branch)
                .text("commit_message", commitMessage)
                .build();
        caller.send(delete(GET, id, filePath).withQuery(queryParameters));
    }

    /**
     * Head ({@code HEAD /projects/{id}/repository/files/{file_path}}).
     *
     * @param id the id
     * @param filePath the file path
     * @param ref the ref
     * @return whether the resource exists
     * @throws IllegalArgumentException if {@code id}, {@code filePath} or {@code ref} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public boolean head(final String id, final String filePath, final String ref) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(filePath, PARAM_FILEPATH);
        requireNotBlank(ref, PARAM_REF);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().text(PARAM_REF, ref).build();
        return caller.isExisting(
                HttpCall.of(HttpMethod.HEAD, GET.expand(id, filePath)).withQuery(queryParameters));
    }
}

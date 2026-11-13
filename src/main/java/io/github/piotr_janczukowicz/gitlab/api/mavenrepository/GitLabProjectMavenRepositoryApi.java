package io.github.piotr_janczukowicz.gitlab.api.mavenrepository;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of project maven repository. */
public final class GitLabProjectMavenRepositoryApi extends GitLabResourceApi {
    private static final String PARAM_FILENAME = "fileName";
    private static final String PARAM_ID = "id";
    private static final String PARAM_PATH = "path";
    private static final PathTemplate CALL = PathTemplate.of("/projects/{id}/packages/maven/{path}/{file_name}");
    private static final PathTemplate AUTHORIZE =
            PathTemplate.of("/projects/{id}/packages/maven/{path}/{file_name}/authorize");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectMavenRepositoryApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Call ({@code GET /projects/{id}/packages/maven/{path}/{file_name}}).
     *
     * @param id the id
     * @param path the path
     * @param fileName the file name
     * @throws IllegalArgumentException if {@code id}, {@code path} or {@code fileName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void call(final String id, final String path, final String fileName) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(path, PARAM_PATH);
        requireNotBlank(fileName, PARAM_FILENAME);
        caller.send(get(CALL, id, path, fileName));
    }

    /**
     * Update ({@code PUT /projects/{id}/packages/maven/{path}/{file_name}}).
     *
     * @param id the id
     * @param path the path
     * @param fileName the file name
     * @param form the form to send
     * @throws IllegalArgumentException if {@code id}, {@code path} or {@code fileName} is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void update(final String id, final String path, final String fileName, final MultipartFormData form)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(path, PARAM_PATH);
        requireNotBlank(fileName, PARAM_FILENAME);
        requireNonNull(form, "form");
        caller.send(caller.multipart(put(CALL, id, path, fileName), form));
    }

    /**
     * Authorize ({@code PUT /projects/{id}/packages/maven/{path}/{file_name}/authorize}).
     *
     * @param id the id
     * @param path the path
     * @param fileName the file name
     * @throws IllegalArgumentException if {@code id}, {@code path} or {@code fileName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void authorize(final String id, final String path, final String fileName) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(path, PARAM_PATH);
        requireNotBlank(fileName, PARAM_FILENAME);
        caller.send(put(AUTHORIZE, id, path, fileName));
    }
}

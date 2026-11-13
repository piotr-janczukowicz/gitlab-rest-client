package io.github.piotr_janczukowicz.gitlab.api.modelregistry;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.Map;

/** The GitLab operations of project model registry. */
public final class GitLabProjectModelRegistryApi extends GitLabResourceApi {
    private static final String PARAM_FILENAME = "fileName";
    private static final String PARAM_ID = "id";
    private static final String PARAM_MODELVERSIONID = "modelVersionId";
    private static final String PARAM_PATH = "path";
    private static final PathTemplate AUTHORIZE_FILE =
            PathTemplate.of("/projects/{id}/packages/ml_models/{model_version_id}/files/{file_name}/authorize");
    private static final PathTemplate AUTHORIZE_FILE_BY_PATH =
            PathTemplate.of("/projects/{id}/packages/ml_models/{model_version_id}/files/{path}/{file_name}/authorize");
    private static final PathTemplate CALL_FILE =
            PathTemplate.of("/projects/{id}/packages/ml_models/{model_version_id}/files/{file_name}");
    private static final PathTemplate CALL_FILE_BY_PATH =
            PathTemplate.of("/projects/{id}/packages/ml_models/{model_version_id}/files/{path}/{file_name}");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectModelRegistryApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Authorize file ({@code PUT /projects/{id}/packages/ml_models/{model_version_id}/files/{file_name}/authorize}).
     *
     * @param id the id
     * @param modelVersionId the model version id
     * @param fileName the file name
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id}, {@code modelVersionId} or {@code fileName} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void authorizeFile(
            final String id,
            final String modelVersionId,
            final String fileName,
            final GitLabProjectModelRegistryAuthorizeFilePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(modelVersionId, PARAM_MODELVERSIONID);
        requireNotBlank(fileName, PARAM_FILENAME);
        requireNonNull(payload, "payload");
        caller.send(caller.json(put(AUTHORIZE_FILE, id, modelVersionId, fileName), payload));
    }

    /**
     * Authorize file by path ({@code PUT
     * /projects/{id}/packages/ml_models/{model_version_id}/files/{path}/{file_name}/authorize}).
     *
     * @param id the id
     * @param modelVersionId the model version id
     * @param path the path
     * @param fileName the file name
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id}, {@code modelVersionId}, {@code path} or {@code fileName} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void authorizeFileByPath(
            final String id,
            final String modelVersionId,
            final String path,
            final String fileName,
            final GitLabProjectModelRegistryAuthorizeFileByPathPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(modelVersionId, PARAM_MODELVERSIONID);
        requireNotBlank(path, PARAM_PATH);
        requireNotBlank(fileName, PARAM_FILENAME);
        requireNonNull(payload, "payload");
        caller.send(caller.json(put(AUTHORIZE_FILE_BY_PATH, id, modelVersionId, path, fileName), payload));
    }

    /**
     * Call file ({@code GET /projects/{id}/packages/ml_models/{model_version_id}/files/{file_name}}).
     *
     * @param id the id
     * @param modelVersionId the model version id
     * @param fileName the file name
     * @throws IllegalArgumentException if {@code id}, {@code modelVersionId} or {@code fileName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callFile(final String id, final String modelVersionId, final String fileName) throws IOException {
        callFile(id, modelVersionId, fileName, GitLabProjectModelRegistryCallFileFilter.empty());
    }

    /**
     * Call file ({@code GET /projects/{id}/packages/ml_models/{model_version_id}/files/{file_name}}).
     *
     * @param id the id
     * @param modelVersionId the model version id
     * @param fileName the file name
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id}, {@code modelVersionId} or {@code fileName} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callFile(
            final String id,
            final String modelVersionId,
            final String fileName,
            final GitLabProjectModelRegistryCallFileFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(modelVersionId, PARAM_MODELVERSIONID);
        requireNotBlank(fileName, PARAM_FILENAME);
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(get(CALL_FILE, id, modelVersionId, fileName).withQuery(queryParameters));
    }

    /**
     * Update file ({@code PUT /projects/{id}/packages/ml_models/{model_version_id}/files/{file_name}}).
     *
     * @param id the id
     * @param modelVersionId the model version id
     * @param fileName the file name
     * @param form the form to send
     * @throws IllegalArgumentException if {@code id}, {@code modelVersionId} or {@code fileName} is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void updateFile(
            final String id, final String modelVersionId, final String fileName, final MultipartFormData form)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(modelVersionId, PARAM_MODELVERSIONID);
        requireNotBlank(fileName, PARAM_FILENAME);
        requireNonNull(form, "form");
        caller.send(caller.multipart(put(CALL_FILE, id, modelVersionId, fileName), form));
    }

    /**
     * Call file by path ({@code GET /projects/{id}/packages/ml_models/{model_version_id}/files/{path}/{file_name}}).
     *
     * @param id the id
     * @param modelVersionId the model version id
     * @param path the path
     * @param fileName the file name
     * @throws IllegalArgumentException if {@code id}, {@code modelVersionId}, {@code path} or {@code fileName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callFileByPath(final String id, final String modelVersionId, final String path, final String fileName)
            throws IOException {
        callFileByPath(id, modelVersionId, path, fileName, GitLabProjectModelRegistryCallFileByPathFilter.empty());
    }

    /**
     * Call file by path ({@code GET /projects/{id}/packages/ml_models/{model_version_id}/files/{path}/{file_name}}).
     *
     * @param id the id
     * @param modelVersionId the model version id
     * @param path the path
     * @param fileName the file name
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id}, {@code modelVersionId}, {@code path} or {@code fileName} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callFileByPath(
            final String id,
            final String modelVersionId,
            final String path,
            final String fileName,
            final GitLabProjectModelRegistryCallFileByPathFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(modelVersionId, PARAM_MODELVERSIONID);
        requireNotBlank(path, PARAM_PATH);
        requireNotBlank(fileName, PARAM_FILENAME);
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(get(CALL_FILE_BY_PATH, id, modelVersionId, path, fileName).withQuery(queryParameters));
    }

    /**
     * Update file by path ({@code PUT /projects/{id}/packages/ml_models/{model_version_id}/files/{path}/{file_name}}).
     *
     * @param id the id
     * @param modelVersionId the model version id
     * @param path the path
     * @param fileName the file name
     * @param form the form to send
     * @throws IllegalArgumentException if {@code id}, {@code modelVersionId}, {@code path} or {@code fileName} is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void updateFileByPath(
            final String id,
            final String modelVersionId,
            final String path,
            final String fileName,
            final MultipartFormData form)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(modelVersionId, PARAM_MODELVERSIONID);
        requireNotBlank(path, PARAM_PATH);
        requireNotBlank(fileName, PARAM_FILENAME);
        requireNonNull(form, "form");
        caller.send(caller.multipart(put(CALL_FILE_BY_PATH, id, modelVersionId, path, fileName), form));
    }
}

package io.github.piotr_janczukowicz.gitlab.api.pypipackages;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of project py pipackages. */
public final class GitLabProjectPyPIPackagesApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate CALL_FILE =
            PathTemplate.of("/projects/{id}/packages/pypi/files/{sha256}/{file_identifier}");
    private static final PathTemplate CALL_SIMPLE = PathTemplate.of("/projects/{id}/packages/pypi/simple");
    private static final PathTemplate CALL_SIMPLE_BY_PACKAGE_NAME =
            PathTemplate.of("/projects/{id}/packages/pypi/simple/{package_name}");
    private static final PathTemplate CREATE = PathTemplate.of("/projects/{id}/packages/pypi");
    private static final PathTemplate AUTHORIZE = PathTemplate.of("/projects/{id}/packages/pypi/authorize");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectPyPIPackagesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Call file ({@code GET /projects/{id}/packages/pypi/files/{sha256}/{file_identifier}}).
     *
     * @param id the id
     * @param sha256 the sha256
     * @param fileIdentifier the file identifier
     * @throws IllegalArgumentException if {@code id}, {@code sha256} or {@code fileIdentifier} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callFile(final String id, final String sha256, final String fileIdentifier) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(sha256, "sha256");
        requireNotBlank(fileIdentifier, "fileIdentifier");
        caller.send(get(CALL_FILE, id, sha256, fileIdentifier));
    }

    /**
     * Call simple ({@code GET /projects/{id}/packages/pypi/simple}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callSimple(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(get(CALL_SIMPLE, id));
    }

    /**
     * Call simple by package name ({@code GET /projects/{id}/packages/pypi/simple/{package_name}}).
     *
     * @param id the id
     * @param packageName the package name
     * @throws IllegalArgumentException if {@code id} or {@code packageName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callSimpleByPackageName(final String id, final String packageName) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, "packageName");
        caller.send(get(CALL_SIMPLE_BY_PACKAGE_NAME, id, packageName));
    }

    /**
     * Create ({@code POST /projects/{id}/packages/pypi}).
     *
     * @param id the id
     * @param form the form to send
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void create(final String id, final MultipartFormData form) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(form, "form");
        caller.send(caller.multipart(post(CREATE, id), form));
    }

    /**
     * Authorize ({@code POST /projects/{id}/packages/pypi/authorize}).
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
}

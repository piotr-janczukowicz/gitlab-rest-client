package io.github.piotr_janczukowicz.gitlab.api.rubygems;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.Map;

/** The GitLab operations of project ruby gems. */
public final class GitLabProjectRubyGemsApi extends GitLabResourceApi {
    private static final String PARAM_FILENAME = "fileName";
    private static final String PARAM_ID = "id";
    private static final String PARAM_OUT = "out";
    private static final String PARAM_TARGET = "target";
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/packages/rubygems/{file_name}");
    private static final PathTemplate GET_QUICK_MARSHAL48 =
            PathTemplate.of("/projects/{id}/packages/rubygems/quick/Marshal.4.8/{file_name}");
    private static final PathTemplate GET_GEM = PathTemplate.of("/projects/{id}/packages/rubygems/gems/{file_name}");
    private static final PathTemplate AUTHORIZE_API_V1_GEM =
            PathTemplate.of("/projects/{id}/packages/rubygems/api/v1/gems/authorize");
    private static final PathTemplate CREATE_API_V1_GEM =
            PathTemplate.of("/projects/{id}/packages/rubygems/api/v1/gems");
    private static final PathTemplate GET_API_V1_DEPENDENCIES =
            PathTemplate.of("/projects/{id}/packages/rubygems/api/v1/dependencies");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectRubyGemsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get ({@code GET /projects/{id}/packages/rubygems/{file_name}}).
     *
     * @param id the id
     * @param fileName the file name
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code fileName} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long get(final String id, final GitLabProjectRubyGemsGetFileName fileName, final OutputStream out)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(fileName, PARAM_FILENAME);
        requireNonNull(out, PARAM_OUT);
        return caller.download(get(GET, id, fileName.wireValue()), out);
    }

    /**
     * Get ({@code GET /projects/{id}/packages/rubygems/{file_name}}).
     *
     * @param id the id
     * @param fileName the file name
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code fileName} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path get(final String id, final GitLabProjectRubyGemsGetFileName fileName, final Path target)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(fileName, PARAM_FILENAME);
        requireNonNull(target, PARAM_TARGET);
        return caller.download(get(GET, id, fileName.wireValue()), target);
    }

    /**
     * Get quick marshal48 ({@code GET /projects/{id}/packages/rubygems/quick/Marshal.4.8/{file_name}}).
     *
     * @param id the id
     * @param fileName the file name
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id} or {@code fileName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getQuickMarshal48(final String id, final String fileName, final OutputStream out) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(fileName, PARAM_FILENAME);
        requireNonNull(out, PARAM_OUT);
        return caller.download(get(GET_QUICK_MARSHAL48, id, fileName), out);
    }

    /**
     * Get quick marshal48 ({@code GET /projects/{id}/packages/rubygems/quick/Marshal.4.8/{file_name}}).
     *
     * @param id the id
     * @param fileName the file name
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id} or {@code fileName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getQuickMarshal48(final String id, final String fileName, final Path target) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(fileName, PARAM_FILENAME);
        requireNonNull(target, PARAM_TARGET);
        return caller.download(get(GET_QUICK_MARSHAL48, id, fileName), target);
    }

    /**
     * Get gem ({@code GET /projects/{id}/packages/rubygems/gems/{file_name}}).
     *
     * @param id the id
     * @param fileName the file name
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id} or {@code fileName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getGem(final String id, final String fileName, final OutputStream out) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(fileName, PARAM_FILENAME);
        requireNonNull(out, PARAM_OUT);
        return caller.download(get(GET_GEM, id, fileName), out);
    }

    /**
     * Get gem ({@code GET /projects/{id}/packages/rubygems/gems/{file_name}}).
     *
     * @param id the id
     * @param fileName the file name
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id} or {@code fileName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getGem(final String id, final String fileName, final Path target) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(fileName, PARAM_FILENAME);
        requireNonNull(target, PARAM_TARGET);
        return caller.download(get(GET_GEM, id, fileName), target);
    }

    /**
     * Authorize api v1 gem ({@code POST /projects/{id}/packages/rubygems/api/v1/gems/authorize}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void authorizeApiV1Gem(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(post(AUTHORIZE_API_V1_GEM, id));
    }

    /**
     * Create api v1 gem ({@code POST /projects/{id}/packages/rubygems/api/v1/gems}).
     *
     * @param id the id
     * @param form the form to send
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createApiV1Gem(final String id, final MultipartFormData form) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(form, "form");
        caller.send(caller.multipart(post(CREATE_API_V1_GEM, id), form));
    }

    /**
     * Get api v1 dependencies ({@code GET /projects/{id}/packages/rubygems/api/v1/dependencies}).
     *
     * @param id the id
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getApiV1Dependencies(final String id, final OutputStream out) throws IOException {
        return getApiV1Dependencies(id, GitLabProjectRubyGemsGetApiV1DependenciesFilter.empty(), out);
    }

    /**
     * Get api v1 dependencies ({@code GET /projects/{id}/packages/rubygems/api/v1/dependencies}).
     *
     * @param id the id
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getApiV1Dependencies(final String id, final Path target) throws IOException {
        return getApiV1Dependencies(id, GitLabProjectRubyGemsGetApiV1DependenciesFilter.empty(), target);
    }

    /**
     * Get api v1 dependencies ({@code GET /projects/{id}/packages/rubygems/api/v1/dependencies}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getApiV1Dependencies(
            final String id, final GitLabProjectRubyGemsGetApiV1DependenciesFilter filter, final OutputStream out)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(out, PARAM_OUT);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.download(get(GET_API_V1_DEPENDENCIES, id).withQuery(queryParameters), out);
    }

    /**
     * Get api v1 dependencies ({@code GET /projects/{id}/packages/rubygems/api/v1/dependencies}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getApiV1Dependencies(
            final String id, final GitLabProjectRubyGemsGetApiV1DependenciesFilter filter, final Path target)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(target, PARAM_TARGET);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.download(get(GET_API_V1_DEPENDENCIES, id).withQuery(queryParameters), target);
    }
}

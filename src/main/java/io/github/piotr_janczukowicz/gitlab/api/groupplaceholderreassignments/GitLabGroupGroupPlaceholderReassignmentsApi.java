package io.github.piotr_janczukowicz.gitlab.api.groupplaceholderreassignments;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of group group placeholder reassignments. */
public final class GitLabGroupGroupPlaceholderReassignmentsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate GET = PathTemplate.of("/groups/{id}/placeholder_reassignments");
    private static final PathTemplate AUTHORIZE = PathTemplate.of("/groups/{id}/placeholder_reassignments/authorize");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupGroupPlaceholderReassignmentsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get ({@code GET /groups/{id}/placeholder_reassignments}).
     *
     * @param id the id
     * @return the text of the body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public String get(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return fetchText(get(GET, id));
    }

    /**
     * Create ({@code POST /groups/{id}/placeholder_reassignments}).
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
        caller.send(caller.multipart(post(GET, id), form));
    }

    /**
     * Authorize ({@code POST /groups/{id}/placeholder_reassignments/authorize}).
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

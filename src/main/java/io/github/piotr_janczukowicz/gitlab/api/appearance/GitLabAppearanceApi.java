package io.github.piotr_janczukowicz.gitlab.api.appearance;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of appearance. */
public final class GitLabAppearanceApi extends GitLabResourceApi {
    private static final PathTemplate GET = PathTemplate.of("/application/appearance");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabAppearanceApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get ({@code GET /application/appearance}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabAppearance get() throws IOException {
        return caller.fetch(get(GET), GitLabAppearance.class);
    }

    /**
     * Update ({@code PUT /application/appearance}).
     *
     * @param form the form to send
     * @return the resource
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabAppearance update(final MultipartFormData form) throws IOException {
        requireNonNull(form, "form");
        return caller.fetch(caller.multipart(put(GET), form), GitLabAppearance.class);
    }
}

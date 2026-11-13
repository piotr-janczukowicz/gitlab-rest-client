package io.github.piotr_janczukowicz.gitlab.api.suggestions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabSuggestion;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of suggestions. */
public final class GitLabSuggestionsApi extends GitLabResourceApi {
    private static final PathTemplate APPLY = PathTemplate.of("/suggestions/{id}/apply");
    private static final PathTemplate BATCH_APPLY = PathTemplate.of("/suggestions/batch_apply");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabSuggestionsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Apply ({@code PUT /suggestions/{id}/apply}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabSuggestion apply(final long id, final GitLabSuggestionsApplyPayload payload) throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(APPLY, id), payload), GitLabSuggestion.class);
    }

    /**
     * Batch apply ({@code PUT /suggestions/batch_apply}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabSuggestion batchApply(final GitLabSuggestionsBatchApplyPayload payload) throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(BATCH_APPLY), payload), GitLabSuggestion.class);
    }
}

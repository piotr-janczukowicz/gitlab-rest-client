package io.github.piotr_janczukowicz.gitlab.api.codesuggestions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of code suggestions. */
public final class GitLabCodeSuggestionsApi extends GitLabResourceApi {
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate CREATE_COMPLETION = PathTemplate.of("/code_suggestions/completions");
    private static final PathTemplate DIRECT_ACCESS = PathTemplate.of("/code_suggestions/direct_access");
    private static final PathTemplate ENABLED = PathTemplate.of("/code_suggestions/enabled");
    private static final PathTemplate CREATE_CONNECTION_DETAIL =
            PathTemplate.of("/code_suggestions/connection_details");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabCodeSuggestionsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Create completion ({@code POST /code_suggestions/completions}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createCompletion(final GitLabCodeSuggestionsCreateCompletionPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(CREATE_COMPLETION), payload));
    }

    /**
     * Direct access ({@code POST /code_suggestions/direct_access}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void directAccess(final GitLabCodeSuggestionsDirectAccessPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(DIRECT_ACCESS), payload));
    }

    /**
     * Enabled ({@code POST /code_suggestions/enabled}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void enabled(final GitLabCodeSuggestionsEnabledPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(ENABLED), payload));
    }

    /**
     * Create connection detail ({@code POST /code_suggestions/connection_details}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createConnectionDetail() throws IOException {
        caller.send(post(CREATE_CONNECTION_DETAIL));
    }
}

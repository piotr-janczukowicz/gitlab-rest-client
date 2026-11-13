package io.github.piotr_janczukowicz.gitlab.api.tokenexchange;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of token exchange. */
public final class GitLabTokenExchangeApi extends GitLabResourceApi {
    private static final PathTemplate CREATE = PathTemplate.of("/token_exchange");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabTokenExchangeApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Create ({@code POST /token_exchange}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabAuthnTokenExchange create(final GitLabTokenExchangeCreatePayload payload) throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(CREATE), payload), GitLabAuthnTokenExchange.class);
    }
}

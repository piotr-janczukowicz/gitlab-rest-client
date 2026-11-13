package io.github.piotr_janczukowicz.gitlab.api.jiraconnectsubscriptions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBasicSuccess;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of jira connect subscriptions. */
public final class GitLabJiraConnectSubscriptionsApi extends GitLabResourceApi {
    private static final PathTemplate CREATE_SUBSCRIPTION = PathTemplate.of("/integrations/jira_connect/subscriptions");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabJiraConnectSubscriptionsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Create subscription ({@code POST /integrations/jira_connect/subscriptions}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabBasicSuccess createSubscription(final GitLabJiraConnectSubscriptionsCreateSubscriptionPayload payload)
            throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(CREATE_SUBSCRIPTION), payload), GitLabBasicSuccess.class);
    }
}

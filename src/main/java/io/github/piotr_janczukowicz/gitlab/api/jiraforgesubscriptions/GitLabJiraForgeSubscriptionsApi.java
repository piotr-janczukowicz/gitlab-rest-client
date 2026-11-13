package io.github.piotr_janczukowicz.gitlab.api.jiraforgesubscriptions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBasicSuccess;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.Optional;

/** The GitLab operations of jira forge subscriptions. */
public final class GitLabJiraForgeSubscriptionsApi extends GitLabResourceApi {
    private static final PathTemplate GET_SUBSCRIPTIONS = PathTemplate.of("/integrations/jira_forge/subscriptions");
    private static final PathTemplate DELETE_SUBSCRIPTION =
            PathTemplate.of("/integrations/jira_forge/subscriptions/{id}");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabJiraForgeSubscriptionsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get subscriptions ({@code GET /integrations/jira_forge/subscriptions}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabJiraConnectSubscriptionEntity getSubscriptions() throws IOException {
        return caller.fetch(get(GET_SUBSCRIPTIONS), GitLabJiraConnectSubscriptionEntity.class);
    }

    /**
     * Create subscription ({@code POST /integrations/jira_forge/subscriptions}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabBasicSuccess createSubscription(final GitLabJiraForgeSubscriptionsCreateSubscriptionPayload payload)
            throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(GET_SUBSCRIPTIONS), payload), GitLabBasicSuccess.class);
    }

    /**
     * Delete subscription ({@code DELETE /integrations/jira_forge/subscriptions/{id}}).
     *
     * @param id the id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabBasicSuccess> deleteSubscription(final long id) throws IOException {
        return caller.fetchOptional(delete(DELETE_SUBSCRIPTION, id), GitLabBasicSuccess.class);
    }
}

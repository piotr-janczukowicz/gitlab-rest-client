package io.github.piotr_janczukowicz.gitlab.api.mobilepushsubscriptions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.Map;

/** The GitLab operations of mobile push subscriptions. */
public final class GitLabMobilePushSubscriptionsApi extends GitLabResourceApi {
    private static final PathTemplate CREATE = PathTemplate.of("/user/push_subscriptions");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabMobilePushSubscriptionsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Create ({@code POST /user/push_subscriptions}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMobilePushSubscription create(final GitLabMobilePushSubscriptionsCreatePayload payload)
            throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(CREATE), payload), GitLabMobilePushSubscription.class);
    }

    /**
     * Delete ({@code DELETE /user/push_subscriptions}).
     *
     * @param deviceToken the device token
     * @throws IllegalArgumentException if {@code deviceToken} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String deviceToken) throws IOException {
        requireNotBlank(deviceToken, "deviceToken");
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .text("device_token", deviceToken)
                .build();
        caller.send(delete(CREATE).withQuery(queryParameters));
    }
}

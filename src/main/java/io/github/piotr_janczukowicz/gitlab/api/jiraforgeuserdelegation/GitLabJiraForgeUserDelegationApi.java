package io.github.piotr_janczukowicz.gitlab.api.jiraforgeuserdelegation;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBasicSuccess;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;

/** The GitLab operations of jira forge user delegation. */
public final class GitLabJiraForgeUserDelegationApi extends GitLabResourceApi {
    private static final PathTemplate USER_DELEGATION = PathTemplate.of("/integrations/jira_forge/user_delegation");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabJiraForgeUserDelegationApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * User delegation ({@code POST /integrations/jira_forge/user_delegation}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabBasicSuccess userDelegation(final GitLabJiraForgeUserDelegationUserDelegationPayload payload)
            throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(USER_DELEGATION), payload), GitLabBasicSuccess.class);
    }
}

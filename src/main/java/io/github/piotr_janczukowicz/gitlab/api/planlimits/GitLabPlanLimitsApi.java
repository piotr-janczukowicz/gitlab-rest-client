package io.github.piotr_janczukowicz.gitlab.api.planlimits;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.Map;

/** The GitLab operations of plan limits. */
public final class GitLabPlanLimitsApi extends GitLabResourceApi {
    private static final PathTemplate GET = PathTemplate.of("/application/plan_limits");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabPlanLimitsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get ({@code GET /application/plan_limits}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPlanLimit get() throws IOException {
        return get(GitLabPlanLimitsGetFilter.empty());
    }

    /**
     * Get ({@code GET /application/plan_limits}).
     *
     * @param filter the optional query parameters
     * @return the resource
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPlanLimit get(final GitLabPlanLimitsGetFilter filter) throws IOException {
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetch(get(GET).withQuery(queryParameters), GitLabPlanLimit.class);
    }

    /**
     * Update ({@code PUT /application/plan_limits}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPlanLimit update(final GitLabPlanLimitsUpdatePayload payload) throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET), payload), GitLabPlanLimit.class);
    }
}

package io.github.piotr_janczukowicz.gitlab.api.sidekiqqueuesadministration;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.Map;

/** The GitLab operations of sidekiq queues administration. */
public final class GitLabSidekiqQueuesAdministrationApi extends GitLabResourceApi {
    private static final PathTemplate DELETE = PathTemplate.of("/admin/sidekiq/queues/{queue_name}");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabSidekiqQueuesAdministrationApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Delete ({@code DELETE /admin/sidekiq/queues/{queue_name}}).
     *
     * @param queueName the queue name
     * @throws IllegalArgumentException if {@code queueName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String queueName) throws IOException {
        delete(queueName, GitLabSidekiqQueuesAdministrationDeleteFilter.empty());
    }

    /**
     * Delete ({@code DELETE /admin/sidekiq/queues/{queue_name}}).
     *
     * @param queueName the queue name
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code queueName} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String queueName, final GitLabSidekiqQueuesAdministrationDeleteFilter filter)
            throws IOException {
        requireNotBlank(queueName, "queueName");
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(delete(DELETE, queueName).withQuery(queryParameters));
    }
}

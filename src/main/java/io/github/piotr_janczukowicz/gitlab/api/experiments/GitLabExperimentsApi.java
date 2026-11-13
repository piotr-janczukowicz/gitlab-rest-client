package io.github.piotr_janczukowicz.gitlab.api.experiments;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of experiments. */
public final class GitLabExperimentsApi extends GitLabResourceApi {
    private static final String PARAM_EXPERIMENTNAME = "experimentName";
    private static final PathTemplate LIST = PathTemplate.of("/experiments");
    private static final PathTemplate DELETE_CACHE = PathTemplate.of("/experiments/{name}/cache");
    private static final PathTemplate GET_ASSIGNMENTS = PathTemplate.of("/experiments/{experiment_name}/assignments");
    private static final JsonType<List<GitLabExperiment>> EXPERIMENT_LIST_TYPE =
            JsonTypes.listOf(GitLabExperiment.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabExperimentsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /experiments}).
     *
     * @return the items
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabExperiment> list() throws IOException {
        return caller.fetch(get(LIST), EXPERIMENT_LIST_TYPE);
    }

    /**
     * Delete cache ({@code DELETE /experiments/{name}/cache}).
     *
     * @param name the name
     * @throws IllegalArgumentException if {@code name} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteCache(final String name) throws IOException {
        requireNotBlank(name, "name");
        caller.send(delete(DELETE_CACHE, name));
    }

    /**
     * Get assignments ({@code GET /experiments/{experiment_name}/assignments}).
     *
     * @param experimentName the experiment name
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code experimentName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabExperimentAssignment> getAssignments(final String experimentName) throws IOException {
        return getAssignments(experimentName, GitLabExperimentsGetAssignmentsFilter.empty());
    }

    /**
     * Get assignments ({@code GET /experiments/{experiment_name}/assignments}).
     *
     * @param experimentName the experiment name
     * @param filter the optional query parameters
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code experimentName} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabExperimentAssignment> getAssignments(
            final String experimentName, final GitLabExperimentsGetAssignmentsFilter filter) throws IOException {
        requireNotBlank(experimentName, PARAM_EXPERIMENTNAME);
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOrEmpty(
                get(GET_ASSIGNMENTS, experimentName).withQuery(queryParameters), GitLabExperimentAssignment.class);
    }

    /**
     * Create assignment ({@code POST /experiments/{experiment_name}/assignments}).
     *
     * @param experimentName the experiment name
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code experimentName} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabExperimentAssignment createAssignment(
            final String experimentName, final GitLabExperimentsCreateAssignmentPayload payload) throws IOException {
        requireNotBlank(experimentName, PARAM_EXPERIMENTNAME);
        requireNonNull(payload, "payload");
        return caller.fetch(
                caller.json(post(GET_ASSIGNMENTS, experimentName), payload), GitLabExperimentAssignment.class);
    }

    /**
     * Delete assignment ({@code DELETE /experiments/{experiment_name}/assignments}).
     *
     * @param experimentName the experiment name
     * @throws IllegalArgumentException if {@code experimentName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteAssignment(final String experimentName) throws IOException {
        deleteAssignment(experimentName, GitLabExperimentsDeleteAssignmentFilter.empty());
    }

    /**
     * Delete assignment ({@code DELETE /experiments/{experiment_name}/assignments}).
     *
     * @param experimentName the experiment name
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code experimentName} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteAssignment(final String experimentName, final GitLabExperimentsDeleteAssignmentFilter filter)
            throws IOException {
        requireNotBlank(experimentName, PARAM_EXPERIMENTNAME);
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(delete(GET_ASSIGNMENTS, experimentName).withQuery(queryParameters));
    }
}

package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.pagination.GitLabListSpec;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPageRequest;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of project feature flags. */
public final class GitLabProjectFeatureFlagsApi extends GitLabResourceApi {
    private static final String PARAM_FEATUREFLAGNAME = "featureFlagName";
    private static final String PARAM_ID = "id";
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/feature_flags");
    private static final PathTemplate GET_FEATURE_FLAGS_SETTINGS =
            PathTemplate.of("/projects/{id}/feature_flags_settings");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/feature_flags/{feature_flag_name}");
    private static final JsonType<List<GitLabFeatureFlag>> FEATURE_FLAG_LIST_TYPE =
            JsonTypes.listOf(GitLabFeatureFlag.class);
    private static final GitLabListSpec<GitLabFeatureFlag> FEATURE_FLAG_SPEC =
            GitLabListSpec.offset(FEATURE_FLAG_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectFeatureFlagsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/feature_flags}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabFeatureFlag> list(final String id) throws IOException {
        return list(id, GitLabProjectFeatureFlagsListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/feature_flags}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabFeatureFlag> list(final String id, final GitLabPageRequest request) throws IOException {
        return list(id, GitLabProjectFeatureFlagsListFilter.empty(), request);
    }

    /**
     * List ({@code GET /projects/{id}/feature_flags}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabFeatureFlag> list(final String id, final GitLabProjectFeatureFlagsListFilter filter)
            throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/feature_flags}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabFeatureFlag> list(
            final String id, final GitLabProjectFeatureFlagsListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, FEATURE_FLAG_SPEC, id);
    }

    /**
     * Create ({@code POST /projects/{id}/feature_flags}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabFeatureFlag create(final String id, final GitLabProjectFeatureFlagsCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST, id), payload), GitLabFeatureFlag.class);
    }

    /**
     * Get feature flags settings ({@code GET /projects/{id}/feature_flags_settings}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabFeatureFlagSettings getFeatureFlagsSettings(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(GET_FEATURE_FLAGS_SETTINGS, id), GitLabFeatureFlagSettings.class);
    }

    /**
     * Update feature flags setting ({@code PUT /projects/{id}/feature_flags_settings}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabFeatureFlagSettings updateFeatureFlagsSetting(
            final String id, final GitLabProjectFeatureFlagsUpdateFeatureFlagsSettingPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET_FEATURE_FLAGS_SETTINGS, id), payload), GitLabFeatureFlagSettings.class);
    }

    /**
     * Get ({@code GET /projects/{id}/feature_flags/{feature_flag_name}}).
     *
     * @param id the id
     * @param featureFlagName the feature flag name
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code featureFlagName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabFeatureFlag> get(final String id, final String featureFlagName) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(featureFlagName, PARAM_FEATUREFLAGNAME);
        return caller.fetchOrEmpty(get(GET, id, featureFlagName), GitLabFeatureFlag.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/feature_flags/{feature_flag_name}}).
     *
     * @param id the id
     * @param featureFlagName the feature flag name
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code featureFlagName} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabFeatureFlag update(
            final String id, final String featureFlagName, final GitLabProjectFeatureFlagsUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(featureFlagName, PARAM_FEATUREFLAGNAME);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GET, id, featureFlagName), payload), GitLabFeatureFlag.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/feature_flags/{feature_flag_name}}).
     *
     * @param id the id
     * @param featureFlagName the feature flag name
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} or {@code featureFlagName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabFeatureFlag> delete(final String id, final String featureFlagName) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(featureFlagName, PARAM_FEATUREFLAGNAME);
        return caller.fetchOptional(delete(GET, id, featureFlagName), GitLabFeatureFlag.class);
    }
}

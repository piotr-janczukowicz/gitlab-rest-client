package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabFeatureDefinition;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;

/** The GitLab operations of instance feature flags. */
public final class GitLabInstanceFeatureFlagsApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/features");
    private static final PathTemplate LIST_DEFINITIONS = PathTemplate.of("/features/definitions");
    private static final PathTemplate CREATE = PathTemplate.of("/features/{name}");
    private static final JsonType<List<GitLabFeature>> FEATURE_LIST_TYPE = JsonTypes.listOf(GitLabFeature.class);
    private static final JsonType<List<GitLabFeatureDefinition>> FEATURE_DEFINITION_LIST_TYPE =
            JsonTypes.listOf(GitLabFeatureDefinition.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabInstanceFeatureFlagsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /features}).
     *
     * @return the items
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabFeature> list() throws IOException {
        return caller.fetch(get(LIST), FEATURE_LIST_TYPE);
    }

    /**
     * List definitions ({@code GET /features/definitions}).
     *
     * @return the items
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabFeatureDefinition> listDefinitions() throws IOException {
        return caller.fetch(get(LIST_DEFINITIONS), FEATURE_DEFINITION_LIST_TYPE);
    }

    /**
     * Create ({@code POST /features/{name}}).
     *
     * @param name the name
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code name} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabFeature create(final String name, final GitLabInstanceFeatureFlagsCreatePayload payload)
            throws IOException {
        requireNotBlank(name, "name");
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(CREATE, name), payload), GitLabFeature.class);
    }

    /**
     * Delete ({@code DELETE /features/{name}}).
     *
     * @param name the name
     * @throws IllegalArgumentException if {@code name} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String name) throws IOException {
        requireNotBlank(name, "name");
        caller.send(delete(CREATE, name));
    }
}

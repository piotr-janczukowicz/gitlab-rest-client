package io.github.piotr_janczukowicz.gitlab.api.customattributes;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCustomAttribute;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/** The GitLab operations of instance custom attributes. */
public final class GitLabInstanceCustomAttributesApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_KEY = "key";
    private static final PathTemplate LIST = PathTemplate.of("/users/{id}/custom_attributes");
    private static final PathTemplate GET = PathTemplate.of("/users/{id}/custom_attributes/{key}");
    private static final JsonType<List<GitLabCustomAttribute>> CUSTOM_ATTRIBUTE_LIST_TYPE =
            JsonTypes.listOf(GitLabCustomAttribute.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabInstanceCustomAttributesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /users/{id}/custom_attributes}).
     *
     * @param id the id
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabCustomAttribute> list(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(LIST, id), CUSTOM_ATTRIBUTE_LIST_TYPE);
    }

    /**
     * Get ({@code GET /users/{id}/custom_attributes/{key}}).
     *
     * @param id the id
     * @param key the key
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code key} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabCustomAttribute> get(final String id, final String key) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(key, PARAM_KEY);
        return caller.fetchOrEmpty(get(GET, id, key), GitLabCustomAttribute.class);
    }

    /**
     * Update ({@code PUT /users/{id}/custom_attributes/{key}}).
     *
     * @param id the id
     * @param key the key
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} or {@code key} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabCustomAttribute update(
            final String id, final String key, final GitLabInstanceCustomAttributesUpdatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(key, PARAM_KEY);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(GET, id, key), payload), GitLabCustomAttribute.class);
    }

    /**
     * Delete ({@code DELETE /users/{id}/custom_attributes/{key}}).
     *
     * @param id the id
     * @param key the key
     * @throws IllegalArgumentException if {@code id} or {@code key} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final String key) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(key, PARAM_KEY);
        caller.send(delete(GET, id, key));
    }
}

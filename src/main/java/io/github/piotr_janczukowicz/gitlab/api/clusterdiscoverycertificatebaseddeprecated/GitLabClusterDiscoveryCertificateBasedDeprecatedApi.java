package io.github.piotr_janczukowicz.gitlab.api.clusterdiscoverycertificatebaseddeprecated;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.Map;

/** The GitLab operations of cluster discovery certificate based deprecated. */
public final class GitLabClusterDiscoveryCertificateBasedDeprecatedApi extends GitLabResourceApi {
    private static final PathTemplate GET = PathTemplate.of("/discover-cert-based-clusters");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabClusterDiscoveryCertificateBasedDeprecatedApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get ({@code GET /discover-cert-based-clusters}).
     *
     * @param groupId the group id
     * @return the resource
     * @throws NullPointerException if {@code groupId} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabDiscoveredClusters get(final Long groupId) throws IOException {
        requireNonNull(groupId, "groupId");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().value("group_id", groupId).build();
        return caller.fetch(get(GET).withQuery(queryParameters), GitLabDiscoveredClusters.class);
    }
}

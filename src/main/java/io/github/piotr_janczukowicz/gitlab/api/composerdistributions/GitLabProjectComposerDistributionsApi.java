package io.github.piotr_janczukowicz.gitlab.api.composerdistributions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.Map;

/** The GitLab operations of project composer distributions. */
public final class GitLabProjectComposerDistributionsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_PACKAGENAME = "packageName";
    private static final String PARAM_SHA = "sha";
    private static final PathTemplate CALL_GROUP_PACKAGES_COMPOSER_PACKAGES =
            PathTemplate.of("/group/{id}/-/packages/composer/packages");
    private static final PathTemplate CALL_GROUP_PACKAGES_COMPOSER_P =
            PathTemplate.of("/group/{id}/-/packages/composer/p/{sha}");
    private static final PathTemplate CALL_GROUP_PACKAGES_COMPOSER_P2 =
            PathTemplate.of("/group/{id}/-/packages/composer/p2/{package_name}");
    private static final PathTemplate CALL_GROUP_PACKAGES_COMPOSER =
            PathTemplate.of("/group/{id}/-/packages/composer/{package_name}");
    private static final PathTemplate CREATE = PathTemplate.of("/projects/{id}/packages/composer");
    private static final PathTemplate CALL_ARCHIVE =
            PathTemplate.of("/projects/{id}/packages/composer/archives/{package_name}");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectComposerDistributionsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Call group packages composer packages ({@code GET /group/{id}/-/packages/composer/packages}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callGroupPackagesComposerPackages(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(get(CALL_GROUP_PACKAGES_COMPOSER_PACKAGES, id));
    }

    /**
     * Call group packages composer p ({@code GET /group/{id}/-/packages/composer/p/{sha}}).
     *
     * @param id the id
     * @param sha the sha
     * @throws IllegalArgumentException if {@code id} or {@code sha} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callGroupPackagesComposerP(final String id, final String sha) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(sha, PARAM_SHA);
        caller.send(get(CALL_GROUP_PACKAGES_COMPOSER_P, id, sha));
    }

    /**
     * Call group packages composer p2 ({@code GET /group/{id}/-/packages/composer/p2/{package_name}}).
     *
     * @param id the id
     * @param packageName the package name
     * @throws IllegalArgumentException if {@code id} or {@code packageName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callGroupPackagesComposerP2(final String id, final String packageName) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        caller.send(get(CALL_GROUP_PACKAGES_COMPOSER_P2, id, packageName));
    }

    /**
     * Call group packages composer ({@code GET /group/{id}/-/packages/composer/{package_name}}).
     *
     * @param id the id
     * @param packageName the package name
     * @throws IllegalArgumentException if {@code id} or {@code packageName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callGroupPackagesComposer(final String id, final String packageName) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        caller.send(get(CALL_GROUP_PACKAGES_COMPOSER, id, packageName));
    }

    /**
     * Create ({@code POST /projects/{id}/packages/composer}).
     *
     * @param id the id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void create(final String id, final GitLabProjectComposerDistributionsCreatePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, "payload");
        caller.send(caller.json(post(CREATE, id), payload));
    }

    /**
     * Call archive ({@code GET /projects/{id}/packages/composer/archives/{package_name}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param sha the sha
     * @throws IllegalArgumentException if {@code id}, {@code packageName} or {@code sha} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callArchive(final String id, final String packageName, final String sha) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(sha, PARAM_SHA);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().text(PARAM_SHA, sha).build();
        caller.send(get(CALL_ARCHIVE, id, packageName).withQuery(queryParameters));
    }
}

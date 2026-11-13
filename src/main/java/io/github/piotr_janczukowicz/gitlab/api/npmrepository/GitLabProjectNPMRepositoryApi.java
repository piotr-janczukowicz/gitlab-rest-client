package io.github.piotr_janczukowicz.gitlab.api.npmrepository;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.Optional;

/** The GitLab operations of project npmrepository. */
public final class GitLabProjectNPMRepositoryApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_PACKAGENAME = "packageName";
    private static final String PARAM_TAG = "tag";
    private static final PathTemplate GET_PROJECT_PACKAGE_DIST_TAGS =
            PathTemplate.of("/projects/{id}/packages/npm/-/package/{package_name}/dist-tags");
    private static final PathTemplate UPDATE_PROJECT_PACKAGE_DIST_TAG =
            PathTemplate.of("/projects/{id}/packages/npm/-/package/{package_name}/dist-tags/{tag}");
    private static final PathTemplate BULK_PROJECT_NPM_V1_SECURITY_ADVISORY =
            PathTemplate.of("/projects/{id}/packages/npm/-/npm/v1/security/advisories/bulk");
    private static final PathTemplate QUICK_PROJECT_NPM_V1_SECURITY_AUDIT =
            PathTemplate.of("/projects/{id}/packages/npm/-/npm/v1/security/audits/quick");
    private static final PathTemplate CALL =
            PathTemplate.of("/projects/{id}/packages/npm/{package_name}/-/{file_name}");
    private static final PathTemplate GET_PROJECT = PathTemplate.of("/projects/{id}/packages/npm/{package_name}");
    private static final PathTemplate GET_PACKAGE_DIST_TAGS =
            PathTemplate.of("/packages/npm/-/package/{package_name}/dist-tags");
    private static final PathTemplate UPDATE_PACKAGE_DIST_TAG =
            PathTemplate.of("/packages/npm/-/package/{package_name}/dist-tags/{tag}");
    private static final PathTemplate BULK_NPM_V1_SECURITY_ADVISORY =
            PathTemplate.of("/packages/npm/-/npm/v1/security/advisories/bulk");
    private static final PathTemplate QUICK_NPM_V1_SECURITY_AUDIT =
            PathTemplate.of("/packages/npm/-/npm/v1/security/audits/quick");
    private static final PathTemplate GET = PathTemplate.of("/packages/npm/{package_name}");
    private static final PathTemplate GET_GROUP_PACKAGE_DIST_TAGS =
            PathTemplate.of("/groups/{id}/-/packages/npm/-/package/{package_name}/dist-tags");
    private static final PathTemplate UPDATE_GROUP_PACKAGE_DIST_TAG =
            PathTemplate.of("/groups/{id}/-/packages/npm/-/package/{package_name}/dist-tags/{tag}");
    private static final PathTemplate BULK_GROUP_NPM_V1_SECURITY_ADVISORY =
            PathTemplate.of("/groups/{id}/-/packages/npm/-/npm/v1/security/advisories/bulk");
    private static final PathTemplate QUICK_GROUP_NPM_V1_SECURITY_AUDIT =
            PathTemplate.of("/groups/{id}/-/packages/npm/-/npm/v1/security/audits/quick");
    private static final PathTemplate GET_GROUP = PathTemplate.of("/groups/{id}/-/packages/npm/{package_name}");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectNPMRepositoryApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get project package dist tags ({@code GET /projects/{id}/packages/npm/-/package/{package_name}/dist-tags}).
     *
     * @param id the id
     * @param packageName the package name
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code packageName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabNpmPackageTag> getProjectPackageDistTags(final String id, final String packageName)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        return caller.fetchOrEmpty(get(GET_PROJECT_PACKAGE_DIST_TAGS, id, packageName), GitLabNpmPackageTag.class);
    }

    /**
     * Update project package dist tag ({@code PUT
     * /projects/{id}/packages/npm/-/package/{package_name}/dist-tags/{tag}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param tag the tag
     * @throws IllegalArgumentException if {@code id}, {@code packageName} or {@code tag} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void updateProjectPackageDistTag(final String id, final String packageName, final String tag)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(tag, PARAM_TAG);
        caller.send(put(UPDATE_PROJECT_PACKAGE_DIST_TAG, id, packageName, tag));
    }

    /**
     * Delete project package dist tag ({@code DELETE
     * /projects/{id}/packages/npm/-/package/{package_name}/dist-tags/{tag}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param tag the tag
     * @throws IllegalArgumentException if {@code id}, {@code packageName} or {@code tag} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteProjectPackageDistTag(final String id, final String packageName, final String tag)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(tag, PARAM_TAG);
        caller.send(delete(UPDATE_PROJECT_PACKAGE_DIST_TAG, id, packageName, tag));
    }

    /**
     * Bulk project npm v1 security advisory ({@code POST
     * /projects/{id}/packages/npm/-/npm/v1/security/advisories/bulk}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void bulkProjectNpmV1SecurityAdvisory(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(post(BULK_PROJECT_NPM_V1_SECURITY_ADVISORY, id));
    }

    /**
     * Quick project npm v1 security audit ({@code POST /projects/{id}/packages/npm/-/npm/v1/security/audits/quick}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void quickProjectNpmV1SecurityAudit(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(post(QUICK_PROJECT_NPM_V1_SECURITY_AUDIT, id));
    }

    /**
     * Call ({@code GET /projects/{id}/packages/npm/{package_name}/-/{file_name}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param fileName the file name
     * @throws IllegalArgumentException if {@code id}, {@code packageName} or {@code fileName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void call(final String id, final String packageName, final String fileName) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(fileName, "fileName");
        caller.send(get(CALL, id, packageName, fileName));
    }

    /**
     * Get project ({@code GET /projects/{id}/packages/npm/{package_name}}).
     *
     * @param id the id
     * @param packageName the package name
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code packageName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabNpmPackage> getProject(final String id, final String packageName) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        return caller.fetchOrEmpty(get(GET_PROJECT, id, packageName), GitLabNpmPackage.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/packages/npm/{package_name}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param form the form to send
     * @throws IllegalArgumentException if {@code id} or {@code packageName} is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void update(final String id, final String packageName, final MultipartFormData form) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNonNull(form, "form");
        caller.send(caller.multipart(put(GET_PROJECT, id, packageName), form));
    }

    /**
     * Get package dist tags ({@code GET /packages/npm/-/package/{package_name}/dist-tags}).
     *
     * @param packageName the package name
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code packageName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabNpmPackageTag> getPackageDistTags(final String packageName) throws IOException {
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        return caller.fetchOrEmpty(get(GET_PACKAGE_DIST_TAGS, packageName), GitLabNpmPackageTag.class);
    }

    /**
     * Update package dist tag ({@code PUT /packages/npm/-/package/{package_name}/dist-tags/{tag}}).
     *
     * @param packageName the package name
     * @param tag the tag
     * @throws IllegalArgumentException if {@code packageName} or {@code tag} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void updatePackageDistTag(final String packageName, final String tag) throws IOException {
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(tag, PARAM_TAG);
        caller.send(put(UPDATE_PACKAGE_DIST_TAG, packageName, tag));
    }

    /**
     * Delete package dist tag ({@code DELETE /packages/npm/-/package/{package_name}/dist-tags/{tag}}).
     *
     * @param packageName the package name
     * @param tag the tag
     * @throws IllegalArgumentException if {@code packageName} or {@code tag} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deletePackageDistTag(final String packageName, final String tag) throws IOException {
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(tag, PARAM_TAG);
        caller.send(delete(UPDATE_PACKAGE_DIST_TAG, packageName, tag));
    }

    /**
     * Bulk npm v1 security advisory ({@code POST /packages/npm/-/npm/v1/security/advisories/bulk}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void bulkNpmV1SecurityAdvisory() throws IOException {
        caller.send(post(BULK_NPM_V1_SECURITY_ADVISORY));
    }

    /**
     * Quick npm v1 security audit ({@code POST /packages/npm/-/npm/v1/security/audits/quick}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void quickNpmV1SecurityAudit() throws IOException {
        caller.send(post(QUICK_NPM_V1_SECURITY_AUDIT));
    }

    /**
     * Get ({@code GET /packages/npm/{package_name}}).
     *
     * @param packageName the package name
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code packageName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabNpmPackage> get(final String packageName) throws IOException {
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        return caller.fetchOrEmpty(get(GET, packageName), GitLabNpmPackage.class);
    }

    /**
     * Get group package dist tags ({@code GET /groups/{id}/-/packages/npm/-/package/{package_name}/dist-tags}).
     *
     * @param id the id
     * @param packageName the package name
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code packageName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabNpmPackageTag> getGroupPackageDistTags(final String id, final String packageName)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        return caller.fetchOrEmpty(get(GET_GROUP_PACKAGE_DIST_TAGS, id, packageName), GitLabNpmPackageTag.class);
    }

    /**
     * Update group package dist tag ({@code PUT /groups/{id}/-/packages/npm/-/package/{package_name}/dist-tags/{tag}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param tag the tag
     * @throws IllegalArgumentException if {@code id}, {@code packageName} or {@code tag} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void updateGroupPackageDistTag(final String id, final String packageName, final String tag)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(tag, PARAM_TAG);
        caller.send(put(UPDATE_GROUP_PACKAGE_DIST_TAG, id, packageName, tag));
    }

    /**
     * Delete group package dist tag ({@code DELETE
     * /groups/{id}/-/packages/npm/-/package/{package_name}/dist-tags/{tag}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param tag the tag
     * @throws IllegalArgumentException if {@code id}, {@code packageName} or {@code tag} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteGroupPackageDistTag(final String id, final String packageName, final String tag)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(tag, PARAM_TAG);
        caller.send(delete(UPDATE_GROUP_PACKAGE_DIST_TAG, id, packageName, tag));
    }

    /**
     * Bulk group npm v1 security advisory ({@code POST /groups/{id}/-/packages/npm/-/npm/v1/security/advisories/bulk}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void bulkGroupNpmV1SecurityAdvisory(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(post(BULK_GROUP_NPM_V1_SECURITY_ADVISORY, id));
    }

    /**
     * Quick group npm v1 security audit ({@code POST /groups/{id}/-/packages/npm/-/npm/v1/security/audits/quick}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void quickGroupNpmV1SecurityAudit(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(post(QUICK_GROUP_NPM_V1_SECURITY_AUDIT, id));
    }

    /**
     * Get group ({@code GET /groups/{id}/-/packages/npm/{package_name}}).
     *
     * @param id the id
     * @param packageName the package name
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code packageName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabNpmPackage> getGroup(final String id, final String packageName) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        return caller.fetchOrEmpty(get(GET_GROUP, id, packageName), GitLabNpmPackage.class);
    }
}

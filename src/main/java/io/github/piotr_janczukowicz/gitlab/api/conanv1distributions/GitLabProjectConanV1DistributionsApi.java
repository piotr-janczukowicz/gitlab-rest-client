package io.github.piotr_janczukowicz.gitlab.api.conanv1distributions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of project conan v1 distributions. */
public final class GitLabProjectConanV1DistributionsApi extends GitLabResourceApi {
    private static final String PARAM_CONANPACKAGEREFERENCE = "conanPackageReference";
    private static final String PARAM_FILENAME = "fileName";
    private static final String PARAM_FORM = "form";
    private static final String PARAM_ID = "id";
    private static final String PARAM_PACKAGECHANNEL = "packageChannel";
    private static final String PARAM_PACKAGENAME = "packageName";
    private static final String PARAM_PACKAGEREVISION = "packageRevision";
    private static final String PARAM_PACKAGEUSERNAME = "packageUsername";
    private static final String PARAM_PACKAGEVERSION = "packageVersion";
    private static final String PARAM_Q = "q";
    private static final String PARAM_RECIPEREVISION = "recipeRevision";
    private static final PathTemplate CALL_PROJECT_V1_USERS_AUTHENTICATE =
            PathTemplate.of("/projects/{id}/packages/conan/v1/users/authenticate");
    private static final PathTemplate CALL_PROJECT_V1_USERS_CHECK_CREDENTIALS =
            PathTemplate.of("/projects/{id}/packages/conan/v1/users/check_credentials");
    private static final PathTemplate CALL_PROJECT_V1_CONANS_SEARCH =
            PathTemplate.of("/projects/{id}/packages/conan/v1/conans/search");
    private static final PathTemplate CALL_PROJECT_V1_CONANS_SEARCH_BY_PACKAGE = PathTemplate.of(
            "/projects/{id}/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/search");
    private static final PathTemplate CALL_PROJECT_V1_PING = PathTemplate.of("/projects/{id}/packages/conan/v1/ping");
    private static final PathTemplate GET_PROJECT_V1_CONANS_PACKAGE = PathTemplate.of(
            "/projects/{id}/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/packages/{conan_package_reference}");
    private static final PathTemplate GET_PROJECT_V1_CONAN = PathTemplate.of(
            "/projects/{id}/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}");
    private static final PathTemplate GET_PROJECT_V1_CONANS_PACKAGES_DIGEST = PathTemplate.of(
            "/projects/{id}/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/packages/{conan_package_reference}/digest");
    private static final PathTemplate GET_PROJECT_V1_CONANS_DIGEST = PathTemplate.of(
            "/projects/{id}/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/digest");
    private static final PathTemplate GET_PROJECT_V1_CONANS_PACKAGES_DOWNLOAD = PathTemplate.of(
            "/projects/{id}/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/packages/{conan_package_reference}/download_urls");
    private static final PathTemplate GET_PROJECT_V1_CONANS_DOWNLOAD_URLS = PathTemplate.of(
            "/projects/{id}/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/download_urls");
    private static final PathTemplate CREATE_PROJECT_V1_CONANS_PACKAGES_UPLOAD = PathTemplate.of(
            "/projects/{id}/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/packages/{conan_package_reference}/upload_urls");
    private static final PathTemplate CREATE_PROJECT_V1_CONANS_UPLOAD_URL = PathTemplate.of(
            "/projects/{id}/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/upload_urls");
    private static final PathTemplate CALL_PROJECT_V1_FILES_EXPORT = PathTemplate.of(
            "/projects/{id}/packages/conan/v1/files/{package_name}/{package_version}/{package_username}/{package_channel}/{recipe_revision}/export/{file_name}");
    private static final PathTemplate AUTHORIZE_PROJECT_V1_FILES_EXPORT = PathTemplate.of(
            "/projects/{id}/packages/conan/v1/files/{package_name}/{package_version}/{package_username}/{package_channel}/{recipe_revision}/export/{file_name}/authorize");
    private static final PathTemplate CALL_PROJECT_V1_FILES_PACKAGE = PathTemplate.of(
            "/projects/{id}/packages/conan/v1/files/{package_name}/{package_version}/{package_username}/{package_channel}/{recipe_revision}/package/{conan_package_reference}/{package_revision}/{file_name}");
    private static final PathTemplate AUTHORIZE_PROJECT_V1_FILES_PACKAGE = PathTemplate.of(
            "/projects/{id}/packages/conan/v1/files/{package_name}/{package_version}/{package_username}/{package_channel}/{recipe_revision}/package/{conan_package_reference}/{package_revision}/{file_name}/authorize");
    private static final PathTemplate CALL_V1_USERS_AUTHENTICATE =
            PathTemplate.of("/packages/conan/v1/users/authenticate");
    private static final PathTemplate CALL_V1_USERS_CHECK_CREDENTIALS =
            PathTemplate.of("/packages/conan/v1/users/check_credentials");
    private static final PathTemplate CALL_V1_CONANS_SEARCH = PathTemplate.of("/packages/conan/v1/conans/search");
    private static final PathTemplate CALL_V1_CONANS_SEARCH_BY_PACKAGE_NAME_AN = PathTemplate.of(
            "/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/search");
    private static final PathTemplate CALL_V1_PING = PathTemplate.of("/packages/conan/v1/ping");
    private static final PathTemplate GET_V1_CONANS_PACKAGE = PathTemplate.of(
            "/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/packages/{conan_package_reference}");
    private static final PathTemplate GET_V1_CONAN = PathTemplate.of(
            "/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}");
    private static final PathTemplate GET_V1_CONANS_PACKAGES_DIGEST = PathTemplate.of(
            "/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/packages/{conan_package_reference}/digest");
    private static final PathTemplate GET_V1_CONANS_DIGEST = PathTemplate.of(
            "/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/digest");
    private static final PathTemplate GET_V1_CONANS_PACKAGES_DOWNLOAD_URLS = PathTemplate.of(
            "/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/packages/{conan_package_reference}/download_urls");
    private static final PathTemplate GET_V1_CONANS_DOWNLOAD_URLS = PathTemplate.of(
            "/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/download_urls");
    private static final PathTemplate CREATE_V1_CONANS_PACKAGES_UPLOAD_URL = PathTemplate.of(
            "/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/packages/{conan_package_reference}/upload_urls");
    private static final PathTemplate CREATE_V1_CONANS_UPLOAD_URL = PathTemplate.of(
            "/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/upload_urls");
    private static final PathTemplate CALL_V1_FILES_EXPORT = PathTemplate.of(
            "/packages/conan/v1/files/{package_name}/{package_version}/{package_username}/{package_channel}/{recipe_revision}/export/{file_name}");
    private static final PathTemplate AUTHORIZE_V1_FILES_EXPORT = PathTemplate.of(
            "/packages/conan/v1/files/{package_name}/{package_version}/{package_username}/{package_channel}/{recipe_revision}/export/{file_name}/authorize");
    private static final PathTemplate CALL_V1_FILES_PACKAGE = PathTemplate.of(
            "/packages/conan/v1/files/{package_name}/{package_version}/{package_username}/{package_channel}/{recipe_revision}/package/{conan_package_reference}/{package_revision}/{file_name}");
    private static final PathTemplate AUTHORIZE_V1_FILES_PACKAGE = PathTemplate.of(
            "/packages/conan/v1/files/{package_name}/{package_version}/{package_username}/{package_channel}/{recipe_revision}/package/{conan_package_reference}/{package_revision}/{file_name}/authorize");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectConanV1DistributionsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Call project v1 users authenticate ({@code GET /projects/{id}/packages/conan/v1/users/authenticate}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callProjectV1UsersAuthenticate(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(get(CALL_PROJECT_V1_USERS_AUTHENTICATE, id));
    }

    /**
     * Call project v1 users check credentials ({@code GET /projects/{id}/packages/conan/v1/users/check_credentials}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callProjectV1UsersCheckCredentials(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(get(CALL_PROJECT_V1_USERS_CHECK_CREDENTIALS, id));
    }

    /**
     * Call project v1 conans search ({@code GET /projects/{id}/packages/conan/v1/conans/search}).
     *
     * @param id the id
     * @param q the q
     * @throws IllegalArgumentException if {@code id} or {@code q} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callProjectV1ConansSearch(final String id, final String q) throws IOException {
        callProjectV1ConansSearch(id, q, GitLabProjectConanV1DistributionsCallProjectV1ConansSearchFilter.empty());
    }

    /**
     * Call project v1 conans search ({@code GET /projects/{id}/packages/conan/v1/conans/search}).
     *
     * @param id the id
     * @param q the q
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id} or {@code q} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callProjectV1ConansSearch(
            final String id,
            final String q,
            final GitLabProjectConanV1DistributionsCallProjectV1ConansSearchFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(q, PARAM_Q);
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .all(filter.toQueryParameters())
                .text(PARAM_Q, q)
                .build();
        caller.send(get(CALL_PROJECT_V1_CONANS_SEARCH, id).withQuery(queryParameters));
    }

    /**
     * Call project v1 conans search by package name and package version and package username and package channel
     * ({@code GET
     * /projects/{id}/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/search}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion},
     *     {@code packageUsername} or {@code packageChannel} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callProjectV1ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        caller.send(get(
                CALL_PROJECT_V1_CONANS_SEARCH_BY_PACKAGE,
                id,
                packageName,
                packageVersion,
                packageUsername,
                packageChannel));
    }

    /**
     * Call project v1 ping ({@code GET /projects/{id}/packages/conan/v1/ping}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callProjectV1Ping(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(get(CALL_PROJECT_V1_PING, id));
    }

    /**
     * Get project v1 conans package ({@code GET
     * /projects/{id}/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/packages/{conan_package_reference}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param conanPackageReference the conan package reference
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion},
     *     {@code packageUsername}, {@code packageChannel} or {@code conanPackageReference} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabPackageConanPackageSnapshot> getProjectV1ConansPackage(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String conanPackageReference)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(conanPackageReference, PARAM_CONANPACKAGEREFERENCE);
        return caller.fetchOrEmpty(
                get(
                        GET_PROJECT_V1_CONANS_PACKAGE,
                        id,
                        packageName,
                        packageVersion,
                        packageUsername,
                        packageChannel,
                        conanPackageReference),
                GitLabPackageConanPackageSnapshot.class);
    }

    /**
     * Get project v1 conan ({@code GET
     * /projects/{id}/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion},
     *     {@code packageUsername} or {@code packageChannel} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabPackageConanRecipeSnapshot> getProjectV1Conan(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        return caller.fetchOrEmpty(
                get(GET_PROJECT_V1_CONAN, id, packageName, packageVersion, packageUsername, packageChannel),
                GitLabPackageConanRecipeSnapshot.class);
    }

    /**
     * Delete project v1 conan ({@code DELETE
     * /projects/{id}/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion},
     *     {@code packageUsername} or {@code packageChannel} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteProjectV1Conan(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        caller.send(delete(GET_PROJECT_V1_CONAN, id, packageName, packageVersion, packageUsername, packageChannel));
    }

    /**
     * Get project v1 conans packages digest ({@code GET
     * /projects/{id}/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/packages/{conan_package_reference}/digest}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param conanPackageReference the conan package reference
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion},
     *     {@code packageUsername}, {@code packageChannel} or {@code conanPackageReference} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabPackageConanPackageManifest> getProjectV1ConansPackagesDigest(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String conanPackageReference)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(conanPackageReference, PARAM_CONANPACKAGEREFERENCE);
        return caller.fetchOrEmpty(
                get(
                        GET_PROJECT_V1_CONANS_PACKAGES_DIGEST,
                        id,
                        packageName,
                        packageVersion,
                        packageUsername,
                        packageChannel,
                        conanPackageReference),
                GitLabPackageConanPackageManifest.class);
    }

    /**
     * Get project v1 conans digest ({@code GET
     * /projects/{id}/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/digest}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion},
     *     {@code packageUsername} or {@code packageChannel} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabPackageConanRecipeManifest> getProjectV1ConansDigest(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        return caller.fetchOrEmpty(
                get(GET_PROJECT_V1_CONANS_DIGEST, id, packageName, packageVersion, packageUsername, packageChannel),
                GitLabPackageConanRecipeManifest.class);
    }

    /**
     * Get project v1 conans packages download urls ({@code GET
     * /projects/{id}/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/packages/{conan_package_reference}/download_urls}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param conanPackageReference the conan package reference
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion},
     *     {@code packageUsername}, {@code packageChannel} or {@code conanPackageReference} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabPackageConanPackageManifest> getProjectV1ConansPackagesDownloadUrls(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String conanPackageReference)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(conanPackageReference, PARAM_CONANPACKAGEREFERENCE);
        return caller.fetchOrEmpty(
                get(
                        GET_PROJECT_V1_CONANS_PACKAGES_DOWNLOAD,
                        id,
                        packageName,
                        packageVersion,
                        packageUsername,
                        packageChannel,
                        conanPackageReference),
                GitLabPackageConanPackageManifest.class);
    }

    /**
     * Get project v1 conans download urls ({@code GET
     * /projects/{id}/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/download_urls}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion},
     *     {@code packageUsername} or {@code packageChannel} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabPackageConanRecipeManifest> getProjectV1ConansDownloadUrls(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        return caller.fetchOrEmpty(
                get(
                        GET_PROJECT_V1_CONANS_DOWNLOAD_URLS,
                        id,
                        packageName,
                        packageVersion,
                        packageUsername,
                        packageChannel),
                GitLabPackageConanRecipeManifest.class);
    }

    /**
     * Create project v1 conans packages upload url ({@code POST
     * /projects/{id}/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/packages/{conan_package_reference}/upload_urls}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param conanPackageReference the conan package reference
     * @return the resource
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion},
     *     {@code packageUsername}, {@code packageChannel} or {@code conanPackageReference} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPackageConanUploadUrls createProjectV1ConansPackagesUploadUrl(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String conanPackageReference)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(conanPackageReference, PARAM_CONANPACKAGEREFERENCE);
        return caller.fetch(
                post(
                        CREATE_PROJECT_V1_CONANS_PACKAGES_UPLOAD,
                        id,
                        packageName,
                        packageVersion,
                        packageUsername,
                        packageChannel,
                        conanPackageReference),
                GitLabPackageConanUploadUrls.class);
    }

    /**
     * Create project v1 conans upload url ({@code POST
     * /projects/{id}/packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/upload_urls}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @return the resource
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion},
     *     {@code packageUsername} or {@code packageChannel} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPackageConanUploadUrls createProjectV1ConansUploadUrl(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        return caller.fetch(
                post(
                        CREATE_PROJECT_V1_CONANS_UPLOAD_URL,
                        id,
                        packageName,
                        packageVersion,
                        packageUsername,
                        packageChannel),
                GitLabPackageConanUploadUrls.class);
    }

    /**
     * Call project v1 files export ({@code GET
     * /projects/{id}/packages/conan/v1/files/{package_name}/{package_version}/{package_username}/{package_channel}/{recipe_revision}/export/{file_name}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param recipeRevision the recipe revision
     * @param fileName the file name
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion},
     *     {@code packageUsername}, {@code packageChannel} or {@code recipeRevision} is blank
     * @throws NullPointerException if {@code fileName} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callProjectV1FilesExport(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String recipeRevision,
            final GitLabProjectConanV1DistributionsCallProjectV1FilesExportFileName fileName)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(recipeRevision, PARAM_RECIPEREVISION);
        requireNonNull(fileName, PARAM_FILENAME);
        caller.send(get(
                CALL_PROJECT_V1_FILES_EXPORT,
                id,
                packageName,
                packageVersion,
                packageUsername,
                packageChannel,
                recipeRevision,
                fileName.wireValue()));
    }

    /**
     * Update project v1 files export ({@code PUT
     * /projects/{id}/packages/conan/v1/files/{package_name}/{package_version}/{package_username}/{package_channel}/{recipe_revision}/export/{file_name}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param recipeRevision the recipe revision
     * @param fileName the file name
     * @param form the form to send
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion},
     *     {@code packageUsername}, {@code packageChannel} or {@code recipeRevision} is blank
     * @throws NullPointerException if {@code fileName} or {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void updateProjectV1FilesExport(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String recipeRevision,
            final GitLabProjectConanV1DistributionsUpdateProjectV1FilesExportFileName fileName,
            final MultipartFormData form)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(recipeRevision, PARAM_RECIPEREVISION);
        requireNonNull(fileName, PARAM_FILENAME);
        requireNonNull(form, PARAM_FORM);
        caller.send(caller.multipart(
                put(
                        CALL_PROJECT_V1_FILES_EXPORT,
                        id,
                        packageName,
                        packageVersion,
                        packageUsername,
                        packageChannel,
                        recipeRevision,
                        fileName.wireValue()),
                form));
    }

    /**
     * Authorize project v1 files export ({@code PUT
     * /projects/{id}/packages/conan/v1/files/{package_name}/{package_version}/{package_username}/{package_channel}/{recipe_revision}/export/{file_name}/authorize}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param recipeRevision the recipe revision
     * @param fileName the file name
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion},
     *     {@code packageUsername}, {@code packageChannel} or {@code recipeRevision} is blank
     * @throws NullPointerException if {@code fileName} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void authorizeProjectV1FilesExport(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String recipeRevision,
            final GitLabProjectConanV1DistributionsAuthorizeProjectV1FilesExportFileName fileName)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(recipeRevision, PARAM_RECIPEREVISION);
        requireNonNull(fileName, PARAM_FILENAME);
        caller.send(put(
                AUTHORIZE_PROJECT_V1_FILES_EXPORT,
                id,
                packageName,
                packageVersion,
                packageUsername,
                packageChannel,
                recipeRevision,
                fileName.wireValue()));
    }

    /**
     * Call project v1 files package ({@code GET
     * /projects/{id}/packages/conan/v1/files/{package_name}/{package_version}/{package_username}/{package_channel}/{recipe_revision}/package/{conan_package_reference}/{package_revision}/{file_name}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param recipeRevision the recipe revision
     * @param conanPackageReference the conan package reference
     * @param packageRevision the package revision
     * @param fileName the file name
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion},
     *     {@code packageUsername}, {@code packageChannel}, {@code recipeRevision}, {@code conanPackageReference} or
     *     {@code packageRevision} is blank
     * @throws NullPointerException if {@code fileName} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callProjectV1FilesPackage(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String recipeRevision,
            final String conanPackageReference,
            final String packageRevision,
            final GitLabProjectConanV1DistributionsCallProjectV1FilesPackageFileName fileName)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(recipeRevision, PARAM_RECIPEREVISION);
        requireNotBlank(conanPackageReference, PARAM_CONANPACKAGEREFERENCE);
        requireNotBlank(packageRevision, PARAM_PACKAGEREVISION);
        requireNonNull(fileName, PARAM_FILENAME);
        caller.send(get(
                CALL_PROJECT_V1_FILES_PACKAGE,
                id,
                packageName,
                packageVersion,
                packageUsername,
                packageChannel,
                recipeRevision,
                conanPackageReference,
                packageRevision,
                fileName.wireValue()));
    }

    /**
     * Update project v1 files package ({@code PUT
     * /projects/{id}/packages/conan/v1/files/{package_name}/{package_version}/{package_username}/{package_channel}/{recipe_revision}/package/{conan_package_reference}/{package_revision}/{file_name}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param recipeRevision the recipe revision
     * @param conanPackageReference the conan package reference
     * @param packageRevision the package revision
     * @param fileName the file name
     * @param form the form to send
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion},
     *     {@code packageUsername}, {@code packageChannel}, {@code recipeRevision}, {@code conanPackageReference} or
     *     {@code packageRevision} is blank
     * @throws NullPointerException if {@code fileName} or {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void updateProjectV1FilesPackage(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String recipeRevision,
            final String conanPackageReference,
            final String packageRevision,
            final GitLabProjectConanV1DistributionsUpdateProjectV1FilesPackageFileName fileName,
            final MultipartFormData form)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(recipeRevision, PARAM_RECIPEREVISION);
        requireNotBlank(conanPackageReference, PARAM_CONANPACKAGEREFERENCE);
        requireNotBlank(packageRevision, PARAM_PACKAGEREVISION);
        requireNonNull(fileName, PARAM_FILENAME);
        requireNonNull(form, PARAM_FORM);
        caller.send(caller.multipart(
                put(
                        CALL_PROJECT_V1_FILES_PACKAGE,
                        id,
                        packageName,
                        packageVersion,
                        packageUsername,
                        packageChannel,
                        recipeRevision,
                        conanPackageReference,
                        packageRevision,
                        fileName.wireValue()),
                form));
    }

    /**
     * Authorize project v1 files package ({@code PUT
     * /projects/{id}/packages/conan/v1/files/{package_name}/{package_version}/{package_username}/{package_channel}/{recipe_revision}/package/{conan_package_reference}/{package_revision}/{file_name}/authorize}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param recipeRevision the recipe revision
     * @param conanPackageReference the conan package reference
     * @param packageRevision the package revision
     * @param fileName the file name
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion},
     *     {@code packageUsername}, {@code packageChannel}, {@code recipeRevision}, {@code conanPackageReference} or
     *     {@code packageRevision} is blank
     * @throws NullPointerException if {@code fileName} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void authorizeProjectV1FilesPackage(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String recipeRevision,
            final String conanPackageReference,
            final String packageRevision,
            final GitLabProjectConanV1DistributionsAuthorizeProjectV1FilesPackageFileName fileName)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(recipeRevision, PARAM_RECIPEREVISION);
        requireNotBlank(conanPackageReference, PARAM_CONANPACKAGEREFERENCE);
        requireNotBlank(packageRevision, PARAM_PACKAGEREVISION);
        requireNonNull(fileName, PARAM_FILENAME);
        caller.send(put(
                AUTHORIZE_PROJECT_V1_FILES_PACKAGE,
                id,
                packageName,
                packageVersion,
                packageUsername,
                packageChannel,
                recipeRevision,
                conanPackageReference,
                packageRevision,
                fileName.wireValue()));
    }

    /**
     * Call v1 users authenticate ({@code GET /packages/conan/v1/users/authenticate}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callV1UsersAuthenticate() throws IOException {
        caller.send(get(CALL_V1_USERS_AUTHENTICATE));
    }

    /**
     * Call v1 users check credentials ({@code GET /packages/conan/v1/users/check_credentials}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callV1UsersCheckCredentials() throws IOException {
        caller.send(get(CALL_V1_USERS_CHECK_CREDENTIALS));
    }

    /**
     * Call v1 conans search ({@code GET /packages/conan/v1/conans/search}).
     *
     * @param q the q
     * @throws IllegalArgumentException if {@code q} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callV1ConansSearch(final String q) throws IOException {
        callV1ConansSearch(q, GitLabProjectConanV1DistributionsCallV1ConansSearchFilter.empty());
    }

    /**
     * Call v1 conans search ({@code GET /packages/conan/v1/conans/search}).
     *
     * @param q the q
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code q} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callV1ConansSearch(
            final String q, final GitLabProjectConanV1DistributionsCallV1ConansSearchFilter filter) throws IOException {
        requireNotBlank(q, PARAM_Q);
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .all(filter.toQueryParameters())
                .text(PARAM_Q, q)
                .build();
        caller.send(get(CALL_V1_CONANS_SEARCH).withQuery(queryParameters));
    }

    /**
     * Call v1 conans search by package name and package version and package username and package channel ({@code GET
     * /packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/search}).
     *
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @throws IllegalArgumentException if {@code packageName}, {@code packageVersion}, {@code packageUsername} or
     *     {@code packageChannel} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callV1ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel(
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel)
            throws IOException {
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        caller.send(get(
                CALL_V1_CONANS_SEARCH_BY_PACKAGE_NAME_AN,
                packageName,
                packageVersion,
                packageUsername,
                packageChannel));
    }

    /**
     * Call v1 ping ({@code GET /packages/conan/v1/ping}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callV1Ping() throws IOException {
        caller.send(get(CALL_V1_PING));
    }

    /**
     * Get v1 conans package ({@code GET
     * /packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/packages/{conan_package_reference}}).
     *
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param conanPackageReference the conan package reference
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code packageName}, {@code packageVersion}, {@code packageUsername},
     *     {@code packageChannel} or {@code conanPackageReference} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabPackageConanPackageSnapshot> getV1ConansPackage(
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String conanPackageReference)
            throws IOException {
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(conanPackageReference, PARAM_CONANPACKAGEREFERENCE);
        return caller.fetchOrEmpty(
                get(
                        GET_V1_CONANS_PACKAGE,
                        packageName,
                        packageVersion,
                        packageUsername,
                        packageChannel,
                        conanPackageReference),
                GitLabPackageConanPackageSnapshot.class);
    }

    /**
     * Get v1 conan ({@code GET
     * /packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}}).
     *
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code packageName}, {@code packageVersion}, {@code packageUsername} or
     *     {@code packageChannel} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabPackageConanRecipeSnapshot> getV1Conan(
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel)
            throws IOException {
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        return caller.fetchOrEmpty(
                get(GET_V1_CONAN, packageName, packageVersion, packageUsername, packageChannel),
                GitLabPackageConanRecipeSnapshot.class);
    }

    /**
     * Delete v1 conan ({@code DELETE
     * /packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}}).
     *
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @throws IllegalArgumentException if {@code packageName}, {@code packageVersion}, {@code packageUsername} or
     *     {@code packageChannel} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteV1Conan(
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel)
            throws IOException {
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        caller.send(delete(GET_V1_CONAN, packageName, packageVersion, packageUsername, packageChannel));
    }

    /**
     * Get v1 conans packages digest ({@code GET
     * /packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/packages/{conan_package_reference}/digest}).
     *
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param conanPackageReference the conan package reference
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code packageName}, {@code packageVersion}, {@code packageUsername},
     *     {@code packageChannel} or {@code conanPackageReference} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabPackageConanPackageManifest> getV1ConansPackagesDigest(
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String conanPackageReference)
            throws IOException {
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(conanPackageReference, PARAM_CONANPACKAGEREFERENCE);
        return caller.fetchOrEmpty(
                get(
                        GET_V1_CONANS_PACKAGES_DIGEST,
                        packageName,
                        packageVersion,
                        packageUsername,
                        packageChannel,
                        conanPackageReference),
                GitLabPackageConanPackageManifest.class);
    }

    /**
     * Get v1 conans digest ({@code GET
     * /packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/digest}).
     *
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code packageName}, {@code packageVersion}, {@code packageUsername} or
     *     {@code packageChannel} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabPackageConanRecipeManifest> getV1ConansDigest(
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel)
            throws IOException {
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        return caller.fetchOrEmpty(
                get(GET_V1_CONANS_DIGEST, packageName, packageVersion, packageUsername, packageChannel),
                GitLabPackageConanRecipeManifest.class);
    }

    /**
     * Get v1 conans packages download urls ({@code GET
     * /packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/packages/{conan_package_reference}/download_urls}).
     *
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param conanPackageReference the conan package reference
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code packageName}, {@code packageVersion}, {@code packageUsername},
     *     {@code packageChannel} or {@code conanPackageReference} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabPackageConanPackageManifest> getV1ConansPackagesDownloadUrls(
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String conanPackageReference)
            throws IOException {
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(conanPackageReference, PARAM_CONANPACKAGEREFERENCE);
        return caller.fetchOrEmpty(
                get(
                        GET_V1_CONANS_PACKAGES_DOWNLOAD_URLS,
                        packageName,
                        packageVersion,
                        packageUsername,
                        packageChannel,
                        conanPackageReference),
                GitLabPackageConanPackageManifest.class);
    }

    /**
     * Get v1 conans download urls ({@code GET
     * /packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/download_urls}).
     *
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code packageName}, {@code packageVersion}, {@code packageUsername} or
     *     {@code packageChannel} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabPackageConanRecipeManifest> getV1ConansDownloadUrls(
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel)
            throws IOException {
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        return caller.fetchOrEmpty(
                get(GET_V1_CONANS_DOWNLOAD_URLS, packageName, packageVersion, packageUsername, packageChannel),
                GitLabPackageConanRecipeManifest.class);
    }

    /**
     * Create v1 conans packages upload url ({@code POST
     * /packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/packages/{conan_package_reference}/upload_urls}).
     *
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param conanPackageReference the conan package reference
     * @return the resource
     * @throws IllegalArgumentException if {@code packageName}, {@code packageVersion}, {@code packageUsername},
     *     {@code packageChannel} or {@code conanPackageReference} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPackageConanUploadUrls createV1ConansPackagesUploadUrl(
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String conanPackageReference)
            throws IOException {
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(conanPackageReference, PARAM_CONANPACKAGEREFERENCE);
        return caller.fetch(
                post(
                        CREATE_V1_CONANS_PACKAGES_UPLOAD_URL,
                        packageName,
                        packageVersion,
                        packageUsername,
                        packageChannel,
                        conanPackageReference),
                GitLabPackageConanUploadUrls.class);
    }

    /**
     * Create v1 conans upload url ({@code POST
     * /packages/conan/v1/conans/{package_name}/{package_version}/{package_username}/{package_channel}/upload_urls}).
     *
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @return the resource
     * @throws IllegalArgumentException if {@code packageName}, {@code packageVersion}, {@code packageUsername} or
     *     {@code packageChannel} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPackageConanUploadUrls createV1ConansUploadUrl(
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel)
            throws IOException {
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        return caller.fetch(
                post(CREATE_V1_CONANS_UPLOAD_URL, packageName, packageVersion, packageUsername, packageChannel),
                GitLabPackageConanUploadUrls.class);
    }

    /**
     * Call v1 files export ({@code GET
     * /packages/conan/v1/files/{package_name}/{package_version}/{package_username}/{package_channel}/{recipe_revision}/export/{file_name}}).
     *
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param recipeRevision the recipe revision
     * @param fileName the file name
     * @throws IllegalArgumentException if {@code packageName}, {@code packageVersion}, {@code packageUsername},
     *     {@code packageChannel} or {@code recipeRevision} is blank
     * @throws NullPointerException if {@code fileName} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callV1FilesExport(
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String recipeRevision,
            final GitLabProjectConanV1DistributionsCallV1FilesExportFileName fileName)
            throws IOException {
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(recipeRevision, PARAM_RECIPEREVISION);
        requireNonNull(fileName, PARAM_FILENAME);
        caller.send(get(
                CALL_V1_FILES_EXPORT,
                packageName,
                packageVersion,
                packageUsername,
                packageChannel,
                recipeRevision,
                fileName.wireValue()));
    }

    /**
     * Update v1 files export ({@code PUT
     * /packages/conan/v1/files/{package_name}/{package_version}/{package_username}/{package_channel}/{recipe_revision}/export/{file_name}}).
     *
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param recipeRevision the recipe revision
     * @param fileName the file name
     * @param form the form to send
     * @throws IllegalArgumentException if {@code packageName}, {@code packageVersion}, {@code packageUsername},
     *     {@code packageChannel} or {@code recipeRevision} is blank
     * @throws NullPointerException if {@code fileName} or {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void updateV1FilesExport(
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String recipeRevision,
            final GitLabProjectConanV1DistributionsUpdateV1FilesExportFileName fileName,
            final MultipartFormData form)
            throws IOException {
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(recipeRevision, PARAM_RECIPEREVISION);
        requireNonNull(fileName, PARAM_FILENAME);
        requireNonNull(form, PARAM_FORM);
        caller.send(caller.multipart(
                put(
                        CALL_V1_FILES_EXPORT,
                        packageName,
                        packageVersion,
                        packageUsername,
                        packageChannel,
                        recipeRevision,
                        fileName.wireValue()),
                form));
    }

    /**
     * Authorize v1 files export ({@code PUT
     * /packages/conan/v1/files/{package_name}/{package_version}/{package_username}/{package_channel}/{recipe_revision}/export/{file_name}/authorize}).
     *
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param recipeRevision the recipe revision
     * @param fileName the file name
     * @throws IllegalArgumentException if {@code packageName}, {@code packageVersion}, {@code packageUsername},
     *     {@code packageChannel} or {@code recipeRevision} is blank
     * @throws NullPointerException if {@code fileName} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void authorizeV1FilesExport(
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String recipeRevision,
            final GitLabProjectConanV1DistributionsAuthorizeV1FilesExportFileName fileName)
            throws IOException {
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(recipeRevision, PARAM_RECIPEREVISION);
        requireNonNull(fileName, PARAM_FILENAME);
        caller.send(put(
                AUTHORIZE_V1_FILES_EXPORT,
                packageName,
                packageVersion,
                packageUsername,
                packageChannel,
                recipeRevision,
                fileName.wireValue()));
    }

    /**
     * Call v1 files package ({@code GET
     * /packages/conan/v1/files/{package_name}/{package_version}/{package_username}/{package_channel}/{recipe_revision}/package/{conan_package_reference}/{package_revision}/{file_name}}).
     *
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param recipeRevision the recipe revision
     * @param conanPackageReference the conan package reference
     * @param packageRevision the package revision
     * @param fileName the file name
     * @throws IllegalArgumentException if {@code packageName}, {@code packageVersion}, {@code packageUsername},
     *     {@code packageChannel}, {@code recipeRevision}, {@code conanPackageReference} or {@code packageRevision} is
     *     blank
     * @throws NullPointerException if {@code fileName} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callV1FilesPackage(
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String recipeRevision,
            final String conanPackageReference,
            final String packageRevision,
            final GitLabProjectConanV1DistributionsCallV1FilesPackageFileName fileName)
            throws IOException {
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(recipeRevision, PARAM_RECIPEREVISION);
        requireNotBlank(conanPackageReference, PARAM_CONANPACKAGEREFERENCE);
        requireNotBlank(packageRevision, PARAM_PACKAGEREVISION);
        requireNonNull(fileName, PARAM_FILENAME);
        caller.send(get(
                CALL_V1_FILES_PACKAGE,
                packageName,
                packageVersion,
                packageUsername,
                packageChannel,
                recipeRevision,
                conanPackageReference,
                packageRevision,
                fileName.wireValue()));
    }

    /**
     * Update v1 files package ({@code PUT
     * /packages/conan/v1/files/{package_name}/{package_version}/{package_username}/{package_channel}/{recipe_revision}/package/{conan_package_reference}/{package_revision}/{file_name}}).
     *
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param recipeRevision the recipe revision
     * @param conanPackageReference the conan package reference
     * @param packageRevision the package revision
     * @param fileName the file name
     * @param form the form to send
     * @throws IllegalArgumentException if {@code packageName}, {@code packageVersion}, {@code packageUsername},
     *     {@code packageChannel}, {@code recipeRevision}, {@code conanPackageReference} or {@code packageRevision} is
     *     blank
     * @throws NullPointerException if {@code fileName} or {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void updateV1FilesPackage(
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String recipeRevision,
            final String conanPackageReference,
            final String packageRevision,
            final GitLabProjectConanV1DistributionsUpdateV1FilesPackageFileName fileName,
            final MultipartFormData form)
            throws IOException {
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(recipeRevision, PARAM_RECIPEREVISION);
        requireNotBlank(conanPackageReference, PARAM_CONANPACKAGEREFERENCE);
        requireNotBlank(packageRevision, PARAM_PACKAGEREVISION);
        requireNonNull(fileName, PARAM_FILENAME);
        requireNonNull(form, PARAM_FORM);
        caller.send(caller.multipart(
                put(
                        CALL_V1_FILES_PACKAGE,
                        packageName,
                        packageVersion,
                        packageUsername,
                        packageChannel,
                        recipeRevision,
                        conanPackageReference,
                        packageRevision,
                        fileName.wireValue()),
                form));
    }

    /**
     * Authorize v1 files package ({@code PUT
     * /packages/conan/v1/files/{package_name}/{package_version}/{package_username}/{package_channel}/{recipe_revision}/package/{conan_package_reference}/{package_revision}/{file_name}/authorize}).
     *
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param recipeRevision the recipe revision
     * @param conanPackageReference the conan package reference
     * @param packageRevision the package revision
     * @param fileName the file name
     * @throws IllegalArgumentException if {@code packageName}, {@code packageVersion}, {@code packageUsername},
     *     {@code packageChannel}, {@code recipeRevision}, {@code conanPackageReference} or {@code packageRevision} is
     *     blank
     * @throws NullPointerException if {@code fileName} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void authorizeV1FilesPackage(
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String recipeRevision,
            final String conanPackageReference,
            final String packageRevision,
            final GitLabProjectConanV1DistributionsAuthorizeV1FilesPackageFileName fileName)
            throws IOException {
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(recipeRevision, PARAM_RECIPEREVISION);
        requireNotBlank(conanPackageReference, PARAM_CONANPACKAGEREFERENCE);
        requireNotBlank(packageRevision, PARAM_PACKAGEREVISION);
        requireNonNull(fileName, PARAM_FILENAME);
        caller.send(put(
                AUTHORIZE_V1_FILES_PACKAGE,
                packageName,
                packageVersion,
                packageUsername,
                packageChannel,
                recipeRevision,
                conanPackageReference,
                packageRevision,
                fileName.wireValue()));
    }
}

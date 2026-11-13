package io.github.piotr_janczukowicz.gitlab.api.conanv2distributions;

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

/** The GitLab operations of project conan v2 distributions. */
public final class GitLabProjectConanV2DistributionsApi extends GitLabResourceApi {
    private static final String PARAM_CONANPACKAGEREFERENCE = "conanPackageReference";
    private static final String PARAM_FILENAME = "fileName";
    private static final String PARAM_ID = "id";
    private static final String PARAM_PACKAGECHANNEL = "packageChannel";
    private static final String PARAM_PACKAGENAME = "packageName";
    private static final String PARAM_PACKAGEREVISION = "packageRevision";
    private static final String PARAM_PACKAGEUSERNAME = "packageUsername";
    private static final String PARAM_PACKAGEVERSION = "packageVersion";
    private static final String PARAM_RECIPEREVISION = "recipeRevision";
    private static final PathTemplate CALL_V2_USERS_AUTHENTICATE =
            PathTemplate.of("/projects/{id}/packages/conan/v2/users/authenticate");
    private static final PathTemplate CALL_V2_USERS_CHECK_CREDENTIALS =
            PathTemplate.of("/projects/{id}/packages/conan/v2/users/check_credentials");
    private static final PathTemplate CALL_V2_CONANS_SEARCH =
            PathTemplate.of("/projects/{id}/packages/conan/v2/conans/search");
    private static final PathTemplate CALL_V2_CONANS_SEARCH_BY_PACKAGE_NAME_AN = PathTemplate.of(
            "/projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/search");
    private static final PathTemplate GET_V2_CONANS_LATEST = PathTemplate.of(
            "/projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/latest");
    private static final PathTemplate GET_V2_CONANS_REVISIONS = PathTemplate.of(
            "/projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/revisions");
    private static final PathTemplate DELETE_V2_CONANS_REVISION = PathTemplate.of(
            "/projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/revisions/{recipe_revision}");
    private static final PathTemplate GET_V2_CONANS_REVISIONS_FILES = PathTemplate.of(
            "/projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/revisions/{recipe_revision}/files");
    private static final PathTemplate CALL_V2_CONANS_REVISIONS_FILE = PathTemplate.of(
            "/projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/revisions/{recipe_revision}/files/{file_name}");
    private static final PathTemplate AUTHORIZE_V2_CONANS_REVISIONS_FILE = PathTemplate.of(
            "/projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/revisions/{recipe_revision}/files/{file_name}/authorize");
    private static final PathTemplate CALL_V2_CONANS_REVISIONS_SEARCH = PathTemplate.of(
            "/projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/revisions/{recipe_revision}/search");
    private static final PathTemplate GET_V2_CONANS_REVISIONS_PACKAGES_LATEST = PathTemplate.of(
            "/projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/revisions/{recipe_revision}/packages/{conan_package_reference}/latest");
    private static final PathTemplate GET_V2_CONANS_REVISIONS_PACKAGES_REVISIO = PathTemplate.of(
            "/projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/revisions/{recipe_revision}/packages/{conan_package_reference}/revisions");
    private static final PathTemplate DELETE_V2_CONANS_REVISIONS_PACKAGES_REVI = PathTemplate.of(
            "/projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/revisions/{recipe_revision}/packages/{conan_package_reference}/revisions/{package_revision}");
    private static final PathTemplate GET_V2_CONANS_REVISIONS_PACKAGES_REVIS_2 = PathTemplate.of(
            "/projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/revisions/{recipe_revision}/packages/{conan_package_reference}/revisions/{package_revision}/files");
    private static final PathTemplate CALL_V2_CONANS_REVISIONS_PACKAGES_REVISI = PathTemplate.of(
            "/projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/revisions/{recipe_revision}/packages/{conan_package_reference}/revisions/{package_revision}/files/{file_name}");
    private static final PathTemplate AUTHORIZE_V2_CONANS_REVISIONS_PACKAGES_R = PathTemplate.of(
            "/projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/revisions/{recipe_revision}/packages/{conan_package_reference}/revisions/{package_revision}/files/{file_name}/authorize");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectConanV2DistributionsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Call v2 users authenticate ({@code GET /projects/{id}/packages/conan/v2/users/authenticate}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callV2UsersAuthenticate(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(get(CALL_V2_USERS_AUTHENTICATE, id));
    }

    /**
     * Call v2 users check credentials ({@code GET /projects/{id}/packages/conan/v2/users/check_credentials}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callV2UsersCheckCredentials(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(get(CALL_V2_USERS_CHECK_CREDENTIALS, id));
    }

    /**
     * Call v2 conans search ({@code GET /projects/{id}/packages/conan/v2/conans/search}).
     *
     * @param id the id
     * @param q the q
     * @throws IllegalArgumentException if {@code id} or {@code q} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callV2ConansSearch(final String id, final String q) throws IOException {
        callV2ConansSearch(id, q, GitLabProjectConanV2DistributionsCallV2ConansSearchFilter.empty());
    }

    /**
     * Call v2 conans search ({@code GET /projects/{id}/packages/conan/v2/conans/search}).
     *
     * @param id the id
     * @param q the q
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id} or {@code q} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callV2ConansSearch(
            final String id, final String q, final GitLabProjectConanV2DistributionsCallV2ConansSearchFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(q, "q");
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .all(filter.toQueryParameters())
                .text("q", q)
                .build();
        caller.send(get(CALL_V2_CONANS_SEARCH, id).withQuery(queryParameters));
    }

    /**
     * Call v2 conans search by package name and package version and package username and package channel ({@code GET
     * /projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/search}).
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
    public void callV2ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel(
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
                CALL_V2_CONANS_SEARCH_BY_PACKAGE_NAME_AN,
                id,
                packageName,
                packageVersion,
                packageUsername,
                packageChannel));
    }

    /**
     * Get v2 conans latest ({@code GET
     * /projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/latest}).
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
    public Optional<GitLabPackageConanRevision> getV2ConansLatest(
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
                get(GET_V2_CONANS_LATEST, id, packageName, packageVersion, packageUsername, packageChannel),
                GitLabPackageConanRevision.class);
    }

    /**
     * Get v2 conans revisions ({@code GET
     * /projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/revisions}).
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
    public Optional<GitLabPackageConanRecipeRevisions> getV2ConansRevisions(
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
                get(GET_V2_CONANS_REVISIONS, id, packageName, packageVersion, packageUsername, packageChannel),
                GitLabPackageConanRecipeRevisions.class);
    }

    /**
     * Delete v2 conans revision ({@code DELETE
     * /projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/revisions/{recipe_revision}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param recipeRevision the recipe revision
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion},
     *     {@code packageUsername}, {@code packageChannel} or {@code recipeRevision} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteV2ConansRevision(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String recipeRevision)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(recipeRevision, PARAM_RECIPEREVISION);
        caller.send(delete(
                DELETE_V2_CONANS_REVISION,
                id,
                packageName,
                packageVersion,
                packageUsername,
                packageChannel,
                recipeRevision));
    }

    /**
     * Get v2 conans revisions files ({@code GET
     * /projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/revisions/{recipe_revision}/files}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param recipeRevision the recipe revision
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion},
     *     {@code packageUsername}, {@code packageChannel} or {@code recipeRevision} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabPackageConanFilesList> getV2ConansRevisionsFiles(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String recipeRevision)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(recipeRevision, PARAM_RECIPEREVISION);
        return caller.fetchOrEmpty(
                get(
                        GET_V2_CONANS_REVISIONS_FILES,
                        id,
                        packageName,
                        packageVersion,
                        packageUsername,
                        packageChannel,
                        recipeRevision),
                GitLabPackageConanFilesList.class);
    }

    /**
     * Call v2 conans revisions file ({@code GET
     * /projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/revisions/{recipe_revision}/files/{file_name}}).
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
    public void callV2ConansRevisionsFile(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String recipeRevision,
            final GitLabProjectConanV2DistributionsCallV2ConansRevisionsFileName fileName)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(recipeRevision, PARAM_RECIPEREVISION);
        requireNonNull(fileName, PARAM_FILENAME);
        caller.send(get(
                CALL_V2_CONANS_REVISIONS_FILE,
                id,
                packageName,
                packageVersion,
                packageUsername,
                packageChannel,
                recipeRevision,
                fileName.wireValue()));
    }

    /**
     * Update v2 conans revisions file ({@code PUT
     * /projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/revisions/{recipe_revision}/files/{file_name}}).
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
    public void updateV2ConansRevisionsFile(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String recipeRevision,
            final GitLabProjectConanV2DistributionsUpdateV2ConansRevisionsFileName fileName,
            final MultipartFormData form)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(recipeRevision, PARAM_RECIPEREVISION);
        requireNonNull(fileName, PARAM_FILENAME);
        requireNonNull(form, "form");
        caller.send(caller.multipart(
                put(
                        CALL_V2_CONANS_REVISIONS_FILE,
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
     * Authorize v2 conans revisions file ({@code PUT
     * /projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/revisions/{recipe_revision}/files/{file_name}/authorize}).
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
    public void authorizeV2ConansRevisionsFile(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String recipeRevision,
            final GitLabProjectConanV2DistributionsAuthorizeV2ConansRevisionsFileName fileName)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(recipeRevision, PARAM_RECIPEREVISION);
        requireNonNull(fileName, PARAM_FILENAME);
        caller.send(put(
                AUTHORIZE_V2_CONANS_REVISIONS_FILE,
                id,
                packageName,
                packageVersion,
                packageUsername,
                packageChannel,
                recipeRevision,
                fileName.wireValue()));
    }

    /**
     * Call v2 conans revisions search ({@code GET
     * /projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/revisions/{recipe_revision}/search}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param recipeRevision the recipe revision
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion},
     *     {@code packageUsername}, {@code packageChannel} or {@code recipeRevision} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callV2ConansRevisionsSearch(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String recipeRevision)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(recipeRevision, PARAM_RECIPEREVISION);
        caller.send(get(
                CALL_V2_CONANS_REVISIONS_SEARCH,
                id,
                packageName,
                packageVersion,
                packageUsername,
                packageChannel,
                recipeRevision));
    }

    /**
     * Get v2 conans revisions packages latest ({@code GET
     * /projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/revisions/{recipe_revision}/packages/{conan_package_reference}/latest}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param recipeRevision the recipe revision
     * @param conanPackageReference the conan package reference
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion},
     *     {@code packageUsername}, {@code packageChannel}, {@code recipeRevision} or {@code conanPackageReference} is
     *     blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabPackageConanRevision> getV2ConansRevisionsPackagesLatest(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String recipeRevision,
            final String conanPackageReference)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(recipeRevision, PARAM_RECIPEREVISION);
        requireNotBlank(conanPackageReference, PARAM_CONANPACKAGEREFERENCE);
        return caller.fetchOrEmpty(
                get(
                        GET_V2_CONANS_REVISIONS_PACKAGES_LATEST,
                        id,
                        packageName,
                        packageVersion,
                        packageUsername,
                        packageChannel,
                        recipeRevision,
                        conanPackageReference),
                GitLabPackageConanRevision.class);
    }

    /**
     * Get v2 conans revisions packages revisions ({@code GET
     * /projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/revisions/{recipe_revision}/packages/{conan_package_reference}/revisions}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param recipeRevision the recipe revision
     * @param conanPackageReference the conan package reference
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion},
     *     {@code packageUsername}, {@code packageChannel}, {@code recipeRevision} or {@code conanPackageReference} is
     *     blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabPackageConanPackageRevisions> getV2ConansRevisionsPackagesRevisions(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String recipeRevision,
            final String conanPackageReference)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(recipeRevision, PARAM_RECIPEREVISION);
        requireNotBlank(conanPackageReference, PARAM_CONANPACKAGEREFERENCE);
        return caller.fetchOrEmpty(
                get(
                        GET_V2_CONANS_REVISIONS_PACKAGES_REVISIO,
                        id,
                        packageName,
                        packageVersion,
                        packageUsername,
                        packageChannel,
                        recipeRevision,
                        conanPackageReference),
                GitLabPackageConanPackageRevisions.class);
    }

    /**
     * Delete v2 conans revisions packages revision ({@code DELETE
     * /projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/revisions/{recipe_revision}/packages/{conan_package_reference}/revisions/{package_revision}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param recipeRevision the recipe revision
     * @param conanPackageReference the conan package reference
     * @param packageRevision the package revision
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion},
     *     {@code packageUsername}, {@code packageChannel}, {@code recipeRevision}, {@code conanPackageReference} or
     *     {@code packageRevision} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteV2ConansRevisionsPackagesRevision(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String recipeRevision,
            final String conanPackageReference,
            final String packageRevision)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(recipeRevision, PARAM_RECIPEREVISION);
        requireNotBlank(conanPackageReference, PARAM_CONANPACKAGEREFERENCE);
        requireNotBlank(packageRevision, PARAM_PACKAGEREVISION);
        caller.send(delete(
                DELETE_V2_CONANS_REVISIONS_PACKAGES_REVI,
                id,
                packageName,
                packageVersion,
                packageUsername,
                packageChannel,
                recipeRevision,
                conanPackageReference,
                packageRevision));
    }

    /**
     * Get v2 conans revisions packages revisions files ({@code GET
     * /projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/revisions/{recipe_revision}/packages/{conan_package_reference}/revisions/{package_revision}/files}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageUsername the package username
     * @param packageChannel the package channel
     * @param recipeRevision the recipe revision
     * @param conanPackageReference the conan package reference
     * @param packageRevision the package revision
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion},
     *     {@code packageUsername}, {@code packageChannel}, {@code recipeRevision}, {@code conanPackageReference} or
     *     {@code packageRevision} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabPackageConanFilesList> getV2ConansRevisionsPackagesRevisionsFiles(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String recipeRevision,
            final String conanPackageReference,
            final String packageRevision)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageUsername, PARAM_PACKAGEUSERNAME);
        requireNotBlank(packageChannel, PARAM_PACKAGECHANNEL);
        requireNotBlank(recipeRevision, PARAM_RECIPEREVISION);
        requireNotBlank(conanPackageReference, PARAM_CONANPACKAGEREFERENCE);
        requireNotBlank(packageRevision, PARAM_PACKAGEREVISION);
        return caller.fetchOrEmpty(
                get(
                        GET_V2_CONANS_REVISIONS_PACKAGES_REVIS_2,
                        id,
                        packageName,
                        packageVersion,
                        packageUsername,
                        packageChannel,
                        recipeRevision,
                        conanPackageReference,
                        packageRevision),
                GitLabPackageConanFilesList.class);
    }

    /**
     * Call v2 conans revisions packages revisions file ({@code GET
     * /projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/revisions/{recipe_revision}/packages/{conan_package_reference}/revisions/{package_revision}/files/{file_name}}).
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
    public void callV2ConansRevisionsPackagesRevisionsFile(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String recipeRevision,
            final String conanPackageReference,
            final String packageRevision,
            final GitLabConanV2PackageFileCallFileName fileName)
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
                CALL_V2_CONANS_REVISIONS_PACKAGES_REVISI,
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
     * Update v2 conans revisions packages revisions file ({@code PUT
     * /projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/revisions/{recipe_revision}/packages/{conan_package_reference}/revisions/{package_revision}/files/{file_name}}).
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
    public void updateV2ConansRevisionsPackagesRevisionsFile(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String recipeRevision,
            final String conanPackageReference,
            final String packageRevision,
            final GitLabConanV2PackageFileUpdateFileName fileName,
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
        requireNonNull(form, "form");
        caller.send(caller.multipart(
                put(
                        CALL_V2_CONANS_REVISIONS_PACKAGES_REVISI,
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
     * Authorize v2 conans revisions packages revisions file ({@code PUT
     * /projects/{id}/packages/conan/v2/conans/{package_name}/{package_version}/{package_username}/{package_channel}/revisions/{recipe_revision}/packages/{conan_package_reference}/revisions/{package_revision}/files/{file_name}/authorize}).
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
    public void authorizeV2ConansRevisionsPackagesRevisionsFile(
            final String id,
            final String packageName,
            final String packageVersion,
            final String packageUsername,
            final String packageChannel,
            final String recipeRevision,
            final String conanPackageReference,
            final String packageRevision,
            final GitLabConanV2PackageFileAuthorizeFileName fileName)
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
                AUTHORIZE_V2_CONANS_REVISIONS_PACKAGES_R,
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
}

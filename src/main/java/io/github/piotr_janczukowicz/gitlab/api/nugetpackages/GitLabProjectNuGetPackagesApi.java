package io.github.piotr_janczukowicz.gitlab.api.nugetpackages;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNugetPackageMetadata;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNugetPackagesMetadata;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNugetSearchResults;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNugetServiceIndex;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of project nu get packages. */
public final class GitLabProjectNuGetPackagesApi extends GitLabResourceApi {
    private static final String PARAM_FORM = "form";
    private static final String PARAM_ID = "id";
    private static final String PARAM_PACKAGENAME = "packageName";
    private static final String PARAM_PACKAGEVERSION = "packageVersion";
    private static final String PARAM_PROJECTID = "projectId";
    private static final PathTemplate GET_INDEX = PathTemplate.of("/projects/{id}/packages/nuget/index");
    private static final PathTemplate CALL_SYMBOLFILE =
            PathTemplate.of("/projects/{id}/packages/nuget/symbolfiles/{file_name}/{signature}/{same_file_name}");
    private static final PathTemplate CALL_V2 = PathTemplate.of("/projects/{id}/packages/nuget/v2");
    private static final PathTemplate CALL_V2_METADATA = PathTemplate.of("/projects/{id}/packages/nuget/v2/$metadata");
    private static final PathTemplate GET_METADATA_INDEX =
            PathTemplate.of("/projects/{id}/packages/nuget/metadata/{package_name}/index");
    private static final PathTemplate GET_METADATA =
            PathTemplate.of("/projects/{id}/packages/nuget/metadata/{package_name}/{package_version}");
    private static final PathTemplate GET_QUERY = PathTemplate.of("/projects/{id}/packages/nuget/query");
    private static final PathTemplate GET_DOWNLOAD_INDEX =
            PathTemplate.of("/projects/{id}/packages/nuget/download/{package_name}/index");
    private static final PathTemplate CALL_DOWNLOAD = PathTemplate.of(
            "/projects/{id}/packages/nuget/download/{package_name}/{package_version}/{package_filename}");
    private static final PathTemplate UPDATE = PathTemplate.of("/projects/{id}/packages/nuget");
    private static final PathTemplate AUTHORIZE = PathTemplate.of("/projects/{id}/packages/nuget/authorize");
    private static final PathTemplate SYMBOLPACKAGE = PathTemplate.of("/projects/{id}/packages/nuget/symbolpackage");
    private static final PathTemplate AUTHORIZE_SYMBOLPACKAGE =
            PathTemplate.of("/projects/{id}/packages/nuget/symbolpackage/authorize");
    private static final PathTemplate DELETE =
            PathTemplate.of("/projects/{id}/packages/nuget/{package_name}/{package_version}");
    private static final PathTemplate AUTHORIZE_V2 = PathTemplate.of("/projects/{id}/packages/nuget/v2/authorize");
    private static final PathTemplate CALL_V2_FINDPACKAGESBYID =
            PathTemplate.of("/projects/{project_id}/packages/nuget/v2/FindPackagesById()");
    private static final PathTemplate CALL_V2_PACKAGES =
            PathTemplate.of("/projects/{project_id}/packages/nuget/v2/Packages()");
    private static final PathTemplate CALL_V2_PACKAGES_ID_PACKAGE_NAME_VERSION =
            PathTemplate.of("/projects/{project_id}/packages/nuget/v2/{package_name}");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectNuGetPackagesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get index ({@code GET /projects/{id}/packages/nuget/index}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabNugetServiceIndex getIndex(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(GET_INDEX, id), GitLabNugetServiceIndex.class);
    }

    /**
     * Call symbolfile ({@code GET /projects/{id}/packages/nuget/symbolfiles/{file_name}/{signature}/{same_file_name}}).
     *
     * @param id the id
     * @param fileName the file name
     * @param signature the signature
     * @param sameFileName the same file name
     * @throws IllegalArgumentException if {@code id}, {@code fileName}, {@code signature} or {@code sameFileName} is
     *     blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callSymbolfile(
            final String id, final String fileName, final String signature, final String sameFileName)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(fileName, "fileName");
        requireNotBlank(signature, "signature");
        requireNotBlank(sameFileName, "sameFileName");
        caller.send(get(CALL_SYMBOLFILE, id, fileName, signature, sameFileName));
    }

    /**
     * Call v2 ({@code GET /projects/{id}/packages/nuget/v2}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callV2(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(get(CALL_V2, id));
    }

    /**
     * Update v2 ({@code PUT /projects/{id}/packages/nuget/v2}).
     *
     * @param id the id
     * @param form the form to send
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void updateV2(final String id, final MultipartFormData form) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(form, PARAM_FORM);
        caller.send(caller.multipart(put(CALL_V2, id), form));
    }

    /**
     * Call v2 metadata ({@code GET /projects/{id}/packages/nuget/v2/$metadata}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callV2Metadata(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(get(CALL_V2_METADATA, id));
    }

    /**
     * Get metadata index ({@code GET /projects/{id}/packages/nuget/metadata/{package_name}/index}).
     *
     * @param id the id
     * @param packageName the package name
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code packageName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabNugetPackagesMetadata> getMetadataIndex(final String id, final String packageName)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        return caller.fetchOrEmpty(get(GET_METADATA_INDEX, id, packageName), GitLabNugetPackagesMetadata.class);
    }

    /**
     * Get metadata ({@code GET /projects/{id}/packages/nuget/metadata/{package_name}/{package_version}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id}, {@code packageName} or {@code packageVersion} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabNugetPackageMetadata> getMetadata(
            final String id, final String packageName, final String packageVersion) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        return caller.fetchOrEmpty(
                get(GET_METADATA, id, packageName, packageVersion), GitLabNugetPackageMetadata.class);
    }

    /**
     * Get query ({@code GET /projects/{id}/packages/nuget/query}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabNugetSearchResults getQuery(final String id) throws IOException {
        return getQuery(id, GitLabProjectNuGetPackagesGetQueryFilter.empty());
    }

    /**
     * Get query ({@code GET /projects/{id}/packages/nuget/query}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabNugetSearchResults getQuery(final String id, final GitLabProjectNuGetPackagesGetQueryFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetch(get(GET_QUERY, id).withQuery(queryParameters), GitLabNugetSearchResults.class);
    }

    /**
     * Get download index ({@code GET /projects/{id}/packages/nuget/download/{package_name}/index}).
     *
     * @param id the id
     * @param packageName the package name
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code packageName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabNugetPackagesVersions> getDownloadIndex(final String id, final String packageName)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        return caller.fetchOrEmpty(get(GET_DOWNLOAD_INDEX, id, packageName), GitLabNugetPackagesVersions.class);
    }

    /**
     * Call download ({@code GET
     * /projects/{id}/packages/nuget/download/{package_name}/{package_version}/{package_filename}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param packageFilename the package filename
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion} or
     *     {@code packageFilename} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callDownload(
            final String id, final String packageName, final String packageVersion, final String packageFilename)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(packageFilename, "packageFilename");
        caller.send(get(CALL_DOWNLOAD, id, packageName, packageVersion, packageFilename));
    }

    /**
     * Update ({@code PUT /projects/{id}/packages/nuget}).
     *
     * @param id the id
     * @param form the form to send
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void update(final String id, final MultipartFormData form) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(form, PARAM_FORM);
        caller.send(caller.multipart(put(UPDATE, id), form));
    }

    /**
     * Authorize ({@code PUT /projects/{id}/packages/nuget/authorize}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void authorize(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(put(AUTHORIZE, id));
    }

    /**
     * Symbolpackage ({@code PUT /projects/{id}/packages/nuget/symbolpackage}).
     *
     * @param id the id
     * @param form the form to send
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void symbolpackage(final String id, final MultipartFormData form) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(form, PARAM_FORM);
        caller.send(caller.multipart(put(SYMBOLPACKAGE, id), form));
    }

    /**
     * Authorize symbolpackage ({@code PUT /projects/{id}/packages/nuget/symbolpackage/authorize}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void authorizeSymbolpackage(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(put(AUTHORIZE_SYMBOLPACKAGE, id));
    }

    /**
     * Delete ({@code DELETE /projects/{id}/packages/nuget/{package_name}/{package_version}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @throws IllegalArgumentException if {@code id}, {@code packageName} or {@code packageVersion} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final String packageName, final String packageVersion) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        caller.send(delete(DELETE, id, packageName, packageVersion));
    }

    /**
     * Authorize v2 ({@code PUT /projects/{id}/packages/nuget/v2/authorize}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void authorizeV2(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(put(AUTHORIZE_V2, id));
    }

    /**
     * Call v2 findpackagesbyid ({@code GET /projects/{project_id}/packages/nuget/v2/FindPackagesById()}).
     *
     * @param projectId the project id
     * @param id the id
     * @throws IllegalArgumentException if {@code projectId} or {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callV2Findpackagesbyid(final String projectId, final String id) throws IOException {
        requireNotBlank(projectId, PARAM_PROJECTID);
        requireNotBlank(id, PARAM_ID);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().text(PARAM_ID, id).build();
        caller.send(get(CALL_V2_FINDPACKAGESBYID, projectId).withQuery(queryParameters));
    }

    /**
     * Call v2 packages ({@code GET /projects/{project_id}/packages/nuget/v2/Packages()}).
     *
     * @param projectId the project id
     * @param filterValue the filter
     * @throws IllegalArgumentException if {@code projectId} or {@code filterValue} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callV2Packages(final String projectId, final String filterValue) throws IOException {
        requireNotBlank(projectId, PARAM_PROJECTID);
        requireNotBlank(filterValue, "filterValue");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().text("$filter", filterValue).build();
        caller.send(get(CALL_V2_PACKAGES, projectId).withQuery(queryParameters));
    }

    /**
     * Call v2 packages id package name version package version ({@code GET
     * /projects/{project_id}/packages/nuget/v2/Packages(Id='{package_name}',Version='{package_version}')}).
     *
     * @param projectId the project id
     * @param packageName the package name
     * @param packageVersion the package version
     * @throws IllegalArgumentException if {@code projectId}, {@code packageName} or {@code packageVersion} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callV2PackagesIdPackageNameVersionPackageVersion(
            final String projectId, final String packageName, final String packageVersion) throws IOException {
        requireNotBlank(projectId, PARAM_PROJECTID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        caller.send(get(
                CALL_V2_PACKAGES_ID_PACKAGE_NAME_VERSION,
                projectId,
                "Packages(Id='" + packageName + "',Version='" + packageVersion + "')"));
    }
}

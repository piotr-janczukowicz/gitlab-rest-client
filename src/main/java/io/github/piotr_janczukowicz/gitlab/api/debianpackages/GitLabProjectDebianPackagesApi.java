package io.github.piotr_janczukowicz.gitlab.api.debianpackages;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;

/** The GitLab operations of project debian packages. */
public final class GitLabProjectDebianPackagesApi extends GitLabResourceApi {
    private static final String PARAM_ARCHITECTURE = "architecture";
    private static final String PARAM_BINARY = "binary-";
    private static final String PARAM_COMPONENT = "component";
    private static final String PARAM_DISTRIBUTION = "distribution";
    private static final String PARAM_FILENAME = "fileName";
    private static final String PARAM_FILESHA256 = "fileSha256";
    private static final String PARAM_ID = "id";
    private static final PathTemplate CALL_DISTS_RELEASE_GPG =
            PathTemplate.of("/projects/{id}/packages/debian/dists/{distribution}/Release.gpg");
    private static final PathTemplate CALL_DISTS_RELEASE =
            PathTemplate.of("/projects/{id}/packages/debian/dists/{distribution}/Release");
    private static final PathTemplate CALL_DISTS_INRELEASE =
            PathTemplate.of("/projects/{id}/packages/debian/dists/{distribution}/InRelease");
    private static final PathTemplate CALL_DISTS_DEBIAN_INSTALLER_BINARY_ARCHI = PathTemplate.of(
            "/projects/{id}/packages/debian/dists/{distribution}/{component}/debian-installer/{architecture}/Packages");
    private static final PathTemplate CALL_DISTS_DEBIAN_INSTALLER_BINARY_ARC_2 = PathTemplate.of(
            "/projects/{id}/packages/debian/dists/{distribution}/{component}/debian-installer/{architecture}/by-hash/SHA256/{file_sha256}");
    private static final PathTemplate CALL_DISTS_SOURCE_SOURCES =
            PathTemplate.of("/projects/{id}/packages/debian/dists/{distribution}/{component}/source/Sources");
    private static final PathTemplate CALL_DISTS_SOURCE_BY_HASH_SHA256 = PathTemplate.of(
            "/projects/{id}/packages/debian/dists/{distribution}/{component}/source/by-hash/SHA256/{file_sha256}");
    private static final PathTemplate CALL_DISTS_BINARY_ARCHITECTURE_PACKAGES =
            PathTemplate.of("/projects/{id}/packages/debian/dists/{distribution}/{component}/{architecture}/Packages");
    private static final PathTemplate CALL_DISTS_BINARY_ARCHITECTURE_BY_HASH_S = PathTemplate.of(
            "/projects/{id}/packages/debian/dists/{distribution}/{component}/{architecture}/by-hash/SHA256/{file_sha256}");
    private static final PathTemplate GET_POOL = PathTemplate.of(
            "/projects/{id}/packages/debian/pool/{distribution}/{letter}/{package_name}/{package_version}/{file_name}");
    private static final PathTemplate UPDATE = PathTemplate.of("/projects/{id}/packages/debian/{file_name}");
    private static final PathTemplate AUTHORIZE =
            PathTemplate.of("/projects/{id}/packages/debian/{file_name}/authorize");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectDebianPackagesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Call dists release gpg ({@code GET /projects/{id}/packages/debian/dists/{distribution}/Release.gpg}).
     *
     * @param id the id
     * @param distribution the distribution
     * @throws IllegalArgumentException if {@code id} or {@code distribution} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callDistsReleaseGpg(final String id, final String distribution) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(distribution, PARAM_DISTRIBUTION);
        caller.send(get(CALL_DISTS_RELEASE_GPG, id, distribution));
    }

    /**
     * Call dists release ({@code GET /projects/{id}/packages/debian/dists/{distribution}/Release}).
     *
     * @param id the id
     * @param distribution the distribution
     * @throws IllegalArgumentException if {@code id} or {@code distribution} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callDistsRelease(final String id, final String distribution) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(distribution, PARAM_DISTRIBUTION);
        caller.send(get(CALL_DISTS_RELEASE, id, distribution));
    }

    /**
     * Call dists inrelease ({@code GET /projects/{id}/packages/debian/dists/{distribution}/InRelease}).
     *
     * @param id the id
     * @param distribution the distribution
     * @throws IllegalArgumentException if {@code id} or {@code distribution} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callDistsInrelease(final String id, final String distribution) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(distribution, PARAM_DISTRIBUTION);
        caller.send(get(CALL_DISTS_INRELEASE, id, distribution));
    }

    /**
     * Call dists debian installer binary architecture packages ({@code GET
     * /projects/{id}/packages/debian/dists/{distribution}/{component}/debian-installer/binary-{architecture}/Packages}).
     *
     * @param id the id
     * @param distribution the distribution
     * @param component the component
     * @param architecture the architecture
     * @throws IllegalArgumentException if {@code id}, {@code distribution}, {@code component} or {@code architecture}
     *     is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callDistsDebianInstallerBinaryArchitecturePackages(
            final String id, final String distribution, final String component, final String architecture)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(distribution, PARAM_DISTRIBUTION);
        requireNotBlank(component, PARAM_COMPONENT);
        requireNotBlank(architecture, PARAM_ARCHITECTURE);
        caller.send(get(
                CALL_DISTS_DEBIAN_INSTALLER_BINARY_ARCHI, id, distribution, component, PARAM_BINARY + architecture));
    }

    /**
     * Call dists debian installer binary architecture by hash sha256 ({@code GET
     * /projects/{id}/packages/debian/dists/{distribution}/{component}/debian-installer/binary-{architecture}/by-hash/SHA256/{file_sha256}}).
     *
     * @param id the id
     * @param distribution the distribution
     * @param component the component
     * @param architecture the architecture
     * @param fileSha256 the file sha256
     * @throws IllegalArgumentException if {@code id}, {@code distribution}, {@code component}, {@code architecture} or
     *     {@code fileSha256} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callDistsDebianInstallerBinaryArchitectureByHashSha256(
            final String id,
            final String distribution,
            final String component,
            final String architecture,
            final String fileSha256)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(distribution, PARAM_DISTRIBUTION);
        requireNotBlank(component, PARAM_COMPONENT);
        requireNotBlank(architecture, PARAM_ARCHITECTURE);
        requireNotBlank(fileSha256, PARAM_FILESHA256);
        caller.send(get(
                CALL_DISTS_DEBIAN_INSTALLER_BINARY_ARC_2,
                id,
                distribution,
                component,
                PARAM_BINARY + architecture,
                fileSha256));
    }

    /**
     * Call dists source sources ({@code GET
     * /projects/{id}/packages/debian/dists/{distribution}/{component}/source/Sources}).
     *
     * @param id the id
     * @param distribution the distribution
     * @param component the component
     * @throws IllegalArgumentException if {@code id}, {@code distribution} or {@code component} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callDistsSourceSources(final String id, final String distribution, final String component)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(distribution, PARAM_DISTRIBUTION);
        requireNotBlank(component, PARAM_COMPONENT);
        caller.send(get(CALL_DISTS_SOURCE_SOURCES, id, distribution, component));
    }

    /**
     * Call dists source by hash sha256 ({@code GET
     * /projects/{id}/packages/debian/dists/{distribution}/{component}/source/by-hash/SHA256/{file_sha256}}).
     *
     * @param id the id
     * @param distribution the distribution
     * @param component the component
     * @param fileSha256 the file sha256
     * @throws IllegalArgumentException if {@code id}, {@code distribution}, {@code component} or {@code fileSha256} is
     *     blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callDistsSourceByHashSha256(
            final String id, final String distribution, final String component, final String fileSha256)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(distribution, PARAM_DISTRIBUTION);
        requireNotBlank(component, PARAM_COMPONENT);
        requireNotBlank(fileSha256, PARAM_FILESHA256);
        caller.send(get(CALL_DISTS_SOURCE_BY_HASH_SHA256, id, distribution, component, fileSha256));
    }

    /**
     * Call dists binary architecture packages ({@code GET
     * /projects/{id}/packages/debian/dists/{distribution}/{component}/binary-{architecture}/Packages}).
     *
     * @param id the id
     * @param distribution the distribution
     * @param component the component
     * @param architecture the architecture
     * @throws IllegalArgumentException if {@code id}, {@code distribution}, {@code component} or {@code architecture}
     *     is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callDistsBinaryArchitecturePackages(
            final String id, final String distribution, final String component, final String architecture)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(distribution, PARAM_DISTRIBUTION);
        requireNotBlank(component, PARAM_COMPONENT);
        requireNotBlank(architecture, PARAM_ARCHITECTURE);
        caller.send(
                get(CALL_DISTS_BINARY_ARCHITECTURE_PACKAGES, id, distribution, component, PARAM_BINARY + architecture));
    }

    /**
     * Call dists binary architecture by hash sha256 ({@code GET
     * /projects/{id}/packages/debian/dists/{distribution}/{component}/binary-{architecture}/by-hash/SHA256/{file_sha256}}).
     *
     * @param id the id
     * @param distribution the distribution
     * @param component the component
     * @param architecture the architecture
     * @param fileSha256 the file sha256
     * @throws IllegalArgumentException if {@code id}, {@code distribution}, {@code component}, {@code architecture} or
     *     {@code fileSha256} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callDistsBinaryArchitectureByHashSha256(
            final String id,
            final String distribution,
            final String component,
            final String architecture,
            final String fileSha256)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(distribution, PARAM_DISTRIBUTION);
        requireNotBlank(component, PARAM_COMPONENT);
        requireNotBlank(architecture, PARAM_ARCHITECTURE);
        requireNotBlank(fileSha256, PARAM_FILESHA256);
        caller.send(get(
                CALL_DISTS_BINARY_ARCHITECTURE_BY_HASH_S,
                id,
                distribution,
                component,
                PARAM_BINARY + architecture,
                fileSha256));
    }

    /**
     * Get pool ({@code GET
     * /projects/{id}/packages/debian/pool/{distribution}/{letter}/{package_name}/{package_version}/{file_name}}).
     *
     * @param id the id
     * @param distribution the distribution
     * @param letter the letter
     * @param packageName the package name
     * @param packageVersion the package version
     * @param fileName the file name
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id}, {@code distribution}, {@code letter}, {@code packageName},
     *     {@code packageVersion} or {@code fileName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getPool(
            final String id,
            final String distribution,
            final String letter,
            final String packageName,
            final String packageVersion,
            final String fileName,
            final OutputStream out)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(distribution, PARAM_DISTRIBUTION);
        requireNotBlank(letter, "letter");
        requireNotBlank(packageName, "packageName");
        requireNotBlank(packageVersion, "packageVersion");
        requireNotBlank(fileName, PARAM_FILENAME);
        requireNonNull(out, "out");
        return caller.download(get(GET_POOL, id, distribution, letter, packageName, packageVersion, fileName), out);
    }

    /**
     * Get pool ({@code GET
     * /projects/{id}/packages/debian/pool/{distribution}/{letter}/{package_name}/{package_version}/{file_name}}).
     *
     * @param id the id
     * @param distribution the distribution
     * @param letter the letter
     * @param packageName the package name
     * @param packageVersion the package version
     * @param fileName the file name
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id}, {@code distribution}, {@code letter}, {@code packageName},
     *     {@code packageVersion} or {@code fileName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getPool(
            final String id,
            final String distribution,
            final String letter,
            final String packageName,
            final String packageVersion,
            final String fileName,
            final Path target)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(distribution, PARAM_DISTRIBUTION);
        requireNotBlank(letter, "letter");
        requireNotBlank(packageName, "packageName");
        requireNotBlank(packageVersion, "packageVersion");
        requireNotBlank(fileName, PARAM_FILENAME);
        requireNonNull(target, "target");
        return caller.download(get(GET_POOL, id, distribution, letter, packageName, packageVersion, fileName), target);
    }

    /**
     * Update ({@code PUT /projects/{id}/packages/debian/{file_name}}).
     *
     * @param id the id
     * @param fileName the file name
     * @param form the form to send
     * @throws IllegalArgumentException if {@code id} or {@code fileName} is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void update(final String id, final String fileName, final MultipartFormData form) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(fileName, PARAM_FILENAME);
        requireNonNull(form, "form");
        caller.send(caller.multipart(put(UPDATE, id, fileName), form));
    }

    /**
     * Authorize ({@code PUT /projects/{id}/packages/debian/{file_name}/authorize}).
     *
     * @param id the id
     * @param fileName the file name
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} or {@code fileName} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void authorize(
            final String id, final String fileName, final GitLabProjectDebianPackagesAuthorizePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(fileName, PARAM_FILENAME);
        requireNonNull(payload, "payload");
        caller.send(caller.json(put(AUTHORIZE, id, fileName), payload));
    }
}

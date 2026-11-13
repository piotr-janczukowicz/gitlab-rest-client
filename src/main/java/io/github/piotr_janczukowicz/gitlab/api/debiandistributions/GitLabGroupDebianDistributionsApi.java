package io.github.piotr_janczukowicz.gitlab.api.debiandistributions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;

/** The GitLab operations of group debian distributions. */
public final class GitLabGroupDebianDistributionsApi extends GitLabResourceApi {
    private static final String PARAM_ARCHITECTURE = "architecture";
    private static final String PARAM_BINARY = "binary-";
    private static final String PARAM_COMPONENT = "component";
    private static final String PARAM_DISTRIBUTION = "distribution";
    private static final String PARAM_FILESHA256 = "fileSha256";
    private static final String PARAM_ID = "id";
    private static final PathTemplate CALL_PACKAGES_DEBIAN_DISTS_RELEASE_GPG =
            PathTemplate.of("/groups/{id}/-/packages/debian/dists/{distribution}/Release.gpg");
    private static final PathTemplate CALL_PACKAGES_DEBIAN_DISTS_RELEASE =
            PathTemplate.of("/groups/{id}/-/packages/debian/dists/{distribution}/Release");
    private static final PathTemplate CALL_PACKAGES_DEBIAN_DISTS_INRELEASE =
            PathTemplate.of("/groups/{id}/-/packages/debian/dists/{distribution}/InRelease");
    private static final PathTemplate CALL_PACKAGES_DEBIAN_DISTS_DEBIAN_INSTAL = PathTemplate.of(
            "/groups/{id}/-/packages/debian/dists/{distribution}/{component}/debian-installer/{architecture}/Packages");
    private static final PathTemplate CALL_PACKAGES_DEBIAN_DISTS_DEBIAN_INST_2 = PathTemplate.of(
            "/groups/{id}/-/packages/debian/dists/{distribution}/{component}/debian-installer/{architecture}/by-hash/SHA256/{file_sha256}");
    private static final PathTemplate CALL_PACKAGES_DEBIAN_DISTS_SOURCE_SOURCE =
            PathTemplate.of("/groups/{id}/-/packages/debian/dists/{distribution}/{component}/source/Sources");
    private static final PathTemplate CALL_PACKAGES_DEBIAN_DISTS_SOURCE_BY_HAS = PathTemplate.of(
            "/groups/{id}/-/packages/debian/dists/{distribution}/{component}/source/by-hash/SHA256/{file_sha256}");
    private static final PathTemplate CALL_PACKAGES_DEBIAN_DISTS_BINARY_ARCHIT =
            PathTemplate.of("/groups/{id}/-/packages/debian/dists/{distribution}/{component}/{architecture}/Packages");
    private static final PathTemplate CALL_PACKAGES_DEBIAN_DISTS_BINARY_ARCH_2 = PathTemplate.of(
            "/groups/{id}/-/packages/debian/dists/{distribution}/{component}/{architecture}/by-hash/SHA256/{file_sha256}");
    private static final PathTemplate GET_PACKAGES_DEBIAN_POOL = PathTemplate.of(
            "/groups/{id}/-/packages/debian/pool/{distribution}/{project_id}/{letter}/{package_name}/{package_version}/{file_name}");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupDebianDistributionsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Call packages debian dists release gpg ({@code GET
     * /groups/{id}/-/packages/debian/dists/{distribution}/Release.gpg}).
     *
     * @param id the id
     * @param distribution the distribution
     * @throws IllegalArgumentException if {@code id} or {@code distribution} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callPackagesDebianDistsReleaseGpg(final String id, final String distribution) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(distribution, PARAM_DISTRIBUTION);
        caller.send(get(CALL_PACKAGES_DEBIAN_DISTS_RELEASE_GPG, id, distribution));
    }

    /**
     * Call packages debian dists release ({@code GET /groups/{id}/-/packages/debian/dists/{distribution}/Release}).
     *
     * @param id the id
     * @param distribution the distribution
     * @throws IllegalArgumentException if {@code id} or {@code distribution} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callPackagesDebianDistsRelease(final String id, final String distribution) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(distribution, PARAM_DISTRIBUTION);
        caller.send(get(CALL_PACKAGES_DEBIAN_DISTS_RELEASE, id, distribution));
    }

    /**
     * Call packages debian dists inrelease ({@code GET /groups/{id}/-/packages/debian/dists/{distribution}/InRelease}).
     *
     * @param id the id
     * @param distribution the distribution
     * @throws IllegalArgumentException if {@code id} or {@code distribution} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callPackagesDebianDistsInrelease(final String id, final String distribution) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(distribution, PARAM_DISTRIBUTION);
        caller.send(get(CALL_PACKAGES_DEBIAN_DISTS_INRELEASE, id, distribution));
    }

    /**
     * Call packages debian dists debian installer binary architecture packages ({@code GET
     * /groups/{id}/-/packages/debian/dists/{distribution}/{component}/debian-installer/binary-{architecture}/Packages}).
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
    public void callPackagesDebianDistsDebianInstallerBinaryArchitecturePackages(
            final String id, final String distribution, final String component, final String architecture)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(distribution, PARAM_DISTRIBUTION);
        requireNotBlank(component, PARAM_COMPONENT);
        requireNotBlank(architecture, PARAM_ARCHITECTURE);
        caller.send(get(
                CALL_PACKAGES_DEBIAN_DISTS_DEBIAN_INSTAL, id, distribution, component, PARAM_BINARY + architecture));
    }

    /**
     * Call packages debian dists debian installer binary architecture by hash sha256 ({@code GET
     * /groups/{id}/-/packages/debian/dists/{distribution}/{component}/debian-installer/binary-{architecture}/by-hash/SHA256/{file_sha256}}).
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
    public void callPackagesDebianDistsDebianInstallerBinaryArchitectureByHashSha256(
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
                CALL_PACKAGES_DEBIAN_DISTS_DEBIAN_INST_2,
                id,
                distribution,
                component,
                PARAM_BINARY + architecture,
                fileSha256));
    }

    /**
     * Call packages debian dists source sources ({@code GET
     * /groups/{id}/-/packages/debian/dists/{distribution}/{component}/source/Sources}).
     *
     * @param id the id
     * @param distribution the distribution
     * @param component the component
     * @throws IllegalArgumentException if {@code id}, {@code distribution} or {@code component} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callPackagesDebianDistsSourceSources(final String id, final String distribution, final String component)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(distribution, PARAM_DISTRIBUTION);
        requireNotBlank(component, PARAM_COMPONENT);
        caller.send(get(CALL_PACKAGES_DEBIAN_DISTS_SOURCE_SOURCE, id, distribution, component));
    }

    /**
     * Call packages debian dists source by hash sha256 ({@code GET
     * /groups/{id}/-/packages/debian/dists/{distribution}/{component}/source/by-hash/SHA256/{file_sha256}}).
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
    public void callPackagesDebianDistsSourceByHashSha256(
            final String id, final String distribution, final String component, final String fileSha256)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(distribution, PARAM_DISTRIBUTION);
        requireNotBlank(component, PARAM_COMPONENT);
        requireNotBlank(fileSha256, PARAM_FILESHA256);
        caller.send(get(CALL_PACKAGES_DEBIAN_DISTS_SOURCE_BY_HAS, id, distribution, component, fileSha256));
    }

    /**
     * Call packages debian dists binary architecture packages ({@code GET
     * /groups/{id}/-/packages/debian/dists/{distribution}/{component}/binary-{architecture}/Packages}).
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
    public void callPackagesDebianDistsBinaryArchitecturePackages(
            final String id, final String distribution, final String component, final String architecture)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(distribution, PARAM_DISTRIBUTION);
        requireNotBlank(component, PARAM_COMPONENT);
        requireNotBlank(architecture, PARAM_ARCHITECTURE);
        caller.send(get(
                CALL_PACKAGES_DEBIAN_DISTS_BINARY_ARCHIT, id, distribution, component, PARAM_BINARY + architecture));
    }

    /**
     * Call packages debian dists binary architecture by hash sha256 ({@code GET
     * /groups/{id}/-/packages/debian/dists/{distribution}/{component}/binary-{architecture}/by-hash/SHA256/{file_sha256}}).
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
    public void callPackagesDebianDistsBinaryArchitectureByHashSha256(
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
                CALL_PACKAGES_DEBIAN_DISTS_BINARY_ARCH_2,
                id,
                distribution,
                component,
                PARAM_BINARY + architecture,
                fileSha256));
    }

    /**
     * Get packages debian pool ({@code GET
     * /groups/{id}/-/packages/debian/pool/{distribution}/{project_id}/{letter}/{package_name}/{package_version}/{file_name}}).
     *
     * @param id the id
     * @param distribution the distribution
     * @param projectId the project id
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
    public long getPackagesDebianPool(
            final String id,
            final String distribution,
            final long projectId,
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
        requireNotBlank(fileName, "fileName");
        requireNonNull(out, "out");
        return caller.download(
                get(
                        GET_PACKAGES_DEBIAN_POOL,
                        id,
                        distribution,
                        projectId,
                        letter,
                        packageName,
                        packageVersion,
                        fileName),
                out);
    }

    /**
     * Get packages debian pool ({@code GET
     * /groups/{id}/-/packages/debian/pool/{distribution}/{project_id}/{letter}/{package_name}/{package_version}/{file_name}}).
     *
     * @param id the id
     * @param distribution the distribution
     * @param projectId the project id
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
    public Path getPackagesDebianPool(
            final String id,
            final String distribution,
            final long projectId,
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
        requireNotBlank(fileName, "fileName");
        requireNonNull(target, "target");
        return caller.download(
                get(
                        GET_PACKAGES_DEBIAN_POOL,
                        id,
                        distribution,
                        projectId,
                        letter,
                        packageName,
                        packageVersion,
                        fileName),
                target);
    }
}

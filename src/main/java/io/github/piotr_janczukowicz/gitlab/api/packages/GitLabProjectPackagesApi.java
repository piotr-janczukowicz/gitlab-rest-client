package io.github.piotr_janczukowicz.gitlab.api.packages;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabPackage;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabPackagePipeline;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.pagination.GitLabListSpec;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPageRequest;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of project packages. */
public final class GitLabProjectPackagesApi extends GitLabResourceApi {
    private static final String PARAM_CHANNEL = "channel";
    private static final String PARAM_FILENAME = "fileName";
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_FORM = "form";
    private static final String PARAM_ID = "id";
    private static final String PARAM_OUT = "out";
    private static final String PARAM_PACKAGENAME = "packageName";
    private static final String PARAM_PACKAGEVERSION = "packageVersion";
    private static final String PARAM_PATH = "path";
    private static final String PARAM_REQUEST = "request";
    private static final String PARAM_TARGET = "target";
    private static final PathTemplate CALL_RPM_REPODATA =
            PathTemplate.of("/projects/{id}/packages/rpm/repodata/{file_name}");
    private static final PathTemplate CALL_RPM =
            PathTemplate.of("/projects/{id}/packages/rpm/{package_file_id}/{file_name}");
    private static final PathTemplate RPM = PathTemplate.of("/projects/{id}/packages/rpm");
    private static final PathTemplate AUTHORIZE_RPM = PathTemplate.of("/projects/{id}/packages/rpm/authorize");
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/packages");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/packages/{package_id}");
    private static final PathTemplate LIST_PIPELINES =
            PathTemplate.of("/projects/{id}/packages/{package_id}/pipelines");
    private static final PathTemplate LIST_PACKAGE_FILES =
            PathTemplate.of("/projects/{id}/packages/{package_id}/package_files");
    private static final PathTemplate DELETE_PACKAGE_FILE =
            PathTemplate.of("/projects/{id}/packages/{package_id}/package_files/{package_file_id}");
    private static final PathTemplate GET_PACKAGE_FILES_DOWNLOAD =
            PathTemplate.of("/projects/{id}/packages/{package_id}/package_files/{package_file_id}/download");
    private static final PathTemplate CALL_MAVEN = PathTemplate.of("/packages/maven/{path}/{file_name}");
    private static final PathTemplate CALL_HELM_INDEX_YAML =
            PathTemplate.of("/projects/{id}/packages/helm/{channel}/index.yaml");
    private static final PathTemplate GET_HELM_CHARTS_FILE_NAME_TGZ =
            PathTemplate.of("/projects/{id}/packages/helm/{channel}/charts/{file_name}");
    private static final PathTemplate AUTHORIZE_HELM_API_CHART =
            PathTemplate.of("/projects/{id}/packages/helm/api/{channel}/charts/authorize");
    private static final PathTemplate CREATE_HELM_API_CHART =
            PathTemplate.of("/projects/{id}/packages/helm/api/{channel}/charts");
    private static final PathTemplate AUTHORIZE_GENERIC =
            PathTemplate.of("/projects/{id}/packages/generic/{package_name}/{package_version}/{file_name}/authorize");
    private static final PathTemplate AUTHORIZE_GENERIC_BY_PATH = PathTemplate.of(
            "/projects/{id}/packages/generic/{package_name}/{package_version}/{path}/{file_name}/authorize");
    private static final PathTemplate CALL_GENERIC =
            PathTemplate.of("/projects/{id}/packages/generic/{package_name}/{package_version}/{file_name}");
    private static final PathTemplate CALL_GENERIC_BY_PATH =
            PathTemplate.of("/projects/{id}/packages/generic/{package_name}/{package_version}/{path}/{file_name}");
    private static final PathTemplate CALL_CARGO_CONFIG_JSON =
            PathTemplate.of("/projects/{id}/packages/cargo/config.json");
    private static final PathTemplate GET_CARGO_V1 = PathTemplate.of("/projects/{id}/packages/cargo/1/{package_name}");
    private static final PathTemplate GET_CARGO_V2 = PathTemplate.of("/projects/{id}/packages/cargo/2/{package_name}");
    private static final PathTemplate GET_CARGO_V3 =
            PathTemplate.of("/projects/{id}/packages/cargo/3/{first_char}/{package_name}");
    private static final PathTemplate GET_CARGO =
            PathTemplate.of("/projects/{id}/packages/cargo/{prefix_1}/{prefix_2}/{package_name}");
    private static final PathTemplate GET_CARGO_DOWNLOAD =
            PathTemplate.of("/projects/{id}/packages/cargo/{package_name}/{package_version}/download");
    private static final PathTemplate NEW_CARGO_API_V1_CRATE =
            PathTemplate.of("/projects/{id}/packages/cargo/api/v1/crates/new");
    private static final JsonType<List<GitLabPackage>> PACKAGE_LIST_TYPE = JsonTypes.listOf(GitLabPackage.class);
    private static final JsonType<List<GitLabPackagePipeline>> PACKAGE_PIPELINE_LIST_TYPE =
            JsonTypes.listOf(GitLabPackagePipeline.class);
    private static final JsonType<List<GitLabPackageFile>> PACKAGE_FILE_LIST_TYPE =
            JsonTypes.listOf(GitLabPackageFile.class);
    private static final GitLabListSpec<GitLabPackage> PACKAGE_SPEC = GitLabListSpec.offset(PACKAGE_LIST_TYPE);
    private static final GitLabListSpec<GitLabPackagePipeline> PACKAGE_PIPELINE_KEYSET_SPEC =
            GitLabListSpec.offsetOrKeyset(PACKAGE_PIPELINE_LIST_TYPE);
    private static final GitLabListSpec<GitLabPackageFile> PACKAGE_FILE_SPEC =
            GitLabListSpec.offset(PACKAGE_FILE_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectPackagesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Call rpm repodata ({@code GET /projects/{id}/packages/rpm/repodata/{file_name}}).
     *
     * @param id the id
     * @param fileName the file name
     * @throws IllegalArgumentException if {@code id} or {@code fileName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callRpmRepodata(final String id, final String fileName) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(fileName, PARAM_FILENAME);
        caller.send(get(CALL_RPM_REPODATA, id, fileName));
    }

    /**
     * Call rpm ({@code GET /projects/{id}/packages/rpm/{package_file_id}/{file_name}}).
     *
     * @param id the id
     * @param packageFileId the package file id
     * @param fileName the file name
     * @throws IllegalArgumentException if {@code id} or {@code fileName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callRpm(final String id, final long packageFileId, final String fileName) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(fileName, PARAM_FILENAME);
        caller.send(get(CALL_RPM, id, packageFileId, fileName));
    }

    /**
     * Rpm ({@code POST /projects/{id}/packages/rpm}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void rpm(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(post(RPM, id));
    }

    /**
     * Authorize rpm ({@code POST /projects/{id}/packages/rpm/authorize}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void authorizeRpm(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(post(AUTHORIZE_RPM, id));
    }

    /**
     * List ({@code GET /projects/{id}/packages}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPackage> list(final String id) throws IOException {
        return list(id, GitLabProjectPackagesListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/packages}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPackage> list(final String id, final GitLabPageRequest request) throws IOException {
        return list(id, GitLabProjectPackagesListFilter.empty(), request);
    }

    /**
     * List ({@code GET /projects/{id}/packages}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPackage> list(final String id, final GitLabProjectPackagesListFilter filter)
            throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/packages}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPackage> list(
            final String id, final GitLabProjectPackagesListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, PACKAGE_SPEC, id);
    }

    /**
     * Get ({@code GET /projects/{id}/packages/{package_id}}).
     *
     * @param id the id
     * @param packageId the package id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabPackage> get(final String id, final long packageId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET, id, packageId), GitLabPackage.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/packages/{package_id}}).
     *
     * @param id the id
     * @param packageId the package id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final long packageId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(GET, id, packageId));
    }

    /**
     * List pipelines ({@code GET /projects/{id}/packages/{package_id}/pipelines}).
     *
     * @param id the id
     * @param packageId the package id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPackagePipeline> listPipelines(final String id, final long packageId) throws IOException {
        return listPipelines(
                id, packageId, GitLabProjectPackagesListPipelinesFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List pipelines ({@code GET /projects/{id}/packages/{package_id}/pipelines}).
     *
     * @param id the id
     * @param packageId the package id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPackagePipeline> listPipelines(
            final String id, final long packageId, final GitLabPageRequest request) throws IOException {
        return listPipelines(id, packageId, GitLabProjectPackagesListPipelinesFilter.empty(), request);
    }

    /**
     * List pipelines ({@code GET /projects/{id}/packages/{package_id}/pipelines}).
     *
     * @param id the id
     * @param packageId the package id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPackagePipeline> listPipelines(
            final String id, final long packageId, final GitLabProjectPackagesListPipelinesFilter filter)
            throws IOException {
        return listPipelines(id, packageId, filter, GitLabPageRequest.byPage());
    }

    /**
     * List pipelines ({@code GET /projects/{id}/packages/{package_id}/pipelines}).
     *
     * @param id the id
     * @param packageId the package id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPackagePipeline> listPipelines(
            final String id,
            final long packageId,
            final GitLabProjectPackagesListPipelinesFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_PIPELINES, queryParameters, request, PACKAGE_PIPELINE_KEYSET_SPEC, id, packageId);
    }

    /**
     * List package files ({@code GET /projects/{id}/packages/{package_id}/package_files}).
     *
     * @param id the id
     * @param packageId the package id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPackageFile> listPackageFiles(final String id, final long packageId) throws IOException {
        return listPackageFiles(
                id, packageId, GitLabProjectPackagesListPackageFilesFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List package files ({@code GET /projects/{id}/packages/{package_id}/package_files}).
     *
     * @param id the id
     * @param packageId the package id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPackageFile> listPackageFiles(
            final String id, final long packageId, final GitLabPageRequest request) throws IOException {
        return listPackageFiles(id, packageId, GitLabProjectPackagesListPackageFilesFilter.empty(), request);
    }

    /**
     * List package files ({@code GET /projects/{id}/packages/{package_id}/package_files}).
     *
     * @param id the id
     * @param packageId the package id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPackageFile> listPackageFiles(
            final String id, final long packageId, final GitLabProjectPackagesListPackageFilesFilter filter)
            throws IOException {
        return listPackageFiles(id, packageId, filter, GitLabPageRequest.byPage());
    }

    /**
     * List package files ({@code GET /projects/{id}/packages/{package_id}/package_files}).
     *
     * @param id the id
     * @param packageId the package id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabPackageFile> listPackageFiles(
            final String id,
            final long packageId,
            final GitLabProjectPackagesListPackageFilesFilter filter,
            final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, PARAM_REQUEST);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST_PACKAGE_FILES, queryParameters, request, PACKAGE_FILE_SPEC, id, packageId);
    }

    /**
     * Delete package file ({@code DELETE /projects/{id}/packages/{package_id}/package_files/{package_file_id}}).
     *
     * @param id the id
     * @param packageId the package id
     * @param packageFileId the package file id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deletePackageFile(final String id, final long packageId, final long packageFileId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(DELETE_PACKAGE_FILE, id, packageId, packageFileId));
    }

    /**
     * Get package files download ({@code GET
     * /projects/{id}/packages/{package_id}/package_files/{package_file_id}/download}).
     *
     * @param id the id
     * @param packageId the package id
     * @param packageFileId the package file id
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getPackageFilesDownload(
            final String id, final long packageId, final long packageFileId, final OutputStream out)
            throws IOException {
        return getPackageFilesDownload(
                id, packageId, packageFileId, GitLabProjectPackagesGetPackageFilesDownloadFilter.empty(), out);
    }

    /**
     * Get package files download ({@code GET
     * /projects/{id}/packages/{package_id}/package_files/{package_file_id}/download}).
     *
     * @param id the id
     * @param packageId the package id
     * @param packageFileId the package file id
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getPackageFilesDownload(
            final String id, final long packageId, final long packageFileId, final Path target) throws IOException {
        return getPackageFilesDownload(
                id, packageId, packageFileId, GitLabProjectPackagesGetPackageFilesDownloadFilter.empty(), target);
    }

    /**
     * Get package files download ({@code GET
     * /projects/{id}/packages/{package_id}/package_files/{package_file_id}/download}).
     *
     * @param id the id
     * @param packageId the package id
     * @param packageFileId the package file id
     * @param filter the optional query parameters
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getPackageFilesDownload(
            final String id,
            final long packageId,
            final long packageFileId,
            final GitLabProjectPackagesGetPackageFilesDownloadFilter filter,
            final OutputStream out)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(out, PARAM_OUT);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.download(
                get(GET_PACKAGE_FILES_DOWNLOAD, id, packageId, packageFileId).withQuery(queryParameters), out);
    }

    /**
     * Get package files download ({@code GET
     * /projects/{id}/packages/{package_id}/package_files/{package_file_id}/download}).
     *
     * @param id the id
     * @param packageId the package id
     * @param packageFileId the package file id
     * @param filter the optional query parameters
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getPackageFilesDownload(
            final String id,
            final long packageId,
            final long packageFileId,
            final GitLabProjectPackagesGetPackageFilesDownloadFilter filter,
            final Path target)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(target, PARAM_TARGET);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.download(
                get(GET_PACKAGE_FILES_DOWNLOAD, id, packageId, packageFileId).withQuery(queryParameters), target);
    }

    /**
     * Call maven ({@code GET /packages/maven/{path}/{file_name}}).
     *
     * @param path the path
     * @param fileName the file name
     * @throws IllegalArgumentException if {@code path} or {@code fileName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callMaven(final String path, final String fileName) throws IOException {
        requireNotBlank(path, PARAM_PATH);
        requireNotBlank(fileName, PARAM_FILENAME);
        caller.send(get(CALL_MAVEN, path, fileName));
    }

    /**
     * Call helm index yaml ({@code GET /projects/{id}/packages/helm/{channel}/index.yaml}).
     *
     * @param id the id
     * @param channel the channel
     * @throws IllegalArgumentException if {@code id} or {@code channel} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callHelmIndexYaml(final String id, final String channel) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(channel, PARAM_CHANNEL);
        caller.send(get(CALL_HELM_INDEX_YAML, id, channel));
    }

    /**
     * Get helm charts file name tgz ({@code GET /projects/{id}/packages/helm/{channel}/charts/{file_name}.tgz}).
     *
     * @param id the id
     * @param channel the channel
     * @param fileName the file name
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id}, {@code channel} or {@code fileName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getHelmChartsFileNameTgz(
            final String id, final String channel, final String fileName, final OutputStream out) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(channel, PARAM_CHANNEL);
        requireNotBlank(fileName, PARAM_FILENAME);
        requireNonNull(out, PARAM_OUT);
        return caller.download(get(GET_HELM_CHARTS_FILE_NAME_TGZ, id, channel, fileName + ".tgz"), out);
    }

    /**
     * Get helm charts file name tgz ({@code GET /projects/{id}/packages/helm/{channel}/charts/{file_name}.tgz}).
     *
     * @param id the id
     * @param channel the channel
     * @param fileName the file name
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id}, {@code channel} or {@code fileName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getHelmChartsFileNameTgz(
            final String id, final String channel, final String fileName, final Path target) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(channel, PARAM_CHANNEL);
        requireNotBlank(fileName, PARAM_FILENAME);
        requireNonNull(target, PARAM_TARGET);
        return caller.download(get(GET_HELM_CHARTS_FILE_NAME_TGZ, id, channel, fileName + ".tgz"), target);
    }

    /**
     * Authorize helm api chart ({@code POST /projects/{id}/packages/helm/api/{channel}/charts/authorize}).
     *
     * @param id the id
     * @param channel the channel
     * @throws IllegalArgumentException if {@code id} or {@code channel} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void authorizeHelmApiChart(final String id, final String channel) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(channel, PARAM_CHANNEL);
        caller.send(post(AUTHORIZE_HELM_API_CHART, id, channel));
    }

    /**
     * Create helm api chart ({@code POST /projects/{id}/packages/helm/api/{channel}/charts}).
     *
     * @param id the id
     * @param channel the channel
     * @param form the form to send
     * @throws IllegalArgumentException if {@code id} or {@code channel} is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createHelmApiChart(final String id, final String channel, final MultipartFormData form)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(channel, PARAM_CHANNEL);
        requireNonNull(form, PARAM_FORM);
        caller.send(caller.multipart(post(CREATE_HELM_API_CHART, id, channel), form));
    }

    /**
     * Authorize generic ({@code PUT
     * /projects/{id}/packages/generic/{package_name}/{package_version}/{file_name}/authorize}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param fileName the file name
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion} or {@code fileName}
     *     is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void authorizeGeneric(
            final String id,
            final String packageName,
            final String packageVersion,
            final String fileName,
            final GitLabProjectPackagesAuthorizeGenericPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(fileName, PARAM_FILENAME);
        requireNonNull(payload, "payload");
        caller.send(caller.json(put(AUTHORIZE_GENERIC, id, packageName, packageVersion, fileName), payload));
    }

    /**
     * Authorize generic by path ({@code PUT
     * /projects/{id}/packages/generic/{package_name}/{package_version}/{path}/{file_name}/authorize}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param path the path
     * @param fileName the file name
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion}, {@code path} or
     *     {@code fileName} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void authorizeGenericByPath(
            final String id,
            final String packageName,
            final String packageVersion,
            final String path,
            final String fileName,
            final GitLabProjectPackagesAuthorizeGenericByPathPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(path, PARAM_PATH);
        requireNotBlank(fileName, PARAM_FILENAME);
        requireNonNull(payload, "payload");
        caller.send(
                caller.json(put(AUTHORIZE_GENERIC_BY_PATH, id, packageName, packageVersion, path, fileName), payload));
    }

    /**
     * Call generic ({@code GET /projects/{id}/packages/generic/{package_name}/{package_version}/{file_name}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param fileName the file name
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion} or {@code fileName}
     *     is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callGeneric(
            final String id, final String packageName, final String packageVersion, final String fileName)
            throws IOException {
        callGeneric(id, packageName, packageVersion, fileName, GitLabProjectPackagesCallGenericFilter.empty());
    }

    /**
     * Call generic ({@code GET /projects/{id}/packages/generic/{package_name}/{package_version}/{file_name}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param fileName the file name
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion} or {@code fileName}
     *     is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callGeneric(
            final String id,
            final String packageName,
            final String packageVersion,
            final String fileName,
            final GitLabProjectPackagesCallGenericFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(fileName, PARAM_FILENAME);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(get(CALL_GENERIC, id, packageName, packageVersion, fileName).withQuery(queryParameters));
    }

    /**
     * Update generic ({@code PUT /projects/{id}/packages/generic/{package_name}/{package_version}/{file_name}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param fileName the file name
     * @param form the form to send
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion} or {@code fileName}
     *     is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void updateGeneric(
            final String id,
            final String packageName,
            final String packageVersion,
            final String fileName,
            final MultipartFormData form)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(fileName, PARAM_FILENAME);
        requireNonNull(form, PARAM_FORM);
        caller.send(caller.multipart(put(CALL_GENERIC, id, packageName, packageVersion, fileName), form));
    }

    /**
     * Call generic by path ({@code GET
     * /projects/{id}/packages/generic/{package_name}/{package_version}/{path}/{file_name}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param path the path
     * @param fileName the file name
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion}, {@code path} or
     *     {@code fileName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callGenericByPath(
            final String id,
            final String packageName,
            final String packageVersion,
            final String path,
            final String fileName)
            throws IOException {
        callGenericByPath(
                id, packageName, packageVersion, path, fileName, GitLabProjectPackagesCallGenericByPathFilter.empty());
    }

    /**
     * Call generic by path ({@code GET
     * /projects/{id}/packages/generic/{package_name}/{package_version}/{path}/{file_name}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param path the path
     * @param fileName the file name
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion}, {@code path} or
     *     {@code fileName} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callGenericByPath(
            final String id,
            final String packageName,
            final String packageVersion,
            final String path,
            final String fileName,
            final GitLabProjectPackagesCallGenericByPathFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(path, PARAM_PATH);
        requireNotBlank(fileName, PARAM_FILENAME);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(get(CALL_GENERIC_BY_PATH, id, packageName, packageVersion, path, fileName)
                .withQuery(queryParameters));
    }

    /**
     * Update generic by path ({@code PUT
     * /projects/{id}/packages/generic/{package_name}/{package_version}/{path}/{file_name}}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @param path the path
     * @param fileName the file name
     * @param form the form to send
     * @throws IllegalArgumentException if {@code id}, {@code packageName}, {@code packageVersion}, {@code path} or
     *     {@code fileName} is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void updateGenericByPath(
            final String id,
            final String packageName,
            final String packageVersion,
            final String path,
            final String fileName,
            final MultipartFormData form)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNotBlank(path, PARAM_PATH);
        requireNotBlank(fileName, PARAM_FILENAME);
        requireNonNull(form, PARAM_FORM);
        caller.send(caller.multipart(put(CALL_GENERIC_BY_PATH, id, packageName, packageVersion, path, fileName), form));
    }

    /**
     * Call cargo config json ({@code GET /projects/{id}/packages/cargo/config.json}).
     *
     * @param id the id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callCargoConfigJson(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(get(CALL_CARGO_CONFIG_JSON, id));
    }

    /**
     * Get cargo v1 ({@code GET /projects/{id}/packages/cargo/1/{package_name}}).
     *
     * @param id the id
     * @param packageName the package name
     * @return the text of the body
     * @throws IllegalArgumentException if {@code id} or {@code packageName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public String getCargoV1(final String id, final String packageName) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        return fetchText(get(GET_CARGO_V1, id, packageName));
    }

    /**
     * Get cargo v2 ({@code GET /projects/{id}/packages/cargo/2/{package_name}}).
     *
     * @param id the id
     * @param packageName the package name
     * @return the text of the body
     * @throws IllegalArgumentException if {@code id} or {@code packageName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public String getCargoV2(final String id, final String packageName) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        return fetchText(get(GET_CARGO_V2, id, packageName));
    }

    /**
     * Get cargo v3 ({@code GET /projects/{id}/packages/cargo/3/{first_char}/{package_name}}).
     *
     * @param id the id
     * @param firstChar the first char
     * @param packageName the package name
     * @return the text of the body
     * @throws IllegalArgumentException if {@code id}, {@code firstChar} or {@code packageName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public String getCargoV3(final String id, final String firstChar, final String packageName) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(firstChar, "firstChar");
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        return fetchText(get(GET_CARGO_V3, id, firstChar, packageName));
    }

    /**
     * Get cargo ({@code GET /projects/{id}/packages/cargo/{prefix_1}/{prefix_2}/{package_name}}).
     *
     * @param id the id
     * @param prefix1 the prefix 1
     * @param prefix2 the prefix 2
     * @param packageName the package name
     * @return the text of the body
     * @throws IllegalArgumentException if {@code id}, {@code prefix1}, {@code prefix2} or {@code packageName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public String getCargo(final String id, final String prefix1, final String prefix2, final String packageName)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(prefix1, "prefix1");
        requireNotBlank(prefix2, "prefix2");
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        return fetchText(get(GET_CARGO, id, prefix1, prefix2, packageName));
    }

    /**
     * Get cargo download ({@code GET /projects/{id}/packages/cargo/{package_name}/{package_version}/download}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code id}, {@code packageName} or {@code packageVersion} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getCargoDownload(
            final String id, final String packageName, final String packageVersion, final OutputStream out)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNonNull(out, PARAM_OUT);
        return caller.download(get(GET_CARGO_DOWNLOAD, id, packageName, packageVersion), out);
    }

    /**
     * Get cargo download ({@code GET /projects/{id}/packages/cargo/{package_name}/{package_version}/download}).
     *
     * @param id the id
     * @param packageName the package name
     * @param packageVersion the package version
     * @return the file that was written
     * @throws IllegalArgumentException if {@code id}, {@code packageName} or {@code packageVersion} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getCargoDownload(
            final String id, final String packageName, final String packageVersion, final Path target)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(packageName, PARAM_PACKAGENAME);
        requireNotBlank(packageVersion, PARAM_PACKAGEVERSION);
        requireNonNull(target, PARAM_TARGET);
        return caller.download(get(GET_CARGO_DOWNLOAD, id, packageName, packageVersion), target);
    }

    /**
     * New cargo api v1 crate ({@code PUT /projects/{id}/packages/cargo/api/v1/crates/new}).
     *
     * @param id the id
     * @param form the form to send
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void newCargoApiV1Crate(final String id, final MultipartFormData form) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(form, PARAM_FORM);
        caller.send(caller.multipart(put(NEW_CARGO_API_V1_CRATE, id), form));
    }
}

package io.github.piotr_janczukowicz.gitlab.api.terraformmodules;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of project terraform modules. */
public final class GitLabProjectTerraformModulesApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_MODULENAME = "moduleName";
    private static final String PARAM_MODULENAMESPACE = "moduleNamespace";
    private static final String PARAM_MODULESYSTEM = "moduleSystem";
    private static final String PARAM_MODULEVERSION = "moduleVersion";
    private static final PathTemplate CALL =
            PathTemplate.of("/projects/{id}/packages/terraform/modules/{module_name}/{module_system}");
    private static final PathTemplate CALL_BY_MODULE_VERSION =
            PathTemplate.of("/projects/{id}/packages/terraform/modules/{module_name}/{module_system}/{module_version}");
    private static final PathTemplate AUTHORIZE_FILE = PathTemplate.of(
            "/projects/{id}/packages/terraform/modules/{module_name}/{module_system}/{module_version}/file/authorize");
    private static final PathTemplate FILE = PathTemplate.of(
            "/projects/{id}/packages/terraform/modules/{module_name}/{module_system}/{module_version}/file");
    private static final PathTemplate LIST_V1_VERSIONS =
            PathTemplate.of("/packages/terraform/modules/v1/{module_namespace}/{module_name}/{module_system}/versions");
    private static final PathTemplate GET_V1_DOWNLOAD =
            PathTemplate.of("/packages/terraform/modules/v1/{module_namespace}/{module_name}/{module_system}/download");
    private static final PathTemplate GET_V1 =
            PathTemplate.of("/packages/terraform/modules/v1/{module_namespace}/{module_name}/{module_system}");
    private static final PathTemplate CALL_V1_DOWNLOAD = PathTemplate.of(
            "/packages/terraform/modules/v1/{module_namespace}/{module_name}/{module_system}/{module_version}/download");
    private static final PathTemplate GET_V1_FILE = PathTemplate.of(
            "/packages/terraform/modules/v1/{module_namespace}/{module_name}/{module_system}/{module_version}/file");
    private static final PathTemplate GET_V1_BY_MODULE_VERSION = PathTemplate.of(
            "/packages/terraform/modules/v1/{module_namespace}/{module_name}/{module_system}/{module_version}");
    private static final JsonType<List<GitLabTerraformModuleVersions>> TERRAFORM_MODULE_VERSIONS_LIST_TYPE =
            JsonTypes.listOf(GitLabTerraformModuleVersions.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectTerraformModulesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Call ({@code GET /projects/{id}/packages/terraform/modules/{module_name}/{module_system}}).
     *
     * @param id the id
     * @param moduleName the module name
     * @param moduleSystem the module system
     * @throws IllegalArgumentException if {@code id}, {@code moduleName} or {@code moduleSystem} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void call(final String id, final String moduleName, final String moduleSystem) throws IOException {
        call(id, moduleName, moduleSystem, GitLabProjectTerraformModulesCallFilter.empty());
    }

    /**
     * Call ({@code GET /projects/{id}/packages/terraform/modules/{module_name}/{module_system}}).
     *
     * @param id the id
     * @param moduleName the module name
     * @param moduleSystem the module system
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id}, {@code moduleName} or {@code moduleSystem} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void call(
            final String id,
            final String moduleName,
            final String moduleSystem,
            final GitLabProjectTerraformModulesCallFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(moduleName, PARAM_MODULENAME);
        requireNotBlank(moduleSystem, PARAM_MODULESYSTEM);
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(get(CALL, id, moduleName, moduleSystem).withQuery(queryParameters));
    }

    /**
     * Call by module version ({@code GET
     * /projects/{id}/packages/terraform/modules/{module_name}/{module_system}/{module_version}}).
     *
     * @param id the id
     * @param moduleName the module name
     * @param moduleSystem the module system
     * @param moduleVersion the module version
     * @throws IllegalArgumentException if {@code id}, {@code moduleName}, {@code moduleSystem} or {@code moduleVersion}
     *     is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callByModuleVersion(
            final String id, final String moduleName, final String moduleSystem, final String moduleVersion)
            throws IOException {
        callByModuleVersion(
                id,
                moduleName,
                moduleSystem,
                moduleVersion,
                GitLabProjectTerraformModulesCallByModuleVersionFilter.empty());
    }

    /**
     * Call by module version ({@code GET
     * /projects/{id}/packages/terraform/modules/{module_name}/{module_system}/{module_version}}).
     *
     * @param id the id
     * @param moduleName the module name
     * @param moduleSystem the module system
     * @param moduleVersion the module version
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id}, {@code moduleName}, {@code moduleSystem} or {@code moduleVersion}
     *     is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callByModuleVersion(
            final String id,
            final String moduleName,
            final String moduleSystem,
            final String moduleVersion,
            final GitLabProjectTerraformModulesCallByModuleVersionFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(moduleName, PARAM_MODULENAME);
        requireNotBlank(moduleSystem, PARAM_MODULESYSTEM);
        requireNotBlank(moduleVersion, PARAM_MODULEVERSION);
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(get(CALL_BY_MODULE_VERSION, id, moduleName, moduleSystem, moduleVersion)
                .withQuery(queryParameters));
    }

    /**
     * Authorize file ({@code PUT
     * /projects/{id}/packages/terraform/modules/{module_name}/{module_system}/{module_version}/file/authorize}).
     *
     * @param id the id
     * @param moduleName the module name
     * @param moduleSystem the module system
     * @param moduleVersion the module version
     * @throws IllegalArgumentException if {@code id}, {@code moduleName}, {@code moduleSystem} or {@code moduleVersion}
     *     is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void authorizeFile(
            final String id, final String moduleName, final String moduleSystem, final String moduleVersion)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(moduleName, PARAM_MODULENAME);
        requireNotBlank(moduleSystem, PARAM_MODULESYSTEM);
        requireNotBlank(moduleVersion, PARAM_MODULEVERSION);
        caller.send(put(AUTHORIZE_FILE, id, moduleName, moduleSystem, moduleVersion));
    }

    /**
     * File ({@code PUT /projects/{id}/packages/terraform/modules/{module_name}/{module_system}/{module_version}/file}).
     *
     * @param id the id
     * @param moduleName the module name
     * @param moduleSystem the module system
     * @param moduleVersion the module version
     * @param form the form to send
     * @throws IllegalArgumentException if {@code id}, {@code moduleName}, {@code moduleSystem} or {@code moduleVersion}
     *     is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void file(
            final String id,
            final String moduleName,
            final String moduleSystem,
            final String moduleVersion,
            final MultipartFormData form)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(moduleName, PARAM_MODULENAME);
        requireNotBlank(moduleSystem, PARAM_MODULESYSTEM);
        requireNotBlank(moduleVersion, PARAM_MODULEVERSION);
        requireNonNull(form, "form");
        caller.send(caller.multipart(put(FILE, id, moduleName, moduleSystem, moduleVersion), form));
    }

    /**
     * List v1 versions ({@code GET
     * /packages/terraform/modules/v1/{module_namespace}/{module_name}/{module_system}/versions}).
     *
     * @param moduleNamespace the module namespace
     * @param moduleName the module name
     * @param moduleSystem the module system
     * @return the items
     * @throws IllegalArgumentException if {@code moduleNamespace}, {@code moduleName} or {@code moduleSystem} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabTerraformModuleVersions> listV1Versions(
            final String moduleNamespace, final String moduleName, final String moduleSystem) throws IOException {
        requireNotBlank(moduleNamespace, PARAM_MODULENAMESPACE);
        requireNotBlank(moduleName, PARAM_MODULENAME);
        requireNotBlank(moduleSystem, PARAM_MODULESYSTEM);
        return caller.fetch(
                get(LIST_V1_VERSIONS, moduleNamespace, moduleName, moduleSystem), TERRAFORM_MODULE_VERSIONS_LIST_TYPE);
    }

    /**
     * Get v1 download ({@code GET
     * /packages/terraform/modules/v1/{module_namespace}/{module_name}/{module_system}/download}).
     *
     * @param moduleNamespace the module namespace
     * @param moduleName the module name
     * @param moduleSystem the module system
     * @return the location GitLab redirects to
     * @throws IllegalArgumentException if {@code moduleNamespace}, {@code moduleName} or {@code moduleSystem} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public URI getV1Download(final String moduleNamespace, final String moduleName, final String moduleSystem)
            throws IOException {
        requireNotBlank(moduleNamespace, PARAM_MODULENAMESPACE);
        requireNotBlank(moduleName, PARAM_MODULENAME);
        requireNotBlank(moduleSystem, PARAM_MODULESYSTEM);
        return caller.redirectLocation(get(GET_V1_DOWNLOAD, moduleNamespace, moduleName, moduleSystem));
    }

    /**
     * Get v1 ({@code GET /packages/terraform/modules/v1/{module_namespace}/{module_name}/{module_system}}).
     *
     * @param moduleNamespace the module namespace
     * @param moduleName the module name
     * @param moduleSystem the module system
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code moduleNamespace}, {@code moduleName} or {@code moduleSystem} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabTerraformModuleVersion> getV1(
            final String moduleNamespace, final String moduleName, final String moduleSystem) throws IOException {
        requireNotBlank(moduleNamespace, PARAM_MODULENAMESPACE);
        requireNotBlank(moduleName, PARAM_MODULENAME);
        requireNotBlank(moduleSystem, PARAM_MODULESYSTEM);
        return caller.fetchOrEmpty(
                get(GET_V1, moduleNamespace, moduleName, moduleSystem), GitLabTerraformModuleVersion.class);
    }

    /**
     * Call v1 download ({@code GET
     * /packages/terraform/modules/v1/{module_namespace}/{module_name}/{module_system}/{module_version}/download}).
     *
     * @param moduleNamespace the module namespace
     * @param moduleName the module name
     * @param moduleSystem the module system
     * @param moduleVersion the module version
     * @throws IllegalArgumentException if {@code moduleNamespace}, {@code moduleName}, {@code moduleSystem} or
     *     {@code moduleVersion} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callV1Download(
            final String moduleNamespace,
            final String moduleName,
            final String moduleSystem,
            final String moduleVersion)
            throws IOException {
        requireNotBlank(moduleNamespace, PARAM_MODULENAMESPACE);
        requireNotBlank(moduleName, PARAM_MODULENAME);
        requireNotBlank(moduleSystem, PARAM_MODULESYSTEM);
        requireNotBlank(moduleVersion, PARAM_MODULEVERSION);
        caller.send(get(CALL_V1_DOWNLOAD, moduleNamespace, moduleName, moduleSystem, moduleVersion));
    }

    /**
     * Get v1 file ({@code GET
     * /packages/terraform/modules/v1/{module_namespace}/{module_name}/{module_system}/{module_version}/file}).
     *
     * @param moduleNamespace the module namespace
     * @param moduleName the module name
     * @param moduleSystem the module system
     * @param moduleVersion the module version
     * @return the number of bytes written
     * @throws IllegalArgumentException if {@code moduleNamespace}, {@code moduleName}, {@code moduleSystem} or
     *     {@code moduleVersion} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public long getV1File(
            final String moduleNamespace,
            final String moduleName,
            final String moduleSystem,
            final String moduleVersion,
            final OutputStream out)
            throws IOException {
        requireNotBlank(moduleNamespace, PARAM_MODULENAMESPACE);
        requireNotBlank(moduleName, PARAM_MODULENAME);
        requireNotBlank(moduleSystem, PARAM_MODULESYSTEM);
        requireNotBlank(moduleVersion, PARAM_MODULEVERSION);
        requireNonNull(out, "out");
        return caller.download(get(GET_V1_FILE, moduleNamespace, moduleName, moduleSystem, moduleVersion), out);
    }

    /**
     * Get v1 file ({@code GET
     * /packages/terraform/modules/v1/{module_namespace}/{module_name}/{module_system}/{module_version}/file}).
     *
     * @param moduleNamespace the module namespace
     * @param moduleName the module name
     * @param moduleSystem the module system
     * @param moduleVersion the module version
     * @return the file that was written
     * @throws IllegalArgumentException if {@code moduleNamespace}, {@code moduleName}, {@code moduleSystem} or
     *     {@code moduleVersion} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Path getV1File(
            final String moduleNamespace,
            final String moduleName,
            final String moduleSystem,
            final String moduleVersion,
            final Path target)
            throws IOException {
        requireNotBlank(moduleNamespace, PARAM_MODULENAMESPACE);
        requireNotBlank(moduleName, PARAM_MODULENAME);
        requireNotBlank(moduleSystem, PARAM_MODULESYSTEM);
        requireNotBlank(moduleVersion, PARAM_MODULEVERSION);
        requireNonNull(target, "target");
        return caller.download(get(GET_V1_FILE, moduleNamespace, moduleName, moduleSystem, moduleVersion), target);
    }

    /**
     * Get v1 by module version ({@code GET
     * /packages/terraform/modules/v1/{module_namespace}/{module_name}/{module_system}/{module_version}}).
     *
     * @param moduleNamespace the module namespace
     * @param moduleName the module name
     * @param moduleSystem the module system
     * @param moduleVersion the module version
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code moduleNamespace}, {@code moduleName}, {@code moduleSystem} or
     *     {@code moduleVersion} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabTerraformModuleVersion> getV1ByModuleVersion(
            final String moduleNamespace,
            final String moduleName,
            final String moduleSystem,
            final String moduleVersion)
            throws IOException {
        requireNotBlank(moduleNamespace, PARAM_MODULENAMESPACE);
        requireNotBlank(moduleName, PARAM_MODULENAME);
        requireNotBlank(moduleSystem, PARAM_MODULESYSTEM);
        requireNotBlank(moduleVersion, PARAM_MODULEVERSION);
        return caller.fetchOrEmpty(
                get(GET_V1_BY_MODULE_VERSION, moduleNamespace, moduleName, moduleSystem, moduleVersion),
                GitLabTerraformModuleVersion.class);
    }
}

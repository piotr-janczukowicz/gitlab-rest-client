package io.github.piotr_janczukowicz.gitlab.api.goproxy;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.Optional;

/** The GitLab operations of project go proxy. */
public final class GitLabProjectGoProxyApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_MODULENAME = "moduleName";
    private static final String PARAM_MODULEVERSION = "moduleVersion";
    private static final PathTemplate CALL_VLIST = PathTemplate.of("/projects/{id}/packages/go/{module_name}/@v/list");
    private static final PathTemplate GET_VMODULE_VERSION_INFO =
            PathTemplate.of("/projects/{id}/packages/go/{module_name}/@v/{module_version}");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectGoProxyApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Call vlist ({@code GET /projects/{id}/packages/go/{module_name}/@v/list}).
     *
     * @param id the id
     * @param moduleName the module name
     * @throws IllegalArgumentException if {@code id} or {@code moduleName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callVList(final String id, final String moduleName) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(moduleName, PARAM_MODULENAME);
        caller.send(get(CALL_VLIST, id, moduleName));
    }

    /**
     * Get vmodule version info ({@code GET /projects/{id}/packages/go/{module_name}/@v/{module_version}.info}).
     *
     * @param id the id
     * @param moduleName the module name
     * @param moduleVersion the module version
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id}, {@code moduleName} or {@code moduleVersion} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabGoModuleVersion> getVModuleVersionInfo(
            final String id, final String moduleName, final String moduleVersion) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(moduleName, PARAM_MODULENAME);
        requireNotBlank(moduleVersion, PARAM_MODULEVERSION);
        return caller.fetchOrEmpty(
                get(GET_VMODULE_VERSION_INFO, id, moduleName, moduleVersion + ".info"), GitLabGoModuleVersion.class);
    }

    /**
     * Call vmodule version mod ({@code GET /projects/{id}/packages/go/{module_name}/@v/{module_version}.mod}).
     *
     * @param id the id
     * @param moduleName the module name
     * @param moduleVersion the module version
     * @throws IllegalArgumentException if {@code id}, {@code moduleName} or {@code moduleVersion} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callVModuleVersionMod(final String id, final String moduleName, final String moduleVersion)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(moduleName, PARAM_MODULENAME);
        requireNotBlank(moduleVersion, PARAM_MODULEVERSION);
        caller.send(get(GET_VMODULE_VERSION_INFO, id, moduleName, moduleVersion + ".mod"));
    }

    /**
     * Call vmodule version zip ({@code GET /projects/{id}/packages/go/{module_name}/@v/{module_version}.zip}).
     *
     * @param id the id
     * @param moduleName the module name
     * @param moduleVersion the module version
     * @throws IllegalArgumentException if {@code id}, {@code moduleName} or {@code moduleVersion} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callVModuleVersionZip(final String id, final String moduleName, final String moduleVersion)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(moduleName, PARAM_MODULENAME);
        requireNotBlank(moduleVersion, PARAM_MODULEVERSION);
        caller.send(get(GET_VMODULE_VERSION_INFO, id, moduleName, moduleVersion + ".zip"));
    }
}

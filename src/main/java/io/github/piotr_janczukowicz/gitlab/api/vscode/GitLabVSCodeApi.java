package io.github.piotr_janczukowicz.gitlab.api.vscode;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/** The GitLab operations of vscode. */
public final class GitLabVSCodeApi extends GitLabResourceApi {
    private static final String PARAM_RESOURCENAME = "resourceName";
    private static final String PARAM_SETTINGSCONTEXTHASH = "settingsContextHash";
    private static final PathTemplate GET_V1_MANIFEST = PathTemplate.of("/vscode/settings_sync/v1/manifest");
    private static final PathTemplate GET_V1_MANIFEST_BY_SETTINGS_CONTEXT_HASH =
            PathTemplate.of("/vscode/settings_sync/{settings_context_hash}/v1/manifest");
    private static final PathTemplate GET_V1_RESOURCE =
            PathTemplate.of("/vscode/settings_sync/v1/resource/{resource_name}/{id}");
    private static final PathTemplate GET_V1_RESOURCE_BY_SETTINGS_CONTEXT_HASH =
            PathTemplate.of("/vscode/settings_sync/{settings_context_hash}/v1/resource/{resource_name}/{id}");
    private static final PathTemplate LIST_V1_RESOURCE =
            PathTemplate.of("/vscode/settings_sync/v1/resource/{resource_name}");
    private static final PathTemplate LIST_V1_RESOURCE_BY_SETTINGS_CONTEXT_HAS =
            PathTemplate.of("/vscode/settings_sync/{settings_context_hash}/v1/resource/{resource_name}");
    private static final PathTemplate DELETE_V1_COLLECTION = PathTemplate.of("/vscode/settings_sync/v1/collection");
    private static final PathTemplate DELETE_V1_COLLECTION_BY_SETTINGS_CONTEXT =
            PathTemplate.of("/vscode/settings_sync/{settings_context_hash}/v1/collection");
    private static final JsonType<List<GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReference>>
            APIVS_CODE_SETTINGS_ENTITIES_VS_CODE_SETTING_REFERENCE_LIST_TYPE =
                    JsonTypes.listOf(GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReference.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabVSCodeApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get v1 manifest ({@code GET /vscode/settings_sync/v1/manifest}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabAPIVsCodeSettingsEntitiesVsCodeManifest getV1Manifest() throws IOException {
        return caller.fetch(get(GET_V1_MANIFEST), GitLabAPIVsCodeSettingsEntitiesVsCodeManifest.class);
    }

    /**
     * Get v1 manifest by settings context hash ({@code GET /vscode/settings_sync/{settings_context_hash}/v1/manifest}).
     *
     * @param settingsContextHash the settings context hash
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code settingsContextHash} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabAPIVsCodeSettingsEntitiesVsCodeManifest> getV1ManifestBySettingsContextHash(
            final String settingsContextHash) throws IOException {
        requireNotBlank(settingsContextHash, PARAM_SETTINGSCONTEXTHASH);
        return caller.fetchOrEmpty(
                get(GET_V1_MANIFEST_BY_SETTINGS_CONTEXT_HASH, settingsContextHash),
                GitLabAPIVsCodeSettingsEntitiesVsCodeManifest.class);
    }

    /**
     * Get v1 resource ({@code GET /vscode/settings_sync/v1/resource/{resource_name}/{id}}).
     *
     * @param resourceName the resource name
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code resourceName} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabAPIVsCodeSettingsEntitiesVsCodeSetting> getV1Resource(
            final GitLabVSCodeGetV1ResourceName resourceName, final String id) throws IOException {
        requireNonNull(resourceName, PARAM_RESOURCENAME);
        requireNotBlank(id, "id");
        return caller.fetchOrEmpty(
                get(GET_V1_RESOURCE, resourceName.wireValue(), id), GitLabAPIVsCodeSettingsEntitiesVsCodeSetting.class);
    }

    /**
     * Get v1 resource by settings context hash ({@code GET
     * /vscode/settings_sync/{settings_context_hash}/v1/resource/{resource_name}/{id}}).
     *
     * @param settingsContextHash the settings context hash
     * @param resourceName the resource name
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code settingsContextHash} or {@code id} is blank
     * @throws NullPointerException if {@code resourceName} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabAPIVsCodeSettingsEntitiesVsCodeSetting> getV1ResourceBySettingsContextHash(
            final String settingsContextHash,
            final GitLabVSCodeGetV1ResourceBySettingsContextHashResourceName resourceName,
            final String id)
            throws IOException {
        requireNotBlank(settingsContextHash, PARAM_SETTINGSCONTEXTHASH);
        requireNonNull(resourceName, PARAM_RESOURCENAME);
        requireNotBlank(id, "id");
        return caller.fetchOrEmpty(
                get(GET_V1_RESOURCE_BY_SETTINGS_CONTEXT_HASH, settingsContextHash, resourceName.wireValue(), id),
                GitLabAPIVsCodeSettingsEntitiesVsCodeSetting.class);
    }

    /**
     * List v1 resource ({@code GET /vscode/settings_sync/v1/resource/{resource_name}}).
     *
     * @param resourceName the resource name
     * @return the items
     * @throws NullPointerException if {@code resourceName} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReference> listV1Resource(
            final GitLabVSCodeListV1ResourceName resourceName) throws IOException {
        requireNonNull(resourceName, PARAM_RESOURCENAME);
        return caller.fetch(
                get(LIST_V1_RESOURCE, resourceName.wireValue()),
                APIVS_CODE_SETTINGS_ENTITIES_VS_CODE_SETTING_REFERENCE_LIST_TYPE);
    }

    /**
     * Create v1 resource ({@code POST /vscode/settings_sync/v1/resource/{resource_name}}).
     *
     * @param resourceName the resource name
     * @throws NullPointerException if {@code resourceName} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createV1Resource(final GitLabVSCodeCreateV1ResourceName resourceName) throws IOException {
        requireNonNull(resourceName, PARAM_RESOURCENAME);
        caller.send(post(LIST_V1_RESOURCE, resourceName.wireValue()));
    }

    /**
     * List v1 resource by settings context hash ({@code GET
     * /vscode/settings_sync/{settings_context_hash}/v1/resource/{resource_name}}).
     *
     * @param settingsContextHash the settings context hash
     * @param resourceName the resource name
     * @return the items
     * @throws IllegalArgumentException if {@code settingsContextHash} is blank
     * @throws NullPointerException if {@code resourceName} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReference> listV1ResourceBySettingsContextHash(
            final String settingsContextHash,
            final GitLabVSCodeListV1ResourceBySettingsContextHashResourceName resourceName)
            throws IOException {
        requireNotBlank(settingsContextHash, PARAM_SETTINGSCONTEXTHASH);
        requireNonNull(resourceName, PARAM_RESOURCENAME);
        return caller.fetch(
                get(LIST_V1_RESOURCE_BY_SETTINGS_CONTEXT_HAS, settingsContextHash, resourceName.wireValue()),
                APIVS_CODE_SETTINGS_ENTITIES_VS_CODE_SETTING_REFERENCE_LIST_TYPE);
    }

    /**
     * Create v1 resource by settings context hash ({@code POST
     * /vscode/settings_sync/{settings_context_hash}/v1/resource/{resource_name}}).
     *
     * @param settingsContextHash the settings context hash
     * @param resourceName the resource name
     * @throws IllegalArgumentException if {@code settingsContextHash} is blank
     * @throws NullPointerException if {@code resourceName} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createV1ResourceBySettingsContextHash(
            final String settingsContextHash,
            final GitLabVSCodeCreateV1ResourceBySettingsContextHashResourceName resourceName)
            throws IOException {
        requireNotBlank(settingsContextHash, PARAM_SETTINGSCONTEXTHASH);
        requireNonNull(resourceName, PARAM_RESOURCENAME);
        caller.send(post(LIST_V1_RESOURCE_BY_SETTINGS_CONTEXT_HAS, settingsContextHash, resourceName.wireValue()));
    }

    /**
     * Delete v1 collection ({@code DELETE /vscode/settings_sync/v1/collection}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteV1Collection() throws IOException {
        caller.send(delete(DELETE_V1_COLLECTION));
    }

    /**
     * Delete v1 collection by settings context hash ({@code DELETE
     * /vscode/settings_sync/{settings_context_hash}/v1/collection}).
     *
     * @param settingsContextHash the settings context hash
     * @throws IllegalArgumentException if {@code settingsContextHash} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteV1CollectionBySettingsContextHash(final String settingsContextHash) throws IOException {
        requireNotBlank(settingsContextHash, PARAM_SETTINGSCONTEXTHASH);
        caller.send(delete(DELETE_V1_COLLECTION_BY_SETTINGS_CONTEXT, settingsContextHash));
    }
}

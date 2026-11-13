package io.github.piotr_janczukowicz.gitlab.api.vscode;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabVSCodeApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabVSCodeApi api() {
        return new GitLabVSCodeApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabVSCodeApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void getV1Manifest_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabAPIVsCodeSettingsEntitiesVsCodeManifest.class,
                                "a-p-i-vs-code-settings-entities-vs-code-manifest.json")));

        final GitLabAPIVsCodeSettingsEntitiesVsCodeManifest result = api().getV1Manifest();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(VscodeCatalogFixtures.apivsCodeSettingsEntitiesVsCodeManifest());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/vscode/settings_sync/v1/manifest");
        });
    }

    @Test
    void getV1Manifest_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getV1Manifest());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getV1ManifestBySettingsContextHash_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabAPIVsCodeSettingsEntitiesVsCodeManifest.class,
                                "a-p-i-vs-code-settings-entities-vs-code-manifest.json")));

        final Optional<GitLabAPIVsCodeSettingsEntitiesVsCodeManifest> result =
                api().getV1ManifestBySettingsContextHash("settings_context_hash");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(VscodeCatalogFixtures.apivsCodeSettingsEntitiesVsCodeManifest());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/vscode/settings_sync/settings_context_hash/v1/manifest");
        });
    }

    @Test
    void getV1ManifestBySettingsContextHash_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabAPIVsCodeSettingsEntitiesVsCodeManifest> result =
                api().getV1ManifestBySettingsContextHash("settings_context_hash");

        assertThat(result).isEmpty();
    }

    @Test
    void getV1Resource_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabAPIVsCodeSettingsEntitiesVsCodeSetting.class,
                                "a-p-i-vs-code-settings-entities-vs-code-setting.json")));

        final Optional<GitLabAPIVsCodeSettingsEntitiesVsCodeSetting> result =
                api().getV1Resource(GitLabVSCodeGetV1ResourceName.SETTINGS, "group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(VscodeCatalogFixtures.apivsCodeSettingsEntitiesVsCodeSetting());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/vscode/settings_sync/v1/resource/settings/group%2Fsub%2Fproject");
        });
    }

    @Test
    void getV1Resource_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabAPIVsCodeSettingsEntitiesVsCodeSetting> result =
                api().getV1Resource(GitLabVSCodeGetV1ResourceName.SETTINGS, "group/sub/project");

        assertThat(result).isEmpty();
    }

    @Test
    void getV1ResourceBySettingsContextHash_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabAPIVsCodeSettingsEntitiesVsCodeSetting.class,
                                "a-p-i-vs-code-settings-entities-vs-code-setting.json")));

        final Optional<GitLabAPIVsCodeSettingsEntitiesVsCodeSetting> result = api().getV1ResourceBySettingsContextHash(
                        "settings_context_hash",
                        GitLabVSCodeGetV1ResourceBySettingsContextHashResourceName.SETTINGS,
                        "group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(VscodeCatalogFixtures.apivsCodeSettingsEntitiesVsCodeSetting());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/vscode/settings_sync/settings_context_hash/v1/resource/settings/group%2Fsub%2Fproject");
        });
    }

    @Test
    void getV1ResourceBySettingsContextHash_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabAPIVsCodeSettingsEntitiesVsCodeSetting> result = api().getV1ResourceBySettingsContextHash(
                        "settings_context_hash",
                        GitLabVSCodeGetV1ResourceBySettingsContextHashResourceName.SETTINGS,
                        "group/sub/project");

        assertThat(result).isEmpty();
    }

    @Test
    void listV1Resource_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReference.class,
                                        "a-p-i-vs-code-settings-entities-vs-code-setting-reference.json")
                                + "]"));

        final List<GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReference> result =
                api().listV1Resource(GitLabVSCodeListV1ResourceName.SETTINGS);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .containsExactly(VscodeCatalogFixtures.apivsCodeSettingsEntitiesVsCodeSettingReference());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/vscode/settings_sync/v1/resource/settings");
        });
    }

    @Test
    void createV1Resource_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createV1Resource(GitLabVSCodeCreateV1ResourceName.SETTINGS);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("POST /api/v4/vscode/settings_sync/v1/resource/settings");
    }

    @Test
    void createV1Resource_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().createV1Resource(GitLabVSCodeCreateV1ResourceName.SETTINGS));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listV1ResourceBySettingsContextHash_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReference.class,
                                        "a-p-i-vs-code-settings-entities-vs-code-setting-reference.json")
                                + "]"));

        final List<GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReference> result =
                api().listV1ResourceBySettingsContextHash(
                                "settings_context_hash",
                                GitLabVSCodeListV1ResourceBySettingsContextHashResourceName.SETTINGS);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .containsExactly(VscodeCatalogFixtures.apivsCodeSettingsEntitiesVsCodeSettingReference());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/vscode/settings_sync/settings_context_hash/v1/resource/settings");
        });
    }

    @Test
    void createV1ResourceBySettingsContextHash_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createV1ResourceBySettingsContextHash(
                        "settings_context_hash",
                        GitLabVSCodeCreateV1ResourceBySettingsContextHashResourceName.SETTINGS);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("POST /api/v4/vscode/settings_sync/settings_context_hash/v1/resource/settings");
    }

    @Test
    void createV1ResourceBySettingsContextHash_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createV1ResourceBySettingsContextHash(
                        "settings_context_hash",
                        GitLabVSCodeCreateV1ResourceBySettingsContextHashResourceName.SETTINGS));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteV1Collection_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteV1Collection();

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/vscode/settings_sync/v1/collection");
    }

    @Test
    void deleteV1Collection_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteV1Collection());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteV1CollectionBySettingsContextHash_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteV1CollectionBySettingsContextHash("settings_context_hash");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/vscode/settings_sync/settings_context_hash/v1/collection");
    }

    @Test
    void deleteV1CollectionBySettingsContextHash_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().deleteV1CollectionBySettingsContextHash("settings_context_hash"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}

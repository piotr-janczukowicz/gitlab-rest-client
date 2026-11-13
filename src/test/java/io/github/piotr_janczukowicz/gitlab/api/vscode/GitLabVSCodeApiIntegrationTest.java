package io.github.piotr_janczukowicz.gitlab.api.vscode;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabVSCodeApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void getV1Manifest_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/vscode/settings_sync/v1/manifest",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabAPIVsCodeSettingsEntitiesVsCodeManifest.class,
                        "a-p-i-vs-code-settings-entities-vs-code-manifest.json")));

        final GitLabAPIVsCodeSettingsEntitiesVsCodeManifest result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabVSCodeApi(GitLabCaller.of(client)).getV1Manifest();
        }

        assertThat(result).isEqualTo(VscodeCatalogFixtures.apivsCodeSettingsEntitiesVsCodeManifest());
        HTTP.verifyRequested(GET, "/api/v4/vscode/settings_sync/v1/manifest");
    }

    @Test
    void getV1Manifest_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/vscode/settings_sync/v1/manifest", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabVSCodeApi api = new GitLabVSCodeApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getV1Manifest());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/vscode/settings_sync/v1/manifest");
    }

    @Test
    void getV1ManifestBySettingsContextHash_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/vscode/settings_sync/settings_context_hash/v1/manifest",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabAPIVsCodeSettingsEntitiesVsCodeManifest.class,
                        "a-p-i-vs-code-settings-entities-vs-code-manifest.json")));

        final Optional<GitLabAPIVsCodeSettingsEntitiesVsCodeManifest> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabVSCodeApi(GitLabCaller.of(client))
                    .getV1ManifestBySettingsContextHash("settings_context_hash");
        }

        assertThat(result).contains(VscodeCatalogFixtures.apivsCodeSettingsEntitiesVsCodeManifest());
        HTTP.verifyRequested(GET, "/api/v4/vscode/settings_sync/settings_context_hash/v1/manifest");
    }

    @Test
    void getV1ManifestBySettingsContextHash_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET, "/api/v4/vscode/settings_sync/settings_context_hash/v1/manifest", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabVSCodeApi(GitLabCaller.of(client))
                    .getV1ManifestBySettingsContextHash("settings_context_hash")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/vscode/settings_sync/settings_context_hash/v1/manifest");
    }

    @Test
    void getV1Resource_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/vscode/settings_sync/v1/resource/settings/group%2Fsub%2Fproject",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabAPIVsCodeSettingsEntitiesVsCodeSetting.class,
                        "a-p-i-vs-code-settings-entities-vs-code-setting.json")));

        final Optional<GitLabAPIVsCodeSettingsEntitiesVsCodeSetting> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabVSCodeApi(GitLabCaller.of(client))
                    .getV1Resource(GitLabVSCodeGetV1ResourceName.SETTINGS, "group/sub/project");
        }

        assertThat(result).contains(VscodeCatalogFixtures.apivsCodeSettingsEntitiesVsCodeSetting());
        HTTP.verifyRequested(GET, "/api/v4/vscode/settings_sync/v1/resource/settings/group%2Fsub%2Fproject");
    }

    @Test
    void getV1Resource_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/vscode/settings_sync/v1/resource/settings/group%2Fsub%2Fproject",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabVSCodeApi(GitLabCaller.of(client))
                    .getV1Resource(GitLabVSCodeGetV1ResourceName.SETTINGS, "group/sub/project")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/vscode/settings_sync/v1/resource/settings/group%2Fsub%2Fproject");
    }

    @Test
    void getV1ResourceBySettingsContextHash_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/vscode/settings_sync/settings_context_hash/v1/resource/settings/group%2Fsub%2Fproject",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabAPIVsCodeSettingsEntitiesVsCodeSetting.class,
                        "a-p-i-vs-code-settings-entities-vs-code-setting.json")));

        final Optional<GitLabAPIVsCodeSettingsEntitiesVsCodeSetting> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabVSCodeApi(GitLabCaller.of(client))
                    .getV1ResourceBySettingsContextHash(
                            "settings_context_hash",
                            GitLabVSCodeGetV1ResourceBySettingsContextHashResourceName.SETTINGS,
                            "group/sub/project");
        }

        assertThat(result).contains(VscodeCatalogFixtures.apivsCodeSettingsEntitiesVsCodeSetting());
        HTTP.verifyRequested(
                GET, "/api/v4/vscode/settings_sync/settings_context_hash/v1/resource/settings/group%2Fsub%2Fproject");
    }

    @Test
    void getV1ResourceBySettingsContextHash_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/vscode/settings_sync/settings_context_hash/v1/resource/settings/group%2Fsub%2Fproject",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabVSCodeApi(GitLabCaller.of(client))
                    .getV1ResourceBySettingsContextHash(
                            "settings_context_hash",
                            GitLabVSCodeGetV1ResourceBySettingsContextHashResourceName.SETTINGS,
                            "group/sub/project")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET, "/api/v4/vscode/settings_sync/settings_context_hash/v1/resource/settings/group%2Fsub%2Fproject");
    }

    @Test
    void listV1Resource_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/vscode/settings_sync/v1/resource/settings",
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(
                                GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReference.class,
                                "a-p-i-vs-code-settings-entities-vs-code-setting-reference.json")
                        + "]"));

        final List<GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReference> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabVSCodeApi(GitLabCaller.of(client))
                    .listV1Resource(GitLabVSCodeListV1ResourceName.SETTINGS);
        }

        assertThat(result).containsExactly(VscodeCatalogFixtures.apivsCodeSettingsEntitiesVsCodeSettingReference());
        HTTP.verifyRequested(GET, "/api/v4/vscode/settings_sync/v1/resource/settings");
    }

    @Test
    void createV1Resource_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/vscode/settings_sync/v1/resource/settings", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabVSCodeApi(GitLabCaller.of(client)).createV1Resource(GitLabVSCodeCreateV1ResourceName.SETTINGS);
        }

        HTTP.verifyRequested(POST, "/api/v4/vscode/settings_sync/v1/resource/settings");
    }

    @Test
    void createV1Resource_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/vscode/settings_sync/v1/resource/settings", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabVSCodeApi api = new GitLabVSCodeApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createV1Resource(GitLabVSCodeCreateV1ResourceName.SETTINGS));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/vscode/settings_sync/v1/resource/settings");
    }

    @Test
    void listV1ResourceBySettingsContextHash_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/vscode/settings_sync/settings_context_hash/v1/resource/settings",
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(
                                GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReference.class,
                                "a-p-i-vs-code-settings-entities-vs-code-setting-reference.json")
                        + "]"));

        final List<GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReference> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabVSCodeApi(GitLabCaller.of(client))
                    .listV1ResourceBySettingsContextHash(
                            "settings_context_hash",
                            GitLabVSCodeListV1ResourceBySettingsContextHashResourceName.SETTINGS);
        }

        assertThat(result).containsExactly(VscodeCatalogFixtures.apivsCodeSettingsEntitiesVsCodeSettingReference());
        HTTP.verifyRequested(GET, "/api/v4/vscode/settings_sync/settings_context_hash/v1/resource/settings");
    }

    @Test
    void createV1ResourceBySettingsContextHash_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/vscode/settings_sync/settings_context_hash/v1/resource/settings",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabVSCodeApi(GitLabCaller.of(client))
                    .createV1ResourceBySettingsContextHash(
                            "settings_context_hash",
                            GitLabVSCodeCreateV1ResourceBySettingsContextHashResourceName.SETTINGS);
        }

        HTTP.verifyRequested(POST, "/api/v4/vscode/settings_sync/settings_context_hash/v1/resource/settings");
    }

    @Test
    void createV1ResourceBySettingsContextHash_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/vscode/settings_sync/settings_context_hash/v1/resource/settings",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabVSCodeApi api = new GitLabVSCodeApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createV1ResourceBySettingsContextHash(
                    "settings_context_hash", GitLabVSCodeCreateV1ResourceBySettingsContextHashResourceName.SETTINGS));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/vscode/settings_sync/settings_context_hash/v1/resource/settings");
    }

    @Test
    void deleteV1Collection_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/vscode/settings_sync/v1/collection", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabVSCodeApi(GitLabCaller.of(client)).deleteV1Collection();
        }

        HTTP.verifyRequested(DELETE, "/api/v4/vscode/settings_sync/v1/collection");
    }

    @Test
    void deleteV1Collection_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/vscode/settings_sync/v1/collection", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabVSCodeApi api = new GitLabVSCodeApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteV1Collection());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/vscode/settings_sync/v1/collection");
    }

    @Test
    void deleteV1CollectionBySettingsContextHash_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/vscode/settings_sync/settings_context_hash/v1/collection",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabVSCodeApi(GitLabCaller.of(client))
                    .deleteV1CollectionBySettingsContextHash("settings_context_hash");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/vscode/settings_sync/settings_context_hash/v1/collection");
    }

    @Test
    void deleteV1CollectionBySettingsContextHash_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/vscode/settings_sync/settings_context_hash/v1/collection",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabVSCodeApi api = new GitLabVSCodeApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteV1CollectionBySettingsContextHash("settings_context_hash"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/vscode/settings_sync/settings_context_hash/v1/collection");
    }
}

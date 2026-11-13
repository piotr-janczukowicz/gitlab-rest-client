package io.github.piotr_janczukowicz.gitlab.api.settings;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabSettingsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/application/settings",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabApplicationSetting.class, "application-setting.json")));

        final GitLabApplicationSetting result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabSettingsApi(GitLabCaller.of(client)).get();
        }

        assertThat(result).isEqualTo(SettingsCatalogFixtures.applicationSetting());
        HTTP.verifyRequested(GET, "/api/v4/application/settings");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/application/settings", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabSettingsApi api = new GitLabSettingsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.get());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/application/settings");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/application/settings",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabApplicationSetting.class, "application-setting.json")));

        final GitLabApplicationSetting result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabSettingsApi(GitLabCaller.of(client))
                    .update(SettingsCatalogFixtures.settingsUpdatePayload());
        }

        assertThat(result).isEqualTo(SettingsCatalogFixtures.applicationSetting());
        HTTP.verifyRequested(PUT, "/api/v4/application/settings");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/application/settings", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabSettingsApi api = new GitLabSettingsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(SettingsCatalogFixtures.settingsUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/application/settings");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.notificationsettings;

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
class GitLabProjectNotificationSettingsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/notification_settings",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabNotificationSetting.class, "notification-setting.json")));

        final GitLabNotificationSetting result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotificationSettingsApi(GitLabCaller.of(client)).get("group/sub/project");
        }

        assertThat(result).isEqualTo(NotificationsettingsCatalogFixtures.notificationSetting());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/notification_settings");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/notification_settings", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNotificationSettingsApi api =
                    new GitLabProjectNotificationSettingsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.get("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/notification_settings");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/notification_settings",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabNotificationSetting.class, "notification-setting.json")));

        final GitLabNotificationSetting result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNotificationSettingsApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload());
        }

        assertThat(result).isEqualTo(NotificationsettingsCatalogFixtures.notificationSetting());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/notification_settings");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/notification_settings", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNotificationSettingsApi api =
                    new GitLabProjectNotificationSettingsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project",
                    NotificationsettingsCatalogFixtures.projectNotificationSettingsUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/notification_settings");
    }
}

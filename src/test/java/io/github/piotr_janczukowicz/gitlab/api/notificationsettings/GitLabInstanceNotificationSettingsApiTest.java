package io.github.piotr_janczukowicz.gitlab.api.notificationsettings;

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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceNotificationSettingsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabInstanceNotificationSettingsApi api() {
        return new GitLabInstanceNotificationSettingsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabInstanceNotificationSettingsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabGlobalNotificationSetting.class, "global-notification-setting.json")));

        final GitLabGlobalNotificationSetting result = api().get();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(NotificationsettingsCatalogFixtures.globalNotificationSetting());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/notification_settings");
        });
    }

    @Test
    void get_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().get());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabGlobalNotificationSetting.class, "global-notification-setting.json")));

        final GitLabGlobalNotificationSetting result =
                api().update(NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(NotificationsettingsCatalogFixtures.globalNotificationSetting());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("PUT /api/v4/notification_settings");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"level\":");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().update(NotificationsettingsCatalogFixtures.instanceNotificationSettingsUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}

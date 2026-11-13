package io.github.piotr_janczukowicz.gitlab.api.projectsecuritysettings;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectSecuritySettingsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectProjectSecuritySettingsApi api() {
        return new GitLabProjectProjectSecuritySettingsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectProjectSecuritySettingsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void call_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectSecuritySettingsApi lowTier =
                new GitLabProjectProjectSecuritySettingsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.call("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void call_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectSecuritySettingsApi lowTier =
                new GitLabProjectProjectSecuritySettingsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.call("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void call_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().call("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/security_settings");
    }

    @Test
    void call_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().call("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void update_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectSecuritySettingsApi lowTier =
                new GitLabProjectProjectSecuritySettingsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.update(
                "group/sub/project",
                ProjectsecuritysettingsCatalogFixtures.projectProjectSecuritySettingsUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void update_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectProjectSecuritySettingsApi lowTier =
                new GitLabProjectProjectSecuritySettingsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.update(
                "group/sub/project",
                ProjectsecuritysettingsCatalogFixtures.projectProjectSecuritySettingsUpdatePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void update_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().update(
                        "group/sub/project",
                        ProjectsecuritysettingsCatalogFixtures.projectProjectSecuritySettingsUpdatePayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/security_settings");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"secret_push_protection_enabled\":");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().update(
                        "group/sub/project",
                        ProjectsecuritysettingsCatalogFixtures.projectProjectSecuritySettingsUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}

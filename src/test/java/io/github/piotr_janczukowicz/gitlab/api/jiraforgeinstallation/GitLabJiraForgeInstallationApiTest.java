package io.github.piotr_janczukowicz.gitlab.api.jiraforgeinstallation;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBasicSuccess;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabJiraForgeInstallationApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabJiraForgeInstallationApi api() {
        return new GitLabJiraForgeInstallationApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabJiraForgeInstallationApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void updateInstallation_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabBasicSuccess.class, "basic-success.json")));

        final GitLabBasicSuccess result = api().updateInstallation(
                        JiraforgeinstallationCatalogFixtures.jiraForgeInstallationUpdateInstallationPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.basicSuccess());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/integrations/jira_forge/installation");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"instance_url\":");
        });
    }

    @Test
    void updateInstallation_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateInstallation(
                        JiraforgeinstallationCatalogFixtures.jiraForgeInstallationUpdateInstallationPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteInstallation_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabBasicSuccess.class, "basic-success.json")));

        final Optional<GitLabBasicSuccess> result = api().deleteInstallation();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.basicSuccess());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("DELETE /api/v4/integrations/jira_forge/installation");
        });
    }

    @Test
    void deleteInstallation_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteInstallation());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteInstallation_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        final Optional<GitLabBasicSuccess> result = api().deleteInstallation();

        assertThat(result).isEmpty();
    }

    @Test
    void forgeTokenInstallation_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabBasicSuccess.class, "basic-success.json")));

        final GitLabBasicSuccess result = api().forgeTokenInstallation();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.basicSuccess());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/integrations/jira_forge/installation/forge_token");
        });
    }

    @Test
    void forgeTokenInstallation_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().forgeTokenInstallation());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}

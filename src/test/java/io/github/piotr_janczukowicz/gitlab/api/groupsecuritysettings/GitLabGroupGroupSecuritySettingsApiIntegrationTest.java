package io.github.piotr_janczukowicz.gitlab.api.groupsecuritysettings;

import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabGroupGroupSecuritySettingsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void update_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/security_settings", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupSecuritySettingsApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            GroupsecuritysettingsCatalogFixtures.groupGroupSecuritySettingsUpdatePayload());
        }

        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/security_settings");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/security_settings", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupSecuritySettingsApi api =
                    new GitLabGroupGroupSecuritySettingsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project",
                    GroupsecuritysettingsCatalogFixtures.groupGroupSecuritySettingsUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/security_settings");
    }
}

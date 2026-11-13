package io.github.piotr_janczukowicz.gitlab.api.jiraforgeuserdelegation;

import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBasicSuccess;
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
class GitLabJiraForgeUserDelegationApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void userDelegation_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/integrations/jira_forge/user_delegation",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabBasicSuccess.class, "basic-success.json")));

        final GitLabBasicSuccess result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabJiraForgeUserDelegationApi(GitLabCaller.of(client))
                    .userDelegation(
                            JiraforgeuserdelegationCatalogFixtures.jiraForgeUserDelegationUserDelegationPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.basicSuccess());
        HTTP.verifyRequested(POST, "/api/v4/integrations/jira_forge/user_delegation");
    }

    @Test
    void userDelegation_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/integrations/jira_forge/user_delegation", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabJiraForgeUserDelegationApi api = new GitLabJiraForgeUserDelegationApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.userDelegation(
                    JiraforgeuserdelegationCatalogFixtures.jiraForgeUserDelegationUserDelegationPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/integrations/jira_forge/user_delegation");
    }
}

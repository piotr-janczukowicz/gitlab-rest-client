package io.github.piotr_janczukowicz.gitlab.api.jiraconnectsubscriptions;

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
class GitLabJiraConnectSubscriptionsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void createSubscription_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/integrations/jira_connect/subscriptions",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabBasicSuccess.class, "basic-success.json")));

        final GitLabBasicSuccess result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabJiraConnectSubscriptionsApi(GitLabCaller.of(client))
                    .createSubscription(
                            JiraconnectsubscriptionsCatalogFixtures
                                    .jiraConnectSubscriptionsCreateSubscriptionPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.basicSuccess());
        HTTP.verifyRequested(POST, "/api/v4/integrations/jira_connect/subscriptions");
    }

    @Test
    void createSubscription_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/integrations/jira_connect/subscriptions", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabJiraConnectSubscriptionsApi api =
                    new GitLabJiraConnectSubscriptionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createSubscription(
                    JiraconnectsubscriptionsCatalogFixtures.jiraConnectSubscriptionsCreateSubscriptionPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/integrations/jira_connect/subscriptions");
    }
}

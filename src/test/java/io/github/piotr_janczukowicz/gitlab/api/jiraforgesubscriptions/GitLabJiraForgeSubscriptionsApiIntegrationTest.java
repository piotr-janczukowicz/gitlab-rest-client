package io.github.piotr_janczukowicz.gitlab.api.jiraforgesubscriptions;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
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
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabJiraForgeSubscriptionsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void getSubscriptions_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/integrations/jira_forge/subscriptions",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabJiraConnectSubscriptionEntity.class, "jira-connect-subscription-entity.json")));

        final GitLabJiraConnectSubscriptionEntity result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabJiraForgeSubscriptionsApi(GitLabCaller.of(client)).getSubscriptions();
        }

        assertThat(result).isEqualTo(JiraforgesubscriptionsCatalogFixtures.jiraConnectSubscriptionEntity());
        HTTP.verifyRequested(GET, "/api/v4/integrations/jira_forge/subscriptions");
    }

    @Test
    void getSubscriptions_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/integrations/jira_forge/subscriptions", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabJiraForgeSubscriptionsApi api = new GitLabJiraForgeSubscriptionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getSubscriptions());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/integrations/jira_forge/subscriptions");
    }

    @Test
    void createSubscription_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/integrations/jira_forge/subscriptions",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabBasicSuccess.class, "basic-success.json")));

        final GitLabBasicSuccess result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabJiraForgeSubscriptionsApi(GitLabCaller.of(client))
                    .createSubscription(
                            JiraforgesubscriptionsCatalogFixtures.jiraForgeSubscriptionsCreateSubscriptionPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.basicSuccess());
        HTTP.verifyRequested(POST, "/api/v4/integrations/jira_forge/subscriptions");
    }

    @Test
    void createSubscription_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/integrations/jira_forge/subscriptions", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabJiraForgeSubscriptionsApi api = new GitLabJiraForgeSubscriptionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createSubscription(
                    JiraforgesubscriptionsCatalogFixtures.jiraForgeSubscriptionsCreateSubscriptionPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/integrations/jira_forge/subscriptions");
    }

    @Test
    void deleteSubscription_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/integrations/jira_forge/subscriptions/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabBasicSuccess.class, "basic-success.json")));

        final Optional<GitLabBasicSuccess> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabJiraForgeSubscriptionsApi(GitLabCaller.of(client)).deleteSubscription(1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.basicSuccess());
        HTTP.verifyRequested(DELETE, "/api/v4/integrations/jira_forge/subscriptions/1");
    }

    @Test
    void deleteSubscription_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/integrations/jira_forge/subscriptions/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabJiraForgeSubscriptionsApi api = new GitLabJiraForgeSubscriptionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteSubscription(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/integrations/jira_forge/subscriptions/1");
    }

    @Test
    void deleteSubscription_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/integrations/jira_forge/subscriptions/1", GitLabApiStubSupport.noContent());

        final Optional<GitLabBasicSuccess> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabJiraForgeSubscriptionsApi(GitLabCaller.of(client)).deleteSubscription(1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/integrations/jira_forge/subscriptions/1");
    }
}

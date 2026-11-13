package io.github.piotr_janczukowicz.gitlab.api.mobilepushsubscriptions;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabMobilePushSubscriptionsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/user/push_subscriptions",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabMobilePushSubscription.class, "mobile-push-subscription.json")));

        final GitLabMobilePushSubscription result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabMobilePushSubscriptionsApi(GitLabCaller.of(client))
                    .create(MobilepushsubscriptionsCatalogFixtures.mobilePushSubscriptionsCreatePayload());
        }

        assertThat(result).isEqualTo(MobilepushsubscriptionsCatalogFixtures.mobilePushSubscription());
        HTTP.verifyRequested(POST, "/api/v4/user/push_subscriptions");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/user/push_subscriptions", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabMobilePushSubscriptionsApi api = new GitLabMobilePushSubscriptionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.create(MobilepushsubscriptionsCatalogFixtures.mobilePushSubscriptionsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/user/push_subscriptions");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/user/push_subscriptions", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabMobilePushSubscriptionsApi(GitLabCaller.of(client)).delete("device_token");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/user/push_subscriptions");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/user/push_subscriptions", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabMobilePushSubscriptionsApi api = new GitLabMobilePushSubscriptionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("device_token"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/user/push_subscriptions");
    }
}

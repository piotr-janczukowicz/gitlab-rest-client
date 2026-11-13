package io.github.piotr_janczukowicz.gitlab.api.sidekiqqueuesadministration;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
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
class GitLabSidekiqQueuesAdministrationApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/admin/sidekiq/queues/queue_name", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabSidekiqQueuesAdministrationApi(GitLabCaller.of(client)).delete("queue_name");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/admin/sidekiq/queues/queue_name");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/admin/sidekiq/queues/queue_name", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabSidekiqQueuesAdministrationApi api =
                    new GitLabSidekiqQueuesAdministrationApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("queue_name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/admin/sidekiq/queues/queue_name");
    }
}

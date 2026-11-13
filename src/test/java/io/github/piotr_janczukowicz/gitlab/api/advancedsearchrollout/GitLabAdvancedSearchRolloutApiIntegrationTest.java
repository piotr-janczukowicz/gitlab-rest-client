package io.github.piotr_janczukowicz.gitlab.api.advancedsearchrollout;

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
class GitLabAdvancedSearchRolloutApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void updateRollout_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(PUT, "/api/v4/elasticsearch_indexed_namespaces/rollout", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabAdvancedSearchRolloutApi(GitLabCaller.of(client))
                    .updateRollout(AdvancedsearchrolloutCatalogFixtures.advancedSearchRolloutUpdateRolloutPayload());
        }

        HTTP.verifyRequested(PUT, "/api/v4/elasticsearch_indexed_namespaces/rollout");
    }

    @Test
    void updateRollout_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/elasticsearch_indexed_namespaces/rollout", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabAdvancedSearchRolloutApi api = new GitLabAdvancedSearchRolloutApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateRollout(
                    AdvancedsearchrolloutCatalogFixtures.advancedSearchRolloutUpdateRolloutPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/elasticsearch_indexed_namespaces/rollout");
    }

    @Test
    void updateRollback_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(PUT, "/api/v4/elasticsearch_indexed_namespaces/rollback", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabAdvancedSearchRolloutApi(GitLabCaller.of(client))
                    .updateRollback(AdvancedsearchrolloutCatalogFixtures.advancedSearchRolloutUpdateRollbackPayload());
        }

        HTTP.verifyRequested(PUT, "/api/v4/elasticsearch_indexed_namespaces/rollback");
    }

    @Test
    void updateRollback_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/elasticsearch_indexed_namespaces/rollback", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabAdvancedSearchRolloutApi api = new GitLabAdvancedSearchRolloutApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateRollback(
                    AdvancedsearchrolloutCatalogFixtures.advancedSearchRolloutUpdateRollbackPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/elasticsearch_indexed_namespaces/rollback");
    }
}

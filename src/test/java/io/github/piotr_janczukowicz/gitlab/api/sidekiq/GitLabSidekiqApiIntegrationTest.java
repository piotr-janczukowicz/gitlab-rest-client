package io.github.piotr_janczukowicz.gitlab.api.sidekiq;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

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
class GitLabSidekiqApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void getConcurrencyLimit_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/admin/sidekiq/concurrency_limits/worker_class",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabSidekiqConcurrencyLimit.class, "sidekiq-concurrency-limit.json")));

        final Optional<GitLabSidekiqConcurrencyLimit> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabSidekiqApi(GitLabCaller.of(client)).getConcurrencyLimit("worker_class");
        }

        assertThat(result).contains(SidekiqCatalogFixtures.sidekiqConcurrencyLimit());
        HTTP.verifyRequested(GET, "/api/v4/admin/sidekiq/concurrency_limits/worker_class");
    }

    @Test
    void getConcurrencyLimit_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/admin/sidekiq/concurrency_limits/worker_class", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabSidekiqApi(GitLabCaller.of(client))
                    .getConcurrencyLimit("worker_class")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/admin/sidekiq/concurrency_limits/worker_class");
    }

    @Test
    void updateConcurrencyLimit_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/admin/sidekiq/concurrency_limits/worker_class",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabSidekiqConcurrencyLimit.class, "sidekiq-concurrency-limit.json")));

        final GitLabSidekiqConcurrencyLimit result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabSidekiqApi(GitLabCaller.of(client))
                    .updateConcurrencyLimit(
                            "worker_class", SidekiqCatalogFixtures.sidekiqUpdateConcurrencyLimitPayload());
        }

        assertThat(result).isEqualTo(SidekiqCatalogFixtures.sidekiqConcurrencyLimit());
        HTTP.verifyRequested(PUT, "/api/v4/admin/sidekiq/concurrency_limits/worker_class");
    }

    @Test
    void updateConcurrencyLimit_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/admin/sidekiq/concurrency_limits/worker_class", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabSidekiqApi api = new GitLabSidekiqApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateConcurrencyLimit(
                    "worker_class", SidekiqCatalogFixtures.sidekiqUpdateConcurrencyLimitPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/admin/sidekiq/concurrency_limits/worker_class");
    }

    @Test
    void deleteConcurrencyLimit_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/admin/sidekiq/concurrency_limits/worker_class",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabSidekiqConcurrencyLimit.class, "sidekiq-concurrency-limit.json")));

        final Optional<GitLabSidekiqConcurrencyLimit> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabSidekiqApi(GitLabCaller.of(client)).deleteConcurrencyLimit("worker_class");
        }

        assertThat(result).contains(SidekiqCatalogFixtures.sidekiqConcurrencyLimit());
        HTTP.verifyRequested(DELETE, "/api/v4/admin/sidekiq/concurrency_limits/worker_class");
    }

    @Test
    void deleteConcurrencyLimit_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/admin/sidekiq/concurrency_limits/worker_class", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabSidekiqApi api = new GitLabSidekiqApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteConcurrencyLimit("worker_class"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/admin/sidekiq/concurrency_limits/worker_class");
    }

    @Test
    void deleteConcurrencyLimit_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/admin/sidekiq/concurrency_limits/worker_class", GitLabApiStubSupport.noContent());

        final Optional<GitLabSidekiqConcurrencyLimit> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabSidekiqApi(GitLabCaller.of(client)).deleteConcurrencyLimit("worker_class");
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/admin/sidekiq/concurrency_limits/worker_class");
    }
}

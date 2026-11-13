package io.github.piotr_janczukowicz.gitlab.api.sidekiq;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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
class GitLabSidekiqApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabSidekiqApi api() {
        return new GitLabSidekiqApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabSidekiqApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void getConcurrencyLimit_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabSidekiqConcurrencyLimit.class, "sidekiq-concurrency-limit.json")));

        final Optional<GitLabSidekiqConcurrencyLimit> result = api().getConcurrencyLimit("worker_class");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(SidekiqCatalogFixtures.sidekiqConcurrencyLimit());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/admin/sidekiq/concurrency_limits/worker_class");
        });
    }

    @Test
    void getConcurrencyLimit_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabSidekiqConcurrencyLimit> result = api().getConcurrencyLimit("worker_class");

        assertThat(result).isEmpty();
    }

    @Test
    void updateConcurrencyLimit_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabSidekiqConcurrencyLimit.class, "sidekiq-concurrency-limit.json")));

        final GitLabSidekiqConcurrencyLimit result = api().updateConcurrencyLimit(
                        "worker_class", SidekiqCatalogFixtures.sidekiqUpdateConcurrencyLimitPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(SidekiqCatalogFixtures.sidekiqConcurrencyLimit());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/admin/sidekiq/concurrency_limits/worker_class");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"limit\":");
        });
    }

    @Test
    void updateConcurrencyLimit_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateConcurrencyLimit(
                        "worker_class", SidekiqCatalogFixtures.sidekiqUpdateConcurrencyLimitPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteConcurrencyLimit_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabSidekiqConcurrencyLimit.class, "sidekiq-concurrency-limit.json")));

        final Optional<GitLabSidekiqConcurrencyLimit> result = api().deleteConcurrencyLimit("worker_class");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(SidekiqCatalogFixtures.sidekiqConcurrencyLimit());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("DELETE /api/v4/admin/sidekiq/concurrency_limits/worker_class");
        });
    }

    @Test
    void deleteConcurrencyLimit_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteConcurrencyLimit("worker_class"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteConcurrencyLimit_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        final Optional<GitLabSidekiqConcurrencyLimit> result = api().deleteConcurrencyLimit("worker_class");

        assertThat(result).isEmpty();
    }
}

package io.github.piotr_janczukowicz.gitlab.api.advancedsearchrollout;

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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAdvancedSearchRolloutApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabAdvancedSearchRolloutApi api() {
        return new GitLabAdvancedSearchRolloutApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabAdvancedSearchRolloutApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void updateRollout_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().updateRollout(AdvancedsearchrolloutCatalogFixtures.advancedSearchRolloutUpdateRolloutPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/elasticsearch_indexed_namespaces/rollout");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"percentage\":");
        });
    }

    @Test
    void updateRollout_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().updateRollout(AdvancedsearchrolloutCatalogFixtures.advancedSearchRolloutUpdateRolloutPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateRollback_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().updateRollback(AdvancedsearchrolloutCatalogFixtures.advancedSearchRolloutUpdateRollbackPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/elasticsearch_indexed_namespaces/rollback");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"percentage\":");
        });
    }

    @Test
    void updateRollback_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateRollback(
                        AdvancedsearchrolloutCatalogFixtures.advancedSearchRolloutUpdateRollbackPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}

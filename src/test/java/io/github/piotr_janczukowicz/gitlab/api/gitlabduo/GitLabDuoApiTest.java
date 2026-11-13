package io.github.piotr_janczukowicz.gitlab.api.gitlabduo;

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
class GitLabDuoApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabDuoApi api() {
        return new GitLabDuoApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabDuoApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void create_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().create(GitlabduoCatalogFixtures.duoCreatePayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/duo_code_review/evaluations");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"diffs\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().create(GitlabduoCatalogFixtures.duoCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void directAccess_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().directAccess();

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/ai/third_party_agents/direct_access");
    }

    @Test
    void directAccess_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().directAccess());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void gitCommand_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().gitCommand(GitlabduoCatalogFixtures.duoGitCommandPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/ai/llm/git_command");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"prompt\":");
        });
    }

    @Test
    void gitCommand_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().gitCommand(GitlabduoCatalogFixtures.duoGitCommandPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}

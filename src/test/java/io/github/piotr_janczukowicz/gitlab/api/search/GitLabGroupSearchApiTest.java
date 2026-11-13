package io.github.piotr_janczukowicz.gitlab.api.search;

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
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupSearchApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabGroupSearchApi api() {
        return new GitLabGroupSearchApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabGroupSearchApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void call_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().call("group/sub/project", "search", GitLabGroupSearchCallScope.WIKI_BLOBS);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/search");
            softly.assertThat(request.uri()).hasParameter("search", "search");
        });
    }

    @Test
    void call_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().call("group/sub/project", "search", GitLabGroupSearchCallScope.WIKI_BLOBS));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void call_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().call(
                        "group/sub/project",
                        "search",
                        GitLabGroupSearchCallScope.WIKI_BLOBS,
                        GitLabGroupSearchCallFilterBuilder.builder()
                                .state(GitLabGroupSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                                .excludeForks(true)
                                .numContextLines(1)
                                .regex(true)
                                .sourceBranch("source_branch")
                                .targetBranch("target_branch")
                                .authorUsername("author_username")
                                .labelName(List.of("label_name"))
                                .notSourceBranch("not[source_branch]")
                                .notTargetBranch("not[target_branch]")
                                .notAuthorUsername("not[author_username]")
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("state", "all");
    }
}

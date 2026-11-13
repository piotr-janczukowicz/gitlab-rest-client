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
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectSearchApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectSearchApi api() {
        return new GitLabProjectSearchApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectSearchApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void getSemantic_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabAiSemanticCodeResponse.class, "ai-semantic-code-response.json")));

        final GitLabAiSemanticCodeResponse result = api().getSemantic("group/sub/project", "q");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(SearchCatalogFixtures.aiSemanticCodeResponse());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/search/semantic");
            softly.assertThat(request.uri()).hasParameter("q", "q");
        });
    }

    @Test
    void getSemantic_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getSemantic("group/sub/project", "q"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getSemantic_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabAiSemanticCodeResponse.class, "ai-semantic-code-response.json")));

        api().getSemantic(
                        "group/sub/project",
                        "q",
                        GitLabProjectSearchGetSemanticFilterBuilder.builder()
                                .directoryPath("directory_path")
                                .knn(1)
                                .limit(1)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("directory_path", "directory_path");
    }

    @Test
    void call_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().call("group/sub/project", "search", GitLabProjectSearchCallScope.ISSUES);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/search");
            softly.assertThat(request.uri()).hasParameter("search", "search");
        });
    }

    @Test
    void call_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().call("group/sub/project", "search", GitLabProjectSearchCallScope.ISSUES));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void call_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().call(
                        "group/sub/project",
                        "search",
                        GitLabProjectSearchCallScope.ISSUES,
                        GitLabProjectSearchCallFilterBuilder.builder()
                                .ref("ref")
                                .state(GitLabProjectSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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
        assertThat(request.uri()).hasParameter("ref", "ref");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.search;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
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
class GitLabProjectSearchApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void getSemantic_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/search/semantic",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabAiSemanticCodeResponse.class, "ai-semantic-code-response.json")));

        final GitLabAiSemanticCodeResponse result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectSearchApi(GitLabCaller.of(client)).getSemantic("group/sub/project", "q");
        }

        assertThat(result).isEqualTo(SearchCatalogFixtures.aiSemanticCodeResponse());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/search/semantic");
    }

    @Test
    void getSemantic_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/search/semantic", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectSearchApi api = new GitLabProjectSearchApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getSemantic("group/sub/project", "q"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/search/semantic");
    }

    @Test
    void call_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/search", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectSearchApi(GitLabCaller.of(client))
                    .call("group/sub/project", "search", GitLabProjectSearchCallScope.ISSUES);
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/search");
    }

    @Test
    void call_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/search", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectSearchApi api = new GitLabProjectSearchApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.call("group/sub/project", "search", GitLabProjectSearchCallScope.ISSUES));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/search");
    }
}

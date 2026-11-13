package io.github.piotr_janczukowicz.gitlab.api.markdown;

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
class GitLabMarkdownApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/markdown",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMarkdown.class, "markdown.json")));

        final GitLabMarkdown result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabMarkdownApi(GitLabCaller.of(client))
                    .create(MarkdownCatalogFixtures.markdownCreatePayload());
        }

        assertThat(result).isEqualTo(MarkdownCatalogFixtures.markdown());
        HTTP.verifyRequested(POST, "/api/v4/markdown");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/markdown", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabMarkdownApi api = new GitLabMarkdownApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(MarkdownCatalogFixtures.markdownCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/markdown");
    }
}

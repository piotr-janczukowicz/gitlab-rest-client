package io.github.piotr_janczukowicz.gitlab.api.gitlabduo;

import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
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
class GitLabDuoApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void create_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/duo_code_review/evaluations", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabDuoApi(GitLabCaller.of(client)).create(GitlabduoCatalogFixtures.duoCreatePayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/duo_code_review/evaluations");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/duo_code_review/evaluations", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoApi api = new GitLabDuoApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(GitlabduoCatalogFixtures.duoCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/duo_code_review/evaluations");
    }

    @Test
    void directAccess_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/ai/third_party_agents/direct_access", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabDuoApi(GitLabCaller.of(client)).directAccess();
        }

        HTTP.verifyRequested(POST, "/api/v4/ai/third_party_agents/direct_access");
    }

    @Test
    void directAccess_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/ai/third_party_agents/direct_access", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoApi api = new GitLabDuoApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.directAccess());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/ai/third_party_agents/direct_access");
    }

    @Test
    void gitCommand_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/ai/llm/git_command", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabDuoApi(GitLabCaller.of(client)).gitCommand(GitlabduoCatalogFixtures.duoGitCommandPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/ai/llm/git_command");
    }

    @Test
    void gitCommand_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/ai/llm/git_command", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDuoApi api = new GitLabDuoApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.gitCommand(GitlabduoCatalogFixtures.duoGitCommandPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/ai/llm/git_command");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.validategitlabciymlfile;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
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
class GitLabProjectValidateGitlabCiYmlFileApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/ci/lint",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiLintResult.class, "ci-lint-result.json")));

        final GitLabCiLintResult result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectValidateGitlabCiYmlFileApi(GitLabCaller.of(client)).get("group/sub/project");
        }

        assertThat(result).isEqualTo(ValidategitlabciymlfileCatalogFixtures.ciLintResult());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/ci/lint");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/ci/lint", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectValidateGitlabCiYmlFileApi api =
                    new GitLabProjectValidateGitlabCiYmlFileApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.get("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/ci/lint");
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/ci/lint",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiLintResult.class, "ci-lint-result.json")));

        final GitLabCiLintResult result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectValidateGitlabCiYmlFileApi(GitLabCaller.of(client))
                    .create(
                            "group/sub/project",
                            ValidategitlabciymlfileCatalogFixtures.projectValidateGitlabCiYmlFileCreatePayload());
        }

        assertThat(result).isEqualTo(ValidategitlabciymlfileCatalogFixtures.ciLintResult());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/ci/lint");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/ci/lint", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectValidateGitlabCiYmlFileApi api =
                    new GitLabProjectValidateGitlabCiYmlFileApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    "group/sub/project",
                    ValidategitlabciymlfileCatalogFixtures.projectValidateGitlabCiYmlFileCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/ci/lint");
    }
}

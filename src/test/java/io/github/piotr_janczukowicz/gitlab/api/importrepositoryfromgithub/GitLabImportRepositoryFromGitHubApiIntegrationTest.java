package io.github.piotr_janczukowicz.gitlab.api.importrepositoryfromgithub;

import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProjectEntity;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProjectImportEntity;
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
class GitLabImportRepositoryFromGitHubApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/import/github",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProjectEntity.class, "project-entity.json")));

        final GitLabProjectEntity result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabImportRepositoryFromGitHubApi(GitLabCaller.of(client))
                    .create(ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.projectEntity());
        HTTP.verifyRequested(POST, "/api/v4/import/github");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/import/github", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabImportRepositoryFromGitHubApi api =
                    new GitLabImportRepositoryFromGitHubApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.create(ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/import/github");
    }

    @Test
    void cancel_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/import/github/cancel",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabProjectImportEntity.class, "project-import-entity.json")));

        final GitLabProjectImportEntity result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabImportRepositoryFromGitHubApi(GitLabCaller.of(client))
                    .cancel(ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCancelPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.projectImportEntity());
        HTTP.verifyRequested(POST, "/api/v4/import/github/cancel");
    }

    @Test
    void cancel_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/import/github/cancel", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabImportRepositoryFromGitHubApi api =
                    new GitLabImportRepositoryFromGitHubApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.cancel(ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCancelPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/import/github/cancel");
    }

    @Test
    void createGist_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/import/github/gists", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabImportRepositoryFromGitHubApi(GitLabCaller.of(client))
                    .createGist(
                            ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreateGistPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/import/github/gists");
    }

    @Test
    void createGist_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/import/github/gists", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabImportRepositoryFromGitHubApi api =
                    new GitLabImportRepositoryFromGitHubApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createGist(
                    ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreateGistPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/import/github/gists");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.repositorysubmodules;

import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCommitDetail;
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
class GitLabProjectRepositorySubmodulesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/submodules/submodule",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCommitDetail.class, "commit-detail.json")));

        final GitLabCommitDetail result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectRepositorySubmodulesApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            "submodule",
                            RepositorysubmodulesCatalogFixtures.projectRepositorySubmodulesUpdatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.commitDetail());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/repository/submodules/submodule");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/submodules/submodule",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectRepositorySubmodulesApi api =
                    new GitLabProjectRepositorySubmodulesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project",
                    "submodule",
                    RepositorysubmodulesCatalogFixtures.projectRepositorySubmodulesUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/repository/submodules/submodule");
    }
}

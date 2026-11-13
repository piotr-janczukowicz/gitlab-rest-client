package io.github.piotr_janczukowicz.gitlab.api.importrepositoryfrombitbucketserver;

import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProjectEntity;
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
class GitLabImportRepositoryFromBitbucketServerApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/import/bitbucket_server",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProjectEntity.class, "project-entity.json")));

        final GitLabProjectEntity result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabImportRepositoryFromBitbucketServerApi(GitLabCaller.of(client))
                    .create(
                            ImportrepositoryfrombitbucketserverCatalogFixtures
                                    .importRepositoryFromBitbucketServerCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.projectEntity());
        HTTP.verifyRequested(POST, "/api/v4/import/bitbucket_server");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/import/bitbucket_server", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabImportRepositoryFromBitbucketServerApi api =
                    new GitLabImportRepositoryFromBitbucketServerApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    ImportrepositoryfrombitbucketserverCatalogFixtures
                            .importRepositoryFromBitbucketServerCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/import/bitbucket_server");
    }
}

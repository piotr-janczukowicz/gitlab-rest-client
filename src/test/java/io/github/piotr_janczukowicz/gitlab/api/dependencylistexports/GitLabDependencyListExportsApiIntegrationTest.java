package io.github.piotr_janczukowicz.gitlab.api.dependencylistexports;

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
class GitLabDependencyListExportsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void create_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/pipelines/group%2Fsub%2Fproject/dependency_list_exports",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabDependencyListExportsApi(GitLabCaller.of(client))
                    .create(
                            "group/sub/project",
                            DependencylistexportsCatalogFixtures.dependencyListExportsCreatePayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/pipelines/group%2Fsub%2Fproject/dependency_list_exports");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/pipelines/group%2Fsub%2Fproject/dependency_list_exports",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabDependencyListExportsApi api = new GitLabDependencyListExportsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    "group/sub/project", DependencylistexportsCatalogFixtures.dependencyListExportsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/pipelines/group%2Fsub%2Fproject/dependency_list_exports");
    }
}

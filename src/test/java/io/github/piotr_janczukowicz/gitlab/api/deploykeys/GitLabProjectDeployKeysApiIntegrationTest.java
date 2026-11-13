package io.github.piotr_janczukowicz.gitlab.api.deploykeys;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabDeployKey;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectDeployKeysApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/deploy_keys",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabDeployKeysProject.class, "deploy-keys-project.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/deploy_keys?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabDeployKeysProject.class, "deploy-keys-project.json") + "]"));

        final List<GitLabDeployKeysProject> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectDeployKeysApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        DeploykeysCatalogFixtures.deployKeysProject(), DeploykeysCatalogFixtures.deployKeysProject());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/deploy_keys", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/deploy_keys",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabDeployKeysProject.class, "deploy-keys-project.json")));

        final GitLabDeployKeysProject result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDeployKeysApi(GitLabCaller.of(client))
                    .create("group/sub/project", DeploykeysCatalogFixtures.projectDeployKeysCreatePayload());
        }

        assertThat(result).isEqualTo(DeploykeysCatalogFixtures.deployKeysProject());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/deploy_keys");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/deploy_keys", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDeployKeysApi api = new GitLabProjectDeployKeysApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.create("group/sub/project", DeploykeysCatalogFixtures.projectDeployKeysCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/deploy_keys");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/deploy_keys/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabDeployKeysProject.class, "deploy-keys-project.json")));

        final Optional<GitLabDeployKeysProject> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDeployKeysApi(GitLabCaller.of(client)).get("group/sub/project", 1L);
        }

        assertThat(result).contains(DeploykeysCatalogFixtures.deployKeysProject());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/deploy_keys/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/deploy_keys/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectDeployKeysApi(GitLabCaller.of(client))
                    .get("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/deploy_keys/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/deploy_keys/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabDeployKey.class, "deploy-key.json")));

        final GitLabDeployKey result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDeployKeysApi(GitLabCaller.of(client))
                    .update("group/sub/project", 1L, DeploykeysCatalogFixtures.projectDeployKeysUpdatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.deployKey());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/deploy_keys/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/deploy_keys/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDeployKeysApi api = new GitLabProjectDeployKeysApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.update("group/sub/project", 1L, DeploykeysCatalogFixtures.projectDeployKeysUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/deploy_keys/1");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/deploy_keys/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectDeployKeysApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/deploy_keys/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/deploy_keys/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDeployKeysApi api = new GitLabProjectDeployKeysApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/deploy_keys/1");
    }

    @Test
    void enable_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/deploy_keys/1/enable",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabDeployKey.class, "deploy-key.json")));

        final GitLabDeployKey result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectDeployKeysApi(GitLabCaller.of(client)).enable("group/sub/project", 1L);
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.deployKey());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/deploy_keys/1/enable");
    }

    @Test
    void enable_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/deploy_keys/1/enable", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectDeployKeysApi api = new GitLabProjectDeployKeysApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.enable("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/deploy_keys/1/enable");
    }
}

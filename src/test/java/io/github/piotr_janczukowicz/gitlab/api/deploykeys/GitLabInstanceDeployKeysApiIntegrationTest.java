package io.github.piotr_janczukowicz.gitlab.api.deploykeys;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabInstanceDeployKeysApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/deploy_keys",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabDeployKey.class, "deploy-key.json") + "]")
                        .header("Link", "<" + base + "/api/v4/deploy_keys?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabDeployKey.class, "deploy-key.json") + "]"));

        final List<GitLabDeployKey> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabInstanceDeployKeysApi(GitLabCaller.of(client))
                    .list()
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.deployKey(), CommonCatalogFixtures.deployKey());
        HTTP.verifyRequested(GET, "/api/v4/deploy_keys", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/deploy_keys",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabDeployKey.class, "deploy-key.json")));

        final GitLabDeployKey result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabInstanceDeployKeysApi(GitLabCaller.of(client))
                    .create(DeploykeysCatalogFixtures.instanceDeployKeysCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.deployKey());
        HTTP.verifyRequested(POST, "/api/v4/deploy_keys");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/deploy_keys", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabInstanceDeployKeysApi api = new GitLabInstanceDeployKeysApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(DeploykeysCatalogFixtures.instanceDeployKeysCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/deploy_keys");
    }
}

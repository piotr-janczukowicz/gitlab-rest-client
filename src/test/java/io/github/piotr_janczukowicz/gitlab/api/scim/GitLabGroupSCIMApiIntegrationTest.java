package io.github.piotr_janczukowicz.gitlab.api.scim;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIdentityDetail;
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
class GitLabGroupSCIMApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/scim/identities",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabIdentityDetail.class, "identity-detail.json")));

        final GitLabIdentityDetail result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupSCIMApi(GitLabCaller.of(client)).get("group/sub/project");
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.identityDetail());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/scim/identities");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/groups/group%2Fsub%2Fproject/scim/identities", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupSCIMApi api = new GitLabGroupSCIMApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.get("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/scim/identities");
    }
}

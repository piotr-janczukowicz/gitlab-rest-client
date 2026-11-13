package io.github.piotr_janczukowicz.gitlab.api.usertokens;

import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabPersonalAccessTokenWithToken;
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
class GitLabUserTokensApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/users/1/personal_access_tokens",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPersonalAccessTokenWithToken.class, "personal-access-token-with-token.json")));

        final GitLabPersonalAccessTokenWithToken result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUserTokensApi(GitLabCaller.of(client))
                    .create(1L, UsertokensCatalogFixtures.userTokensCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.personalAccessTokenWithToken());
        HTTP.verifyRequested(POST, "/api/v4/users/1/personal_access_tokens");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/users/1/personal_access_tokens", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUserTokensApi api = new GitLabUserTokensApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(1L, UsertokensCatalogFixtures.userTokensCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/users/1/personal_access_tokens");
    }
}

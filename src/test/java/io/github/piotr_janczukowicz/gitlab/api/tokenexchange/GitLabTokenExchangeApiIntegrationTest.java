package io.github.piotr_janczukowicz.gitlab.api.tokenexchange;

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
class GitLabTokenExchangeApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/token_exchange",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabAuthnTokenExchange.class, "authn-token-exchange.json")));

        final GitLabAuthnTokenExchange result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabTokenExchangeApi(GitLabCaller.of(client))
                    .create(TokenexchangeCatalogFixtures.tokenExchangeCreatePayload());
        }

        assertThat(result).isEqualTo(TokenexchangeCatalogFixtures.authnTokenExchange());
        HTTP.verifyRequested(POST, "/api/v4/token_exchange");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/token_exchange", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabTokenExchangeApi api = new GitLabTokenExchangeApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(TokenexchangeCatalogFixtures.tokenExchangeCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/token_exchange");
    }
}

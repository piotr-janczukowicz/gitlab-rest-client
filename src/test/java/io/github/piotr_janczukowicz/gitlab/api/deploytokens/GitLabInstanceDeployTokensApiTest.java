package io.github.piotr_janczukowicz.gitlab.api.deploytokens;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceDeployTokensApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabInstanceDeployTokensApi api() {
        return new GitLabInstanceDeployTokensApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabInstanceDeployTokensApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabDeployToken.class, "deploy-token.json") + "]"));

        final GitLabPage<GitLabDeployToken> page = api().list();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(DeploytokensCatalogFixtures.deployToken());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/deploy_tokens");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabDeployToken.class, "deploy-token.json") + "]"));

        final GitLabPage<GitLabDeployToken> page = api().list(GitLabInstanceDeployTokensListFilterBuilder.builder()
                .active(true)
                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(DeploytokensCatalogFixtures.deployToken());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/deploy_tokens");
            softly.assertThat(request.uri()).hasParameter("active", "true");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabDeployToken.class, "deploy-token.json") + "]"));

        final GitLabPage<GitLabDeployToken> page = api().list(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(DeploytokensCatalogFixtures.deployToken());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/deploy_tokens");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabDeployToken.class, "deploy-token.json") + "]"));

        final GitLabPage<GitLabDeployToken> page = api().list(
                        GitLabInstanceDeployTokensListFilterBuilder.builder()
                                .active(true)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(DeploytokensCatalogFixtures.deployToken());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/deploy_tokens");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("active", "true");
        });
    }
}

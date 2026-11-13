package io.github.piotr_janczukowicz.gitlab.api.personalaccesstokens;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabPersonalAccessToken;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabPersonalAccessTokenWithToken;
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
class GitLabPersonalAccessTokensApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void createUserPersonalAccessToken_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/user/personal_access_tokens",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPersonalAccessTokenWithToken.class, "personal-access-token-with-token.json")));

        final GitLabPersonalAccessTokenWithToken result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabPersonalAccessTokensApi(GitLabCaller.of(client))
                    .createUserPersonalAccessToken(
                            PersonalaccesstokensCatalogFixtures.personalAccessTokenCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.personalAccessTokenWithToken());
        HTTP.verifyRequested(POST, "/api/v4/user/personal_access_tokens");
    }

    @Test
    void createUserPersonalAccessToken_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/user/personal_access_tokens", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabPersonalAccessTokensApi api = new GitLabPersonalAccessTokensApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createUserPersonalAccessToken(
                    PersonalaccesstokensCatalogFixtures.personalAccessTokenCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/user/personal_access_tokens");
    }

    @Test
    void rotateSelf_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/personal_access_tokens/self/rotate",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPersonalAccessTokenWithToken.class, "personal-access-token-with-token.json")));

        final GitLabPersonalAccessTokenWithToken result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabPersonalAccessTokensApi(GitLabCaller.of(client))
                    .rotateSelf(PersonalaccesstokensCatalogFixtures.personalAccessTokensRotateSelfPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.personalAccessTokenWithToken());
        HTTP.verifyRequested(POST, "/api/v4/personal_access_tokens/self/rotate");
    }

    @Test
    void rotateSelf_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/personal_access_tokens/self/rotate", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabPersonalAccessTokensApi api = new GitLabPersonalAccessTokensApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.rotateSelf(PersonalaccesstokensCatalogFixtures.personalAccessTokensRotateSelfPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/personal_access_tokens/self/rotate");
    }

    @Test
    void getSelf_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/personal_access_tokens/self",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabPersonalAccessToken.class, "personal-access-token.json")));

        final GitLabPersonalAccessToken result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabPersonalAccessTokensApi(GitLabCaller.of(client)).getSelf();
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.personalAccessToken());
        HTTP.verifyRequested(GET, "/api/v4/personal_access_tokens/self");
    }

    @Test
    void getSelf_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/personal_access_tokens/self", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabPersonalAccessTokensApi api = new GitLabPersonalAccessTokensApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getSelf());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/personal_access_tokens/self");
    }

    @Test
    void deleteSelf_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/personal_access_tokens/self", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabPersonalAccessTokensApi(GitLabCaller.of(client)).deleteSelf();
        }

        HTTP.verifyRequested(DELETE, "/api/v4/personal_access_tokens/self");
    }

    @Test
    void deleteSelf_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/personal_access_tokens/self", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabPersonalAccessTokensApi api = new GitLabPersonalAccessTokensApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteSelf());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/personal_access_tokens/self");
    }

    @Test
    void listSelfAssociations_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/personal_access_tokens/self/associations",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabPersonalAccessToken.class, "personal-access-token.json")
                                + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/personal_access_tokens/self/associations?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(GitLabPersonalAccessToken.class, "personal-access-token.json") + "]"));

        final List<GitLabPersonalAccessToken> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabPersonalAccessTokensApi(GitLabCaller.of(client))
                    .listSelfAssociations()
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        CommonCatalogFixtures.personalAccessToken(), CommonCatalogFixtures.personalAccessToken());
        HTTP.verifyRequested(GET, "/api/v4/personal_access_tokens/self/associations", 2);
    }

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/personal_access_tokens",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabPersonalAccessToken.class, "personal-access-token.json")
                                + "]")
                        .header("Link", "<" + base + "/api/v4/personal_access_tokens?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(GitLabPersonalAccessToken.class, "personal-access-token.json") + "]"));

        final List<GitLabPersonalAccessToken> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabPersonalAccessTokensApi(GitLabCaller.of(client))
                    .list()
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        CommonCatalogFixtures.personalAccessToken(), CommonCatalogFixtures.personalAccessToken());
        HTTP.verifyRequested(GET, "/api/v4/personal_access_tokens", 2);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/personal_access_tokens/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabPersonalAccessToken.class, "personal-access-token.json")));

        final Optional<GitLabPersonalAccessToken> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabPersonalAccessTokensApi(GitLabCaller.of(client)).get(1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.personalAccessToken());
        HTTP.verifyRequested(GET, "/api/v4/personal_access_tokens/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/personal_access_tokens/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabPersonalAccessTokensApi(GitLabCaller.of(client))
                    .get(1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/personal_access_tokens/1");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/personal_access_tokens/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabPersonalAccessTokensApi(GitLabCaller.of(client)).delete(1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/personal_access_tokens/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/personal_access_tokens/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabPersonalAccessTokensApi api = new GitLabPersonalAccessTokensApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/personal_access_tokens/1");
    }

    @Test
    void rotate_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/personal_access_tokens/1/rotate",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPersonalAccessTokenWithToken.class, "personal-access-token-with-token.json")));

        final GitLabPersonalAccessTokenWithToken result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabPersonalAccessTokensApi(GitLabCaller.of(client))
                    .rotate(1L, PersonalaccesstokensCatalogFixtures.personalAccessTokensRotatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.personalAccessTokenWithToken());
        HTTP.verifyRequested(POST, "/api/v4/personal_access_tokens/1/rotate");
    }

    @Test
    void rotate_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/personal_access_tokens/1/rotate", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabPersonalAccessTokensApi api = new GitLabPersonalAccessTokensApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.rotate(1L, PersonalaccesstokensCatalogFixtures.personalAccessTokensRotatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/personal_access_tokens/1/rotate");
    }
}

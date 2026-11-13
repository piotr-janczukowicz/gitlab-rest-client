package io.github.piotr_janczukowicz.gitlab.api.accesstokens;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
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
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectAccessTokensApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void rotateSelf_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/access_tokens/self/rotate",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabResourceAccessTokenWithToken.class, "resource-access-token-with-token.json")));

        final GitLabResourceAccessTokenWithToken result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectAccessTokensApi(GitLabCaller.of(client))
                    .rotateSelf(
                            "group/sub/project", AccesstokensCatalogFixtures.projectAccessTokensRotateSelfPayload());
        }

        assertThat(result).isEqualTo(AccesstokensCatalogFixtures.resourceAccessTokenWithToken());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/access_tokens/self/rotate");
    }

    @Test
    void rotateSelf_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/access_tokens/self/rotate",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectAccessTokensApi api = new GitLabProjectAccessTokensApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.rotateSelf(
                    "group/sub/project", AccesstokensCatalogFixtures.projectAccessTokensRotateSelfPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/access_tokens/self/rotate");
    }

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/access_tokens",
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(GitLabResourceAccessToken.class, "resource-access-token.json") + "]"));

        final List<GitLabResourceAccessToken> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectAccessTokensApi(GitLabCaller.of(client)).list("group/sub/project");
        }

        assertThat(result).containsExactly(AccesstokensCatalogFixtures.resourceAccessToken());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/access_tokens");
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/access_tokens",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabResourceAccessTokenWithToken.class, "resource-access-token-with-token.json")));

        final GitLabResourceAccessTokenWithToken result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectAccessTokensApi(GitLabCaller.of(client))
                    .create("group/sub/project", AccesstokensCatalogFixtures.projectAccessTokensCreatePayload());
        }

        assertThat(result).isEqualTo(AccesstokensCatalogFixtures.resourceAccessTokenWithToken());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/access_tokens");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/access_tokens", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectAccessTokensApi api = new GitLabProjectAccessTokensApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.create("group/sub/project", AccesstokensCatalogFixtures.projectAccessTokensCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/access_tokens");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/access_tokens/token_id",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabResourceAccessToken.class, "resource-access-token.json")));

        final Optional<GitLabResourceAccessToken> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectAccessTokensApi(GitLabCaller.of(client)).get("group/sub/project", "token_id");
        }

        assertThat(result).contains(AccesstokensCatalogFixtures.resourceAccessToken());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/access_tokens/token_id");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/access_tokens/token_id", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectAccessTokensApi(GitLabCaller.of(client))
                    .get("group/sub/project", "token_id")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/access_tokens/token_id");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/access_tokens/token_id",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectAccessTokensApi(GitLabCaller.of(client)).delete("group/sub/project", "token_id");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/access_tokens/token_id");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/access_tokens/token_id",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectAccessTokensApi api = new GitLabProjectAccessTokensApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", "token_id"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/access_tokens/token_id");
    }

    @Test
    void rotate_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/access_tokens/token_id/rotate",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabResourceAccessTokenWithToken.class, "resource-access-token-with-token.json")));

        final GitLabResourceAccessTokenWithToken result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectAccessTokensApi(GitLabCaller.of(client))
                    .rotate(
                            "group/sub/project",
                            "token_id",
                            AccesstokensCatalogFixtures.projectAccessTokensRotatePayload());
        }

        assertThat(result).isEqualTo(AccesstokensCatalogFixtures.resourceAccessTokenWithToken());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/access_tokens/token_id/rotate");
    }

    @Test
    void rotate_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/access_tokens/token_id/rotate",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectAccessTokensApi api = new GitLabProjectAccessTokensApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.rotate(
                    "group/sub/project", "token_id", AccesstokensCatalogFixtures.projectAccessTokensRotatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/access_tokens/token_id/rotate");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.PATCH;
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
class GitLabGroupServiceAccountsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/service_accounts",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabServiceAccount.class, "service-account.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/service_accounts?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabServiceAccount.class, "service-account.json") + "]"));

        final List<GitLabServiceAccount> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupServiceAccountsApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        ServiceaccountsCatalogFixtures.serviceAccount(),
                        ServiceaccountsCatalogFixtures.serviceAccount());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/service_accounts", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/service_accounts",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabServiceAccount.class, "service-account.json")));

        final GitLabServiceAccount result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupServiceAccountsApi(GitLabCaller.of(client))
                    .create("group/sub/project", ServiceaccountsCatalogFixtures.groupServiceAccountsCreatePayload());
        }

        assertThat(result).isEqualTo(ServiceaccountsCatalogFixtures.serviceAccount());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/service_accounts");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/service_accounts", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupServiceAccountsApi api = new GitLabGroupServiceAccountsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    "group/sub/project", ServiceaccountsCatalogFixtures.groupServiceAccountsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/service_accounts");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabServiceAccount.class, "service-account.json")));

        final Optional<GitLabServiceAccount> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupServiceAccountsApi(GitLabCaller.of(client)).get("group/sub/project", 1L);
        }

        assertThat(result).contains(ServiceaccountsCatalogFixtures.serviceAccount());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupServiceAccountsApi(GitLabCaller.of(client))
                    .get("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PATCH,
                "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabServiceAccount.class, "service-account.json")));

        final GitLabServiceAccount result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupServiceAccountsApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            1L,
                            ServiceaccountsCatalogFixtures.groupServiceAccountsUpdatePayload());
        }

        assertThat(result).isEqualTo(ServiceaccountsCatalogFixtures.serviceAccount());
        HTTP.verifyRequested(PATCH, "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PATCH, "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupServiceAccountsApi api = new GitLabGroupServiceAccountsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project", 1L, ServiceaccountsCatalogFixtures.groupServiceAccountsUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PATCH, "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupServiceAccountsApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupServiceAccountsApi api = new GitLabGroupServiceAccountsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1");
    }

    @Test
    void listPersonalAccessTokens_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1/personal_access_tokens",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabPersonalAccessToken.class, "personal-access-token.json")
                                + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1/personal_access_tokens?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(GitLabPersonalAccessToken.class, "personal-access-token.json") + "]"));

        final List<GitLabPersonalAccessToken> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupServiceAccountsApi(GitLabCaller.of(client))
                    .listPersonalAccessTokens("group/sub/project", 1L)
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        CommonCatalogFixtures.personalAccessToken(), CommonCatalogFixtures.personalAccessToken());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1/personal_access_tokens", 2);
    }

    @Test
    void createPersonalAccessToken_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1/personal_access_tokens",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPersonalAccessTokenWithToken.class, "personal-access-token-with-token.json")));

        final GitLabPersonalAccessTokenWithToken result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupServiceAccountsApi(GitLabCaller.of(client))
                    .createPersonalAccessToken(
                            "group/sub/project",
                            1L,
                            ServiceaccountsCatalogFixtures.groupServiceAccountsCreatePersonalAccessTokenPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.personalAccessTokenWithToken());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1/personal_access_tokens");
    }

    @Test
    void createPersonalAccessToken_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1/personal_access_tokens",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupServiceAccountsApi api = new GitLabGroupServiceAccountsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createPersonalAccessToken(
                    "group/sub/project",
                    1L,
                    ServiceaccountsCatalogFixtures.groupServiceAccountsCreatePersonalAccessTokenPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1/personal_access_tokens");
    }

    @Test
    void deletePersonalAccessToken_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1/personal_access_tokens/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupServiceAccountsApi(GitLabCaller.of(client))
                    .deletePersonalAccessToken("group/sub/project", 1L, 1L);
        }

        HTTP.verifyRequested(
                DELETE, "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1/personal_access_tokens/1");
    }

    @Test
    void deletePersonalAccessToken_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1/personal_access_tokens/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupServiceAccountsApi api = new GitLabGroupServiceAccountsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deletePersonalAccessToken("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                DELETE, "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1/personal_access_tokens/1");
    }

    @Test
    void rotatePersonalAccessToken_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1/personal_access_tokens/1/rotate",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPersonalAccessTokenWithToken.class, "personal-access-token-with-token.json")));

        final GitLabPersonalAccessTokenWithToken result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupServiceAccountsApi(GitLabCaller.of(client))
                    .rotatePersonalAccessToken(
                            "group/sub/project",
                            1L,
                            1L,
                            ServiceaccountsCatalogFixtures.groupServiceAccountsRotatePersonalAccessTokenPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.personalAccessTokenWithToken());
        HTTP.verifyRequested(
                POST, "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1/personal_access_tokens/1/rotate");
    }

    @Test
    void rotatePersonalAccessToken_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1/personal_access_tokens/1/rotate",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupServiceAccountsApi api = new GitLabGroupServiceAccountsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.rotatePersonalAccessToken(
                    "group/sub/project",
                    1L,
                    1L,
                    ServiceaccountsCatalogFixtures.groupServiceAccountsRotatePersonalAccessTokenPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                POST, "/api/v4/groups/group%2Fsub%2Fproject/service_accounts/1/personal_access_tokens/1/rotate");
    }
}

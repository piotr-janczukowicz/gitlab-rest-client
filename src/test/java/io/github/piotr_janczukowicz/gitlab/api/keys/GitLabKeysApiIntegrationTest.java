package io.github.piotr_janczukowicz.gitlab.api.keys;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabSSHKey;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserWithAdmin;
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
class GitLabKeysApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void listUsersKeys_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/users/user_id/keys",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabSSHKey.class, "s-s-h-key.json") + "]")
                        .header("Link", "<" + base + "/api/v4/users/user_id/keys?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabSSHKey.class, "s-s-h-key.json") + "]"));

        final List<GitLabSSHKey> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabKeysApi(GitLabCaller.of(client))
                    .listUsersKeys("user_id")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.sshkey(), CommonCatalogFixtures.sshkey());
        HTTP.verifyRequested(GET, "/api/v4/users/user_id/keys", 2);
    }

    @Test
    void createUsersKey_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/users/1/keys",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabSSHKey.class, "s-s-h-key.json")));

        final GitLabSSHKey result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabKeysApi(GitLabCaller.of(client))
                    .createUsersKey(1L, KeysCatalogFixtures.keysCreateUsersKeyPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.sshkey());
        HTTP.verifyRequested(POST, "/api/v4/users/1/keys");
    }

    @Test
    void createUsersKey_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/users/1/keys", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabKeysApi api = new GitLabKeysApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createUsersKey(1L, KeysCatalogFixtures.keysCreateUsersKeyPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/users/1/keys");
    }

    @Test
    void getUsersKey_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/users/1/keys/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabSSHKey.class, "s-s-h-key.json")));

        final Optional<GitLabSSHKey> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabKeysApi(GitLabCaller.of(client)).getUsersKey(1L, 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.sshkey());
        HTTP.verifyRequested(GET, "/api/v4/users/1/keys/1");
    }

    @Test
    void getUsersKey_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/users/1/keys/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabKeysApi(GitLabCaller.of(client))
                    .getUsersKey(1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/users/1/keys/1");
    }

    @Test
    void deleteUsersKey_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/users/1/keys/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabSSHKey.class, "s-s-h-key.json")));

        final Optional<GitLabSSHKey> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabKeysApi(GitLabCaller.of(client)).deleteUsersKey(1L, 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.sshkey());
        HTTP.verifyRequested(DELETE, "/api/v4/users/1/keys/1");
    }

    @Test
    void deleteUsersKey_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/users/1/keys/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabKeysApi api = new GitLabKeysApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteUsersKey(1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/users/1/keys/1");
    }

    @Test
    void deleteUsersKey_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/users/1/keys/1", GitLabApiStubSupport.noContent());

        final Optional<GitLabSSHKey> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabKeysApi(GitLabCaller.of(client)).deleteUsersKey(1L, 1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/users/1/keys/1");
    }

    @Test
    void listUsersGpgKeys_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/users/1/gpg_keys",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabGpgKey.class, "gpg-key.json") + "]")
                        .header("Link", "<" + base + "/api/v4/users/1/gpg_keys?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabGpgKey.class, "gpg-key.json") + "]"));

        final List<GitLabGpgKey> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabKeysApi(GitLabCaller.of(client))
                    .listUsersGpgKeys(1L)
                    .all();
        }

        assertThat(items).containsExactly(KeysCatalogFixtures.gpgKey(), KeysCatalogFixtures.gpgKey());
        HTTP.verifyRequested(GET, "/api/v4/users/1/gpg_keys", 2);
    }

    @Test
    void createUsersGpgKey_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/users/1/gpg_keys",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGpgKey.class, "gpg-key.json")));

        final GitLabGpgKey result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabKeysApi(GitLabCaller.of(client))
                    .createUsersGpgKey(1L, KeysCatalogFixtures.keysCreateUsersGpgKeyPayload());
        }

        assertThat(result).isEqualTo(KeysCatalogFixtures.gpgKey());
        HTTP.verifyRequested(POST, "/api/v4/users/1/gpg_keys");
    }

    @Test
    void createUsersGpgKey_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/users/1/gpg_keys", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabKeysApi api = new GitLabKeysApi(GitLabCaller.of(client));
            thrown =
                    catchThrowable(() -> api.createUsersGpgKey(1L, KeysCatalogFixtures.keysCreateUsersGpgKeyPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/users/1/gpg_keys");
    }

    @Test
    void getUsersGpgKey_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/users/1/gpg_keys/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGpgKey.class, "gpg-key.json")));

        final Optional<GitLabGpgKey> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabKeysApi(GitLabCaller.of(client)).getUsersGpgKey(1L, 1L);
        }

        assertThat(result).contains(KeysCatalogFixtures.gpgKey());
        HTTP.verifyRequested(GET, "/api/v4/users/1/gpg_keys/1");
    }

    @Test
    void getUsersGpgKey_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/users/1/gpg_keys/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabKeysApi(GitLabCaller.of(client))
                    .getUsersGpgKey(1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/users/1/gpg_keys/1");
    }

    @Test
    void deleteUsersGpgKey_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/users/1/gpg_keys/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabKeysApi(GitLabCaller.of(client)).deleteUsersGpgKey(1L, 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/users/1/gpg_keys/1");
    }

    @Test
    void deleteUsersGpgKey_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/users/1/gpg_keys/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabKeysApi api = new GitLabKeysApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteUsersGpgKey(1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/users/1/gpg_keys/1");
    }

    @Test
    void revokeUsersGpgKey_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/users/1/gpg_keys/1/revoke", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabKeysApi(GitLabCaller.of(client)).revokeUsersGpgKey(1L, 1L);
        }

        HTTP.verifyRequested(POST, "/api/v4/users/1/gpg_keys/1/revoke");
    }

    @Test
    void revokeUsersGpgKey_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/users/1/gpg_keys/1/revoke", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabKeysApi api = new GitLabKeysApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.revokeUsersGpgKey(1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/users/1/gpg_keys/1/revoke");
    }

    @Test
    void listUserGpgKeys_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/user/gpg_keys",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabGpgKey.class, "gpg-key.json") + "]")
                        .header("Link", "<" + base + "/api/v4/user/gpg_keys?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabGpgKey.class, "gpg-key.json") + "]"));

        final List<GitLabGpgKey> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabKeysApi(GitLabCaller.of(client)).listUserGpgKeys().all();
        }

        assertThat(items).containsExactly(KeysCatalogFixtures.gpgKey(), KeysCatalogFixtures.gpgKey());
        HTTP.verifyRequested(GET, "/api/v4/user/gpg_keys", 2);
    }

    @Test
    void createUserGpgKey_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/user/gpg_keys",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGpgKey.class, "gpg-key.json")));

        final GitLabGpgKey result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabKeysApi(GitLabCaller.of(client))
                    .createUserGpgKey(KeysCatalogFixtures.keysCreateUserGpgKeyPayload());
        }

        assertThat(result).isEqualTo(KeysCatalogFixtures.gpgKey());
        HTTP.verifyRequested(POST, "/api/v4/user/gpg_keys");
    }

    @Test
    void createUserGpgKey_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/user/gpg_keys", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabKeysApi api = new GitLabKeysApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createUserGpgKey(KeysCatalogFixtures.keysCreateUserGpgKeyPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/user/gpg_keys");
    }

    @Test
    void getUserGpgKey_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/user/gpg_keys/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGpgKey.class, "gpg-key.json")));

        final Optional<GitLabGpgKey> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabKeysApi(GitLabCaller.of(client)).getUserGpgKey(1L);
        }

        assertThat(result).contains(KeysCatalogFixtures.gpgKey());
        HTTP.verifyRequested(GET, "/api/v4/user/gpg_keys/1");
    }

    @Test
    void getUserGpgKey_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/user/gpg_keys/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabKeysApi(GitLabCaller.of(client)).getUserGpgKey(1L).isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/user/gpg_keys/1");
    }

    @Test
    void deleteUserGpgKey_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/user/gpg_keys/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabKeysApi(GitLabCaller.of(client)).deleteUserGpgKey(1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/user/gpg_keys/1");
    }

    @Test
    void deleteUserGpgKey_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/user/gpg_keys/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabKeysApi api = new GitLabKeysApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteUserGpgKey(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/user/gpg_keys/1");
    }

    @Test
    void revokeUserGpgKey_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/user/gpg_keys/1/revoke", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabKeysApi(GitLabCaller.of(client)).revokeUserGpgKey(1L);
        }

        HTTP.verifyRequested(POST, "/api/v4/user/gpg_keys/1/revoke");
    }

    @Test
    void revokeUserGpgKey_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/user/gpg_keys/1/revoke", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabKeysApi api = new GitLabKeysApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.revokeUserGpgKey(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/user/gpg_keys/1/revoke");
    }

    @Test
    void getById_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/keys/group%2Fsub%2Fproject",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabSSHKeyWithUser.class, "s-s-h-key-with-user.json")));

        final Optional<GitLabSSHKeyWithUser> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabKeysApi(GitLabCaller.of(client)).getById("group/sub/project");
        }

        assertThat(result).contains(KeysCatalogFixtures.sshkeyWithUser());
        HTTP.verifyRequested(GET, "/api/v4/keys/group%2Fsub%2Fproject");
    }

    @Test
    void getById_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/keys/group%2Fsub%2Fproject", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabKeysApi(GitLabCaller.of(client))
                    .getById("group/sub/project")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/keys/group%2Fsub%2Fproject");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/keys",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabUserWithAdmin.class, "user-with-admin.json")));

        final GitLabUserWithAdmin result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabKeysApi(GitLabCaller.of(client)).get("fingerprint");
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.userWithAdmin());
        HTTP.verifyRequested(GET, "/api/v4/keys");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/keys", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabKeysApi api = new GitLabKeysApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.get("fingerprint"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/keys");
    }
}

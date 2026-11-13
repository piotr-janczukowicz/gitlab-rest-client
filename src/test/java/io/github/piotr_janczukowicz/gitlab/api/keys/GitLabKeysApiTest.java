package io.github.piotr_janczukowicz.gitlab.api.keys;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabSSHKey;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserWithAdmin;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabKeysApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabKeysApi api() {
        return new GitLabKeysApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabKeysApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void listUsersKeys_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabSSHKey.class, "s-s-h-key.json") + "]"));

        final GitLabPage<GitLabSSHKey> page = api().listUsersKeys("user_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.sshkey());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/user_id/keys");
        });
    }

    @Test
    void listUsersKeys_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabSSHKey.class, "s-s-h-key.json") + "]"));

        final GitLabPage<GitLabSSHKey> page = api().listUsersKeys("user_id", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.sshkey());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/user_id/keys");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createUsersKey_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabSSHKey.class, "s-s-h-key.json")));

        final GitLabSSHKey result = api().createUsersKey(1L, KeysCatalogFixtures.keysCreateUsersKeyPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.sshkey());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/users/1/keys");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"key\":");
        });
    }

    @Test
    void createUsersKey_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().createUsersKey(1L, KeysCatalogFixtures.keysCreateUsersKeyPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getUsersKey_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabSSHKey.class, "s-s-h-key.json")));

        final Optional<GitLabSSHKey> result = api().getUsersKey(1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.sshkey());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/1/keys/1");
        });
    }

    @Test
    void getUsersKey_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabSSHKey> result = api().getUsersKey(1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void deleteUsersKey_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabSSHKey.class, "s-s-h-key.json")));

        final Optional<GitLabSSHKey> result = api().deleteUsersKey(1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.sshkey());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/users/1/keys/1");
        });
    }

    @Test
    void deleteUsersKey_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteUsersKey(1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteUsersKey_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        final Optional<GitLabSSHKey> result = api().deleteUsersKey(1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void listUsersGpgKeys_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGpgKey.class, "gpg-key.json") + "]"));

        final GitLabPage<GitLabGpgKey> page = api().listUsersGpgKeys(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(KeysCatalogFixtures.gpgKey());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/1/gpg_keys");
        });
    }

    @Test
    void listUsersGpgKeys_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGpgKey.class, "gpg-key.json") + "]"));

        final GitLabPage<GitLabGpgKey> page = api().listUsersGpgKeys(1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(KeysCatalogFixtures.gpgKey());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/1/gpg_keys");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createUsersGpgKey_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabGpgKey.class, "gpg-key.json")));

        final GitLabGpgKey result = api().createUsersGpgKey(1L, KeysCatalogFixtures.keysCreateUsersGpgKeyPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(KeysCatalogFixtures.gpgKey());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/users/1/gpg_keys");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"key\":");
        });
    }

    @Test
    void createUsersGpgKey_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().createUsersGpgKey(1L, KeysCatalogFixtures.keysCreateUsersGpgKeyPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getUsersGpgKey_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabGpgKey.class, "gpg-key.json")));

        final Optional<GitLabGpgKey> result = api().getUsersGpgKey(1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(KeysCatalogFixtures.gpgKey());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/1/gpg_keys/1");
        });
    }

    @Test
    void getUsersGpgKey_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabGpgKey> result = api().getUsersGpgKey(1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void deleteUsersGpgKey_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteUsersGpgKey(1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/users/1/gpg_keys/1");
    }

    @Test
    void deleteUsersGpgKey_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteUsersGpgKey(1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void revokeUsersGpgKey_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().revokeUsersGpgKey(1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/users/1/gpg_keys/1/revoke");
    }

    @Test
    void revokeUsersGpgKey_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().revokeUsersGpgKey(1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listUserGpgKeys_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGpgKey.class, "gpg-key.json") + "]"));

        final GitLabPage<GitLabGpgKey> page = api().listUserGpgKeys();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(KeysCatalogFixtures.gpgKey());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/user/gpg_keys");
        });
    }

    @Test
    void listUserGpgKeys_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGpgKey.class, "gpg-key.json") + "]"));

        final GitLabPage<GitLabGpgKey> page = api().listUserGpgKeys(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(KeysCatalogFixtures.gpgKey());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/user/gpg_keys");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createUserGpgKey_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabGpgKey.class, "gpg-key.json")));

        final GitLabGpgKey result = api().createUserGpgKey(KeysCatalogFixtures.keysCreateUserGpgKeyPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(KeysCatalogFixtures.gpgKey());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/user/gpg_keys");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"key\":");
        });
    }

    @Test
    void createUserGpgKey_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().createUserGpgKey(KeysCatalogFixtures.keysCreateUserGpgKeyPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getUserGpgKey_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabGpgKey.class, "gpg-key.json")));

        final Optional<GitLabGpgKey> result = api().getUserGpgKey(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(KeysCatalogFixtures.gpgKey());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/user/gpg_keys/1");
        });
    }

    @Test
    void getUserGpgKey_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabGpgKey> result = api().getUserGpgKey(1L);

        assertThat(result).isEmpty();
    }

    @Test
    void deleteUserGpgKey_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteUserGpgKey(1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/user/gpg_keys/1");
    }

    @Test
    void deleteUserGpgKey_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteUserGpgKey(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void revokeUserGpgKey_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().revokeUserGpgKey(1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/user/gpg_keys/1/revoke");
    }

    @Test
    void revokeUserGpgKey_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().revokeUserGpgKey(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getById_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabSSHKeyWithUser.class, "s-s-h-key-with-user.json")));

        final Optional<GitLabSSHKeyWithUser> result = api().getById("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(KeysCatalogFixtures.sshkeyWithUser());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/keys/group%2Fsub%2Fproject");
        });
    }

    @Test
    void getById_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabSSHKeyWithUser> result = api().getById("group/sub/project");

        assertThat(result).isEmpty();
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabUserWithAdmin.class, "user-with-admin.json")));

        final GitLabUserWithAdmin result = api().get("fingerprint");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.userWithAdmin());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/keys");
            softly.assertThat(request.uri()).hasParameter("fingerprint", "fingerprint");
        });
    }

    @Test
    void get_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().get("fingerprint"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}

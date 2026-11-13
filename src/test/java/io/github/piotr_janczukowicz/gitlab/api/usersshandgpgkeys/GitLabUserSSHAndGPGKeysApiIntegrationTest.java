package io.github.piotr_janczukowicz.gitlab.api.usersshandgpgkeys;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabSSHKey;
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
class GitLabUserSSHAndGPGKeysApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/user/keys",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabSSHKey.class, "s-s-h-key.json") + "]")
                        .header("Link", "<" + base + "/api/v4/user/keys?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabSSHKey.class, "s-s-h-key.json") + "]"));

        final List<GitLabSSHKey> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabUserSSHAndGPGKeysApi(GitLabCaller.of(client))
                    .list()
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.sshkey(), CommonCatalogFixtures.sshkey());
        HTTP.verifyRequested(GET, "/api/v4/user/keys", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/user/keys",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabSSHKey.class, "s-s-h-key.json")));

        final GitLabSSHKey result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUserSSHAndGPGKeysApi(GitLabCaller.of(client))
                    .create(UsersshandgpgkeysCatalogFixtures.userSSHAndGPGKeysCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.sshkey());
        HTTP.verifyRequested(POST, "/api/v4/user/keys");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/user/keys", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUserSSHAndGPGKeysApi api = new GitLabUserSSHAndGPGKeysApi(GitLabCaller.of(client));
            thrown =
                    catchThrowable(() -> api.create(UsersshandgpgkeysCatalogFixtures.userSSHAndGPGKeysCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/user/keys");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/user/keys/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabSSHKey.class, "s-s-h-key.json")));

        final Optional<GitLabSSHKey> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUserSSHAndGPGKeysApi(GitLabCaller.of(client)).get(1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.sshkey());
        HTTP.verifyRequested(GET, "/api/v4/user/keys/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/user/keys/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabUserSSHAndGPGKeysApi(GitLabCaller.of(client))
                    .get(1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/user/keys/1");
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/user/keys/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabSSHKey.class, "s-s-h-key.json")));

        final Optional<GitLabSSHKey> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUserSSHAndGPGKeysApi(GitLabCaller.of(client)).delete(1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.sshkey());
        HTTP.verifyRequested(DELETE, "/api/v4/user/keys/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/user/keys/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUserSSHAndGPGKeysApi api = new GitLabUserSSHAndGPGKeysApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/user/keys/1");
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/user/keys/1", GitLabApiStubSupport.noContent());

        final Optional<GitLabSSHKey> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUserSSHAndGPGKeysApi(GitLabCaller.of(client)).delete(1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/user/keys/1");
    }
}

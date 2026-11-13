package io.github.piotr_janczukowicz.gitlab.api.users;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.PATCH;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiRunnerRegistrationDetails;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabDeployKey;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabEmail;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserPublic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserWithAdmin;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabUsersApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void getUsersSupportPin_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/users/1/support_pin",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabUserSupportPin.class, "user-support-pin.json")));

        final Optional<GitLabUserSupportPin> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client)).getUsersSupportPin(1L);
        }

        assertThat(result).contains(UsersCatalogFixtures.userSupportPin());
        HTTP.verifyRequested(GET, "/api/v4/users/1/support_pin");
    }

    @Test
    void getUsersSupportPin_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/users/1/support_pin", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabUsersApi(GitLabCaller.of(client))
                    .getUsersSupportPin(1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/users/1/support_pin");
    }

    @Test
    void revokeSupportPin_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/users/1/support_pin/revoke", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabUsersApi(GitLabCaller.of(client)).revokeSupportPin(1L);
        }

        HTTP.verifyRequested(POST, "/api/v4/users/1/support_pin/revoke");
    }

    @Test
    void revokeSupportPin_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/users/1/support_pin/revoke", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.revokeSupportPin(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/users/1/support_pin/revoke");
    }

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/users",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabUserBasic.class, "user-basic.json") + "]")
                        .header("Link", "<" + base + "/api/v4/users?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabUserBasic.class, "user-basic.json") + "]"));

        final List<GitLabUserBasic> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabUsersApi(GitLabCaller.of(client)).list().all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.userBasic(), CommonCatalogFixtures.userBasic());
        HTTP.verifyRequested(GET, "/api/v4/users", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/users",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabUserWithAdmin.class, "user-with-admin.json")));

        final GitLabUserWithAdmin result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client))
                    .create(MultipartFormData.builder().text("field", "value").build());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.userWithAdmin());
        HTTP.verifyRequested(POST, "/api/v4/users");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/users", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/users");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/users/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabUserProfile.class, "user-profile.json")));

        final Optional<GitLabUserProfile> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client)).get(1L);
        }

        assertThat(result).contains(UsersCatalogFixtures.userProfile());
        HTTP.verifyRequested(GET, "/api/v4/users/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/users/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabUsersApi(GitLabCaller.of(client)).get(1L).isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/users/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/users/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabUserWithAdmin.class, "user-with-admin.json")));

        final GitLabUserWithAdmin result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client))
                    .update(
                            1L,
                            MultipartFormData.builder().text("field", "value").build());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.userWithAdmin());
        HTTP.verifyRequested(PUT, "/api/v4/users/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/users/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    1L, MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/users/1");
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/users/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabEmail.class, "email.json")));

        final Optional<GitLabEmail> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client)).delete(1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.email());
        HTTP.verifyRequested(DELETE, "/api/v4/users/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/users/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/users/1");
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/users/1", GitLabApiStubSupport.noContent());

        final Optional<GitLabEmail> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client)).delete(1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/users/1");
    }

    @Test
    void getUsersStatus_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/users/user_id/status",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabUserStatus.class, "user-status.json")));

        final Optional<GitLabUserStatus> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client)).getUsersStatus("user_id");
        }

        assertThat(result).contains(UsersCatalogFixtures.userStatus());
        HTTP.verifyRequested(GET, "/api/v4/users/user_id/status");
    }

    @Test
    void getUsersStatus_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/users/user_id/status", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabUsersApi(GitLabCaller.of(client))
                    .getUsersStatus("user_id")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/users/user_id/status");
    }

    @Test
    void listFollowing_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/users/1/following",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabUserBasic.class, "user-basic.json") + "]")
                        .header("Link", "<" + base + "/api/v4/users/1/following?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabUserBasic.class, "user-basic.json") + "]"));

        final List<GitLabUserBasic> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabUsersApi(GitLabCaller.of(client))
                    .listFollowing(1L)
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.userBasic(), CommonCatalogFixtures.userBasic());
        HTTP.verifyRequested(GET, "/api/v4/users/1/following", 2);
    }

    @Test
    void listFollowers_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/users/1/followers",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabUserBasic.class, "user-basic.json") + "]")
                        .header("Link", "<" + base + "/api/v4/users/1/followers?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabUserBasic.class, "user-basic.json") + "]"));

        final List<GitLabUserBasic> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabUsersApi(GitLabCaller.of(client))
                    .listFollowers(1L)
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.userBasic(), CommonCatalogFixtures.userBasic());
        HTTP.verifyRequested(GET, "/api/v4/users/1/followers", 2);
    }

    @Test
    void disableTwoFactor_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PATCH,
                "/api/v4/users/1/disable_two_factor",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabUserWithAdmin.class, "user-with-admin.json")));

        final GitLabUserWithAdmin result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client)).disableTwoFactor(1L);
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.userWithAdmin());
        HTTP.verifyRequested(PATCH, "/api/v4/users/1/disable_two_factor");
    }

    @Test
    void disableTwoFactor_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PATCH, "/api/v4/users/1/disable_two_factor", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.disableTwoFactor(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PATCH, "/api/v4/users/1/disable_two_factor");
    }

    @Test
    void deleteIdentity_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/users/1/identities/provider",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabUserWithAdmin.class, "user-with-admin.json")));

        final Optional<GitLabUserWithAdmin> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client)).deleteIdentity(1L, "provider");
        }

        assertThat(result).contains(CommonCatalogFixtures.userWithAdmin());
        HTTP.verifyRequested(DELETE, "/api/v4/users/1/identities/provider");
    }

    @Test
    void deleteIdentity_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/users/1/identities/provider", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteIdentity(1L, "provider"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/users/1/identities/provider");
    }

    @Test
    void deleteIdentity_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/users/1/identities/provider", GitLabApiStubSupport.noContent());

        final Optional<GitLabUserWithAdmin> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client)).deleteIdentity(1L, "provider");
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/users/1/identities/provider");
    }

    @Test
    void listProjectDeployKeys_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/users/user_id/project_deploy_keys",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabDeployKey.class, "deploy-key.json") + "]")
                        .header("Link", "<" + base + "/api/v4/users/user_id/project_deploy_keys?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabDeployKey.class, "deploy-key.json") + "]"));

        final List<GitLabDeployKey> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabUsersApi(GitLabCaller.of(client))
                    .listProjectDeployKeys("user_id")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.deployKey(), CommonCatalogFixtures.deployKey());
        HTTP.verifyRequested(GET, "/api/v4/users/user_id/project_deploy_keys", 2);
    }

    @Test
    void listEmails_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/users/1/emails",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabEmail.class, "email.json") + "]")
                        .header("Link", "<" + base + "/api/v4/users/1/emails?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabEmail.class, "email.json") + "]"));

        final List<GitLabEmail> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabUsersApi(GitLabCaller.of(client)).listEmails(1L).all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.email(), CommonCatalogFixtures.email());
        HTTP.verifyRequested(GET, "/api/v4/users/1/emails", 2);
    }

    @Test
    void createEmail_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/users/1/emails",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabEmail.class, "email.json")));

        final GitLabEmail result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client))
                    .createEmail(1L, UsersCatalogFixtures.usersCreateEmailPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.email());
        HTTP.verifyRequested(POST, "/api/v4/users/1/emails");
    }

    @Test
    void createEmail_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/users/1/emails", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createEmail(1L, UsersCatalogFixtures.usersCreateEmailPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/users/1/emails");
    }

    @Test
    void deleteEmail_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/users/1/emails/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabEmail.class, "email.json")));

        final Optional<GitLabEmail> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client)).deleteEmail(1L, 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.email());
        HTTP.verifyRequested(DELETE, "/api/v4/users/1/emails/1");
    }

    @Test
    void deleteEmail_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/users/1/emails/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteEmail(1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/users/1/emails/1");
    }

    @Test
    void deleteEmail_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/users/1/emails/1", GitLabApiStubSupport.noContent());

        final Optional<GitLabEmail> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client)).deleteEmail(1L, 1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/users/1/emails/1");
    }

    @Test
    void activate_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/users/1/activate", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabUsersApi(GitLabCaller.of(client)).activate(1L);
        }

        HTTP.verifyRequested(POST, "/api/v4/users/1/activate");
    }

    @Test
    void activate_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/users/1/activate", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.activate(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/users/1/activate");
    }

    @Test
    void deactivate_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/users/1/deactivate", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabUsersApi(GitLabCaller.of(client)).deactivate(1L);
        }

        HTTP.verifyRequested(POST, "/api/v4/users/1/deactivate");
    }

    @Test
    void deactivate_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/users/1/deactivate", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deactivate(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/users/1/deactivate");
    }

    @Test
    void block_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/users/1/block", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabUsersApi(GitLabCaller.of(client)).block(1L);
        }

        HTTP.verifyRequested(POST, "/api/v4/users/1/block");
    }

    @Test
    void block_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/users/1/block", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.block(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/users/1/block");
    }

    @Test
    void unblock_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/users/1/unblock", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabUsersApi(GitLabCaller.of(client)).unblock(1L);
        }

        HTTP.verifyRequested(POST, "/api/v4/users/1/unblock");
    }

    @Test
    void unblock_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/users/1/unblock", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.unblock(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/users/1/unblock");
    }

    @Test
    void ban_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/users/1/ban", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabUsersApi(GitLabCaller.of(client)).ban(1L);
        }

        HTTP.verifyRequested(POST, "/api/v4/users/1/ban");
    }

    @Test
    void ban_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/users/1/ban", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.ban(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/users/1/ban");
    }

    @Test
    void unban_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/users/1/unban", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabUsersApi(GitLabCaller.of(client)).unban(1L);
        }

        HTTP.verifyRequested(POST, "/api/v4/users/1/unban");
    }

    @Test
    void unban_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/users/1/unban", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.unban(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/users/1/unban");
    }

    @Test
    void listMemberships_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/users/1/memberships",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabMembership.class, "membership.json") + "]")
                        .header("Link", "<" + base + "/api/v4/users/1/memberships?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabMembership.class, "membership.json") + "]"));

        final List<GitLabMembership> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabUsersApi(GitLabCaller.of(client))
                    .listMemberships(1L)
                    .all();
        }

        assertThat(items).containsExactly(UsersCatalogFixtures.membership(), UsersCatalogFixtures.membership());
        HTTP.verifyRequested(GET, "/api/v4/users/1/memberships", 2);
    }

    @Test
    void getAssociationsCount_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/users/1/associations_count",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabUserAssociationsCount.class, "user-associations-count.json")));

        final Optional<GitLabUserAssociationsCount> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client)).getAssociationsCount(1L);
        }

        assertThat(result).contains(UsersCatalogFixtures.userAssociationsCount());
        HTTP.verifyRequested(GET, "/api/v4/users/1/associations_count");
    }

    @Test
    void getAssociationsCount_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/users/1/associations_count", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabUsersApi(GitLabCaller.of(client))
                    .getAssociationsCount(1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/users/1/associations_count");
    }

    @Test
    void listImpersonationTokens_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/users/1/impersonation_tokens",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabImpersonationToken.class, "impersonation-token.json")
                                        + "]")
                        .header("Link", "<" + base + "/api/v4/users/1/impersonation_tokens?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabImpersonationToken.class, "impersonation-token.json") + "]"));

        final List<GitLabImpersonationToken> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabUsersApi(GitLabCaller.of(client))
                    .listImpersonationTokens(1L)
                    .all();
        }

        assertThat(items)
                .containsExactly(UsersCatalogFixtures.impersonationToken(), UsersCatalogFixtures.impersonationToken());
        HTTP.verifyRequested(GET, "/api/v4/users/1/impersonation_tokens", 2);
    }

    @Test
    void createImpersonationToken_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/users/1/impersonation_tokens",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabImpersonationTokenWithToken.class, "impersonation-token-with-token.json")));

        final GitLabImpersonationTokenWithToken result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client))
                    .createImpersonationToken(1L, UsersCatalogFixtures.usersCreateImpersonationTokenPayload());
        }

        assertThat(result).isEqualTo(UsersCatalogFixtures.impersonationTokenWithToken());
        HTTP.verifyRequested(POST, "/api/v4/users/1/impersonation_tokens");
    }

    @Test
    void createImpersonationToken_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/users/1/impersonation_tokens", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.createImpersonationToken(1L, UsersCatalogFixtures.usersCreateImpersonationTokenPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/users/1/impersonation_tokens");
    }

    @Test
    void getImpersonationToken_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/users/1/impersonation_tokens/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabImpersonationToken.class, "impersonation-token.json")));

        final Optional<GitLabImpersonationToken> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client)).getImpersonationToken(1L, 1L);
        }

        assertThat(result).contains(UsersCatalogFixtures.impersonationToken());
        HTTP.verifyRequested(GET, "/api/v4/users/1/impersonation_tokens/1");
    }

    @Test
    void getImpersonationToken_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/users/1/impersonation_tokens/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabUsersApi(GitLabCaller.of(client))
                    .getImpersonationToken(1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/users/1/impersonation_tokens/1");
    }

    @Test
    void deleteImpersonationToken_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/users/1/impersonation_tokens/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabUsersApi(GitLabCaller.of(client)).deleteImpersonationToken(1L, 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/users/1/impersonation_tokens/1");
    }

    @Test
    void deleteImpersonationToken_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/users/1/impersonation_tokens/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteImpersonationToken(1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/users/1/impersonation_tokens/1");
    }

    @Test
    void getUser_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/user",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabUserPublic.class, "user-public.json")));

        final GitLabUserPublic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client)).getUser();
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.userPublic());
        HTTP.verifyRequested(GET, "/api/v4/user");
    }

    @Test
    void getUser_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/user", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getUser());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/user");
    }

    @Test
    void creditCardValidation_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/user/user_id/credit_card_validation",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabUserCreditCardValidations.class, "user-credit-card-validations.json")));

        final GitLabUserCreditCardValidations result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client))
                    .creditCardValidation("user_id", UsersCatalogFixtures.usersCreditCardValidationPayload());
        }

        assertThat(result).isEqualTo(UsersCatalogFixtures.userCreditCardValidations());
        HTTP.verifyRequested(PUT, "/api/v4/user/user_id/credit_card_validation");
    }

    @Test
    void creditCardValidation_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/user/user_id/credit_card_validation", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.creditCardValidation("user_id", UsersCatalogFixtures.usersCreditCardValidationPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/user/user_id/credit_card_validation");
    }

    @Test
    void getUserSupportPin_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/user/support_pin",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabUserSupportPin.class, "user-support-pin.json")));

        final GitLabUserSupportPin result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client)).getUserSupportPin();
        }

        assertThat(result).isEqualTo(UsersCatalogFixtures.userSupportPin());
        HTTP.verifyRequested(GET, "/api/v4/user/support_pin");
    }

    @Test
    void getUserSupportPin_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/user/support_pin", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getUserSupportPin());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/user/support_pin");
    }

    @Test
    void createSupportPin_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/user/support_pin",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabUserSupportPin.class, "user-support-pin.json")));

        final GitLabUserSupportPin result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client)).createSupportPin();
        }

        assertThat(result).isEqualTo(UsersCatalogFixtures.userSupportPin());
        HTTP.verifyRequested(POST, "/api/v4/user/support_pin");
    }

    @Test
    void createSupportPin_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/user/support_pin", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createSupportPin());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/user/support_pin");
    }

    @Test
    void getPreferences_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/user/preferences",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabUserPreferences.class, "user-preferences.json")));

        final GitLabUserPreferences result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client)).getPreferences();
        }

        assertThat(result).isEqualTo(UsersCatalogFixtures.userPreferences());
        HTTP.verifyRequested(GET, "/api/v4/user/preferences");
    }

    @Test
    void getPreferences_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/user/preferences", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getPreferences());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/user/preferences");
    }

    @Test
    void updatePreference_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/user/preferences",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabUserPreferences.class, "user-preferences.json")));

        final GitLabUserPreferences result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client))
                    .updatePreference(UsersCatalogFixtures.usersUpdatePreferencePayload());
        }

        assertThat(result).isEqualTo(UsersCatalogFixtures.userPreferences());
        HTTP.verifyRequested(PUT, "/api/v4/user/preferences");
    }

    @Test
    void updatePreference_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/user/preferences", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updatePreference(UsersCatalogFixtures.usersUpdatePreferencePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/user/preferences");
    }

    @Test
    void listActivities_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/user/activities",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabUserActivity.class, "user-activity.json") + "]")
                        .header("Link", "<" + base + "/api/v4/user/activities?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabUserActivity.class, "user-activity.json") + "]"));

        final List<GitLabUserActivity> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabUsersApi(GitLabCaller.of(client)).listActivities().all();
        }

        assertThat(items).containsExactly(UsersCatalogFixtures.userActivity(), UsersCatalogFixtures.userActivity());
        HTTP.verifyRequested(GET, "/api/v4/user/activities", 2);
    }

    @Test
    void getUserStatus_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/user/status",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabUserStatus.class, "user-status.json")));

        final GitLabUserStatus result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client)).getUserStatus();
        }

        assertThat(result).isEqualTo(UsersCatalogFixtures.userStatus());
        HTTP.verifyRequested(GET, "/api/v4/user/status");
    }

    @Test
    void getUserStatus_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/user/status", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getUserStatus());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/user/status");
    }

    @Test
    void updateStatus_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/user/status",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabUserStatus.class, "user-status.json")));

        final GitLabUserStatus result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client))
                    .updateStatus(UsersCatalogFixtures.usersUpdateStatusPayload());
        }

        assertThat(result).isEqualTo(UsersCatalogFixtures.userStatus());
        HTTP.verifyRequested(PUT, "/api/v4/user/status");
    }

    @Test
    void updateStatus_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/user/status", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateStatus(UsersCatalogFixtures.usersUpdateStatusPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/user/status");
    }

    @Test
    void patchStatus_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PATCH,
                "/api/v4/user/status",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabUserStatus.class, "user-status.json")));

        final GitLabUserStatus result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client))
                    .patchStatus(UsersCatalogFixtures.usersPatchStatusPayload());
        }

        assertThat(result).isEqualTo(UsersCatalogFixtures.userStatus());
        HTTP.verifyRequested(PATCH, "/api/v4/user/status");
    }

    @Test
    void patchStatus_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PATCH, "/api/v4/user/status", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.patchStatus(UsersCatalogFixtures.usersPatchStatusPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PATCH, "/api/v4/user/status");
    }

    @Test
    void createRunner_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/user/runners",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabCiRunnerRegistrationDetails.class, "ci-runner-registration-details.json")));

        final GitLabCiRunnerRegistrationDetails result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client))
                    .createRunner(UsersCatalogFixtures.usersCreateRunnerPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciRunnerRegistrationDetails());
        HTTP.verifyRequested(POST, "/api/v4/user/runners");
    }

    @Test
    void createRunner_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/user/runners", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createRunner(UsersCatalogFixtures.usersCreateRunnerPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/user/runners");
    }

    @Test
    void getUserCounts_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/user_counts",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabUserCounts.class, "user-counts.json")));

        final GitLabUserCounts result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUsersApi(GitLabCaller.of(client)).getUserCounts();
        }

        assertThat(result).isEqualTo(UsersCatalogFixtures.userCounts());
        HTTP.verifyRequested(GET, "/api/v4/user_counts");
    }

    @Test
    void getUserCounts_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/user_counts", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUsersApi api = new GitLabUsersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getUserCounts());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/user_counts");
    }
}

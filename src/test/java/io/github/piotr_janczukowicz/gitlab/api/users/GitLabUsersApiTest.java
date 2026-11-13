package io.github.piotr_janczukowicz.gitlab.api.users;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiRunnerRegistrationDetails;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabDeployKey;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabEmail;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserPublic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserWithAdmin;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUsersApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabUsersApi api() {
        return new GitLabUsersApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabUsersApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void getUsersSupportPin_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabUserSupportPin.class, "user-support-pin.json")));

        final Optional<GitLabUserSupportPin> result = api().getUsersSupportPin(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(UsersCatalogFixtures.userSupportPin());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/1/support_pin");
        });
    }

    @Test
    void getUsersSupportPin_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabUserSupportPin> result = api().getUsersSupportPin(1L);

        assertThat(result).isEmpty();
    }

    @Test
    void revokeSupportPin_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().revokeSupportPin(1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/users/1/support_pin/revoke");
    }

    @Test
    void revokeSupportPin_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().revokeSupportPin(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabUserBasic.class, "user-basic.json") + "]"));

        final GitLabPage<GitLabUserBasic> page = api().list();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.userBasic());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabUserBasic.class, "user-basic.json") + "]"));

        final GitLabPage<GitLabUserBasic> page = api().list(GitLabUsersListFilterBuilder.builder()
                .username("username")
                .externUid("extern_uid")
                .publicEmail("public_email")
                .provider("provider")
                .search("search")
                .active(true)
                .humans(true)
                .external(true)
                .blocked(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .withoutProjects(true)
                .withoutProjectBots(true)
                .admins(true)
                .twoFactor("two_factor")
                .excludeActive(true)
                .excludeExternal(true)
                .excludeHumans(true)
                .excludeInternal(true)
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .skipLdap(true)
                .auditors(true)
                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.userBasic());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users");
            softly.assertThat(request.uri()).hasParameter("username", "username");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabUserBasic.class, "user-basic.json") + "]"));

        final GitLabPage<GitLabUserBasic> page = api().list(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.userBasic());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabUserBasic.class, "user-basic.json") + "]"));

        final GitLabPage<GitLabUserBasic> page = api().list(
                        GitLabUsersListFilterBuilder.builder()
                                .username("username")
                                .externUid("extern_uid")
                                .publicEmail("public_email")
                                .provider("provider")
                                .search("search")
                                .active(true)
                                .humans(true)
                                .external(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .withoutProjects(true)
                                .withoutProjectBots(true)
                                .admins(true)
                                .twoFactor("two_factor")
                                .excludeActive(true)
                                .excludeExternal(true)
                                .excludeHumans(true)
                                .excludeInternal(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .skipLdap(true)
                                .auditors(true)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.userBasic());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("username", "username");
        });
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabUserWithAdmin.class, "user-with-admin.json")));

        final GitLabUserWithAdmin result =
                api().create(MultipartFormData.builder().text("field", "value").build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.userWithAdmin());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/users");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().create(MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabUserProfile.class, "user-profile.json")));

        final Optional<GitLabUserProfile> result = api().get(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(UsersCatalogFixtures.userProfile());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/1");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabUserProfile> result = api().get(1L);

        assertThat(result).isEmpty();
    }

    @Test
    void get_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabUserProfile.class, "user-profile.json")));

        api().get(
                        1L,
                        GitLabUsersGetFilterBuilder.builder()
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("with_custom_attributes", "true");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabUserWithAdmin.class, "user-with-admin.json")));

        final GitLabUserWithAdmin result = api().update(
                        1L, MultipartFormData.builder().text("field", "value").build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.userWithAdmin());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("PUT /api/v4/users/1");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().update(
                        1L, MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabEmail.class, "email.json")));

        final Optional<GitLabEmail> result = api().delete(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.email());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/users/1");
        });
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        final Optional<GitLabEmail> result = api().delete(1L);

        assertThat(result).isEmpty();
    }

    @Test
    void delete_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabEmail.class, "email.json")));

        api().delete(
                        1L,
                        GitLabUsersDeleteFilterBuilder.builder()
                                .hardDelete(true)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("hard_delete", "true");
    }

    @Test
    void getUsersStatus_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabUserStatus.class, "user-status.json")));

        final Optional<GitLabUserStatus> result = api().getUsersStatus("user_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(UsersCatalogFixtures.userStatus());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/user_id/status");
        });
    }

    @Test
    void getUsersStatus_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabUserStatus> result = api().getUsersStatus("user_id");

        assertThat(result).isEmpty();
    }

    @Test
    void listFollowing_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabUserBasic.class, "user-basic.json") + "]"));

        final GitLabPage<GitLabUserBasic> page = api().listFollowing(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.userBasic());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/1/following");
        });
    }

    @Test
    void listFollowing_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabUserBasic.class, "user-basic.json") + "]"));

        final GitLabPage<GitLabUserBasic> page = api().listFollowing(1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.userBasic());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/1/following");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listFollowers_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabUserBasic.class, "user-basic.json") + "]"));

        final GitLabPage<GitLabUserBasic> page = api().listFollowers(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.userBasic());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/1/followers");
        });
    }

    @Test
    void listFollowers_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabUserBasic.class, "user-basic.json") + "]"));

        final GitLabPage<GitLabUserBasic> page = api().listFollowers(1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.userBasic());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/1/followers");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void disableTwoFactor_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabUserWithAdmin.class, "user-with-admin.json")));

        final GitLabUserWithAdmin result = api().disableTwoFactor(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.userWithAdmin());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("PATCH /api/v4/users/1/disable_two_factor");
        });
    }

    @Test
    void disableTwoFactor_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().disableTwoFactor(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteIdentity_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabUserWithAdmin.class, "user-with-admin.json")));

        final Optional<GitLabUserWithAdmin> result = api().deleteIdentity(1L, "provider");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.userWithAdmin());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("DELETE /api/v4/users/1/identities/provider");
        });
    }

    @Test
    void deleteIdentity_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteIdentity(1L, "provider"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteIdentity_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        final Optional<GitLabUserWithAdmin> result = api().deleteIdentity(1L, "provider");

        assertThat(result).isEmpty();
    }

    @Test
    void listProjectDeployKeys_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabDeployKey.class, "deploy-key.json") + "]"));

        final GitLabPage<GitLabDeployKey> page = api().listProjectDeployKeys("user_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.deployKey());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/users/user_id/project_deploy_keys");
        });
    }

    @Test
    void listProjectDeployKeys_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabDeployKey.class, "deploy-key.json") + "]"));

        final GitLabPage<GitLabDeployKey> page = api().listProjectDeployKeys("user_id", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.deployKey());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/users/user_id/project_deploy_keys");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listEmails_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabEmail.class, "email.json") + "]"));

        final GitLabPage<GitLabEmail> page = api().listEmails(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.email());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/1/emails");
        });
    }

    @Test
    void listEmails_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabEmail.class, "email.json") + "]"));

        final GitLabPage<GitLabEmail> page = api().listEmails(1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.email());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/1/emails");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createEmail_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabEmail.class, "email.json")));

        final GitLabEmail result = api().createEmail(1L, UsersCatalogFixtures.usersCreateEmailPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.email());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/users/1/emails");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"email\":");
        });
    }

    @Test
    void createEmail_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().createEmail(1L, UsersCatalogFixtures.usersCreateEmailPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteEmail_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabEmail.class, "email.json")));

        final Optional<GitLabEmail> result = api().deleteEmail(1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.email());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/users/1/emails/1");
        });
    }

    @Test
    void deleteEmail_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteEmail(1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteEmail_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        final Optional<GitLabEmail> result = api().deleteEmail(1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void activate_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().activate(1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/users/1/activate");
    }

    @Test
    void activate_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().activate(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deactivate_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deactivate(1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/users/1/deactivate");
    }

    @Test
    void deactivate_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deactivate(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void block_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().block(1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/users/1/block");
    }

    @Test
    void block_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().block(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void unblock_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().unblock(1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/users/1/unblock");
    }

    @Test
    void unblock_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().unblock(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void ban_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().ban(1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/users/1/ban");
    }

    @Test
    void ban_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().ban(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void unban_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().unban(1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/users/1/unban");
    }

    @Test
    void unban_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().unban(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listMemberships_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabMembership.class, "membership.json") + "]"));

        final GitLabPage<GitLabMembership> page = api().listMemberships(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(UsersCatalogFixtures.membership());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/1/memberships");
        });
    }

    @Test
    void listMemberships_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabMembership.class, "membership.json") + "]"));

        final GitLabPage<GitLabMembership> page = api().listMemberships(
                        1L,
                        GitLabUsersListMembershipsFilterBuilder.builder()
                                .type(GitLabUsersListMembershipsType.PROJECT)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(UsersCatalogFixtures.membership());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/1/memberships");
            softly.assertThat(request.uri()).hasParameter("type", "Project");
        });
    }

    @Test
    void listMemberships_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabMembership.class, "membership.json") + "]"));

        final GitLabPage<GitLabMembership> page = api().listMemberships(1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(UsersCatalogFixtures.membership());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/1/memberships");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listMemberships_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabMembership.class, "membership.json") + "]"));

        final GitLabPage<GitLabMembership> page = api().listMemberships(
                        1L,
                        GitLabUsersListMembershipsFilterBuilder.builder()
                                .type(GitLabUsersListMembershipsType.PROJECT)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(UsersCatalogFixtures.membership());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/1/memberships");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("type", "Project");
        });
    }

    @Test
    void getAssociationsCount_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabUserAssociationsCount.class, "user-associations-count.json")));

        final Optional<GitLabUserAssociationsCount> result = api().getAssociationsCount(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(UsersCatalogFixtures.userAssociationsCount());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/1/associations_count");
        });
    }

    @Test
    void getAssociationsCount_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabUserAssociationsCount> result = api().getAssociationsCount(1L);

        assertThat(result).isEmpty();
    }

    @Test
    void listImpersonationTokens_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabImpersonationToken.class, "impersonation-token.json") + "]"));

        final GitLabPage<GitLabImpersonationToken> page = api().listImpersonationTokens(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(UsersCatalogFixtures.impersonationToken());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/1/impersonation_tokens");
        });
    }

    @Test
    void listImpersonationTokens_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabImpersonationToken.class, "impersonation-token.json") + "]"));

        final GitLabPage<GitLabImpersonationToken> page = api().listImpersonationTokens(
                        1L,
                        GitLabUsersListImpersonationTokensFilterBuilder.builder()
                                .revoked(true)
                                .state(GitLabUsersListImpersonationTokensState.ALL)
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .expiresBefore(LocalDate.parse("2026-01-01"))
                                .expiresAfter(LocalDate.parse("2026-01-01"))
                                .search("search")
                                .sort("sort")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(UsersCatalogFixtures.impersonationToken());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/1/impersonation_tokens");
            softly.assertThat(request.uri()).hasParameter("revoked", "true");
        });
    }

    @Test
    void listImpersonationTokens_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabImpersonationToken.class, "impersonation-token.json") + "]"));

        final GitLabPage<GitLabImpersonationToken> page = api().listImpersonationTokens(1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(UsersCatalogFixtures.impersonationToken());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/1/impersonation_tokens");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listImpersonationTokens_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabImpersonationToken.class, "impersonation-token.json") + "]"));

        final GitLabPage<GitLabImpersonationToken> page = api().listImpersonationTokens(
                        1L,
                        GitLabUsersListImpersonationTokensFilterBuilder.builder()
                                .revoked(true)
                                .state(GitLabUsersListImpersonationTokensState.ALL)
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .expiresBefore(LocalDate.parse("2026-01-01"))
                                .expiresAfter(LocalDate.parse("2026-01-01"))
                                .search("search")
                                .sort("sort")
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(UsersCatalogFixtures.impersonationToken());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/1/impersonation_tokens");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("revoked", "true");
        });
    }

    @Test
    void createImpersonationToken_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabImpersonationTokenWithToken.class, "impersonation-token-with-token.json")));

        final GitLabImpersonationTokenWithToken result =
                api().createImpersonationToken(1L, UsersCatalogFixtures.usersCreateImpersonationTokenPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(UsersCatalogFixtures.impersonationTokenWithToken());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/users/1/impersonation_tokens");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void createImpersonationToken_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().createImpersonationToken(1L, UsersCatalogFixtures.usersCreateImpersonationTokenPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getImpersonationToken_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabImpersonationToken.class, "impersonation-token.json")));

        final Optional<GitLabImpersonationToken> result = api().getImpersonationToken(1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(UsersCatalogFixtures.impersonationToken());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/users/1/impersonation_tokens/1");
        });
    }

    @Test
    void getImpersonationToken_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabImpersonationToken> result = api().getImpersonationToken(1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void deleteImpersonationToken_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteImpersonationToken(1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/users/1/impersonation_tokens/1");
    }

    @Test
    void deleteImpersonationToken_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteImpersonationToken(1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getUser_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabUserPublic.class, "user-public.json")));

        final GitLabUserPublic result = api().getUser();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.userPublic());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/user");
        });
    }

    @Test
    void getUser_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getUser());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void creditCardValidation_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabUserCreditCardValidations.class, "user-credit-card-validations.json")));

        final GitLabUserCreditCardValidations result =
                api().creditCardValidation("user_id", UsersCatalogFixtures.usersCreditCardValidationPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(UsersCatalogFixtures.userCreditCardValidations());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/user/user_id/credit_card_validation");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"credit_card_validated_at\":");
        });
    }

    @Test
    void creditCardValidation_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().creditCardValidation("user_id", UsersCatalogFixtures.usersCreditCardValidationPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getUserSupportPin_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabUserSupportPin.class, "user-support-pin.json")));

        final GitLabUserSupportPin result = api().getUserSupportPin();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(UsersCatalogFixtures.userSupportPin());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/user/support_pin");
        });
    }

    @Test
    void getUserSupportPin_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getUserSupportPin());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createSupportPin_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabUserSupportPin.class, "user-support-pin.json")));

        final GitLabUserSupportPin result = api().createSupportPin();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(UsersCatalogFixtures.userSupportPin());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/user/support_pin");
        });
    }

    @Test
    void createSupportPin_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createSupportPin());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getPreferences_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabUserPreferences.class, "user-preferences.json")));

        final GitLabUserPreferences result = api().getPreferences();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(UsersCatalogFixtures.userPreferences());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/user/preferences");
        });
    }

    @Test
    void getPreferences_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getPreferences());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updatePreference_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabUserPreferences.class, "user-preferences.json")));

        final GitLabUserPreferences result =
                api().updatePreference(UsersCatalogFixtures.usersUpdatePreferencePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(UsersCatalogFixtures.userPreferences());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("PUT /api/v4/user/preferences");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"view_diffs_file_by_file\":");
        });
    }

    @Test
    void updatePreference_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().updatePreference(UsersCatalogFixtures.usersUpdatePreferencePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listActivities_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabUserActivity.class, "user-activity.json") + "]"));

        final GitLabPage<GitLabUserActivity> page = api().listActivities();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(UsersCatalogFixtures.userActivity());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/user/activities");
        });
    }

    @Test
    void listActivities_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabUserActivity.class, "user-activity.json") + "]"));

        final GitLabPage<GitLabUserActivity> page = api().listActivities(
                        GitLabUsersListActivitiesFilterBuilder.builder()
                                .fromValue(Instant.parse("2026-01-01T00:00:00Z"))
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(UsersCatalogFixtures.userActivity());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/user/activities");
            softly.assertThat(request.uri()).hasParameter("from", "2026-01-01T00:00:00Z");
        });
    }

    @Test
    void listActivities_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabUserActivity.class, "user-activity.json") + "]"));

        final GitLabPage<GitLabUserActivity> page = api().listActivities(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(UsersCatalogFixtures.userActivity());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/user/activities");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listActivities_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabUserActivity.class, "user-activity.json") + "]"));

        final GitLabPage<GitLabUserActivity> page = api().listActivities(
                        GitLabUsersListActivitiesFilterBuilder.builder()
                                .fromValue(Instant.parse("2026-01-01T00:00:00Z"))
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(UsersCatalogFixtures.userActivity());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/user/activities");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("from", "2026-01-01T00:00:00Z");
        });
    }

    @Test
    void getUserStatus_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabUserStatus.class, "user-status.json")));

        final GitLabUserStatus result = api().getUserStatus();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(UsersCatalogFixtures.userStatus());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/user/status");
        });
    }

    @Test
    void getUserStatus_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getUserStatus());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateStatus_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabUserStatus.class, "user-status.json")));

        final GitLabUserStatus result = api().updateStatus(UsersCatalogFixtures.usersUpdateStatusPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(UsersCatalogFixtures.userStatus());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("PUT /api/v4/user/status");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"emoji\":");
        });
    }

    @Test
    void updateStatus_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().updateStatus(UsersCatalogFixtures.usersUpdateStatusPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void patchStatus_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabUserStatus.class, "user-status.json")));

        final GitLabUserStatus result = api().patchStatus(UsersCatalogFixtures.usersPatchStatusPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(UsersCatalogFixtures.userStatus());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("PATCH /api/v4/user/status");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"emoji\":");
        });
    }

    @Test
    void patchStatus_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().patchStatus(UsersCatalogFixtures.usersPatchStatusPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createRunner_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabCiRunnerRegistrationDetails.class, "ci-runner-registration-details.json")));

        final GitLabCiRunnerRegistrationDetails result =
                api().createRunner(UsersCatalogFixtures.usersCreateRunnerPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.ciRunnerRegistrationDetails());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/user/runners");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"runner_type\":");
        });
    }

    @Test
    void createRunner_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().createRunner(UsersCatalogFixtures.usersCreateRunnerPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getUserCounts_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabUserCounts.class, "user-counts.json")));

        final GitLabUserCounts result = api().getUserCounts();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(UsersCatalogFixtures.userCounts());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/user_counts");
        });
    }

    @Test
    void getUserCounts_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getUserCounts());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}

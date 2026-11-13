package io.github.piotr_janczukowicz.gitlab.api.organizations;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOrganizationsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabOrganizationsApi api() {
        return new GitLabOrganizationsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabOrganizationsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabOrganization.class, "organization.json")));

        final GitLabOrganization result =
                api().create(MultipartFormData.builder().text("field", "value").build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(OrganizationsCatalogFixtures.organization());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/organizations");
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
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete(1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/organizations/1");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void restore_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabOrganization.class, "organization.json")));

        final GitLabOrganization result = api().restore(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(OrganizationsCatalogFixtures.organization());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/organizations/1/restore");
        });
    }

    @Test
    void restore_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().restore(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createTransferUser_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createTransferUser(1L, OrganizationsCatalogFixtures.organizationsCreateTransferUserPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/organizations/1/transfer_users");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"user_ids\":");
        });
    }

    @Test
    void createTransferUser_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().createTransferUser(1L, OrganizationsCatalogFixtures.organizationsCreateTransferUserPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listUsers_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabOrganizationUser.class, "organization-user.json") + "]"));

        final GitLabPage<GitLabOrganizationUser> page = api().listUsers(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(OrganizationsCatalogFixtures.organizationUser());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/organizations/1/users");
        });
    }

    @Test
    void listUsers_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabOrganizationUser.class, "organization-user.json") + "]"));

        final GitLabPage<GitLabOrganizationUser> page = api().listUsers(
                        1L,
                        GitLabOrganizationsListUsersFilterBuilder.builder()
                                .cursor("cursor")
                                .orderBy(GitLabOrganizationsListUsersOrderBy.ID)
                                .sort(GitLabOrganizationsListUsersSort.ASC)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(OrganizationsCatalogFixtures.organizationUser());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/organizations/1/users");
            softly.assertThat(request.uri()).hasParameter("cursor", "cursor");
        });
    }

    @Test
    void listUsers_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabOrganizationUser.class, "organization-user.json") + "]"));

        final GitLabPage<GitLabOrganizationUser> page = api().listUsers(1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(OrganizationsCatalogFixtures.organizationUser());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/organizations/1/users");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listUsers_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabOrganizationUser.class, "organization-user.json") + "]"));

        final GitLabPage<GitLabOrganizationUser> page = api().listUsers(
                        1L,
                        GitLabOrganizationsListUsersFilterBuilder.builder()
                                .cursor("cursor")
                                .orderBy(GitLabOrganizationsListUsersOrderBy.ID)
                                .sort(GitLabOrganizationsListUsersSort.ASC)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(OrganizationsCatalogFixtures.organizationUser());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/organizations/1/users");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("cursor", "cursor");
        });
    }

    @Test
    void createUser_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabOrganizationUser.class, "organization-user.json")));

        final GitLabOrganizationUser result =
                api().createUser(1L, OrganizationsCatalogFixtures.organizationsCreateUserPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(OrganizationsCatalogFixtures.organizationUser());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/organizations/1/users");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"username\":");
        });
    }

    @Test
    void createUser_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().createUser(1L, OrganizationsCatalogFixtures.organizationsCreateUserPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateUser_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabOrganizationUser.class, "organization-user.json")));

        final GitLabOrganizationUser result =
                api().updateUser(1L, 1L, OrganizationsCatalogFixtures.organizationsUpdateUserPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(OrganizationsCatalogFixtures.organizationUser());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("PUT /api/v4/organizations/1/users/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"access_level\":");
        });
    }

    @Test
    void updateUser_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().updateUser(1L, 1L, OrganizationsCatalogFixtures.organizationsUpdateUserPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteUser_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteUser(1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/organizations/1/users/1");
    }

    @Test
    void deleteUser_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteUser(1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}

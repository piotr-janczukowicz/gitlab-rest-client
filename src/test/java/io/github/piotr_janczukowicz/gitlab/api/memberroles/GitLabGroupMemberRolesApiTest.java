package io.github.piotr_janczukowicz.gitlab.api.memberroles;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMemberRole;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupMemberRolesApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabGroupMemberRolesApi api() {
        return new GitLabGroupMemberRolesApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabGroupMemberRolesApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void listGroup_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupMemberRolesApi lowTier =
                new GitLabGroupMemberRolesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listGroup("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listGroup_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupMemberRolesApi lowTier =
                new GitLabGroupMemberRolesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listGroup("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listGroup_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabMemberRole.class, "member-role.json") + "]"));

        final List<GitLabMemberRole> result = api().listGroup("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(CommonCatalogFixtures.memberRole());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/member_roles");
        });
    }

    @Test
    void createGroup_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupMemberRolesApi lowTier =
                new GitLabGroupMemberRolesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createGroup(
                "group/sub/project", MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createGroup_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupMemberRolesApi lowTier =
                new GitLabGroupMemberRolesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createGroup(
                "group/sub/project", MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createGroup_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabMemberRole.class, "member-role.json")));

        final GitLabMemberRole result =
                api().createGroup("group/sub/project", MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.memberRole());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/member_roles");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"base_access_level\":");
        });
    }

    @Test
    void createGroup_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createGroup(
                        "group/sub/project", MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteGroup_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupMemberRolesApi lowTier =
                new GitLabGroupMemberRolesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteGroup("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void deleteGroup_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupMemberRolesApi lowTier =
                new GitLabGroupMemberRolesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteGroup("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void deleteGroup_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteGroup("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/member_roles/1");
    }

    @Test
    void deleteGroup_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteGroup("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void list_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupMemberRolesApi lowTier =
                new GitLabGroupMemberRolesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list());

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void list_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupMemberRolesApi lowTier =
                new GitLabGroupMemberRolesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list());

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabMemberRole.class, "member-role.json") + "]"));

        final List<GitLabMemberRole> result = api().list();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(CommonCatalogFixtures.memberRole());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/member_roles");
        });
    }

    @Test
    void create_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupMemberRolesApi lowTier =
                new GitLabGroupMemberRolesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown =
                catchThrowable(() -> lowTier.create(MemberrolesCatalogFixtures.groupMemberRolesCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void create_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupMemberRolesApi lowTier =
                new GitLabGroupMemberRolesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown =
                catchThrowable(() -> lowTier.create(MemberrolesCatalogFixtures.groupMemberRolesCreatePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabMemberRole.class, "member-role.json")));

        final GitLabMemberRole result = api().create(MemberrolesCatalogFixtures.groupMemberRolesCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.memberRole());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/member_roles");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"base_access_level\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().create(MemberrolesCatalogFixtures.groupMemberRolesCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupMemberRolesApi lowTier =
                new GitLabGroupMemberRolesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.delete(1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void delete_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupMemberRolesApi lowTier =
                new GitLabGroupMemberRolesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.delete(1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete(1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/member_roles/1");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listAdminMemberRoles_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupMemberRolesApi lowTier =
                new GitLabGroupMemberRolesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listAdminMemberRoles());

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listAdminMemberRoles_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupMemberRolesApi lowTier =
                new GitLabGroupMemberRolesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listAdminMemberRoles());

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listAdminMemberRoles_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabMemberRole.class, "member-role.json") + "]"));

        final List<GitLabMemberRole> result = api().listAdminMemberRoles();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(CommonCatalogFixtures.memberRole());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/admin_member_roles");
        });
    }

    @Test
    void createAdminMemberRole_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupMemberRolesApi lowTier =
                new GitLabGroupMemberRolesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createAdminMemberRole(
                MemberrolesCatalogFixtures.groupMemberRolesCreateAdminMemberRolePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createAdminMemberRole_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupMemberRolesApi lowTier =
                new GitLabGroupMemberRolesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createAdminMemberRole(
                MemberrolesCatalogFixtures.groupMemberRolesCreateAdminMemberRolePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createAdminMemberRole_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabMemberRole.class, "member-role.json")));

        final GitLabMemberRole result =
                api().createAdminMemberRole(MemberrolesCatalogFixtures.groupMemberRolesCreateAdminMemberRolePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.memberRole());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/admin_member_roles");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void createAdminMemberRole_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().createAdminMemberRole(MemberrolesCatalogFixtures.groupMemberRolesCreateAdminMemberRolePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteAdminMemberRole_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupMemberRolesApi lowTier =
                new GitLabGroupMemberRolesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteAdminMemberRole(1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void deleteAdminMemberRole_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupMemberRolesApi lowTier =
                new GitLabGroupMemberRolesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteAdminMemberRole(1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void deleteAdminMemberRole_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteAdminMemberRole(1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/admin_member_roles/1");
    }

    @Test
    void deleteAdminMemberRole_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteAdminMemberRole(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}

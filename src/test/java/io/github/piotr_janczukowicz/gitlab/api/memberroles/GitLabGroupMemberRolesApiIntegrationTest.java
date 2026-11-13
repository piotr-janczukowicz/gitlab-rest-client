package io.github.piotr_janczukowicz.gitlab.api.memberroles;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMemberRole;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabGroupMemberRolesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void listGroup_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/member_roles",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabMemberRole.class, "member-role.json") + "]"));

        final List<GitLabMemberRole> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupMemberRolesApi(GitLabCaller.of(client)).listGroup("group/sub/project");
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.memberRole());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/member_roles");
    }

    @Test
    void createGroup_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/member_roles",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMemberRole.class, "member-role.json")));

        final GitLabMemberRole result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupMemberRolesApi(GitLabCaller.of(client))
                    .createGroup("group/sub/project", MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.memberRole());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/member_roles");
    }

    @Test
    void createGroup_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/member_roles", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupMemberRolesApi api = new GitLabGroupMemberRolesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createGroup(
                    "group/sub/project", MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/member_roles");
    }

    @Test
    void deleteGroup_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/member_roles/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupMemberRolesApi(GitLabCaller.of(client)).deleteGroup("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/member_roles/1");
    }

    @Test
    void deleteGroup_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/member_roles/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupMemberRolesApi api = new GitLabGroupMemberRolesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteGroup("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/member_roles/1");
    }

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/member_roles",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabMemberRole.class, "member-role.json") + "]"));

        final List<GitLabMemberRole> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupMemberRolesApi(GitLabCaller.of(client)).list();
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.memberRole());
        HTTP.verifyRequested(GET, "/api/v4/member_roles");
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/member_roles",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMemberRole.class, "member-role.json")));

        final GitLabMemberRole result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupMemberRolesApi(GitLabCaller.of(client))
                    .create(MemberrolesCatalogFixtures.groupMemberRolesCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.memberRole());
        HTTP.verifyRequested(POST, "/api/v4/member_roles");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/member_roles", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupMemberRolesApi api = new GitLabGroupMemberRolesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(MemberrolesCatalogFixtures.groupMemberRolesCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/member_roles");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/member_roles/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupMemberRolesApi(GitLabCaller.of(client)).delete(1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/member_roles/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/member_roles/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupMemberRolesApi api = new GitLabGroupMemberRolesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/member_roles/1");
    }

    @Test
    void listAdminMemberRoles_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/admin_member_roles",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabMemberRole.class, "member-role.json") + "]"));

        final List<GitLabMemberRole> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupMemberRolesApi(GitLabCaller.of(client)).listAdminMemberRoles();
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.memberRole());
        HTTP.verifyRequested(GET, "/api/v4/admin_member_roles");
    }

    @Test
    void createAdminMemberRole_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/admin_member_roles",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMemberRole.class, "member-role.json")));

        final GitLabMemberRole result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupMemberRolesApi(GitLabCaller.of(client))
                    .createAdminMemberRole(MemberrolesCatalogFixtures.groupMemberRolesCreateAdminMemberRolePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.memberRole());
        HTTP.verifyRequested(POST, "/api/v4/admin_member_roles");
    }

    @Test
    void createAdminMemberRole_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/admin_member_roles", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupMemberRolesApi api = new GitLabGroupMemberRolesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createAdminMemberRole(
                    MemberrolesCatalogFixtures.groupMemberRolesCreateAdminMemberRolePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/admin_member_roles");
    }

    @Test
    void deleteAdminMemberRole_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/admin_member_roles/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupMemberRolesApi(GitLabCaller.of(client)).deleteAdminMemberRole(1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/admin_member_roles/1");
    }

    @Test
    void deleteAdminMemberRole_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/admin_member_roles/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupMemberRolesApi api = new GitLabGroupMemberRolesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteAdminMemberRole(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/admin_member_roles/1");
    }
}

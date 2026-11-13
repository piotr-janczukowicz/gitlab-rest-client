package io.github.piotr_janczukowicz.gitlab.api.organizations;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabOrganizationsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/organizations",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabOrganization.class, "organization.json")));

        final GitLabOrganization result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabOrganizationsApi(GitLabCaller.of(client))
                    .create(MultipartFormData.builder().text("field", "value").build());
        }

        assertThat(result).isEqualTo(OrganizationsCatalogFixtures.organization());
        HTTP.verifyRequested(POST, "/api/v4/organizations");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/organizations", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabOrganizationsApi api = new GitLabOrganizationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/organizations");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/organizations/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabOrganizationsApi(GitLabCaller.of(client)).delete(1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/organizations/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/organizations/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabOrganizationsApi api = new GitLabOrganizationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/organizations/1");
    }

    @Test
    void restore_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/organizations/1/restore",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabOrganization.class, "organization.json")));

        final GitLabOrganization result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabOrganizationsApi(GitLabCaller.of(client)).restore(1L);
        }

        assertThat(result).isEqualTo(OrganizationsCatalogFixtures.organization());
        HTTP.verifyRequested(POST, "/api/v4/organizations/1/restore");
    }

    @Test
    void restore_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/organizations/1/restore", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabOrganizationsApi api = new GitLabOrganizationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.restore(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/organizations/1/restore");
    }

    @Test
    void createTransferUser_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/organizations/1/transfer_users", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabOrganizationsApi(GitLabCaller.of(client))
                    .createTransferUser(1L, OrganizationsCatalogFixtures.organizationsCreateTransferUserPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/organizations/1/transfer_users");
    }

    @Test
    void createTransferUser_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/organizations/1/transfer_users", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabOrganizationsApi api = new GitLabOrganizationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.createTransferUser(1L, OrganizationsCatalogFixtures.organizationsCreateTransferUserPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/organizations/1/transfer_users");
    }

    @Test
    void listUsers_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/organizations/1/users",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabOrganizationUser.class, "organization-user.json") + "]")
                        .header("Link", "<" + base + "/api/v4/organizations/1/users?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabOrganizationUser.class, "organization-user.json") + "]"));

        final List<GitLabOrganizationUser> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabOrganizationsApi(GitLabCaller.of(client))
                    .listUsers(1L)
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        OrganizationsCatalogFixtures.organizationUser(),
                        OrganizationsCatalogFixtures.organizationUser());
        HTTP.verifyRequested(GET, "/api/v4/organizations/1/users", 2);
    }

    @Test
    void createUser_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/organizations/1/users",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabOrganizationUser.class, "organization-user.json")));

        final GitLabOrganizationUser result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabOrganizationsApi(GitLabCaller.of(client))
                    .createUser(1L, OrganizationsCatalogFixtures.organizationsCreateUserPayload());
        }

        assertThat(result).isEqualTo(OrganizationsCatalogFixtures.organizationUser());
        HTTP.verifyRequested(POST, "/api/v4/organizations/1/users");
    }

    @Test
    void createUser_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/organizations/1/users", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabOrganizationsApi api = new GitLabOrganizationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.createUser(1L, OrganizationsCatalogFixtures.organizationsCreateUserPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/organizations/1/users");
    }

    @Test
    void updateUser_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/organizations/1/users/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabOrganizationUser.class, "organization-user.json")));

        final GitLabOrganizationUser result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabOrganizationsApi(GitLabCaller.of(client))
                    .updateUser(1L, 1L, OrganizationsCatalogFixtures.organizationsUpdateUserPayload());
        }

        assertThat(result).isEqualTo(OrganizationsCatalogFixtures.organizationUser());
        HTTP.verifyRequested(PUT, "/api/v4/organizations/1/users/1");
    }

    @Test
    void updateUser_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/organizations/1/users/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabOrganizationsApi api = new GitLabOrganizationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.updateUser(1L, 1L, OrganizationsCatalogFixtures.organizationsUpdateUserPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/organizations/1/users/1");
    }

    @Test
    void deleteUser_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/organizations/1/users/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabOrganizationsApi(GitLabCaller.of(client)).deleteUser(1L, 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/organizations/1/users/1");
    }

    @Test
    void deleteUser_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/organizations/1/users/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabOrganizationsApi api = new GitLabOrganizationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteUser(1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/organizations/1/users/1");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.license;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBasicSuccess;
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
class GitLabLicenseApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/license",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabGitlabLicenseWithActiveUsers.class, "gitlab-license-with-active-users.json")));

        final GitLabGitlabLicenseWithActiveUsers result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabLicenseApi(GitLabCaller.of(client)).get();
        }

        assertThat(result).isEqualTo(LicenseCatalogFixtures.gitlabLicenseWithActiveUsers());
        HTTP.verifyRequested(GET, "/api/v4/license");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/license", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabLicenseApi api = new GitLabLicenseApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.get());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/license");
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/license",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabGitlabLicenseWithActiveUsers.class, "gitlab-license-with-active-users.json")));

        final GitLabGitlabLicenseWithActiveUsers result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result =
                    new GitLabLicenseApi(GitLabCaller.of(client)).create(LicenseCatalogFixtures.licenseCreatePayload());
        }

        assertThat(result).isEqualTo(LicenseCatalogFixtures.gitlabLicenseWithActiveUsers());
        HTTP.verifyRequested(POST, "/api/v4/license");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/license", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabLicenseApi api = new GitLabLicenseApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(LicenseCatalogFixtures.licenseCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/license");
    }

    @Test
    void callUsageExport_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/license/usage_export", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabLicenseApi(GitLabCaller.of(client)).callUsageExport();
        }

        HTTP.verifyRequested(GET, "/api/v4/license/usage_export");
    }

    @Test
    void callUsageExport_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/license/usage_export", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabLicenseApi api = new GitLabLicenseApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callUsageExport());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/license/usage_export");
    }

    @Test
    void getById_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/license/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabGitlabLicenseWithActiveUsers.class, "gitlab-license-with-active-users.json")));

        final Optional<GitLabGitlabLicenseWithActiveUsers> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabLicenseApi(GitLabCaller.of(client)).getById(1L);
        }

        assertThat(result).contains(LicenseCatalogFixtures.gitlabLicenseWithActiveUsers());
        HTTP.verifyRequested(GET, "/api/v4/license/1");
    }

    @Test
    void getById_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/license/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabLicenseApi(GitLabCaller.of(client)).getById(1L).isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/license/1");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/license/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabLicenseApi(GitLabCaller.of(client)).delete(1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/license/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/license/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabLicenseApi api = new GitLabLicenseApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/license/1");
    }

    @Test
    void updateRefreshBillableUser_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/license/1/refresh_billable_users",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabBasicSuccess.class, "basic-success.json")));

        final GitLabBasicSuccess result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabLicenseApi(GitLabCaller.of(client)).updateRefreshBillableUser(1L);
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.basicSuccess());
        HTTP.verifyRequested(PUT, "/api/v4/license/1/refresh_billable_users");
    }

    @Test
    void updateRefreshBillableUser_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/license/1/refresh_billable_users", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabLicenseApi api = new GitLabLicenseApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateRefreshBillableUser(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/license/1/refresh_billable_users");
    }

    @Test
    void listLicenses_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/licenses",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabGitlabLicense.class, "gitlab-license.json") + "]"));

        final List<GitLabGitlabLicense> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabLicenseApi(GitLabCaller.of(client)).listLicenses();
        }

        assertThat(result).containsExactly(LicenseCatalogFixtures.gitlabLicense());
        HTTP.verifyRequested(GET, "/api/v4/licenses");
    }
}

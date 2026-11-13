package io.github.piotr_janczukowicz.gitlab.api.license;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBasicSuccess;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabLicenseApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabLicenseApi api() {
        return new GitLabLicenseApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabLicenseApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabGitlabLicenseWithActiveUsers.class, "gitlab-license-with-active-users.json")));

        final GitLabGitlabLicenseWithActiveUsers result = api().get();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(LicenseCatalogFixtures.gitlabLicenseWithActiveUsers());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/license");
        });
    }

    @Test
    void get_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().get());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabGitlabLicenseWithActiveUsers.class, "gitlab-license-with-active-users.json")));

        final GitLabGitlabLicenseWithActiveUsers result = api().create(LicenseCatalogFixtures.licenseCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(LicenseCatalogFixtures.gitlabLicenseWithActiveUsers());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/license");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"license\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().create(LicenseCatalogFixtures.licenseCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callUsageExport_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callUsageExport();

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/license/usage_export");
    }

    @Test
    void callUsageExport_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callUsageExport());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getById_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabGitlabLicenseWithActiveUsers.class, "gitlab-license-with-active-users.json")));

        final Optional<GitLabGitlabLicenseWithActiveUsers> result = api().getById(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(LicenseCatalogFixtures.gitlabLicenseWithActiveUsers());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/license/1");
        });
    }

    @Test
    void getById_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabGitlabLicenseWithActiveUsers> result = api().getById(1L);

        assertThat(result).isEmpty();
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete(1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/license/1");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateRefreshBillableUser_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabBasicSuccess.class, "basic-success.json")));

        final GitLabBasicSuccess result = api().updateRefreshBillableUser(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.basicSuccess());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/license/1/refresh_billable_users");
        });
    }

    @Test
    void updateRefreshBillableUser_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateRefreshBillableUser(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listLicenses_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabGitlabLicense.class, "gitlab-license.json") + "]"));

        final List<GitLabGitlabLicense> result = api().listLicenses();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(LicenseCatalogFixtures.gitlabLicense());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/licenses");
        });
    }
}

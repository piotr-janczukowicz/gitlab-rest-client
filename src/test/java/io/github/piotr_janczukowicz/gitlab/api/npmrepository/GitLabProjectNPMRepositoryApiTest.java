package io.github.piotr_janczukowicz.gitlab.api.npmrepository;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectNPMRepositoryApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectNPMRepositoryApi api() {
        return new GitLabProjectNPMRepositoryApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectNPMRepositoryApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void getProjectPackageDistTags_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabNpmPackageTag.class, "npm-package-tag.json")));

        final Optional<GitLabNpmPackageTag> result =
                api().getProjectPackageDistTags("group/sub/project", "package_name");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(NpmrepositoryCatalogFixtures.npmPackageTag());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/packages/npm/-/package/package_name/dist-tags");
        });
    }

    @Test
    void getProjectPackageDistTags_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabNpmPackageTag> result =
                api().getProjectPackageDistTags("group/sub/project", "package_name");

        assertThat(result).isEmpty();
    }

    @Test
    void updateProjectPackageDistTag_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().updateProjectPackageDistTag("group/sub/project", "package_name", "tag");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "PUT /api/v4/projects/group%2Fsub%2Fproject/packages/npm/-/package/package_name/dist-tags/tag");
    }

    @Test
    void updateProjectPackageDistTag_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().updateProjectPackageDistTag("group/sub/project", "package_name", "tag"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteProjectPackageDistTag_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteProjectPackageDistTag("group/sub/project", "package_name", "tag");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "DELETE /api/v4/projects/group%2Fsub%2Fproject/packages/npm/-/package/package_name/dist-tags/tag");
    }

    @Test
    void deleteProjectPackageDistTag_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().deleteProjectPackageDistTag("group/sub/project", "package_name", "tag"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void bulkProjectNpmV1SecurityAdvisory_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().bulkProjectNpmV1SecurityAdvisory("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "POST /api/v4/projects/group%2Fsub%2Fproject/packages/npm/-/npm/v1/security/advisories/bulk");
    }

    @Test
    void bulkProjectNpmV1SecurityAdvisory_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().bulkProjectNpmV1SecurityAdvisory("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void quickProjectNpmV1SecurityAudit_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().quickProjectNpmV1SecurityAudit("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/packages/npm/-/npm/v1/security/audits/quick");
    }

    @Test
    void quickProjectNpmV1SecurityAudit_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().quickProjectNpmV1SecurityAudit("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void call_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().call("group/sub/project", "package_name", "file_name");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/npm/package_name/-/file_name");
    }

    @Test
    void call_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().call("group/sub/project", "package_name", "file_name"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getProject_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabNpmPackage.class, "npm-package.json")));

        final Optional<GitLabNpmPackage> result = api().getProject("group/sub/project", "package_name");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(NpmrepositoryCatalogFixtures.npmPackage());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/npm/package_name");
        });
    }

    @Test
    void getProject_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabNpmPackage> result = api().getProject("group/sub/project", "package_name");

        assertThat(result).isEmpty();
    }

    @Test
    void update_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().update(
                        "group/sub/project",
                        "package_name",
                        MultipartFormData.builder().text("field", "value").build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/packages/npm/package_name");
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().update(
                        "group/sub/project",
                        "package_name",
                        MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getPackageDistTags_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabNpmPackageTag.class, "npm-package-tag.json")));

        final Optional<GitLabNpmPackageTag> result = api().getPackageDistTags("package_name");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(NpmrepositoryCatalogFixtures.npmPackageTag());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/packages/npm/-/package/package_name/dist-tags");
        });
    }

    @Test
    void getPackageDistTags_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabNpmPackageTag> result = api().getPackageDistTags("package_name");

        assertThat(result).isEmpty();
    }

    @Test
    void updatePackageDistTag_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().updatePackageDistTag("package_name", "tag");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("PUT /api/v4/packages/npm/-/package/package_name/dist-tags/tag");
    }

    @Test
    void updatePackageDistTag_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updatePackageDistTag("package_name", "tag"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deletePackageDistTag_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deletePackageDistTag("package_name", "tag");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/packages/npm/-/package/package_name/dist-tags/tag");
    }

    @Test
    void deletePackageDistTag_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deletePackageDistTag("package_name", "tag"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void bulkNpmV1SecurityAdvisory_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().bulkNpmV1SecurityAdvisory();

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("POST /api/v4/packages/npm/-/npm/v1/security/advisories/bulk");
    }

    @Test
    void bulkNpmV1SecurityAdvisory_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().bulkNpmV1SecurityAdvisory());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void quickNpmV1SecurityAudit_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().quickNpmV1SecurityAudit();

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("POST /api/v4/packages/npm/-/npm/v1/security/audits/quick");
    }

    @Test
    void quickNpmV1SecurityAudit_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().quickNpmV1SecurityAudit());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabNpmPackage.class, "npm-package.json")));

        final Optional<GitLabNpmPackage> result = api().get("package_name");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(NpmrepositoryCatalogFixtures.npmPackage());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/packages/npm/package_name");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabNpmPackage> result = api().get("package_name");

        assertThat(result).isEmpty();
    }

    @Test
    void getGroupPackageDistTags_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabNpmPackageTag.class, "npm-package-tag.json")));

        final Optional<GitLabNpmPackageTag> result = api().getGroupPackageDistTags("group/sub/project", "package_name");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(NpmrepositoryCatalogFixtures.npmPackageTag());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/-/package/package_name/dist-tags");
        });
    }

    @Test
    void getGroupPackageDistTags_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabNpmPackageTag> result = api().getGroupPackageDistTags("group/sub/project", "package_name");

        assertThat(result).isEmpty();
    }

    @Test
    void updateGroupPackageDistTag_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().updateGroupPackageDistTag("group/sub/project", "package_name", "tag");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "PUT /api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/-/package/package_name/dist-tags/tag");
    }

    @Test
    void updateGroupPackageDistTag_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().updateGroupPackageDistTag("group/sub/project", "package_name", "tag"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteGroupPackageDistTag_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteGroupPackageDistTag("group/sub/project", "package_name", "tag");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "DELETE /api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/-/package/package_name/dist-tags/tag");
    }

    @Test
    void deleteGroupPackageDistTag_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().deleteGroupPackageDistTag("group/sub/project", "package_name", "tag"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void bulkGroupNpmV1SecurityAdvisory_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().bulkGroupNpmV1SecurityAdvisory("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "POST /api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/-/npm/v1/security/advisories/bulk");
    }

    @Test
    void bulkGroupNpmV1SecurityAdvisory_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().bulkGroupNpmV1SecurityAdvisory("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void quickGroupNpmV1SecurityAudit_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().quickGroupNpmV1SecurityAudit("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/-/npm/v1/security/audits/quick");
    }

    @Test
    void quickGroupNpmV1SecurityAudit_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().quickGroupNpmV1SecurityAudit("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getGroup_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabNpmPackage.class, "npm-package.json")));

        final Optional<GitLabNpmPackage> result = api().getGroup("group/sub/project", "package_name");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(NpmrepositoryCatalogFixtures.npmPackage());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/package_name");
        });
    }

    @Test
    void getGroup_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabNpmPackage> result = api().getGroup("group/sub/project", "package_name");

        assertThat(result).isEmpty();
    }
}

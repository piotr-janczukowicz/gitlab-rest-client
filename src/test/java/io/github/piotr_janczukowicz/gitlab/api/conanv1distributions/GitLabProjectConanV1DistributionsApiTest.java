package io.github.piotr_janczukowicz.gitlab.api.conanv1distributions;

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
class GitLabProjectConanV1DistributionsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectConanV1DistributionsApi api() {
        return new GitLabProjectConanV1DistributionsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectConanV1DistributionsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void callProjectV1UsersAuthenticate_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callProjectV1UsersAuthenticate("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/users/authenticate");
    }

    @Test
    void callProjectV1UsersAuthenticate_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callProjectV1UsersAuthenticate("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callProjectV1UsersCheckCredentials_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callProjectV1UsersCheckCredentials("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/users/check_credentials");
    }

    @Test
    void callProjectV1UsersCheckCredentials_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callProjectV1UsersCheckCredentials("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callProjectV1ConansSearch_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callProjectV1ConansSearch("group/sub/project", "q");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/search");
            softly.assertThat(request.uri()).hasParameter("q", "q");
        });
    }

    @Test
    void callProjectV1ConansSearch_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callProjectV1ConansSearch("group/sub/project", "q"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callProjectV1ConansSearch_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callProjectV1ConansSearch(
                        "group/sub/project",
                        "q",
                        GitLabProjectConanV1DistributionsCallProjectV1ConansSearchFilterBuilder.builder()
                                .ignorecase(true)
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("ignorecase", "true");
    }

    @Test
    void
            callProjectV1ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel_shouldSendTheRequest_whenResponseIsNoContent()
                    throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callProjectV1ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel(
                        "group/sub/project", "package_name", "package_version", "package_username", "package_channel");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/search");
    }

    @Test
    void
            callProjectV1ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel_shouldThrowNotFound_whenResponseIsNotFound()
                    throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().callProjectV1ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel(
                                "group/sub/project",
                                "package_name",
                                "package_version",
                                "package_username",
                                "package_channel"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callProjectV1Ping_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callProjectV1Ping("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/ping");
    }

    @Test
    void callProjectV1Ping_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callProjectV1Ping("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getProjectV1ConansPackage_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabPackageConanPackageSnapshot.class, "package-conan-package-snapshot.json")));

        final Optional<GitLabPackageConanPackageSnapshot> result = api().getProjectV1ConansPackage(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "conan_package_reference");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(Conanv1distributionsCatalogFixtures.packageConanPackageSnapshot());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference");
        });
    }

    @Test
    void getProjectV1ConansPackage_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabPackageConanPackageSnapshot> result = api().getProjectV1ConansPackage(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "conan_package_reference");

        assertThat(result).isEmpty();
    }

    @Test
    void getProjectV1Conan_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabPackageConanRecipeSnapshot.class, "package-conan-recipe-snapshot.json")));

        final Optional<GitLabPackageConanRecipeSnapshot> result = api().getProjectV1Conan(
                        "group/sub/project", "package_name", "package_version", "package_username", "package_channel");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(Conanv1distributionsCatalogFixtures.packageConanRecipeSnapshot());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel");
        });
    }

    @Test
    void getProjectV1Conan_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabPackageConanRecipeSnapshot> result = api().getProjectV1Conan(
                        "group/sub/project", "package_name", "package_version", "package_username", "package_channel");

        assertThat(result).isEmpty();
    }

    @Test
    void deleteProjectV1Conan_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteProjectV1Conan(
                        "group/sub/project", "package_name", "package_version", "package_username", "package_channel");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "DELETE /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel");
    }

    @Test
    void deleteProjectV1Conan_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteProjectV1Conan(
                        "group/sub/project", "package_name", "package_version", "package_username", "package_channel"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getProjectV1ConansPackagesDigest_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabPackageConanPackageManifest.class, "package-conan-package-manifest.json")));

        final Optional<GitLabPackageConanPackageManifest> result = api().getProjectV1ConansPackagesDigest(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "conan_package_reference");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(Conanv1distributionsCatalogFixtures.packageConanPackageManifest());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/digest");
        });
    }

    @Test
    void getProjectV1ConansPackagesDigest_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabPackageConanPackageManifest> result = api().getProjectV1ConansPackagesDigest(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "conan_package_reference");

        assertThat(result).isEmpty();
    }

    @Test
    void getProjectV1ConansDigest_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabPackageConanRecipeManifest.class, "package-conan-recipe-manifest.json")));

        final Optional<GitLabPackageConanRecipeManifest> result = api().getProjectV1ConansDigest(
                        "group/sub/project", "package_name", "package_version", "package_username", "package_channel");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(Conanv1distributionsCatalogFixtures.packageConanRecipeManifest());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/digest");
        });
    }

    @Test
    void getProjectV1ConansDigest_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabPackageConanRecipeManifest> result = api().getProjectV1ConansDigest(
                        "group/sub/project", "package_name", "package_version", "package_username", "package_channel");

        assertThat(result).isEmpty();
    }

    @Test
    void getProjectV1ConansPackagesDownloadUrls_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabPackageConanPackageManifest.class, "package-conan-package-manifest.json")));

        final Optional<GitLabPackageConanPackageManifest> result = api().getProjectV1ConansPackagesDownloadUrls(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "conan_package_reference");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(Conanv1distributionsCatalogFixtures.packageConanPackageManifest());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/download_urls");
        });
    }

    @Test
    void getProjectV1ConansPackagesDownloadUrls_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabPackageConanPackageManifest> result = api().getProjectV1ConansPackagesDownloadUrls(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "conan_package_reference");

        assertThat(result).isEmpty();
    }

    @Test
    void getProjectV1ConansDownloadUrls_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabPackageConanRecipeManifest.class, "package-conan-recipe-manifest.json")));

        final Optional<GitLabPackageConanRecipeManifest> result = api().getProjectV1ConansDownloadUrls(
                        "group/sub/project", "package_name", "package_version", "package_username", "package_channel");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(Conanv1distributionsCatalogFixtures.packageConanRecipeManifest());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/download_urls");
        });
    }

    @Test
    void getProjectV1ConansDownloadUrls_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabPackageConanRecipeManifest> result = api().getProjectV1ConansDownloadUrls(
                        "group/sub/project", "package_name", "package_version", "package_username", "package_channel");

        assertThat(result).isEmpty();
    }

    @Test
    void createProjectV1ConansPackagesUploadUrl_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabPackageConanUploadUrls.class, "package-conan-upload-urls.json")));

        final GitLabPackageConanUploadUrls result = api().createProjectV1ConansPackagesUploadUrl(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "conan_package_reference");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(Conanv1distributionsCatalogFixtures.packageConanUploadUrls());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "POST /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/upload_urls");
        });
    }

    @Test
    void createProjectV1ConansPackagesUploadUrl_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createProjectV1ConansPackagesUploadUrl(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "conan_package_reference"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createProjectV1ConansUploadUrl_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabPackageConanUploadUrls.class, "package-conan-upload-urls.json")));

        final GitLabPackageConanUploadUrls result = api().createProjectV1ConansUploadUrl(
                        "group/sub/project", "package_name", "package_version", "package_username", "package_channel");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(Conanv1distributionsCatalogFixtures.packageConanUploadUrls());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "POST /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/upload_urls");
        });
    }

    @Test
    void createProjectV1ConansUploadUrl_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createProjectV1ConansUploadUrl(
                        "group/sub/project", "package_name", "package_version", "package_username", "package_channel"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callProjectV1FilesExport_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callProjectV1FilesExport(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        GitLabProjectConanV1DistributionsCallProjectV1FilesExportFileName.CONANFILE_PY);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py");
    }

    @Test
    void callProjectV1FilesExport_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callProjectV1FilesExport(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        GitLabProjectConanV1DistributionsCallProjectV1FilesExportFileName.CONANFILE_PY));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateProjectV1FilesExport_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().updateProjectV1FilesExport(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        GitLabProjectConanV1DistributionsUpdateProjectV1FilesExportFileName.CONANFILE_PY,
                        MultipartFormData.builder().text("field", "value").build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "PUT /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py");
    }

    @Test
    void updateProjectV1FilesExport_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateProjectV1FilesExport(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        GitLabProjectConanV1DistributionsUpdateProjectV1FilesExportFileName.CONANFILE_PY,
                        MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void authorizeProjectV1FilesExport_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().authorizeProjectV1FilesExport(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        GitLabProjectConanV1DistributionsAuthorizeProjectV1FilesExportFileName.CONANFILE_PY);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "PUT /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py/authorize");
    }

    @Test
    void authorizeProjectV1FilesExport_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().authorizeProjectV1FilesExport(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        GitLabProjectConanV1DistributionsAuthorizeProjectV1FilesExportFileName.CONANFILE_PY));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callProjectV1FilesPackage_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callProjectV1FilesPackage(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        "conan_package_reference",
                        "package_revision",
                        GitLabProjectConanV1DistributionsCallProjectV1FilesPackageFileName.CONANFILE_PY);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py");
    }

    @Test
    void callProjectV1FilesPackage_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callProjectV1FilesPackage(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        "conan_package_reference",
                        "package_revision",
                        GitLabProjectConanV1DistributionsCallProjectV1FilesPackageFileName.CONANFILE_PY));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateProjectV1FilesPackage_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().updateProjectV1FilesPackage(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        "conan_package_reference",
                        "package_revision",
                        GitLabProjectConanV1DistributionsUpdateProjectV1FilesPackageFileName.CONANFILE_PY,
                        MultipartFormData.builder().text("field", "value").build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "PUT /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py");
    }

    @Test
    void updateProjectV1FilesPackage_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateProjectV1FilesPackage(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        "conan_package_reference",
                        "package_revision",
                        GitLabProjectConanV1DistributionsUpdateProjectV1FilesPackageFileName.CONANFILE_PY,
                        MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void authorizeProjectV1FilesPackage_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().authorizeProjectV1FilesPackage(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        "conan_package_reference",
                        "package_revision",
                        GitLabProjectConanV1DistributionsAuthorizeProjectV1FilesPackageFileName.CONANFILE_PY);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "PUT /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py/authorize");
    }

    @Test
    void authorizeProjectV1FilesPackage_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().authorizeProjectV1FilesPackage(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        "conan_package_reference",
                        "package_revision",
                        GitLabProjectConanV1DistributionsAuthorizeProjectV1FilesPackageFileName.CONANFILE_PY));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callV1UsersAuthenticate_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callV1UsersAuthenticate();

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/packages/conan/v1/users/authenticate");
    }

    @Test
    void callV1UsersAuthenticate_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callV1UsersAuthenticate());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callV1UsersCheckCredentials_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callV1UsersCheckCredentials();

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/packages/conan/v1/users/check_credentials");
    }

    @Test
    void callV1UsersCheckCredentials_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callV1UsersCheckCredentials());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callV1ConansSearch_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callV1ConansSearch("q");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/packages/conan/v1/conans/search");
            softly.assertThat(request.uri()).hasParameter("q", "q");
        });
    }

    @Test
    void callV1ConansSearch_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callV1ConansSearch("q"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callV1ConansSearch_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callV1ConansSearch(
                        "q",
                        GitLabProjectConanV1DistributionsCallV1ConansSearchFilterBuilder.builder()
                                .ignorecase(true)
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("ignorecase", "true");
    }

    @Test
    void
            callV1ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel_shouldSendTheRequest_whenResponseIsNoContent()
                    throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callV1ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel(
                        "package_name", "package_version", "package_username", "package_channel");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/search");
    }

    @Test
    void
            callV1ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel_shouldThrowNotFound_whenResponseIsNotFound()
                    throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().callV1ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel(
                                "package_name", "package_version", "package_username", "package_channel"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callV1Ping_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callV1Ping();

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/packages/conan/v1/ping");
    }

    @Test
    void callV1Ping_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callV1Ping());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getV1ConansPackage_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabPackageConanPackageSnapshot.class, "package-conan-package-snapshot.json")));

        final Optional<GitLabPackageConanPackageSnapshot> result = api().getV1ConansPackage(
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "conan_package_reference");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(Conanv1distributionsCatalogFixtures.packageConanPackageSnapshot());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference");
        });
    }

    @Test
    void getV1ConansPackage_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabPackageConanPackageSnapshot> result = api().getV1ConansPackage(
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "conan_package_reference");

        assertThat(result).isEmpty();
    }

    @Test
    void getV1Conan_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabPackageConanRecipeSnapshot.class, "package-conan-recipe-snapshot.json")));

        final Optional<GitLabPackageConanRecipeSnapshot> result =
                api().getV1Conan("package_name", "package_version", "package_username", "package_channel");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(Conanv1distributionsCatalogFixtures.packageConanRecipeSnapshot());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel");
        });
    }

    @Test
    void getV1Conan_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabPackageConanRecipeSnapshot> result =
                api().getV1Conan("package_name", "package_version", "package_username", "package_channel");

        assertThat(result).isEmpty();
    }

    @Test
    void deleteV1Conan_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteV1Conan("package_name", "package_version", "package_username", "package_channel");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "DELETE /api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel");
    }

    @Test
    void deleteV1Conan_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().deleteV1Conan("package_name", "package_version", "package_username", "package_channel"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getV1ConansPackagesDigest_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabPackageConanPackageManifest.class, "package-conan-package-manifest.json")));

        final Optional<GitLabPackageConanPackageManifest> result = api().getV1ConansPackagesDigest(
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "conan_package_reference");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(Conanv1distributionsCatalogFixtures.packageConanPackageManifest());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/digest");
        });
    }

    @Test
    void getV1ConansPackagesDigest_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabPackageConanPackageManifest> result = api().getV1ConansPackagesDigest(
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "conan_package_reference");

        assertThat(result).isEmpty();
    }

    @Test
    void getV1ConansDigest_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabPackageConanRecipeManifest.class, "package-conan-recipe-manifest.json")));

        final Optional<GitLabPackageConanRecipeManifest> result =
                api().getV1ConansDigest("package_name", "package_version", "package_username", "package_channel");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(Conanv1distributionsCatalogFixtures.packageConanRecipeManifest());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/digest");
        });
    }

    @Test
    void getV1ConansDigest_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabPackageConanRecipeManifest> result =
                api().getV1ConansDigest("package_name", "package_version", "package_username", "package_channel");

        assertThat(result).isEmpty();
    }

    @Test
    void getV1ConansPackagesDownloadUrls_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabPackageConanPackageManifest.class, "package-conan-package-manifest.json")));

        final Optional<GitLabPackageConanPackageManifest> result = api().getV1ConansPackagesDownloadUrls(
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "conan_package_reference");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(Conanv1distributionsCatalogFixtures.packageConanPackageManifest());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/download_urls");
        });
    }

    @Test
    void getV1ConansPackagesDownloadUrls_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabPackageConanPackageManifest> result = api().getV1ConansPackagesDownloadUrls(
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "conan_package_reference");

        assertThat(result).isEmpty();
    }

    @Test
    void getV1ConansDownloadUrls_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabPackageConanRecipeManifest.class, "package-conan-recipe-manifest.json")));

        final Optional<GitLabPackageConanRecipeManifest> result =
                api().getV1ConansDownloadUrls("package_name", "package_version", "package_username", "package_channel");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(Conanv1distributionsCatalogFixtures.packageConanRecipeManifest());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/download_urls");
        });
    }

    @Test
    void getV1ConansDownloadUrls_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabPackageConanRecipeManifest> result =
                api().getV1ConansDownloadUrls("package_name", "package_version", "package_username", "package_channel");

        assertThat(result).isEmpty();
    }

    @Test
    void createV1ConansPackagesUploadUrl_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabPackageConanUploadUrls.class, "package-conan-upload-urls.json")));

        final GitLabPackageConanUploadUrls result = api().createV1ConansPackagesUploadUrl(
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "conan_package_reference");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(Conanv1distributionsCatalogFixtures.packageConanUploadUrls());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "POST /api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/upload_urls");
        });
    }

    @Test
    void createV1ConansPackagesUploadUrl_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createV1ConansPackagesUploadUrl(
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "conan_package_reference"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createV1ConansUploadUrl_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabPackageConanUploadUrls.class, "package-conan-upload-urls.json")));

        final GitLabPackageConanUploadUrls result =
                api().createV1ConansUploadUrl("package_name", "package_version", "package_username", "package_channel");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(Conanv1distributionsCatalogFixtures.packageConanUploadUrls());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "POST /api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/upload_urls");
        });
    }

    @Test
    void createV1ConansUploadUrl_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createV1ConansUploadUrl(
                        "package_name", "package_version", "package_username", "package_channel"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callV1FilesExport_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callV1FilesExport(
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        GitLabProjectConanV1DistributionsCallV1FilesExportFileName.CONANFILE_PY);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py");
    }

    @Test
    void callV1FilesExport_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callV1FilesExport(
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        GitLabProjectConanV1DistributionsCallV1FilesExportFileName.CONANFILE_PY));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateV1FilesExport_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().updateV1FilesExport(
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        GitLabProjectConanV1DistributionsUpdateV1FilesExportFileName.CONANFILE_PY,
                        MultipartFormData.builder().text("field", "value").build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "PUT /api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py");
    }

    @Test
    void updateV1FilesExport_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateV1FilesExport(
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        GitLabProjectConanV1DistributionsUpdateV1FilesExportFileName.CONANFILE_PY,
                        MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void authorizeV1FilesExport_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().authorizeV1FilesExport(
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        GitLabProjectConanV1DistributionsAuthorizeV1FilesExportFileName.CONANFILE_PY);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "PUT /api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py/authorize");
    }

    @Test
    void authorizeV1FilesExport_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().authorizeV1FilesExport(
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        GitLabProjectConanV1DistributionsAuthorizeV1FilesExportFileName.CONANFILE_PY));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callV1FilesPackage_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callV1FilesPackage(
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        "conan_package_reference",
                        "package_revision",
                        GitLabProjectConanV1DistributionsCallV1FilesPackageFileName.CONANFILE_PY);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py");
    }

    @Test
    void callV1FilesPackage_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callV1FilesPackage(
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        "conan_package_reference",
                        "package_revision",
                        GitLabProjectConanV1DistributionsCallV1FilesPackageFileName.CONANFILE_PY));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateV1FilesPackage_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().updateV1FilesPackage(
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        "conan_package_reference",
                        "package_revision",
                        GitLabProjectConanV1DistributionsUpdateV1FilesPackageFileName.CONANFILE_PY,
                        MultipartFormData.builder().text("field", "value").build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "PUT /api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py");
    }

    @Test
    void updateV1FilesPackage_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateV1FilesPackage(
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        "conan_package_reference",
                        "package_revision",
                        GitLabProjectConanV1DistributionsUpdateV1FilesPackageFileName.CONANFILE_PY,
                        MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void authorizeV1FilesPackage_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().authorizeV1FilesPackage(
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        "conan_package_reference",
                        "package_revision",
                        GitLabProjectConanV1DistributionsAuthorizeV1FilesPackageFileName.CONANFILE_PY);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "PUT /api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py/authorize");
    }

    @Test
    void authorizeV1FilesPackage_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().authorizeV1FilesPackage(
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        "conan_package_reference",
                        "package_revision",
                        GitLabProjectConanV1DistributionsAuthorizeV1FilesPackageFileName.CONANFILE_PY));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}

package io.github.piotr_janczukowicz.gitlab.api.conanv2distributions;

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
class GitLabProjectConanV2DistributionsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectConanV2DistributionsApi api() {
        return new GitLabProjectConanV2DistributionsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectConanV2DistributionsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void callV2UsersAuthenticate_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callV2UsersAuthenticate("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/users/authenticate");
    }

    @Test
    void callV2UsersAuthenticate_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callV2UsersAuthenticate("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callV2UsersCheckCredentials_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callV2UsersCheckCredentials("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/users/check_credentials");
    }

    @Test
    void callV2UsersCheckCredentials_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callV2UsersCheckCredentials("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callV2ConansSearch_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callV2ConansSearch("group/sub/project", "q");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/search");
            softly.assertThat(request.uri()).hasParameter("q", "q");
        });
    }

    @Test
    void callV2ConansSearch_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callV2ConansSearch("group/sub/project", "q"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callV2ConansSearch_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callV2ConansSearch(
                        "group/sub/project",
                        "q",
                        GitLabProjectConanV2DistributionsCallV2ConansSearchFilterBuilder.builder()
                                .ignorecase(true)
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("ignorecase", "true");
    }

    @Test
    void
            callV2ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel_shouldSendTheRequest_whenResponseIsNoContent()
                    throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callV2ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel(
                        "group/sub/project", "package_name", "package_version", "package_username", "package_channel");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/search");
    }

    @Test
    void
            callV2ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel_shouldThrowNotFound_whenResponseIsNotFound()
                    throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().callV2ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel(
                                "group/sub/project",
                                "package_name",
                                "package_version",
                                "package_username",
                                "package_channel"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getV2ConansLatest_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabPackageConanRevision.class, "package-conan-revision.json")));

        final Optional<GitLabPackageConanRevision> result = api().getV2ConansLatest(
                        "group/sub/project", "package_name", "package_version", "package_username", "package_channel");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(Conanv2distributionsCatalogFixtures.packageConanRevision());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/latest");
        });
    }

    @Test
    void getV2ConansLatest_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabPackageConanRevision> result = api().getV2ConansLatest(
                        "group/sub/project", "package_name", "package_version", "package_username", "package_channel");

        assertThat(result).isEmpty();
    }

    @Test
    void getV2ConansRevisions_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabPackageConanRecipeRevisions.class, "package-conan-recipe-revisions.json")));

        final Optional<GitLabPackageConanRecipeRevisions> result = api().getV2ConansRevisions(
                        "group/sub/project", "package_name", "package_version", "package_username", "package_channel");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(Conanv2distributionsCatalogFixtures.packageConanRecipeRevisions());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions");
        });
    }

    @Test
    void getV2ConansRevisions_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabPackageConanRecipeRevisions> result = api().getV2ConansRevisions(
                        "group/sub/project", "package_name", "package_version", "package_username", "package_channel");

        assertThat(result).isEmpty();
    }

    @Test
    void deleteV2ConansRevision_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteV2ConansRevision(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "DELETE /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision");
    }

    @Test
    void deleteV2ConansRevision_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteV2ConansRevision(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getV2ConansRevisionsFiles_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabPackageConanFilesList.class, "package-conan-files-list.json")));

        final Optional<GitLabPackageConanFilesList> result = api().getV2ConansRevisionsFiles(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(Conanv2distributionsCatalogFixtures.packageConanFilesList());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/files");
        });
    }

    @Test
    void getV2ConansRevisionsFiles_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabPackageConanFilesList> result = api().getV2ConansRevisionsFiles(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision");

        assertThat(result).isEmpty();
    }

    @Test
    void callV2ConansRevisionsFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callV2ConansRevisionsFile(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        GitLabProjectConanV2DistributionsCallV2ConansRevisionsFileName.CONANFILE_PY);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/files/conanfile.py");
    }

    @Test
    void callV2ConansRevisionsFile_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callV2ConansRevisionsFile(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        GitLabProjectConanV2DistributionsCallV2ConansRevisionsFileName.CONANFILE_PY));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateV2ConansRevisionsFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().updateV2ConansRevisionsFile(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        GitLabProjectConanV2DistributionsUpdateV2ConansRevisionsFileName.CONANFILE_PY,
                        MultipartFormData.builder().text("field", "value").build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "PUT /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/files/conanfile.py");
    }

    @Test
    void updateV2ConansRevisionsFile_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateV2ConansRevisionsFile(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        GitLabProjectConanV2DistributionsUpdateV2ConansRevisionsFileName.CONANFILE_PY,
                        MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void authorizeV2ConansRevisionsFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().authorizeV2ConansRevisionsFile(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        GitLabProjectConanV2DistributionsAuthorizeV2ConansRevisionsFileName.CONANFILE_PY);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "PUT /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/files/conanfile.py/authorize");
    }

    @Test
    void authorizeV2ConansRevisionsFile_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().authorizeV2ConansRevisionsFile(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        GitLabProjectConanV2DistributionsAuthorizeV2ConansRevisionsFileName.CONANFILE_PY));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callV2ConansRevisionsSearch_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callV2ConansRevisionsSearch(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/search");
    }

    @Test
    void callV2ConansRevisionsSearch_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callV2ConansRevisionsSearch(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getV2ConansRevisionsPackagesLatest_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabPackageConanRevision.class, "package-conan-revision.json")));

        final Optional<GitLabPackageConanRevision> result = api().getV2ConansRevisionsPackagesLatest(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        "conan_package_reference");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(Conanv2distributionsCatalogFixtures.packageConanRevision());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/latest");
        });
    }

    @Test
    void getV2ConansRevisionsPackagesLatest_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabPackageConanRevision> result = api().getV2ConansRevisionsPackagesLatest(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        "conan_package_reference");

        assertThat(result).isEmpty();
    }

    @Test
    void getV2ConansRevisionsPackagesRevisions_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabPackageConanPackageRevisions.class, "package-conan-package-revisions.json")));

        final Optional<GitLabPackageConanPackageRevisions> result = api().getV2ConansRevisionsPackagesRevisions(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        "conan_package_reference");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(Conanv2distributionsCatalogFixtures.packageConanPackageRevisions());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions");
        });
    }

    @Test
    void getV2ConansRevisionsPackagesRevisions_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabPackageConanPackageRevisions> result = api().getV2ConansRevisionsPackagesRevisions(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        "conan_package_reference");

        assertThat(result).isEmpty();
    }

    @Test
    void deleteV2ConansRevisionsPackagesRevision_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteV2ConansRevisionsPackagesRevision(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        "conan_package_reference",
                        "package_revision");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "DELETE /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions/package_revision");
    }

    @Test
    void deleteV2ConansRevisionsPackagesRevision_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteV2ConansRevisionsPackagesRevision(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        "conan_package_reference",
                        "package_revision"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getV2ConansRevisionsPackagesRevisionsFiles_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabPackageConanFilesList.class, "package-conan-files-list.json")));

        final Optional<GitLabPackageConanFilesList> result = api().getV2ConansRevisionsPackagesRevisionsFiles(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        "conan_package_reference",
                        "package_revision");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(Conanv2distributionsCatalogFixtures.packageConanFilesList());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions/package_revision/files");
        });
    }

    @Test
    void getV2ConansRevisionsPackagesRevisionsFiles_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabPackageConanFilesList> result = api().getV2ConansRevisionsPackagesRevisionsFiles(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        "conan_package_reference",
                        "package_revision");

        assertThat(result).isEmpty();
    }

    @Test
    void callV2ConansRevisionsPackagesRevisionsFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callV2ConansRevisionsPackagesRevisionsFile(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        "conan_package_reference",
                        "package_revision",
                        GitLabConanV2PackageFileCallFileName.CONANFILE_PY);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions/package_revision/files/conanfile.py");
    }

    @Test
    void callV2ConansRevisionsPackagesRevisionsFile_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callV2ConansRevisionsPackagesRevisionsFile(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        "conan_package_reference",
                        "package_revision",
                        GitLabConanV2PackageFileCallFileName.CONANFILE_PY));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateV2ConansRevisionsPackagesRevisionsFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().updateV2ConansRevisionsPackagesRevisionsFile(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        "conan_package_reference",
                        "package_revision",
                        GitLabConanV2PackageFileUpdateFileName.CONANFILE_PY,
                        MultipartFormData.builder().text("field", "value").build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "PUT /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions/package_revision/files/conanfile.py");
    }

    @Test
    void updateV2ConansRevisionsPackagesRevisionsFile_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateV2ConansRevisionsPackagesRevisionsFile(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        "conan_package_reference",
                        "package_revision",
                        GitLabConanV2PackageFileUpdateFileName.CONANFILE_PY,
                        MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void authorizeV2ConansRevisionsPackagesRevisionsFile_shouldSendTheRequest_whenResponseIsNoContent()
            throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().authorizeV2ConansRevisionsPackagesRevisionsFile(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        "conan_package_reference",
                        "package_revision",
                        GitLabConanV2PackageFileAuthorizeFileName.CONANFILE_PY);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "PUT /api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions/package_revision/files/conanfile.py/authorize");
    }

    @Test
    void authorizeV2ConansRevisionsPackagesRevisionsFile_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().authorizeV2ConansRevisionsPackagesRevisionsFile(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "package_username",
                        "package_channel",
                        "recipe_revision",
                        "conan_package_reference",
                        "package_revision",
                        GitLabConanV2PackageFileAuthorizeFileName.CONANFILE_PY));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}

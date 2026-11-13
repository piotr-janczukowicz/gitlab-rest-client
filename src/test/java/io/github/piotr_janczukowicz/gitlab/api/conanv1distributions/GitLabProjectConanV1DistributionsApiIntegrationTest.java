package io.github.piotr_janczukowicz.gitlab.api.conanv1distributions;

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
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectConanV1DistributionsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void callProjectV1UsersAuthenticate_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/users/authenticate",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .callProjectV1UsersAuthenticate("group/sub/project");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/users/authenticate");
    }

    @Test
    void callProjectV1UsersAuthenticate_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/users/authenticate",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callProjectV1UsersAuthenticate("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/users/authenticate");
    }

    @Test
    void callProjectV1UsersCheckCredentials_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/users/check_credentials",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .callProjectV1UsersCheckCredentials("group/sub/project");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/users/check_credentials");
    }

    @Test
    void callProjectV1UsersCheckCredentials_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/users/check_credentials",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callProjectV1UsersCheckCredentials("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/users/check_credentials");
    }

    @Test
    void callProjectV1ConansSearch_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/search",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .callProjectV1ConansSearch("group/sub/project", "q");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/search");
    }

    @Test
    void callProjectV1ConansSearch_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/search",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callProjectV1ConansSearch("group/sub/project", "q"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/search");
    }

    @Test
    void
            callProjectV1ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel_shouldSendTheRequest_whenResponseIsNoContent()
                    throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/search",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .callProjectV1ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel");
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/search");
    }

    @Test
    void
            callProjectV1ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel_shouldAnswerNotFound_whenResponseIsNotFound()
                    throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/search",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.callProjectV1ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/search");
    }

    @Test
    void callProjectV1Ping_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/ping", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client)).callProjectV1Ping("group/sub/project");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/ping");
    }

    @Test
    void callProjectV1Ping_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/ping", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callProjectV1Ping("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/ping");
    }

    @Test
    void getProjectV1ConansPackage_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPackageConanPackageSnapshot.class, "package-conan-package-snapshot.json")));

        final Optional<GitLabPackageConanPackageSnapshot> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .getProjectV1ConansPackage(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "conan_package_reference");
        }

        assertThat(result).contains(Conanv1distributionsCatalogFixtures.packageConanPackageSnapshot());
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference");
    }

    @Test
    void getProjectV1ConansPackage_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .getProjectV1ConansPackage(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "conan_package_reference")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference");
    }

    @Test
    void getProjectV1Conan_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPackageConanRecipeSnapshot.class, "package-conan-recipe-snapshot.json")));

        final Optional<GitLabPackageConanRecipeSnapshot> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .getProjectV1Conan(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel");
        }

        assertThat(result).contains(Conanv1distributionsCatalogFixtures.packageConanRecipeSnapshot());
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel");
    }

    @Test
    void getProjectV1Conan_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .getProjectV1Conan(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel");
    }

    @Test
    void deleteProjectV1Conan_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .deleteProjectV1Conan(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel");
        }

        HTTP.verifyRequested(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel");
    }

    @Test
    void deleteProjectV1Conan_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteProjectV1Conan(
                    "group/sub/project", "package_name", "package_version", "package_username", "package_channel"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel");
    }

    @Test
    void getProjectV1ConansPackagesDigest_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/digest",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPackageConanPackageManifest.class, "package-conan-package-manifest.json")));

        final Optional<GitLabPackageConanPackageManifest> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .getProjectV1ConansPackagesDigest(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "conan_package_reference");
        }

        assertThat(result).contains(Conanv1distributionsCatalogFixtures.packageConanPackageManifest());
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/digest");
    }

    @Test
    void getProjectV1ConansPackagesDigest_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/digest",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .getProjectV1ConansPackagesDigest(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "conan_package_reference")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/digest");
    }

    @Test
    void getProjectV1ConansDigest_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/digest",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPackageConanRecipeManifest.class, "package-conan-recipe-manifest.json")));

        final Optional<GitLabPackageConanRecipeManifest> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .getProjectV1ConansDigest(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel");
        }

        assertThat(result).contains(Conanv1distributionsCatalogFixtures.packageConanRecipeManifest());
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/digest");
    }

    @Test
    void getProjectV1ConansDigest_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/digest",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .getProjectV1ConansDigest(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/digest");
    }

    @Test
    void getProjectV1ConansPackagesDownloadUrls_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/download_urls",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPackageConanPackageManifest.class, "package-conan-package-manifest.json")));

        final Optional<GitLabPackageConanPackageManifest> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .getProjectV1ConansPackagesDownloadUrls(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "conan_package_reference");
        }

        assertThat(result).contains(Conanv1distributionsCatalogFixtures.packageConanPackageManifest());
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/download_urls");
    }

    @Test
    void getProjectV1ConansPackagesDownloadUrls_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/download_urls",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .getProjectV1ConansPackagesDownloadUrls(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "conan_package_reference")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/download_urls");
    }

    @Test
    void getProjectV1ConansDownloadUrls_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/download_urls",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPackageConanRecipeManifest.class, "package-conan-recipe-manifest.json")));

        final Optional<GitLabPackageConanRecipeManifest> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .getProjectV1ConansDownloadUrls(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel");
        }

        assertThat(result).contains(Conanv1distributionsCatalogFixtures.packageConanRecipeManifest());
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/download_urls");
    }

    @Test
    void getProjectV1ConansDownloadUrls_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/download_urls",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .getProjectV1ConansDownloadUrls(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/download_urls");
    }

    @Test
    void createProjectV1ConansPackagesUploadUrl_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/upload_urls",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabPackageConanUploadUrls.class, "package-conan-upload-urls.json")));

        final GitLabPackageConanUploadUrls result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .createProjectV1ConansPackagesUploadUrl(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "conan_package_reference");
        }

        assertThat(result).isEqualTo(Conanv1distributionsCatalogFixtures.packageConanUploadUrls());
        HTTP.verifyRequested(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/upload_urls");
    }

    @Test
    void createProjectV1ConansPackagesUploadUrl_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/upload_urls",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createProjectV1ConansPackagesUploadUrl(
                    "group/sub/project",
                    "package_name",
                    "package_version",
                    "package_username",
                    "package_channel",
                    "conan_package_reference"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/upload_urls");
    }

    @Test
    void createProjectV1ConansUploadUrl_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/upload_urls",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabPackageConanUploadUrls.class, "package-conan-upload-urls.json")));

        final GitLabPackageConanUploadUrls result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .createProjectV1ConansUploadUrl(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel");
        }

        assertThat(result).isEqualTo(Conanv1distributionsCatalogFixtures.packageConanUploadUrls());
        HTTP.verifyRequested(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/upload_urls");
    }

    @Test
    void createProjectV1ConansUploadUrl_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/upload_urls",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createProjectV1ConansUploadUrl(
                    "group/sub/project", "package_name", "package_version", "package_username", "package_channel"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/upload_urls");
    }

    @Test
    void callProjectV1FilesExport_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .callProjectV1FilesExport(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision",
                            GitLabProjectConanV1DistributionsCallProjectV1FilesExportFileName.CONANFILE_PY);
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py");
    }

    @Test
    void callProjectV1FilesExport_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callProjectV1FilesExport(
                    "group/sub/project",
                    "package_name",
                    "package_version",
                    "package_username",
                    "package_channel",
                    "recipe_revision",
                    GitLabProjectConanV1DistributionsCallProjectV1FilesExportFileName.CONANFILE_PY));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py");
    }

    @Test
    void updateProjectV1FilesExport_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .updateProjectV1FilesExport(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision",
                            GitLabProjectConanV1DistributionsUpdateProjectV1FilesExportFileName.CONANFILE_PY,
                            MultipartFormData.builder().text("field", "value").build());
        }

        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py");
    }

    @Test
    void updateProjectV1FilesExport_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateProjectV1FilesExport(
                    "group/sub/project",
                    "package_name",
                    "package_version",
                    "package_username",
                    "package_channel",
                    "recipe_revision",
                    GitLabProjectConanV1DistributionsUpdateProjectV1FilesExportFileName.CONANFILE_PY,
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py");
    }

    @Test
    void authorizeProjectV1FilesExport_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py/authorize",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .authorizeProjectV1FilesExport(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision",
                            GitLabProjectConanV1DistributionsAuthorizeProjectV1FilesExportFileName.CONANFILE_PY);
        }

        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py/authorize");
    }

    @Test
    void authorizeProjectV1FilesExport_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py/authorize",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorizeProjectV1FilesExport(
                    "group/sub/project",
                    "package_name",
                    "package_version",
                    "package_username",
                    "package_channel",
                    "recipe_revision",
                    GitLabProjectConanV1DistributionsAuthorizeProjectV1FilesExportFileName.CONANFILE_PY));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py/authorize");
    }

    @Test
    void callProjectV1FilesPackage_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .callProjectV1FilesPackage(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision",
                            "conan_package_reference",
                            "package_revision",
                            GitLabProjectConanV1DistributionsCallProjectV1FilesPackageFileName.CONANFILE_PY);
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py");
    }

    @Test
    void callProjectV1FilesPackage_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callProjectV1FilesPackage(
                    "group/sub/project",
                    "package_name",
                    "package_version",
                    "package_username",
                    "package_channel",
                    "recipe_revision",
                    "conan_package_reference",
                    "package_revision",
                    GitLabProjectConanV1DistributionsCallProjectV1FilesPackageFileName.CONANFILE_PY));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py");
    }

    @Test
    void updateProjectV1FilesPackage_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .updateProjectV1FilesPackage(
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
        }

        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py");
    }

    @Test
    void updateProjectV1FilesPackage_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateProjectV1FilesPackage(
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
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py");
    }

    @Test
    void authorizeProjectV1FilesPackage_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py/authorize",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .authorizeProjectV1FilesPackage(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision",
                            "conan_package_reference",
                            "package_revision",
                            GitLabProjectConanV1DistributionsAuthorizeProjectV1FilesPackageFileName.CONANFILE_PY);
        }

        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py/authorize");
    }

    @Test
    void authorizeProjectV1FilesPackage_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py/authorize",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorizeProjectV1FilesPackage(
                    "group/sub/project",
                    "package_name",
                    "package_version",
                    "package_username",
                    "package_channel",
                    "recipe_revision",
                    "conan_package_reference",
                    "package_revision",
                    GitLabProjectConanV1DistributionsAuthorizeProjectV1FilesPackageFileName.CONANFILE_PY));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py/authorize");
    }

    @Test
    void callV1UsersAuthenticate_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/packages/conan/v1/users/authenticate", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client)).callV1UsersAuthenticate();
        }

        HTTP.verifyRequested(GET, "/api/v4/packages/conan/v1/users/authenticate");
    }

    @Test
    void callV1UsersAuthenticate_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/packages/conan/v1/users/authenticate", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callV1UsersAuthenticate());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/packages/conan/v1/users/authenticate");
    }

    @Test
    void callV1UsersCheckCredentials_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/packages/conan/v1/users/check_credentials", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client)).callV1UsersCheckCredentials();
        }

        HTTP.verifyRequested(GET, "/api/v4/packages/conan/v1/users/check_credentials");
    }

    @Test
    void callV1UsersCheckCredentials_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/packages/conan/v1/users/check_credentials", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callV1UsersCheckCredentials());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/packages/conan/v1/users/check_credentials");
    }

    @Test
    void callV1ConansSearch_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/packages/conan/v1/conans/search", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client)).callV1ConansSearch("q");
        }

        HTTP.verifyRequested(GET, "/api/v4/packages/conan/v1/conans/search");
    }

    @Test
    void callV1ConansSearch_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/packages/conan/v1/conans/search", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callV1ConansSearch("q"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/packages/conan/v1/conans/search");
    }

    @Test
    void
            callV1ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel_shouldSendTheRequest_whenResponseIsNoContent()
                    throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/search",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .callV1ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel(
                            "package_name", "package_version", "package_username", "package_channel");
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/search");
    }

    @Test
    void
            callV1ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel_shouldAnswerNotFound_whenResponseIsNotFound()
                    throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/search",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.callV1ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel(
                            "package_name", "package_version", "package_username", "package_channel"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/search");
    }

    @Test
    void callV1Ping_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/packages/conan/v1/ping", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client)).callV1Ping();
        }

        HTTP.verifyRequested(GET, "/api/v4/packages/conan/v1/ping");
    }

    @Test
    void callV1Ping_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/packages/conan/v1/ping", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callV1Ping());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/packages/conan/v1/ping");
    }

    @Test
    void getV1ConansPackage_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPackageConanPackageSnapshot.class, "package-conan-package-snapshot.json")));

        final Optional<GitLabPackageConanPackageSnapshot> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .getV1ConansPackage(
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "conan_package_reference");
        }

        assertThat(result).contains(Conanv1distributionsCatalogFixtures.packageConanPackageSnapshot());
        HTTP.verifyRequested(
                GET,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference");
    }

    @Test
    void getV1ConansPackage_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .getV1ConansPackage(
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "conan_package_reference")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference");
    }

    @Test
    void getV1Conan_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPackageConanRecipeSnapshot.class, "package-conan-recipe-snapshot.json")));

        final Optional<GitLabPackageConanRecipeSnapshot> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .getV1Conan("package_name", "package_version", "package_username", "package_channel");
        }

        assertThat(result).contains(Conanv1distributionsCatalogFixtures.packageConanRecipeSnapshot());
        HTTP.verifyRequested(
                GET, "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel");
    }

    @Test
    void getV1Conan_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .getV1Conan("package_name", "package_version", "package_username", "package_channel")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET, "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel");
    }

    @Test
    void deleteV1Conan_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .deleteV1Conan("package_name", "package_version", "package_username", "package_channel");
        }

        HTTP.verifyRequested(
                DELETE,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel");
    }

    @Test
    void deleteV1Conan_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.deleteV1Conan("package_name", "package_version", "package_username", "package_channel"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                DELETE,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel");
    }

    @Test
    void getV1ConansPackagesDigest_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/digest",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPackageConanPackageManifest.class, "package-conan-package-manifest.json")));

        final Optional<GitLabPackageConanPackageManifest> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .getV1ConansPackagesDigest(
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "conan_package_reference");
        }

        assertThat(result).contains(Conanv1distributionsCatalogFixtures.packageConanPackageManifest());
        HTTP.verifyRequested(
                GET,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/digest");
    }

    @Test
    void getV1ConansPackagesDigest_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/digest",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .getV1ConansPackagesDigest(
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "conan_package_reference")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/digest");
    }

    @Test
    void getV1ConansDigest_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/digest",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPackageConanRecipeManifest.class, "package-conan-recipe-manifest.json")));

        final Optional<GitLabPackageConanRecipeManifest> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .getV1ConansDigest("package_name", "package_version", "package_username", "package_channel");
        }

        assertThat(result).contains(Conanv1distributionsCatalogFixtures.packageConanRecipeManifest());
        HTTP.verifyRequested(
                GET,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/digest");
    }

    @Test
    void getV1ConansDigest_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/digest",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .getV1ConansDigest("package_name", "package_version", "package_username", "package_channel")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/digest");
    }

    @Test
    void getV1ConansPackagesDownloadUrls_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/download_urls",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPackageConanPackageManifest.class, "package-conan-package-manifest.json")));

        final Optional<GitLabPackageConanPackageManifest> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .getV1ConansPackagesDownloadUrls(
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "conan_package_reference");
        }

        assertThat(result).contains(Conanv1distributionsCatalogFixtures.packageConanPackageManifest());
        HTTP.verifyRequested(
                GET,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/download_urls");
    }

    @Test
    void getV1ConansPackagesDownloadUrls_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/download_urls",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .getV1ConansPackagesDownloadUrls(
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "conan_package_reference")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/download_urls");
    }

    @Test
    void getV1ConansDownloadUrls_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/download_urls",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPackageConanRecipeManifest.class, "package-conan-recipe-manifest.json")));

        final Optional<GitLabPackageConanRecipeManifest> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .getV1ConansDownloadUrls("package_name", "package_version", "package_username", "package_channel");
        }

        assertThat(result).contains(Conanv1distributionsCatalogFixtures.packageConanRecipeManifest());
        HTTP.verifyRequested(
                GET,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/download_urls");
    }

    @Test
    void getV1ConansDownloadUrls_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/download_urls",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .getV1ConansDownloadUrls("package_name", "package_version", "package_username", "package_channel")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/download_urls");
    }

    @Test
    void createV1ConansPackagesUploadUrl_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/upload_urls",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabPackageConanUploadUrls.class, "package-conan-upload-urls.json")));

        final GitLabPackageConanUploadUrls result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .createV1ConansPackagesUploadUrl(
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "conan_package_reference");
        }

        assertThat(result).isEqualTo(Conanv1distributionsCatalogFixtures.packageConanUploadUrls());
        HTTP.verifyRequested(
                POST,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/upload_urls");
    }

    @Test
    void createV1ConansPackagesUploadUrl_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/upload_urls",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createV1ConansPackagesUploadUrl(
                    "package_name",
                    "package_version",
                    "package_username",
                    "package_channel",
                    "conan_package_reference"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                POST,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/packages/conan_package_reference/upload_urls");
    }

    @Test
    void createV1ConansUploadUrl_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/upload_urls",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabPackageConanUploadUrls.class, "package-conan-upload-urls.json")));

        final GitLabPackageConanUploadUrls result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .createV1ConansUploadUrl("package_name", "package_version", "package_username", "package_channel");
        }

        assertThat(result).isEqualTo(Conanv1distributionsCatalogFixtures.packageConanUploadUrls());
        HTTP.verifyRequested(
                POST,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/upload_urls");
    }

    @Test
    void createV1ConansUploadUrl_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/upload_urls",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createV1ConansUploadUrl(
                    "package_name", "package_version", "package_username", "package_channel"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                POST,
                "/api/v4/packages/conan/v1/conans/package_name/package_version/package_username/package_channel/upload_urls");
    }

    @Test
    void callV1FilesExport_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .callV1FilesExport(
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision",
                            GitLabProjectConanV1DistributionsCallV1FilesExportFileName.CONANFILE_PY);
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py");
    }

    @Test
    void callV1FilesExport_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callV1FilesExport(
                    "package_name",
                    "package_version",
                    "package_username",
                    "package_channel",
                    "recipe_revision",
                    GitLabProjectConanV1DistributionsCallV1FilesExportFileName.CONANFILE_PY));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py");
    }

    @Test
    void updateV1FilesExport_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .updateV1FilesExport(
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision",
                            GitLabProjectConanV1DistributionsUpdateV1FilesExportFileName.CONANFILE_PY,
                            MultipartFormData.builder().text("field", "value").build());
        }

        HTTP.verifyRequested(
                PUT,
                "/api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py");
    }

    @Test
    void updateV1FilesExport_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateV1FilesExport(
                    "package_name",
                    "package_version",
                    "package_username",
                    "package_channel",
                    "recipe_revision",
                    GitLabProjectConanV1DistributionsUpdateV1FilesExportFileName.CONANFILE_PY,
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT,
                "/api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py");
    }

    @Test
    void authorizeV1FilesExport_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py/authorize",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .authorizeV1FilesExport(
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision",
                            GitLabProjectConanV1DistributionsAuthorizeV1FilesExportFileName.CONANFILE_PY);
        }

        HTTP.verifyRequested(
                PUT,
                "/api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py/authorize");
    }

    @Test
    void authorizeV1FilesExport_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py/authorize",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorizeV1FilesExport(
                    "package_name",
                    "package_version",
                    "package_username",
                    "package_channel",
                    "recipe_revision",
                    GitLabProjectConanV1DistributionsAuthorizeV1FilesExportFileName.CONANFILE_PY));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT,
                "/api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/export/conanfile.py/authorize");
    }

    @Test
    void callV1FilesPackage_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .callV1FilesPackage(
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision",
                            "conan_package_reference",
                            "package_revision",
                            GitLabProjectConanV1DistributionsCallV1FilesPackageFileName.CONANFILE_PY);
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py");
    }

    @Test
    void callV1FilesPackage_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callV1FilesPackage(
                    "package_name",
                    "package_version",
                    "package_username",
                    "package_channel",
                    "recipe_revision",
                    "conan_package_reference",
                    "package_revision",
                    GitLabProjectConanV1DistributionsCallV1FilesPackageFileName.CONANFILE_PY));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py");
    }

    @Test
    void updateV1FilesPackage_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .updateV1FilesPackage(
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision",
                            "conan_package_reference",
                            "package_revision",
                            GitLabProjectConanV1DistributionsUpdateV1FilesPackageFileName.CONANFILE_PY,
                            MultipartFormData.builder().text("field", "value").build());
        }

        HTTP.verifyRequested(
                PUT,
                "/api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py");
    }

    @Test
    void updateV1FilesPackage_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateV1FilesPackage(
                    "package_name",
                    "package_version",
                    "package_username",
                    "package_channel",
                    "recipe_revision",
                    "conan_package_reference",
                    "package_revision",
                    GitLabProjectConanV1DistributionsUpdateV1FilesPackageFileName.CONANFILE_PY,
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT,
                "/api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py");
    }

    @Test
    void authorizeV1FilesPackage_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py/authorize",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client))
                    .authorizeV1FilesPackage(
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision",
                            "conan_package_reference",
                            "package_revision",
                            GitLabProjectConanV1DistributionsAuthorizeV1FilesPackageFileName.CONANFILE_PY);
        }

        HTTP.verifyRequested(
                PUT,
                "/api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py/authorize");
    }

    @Test
    void authorizeV1FilesPackage_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py/authorize",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV1DistributionsApi api =
                    new GitLabProjectConanV1DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorizeV1FilesPackage(
                    "package_name",
                    "package_version",
                    "package_username",
                    "package_channel",
                    "recipe_revision",
                    "conan_package_reference",
                    "package_revision",
                    GitLabProjectConanV1DistributionsAuthorizeV1FilesPackageFileName.CONANFILE_PY));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT,
                "/api/v4/packages/conan/v1/files/package_name/package_version/package_username/package_channel/recipe_revision/package/conan_package_reference/package_revision/conanfile.py/authorize");
    }
}

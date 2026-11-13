package io.github.piotr_janczukowicz.gitlab.api.conanv2distributions;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
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
class GitLabProjectConanV2DistributionsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void callV2UsersAuthenticate_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/users/authenticate",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client))
                    .callV2UsersAuthenticate("group/sub/project");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/users/authenticate");
    }

    @Test
    void callV2UsersAuthenticate_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/users/authenticate",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV2DistributionsApi api =
                    new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callV2UsersAuthenticate("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/users/authenticate");
    }

    @Test
    void callV2UsersCheckCredentials_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/users/check_credentials",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client))
                    .callV2UsersCheckCredentials("group/sub/project");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/users/check_credentials");
    }

    @Test
    void callV2UsersCheckCredentials_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/users/check_credentials",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV2DistributionsApi api =
                    new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callV2UsersCheckCredentials("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/users/check_credentials");
    }

    @Test
    void callV2ConansSearch_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/search",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client))
                    .callV2ConansSearch("group/sub/project", "q");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/search");
    }

    @Test
    void callV2ConansSearch_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/search",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV2DistributionsApi api =
                    new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callV2ConansSearch("group/sub/project", "q"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/search");
    }

    @Test
    void
            callV2ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel_shouldSendTheRequest_whenResponseIsNoContent()
                    throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/search",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client))
                    .callV2ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel");
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/search");
    }

    @Test
    void
            callV2ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel_shouldAnswerNotFound_whenResponseIsNotFound()
                    throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/search",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV2DistributionsApi api =
                    new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.callV2ConansSearchByPackageNameAndPackageVersionAndPackageUsernameAndPackageChannel(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/search");
    }

    @Test
    void getV2ConansLatest_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/latest",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabPackageConanRevision.class, "package-conan-revision.json")));

        final Optional<GitLabPackageConanRevision> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client))
                    .getV2ConansLatest(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel");
        }

        assertThat(result).contains(Conanv2distributionsCatalogFixtures.packageConanRevision());
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/latest");
    }

    @Test
    void getV2ConansLatest_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/latest",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client))
                    .getV2ConansLatest(
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
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/latest");
    }

    @Test
    void getV2ConansRevisions_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPackageConanRecipeRevisions.class, "package-conan-recipe-revisions.json")));

        final Optional<GitLabPackageConanRecipeRevisions> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client))
                    .getV2ConansRevisions(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel");
        }

        assertThat(result).contains(Conanv2distributionsCatalogFixtures.packageConanRecipeRevisions());
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions");
    }

    @Test
    void getV2ConansRevisions_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client))
                    .getV2ConansRevisions(
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
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions");
    }

    @Test
    void deleteV2ConansRevision_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client))
                    .deleteV2ConansRevision(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision");
        }

        HTTP.verifyRequested(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision");
    }

    @Test
    void deleteV2ConansRevision_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV2DistributionsApi api =
                    new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteV2ConansRevision(
                    "group/sub/project",
                    "package_name",
                    "package_version",
                    "package_username",
                    "package_channel",
                    "recipe_revision"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision");
    }

    @Test
    void getV2ConansRevisionsFiles_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/files",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabPackageConanFilesList.class, "package-conan-files-list.json")));

        final Optional<GitLabPackageConanFilesList> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client))
                    .getV2ConansRevisionsFiles(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision");
        }

        assertThat(result).contains(Conanv2distributionsCatalogFixtures.packageConanFilesList());
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/files");
    }

    @Test
    void getV2ConansRevisionsFiles_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/files",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client))
                    .getV2ConansRevisionsFiles(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/files");
    }

    @Test
    void callV2ConansRevisionsFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/files/conanfile.py",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client))
                    .callV2ConansRevisionsFile(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision",
                            GitLabProjectConanV2DistributionsCallV2ConansRevisionsFileName.CONANFILE_PY);
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/files/conanfile.py");
    }

    @Test
    void callV2ConansRevisionsFile_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/files/conanfile.py",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV2DistributionsApi api =
                    new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callV2ConansRevisionsFile(
                    "group/sub/project",
                    "package_name",
                    "package_version",
                    "package_username",
                    "package_channel",
                    "recipe_revision",
                    GitLabProjectConanV2DistributionsCallV2ConansRevisionsFileName.CONANFILE_PY));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/files/conanfile.py");
    }

    @Test
    void updateV2ConansRevisionsFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/files/conanfile.py",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client))
                    .updateV2ConansRevisionsFile(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision",
                            GitLabProjectConanV2DistributionsUpdateV2ConansRevisionsFileName.CONANFILE_PY,
                            MultipartFormData.builder().text("field", "value").build());
        }

        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/files/conanfile.py");
    }

    @Test
    void updateV2ConansRevisionsFile_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/files/conanfile.py",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV2DistributionsApi api =
                    new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateV2ConansRevisionsFile(
                    "group/sub/project",
                    "package_name",
                    "package_version",
                    "package_username",
                    "package_channel",
                    "recipe_revision",
                    GitLabProjectConanV2DistributionsUpdateV2ConansRevisionsFileName.CONANFILE_PY,
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/files/conanfile.py");
    }

    @Test
    void authorizeV2ConansRevisionsFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/files/conanfile.py/authorize",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client))
                    .authorizeV2ConansRevisionsFile(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision",
                            GitLabProjectConanV2DistributionsAuthorizeV2ConansRevisionsFileName.CONANFILE_PY);
        }

        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/files/conanfile.py/authorize");
    }

    @Test
    void authorizeV2ConansRevisionsFile_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/files/conanfile.py/authorize",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV2DistributionsApi api =
                    new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorizeV2ConansRevisionsFile(
                    "group/sub/project",
                    "package_name",
                    "package_version",
                    "package_username",
                    "package_channel",
                    "recipe_revision",
                    GitLabProjectConanV2DistributionsAuthorizeV2ConansRevisionsFileName.CONANFILE_PY));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/files/conanfile.py/authorize");
    }

    @Test
    void callV2ConansRevisionsSearch_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/search",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client))
                    .callV2ConansRevisionsSearch(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision");
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/search");
    }

    @Test
    void callV2ConansRevisionsSearch_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/search",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV2DistributionsApi api =
                    new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callV2ConansRevisionsSearch(
                    "group/sub/project",
                    "package_name",
                    "package_version",
                    "package_username",
                    "package_channel",
                    "recipe_revision"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/search");
    }

    @Test
    void getV2ConansRevisionsPackagesLatest_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/latest",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabPackageConanRevision.class, "package-conan-revision.json")));

        final Optional<GitLabPackageConanRevision> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client))
                    .getV2ConansRevisionsPackagesLatest(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision",
                            "conan_package_reference");
        }

        assertThat(result).contains(Conanv2distributionsCatalogFixtures.packageConanRevision());
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/latest");
    }

    @Test
    void getV2ConansRevisionsPackagesLatest_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/latest",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client))
                    .getV2ConansRevisionsPackagesLatest(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision",
                            "conan_package_reference")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/latest");
    }

    @Test
    void getV2ConansRevisionsPackagesRevisions_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabPackageConanPackageRevisions.class, "package-conan-package-revisions.json")));

        final Optional<GitLabPackageConanPackageRevisions> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client))
                    .getV2ConansRevisionsPackagesRevisions(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision",
                            "conan_package_reference");
        }

        assertThat(result).contains(Conanv2distributionsCatalogFixtures.packageConanPackageRevisions());
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions");
    }

    @Test
    void getV2ConansRevisionsPackagesRevisions_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client))
                    .getV2ConansRevisionsPackagesRevisions(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision",
                            "conan_package_reference")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions");
    }

    @Test
    void deleteV2ConansRevisionsPackagesRevision_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions/package_revision",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client))
                    .deleteV2ConansRevisionsPackagesRevision(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision",
                            "conan_package_reference",
                            "package_revision");
        }

        HTTP.verifyRequested(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions/package_revision");
    }

    @Test
    void deleteV2ConansRevisionsPackagesRevision_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions/package_revision",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV2DistributionsApi api =
                    new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteV2ConansRevisionsPackagesRevision(
                    "group/sub/project",
                    "package_name",
                    "package_version",
                    "package_username",
                    "package_channel",
                    "recipe_revision",
                    "conan_package_reference",
                    "package_revision"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions/package_revision");
    }

    @Test
    void getV2ConansRevisionsPackagesRevisionsFiles_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions/package_revision/files",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabPackageConanFilesList.class, "package-conan-files-list.json")));

        final Optional<GitLabPackageConanFilesList> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client))
                    .getV2ConansRevisionsPackagesRevisionsFiles(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision",
                            "conan_package_reference",
                            "package_revision");
        }

        assertThat(result).contains(Conanv2distributionsCatalogFixtures.packageConanFilesList());
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions/package_revision/files");
    }

    @Test
    void getV2ConansRevisionsPackagesRevisionsFiles_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions/package_revision/files",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client))
                    .getV2ConansRevisionsPackagesRevisionsFiles(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision",
                            "conan_package_reference",
                            "package_revision")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions/package_revision/files");
    }

    @Test
    void callV2ConansRevisionsPackagesRevisionsFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions/package_revision/files/conanfile.py",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client))
                    .callV2ConansRevisionsPackagesRevisionsFile(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision",
                            "conan_package_reference",
                            "package_revision",
                            GitLabConanV2PackageFileCallFileName.CONANFILE_PY);
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions/package_revision/files/conanfile.py");
    }

    @Test
    void callV2ConansRevisionsPackagesRevisionsFile_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions/package_revision/files/conanfile.py",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV2DistributionsApi api =
                    new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callV2ConansRevisionsPackagesRevisionsFile(
                    "group/sub/project",
                    "package_name",
                    "package_version",
                    "package_username",
                    "package_channel",
                    "recipe_revision",
                    "conan_package_reference",
                    "package_revision",
                    GitLabConanV2PackageFileCallFileName.CONANFILE_PY));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions/package_revision/files/conanfile.py");
    }

    @Test
    void updateV2ConansRevisionsPackagesRevisionsFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions/package_revision/files/conanfile.py",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client))
                    .updateV2ConansRevisionsPackagesRevisionsFile(
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
        }

        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions/package_revision/files/conanfile.py");
    }

    @Test
    void updateV2ConansRevisionsPackagesRevisionsFile_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions/package_revision/files/conanfile.py",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV2DistributionsApi api =
                    new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateV2ConansRevisionsPackagesRevisionsFile(
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
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions/package_revision/files/conanfile.py");
    }

    @Test
    void authorizeV2ConansRevisionsPackagesRevisionsFile_shouldSendTheRequest_whenResponseIsNoContent()
            throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions/package_revision/files/conanfile.py/authorize",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client))
                    .authorizeV2ConansRevisionsPackagesRevisionsFile(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "package_username",
                            "package_channel",
                            "recipe_revision",
                            "conan_package_reference",
                            "package_revision",
                            GitLabConanV2PackageFileAuthorizeFileName.CONANFILE_PY);
        }

        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions/package_revision/files/conanfile.py/authorize");
    }

    @Test
    void authorizeV2ConansRevisionsPackagesRevisionsFile_shouldAnswerNotFound_whenResponseIsNotFound()
            throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions/package_revision/files/conanfile.py/authorize",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectConanV2DistributionsApi api =
                    new GitLabProjectConanV2DistributionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorizeV2ConansRevisionsPackagesRevisionsFile(
                    "group/sub/project",
                    "package_name",
                    "package_version",
                    "package_username",
                    "package_channel",
                    "recipe_revision",
                    "conan_package_reference",
                    "package_revision",
                    GitLabConanV2PackageFileAuthorizeFileName.CONANFILE_PY));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/conan/v2/conans/package_name/package_version/package_username/package_channel/revisions/recipe_revision/packages/conan_package_reference/revisions/package_revision/files/conanfile.py/authorize");
    }
}

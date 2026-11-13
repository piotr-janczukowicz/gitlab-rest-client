package io.github.piotr_janczukowicz.gitlab.api.packages;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabPackage;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabPackagePipeline;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.io.ByteArrayOutputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.io.TempDir;

@IntegrationTest
class GitLabProjectPackagesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void callRpmRepodata_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/rpm/repodata/file_name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPackagesApi(GitLabCaller.of(client)).callRpmRepodata("group/sub/project", "file_name");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/rpm/repodata/file_name");
    }

    @Test
    void callRpmRepodata_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/rpm/repodata/file_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPackagesApi api = new GitLabProjectPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callRpmRepodata("group/sub/project", "file_name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/rpm/repodata/file_name");
    }

    @Test
    void callRpm_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/rpm/1/file_name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPackagesApi(GitLabCaller.of(client)).callRpm("group/sub/project", 1L, "file_name");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/rpm/1/file_name");
    }

    @Test
    void callRpm_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/rpm/1/file_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPackagesApi api = new GitLabProjectPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callRpm("group/sub/project", 1L, "file_name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/rpm/1/file_name");
    }

    @Test
    void rpm_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/rpm", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPackagesApi(GitLabCaller.of(client)).rpm("group/sub/project");
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/rpm");
    }

    @Test
    void rpm_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/rpm", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPackagesApi api = new GitLabProjectPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.rpm("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/rpm");
    }

    @Test
    void authorizeRpm_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/rpm/authorize",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPackagesApi(GitLabCaller.of(client)).authorizeRpm("group/sub/project");
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/rpm/authorize");
    }

    @Test
    void authorizeRpm_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/rpm/authorize", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPackagesApi api = new GitLabProjectPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorizeRpm("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/rpm/authorize");
    }

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabPackage.class, "package.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/projects/group%2Fsub%2Fproject/packages?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabPackage.class, "package.json") + "]"));

        final List<GitLabPackage> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectPackagesApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.packageValue(), CommonCatalogFixtures.packageValue());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages", 2);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabPackage.class, "package.json")));

        final Optional<GitLabPackage> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectPackagesApi(GitLabCaller.of(client)).get("group/sub/project", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.packageValue());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectPackagesApi(GitLabCaller.of(client))
                    .get("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/1");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/packages/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPackagesApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/packages/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/packages/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPackagesApi api = new GitLabProjectPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/packages/1");
    }

    @Test
    void listPipelines_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/1/pipelines",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabPackagePipeline.class, "package-pipeline.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/packages/1/pipelines?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabPackagePipeline.class, "package-pipeline.json") + "]"));

        final List<GitLabPackagePipeline> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectPackagesApi(GitLabCaller.of(client))
                    .listPipelines("group/sub/project", 1L)
                    .all();
        }

        assertThat(items)
                .containsExactly(CommonCatalogFixtures.packagePipeline(), CommonCatalogFixtures.packagePipeline());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/1/pipelines", 2);
    }

    @Test
    void listPackageFiles_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/1/package_files",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabPackageFile.class, "package-file.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/packages/1/package_files?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabPackageFile.class, "package-file.json") + "]"));

        final List<GitLabPackageFile> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectPackagesApi(GitLabCaller.of(client))
                    .listPackageFiles("group/sub/project", 1L)
                    .all();
        }

        assertThat(items).containsExactly(PackagesCatalogFixtures.packageFile(), PackagesCatalogFixtures.packageFile());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/1/package_files", 2);
    }

    @Test
    void deletePackageFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/1/package_files/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPackagesApi(GitLabCaller.of(client)).deletePackageFile("group/sub/project", 1L, 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/packages/1/package_files/1");
    }

    @Test
    void deletePackageFile_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/1/package_files/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPackagesApi api = new GitLabProjectPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deletePackageFile("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/packages/1/package_files/1");
    }

    @Test
    void getPackageFilesDownload_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/1/package_files/1/download",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPackagesApi(GitLabCaller.of(client))
                    .getPackageFilesDownload("group/sub/project", 1L, 1L, out);
        }

        assertThat(out.toByteArray()).containsExactly(1, 2, 3);
    }

    @Test
    void getPackageFilesDownload_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory)
            throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/1/package_files/1/download",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));
        final Path target = directory.resolve("download.bin");

        final Path written;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            written = new GitLabProjectPackagesApi(GitLabCaller.of(client))
                    .getPackageFilesDownload("group/sub/project", 1L, 1L, target);
        }

        assertThat(written).hasBinaryContent(new byte[] {1, 2, 3});
    }

    @Test
    void callMaven_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/packages/maven/path/file_name", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPackagesApi(GitLabCaller.of(client)).callMaven("path", "file_name");
        }

        HTTP.verifyRequested(GET, "/api/v4/packages/maven/path/file_name");
    }

    @Test
    void callMaven_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/packages/maven/path/file_name", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPackagesApi api = new GitLabProjectPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callMaven("path", "file_name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/packages/maven/path/file_name");
    }

    @Test
    void callHelmIndexYaml_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/helm/channel/index.yaml",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPackagesApi(GitLabCaller.of(client)).callHelmIndexYaml("group/sub/project", "channel");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/helm/channel/index.yaml");
    }

    @Test
    void callHelmIndexYaml_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/helm/channel/index.yaml",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPackagesApi api = new GitLabProjectPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callHelmIndexYaml("group/sub/project", "channel"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/helm/channel/index.yaml");
    }

    @Test
    void getHelmChartsFileNameTgz_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/helm/channel/charts/file_name.tgz",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPackagesApi(GitLabCaller.of(client))
                    .getHelmChartsFileNameTgz("group/sub/project", "channel", "file_name", out);
        }

        assertThat(out.toByteArray()).containsExactly(1, 2, 3);
    }

    @Test
    void getHelmChartsFileNameTgz_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory)
            throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/helm/channel/charts/file_name.tgz",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));
        final Path target = directory.resolve("download.bin");

        final Path written;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            written = new GitLabProjectPackagesApi(GitLabCaller.of(client))
                    .getHelmChartsFileNameTgz("group/sub/project", "channel", "file_name", target);
        }

        assertThat(written).hasBinaryContent(new byte[] {1, 2, 3});
    }

    @Test
    void authorizeHelmApiChart_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/helm/api/channel/charts/authorize",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPackagesApi(GitLabCaller.of(client)).authorizeHelmApiChart("group/sub/project", "channel");
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/helm/api/channel/charts/authorize");
    }

    @Test
    void authorizeHelmApiChart_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/helm/api/channel/charts/authorize",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPackagesApi api = new GitLabProjectPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorizeHelmApiChart("group/sub/project", "channel"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/helm/api/channel/charts/authorize");
    }

    @Test
    void createHelmApiChart_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/helm/api/channel/charts",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPackagesApi(GitLabCaller.of(client))
                    .createHelmApiChart(
                            "group/sub/project",
                            "channel",
                            MultipartFormData.builder().text("field", "value").build());
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/helm/api/channel/charts");
    }

    @Test
    void createHelmApiChart_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/helm/api/channel/charts",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPackagesApi api = new GitLabProjectPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createHelmApiChart(
                    "group/sub/project",
                    "channel",
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/helm/api/channel/charts");
    }

    @Test
    void authorizeGeneric_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/file_name/authorize",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPackagesApi(GitLabCaller.of(client))
                    .authorizeGeneric(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "file_name",
                            PackagesCatalogFixtures.projectPackagesAuthorizeGenericPayload());
        }

        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/file_name/authorize");
    }

    @Test
    void authorizeGeneric_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/file_name/authorize",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPackagesApi api = new GitLabProjectPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorizeGeneric(
                    "group/sub/project",
                    "package_name",
                    "package_version",
                    "file_name",
                    PackagesCatalogFixtures.projectPackagesAuthorizeGenericPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/file_name/authorize");
    }

    @Test
    void authorizeGenericByPath_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/path/file_name/authorize",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPackagesApi(GitLabCaller.of(client))
                    .authorizeGenericByPath(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "path",
                            "file_name",
                            PackagesCatalogFixtures.projectPackagesAuthorizeGenericByPathPayload());
        }

        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/path/file_name/authorize");
    }

    @Test
    void authorizeGenericByPath_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/path/file_name/authorize",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPackagesApi api = new GitLabProjectPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorizeGenericByPath(
                    "group/sub/project",
                    "package_name",
                    "package_version",
                    "path",
                    "file_name",
                    PackagesCatalogFixtures.projectPackagesAuthorizeGenericByPathPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/path/file_name/authorize");
    }

    @Test
    void callGeneric_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/file_name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPackagesApi(GitLabCaller.of(client))
                    .callGeneric("group/sub/project", "package_name", "package_version", "file_name");
        }

        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/file_name");
    }

    @Test
    void callGeneric_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/file_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPackagesApi api = new GitLabProjectPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.callGeneric("group/sub/project", "package_name", "package_version", "file_name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/file_name");
    }

    @Test
    void updateGeneric_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/file_name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPackagesApi(GitLabCaller.of(client))
                    .updateGeneric(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "file_name",
                            MultipartFormData.builder().text("field", "value").build());
        }

        HTTP.verifyRequested(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/file_name");
    }

    @Test
    void updateGeneric_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/file_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPackagesApi api = new GitLabProjectPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateGeneric(
                    "group/sub/project",
                    "package_name",
                    "package_version",
                    "file_name",
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/file_name");
    }

    @Test
    void callGenericByPath_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/path/file_name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPackagesApi(GitLabCaller.of(client))
                    .callGenericByPath("group/sub/project", "package_name", "package_version", "path", "file_name");
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/path/file_name");
    }

    @Test
    void callGenericByPath_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/path/file_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPackagesApi api = new GitLabProjectPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.callGenericByPath("group/sub/project", "package_name", "package_version", "path", "file_name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/path/file_name");
    }

    @Test
    void updateGenericByPath_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/path/file_name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPackagesApi(GitLabCaller.of(client))
                    .updateGenericByPath(
                            "group/sub/project",
                            "package_name",
                            "package_version",
                            "path",
                            "file_name",
                            MultipartFormData.builder().text("field", "value").build());
        }

        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/path/file_name");
    }

    @Test
    void updateGenericByPath_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/path/file_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPackagesApi api = new GitLabProjectPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateGenericByPath(
                    "group/sub/project",
                    "package_name",
                    "package_version",
                    "path",
                    "file_name",
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/path/file_name");
    }

    @Test
    void callCargoConfigJson_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/cargo/config.json",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPackagesApi(GitLabCaller.of(client)).callCargoConfigJson("group/sub/project");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/cargo/config.json");
    }

    @Test
    void callCargoConfigJson_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/cargo/config.json",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPackagesApi api = new GitLabProjectPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callCargoConfigJson("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/cargo/config.json");
    }

    @Test
    void getCargoV1_shouldReturnTheText_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/cargo/1/package_name",
                GitLabApiStubSupport.okJson("echo hi"));

        final String text;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            text = new GitLabProjectPackagesApi(GitLabCaller.of(client))
                    .getCargoV1("group/sub/project", "package_name");
        }

        assertThat(text).isEqualTo("echo hi");
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/cargo/1/package_name");
    }

    @Test
    void getCargoV2_shouldReturnTheText_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/cargo/2/package_name",
                GitLabApiStubSupport.okJson("echo hi"));

        final String text;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            text = new GitLabProjectPackagesApi(GitLabCaller.of(client))
                    .getCargoV2("group/sub/project", "package_name");
        }

        assertThat(text).isEqualTo("echo hi");
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/cargo/2/package_name");
    }

    @Test
    void getCargoV3_shouldReturnTheText_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/cargo/3/first_char/package_name",
                GitLabApiStubSupport.okJson("echo hi"));

        final String text;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            text = new GitLabProjectPackagesApi(GitLabCaller.of(client))
                    .getCargoV3("group/sub/project", "first_char", "package_name");
        }

        assertThat(text).isEqualTo("echo hi");
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/cargo/3/first_char/package_name");
    }

    @Test
    void getCargo_shouldReturnTheText_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/cargo/prefix_1/prefix_2/package_name",
                GitLabApiStubSupport.okJson("echo hi"));

        final String text;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            text = new GitLabProjectPackagesApi(GitLabCaller.of(client))
                    .getCargo("group/sub/project", "prefix_1", "prefix_2", "package_name");
        }

        assertThat(text).isEqualTo("echo hi");
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/cargo/prefix_1/prefix_2/package_name");
    }

    @Test
    void getCargoDownload_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/cargo/package_name/package_version/download",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPackagesApi(GitLabCaller.of(client))
                    .getCargoDownload("group/sub/project", "package_name", "package_version", out);
        }

        assertThat(out.toByteArray()).containsExactly(1, 2, 3);
    }

    @Test
    void getCargoDownload_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/cargo/package_name/package_version/download",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));
        final Path target = directory.resolve("download.bin");

        final Path written;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            written = new GitLabProjectPackagesApi(GitLabCaller.of(client))
                    .getCargoDownload("group/sub/project", "package_name", "package_version", target);
        }

        assertThat(written).hasBinaryContent(new byte[] {1, 2, 3});
    }

    @Test
    void newCargoApiV1Crate_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/cargo/api/v1/crates/new",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPackagesApi(GitLabCaller.of(client))
                    .newCargoApiV1Crate(
                            "group/sub/project",
                            MultipartFormData.builder().text("field", "value").build());
        }

        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/cargo/api/v1/crates/new");
    }

    @Test
    void newCargoApiV1Crate_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/cargo/api/v1/crates/new",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPackagesApi api = new GitLabProjectPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.newCargoApiV1Crate(
                    "group/sub/project",
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/cargo/api/v1/crates/new");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.packages;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabPackage;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabPackagePipeline;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.HttpStreamResponse;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.io.ByteArrayOutputStream;
import java.nio.file.Path;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

@UnitTest
class GitLabProjectPackagesApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectPackagesApi api() {
        return new GitLabProjectPackagesApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectPackagesApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void callRpmRepodata_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callRpmRepodata("group/sub/project", "file_name");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/rpm/repodata/file_name");
    }

    @Test
    void callRpmRepodata_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callRpmRepodata("group/sub/project", "file_name"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callRpm_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callRpm("group/sub/project", 1L, "file_name");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/rpm/1/file_name");
    }

    @Test
    void callRpm_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callRpm("group/sub/project", 1L, "file_name"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void rpm_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().rpm("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/packages/rpm");
    }

    @Test
    void rpm_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().rpm("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void authorizeRpm_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().authorizeRpm("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/packages/rpm/authorize");
    }

    @Test
    void authorizeRpm_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().authorizeRpm("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabPackage.class, "package.json") + "]"));

        final GitLabPage<GitLabPackage> page = api().list("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.packageValue());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabPackage.class, "package.json") + "]"));

        final GitLabPage<GitLabPackage> page = api().list(
                        "group/sub/project",
                        GitLabProjectPackagesListFilterBuilder.builder()
                                .orderBy(GitLabProjectPackagesListOrderBy.CREATED_AT)
                                .sort(GitLabProjectPackagesListSort.ASC)
                                .packageType(GitLabProjectPackagesListPackageType.MAVEN)
                                .packageName("package_name")
                                .packageVersion("package_version")
                                .includeVersionless(true)
                                .status(GitLabProjectPackagesListStatus.DEFAULT)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.packageValue());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages");
            softly.assertThat(request.uri()).hasParameter("order_by", "created_at");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabPackage.class, "package.json") + "]"));

        final GitLabPage<GitLabPackage> page = api().list("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.packageValue());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabPackage.class, "package.json") + "]"));

        final GitLabPage<GitLabPackage> page = api().list(
                        "group/sub/project",
                        GitLabProjectPackagesListFilterBuilder.builder()
                                .orderBy(GitLabProjectPackagesListOrderBy.CREATED_AT)
                                .sort(GitLabProjectPackagesListSort.ASC)
                                .packageType(GitLabProjectPackagesListPackageType.MAVEN)
                                .packageName("package_name")
                                .packageVersion("package_version")
                                .includeVersionless(true)
                                .status(GitLabProjectPackagesListStatus.DEFAULT)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.packageValue());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("order_by", "created_at");
        });
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabPackage.class, "package.json")));

        final Optional<GitLabPackage> result = api().get("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.packageValue());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/1");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabPackage> result = api().get("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/packages/1");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listPipelines_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabPackagePipeline.class, "package-pipeline.json") + "]"));

        final GitLabPage<GitLabPackagePipeline> page = api().listPipelines("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.packagePipeline());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/1/pipelines");
        });
    }

    @Test
    void listPipelines_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabPackagePipeline.class, "package-pipeline.json") + "]"));

        final GitLabPage<GitLabPackagePipeline> page = api().listPipelines(
                        "group/sub/project",
                        1L,
                        GitLabProjectPackagesListPipelinesFilterBuilder.builder()
                                .cursor("cursor")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.packagePipeline());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/1/pipelines");
            softly.assertThat(request.uri()).hasParameter("cursor", "cursor");
        });
    }

    @Test
    void listPipelines_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabPackagePipeline.class, "package-pipeline.json") + "]"));

        final GitLabPage<GitLabPackagePipeline> page =
                api().listPipelines("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.packagePipeline());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/1/pipelines");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listPipelines_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabPackagePipeline.class, "package-pipeline.json") + "]"));

        final GitLabPage<GitLabPackagePipeline> page = api().listPipelines(
                        "group/sub/project",
                        1L,
                        GitLabProjectPackagesListPipelinesFilterBuilder.builder()
                                .cursor("cursor")
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.packagePipeline());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/1/pipelines");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("cursor", "cursor");
        });
    }

    @Test
    void listPackageFiles_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabPackageFile.class, "package-file.json") + "]"));

        final GitLabPage<GitLabPackageFile> page = api().listPackageFiles("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(PackagesCatalogFixtures.packageFile());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/1/package_files");
        });
    }

    @Test
    void listPackageFiles_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabPackageFile.class, "package-file.json") + "]"));

        final GitLabPage<GitLabPackageFile> page = api().listPackageFiles(
                        "group/sub/project",
                        1L,
                        GitLabProjectPackagesListPackageFilesFilterBuilder.builder()
                                .orderBy(GitLabProjectPackagesListPackageFilesOrderBy.ID)
                                .sort(GitLabProjectPackagesListPackageFilesSort.ASC)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(PackagesCatalogFixtures.packageFile());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/1/package_files");
            softly.assertThat(request.uri()).hasParameter("order_by", "id");
        });
    }

    @Test
    void listPackageFiles_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabPackageFile.class, "package-file.json") + "]"));

        final GitLabPage<GitLabPackageFile> page =
                api().listPackageFiles("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(PackagesCatalogFixtures.packageFile());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/1/package_files");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listPackageFiles_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabPackageFile.class, "package-file.json") + "]"));

        final GitLabPage<GitLabPackageFile> page = api().listPackageFiles(
                        "group/sub/project",
                        1L,
                        GitLabProjectPackagesListPackageFilesFilterBuilder.builder()
                                .orderBy(GitLabProjectPackagesListPackageFilesOrderBy.ID)
                                .sort(GitLabProjectPackagesListPackageFilesSort.ASC)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(PackagesCatalogFixtures.packageFile());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/1/package_files");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("order_by", "id");
        });
    }

    @Test
    void deletePackageFile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deletePackageFile("group/sub/project", 1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/packages/1/package_files/1");
    }

    @Test
    void deletePackageFile_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deletePackageFile("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getPackageFilesDownload_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        final long written = api().getPackageFilesDownload("group/sub/project", 1L, 1L, out);

        assertSoftly(softly -> {
            softly.assertThat(written).isEqualTo(3L);
            softly.assertThat(out).hasToString("abc");
        });
    }

    @Test
    void getPackageFilesDownload_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory)
            throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final Path target = directory.resolve("download.bin");

        final Path written = api().getPackageFilesDownload("group/sub/project", 1L, 1L, target);

        assertThat(written).hasContent("abc");
    }

    @Test
    void callMaven_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callMaven("path", "file_name");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/packages/maven/path/file_name");
    }

    @Test
    void callMaven_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callMaven("path", "file_name"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callHelmIndexYaml_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callHelmIndexYaml("group/sub/project", "channel");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/helm/channel/index.yaml");
    }

    @Test
    void callHelmIndexYaml_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callHelmIndexYaml("group/sub/project", "channel"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getHelmChartsFileNameTgz_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        final long written = api().getHelmChartsFileNameTgz("group/sub/project", "channel", "file_name", out);

        assertSoftly(softly -> {
            softly.assertThat(written).isEqualTo(3L);
            softly.assertThat(out).hasToString("abc");
        });
    }

    @Test
    void getHelmChartsFileNameTgz_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory)
            throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final Path target = directory.resolve("download.bin");

        final Path written = api().getHelmChartsFileNameTgz("group/sub/project", "channel", "file_name", target);

        assertThat(written).hasContent("abc");
    }

    @Test
    void authorizeHelmApiChart_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().authorizeHelmApiChart("group/sub/project", "channel");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/packages/helm/api/channel/charts/authorize");
    }

    @Test
    void authorizeHelmApiChart_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().authorizeHelmApiChart("group/sub/project", "channel"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createHelmApiChart_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createHelmApiChart(
                        "group/sub/project",
                        "channel",
                        MultipartFormData.builder().text("field", "value").build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/packages/helm/api/channel/charts");
    }

    @Test
    void createHelmApiChart_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createHelmApiChart(
                        "group/sub/project",
                        "channel",
                        MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void authorizeGeneric_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().authorizeGeneric(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "file_name",
                        PackagesCatalogFixtures.projectPackagesAuthorizeGenericPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "PUT /api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/file_name/authorize");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"status\":");
        });
    }

    @Test
    void authorizeGeneric_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().authorizeGeneric(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "file_name",
                        PackagesCatalogFixtures.projectPackagesAuthorizeGenericPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void authorizeGenericByPath_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().authorizeGenericByPath(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "path",
                        "file_name",
                        PackagesCatalogFixtures.projectPackagesAuthorizeGenericByPathPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "PUT /api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/path/file_name/authorize");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"status\":");
        });
    }

    @Test
    void authorizeGenericByPath_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().authorizeGenericByPath(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "path",
                        "file_name",
                        PackagesCatalogFixtures.projectPackagesAuthorizeGenericByPathPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callGeneric_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callGeneric("group/sub/project", "package_name", "package_version", "file_name");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/file_name");
    }

    @Test
    void callGeneric_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().callGeneric("group/sub/project", "package_name", "package_version", "file_name"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callGeneric_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callGeneric(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "file_name",
                        GitLabProjectPackagesCallGenericFilterBuilder.builder()
                                .downloadMode(GitLabProjectPackagesCallGenericDownloadMode.PROXY)
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("download_mode", "proxy");
    }

    @Test
    void updateGeneric_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().updateGeneric(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "file_name",
                        MultipartFormData.builder().text("field", "value").build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "PUT /api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/file_name");
    }

    @Test
    void updateGeneric_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateGeneric(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "file_name",
                        MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callGenericByPath_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callGenericByPath("group/sub/project", "package_name", "package_version", "path", "file_name");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "GET /api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/path/file_name");
    }

    @Test
    void callGenericByPath_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().callGenericByPath("group/sub/project", "package_name", "package_version", "path", "file_name"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callGenericByPath_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callGenericByPath(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "path",
                        "file_name",
                        GitLabProjectPackagesCallGenericByPathFilterBuilder.builder()
                                .downloadMode(GitLabProjectPackagesCallGenericByPathDownloadMode.PROXY)
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("download_mode", "proxy");
    }

    @Test
    void updateGenericByPath_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().updateGenericByPath(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "path",
                        "file_name",
                        MultipartFormData.builder().text("field", "value").build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo(
                        "PUT /api/v4/projects/group%2Fsub%2Fproject/packages/generic/package_name/package_version/path/file_name");
    }

    @Test
    void updateGenericByPath_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateGenericByPath(
                        "group/sub/project",
                        "package_name",
                        "package_version",
                        "path",
                        "file_name",
                        MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callCargoConfigJson_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callCargoConfigJson("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/cargo/config.json");
    }

    @Test
    void callCargoConfigJson_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callCargoConfigJson("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getCargoV1_shouldReturnTheText_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, "echo hi"));

        final String text = api().getCargoV1("group/sub/project", "package_name");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(text).isEqualTo("echo hi");
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/cargo/1/package_name");
        });
    }

    @Test
    void getCargoV2_shouldReturnTheText_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, "echo hi"));

        final String text = api().getCargoV2("group/sub/project", "package_name");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(text).isEqualTo("echo hi");
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/cargo/2/package_name");
        });
    }

    @Test
    void getCargoV3_shouldReturnTheText_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, "echo hi"));

        final String text = api().getCargoV3("group/sub/project", "first_char", "package_name");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(text).isEqualTo("echo hi");
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/cargo/3/first_char/package_name");
        });
    }

    @Test
    void getCargo_shouldReturnTheText_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, "echo hi"));

        final String text = api().getCargo("group/sub/project", "prefix_1", "prefix_2", "package_name");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(text).isEqualTo("echo hi");
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/packages/cargo/prefix_1/prefix_2/package_name");
        });
    }

    @Test
    void getCargoDownload_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        final long written = api().getCargoDownload("group/sub/project", "package_name", "package_version", out);

        assertSoftly(softly -> {
            softly.assertThat(written).isEqualTo(3L);
            softly.assertThat(out).hasToString("abc");
        });
    }

    @Test
    void getCargoDownload_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final Path target = directory.resolve("download.bin");

        final Path written = api().getCargoDownload("group/sub/project", "package_name", "package_version", target);

        assertThat(written).hasContent("abc");
    }

    @Test
    void newCargoApiV1Crate_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().newCargoApiV1Crate(
                        "group/sub/project",
                        MultipartFormData.builder().text("field", "value").build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/packages/cargo/api/v1/crates/new");
    }

    @Test
    void newCargoApiV1Crate_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().newCargoApiV1Crate(
                        "group/sub/project",
                        MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}

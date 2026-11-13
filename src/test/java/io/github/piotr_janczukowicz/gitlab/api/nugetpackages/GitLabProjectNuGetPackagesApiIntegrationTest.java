package io.github.piotr_janczukowicz.gitlab.api.nugetpackages;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNugetPackageMetadata;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNugetPackagesMetadata;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNugetSearchResults;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNugetServiceIndex;
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
class GitLabProjectNuGetPackagesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void getIndex_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/index",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabNugetServiceIndex.class, "nuget-service-index.json")));

        final GitLabNugetServiceIndex result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client)).getIndex("group/sub/project");
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.nugetServiceIndex());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/index");
    }

    @Test
    void getIndex_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/index", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNuGetPackagesApi api = new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getIndex("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/index");
    }

    @Test
    void callSymbolfile_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/symbolfiles/file_name/signature/same_file_name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client))
                    .callSymbolfile("group/sub/project", "file_name", "signature", "same_file_name");
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/symbolfiles/file_name/signature/same_file_name");
    }

    @Test
    void callSymbolfile_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/symbolfiles/file_name/signature/same_file_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNuGetPackagesApi api = new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.callSymbolfile("group/sub/project", "file_name", "signature", "same_file_name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/symbolfiles/file_name/signature/same_file_name");
    }

    @Test
    void callV2_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/v2", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client)).callV2("group/sub/project");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/v2");
    }

    @Test
    void callV2_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/v2", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNuGetPackagesApi api = new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callV2("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/v2");
    }

    @Test
    void updateV2_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/v2", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client))
                    .updateV2(
                            "group/sub/project",
                            MultipartFormData.builder().text("field", "value").build());
        }

        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/v2");
    }

    @Test
    void updateV2_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/v2", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNuGetPackagesApi api = new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateV2(
                    "group/sub/project",
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/v2");
    }

    @Test
    void callV2Metadata_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/v2/$metadata",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client)).callV2Metadata("group/sub/project");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/v2/$metadata");
    }

    @Test
    void callV2Metadata_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/v2/$metadata",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNuGetPackagesApi api = new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callV2Metadata("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/v2/$metadata");
    }

    @Test
    void getMetadataIndex_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/metadata/package_name/index",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabNugetPackagesMetadata.class, "nuget-packages-metadata.json")));

        final Optional<GitLabNugetPackagesMetadata> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client))
                    .getMetadataIndex("group/sub/project", "package_name");
        }

        assertThat(result).contains(CommonCatalogFixtures.nugetPackagesMetadata());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/metadata/package_name/index");
    }

    @Test
    void getMetadataIndex_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/metadata/package_name/index",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client))
                    .getMetadataIndex("group/sub/project", "package_name")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/metadata/package_name/index");
    }

    @Test
    void getMetadata_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/metadata/package_name/package_version",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabNugetPackageMetadata.class, "nuget-package-metadata.json")));

        final Optional<GitLabNugetPackageMetadata> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client))
                    .getMetadata("group/sub/project", "package_name", "package_version");
        }

        assertThat(result).contains(CommonCatalogFixtures.nugetPackageMetadata());
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/metadata/package_name/package_version");
    }

    @Test
    void getMetadata_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/metadata/package_name/package_version",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client))
                    .getMetadata("group/sub/project", "package_name", "package_version")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/metadata/package_name/package_version");
    }

    @Test
    void getQuery_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/query",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabNugetSearchResults.class, "nuget-search-results.json")));

        final GitLabNugetSearchResults result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client)).getQuery("group/sub/project");
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.nugetSearchResults());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/query");
    }

    @Test
    void getQuery_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/query", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNuGetPackagesApi api = new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getQuery("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/query");
    }

    @Test
    void getDownloadIndex_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/download/package_name/index",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabNugetPackagesVersions.class, "nuget-packages-versions.json")));

        final Optional<GitLabNugetPackagesVersions> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client))
                    .getDownloadIndex("group/sub/project", "package_name");
        }

        assertThat(result).contains(NugetpackagesCatalogFixtures.nugetPackagesVersions());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/download/package_name/index");
    }

    @Test
    void getDownloadIndex_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/download/package_name/index",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client))
                    .getDownloadIndex("group/sub/project", "package_name")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/download/package_name/index");
    }

    @Test
    void callDownload_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/download/package_name/package_version/package_filename",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client))
                    .callDownload("group/sub/project", "package_name", "package_version", "package_filename");
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/download/package_name/package_version/package_filename");
    }

    @Test
    void callDownload_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/download/package_name/package_version/package_filename",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNuGetPackagesApi api = new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.callDownload("group/sub/project", "package_name", "package_version", "package_filename"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/download/package_name/package_version/package_filename");
    }

    @Test
    void update_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            MultipartFormData.builder().text("field", "value").build());
        }

        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNuGetPackagesApi api = new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project",
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget");
    }

    @Test
    void authorize_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/authorize",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client)).authorize("group/sub/project");
        }

        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/authorize");
    }

    @Test
    void authorize_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/authorize",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNuGetPackagesApi api = new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorize("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/authorize");
    }

    @Test
    void symbolpackage_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/symbolpackage",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client))
                    .symbolpackage(
                            "group/sub/project",
                            MultipartFormData.builder().text("field", "value").build());
        }

        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/symbolpackage");
    }

    @Test
    void symbolpackage_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/symbolpackage",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNuGetPackagesApi api = new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.symbolpackage(
                    "group/sub/project",
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/symbolpackage");
    }

    @Test
    void authorizeSymbolpackage_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/symbolpackage/authorize",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client)).authorizeSymbolpackage("group/sub/project");
        }

        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/symbolpackage/authorize");
    }

    @Test
    void authorizeSymbolpackage_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/symbolpackage/authorize",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNuGetPackagesApi api = new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorizeSymbolpackage("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/symbolpackage/authorize");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/package_name/package_version",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client))
                    .delete("group/sub/project", "package_name", "package_version");
        }

        HTTP.verifyRequested(
                DELETE, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/package_name/package_version");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/package_name/package_version",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNuGetPackagesApi api = new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", "package_name", "package_version"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                DELETE, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/package_name/package_version");
    }

    @Test
    void authorizeV2_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/v2/authorize",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client)).authorizeV2("group/sub/project");
        }

        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/v2/authorize");
    }

    @Test
    void authorizeV2_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/v2/authorize",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNuGetPackagesApi api = new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorizeV2("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/nuget/v2/authorize");
    }

    @Test
    void callV2Findpackagesbyid_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/project_id/packages/nuget/v2/FindPackagesById()",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client)).callV2Findpackagesbyid("project_id", "id");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/project_id/packages/nuget/v2/FindPackagesById()");
    }

    @Test
    void callV2Findpackagesbyid_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/project_id/packages/nuget/v2/FindPackagesById()",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNuGetPackagesApi api = new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callV2Findpackagesbyid("project_id", "id"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/project_id/packages/nuget/v2/FindPackagesById()");
    }

    @Test
    void callV2Packages_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/project_id/packages/nuget/v2/Packages()", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client)).callV2Packages("project_id", "a1");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/project_id/packages/nuget/v2/Packages()");
    }

    @Test
    void callV2Packages_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/project_id/packages/nuget/v2/Packages()", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNuGetPackagesApi api = new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callV2Packages("project_id", "a1"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/project_id/packages/nuget/v2/Packages()");
    }

    @Test
    void callV2PackagesIdPackageNameVersionPackageVersion_shouldSendTheRequest_whenResponseIsNoContent()
            throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/project_id/packages/nuget/v2/Packages(Id='package_name',Version='package_version')",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client))
                    .callV2PackagesIdPackageNameVersionPackageVersion("project_id", "package_name", "package_version");
        }

        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/project_id/packages/nuget/v2/Packages(Id='package_name',Version='package_version')");
    }

    @Test
    void callV2PackagesIdPackageNameVersionPackageVersion_shouldAnswerNotFound_whenResponseIsNotFound()
            throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/project_id/packages/nuget/v2/Packages(Id='package_name',Version='package_version')",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNuGetPackagesApi api = new GitLabProjectNuGetPackagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callV2PackagesIdPackageNameVersionPackageVersion(
                    "project_id", "package_name", "package_version"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/project_id/packages/nuget/v2/Packages(Id='package_name',Version='package_version')");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.repositoryfiles;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.HEAD;
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
import java.io.ByteArrayOutputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.io.TempDir;

@IntegrationTest
class GitLabProjectRepositoryFilesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void listBlame_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path/blame",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabBlameRange.class, "blame-range.json") + "]"));

        final List<GitLabBlameRange> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectRepositoryFilesApi(GitLabCaller.of(client))
                    .listBlame("group/sub/project", "file_path", "ref", 1, 1);
        }

        assertThat(result).containsExactly(RepositoryfilesCatalogFixtures.blameRange());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path/blame");
    }

    @Test
    void headBlame_shouldReturnTrue_whenTheResourceExists() throws Exception {
        HTTP.stub(HEAD, "/api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path/blame", 200);

        final boolean exists;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            exists = new GitLabProjectRepositoryFilesApi(GitLabCaller.of(client))
                    .headBlame("group/sub/project", "file_path", "ref");
        }

        assertThat(exists).isTrue();
    }

    @Test
    void getRaw_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path/raw",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectRepositoryFilesApi(GitLabCaller.of(client)).getRaw("group/sub/project", "file_path", out);
        }

        assertThat(out.toByteArray()).containsExactly(1, 2, 3);
    }

    @Test
    void getRaw_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path/raw",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));
        final Path target = directory.resolve("download.bin");

        final Path written;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            written = new GitLabProjectRepositoryFilesApi(GitLabCaller.of(client))
                    .getRaw("group/sub/project", "file_path", target);
        }

        assertThat(written).hasBinaryContent(new byte[] {1, 2, 3});
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabProjectRepositoryFilesGetResponse.class, "project-repository-files-get-response.json")));

        final Optional<GitLabProjectRepositoryFilesGetResponse> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectRepositoryFilesApi(GitLabCaller.of(client))
                    .get("group/sub/project", "file_path", "ref");
        }

        assertThat(result).contains(RepositoryfilesCatalogFixtures.projectRepositoryFilesGetResponse());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectRepositoryFilesApi(GitLabCaller.of(client))
                    .get("group/sub/project", "file_path", "ref")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path");
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabProjectRepositoryFilesCreateResponse.class,
                        "project-repository-files-create-response.json")));

        final GitLabProjectRepositoryFilesCreateResponse result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectRepositoryFilesApi(GitLabCaller.of(client))
                    .create(
                            "group/sub/project",
                            "file_path",
                            MultipartFormData.builder().text("field", "value").build());
        }

        assertThat(result).isEqualTo(RepositoryfilesCatalogFixtures.projectRepositoryFilesCreateResponse());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectRepositoryFilesApi api = new GitLabProjectRepositoryFilesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    "group/sub/project",
                    "file_path",
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabProjectRepositoryFilesUpdateResponse.class,
                        "project-repository-files-update-response.json")));

        final GitLabProjectRepositoryFilesUpdateResponse result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectRepositoryFilesApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            "file_path",
                            MultipartFormData.builder().text("field", "value").build());
        }

        assertThat(result).isEqualTo(RepositoryfilesCatalogFixtures.projectRepositoryFilesUpdateResponse());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectRepositoryFilesApi api = new GitLabProjectRepositoryFilesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project",
                    "file_path",
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectRepositoryFilesApi(GitLabCaller.of(client))
                    .delete("group/sub/project", "file_path", "branch", "commit_message");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectRepositoryFilesApi api = new GitLabProjectRepositoryFilesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", "file_path", "branch", "commit_message"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path");
    }

    @Test
    void head_shouldReturnTrue_whenTheResourceExists() throws Exception {
        HTTP.stub(HEAD, "/api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path", 200);

        final boolean exists;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            exists = new GitLabProjectRepositoryFilesApi(GitLabCaller.of(client))
                    .head("group/sub/project", "file_path", "ref");
        }

        assertThat(exists).isTrue();
    }
}

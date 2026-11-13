package io.github.piotr_janczukowicz.gitlab.api.repositoryfiles;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
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
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

@UnitTest
class GitLabProjectRepositoryFilesApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectRepositoryFilesApi api() {
        return new GitLabProjectRepositoryFilesApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectRepositoryFilesApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void listBlame_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabBlameRange.class, "blame-range.json") + "]"));

        final List<GitLabBlameRange> result = api().listBlame("group/sub/project", "file_path", "ref", 1, 1);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(RepositoryfilesCatalogFixtures.blameRange());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path/blame");
            softly.assertThat(request.uri()).hasParameter("ref", "ref");
        });
    }

    @Test
    void headBlame_shouldReturnTrue_whenTheResourceExists() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, null));

        final boolean exists = api().headBlame("group/sub/project", "file_path", "ref");

        assertThat(exists).isTrue();
    }

    @Test
    void headBlame_shouldReturnFalse_whenTheResourceIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final boolean exists = api().headBlame("group/sub/project", "file_path", "ref");

        assertThat(exists).isFalse();
    }

    @Test
    void getRaw_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        final long written = api().getRaw("group/sub/project", "file_path", out);

        assertSoftly(softly -> {
            softly.assertThat(written).isEqualTo(3L);
            softly.assertThat(out).hasToString("abc");
        });
    }

    @Test
    void getRaw_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final Path target = directory.resolve("download.bin");

        final Path written = api().getRaw("group/sub/project", "file_path", target);

        assertThat(written).hasContent("abc");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabProjectRepositoryFilesGetResponse.class,
                                "project-repository-files-get-response.json")));

        final Optional<GitLabProjectRepositoryFilesGetResponse> result =
                api().get("group/sub/project", "file_path", "ref");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(RepositoryfilesCatalogFixtures.projectRepositoryFilesGetResponse());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path");
            softly.assertThat(request.uri()).hasParameter("ref", "ref");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabProjectRepositoryFilesGetResponse> result =
                api().get("group/sub/project", "file_path", "ref");

        assertThat(result).isEmpty();
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabProjectRepositoryFilesCreateResponse.class,
                                "project-repository-files-create-response.json")));

        final GitLabProjectRepositoryFilesCreateResponse result = api().create(
                        "group/sub/project",
                        "file_path",
                        MultipartFormData.builder().text("field", "value").build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(RepositoryfilesCatalogFixtures.projectRepositoryFilesCreateResponse());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().create(
                        "group/sub/project",
                        "file_path",
                        MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabProjectRepositoryFilesUpdateResponse.class,
                                "project-repository-files-update-response.json")));

        final GitLabProjectRepositoryFilesUpdateResponse result = api().update(
                        "group/sub/project",
                        "file_path",
                        MultipartFormData.builder().text("field", "value").build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(RepositoryfilesCatalogFixtures.projectRepositoryFilesUpdateResponse());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().update(
                        "group/sub/project",
                        "file_path",
                        MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete("group/sub/project", "file_path", "branch", "commit_message");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/repository/files/file_path");
            softly.assertThat(request.uri()).hasParameter("branch", "branch");
        });
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().delete("group/sub/project", "file_path", "branch", "commit_message"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete(
                        "group/sub/project",
                        "file_path",
                        "branch",
                        "commit_message",
                        GitLabProjectRepositoryFilesDeleteFilterBuilder.builder()
                                .startBranch("start_branch")
                                .authorEmail("author_email")
                                .authorName("author_name")
                                .lastCommitId("last_commit_id")
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("start_branch", "start_branch");
    }

    @Test
    void head_shouldReturnTrue_whenTheResourceExists() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, null));

        final boolean exists = api().head("group/sub/project", "file_path", "ref");

        assertThat(exists).isTrue();
    }

    @Test
    void head_shouldReturnFalse_whenTheResourceIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final boolean exists = api().head("group/sub/project", "file_path", "ref");

        assertThat(exists).isFalse();
    }
}

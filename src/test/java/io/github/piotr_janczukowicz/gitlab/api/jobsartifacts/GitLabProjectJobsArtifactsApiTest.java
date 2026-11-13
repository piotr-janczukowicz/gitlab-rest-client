package io.github.piotr_janczukowicz.gitlab.api.jobsartifacts;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiJob;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.HttpStreamResponse;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.io.ByteArrayOutputStream;
import java.nio.file.Path;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

@UnitTest
class GitLabProjectJobsArtifactsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectJobsArtifactsApi api() {
        return new GitLabProjectJobsArtifactsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectJobsArtifactsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void get_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        final long written = api().get("group/sub/project", 1L, out);

        assertSoftly(softly -> {
            softly.assertThat(written).isEqualTo(3L);
            softly.assertThat(out).hasToString("abc");
        });
    }

    @Test
    void get_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        when(transport.stream(any())).thenReturn(HttpStreamResponse.buffered(response(200, "abc")));
        final Path target = directory.resolve("download.bin");

        final Path written = api().get("group/sub/project", 1L, target);

        assertThat(written).hasContent("abc");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/jobs/1/artifacts");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listTree_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabCiJobArtifactEntry.class, "ci-job-artifact-entry.json")
                                + "]"));

        final GitLabPage<GitLabCiJobArtifactEntry> page = api().listTree("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(JobsartifactsCatalogFixtures.ciJobArtifactEntry());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/jobs/1/artifacts/tree");
        });
    }

    @Test
    void listTree_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabCiJobArtifactEntry.class, "ci-job-artifact-entry.json")
                                + "]"));

        final GitLabPage<GitLabCiJobArtifactEntry> page = api().listTree(
                        "group/sub/project",
                        1L,
                        GitLabProjectJobsArtifactsListTreeFilterBuilder.builder()
                                .path("path")
                                .recursive(true)
                                .jobToken("job_token")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(JobsartifactsCatalogFixtures.ciJobArtifactEntry());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/jobs/1/artifacts/tree");
            softly.assertThat(request.uri()).hasParameter("path", "path");
        });
    }

    @Test
    void listTree_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabCiJobArtifactEntry.class, "ci-job-artifact-entry.json")
                                + "]"));

        final GitLabPage<GitLabCiJobArtifactEntry> page =
                api().listTree("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(JobsartifactsCatalogFixtures.ciJobArtifactEntry());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/jobs/1/artifacts/tree");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listTree_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabCiJobArtifactEntry.class, "ci-job-artifact-entry.json")
                                + "]"));

        final GitLabPage<GitLabCiJobArtifactEntry> page = api().listTree(
                        "group/sub/project",
                        1L,
                        GitLabProjectJobsArtifactsListTreeFilterBuilder.builder()
                                .path("path")
                                .recursive(true)
                                .jobToken("job_token")
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(JobsartifactsCatalogFixtures.ciJobArtifactEntry());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/jobs/1/artifacts/tree");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("path", "path");
        });
    }

    @Test
    void call_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().call("group/sub/project", 1L, "artifact_path");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/jobs/1/artifacts/artifact_path");
    }

    @Test
    void call_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().call("group/sub/project", 1L, "artifact_path"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void call_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().call(
                        "group/sub/project",
                        1L,
                        "artifact_path",
                        GitLabProjectJobsArtifactsCallFilterBuilder.builder()
                                .jobToken("job_token")
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("job_token", "job_token");
    }

    @Test
    void keep_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCiJob.class, "ci-job.json")));

        final GitLabCiJob result = api().keep("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.ciJob());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/jobs/1/artifacts/keep");
        });
    }

    @Test
    void keep_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().keep("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}

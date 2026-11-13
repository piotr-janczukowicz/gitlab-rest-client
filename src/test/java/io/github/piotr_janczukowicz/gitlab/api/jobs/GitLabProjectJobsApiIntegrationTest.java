package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiJob;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiJobBasic;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
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
class GitLabProjectJobsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void listPipelinesJobs_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/jobs",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabCiJob.class, "ci-job.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/jobs?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabCiJob.class, "ci-job.json") + "]"));

        final List<GitLabCiJob> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectJobsApi(GitLabCaller.of(client))
                    .listPipelinesJobs("group/sub/project", 1L)
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.ciJob(), CommonCatalogFixtures.ciJob());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/jobs", 2);
    }

    @Test
    void listJobs_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/jobs",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabCiJob.class, "ci-job.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/projects/group%2Fsub%2Fproject/jobs?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabCiJob.class, "ci-job.json") + "]"));

        final List<GitLabCiJob> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectJobsApi(GitLabCaller.of(client))
                    .listJobs("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.ciJob(), CommonCatalogFixtures.ciJob());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/jobs", 2);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/jobs/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiJob.class, "ci-job.json")));

        final Optional<GitLabCiJob> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectJobsApi(GitLabCaller.of(client)).get("group/sub/project", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.ciJob());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/jobs/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/jobs/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectJobsApi(GitLabCaller.of(client))
                    .get("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/jobs/1");
    }

    @Test
    void getTrace_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/jobs/1/trace",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiJob.class, "ci-job.json")));

        final Optional<GitLabCiJob> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectJobsApi(GitLabCaller.of(client)).getTrace("group/sub/project", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.ciJob());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/jobs/1/trace");
    }

    @Test
    void getTrace_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/jobs/1/trace", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectJobsApi(GitLabCaller.of(client))
                    .getTrace("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/jobs/1/trace");
    }

    @Test
    void cancel_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/jobs/1/cancel",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiJob.class, "ci-job.json")));

        final GitLabCiJob result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectJobsApi(GitLabCaller.of(client))
                    .cancel("group/sub/project", 1L, JobsCatalogFixtures.projectJobsCancelPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciJob());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/jobs/1/cancel");
    }

    @Test
    void cancel_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/jobs/1/cancel", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectJobsApi api = new GitLabProjectJobsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.cancel("group/sub/project", 1L, JobsCatalogFixtures.projectJobsCancelPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/jobs/1/cancel");
    }

    @Test
    void retry_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/jobs/1/retry",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiJob.class, "ci-job.json")));

        final GitLabCiJob result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectJobsApi(GitLabCaller.of(client))
                    .retry("group/sub/project", 1L, JobsCatalogFixtures.projectJobsRetryPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciJob());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/jobs/1/retry");
    }

    @Test
    void retry_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/jobs/1/retry", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectJobsApi api = new GitLabProjectJobsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.retry("group/sub/project", 1L, JobsCatalogFixtures.projectJobsRetryPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/jobs/1/retry");
    }

    @Test
    void erase_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/jobs/1/erase",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiJob.class, "ci-job.json")));

        final GitLabCiJob result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectJobsApi(GitLabCaller.of(client)).erase("group/sub/project", 1L);
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciJob());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/jobs/1/erase");
    }

    @Test
    void erase_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/jobs/1/erase", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectJobsApi api = new GitLabProjectJobsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.erase("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/jobs/1/erase");
    }

    @Test
    void play_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/jobs/1/play",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiJobBasic.class, "ci-job-basic.json")));

        final GitLabCiJobBasic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectJobsApi(GitLabCaller.of(client))
                    .play("group/sub/project", 1L, JobsCatalogFixtures.projectJobsPlayPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciJobBasic());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/jobs/1/play");
    }

    @Test
    void play_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/jobs/1/play", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectJobsApi api = new GitLabProjectJobsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.play("group/sub/project", 1L, JobsCatalogFixtures.projectJobsPlayPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/jobs/1/play");
    }

    @Test
    void getArtifactsDownload_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/jobs/artifacts/ref_name/download",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectJobsApi(GitLabCaller.of(client))
                    .getArtifactsDownload("group/sub/project", "ref_name", "job", out);
        }

        assertThat(out.toByteArray()).containsExactly(1, 2, 3);
    }

    @Test
    void getArtifactsDownload_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/jobs/artifacts/ref_name/download",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));
        final Path target = directory.resolve("download.bin");

        final Path written;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            written = new GitLabProjectJobsApi(GitLabCaller.of(client))
                    .getArtifactsDownload("group/sub/project", "ref_name", "job", target);
        }

        assertThat(written).hasBinaryContent(new byte[] {1, 2, 3});
    }

    @Test
    void callArtifactsRaw_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/jobs/artifacts/ref_name/raw/artifact_path",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectJobsApi(GitLabCaller.of(client))
                    .callArtifactsRaw("group/sub/project", "ref_name", "artifact_path", "job");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/jobs/artifacts/ref_name/raw/artifact_path");
    }

    @Test
    void callArtifactsRaw_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/jobs/artifacts/ref_name/raw/artifact_path",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectJobsApi api = new GitLabProjectJobsApi(GitLabCaller.of(client));
            thrown =
                    catchThrowable(() -> api.callArtifactsRaw("group/sub/project", "ref_name", "artifact_path", "job"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/jobs/artifacts/ref_name/raw/artifact_path");
    }
}

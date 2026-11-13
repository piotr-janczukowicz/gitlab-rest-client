package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.PATCH;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiJob;
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
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.io.TempDir;

@IntegrationTest
class GitLabInstanceJobsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void request_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/jobs/request",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabCiJobRequestResponse.class, "ci-job-request-response.json")));

        final GitLabCiJobRequestResponse result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabInstanceJobsApi(GitLabCaller.of(client))
                    .request(JobsCatalogFixtures.instanceJobsRequestPayload());
        }

        assertThat(result).isEqualTo(JobsCatalogFixtures.ciJobRequestResponse());
        HTTP.verifyRequested(POST, "/api/v4/jobs/request");
    }

    @Test
    void request_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/jobs/request", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabInstanceJobsApi api = new GitLabInstanceJobsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.request(JobsCatalogFixtures.instanceJobsRequestPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/jobs/request");
    }

    @Test
    void update_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(PUT, "/api/v4/jobs/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabInstanceJobsApi(GitLabCaller.of(client))
                    .update(1L, JobsCatalogFixtures.instanceJobsUpdatePayload());
        }

        HTTP.verifyRequested(PUT, "/api/v4/jobs/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/jobs/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabInstanceJobsApi api = new GitLabInstanceJobsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(1L, JobsCatalogFixtures.instanceJobsUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/jobs/1");
    }

    @Test
    void getRuntimeEnvironmentKey_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/jobs/1/runtime_environment_key",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabCiRuntimeEnvironmentKey.class, "ci-runtime-environment-key.json")));

        final Optional<GitLabCiRuntimeEnvironmentKey> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabInstanceJobsApi(GitLabCaller.of(client)).getRuntimeEnvironmentKey(1L);
        }

        assertThat(result).contains(JobsCatalogFixtures.ciRuntimeEnvironmentKey());
        HTTP.verifyRequested(GET, "/api/v4/jobs/1/runtime_environment_key");
    }

    @Test
    void getRuntimeEnvironmentKey_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/jobs/1/runtime_environment_key", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabInstanceJobsApi(GitLabCaller.of(client))
                    .getRuntimeEnvironmentKey(1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/jobs/1/runtime_environment_key");
    }

    @Test
    void trace_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(PATCH, "/api/v4/jobs/1/trace", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabInstanceJobsApi(GitLabCaller.of(client))
                    .trace(1L, JobsCatalogFixtures.instanceJobsTracePayload());
        }

        HTTP.verifyRequested(PATCH, "/api/v4/jobs/1/trace");
    }

    @Test
    void trace_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PATCH, "/api/v4/jobs/1/trace", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabInstanceJobsApi api = new GitLabInstanceJobsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.trace(1L, JobsCatalogFixtures.instanceJobsTracePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PATCH, "/api/v4/jobs/1/trace");
    }

    @Test
    void authorizeArtifact_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/jobs/1/artifacts/authorize", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabInstanceJobsApi(GitLabCaller.of(client))
                    .authorizeArtifact(1L, JobsCatalogFixtures.instanceJobsAuthorizeArtifactPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/jobs/1/artifacts/authorize");
    }

    @Test
    void authorizeArtifact_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/jobs/1/artifacts/authorize", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabInstanceJobsApi api = new GitLabInstanceJobsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.authorizeArtifact(1L, JobsCatalogFixtures.instanceJobsAuthorizeArtifactPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/jobs/1/artifacts/authorize");
    }

    @Test
    void getArtifacts_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/jobs/1/artifacts",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabInstanceJobsApi(GitLabCaller.of(client)).getArtifacts(1L, out);
        }

        assertThat(out.toByteArray()).containsExactly(1, 2, 3);
    }

    @Test
    void getArtifacts_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/jobs/1/artifacts",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));
        final Path target = directory.resolve("download.bin");

        final Path written;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            written = new GitLabInstanceJobsApi(GitLabCaller.of(client)).getArtifacts(1L, target);
        }

        assertThat(written).hasBinaryContent(new byte[] {1, 2, 3});
    }

    @Test
    void createArtifact_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/jobs/1/artifacts", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabInstanceJobsApi(GitLabCaller.of(client))
                    .createArtifact(
                            1L,
                            MultipartFormData.builder().text("field", "value").build());
        }

        HTTP.verifyRequested(POST, "/api/v4/jobs/1/artifacts");
    }

    @Test
    void createArtifact_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/jobs/1/artifacts", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabInstanceJobsApi api = new GitLabInstanceJobsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createArtifact(
                    1L, MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/jobs/1/artifacts");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/job",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiJob.class, "ci-job.json")));

        final GitLabCiJob result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabInstanceJobsApi(GitLabCaller.of(client)).get();
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciJob());
        HTTP.verifyRequested(GET, "/api/v4/job");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/job", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabInstanceJobsApi api = new GitLabInstanceJobsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.get());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/job");
    }

    @Test
    void getAllowedAgents_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/job/allowed_agents",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiJob.class, "ci-job.json")));

        final GitLabCiJob result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabInstanceJobsApi(GitLabCaller.of(client)).getAllowedAgents();
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciJob());
        HTTP.verifyRequested(GET, "/api/v4/job/allowed_agents");
    }

    @Test
    void getAllowedAgents_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/job/allowed_agents", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabInstanceJobsApi api = new GitLabInstanceJobsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getAllowedAgents());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/job/allowed_agents");
    }
}

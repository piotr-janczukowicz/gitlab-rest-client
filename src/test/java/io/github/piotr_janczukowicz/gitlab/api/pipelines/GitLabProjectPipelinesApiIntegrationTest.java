package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiPipeline;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiPipelineBasic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiVariable;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectPipelinesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/pipelines",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabCiUserPipeline.class, "ci-user-pipeline.json") + "]")
                        .header("Link", "<" + base + "/api/v4/pipelines?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabCiUserPipeline.class, "ci-user-pipeline.json") + "]"));

        final List<GitLabCiUserPipeline> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectPipelinesApi(GitLabCaller.of(client))
                    .list()
                    .all();
        }

        assertThat(items)
                .containsExactly(PipelinesCatalogFixtures.ciUserPipeline(), PipelinesCatalogFixtures.ciUserPipeline());
        HTTP.verifyRequested(GET, "/api/v4/pipelines", 2);
    }

    @Test
    void listProject_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/pipelines",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabCiPipelineBasic.class, "ci-pipeline-basic.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/projects/group%2Fsub%2Fproject/pipelines?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabCiPipelineBasic.class, "ci-pipeline-basic.json") + "]"));

        final List<GitLabCiPipelineBasic> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectPipelinesApi(GitLabCaller.of(client))
                    .listProject("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(CommonCatalogFixtures.ciPipelineBasic(), CommonCatalogFixtures.ciPipelineBasic());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/pipelines", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/pipeline",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiPipeline.class, "ci-pipeline.json")));

        final GitLabCiPipeline result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectPipelinesApi(GitLabCaller.of(client))
                    .create("group/sub/project", PipelinesCatalogFixtures.projectPipelinesCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciPipeline());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/pipeline");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/pipeline", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPipelinesApi api = new GitLabProjectPipelinesApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.create("group/sub/project", PipelinesCatalogFixtures.projectPipelinesCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/pipeline");
    }

    @Test
    void getLatest_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/pipelines/latest",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabCiPipelineWithMetadata.class, "ci-pipeline-with-metadata.json")));

        final GitLabCiPipelineWithMetadata result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectPipelinesApi(GitLabCaller.of(client)).getLatest("group/sub/project");
        }

        assertThat(result).isEqualTo(PipelinesCatalogFixtures.ciPipelineWithMetadata());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/latest");
    }

    @Test
    void getLatest_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/latest", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPipelinesApi api = new GitLabProjectPipelinesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getLatest("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/latest");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabCiPipelineWithMetadata.class, "ci-pipeline-with-metadata.json")));

        final Optional<GitLabCiPipelineWithMetadata> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectPipelinesApi(GitLabCaller.of(client)).get("group/sub/project", 1L);
        }

        assertThat(result).contains(PipelinesCatalogFixtures.ciPipelineWithMetadata());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectPipelinesApi(GitLabCaller.of(client))
                    .get("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPipelinesApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPipelinesApi api = new GitLabProjectPipelinesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1");
    }

    @Test
    void listBridges_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/bridges",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabCiBridge.class, "ci-bridge.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/bridges?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabCiBridge.class, "ci-bridge.json") + "]"));

        final List<GitLabCiBridge> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectPipelinesApi(GitLabCaller.of(client))
                    .listBridges("group/sub/project", 1L)
                    .all();
        }

        assertThat(items).containsExactly(PipelinesCatalogFixtures.ciBridge(), PipelinesCatalogFixtures.ciBridge());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/bridges", 2);
    }

    @Test
    void listTriggerJobs_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/trigger_jobs",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabCiBridge.class, "ci-bridge.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/trigger_jobs?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabCiBridge.class, "ci-bridge.json") + "]"));

        final List<GitLabCiBridge> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectPipelinesApi(GitLabCaller.of(client))
                    .listTriggerJobs("group/sub/project", 1L)
                    .all();
        }

        assertThat(items).containsExactly(PipelinesCatalogFixtures.ciBridge(), PipelinesCatalogFixtures.ciBridge());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/trigger_jobs", 2);
    }

    @Test
    void listVariables_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/variables",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabCiVariable.class, "ci-variable.json") + "]"));

        final List<GitLabCiVariable> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectPipelinesApi(GitLabCaller.of(client)).listVariables("group/sub/project", 1L);
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.ciVariable());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/variables");
    }

    @Test
    void getTestReport_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/test_report",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabTestReportEntity.class, "test-report-entity.json")));

        final Optional<GitLabTestReportEntity> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectPipelinesApi(GitLabCaller.of(client)).getTestReport("group/sub/project", 1L);
        }

        assertThat(result).contains(PipelinesCatalogFixtures.testReportEntity());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/test_report");
    }

    @Test
    void getTestReport_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/test_report", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectPipelinesApi(GitLabCaller.of(client))
                    .getTestReport("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/test_report");
    }

    @Test
    void getTestReportSummary_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/test_report_summary",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabTestReportSummaryEntity.class, "test-report-summary-entity.json")));

        final Optional<GitLabTestReportSummaryEntity> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectPipelinesApi(GitLabCaller.of(client))
                    .getTestReportSummary("group/sub/project", 1L);
        }

        assertThat(result).contains(PipelinesCatalogFixtures.testReportSummaryEntity());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/test_report_summary");
    }

    @Test
    void getTestReportSummary_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/test_report_summary",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectPipelinesApi(GitLabCaller.of(client))
                    .getTestReportSummary("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/test_report_summary");
    }

    @Test
    void metadata_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/metadata",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabCiPipelineWithMetadata.class, "ci-pipeline-with-metadata.json")));

        final GitLabCiPipelineWithMetadata result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectPipelinesApi(GitLabCaller.of(client))
                    .metadata("group/sub/project", 1L, PipelinesCatalogFixtures.projectPipelinesMetadataPayload());
        }

        assertThat(result).isEqualTo(PipelinesCatalogFixtures.ciPipelineWithMetadata());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/metadata");
    }

    @Test
    void metadata_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/metadata", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPipelinesApi api = new GitLabProjectPipelinesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.metadata("group/sub/project", 1L, PipelinesCatalogFixtures.projectPipelinesMetadataPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/metadata");
    }

    @Test
    void retry_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/retry",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiPipeline.class, "ci-pipeline.json")));

        final GitLabCiPipeline result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectPipelinesApi(GitLabCaller.of(client)).retry("group/sub/project", 1L);
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciPipeline());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/retry");
    }

    @Test
    void retry_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/retry", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPipelinesApi api = new GitLabProjectPipelinesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.retry("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/retry");
    }

    @Test
    void cancel_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/cancel",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiPipeline.class, "ci-pipeline.json")));

        final GitLabCiPipeline result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectPipelinesApi(GitLabCaller.of(client)).cancel("group/sub/project", 1L);
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciPipeline());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/cancel");
    }

    @Test
    void cancel_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/cancel", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPipelinesApi api = new GitLabProjectPipelinesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.cancel("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/pipelines/1/cancel");
    }
}

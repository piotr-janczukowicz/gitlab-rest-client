package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiPipeline;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiPipelineBasic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiVariable;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPipelinesApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectPipelinesApi api() {
        return new GitLabProjectPipelinesApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectPipelinesApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabCiUserPipeline.class, "ci-user-pipeline.json") + "]"));

        final GitLabPage<GitLabCiUserPipeline> page = api().list();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(PipelinesCatalogFixtures.ciUserPipeline());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/pipelines");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabCiUserPipeline.class, "ci-user-pipeline.json") + "]"));

        final GitLabPage<GitLabCiUserPipeline> page = api().list(GitLabProjectPipelinesListFilterBuilder.builder()
                .source(GitLabProjectPipelinesListSource.UNKNOWN)
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .orderBy(GitLabProjectPipelinesListOrderBy.CREATED_AT)
                .sort(GitLabProjectPipelinesListSort.DESC)
                .cursor("cursor")
                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(PipelinesCatalogFixtures.ciUserPipeline());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/pipelines");
            softly.assertThat(request.uri()).hasParameter("source", "unknown");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabCiUserPipeline.class, "ci-user-pipeline.json") + "]"));

        final GitLabPage<GitLabCiUserPipeline> page = api().list(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(PipelinesCatalogFixtures.ciUserPipeline());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/pipelines");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabCiUserPipeline.class, "ci-user-pipeline.json") + "]"));

        final GitLabPage<GitLabCiUserPipeline> page = api().list(
                        GitLabProjectPipelinesListFilterBuilder.builder()
                                .source(GitLabProjectPipelinesListSource.UNKNOWN)
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .orderBy(GitLabProjectPipelinesListOrderBy.CREATED_AT)
                                .sort(GitLabProjectPipelinesListSort.DESC)
                                .cursor("cursor")
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(PipelinesCatalogFixtures.ciUserPipeline());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/pipelines");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("source", "unknown");
        });
    }

    @Test
    void listProject_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabCiPipelineBasic.class, "ci-pipeline-basic.json") + "]"));

        final GitLabPage<GitLabCiPipelineBasic> page = api().listProject("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.ciPipelineBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipelines");
        });
    }

    @Test
    void listProject_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabCiPipelineBasic.class, "ci-pipeline-basic.json") + "]"));

        final GitLabPage<GitLabCiPipelineBasic> page = api().listProject(
                        "group/sub/project",
                        GitLabProjectPipelinesListProjectFilterBuilder.builder()
                                .scope(GitLabProjectPipelinesListProjectScope.RUNNING)
                                .status(GitLabProjectPipelinesListProjectStatus.CREATED)
                                .ref("ref")
                                .sha("sha")
                                .yamlErrors(true)
                                .username("username")
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .orderBy(GitLabProjectPipelinesListProjectOrderBy.ID)
                                .sort(GitLabProjectPipelinesListProjectSort.ASC)
                                .source(GitLabProjectPipelinesListProjectSource.UNKNOWN)
                                .name("name")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.ciPipelineBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipelines");
            softly.assertThat(request.uri()).hasParameter("scope", "running");
        });
    }

    @Test
    void listProject_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabCiPipelineBasic.class, "ci-pipeline-basic.json") + "]"));

        final GitLabPage<GitLabCiPipelineBasic> page =
                api().listProject("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.ciPipelineBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipelines");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listProject_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabCiPipelineBasic.class, "ci-pipeline-basic.json") + "]"));

        final GitLabPage<GitLabCiPipelineBasic> page = api().listProject(
                        "group/sub/project",
                        GitLabProjectPipelinesListProjectFilterBuilder.builder()
                                .scope(GitLabProjectPipelinesListProjectScope.RUNNING)
                                .status(GitLabProjectPipelinesListProjectStatus.CREATED)
                                .ref("ref")
                                .sha("sha")
                                .yamlErrors(true)
                                .username("username")
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .orderBy(GitLabProjectPipelinesListProjectOrderBy.ID)
                                .sort(GitLabProjectPipelinesListProjectSort.ASC)
                                .source(GitLabProjectPipelinesListProjectSource.UNKNOWN)
                                .name("name")
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.ciPipelineBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipelines");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("scope", "running");
        });
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCiPipeline.class, "ci-pipeline.json")));

        final GitLabCiPipeline result =
                api().create("group/sub/project", PipelinesCatalogFixtures.projectPipelinesCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.ciPipeline());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/pipeline");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"ref\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().create("group/sub/project", PipelinesCatalogFixtures.projectPipelinesCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getLatest_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabCiPipelineWithMetadata.class, "ci-pipeline-with-metadata.json")));

        final GitLabCiPipelineWithMetadata result = api().getLatest("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(PipelinesCatalogFixtures.ciPipelineWithMetadata());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipelines/latest");
        });
    }

    @Test
    void getLatest_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getLatest("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getLatest_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabCiPipelineWithMetadata.class, "ci-pipeline-with-metadata.json")));

        api().getLatest(
                        "group/sub/project",
                        GitLabProjectPipelinesGetLatestFilterBuilder.builder()
                                .ref("ref")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("ref", "ref");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabCiPipelineWithMetadata.class, "ci-pipeline-with-metadata.json")));

        final Optional<GitLabCiPipelineWithMetadata> result = api().get("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(PipelinesCatalogFixtures.ciPipelineWithMetadata());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipelines/1");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabCiPipelineWithMetadata> result = api().get("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/pipelines/1");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listBridges_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabCiBridge.class, "ci-bridge.json") + "]"));

        final GitLabPage<GitLabCiBridge> page = api().listBridges("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(PipelinesCatalogFixtures.ciBridge());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipelines/1/bridges");
        });
    }

    @Test
    void listBridges_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabCiBridge.class, "ci-bridge.json") + "]"));

        final GitLabPage<GitLabCiBridge> page = api().listBridges(
                        "group/sub/project",
                        1L,
                        GitLabProjectPipelinesListBridgesFilterBuilder.builder()
                                .scope(List.of("text"))
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(PipelinesCatalogFixtures.ciBridge());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipelines/1/bridges");
            softly.assertThat(request.uri()).hasParameter("scope", "text");
        });
    }

    @Test
    void listBridges_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabCiBridge.class, "ci-bridge.json") + "]"));

        final GitLabPage<GitLabCiBridge> page = api().listBridges("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(PipelinesCatalogFixtures.ciBridge());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipelines/1/bridges");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listBridges_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabCiBridge.class, "ci-bridge.json") + "]"));

        final GitLabPage<GitLabCiBridge> page = api().listBridges(
                        "group/sub/project",
                        1L,
                        GitLabProjectPipelinesListBridgesFilterBuilder.builder()
                                .scope(List.of("text"))
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(PipelinesCatalogFixtures.ciBridge());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipelines/1/bridges");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("scope", "text");
        });
    }

    @Test
    void listTriggerJobs_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabCiBridge.class, "ci-bridge.json") + "]"));

        final GitLabPage<GitLabCiBridge> page = api().listTriggerJobs("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(PipelinesCatalogFixtures.ciBridge());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipelines/1/trigger_jobs");
        });
    }

    @Test
    void listTriggerJobs_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabCiBridge.class, "ci-bridge.json") + "]"));

        final GitLabPage<GitLabCiBridge> page = api().listTriggerJobs(
                        "group/sub/project",
                        1L,
                        GitLabProjectPipelinesListTriggerJobsFilterBuilder.builder()
                                .scope(List.of("text"))
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(PipelinesCatalogFixtures.ciBridge());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipelines/1/trigger_jobs");
            softly.assertThat(request.uri()).hasParameter("scope", "text");
        });
    }

    @Test
    void listTriggerJobs_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabCiBridge.class, "ci-bridge.json") + "]"));

        final GitLabPage<GitLabCiBridge> page =
                api().listTriggerJobs("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(PipelinesCatalogFixtures.ciBridge());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipelines/1/trigger_jobs");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listTriggerJobs_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabCiBridge.class, "ci-bridge.json") + "]"));

        final GitLabPage<GitLabCiBridge> page = api().listTriggerJobs(
                        "group/sub/project",
                        1L,
                        GitLabProjectPipelinesListTriggerJobsFilterBuilder.builder()
                                .scope(List.of("text"))
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(PipelinesCatalogFixtures.ciBridge());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipelines/1/trigger_jobs");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("scope", "text");
        });
    }

    @Test
    void listVariables_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabCiVariable.class, "ci-variable.json") + "]"));

        final List<GitLabCiVariable> result = api().listVariables("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(CommonCatalogFixtures.ciVariable());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipelines/1/variables");
        });
    }

    @Test
    void getTestReport_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabTestReportEntity.class, "test-report-entity.json")));

        final Optional<GitLabTestReportEntity> result = api().getTestReport("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(PipelinesCatalogFixtures.testReportEntity());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipelines/1/test_report");
        });
    }

    @Test
    void getTestReport_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabTestReportEntity> result = api().getTestReport("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void getTestReportSummary_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabTestReportSummaryEntity.class, "test-report-summary-entity.json")));

        final Optional<GitLabTestReportSummaryEntity> result = api().getTestReportSummary("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(PipelinesCatalogFixtures.testReportSummaryEntity());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipelines/1/test_report_summary");
        });
    }

    @Test
    void getTestReportSummary_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabTestReportSummaryEntity> result = api().getTestReportSummary("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void metadata_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabCiPipelineWithMetadata.class, "ci-pipeline-with-metadata.json")));

        final GitLabCiPipelineWithMetadata result =
                api().metadata("group/sub/project", 1L, PipelinesCatalogFixtures.projectPipelinesMetadataPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(PipelinesCatalogFixtures.ciPipelineWithMetadata());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/pipelines/1/metadata");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void metadata_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().metadata("group/sub/project", 1L, PipelinesCatalogFixtures.projectPipelinesMetadataPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void retry_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCiPipeline.class, "ci-pipeline.json")));

        final GitLabCiPipeline result = api().retry("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.ciPipeline());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/pipelines/1/retry");
        });
    }

    @Test
    void retry_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().retry("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void cancel_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCiPipeline.class, "ci-pipeline.json")));

        final GitLabCiPipeline result = api().cancel("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.ciPipeline());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/pipelines/1/cancel");
        });
    }

    @Test
    void cancel_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().cancel("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}

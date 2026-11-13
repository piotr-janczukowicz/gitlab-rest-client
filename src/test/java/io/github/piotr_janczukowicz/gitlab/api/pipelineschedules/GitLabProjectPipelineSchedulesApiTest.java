package io.github.piotr_janczukowicz.gitlab.api.pipelineschedules;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
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
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPipelineSchedulesApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectPipelineSchedulesApi api() {
        return new GitLabProjectPipelineSchedulesApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectPipelineSchedulesApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabCiPipelineSchedule.class, "ci-pipeline-schedule.json") + "]"));

        final GitLabPage<GitLabCiPipelineSchedule> page = api().list("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(PipelineschedulesCatalogFixtures.ciPipelineSchedule());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabCiPipelineSchedule.class, "ci-pipeline-schedule.json") + "]"));

        final GitLabPage<GitLabCiPipelineSchedule> page = api().list(
                        "group/sub/project",
                        GitLabProjectPipelineSchedulesListFilterBuilder.builder()
                                .scope(GitLabProjectPipelineSchedulesListScope.ACTIVE)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(PipelineschedulesCatalogFixtures.ciPipelineSchedule());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules");
            softly.assertThat(request.uri()).hasParameter("scope", "active");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabCiPipelineSchedule.class, "ci-pipeline-schedule.json") + "]"));

        final GitLabPage<GitLabCiPipelineSchedule> page = api().list("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(PipelineschedulesCatalogFixtures.ciPipelineSchedule());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabCiPipelineSchedule.class, "ci-pipeline-schedule.json") + "]"));

        final GitLabPage<GitLabCiPipelineSchedule> page = api().list(
                        "group/sub/project",
                        GitLabProjectPipelineSchedulesListFilterBuilder.builder()
                                .scope(GitLabProjectPipelineSchedulesListScope.ACTIVE)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(PipelineschedulesCatalogFixtures.ciPipelineSchedule());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("scope", "active");
        });
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabCiPipelineScheduleDetails.class, "ci-pipeline-schedule-details.json")));

        final GitLabCiPipelineScheduleDetails result = api().create(
                        "group/sub/project", PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(PipelineschedulesCatalogFixtures.ciPipelineScheduleDetails());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"description\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().create(
                        "group/sub/project", PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabCiPipelineScheduleDetails.class, "ci-pipeline-schedule-details.json")));

        final Optional<GitLabCiPipelineScheduleDetails> result = api().get("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(PipelineschedulesCatalogFixtures.ciPipelineScheduleDetails());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabCiPipelineScheduleDetails> result = api().get("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabCiPipelineScheduleDetails.class, "ci-pipeline-schedule-details.json")));

        final GitLabCiPipelineScheduleDetails result = api().update(
                        "group/sub/project",
                        1L,
                        PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(PipelineschedulesCatalogFixtures.ciPipelineScheduleDetails());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"description\":");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().update(
                        "group/sub/project",
                        1L,
                        PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1");
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
                        200, "[" + FileUtils.readString(GitLabCiPipelineBasic.class, "ci-pipeline-basic.json") + "]"));

        final GitLabPage<GitLabCiPipelineBasic> page = api().listPipelines("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.ciPipelineBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/pipelines");
        });
    }

    @Test
    void listPipelines_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabCiPipelineBasic.class, "ci-pipeline-basic.json") + "]"));

        final GitLabPage<GitLabCiPipelineBasic> page = api().listPipelines(
                        "group/sub/project",
                        1L,
                        GitLabProjectPipelineSchedulesListPipelinesFilterBuilder.builder()
                                .scope(GitLabProjectPipelineSchedulesListPipelinesScope.RUNNING)
                                .status(GitLabProjectPipelineSchedulesListPipelinesStatus.CREATED)
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .sort(GitLabProjectPipelineSchedulesListPipelinesSort.ASC)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.ciPipelineBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/pipelines");
            softly.assertThat(request.uri()).hasParameter("scope", "running");
        });
    }

    @Test
    void listPipelines_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabCiPipelineBasic.class, "ci-pipeline-basic.json") + "]"));

        final GitLabPage<GitLabCiPipelineBasic> page =
                api().listPipelines("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.ciPipelineBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/pipelines");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listPipelines_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabCiPipelineBasic.class, "ci-pipeline-basic.json") + "]"));

        final GitLabPage<GitLabCiPipelineBasic> page = api().listPipelines(
                        "group/sub/project",
                        1L,
                        GitLabProjectPipelineSchedulesListPipelinesFilterBuilder.builder()
                                .scope(GitLabProjectPipelineSchedulesListPipelinesScope.RUNNING)
                                .status(GitLabProjectPipelineSchedulesListPipelinesStatus.CREATED)
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .sort(GitLabProjectPipelineSchedulesListPipelinesSort.ASC)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.ciPipelineBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/pipelines");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("scope", "running");
        });
    }

    @Test
    void takeOwnership_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabCiPipelineScheduleDetails.class, "ci-pipeline-schedule-details.json")));

        final GitLabCiPipelineScheduleDetails result = api().takeOwnership("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(PipelineschedulesCatalogFixtures.ciPipelineScheduleDetails());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/take_ownership");
        });
    }

    @Test
    void takeOwnership_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().takeOwnership("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void play_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().play("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/play");
    }

    @Test
    void play_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().play("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createVariable_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCiVariable.class, "ci-variable.json")));

        final GitLabCiVariable result = api().createVariable(
                        "group/sub/project",
                        1L,
                        PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreateVariablePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.ciVariable());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/variables");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"key\":");
        });
    }

    @Test
    void createVariable_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createVariable(
                        "group/sub/project",
                        1L,
                        PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreateVariablePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getVariable_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCiVariable.class, "ci-variable.json")));

        final Optional<GitLabCiVariable> result = api().getVariable("group/sub/project", 1L, "key");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.ciVariable());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/variables/key");
        });
    }

    @Test
    void getVariable_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabCiVariable> result = api().getVariable("group/sub/project", 1L, "key");

        assertThat(result).isEmpty();
    }

    @Test
    void updateVariable_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCiVariable.class, "ci-variable.json")));

        final GitLabCiVariable result = api().updateVariable(
                        "group/sub/project",
                        1L,
                        "key",
                        PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdateVariablePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.ciVariable());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/variables/key");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"value\":");
        });
    }

    @Test
    void updateVariable_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateVariable(
                        "group/sub/project",
                        1L,
                        "key",
                        PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdateVariablePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteVariable_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCiVariable.class, "ci-variable.json")));

        final Optional<GitLabCiVariable> result = api().deleteVariable("group/sub/project", 1L, "key");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.ciVariable());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/variables/key");
        });
    }

    @Test
    void deleteVariable_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteVariable("group/sub/project", 1L, "key"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteVariable_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        final Optional<GitLabCiVariable> result = api().deleteVariable("group/sub/project", 1L, "key");

        assertThat(result).isEmpty();
    }
}

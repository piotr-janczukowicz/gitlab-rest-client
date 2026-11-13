package io.github.piotr_janczukowicz.gitlab.api.pipelineschedules;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
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
class GitLabProjectPipelineSchedulesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabCiPipelineSchedule.class, "ci-pipeline-schedule.json")
                                        + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabCiPipelineSchedule.class, "ci-pipeline-schedule.json") + "]"));

        final List<GitLabCiPipelineSchedule> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectPipelineSchedulesApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        PipelineschedulesCatalogFixtures.ciPipelineSchedule(),
                        PipelineschedulesCatalogFixtures.ciPipelineSchedule());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabCiPipelineScheduleDetails.class, "ci-pipeline-schedule-details.json")));

        final GitLabCiPipelineScheduleDetails result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectPipelineSchedulesApi(GitLabCaller.of(client))
                    .create(
                            "group/sub/project",
                            PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreatePayload());
        }

        assertThat(result).isEqualTo(PipelineschedulesCatalogFixtures.ciPipelineScheduleDetails());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPipelineSchedulesApi api =
                    new GitLabProjectPipelineSchedulesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    "group/sub/project", PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabCiPipelineScheduleDetails.class, "ci-pipeline-schedule-details.json")));

        final Optional<GitLabCiPipelineScheduleDetails> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectPipelineSchedulesApi(GitLabCaller.of(client)).get("group/sub/project", 1L);
        }

        assertThat(result).contains(PipelineschedulesCatalogFixtures.ciPipelineScheduleDetails());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectPipelineSchedulesApi(GitLabCaller.of(client))
                    .get("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabCiPipelineScheduleDetails.class, "ci-pipeline-schedule-details.json")));

        final GitLabCiPipelineScheduleDetails result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectPipelineSchedulesApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            1L,
                            PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdatePayload());
        }

        assertThat(result).isEqualTo(PipelineschedulesCatalogFixtures.ciPipelineScheduleDetails());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPipelineSchedulesApi api =
                    new GitLabProjectPipelineSchedulesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project", 1L, PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPipelineSchedulesApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPipelineSchedulesApi api =
                    new GitLabProjectPipelineSchedulesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1");
    }

    @Test
    void listPipelines_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/pipelines",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabCiPipelineBasic.class, "ci-pipeline-basic.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/pipelines?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabCiPipelineBasic.class, "ci-pipeline-basic.json") + "]"));

        final List<GitLabCiPipelineBasic> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectPipelineSchedulesApi(GitLabCaller.of(client))
                    .listPipelines("group/sub/project", 1L)
                    .all();
        }

        assertThat(items)
                .containsExactly(CommonCatalogFixtures.ciPipelineBasic(), CommonCatalogFixtures.ciPipelineBasic());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/pipelines", 2);
    }

    @Test
    void takeOwnership_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/take_ownership",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabCiPipelineScheduleDetails.class, "ci-pipeline-schedule-details.json")));

        final GitLabCiPipelineScheduleDetails result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectPipelineSchedulesApi(GitLabCaller.of(client))
                    .takeOwnership("group/sub/project", 1L);
        }

        assertThat(result).isEqualTo(PipelineschedulesCatalogFixtures.ciPipelineScheduleDetails());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/take_ownership");
    }

    @Test
    void takeOwnership_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/take_ownership",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPipelineSchedulesApi api =
                    new GitLabProjectPipelineSchedulesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.takeOwnership("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/take_ownership");
    }

    @Test
    void play_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/play",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPipelineSchedulesApi(GitLabCaller.of(client)).play("group/sub/project", 1L);
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/play");
    }

    @Test
    void play_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/play",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPipelineSchedulesApi api =
                    new GitLabProjectPipelineSchedulesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.play("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/play");
    }

    @Test
    void createVariable_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/variables",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiVariable.class, "ci-variable.json")));

        final GitLabCiVariable result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectPipelineSchedulesApi(GitLabCaller.of(client))
                    .createVariable(
                            "group/sub/project",
                            1L,
                            PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreateVariablePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciVariable());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/variables");
    }

    @Test
    void createVariable_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/variables",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPipelineSchedulesApi api =
                    new GitLabProjectPipelineSchedulesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createVariable(
                    "group/sub/project",
                    1L,
                    PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreateVariablePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/variables");
    }

    @Test
    void getVariable_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/variables/key",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiVariable.class, "ci-variable.json")));

        final Optional<GitLabCiVariable> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectPipelineSchedulesApi(GitLabCaller.of(client))
                    .getVariable("group/sub/project", 1L, "key");
        }

        assertThat(result).contains(CommonCatalogFixtures.ciVariable());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/variables/key");
    }

    @Test
    void getVariable_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/variables/key",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectPipelineSchedulesApi(GitLabCaller.of(client))
                    .getVariable("group/sub/project", 1L, "key")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/variables/key");
    }

    @Test
    void updateVariable_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/variables/key",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiVariable.class, "ci-variable.json")));

        final GitLabCiVariable result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectPipelineSchedulesApi(GitLabCaller.of(client))
                    .updateVariable(
                            "group/sub/project",
                            1L,
                            "key",
                            PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdateVariablePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciVariable());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/variables/key");
    }

    @Test
    void updateVariable_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/variables/key",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPipelineSchedulesApi api =
                    new GitLabProjectPipelineSchedulesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateVariable(
                    "group/sub/project",
                    1L,
                    "key",
                    PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdateVariablePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/variables/key");
    }

    @Test
    void deleteVariable_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/variables/key",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiVariable.class, "ci-variable.json")));

        final Optional<GitLabCiVariable> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectPipelineSchedulesApi(GitLabCaller.of(client))
                    .deleteVariable("group/sub/project", 1L, "key");
        }

        assertThat(result).contains(CommonCatalogFixtures.ciVariable());
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/variables/key");
    }

    @Test
    void deleteVariable_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/variables/key",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPipelineSchedulesApi api =
                    new GitLabProjectPipelineSchedulesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteVariable("group/sub/project", 1L, "key"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/variables/key");
    }

    @Test
    void deleteVariable_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/variables/key",
                GitLabApiStubSupport.noContent());

        final Optional<GitLabCiVariable> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectPipelineSchedulesApi(GitLabCaller.of(client))
                    .deleteVariable("group/sub/project", 1L, "key");
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/pipeline_schedules/1/variables/key");
    }
}

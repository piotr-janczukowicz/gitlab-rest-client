package io.github.piotr_janczukowicz.gitlab.api.experiments;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

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
class GitLabExperimentsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/experiments",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabExperiment.class, "experiment.json") + "]"));

        final List<GitLabExperiment> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabExperimentsApi(GitLabCaller.of(client)).list();
        }

        assertThat(result).containsExactly(ExperimentsCatalogFixtures.experiment());
        HTTP.verifyRequested(GET, "/api/v4/experiments");
    }

    @Test
    void deleteCache_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/experiments/name/cache", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabExperimentsApi(GitLabCaller.of(client)).deleteCache("name");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/experiments/name/cache");
    }

    @Test
    void deleteCache_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/experiments/name/cache", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabExperimentsApi api = new GitLabExperimentsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteCache("name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/experiments/name/cache");
    }

    @Test
    void getAssignments_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/experiments/experiment_name/assignments",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabExperimentAssignment.class, "experiment-assignment.json")));

        final Optional<GitLabExperimentAssignment> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabExperimentsApi(GitLabCaller.of(client)).getAssignments("experiment_name");
        }

        assertThat(result).contains(ExperimentsCatalogFixtures.experimentAssignment());
        HTTP.verifyRequested(GET, "/api/v4/experiments/experiment_name/assignments");
    }

    @Test
    void getAssignments_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/experiments/experiment_name/assignments", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabExperimentsApi(GitLabCaller.of(client))
                    .getAssignments("experiment_name")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/experiments/experiment_name/assignments");
    }

    @Test
    void createAssignment_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/experiments/experiment_name/assignments",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabExperimentAssignment.class, "experiment-assignment.json")));

        final GitLabExperimentAssignment result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabExperimentsApi(GitLabCaller.of(client))
                    .createAssignment(
                            "experiment_name", ExperimentsCatalogFixtures.experimentsCreateAssignmentPayload());
        }

        assertThat(result).isEqualTo(ExperimentsCatalogFixtures.experimentAssignment());
        HTTP.verifyRequested(POST, "/api/v4/experiments/experiment_name/assignments");
    }

    @Test
    void createAssignment_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/experiments/experiment_name/assignments", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabExperimentsApi api = new GitLabExperimentsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createAssignment(
                    "experiment_name", ExperimentsCatalogFixtures.experimentsCreateAssignmentPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/experiments/experiment_name/assignments");
    }

    @Test
    void deleteAssignment_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/experiments/experiment_name/assignments", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabExperimentsApi(GitLabCaller.of(client)).deleteAssignment("experiment_name");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/experiments/experiment_name/assignments");
    }

    @Test
    void deleteAssignment_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/experiments/experiment_name/assignments", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabExperimentsApi api = new GitLabExperimentsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteAssignment("experiment_name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/experiments/experiment_name/assignments");
    }
}

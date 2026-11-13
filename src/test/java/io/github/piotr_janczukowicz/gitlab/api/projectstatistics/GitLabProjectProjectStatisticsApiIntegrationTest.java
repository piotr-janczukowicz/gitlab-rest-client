package io.github.piotr_janczukowicz.gitlab.api.projectstatistics;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectProjectStatisticsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/statistics",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabProjectDailyStatistics.class, "project-daily-statistics.json")));

        final GitLabProjectDailyStatistics result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectStatisticsApi(GitLabCaller.of(client)).get("group/sub/project");
        }

        assertThat(result).isEqualTo(ProjectstatisticsCatalogFixtures.projectDailyStatistics());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/statistics");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/statistics", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectStatisticsApi api =
                    new GitLabProjectProjectStatisticsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.get("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/statistics");
    }
}

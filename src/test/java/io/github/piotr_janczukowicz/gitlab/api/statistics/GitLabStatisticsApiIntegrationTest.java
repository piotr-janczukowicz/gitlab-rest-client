package io.github.piotr_janczukowicz.gitlab.api.statistics;

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
class GitLabStatisticsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/application/statistics",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabApplicationStatistics.class, "application-statistics.json")));

        final GitLabApplicationStatistics result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabStatisticsApi(GitLabCaller.of(client)).get();
        }

        assertThat(result).isEqualTo(StatisticsCatalogFixtures.applicationStatistics());
        HTTP.verifyRequested(GET, "/api/v4/application/statistics");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/application/statistics", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabStatisticsApi api = new GitLabStatisticsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.get());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/application/statistics");
    }
}

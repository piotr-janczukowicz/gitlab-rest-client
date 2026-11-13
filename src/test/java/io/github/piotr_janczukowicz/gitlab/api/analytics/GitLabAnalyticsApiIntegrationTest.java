package io.github.piotr_janczukowicz.gitlab.api.analytics;

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
class GitLabAnalyticsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void getIssuesCount_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/analytics/group_activity/issues_count",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabAnalyticsGroupActivityIssuesCount.class, "analytics-group-activity-issues-count.json")));

        final GitLabAnalyticsGroupActivityIssuesCount result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabAnalyticsApi(GitLabCaller.of(client)).getIssuesCount("group_path");
        }

        assertThat(result).isEqualTo(AnalyticsCatalogFixtures.analyticsGroupActivityIssuesCount());
        HTTP.verifyRequested(GET, "/api/v4/analytics/group_activity/issues_count");
    }

    @Test
    void getIssuesCount_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/analytics/group_activity/issues_count", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabAnalyticsApi api = new GitLabAnalyticsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getIssuesCount("group_path"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/analytics/group_activity/issues_count");
    }

    @Test
    void getMergeRequestsCount_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/analytics/group_activity/merge_requests_count",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabAnalyticsGroupActivityMergeRequestsCount.class,
                        "analytics-group-activity-merge-requests-count.json")));

        final GitLabAnalyticsGroupActivityMergeRequestsCount result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabAnalyticsApi(GitLabCaller.of(client)).getMergeRequestsCount("group_path");
        }

        assertThat(result).isEqualTo(AnalyticsCatalogFixtures.analyticsGroupActivityMergeRequestsCount());
        HTTP.verifyRequested(GET, "/api/v4/analytics/group_activity/merge_requests_count");
    }

    @Test
    void getMergeRequestsCount_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/analytics/group_activity/merge_requests_count", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabAnalyticsApi api = new GitLabAnalyticsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getMergeRequestsCount("group_path"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/analytics/group_activity/merge_requests_count");
    }

    @Test
    void getNewMembersCount_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/analytics/group_activity/new_members_count",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabAnalyticsGroupActivityNewMembersCount.class,
                        "analytics-group-activity-new-members-count.json")));

        final GitLabAnalyticsGroupActivityNewMembersCount result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabAnalyticsApi(GitLabCaller.of(client)).getNewMembersCount("group_path");
        }

        assertThat(result).isEqualTo(AnalyticsCatalogFixtures.analyticsGroupActivityNewMembersCount());
        HTTP.verifyRequested(GET, "/api/v4/analytics/group_activity/new_members_count");
    }

    @Test
    void getNewMembersCount_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/analytics/group_activity/new_members_count", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabAnalyticsApi api = new GitLabAnalyticsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getNewMembersCount("group_path"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/analytics/group_activity/new_members_count");
    }
}

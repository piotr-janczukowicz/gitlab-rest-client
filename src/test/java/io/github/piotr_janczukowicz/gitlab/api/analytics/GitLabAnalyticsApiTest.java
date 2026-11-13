package io.github.piotr_janczukowicz.gitlab.api.analytics;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAnalyticsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabAnalyticsApi api() {
        return new GitLabAnalyticsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabAnalyticsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void getIssuesCount_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabAnalyticsApi lowTier =
                new GitLabAnalyticsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getIssuesCount("group_path"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getIssuesCount_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabAnalyticsApi lowTier =
                new GitLabAnalyticsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getIssuesCount("group_path"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getIssuesCount_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabAnalyticsGroupActivityIssuesCount.class,
                                "analytics-group-activity-issues-count.json")));

        final GitLabAnalyticsGroupActivityIssuesCount result = api().getIssuesCount("group_path");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(AnalyticsCatalogFixtures.analyticsGroupActivityIssuesCount());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/analytics/group_activity/issues_count");
            softly.assertThat(request.uri()).hasParameter("group_path", "group_path");
        });
    }

    @Test
    void getIssuesCount_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getIssuesCount("group_path"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getMergeRequestsCount_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabAnalyticsApi lowTier =
                new GitLabAnalyticsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getMergeRequestsCount("group_path"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getMergeRequestsCount_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabAnalyticsApi lowTier =
                new GitLabAnalyticsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getMergeRequestsCount("group_path"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getMergeRequestsCount_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabAnalyticsGroupActivityMergeRequestsCount.class,
                                "analytics-group-activity-merge-requests-count.json")));

        final GitLabAnalyticsGroupActivityMergeRequestsCount result = api().getMergeRequestsCount("group_path");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(AnalyticsCatalogFixtures.analyticsGroupActivityMergeRequestsCount());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/analytics/group_activity/merge_requests_count");
            softly.assertThat(request.uri()).hasParameter("group_path", "group_path");
        });
    }

    @Test
    void getMergeRequestsCount_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getMergeRequestsCount("group_path"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getNewMembersCount_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabAnalyticsApi lowTier =
                new GitLabAnalyticsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getNewMembersCount("group_path"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getNewMembersCount_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabAnalyticsApi lowTier =
                new GitLabAnalyticsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getNewMembersCount("group_path"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getNewMembersCount_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabAnalyticsGroupActivityNewMembersCount.class,
                                "analytics-group-activity-new-members-count.json")));

        final GitLabAnalyticsGroupActivityNewMembersCount result = api().getNewMembersCount("group_path");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(AnalyticsCatalogFixtures.analyticsGroupActivityNewMembersCount());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/analytics/group_activity/new_members_count");
            softly.assertThat(request.uri()).hasParameter("group_path", "group_path");
        });
    }

    @Test
    void getNewMembersCount_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getNewMembersCount("group_path"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}

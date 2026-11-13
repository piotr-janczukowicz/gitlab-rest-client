package io.github.piotr_janczukowicz.gitlab.api.codereviewanalytics;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCodeReviewAnalyticsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabCodeReviewAnalyticsApi api() {
        return new GitLabCodeReviewAnalyticsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabCodeReviewAnalyticsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabCodeReviewAnalyticsApi lowTier =
                new GitLabCodeReviewAnalyticsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list(1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void list_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabCodeReviewAnalyticsApi lowTier =
                new GitLabCodeReviewAnalyticsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list(1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabAnalyticsCodeReviewMergeRequest.class,
                                        "analytics-code-review-merge-request.json")
                                + "]"));

        final GitLabPage<GitLabAnalyticsCodeReviewMergeRequest> page = api().list(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items())
                    .containsExactly(CodereviewanalyticsCatalogFixtures.analyticsCodeReviewMergeRequest());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/analytics/code_review");
            softly.assertThat(request.uri()).hasParameter("project_id", "1");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabAnalyticsCodeReviewMergeRequest.class,
                                        "analytics-code-review-merge-request.json")
                                + "]"));

        final GitLabPage<GitLabAnalyticsCodeReviewMergeRequest> page = api().list(
                        1L,
                        GitLabCodeReviewAnalyticsListFilterBuilder.builder()
                                .labelName(List.of("label_name"))
                                .milestoneTitle("milestone_title")
                                .notLabelName(List.of("not[label_name]"))
                                .notMilestoneTitle("not[milestone_title]")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items())
                    .containsExactly(CodereviewanalyticsCatalogFixtures.analyticsCodeReviewMergeRequest());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/analytics/code_review");
            softly.assertThat(request.uri()).hasParameter("project_id", "1");
            softly.assertThat(request.uri()).hasParameter("label_name", "label_name");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabAnalyticsCodeReviewMergeRequest.class,
                                        "analytics-code-review-merge-request.json")
                                + "]"));

        final GitLabPage<GitLabAnalyticsCodeReviewMergeRequest> page = api().list(1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items())
                    .containsExactly(CodereviewanalyticsCatalogFixtures.analyticsCodeReviewMergeRequest());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/analytics/code_review");
            softly.assertThat(request.uri()).hasParameter("project_id", "1");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabAnalyticsCodeReviewMergeRequest.class,
                                        "analytics-code-review-merge-request.json")
                                + "]"));

        final GitLabPage<GitLabAnalyticsCodeReviewMergeRequest> page = api().list(
                        1L,
                        GitLabCodeReviewAnalyticsListFilterBuilder.builder()
                                .labelName(List.of("label_name"))
                                .milestoneTitle("milestone_title")
                                .notLabelName(List.of("not[label_name]"))
                                .notMilestoneTitle("not[milestone_title]")
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items())
                    .containsExactly(CodereviewanalyticsCatalogFixtures.analyticsCodeReviewMergeRequest());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/analytics/code_review");
            softly.assertThat(request.uri()).hasParameter("project_id", "1");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("label_name", "label_name");
        });
    }
}

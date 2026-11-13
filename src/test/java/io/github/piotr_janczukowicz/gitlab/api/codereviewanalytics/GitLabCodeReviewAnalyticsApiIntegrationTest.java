package io.github.piotr_janczukowicz.gitlab.api.codereviewanalytics;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabCodeReviewAnalyticsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/analytics/code_review",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(
                                        GitLabAnalyticsCodeReviewMergeRequest.class,
                                        "analytics-code-review-merge-request.json")
                                + "]")
                        .header("Link", "<" + base + "/api/v4/analytics/code_review?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(
                                GitLabAnalyticsCodeReviewMergeRequest.class, "analytics-code-review-merge-request.json")
                        + "]"));

        final List<GitLabAnalyticsCodeReviewMergeRequest> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabCodeReviewAnalyticsApi(GitLabCaller.of(client))
                    .list(1L)
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        CodereviewanalyticsCatalogFixtures.analyticsCodeReviewMergeRequest(),
                        CodereviewanalyticsCatalogFixtures.analyticsCodeReviewMergeRequest());
        HTTP.verifyRequested(GET, "/api/v4/analytics/code_review", 2);
    }
}

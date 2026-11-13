package io.github.piotr_janczukowicz.gitlab.api.codereviewanalytics;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.RequiresTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.client.pagination.GitLabListSpec;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPageRequest;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/** The GitLab operations of code review analytics. */
public final class GitLabCodeReviewAnalyticsApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/analytics/code_review");
    private static final JsonType<List<GitLabAnalyticsCodeReviewMergeRequest>>
            ANALYTICS_CODE_REVIEW_MERGE_REQUEST_LIST_TYPE =
                    JsonTypes.listOf(GitLabAnalyticsCodeReviewMergeRequest.class);
    private static final GitLabListSpec<GitLabAnalyticsCodeReviewMergeRequest>
            ANALYTICS_CODE_REVIEW_MERGE_REQUEST_SPEC =
                    GitLabListSpec.offset(ANALYTICS_CODE_REVIEW_MERGE_REQUEST_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabCodeReviewAnalyticsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /analytics/code_review}).
     *
     * @param projectId the project id
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code projectId} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAnalyticsCodeReviewMergeRequest> list(final Long projectId) throws IOException {
        return list(projectId, GitLabCodeReviewAnalyticsListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /analytics/code_review}).
     *
     * @param projectId the project id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code projectId} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAnalyticsCodeReviewMergeRequest> list(final Long projectId, final GitLabPageRequest request)
            throws IOException {
        return list(projectId, GitLabCodeReviewAnalyticsListFilter.empty(), request);
    }

    /**
     * List ({@code GET /analytics/code_review}).
     *
     * @param projectId the project id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code projectId} or {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAnalyticsCodeReviewMergeRequest> list(
            final Long projectId, final GitLabCodeReviewAnalyticsListFilter filter) throws IOException {
        return list(projectId, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /analytics/code_review}).
     *
     * @param projectId the project id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code projectId}, {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAnalyticsCodeReviewMergeRequest> list(
            final Long projectId, final GitLabCodeReviewAnalyticsListFilter filter, final GitLabPageRequest request)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4AnalyticsCodeReview");
        requireNonNull(projectId, "projectId");
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .all(filter.toQueryParameters())
                .value("project_id", projectId)
                .build();
        return pageList(LIST, queryParameters, request, ANALYTICS_CODE_REVIEW_MERGE_REQUEST_SPEC);
    }
}

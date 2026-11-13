package io.github.piotr_janczukowicz.gitlab.api.analytics;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.RequiresTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.Map;

/** The GitLab operations of analytics. */
public final class GitLabAnalyticsApi extends GitLabResourceApi {
    private static final String PARAM_GROUPPATH = "groupPath";
    private static final String PARAM_GROUP_PATH = "group_path";
    private static final PathTemplate GET_ISSUES_COUNT = PathTemplate.of("/analytics/group_activity/issues_count");
    private static final PathTemplate GET_MERGE_REQUESTS_COUNT =
            PathTemplate.of("/analytics/group_activity/merge_requests_count");
    private static final PathTemplate GET_NEW_MEMBERS_COUNT =
            PathTemplate.of("/analytics/group_activity/new_members_count");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabAnalyticsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get issues count ({@code GET /analytics/group_activity/issues_count}).
     *
     * @param groupPath the group path
     * @return the resource
     * @throws IllegalArgumentException if {@code groupPath} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabAnalyticsGroupActivityIssuesCount getIssuesCount(final String groupPath) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4AnalyticsGroupActivityIssuesCount");
        requireNotBlank(groupPath, PARAM_GROUPPATH);
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .text(PARAM_GROUP_PATH, groupPath)
                .build();
        return caller.fetch(
                get(GET_ISSUES_COUNT).withQuery(queryParameters), GitLabAnalyticsGroupActivityIssuesCount.class);
    }

    /**
     * Get merge requests count ({@code GET /analytics/group_activity/merge_requests_count}).
     *
     * @param groupPath the group path
     * @return the resource
     * @throws IllegalArgumentException if {@code groupPath} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabAnalyticsGroupActivityMergeRequestsCount getMergeRequestsCount(final String groupPath)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4AnalyticsGroupActivityMergeRequestsCount");
        requireNotBlank(groupPath, PARAM_GROUPPATH);
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .text(PARAM_GROUP_PATH, groupPath)
                .build();
        return caller.fetch(
                get(GET_MERGE_REQUESTS_COUNT).withQuery(queryParameters),
                GitLabAnalyticsGroupActivityMergeRequestsCount.class);
    }

    /**
     * Get new members count ({@code GET /analytics/group_activity/new_members_count}).
     *
     * @param groupPath the group path
     * @return the resource
     * @throws IllegalArgumentException if {@code groupPath} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabAnalyticsGroupActivityNewMembersCount getNewMembersCount(final String groupPath) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4AnalyticsGroupActivityNewMembersCount");
        requireNotBlank(groupPath, PARAM_GROUPPATH);
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .text(PARAM_GROUP_PATH, groupPath)
                .build();
        return caller.fetch(
                get(GET_NEW_MEMBERS_COUNT).withQuery(queryParameters),
                GitLabAnalyticsGroupActivityNewMembersCount.class);
    }
}

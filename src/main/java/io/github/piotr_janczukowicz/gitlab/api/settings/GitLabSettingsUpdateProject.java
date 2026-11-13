package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabSettingsUpdatePayload}, flattened into it in JSON.
 *
 * @param projectExportEnabled the project export enabled
 * @param projectRunnerTokenExpirationInterval the project runner token expiration interval
 * @param projectRelationsExportLimit the project relations export limit
 * @param projectRelationsExportDownloadLimit the project relations export download limit
 * @param projectJobsApiRateLimit the project jobs api rate limit
 * @param projectHooksCreateLimit the project hooks create limit
 * @param projectAuditEventsApiLimit the project audit events api limit
 * @param projectSecretsLimit the project secrets limit
 * @param projectCreateLimit the project create limit
 * @param projectImportLimit the project import limit
 * @param projectExportLimit the project export limit
 * @param projectDownloadExportLimit the project download export limit
 * @param projectApiLimit the project api limit
 * @param projectInvitedGroupsApiLimit the project invited groups api limit
 * @param projectRepositoriesBlameLimit the project repositories blame limit
 * @param projectRepositoriesBlameUnauthenticatedLimit the project repositories blame unauthenticated limit
 * @param projectRepositoriesBlobsBatchLimit the project repositories blobs batch limit
 * @param projectRepositoryCommitsApiLimit the project repository commits api limit
 * @param projectMembersApiLimit the project members api limit
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabSettingsUpdateProject(
        @Nullable Boolean projectExportEnabled,
        @Nullable Integer projectRunnerTokenExpirationInterval,
        @Nullable Integer projectRelationsExportLimit,
        @Nullable Integer projectRelationsExportDownloadLimit,
        @Nullable Integer projectJobsApiRateLimit,
        @Nullable String projectHooksCreateLimit,
        @Nullable Integer projectAuditEventsApiLimit,
        @Nullable String projectSecretsLimit,
        @Nullable String projectCreateLimit,
        @Nullable String projectImportLimit,
        @Nullable String projectExportLimit,
        @Nullable String projectDownloadExportLimit,
        @Nullable String projectApiLimit,
        @Nullable String projectInvitedGroupsApiLimit,
        @Nullable String projectRepositoriesBlameLimit,
        @Nullable String projectRepositoriesBlameUnauthenticatedLimit,
        @Nullable String projectRepositoriesBlobsBatchLimit,
        @Nullable String projectRepositoryCommitsApiLimit,
        @Nullable String projectMembersApiLimit) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code projectSecretsLimit} redacted
     */
    @Override
    public String toString() {
        return "GitLabSettingsUpdateProject[" + "projectExportEnabled=" + projectExportEnabled
                + ", projectRunnerTokenExpirationInterval=" + projectRunnerTokenExpirationInterval
                + ", projectRelationsExportLimit=" + projectRelationsExportLimit
                + ", projectRelationsExportDownloadLimit=" + projectRelationsExportDownloadLimit
                + ", projectJobsApiRateLimit=" + projectJobsApiRateLimit + ", projectHooksCreateLimit="
                + projectHooksCreateLimit + ", projectAuditEventsApiLimit=" + projectAuditEventsApiLimit
                + ", projectSecretsLimit=<redacted>" + ", projectCreateLimit=" + projectCreateLimit
                + ", projectImportLimit=" + projectImportLimit + ", projectExportLimit=" + projectExportLimit
                + ", projectDownloadExportLimit=" + projectDownloadExportLimit + ", projectApiLimit=" + projectApiLimit
                + ", projectInvitedGroupsApiLimit=" + projectInvitedGroupsApiLimit + ", projectRepositoriesBlameLimit="
                + projectRepositoriesBlameLimit + ", projectRepositoriesBlameUnauthenticatedLimit="
                + projectRepositoriesBlameUnauthenticatedLimit + ", projectRepositoriesBlobsBatchLimit="
                + projectRepositoriesBlobsBatchLimit + ", projectRepositoryCommitsApiLimit="
                + projectRepositoryCommitsApiLimit + ", projectMembersApiLimit=" + projectMembersApiLimit + "]";
    }
}

package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabSettingsUpdatePayload}, flattened into it in JSON.
 *
 * @param groupRunnerTokenExpirationInterval the group runner token expiration interval
 * @param groupRelationsExportLimit the group relations export limit
 * @param groupRelationsExportDownloadLimit the group relations export download limit
 * @param groupHooksCreateLimit the group hooks create limit
 * @param groupAuditEventsApiLimit the group audit events api limit
 * @param groupOwnersCanManageDefaultBranchProtection the group owners can manage default branch protection
 * @param groupSecretsLimit the group secrets limit
 * @param groupCreateLimit the group create limit
 * @param groupImportLimit the group import limit
 * @param groupExportLimit the group export limit
 * @param groupDownloadExportLimit the group download export limit
 * @param groupApiLimit the group api limit
 * @param groupArchiveUnarchiveApiLimit the group archive unarchive api limit
 * @param groupInvitedGroupsApiLimit the group invited groups api limit
 * @param groupSharedGroupsApiLimit the group shared groups api limit
 * @param groupProjectsApiLimit the group projects api limit
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabSettingsUpdateGroup(
        @Nullable Integer groupRunnerTokenExpirationInterval,
        @Nullable Integer groupRelationsExportLimit,
        @Nullable Integer groupRelationsExportDownloadLimit,
        @Nullable String groupHooksCreateLimit,
        @Nullable Integer groupAuditEventsApiLimit,
        @Nullable Boolean groupOwnersCanManageDefaultBranchProtection,
        @Nullable String groupSecretsLimit,
        @Nullable String groupCreateLimit,
        @Nullable String groupImportLimit,
        @Nullable String groupExportLimit,
        @Nullable String groupDownloadExportLimit,
        @Nullable String groupApiLimit,
        @Nullable String groupArchiveUnarchiveApiLimit,
        @Nullable String groupInvitedGroupsApiLimit,
        @Nullable String groupSharedGroupsApiLimit,
        @Nullable String groupProjectsApiLimit) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code groupSecretsLimit} redacted
     */
    @Override
    public String toString() {
        return "GitLabSettingsUpdateGroup[" + "groupRunnerTokenExpirationInterval=" + groupRunnerTokenExpirationInterval
                + ", groupRelationsExportLimit=" + groupRelationsExportLimit + ", groupRelationsExportDownloadLimit="
                + groupRelationsExportDownloadLimit + ", groupHooksCreateLimit=" + groupHooksCreateLimit
                + ", groupAuditEventsApiLimit=" + groupAuditEventsApiLimit
                + ", groupOwnersCanManageDefaultBranchProtection=" + groupOwnersCanManageDefaultBranchProtection
                + ", groupSecretsLimit=<redacted>" + ", groupCreateLimit=" + groupCreateLimit + ", groupImportLimit="
                + groupImportLimit + ", groupExportLimit=" + groupExportLimit + ", groupDownloadExportLimit="
                + groupDownloadExportLimit + ", groupApiLimit=" + groupApiLimit + ", groupArchiveUnarchiveApiLimit="
                + groupArchiveUnarchiveApiLimit + ", groupInvitedGroupsApiLimit=" + groupInvitedGroupsApiLimit
                + ", groupSharedGroupsApiLimit=" + groupSharedGroupsApiLimit + ", groupProjectsApiLimit="
                + groupProjectsApiLimit + "]";
    }
}

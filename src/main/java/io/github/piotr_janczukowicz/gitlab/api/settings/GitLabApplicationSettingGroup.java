package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabApplicationSetting}, flattened into it in JSON.
 *
 * @param groupCreateLimit the group create limit
 * @param groupImportLimit the group import limit
 * @param groupExportLimit the group export limit
 * @param groupDownloadExportLimit the group download export limit
 * @param groupRelationsExportLimit the group relations export limit
 * @param groupRelationsExportDownloadLimit the group relations export download limit
 * @param groupRunnerTokenExpirationInterval the group runner token expiration interval
 * @param groupApiLimit the group api limit
 * @param groupArchiveUnarchiveApiLimit the group archive unarchive api limit
 * @param groupInvitedGroupsApiLimit the group invited groups api limit
 * @param groupSharedGroupsApiLimit the group shared groups api limit
 * @param groupProjectsApiLimit the group projects api limit
 * @param groupHooksCreateLimit the group hooks create limit
 * @param groupSecretsLimit the group secrets limit
 * @param groupAuditEventsApiLimit the group audit events api limit
 * @param groupOwnersCanManageDefaultBranchProtection the group owners can manage default branch protection
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabApplicationSettingGroup(
        @Nullable String groupCreateLimit,
        @Nullable String groupImportLimit,
        @Nullable String groupExportLimit,
        @Nullable String groupDownloadExportLimit,
        @Nullable String groupRelationsExportLimit,
        @Nullable String groupRelationsExportDownloadLimit,
        @Nullable String groupRunnerTokenExpirationInterval,
        @Nullable String groupApiLimit,
        @Nullable String groupArchiveUnarchiveApiLimit,
        @Nullable String groupInvitedGroupsApiLimit,
        @Nullable String groupSharedGroupsApiLimit,
        @Nullable String groupProjectsApiLimit,
        @Nullable String groupHooksCreateLimit,
        @Nullable String groupSecretsLimit,
        @Nullable String groupAuditEventsApiLimit,
        @Nullable String groupOwnersCanManageDefaultBranchProtection) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code groupRunnerTokenExpirationInterval}, {@code groupSecretsLimit} redacted
     */
    @Override
    public String toString() {
        return "GitLabApplicationSettingGroup[" + "groupCreateLimit=" + groupCreateLimit + ", groupImportLimit="
                + groupImportLimit + ", groupExportLimit=" + groupExportLimit + ", groupDownloadExportLimit="
                + groupDownloadExportLimit + ", groupRelationsExportLimit=" + groupRelationsExportLimit
                + ", groupRelationsExportDownloadLimit=" + groupRelationsExportDownloadLimit
                + ", groupRunnerTokenExpirationInterval=<redacted>" + ", groupApiLimit=" + groupApiLimit
                + ", groupArchiveUnarchiveApiLimit=" + groupArchiveUnarchiveApiLimit + ", groupInvitedGroupsApiLimit="
                + groupInvitedGroupsApiLimit + ", groupSharedGroupsApiLimit=" + groupSharedGroupsApiLimit
                + ", groupProjectsApiLimit=" + groupProjectsApiLimit + ", groupHooksCreateLimit="
                + groupHooksCreateLimit + ", groupSecretsLimit=<redacted>" + ", groupAuditEventsApiLimit="
                + groupAuditEventsApiLimit + ", groupOwnersCanManageDefaultBranchProtection="
                + groupOwnersCanManageDefaultBranchProtection + "]";
    }
}

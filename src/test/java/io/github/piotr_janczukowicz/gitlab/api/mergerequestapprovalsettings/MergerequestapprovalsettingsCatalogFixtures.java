package io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovalsettings;

public final class MergerequestapprovalsettingsCatalogFixtures {

    private MergerequestapprovalsettingsCatalogFixtures() {}

    public static GitLabGroupMergeRequestApprovalSettingsUpdatePayload
            groupMergeRequestApprovalSettingsUpdatePayload() {
        return GitLabGroupMergeRequestApprovalSettingsUpdatePayloadBuilder.builder()
                .allowAuthorApproval(true)
                .allowCommitterApproval(true)
                .allowOverridesToApproverListPerMergeRequest(true)
                .retainApprovalsOnPush(true)
                .selectiveCodeOwnerRemovals(true)
                .requirePasswordToApprove(true)
                .requireReauthenticationToApprove(true)
                .build();
    }

    public static GitLabMergeRequestApprovalSetting mergeRequestApprovalSetting() {
        return GitLabMergeRequestApprovalSettingBuilder.builder()
                .allowAuthorApproval(true)
                .allowCommitterApproval(true)
                .allowOverridesToApproverListPerMergeRequest(true)
                .retainApprovalsOnPush(true)
                .selectiveCodeOwnerRemovals(true)
                .requirePasswordToApprove(true)
                .requireReauthenticationToApprove(true)
                .build();
    }

    public static GitLabProjectMergeRequestApprovalSettingsUpdatePayload
            projectMergeRequestApprovalSettingsUpdatePayload() {
        return GitLabProjectMergeRequestApprovalSettingsUpdatePayloadBuilder.builder()
                .allowAuthorApproval(true)
                .allowCommitterApproval(true)
                .allowOverridesToApproverListPerMergeRequest(true)
                .retainApprovalsOnPush(true)
                .selectiveCodeOwnerRemovals(true)
                .requirePasswordToApprove(true)
                .requireReauthenticationToApprove(true)
                .build();
    }
}

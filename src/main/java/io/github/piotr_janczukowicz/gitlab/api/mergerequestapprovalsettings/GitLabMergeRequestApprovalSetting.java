package io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovalsettings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab merge request approval setting.
 *
 * @param allowAuthorApproval the allow author approval
 * @param allowCommitterApproval the allow committer approval
 * @param allowOverridesToApproverListPerMergeRequest the allow overrides to approver list per merge request
 * @param retainApprovalsOnPush the retain approvals on push
 * @param selectiveCodeOwnerRemovals the selective code owner removals
 * @param requirePasswordToApprove the require password to approve
 * @param requireReauthenticationToApprove the require reauthentication to approve
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMergeRequestApprovalSetting")
public record GitLabMergeRequestApprovalSetting(
        @Nullable Boolean allowAuthorApproval,
        @Nullable Boolean allowCommitterApproval,
        @Nullable Boolean allowOverridesToApproverListPerMergeRequest,
        @Nullable Boolean retainApprovalsOnPush,
        @Nullable Boolean selectiveCodeOwnerRemovals,
        @Nullable Boolean requirePasswordToApprove,
        @Nullable Boolean requireReauthenticationToApprove) {}

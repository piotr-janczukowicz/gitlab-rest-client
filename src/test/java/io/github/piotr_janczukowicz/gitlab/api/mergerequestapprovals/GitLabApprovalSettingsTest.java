package io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovals;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApprovalSettingsTest {

    @Test
    void constructor_shouldAcceptNull_whenApproversIsNullable() {
        final GitLabApprovalSettingsBuilder builder = GitLabApprovalSettingsBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalSettings())
                .approvers(null);

        final GitLabApprovalSettings built = builder.build();

        assertThat(built.approvers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApproverGroupsIsNullable() {
        final GitLabApprovalSettingsBuilder builder = GitLabApprovalSettingsBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalSettings())
                .approverGroups(null);

        final GitLabApprovalSettings built = builder.build();

        assertThat(built.approverGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsBeforeMergeIsNullable() {
        final GitLabApprovalSettingsBuilder builder = GitLabApprovalSettingsBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalSettings())
                .approvalsBeforeMerge(null);

        final GitLabApprovalSettings built = builder.build();

        assertThat(built.approvalsBeforeMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResetApprovalsOnPushIsNullable() {
        final GitLabApprovalSettingsBuilder builder = GitLabApprovalSettingsBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalSettings())
                .resetApprovalsOnPush(null);

        final GitLabApprovalSettings built = builder.build();

        assertThat(built.resetApprovalsOnPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveCodeOwnerRemovalsIsNullable() {
        final GitLabApprovalSettingsBuilder builder = GitLabApprovalSettingsBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalSettings())
                .selectiveCodeOwnerRemovals(null);

        final GitLabApprovalSettings built = builder.build();

        assertThat(built.selectiveCodeOwnerRemovals()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDisableOverridingApproversPerMergeRequestIsNullable() {
        final GitLabApprovalSettingsBuilder builder = GitLabApprovalSettingsBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalSettings())
                .disableOverridingApproversPerMergeRequest(null);

        final GitLabApprovalSettings built = builder.build();

        assertThat(built.disableOverridingApproversPerMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsAuthorApprovalIsNullable() {
        final GitLabApprovalSettingsBuilder builder = GitLabApprovalSettingsBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalSettings())
                .mergeRequestsAuthorApproval(null);

        final GitLabApprovalSettings built = builder.build();

        assertThat(built.mergeRequestsAuthorApproval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsDisableCommittersApprovalIsNullable() {
        final GitLabApprovalSettingsBuilder builder = GitLabApprovalSettingsBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalSettings())
                .mergeRequestsDisableCommittersApproval(null);

        final GitLabApprovalSettings built = builder.build();

        assertThat(built.mergeRequestsDisableCommittersApproval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequirePasswordToApproveIsNullable() {
        final GitLabApprovalSettingsBuilder builder = GitLabApprovalSettingsBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalSettings())
                .requirePasswordToApprove(null);

        final GitLabApprovalSettings built = builder.build();

        assertThat(built.requirePasswordToApprove()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequireReauthenticationToApproveIsNullable() {
        final GitLabApprovalSettingsBuilder builder = GitLabApprovalSettingsBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalSettings())
                .requireReauthenticationToApprove(null);

        final GitLabApprovalSettings built = builder.build();

        assertThat(built.requireReauthenticationToApprove()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApprovalSettings value = MergerequestapprovalsCatalogFixtures.approvalSettings();

        assertSoftly(softly -> {
            softly.assertThat(value.approvers()).isEqualTo(MergerequestapprovalsCatalogFixtures.approver());
            softly.assertThat(value.approverGroups()).isEqualTo(MergerequestapprovalsCatalogFixtures.approverGroup());
            softly.assertThat(value.approvalsBeforeMerge()).isEqualTo(1);
            softly.assertThat(value.resetApprovalsOnPush()).isEqualTo(true);
            softly.assertThat(value.selectiveCodeOwnerRemovals()).isEqualTo(true);
            softly.assertThat(value.disableOverridingApproversPerMergeRequest()).isEqualTo(true);
            softly.assertThat(value.mergeRequestsAuthorApproval()).isEqualTo(true);
            softly.assertThat(value.mergeRequestsDisableCommittersApproval()).isEqualTo(true);
            softly.assertThat(value.requirePasswordToApprove()).isEqualTo(true);
            softly.assertThat(value.requireReauthenticationToApprove()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApprovalSettings original = MergerequestapprovalsCatalogFixtures.approvalSettings();

        final GitLabApprovalSettings rebuilt =
                GitLabApprovalSettingsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApprovalSettings.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "approvers",
                        "approverGroups",
                        "approvalsBeforeMerge",
                        "resetApprovalsOnPush",
                        "selectiveCodeOwnerRemovals",
                        "disableOverridingApproversPerMergeRequest",
                        "mergeRequestsAuthorApproval",
                        "mergeRequestsDisableCommittersApproval",
                        "requirePasswordToApprove",
                        "requireReauthenticationToApprove");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovals;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMergeRequestApprovalsCreateApprovalsPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenApprovalsBeforeMergeIsNullable() {
        final GitLabProjectMergeRequestApprovalsCreateApprovalsPayloadBuilder builder =
                GitLabProjectMergeRequestApprovalsCreateApprovalsPayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsCreateApprovalsPayload())
                        .approvalsBeforeMerge(null);

        final GitLabProjectMergeRequestApprovalsCreateApprovalsPayload built = builder.build();

        assertThat(built.approvalsBeforeMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResetApprovalsOnPushIsNullable() {
        final GitLabProjectMergeRequestApprovalsCreateApprovalsPayloadBuilder builder =
                GitLabProjectMergeRequestApprovalsCreateApprovalsPayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsCreateApprovalsPayload())
                        .resetApprovalsOnPush(null);

        final GitLabProjectMergeRequestApprovalsCreateApprovalsPayload built = builder.build();

        assertThat(built.resetApprovalsOnPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveCodeOwnerRemovalsIsNullable() {
        final GitLabProjectMergeRequestApprovalsCreateApprovalsPayloadBuilder builder =
                GitLabProjectMergeRequestApprovalsCreateApprovalsPayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsCreateApprovalsPayload())
                        .selectiveCodeOwnerRemovals(null);

        final GitLabProjectMergeRequestApprovalsCreateApprovalsPayload built = builder.build();

        assertThat(built.selectiveCodeOwnerRemovals()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDisableOverridingApproversPerMergeRequestIsNullable() {
        final GitLabProjectMergeRequestApprovalsCreateApprovalsPayloadBuilder builder =
                GitLabProjectMergeRequestApprovalsCreateApprovalsPayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsCreateApprovalsPayload())
                        .disableOverridingApproversPerMergeRequest(null);

        final GitLabProjectMergeRequestApprovalsCreateApprovalsPayload built = builder.build();

        assertThat(built.disableOverridingApproversPerMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsAuthorApprovalIsNullable() {
        final GitLabProjectMergeRequestApprovalsCreateApprovalsPayloadBuilder builder =
                GitLabProjectMergeRequestApprovalsCreateApprovalsPayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsCreateApprovalsPayload())
                        .mergeRequestsAuthorApproval(null);

        final GitLabProjectMergeRequestApprovalsCreateApprovalsPayload built = builder.build();

        assertThat(built.mergeRequestsAuthorApproval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsDisableCommittersApprovalIsNullable() {
        final GitLabProjectMergeRequestApprovalsCreateApprovalsPayloadBuilder builder =
                GitLabProjectMergeRequestApprovalsCreateApprovalsPayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsCreateApprovalsPayload())
                        .mergeRequestsDisableCommittersApproval(null);

        final GitLabProjectMergeRequestApprovalsCreateApprovalsPayload built = builder.build();

        assertThat(built.mergeRequestsDisableCommittersApproval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequirePasswordToApproveIsNullable() {
        final GitLabProjectMergeRequestApprovalsCreateApprovalsPayloadBuilder builder =
                GitLabProjectMergeRequestApprovalsCreateApprovalsPayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsCreateApprovalsPayload())
                        .requirePasswordToApprove(null);

        final GitLabProjectMergeRequestApprovalsCreateApprovalsPayload built = builder.build();

        assertThat(built.requirePasswordToApprove()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequireReauthenticationToApproveIsNullable() {
        final GitLabProjectMergeRequestApprovalsCreateApprovalsPayloadBuilder builder =
                GitLabProjectMergeRequestApprovalsCreateApprovalsPayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsCreateApprovalsPayload())
                        .requireReauthenticationToApprove(null);

        final GitLabProjectMergeRequestApprovalsCreateApprovalsPayload built = builder.build();

        assertThat(built.requireReauthenticationToApprove()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMergeRequestApprovalsCreateApprovalsPayload value =
                MergerequestapprovalsCatalogFixtures.projectMergeRequestApprovalsCreateApprovalsPayload();

        assertSoftly(softly -> {
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
        final GitLabProjectMergeRequestApprovalsCreateApprovalsPayload original =
                MergerequestapprovalsCatalogFixtures.projectMergeRequestApprovalsCreateApprovalsPayload();

        final GitLabProjectMergeRequestApprovalsCreateApprovalsPayload rebuilt =
                GitLabProjectMergeRequestApprovalsCreateApprovalsPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectMergeRequestApprovalsCreateApprovalsPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
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

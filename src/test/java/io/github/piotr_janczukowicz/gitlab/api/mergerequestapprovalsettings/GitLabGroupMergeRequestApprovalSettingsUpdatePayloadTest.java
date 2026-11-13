package io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovalsettings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupMergeRequestApprovalSettingsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenAllowAuthorApprovalIsNullable() {
        final GitLabGroupMergeRequestApprovalSettingsUpdatePayloadBuilder builder =
                GitLabGroupMergeRequestApprovalSettingsUpdatePayloadBuilder.builder(
                                MergerequestapprovalsettingsCatalogFixtures
                                        .groupMergeRequestApprovalSettingsUpdatePayload())
                        .allowAuthorApproval(null);

        final GitLabGroupMergeRequestApprovalSettingsUpdatePayload built = builder.build();

        assertThat(built.allowAuthorApproval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowCommitterApprovalIsNullable() {
        final GitLabGroupMergeRequestApprovalSettingsUpdatePayloadBuilder builder =
                GitLabGroupMergeRequestApprovalSettingsUpdatePayloadBuilder.builder(
                                MergerequestapprovalsettingsCatalogFixtures
                                        .groupMergeRequestApprovalSettingsUpdatePayload())
                        .allowCommitterApproval(null);

        final GitLabGroupMergeRequestApprovalSettingsUpdatePayload built = builder.build();

        assertThat(built.allowCommitterApproval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowOverridesToApproverListPerMergeRequestIsNullable() {
        final GitLabGroupMergeRequestApprovalSettingsUpdatePayloadBuilder builder =
                GitLabGroupMergeRequestApprovalSettingsUpdatePayloadBuilder.builder(
                                MergerequestapprovalsettingsCatalogFixtures
                                        .groupMergeRequestApprovalSettingsUpdatePayload())
                        .allowOverridesToApproverListPerMergeRequest(null);

        final GitLabGroupMergeRequestApprovalSettingsUpdatePayload built = builder.build();

        assertThat(built.allowOverridesToApproverListPerMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRetainApprovalsOnPushIsNullable() {
        final GitLabGroupMergeRequestApprovalSettingsUpdatePayloadBuilder builder =
                GitLabGroupMergeRequestApprovalSettingsUpdatePayloadBuilder.builder(
                                MergerequestapprovalsettingsCatalogFixtures
                                        .groupMergeRequestApprovalSettingsUpdatePayload())
                        .retainApprovalsOnPush(null);

        final GitLabGroupMergeRequestApprovalSettingsUpdatePayload built = builder.build();

        assertThat(built.retainApprovalsOnPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveCodeOwnerRemovalsIsNullable() {
        final GitLabGroupMergeRequestApprovalSettingsUpdatePayloadBuilder builder =
                GitLabGroupMergeRequestApprovalSettingsUpdatePayloadBuilder.builder(
                                MergerequestapprovalsettingsCatalogFixtures
                                        .groupMergeRequestApprovalSettingsUpdatePayload())
                        .selectiveCodeOwnerRemovals(null);

        final GitLabGroupMergeRequestApprovalSettingsUpdatePayload built = builder.build();

        assertThat(built.selectiveCodeOwnerRemovals()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequirePasswordToApproveIsNullable() {
        final GitLabGroupMergeRequestApprovalSettingsUpdatePayloadBuilder builder =
                GitLabGroupMergeRequestApprovalSettingsUpdatePayloadBuilder.builder(
                                MergerequestapprovalsettingsCatalogFixtures
                                        .groupMergeRequestApprovalSettingsUpdatePayload())
                        .requirePasswordToApprove(null);

        final GitLabGroupMergeRequestApprovalSettingsUpdatePayload built = builder.build();

        assertThat(built.requirePasswordToApprove()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequireReauthenticationToApproveIsNullable() {
        final GitLabGroupMergeRequestApprovalSettingsUpdatePayloadBuilder builder =
                GitLabGroupMergeRequestApprovalSettingsUpdatePayloadBuilder.builder(
                                MergerequestapprovalsettingsCatalogFixtures
                                        .groupMergeRequestApprovalSettingsUpdatePayload())
                        .requireReauthenticationToApprove(null);

        final GitLabGroupMergeRequestApprovalSettingsUpdatePayload built = builder.build();

        assertThat(built.requireReauthenticationToApprove()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupMergeRequestApprovalSettingsUpdatePayload value =
                MergerequestapprovalsettingsCatalogFixtures.groupMergeRequestApprovalSettingsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.allowAuthorApproval()).isEqualTo(true);
            softly.assertThat(value.allowCommitterApproval()).isEqualTo(true);
            softly.assertThat(value.allowOverridesToApproverListPerMergeRequest())
                    .isEqualTo(true);
            softly.assertThat(value.retainApprovalsOnPush()).isEqualTo(true);
            softly.assertThat(value.selectiveCodeOwnerRemovals()).isEqualTo(true);
            softly.assertThat(value.requirePasswordToApprove()).isEqualTo(true);
            softly.assertThat(value.requireReauthenticationToApprove()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupMergeRequestApprovalSettingsUpdatePayload original =
                MergerequestapprovalsettingsCatalogFixtures.groupMergeRequestApprovalSettingsUpdatePayload();

        final GitLabGroupMergeRequestApprovalSettingsUpdatePayload rebuilt =
                GitLabGroupMergeRequestApprovalSettingsUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupMergeRequestApprovalSettingsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "allowAuthorApproval",
                        "allowCommitterApproval",
                        "allowOverridesToApproverListPerMergeRequest",
                        "retainApprovalsOnPush",
                        "selectiveCodeOwnerRemovals",
                        "requirePasswordToApprove",
                        "requireReauthenticationToApprove");
    }
}

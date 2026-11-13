package io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovalsettings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMergeRequestApprovalSettingsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenAllowAuthorApprovalIsNullable() {
        final GitLabProjectMergeRequestApprovalSettingsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestApprovalSettingsUpdatePayloadBuilder.builder(
                                MergerequestapprovalsettingsCatalogFixtures
                                        .projectMergeRequestApprovalSettingsUpdatePayload())
                        .allowAuthorApproval(null);

        final GitLabProjectMergeRequestApprovalSettingsUpdatePayload built = builder.build();

        assertThat(built.allowAuthorApproval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowCommitterApprovalIsNullable() {
        final GitLabProjectMergeRequestApprovalSettingsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestApprovalSettingsUpdatePayloadBuilder.builder(
                                MergerequestapprovalsettingsCatalogFixtures
                                        .projectMergeRequestApprovalSettingsUpdatePayload())
                        .allowCommitterApproval(null);

        final GitLabProjectMergeRequestApprovalSettingsUpdatePayload built = builder.build();

        assertThat(built.allowCommitterApproval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowOverridesToApproverListPerMergeRequestIsNullable() {
        final GitLabProjectMergeRequestApprovalSettingsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestApprovalSettingsUpdatePayloadBuilder.builder(
                                MergerequestapprovalsettingsCatalogFixtures
                                        .projectMergeRequestApprovalSettingsUpdatePayload())
                        .allowOverridesToApproverListPerMergeRequest(null);

        final GitLabProjectMergeRequestApprovalSettingsUpdatePayload built = builder.build();

        assertThat(built.allowOverridesToApproverListPerMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRetainApprovalsOnPushIsNullable() {
        final GitLabProjectMergeRequestApprovalSettingsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestApprovalSettingsUpdatePayloadBuilder.builder(
                                MergerequestapprovalsettingsCatalogFixtures
                                        .projectMergeRequestApprovalSettingsUpdatePayload())
                        .retainApprovalsOnPush(null);

        final GitLabProjectMergeRequestApprovalSettingsUpdatePayload built = builder.build();

        assertThat(built.retainApprovalsOnPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveCodeOwnerRemovalsIsNullable() {
        final GitLabProjectMergeRequestApprovalSettingsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestApprovalSettingsUpdatePayloadBuilder.builder(
                                MergerequestapprovalsettingsCatalogFixtures
                                        .projectMergeRequestApprovalSettingsUpdatePayload())
                        .selectiveCodeOwnerRemovals(null);

        final GitLabProjectMergeRequestApprovalSettingsUpdatePayload built = builder.build();

        assertThat(built.selectiveCodeOwnerRemovals()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequirePasswordToApproveIsNullable() {
        final GitLabProjectMergeRequestApprovalSettingsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestApprovalSettingsUpdatePayloadBuilder.builder(
                                MergerequestapprovalsettingsCatalogFixtures
                                        .projectMergeRequestApprovalSettingsUpdatePayload())
                        .requirePasswordToApprove(null);

        final GitLabProjectMergeRequestApprovalSettingsUpdatePayload built = builder.build();

        assertThat(built.requirePasswordToApprove()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequireReauthenticationToApproveIsNullable() {
        final GitLabProjectMergeRequestApprovalSettingsUpdatePayloadBuilder builder =
                GitLabProjectMergeRequestApprovalSettingsUpdatePayloadBuilder.builder(
                                MergerequestapprovalsettingsCatalogFixtures
                                        .projectMergeRequestApprovalSettingsUpdatePayload())
                        .requireReauthenticationToApprove(null);

        final GitLabProjectMergeRequestApprovalSettingsUpdatePayload built = builder.build();

        assertThat(built.requireReauthenticationToApprove()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMergeRequestApprovalSettingsUpdatePayload value =
                MergerequestapprovalsettingsCatalogFixtures.projectMergeRequestApprovalSettingsUpdatePayload();

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
        final GitLabProjectMergeRequestApprovalSettingsUpdatePayload original =
                MergerequestapprovalsettingsCatalogFixtures.projectMergeRequestApprovalSettingsUpdatePayload();

        final GitLabProjectMergeRequestApprovalSettingsUpdatePayload rebuilt =
                GitLabProjectMergeRequestApprovalSettingsUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectMergeRequestApprovalSettingsUpdatePayload.class.getRecordComponents())
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

package io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovalsettings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMergeRequestApprovalSettingTest {

    @Test
    void constructor_shouldAcceptNull_whenAllowAuthorApprovalIsNullable() {
        final GitLabMergeRequestApprovalSettingBuilder builder = GitLabMergeRequestApprovalSettingBuilder.builder(
                        MergerequestapprovalsettingsCatalogFixtures.mergeRequestApprovalSetting())
                .allowAuthorApproval(null);

        final GitLabMergeRequestApprovalSetting built = builder.build();

        assertThat(built.allowAuthorApproval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowCommitterApprovalIsNullable() {
        final GitLabMergeRequestApprovalSettingBuilder builder = GitLabMergeRequestApprovalSettingBuilder.builder(
                        MergerequestapprovalsettingsCatalogFixtures.mergeRequestApprovalSetting())
                .allowCommitterApproval(null);

        final GitLabMergeRequestApprovalSetting built = builder.build();

        assertThat(built.allowCommitterApproval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowOverridesToApproverListPerMergeRequestIsNullable() {
        final GitLabMergeRequestApprovalSettingBuilder builder = GitLabMergeRequestApprovalSettingBuilder.builder(
                        MergerequestapprovalsettingsCatalogFixtures.mergeRequestApprovalSetting())
                .allowOverridesToApproverListPerMergeRequest(null);

        final GitLabMergeRequestApprovalSetting built = builder.build();

        assertThat(built.allowOverridesToApproverListPerMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRetainApprovalsOnPushIsNullable() {
        final GitLabMergeRequestApprovalSettingBuilder builder = GitLabMergeRequestApprovalSettingBuilder.builder(
                        MergerequestapprovalsettingsCatalogFixtures.mergeRequestApprovalSetting())
                .retainApprovalsOnPush(null);

        final GitLabMergeRequestApprovalSetting built = builder.build();

        assertThat(built.retainApprovalsOnPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelectiveCodeOwnerRemovalsIsNullable() {
        final GitLabMergeRequestApprovalSettingBuilder builder = GitLabMergeRequestApprovalSettingBuilder.builder(
                        MergerequestapprovalsettingsCatalogFixtures.mergeRequestApprovalSetting())
                .selectiveCodeOwnerRemovals(null);

        final GitLabMergeRequestApprovalSetting built = builder.build();

        assertThat(built.selectiveCodeOwnerRemovals()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequirePasswordToApproveIsNullable() {
        final GitLabMergeRequestApprovalSettingBuilder builder = GitLabMergeRequestApprovalSettingBuilder.builder(
                        MergerequestapprovalsettingsCatalogFixtures.mergeRequestApprovalSetting())
                .requirePasswordToApprove(null);

        final GitLabMergeRequestApprovalSetting built = builder.build();

        assertThat(built.requirePasswordToApprove()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequireReauthenticationToApproveIsNullable() {
        final GitLabMergeRequestApprovalSettingBuilder builder = GitLabMergeRequestApprovalSettingBuilder.builder(
                        MergerequestapprovalsettingsCatalogFixtures.mergeRequestApprovalSetting())
                .requireReauthenticationToApprove(null);

        final GitLabMergeRequestApprovalSetting built = builder.build();

        assertThat(built.requireReauthenticationToApprove()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMergeRequestApprovalSetting value =
                MergerequestapprovalsettingsCatalogFixtures.mergeRequestApprovalSetting();

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
        final GitLabMergeRequestApprovalSetting original =
                MergerequestapprovalsettingsCatalogFixtures.mergeRequestApprovalSetting();

        final GitLabMergeRequestApprovalSetting rebuilt =
                GitLabMergeRequestApprovalSettingBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMergeRequestApprovalSetting.class.getRecordComponents())
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

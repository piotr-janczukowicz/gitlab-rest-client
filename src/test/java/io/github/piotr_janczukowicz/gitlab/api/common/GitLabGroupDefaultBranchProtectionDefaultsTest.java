package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupDefaultBranchProtectionDefaultsTest {

    @Test
    void constructor_shouldAcceptNull_whenAllowedToPushIsNullable() {
        final GitLabGroupDefaultBranchProtectionDefaultsBuilder builder =
                GitLabGroupDefaultBranchProtectionDefaultsBuilder.builder(
                                CommonCatalogFixtures.groupDefaultBranchProtectionDefaults())
                        .allowedToPush(null);

        final GitLabGroupDefaultBranchProtectionDefaults built = builder.build();

        assertThat(built.allowedToPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowForcePushIsNullable() {
        final GitLabGroupDefaultBranchProtectionDefaultsBuilder builder =
                GitLabGroupDefaultBranchProtectionDefaultsBuilder.builder(
                                CommonCatalogFixtures.groupDefaultBranchProtectionDefaults())
                        .allowForcePush(null);

        final GitLabGroupDefaultBranchProtectionDefaults built = builder.build();

        assertThat(built.allowForcePush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowedToMergeIsNullable() {
        final GitLabGroupDefaultBranchProtectionDefaultsBuilder builder =
                GitLabGroupDefaultBranchProtectionDefaultsBuilder.builder(
                                CommonCatalogFixtures.groupDefaultBranchProtectionDefaults())
                        .allowedToMerge(null);

        final GitLabGroupDefaultBranchProtectionDefaults built = builder.build();

        assertThat(built.allowedToMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCodeOwnerApprovalRequiredIsNullable() {
        final GitLabGroupDefaultBranchProtectionDefaultsBuilder builder =
                GitLabGroupDefaultBranchProtectionDefaultsBuilder.builder(
                                CommonCatalogFixtures.groupDefaultBranchProtectionDefaults())
                        .codeOwnerApprovalRequired(null);

        final GitLabGroupDefaultBranchProtectionDefaults built = builder.build();

        assertThat(built.codeOwnerApprovalRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeveloperCanInitialPushIsNullable() {
        final GitLabGroupDefaultBranchProtectionDefaultsBuilder builder =
                GitLabGroupDefaultBranchProtectionDefaultsBuilder.builder(
                                CommonCatalogFixtures.groupDefaultBranchProtectionDefaults())
                        .developerCanInitialPush(null);

        final GitLabGroupDefaultBranchProtectionDefaults built = builder.build();

        assertThat(built.developerCanInitialPush()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupDefaultBranchProtectionDefaults value =
                CommonCatalogFixtures.groupDefaultBranchProtectionDefaults();

        assertSoftly(softly -> {
            softly.assertThat(value.allowedToPush())
                    .isEqualTo(List.of(CommonCatalogFixtures.groupDefaultBranchProtectionDefaultsAllowedToPush()));
            softly.assertThat(value.allowForcePush()).isEqualTo(true);
            softly.assertThat(value.allowedToMerge())
                    .isEqualTo(List.of(CommonCatalogFixtures.groupDefaultBranchProtectionDefaultsAllowedToMerge()));
            softly.assertThat(value.codeOwnerApprovalRequired()).isEqualTo(true);
            softly.assertThat(value.developerCanInitialPush()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupDefaultBranchProtectionDefaults original =
                CommonCatalogFixtures.groupDefaultBranchProtectionDefaults();

        final GitLabGroupDefaultBranchProtectionDefaults rebuilt =
                GitLabGroupDefaultBranchProtectionDefaultsBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupDefaultBranchProtectionDefaults.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "allowedToPush",
                        "allowForcePush",
                        "allowedToMerge",
                        "codeOwnerApprovalRequired",
                        "developerCanInitialPush");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApplicationSettingDefaultBranchProtectionDefaultsTest {

    @Test
    void constructor_shouldAcceptNull_whenAllowedToPushIsNullable() {
        final GitLabApplicationSettingDefaultBranchProtectionDefaultsBuilder builder =
                GitLabApplicationSettingDefaultBranchProtectionDefaultsBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingDefaultBranchProtectionDefaults())
                        .allowedToPush(null);

        final GitLabApplicationSettingDefaultBranchProtectionDefaults built = builder.build();

        assertThat(built.allowedToPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowForcePushIsNullable() {
        final GitLabApplicationSettingDefaultBranchProtectionDefaultsBuilder builder =
                GitLabApplicationSettingDefaultBranchProtectionDefaultsBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingDefaultBranchProtectionDefaults())
                        .allowForcePush(null);

        final GitLabApplicationSettingDefaultBranchProtectionDefaults built = builder.build();

        assertThat(built.allowForcePush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowedToMergeIsNullable() {
        final GitLabApplicationSettingDefaultBranchProtectionDefaultsBuilder builder =
                GitLabApplicationSettingDefaultBranchProtectionDefaultsBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingDefaultBranchProtectionDefaults())
                        .allowedToMerge(null);

        final GitLabApplicationSettingDefaultBranchProtectionDefaults built = builder.build();

        assertThat(built.allowedToMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCodeOwnerApprovalRequiredIsNullable() {
        final GitLabApplicationSettingDefaultBranchProtectionDefaultsBuilder builder =
                GitLabApplicationSettingDefaultBranchProtectionDefaultsBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingDefaultBranchProtectionDefaults())
                        .codeOwnerApprovalRequired(null);

        final GitLabApplicationSettingDefaultBranchProtectionDefaults built = builder.build();

        assertThat(built.codeOwnerApprovalRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeveloperCanInitialPushIsNullable() {
        final GitLabApplicationSettingDefaultBranchProtectionDefaultsBuilder builder =
                GitLabApplicationSettingDefaultBranchProtectionDefaultsBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingDefaultBranchProtectionDefaults())
                        .developerCanInitialPush(null);

        final GitLabApplicationSettingDefaultBranchProtectionDefaults built = builder.build();

        assertThat(built.developerCanInitialPush()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplicationSettingDefaultBranchProtectionDefaults value =
                SettingsCatalogFixtures.applicationSettingDefaultBranchProtectionDefaults();

        assertSoftly(softly -> {
            softly.assertThat(value.allowedToPush())
                    .isEqualTo(List.of(
                            SettingsCatalogFixtures.applicationSettingDefaultBranchProtectionDefaultsAllowedToPush()));
            softly.assertThat(value.allowForcePush()).isEqualTo(true);
            softly.assertThat(value.allowedToMerge())
                    .isEqualTo(List.of(
                            SettingsCatalogFixtures.applicationSettingDefaultBranchProtectionDefaultsAllowedToMerge()));
            softly.assertThat(value.codeOwnerApprovalRequired()).isEqualTo(true);
            softly.assertThat(value.developerCanInitialPush()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApplicationSettingDefaultBranchProtectionDefaults original =
                SettingsCatalogFixtures.applicationSettingDefaultBranchProtectionDefaults();

        final GitLabApplicationSettingDefaultBranchProtectionDefaults rebuilt =
                GitLabApplicationSettingDefaultBranchProtectionDefaultsBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabApplicationSettingDefaultBranchProtectionDefaults.class.getRecordComponents())
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

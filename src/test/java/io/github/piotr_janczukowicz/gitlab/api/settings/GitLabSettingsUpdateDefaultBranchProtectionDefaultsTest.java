package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdateDefaultBranchProtectionDefaultsTest {

    @Test
    void constructor_shouldAcceptNull_whenAllowedToPushIsNullable() {
        final GitLabSettingsUpdateDefaultBranchProtectionDefaultsBuilder builder =
                GitLabSettingsUpdateDefaultBranchProtectionDefaultsBuilder.builder(
                                SettingsCatalogFixtures.settingsUpdateDefaultBranchProtectionDefaults())
                        .allowedToPush(null);

        final GitLabSettingsUpdateDefaultBranchProtectionDefaults built = builder.build();

        assertThat(built.allowedToPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowForcePushIsNullable() {
        final GitLabSettingsUpdateDefaultBranchProtectionDefaultsBuilder builder =
                GitLabSettingsUpdateDefaultBranchProtectionDefaultsBuilder.builder(
                                SettingsCatalogFixtures.settingsUpdateDefaultBranchProtectionDefaults())
                        .allowForcePush(null);

        final GitLabSettingsUpdateDefaultBranchProtectionDefaults built = builder.build();

        assertThat(built.allowForcePush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowedToMergeIsNullable() {
        final GitLabSettingsUpdateDefaultBranchProtectionDefaultsBuilder builder =
                GitLabSettingsUpdateDefaultBranchProtectionDefaultsBuilder.builder(
                                SettingsCatalogFixtures.settingsUpdateDefaultBranchProtectionDefaults())
                        .allowedToMerge(null);

        final GitLabSettingsUpdateDefaultBranchProtectionDefaults built = builder.build();

        assertThat(built.allowedToMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCodeOwnerApprovalRequiredIsNullable() {
        final GitLabSettingsUpdateDefaultBranchProtectionDefaultsBuilder builder =
                GitLabSettingsUpdateDefaultBranchProtectionDefaultsBuilder.builder(
                                SettingsCatalogFixtures.settingsUpdateDefaultBranchProtectionDefaults())
                        .codeOwnerApprovalRequired(null);

        final GitLabSettingsUpdateDefaultBranchProtectionDefaults built = builder.build();

        assertThat(built.codeOwnerApprovalRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeveloperCanInitialPushIsNullable() {
        final GitLabSettingsUpdateDefaultBranchProtectionDefaultsBuilder builder =
                GitLabSettingsUpdateDefaultBranchProtectionDefaultsBuilder.builder(
                                SettingsCatalogFixtures.settingsUpdateDefaultBranchProtectionDefaults())
                        .developerCanInitialPush(null);

        final GitLabSettingsUpdateDefaultBranchProtectionDefaults built = builder.build();

        assertThat(built.developerCanInitialPush()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdateDefaultBranchProtectionDefaults value =
                SettingsCatalogFixtures.settingsUpdateDefaultBranchProtectionDefaults();

        assertSoftly(softly -> {
            softly.assertThat(value.allowedToPush())
                    .isEqualTo(List.of(
                            SettingsCatalogFixtures.settingsUpdateDefaultBranchProtectionDefaultsAllowedToPush()));
            softly.assertThat(value.allowForcePush()).isEqualTo(true);
            softly.assertThat(value.allowedToMerge())
                    .isEqualTo(List.of(
                            SettingsCatalogFixtures.settingsUpdateDefaultBranchProtectionDefaultsAllowedToMerge()));
            softly.assertThat(value.codeOwnerApprovalRequired()).isEqualTo(true);
            softly.assertThat(value.developerCanInitialPush()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSettingsUpdateDefaultBranchProtectionDefaults original =
                SettingsCatalogFixtures.settingsUpdateDefaultBranchProtectionDefaults();

        final GitLabSettingsUpdateDefaultBranchProtectionDefaults rebuilt =
                GitLabSettingsUpdateDefaultBranchProtectionDefaultsBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenAllowedToPushSourceChangesLater() {
        final List<GitLabSettingsUpdateDefaultBranchProtectionDefaultsAllowedToPush> source = new ArrayList<>(
                List.of(SettingsCatalogFixtures.settingsUpdateDefaultBranchProtectionDefaultsAllowedToPush()));
        final GitLabSettingsUpdateDefaultBranchProtectionDefaults built =
                GitLabSettingsUpdateDefaultBranchProtectionDefaultsBuilder.builder(
                                SettingsCatalogFixtures.settingsUpdateDefaultBranchProtectionDefaults())
                        .allowedToPush(source)
                        .build();
        source.clear();

        assertThat(built.allowedToPush()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAllowedToPushIsRead() {
        final GitLabSettingsUpdateDefaultBranchProtectionDefaults built =
                SettingsCatalogFixtures.settingsUpdateDefaultBranchProtectionDefaults();
        final List<GitLabSettingsUpdateDefaultBranchProtectionDefaultsAllowedToPush> values = built.allowedToPush();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenAllowedToMergeSourceChangesLater() {
        final List<GitLabSettingsUpdateDefaultBranchProtectionDefaultsAllowedToMerge> source = new ArrayList<>(
                List.of(SettingsCatalogFixtures.settingsUpdateDefaultBranchProtectionDefaultsAllowedToMerge()));
        final GitLabSettingsUpdateDefaultBranchProtectionDefaults built =
                GitLabSettingsUpdateDefaultBranchProtectionDefaultsBuilder.builder(
                                SettingsCatalogFixtures.settingsUpdateDefaultBranchProtectionDefaults())
                        .allowedToMerge(source)
                        .build();
        source.clear();

        assertThat(built.allowedToMerge()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAllowedToMergeIsRead() {
        final GitLabSettingsUpdateDefaultBranchProtectionDefaults built =
                SettingsCatalogFixtures.settingsUpdateDefaultBranchProtectionDefaults();
        final List<GitLabSettingsUpdateDefaultBranchProtectionDefaultsAllowedToMerge> values = built.allowedToMerge();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabSettingsUpdateDefaultBranchProtectionDefaults.class.getRecordComponents())
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

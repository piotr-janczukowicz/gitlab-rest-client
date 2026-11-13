package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApplicationSettingDefaultBranchProtectionDefaultsAllowedToMergeTest {

    @Test
    void constructor_shouldRefuseNull_whenAccessLevelIsNull() {
        final GitLabApplicationSettingDefaultBranchProtectionDefaultsAllowedToMergeBuilder builder =
                GitLabApplicationSettingDefaultBranchProtectionDefaultsAllowedToMergeBuilder.builder(
                                SettingsCatalogFixtures
                                        .applicationSettingDefaultBranchProtectionDefaultsAllowedToMerge())
                        .accessLevel(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("accessLevel");
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplicationSettingDefaultBranchProtectionDefaultsAllowedToMerge value =
                SettingsCatalogFixtures.applicationSettingDefaultBranchProtectionDefaultsAllowedToMerge();

        assertThat(value.accessLevel()).isEqualTo(GitLabApplicationSettingBranchProtectionMergeAccessLevel.DEVELOPER);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApplicationSettingDefaultBranchProtectionDefaultsAllowedToMerge original =
                SettingsCatalogFixtures.applicationSettingDefaultBranchProtectionDefaultsAllowedToMerge();

        final GitLabApplicationSettingDefaultBranchProtectionDefaultsAllowedToMerge rebuilt =
                GitLabApplicationSettingDefaultBranchProtectionDefaultsAllowedToMergeBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabApplicationSettingDefaultBranchProtectionDefaultsAllowedToMerge.class
                                .getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("accessLevel");
    }
}

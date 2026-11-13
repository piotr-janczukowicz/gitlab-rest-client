package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdateDefaultBranchProtectionDefaultsAllowedToMergeTest {

    @Test
    void constructor_shouldRefuseNull_whenAccessLevelIsNull() {
        final GitLabSettingsUpdateDefaultBranchProtectionDefaultsAllowedToMergeBuilder builder =
                GitLabSettingsUpdateDefaultBranchProtectionDefaultsAllowedToMergeBuilder.builder(
                                SettingsCatalogFixtures.settingsUpdateDefaultBranchProtectionDefaultsAllowedToMerge())
                        .accessLevel(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("accessLevel");
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdateDefaultBranchProtectionDefaultsAllowedToMerge value =
                SettingsCatalogFixtures.settingsUpdateDefaultBranchProtectionDefaultsAllowedToMerge();

        assertThat(value.accessLevel()).isEqualTo(GitLabSettingsUpdateBranchProtectionMergeAccessLevel.DEVELOPER);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSettingsUpdateDefaultBranchProtectionDefaultsAllowedToMerge original =
                SettingsCatalogFixtures.settingsUpdateDefaultBranchProtectionDefaultsAllowedToMerge();

        final GitLabSettingsUpdateDefaultBranchProtectionDefaultsAllowedToMerge rebuilt =
                GitLabSettingsUpdateDefaultBranchProtectionDefaultsAllowedToMergeBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabSettingsUpdateDefaultBranchProtectionDefaultsAllowedToMerge.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("accessLevel");
    }
}

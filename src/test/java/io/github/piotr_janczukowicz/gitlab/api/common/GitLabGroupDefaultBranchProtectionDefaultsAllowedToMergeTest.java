package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupDefaultBranchProtectionDefaultsAllowedToMergeTest {

    @Test
    void constructor_shouldRefuseNull_whenAccessLevelIsNull() {
        final GitLabGroupDefaultBranchProtectionDefaultsAllowedToMergeBuilder builder =
                GitLabGroupDefaultBranchProtectionDefaultsAllowedToMergeBuilder.builder(
                                CommonCatalogFixtures.groupDefaultBranchProtectionDefaultsAllowedToMerge())
                        .accessLevel(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("accessLevel");
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupDefaultBranchProtectionDefaultsAllowedToMerge value =
                CommonCatalogFixtures.groupDefaultBranchProtectionDefaultsAllowedToMerge();

        assertThat(value.accessLevel())
                .isEqualTo(GitLabGroupDefaultBranchProtectionDefaultsAllowedToMergeAccessLevel.DEVELOPER);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupDefaultBranchProtectionDefaultsAllowedToMerge original =
                CommonCatalogFixtures.groupDefaultBranchProtectionDefaultsAllowedToMerge();

        final GitLabGroupDefaultBranchProtectionDefaultsAllowedToMerge rebuilt =
                GitLabGroupDefaultBranchProtectionDefaultsAllowedToMergeBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupDefaultBranchProtectionDefaultsAllowedToMerge.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("accessLevel");
    }
}

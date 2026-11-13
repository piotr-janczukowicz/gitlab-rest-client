package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupDetailDefaultBranchProtectionDefaultsAllowedToMergeTest {

    @Test
    void constructor_shouldRefuseNull_whenAccessLevelIsNull() {
        final GitLabGroupDetailDefaultBranchProtectionDefaultsAllowedToMergeBuilder builder =
                GitLabGroupDetailDefaultBranchProtectionDefaultsAllowedToMergeBuilder.builder(
                                GroupsCatalogFixtures.groupDetailDefaultBranchProtectionDefaultsAllowedToMerge())
                        .accessLevel(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("accessLevel");
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupDetailDefaultBranchProtectionDefaultsAllowedToMerge value =
                GroupsCatalogFixtures.groupDetailDefaultBranchProtectionDefaultsAllowedToMerge();

        assertThat(value.accessLevel()).isEqualTo(GitLabGroupDetailBranchProtectionMergeAccessLevel.DEVELOPER);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupDetailDefaultBranchProtectionDefaultsAllowedToMerge original =
                GroupsCatalogFixtures.groupDetailDefaultBranchProtectionDefaultsAllowedToMerge();

        final GitLabGroupDetailDefaultBranchProtectionDefaultsAllowedToMerge rebuilt =
                GitLabGroupDetailDefaultBranchProtectionDefaultsAllowedToMergeBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupDetailDefaultBranchProtectionDefaultsAllowedToMerge.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("accessLevel");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupDefaultBranchProtectionDefaultsAllowedToPushTest {

    @Test
    void constructor_shouldRefuseNull_whenAccessLevelIsNull() {
        final GitLabGroupDefaultBranchProtectionDefaultsAllowedToPushBuilder builder =
                GitLabGroupDefaultBranchProtectionDefaultsAllowedToPushBuilder.builder(
                                CommonCatalogFixtures.groupDefaultBranchProtectionDefaultsAllowedToPush())
                        .accessLevel(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("accessLevel");
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupDefaultBranchProtectionDefaultsAllowedToPush value =
                CommonCatalogFixtures.groupDefaultBranchProtectionDefaultsAllowedToPush();

        assertThat(value.accessLevel())
                .isEqualTo(GitLabGroupDefaultBranchProtectionDefaultsAllowedToPushAccessLevel.DEVELOPER);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupDefaultBranchProtectionDefaultsAllowedToPush original =
                CommonCatalogFixtures.groupDefaultBranchProtectionDefaultsAllowedToPush();

        final GitLabGroupDefaultBranchProtectionDefaultsAllowedToPush rebuilt =
                GitLabGroupDefaultBranchProtectionDefaultsAllowedToPushBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupDefaultBranchProtectionDefaultsAllowedToPush.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("accessLevel");
    }
}

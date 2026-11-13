package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupDetailDefaultBranchProtectionDefaultsAllowedToPushTest {

    @Test
    void constructor_shouldRefuseNull_whenAccessLevelIsNull() {
        final GitLabGroupDetailDefaultBranchProtectionDefaultsAllowedToPushBuilder builder =
                GitLabGroupDetailDefaultBranchProtectionDefaultsAllowedToPushBuilder.builder(
                                GroupsCatalogFixtures.groupDetailDefaultBranchProtectionDefaultsAllowedToPush())
                        .accessLevel(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("accessLevel");
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupDetailDefaultBranchProtectionDefaultsAllowedToPush value =
                GroupsCatalogFixtures.groupDetailDefaultBranchProtectionDefaultsAllowedToPush();

        assertThat(value.accessLevel()).isEqualTo(GitLabGroupDetailBranchProtectionPushAccessLevel.DEVELOPER);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupDetailDefaultBranchProtectionDefaultsAllowedToPush original =
                GroupsCatalogFixtures.groupDetailDefaultBranchProtectionDefaultsAllowedToPush();

        final GitLabGroupDetailDefaultBranchProtectionDefaultsAllowedToPush rebuilt =
                GitLabGroupDetailDefaultBranchProtectionDefaultsAllowedToPushBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupDetailDefaultBranchProtectionDefaultsAllowedToPush.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("accessLevel");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupDetailDefaultBranchProtectionDefaultsTest {

    @Test
    void constructor_shouldAcceptNull_whenAllowedToPushIsNullable() {
        final GitLabGroupDetailDefaultBranchProtectionDefaultsBuilder builder =
                GitLabGroupDetailDefaultBranchProtectionDefaultsBuilder.builder(
                                GroupsCatalogFixtures.groupDetailDefaultBranchProtectionDefaults())
                        .allowedToPush(null);

        final GitLabGroupDetailDefaultBranchProtectionDefaults built = builder.build();

        assertThat(built.allowedToPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowForcePushIsNullable() {
        final GitLabGroupDetailDefaultBranchProtectionDefaultsBuilder builder =
                GitLabGroupDetailDefaultBranchProtectionDefaultsBuilder.builder(
                                GroupsCatalogFixtures.groupDetailDefaultBranchProtectionDefaults())
                        .allowForcePush(null);

        final GitLabGroupDetailDefaultBranchProtectionDefaults built = builder.build();

        assertThat(built.allowForcePush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowedToMergeIsNullable() {
        final GitLabGroupDetailDefaultBranchProtectionDefaultsBuilder builder =
                GitLabGroupDetailDefaultBranchProtectionDefaultsBuilder.builder(
                                GroupsCatalogFixtures.groupDetailDefaultBranchProtectionDefaults())
                        .allowedToMerge(null);

        final GitLabGroupDetailDefaultBranchProtectionDefaults built = builder.build();

        assertThat(built.allowedToMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCodeOwnerApprovalRequiredIsNullable() {
        final GitLabGroupDetailDefaultBranchProtectionDefaultsBuilder builder =
                GitLabGroupDetailDefaultBranchProtectionDefaultsBuilder.builder(
                                GroupsCatalogFixtures.groupDetailDefaultBranchProtectionDefaults())
                        .codeOwnerApprovalRequired(null);

        final GitLabGroupDetailDefaultBranchProtectionDefaults built = builder.build();

        assertThat(built.codeOwnerApprovalRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeveloperCanInitialPushIsNullable() {
        final GitLabGroupDetailDefaultBranchProtectionDefaultsBuilder builder =
                GitLabGroupDetailDefaultBranchProtectionDefaultsBuilder.builder(
                                GroupsCatalogFixtures.groupDetailDefaultBranchProtectionDefaults())
                        .developerCanInitialPush(null);

        final GitLabGroupDetailDefaultBranchProtectionDefaults built = builder.build();

        assertThat(built.developerCanInitialPush()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupDetailDefaultBranchProtectionDefaults value =
                GroupsCatalogFixtures.groupDetailDefaultBranchProtectionDefaults();

        assertSoftly(softly -> {
            softly.assertThat(value.allowedToPush())
                    .isEqualTo(
                            List.of(GroupsCatalogFixtures.groupDetailDefaultBranchProtectionDefaultsAllowedToPush()));
            softly.assertThat(value.allowForcePush()).isEqualTo(true);
            softly.assertThat(value.allowedToMerge())
                    .isEqualTo(
                            List.of(GroupsCatalogFixtures.groupDetailDefaultBranchProtectionDefaultsAllowedToMerge()));
            softly.assertThat(value.codeOwnerApprovalRequired()).isEqualTo(true);
            softly.assertThat(value.developerCanInitialPush()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupDetailDefaultBranchProtectionDefaults original =
                GroupsCatalogFixtures.groupDetailDefaultBranchProtectionDefaults();

        final GitLabGroupDetailDefaultBranchProtectionDefaults rebuilt =
                GitLabGroupDetailDefaultBranchProtectionDefaultsBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupDetailDefaultBranchProtectionDefaults.class.getRecordComponents())
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

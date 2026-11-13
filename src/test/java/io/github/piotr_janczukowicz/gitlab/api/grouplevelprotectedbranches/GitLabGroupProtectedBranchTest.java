package io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedbranches;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupProtectedBranchTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabGroupProtectedBranchBuilder builder = GitLabGroupProtectedBranchBuilder.builder(
                        GrouplevelprotectedbranchesCatalogFixtures.groupProtectedBranch())
                .id(null);

        final GitLabGroupProtectedBranch built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupProtectedBranchBuilder builder = GitLabGroupProtectedBranchBuilder.builder(
                        GrouplevelprotectedbranchesCatalogFixtures.groupProtectedBranch())
                .name(null);

        final GitLabGroupProtectedBranch built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushAccessLevelsIsNullable() {
        final GitLabGroupProtectedBranchBuilder builder = GitLabGroupProtectedBranchBuilder.builder(
                        GrouplevelprotectedbranchesCatalogFixtures.groupProtectedBranch())
                .pushAccessLevels(null);

        final GitLabGroupProtectedBranch built = builder.build();

        assertThat(built.pushAccessLevels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeAccessLevelsIsNullable() {
        final GitLabGroupProtectedBranchBuilder builder = GitLabGroupProtectedBranchBuilder.builder(
                        GrouplevelprotectedbranchesCatalogFixtures.groupProtectedBranch())
                .mergeAccessLevels(null);

        final GitLabGroupProtectedBranch built = builder.build();

        assertThat(built.mergeAccessLevels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowForcePushIsNullable() {
        final GitLabGroupProtectedBranchBuilder builder = GitLabGroupProtectedBranchBuilder.builder(
                        GrouplevelprotectedbranchesCatalogFixtures.groupProtectedBranch())
                .allowForcePush(null);

        final GitLabGroupProtectedBranch built = builder.build();

        assertThat(built.allowForcePush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUnprotectAccessLevelsIsNullable() {
        final GitLabGroupProtectedBranchBuilder builder = GitLabGroupProtectedBranchBuilder.builder(
                        GrouplevelprotectedbranchesCatalogFixtures.groupProtectedBranch())
                .unprotectAccessLevels(null);

        final GitLabGroupProtectedBranch built = builder.build();

        assertThat(built.unprotectAccessLevels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCodeOwnerApprovalRequiredIsNullable() {
        final GitLabGroupProtectedBranchBuilder builder = GitLabGroupProtectedBranchBuilder.builder(
                        GrouplevelprotectedbranchesCatalogFixtures.groupProtectedBranch())
                .codeOwnerApprovalRequired(null);

        final GitLabGroupProtectedBranch built = builder.build();

        assertThat(built.codeOwnerApprovalRequired()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupProtectedBranch value = GrouplevelprotectedbranchesCatalogFixtures.groupProtectedBranch();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("main");
            softly.assertThat(value.pushAccessLevels()).isEqualTo(List.of(CommonCatalogFixtures.protectedRefAccess()));
            softly.assertThat(value.mergeAccessLevels()).isEqualTo(List.of(CommonCatalogFixtures.protectedRefAccess()));
            softly.assertThat(value.allowForcePush()).isEqualTo(true);
            softly.assertThat(value.unprotectAccessLevels())
                    .isEqualTo(List.of(CommonCatalogFixtures.protectedRefAccess()));
            softly.assertThat(value.codeOwnerApprovalRequired()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupProtectedBranch original = GrouplevelprotectedbranchesCatalogFixtures.groupProtectedBranch();

        final GitLabGroupProtectedBranch rebuilt =
                GitLabGroupProtectedBranchBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupProtectedBranch.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "name",
                        "pushAccessLevels",
                        "mergeAccessLevels",
                        "allowForcePush",
                        "unprotectAccessLevels",
                        "codeOwnerApprovalRequired");
    }
}

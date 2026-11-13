package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProtectedBranchTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProtectedBranchBuilder builder = GitLabProtectedBranchBuilder.builder(
                        CommonCatalogFixtures.protectedBranch())
                .id(null);

        final GitLabProtectedBranch built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProtectedBranchBuilder builder = GitLabProtectedBranchBuilder.builder(
                        CommonCatalogFixtures.protectedBranch())
                .name(null);

        final GitLabProtectedBranch built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushAccessLevelsIsNullable() {
        final GitLabProtectedBranchBuilder builder = GitLabProtectedBranchBuilder.builder(
                        CommonCatalogFixtures.protectedBranch())
                .pushAccessLevels(null);

        final GitLabProtectedBranch built = builder.build();

        assertThat(built.pushAccessLevels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeAccessLevelsIsNullable() {
        final GitLabProtectedBranchBuilder builder = GitLabProtectedBranchBuilder.builder(
                        CommonCatalogFixtures.protectedBranch())
                .mergeAccessLevels(null);

        final GitLabProtectedBranch built = builder.build();

        assertThat(built.mergeAccessLevels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowForcePushIsNullable() {
        final GitLabProtectedBranchBuilder builder = GitLabProtectedBranchBuilder.builder(
                        CommonCatalogFixtures.protectedBranch())
                .allowForcePush(null);

        final GitLabProtectedBranch built = builder.build();

        assertThat(built.allowForcePush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUnprotectAccessLevelsIsNullable() {
        final GitLabProtectedBranchBuilder builder = GitLabProtectedBranchBuilder.builder(
                        CommonCatalogFixtures.protectedBranch())
                .unprotectAccessLevels(null);

        final GitLabProtectedBranch built = builder.build();

        assertThat(built.unprotectAccessLevels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCodeOwnerApprovalRequiredIsNullable() {
        final GitLabProtectedBranchBuilder builder = GitLabProtectedBranchBuilder.builder(
                        CommonCatalogFixtures.protectedBranch())
                .codeOwnerApprovalRequired(null);

        final GitLabProtectedBranch built = builder.build();

        assertThat(built.codeOwnerApprovalRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInheritedIsNullable() {
        final GitLabProtectedBranchBuilder builder = GitLabProtectedBranchBuilder.builder(
                        CommonCatalogFixtures.protectedBranch())
                .inherited(null);

        final GitLabProtectedBranch built = builder.build();

        assertThat(built.inherited()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProtectedBranch value = CommonCatalogFixtures.protectedBranch();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("main");
            softly.assertThat(value.pushAccessLevels()).isEqualTo(List.of(CommonCatalogFixtures.protectedRefAccess()));
            softly.assertThat(value.mergeAccessLevels()).isEqualTo(List.of(CommonCatalogFixtures.protectedRefAccess()));
            softly.assertThat(value.allowForcePush()).isEqualTo(true);
            softly.assertThat(value.unprotectAccessLevels())
                    .isEqualTo(List.of(CommonCatalogFixtures.protectedRefAccess()));
            softly.assertThat(value.codeOwnerApprovalRequired()).isEqualTo(true);
            softly.assertThat(value.inherited()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProtectedBranch original = CommonCatalogFixtures.protectedBranch();

        final GitLabProtectedBranch rebuilt =
                GitLabProtectedBranchBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProtectedBranch.class.getRecordComponents())
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
                        "codeOwnerApprovalRequired",
                        "inherited");
    }
}

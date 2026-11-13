package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectApprovalRuleTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectApprovalRuleBuilder builder = GitLabProjectApprovalRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalRule())
                .id(null);

        final GitLabProjectApprovalRule built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectApprovalRuleBuilder builder = GitLabProjectApprovalRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalRule())
                .name(null);

        final GitLabProjectApprovalRule built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRuleTypeIsNullable() {
        final GitLabProjectApprovalRuleBuilder builder = GitLabProjectApprovalRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalRule())
                .ruleType(null);

        final GitLabProjectApprovalRule built = builder.build();

        assertThat(built.ruleType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEligibleApproversIsNullable() {
        final GitLabProjectApprovalRuleBuilder builder = GitLabProjectApprovalRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalRule())
                .eligibleApprovers(null);

        final GitLabProjectApprovalRule built = builder.build();

        assertThat(built.eligibleApprovers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsRequiredIsNullable() {
        final GitLabProjectApprovalRuleBuilder builder = GitLabProjectApprovalRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalRule())
                .approvalsRequired(null);

        final GitLabProjectApprovalRule built = builder.build();

        assertThat(built.approvalsRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersIsNullable() {
        final GitLabProjectApprovalRuleBuilder builder = GitLabProjectApprovalRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalRule())
                .users(null);

        final GitLabProjectApprovalRule built = builder.build();

        assertThat(built.users()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupsIsNullable() {
        final GitLabProjectApprovalRuleBuilder builder = GitLabProjectApprovalRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalRule())
                .groups(null);

        final GitLabProjectApprovalRule built = builder.build();

        assertThat(built.groups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainsHiddenGroupsIsNullable() {
        final GitLabProjectApprovalRuleBuilder builder = GitLabProjectApprovalRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalRule())
                .containsHiddenGroups(null);

        final GitLabProjectApprovalRule built = builder.build();

        assertThat(built.containsHiddenGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReportTypeIsNullable() {
        final GitLabProjectApprovalRuleBuilder builder = GitLabProjectApprovalRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalRule())
                .reportType(null);

        final GitLabProjectApprovalRule built = builder.build();

        assertThat(built.reportType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedBranchesIsNullable() {
        final GitLabProjectApprovalRuleBuilder builder = GitLabProjectApprovalRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalRule())
                .protectedBranches(null);

        final GitLabProjectApprovalRule built = builder.build();

        assertThat(built.protectedBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppliesToAllProtectedBranchesIsNullable() {
        final GitLabProjectApprovalRuleBuilder builder = GitLabProjectApprovalRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalRule())
                .appliesToAllProtectedBranches(null);

        final GitLabProjectApprovalRule built = builder.build();

        assertThat(built.appliesToAllProtectedBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCoverageMinimumThresholdIsNullable() {
        final GitLabProjectApprovalRuleBuilder builder = GitLabProjectApprovalRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalRule())
                .coverageMinimumThreshold(null);

        final GitLabProjectApprovalRule built = builder.build();

        assertThat(built.coverageMinimumThreshold()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectApprovalRule value = ProjectsCatalogFixtures.projectApprovalRule();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("QA");
            softly.assertThat(value.ruleType()).isEqualTo("regular");
            softly.assertThat(value.eligibleApprovers()).isEqualTo(List.of(CommonCatalogFixtures.userBasic()));
            softly.assertThat(value.approvalsRequired()).isEqualTo(1);
            softly.assertThat(value.users()).isEqualTo(List.of(CommonCatalogFixtures.userBasic()));
            softly.assertThat(value.groups()).isEqualTo(List.of(CommonCatalogFixtures.group()));
            softly.assertThat(value.containsHiddenGroups()).isEqualTo(true);
            softly.assertThat(value.reportType()).isEqualTo("report_type");
            softly.assertThat(value.protectedBranches()).isEqualTo(List.of(CommonCatalogFixtures.protectedBranch()));
            softly.assertThat(value.appliesToAllProtectedBranches()).isEqualTo(true);
            softly.assertThat(value.coverageMinimumThreshold()).isEqualTo(1.5);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectApprovalRule original = ProjectsCatalogFixtures.projectApprovalRule();

        final GitLabProjectApprovalRule rebuilt =
                GitLabProjectApprovalRuleBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectApprovalRule.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "name",
                        "ruleType",
                        "eligibleApprovers",
                        "approvalsRequired",
                        "users",
                        "groups",
                        "containsHiddenGroups",
                        "reportType",
                        "protectedBranches",
                        "appliesToAllProtectedBranches",
                        "coverageMinimumThreshold");
    }
}

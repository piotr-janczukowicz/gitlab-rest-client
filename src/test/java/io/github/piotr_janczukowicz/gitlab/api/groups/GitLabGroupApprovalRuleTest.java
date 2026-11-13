package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupApprovalRuleTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabGroupApprovalRuleBuilder builder = GitLabGroupApprovalRuleBuilder.builder(
                        GroupsCatalogFixtures.groupApprovalRule())
                .id(null);

        final GitLabGroupApprovalRule built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupApprovalRuleBuilder builder = GitLabGroupApprovalRuleBuilder.builder(
                        GroupsCatalogFixtures.groupApprovalRule())
                .name(null);

        final GitLabGroupApprovalRule built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRuleTypeIsNullable() {
        final GitLabGroupApprovalRuleBuilder builder = GitLabGroupApprovalRuleBuilder.builder(
                        GroupsCatalogFixtures.groupApprovalRule())
                .ruleType(null);

        final GitLabGroupApprovalRule built = builder.build();

        assertThat(built.ruleType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEligibleApproversIsNullable() {
        final GitLabGroupApprovalRuleBuilder builder = GitLabGroupApprovalRuleBuilder.builder(
                        GroupsCatalogFixtures.groupApprovalRule())
                .eligibleApprovers(null);

        final GitLabGroupApprovalRule built = builder.build();

        assertThat(built.eligibleApprovers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsRequiredIsNullable() {
        final GitLabGroupApprovalRuleBuilder builder = GitLabGroupApprovalRuleBuilder.builder(
                        GroupsCatalogFixtures.groupApprovalRule())
                .approvalsRequired(null);

        final GitLabGroupApprovalRule built = builder.build();

        assertThat(built.approvalsRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersIsNullable() {
        final GitLabGroupApprovalRuleBuilder builder = GitLabGroupApprovalRuleBuilder.builder(
                        GroupsCatalogFixtures.groupApprovalRule())
                .users(null);

        final GitLabGroupApprovalRule built = builder.build();

        assertThat(built.users()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupsIsNullable() {
        final GitLabGroupApprovalRuleBuilder builder = GitLabGroupApprovalRuleBuilder.builder(
                        GroupsCatalogFixtures.groupApprovalRule())
                .groups(null);

        final GitLabGroupApprovalRule built = builder.build();

        assertThat(built.groups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainsHiddenGroupsIsNullable() {
        final GitLabGroupApprovalRuleBuilder builder = GitLabGroupApprovalRuleBuilder.builder(
                        GroupsCatalogFixtures.groupApprovalRule())
                .containsHiddenGroups(null);

        final GitLabGroupApprovalRule built = builder.build();

        assertThat(built.containsHiddenGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReportTypeIsNullable() {
        final GitLabGroupApprovalRuleBuilder builder = GitLabGroupApprovalRuleBuilder.builder(
                        GroupsCatalogFixtures.groupApprovalRule())
                .reportType(null);

        final GitLabGroupApprovalRule built = builder.build();

        assertThat(built.reportType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedBranchesIsNullable() {
        final GitLabGroupApprovalRuleBuilder builder = GitLabGroupApprovalRuleBuilder.builder(
                        GroupsCatalogFixtures.groupApprovalRule())
                .protectedBranches(null);

        final GitLabGroupApprovalRule built = builder.build();

        assertThat(built.protectedBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppliesToAllProtectedBranchesIsNullable() {
        final GitLabGroupApprovalRuleBuilder builder = GitLabGroupApprovalRuleBuilder.builder(
                        GroupsCatalogFixtures.groupApprovalRule())
                .appliesToAllProtectedBranches(null);

        final GitLabGroupApprovalRule built = builder.build();

        assertThat(built.appliesToAllProtectedBranches()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupApprovalRule value = GroupsCatalogFixtures.groupApprovalRule();

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
            softly.assertThat(value.protectedBranches()).isEqualTo(CommonCatalogFixtures.protectedBranch());
            softly.assertThat(value.appliesToAllProtectedBranches()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupApprovalRule original = GroupsCatalogFixtures.groupApprovalRule();

        final GitLabGroupApprovalRule rebuilt =
                GitLabGroupApprovalRuleBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupApprovalRule.class.getRecordComponents())
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
                        "appliesToAllProtectedBranches");
    }
}

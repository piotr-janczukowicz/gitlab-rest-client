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
class GitLabProjectApprovalSettingRuleTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectApprovalSettingRuleBuilder builder = GitLabProjectApprovalSettingRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalSettingRule())
                .id(null);

        final GitLabProjectApprovalSettingRule built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectApprovalSettingRuleBuilder builder = GitLabProjectApprovalSettingRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalSettingRule())
                .name(null);

        final GitLabProjectApprovalSettingRule built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRuleTypeIsNullable() {
        final GitLabProjectApprovalSettingRuleBuilder builder = GitLabProjectApprovalSettingRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalSettingRule())
                .ruleType(null);

        final GitLabProjectApprovalSettingRule built = builder.build();

        assertThat(built.ruleType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsRequiredIsNullable() {
        final GitLabProjectApprovalSettingRuleBuilder builder = GitLabProjectApprovalSettingRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalSettingRule())
                .approvalsRequired(null);

        final GitLabProjectApprovalSettingRule built = builder.build();

        assertThat(built.approvalsRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersIsNullable() {
        final GitLabProjectApprovalSettingRuleBuilder builder = GitLabProjectApprovalSettingRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalSettingRule())
                .users(null);

        final GitLabProjectApprovalSettingRule built = builder.build();

        assertThat(built.users()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupsIsNullable() {
        final GitLabProjectApprovalSettingRuleBuilder builder = GitLabProjectApprovalSettingRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalSettingRule())
                .groups(null);

        final GitLabProjectApprovalSettingRule built = builder.build();

        assertThat(built.groups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainsHiddenGroupsIsNullable() {
        final GitLabProjectApprovalSettingRuleBuilder builder = GitLabProjectApprovalSettingRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalSettingRule())
                .containsHiddenGroups(null);

        final GitLabProjectApprovalSettingRule built = builder.build();

        assertThat(built.containsHiddenGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReportTypeIsNullable() {
        final GitLabProjectApprovalSettingRuleBuilder builder = GitLabProjectApprovalSettingRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalSettingRule())
                .reportType(null);

        final GitLabProjectApprovalSettingRule built = builder.build();

        assertThat(built.reportType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedBranchesIsNullable() {
        final GitLabProjectApprovalSettingRuleBuilder builder = GitLabProjectApprovalSettingRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalSettingRule())
                .protectedBranches(null);

        final GitLabProjectApprovalSettingRule built = builder.build();

        assertThat(built.protectedBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppliesToAllProtectedBranchesIsNullable() {
        final GitLabProjectApprovalSettingRuleBuilder builder = GitLabProjectApprovalSettingRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalSettingRule())
                .appliesToAllProtectedBranches(null);

        final GitLabProjectApprovalSettingRule built = builder.build();

        assertThat(built.appliesToAllProtectedBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCoverageMinimumThresholdIsNullable() {
        final GitLabProjectApprovalSettingRuleBuilder builder = GitLabProjectApprovalSettingRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalSettingRule())
                .coverageMinimumThreshold(null);

        final GitLabProjectApprovalSettingRule built = builder.build();

        assertThat(built.coverageMinimumThreshold()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApproversIsNullable() {
        final GitLabProjectApprovalSettingRuleBuilder builder = GitLabProjectApprovalSettingRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalSettingRule())
                .approvers(null);

        final GitLabProjectApprovalSettingRule built = builder.build();

        assertThat(built.approvers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScannersIsNullable() {
        final GitLabProjectApprovalSettingRuleBuilder builder = GitLabProjectApprovalSettingRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalSettingRule())
                .scanners(null);

        final GitLabProjectApprovalSettingRule built = builder.build();

        assertThat(built.scanners()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilitiesAllowedIsNullable() {
        final GitLabProjectApprovalSettingRuleBuilder builder = GitLabProjectApprovalSettingRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalSettingRule())
                .vulnerabilitiesAllowed(null);

        final GitLabProjectApprovalSettingRule built = builder.build();

        assertThat(built.vulnerabilitiesAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSeverityLevelsIsNullable() {
        final GitLabProjectApprovalSettingRuleBuilder builder = GitLabProjectApprovalSettingRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalSettingRule())
                .severityLevels(null);

        final GitLabProjectApprovalSettingRule built = builder.build();

        assertThat(built.severityLevels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityStatesIsNullable() {
        final GitLabProjectApprovalSettingRuleBuilder builder = GitLabProjectApprovalSettingRuleBuilder.builder(
                        ProjectsCatalogFixtures.projectApprovalSettingRule())
                .vulnerabilityStates(null);

        final GitLabProjectApprovalSettingRule built = builder.build();

        assertThat(built.vulnerabilityStates()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectApprovalSettingRule value = ProjectsCatalogFixtures.projectApprovalSettingRule();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("QA");
            softly.assertThat(value.ruleType()).isEqualTo("regular");
            softly.assertThat(value.approvalsRequired()).isEqualTo(1);
            softly.assertThat(value.users()).isEqualTo(List.of(CommonCatalogFixtures.userBasic()));
            softly.assertThat(value.groups()).isEqualTo(List.of(CommonCatalogFixtures.group()));
            softly.assertThat(value.containsHiddenGroups()).isEqualTo(true);
            softly.assertThat(value.reportType()).isEqualTo("report_type");
            softly.assertThat(value.protectedBranches()).isEqualTo(List.of(CommonCatalogFixtures.protectedBranch()));
            softly.assertThat(value.appliesToAllProtectedBranches()).isEqualTo(true);
            softly.assertThat(value.coverageMinimumThreshold()).isEqualTo(1.5);
            softly.assertThat(value.approvers()).isEqualTo(List.of(CommonCatalogFixtures.userBasic()));
            softly.assertThat(value.scanners()).isEqualTo(List.of("scanners"));
            softly.assertThat(value.vulnerabilitiesAllowed()).isEqualTo(1);
            softly.assertThat(value.severityLevels()).isEqualTo(List.of("severity_levels"));
            softly.assertThat(value.vulnerabilityStates()).isEqualTo(List.of("vulnerability_states"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectApprovalSettingRule original = ProjectsCatalogFixtures.projectApprovalSettingRule();

        final GitLabProjectApprovalSettingRule rebuilt =
                GitLabProjectApprovalSettingRuleBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectApprovalSettingRule.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "name",
                        "ruleType",
                        "approvalsRequired",
                        "users",
                        "groups",
                        "containsHiddenGroups",
                        "reportType",
                        "protectedBranches",
                        "appliesToAllProtectedBranches",
                        "coverageMinimumThreshold",
                        "approvers",
                        "scanners",
                        "vulnerabilitiesAllowed",
                        "severityLevels",
                        "vulnerabilityStates");
    }
}

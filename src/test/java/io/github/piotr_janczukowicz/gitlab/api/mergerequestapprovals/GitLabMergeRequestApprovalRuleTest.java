package io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovals;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMergeRequestApprovalRuleTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabMergeRequestApprovalRuleBuilder builder = GitLabMergeRequestApprovalRuleBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.mergeRequestApprovalRule())
                .id(null);

        final GitLabMergeRequestApprovalRule built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabMergeRequestApprovalRuleBuilder builder = GitLabMergeRequestApprovalRuleBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.mergeRequestApprovalRule())
                .name(null);

        final GitLabMergeRequestApprovalRule built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRuleTypeIsNullable() {
        final GitLabMergeRequestApprovalRuleBuilder builder = GitLabMergeRequestApprovalRuleBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.mergeRequestApprovalRule())
                .ruleType(null);

        final GitLabMergeRequestApprovalRule built = builder.build();

        assertThat(built.ruleType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEligibleApproversIsNullable() {
        final GitLabMergeRequestApprovalRuleBuilder builder = GitLabMergeRequestApprovalRuleBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.mergeRequestApprovalRule())
                .eligibleApprovers(null);

        final GitLabMergeRequestApprovalRule built = builder.build();

        assertThat(built.eligibleApprovers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsRequiredIsNullable() {
        final GitLabMergeRequestApprovalRuleBuilder builder = GitLabMergeRequestApprovalRuleBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.mergeRequestApprovalRule())
                .approvalsRequired(null);

        final GitLabMergeRequestApprovalRule built = builder.build();

        assertThat(built.approvalsRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersIsNullable() {
        final GitLabMergeRequestApprovalRuleBuilder builder = GitLabMergeRequestApprovalRuleBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.mergeRequestApprovalRule())
                .users(null);

        final GitLabMergeRequestApprovalRule built = builder.build();

        assertThat(built.users()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupsIsNullable() {
        final GitLabMergeRequestApprovalRuleBuilder builder = GitLabMergeRequestApprovalRuleBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.mergeRequestApprovalRule())
                .groups(null);

        final GitLabMergeRequestApprovalRule built = builder.build();

        assertThat(built.groups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainsHiddenGroupsIsNullable() {
        final GitLabMergeRequestApprovalRuleBuilder builder = GitLabMergeRequestApprovalRuleBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.mergeRequestApprovalRule())
                .containsHiddenGroups(null);

        final GitLabMergeRequestApprovalRule built = builder.build();

        assertThat(built.containsHiddenGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReportTypeIsNullable() {
        final GitLabMergeRequestApprovalRuleBuilder builder = GitLabMergeRequestApprovalRuleBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.mergeRequestApprovalRule())
                .reportType(null);

        final GitLabMergeRequestApprovalRule built = builder.build();

        assertThat(built.reportType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSectionIsNullable() {
        final GitLabMergeRequestApprovalRuleBuilder builder = GitLabMergeRequestApprovalRuleBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.mergeRequestApprovalRule())
                .section(null);

        final GitLabMergeRequestApprovalRule built = builder.build();

        assertThat(built.section()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceRuleIsNullable() {
        final GitLabMergeRequestApprovalRuleBuilder builder = GitLabMergeRequestApprovalRuleBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.mergeRequestApprovalRule())
                .sourceRule(null);

        final GitLabMergeRequestApprovalRule built = builder.build();

        assertThat(built.sourceRule()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOverriddenIsNullable() {
        final GitLabMergeRequestApprovalRuleBuilder builder = GitLabMergeRequestApprovalRuleBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.mergeRequestApprovalRule())
                .overridden(null);

        final GitLabMergeRequestApprovalRule built = builder.build();

        assertThat(built.overridden()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMergeRequestApprovalRule value = MergerequestapprovalsCatalogFixtures.mergeRequestApprovalRule();

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
            softly.assertThat(value.section()).isEqualTo("Backend");
            softly.assertThat(value.sourceRule()).isEqualTo(CommonCatalogFixtures.mergeRequestApprovalRuleSourceRule());
            softly.assertThat(value.overridden()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMergeRequestApprovalRule original = MergerequestapprovalsCatalogFixtures.mergeRequestApprovalRule();

        final GitLabMergeRequestApprovalRule rebuilt =
                GitLabMergeRequestApprovalRuleBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMergeRequestApprovalRule.class.getRecordComponents())
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
                        "section",
                        "sourceRule",
                        "overridden");
    }
}

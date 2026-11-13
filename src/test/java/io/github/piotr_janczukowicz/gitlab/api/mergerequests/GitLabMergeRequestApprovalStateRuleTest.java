package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMergeRequestApprovalStateRuleTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabMergeRequestApprovalStateRuleBuilder builder = GitLabMergeRequestApprovalStateRuleBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestApprovalStateRule())
                .id(null);

        final GitLabMergeRequestApprovalStateRule built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabMergeRequestApprovalStateRuleBuilder builder = GitLabMergeRequestApprovalStateRuleBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestApprovalStateRule())
                .name(null);

        final GitLabMergeRequestApprovalStateRule built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRuleTypeIsNullable() {
        final GitLabMergeRequestApprovalStateRuleBuilder builder = GitLabMergeRequestApprovalStateRuleBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestApprovalStateRule())
                .ruleType(null);

        final GitLabMergeRequestApprovalStateRule built = builder.build();

        assertThat(built.ruleType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEligibleApproversIsNullable() {
        final GitLabMergeRequestApprovalStateRuleBuilder builder = GitLabMergeRequestApprovalStateRuleBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestApprovalStateRule())
                .eligibleApprovers(null);

        final GitLabMergeRequestApprovalStateRule built = builder.build();

        assertThat(built.eligibleApprovers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsRequiredIsNullable() {
        final GitLabMergeRequestApprovalStateRuleBuilder builder = GitLabMergeRequestApprovalStateRuleBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestApprovalStateRule())
                .approvalsRequired(null);

        final GitLabMergeRequestApprovalStateRule built = builder.build();

        assertThat(built.approvalsRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersIsNullable() {
        final GitLabMergeRequestApprovalStateRuleBuilder builder = GitLabMergeRequestApprovalStateRuleBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestApprovalStateRule())
                .users(null);

        final GitLabMergeRequestApprovalStateRule built = builder.build();

        assertThat(built.users()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupsIsNullable() {
        final GitLabMergeRequestApprovalStateRuleBuilder builder = GitLabMergeRequestApprovalStateRuleBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestApprovalStateRule())
                .groups(null);

        final GitLabMergeRequestApprovalStateRule built = builder.build();

        assertThat(built.groups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainsHiddenGroupsIsNullable() {
        final GitLabMergeRequestApprovalStateRuleBuilder builder = GitLabMergeRequestApprovalStateRuleBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestApprovalStateRule())
                .containsHiddenGroups(null);

        final GitLabMergeRequestApprovalStateRule built = builder.build();

        assertThat(built.containsHiddenGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReportTypeIsNullable() {
        final GitLabMergeRequestApprovalStateRuleBuilder builder = GitLabMergeRequestApprovalStateRuleBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestApprovalStateRule())
                .reportType(null);

        final GitLabMergeRequestApprovalStateRule built = builder.build();

        assertThat(built.reportType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSectionIsNullable() {
        final GitLabMergeRequestApprovalStateRuleBuilder builder = GitLabMergeRequestApprovalStateRuleBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestApprovalStateRule())
                .section(null);

        final GitLabMergeRequestApprovalStateRule built = builder.build();

        assertThat(built.section()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceRuleIsNullable() {
        final GitLabMergeRequestApprovalStateRuleBuilder builder = GitLabMergeRequestApprovalStateRuleBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestApprovalStateRule())
                .sourceRule(null);

        final GitLabMergeRequestApprovalStateRule built = builder.build();

        assertThat(built.sourceRule()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOverriddenIsNullable() {
        final GitLabMergeRequestApprovalStateRuleBuilder builder = GitLabMergeRequestApprovalStateRuleBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestApprovalStateRule())
                .overridden(null);

        final GitLabMergeRequestApprovalStateRule built = builder.build();

        assertThat(built.overridden()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCodeOwnerIsNullable() {
        final GitLabMergeRequestApprovalStateRuleBuilder builder = GitLabMergeRequestApprovalStateRuleBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestApprovalStateRule())
                .codeOwner(null);

        final GitLabMergeRequestApprovalStateRule built = builder.build();

        assertThat(built.codeOwner()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovedByIsNullable() {
        final GitLabMergeRequestApprovalStateRuleBuilder builder = GitLabMergeRequestApprovalStateRuleBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestApprovalStateRule())
                .approvedBy(null);

        final GitLabMergeRequestApprovalStateRule built = builder.build();

        assertThat(built.approvedBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovedIsNullable() {
        final GitLabMergeRequestApprovalStateRuleBuilder builder = GitLabMergeRequestApprovalStateRuleBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestApprovalStateRule())
                .approved(null);

        final GitLabMergeRequestApprovalStateRule built = builder.build();

        assertThat(built.approved()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMergeRequestApprovalStateRule value = MergerequestsCatalogFixtures.mergeRequestApprovalStateRule();

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
            softly.assertThat(value.codeOwner()).isEqualTo(true);
            softly.assertThat(value.approvedBy()).isEqualTo(List.of(CommonCatalogFixtures.userBasic()));
            softly.assertThat(value.approved()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMergeRequestApprovalStateRule original =
                MergerequestsCatalogFixtures.mergeRequestApprovalStateRule();

        final GitLabMergeRequestApprovalStateRule rebuilt =
                GitLabMergeRequestApprovalStateRuleBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMergeRequestApprovalStateRule.class.getRecordComponents())
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
                        "overridden",
                        "codeOwner",
                        "approvedBy",
                        "approved");
    }
}

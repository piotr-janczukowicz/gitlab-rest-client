package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMergeRequestApprovalsTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabMergeRequestApprovalsBuilder builder = GitLabMergeRequestApprovalsBuilder.builder(
                        CommonCatalogFixtures.mergeRequestApprovals())
                .id(null);

        final GitLabMergeRequestApprovals built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabMergeRequestApprovalsBuilder builder = GitLabMergeRequestApprovalsBuilder.builder(
                        CommonCatalogFixtures.mergeRequestApprovals())
                .iid(null);

        final GitLabMergeRequestApprovals built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabMergeRequestApprovalsBuilder builder = GitLabMergeRequestApprovalsBuilder.builder(
                        CommonCatalogFixtures.mergeRequestApprovals())
                .projectId(null);

        final GitLabMergeRequestApprovals built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabMergeRequestApprovalsBuilder builder = GitLabMergeRequestApprovalsBuilder.builder(
                        CommonCatalogFixtures.mergeRequestApprovals())
                .title(null);

        final GitLabMergeRequestApprovals built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabMergeRequestApprovalsBuilder builder = GitLabMergeRequestApprovalsBuilder.builder(
                        CommonCatalogFixtures.mergeRequestApprovals())
                .description(null);

        final GitLabMergeRequestApprovals built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabMergeRequestApprovalsBuilder builder = GitLabMergeRequestApprovalsBuilder.builder(
                        CommonCatalogFixtures.mergeRequestApprovals())
                .state(null);

        final GitLabMergeRequestApprovals built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabMergeRequestApprovalsBuilder builder = GitLabMergeRequestApprovalsBuilder.builder(
                        CommonCatalogFixtures.mergeRequestApprovals())
                .createdAt(null);

        final GitLabMergeRequestApprovals built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabMergeRequestApprovalsBuilder builder = GitLabMergeRequestApprovalsBuilder.builder(
                        CommonCatalogFixtures.mergeRequestApprovals())
                .updatedAt(null);

        final GitLabMergeRequestApprovals built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeStatusIsNullable() {
        final GitLabMergeRequestApprovalsBuilder builder = GitLabMergeRequestApprovalsBuilder.builder(
                        CommonCatalogFixtures.mergeRequestApprovals())
                .mergeStatus(null);

        final GitLabMergeRequestApprovals built = builder.build();

        assertThat(built.mergeStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovedIsNullable() {
        final GitLabMergeRequestApprovalsBuilder builder = GitLabMergeRequestApprovalsBuilder.builder(
                        CommonCatalogFixtures.mergeRequestApprovals())
                .approved(null);

        final GitLabMergeRequestApprovals built = builder.build();

        assertThat(built.approved()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsRequiredIsNullable() {
        final GitLabMergeRequestApprovalsBuilder builder = GitLabMergeRequestApprovalsBuilder.builder(
                        CommonCatalogFixtures.mergeRequestApprovals())
                .approvalsRequired(null);

        final GitLabMergeRequestApprovals built = builder.build();

        assertThat(built.approvalsRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsLeftIsNullable() {
        final GitLabMergeRequestApprovalsBuilder builder = GitLabMergeRequestApprovalsBuilder.builder(
                        CommonCatalogFixtures.mergeRequestApprovals())
                .approvalsLeft(null);

        final GitLabMergeRequestApprovals built = builder.build();

        assertThat(built.approvalsLeft()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequirePasswordToApproveIsNullable() {
        final GitLabMergeRequestApprovalsBuilder builder = GitLabMergeRequestApprovalsBuilder.builder(
                        CommonCatalogFixtures.mergeRequestApprovals())
                .requirePasswordToApprove(null);

        final GitLabMergeRequestApprovals built = builder.build();

        assertThat(built.requirePasswordToApprove()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovedByIsNullable() {
        final GitLabMergeRequestApprovalsBuilder builder = GitLabMergeRequestApprovalsBuilder.builder(
                        CommonCatalogFixtures.mergeRequestApprovals())
                .approvedBy(null);

        final GitLabMergeRequestApprovals built = builder.build();

        assertThat(built.approvedBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSuggestedApproversIsNullable() {
        final GitLabMergeRequestApprovalsBuilder builder = GitLabMergeRequestApprovalsBuilder.builder(
                        CommonCatalogFixtures.mergeRequestApprovals())
                .suggestedApprovers(null);

        final GitLabMergeRequestApprovals built = builder.build();

        assertThat(built.suggestedApprovers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApproversIsNullable() {
        final GitLabMergeRequestApprovalsBuilder builder = GitLabMergeRequestApprovalsBuilder.builder(
                        CommonCatalogFixtures.mergeRequestApprovals())
                .approvers(null);

        final GitLabMergeRequestApprovals built = builder.build();

        assertThat(built.approvers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApproverGroupsIsNullable() {
        final GitLabMergeRequestApprovalsBuilder builder = GitLabMergeRequestApprovalsBuilder.builder(
                        CommonCatalogFixtures.mergeRequestApprovals())
                .approverGroups(null);

        final GitLabMergeRequestApprovals built = builder.build();

        assertThat(built.approverGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserHasApprovedIsNullable() {
        final GitLabMergeRequestApprovalsBuilder builder = GitLabMergeRequestApprovalsBuilder.builder(
                        CommonCatalogFixtures.mergeRequestApprovals())
                .userHasApproved(null);

        final GitLabMergeRequestApprovals built = builder.build();

        assertThat(built.userHasApproved()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserCanApproveIsNullable() {
        final GitLabMergeRequestApprovalsBuilder builder = GitLabMergeRequestApprovalsBuilder.builder(
                        CommonCatalogFixtures.mergeRequestApprovals())
                .userCanApprove(null);

        final GitLabMergeRequestApprovals built = builder.build();

        assertThat(built.userCanApprove()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalRulesLeftIsNullable() {
        final GitLabMergeRequestApprovalsBuilder builder = GitLabMergeRequestApprovalsBuilder.builder(
                        CommonCatalogFixtures.mergeRequestApprovals())
                .approvalRulesLeft(null);

        final GitLabMergeRequestApprovals built = builder.build();

        assertThat(built.approvalRulesLeft()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHasApprovalRulesIsNullable() {
        final GitLabMergeRequestApprovalsBuilder builder = GitLabMergeRequestApprovalsBuilder.builder(
                        CommonCatalogFixtures.mergeRequestApprovals())
                .hasApprovalRules(null);

        final GitLabMergeRequestApprovals built = builder.build();

        assertThat(built.hasApprovalRules()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestApproversAvailableIsNullable() {
        final GitLabMergeRequestApprovalsBuilder builder = GitLabMergeRequestApprovalsBuilder.builder(
                        CommonCatalogFixtures.mergeRequestApprovals())
                .mergeRequestApproversAvailable(null);

        final GitLabMergeRequestApprovals built = builder.build();

        assertThat(built.mergeRequestApproversAvailable()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMultipleApprovalRulesAvailableIsNullable() {
        final GitLabMergeRequestApprovalsBuilder builder = GitLabMergeRequestApprovalsBuilder.builder(
                        CommonCatalogFixtures.mergeRequestApprovals())
                .multipleApprovalRulesAvailable(null);

        final GitLabMergeRequestApprovals built = builder.build();

        assertThat(built.multipleApprovalRulesAvailable()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInvalidApproversRulesIsNullable() {
        final GitLabMergeRequestApprovalsBuilder builder = GitLabMergeRequestApprovalsBuilder.builder(
                        CommonCatalogFixtures.mergeRequestApprovals())
                .invalidApproversRules(null);

        final GitLabMergeRequestApprovals built = builder.build();

        assertThat(built.invalidApproversRules()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMergeRequestApprovals value = CommonCatalogFixtures.mergeRequestApprovals();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.iid()).isEqualTo(1L);
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.title()).isEqualTo("Impedit et ut et dolores vero provident ullam est");
            softly.assertThat(value.description()).isEqualTo("Repellendus impedit et vel velit dignissimos.");
            softly.assertThat(value.state()).isEqualTo("closed");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.mergeStatus()).isEqualTo("can_be_merged");
            softly.assertThat(value.approved()).isEqualTo(true);
            softly.assertThat(value.approvalsRequired()).isEqualTo(1);
            softly.assertThat(value.approvalsLeft()).isEqualTo(1);
            softly.assertThat(value.requirePasswordToApprove()).isEqualTo(true);
            softly.assertThat(value.approvedBy()).isEqualTo(List.of(CommonCatalogFixtures.approvals()));
            softly.assertThat(value.suggestedApprovers()).isEqualTo(List.of(CommonCatalogFixtures.userBasic()));
            softly.assertThat(value.approvers()).isEqualTo(List.of(Map.of("key", "value")));
            softly.assertThat(value.approverGroups()).isEqualTo(List.of(Map.of("key", "value")));
            softly.assertThat(value.userHasApproved()).isEqualTo(true);
            softly.assertThat(value.userCanApprove()).isEqualTo(true);
            softly.assertThat(value.approvalRulesLeft()).isEqualTo(List.of(CommonCatalogFixtures.approvalRuleShort()));
            softly.assertThat(value.hasApprovalRules()).isEqualTo(true);
            softly.assertThat(value.mergeRequestApproversAvailable()).isEqualTo(true);
            softly.assertThat(value.multipleApprovalRulesAvailable()).isEqualTo(true);
            softly.assertThat(value.invalidApproversRules())
                    .isEqualTo(List.of(CommonCatalogFixtures.approvalRuleShort()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMergeRequestApprovals original = CommonCatalogFixtures.mergeRequestApprovals();

        final GitLabMergeRequestApprovals rebuilt =
                GitLabMergeRequestApprovalsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMergeRequestApprovals.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "iid",
                        "projectId",
                        "title",
                        "description",
                        "state",
                        "createdAt",
                        "updatedAt",
                        "mergeStatus",
                        "approved",
                        "approvalsRequired",
                        "approvalsLeft",
                        "requirePasswordToApprove",
                        "approvedBy",
                        "suggestedApprovers",
                        "approvers",
                        "approverGroups",
                        "userHasApproved",
                        "userCanApprove",
                        "approvalRulesLeft",
                        "hasApprovalRules",
                        "mergeRequestApproversAvailable",
                        "multipleApprovalRulesAvailable",
                        "invalidApproversRules");
    }
}

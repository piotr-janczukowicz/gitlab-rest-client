package io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovals;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApprovalStateTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabApprovalStateBuilder builder = GitLabApprovalStateBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalState())
                .id(null);

        final GitLabApprovalState built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabApprovalStateBuilder builder = GitLabApprovalStateBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalState())
                .iid(null);

        final GitLabApprovalState built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabApprovalStateBuilder builder = GitLabApprovalStateBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalState())
                .projectId(null);

        final GitLabApprovalState built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabApprovalStateBuilder builder = GitLabApprovalStateBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalState())
                .title(null);

        final GitLabApprovalState built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabApprovalStateBuilder builder = GitLabApprovalStateBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalState())
                .description(null);

        final GitLabApprovalState built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabApprovalStateBuilder builder = GitLabApprovalStateBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalState())
                .state(null);

        final GitLabApprovalState built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabApprovalStateBuilder builder = GitLabApprovalStateBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalState())
                .createdAt(null);

        final GitLabApprovalState built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabApprovalStateBuilder builder = GitLabApprovalStateBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalState())
                .updatedAt(null);

        final GitLabApprovalState built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeStatusIsNullable() {
        final GitLabApprovalStateBuilder builder = GitLabApprovalStateBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalState())
                .mergeStatus(null);

        final GitLabApprovalState built = builder.build();

        assertThat(built.mergeStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovedIsNullable() {
        final GitLabApprovalStateBuilder builder = GitLabApprovalStateBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalState())
                .approved(null);

        final GitLabApprovalState built = builder.build();

        assertThat(built.approved()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsRequiredIsNullable() {
        final GitLabApprovalStateBuilder builder = GitLabApprovalStateBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalState())
                .approvalsRequired(null);

        final GitLabApprovalState built = builder.build();

        assertThat(built.approvalsRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsLeftIsNullable() {
        final GitLabApprovalStateBuilder builder = GitLabApprovalStateBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalState())
                .approvalsLeft(null);

        final GitLabApprovalState built = builder.build();

        assertThat(built.approvalsLeft()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequirePasswordToApproveIsNullable() {
        final GitLabApprovalStateBuilder builder = GitLabApprovalStateBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalState())
                .requirePasswordToApprove(null);

        final GitLabApprovalState built = builder.build();

        assertThat(built.requirePasswordToApprove()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovedByIsNullable() {
        final GitLabApprovalStateBuilder builder = GitLabApprovalStateBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalState())
                .approvedBy(null);

        final GitLabApprovalState built = builder.build();

        assertThat(built.approvedBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSuggestedApproversIsNullable() {
        final GitLabApprovalStateBuilder builder = GitLabApprovalStateBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalState())
                .suggestedApprovers(null);

        final GitLabApprovalState built = builder.build();

        assertThat(built.suggestedApprovers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApproversIsNullable() {
        final GitLabApprovalStateBuilder builder = GitLabApprovalStateBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalState())
                .approvers(null);

        final GitLabApprovalState built = builder.build();

        assertThat(built.approvers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApproverGroupsIsNullable() {
        final GitLabApprovalStateBuilder builder = GitLabApprovalStateBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalState())
                .approverGroups(null);

        final GitLabApprovalState built = builder.build();

        assertThat(built.approverGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserHasApprovedIsNullable() {
        final GitLabApprovalStateBuilder builder = GitLabApprovalStateBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalState())
                .userHasApproved(null);

        final GitLabApprovalState built = builder.build();

        assertThat(built.userHasApproved()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserCanApproveIsNullable() {
        final GitLabApprovalStateBuilder builder = GitLabApprovalStateBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalState())
                .userCanApprove(null);

        final GitLabApprovalState built = builder.build();

        assertThat(built.userCanApprove()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalRulesLeftIsNullable() {
        final GitLabApprovalStateBuilder builder = GitLabApprovalStateBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalState())
                .approvalRulesLeft(null);

        final GitLabApprovalState built = builder.build();

        assertThat(built.approvalRulesLeft()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHasApprovalRulesIsNullable() {
        final GitLabApprovalStateBuilder builder = GitLabApprovalStateBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalState())
                .hasApprovalRules(null);

        final GitLabApprovalState built = builder.build();

        assertThat(built.hasApprovalRules()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestApproversAvailableIsNullable() {
        final GitLabApprovalStateBuilder builder = GitLabApprovalStateBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalState())
                .mergeRequestApproversAvailable(null);

        final GitLabApprovalState built = builder.build();

        assertThat(built.mergeRequestApproversAvailable()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMultipleApprovalRulesAvailableIsNullable() {
        final GitLabApprovalStateBuilder builder = GitLabApprovalStateBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalState())
                .multipleApprovalRulesAvailable(null);

        final GitLabApprovalState built = builder.build();

        assertThat(built.multipleApprovalRulesAvailable()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInvalidApproversRulesIsNullable() {
        final GitLabApprovalStateBuilder builder = GitLabApprovalStateBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approvalState())
                .invalidApproversRules(null);

        final GitLabApprovalState built = builder.build();

        assertThat(built.invalidApproversRules()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApprovalState value = MergerequestapprovalsCatalogFixtures.approvalState();

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
        final GitLabApprovalState original = MergerequestapprovalsCatalogFixtures.approvalState();

        final GitLabApprovalState rebuilt =
                GitLabApprovalStateBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApprovalState.class.getRecordComponents())
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

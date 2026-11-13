package io.github.piotr_janczukowicz.gitlab.api.deployments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProtectedEnvironmentsApprovalRuleForSummaryTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProtectedEnvironmentsApprovalRuleForSummaryBuilder builder =
                GitLabProtectedEnvironmentsApprovalRuleForSummaryBuilder.builder(
                                DeploymentsCatalogFixtures.protectedEnvironmentsApprovalRuleForSummary())
                        .id(null);

        final GitLabProtectedEnvironmentsApprovalRuleForSummary built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabProtectedEnvironmentsApprovalRuleForSummaryBuilder builder =
                GitLabProtectedEnvironmentsApprovalRuleForSummaryBuilder.builder(
                                DeploymentsCatalogFixtures.protectedEnvironmentsApprovalRuleForSummary())
                        .userId(null);

        final GitLabProtectedEnvironmentsApprovalRuleForSummary built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabProtectedEnvironmentsApprovalRuleForSummaryBuilder builder =
                GitLabProtectedEnvironmentsApprovalRuleForSummaryBuilder.builder(
                                DeploymentsCatalogFixtures.protectedEnvironmentsApprovalRuleForSummary())
                        .groupId(null);

        final GitLabProtectedEnvironmentsApprovalRuleForSummary built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabProtectedEnvironmentsApprovalRuleForSummaryBuilder builder =
                GitLabProtectedEnvironmentsApprovalRuleForSummaryBuilder.builder(
                                DeploymentsCatalogFixtures.protectedEnvironmentsApprovalRuleForSummary())
                        .accessLevel(null);

        final GitLabProtectedEnvironmentsApprovalRuleForSummary built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelDescriptionIsNullable() {
        final GitLabProtectedEnvironmentsApprovalRuleForSummaryBuilder builder =
                GitLabProtectedEnvironmentsApprovalRuleForSummaryBuilder.builder(
                                DeploymentsCatalogFixtures.protectedEnvironmentsApprovalRuleForSummary())
                        .accessLevelDescription(null);

        final GitLabProtectedEnvironmentsApprovalRuleForSummary built = builder.build();

        assertThat(built.accessLevelDescription()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequiredApprovalsIsNullable() {
        final GitLabProtectedEnvironmentsApprovalRuleForSummaryBuilder builder =
                GitLabProtectedEnvironmentsApprovalRuleForSummaryBuilder.builder(
                                DeploymentsCatalogFixtures.protectedEnvironmentsApprovalRuleForSummary())
                        .requiredApprovals(null);

        final GitLabProtectedEnvironmentsApprovalRuleForSummary built = builder.build();

        assertThat(built.requiredApprovals()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupInheritanceTypeIsNullable() {
        final GitLabProtectedEnvironmentsApprovalRuleForSummaryBuilder builder =
                GitLabProtectedEnvironmentsApprovalRuleForSummaryBuilder.builder(
                                DeploymentsCatalogFixtures.protectedEnvironmentsApprovalRuleForSummary())
                        .groupInheritanceType(null);

        final GitLabProtectedEnvironmentsApprovalRuleForSummary built = builder.build();

        assertThat(built.groupInheritanceType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentApprovalsIsNullable() {
        final GitLabProtectedEnvironmentsApprovalRuleForSummaryBuilder builder =
                GitLabProtectedEnvironmentsApprovalRuleForSummaryBuilder.builder(
                                DeploymentsCatalogFixtures.protectedEnvironmentsApprovalRuleForSummary())
                        .deploymentApprovals(null);

        final GitLabProtectedEnvironmentsApprovalRuleForSummary built = builder.build();

        assertThat(built.deploymentApprovals()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProtectedEnvironmentsApprovalRuleForSummary value =
                DeploymentsCatalogFixtures.protectedEnvironmentsApprovalRuleForSummary();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.userId()).isEqualTo(1L);
            softly.assertThat(value.groupId()).isEqualTo(1L);
            softly.assertThat(value.accessLevel()).isEqualTo(1);
            softly.assertThat(value.accessLevelDescription()).isEqualTo("access_level_description");
            softly.assertThat(value.requiredApprovals()).isEqualTo(1);
            softly.assertThat(value.groupInheritanceType()).isEqualTo(1);
            softly.assertThat(value.deploymentApprovals()).isEqualTo(DeploymentsCatalogFixtures.deploymentApproval());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProtectedEnvironmentsApprovalRuleForSummary original =
                DeploymentsCatalogFixtures.protectedEnvironmentsApprovalRuleForSummary();

        final GitLabProtectedEnvironmentsApprovalRuleForSummary rebuilt =
                GitLabProtectedEnvironmentsApprovalRuleForSummaryBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProtectedEnvironmentsApprovalRuleForSummary.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "userId",
                        "groupId",
                        "accessLevel",
                        "accessLevelDescription",
                        "requiredApprovals",
                        "groupInheritanceType",
                        "deploymentApprovals");
    }
}

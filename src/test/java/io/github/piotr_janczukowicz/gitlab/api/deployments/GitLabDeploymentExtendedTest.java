package io.github.piotr_janczukowicz.gitlab.api.deployments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDeploymentExtendedTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabDeploymentExtendedBuilder builder = GitLabDeploymentExtendedBuilder.builder(
                        DeploymentsCatalogFixtures.deploymentExtended())
                .id(null);

        final GitLabDeploymentExtended built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabDeploymentExtendedBuilder builder = GitLabDeploymentExtendedBuilder.builder(
                        DeploymentsCatalogFixtures.deploymentExtended())
                .iid(null);

        final GitLabDeploymentExtended built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabDeploymentExtendedBuilder builder = GitLabDeploymentExtendedBuilder.builder(
                        DeploymentsCatalogFixtures.deploymentExtended())
                .ref(null);

        final GitLabDeploymentExtended built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShaIsNullable() {
        final GitLabDeploymentExtendedBuilder builder = GitLabDeploymentExtendedBuilder.builder(
                        DeploymentsCatalogFixtures.deploymentExtended())
                .sha(null);

        final GitLabDeploymentExtended built = builder.build();

        assertThat(built.sha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabDeploymentExtendedBuilder builder = GitLabDeploymentExtendedBuilder.builder(
                        DeploymentsCatalogFixtures.deploymentExtended())
                .createdAt(null);

        final GitLabDeploymentExtended built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabDeploymentExtendedBuilder builder = GitLabDeploymentExtendedBuilder.builder(
                        DeploymentsCatalogFixtures.deploymentExtended())
                .updatedAt(null);

        final GitLabDeploymentExtended built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabDeploymentExtendedBuilder builder = GitLabDeploymentExtendedBuilder.builder(
                        DeploymentsCatalogFixtures.deploymentExtended())
                .user(null);

        final GitLabDeploymentExtended built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentIsNullable() {
        final GitLabDeploymentExtendedBuilder builder = GitLabDeploymentExtendedBuilder.builder(
                        DeploymentsCatalogFixtures.deploymentExtended())
                .environment(null);

        final GitLabDeploymentExtended built = builder.build();

        assertThat(built.environment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeployableIsNullable() {
        final GitLabDeploymentExtendedBuilder builder = GitLabDeploymentExtendedBuilder.builder(
                        DeploymentsCatalogFixtures.deploymentExtended())
                .deployable(null);

        final GitLabDeploymentExtended built = builder.build();

        assertThat(built.deployable()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabDeploymentExtendedBuilder builder = GitLabDeploymentExtendedBuilder.builder(
                        DeploymentsCatalogFixtures.deploymentExtended())
                .status(null);

        final GitLabDeploymentExtended built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPendingApprovalCountIsNullable() {
        final GitLabDeploymentExtendedBuilder builder = GitLabDeploymentExtendedBuilder.builder(
                        DeploymentsCatalogFixtures.deploymentExtended())
                .pendingApprovalCount(null);

        final GitLabDeploymentExtended built = builder.build();

        assertThat(built.pendingApprovalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsIsNullable() {
        final GitLabDeploymentExtendedBuilder builder = GitLabDeploymentExtendedBuilder.builder(
                        DeploymentsCatalogFixtures.deploymentExtended())
                .approvals(null);

        final GitLabDeploymentExtended built = builder.build();

        assertThat(built.approvals()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalSummaryIsNullable() {
        final GitLabDeploymentExtendedBuilder builder = GitLabDeploymentExtendedBuilder.builder(
                        DeploymentsCatalogFixtures.deploymentExtended())
                .approvalSummary(null);

        final GitLabDeploymentExtended built = builder.build();

        assertThat(built.approvalSummary()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDeploymentExtended value = DeploymentsCatalogFixtures.deploymentExtended();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.iid()).isEqualTo(1L);
            softly.assertThat(value.ref()).isEqualTo("main");
            softly.assertThat(value.sha()).isEqualTo("99d03678b90d914dbb1b109132516d71a4a03ea8");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.user()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.environment()).isEqualTo(CommonCatalogFixtures.environmentBasic());
            softly.assertThat(value.deployable()).isEqualTo(CommonCatalogFixtures.ciJob());
            softly.assertThat(value.status()).isEqualTo("created");
            softly.assertThat(value.pendingApprovalCount()).isEqualTo(1);
            softly.assertThat(value.approvals()).isEqualTo(List.of(DeploymentsCatalogFixtures.deploymentApproval()));
            softly.assertThat(value.approvalSummary())
                    .isEqualTo(DeploymentsCatalogFixtures.deploymentApprovalSummary());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDeploymentExtended original = DeploymentsCatalogFixtures.deploymentExtended();

        final GitLabDeploymentExtended rebuilt =
                GitLabDeploymentExtendedBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDeploymentExtended.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "iid",
                        "ref",
                        "sha",
                        "createdAt",
                        "updatedAt",
                        "user",
                        "environment",
                        "deployable",
                        "status",
                        "pendingApprovalCount",
                        "approvals",
                        "approvalSummary");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.deployments;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDeploymentApprovalSummaryTest {

    @Test
    void constructor_shouldAcceptNull_whenRulesIsNullable() {
        final GitLabDeploymentApprovalSummaryBuilder builder = GitLabDeploymentApprovalSummaryBuilder.builder(
                        DeploymentsCatalogFixtures.deploymentApprovalSummary())
                .rules(null);

        final GitLabDeploymentApprovalSummary built = builder.build();

        assertThat(built.rules()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDeploymentApprovalSummary value = DeploymentsCatalogFixtures.deploymentApprovalSummary();

        assertThat(value.rules())
                .isEqualTo(List.of(DeploymentsCatalogFixtures.protectedEnvironmentsApprovalRuleForSummary()));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDeploymentApprovalSummary original = DeploymentsCatalogFixtures.deploymentApprovalSummary();

        final GitLabDeploymentApprovalSummary rebuilt =
                GitLabDeploymentApprovalSummaryBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDeploymentApprovalSummary.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("rules");
    }
}

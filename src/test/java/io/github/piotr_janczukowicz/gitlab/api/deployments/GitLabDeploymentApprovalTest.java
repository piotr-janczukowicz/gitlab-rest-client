package io.github.piotr_janczukowicz.gitlab.api.deployments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDeploymentApprovalTest {

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabDeploymentApprovalBuilder builder = GitLabDeploymentApprovalBuilder.builder(
                        DeploymentsCatalogFixtures.deploymentApproval())
                .user(null);

        final GitLabDeploymentApproval built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabDeploymentApprovalBuilder builder = GitLabDeploymentApprovalBuilder.builder(
                        DeploymentsCatalogFixtures.deploymentApproval())
                .status(null);

        final GitLabDeploymentApproval built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabDeploymentApprovalBuilder builder = GitLabDeploymentApprovalBuilder.builder(
                        DeploymentsCatalogFixtures.deploymentApproval())
                .createdAt(null);

        final GitLabDeploymentApproval built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommentIsNullable() {
        final GitLabDeploymentApprovalBuilder builder = GitLabDeploymentApprovalBuilder.builder(
                        DeploymentsCatalogFixtures.deploymentApproval())
                .comment(null);

        final GitLabDeploymentApproval built = builder.build();

        assertThat(built.comment()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDeploymentApproval value = DeploymentsCatalogFixtures.deploymentApproval();

        assertSoftly(softly -> {
            softly.assertThat(value.user()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.status()).isEqualTo("approved");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.comment()).isEqualTo("LGTM");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDeploymentApproval original = DeploymentsCatalogFixtures.deploymentApproval();

        final GitLabDeploymentApproval rebuilt =
                GitLabDeploymentApprovalBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDeploymentApproval.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("user", "status", "createdAt", "comment");
    }
}

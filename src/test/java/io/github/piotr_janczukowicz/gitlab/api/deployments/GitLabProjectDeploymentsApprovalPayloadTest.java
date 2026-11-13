package io.github.piotr_janczukowicz.gitlab.api.deployments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDeploymentsApprovalPayloadTest {

    @Test
    void constructor_shouldRefuseNull_whenStatusIsNull() {
        final GitLabProjectDeploymentsApprovalPayloadBuilder builder =
                GitLabProjectDeploymentsApprovalPayloadBuilder.builder(
                                DeploymentsCatalogFixtures.projectDeploymentsApprovalPayload())
                        .status(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("status");
    }

    @Test
    void constructor_shouldAcceptNull_whenCommentIsNullable() {
        final GitLabProjectDeploymentsApprovalPayloadBuilder builder =
                GitLabProjectDeploymentsApprovalPayloadBuilder.builder(
                                DeploymentsCatalogFixtures.projectDeploymentsApprovalPayload())
                        .comment(null);

        final GitLabProjectDeploymentsApprovalPayload built = builder.build();

        assertThat(built.comment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepresentedAsIsNullable() {
        final GitLabProjectDeploymentsApprovalPayloadBuilder builder =
                GitLabProjectDeploymentsApprovalPayloadBuilder.builder(
                                DeploymentsCatalogFixtures.projectDeploymentsApprovalPayload())
                        .representedAs(null);

        final GitLabProjectDeploymentsApprovalPayload built = builder.build();

        assertThat(built.representedAs()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDeploymentsApprovalPayload value =
                DeploymentsCatalogFixtures.projectDeploymentsApprovalPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.status()).isEqualTo(GitLabProjectDeploymentsApprovalStatus.APPROVED);
            softly.assertThat(value.comment()).isEqualTo("comment");
            softly.assertThat(value.representedAs()).isEqualTo("represented_as");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDeploymentsApprovalPayload original =
                DeploymentsCatalogFixtures.projectDeploymentsApprovalPayload();

        final GitLabProjectDeploymentsApprovalPayload rebuilt =
                GitLabProjectDeploymentsApprovalPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectDeploymentsApprovalPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("status", "comment", "representedAs");
    }
}

package io.github.piotr_janczukowicz.gitlab.api.deployments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDeploymentsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentIsNullable() {
        final GitLabProjectDeploymentsCreatePayloadBuilder builder =
                GitLabProjectDeploymentsCreatePayloadBuilder.builder(
                                DeploymentsCatalogFixtures.projectDeploymentsCreatePayload())
                        .environment(null);

        final GitLabProjectDeploymentsCreatePayload built = builder.build();

        assertThat(built.environment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShaIsNullable() {
        final GitLabProjectDeploymentsCreatePayloadBuilder builder =
                GitLabProjectDeploymentsCreatePayloadBuilder.builder(
                                DeploymentsCatalogFixtures.projectDeploymentsCreatePayload())
                        .sha(null);

        final GitLabProjectDeploymentsCreatePayload built = builder.build();

        assertThat(built.sha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabProjectDeploymentsCreatePayloadBuilder builder =
                GitLabProjectDeploymentsCreatePayloadBuilder.builder(
                                DeploymentsCatalogFixtures.projectDeploymentsCreatePayload())
                        .ref(null);

        final GitLabProjectDeploymentsCreatePayload built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagIsNullable() {
        final GitLabProjectDeploymentsCreatePayloadBuilder builder =
                GitLabProjectDeploymentsCreatePayloadBuilder.builder(
                                DeploymentsCatalogFixtures.projectDeploymentsCreatePayload())
                        .tag(null);

        final GitLabProjectDeploymentsCreatePayload built = builder.build();

        assertThat(built.tag()).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenStatusIsNull() {
        final GitLabProjectDeploymentsCreatePayloadBuilder builder =
                GitLabProjectDeploymentsCreatePayloadBuilder.builder(
                                DeploymentsCatalogFixtures.projectDeploymentsCreatePayload())
                        .status(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("status");
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDeploymentsCreatePayload value =
                DeploymentsCatalogFixtures.projectDeploymentsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.environment()).isEqualTo("environment");
            softly.assertThat(value.sha()).isEqualTo("sha");
            softly.assertThat(value.ref()).isEqualTo("ref");
            softly.assertThat(value.tag()).isEqualTo(true);
            softly.assertThat(value.status()).isEqualTo(GitLabProjectDeploymentsCreateStatus.RUNNING);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDeploymentsCreatePayload original =
                DeploymentsCatalogFixtures.projectDeploymentsCreatePayload();

        final GitLabProjectDeploymentsCreatePayload rebuilt =
                GitLabProjectDeploymentsCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectDeploymentsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("environment", "sha", "ref", "tag", "status");
    }
}

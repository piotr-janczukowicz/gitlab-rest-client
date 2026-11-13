package io.github.piotr_janczukowicz.gitlab.api.deployments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDeploymentsUpdatePayloadTest {

    @Test
    void constructor_shouldRefuseNull_whenStatusIsNull() {
        final GitLabProjectDeploymentsUpdatePayloadBuilder builder =
                GitLabProjectDeploymentsUpdatePayloadBuilder.builder(
                                DeploymentsCatalogFixtures.projectDeploymentsUpdatePayload())
                        .status(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("status");
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDeploymentsUpdatePayload value =
                DeploymentsCatalogFixtures.projectDeploymentsUpdatePayload();

        assertThat(value.status()).isEqualTo(GitLabProjectDeploymentsUpdateStatus.RUNNING);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDeploymentsUpdatePayload original =
                DeploymentsCatalogFixtures.projectDeploymentsUpdatePayload();

        final GitLabProjectDeploymentsUpdatePayload rebuilt =
                GitLabProjectDeploymentsUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectDeploymentsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("status");
    }
}

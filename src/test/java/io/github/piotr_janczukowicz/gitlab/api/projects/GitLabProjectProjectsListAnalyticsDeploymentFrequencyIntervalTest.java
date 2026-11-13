package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectProjectsListAnalyticsDeploymentFrequencyIntervalTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectProjectsListAnalyticsDeploymentFrequencyInterval.values())
                .map(GitLabProjectProjectsListAnalyticsDeploymentFrequencyInterval::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("all", "monthly", "daily");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectProjectsListAnalyticsDeploymentFrequencyInterval.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectProjectsListAnalyticsDeploymentFrequencyInterval constant) {
        final GitLabProjectProjectsListAnalyticsDeploymentFrequencyInterval decoded =
                GitLabProjectProjectsListAnalyticsDeploymentFrequencyInterval.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectProjectsListAnalyticsDeploymentFrequencyInterval.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(
                () -> GitLabProjectProjectsListAnalyticsDeploymentFrequencyInterval.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}

package io.github.piotr_janczukowicz.gitlab.api.devopsresearchandassessmentdorametrics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallMetricTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallMetric.values())
                .map(GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallMetric::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "deployment_frequency",
                        "lead_time_for_changes",
                        "time_to_restore_service",
                        "change_failure_rate");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallMetric.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallMetric constant) {
        final GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallMetric decoded =
                GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallMetric.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallMetric.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(
                () -> GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallMetric.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}

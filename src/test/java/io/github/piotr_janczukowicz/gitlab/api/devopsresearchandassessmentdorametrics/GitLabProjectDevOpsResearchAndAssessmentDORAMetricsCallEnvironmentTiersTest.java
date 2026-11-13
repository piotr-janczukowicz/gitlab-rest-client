package io.github.piotr_janczukowicz.gitlab.api.devopsresearchandassessmentdorametrics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiersTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(
                        GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers.values())
                .map(GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("production", "staging", "testing", "development", "other");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers constant) {
        final GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers decoded =
                GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(
                () -> GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() ->
                GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}

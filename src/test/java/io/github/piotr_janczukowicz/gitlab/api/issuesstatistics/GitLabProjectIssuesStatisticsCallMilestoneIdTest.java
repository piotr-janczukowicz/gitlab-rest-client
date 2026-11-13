package io.github.piotr_janczukowicz.gitlab.api.issuesstatistics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectIssuesStatisticsCallMilestoneIdTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectIssuesStatisticsCallMilestoneId.values())
                .map(GitLabProjectIssuesStatisticsCallMilestoneId::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("Any", "None", "Upcoming", "Started");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectIssuesStatisticsCallMilestoneId.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectIssuesStatisticsCallMilestoneId constant) {
        final GitLabProjectIssuesStatisticsCallMilestoneId decoded =
                GitLabProjectIssuesStatisticsCallMilestoneId.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectIssuesStatisticsCallMilestoneId.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectIssuesStatisticsCallMilestoneId.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}

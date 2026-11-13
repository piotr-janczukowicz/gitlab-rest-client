package io.github.piotr_janczukowicz.gitlab.api.issuesstatistics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupIssuesStatisticsCallNotMilestoneIdTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabGroupIssuesStatisticsCallNotMilestoneId.values())
                .map(GitLabGroupIssuesStatisticsCallNotMilestoneId::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("Any", "None", "Upcoming", "Started");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupIssuesStatisticsCallNotMilestoneId.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabGroupIssuesStatisticsCallNotMilestoneId constant) {
        final GitLabGroupIssuesStatisticsCallNotMilestoneId decoded =
                GitLabGroupIssuesStatisticsCallNotMilestoneId.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupIssuesStatisticsCallNotMilestoneId.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabGroupIssuesStatisticsCallNotMilestoneId.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}

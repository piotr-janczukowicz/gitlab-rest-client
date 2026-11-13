package io.github.piotr_janczukowicz.gitlab.api.runners;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabCiRunnerDetailsJobExecutionStatusTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabCiRunnerDetailsJobExecutionStatus.values())
                .filter(constant -> constant != GitLabCiRunnerDetailsJobExecutionStatus.UNRECOGNIZED)
                .map(GitLabCiRunnerDetailsJobExecutionStatus::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("active", "idle");
    }

    @ParameterizedTest
    @EnumSource(
            value = GitLabCiRunnerDetailsJobExecutionStatus.class,
            mode = EnumSource.Mode.EXCLUDE,
            names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabCiRunnerDetailsJobExecutionStatus constant) {
        final GitLabCiRunnerDetailsJobExecutionStatus decoded =
                GitLabCiRunnerDetailsJobExecutionStatus.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabCiRunnerDetailsJobExecutionStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabCiRunnerDetailsJobExecutionStatus decoded =
                GitLabCiRunnerDetailsJobExecutionStatus.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabCiRunnerDetailsJobExecutionStatus.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabCiRunnerDetailsJobExecutionStatus.values())
                .filter(constant ->
                        constant.wireValue().equals(GitLabCiRunnerDetailsJobExecutionStatus.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}

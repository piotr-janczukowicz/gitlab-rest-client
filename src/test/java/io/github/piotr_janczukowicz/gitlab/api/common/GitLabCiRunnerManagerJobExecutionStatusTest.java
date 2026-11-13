package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabCiRunnerManagerJobExecutionStatusTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabCiRunnerManagerJobExecutionStatus.values())
                .filter(constant -> constant != GitLabCiRunnerManagerJobExecutionStatus.UNRECOGNIZED)
                .map(GitLabCiRunnerManagerJobExecutionStatus::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("active", "idle");
    }

    @ParameterizedTest
    @EnumSource(
            value = GitLabCiRunnerManagerJobExecutionStatus.class,
            mode = EnumSource.Mode.EXCLUDE,
            names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabCiRunnerManagerJobExecutionStatus constant) {
        final GitLabCiRunnerManagerJobExecutionStatus decoded =
                GitLabCiRunnerManagerJobExecutionStatus.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabCiRunnerManagerJobExecutionStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabCiRunnerManagerJobExecutionStatus decoded =
                GitLabCiRunnerManagerJobExecutionStatus.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabCiRunnerManagerJobExecutionStatus.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabCiRunnerManagerJobExecutionStatus.values())
                .filter(constant ->
                        constant.wireValue().equals(GitLabCiRunnerManagerJobExecutionStatus.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}

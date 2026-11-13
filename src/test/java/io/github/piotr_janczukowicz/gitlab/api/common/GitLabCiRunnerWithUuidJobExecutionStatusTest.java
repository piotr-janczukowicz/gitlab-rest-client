package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabCiRunnerWithUuidJobExecutionStatusTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabCiRunnerWithUuidJobExecutionStatus.values())
                .filter(constant -> constant != GitLabCiRunnerWithUuidJobExecutionStatus.UNRECOGNIZED)
                .map(GitLabCiRunnerWithUuidJobExecutionStatus::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("active", "idle");
    }

    @ParameterizedTest
    @EnumSource(
            value = GitLabCiRunnerWithUuidJobExecutionStatus.class,
            mode = EnumSource.Mode.EXCLUDE,
            names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabCiRunnerWithUuidJobExecutionStatus constant) {
        final GitLabCiRunnerWithUuidJobExecutionStatus decoded =
                GitLabCiRunnerWithUuidJobExecutionStatus.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabCiRunnerWithUuidJobExecutionStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabCiRunnerWithUuidJobExecutionStatus decoded =
                GitLabCiRunnerWithUuidJobExecutionStatus.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabCiRunnerWithUuidJobExecutionStatus.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabCiRunnerWithUuidJobExecutionStatus.values())
                .filter(constant ->
                        constant.wireValue().equals(GitLabCiRunnerWithUuidJobExecutionStatus.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}

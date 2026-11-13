package io.github.piotr_janczukowicz.gitlab.api.runnercontrollers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabRunnerControllersCreateStateTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabRunnerControllersCreateState.values())
                .map(GitLabRunnerControllersCreateState::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("disabled", "enabled", "dry_run");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabRunnerControllersCreateState.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabRunnerControllersCreateState constant) {
        final GitLabRunnerControllersCreateState decoded =
                GitLabRunnerControllersCreateState.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabRunnerControllersCreateState.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabRunnerControllersCreateState.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}

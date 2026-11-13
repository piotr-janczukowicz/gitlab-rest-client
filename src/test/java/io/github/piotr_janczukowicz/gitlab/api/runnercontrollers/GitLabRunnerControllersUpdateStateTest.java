package io.github.piotr_janczukowicz.gitlab.api.runnercontrollers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabRunnerControllersUpdateStateTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabRunnerControllersUpdateState.values())
                .map(GitLabRunnerControllersUpdateState::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("disabled", "enabled", "dry_run");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabRunnerControllersUpdateState.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabRunnerControllersUpdateState constant) {
        final GitLabRunnerControllersUpdateState decoded =
                GitLabRunnerControllersUpdateState.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabRunnerControllersUpdateState.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabRunnerControllersUpdateState.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}

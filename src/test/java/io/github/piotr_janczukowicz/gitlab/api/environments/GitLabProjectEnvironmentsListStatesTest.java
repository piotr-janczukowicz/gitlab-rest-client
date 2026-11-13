package io.github.piotr_janczukowicz.gitlab.api.environments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectEnvironmentsListStatesTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectEnvironmentsListStates.values())
                .map(GitLabProjectEnvironmentsListStates::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("stopped", "stopping", "available");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectEnvironmentsListStates.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabProjectEnvironmentsListStates constant) {
        final GitLabProjectEnvironmentsListStates decoded =
                GitLabProjectEnvironmentsListStates.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectEnvironmentsListStates.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectEnvironmentsListStates.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}

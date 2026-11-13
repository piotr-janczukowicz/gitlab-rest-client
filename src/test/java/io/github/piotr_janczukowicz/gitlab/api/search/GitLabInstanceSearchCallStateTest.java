package io.github.piotr_janczukowicz.gitlab.api.search;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabInstanceSearchCallStateTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabInstanceSearchCallState.values())
                .map(GitLabInstanceSearchCallState::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("all", "opened", "closed", "merged");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabInstanceSearchCallState.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabInstanceSearchCallState constant) {
        final GitLabInstanceSearchCallState decoded = GitLabInstanceSearchCallState.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabInstanceSearchCallState.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabInstanceSearchCallState.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}

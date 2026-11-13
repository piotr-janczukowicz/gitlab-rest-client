package io.github.piotr_janczukowicz.gitlab.api.activecontext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabActiveContextUpdateCodeEnabledNamespaceStateTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabActiveContextUpdateCodeEnabledNamespaceState.values())
                .map(GitLabActiveContextUpdateCodeEnabledNamespaceState::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("pending", "ready");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabActiveContextUpdateCodeEnabledNamespaceState.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabActiveContextUpdateCodeEnabledNamespaceState constant) {
        final GitLabActiveContextUpdateCodeEnabledNamespaceState decoded =
                GitLabActiveContextUpdateCodeEnabledNamespaceState.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabActiveContextUpdateCodeEnabledNamespaceState.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabActiveContextUpdateCodeEnabledNamespaceState.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}

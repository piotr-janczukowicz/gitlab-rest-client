package io.github.piotr_janczukowicz.gitlab.api.vscode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabVSCodeListV1ResourceNameTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabVSCodeListV1ResourceName.values())
                .map(GitLabVSCodeListV1ResourceName::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "settings",
                        "extensions",
                        "globalState",
                        "machines",
                        "keybindings",
                        "snippets",
                        "tasks",
                        "profiles");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabVSCodeListV1ResourceName.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabVSCodeListV1ResourceName constant) {
        final GitLabVSCodeListV1ResourceName decoded = GitLabVSCodeListV1ResourceName.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabVSCodeListV1ResourceName.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabVSCodeListV1ResourceName.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}

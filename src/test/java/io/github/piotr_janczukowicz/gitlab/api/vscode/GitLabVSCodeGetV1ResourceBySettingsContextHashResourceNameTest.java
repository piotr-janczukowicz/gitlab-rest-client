package io.github.piotr_janczukowicz.gitlab.api.vscode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabVSCodeGetV1ResourceBySettingsContextHashResourceNameTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabVSCodeGetV1ResourceBySettingsContextHashResourceName.values())
                .map(GitLabVSCodeGetV1ResourceBySettingsContextHashResourceName::wireValue)
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
    @EnumSource(value = GitLabVSCodeGetV1ResourceBySettingsContextHashResourceName.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabVSCodeGetV1ResourceBySettingsContextHashResourceName constant) {
        final GitLabVSCodeGetV1ResourceBySettingsContextHashResourceName decoded =
                GitLabVSCodeGetV1ResourceBySettingsContextHashResourceName.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabVSCodeGetV1ResourceBySettingsContextHashResourceName.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(
                () -> GitLabVSCodeGetV1ResourceBySettingsContextHashResourceName.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}

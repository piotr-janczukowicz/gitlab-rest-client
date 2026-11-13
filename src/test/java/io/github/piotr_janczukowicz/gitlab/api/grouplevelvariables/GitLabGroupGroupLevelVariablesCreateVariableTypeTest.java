package io.github.piotr_janczukowicz.gitlab.api.grouplevelvariables;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupGroupLevelVariablesCreateVariableTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabGroupGroupLevelVariablesCreateVariableType.values())
                .map(GitLabGroupGroupLevelVariablesCreateVariableType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("env_var", "file");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupGroupLevelVariablesCreateVariableType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabGroupGroupLevelVariablesCreateVariableType constant) {
        final GitLabGroupGroupLevelVariablesCreateVariableType decoded =
                GitLabGroupGroupLevelVariablesCreateVariableType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupGroupLevelVariablesCreateVariableType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabGroupGroupLevelVariablesCreateVariableType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}

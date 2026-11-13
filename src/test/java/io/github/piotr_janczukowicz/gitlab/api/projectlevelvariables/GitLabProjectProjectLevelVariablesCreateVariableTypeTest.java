package io.github.piotr_janczukowicz.gitlab.api.projectlevelvariables;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectProjectLevelVariablesCreateVariableTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectProjectLevelVariablesCreateVariableType.values())
                .map(GitLabProjectProjectLevelVariablesCreateVariableType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("env_var", "file");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectProjectLevelVariablesCreateVariableType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectProjectLevelVariablesCreateVariableType constant) {
        final GitLabProjectProjectLevelVariablesCreateVariableType decoded =
                GitLabProjectProjectLevelVariablesCreateVariableType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectProjectLevelVariablesCreateVariableType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectProjectLevelVariablesCreateVariableType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}

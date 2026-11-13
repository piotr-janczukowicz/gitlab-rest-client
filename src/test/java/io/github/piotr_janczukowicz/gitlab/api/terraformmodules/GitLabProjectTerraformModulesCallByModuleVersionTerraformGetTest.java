package io.github.piotr_janczukowicz.gitlab.api.terraformmodules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectTerraformModulesCallByModuleVersionTerraformGetTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectTerraformModulesCallByModuleVersionTerraformGet.values())
                .map(GitLabProjectTerraformModulesCallByModuleVersionTerraformGet::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("1");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectTerraformModulesCallByModuleVersionTerraformGet.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectTerraformModulesCallByModuleVersionTerraformGet constant) {
        final GitLabProjectTerraformModulesCallByModuleVersionTerraformGet decoded =
                GitLabProjectTerraformModulesCallByModuleVersionTerraformGet.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectTerraformModulesCallByModuleVersionTerraformGet.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(
                () -> GitLabProjectTerraformModulesCallByModuleVersionTerraformGet.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}

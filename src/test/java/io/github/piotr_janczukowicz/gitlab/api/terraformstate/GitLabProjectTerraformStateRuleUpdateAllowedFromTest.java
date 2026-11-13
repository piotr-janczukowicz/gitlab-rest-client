package io.github.piotr_janczukowicz.gitlab.api.terraformstate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectTerraformStateRuleUpdateAllowedFromTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectTerraformStateRuleUpdateAllowedFrom.values())
                .map(GitLabProjectTerraformStateRuleUpdateAllowedFrom::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("anywhere", "ci_only", "ci_on_protected_branch_only");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectTerraformStateRuleUpdateAllowedFrom.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectTerraformStateRuleUpdateAllowedFrom constant) {
        final GitLabProjectTerraformStateRuleUpdateAllowedFrom decoded =
                GitLabProjectTerraformStateRuleUpdateAllowedFrom.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectTerraformStateRuleUpdateAllowedFrom.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectTerraformStateRuleUpdateAllowedFrom.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}

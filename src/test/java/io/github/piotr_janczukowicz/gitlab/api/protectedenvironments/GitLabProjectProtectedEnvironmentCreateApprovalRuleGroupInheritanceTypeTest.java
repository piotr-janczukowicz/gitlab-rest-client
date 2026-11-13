package io.github.piotr_janczukowicz.gitlab.api.protectedenvironments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectProtectedEnvironmentCreateApprovalRuleGroupInheritanceTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final int[] wires = Arrays.stream(
                        GitLabProjectProtectedEnvironmentCreateApprovalRuleGroupInheritanceType.values())
                .mapToInt(GitLabProjectProtectedEnvironmentCreateApprovalRuleGroupInheritanceType::wireValue)
                .toArray();

        assertThat(wires).containsExactly(0, 1);
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectProtectedEnvironmentCreateApprovalRuleGroupInheritanceType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectProtectedEnvironmentCreateApprovalRuleGroupInheritanceType constant) {
        final GitLabProjectProtectedEnvironmentCreateApprovalRuleGroupInheritanceType decoded =
                GitLabProjectProtectedEnvironmentCreateApprovalRuleGroupInheritanceType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(
                () -> GitLabProjectProtectedEnvironmentCreateApprovalRuleGroupInheritanceType.fromWire(-12345));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}

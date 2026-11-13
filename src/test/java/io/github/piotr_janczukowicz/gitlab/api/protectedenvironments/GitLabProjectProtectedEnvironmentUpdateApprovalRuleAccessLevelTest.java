package io.github.piotr_janczukowicz.gitlab.api.protectedenvironments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectProtectedEnvironmentUpdateApprovalRuleAccessLevelTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final int[] wires = Arrays.stream(GitLabProjectProtectedEnvironmentUpdateApprovalRuleAccessLevel.values())
                .mapToInt(GitLabProjectProtectedEnvironmentUpdateApprovalRuleAccessLevel::wireValue)
                .toArray();

        assertThat(wires).containsExactly(40, 30, 20, 60);
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectProtectedEnvironmentUpdateApprovalRuleAccessLevel.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectProtectedEnvironmentUpdateApprovalRuleAccessLevel constant) {
        final GitLabProjectProtectedEnvironmentUpdateApprovalRuleAccessLevel decoded =
                GitLabProjectProtectedEnvironmentUpdateApprovalRuleAccessLevel.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectProtectedEnvironmentUpdateApprovalRuleAccessLevel.fromWire(-12345));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}

package io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedenvironments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupProtectedEnvironmentCreateDeployAccessLevelGroupInheritanceTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final int[] wires = Arrays.stream(
                        GitLabGroupProtectedEnvironmentCreateDeployAccessLevelGroupInheritanceType.values())
                .mapToInt(GitLabGroupProtectedEnvironmentCreateDeployAccessLevelGroupInheritanceType::wireValue)
                .toArray();

        assertThat(wires).containsExactly(0, 1);
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupProtectedEnvironmentCreateDeployAccessLevelGroupInheritanceType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabGroupProtectedEnvironmentCreateDeployAccessLevelGroupInheritanceType constant) {
        final GitLabGroupProtectedEnvironmentCreateDeployAccessLevelGroupInheritanceType decoded =
                GitLabGroupProtectedEnvironmentCreateDeployAccessLevelGroupInheritanceType.fromWire(
                        constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(
                () -> GitLabGroupProtectedEnvironmentCreateDeployAccessLevelGroupInheritanceType.fromWire(-12345));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}

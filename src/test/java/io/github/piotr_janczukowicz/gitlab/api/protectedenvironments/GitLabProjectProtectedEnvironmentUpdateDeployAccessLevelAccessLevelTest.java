package io.github.piotr_janczukowicz.gitlab.api.protectedenvironments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelAccessLevelTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final int[] wires = Arrays.stream(GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelAccessLevel.values())
                .mapToInt(GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelAccessLevel::wireValue)
                .toArray();

        assertThat(wires).containsExactly(40, 30, 20, 60);
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelAccessLevel.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelAccessLevel constant) {
        final GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelAccessLevel decoded =
                GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelAccessLevel.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(
                () -> GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelAccessLevel.fromWire(-12345));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}

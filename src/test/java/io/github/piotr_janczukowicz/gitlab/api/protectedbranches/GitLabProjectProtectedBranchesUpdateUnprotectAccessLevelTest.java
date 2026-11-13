package io.github.piotr_janczukowicz.gitlab.api.protectedbranches;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectProtectedBranchesUpdateUnprotectAccessLevelTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final int[] wires = Arrays.stream(GitLabProjectProtectedBranchesUpdateUnprotectAccessLevel.values())
                .mapToInt(GitLabProjectProtectedBranchesUpdateUnprotectAccessLevel::wireValue)
                .toArray();

        assertThat(wires).containsExactly(30, 40, 60);
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectProtectedBranchesUpdateUnprotectAccessLevel.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectProtectedBranchesUpdateUnprotectAccessLevel constant) {
        final GitLabProjectProtectedBranchesUpdateUnprotectAccessLevel decoded =
                GitLabProjectProtectedBranchesUpdateUnprotectAccessLevel.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectProtectedBranchesUpdateUnprotectAccessLevel.fromWire(-12345));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}

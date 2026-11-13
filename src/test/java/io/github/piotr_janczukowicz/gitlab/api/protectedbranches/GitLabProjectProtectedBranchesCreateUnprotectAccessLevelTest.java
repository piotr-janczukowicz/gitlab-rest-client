package io.github.piotr_janczukowicz.gitlab.api.protectedbranches;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectProtectedBranchesCreateUnprotectAccessLevelTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final int[] wires = Arrays.stream(GitLabProjectProtectedBranchesCreateUnprotectAccessLevel.values())
                .mapToInt(GitLabProjectProtectedBranchesCreateUnprotectAccessLevel::wireValue)
                .toArray();

        assertThat(wires).containsExactly(30, 40, 60);
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectProtectedBranchesCreateUnprotectAccessLevel.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectProtectedBranchesCreateUnprotectAccessLevel constant) {
        final GitLabProjectProtectedBranchesCreateUnprotectAccessLevel decoded =
                GitLabProjectProtectedBranchesCreateUnprotectAccessLevel.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectProtectedBranchesCreateUnprotectAccessLevel.fromWire(-12345));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}

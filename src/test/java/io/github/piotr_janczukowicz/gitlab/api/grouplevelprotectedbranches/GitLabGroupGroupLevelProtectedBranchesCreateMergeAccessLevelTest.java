package io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedbranches;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupGroupLevelProtectedBranchesCreateMergeAccessLevelTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final int[] wires = Arrays.stream(GitLabGroupGroupLevelProtectedBranchesCreateMergeAccessLevel.values())
                .mapToInt(GitLabGroupGroupLevelProtectedBranchesCreateMergeAccessLevel::wireValue)
                .toArray();

        assertThat(wires).containsExactly(30, 40, 60, 0);
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupGroupLevelProtectedBranchesCreateMergeAccessLevel.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabGroupGroupLevelProtectedBranchesCreateMergeAccessLevel constant) {
        final GitLabGroupGroupLevelProtectedBranchesCreateMergeAccessLevel decoded =
                GitLabGroupGroupLevelProtectedBranchesCreateMergeAccessLevel.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabGroupGroupLevelProtectedBranchesCreateMergeAccessLevel.fromWire(-12345));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}

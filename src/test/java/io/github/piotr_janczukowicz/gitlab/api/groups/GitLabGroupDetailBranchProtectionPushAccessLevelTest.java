package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupDetailBranchProtectionPushAccessLevelTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final int[] wires = Arrays.stream(GitLabGroupDetailBranchProtectionPushAccessLevel.values())
                .mapToInt(GitLabGroupDetailBranchProtectionPushAccessLevel::wireValue)
                .toArray();

        assertThat(wires).containsExactly(30, 40, 60, 0);
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupDetailBranchProtectionPushAccessLevel.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabGroupDetailBranchProtectionPushAccessLevel constant) {
        final GitLabGroupDetailBranchProtectionPushAccessLevel decoded =
                GitLabGroupDetailBranchProtectionPushAccessLevel.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabGroupDetailBranchProtectionPushAccessLevel.fromWire(-12345));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}

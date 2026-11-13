package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabMemberRoleBaseAccessLevelTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final int[] wires = Arrays.stream(GitLabMemberRoleBaseAccessLevel.values())
                .mapToInt(GitLabMemberRoleBaseAccessLevel::wireValue)
                .toArray();

        assertThat(wires).containsExactly(5, 10, 15, 20, 25, 30, 40);
    }

    @ParameterizedTest
    @EnumSource(value = GitLabMemberRoleBaseAccessLevel.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabMemberRoleBaseAccessLevel constant) {
        final GitLabMemberRoleBaseAccessLevel decoded = GitLabMemberRoleBaseAccessLevel.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabMemberRoleBaseAccessLevel.fromWire(-12345));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}

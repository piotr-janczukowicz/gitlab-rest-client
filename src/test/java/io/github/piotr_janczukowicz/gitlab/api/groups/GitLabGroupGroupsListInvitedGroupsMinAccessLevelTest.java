package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupGroupsListInvitedGroupsMinAccessLevelTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final int[] wires = Arrays.stream(GitLabGroupGroupsListInvitedGroupsMinAccessLevel.values())
                .mapToInt(GitLabGroupGroupsListInvitedGroupsMinAccessLevel::wireValue)
                .toArray();

        assertThat(wires).containsExactly(10, 15, 20, 25, 30, 40, 50);
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupGroupsListInvitedGroupsMinAccessLevel.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabGroupGroupsListInvitedGroupsMinAccessLevel constant) {
        final GitLabGroupGroupsListInvitedGroupsMinAccessLevel decoded =
                GitLabGroupGroupsListInvitedGroupsMinAccessLevel.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabGroupGroupsListInvitedGroupsMinAccessLevel.fromWire(-12345));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
